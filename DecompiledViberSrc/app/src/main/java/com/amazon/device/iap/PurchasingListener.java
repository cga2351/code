package com.amazon.device.iap;

import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;

public abstract interface PurchasingListener
{
  public abstract void onProductDataResponse(ProductDataResponse paramProductDataResponse);

  public abstract void onPurchaseResponse(PurchaseResponse paramPurchaseResponse);

  public abstract void onPurchaseUpdatesResponse(PurchaseUpdatesResponse paramPurchaseUpdatesResponse);

  public abstract void onUserDataResponse(UserDataResponse paramUserDataResponse);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.PurchasingListener
 * JD-Core Version:    0.6.2
 */