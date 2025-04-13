package com.major.payment_service.service;


import com.major.payment_service.dto.ProductCheckout;
import com.major.payment_service.dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.secretKey}")
    private String secretKey;


    public StripeResponse checkoutProducts(ProductCheckout productRequest) {
        // Set your secret key. Remember to switch to your live secret key in production!
            Stripe.apiKey = secretKey;

            // Create a PaymentIntent with the order amount and currency
            SessionCreateParams.LineItem.PriceData.ProductData productData =
                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                            .setName(productRequest.getName())
                            .build();
            
            System.out.println("1 secret key --------------> " + secretKey);

           // Convert Double amount to long in cents (e.g., $10.50 => 1050 cents)
            long amountInCents = Math.round(productRequest.getAmount() * 100);

            SessionCreateParams.LineItem.PriceData priceData =
                    SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency(productRequest.getCurrency() != null ? productRequest.getCurrency() : "USD")
                            .setUnitAmount(amountInCents)
                            .setProductData(productData)
                            .build();
            
            System.out.println("2 secret key --------------> " + secretKey);

            // Create new line item with the above price data
            SessionCreateParams.LineItem lineItem =
                    SessionCreateParams
                            .LineItem.builder()
                            .setQuantity(productRequest.getQuantity())
                            .setPriceData(priceData)
                            .build();

            // Create new session with the line items
            SessionCreateParams params =
            		SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("http://localhost:4200/payment/success") // ✅ required
                    .setCancelUrl("http://localhost:4200/payment/cancel")   // ✅ required
                    .addLineItem(lineItem)
                    .build();
            
            System.out.println("3 secret key --------------> " + secretKey);

            // Create new session
            Session session = null;
            try {
                session = Session.create(params);
            } catch (StripeException e) {
                //log the error
            	System.out.println("Error in creating the seesion : " + e.getMessage());
            }
            
            System.out.println("4 secret key --------------> " + secretKey);
            
            if (session == null) {
                return StripeResponse.builder()
                        .status("FAILURE")
                        .message("Failed to create payment session.")
                        .build();
            }

            return StripeResponse
                    .builder()
                    .status("SUCCESS")
                    .message("Payment session created ")
                    .sessionId(session.getId())
                    .sessionUrl(session.getUrl())
                    .build();
    }
}