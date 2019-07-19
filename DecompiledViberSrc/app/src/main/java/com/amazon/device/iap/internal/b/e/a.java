package com.amazon.device.iap.internal.b.e;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.device.iap.model.UserDataResponse.RequestStatus;

public final class a extends e
{
  public a(RequestId paramRequestId)
  {
    super(paramRequestId);
    c localc = new c(this);
    localc.b(new d(this));
    a(localc);
  }

  public void a()
  {
    a((UserDataResponse)d().a());
  }

  public void b()
  {
    UserDataResponse localUserDataResponse = (UserDataResponse)d().a();
    if (localUserDataResponse == null)
      localUserDataResponse = new UserDataResponseBuilder().setRequestId(c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
    a(localUserDataResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.e.a
 * JD-Core Version:    0.6.2
 */