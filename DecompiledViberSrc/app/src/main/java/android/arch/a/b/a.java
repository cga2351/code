package android.arch.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

public class a<K, V> extends b<K, V>
{
  private HashMap<K, b.c<K, V>> a = new HashMap();

  protected b.c<K, V> a(K paramK)
  {
    return (b.c)this.a.get(paramK);
  }

  public V a(K paramK, V paramV)
  {
    b.c localc = a(paramK);
    if (localc != null)
      return localc.b;
    this.a.put(paramK, b(paramK, paramV));
    return null;
  }

  public V b(K paramK)
  {
    Object localObject = super.b(paramK);
    this.a.remove(paramK);
    return localObject;
  }

  public boolean c(K paramK)
  {
    return this.a.containsKey(paramK);
  }

  public Map.Entry<K, V> d(K paramK)
  {
    if (c(paramK))
      return ((b.c)this.a.get(paramK)).d;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.a.b.a
 * JD-Core Version:    0.6.2
 */