package com.viber.voip.backup.ui.a.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.google.a.a.b.a.a.b.a.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ax;
import com.viber.voip.util.cb;

public class b
  implements cb
{
  private static final Logger a = ViberEnv.getLogger();
  private final Activity b;
  private final Fragment c;
  private final a d;
  private final a.a e;
  private final com.viber.voip.backup.b.b f;
  private a g;

  public b(Activity paramActivity, Fragment paramFragment, a parama, com.viber.voip.backup.b.b paramb)
  {
    this.b = paramActivity;
    this.c = paramFragment;
    this.d = parama;
    this.f = paramb;
    this.e = j();
  }

  private void b(int paramInt)
  {
    int i = 1;
    if (i());
    try
    {
      this.f.a(this.c, paramInt);
      i = 0;
      label23: if ((i != 0) && (this.g != null))
        this.g.a(paramInt, 0);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      break label23;
    }
  }

  private a.a j()
  {
    return new a.a()
    {
      @SuppressLint({"MissingPermission"})
      public void a(int paramAnonymousInt)
      {
        b.a(b.this).a();
        if (!b.this.g())
          b.a(b.this, paramAnonymousInt);
        while (b.b(b.this) == null)
          return;
        b.b(b.this).a(paramAnonymousInt);
      }

      public void b(int paramAnonymousInt)
      {
        if (paramAnonymousInt == -1)
          paramAnonymousInt = -1;
        if (b.b(b.this) != null)
          b.b(b.this).a(paramAnonymousInt, 1);
      }
    };
  }

  private boolean k()
  {
    return (!this.b.isFinishing()) && (ax.a(this.f, this.b, this.c, null, 1005, 1000));
  }

  public void a()
  {
    this.d.a(this.e);
  }

  @SuppressLint({"MissingPermission"})
  public void a(int paramInt)
  {
    if (this.d.a())
    {
      b(paramInt);
      return;
    }
    this.d.a(paramInt);
  }

  public void a(int paramInt, d paramd)
  {
    ax.a(paramd, this.c, paramInt);
  }

  public void a(a parama)
  {
    this.g = parama;
  }

  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default:
      bool = false;
    case 1000:
    case 1001:
    case 1002:
    case 1003:
    case 1004:
    case 1005:
    }
    do
    {
      do
      {
        do
          return bool;
        while (this.g == null);
        if (this.f.a(paramInt2, paramIntent))
        {
          this.g.a(paramInt1);
          return bool;
        }
        this.g.a(paramInt1, 3);
        return bool;
        if (paramInt2 != -1)
          c();
      }
      while (this.g == null);
      if (paramInt2 == -1)
      {
        this.g.a(paramInt1);
        return bool;
      }
      this.g.a(paramInt1, 3);
      return bool;
    }
    while ((paramInt2 == -1) || (this.g == null));
    this.g.a(paramInt1, 0);
    return bool;
  }

  public void b()
  {
    this.d.b();
  }

  public void c()
  {
    this.f.a(null);
  }

  public int d()
  {
    if (i())
    {
      if (g())
      {
        if (k())
          return 0;
        return 3;
      }
      return 1;
    }
    return 2;
  }

  public com.google.a.a.b.a.a.b.a.a e()
  {
    return this.f.c();
  }

  public com.google.a.a.b.a.a.b.a.a f()
  {
    return this.f.b();
  }

  public boolean g()
  {
    return this.f.d();
  }

  public boolean h()
  {
    return (this.f.d()) && (this.d.a());
  }

  public boolean i()
  {
    return (!this.b.isFinishing()) && (ax.a(this.b, this.c, null, 1005));
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.b.b
 * JD-Core Version:    0.6.2
 */