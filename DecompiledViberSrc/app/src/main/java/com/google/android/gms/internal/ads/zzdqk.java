package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

final class zzdqk
  implements Comparable<zzdqk>, Map.Entry<K, V>
{
  private V value;
  private final K zzhlb;

  zzdqk(K paramK, V paramV)
  {
    this.zzhlb = paramV;
    Object localObject;
    this.value = localObject;
  }

  zzdqk(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
  }

  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    Map.Entry localEntry;
    do
    {
      return true;
      if (!(paramObject instanceof Map.Entry))
        return false;
      localEntry = (Map.Entry)paramObject;
    }
    while ((equals(this.zzhlb, localEntry.getKey())) && (equals(this.value, localEntry.getValue())));
    return false;
  }

  public final V getValue()
  {
    return this.value;
  }

  public final int hashCode()
  {
    int i;
    int j;
    if (this.zzhlb == null)
    {
      i = 0;
      Object localObject = this.value;
      j = 0;
      if (localObject != null)
        break label35;
    }
    while (true)
    {
      return i ^ j;
      i = this.zzhlb.hashCode();
      break;
      label35: j = this.value.hashCode();
    }
  }

  public final V setValue(V paramV)
  {
    zzdqd.zza(this.zzhky);
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }

  public final String toString()
  {
    String str1 = String.valueOf(this.zzhlb);
    String str2 = String.valueOf(this.value);
    return 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + "=" + str2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqk
 * JD-Core Version:    0.6.2
 */