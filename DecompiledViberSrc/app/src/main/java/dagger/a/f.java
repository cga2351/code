package dagger.a;

import java.util.Collections;
import java.util.Map;

public final class f<K, V>
{
  private final Map<K, V> a;

  private f(int paramInt)
  {
    this.a = a.a(paramInt);
  }

  public static <K, V> f<K, V> a(int paramInt)
  {
    return new f(paramInt);
  }

  public f<K, V> a(K paramK, V paramV)
  {
    this.a.put(paramK, paramV);
    return this;
  }

  public Map<K, V> a()
  {
    switch (this.a.size())
    {
    default:
      return Collections.unmodifiableMap(this.a);
    case 0:
    }
    return Collections.emptyMap();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.f
 * JD-Core Version:    0.6.2
 */