package com.shopchat.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shopchat.library.R.string;
import com.shopchat.library.RootView;
import com.shopchat.library.RootView.a;
import com.shopchat.library.util.BuildConfigUtils;
import com.shopchat.library.util.b;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class a
{
  private static b b = RootView.a;
  private static a c = null;
  public String a = null;
  private Context d;
  private OkHttpClient e;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k;

  private a(Context paramContext, String paramString, RootView.a parama)
  {
    this.d = paramContext;
    this.k = paramString;
    if (this.f == null)
      this.f = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "SHOPCHAT_APP_TYPE_HEADER_VALUE"));
    if (parama != null)
      switch (2.a[parama.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
    while (true)
    {
      b localb1 = b;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.a;
      localb1.a("BASE URL: [?]", arrayOfObject1);
      if (this.h == null)
        this.h = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "SHOPCHAT_FRAMEWORK_VERSION_HEADER_VALUE"));
      if (this.g == null)
        this.g = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "SHOPCHAT_CONTAINER_VERSION_HEADER_VALUE"));
      b localb2 = b;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.f;
      localb2.a("_APP_TYPE_HEADER_VALUE: ?", arrayOfObject2);
      b localb3 = b;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.h;
      localb3.a("_FWORK_VER_HEADER_VALUE: ?", arrayOfObject3);
      b localb4 = b;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = this.g;
      localb4.a("_CTNR_VER_HEADER_VALUE: ?", arrayOfObject4);
      this.i = paramContext.getResources().getString(R.string.uri_brands);
      this.j = paramContext.getResources().getString(R.string.uri_recommended_products);
      this.e = a(paramString);
      return;
      this.a = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "SHOPCHAT_API_URL_BASE"));
      continue;
      this.a = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "EMBEDDED_SHOPCHAT_API_URL_BASE"));
      continue;
      if (this.a == null)
        if (this.f.equalsIgnoreCase("SHOPCHAT_EMBEDDED_ANDROID"))
          this.a = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "EMBEDDED_SHOPCHAT_API_URL_BASE"));
        else
          this.a = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "SHOPCHAT_API_URL_BASE"));
    }
  }

  public static a a(Context paramContext, String paramString, RootView.a parama)
  {
    if ((c == null) || (!c.k.equals(paramString)) || (parama != null))
      c = new a(paramContext, paramString, parama);
    return c;
  }

  private OkHttpClient a(String paramString)
  {
    Cache localCache = new Cache(new File(this.d.getCacheDir(), "responses"), 10485760);
    return new OkHttpClient.Builder().addInterceptor(b(paramString)).cache(localCache).connectTimeout(25L, TimeUnit.SECONDS).writeTimeout(25L, TimeUnit.SECONDS).readTimeout(25L, TimeUnit.SECONDS).build();
  }

  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }

  private Interceptor b(final String paramString)
  {
    return new Interceptor()
    {
      public Response intercept(Interceptor.Chain paramAnonymousChain)
        throws IOException
      {
        Request localRequest;
        if (a.a(a.a(a.this)))
          if (paramString.toUpperCase().equals("US"))
            localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, max-age=" + 60).addHeader("X-App-Type", a.d(a.this)).addHeader("X-Framework-Version", a.c(a.this)).addHeader("X-Container-Version", a.b(a.this)).build();
        while (true)
        {
          return paramAnonymousChain.proceed(localRequest);
          localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, max-age=" + 60).addHeader("X-App-Type", a.d(a.this)).addHeader("X-Framework-Version", a.c(a.this)).addHeader("X-Container-Version", a.b(a.this)).addHeader("X-Country-Code", paramString).build();
          continue;
          if (paramString.toUpperCase().equals("US"))
            localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 2419200).cacheControl(CacheControl.FORCE_CACHE).addHeader("X-App-Type", a.d(a.this)).addHeader("X-Framework-Version", a.c(a.this)).addHeader("X-Container-Version", a.b(a.this)).build();
          else
            localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 2419200).cacheControl(CacheControl.FORCE_CACHE).addHeader("X-App-Type", a.d(a.this)).addHeader("X-Framework-Version", a.c(a.this)).addHeader("X-Container-Version", a.b(a.this)).addHeader("X-Country-Code", paramString).build();
        }
      }
    };
  }

  public void a(String paramString, Callback paramCallback)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(paramString);
    Request localRequest = localBuilder.build();
    this.e.newCall(localRequest).enqueue(paramCallback);
  }

  public void a(Callback paramCallback)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(this.a + this.i);
    Request localRequest = localBuilder.build();
    this.e.newCall(localRequest).enqueue(paramCallback);
  }

  public void b(Callback paramCallback)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(this.a + this.j);
    Request localRequest = localBuilder.build();
    this.e.newCall(localRequest).enqueue(paramCallback);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.b.a
 * JD-Core Version:    0.6.2
 */