package com.viber.voip.engagement;

import android.net.Uri;
import android.os.Handler;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.c.c;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.messages.controller.y;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;
import com.viber.voip.stickers.i;
import com.viber.voip.util.b.a.a;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final Logger c = ViberEnv.getLogger();
  final f.a a;
  final d.al b;
  private final c d;
  private final i e;
  private final y f;
  private final f g;
  private final Handler h;

  public b(c paramc, i parami, y paramy, f paramf, h paramh, Handler paramHandler)
  {
    this.d = paramc;
    this.e = parami;
    this.f = paramy;
    this.g = paramf;
    this.h = paramHandler;
    this.b = new d.al(new com.viber.common.b.a[] { paramh })
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (b.a(b.this).e())
          b.this.b();
      }
    };
    this.a = new f.a()
    {
      public void onFeatureStateChanged(f paramAnonymousf)
      {
        if (paramAnonymousf.e())
          b.this.b();
      }
    };
  }

  public void a()
  {
    this.g.a(this.a);
    d.a(this.b);
  }

  void b()
  {
    this.h.post(new a(null));
  }

  void c()
  {
    com.viber.voip.engagement.data.a locala = this.d.b();
    if (locala == null);
    while (true)
    {
      return;
      com.viber.voip.util.b.a locala1 = locala.a();
      List localList1 = locala1.a();
      List localList2 = locala1.b();
      if (!u.a(localList1))
      {
        Iterator localIterator2 = localList1.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!da.a(str))
            this.f.a(Uri.parse(str), null);
        }
      }
      if (!u.a(localList2))
      {
        Iterator localIterator1 = localList2.iterator();
        while (localIterator1.hasNext())
        {
          a.a locala2 = (a.a)localIterator1.next();
          if (locala2 != null)
            this.e.u(locala2.a());
        }
      }
    }
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      b.this.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.b
 * JD-Core Version:    0.6.2
 */