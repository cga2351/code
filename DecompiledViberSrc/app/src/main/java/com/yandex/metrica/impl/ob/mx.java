package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.yandex.metrica.impl.br;
import com.yandex.metrica.impl.br.b;
import com.yandex.metrica.impl.bs;
import com.yandex.metrica.impl.bw;
import java.util.List;
import java.util.Map;

public class mx
  implements ae
{
  private final Context a;
  private final y b;
  private final mv c;
  private volatile ge<mw> d;
  private volatile bs e;
  private mp f;

  public mx(Context paramContext, String paramString, t paramt, mv parammv)
  {
    this.a = paramContext;
    this.b = new v(paramString);
    this.c = parammv;
    this.d = hd.a.a(mw.class).a(this.a);
    mw localmw = (mw)this.d.a();
    b(localmw);
    this.f = new mp(new ls.b(this.a, this.b.b()), localmw, paramt);
  }

  private void c(mw parammw)
  {
    this.f.a(parammw);
    a(parammw);
    d(parammw);
  }

  @Deprecated
  private void d(mw parammw)
  {
    if (!TextUtils.isEmpty(parammw.b))
    {
      Intent localIntent = new Intent("com.yandex.metrica.intent.action.SYNC");
      localIntent.putExtra("CAUSE", "CAUSE_DEVICE_ID");
      localIntent.putExtra("SYNC_TO_PKG", this.b.b());
      localIntent.putExtra("SYNC_DATA", parammw.b);
      localIntent.putExtra("SYNC_DATA_2", parammw.a);
      this.a.sendBroadcast(localIntent);
    }
  }

  private void g()
  {
    try
    {
      this.e = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  bs a()
  {
    try
    {
      if (d())
        if (this.e == null)
          this.e = new bs(this, e());
      for (bs localbs = this.e; ; localbs = null)
        return localbs;
    }
    finally
    {
    }
  }

  protected mw a(br.b paramb, ls paramls, Long paramLong)
  {
    String str1 = ol.a(paramls.F());
    Object localObject = paramb.l();
    String str2 = f().l;
    if (ol.b(ol.a((String)localObject)));
    while (true)
    {
      String str3 = paramb.i();
      if (TextUtils.isEmpty(str3))
        str3 = f().b;
      mw.a locala = new mw.a(paramb.a()).a(System.currentTimeMillis() / 1000L).b(str3).c(paramb.j()).a(oq.a(paramb.k(), f().a)).d(paramb.e()).c(paramb.c()).d(paramls.E()).a(paramb.f()).b(paramb.h()).e(paramb.g()).f(paramb.d()).e(paramb.w()).g((String)localObject).h(str1);
      Map localMap = paramls.F();
      return locala.b(ol.a((String)localObject).equals(localMap)).a(paramb.o()).a(paramb.r()).a(paramb.s()).f(paramb.u()).j(paramb.v()).g(paramb.q()).a(paramb.p()).a(paramb.x()).a(true).b(oq.a(paramLong, 1000L * (System.currentTimeMillis() / 1000L))).c(((ls)this.f.e()).b(paramLong.longValue())).c(false).i(f().r).a();
      if (ol.b(ol.a(str2)))
        localObject = str2;
      else
        localObject = null;
    }
  }

  public void a(br.b paramb, ls paramls, Map<String, List<String>> paramMap)
  {
    try
    {
      Long localLong1 = Long.valueOf(oq.a(br.a(paramMap), 0L));
      Long localLong2 = paramb.t();
      ok.a().a(localLong1.longValue(), localLong2);
      mw localmw = a(paramb, paramls, localLong1);
      new hg().a(this.a, new he(localmw.b, localmw.c), new iv(is.b().a(localmw).a()));
      g();
      c(localmw);
      this.c.a(this.b.b(), localmw);
      b(localmw);
      return;
    }
    finally
    {
    }
  }

  public void a(mq parammq)
  {
    g();
    this.c.a(b().b(), parammq);
  }

  void a(mw parammw)
  {
    this.d.a(parammw);
  }

  public void a(t paramt)
  {
    while (true)
    {
      mw.a locala1;
      int i;
      try
      {
        this.f.a(paramt);
        ls localls = (ls)this.f.e();
        if (localls.I())
        {
          List localList = localls.H();
          boolean bool1 = bw.a(localList);
          locala1 = null;
          i = 0;
          if (bool1)
          {
            boolean bool2 = bw.a(localls.E());
            locala1 = null;
            i = 0;
            if (!bool2)
            {
              locala1 = f().a().d(null);
              i = 1;
            }
          }
          if ((bw.a(localList)) || (bw.a(localList, localls.E())))
            break label147;
          locala2 = f().a().d(localList);
          j = 1;
          if (j != 0)
            c(locala2.a());
        }
        return;
      }
      finally
      {
      }
      label147: mw.a locala2 = locala1;
      int j = i;
    }
  }

  public void a(String paramString)
  {
    try
    {
      c(f().a().i(paramString).a());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean a(long paramLong)
  {
    try
    {
      boolean bool1 = ((ls)this.f.e()).e();
      boolean bool2;
      if (!bool1)
        bool2 = false;
      while (true)
      {
        return bool2;
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = l1 - paramLong;
        if ((l2 > 86400L) || (l2 < 0L))
          bool2 = false;
        else
          bool2 = true;
      }
    }
    finally
    {
    }
  }

  public y b()
  {
    return this.b;
  }

  void b(mw parammw)
  {
    h.a().b(new r(this.b.b(), parammw));
    if (!TextUtils.isEmpty(parammw.a))
      h.a().b(new s(parammw.a, this.b.b()));
    if (parammw.q == null)
    {
      h.a().a(q.class);
      return;
    }
    h.a().b(new q(parammw.q));
  }

  public Context c()
  {
    return this.a;
  }

  public boolean d()
  {
    while (true)
    {
      boolean bool2;
      try
      {
        bool1 = f().C;
        if (!bool1)
        {
          if (!a(oq.a(Long.valueOf(f().s), 0L)))
          {
            bool2 = true;
            String str = ol.a(((ls)this.f.e()).F());
            if ((bool2) || (TextUtils.isEmpty(str)))
              break label102;
            boolean bool3 = str.equals(f().m);
            if (bool3)
              break label102;
            bool1 = true;
          }
        }
        else
          return bool1;
        bool2 = false;
        continue;
      }
      finally
      {
      }
      label102: boolean bool1 = bool2;
    }
  }

  public ls e()
  {
    return (ls)this.f.e();
  }

  public mw f()
  {
    return this.f.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mx
 * JD-Core Version:    0.6.2
 */