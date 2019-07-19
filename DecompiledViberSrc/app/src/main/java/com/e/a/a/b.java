package com.e.a.a;

import com.e.a.b.a;
import com.e.a.h;
import java.util.Collections;
import java.util.Set;

abstract class b
{
  private final Set<h> a;
  private final a b = new a();

  public b(Set<h> paramSet)
  {
    if (paramSet == null)
      throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
    this.a = Collections.unmodifiableSet(paramSet);
  }

  public a a()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.b
 * JD-Core Version:    0.6.2
 */