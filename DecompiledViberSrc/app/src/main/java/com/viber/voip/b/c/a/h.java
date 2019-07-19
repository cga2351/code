package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.sqlite.database.sqlite.SQLiteDatabase;

public class h
{
  private static final Logger a = ViberEnv.getLogger();
  private static h b;
  private static volatile long c = 0L;
  private final Context d;
  private Thread e;
  private volatile boolean f;

  public h(Context paramContext)
  {
    this.d = paramContext;
    d.c(new d.b()
    {
      public void onAppStopped()
      {
        com.viber.voip.util.i.c(this);
      }

      public void onBackground()
      {
        h.a(h.this);
      }

      public void onForeground()
      {
        h.b(h.this);
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        com.viber.voip.util.i.a(this, paramAnonymousBoolean);
      }
    });
    d.a(new d.d()
    {
      public void a()
      {
        h.c(h.this);
      }

      public void a(int paramAnonymousInt)
      {
      }
    }
    , av.e.b.a());
  }

  public static h a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (b == null);
    try
    {
      if (b == null)
        b = new h(localContext);
      return b;
    }
    finally
    {
    }
  }

  private void b()
  {
    this.f = false;
    ViberApplication.getInstance().getMessagesManager().c().c();
  }

  private void c()
  {
    this.f = true;
    e();
  }

  private void d()
  {
    if (!d.a())
    {
      long l = System.currentTimeMillis();
      if ((c != 0L) && (l - c < 14400000L))
        return;
    }
    com.viber.voip.messages.controller.manager.k localk = ViberApplication.getInstance().getMessagesManager().a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new n(this.d, new com.viber.voip.stickers.b.a()));
    localArrayList.add(new p(this.d));
    localArrayList.add(new a(this.d, localk));
    localArrayList.add(new s(this.d));
    localArrayList.add(new l(this.d));
    localArrayList.add(new m(this.d));
    localArrayList.add(new k(this.d));
    localArrayList.add(new q(this.d));
    localArrayList.add(new r(this.d));
    localArrayList.add(new j(this.d));
    localArrayList.add(new b(this.d));
    localArrayList.add(new o(this.d));
    localArrayList.add(new i(this.d));
    if (d.ad.b.d())
      localArrayList.add(new e(this.d));
    this.e = new a(localArrayList);
    this.e.start();
  }

  private void e()
  {
    try
    {
      if (this.e != null)
      {
        this.e.interrupt();
        this.e = null;
      }
      return;
    }
    finally
    {
    }
  }

  public void a()
  {
  }

  private class a extends Thread
  {
    private final List<g> b;

    public a()
    {
      super();
      Object localObject;
      this.b = localObject;
      setPriority(1);
      setDaemon(true);
    }

    public void interrupt()
    {
      h.a(h.this, true);
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
          ((g)localIterator.next()).d();
      }
      super.interrupt();
    }

    public void run()
    {
      super.run();
      if (this.b == null)
        return;
      Iterator localIterator = this.b.iterator();
      while (true)
      {
        g localg;
        if (localIterator.hasNext())
        {
          localg = (g)localIterator.next();
          if ((!interrupted()) && (!h.d(h.this)));
        }
        else
        {
          if ((!interrupted()) && (!h.d(h.this)))
          {
            h.a(System.currentTimeMillis());
            SQLiteDatabase.releaseMemory();
          }
          h.a(h.this, null);
          return;
        }
        localg.c();
        if ((!interrupted()) && (!h.d(h.this)) && ((localg instanceof e)) && (!localg.e()))
          d.ad.b.a(false);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.h
 * JD-Core Version:    0.6.2
 */