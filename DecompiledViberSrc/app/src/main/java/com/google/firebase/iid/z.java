package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class z
{
  private static final long b = TimeUnit.DAYS.toMillis(7L);
  final String a;
  private final String c;
  private final long d;

  private z(String paramString1, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramLong;
  }

  static z a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    if (paramString.startsWith("{"))
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        z localz = new z(localJSONObject.getString("token"), localJSONObject.getString("appVersion"), localJSONObject.getLong("timestamp"));
        return localz;
      }
      catch (JSONException localJSONException)
      {
        String str = String.valueOf(localJSONException);
        Log.w("FirebaseInstanceId", 23 + String.valueOf(str).length() + "Failed to parse token: " + str);
        return null;
      }
    return new z(paramString, null, 0L);
  }

  static String a(z paramz)
  {
    if (paramz == null)
      return null;
    return paramz.a;
  }

  static String a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("token", paramString1);
      localJSONObject.put("appVersion", paramString2);
      localJSONObject.put("timestamp", paramLong);
      String str2 = localJSONObject.toString();
      return str2;
    }
    catch (JSONException localJSONException)
    {
      String str1 = String.valueOf(localJSONException);
      Log.w("FirebaseInstanceId", 24 + String.valueOf(str1).length() + "Failed to encode token: " + str1);
    }
    return null;
  }

  final boolean b(String paramString)
  {
    return (System.currentTimeMillis() > this.d + b) || (!paramString.equals(this.c));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.z
 * JD-Core Version:    0.6.2
 */