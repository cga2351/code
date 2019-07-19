package com.yandex.mobile.ads.impl;

import android.content.Context;

public abstract class pm<R, T> extends pl<T>
{
  private final R a;
  private final fe<R, T> b;
  private final fb c;

  public pm(Context paramContext, int paramInt, String paramString, pl.a<T> parama, R paramR, fe<R, T> paramfe)
  {
    super(paramInt, paramString, parama);
    this.a = paramR;
    this.b = paramfe;
    this.c = fb.a(paramContext);
    fd localfd = this.b.a(this.a);
    this.c.a(localfd);
  }

  private void a(ok<T> paramok, int paramInt)
  {
    fd localfd = this.b.a(paramok, paramInt, this.a);
    this.c.a(localfd);
  }

  protected final ok<T> a(oh paramoh)
  {
    int i = paramoh.a;
    ok localok = a(paramoh, i);
    a(localok, i);
    return localok;
  }

  protected abstract ok<T> a(oh paramoh, int paramInt);

  protected ov a(ov paramov)
  {
    if (paramov.a != null);
    for (int i = paramov.a.a; ; i = -1)
    {
      a(null, i);
      return super.a(paramov);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pm
 * JD-Core Version:    0.6.2
 */