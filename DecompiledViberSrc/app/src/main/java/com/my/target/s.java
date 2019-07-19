package com.my.target;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public final class s extends v<String>
{
  public static s a()
  {
    return new s();
  }

  protected String a(String paramString, Context paramContext)
  {
    try
    {
      dp.a("send ad request: " + paramString);
      Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
      BufferedReader localBufferedReader;
      StringBuilder localStringBuilder;
      Throwable localThrowable1;
      try
      {
        ((HttpURLConnection)localObject2).setReadTimeout(10000);
        ((HttpURLConnection)localObject2).setConnectTimeout(10000);
        ((HttpURLConnection)localObject2).setInstanceFollowRedirects(true);
        ((HttpURLConnection)localObject2).setRequestProperty("connection", "close");
        ((HttpURLConnection)localObject2).connect();
        this.c = ((HttpURLConnection)localObject2).getResponseCode();
        if (this.c != 200)
          break label237;
        localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject2).getInputStream(), Charset.forName("UTF-8")));
        localStringBuilder = new StringBuilder();
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          localStringBuilder.append(str);
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject1 = localObject2;
        localThrowable1 = localThrowable3;
      }
      this.a = false;
      this.e = localThrowable1.getMessage();
      dp.a("ad request error: " + this.e);
      localObject2 = localObject1;
      while (true)
      {
        if (localObject2 != null)
          ((HttpURLConnection)localObject2).disconnect();
        return (String)this.d;
        localBufferedReader.close();
        this.d = localStringBuilder.toString();
        continue;
        label237: if (this.c != 204)
        {
          this.a = false;
          this.e = ("ad request error: response code " + this.c);
          dp.a(this.e);
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      while (true)
        Object localObject1 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.s
 * JD-Core Version:    0.6.2
 */