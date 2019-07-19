package com.microsoft.codepush.react;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private SharedPreferences a;

  private String b(String paramString)
  {
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length > 0)
      return arrayOfString[0];
    return null;
  }

  private void b()
  {
    this.a.edit().remove("CODE_PUSH_RETRY_DEPLOYMENT_REPORT").commit();
  }

  private String c()
  {
    return this.a.getString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", null);
  }

  private String c(ReadableMap paramReadableMap)
  {
    String str1 = j.a(paramReadableMap, "deploymentKey");
    String str2 = j.a(paramReadableMap, "label");
    if ((str1 != null) && (str2 != null))
      return str1 + ":" + str2;
    return null;
  }

  private String c(String paramString)
  {
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length > 1)
      return arrayOfString[1];
    return null;
  }

  private boolean d(String paramString)
  {
    return (paramString != null) && (paramString.contains(":"));
  }

  private void e(String paramString)
  {
    this.a.edit().putString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", paramString).commit();
  }

  public WritableMap a()
  {
    String str = this.a.getString("CODE_PUSH_RETRY_DEPLOYMENT_REPORT", null);
    Object localObject = null;
    if (str != null)
      b();
    try
    {
      WritableMap localWritableMap = j.a(new JSONObject(str));
      localObject = localWritableMap;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public WritableMap a(WritableMap paramWritableMap)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putMap("package", paramWritableMap);
    localWritableMap.putString("status", "DeploymentFailed");
    return localWritableMap;
  }

  public WritableMap a(String paramString)
  {
    String str1 = c();
    WritableMap localWritableMap1;
    if (str1 == null)
    {
      b();
      localWritableMap1 = Arguments.createMap();
      localWritableMap1.putString("appVersion", paramString);
    }
    boolean bool;
    do
    {
      return localWritableMap1;
      bool = str1.equals(paramString);
      localWritableMap1 = null;
    }
    while (bool);
    b();
    WritableMap localWritableMap2 = Arguments.createMap();
    if (d(str1))
    {
      String str2 = b(str1);
      String str3 = c(str1);
      localWritableMap2.putString("appVersion", paramString);
      localWritableMap2.putString("previousDeploymentKey", str2);
      localWritableMap2.putString("previousLabelOrAppVersion", str3);
      return localWritableMap2;
    }
    localWritableMap2.putString("appVersion", paramString);
    localWritableMap2.putString("previousLabelOrAppVersion", str1);
    return localWritableMap2;
  }

  public void a(ReadableMap paramReadableMap)
  {
    if ((paramReadableMap.hasKey("status")) && ("DeploymentFailed".equals(paramReadableMap.getString("status"))));
    do
    {
      return;
      if (paramReadableMap.hasKey("appVersion"))
      {
        e(paramReadableMap.getString("appVersion"));
        return;
      }
    }
    while (!paramReadableMap.hasKey("package"));
    e(c(paramReadableMap.getMap("package")));
  }

  public WritableMap b(WritableMap paramWritableMap)
  {
    String str1 = c(paramWritableMap);
    String str2 = c();
    WritableMap localWritableMap1 = null;
    if (str1 != null)
    {
      if (str2 != null)
        break label55;
      b();
      localWritableMap1 = Arguments.createMap();
      localWritableMap1.putMap("package", paramWritableMap);
      localWritableMap1.putString("status", "DeploymentSucceeded");
    }
    label55: boolean bool;
    do
    {
      return localWritableMap1;
      bool = str2.equals(str1);
      localWritableMap1 = null;
    }
    while (bool);
    b();
    WritableMap localWritableMap2 = Arguments.createMap();
    if (d(str2))
    {
      String str3 = b(str2);
      String str4 = c(str2);
      localWritableMap2.putMap("package", paramWritableMap);
      localWritableMap2.putString("status", "DeploymentSucceeded");
      localWritableMap2.putString("previousDeploymentKey", str3);
      localWritableMap2.putString("previousLabelOrAppVersion", str4);
      return localWritableMap2;
    }
    localWritableMap2.putMap("package", paramWritableMap);
    localWritableMap2.putString("status", "DeploymentSucceeded");
    localWritableMap2.putString("previousLabelOrAppVersion", str2);
    return localWritableMap2;
  }

  public void b(ReadableMap paramReadableMap)
  {
    JSONObject localJSONObject = j.a(paramReadableMap);
    this.a.edit().putString("CODE_PUSH_RETRY_DEPLOYMENT_REPORT", localJSONObject.toString()).commit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.e
 * JD-Core Version:    0.6.2
 */