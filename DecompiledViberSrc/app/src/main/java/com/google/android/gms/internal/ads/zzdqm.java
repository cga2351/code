package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzdqm extends AbstractSet<Map.Entry<K, V>>
{
  private zzdqm(zzdqd paramzzdqd)
  {
  }

  public void clear()
  {
    this.zzhky.clear();
  }

  public boolean contains(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    Object localObject1 = this.zzhky.get(localEntry.getKey());
    Object localObject2 = localEntry.getValue();
    return (localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2)));
  }

  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzdql(this.zzhky, null);
  }

  public boolean remove(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    if (contains(localEntry))
    {
      this.zzhky.remove(localEntry.getKey());
      return true;
    }
    return false;
  }

  public int size()
  {
    return this.zzhky.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqm
 * JD-Core Version:    0.6.2
 */