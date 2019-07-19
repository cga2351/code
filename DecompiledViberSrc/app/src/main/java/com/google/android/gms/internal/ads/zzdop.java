package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzdop<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzhit;

  public zzdop(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zzhit = paramIterator;
  }

  public final boolean hasNext()
  {
    return this.zzhit.hasNext();
  }

  public final void remove()
  {
    this.zzhit.remove();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdop
 * JD-Core Version:    0.6.2
 */