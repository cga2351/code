package com.amazon.device.iap.internal.c;

import org.json.JSONException;
import org.json.JSONObject;

class d
{
  private final String a;
  private final String b;
  private final long c;
  private final String d;

  public d(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.c = paramLong;
  }

  public static d a(String paramString)
    throws e
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      d locald = new d(localJSONObject.getString("KEY_USER_ID"), localJSONObject.getString("KEY_RECEIPT_STRING"), localJSONObject.getString("KEY_REQUEST_ID"), localJSONObject.getLong("KEY_TIMESTAMP"));
      return locald;
    }
    catch (Throwable localThrowable)
    {
      throw new e("Input invalid for PendingReceipt Object:" + paramString, localThrowable);
    }
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public String d()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("KEY_USER_ID", this.a);
    localJSONObject.put("KEY_RECEIPT_STRING", this.b);
    localJSONObject.put("KEY_REQUEST_ID", this.d);
    localJSONObject.put("KEY_TIMESTAMP", this.c);
    return localJSONObject.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.c.d
 * JD-Core Version:    0.6.2
 */