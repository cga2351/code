package com.crashlytics.android.a;

import android.content.Context;
import c.a.a.a.a.b.k;
import c.a.a.a.a.d.c;
import java.io.IOException;
import java.util.UUID;

class z extends c.a.a.a.a.d.b<ad>
{
  private c.a.a.a.a.g.b g;

  z(Context paramContext, af paramaf, k paramk, c paramc)
    throws IOException
  {
    super(paramContext, paramaf, paramk, paramc, 100);
  }

  protected String a()
  {
    UUID localUUID = UUID.randomUUID();
    return "sa" + "_" + localUUID.toString() + "_" + this.c.a() + ".tap";
  }

  void a(c.a.a.a.a.g.b paramb)
  {
    this.g = paramb;
  }

  protected int b()
  {
    if (this.g == null)
      return super.b();
    return this.g.e;
  }

  protected int c()
  {
    if (this.g == null)
      return super.c();
    return this.g.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.z
 * JD-Core Version:    0.6.2
 */