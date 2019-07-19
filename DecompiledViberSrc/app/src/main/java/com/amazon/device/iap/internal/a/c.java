package com.amazon.device.iap.internal.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.util.e;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.amazon.device.iap.internal.c
{
  private static final String a = c.class.getSimpleName();

  private Intent a(String paramString)
  {
    Intent localIntent = new Intent(paramString);
    localIntent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
    return localIntent;
  }

  private Product a(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    ProductType localProductType = ProductType.valueOf(paramJSONObject.optString("itemType"));
    JSONObject localJSONObject = paramJSONObject.getJSONObject("priceJson");
    Currency localCurrency = Currency.getInstance(localJSONObject.optString("currency"));
    BigDecimal localBigDecimal = new BigDecimal(localJSONObject.optString("value"));
    String str1 = localCurrency.getSymbol() + localBigDecimal;
    String str2 = paramJSONObject.optString("title");
    String str3 = paramJSONObject.optString("description");
    String str4 = paramJSONObject.optString("smallIconUrl");
    return new ProductBuilder().setSku(paramString).setProductType(localProductType).setDescription(str3).setPrice(str1).setSmallIconUrl(str4).setTitle(str2).build();
  }

  private Receipt a(JSONObject paramJSONObject)
    throws ParseException
  {
    String str1 = paramJSONObject.optString("receiptId");
    String str2 = paramJSONObject.optString("sku");
    ProductType localProductType = ProductType.valueOf(paramJSONObject.optString("itemType"));
    String str3 = paramJSONObject.optString("purchaseDate");
    Date localDate1 = b.a.parse(str3);
    String str4 = paramJSONObject.optString("cancelDate");
    if ((str4 == null) || (str4.length() == 0));
    for (Date localDate2 = null; ; localDate2 = b.a.parse(str4))
      return new ReceiptBuilder().setReceiptId(str1).setSku(str2).setProductType(localProductType).setPurchaseDate(localDate1).setCancelDate(localDate2).build();
  }

  private void a(Intent paramIntent)
    throws JSONException
  {
    PurchaseUpdatesResponse localPurchaseUpdatesResponse = b(paramIntent);
    if (localPurchaseUpdatesResponse.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL)
    {
      String str = new JSONObject(paramIntent.getStringExtra("purchaseUpdatesOutput")).optString("offset");
      Log.i(a, "Offset for PurchaseUpdatesResponse:" + str);
      com.amazon.device.iap.internal.util.b.a(localPurchaseUpdatesResponse.getUserData().getUserId(), str);
    }
    a(localPurchaseUpdatesResponse);
  }

  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      String str = com.amazon.device.iap.internal.util.b.a(paramString2);
      Log.i(a, "send PurchaseUpdates with user id:" + paramString2 + ";reset flag:" + paramBoolean + ", local cursor:" + str + ", parsed from old requestId:" + paramString1);
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("requestId", paramString1.toString());
      if (paramBoolean)
        str = null;
      localJSONObject.put("offset", str);
      localJSONObject.put("sdkVersion", "2.0.61.0");
      localJSONObject.put("packageName", localContext.getPackageName());
      localBundle.putString("purchaseUpdatesInput", localJSONObject.toString());
      Intent localIntent = a("com.amazon.testclient.iap.purchaseUpdates");
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      localContext.startService(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.b(a, "Error in sendPurchaseUpdatesRequest.");
    }
  }

  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("requestId", paramString);
      localJSONObject.put("packageName", localContext.getPackageName());
      localJSONObject.put("sdkVersion", "2.0.61.0");
      localJSONObject.put("isPurchaseUpdates", paramBoolean1);
      localJSONObject.put("reset", paramBoolean2);
      localBundle.putString("userInput", localJSONObject.toString());
      Intent localIntent = a("com.amazon.testclient.iap.appUserId");
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      localContext.startService(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.b(a, "Error in sendGetUserDataRequest.");
    }
  }

  private PurchaseUpdatesResponse b(Intent paramIntent)
  {
    PurchaseUpdatesResponse.RequestStatus localRequestStatus1 = PurchaseUpdatesResponse.RequestStatus.FAILED;
    try
    {
      localJSONObject1 = new JSONObject(paramIntent.getStringExtra("purchaseUpdatesOutput"));
      localRequestId2 = RequestId.fromString(localJSONObject1.optString("requestId"));
    }
    catch (Exception localException3)
    {
      try
      {
        localRequestStatus1 = PurchaseUpdatesResponse.RequestStatus.valueOf(localJSONObject1.optString("status"));
        bool2 = localJSONObject1.optBoolean("isMore");
      }
      catch (Exception localException3)
      {
        try
        {
          String str1 = localJSONObject1.optString("userId");
          String str2 = localJSONObject1.optString("marketplace");
          localUserData2 = new UserDataBuilder().setUserId(str1).setMarketplace(str2).build();
        }
        catch (Exception localException3)
        {
          try
          {
            JSONObject localJSONObject1;
            if (localRequestStatus1 == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL)
            {
              localArrayList = new ArrayList();
              try
              {
                JSONArray localJSONArray = localJSONObject1.optJSONArray("receipts");
                int i = 0;
                while (true)
                  if ((localJSONArray != null) && (i < localJSONArray.length()))
                  {
                    JSONObject localJSONObject2 = localJSONArray.optJSONObject(i);
                    try
                    {
                      localArrayList.add(a(localJSONObject2));
                      i++;
                    }
                    catch (Exception localException6)
                    {
                      while (true)
                        Log.e(a, "Failed to parse receipt from json:" + localJSONObject2);
                    }
                  }
              }
              catch (Exception localException5)
              {
                localRequestStatus2 = localRequestStatus1;
                bool1 = bool2;
                localUserData1 = localUserData2;
                localRequestId1 = localRequestId2;
                localObject = localException5;
              }
            }
            while (true)
            {
              Log.e(a, "Error parsing purchase updates output", (Throwable)localObject);
              while (true)
              {
                return new PurchaseUpdatesResponseBuilder().setRequestId(localRequestId1).setRequestStatus(localRequestStatus2).setUserData(localUserData1).setReceipts(localArrayList).setHasMore(bool1).build();
                localArrayList = null;
                localRequestStatus2 = localRequestStatus1;
                bool1 = bool2;
                localUserData1 = localUserData2;
                localRequestId1 = localRequestId2;
              }
              localException1 = localException1;
              localObject = localException1;
              localRequestStatus2 = localRequestStatus1;
              localArrayList = null;
              bool1 = false;
              localUserData1 = null;
              localRequestId1 = null;
              continue;
              localException2 = localException2;
              localRequestId1 = localRequestId2;
              localObject = localException2;
              localRequestStatus2 = localRequestStatus1;
              localArrayList = null;
              bool1 = false;
              localUserData1 = null;
              continue;
              localException3 = localException3;
              localRequestId1 = localRequestId2;
              localObject = localException3;
              localRequestStatus2 = localRequestStatus1;
              bool1 = bool2;
              localArrayList = null;
              localUserData1 = null;
            }
          }
          catch (Exception localException4)
          {
            while (true)
            {
              RequestId localRequestId2;
              boolean bool2;
              UserData localUserData2;
              PurchaseUpdatesResponse.RequestStatus localRequestStatus2 = localRequestStatus1;
              boolean bool1 = bool2;
              UserData localUserData1 = localUserData2;
              RequestId localRequestId1 = localRequestId2;
              Object localObject = localException4;
              ArrayList localArrayList = null;
            }
          }
        }
      }
    }
  }

  private void c(Intent paramIntent)
  {
    a(d(paramIntent));
  }

  private ProductDataResponse d(Intent paramIntent)
  {
    ProductDataResponse.RequestStatus localRequestStatus1 = ProductDataResponse.RequestStatus.FAILED;
    try
    {
      localJSONObject1 = new JSONObject(paramIntent.getStringExtra("itemDataOutput"));
      localRequestId2 = RequestId.fromString(localJSONObject1.optString("requestId"));
    }
    catch (Exception localException2)
    {
      try
      {
        localRequestStatus1 = ProductDataResponse.RequestStatus.valueOf(localJSONObject1.optString("status"));
        if (localRequestStatus1 != ProductDataResponse.RequestStatus.FAILED)
          localObject3 = new LinkedHashSet();
      }
      catch (Exception localException2)
      {
        while (true)
        {
          try
          {
            JSONObject localJSONObject1;
            HashMap localHashMap2 = new HashMap();
            try
            {
              JSONArray localJSONArray = localJSONObject1.optJSONArray("unavailableSkus");
              if (localJSONArray != null)
              {
                int i = 0;
                if (i < localJSONArray.length())
                {
                  ((Set)localObject3).add(localJSONArray.getString(i));
                  i++;
                  continue;
                }
              }
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("items");
              if (localJSONObject2 == null)
                continue;
              Iterator localIterator = localJSONObject2.keys();
              if (!localIterator.hasNext())
                continue;
              String str = (String)localIterator.next();
              localHashMap2.put(str, a(str, localJSONObject2.optJSONObject(str)));
              continue;
            }
            catch (Exception localException3)
            {
              localHashMap1 = localHashMap2;
              localObject2 = localRequestStatus1;
              localRequestId1 = localRequestId2;
              localObject1 = localException3;
            }
            Log.e(a, "Error parsing item data output", (Throwable)localObject1);
            return new ProductDataResponseBuilder().setRequestId(localRequestId1).setRequestStatus((ProductDataResponse.RequestStatus)localObject2).setProductData(localHashMap1).setUnavailableSkus((Set)localObject3).build();
            localHashMap1 = localHashMap2;
            localObject4 = localObject3;
            Object localObject3 = localObject4;
            localObject2 = localRequestStatus1;
            localRequestId1 = localRequestId2;
            continue;
            localException1 = localException1;
            localObject1 = localException1;
            localObject2 = localRequestStatus1;
            localHashMap1 = null;
            localObject3 = null;
            localRequestId1 = null;
            continue;
            localException2 = localException2;
            ProductDataResponse.RequestStatus localRequestStatus2 = localRequestStatus1;
            localRequestId1 = localRequestId2;
            localObject1 = localException2;
            localObject2 = localRequestStatus2;
            localHashMap1 = null;
            localObject3 = null;
            continue;
          }
          catch (Exception localException4)
          {
            RequestId localRequestId2;
            Object localObject2 = localRequestStatus1;
            RequestId localRequestId1 = localRequestId2;
            Object localObject1 = localException4;
            localHashMap1 = null;
            continue;
          }
          HashMap localHashMap1 = null;
          Object localObject4 = null;
        }
      }
    }
  }

  private void e(Intent paramIntent)
  {
    UserDataResponse localUserDataResponse = f(paramIntent);
    RequestId localRequestId = localUserDataResponse.getRequestId();
    String str = paramIntent.getStringExtra("userInput");
    try
    {
      localJSONObject = new JSONObject(str);
      if ((localRequestId == null) || (localJSONObject == null))
      {
        a(localUserDataResponse);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      while (true)
      {
        Log.e(a, "Unable to parse request data: " + str, localJSONException);
        localJSONObject = null;
      }
      if (!localJSONObject.optBoolean("isPurchaseUpdates", false))
      {
        a(localUserDataResponse);
        return;
      }
      if ((localUserDataResponse.getUserData() == null) || (com.amazon.device.iap.internal.util.d.a(localUserDataResponse.getUserData().getUserId())))
      {
        Log.e(a, "No Userid found in userDataResponse" + localUserDataResponse);
        a(new PurchaseUpdatesResponseBuilder().setRequestId(localRequestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(localUserDataResponse.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
        return;
      }
      Log.i(a, "sendGetPurchaseUpdates with user id" + localUserDataResponse.getUserData().getUserId());
      boolean bool = localJSONObject.optBoolean("reset", true);
      a(localRequestId.toString(), localUserDataResponse.getUserData().getUserId(), bool);
    }
  }

  // ERROR //
  private UserDataResponse f(Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 518	com/amazon/device/iap/model/UserDataResponse$RequestStatus:FAILED	Lcom/amazon/device/iap/model/UserDataResponse$RequestStatus;
    //   3: astore_2
    //   4: new 47	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: ldc_w 520
    //   12: invokevirtual 197	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 253
    //   22: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 323	com/amazon/device/iap/model/RequestId:fromString	(Ljava/lang/String;)Lcom/amazon/device/iap/model/RequestId;
    //   28: astore 11
    //   30: aload 11
    //   32: astore 5
    //   34: aload_3
    //   35: ldc_w 325
    //   38: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 523	com/amazon/device/iap/model/UserDataResponse$RequestStatus:valueOf	(Ljava/lang/String;)Lcom/amazon/device/iap/model/UserDataResponse$RequestStatus;
    //   44: astore 13
    //   46: aload 13
    //   48: astore 7
    //   50: getstatic 525	com/amazon/device/iap/model/UserDataResponse$RequestStatus:SUCCESSFUL	Lcom/amazon/device/iap/model/UserDataResponse$RequestStatus;
    //   53: astore 14
    //   55: aconst_null
    //   56: astore 15
    //   58: aload 7
    //   60: aload 14
    //   62: if_acmpne +47 -> 109
    //   65: aload_3
    //   66: ldc_w 336
    //   69: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 16
    //   74: aload_3
    //   75: ldc_w 338
    //   78: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 17
    //   83: new 340	com/amazon/device/iap/internal/model/UserDataBuilder
    //   86: dup
    //   87: invokespecial 341	com/amazon/device/iap/internal/model/UserDataBuilder:<init>	()V
    //   90: aload 16
    //   92: invokevirtual 345	com/amazon/device/iap/internal/model/UserDataBuilder:setUserId	(Ljava/lang/String;)Lcom/amazon/device/iap/internal/model/UserDataBuilder;
    //   95: aload 17
    //   97: invokevirtual 348	com/amazon/device/iap/internal/model/UserDataBuilder:setMarketplace	(Ljava/lang/String;)Lcom/amazon/device/iap/internal/model/UserDataBuilder;
    //   100: invokevirtual 350	com/amazon/device/iap/internal/model/UserDataBuilder:build	()Lcom/amazon/device/iap/model/UserData;
    //   103: astore 18
    //   105: aload 18
    //   107: astore 15
    //   109: aload 7
    //   111: astore 19
    //   113: aload 15
    //   115: astore 10
    //   117: aload 19
    //   119: astore 9
    //   121: new 527	com/amazon/device/iap/internal/model/UserDataResponseBuilder
    //   124: dup
    //   125: invokespecial 528	com/amazon/device/iap/internal/model/UserDataResponseBuilder:<init>	()V
    //   128: aload 5
    //   130: invokevirtual 531	com/amazon/device/iap/internal/model/UserDataResponseBuilder:setRequestId	(Lcom/amazon/device/iap/model/RequestId;)Lcom/amazon/device/iap/internal/model/UserDataResponseBuilder;
    //   133: aload 9
    //   135: invokevirtual 534	com/amazon/device/iap/internal/model/UserDataResponseBuilder:setRequestStatus	(Lcom/amazon/device/iap/model/UserDataResponse$RequestStatus;)Lcom/amazon/device/iap/internal/model/UserDataResponseBuilder;
    //   138: aload 10
    //   140: invokevirtual 537	com/amazon/device/iap/internal/model/UserDataResponseBuilder:setUserData	(Lcom/amazon/device/iap/model/UserData;)Lcom/amazon/device/iap/internal/model/UserDataResponseBuilder;
    //   143: invokevirtual 540	com/amazon/device/iap/internal/model/UserDataResponseBuilder:build	()Lcom/amazon/device/iap/model/UserDataResponse;
    //   146: areturn
    //   147: astore 4
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 4
    //   154: astore 6
    //   156: aload_2
    //   157: astore 7
    //   159: getstatic 18	com/amazon/device/iap/internal/a/c:a	Ljava/lang/String;
    //   162: ldc_w 542
    //   165: aload 6
    //   167: invokestatic 384	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   170: pop
    //   171: aload 7
    //   173: astore 9
    //   175: aconst_null
    //   176: astore 10
    //   178: goto -57 -> 121
    //   181: astore 12
    //   183: aload_2
    //   184: astore 7
    //   186: aload 12
    //   188: astore 6
    //   190: goto -31 -> 159
    //   193: astore 6
    //   195: goto -36 -> 159
    //
    // Exception table:
    //   from	to	target	type
    //   4	30	147	java/lang/Exception
    //   34	46	181	java/lang/Exception
    //   50	55	193	java/lang/Exception
    //   65	105	193	java/lang/Exception
  }

  private void g(Intent paramIntent)
  {
    a(h(paramIntent));
  }

  // ERROR //
  private PurchaseResponse h(Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 552	com/amazon/device/iap/model/PurchaseResponse$RequestStatus:FAILED	Lcom/amazon/device/iap/model/PurchaseResponse$RequestStatus;
    //   3: astore_2
    //   4: new 47	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: ldc_w 554
    //   12: invokevirtual 197	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 253
    //   22: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 323	com/amazon/device/iap/model/RequestId:fromString	(Ljava/lang/String;)Lcom/amazon/device/iap/model/RequestId;
    //   28: astore 11
    //   30: aload 11
    //   32: astore 6
    //   34: aload_3
    //   35: ldc_w 336
    //   38: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 13
    //   43: aload_3
    //   44: ldc_w 338
    //   47: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 14
    //   52: new 340	com/amazon/device/iap/internal/model/UserDataBuilder
    //   55: dup
    //   56: invokespecial 341	com/amazon/device/iap/internal/model/UserDataBuilder:<init>	()V
    //   59: aload 13
    //   61: invokevirtual 345	com/amazon/device/iap/internal/model/UserDataBuilder:setUserId	(Ljava/lang/String;)Lcom/amazon/device/iap/internal/model/UserDataBuilder;
    //   64: aload 14
    //   66: invokevirtual 348	com/amazon/device/iap/internal/model/UserDataBuilder:setMarketplace	(Ljava/lang/String;)Lcom/amazon/device/iap/internal/model/UserDataBuilder;
    //   69: invokevirtual 350	com/amazon/device/iap/internal/model/UserDataBuilder:build	()Lcom/amazon/device/iap/model/UserData;
    //   72: astore 15
    //   74: aload 15
    //   76: astore 5
    //   78: aload_3
    //   79: ldc_w 556
    //   82: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 560	com/amazon/device/iap/model/PurchaseResponse$RequestStatus:safeValueOf	(Ljava/lang/String;)Lcom/amazon/device/iap/model/PurchaseResponse$RequestStatus;
    //   88: astore 17
    //   90: aload 17
    //   92: astore 7
    //   94: aload_3
    //   95: ldc_w 562
    //   98: invokevirtual 443	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   101: astore 18
    //   103: aconst_null
    //   104: astore 10
    //   106: aload 18
    //   108: ifnull +15 -> 123
    //   111: aload_0
    //   112: aload 18
    //   114: invokespecial 368	com/amazon/device/iap/internal/a/c:a	(Lorg/json/JSONObject;)Lcom/amazon/device/iap/model/Receipt;
    //   117: astore 19
    //   119: aload 19
    //   121: astore 10
    //   123: new 564	com/amazon/device/iap/internal/model/PurchaseResponseBuilder
    //   126: dup
    //   127: invokespecial 565	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:<init>	()V
    //   130: aload 6
    //   132: invokevirtual 568	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:setRequestId	(Lcom/amazon/device/iap/model/RequestId;)Lcom/amazon/device/iap/internal/model/PurchaseResponseBuilder;
    //   135: aload 7
    //   137: invokevirtual 571	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:setRequestStatus	(Lcom/amazon/device/iap/model/PurchaseResponse$RequestStatus;)Lcom/amazon/device/iap/internal/model/PurchaseResponseBuilder;
    //   140: aload 5
    //   142: invokevirtual 574	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:setUserData	(Lcom/amazon/device/iap/model/UserData;)Lcom/amazon/device/iap/internal/model/PurchaseResponseBuilder;
    //   145: aload 10
    //   147: invokevirtual 578	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:setReceipt	(Lcom/amazon/device/iap/model/Receipt;)Lcom/amazon/device/iap/internal/model/PurchaseResponseBuilder;
    //   150: invokevirtual 581	com/amazon/device/iap/internal/model/PurchaseResponseBuilder:build	()Lcom/amazon/device/iap/model/PurchaseResponse;
    //   153: areturn
    //   154: astore 4
    //   156: aconst_null
    //   157: astore 5
    //   159: aconst_null
    //   160: astore 6
    //   162: aload_2
    //   163: astore 7
    //   165: aload 4
    //   167: astore 8
    //   169: getstatic 18	com/amazon/device/iap/internal/a/c:a	Ljava/lang/String;
    //   172: ldc_w 583
    //   175: aload 8
    //   177: invokestatic 384	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   180: pop
    //   181: aconst_null
    //   182: astore 10
    //   184: goto -61 -> 123
    //   187: astore 12
    //   189: aload 12
    //   191: astore 8
    //   193: aload_2
    //   194: astore 7
    //   196: aconst_null
    //   197: astore 5
    //   199: goto -30 -> 169
    //   202: astore 16
    //   204: aload_2
    //   205: astore 7
    //   207: aload 16
    //   209: astore 8
    //   211: goto -42 -> 169
    //   214: astore 8
    //   216: goto -47 -> 169
    //
    // Exception table:
    //   from	to	target	type
    //   4	30	154	java/lang/Exception
    //   34	74	187	java/lang/Exception
    //   78	90	202	java/lang/Exception
    //   94	103	214	java/lang/Exception
    //   111	119	214	java/lang/Exception
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    e.a(a, "handleResponse");
    paramIntent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
    String str;
    try
    {
      str = paramIntent.getExtras().getString("responseType");
      if (str.equalsIgnoreCase("com.amazon.testclient.iap.purchase"))
      {
        g(paramIntent);
        return;
      }
      if (str.equalsIgnoreCase("com.amazon.testclient.iap.appUserId"))
      {
        e(paramIntent);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(a, "Error handling response.", localException);
      return;
    }
    if (str.equalsIgnoreCase("com.amazon.testclient.iap.itemData"))
    {
      c(paramIntent);
      return;
    }
    if (str.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates"))
      a(paramIntent);
  }

  public void a(RequestId paramRequestId)
  {
    e.a(a, "sendGetUserDataRequest");
    a(paramRequestId.toString(), false, false);
  }

  public void a(RequestId paramRequestId, String paramString)
  {
    e.a(a, "sendPurchaseRequest");
    try
    {
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sku", paramString);
      localJSONObject.put("requestId", paramRequestId.toString());
      localJSONObject.put("packageName", localContext.getPackageName());
      localJSONObject.put("sdkVersion", "2.0.61.0");
      localBundle.putString("purchaseInput", localJSONObject.toString());
      Intent localIntent = a("com.amazon.testclient.iap.purchase");
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      localContext.startService(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.b(a, "Error in sendPurchaseRequest.");
    }
  }

  public void a(RequestId paramRequestId, String paramString, FulfillmentResult paramFulfillmentResult)
  {
    e.a(a, "sendNotifyPurchaseFulfilled");
    try
    {
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("requestId", paramRequestId.toString());
      localJSONObject.put("packageName", localContext.getPackageName());
      localJSONObject.put("receiptId", paramString);
      localJSONObject.put("fulfillmentResult", paramFulfillmentResult);
      localJSONObject.put("sdkVersion", "2.0.61.0");
      localBundle.putString("purchaseFulfilledInput", localJSONObject.toString());
      Intent localIntent = a("com.amazon.testclient.iap.purchaseFulfilled");
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      localContext.startService(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.b(a, "Error in sendNotifyPurchaseFulfilled.");
    }
  }

  public void a(RequestId paramRequestId, Set<String> paramSet)
  {
    e.a(a, "sendItemDataRequest");
    try
    {
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray(paramSet);
      localJSONObject.put("requestId", paramRequestId.toString());
      localJSONObject.put("packageName", localContext.getPackageName());
      localJSONObject.put("skus", localJSONArray);
      localJSONObject.put("sdkVersion", "2.0.61.0");
      localBundle.putString("itemDataInput", localJSONObject.toString());
      Intent localIntent = a("com.amazon.testclient.iap.itemData");
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      localContext.startService(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.b(a, "Error in sendItemDataRequest.");
    }
  }

  public void a(RequestId paramRequestId, boolean paramBoolean)
  {
    if (paramRequestId == null)
      paramRequestId = new RequestId();
    e.a(a, "sendPurchaseUpdatesRequest/sendGetUserData first:" + paramRequestId);
    a(paramRequestId.toString(), true, paramBoolean);
  }

  protected void a(final Object paramObject)
  {
    com.amazon.device.iap.internal.util.d.a(paramObject, "response");
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    final PurchasingListener localPurchasingListener = com.amazon.device.iap.internal.d.d().a();
    if ((localContext == null) || (localPurchasingListener == null))
    {
      e.a(a, "PurchasingListener is not set. Dropping response: " + paramObject);
      return;
    }
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        try
        {
          if ((paramObject instanceof ProductDataResponse))
          {
            localPurchasingListener.onProductDataResponse((ProductDataResponse)paramObject);
            return;
          }
          if ((paramObject instanceof UserDataResponse))
          {
            localPurchasingListener.onUserDataResponse((UserDataResponse)paramObject);
            return;
          }
        }
        catch (Exception localException)
        {
          e.b(c.a(), "Error in sendResponse: " + localException);
          return;
        }
        if ((paramObject instanceof PurchaseUpdatesResponse))
        {
          localPurchasingListener.onPurchaseUpdatesResponse((PurchaseUpdatesResponse)paramObject);
          return;
        }
        if ((paramObject instanceof PurchaseResponse))
        {
          localPurchasingListener.onPurchaseResponse((PurchaseResponse)paramObject);
          return;
        }
        e.b(c.a(), "Unknown response type:" + paramObject.getClass().getName());
      }
    };
    new Handler(localContext.getMainLooper()).post(local1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.a.c
 * JD-Core Version:    0.6.2
 */