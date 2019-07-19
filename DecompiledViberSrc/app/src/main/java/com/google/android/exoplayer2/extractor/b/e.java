package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;

abstract class e
{
  protected final q a;

  protected e(q paramq)
  {
    this.a = paramq;
  }

  protected abstract void a(r paramr, long paramLong)
    throws w;

  protected abstract boolean a(r paramr)
    throws w;

  public final void b(r paramr, long paramLong)
    throws w
  {
    if (a(paramr))
      a(paramr, paramLong);
  }

  public static final class a extends w
  {
    public a(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b.e
 * JD-Core Version:    0.6.2
 */