package com.amazon.device.iap.internal.b.c;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

public final class d extends e
{
  public d(RequestId paramRequestId, Set<String> paramSet)
  {
    super(paramRequestId);
    a locala = new a(this, paramSet);
    locala.b(new b(this, paramSet));
    a(locala);
  }

  public void a()
  {
    a((ProductDataResponse)d().a());
  }

  public void b()
  {
    ProductDataResponse localProductDataResponse = (ProductDataResponse)d().a();
    if (localProductDataResponse == null)
      localProductDataResponse = new ProductDataResponseBuilder().setRequestId(c()).setRequestStatus(ProductDataResponse.RequestStatus.FAILED).build();
    a(localProductDataResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.c.d
 * JD-Core Version:    0.6.2
 */