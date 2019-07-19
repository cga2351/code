package dagger.android;

import java.util.Map;
import javax.inject.Provider;

public final class d<T>
  implements dagger.a.d<c<T>>
{
  private final Provider<Map<Class<? extends T>, Provider<b.b<? extends T>>>> a;

  public static <T> c<T> a(Map<Class<? extends T>, Provider<b.b<? extends T>>> paramMap)
  {
    return new c(paramMap);
  }

  public c<T> a()
  {
    return new c((Map)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.d
 * JD-Core Version:    0.6.2
 */