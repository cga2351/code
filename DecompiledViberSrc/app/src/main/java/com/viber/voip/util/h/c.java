package com.viber.voip.util.h;

public class c
{
  private long a;
  private final d b;

  public c(d paramd)
  {
    this.b = paramd;
  }

  private void b()
  {
    if (this.b != null)
      this.b.a(this.a);
  }

  public long a()
  {
    return this.a;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
    b();
  }

  public void b(long paramLong)
  {
    a(paramLong + this.a);
  }

  public void c(long paramLong)
  {
    if (paramLong > 0L)
      b(paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.h.c
 * JD-Core Version:    0.6.2
 */