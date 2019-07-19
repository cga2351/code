package dagger.a;

import javax.inject.Provider;

public final class b<T>
  implements d<T>
{
  private Provider<T> a;

  public void a(Provider<T> paramProvider)
  {
    if (paramProvider == null)
      throw new IllegalArgumentException();
    if (this.a != null)
      throw new IllegalStateException();
    this.a = paramProvider;
  }

  public T get()
  {
    if (this.a == null)
      throw new IllegalStateException();
    return this.a.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.b
 * JD-Core Version:    0.6.2
 */