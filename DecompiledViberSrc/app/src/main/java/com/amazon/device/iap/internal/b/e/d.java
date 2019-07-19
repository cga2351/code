package com.amazon.device.iap.internal.b.e;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.device.iap.model.UserDataResponse.RequestStatus;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

public final class d extends b
{
  private static final String b = d.class.getSimpleName();

  public d(com.amazon.device.iap.internal.b.e parame)
  {
    super(parame, "1.0");
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws RemoteException, KiwiException
  {
    com.amazon.device.iap.internal.util.e.a(b, "onSuccessInternal: result = " + paramSuccessResult);
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(b, "data: " + localMap);
    String str = (String)localMap.get("userId");
    com.amazon.device.iap.internal.b.e locale = b();
    if (com.amazon.device.iap.internal.util.d.a(str))
    {
      locale.d().a(new UserDataResponseBuilder().setRequestId(locale.c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
      return false;
    }
    UserData localUserData = new UserDataBuilder().setUserId(str).setMarketplace(a).build();
    UserDataResponse localUserDataResponse = new UserDataResponseBuilder().setRequestId(locale.c()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(localUserData).build();
    locale.d().a("userId", localUserData.getUserId());
    locale.d().a(localUserDataResponse);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.e.d
 * JD-Core Version:    0.6.2
 */