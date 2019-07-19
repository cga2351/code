package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.util.d;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;
import org.json.JSONObject;

public final class a extends c
{
  private static final String a = a.class.getSimpleName();

  public a(com.amazon.device.iap.internal.b.e parame)
  {
    super(parame, "2.0");
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws Exception
  {
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(a, "data: " + localMap);
    String str1 = (String)getCommandData().get("requestId");
    String str2 = (String)localMap.get("userId");
    String str3 = (String)localMap.get("marketplace");
    String str4 = (String)localMap.get("receipt");
    if (d.a(str4))
    {
      a(str2, str3, str1, PurchaseResponse.RequestStatus.FAILED);
      return false;
    }
    JSONObject localJSONObject = new JSONObject(str4);
    PurchaseResponse.RequestStatus localRequestStatus = PurchaseResponse.RequestStatus.safeValueOf(localJSONObject.getString("orderStatus"));
    if (localRequestStatus == PurchaseResponse.RequestStatus.SUCCESSFUL);
    while (true)
    {
      try
      {
        Receipt localReceipt2 = com.amazon.device.iap.internal.util.a.a(localJSONObject, str2, str1);
        localReceipt1 = localReceipt2;
        com.amazon.device.iap.internal.b.e locale = b();
        UserData localUserData = new UserDataBuilder().setUserId(str2).setMarketplace(str3).build();
        PurchaseResponse localPurchaseResponse = new PurchaseResponseBuilder().setRequestId(locale.c()).setRequestStatus(localRequestStatus).setUserData(localUserData).setReceipt(localReceipt1).build();
        locale.d().a(localPurchaseResponse);
        return true;
      }
      catch (Throwable localThrowable)
      {
        a(str2, str3, str1, PurchaseResponse.RequestStatus.FAILED);
        return false;
      }
      Receipt localReceipt1 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.a.a
 * JD-Core Version:    0.6.2
 */