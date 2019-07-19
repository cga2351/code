package com.google.android.exoplayer2.f;

import android.content.Context;

public final class q
  implements h.a
{
  private final Context a;
  private final ad b;
  private final h.a c;

  public q(Context paramContext, ad paramad, h.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramad;
    this.c = parama;
  }

  public q(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null);
  }

  public q(Context paramContext, String paramString, ad paramad)
  {
    this(paramContext, paramad, new s(paramString, paramad));
  }

  public p b()
  {
    p localp = new p(this.a, this.c.a());
    if (this.b != null)
      localp.a(this.b);
    return localp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.q
 * JD-Core Version:    0.6.2
 */