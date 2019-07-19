package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bn;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class io
{
  private final String a;

  public io(String paramString)
  {
    this.a = paramString;
  }

  public HttpURLConnection a()
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
    localHttpURLConnection.setConnectTimeout(a.a);
    localHttpURLConnection.setReadTimeout(a.a);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setRequestProperty("Accept", "application/json");
    localHttpURLConnection.setRequestProperty("User-Agent", bn.a("com.yandex.mobile.metrica.sdk"));
    return localHttpURLConnection;
  }

  public abstract boolean b();

  public static final class a
  {
    public static final int a = (int)TimeUnit.SECONDS.toMillis(30L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.io
 * JD-Core Version:    0.6.2
 */