package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class cm
{
  private final Context a;
  private final eo b;
  private cl c;

  public cm(Context paramContext, eo parameo)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parameo;
  }

  public final void a()
  {
    if (this.c != null)
      this.c.a();
  }

  public final void a(cn paramcn)
  {
    if (paramcn != null)
      this.c = new cl(this.a, this.b, paramcn);
  }

  public final void a(fd.a parama)
  {
    if (this.c != null)
      this.c.a(parama);
  }

  public final void b()
  {
    if (this.c != null)
      this.c.b();
  }

  public final void c()
  {
    if (this.c != null)
      this.c.c();
  }

  public final void d()
  {
    if (this.c != null)
      this.c.e();
  }

  public final void e()
  {
    if (this.c != null)
      this.c.f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cm
 * JD-Core Version:    0.6.2
 */