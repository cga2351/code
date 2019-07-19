package com.yandex.metrica.impl.ob;

import java.util.Random;

public class lt
{
  private int a;
  private int b;
  private Random c;
  private int d;

  public lt(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 31));
    for (this.a = paramInt; ; this.a = 31)
    {
      this.c = new Random();
      return;
    }
  }

  public int a()
  {
    if (this.b < this.a)
    {
      this.b = (1 + this.b);
      this.d = (1 << this.b);
    }
    return this.c.nextInt(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lt
 * JD-Core Version:    0.6.2
 */