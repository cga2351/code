package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class t extends v<Bitmap>
{
  private final boolean f;

  private t(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public static t a()
  {
    return new t(false);
  }

  private void a(bc parambc, InputStream paramInputStream, String paramString)
  {
    File localFile = parambc.a(paramInputStream, paramString);
    if (localFile != null)
    {
      if (!this.f)
        this.d = BitmapFactory.decodeFile(localFile.getAbsolutePath());
      return;
    }
    this.a = false;
    this.e = "image request error: can't save image to disk cache";
    dp.a(this.e);
  }

  private void a(bc parambc, String paramString)
  {
    try
    {
      dp.a("send image request: " + paramString);
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
            break label186;
          InputStream localInputStream = ((HttpURLConnection)localObject2).getInputStream();
          if (parambc != null)
          {
            a(parambc, localInputStream, paramString);
            if (localObject2 != null)
              ((HttpURLConnection)localObject2).disconnect();
            return;
          }
          a(localInputStream);
          continue;
        }
        catch (Throwable localThrowable3)
        {
          localObject1 = localObject2;
          localThrowable1 = localThrowable3;
        }
        this.a = false;
        this.e = localThrowable1.getMessage();
        dp.a("image request error: " + this.e);
        localObject2 = localObject1;
        continue;
        label186: this.a = false;
        this.e = ("image request error: response code " + this.c);
        dp.a(this.e);
      }
    }
    catch (Throwable localThrowable2)
    {
      while (true)
        Object localObject1 = null;
    }
  }

  private void a(InputStream paramInputStream)
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream, 8192);
    this.d = BitmapFactory.decodeStream(localBufferedInputStream);
    try
    {
      localBufferedInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      dp.a(localIOException.getMessage());
    }
  }

  public static t b()
  {
    return new t(true);
  }

  protected Bitmap a(String paramString, Context paramContext)
  {
    bc localbc = bc.a(paramContext);
    if (localbc != null)
    {
      if (this.f)
      {
        if (localbc.b(paramString) != null)
        {
          dp.a("image request (caching only): image already cached");
          this.b = true;
          return null;
        }
      }
      else
      {
        this.d = localbc.c(paramString);
        if (this.d != null)
        {
          this.b = true;
          return (Bitmap)this.d;
        }
      }
    }
    else
    {
      dp.a("unable to open disk cache and get image " + paramString);
      if (this.f)
      {
        this.a = false;
        this.e = "image request (caching only) error: can't cache image";
        dp.a(this.e);
        return null;
      }
    }
    a(localbc, paramString);
    return (Bitmap)this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.t
 * JD-Core Version:    0.6.2
 */