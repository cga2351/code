package com.amazon.device.iap.internal.b.b;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.RequestId;

public final class d extends e
{
  public d(RequestId paramRequestId, String paramString)
  {
    super(paramRequestId);
    c localc = new c(this, paramString);
    localc.b(new b(this, paramString));
    a(localc);
  }

  public void a()
  {
  }

  public void b()
  {
    PurchaseResponse localPurchaseResponse = (PurchaseResponse)d().a();
    if (localPurchaseResponse == null)
      localPurchaseResponse = new PurchaseResponseBuilder().setRequestId(c()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
    a(localPurchaseResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.b.d
 * JD-Core Version:    0.6.2
 */