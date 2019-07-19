package com.my.target;

import android.content.Context;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

public final class x extends v<String>
{
  public static x a()
  {
    return new x();
  }

  protected String a(String paramString, Context paramContext)
  {
    bc localbc = bc.a(paramContext);
    if (localbc != null)
    {
      this.d = localbc.a(paramString);
      if (this.d != null)
      {
        this.b = true;
        return (String)this.d;
      }
    }
    else
    {
      dp.a("unable to open disk cache and load/save video " + paramString);
      this.a = false;
      return null;
    }
    try
    {
      dp.a("send video request: " + paramString);
      Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
      while (true)
      {
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
            break label281;
          File localFile = localbc.b(((HttpURLConnection)localObject2).getInputStream(), paramString);
          if (localFile != null)
          {
            this.d = localFile.getAbsolutePath();
            if (localObject2 != null)
              ((HttpURLConnection)localObject2).disconnect();
            return (String)this.d;
          }
          this.a = false;
          this.e = "video request error: can't save video to disk cache";
          dp.a(this.e);
          continue;
        }
        catch (Throwable localThrowable3)
        {
          localObject1 = localObject2;
          localThrowable1 = localThrowable3;
        }
        this.a = false;
        this.e = localThrowable1.getMessage();
        dp.a("video request error: " + this.e);
        localObject2 = localObject1;
        continue;
        label281: this.a = false;
        this.e = ("video request error: response code " + this.c);
        dp.a(this.e);
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
 * Qualified Name:     com.my.target.x
 * JD-Core Version:    0.6.2
 */