package com.google.android.exoplayer2.c;

public abstract class a
{
  private int a;

  public void a()
  {
    this.a = 0;
  }

  public final void a_(int paramInt)
  {
    this.a = paramInt;
  }

  public final void b(int paramInt)
  {
    this.a = (paramInt | this.a);
  }

  public final void c(int paramInt)
  {
    this.a &= (paramInt ^ 0xFFFFFFFF);
  }

  public final boolean c()
  {
    return d(4);
  }

  public final boolean d()
  {
    return d(1);
  }

  protected final boolean d(int paramInt)
  {
    return (paramInt & this.a) == paramInt;
  }

  public final boolean j_()
  {
    return d(-2147483648);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.6.2
 */