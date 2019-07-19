package com.viber.voip.c;

import java.util.HashSet;
import java.util.Set;

public class g
{
  private final Set<Long> a = new HashSet();

  public void a(long paramLong)
  {
    this.a.add(Long.valueOf(paramLong));
  }

  public boolean a()
  {
    return !this.a.isEmpty();
  }

  public void b()
  {
    this.a.clear();
  }

  public boolean b(long paramLong)
  {
    return this.a.contains(Long.valueOf(paramLong));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.c.g
 * JD-Core Version:    0.6.2
 */