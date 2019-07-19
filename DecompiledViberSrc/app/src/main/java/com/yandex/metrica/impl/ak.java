package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.MetricaService.c;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ob.av;
import com.yandex.metrica.impl.ob.aw;
import com.yandex.metrica.impl.ob.ax;
import com.yandex.metrica.impl.ob.en;
import com.yandex.metrica.impl.ob.fj;
import com.yandex.metrica.impl.ob.fy;
import com.yandex.metrica.impl.ob.ge;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.hd;
import com.yandex.metrica.impl.ob.hd.a;
import com.yandex.metrica.impl.ob.hw;
import com.yandex.metrica.impl.ob.ij;
import com.yandex.metrica.impl.ob.in;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.ku;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.mk;
import com.yandex.metrica.impl.ob.mk.b;
import com.yandex.metrica.impl.ob.mn;
import com.yandex.metrica.impl.ob.mw;
import com.yandex.metrica.impl.ob.np;
import com.yandex.metrica.impl.ob.od;
import com.yandex.metrica.impl.ob.ok;
import com.yandex.metrica.impl.ob.q;
import com.yandex.metrica.impl.ob.r;
import com.yandex.metrica.impl.ob.t;
import com.yandex.metrica.impl.ob.u;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ak
  implements ai
{
  public static final Executor a = new in();
  private static final ExecutorService g = Executors.newSingleThreadExecutor(new od("YMM-MSTE"));
  private mw b;
  private final Context c;
  private final MetricaService.c d;
  private final mk.b e;
  private mk f;
  private Thread h;
  private aw i;
  private final al j;
  private ij k;

  public ak(Context paramContext, MetricaService.c paramc)
  {
    this(paramContext, paramc, new aw(paramContext), new al(), new mk.b());
  }

  ak(Context paramContext, MetricaService.c paramc, aw paramaw, al paramal, mk.b paramb)
  {
    this.c = paramContext;
    this.d = paramc;
    this.i = paramaw;
    this.j = paramal;
    this.e = paramb;
    this.k = new ij(hw.a(paramContext), np.a(paramContext), bx.a(paramContext), new fy(fj.a(paramContext).c()));
    this.j.a(new al.b()
    {
      public void a()
      {
        ak.a(ak.this, ak.b(ak.this));
        ak.c(ak.this);
      }
    });
    this.j.b(new al.b()
    {
      public void a()
      {
        ak.a(ak.this, ak.b(ak.this));
        ak.d(ak.this);
      }
    });
    this.j.c(new al.b()
    {
      public void a()
      {
        ak.a(ak.this, ak.b(ak.this));
        ak.e(ak.this);
        ak.a(ak.this, ak.f(ak.this).a(ak.a(ak.this)));
      }
    });
    this.j.d(new al.b()
    {
      public void a()
      {
        ak.g(ak.this);
      }
    });
    this.j.e(new al.b()
    {
      public void a()
      {
        ak.h(ak.this);
      }
    });
  }

  private void a(i parami, Bundle paramBundle)
  {
    if (!parami.p())
    {
      a locala = new a(this.c, parami, paramBundle);
      g.execute(locala);
    }
  }

  private void b(Intent paramIntent, int paramInt)
  {
    if (paramIntent != null)
    {
      paramIntent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
      e(paramIntent);
    }
    this.d.a(paramInt);
  }

  private void c()
  {
    if (this.f != null)
      this.f.a();
  }

  private void c(mw parammw)
  {
    this.k.a(parammw, this.j.c());
  }

  private void d()
  {
    this.k.a(this);
  }

  private void d(mw parammw)
  {
    if (parammw != null)
    {
      this.h = od.a("YMM-CSL", new Runnable()
      {
        public void run()
        {
          this.a.a();
        }
      });
      this.h.start();
    }
  }

  private static boolean d(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getData() == null);
  }

  private void e(Intent paramIntent)
  {
    if (d(paramIntent));
    t localt;
    i locali;
    do
    {
      do
      {
        return;
        localt = new t(paramIntent.getExtras());
      }
      while (a(localt));
      locali = i.b(paramIntent.getExtras());
    }
    while ((locali.o() | locali.p()));
    try
    {
      av localav = av.a(localt);
      this.i.a(localav, localt).a(locali, localt);
      this.i.a(localav.c(), localav.d().intValue(), localav.e());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a()
  {
    new bo(this.c).a(this.c);
    ok.a().a(this.c);
    GoogleAdvertisingIdGetter.a().b(this.c);
    l locall = l.a(new k()
    {
      public void a(r paramAnonymousr)
      {
        ak.this.a(paramAnonymousr.b);
      }
    }).a(new com.yandex.metrica.impl.ob.i()
    {
      public boolean a(r paramAnonymousr)
      {
        return !ak.a(ak.this).getPackageName().equals(paramAnonymousr.a);
      }
    }).a();
    h.a().a(this, r.class, locall);
    this.b = ((mw)hd.a.a(mw.class).a(this.c).a());
    if (this.b != null)
    {
      b(this.b);
      d(this.b);
    }
    c(this.b);
    h.a().a(this, r.class, l.a(new k()
    {
      public void a(r paramAnonymousr)
      {
        ak.b(ak.this, paramAnonymousr.b);
        ak.a(ak.this, paramAnonymousr.b);
      }
    }).a(new com.yandex.metrica.impl.ob.i()
    {
      public boolean a(r paramAnonymousr)
      {
        return !ak.a(ak.this).getPackageName().equals(paramAnonymousr.a);
      }
    }).a());
    v.a().e().a();
    v.a().h().a();
  }

  public void a(Intent paramIntent)
  {
    this.j.a(paramIntent);
  }

  public void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }

  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    b(paramIntent, paramInt2);
  }

  void a(Uri paramUri, String paramString)
  {
    if ((paramUri != null) && (paramUri.getPath().equals("/client")))
    {
      int m = Integer.parseInt(paramUri.getQueryParameter("pid"));
      String str = paramUri.getQueryParameter("psid");
      this.i.a(paramString, m, str);
    }
    if (this.i.a() <= 0)
      c();
  }

  public void a(Bundle paramBundle)
    throws RemoteException
  {
    paramBundle.setClassLoader(CounterConfiguration.class.getClassLoader());
    a(i.b(paramBundle), paramBundle);
  }

  public void a(mw parammw)
  {
    this.b = parammw;
    d(parammw);
    c(parammw);
    v.a().a(parammw);
  }

  public void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    paramBundle.setClassLoader(CounterConfiguration.class.getClassLoader());
    a(new i(paramString2, paramString1, paramInt), paramBundle);
  }

  boolean a(t paramt)
  {
    return (paramt == null) || (paramt.a() == null) || (!this.c.getPackageName().equals(paramt.a().h())) || (paramt.a().g() != 72);
  }

  public void b()
  {
    d();
    h.a().a(this);
  }

  public void b(Intent paramIntent)
  {
    this.j.b(paramIntent);
  }

  void b(mw parammw)
  {
    mn localmn = parammw.q;
    if (localmn == null)
    {
      h.a().a(q.class);
      return;
    }
    h.a().b(new q(localmn));
  }

  public void c(Intent paramIntent)
  {
    this.j.c(paramIntent);
    String str1;
    Uri localUri;
    if (paramIntent != null)
    {
      str1 = paramIntent.getAction();
      localUri = paramIntent.getData();
      if (localUri != null)
        break label47;
    }
    label47: for (String str2 = null; ; str2 = localUri.getEncodedAuthority())
    {
      if ("com.yandex.metrica.IMetricaService".equals(str1))
        a(localUri, str2);
      return;
    }
  }

  final class a
    implements Runnable
  {
    private final i b;
    private final Bundle c;
    private final Context d;

    a(Context parami, i paramBundle, Bundle arg4)
    {
      this.d = parami.getApplicationContext();
      this.b = paramBundle;
      Object localObject;
      this.c = localObject;
    }

    public void run()
    {
      t localt = new t(this.c);
      if (ak.this.a(localt));
      av localav;
      do
      {
        return;
        localav = av.a(localt);
      }
      while (localav == null);
      ak.i(ak.this).a(localav, localt).a(this.b, localt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ak
 * JD-Core Version:    0.6.2
 */