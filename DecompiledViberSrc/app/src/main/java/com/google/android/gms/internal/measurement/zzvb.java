package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzvb<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzbzv;

  public zzvb(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zzbzv = paramIterator;
  }

  public final boolean hasNext()
  {
    return this.zzbzv.hasNext();
  }

  public final void remove()
  {
    this.zzbzv.remove();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvb
 * JD-Core Version:    0.6.2
 */