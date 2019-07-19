package dagger.a;

import dagger.a;
import javax.inject.Provider;

public final class c<T>
  implements a<T>, Provider<T>
{
  private static final Object b;
  private volatile Provider<T> c;
  private volatile Object d = b;

  static
  {
    if (!c.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = new Object();
      return;
    }
  }

  private c(Provider<T> paramProvider)
  {
    if ((!a) && (paramProvider == null))
      throw new AssertionError();
    this.c = paramProvider;
  }

  public static <P extends Provider<T>, T> Provider<T> a(P paramP)
  {
    h.a(paramP);
    if ((paramP instanceof c))
      return paramP;
    return new c(paramP);
  }

  public static <P extends Provider<T>, T> a<T> b(P paramP)
  {
    if ((paramP instanceof a))
      return (a)paramP;
    return new c((Provider)h.a(paramP));
  }

  public T get()
  {
    Object localObject1 = this.d;
    if (localObject1 == b)
    {
      try
      {
        localObject1 = this.d;
        if (localObject1 != b)
          break label109;
        localObject1 = this.c.get();
        Object localObject3 = this.d;
        if ((localObject3 != b) && (localObject3 != localObject1))
          throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + localObject3 + " & " + localObject1 + ". This is likely due to a circular dependency.");
      }
      finally
      {
      }
      this.d = localObject1;
      this.c = null;
    }
    label109: return localObject1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.c
 * JD-Core Version:    0.6.2
 */