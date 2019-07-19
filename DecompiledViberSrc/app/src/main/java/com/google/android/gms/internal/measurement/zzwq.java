package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzwq
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = zzwo.zzb(this.zzcca).size();
  private Iterator<Map.Entry<K, V>> zzcbz;

  private zzwq(zzwo paramzzwo)
  {
  }

  private final Iterator<Map.Entry<K, V>> zzyh()
  {
    if (this.zzcbz == null)
      this.zzcbz = zzwo.zzd(this.zzcca).entrySet().iterator();
    return this.zzcbz;
  }

  public final boolean hasNext()
  {
    return ((this.pos > 0) && (this.pos <= zzwo.zzb(this.zzcca).size())) || (zzyh().hasNext());
  }

  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwq
 * JD-Core Version:    0.6.2
 */