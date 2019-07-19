package com.viber.voip.ads.b.a.a;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.util.Pair;
import com.adsnative.ads.aa.a;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.bg;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  implements l<com.viber.voip.ads.b.a.a.a.a>
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private final com.viber.common.b.b b;
  private final Handler c;

  public a(com.viber.common.b.b paramb, Handler paramHandler)
  {
    this.b = paramb;
    this.c = paramHandler;
    com.adsnative.a.a(bg.a());
  }

  private PublisherAdRequest.Builder a(com.viber.voip.ads.b.a.a.a.a parama)
  {
    PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
    if (parama.e != null)
      localBuilder.setLocation(parama.e);
    if (parama.f != null)
    {
      Iterator localIterator = parama.f.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.addCustomTargeting((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBuilder;
  }

  private aa.a b(com.viber.voip.ads.b.a.a.a.a parama)
  {
    aa.a locala = new aa.a();
    locala.a(this.b.d());
    if (parama.e != null)
      locala.a(parama.e);
    if (parama.g != null)
    {
      Iterator localIterator = parama.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ((String)localEntry.getValue());
        locala.a(str, arrayOfString);
      }
    }
    return locala;
  }

  private void e(com.viber.voip.ads.b.a.a.a.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
    Activity localActivity = parama.a;
    String str1 = parama.d;
    String str2 = parama.c;
    com.viber.voip.ads.polymorph.dfp.a locala = new com.viber.voip.ads.polymorph.dfp.a(localActivity, str2, new AdLoader.Builder(localActivity, str1).withNativeAdOptions(new NativeAdOptions.Builder().setAdChoicesPlacement(parama.h).build()));
    locala.a(new a(paramc, paramc, str1, str2, this.c));
    locala.a();
    locala.a(a(parama));
    locala.a(b(parama));
    locala.b();
  }

  private void f(com.viber.voip.ads.b.a.a.a.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
  }

  private void g(com.viber.voip.ads.b.a.a.a.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
  }

  public int a()
  {
    return 5;
  }

  public void a(com.viber.voip.ads.b.a.a.a.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
    switch (parama.b)
    {
    default:
      return;
    case 0:
      this.c.post(new b(this, parama, paramc));
      return;
    case 1:
      this.c.post(new c(this, parama, paramc));
      return;
    case 2:
    }
    this.c.post(new d(this, parama, paramc));
  }

  private static class a
    implements com.viber.voip.ads.polymorph.dfp.a.a
  {
    private final com.viber.voip.ads.b.b.a.d a;
    private final com.viber.voip.ads.b.b.a.a b;
    private final String c;
    private final String d;
    private final Handler e;

    a(com.viber.voip.ads.b.b.a.d paramd, com.viber.voip.ads.b.b.a.a parama, String paramString1, String paramString2, Handler paramHandler)
    {
      this.a = paramd;
      this.b = parama;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramHandler;
    }

    private void b(Pair<Integer, String> paramPair)
    {
      this.e.post(new g(this, paramPair));
    }

    private boolean k()
    {
      return false;
    }

    public void a()
    {
    }

    public void a(int paramInt)
    {
      b(com.viber.voip.util.k.a.a(paramInt));
    }

    public void a(NativeAppInstallAd paramNativeAppInstallAd)
    {
      if (k())
        return;
      String str = this.d;
      this.e.post(new f(this, paramNativeAppInstallAd, str));
    }

    public void a(NativeContentAd paramNativeContentAd)
    {
      if (k())
        return;
      String str = this.d;
      this.e.post(new e(this, paramNativeContentAd, str));
    }

    public void b()
    {
      this.e.post(new h(this));
    }

    public void c()
    {
    }

    public void d()
    {
      this.e.post(new i(this));
    }

    public void e()
    {
      this.e.post(new j(this));
    }

    public void f()
    {
      this.e.post(new k(this));
    }
  }

  public static enum b
  {
    private final int c;

    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }

    private b(int paramInt)
    {
      this.c = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.a
 * JD-Core Version:    0.6.2
 */