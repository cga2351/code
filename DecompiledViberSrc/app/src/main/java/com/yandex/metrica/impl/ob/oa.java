package com.yandex.metrica.impl.ob;

import java.util.Random;

public class oa
{
  private final Random a;

  public oa()
  {
    this(new Random());
  }

  public oa(Random paramRandom)
  {
    this.a = paramRandom;
  }

  public long a(long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    if (paramLong1 >= paramLong2)
      throw new IllegalArgumentException("min should be less than max");
    long l2 = this.a.nextLong();
    if (l2 == -9223372036854775808L);
    while (true)
    {
      return paramLong1 + l1 % (paramLong2 - paramLong1);
      if (l2 < l1)
        l1 = -l2;
      else
        l1 = l2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oa
 * JD-Core Version:    0.6.2
 */