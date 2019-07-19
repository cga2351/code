package dagger.android;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Faked versions of AndroidInjector are much clearer than a mock. See https://google.github.io/dagger/testing")
public abstract interface b<T>
{
  public abstract void a(T paramT);

  @DoNotMock
  public static abstract class a<T>
    implements b.b<T>
  {
    public abstract void a(T paramT);

    public abstract b<T> b();

    public final b<T> b(T paramT)
    {
      a(paramT);
      return b();
    }
  }

  @DoNotMock
  public static abstract interface b<T>
  {
    public abstract b<T> b(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.b
 * JD-Core Version:    0.6.2
 */