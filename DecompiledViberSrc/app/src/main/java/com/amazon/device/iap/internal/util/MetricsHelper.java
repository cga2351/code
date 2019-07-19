package com.amazon.device.iap.internal.util;

import com.amazon.device.iap.internal.b.h.a;
import com.amazon.device.iap.model.RequestId;
import org.json.JSONObject;

public class MetricsHelper
{
  private static final String DESCRIPTION = "description";
  private static final String EXCEPTION_MESSAGE = "exceptionMessage";
  private static final String EXCEPTION_METRIC = "GenericException";
  private static final String JSON_PARSING_EXCEPTION_METRIC = "JsonParsingFailed";
  private static final String JSON_STRING = "jsonString";
  private static final String RECEIPT_VERIFICATION_FAILED_METRIC = "IapReceiptVerificationFailed";
  private static final String SIGNATURE = "signature";
  private static final String STRING_TO_SIGN = "stringToSign";
  private static final String TAG = MetricsHelper.class.getSimpleName();

  public static void submitExceptionMetrics(String paramString1, String paramString2, Exception paramException)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exceptionMessage", paramException.getMessage());
      localJSONObject.put("description", paramString2);
      submitMetric(paramString1, "GenericException", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      e.b(TAG, "error calling submitMetric: " + localException);
    }
  }

  public static void submitJsonParsingExceptionMetrics(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("jsonString", paramString2);
      localJSONObject.put("description", paramString3);
      submitMetric(paramString1, "JsonParsingFailed", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      e.b(TAG, "error calling submitMetric: " + localException);
    }
  }

  protected static void submitMetric(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    new a(new com.amazon.device.iap.internal.b.e(RequestId.fromString(paramString1)), paramString2, paramJSONObject.toString()).a_();
  }

  public static void submitReceiptVerificationFailureMetrics(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("stringToSign", paramString2);
      localJSONObject.put("signature", paramString3);
      submitMetric(paramString1, "IapReceiptVerificationFailed", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      e.b(TAG, "error calling submitMetric: " + localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.util.MetricsHelper
 * JD-Core Version:    0.6.2
 */