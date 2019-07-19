package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.d;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public final class c extends b
{
  private static final String b = c.class.getSimpleName();

  public c(com.amazon.device.iap.internal.b.e parame, boolean paramBoolean)
  {
    super(parame, "2.0", paramBoolean);
  }

  private List<Receipt> a(String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = new JSONArray(paramString2);
    int i = 0;
    while (true)
      if (i < localJSONArray.length())
        try
        {
          localArrayList.add(com.amazon.device.iap.internal.util.a.a(localJSONArray.getJSONObject(i), paramString1, paramString3));
          i++;
        }
        catch (com.amazon.device.iap.internal.b.a locala)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to parse receipt, requestId:" + locala.a());
        }
        catch (d locald)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to verify receipt, requestId:" + locald.a());
        }
        catch (Throwable localThrowable)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to verify receipt, requestId:" + localThrowable.getMessage());
        }
    return localArrayList;
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws Exception
  {
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(b, "data: " + localMap);
    String str1 = (String)localMap.get("userId");
    String str2 = (String)localMap.get("marketplace");
    String str3 = (String)localMap.get("requestId");
    List localList = a(str1, (String)localMap.get("receipts"), str3);
    String str4 = (String)localMap.get("cursor");
    boolean bool = Boolean.valueOf((String)localMap.get("hasMore")).booleanValue();
    com.amazon.device.iap.internal.b.e locale = b();
    UserData localUserData = new UserDataBuilder().setUserId(str1).setMarketplace(str2).build();
    PurchaseUpdatesResponse localPurchaseUpdatesResponse = new PurchaseUpdatesResponseBuilder().setRequestId(locale.c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(localUserData).setReceipts(localList).setHasMore(bool).build();
    locale.d().a("newCursor", str4);
    locale.d().a(localPurchaseUpdatesResponse);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.d.c
 * JD-Core Version:    0.6.2
 */