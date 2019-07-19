package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.UserData;

abstract class c extends i
{
  c(e parame, String paramString)
  {
    super(parame, "purchase_response", paramString);
  }

  protected void a(String paramString1, String paramString2, String paramString3, PurchaseResponse.RequestStatus paramRequestStatus)
  {
    e locale = b();
    UserData localUserData = new UserDataBuilder().setUserId(paramString1).setMarketplace(paramString2).build();
    PurchaseResponse localPurchaseResponse = new PurchaseResponseBuilder().setRequestId(locale.c()).setRequestStatus(paramRequestStatus).setUserData(localUserData).setReceipt(null).build();
    locale.d().a(localPurchaseResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.a.c
 * JD-Core Version:    0.6.2
 */