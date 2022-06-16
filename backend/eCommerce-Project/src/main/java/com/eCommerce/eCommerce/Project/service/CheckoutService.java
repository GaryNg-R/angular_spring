package com.eCommerce.eCommerce.Project.service;

import com.eCommerce.eCommerce.Project.dto.Purchase;
import com.eCommerce.eCommerce.Project.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
