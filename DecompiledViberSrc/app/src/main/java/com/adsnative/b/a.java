package com.adsnative.b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.adsnative.ads.f;
import com.adsnative.c.b;
import com.adsnative.c.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class a
{
  private String a;
  private b b;
  private final Handler c = new Handler();
  private final Runnable d;

  public a(String paramString, Context paramContext, final b paramb)
  {
    this.a = paramString;
    this.b = new b(paramContext);
    this.d = new Runnable()
    {
      public void run()
      {
        new a.a(a.this, paramb).execute(new String[0]);
      }
    };
  }

  private String c()
    throws UnsupportedEncodingException
  {
    String str = "https://api.adsnative.com/v1/sdk/configs.json?" + d();
    i.b("Fetching url: " + str);
    return str;
  }

  private String d()
    throws UnsupportedEncodingException
  {
    String str1 = this.a;
    String str2 = this.b.b();
    String str3 = this.b.d();
    String str4 = this.b.e();
    String str5 = this.b.g();
    return "zid=" + str1 + "&ua=" + URLEncoder.encode(str2, "utf-8") + "&al=" + URLEncoder.encode(str3, "utf-8") + "&tz=" + URLEncoder.encode(str4, "utf-8") + "&bd=" + URLEncoder.encode(str5, "utf-8");
  }

  public void a()
  {
    this.c.post(this.d);
  }

  public void a(int paramInt)
  {
    this.c.postDelayed(this.d, paramInt);
  }

  public String b()
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(c()).openConnection();
    if (localHttpsURLConnection.getResponseCode() == 200)
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpsURLConnection.getInputStream()));
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str);
      }
      localBufferedReader.close();
      localHttpsURLConnection.disconnect();
      return localStringBuilder.toString();
    }
    i.e(localHttpsURLConnection.getResponseMessage());
    throw new IOException(localHttpsURLConnection.getResponseMessage());
  }

  private class a extends AsyncTask<String, Void, String>
  {
    private a.b b;

    a(a.b arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    protected String a(String[] paramArrayOfString)
    {
      try
      {
        String str = a.this.b();
        return str;
      }
      catch (IOException localIOException)
      {
        this.b.a(new f("IOException: " + localIOException.getMessage()));
        localIOException.printStackTrace();
      }
      return null;
    }

    protected void a(String paramString)
    {
      if (paramString != null)
      {
        this.b.a(paramString);
        return;
      }
      this.b.a(new f("Failed to load configs"));
    }
  }

  public static abstract interface b
  {
    public abstract void a(f paramf);

    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.a
 * JD-Core Version:    0.6.2
 */