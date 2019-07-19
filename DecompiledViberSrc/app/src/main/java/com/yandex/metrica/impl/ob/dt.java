package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bw;
import java.util.HashSet;
import java.util.Set;

public class dt
{
  private boolean a;
  private Set<Integer> b;
  private int c;
  private int d;

  public dt()
  {
    this(false, 0, 0, new HashSet());
  }

  public dt(boolean paramBoolean, int paramInt1, int paramInt2, Set<Integer> paramSet)
  {
    this.a = paramBoolean;
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public dt(boolean paramBoolean, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this(paramBoolean, paramInt1, paramInt2, bw.a(paramArrayOfInt));
  }

  public void a()
  {
    this.b = new HashSet();
    this.d = 0;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
    this.d = 0;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void b(int paramInt)
  {
    this.b.add(Integer.valueOf(paramInt));
    this.d = (1 + this.d);
  }

  public boolean b()
  {
    return this.a;
  }

  public Set<Integer> c()
  {
    return this.b;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.dt
 * JD-Core Version:    0.6.2
 */