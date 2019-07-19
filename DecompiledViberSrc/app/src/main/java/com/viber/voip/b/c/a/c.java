package com.viber.voip.b.c.a;

import android.content.Context;

public abstract class c
  implements g
{
  protected volatile boolean a;
  protected f b;
  final Context c;

  public c(Context paramContext)
  {
    this.c = paramContext;
  }

  protected abstract void b();

  public void c()
  {
    a();
    b();
  }

  public void d()
  {
    try
    {
      this.a = true;
      if (this.b != null)
        this.b.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean e()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.c
 * JD-Core Version:    0.6.2
 */