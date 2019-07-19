package com.google.android.exoplayer2;

public abstract class a
  implements aa
{
  protected final ak.b a = new ak.b();

  private int p()
  {
    int i = m();
    if (i == 1)
      i = 0;
    return i;
  }

  public final void a(long paramLong)
  {
    a(r(), paramLong);
  }

  public final boolean a()
  {
    return e() != -1;
  }

  public final boolean b()
  {
    return d() != -1;
  }

  public final void c()
  {
    c(false);
  }

  public final int d()
  {
    ak localak = C();
    if (localak.a())
      return -1;
    return localak.a(r(), p(), n());
  }

  public final int e()
  {
    ak localak = C();
    if (localak.a())
      return -1;
    return localak.b(r(), p(), n());
  }

  public final long f()
  {
    ak localak = C();
    if (localak.a())
      return -9223372036854775807L;
    return localak.a(r(), this.a).c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.6.2
 */