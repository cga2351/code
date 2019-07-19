package com.amazon.device.iap.internal.util;

import com.amazon.android.Kiwi;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();

  private static Receipt a(JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramJSONObject.optString("token");
    String str2 = paramJSONObject.getString("sku");
    ProductType localProductType = ProductType.valueOf(paramJSONObject.getString("itemType").toUpperCase());
    String str3 = paramJSONObject.optString("startDate");
    Date localDate1;
    String str4;
    Date localDate2;
    if (a(str3))
    {
      localDate1 = null;
      str4 = paramJSONObject.optString("endDate");
      boolean bool = a(str4);
      localDate2 = null;
      if (!bool)
        break label112;
    }
    while (true)
    {
      return new ReceiptBuilder().setReceiptId(str1).setSku(str2).setProductType(localProductType).setPurchaseDate(localDate1).setCancelDate(localDate2).build();
      localDate1 = b(str3);
      break;
      label112: localDate2 = b(str4);
    }
  }

  public static Receipt a(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws com.amazon.device.iap.internal.b.a, com.amazon.device.iap.internal.b.d, IllegalArgumentException
  {
    c localc = b(paramJSONObject);
    switch (1.a[localc.ordinal()])
    {
    default:
      return d(paramJSONObject, paramString1, paramString2);
    case 1:
      return c(paramJSONObject, paramString1, paramString2);
    case 2:
    }
    return b(paramJSONObject, paramString1, paramString2);
  }

  protected static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }

  private static c b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("DeviceId");
    if (!d.a(paramJSONObject.optString("receiptId")))
      return c.c;
    if (d.a(str))
      return c.a;
    return c.b;
  }

  private static Receipt b(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws com.amazon.device.iap.internal.b.a, com.amazon.device.iap.internal.b.d
  {
    String str1 = paramJSONObject.optString("signature");
    if (d.a(str1))
    {
      e.b(a, "a signature was not found in the receipt for request ID " + paramString2);
      MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, "NO Signature found", str1);
      throw new com.amazon.device.iap.internal.b.d(paramString2, null, str1);
    }
    Receipt localReceipt;
    try
    {
      localReceipt = a(paramJSONObject);
      String str2 = paramString1 + "-" + localReceipt.getReceiptId();
      boolean bool = Kiwi.isSignedByKiwi(str2, str1);
      e.a(a, "stringToVerify/legacy:\n" + str2 + "\nsignature:\n" + str1);
      if (!bool)
      {
        MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, str2, str1);
        throw new com.amazon.device.iap.internal.b.d(paramString2, str2, str1);
      }
    }
    catch (JSONException localJSONException)
    {
      throw new com.amazon.device.iap.internal.b.a(paramString2, paramJSONObject.toString(), localJSONException);
    }
    return localReceipt;
  }

  protected static Date b(String paramString)
    throws JSONException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    try
    {
      Date localDate = localSimpleDateFormat.parse(paramString);
      long l = localDate.getTime();
      if (0L == l)
        localDate = null;
      return localDate;
    }
    catch (ParseException localParseException)
    {
      throw new JSONException(localParseException.getMessage());
    }
  }

  private static Receipt c(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws com.amazon.device.iap.internal.b.a, com.amazon.device.iap.internal.b.d
  {
    String str1 = paramJSONObject.optString("DeviceId");
    String str2 = paramJSONObject.optString("signature");
    if (d.a(str2))
    {
      e.b(a, "a signature was not found in the receipt for request ID " + paramString2);
      MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, "NO Signature found", str2);
      throw new com.amazon.device.iap.internal.b.d(paramString2, null, str2);
    }
    Receipt localReceipt;
    while (true)
    {
      try
      {
        localReceipt = a(paramJSONObject);
        Object[] arrayOfObject = new Object[9];
        arrayOfObject[0] = "2.0.61.0";
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = str1;
        arrayOfObject[3] = localReceipt.getProductType();
        arrayOfObject[4] = localReceipt.getSku();
        arrayOfObject[5] = localReceipt.getReceiptId();
        arrayOfObject[6] = paramString2;
        if (ProductType.SUBSCRIPTION == localReceipt.getProductType())
        {
          localDate1 = localReceipt.getPurchaseDate();
          arrayOfObject[7] = localDate1;
          ProductType localProductType1 = ProductType.SUBSCRIPTION;
          ProductType localProductType2 = localReceipt.getProductType();
          Date localDate2 = null;
          if (localProductType1 == localProductType2)
            localDate2 = localReceipt.getCancelDate();
          arrayOfObject[8] = localDate2;
          String str3 = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ", arrayOfObject);
          e.a(a, "stringToVerify/v1:\n" + str3 + "\nsignature:\n" + str2);
          if (Kiwi.isSignedByKiwi(str3, str2))
            break;
          MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, str3, str2);
          throw new com.amazon.device.iap.internal.b.d(paramString2, str3, str2);
        }
      }
      catch (JSONException localJSONException)
      {
        throw new com.amazon.device.iap.internal.b.a(paramString2, paramJSONObject.toString(), localJSONException);
      }
      Date localDate1 = null;
    }
    return localReceipt;
  }

  private static Receipt d(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws com.amazon.device.iap.internal.b.a, com.amazon.device.iap.internal.b.d
  {
    String str1 = paramJSONObject.optString("DeviceId");
    String str2 = paramJSONObject.optString("signature");
    if (d.a(str2))
    {
      e.b(a, "a signature was not found in the receipt for request ID " + paramString2);
      MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, "NO Signature found", str2);
      throw new com.amazon.device.iap.internal.b.d(paramString2, null, str2);
    }
    Receipt localReceipt;
    try
    {
      String str3 = paramJSONObject.getString("receiptId");
      String str4 = paramJSONObject.getString("sku");
      ProductType localProductType = ProductType.valueOf(paramJSONObject.getString("itemType").toUpperCase());
      String str5 = paramJSONObject.optString("purchaseDate");
      Date localDate1;
      String str6;
      Object localObject;
      if (a(str5))
      {
        localDate1 = null;
        str6 = paramJSONObject.optString("cancelDate");
        boolean bool = a(str6);
        localObject = null;
        if (!bool)
          break label326;
      }
      while (true)
      {
        localReceipt = new ReceiptBuilder().setReceiptId(str3).setSku(str4).setProductType(localProductType).setPurchaseDate(localDate1).setCancelDate((Date)localObject).build();
        Object[] arrayOfObject = new Object[7];
        arrayOfObject[0] = paramString1;
        arrayOfObject[1] = str1;
        arrayOfObject[2] = localReceipt.getProductType();
        arrayOfObject[3] = localReceipt.getSku();
        arrayOfObject[4] = localReceipt.getReceiptId();
        arrayOfObject[5] = localReceipt.getPurchaseDate();
        arrayOfObject[6] = localReceipt.getCancelDate();
        String str7 = String.format("%s|%s|%s|%s|%s|%tQ|%tQ", arrayOfObject);
        e.a(a, "stringToVerify/v2:\n" + str7 + "\nsignature:\n" + str2);
        if (Kiwi.isSignedByKiwi(str7, str2))
          break label357;
        MetricsHelper.submitReceiptVerificationFailureMetrics(paramString2, str7, str2);
        throw new com.amazon.device.iap.internal.b.d(paramString2, str7, str2);
        localDate1 = b(str5);
        break;
        label326: Date localDate2 = b(str6);
        localObject = localDate2;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new com.amazon.device.iap.internal.b.a(paramString2, paramJSONObject.toString(), localJSONException);
    }
    label357: return localReceipt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.util.a
 * JD-Core Version:    0.6.2
 */