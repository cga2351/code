package com.viber.voip.contacts.c.f.a.a;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.ContactsContract.Data;
import android.support.v4.util.ArraySet;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ao;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g.h;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.p;
import com.viber.voip.util.bq;
import com.viber.voip.util.br;
import com.viber.voip.util.d.a;
import com.viber.voip.util.d.b;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class e extends ContentObserver
  implements c.f
{
  private static final Logger a = ViberEnv.getLogger();
  private static final boolean b = br.e.a();
  private final b c;
  private final c d;
  private final com.viber.voip.contacts.c.d.n e;
  private final a f;
  private final Context g;
  private final ViberApplication h;
  private final Handler i;
  private final bq j;
  private c.a k;
  private boolean l;
  private boolean m;
  private AtomicBoolean n = new AtomicBoolean();
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r = true;
  private ao s;
  private Set<String> t = new ArraySet();
  private d.al u;
  private d.b v;
  private b w;

  public e(Context paramContext, ViberApplication paramViberApplication, a parama, bq parambq)
  {
    super(av.a(av.e.c));
    Handler localHandler = av.a(av.e.c);
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.az.a;
    this.u = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        boolean bool = d.p.c.d();
        if (bool != e.a(e.this))
        {
          e.a(e.this, bool);
          e.this.b();
        }
      }
    };
    this.v = new d.b()
    {
      private final Runnable b = new Runnable()
      {
        public void run()
        {
          e.this.a(false);
        }
      };

      public void onAppStopped()
      {
        com.viber.voip.util.i.c(this);
      }

      public void onBackground()
      {
        e.h(e.this).postDelayed(this.b, 300000L);
      }

      public void onForeground()
      {
        e.h(e.this).removeCallbacks(this.b);
        e.this.a(true);
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        com.viber.voip.util.i.a(this, paramAnonymousBoolean);
      }
    };
    this.w = new b(null);
    this.g = paramContext;
    this.i = av.a(av.e.c);
    this.s = bq.b(paramContext).a();
    this.f = parama;
    this.j = parambq;
    this.h = paramViberApplication;
    this.e = com.viber.voip.contacts.c.f.a.a(this.g);
    this.d = new c(this.g, this, this.i, this.s, paramContext.getContentResolver());
    this.c = new b(this.g);
    this.p = d.p.c.d();
    if (this.p)
    {
      f();
      return;
    }
    this.d.a(new c.h()
    {
      public void a(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          e.a(e.this, true);
          d.p.c.a(e.a(e.this));
        }
        e.b(e.this);
      }
    });
  }

  private void a(a parama)
  {
    if (((parama == a.a) && (!ViberApplication.isActivated())) || (!ViberApplication.getInstance().getEngine(false).isInitialized()));
    do
    {
      return;
      if ((this.k == null) || (this.l))
      {
        b(parama);
        return;
      }
      if (parama == a.a)
      {
        i();
        return;
      }
      if (parama == a.c)
      {
        if (this.t.isEmpty())
        {
          a(a.b);
          return;
        }
        this.d.a(this.p, new ArraySet(this.t));
        this.t.clear();
        return;
      }
      if (parama == a.b)
      {
        this.d.a(this.p, this.k, 0L);
        return;
      }
      if (parama == a.g)
      {
        this.d.a(this.k);
        return;
      }
      if (parama == a.e)
      {
        this.d.b(this.k);
        return;
      }
      if (parama == a.d)
      {
        if (!this.p)
        {
          this.d.c(this.k);
          return;
        }
        a(a.f);
        return;
      }
    }
    while (parama != a.f);
    this.e.a(1);
    h();
    this.f.a();
  }

  private void b(a parama)
  {
    this.j.a(0, null, a.c.j, new String[] { "phonebookrawcontact.contact_id", "phonebookrawcontact._id", "phonebookrawcontact.version", "phonebookrawcontact.starred", "phonebookcontact.contact_lookup_key" }, null, null, "phonebookrawcontact.contact_id ASC, phonebookrawcontact._id ASC", new i(this, parama), false, false, false);
  }

  private void f()
  {
    boolean bool1 = this.h.isOnForeground();
    com.viber.voip.settings.d.a(this.u);
    if (b)
    {
      com.viber.voip.util.d.c(this.w);
      com.viber.voip.util.d.a(this.w);
      if ((b) && (!bool1))
        break label63;
    }
    label63: for (boolean bool2 = true; ; bool2 = false)
    {
      a(bool2);
      return;
      com.viber.voip.util.d.c(this.v);
      break;
    }
  }

  private void g()
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this, e.a.a);
      }
    });
  }

  private void h()
  {
    this.i.postDelayed(new Runnable()
    {
      public void run()
      {
        e.c(e.this);
      }
    }
    , 1000L);
  }

  private void i()
  {
    while (true)
    {
      try
      {
        if (this.n.get())
        {
          this.m = true;
          return;
        }
        this.n.set(true);
        if (this.c.a())
        {
          this.c.a(new f(this));
          continue;
        }
      }
      finally
      {
      }
      a(a.c);
    }
  }

  private void j()
  {
    try
    {
      if (this.m)
      {
        this.m = false;
        a(a.b);
      }
      while (true)
      {
        return;
        this.n.set(false);
      }
    }
    finally
    {
    }
  }

  private CircularArray<c.g> k()
  {
    CircularArray localCircularArray = new CircularArray(1);
    localCircularArray.addLast(new c.g("", 0L, 0L, 0, true));
    return localCircularArray;
  }

  public void a()
  {
    if (b)
    {
      com.viber.voip.util.d.d(this.w);
      com.viber.voip.util.d.b(this.w);
    }
    while (true)
    {
      a(false);
      com.viber.voip.settings.d.b(this.u);
      return;
      com.viber.voip.util.d.d(this.v);
    }
  }

  public void a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, g.h paramh)
  {
    this.i.post(new h(this, paramAccount, paramString1, paramString2, paramString3, paramBitmap, paramh));
  }

  public void a(c.b paramb)
  {
    this.f.a(paramb.a, paramb.b, new g(this));
  }

  public void a(c.c paramc)
  {
    if (paramc.a)
    {
      this.f.a(true, paramc.b, new a.a()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
            e.this.d();
          e.a(e.this, e.a.d);
        }
      });
      return;
    }
    a(a.d);
  }

  public void a(c.d paramd)
  {
    if (paramd.a)
    {
      this.f.a(false, paramd.b, new a.a()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
            e.this.d();
          e.a(e.this, e.a.e);
        }
      });
      return;
    }
    a(a.e);
  }

  public void a(c.e parame)
  {
    if (parame.a)
    {
      this.f.a(parame.b, new a.a()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
            e.this.d();
          e.a(e.this, e.a.f);
        }
      });
      return;
    }
    a(a.f);
  }

  public void a(boolean paramBoolean)
  {
    while (true)
    {
      boolean bool2;
      try
      {
        boolean bool1 = ViberApplication.getInstance().getEngine(false).isInitialized();
        if (!bool1)
          return;
        bool2 = com.viber.common.permission.c.a(this.g).a(com.viber.voip.permissions.n.j);
        if (this.r != bool2)
        {
          this.r = bool2;
          if (bool2)
            this.f.e();
        }
        else
        {
          if ((!bool2) || (!paramBoolean) || (this.o))
            break label117;
          this.o = true;
          this.g.getContentResolver().registerContentObserver(ContactsContract.Data.CONTENT_URI, true, this);
          b();
          continue;
        }
      }
      finally
      {
      }
      g();
      continue;
      label117: if ((this.o) && ((!paramBoolean) || (!bool2)))
      {
        this.o = false;
        this.g.getContentResolver().unregisterContentObserver(this);
      }
    }
  }

  public void b()
  {
    try
    {
      boolean bool = this.o;
      if (!bool);
      while (true)
      {
        return;
        g();
      }
    }
    finally
    {
    }
  }

  public void b(final c.b paramb)
  {
    this.f.a(paramb.a, paramb.b, new a.a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        boolean bool1 = true;
        if (paramAnonymousBoolean)
          e.this.d();
        if (!paramb.a)
        {
          e.e(e.this).a(e.a(e.this), e.d(e.this), paramb.c);
          if (!e.f(e.this))
          {
            e.b(e.this, bool1);
            if ((!paramb.a) || (paramb.c != -1L))
              break label138;
          }
        }
        label138: for (boolean bool2 = bool1; ; bool2 = false)
        {
          com.viber.voip.contacts.c.d.n localn = e.g(e.this);
          int i;
          if (bool2)
            i = 4;
          localn.a(i);
          return;
          e.a(e.this, e.a.g);
          break;
        }
      }
    });
  }

  public boolean c()
  {
    return this.n.get();
  }

  public void d()
  {
    this.l = true;
  }

  public boolean deliverSelfNotifications()
  {
    return false;
  }

  public void onChange(boolean paramBoolean)
  {
    try
    {
      a(a.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }
  }

  private class b
    implements d.a, d.b
  {
    private final Runnable b = new Runnable()
    {
      public void run()
      {
        e.this.a(true);
      }
    };

    private b()
    {
    }

    public void a(boolean paramBoolean, Class paramClass)
    {
      if (paramBoolean)
      {
        e.i(e.this).b();
        return;
      }
      e.i(e.this).a();
    }

    public void onAppStopped()
    {
      com.viber.voip.util.i.c(this);
    }

    public void onBackground()
    {
      e.h(e.this).removeCallbacks(this.b);
      e.this.a(false);
    }

    public void onForeground()
    {
      e.h(e.this).removeCallbacks(this.b);
      e.h(e.this).postDelayed(this.b, 500L);
    }

    public void onForegroundStateChanged(boolean paramBoolean)
    {
      com.viber.voip.util.i.a(this, paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.a.a.e
 * JD-Core Version:    0.6.2
 */