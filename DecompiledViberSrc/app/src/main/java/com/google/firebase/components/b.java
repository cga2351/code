package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class b<T>
{
  private final Set<Class<? super T>> a;
  private final Set<n> b;
  private final int c;
  private final int d;
  private final g<T> e;
  private final Set<Class<?>> f;

  private b(Set<Class<? super T>> paramSet, Set<n> paramSet1, int paramInt1, int paramInt2, g<T> paramg, Set<Class<?>> paramSet2)
  {
    this.a = Collections.unmodifiableSet(paramSet);
    this.b = Collections.unmodifiableSet(paramSet1);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramg;
    this.f = Collections.unmodifiableSet(paramSet2);
  }

  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass)
  {
    return new a(paramClass, new Class[0], null);
  }

  @SafeVarargs
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, Class<? super T>[] paramArrayOfClass)
  {
    return new a(paramClass, paramArrayOfClass, null);
  }

  @KeepForSdk
  public static <T> b<T> a(T paramT, Class<T> paramClass)
  {
    return b(paramClass).a(d.a(paramT)).b();
  }

  @SafeVarargs
  @KeepForSdk
  public static <T> b<T> a(T paramT, Class<T> paramClass, Class<? super T>[] paramArrayOfClass)
  {
    return a(paramClass, paramArrayOfClass).a(c.a(paramT)).b();
  }

  @KeepForSdk
  public static <T> a<T> b(Class<T> paramClass)
  {
    return a.a(a(paramClass));
  }

  public Set<Class<? super T>> a()
  {
    return this.a;
  }

  public Set<n> b()
  {
    return this.b;
  }

  public g<T> c()
  {
    return this.e;
  }

  public Set<Class<?>> d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.c == 1;
  }

  public boolean f()
  {
    return this.c == 2;
  }

  public boolean g()
  {
    return this.d == 0;
  }

  public String toString()
  {
    return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
  }

  @KeepForSdk
  public static class a<T>
  {
    private final Set<Class<? super T>> a = new HashSet();
    private final Set<n> b = new HashSet();
    private int c = 0;
    private int d = 0;
    private g<T> e;
    private Set<Class<?>> f = new HashSet();

    @SafeVarargs
    private a(Class<T> paramClass, Class<? super T>[] paramArrayOfClass)
    {
      Preconditions.checkNotNull(paramClass, "Null interface");
      this.a.add(paramClass);
      int j = paramArrayOfClass.length;
      while (i < j)
      {
        Preconditions.checkNotNull(paramArrayOfClass[i], "Null interface");
        i++;
      }
      Collections.addAll(this.a, paramArrayOfClass);
    }

    private a<T> a(int paramInt)
    {
      if (this.c == 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool, "Instantiation type has already been set.");
        this.c = paramInt;
        return this;
      }
    }

    private void a(Class<?> paramClass)
    {
      if (!this.a.contains(paramClass));
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "Components are not allowed to depend on interfaces they themselves provide.");
        return;
      }
    }

    private a<T> c()
    {
      this.d = 1;
      return this;
    }

    @KeepForSdk
    public a<T> a()
    {
      return a(1);
    }

    @KeepForSdk
    public a<T> a(g<T> paramg)
    {
      this.e = ((g)Preconditions.checkNotNull(paramg, "Null factory"));
      return this;
    }

    @KeepForSdk
    public a<T> a(n paramn)
    {
      Preconditions.checkNotNull(paramn, "Null dependency");
      a(paramn.a());
      this.b.add(paramn);
      return this;
    }

    @KeepForSdk
    public b<T> b()
    {
      if (this.e != null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool, "Missing required property: factory.");
        return new b(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f, null);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.b
 * JD-Core Version:    0.6.2
 */