package com.viber.voip.ui.call.a;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  implements c
{
  public static int a = -1;
  public static int b = 1;
  private long c;
  private Set<c> d = new HashSet();
  private float e;
  private int f = b;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;

  public d(long paramLong)
  {
    this(paramLong, (c[])null);
  }

  public d(long paramLong, c paramc)
  {
    this(paramLong, new c[] { paramc });
  }

  public d(long paramLong, c[] paramArrayOfc)
  {
    this.e = ((float)paramLong);
    if (paramArrayOfc != null)
      Collections.addAll(this.d, paramArrayOfc);
  }

  public void a(float paramFloat)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((c)localIterator.next()).a(paramFloat);
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(long paramLong)
  {
    int j;
    float f1;
    float f2;
    if ((a == this.f) || (this.f > this.g))
    {
      j = 1;
      f1 = (float)(paramLong - this.c) / this.e;
      if ((j == 0) || ((0L != this.c) && (f1 <= 1.0F)))
        break label125;
      this.c = paramLong;
      f2 = 0.0F;
      this.g = (1 + this.g);
      this.i = false;
    }
    while (true)
    {
      if ((f2 <= 1.0F) || (!this.i))
      {
        if (this.h)
          f2 = 1.0F - f2;
        a(f2);
        return;
        j = 0;
        break;
      }
      this.i = true;
      return;
      label125: f2 = f1;
    }
  }

  public void a(c paramc)
  {
    this.d.add(paramc);
  }

  public void c()
  {
    this.g = 0;
    this.c = 0L;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((c)localIterator.next()).c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.a.d
 * JD-Core Version:    0.6.2
 */