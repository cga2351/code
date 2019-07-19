package com.my.target;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Base64;
import java.nio.charset.Charset;
import org.json.JSONObject;

public class y
{
  public static boolean a = true;
  private static String b = "https://ad.mail.ru/sdk/log/";
  private final String c;
  private final String d;
  private String e;
  private int f;
  private String g;
  private String h;
  private String i;

  private y(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }

  public static y a(String paramString)
  {
    return new y(paramString, "error");
  }

  public y a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sdk", "myTarget");
      localJSONObject.put("sdkver", "5.3.11");
      localJSONObject.put("os", "Android");
      localJSONObject.put("osver", Build.VERSION.RELEASE);
      localJSONObject.put("type", this.d);
      localJSONObject.put("name", this.c);
      if (this.e != null)
        localJSONObject.put("message", this.e);
      if (this.f > 0)
        localJSONObject.put("slot", this.f);
      if (this.g != null)
        localJSONObject.put("url", this.g);
      if (this.h != null)
        localJSONObject.put("bannerId", this.h);
      if (this.i != null)
        localJSONObject.put("data", this.i);
      label157: return localJSONObject.toString();
    }
    catch (Throwable localThrowable)
    {
      break label157;
    }
  }

  public void a(final Context paramContext)
  {
    dq.b(new Runnable()
    {
      public void run()
      {
        String str1 = y.this.a();
        dp.a("send message to log:\n " + str1);
        if (y.a)
        {
          String str2 = Base64.encodeToString(str1.getBytes(Charset.forName("UTF-8")), 0);
          u.a().a(str2).c(y.b(), paramContext);
        }
      }
    });
  }

  public y b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public y c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public y d(String paramString)
  {
    this.h = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.y
 * JD-Core Version:    0.6.2
 */