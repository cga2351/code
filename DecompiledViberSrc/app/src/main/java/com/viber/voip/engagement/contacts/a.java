package com.viber.voip.engagement.contacts;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.contacts.b;
import com.viber.voip.contacts.b.a;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.util.cl;

public class a
{
  private final b.b a;
  private final Handler b;
  private final dagger.a<g> c;
  private final b d;
  private a e = (a)cl.b(a.class);
  private final d.a f = new d.a()
  {
    public void onLoadFinished(d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      a.a locala = a.a(a.this);
      if (paramAnonymousd.getCount() == 0);
      for (boolean bool = true; ; bool = false)
      {
        locala.a(bool);
        return;
      }
    }

    public void onLoaderReset(d paramAnonymousd)
    {
    }
  };
  private final g.b g = new g.b()
  {
    private final Runnable b = new Runnable()
    {
      public void run()
      {
        a.a(a.this).a();
      }
    };

    public void a()
    {
      a.b(a.this).post(this.b);
    }
  };
  private boolean h;

  public a(Context paramContext, Handler paramHandler, LoaderManager paramLoaderManager, dagger.a<g> parama)
  {
    this(paramContext, paramHandler, paramLoaderManager, parama, b.b.d);
  }

  public a(Context paramContext, Handler paramHandler, LoaderManager paramLoaderManager, dagger.a<g> parama, b.b paramb)
  {
    this.a = paramb;
    this.b = paramHandler;
    this.c = parama;
    this.d = new b(4, paramContext, paramLoaderManager, parama, this.f, this.a);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.h)
      return;
    this.h = paramBoolean;
    if (this.h)
    {
      this.d.p();
      ((g)this.c.get()).a(this.g);
      return;
    }
    this.d.q();
    ((g)this.c.get()).b(this.g);
  }

  public b.a a()
  {
    return this.d.w();
  }

  public void a(a parama)
  {
    this.e = parama;
  }

  public void a(String paramString)
  {
    if (!this.d.d())
    {
      this.d.a(paramString, "", this.a);
      a(true);
      return;
    }
    this.d.a(paramString, "");
  }

  public b.a b()
  {
    return this.d.u();
  }

  public void c()
  {
    if (this.d.d())
      this.d.l();
    while (true)
    {
      a(true);
      return;
      this.d.b(this.a);
    }
  }

  public void d()
  {
    a(false);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.a
 * JD-Core Version:    0.6.2
 */