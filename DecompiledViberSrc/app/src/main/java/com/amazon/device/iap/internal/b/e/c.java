package com.amazon.device.iap.internal.b.e;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.util.d;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.device.iap.model.UserDataResponse.RequestStatus;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

public final class c extends b
{
  private static final String b = c.class.getSimpleName();

  public c(com.amazon.device.iap.internal.b.e parame)
  {
    super(parame, "2.0");
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws RemoteException, KiwiException
  {
    com.amazon.device.iap.internal.util.e.a(b, "onResult: result = " + paramSuccessResult);
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(b, "data: " + localMap);
    String str1 = (String)localMap.get("userId");
    String str2 = (String)localMap.get("marketplace");
    com.amazon.device.iap.internal.b.e locale = b();
    if ((d.a(str1)) || (d.a(str2)))
    {
      locale.d().a(new UserDataResponseBuilder().setRequestId(locale.c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
      return false;
    }
    UserData localUserData = new UserDataBuilder().setUserId(str1).setMarketplace(str2).build();
    UserDataResponse localUserDataResponse = new UserDataResponseBuilder().setRequestId(locale.c()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(localUserData).build();
    locale.d().a("userId", localUserData.getUserId());
    locale.d().a(localUserDataResponse);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.e.c
 * JD-Core Version:    0.6.2
 */