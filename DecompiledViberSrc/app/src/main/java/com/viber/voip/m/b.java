package com.viber.voip.m;

import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static Handler b = av.a(av.e.f);

  private Response a(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2)
    throws IOException
  {
    OkHttpClient.Builder localBuilder;
    Request.Builder localBuilder1;
    FormBody.Builder localBuilder2;
    try
    {
      localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(60000L, TimeUnit.MILLISECONDS).followRedirects(false);
      localBuilder1 = new Request.Builder().url(paramString1);
      if (paramString2 == null)
        break label153;
      localBuilder2 = new FormBody.Builder();
      localBuilder2.add("XMLDOC", paramString2);
      Iterator localIterator1 = paramMap2.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        localBuilder2.add((String)localEntry2.getKey(), (String)localEntry2.getValue());
      }
    }
    catch (Exception localException)
    {
      com.viber.voip.analytics.f.a.a("NetworkConnector.request", localException);
      throw new IOException(localException);
    }
    localBuilder1.post(localBuilder2.build());
    label153: localBuilder1.header("User-Agent", "Android");
    Iterator localIterator2 = paramMap1.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      if (!TextUtils.isEmpty((CharSequence)localEntry1.getKey()))
        localBuilder1.header((String)localEntry1.getKey(), (String)localEntry1.getValue());
    }
    Response localResponse1 = localBuilder.build().newCall(localBuilder1.build()).execute();
    Response localResponse2 = localResponse1;
    String str;
    switch (localResponse2.code())
    {
    default:
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localResponse2.code());
      arrayOfObject[1] = paramString1;
      throw new IOException(String.format("Wrong server response: %d for URL = %s", arrayOfObject));
    case 301:
    case 302:
    case 303:
    case 307:
      str = localResponse2.header("Location");
      if (paramInt < 10)
        localResponse2 = a(str, paramString2, paramInt + 1, paramMap1, paramMap2);
    case 200:
    case 203:
      return localResponse2;
      throw new IOException("Max redirect count reached: url=" + paramString1 + ", redirectUrl=" + str);
    case 304:
    }
    throw new IOException("Server file hasn't been modified since last update");
  }

  public a a(String paramString1, String paramString2, c paramc)
    throws IOException
  {
    return a(paramString1, paramString2, new HashMap(), new HashMap(), paramc);
  }

  public a a(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, c paramc)
    throws IOException
  {
    a locala = new a(paramString1, paramString2, paramc, paramMap1, paramMap2);
    b.post(locala);
    return locala;
  }

  public class a extends com.viber.voip.util.a
    implements Runnable
  {
    private final String b;
    private final String c;
    private final Map<String, String> d;
    private int e;
    private c f;
    private Map<String, String> g;

    public a(String paramc, c paramMap1, Map<String, String> paramMap2, Map<String, String> arg5)
    {
      this.f = paramMap2;
      if (paramc == null)
        throw new IllegalArgumentException("url parameter can not be null");
      this.b = paramc;
      this.c = paramMap1;
      Object localObject1;
      this.d = localObject1;
      Object localObject2;
      this.g = localObject2;
    }

    public void a()
    {
      try
      {
        Response localResponse = b.a(b.this, this.b, this.c, 0, this.d, this.g);
        this.f.a(localResponse.body());
        this.e = 1;
        return;
      }
      catch (IOException localIOException)
      {
        this.e = 2;
        this.f.a(this.e, localIOException.getMessage());
      }
    }

    public void b()
    {
      b.a().removeCallbacks(this);
      this.e = 3;
      this.f.a(this.e, "Data receive interrupted");
    }

    public void run()
    {
      a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.m.b
 * JD-Core Version:    0.6.2
 */