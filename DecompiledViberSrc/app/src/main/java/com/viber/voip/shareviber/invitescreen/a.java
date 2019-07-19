package com.viber.voip.shareviber.invitescreen;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.contacts.e;
import com.viber.voip.model.c;
import com.viber.voip.util.cl;
import java.util.ArrayList;
import java.util.Collection;

public class a
{
  private final Handler a;
  private final g b;
  private final e c;
  private a d = (a)cl.b(a.class);
  private final d.a e = new d.a()
  {
    public void onLoadFinished(d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      ArrayList localArrayList = new ArrayList(paramAnonymousd.getCount());
      for (int i = 0; i < paramAnonymousd.getCount(); i++)
      {
        Object localObject = paramAnonymousd.b(i);
        if ((localObject instanceof c))
          localArrayList.add((c)localObject);
      }
      a.a(a.this).a(localArrayList, paramAnonymousBoolean);
    }

    public void onLoaderReset(d paramAnonymousd)
    {
    }
  };
  private final g.b f = new g.b()
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
  private boolean g;

  a(Context paramContext, Handler paramHandler, LoaderManager paramLoaderManager, g paramg)
  {
    this.a = paramHandler;
    this.b = paramg;
    this.c = new e(paramContext, paramLoaderManager, paramg, this.e);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.g)
      return;
    this.g = paramBoolean;
    if (this.g)
    {
      this.c.p();
      this.b.a(this.f);
      return;
    }
    this.c.q();
    this.b.b(this.f);
  }

  public com.viber.voip.contacts.a a()
  {
    return this.c;
  }

  void a(a parama)
  {
    this.d = parama;
  }

  public void a(String paramString)
  {
    if (!this.c.d())
    {
      this.c.g(paramString);
      a(true);
      return;
    }
    this.c.f(paramString);
  }

  public void b()
  {
    if (this.c.d())
      this.c.l();
    while (true)
    {
      a(true);
      return;
      this.c.i();
    }
  }

  public void c()
  {
    a(false);
  }

  public void d()
  {
    this.c.l();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(Collection<c> paramCollection, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.a
 * JD-Core Version:    0.6.2
 */