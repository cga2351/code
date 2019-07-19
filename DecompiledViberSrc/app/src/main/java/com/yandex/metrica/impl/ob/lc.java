package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.a.a;
import com.yandex.metrica.g;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public final class lc extends kw<ky<le>>
{
  private ld a = new ld();

  private lc(lb paramlb, Executor paramExecutor, kz<ky<le>> paramkz, ld paramld)
  {
    this(paramlb, paramExecutor, paramkz, paramld, new kv(paramlb));
  }

  lc(lb paramlb, Executor paramExecutor, kz<ky<le>> paramkz, ld paramld, kv paramkv)
  {
    super(paramlb, paramExecutor, paramkz, paramkv);
    this.a = paramld;
  }

  public lc(Executor paramExecutor)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 30	com/yandex/metrica/impl/ob/lb
    //   4: dup
    //   5: invokespecial 31	com/yandex/metrica/impl/ob/lb:<init>	()V
    //   8: aload_1
    //   9: new 33	com/yandex/metrica/impl/ob/lc$1
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 35	com/yandex/metrica/impl/ob/lc$1:<init>	(Ljava/util/concurrent/Executor;)V
    //   17: new 22	com/yandex/metrica/impl/ob/ld
    //   20: dup
    //   21: invokespecial 25	com/yandex/metrica/impl/ob/ld:<init>	()V
    //   24: invokespecial 37	com/yandex/metrica/impl/ob/lc:<init>	(Lcom/yandex/metrica/impl/ob/lb;Ljava/util/concurrent/Executor;Lcom/yandex/metrica/impl/ob/kz;Lcom/yandex/metrica/impl/ob/ld;)V
    //   27: return
  }

  public IReporter a(Context paramContext, String paramString)
  {
    this.a.a(paramContext, paramString);
    return b().a(paramContext, paramString);
  }

  public void a(final Activity paramActivity)
  {
    d().a();
    this.a.resumeSession();
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().b(paramActivity);
      }
    });
  }

  public void a(final Application paramApplication)
  {
    d().a();
    this.a.a(paramApplication);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().a(paramApplication);
      }
    });
  }

  public void a(Context paramContext, ReporterConfig paramReporterConfig)
  {
    this.a.a(paramContext, paramReporterConfig);
    b().a(paramContext, paramReporterConfig.apiKey).a(paramReporterConfig);
  }

  public void a(final Context paramContext, final YandexMetricaConfig paramYandexMetricaConfig)
  {
    this.a.a(paramContext, paramYandexMetricaConfig);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().a(paramContext, g.a(paramYandexMetricaConfig));
      }
    });
    c().b();
  }

  public void a(final Context paramContext, final boolean paramBoolean)
  {
    this.a.a(paramContext);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().a(paramContext, paramBoolean);
      }
    });
  }

  public void a(final Location paramLocation)
  {
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().a(paramLocation);
      }
    });
  }

  public void a(final AppMetricaDeviceIDListener paramAppMetricaDeviceIDListener)
  {
    d().a();
    this.a.a(paramAppMetricaDeviceIDListener);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().f().a(paramAppMetricaDeviceIDListener);
      }
    });
  }

  public void a(final DeferredDeeplinkParametersListener paramDeferredDeeplinkParametersListener)
  {
    d().a();
    this.a.a(paramDeferredDeeplinkParametersListener);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().f().a(paramDeferredDeeplinkParametersListener);
      }
    });
  }

  public void a(final Revenue paramRevenue)
  {
    d().a();
    this.a.reportRevenue(paramRevenue);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportRevenue(paramRevenue);
      }
    });
  }

  public void a(final a parama)
  {
    d().a();
    this.a.reportUserProfile(parama);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportUserProfile(parama);
      }
    });
  }

  public void a(final String paramString)
  {
    d().a();
    this.a.reportEvent(paramString);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportEvent(paramString);
      }
    });
  }

  public void a(final String paramString1, final String paramString2)
  {
    d().a();
    this.a.reportEvent(paramString1, paramString2);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportEvent(paramString1, paramString2);
      }
    });
  }

  public void a(final String paramString, final Throwable paramThrowable)
  {
    d().a();
    this.a.reportError(paramString, paramThrowable);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportError(paramString, paramThrowable);
      }
    });
  }

  public void a(final String paramString, Map<String, Object> paramMap)
  {
    d().a();
    this.a.reportEvent(paramString, paramMap);
    if (paramMap == null);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      a().execute(new Runnable()
      {
        public void run()
        {
          LinkedHashMap localLinkedHashMap = new LinkedHashMap();
          if (this.a != null)
          {
            Iterator localIterator = this.a.iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
            }
          }
          lc.this.c().e().reportEvent(paramString, localLinkedHashMap);
        }
      });
      return;
      localArrayList = new ArrayList(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
        localArrayList.add((Map.Entry)localIterator.next());
    }
  }

  public void a(final Throwable paramThrowable)
  {
    d().a();
    this.a.reportUnhandledException(paramThrowable);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().reportUnhandledException(paramThrowable);
      }
    });
  }

  public void a(final boolean paramBoolean)
  {
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().a(paramBoolean);
      }
    });
  }

  public void b(final Activity paramActivity)
  {
    d().a();
    this.a.pauseSession();
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().c(paramActivity);
      }
    });
  }

  public void b(final Context paramContext, final boolean paramBoolean)
  {
    this.a.b(paramContext);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().b(paramContext, paramBoolean);
      }
    });
  }

  public void b(final String paramString)
  {
    d().a();
    this.a.a(paramString);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().c(paramString);
      }
    });
  }

  public void c(final Activity paramActivity)
  {
    d().a();
    this.a.a(paramActivity);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().a(paramActivity);
      }
    });
  }

  public void c(final String paramString)
  {
    d().a();
    this.a.b(paramString);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().e(paramString);
      }
    });
  }

  public void d(final String paramString)
  {
    d().a();
    this.a.c(paramString);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().f(paramString);
      }
    });
  }

  public void e()
  {
    d().a();
    this.a.sendEventsBuffer();
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().sendEventsBuffer();
      }
    });
  }

  public void e(final String paramString)
  {
    d().a();
    this.a.setUserProfileID(paramString);
    a().execute(new Runnable()
    {
      public void run()
      {
        lc.this.c().e().setUserProfileID(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lc
 * JD-Core Version:    0.6.2
 */