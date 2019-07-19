package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzwx extends AbstractSet<Map.Entry<K, V>>
{
  private zzwx(zzwo paramzzwo)
  {
  }

  public void clear()
  {
    this.zzcca.clear();
  }

  public boolean contains(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    Object localObject1 = this.zzcca.get(localEntry.getKey());
    Object localObject2 = localEntry.getValue();
    return (localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2)));
  }

  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzww(this.zzcca, null);
  }

  public boolean remove(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    if (contains(localEntry))
    {
      this.zzcca.remove(localEntry.getKey());
      return true;
    }
    return false;
  }

  public int size()
  {
    return this.zzcca.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwx
 * JD-Core Version:    0.6.2
 */