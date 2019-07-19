package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.a.a;
import com.yandex.metrica.c;
import com.yandex.metrica.e;
import com.yandex.metrica.e.a;
import com.yandex.metrica.impl.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

public class ky<B extends le>
  implements IReporter
{
  B a;
  final Executor b;
  private lb c = new lb();
  private final Context d;
  private final e e;

  ky(Executor paramExecutor, Context paramContext, String paramString, B paramB)
  {
    this.b = paramExecutor;
    this.d = paramContext;
    this.e = e.a(paramString).a();
    this.a = paramB;
  }

  final c a()
  {
    return this.c.a(this.d).b(this.e);
  }

  public void a(final ReporterConfig paramReporterConfig)
  {
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.b(e.a(paramReporterConfig));
      }
    });
  }

  protected void b(e parame)
  {
    this.c.a(this.d).a(parame);
  }

  public void pauseSession()
  {
    this.a.pauseSession();
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().pauseSession();
      }
    });
  }

  public void reportError(final String paramString, final Throwable paramThrowable)
  {
    this.a.reportError(paramString, paramThrowable);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportError(paramString, paramThrowable);
      }
    });
  }

  public void reportEvent(final String paramString)
  {
    this.a.reportEvent(paramString);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportEvent(paramString);
      }
    });
  }

  public void reportEvent(final String paramString1, final String paramString2)
  {
    this.a.reportEvent(paramString1, paramString2);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportEvent(paramString1, paramString2);
      }
    });
  }

  public void reportEvent(final String paramString, Map<String, Object> paramMap)
  {
    this.a.reportEvent(paramString, paramMap);
    if (paramMap == null);
    for (Object localObject = null; ; localObject = new ArrayList(paramMap.entrySet()))
    {
      this.b.execute(new Runnable()
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
          ky.this.a().reportEvent(paramString, localLinkedHashMap);
        }
      });
      return;
    }
  }

  public void reportRevenue(final Revenue paramRevenue)
  {
    this.a.reportRevenue(paramRevenue);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportRevenue(paramRevenue);
      }
    });
  }

  public void reportUnhandledException(final Throwable paramThrowable)
  {
    this.a.reportUnhandledException(paramThrowable);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportUnhandledException(paramThrowable);
      }
    });
  }

  public void reportUserProfile(final a parama)
  {
    this.a.reportUserProfile(parama);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().reportUserProfile(parama);
      }
    });
  }

  public void resumeSession()
  {
    this.a.resumeSession();
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().resumeSession();
      }
    });
  }

  public void sendEventsBuffer()
  {
    this.a.sendEventsBuffer();
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().sendEventsBuffer();
      }
    });
  }

  public void setStatisticsSending(final boolean paramBoolean)
  {
    this.a.setStatisticsSending(paramBoolean);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().setStatisticsSending(paramBoolean);
      }
    });
  }

  public void setUserProfileID(final String paramString)
  {
    this.a.setUserProfileID(paramString);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        ky.this.a().setUserProfileID(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ky
 * JD-Core Version:    0.6.2
 */