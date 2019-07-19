package dagger.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

public final class g<K, V>
  implements d<Map<K, V>>
{
  private static final Provider<Map<Object, Object>> a = e.a(Collections.emptyMap());
  private final Map<K, Provider<V>> b;

  private g(Map<K, Provider<V>> paramMap)
  {
    this.b = Collections.unmodifiableMap(paramMap);
  }

  public static <K, V> a<K, V> a(int paramInt)
  {
    return new a(paramInt, null);
  }

  public Map<K, V> a()
  {
    LinkedHashMap localLinkedHashMap = a.a(this.b.size());
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedHashMap.put(localEntry.getKey(), ((Provider)localEntry.getValue()).get());
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }

  public static final class a<K, V>
  {
    private final LinkedHashMap<K, Provider<V>> a;

    private a(int paramInt)
    {
      this.a = a.a(paramInt);
    }

    public a<K, V> a(K paramK, Provider<V> paramProvider)
    {
      this.a.put(h.a(paramK, "key"), h.a(paramProvider, "provider"));
      return this;
    }

    public g<K, V> a()
    {
      return new g(this.a, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.g
 * JD-Core Version:    0.6.2
 */