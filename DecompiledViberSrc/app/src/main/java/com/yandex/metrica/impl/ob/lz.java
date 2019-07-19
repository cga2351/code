package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.yandex.metrica.impl.bu;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.w;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class lz
  implements mt
{
  private Handler a;
  private final Context b;
  private final ge<mb> c;
  private ny d;
  private a e;
  private gm f;
  private final b g;
  private final om h;
  private String i;

  public lz(Context paramContext, String paramString, Handler paramHandler)
  {
    this(paramContext, paramString, hd.a.a(mb.class).a(paramContext), new nv(), new a(), new b(), paramHandler, new gm(), new om());
  }

  lz(Context paramContext, String paramString, ge paramge, ny paramny, a parama, b paramb, Handler paramHandler, gm paramgm, om paramom)
  {
    this.b = paramContext;
    this.i = paramString;
    this.c = paramge;
    this.d = paramny;
    this.e = parama;
    this.g = paramb;
    this.a = paramHandler;
    this.f = paramgm;
    this.h = paramom;
  }

  mb a(HttpURLConnection paramHttpURLConnection, mb parammb)
    throws IOException
  {
    switch (paramHttpURLConnection.getResponseCode())
    {
    default:
      return null;
    case 200:
      String str = bu.a(paramHttpURLConnection.getHeaderField("ETag"));
      try
      {
        byte[] arrayOfByte = w.a(paramHttpURLConnection.getInputStream(), 2147483647);
        mb localmb = new mb(this.e.a(this.f.a(arrayOfByte, "af9202nao18gswqp")), str, this.h.a(), true, false);
        return localmb;
      }
      catch (IOException localIOException)
      {
        return null;
      }
    case 304:
    }
    return new mb(parammb.a, parammb.b, this.h.a(), true, false);
  }

  public void a(final ly paramly)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        lz.a(lz.this, paramly, lz.a(lz.this));
      }
    });
  }

  public void a(mq parammq)
  {
  }

  public void a(mw parammw)
  {
    if (parammw != null)
      this.i = parammw.g;
  }

  public boolean b(mw parammw)
  {
    if (this.i == null)
      if (parammw.g == null);
    while (!this.i.equals(parammw.g))
    {
      return true;
      return false;
    }
    return false;
  }

  public static class a
  {
    private final mf a;

    public a()
    {
      this(new mf());
    }

    a(mf parammf)
    {
      this.a = parammf;
    }

    public List<me> a(byte[] paramArrayOfByte)
    {
      ArrayList localArrayList = new ArrayList();
      if (bw.a(paramArrayOfByte))
        return localArrayList;
      try
      {
        List localList = this.a.a(new String(paramArrayOfByte, "UTF-8"));
        return localList;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
      return localArrayList;
    }
  }

  static class b
  {
    public HttpURLConnection a(String paramString1, String paramString2)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString2).openConnection();
        if (!TextUtils.isEmpty(paramString1))
          localHttpURLConnection.setRequestProperty("If-None-Match", paramString1);
        localHttpURLConnection.setInstanceFollowRedirects(true);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.setConnectTimeout(io.a.a);
        localHttpURLConnection.setReadTimeout(io.a.a);
        localHttpURLConnection.connect();
        return localHttpURLConnection;
      }
      catch (Exception localException)
      {
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lz
 * JD-Core Version:    0.6.2
 */