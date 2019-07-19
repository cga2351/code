package com.yandex.metrica.impl;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Pair;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.ko.a;
import com.yandex.metrica.impl.ob.lj;
import com.yandex.metrica.impl.ob.ms;
import com.yandex.metrica.impl.ob.nz;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.og;
import com.yandex.metrica.impl.ob.u;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class bj
  implements x
{
  private final Context a;
  private ah b;
  private final NativeCrashesHelper c;
  private final ExecutorService d;
  private ad e;
  private final g f;
  private ms g;
  private final bk h;

  bj(u paramu, ExecutorService paramExecutorService, Context paramContext, Handler paramHandler, k paramk)
  {
    this.b = new ah(paramContext, paramHandler);
    this.d = paramExecutorService;
    this.a = paramContext;
    this.c = new NativeCrashesHelper(paramContext);
    this.f = new g(paramu, paramk);
    this.h = new bk(this);
  }

  private Future<Void> a(bk.d paramd)
  {
    paramd.a().a(this.g);
    return this.h.a(paramd);
  }

  private static i c(i parami, bg parambg)
  {
    if (parami.e() == s.a.e.a())
      parami.f(parambg.f());
    return parami;
  }

  private static of c(bg parambg)
  {
    return og.a(parambg.b().f());
  }

  public ah a()
  {
    return this.b;
  }

  public Future<Void> a(i parami, final bg parambg, final Map<String, Object> paramMap)
  {
    this.b.c();
    bk.d locald = new bk.d(parami, parambg);
    if (!bw.a(paramMap))
      locald.a(new bk.c()
      {
        public i a(i paramAnonymousi)
        {
          return bj.b(paramAnonymousi.c(nz.a(paramMap)), parambg);
        }
      });
    return a(locald);
  }

  public void a(IMetricaService paramIMetricaService, i parami, bg parambg)
    throws RemoteException
  {
    if (this.c.a())
      this.c.a(this, this.d);
    paramIMetricaService.reportData(parami.a(parambg.c()));
    if ((this.e == null) || (this.e.e()))
      this.b.b();
  }

  void a(ad paramad)
  {
    this.e = paramad;
  }

  public void a(bg parambg)
  {
    a(s.a(parambg.g(), c(parambg)), parambg);
  }

  void a(final bl parambl, bg parambg)
  {
    a(new bk.d(new e(c(parambg)).a(s.a.l.a()), parambg).a(new bk.c()
    {
      public i a(i paramAnonymousi)
      {
        Pair localPair = parambl.a();
        return paramAnonymousi.c(new String(Base64.encode((byte[])localPair.first, 0))).c(((Integer)localPair.second).intValue());
      }
    }));
  }

  void a(i parami, bg parambg)
  {
    a(c(parami, parambg), parambg, null);
  }

  void a(final ko.a parama, bg parambg)
  {
    a(new bk.d(e.a(), parambg).a(new bk.c()
    {
      public i a(i paramAnonymousi)
      {
        return paramAnonymousi.c(new String(Base64.encode(com.yandex.metrica.impl.ob.e.a(parama), 0)));
      }
    }));
  }

  public void a(lj paramlj)
  {
    a(s.a(paramlj, og.a()), this.f);
  }

  void a(ms paramms)
  {
    this.g = paramms;
    this.f.b(paramms);
  }

  void a(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    int i = 1;
    int j;
    if (paramBoolean1 != null)
    {
      j = i;
      if (j != 0)
        this.f.b().a(paramBoolean1.booleanValue());
      if (paramBoolean2 == null)
        break label81;
    }
    while (true)
    {
      if (i != 0)
        this.f.b().g(paramBoolean2.booleanValue());
      a(new i().a(s.a.I.a()), this.f);
      return;
      j = 0;
      break;
      label81: i = 0;
    }
  }

  void a(String paramString)
  {
    a(paramString, this.e.d());
  }

  void a(String paramString, bg parambg)
  {
    a(s.a(s.a.n, paramString, c(parambg)), parambg);
  }

  public void a(String paramString1, String paramString2, bg parambg)
  {
    a(new bk.d(new i().a(s.a.x.a()).a(paramString1, paramString2), parambg));
  }

  void a(Throwable paramThrowable, bg parambg)
  {
    this.b.c();
    String str1 = bw.a(null, paramThrowable);
    String str2;
    if (paramThrowable == null)
      str2 = "";
    while (true)
    {
      i locali = s.d(str2, str1, c(parambg));
      locali.f(parambg.f());
      try
      {
        a(new bk.d(locali, parambg).a(true)).get();
        return;
        str2 = paramThrowable.getClass().getName();
      }
      catch (ExecutionException localExecutionException)
      {
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }

  public void a(List<String> paramList)
  {
    this.f.h().a(paramList);
  }

  public void a(Map<String, String> paramMap)
  {
    this.f.h().a(paramMap);
  }

  void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public Context b()
  {
    return this.a;
  }

  public void b(bg parambg)
  {
    a(new bk.d(new i().a(s.a.y.a()), parambg));
  }

  public void b(String paramString)
  {
    a(s.d(paramString, og.a()), this.f);
  }

  void b(final String paramString, bg parambg)
  {
    a(new bk.d(new e(c(parambg)).a(s.a.k.a()).d(paramString), parambg).a(new bk.c()
    {
      public i a(i paramAnonymousi)
      {
        return paramAnonymousi.c(paramString);
      }
    }));
  }

  public void c()
  {
    this.b.f();
  }

  public void c(String paramString)
  {
    this.f.h().a(paramString);
  }

  public void d()
  {
    this.b.g();
  }

  public void e()
  {
    a(s.a(s.a.o, og.a()), this.f);
  }

  void f()
  {
    this.b.c();
  }

  void g()
  {
    this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bj
 * JD-Core Version:    0.6.2
 */