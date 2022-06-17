package com.eCommerce.eCommerce.Project.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    //lombok only take final var to create a args constructor
    //or use @NonNull instead of final
    private final String orderTrackingNumber;

}
