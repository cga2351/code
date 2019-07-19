package com.yandex.metrica.impl.ob;

public class bo
{
  private Long a;
  private int b;
  private on c;

  public bo()
  {
    this(new om());
  }

  public bo(on paramon)
  {
    this.c = paramon;
  }

  public a a()
  {
    if (this.a == null)
      this.a = Long.valueOf(this.c.b());
    a locala = new a(this.a.longValue(), this.a.longValue(), this.b);
    this.b = (1 + this.b);
    return locala;
  }

  public static class a
  {
    public final long a;
    public final long b;
    public final int c;

    public a(long paramLong1, long paramLong2, int paramInt)
    {
      this.a = paramLong1;
      this.c = paramInt;
      this.b = paramLong2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bo
 * JD-Core Version:    0.6.2
 */