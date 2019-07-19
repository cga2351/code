package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.f.c;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;

public final class d extends e
{
  public d(RequestId paramRequestId)
  {
    super(paramRequestId);
    a locala = new a(this);
    locala.b(new b(this));
    a(locala);
  }

  public void a()
  {
    PurchaseResponse localPurchaseResponse = (PurchaseResponse)d().a();
    if (localPurchaseResponse == null)
      return;
    Receipt localReceipt = localPurchaseResponse.getReceipt();
    if (localReceipt != null);
    for (boolean bool = true; ; bool = false)
    {
      c localc = new c(this, bool);
      if ((bool) && ((ProductType.ENTITLED == localReceipt.getProductType()) || (ProductType.SUBSCRIPTION == localReceipt.getProductType())))
        localc.b(new com.amazon.device.iap.internal.b.f.b(this, c().toString()));
      a(localPurchaseResponse, localc);
      return;
    }
  }

  public void b()
  {
    PurchaseResponse localPurchaseResponse = (PurchaseResponse)d().a();
    if (localPurchaseResponse == null)
      localPurchaseResponse = new PurchaseResponseBuilder().setRequestId(c()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
    a(localPurchaseResponse, new c(this, false));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.a.d
 * JD-Core Version:    0.6.2
 */