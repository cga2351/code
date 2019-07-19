package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Map;

public class oc<K, V>
{
  private final Map<K, V> a;
  private final V b;

  public oc(V paramV)
  {
    this(new HashMap(), paramV);
  }

  public oc(Map<K, V> paramMap, V paramV)
  {
    this.a = paramMap;
    this.b = paramV;
  }

  public V a(K paramK)
  {
    Object localObject = this.a.get(paramK);
    if (localObject == null)
      localObject = this.b;
    return localObject;
  }

  public void a(K paramK, V paramV)
  {
    this.a.put(paramK, paramV);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oc
 * JD-Core Version:    0.6.2
 */