package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzdqf
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = zzdqd.zzb(this.zzhky).size();
  private Iterator<Map.Entry<K, V>> zzhkx;

  private zzdqf(zzdqd paramzzdqd)
  {
  }

  private final Iterator<Map.Entry<K, V>> zzazu()
  {
    if (this.zzhkx == null)
      this.zzhkx = zzdqd.zzd(this.zzhky).entrySet().iterator();
    return this.zzhkx;
  }

  public final boolean hasNext()
  {
    return ((this.pos > 0) && (this.pos <= zzdqd.zzb(this.zzhky).size())) || (zzazu().hasNext());
  }

  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqf
 * JD-Core Version:    0.6.2
 */