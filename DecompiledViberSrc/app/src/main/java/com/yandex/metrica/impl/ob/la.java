package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.g;
import com.yandex.metrica.g.a;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.ba;
import com.yandex.metrica.impl.bn;
import com.yandex.metrica.impl.bz;
import com.yandex.metrica.impl.interact.CellularNetworkInfo;
import com.yandex.metrica.impl.interact.DeviceInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class la
{
  private final lb a;
  private final Executor b;
  private final kv c;
  private final px<Context> d;
  private final px<String> e;
  private final a f;

  public la(Executor paramExecutor)
  {
    this(paramExecutor, new lb());
  }

  public la(Executor paramExecutor, lb paramlb)
  {
    this(paramExecutor, paramlb, new kv(paramlb), new pt(new ps("Context")), new pt(new ps("Event name")), new a());
  }

  public la(Executor paramExecutor, lb paramlb, kv paramkv, px<Context> parampx, px<String> parampx1, a parama)
  {
    this.a = paramlb;
    this.b = paramExecutor;
    this.c = paramkv;
    this.d = parampx;
    this.e = parampx1;
    this.f = parama;
  }

  public YandexMetricaConfig a(YandexMetricaConfig paramYandexMetricaConfig, String paramString)
  {
    return g.b(paramYandexMetricaConfig).a(Collections.singletonList(paramString)).b();
  }

  public YandexMetricaConfig a(YandexMetricaConfig paramYandexMetricaConfig, List<String> paramList)
  {
    return g.b(paramYandexMetricaConfig).a(paramList).b();
  }

  public DeviceInfo a(Context paramContext)
  {
    this.d.a(paramContext);
    return DeviceInfo.getInstance(paramContext);
  }

  public String a(int paramInt)
  {
    return ba.a(paramInt);
  }

  public String a(String paramString)
  {
    return bn.a(paramString);
  }

  public void a(final int paramInt, final String paramString1, final String paramString2, final Map<String, String> paramMap)
  {
    this.c.a();
    this.e.a(paramString1);
    this.b.execute(new oi()
    {
      public void a()
        throws Exception
      {
        la.a(la.this).e().a(paramInt, paramString1, paramString2, paramMap);
      }
    });
  }

  public void a(final Context paramContext, final IIdentifierCallback paramIIdentifierCallback)
  {
    this.d.a(paramContext);
    this.b.execute(new oi()
    {
      public void a()
        throws Exception
      {
        la.a(la.this).a(paramContext).a(paramIIdentifierCallback);
      }
    });
  }

  @Deprecated
  public void a(final IIdentifierCallback paramIIdentifierCallback)
  {
    this.b.execute(new oi()
    {
      public void a()
        throws Exception
      {
        if (la.a(la.this).d())
          la.a(la.this).a().a(paramIIdentifierCallback);
      }
    });
  }

  public boolean a()
  {
    return this.a.c();
  }

  public String b(Context paramContext)
  {
    this.d.a(paramContext);
    return new CellularNetworkInfo(paramContext).getCelluralInfo();
  }

  public Future<String> b()
  {
    return ((ExecutorService)this.b).submit(new oh()
    {
      public String a()
      {
        return GoogleAdvertisingIdGetter.b().c();
      }
    });
  }

  public Integer c(Context paramContext)
  {
    this.d.a(paramContext);
    return aw.c(paramContext);
  }

  public Future<Boolean> c()
  {
    return ((ExecutorService)this.b).submit(new oh()
    {
      public Boolean a()
      {
        return GoogleAdvertisingIdGetter.b().d();
      }
    });
  }

  @Deprecated
  public String d()
  {
    boolean bool = this.a.d();
    String str = null;
    if (bool)
      str = this.a.a().k();
    return str;
  }

  public String d(Context paramContext)
  {
    this.d.a(paramContext);
    return this.a.a(paramContext).k();
  }

  public String e(Context paramContext)
  {
    this.d.a(paramContext);
    return this.a.a(paramContext).j();
  }

  public void e()
  {
    this.c.a();
    this.b.execute(new oi()
    {
      public void a()
        throws Exception
      {
        la.a(la.this).e().sendEventsBuffer();
      }
    });
  }

  public String f(Context paramContext)
  {
    this.d.a(paramContext);
    return paramContext.getPackageName();
  }

  public Location g(Context paramContext)
  {
    this.d.a(paramContext);
    return this.f.a(paramContext, (LocationManager)paramContext.getSystemService("location")).a();
  }

  static class a
  {
    public hs a(Context paramContext, LocationManager paramLocationManager)
    {
      return new hs(paramContext, paramLocationManager, new iv(new ir()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.la
 * JD-Core Version:    0.6.2
 */