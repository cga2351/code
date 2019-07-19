package com.shopchat.library.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.shopchat.library.RootView;
import com.shopchat.library.b.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d
{
  private static b a = RootView.a;
  private static volatile d b;
  private static Request.Builder c;
  private static Context d;
  private static OkHttpClient e;

  private d(Context paramContext, Request.Builder paramBuilder)
  {
    d = paramContext;
    c = paramBuilder;
  }

  public static d a(Context paramContext)
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new d(paramContext, new Request.Builder());
      return b;
    }
    finally
    {
    }
  }

  private static OkHttpClient b(Context paramContext)
  {
    if (e == null)
    {
      Cache localCache = new Cache(new File(paramContext.getCacheDir(), "responses"), 10485760);
      e = new OkHttpClient.Builder().addInterceptor(c(paramContext)).cache(localCache).build();
    }
    return e;
  }

  private static Interceptor c(Context paramContext)
  {
    return new Interceptor()
    {
      public Response intercept(Interceptor.Chain paramAnonymousChain)
        throws IOException
      {
        if (a.a(this.a));
        for (Request localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, max-age=" + 60).build(); ; localRequest = paramAnonymousChain.request().newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 2419200).cacheControl(CacheControl.FORCE_CACHE).build())
          return paramAnonymousChain.proceed(localRequest);
      }
    };
  }

  public b a(String paramString, ImageView paramImageView, int paramInt, a parama)
  {
    paramImageView.setImageDrawable(null);
    c.url(paramString);
    b localb = new b(paramImageView, paramString);
    localb.a(paramInt);
    localb.a(parama);
    Request localRequest = c.build();
    b(d).newCall(localRequest).enqueue(localb.a());
    return localb;
  }

  public b a(String paramString, ImageView paramImageView, a parama)
  {
    paramImageView.setImageDrawable(null);
    c.url(paramString);
    b localb = new b(paramImageView, paramString);
    localb.a(parama);
    Request localRequest = c.build();
    b(d).newCall(localRequest).enqueue(localb.a());
    return localb;
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static class b
  {
    private Bitmap a;
    private ImageView b;
    private d.a c;
    private String d;
    private int e = 1;
    private Callback f = new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        b localb1 = d.a();
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramAnonymousIOException.getMessage();
        localb1.a("ImageLoader callback failed: ?", arrayOfObject1);
        b localb2 = d.a();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramAnonymousCall.request().url().url().toString();
        localb2.a("Failed url: ?", arrayOfObject2);
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            if (d.b.a(d.b.this) != null)
              d.b.a(d.b.this).a();
          }
        });
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if (paramAnonymousResponse.cacheResponse() != null)
        {
          b localb2 = d.a();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = d.b.b(d.b.this);
          localb2.a("response cached: ? ", arrayOfObject2);
        }
        b localb1 = d.a();
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(paramAnonymousResponse.body().contentLength());
        localb1.a("Image Content Length: ?", arrayOfObject1);
        InputStream localInputStream = paramAnonymousResponse.body().byteStream();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = d.b.c(d.b.this);
        d.b.a(d.b.this, BitmapFactory.decodeStream(localInputStream, null, localOptions));
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            d.b.e(d.b.this).setImageBitmap(d.b.d(d.b.this));
            if (d.b.a(d.b.this) != null)
              d.b.a(d.b.this).a();
          }
        });
      }
    };

    public b(ImageView paramImageView, String paramString)
    {
      this.b = paramImageView;
      this.d = paramString;
    }

    public Callback a()
    {
      return this.f;
    }

    public void a(int paramInt)
    {
      if (paramInt > 1)
        this.e = paramInt;
    }

    public void a(d.a parama)
    {
      this.c = parama;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.util.d
 * JD-Core Version:    0.6.2
 */