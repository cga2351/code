package com.google.firebase.components;

import com.google.firebase.a.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class u extends a
{
  private final Set<Class<?>> a;
  private final Set<Class<?>> b;
  private final Set<Class<?>> c;
  private final Set<Class<?>> d;
  private final Set<Class<?>> e;
  private final e f;

  u(b<?> paramb, e parame)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    HashSet localHashSet4 = new HashSet();
    Iterator localIterator = paramb.b().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.d())
      {
        if (localn.c())
          localHashSet3.add(localn.a());
        else
          localHashSet1.add(localn.a());
      }
      else if (localn.c())
        localHashSet4.add(localn.a());
      else
        localHashSet2.add(localn.a());
    }
    if (!paramb.d().isEmpty())
      localHashSet1.add(c.class);
    this.a = Collections.unmodifiableSet(localHashSet1);
    this.b = Collections.unmodifiableSet(localHashSet2);
    this.c = Collections.unmodifiableSet(localHashSet3);
    this.d = Collections.unmodifiableSet(localHashSet4);
    this.e = paramb.d();
    this.f = parame;
  }

  public <T> T a(Class<T> paramClass)
  {
    if (!this.a.contains(paramClass))
      throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[] { paramClass }));
    Object localObject = this.f.a(paramClass);
    if (!paramClass.equals(c.class))
      return localObject;
    return new a(this.e, (c)localObject);
  }

  public <T> Set<T> b(Class<T> paramClass)
  {
    if (!this.c.contains(paramClass))
      throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[] { paramClass }));
    return this.f.b(paramClass);
  }

  public <T> com.google.firebase.b.a<T> c(Class<T> paramClass)
  {
    if (!this.b.contains(paramClass))
      throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[] { paramClass }));
    return this.f.c(paramClass);
  }

  public <T> com.google.firebase.b.a<Set<T>> d(Class<T> paramClass)
  {
    if (!this.d.contains(paramClass))
      throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[] { paramClass }));
    return this.f.d(paramClass);
  }

  private static class a
    implements c
  {
    private final Set<Class<?>> a;
    private final c b;

    public a(Set<Class<?>> paramSet, c paramc)
    {
      this.a = paramSet;
      this.b = paramc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.u
 * JD-Core Version:    0.6.2
 */