package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.c.c;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public final class d extends b
{
  private static final String b = d.class.getSimpleName();
  private static final Date c = new Date(0L);

  public d(com.amazon.device.iap.internal.b.e parame)
  {
    super(parame, "1.0", true);
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws Exception
  {
    int i = 0;
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(b, "data: " + localMap);
    String str1 = (String)localMap.get("userId");
    ((String)localMap.get("requestId"));
    String str2 = (String)localMap.get("marketplace");
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray1 = new JSONArray((String)localMap.get("receipts"));
    int j = 0;
    while (true)
      if (j < localJSONArray1.length())
        try
        {
          Receipt localReceipt = com.amazon.device.iap.internal.util.a.a(localJSONArray1.getJSONObject(j), str1, null);
          localArrayList.add(localReceipt);
          if (ProductType.ENTITLED == localReceipt.getProductType())
            c.a().a(str1, localReceipt.getReceiptId(), localReceipt.getSku());
          j++;
        }
        catch (com.amazon.device.iap.internal.b.a locala)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to parse receipt, requestId:" + locala.a());
        }
        catch (com.amazon.device.iap.internal.b.d locald)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to verify receipt, requestId:" + locald.a());
        }
        catch (Throwable localThrowable)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to verify receipt, requestId:" + localThrowable.getMessage());
        }
    JSONArray localJSONArray2 = new JSONArray((String)localMap.get("revocations"));
    while (true)
      if (i < localJSONArray2.length())
        try
        {
          String str4 = localJSONArray2.getString(i);
          String str5 = c.a().a(str1, str4);
          localArrayList.add(new ReceiptBuilder().setSku(str4).setProductType(ProductType.ENTITLED).setPurchaseDate(null).setCancelDate(c).setReceiptId(str5).build());
          i++;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            com.amazon.device.iap.internal.util.e.b(b, "fail to parse JSON[" + i + "] in \"" + localJSONArray2 + "\"");
        }
    String str3 = (String)localMap.get("cursor");
    boolean bool = "true".equalsIgnoreCase((String)localMap.get("hasMore"));
    com.amazon.device.iap.internal.b.e locale = b();
    UserData localUserData = new UserDataBuilder().setUserId(str1).setMarketplace(str2).build();
    PurchaseUpdatesResponse localPurchaseUpdatesResponse = new PurchaseUpdatesResponseBuilder().setRequestId(locale.c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(localUserData).setReceipts(localArrayList).setHasMore(bool).build();
    Set localSet = com.amazon.device.iap.internal.c.a.a().b(localPurchaseUpdatesResponse.getUserData().getUserId());
    localPurchaseUpdatesResponse.getReceipts().addAll(localSet);
    locale.d().a(localPurchaseUpdatesResponse);
    locale.d().a("newCursor", str3);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.d.d
 * JD-Core Version:    0.6.2
 */