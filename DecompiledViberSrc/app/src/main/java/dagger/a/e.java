package dagger.a;

import dagger.a;

public final class e<T>
  implements a<T>, d<T>
{
  private static final e<Object> a = new e(null);
  private final T b;

  private e(T paramT)
  {
    this.b = paramT;
  }

  public static <T> d<T> a(T paramT)
  {
    return new e(h.a(paramT, "instance cannot be null"));
  }

  public T get()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.e
 * JD-Core Version:    0.6.2
 */