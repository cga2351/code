package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzdql
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private Iterator<Map.Entry<K, V>> zzhkx;
  private boolean zzhlc;

  private zzdql(zzdqd paramzzdqd)
  {
  }

  private final Iterator<Map.Entry<K, V>> zzazu()
  {
    if (this.zzhkx == null)
      this.zzhkx = zzdqd.zzc(this.zzhky).entrySet().iterator();
    return this.zzhkx;
  }

  public final boolean hasNext()
  {
    return (1 + this.pos < zzdqd.zzb(this.zzhky).size()) || ((!zzdqd.zzc(this.zzhky).isEmpty()) && (zzazu().hasNext()));
  }

  public final void remove()
  {
    if (!this.zzhlc)
      throw new IllegalStateException("remove() was called before next()");
    this.zzhlc = false;
    zzdqd.zza(this.zzhky);
    if (this.pos < zzdqd.zzb(this.zzhky).size())
    {
      zzdqd localzzdqd = this.zzhky;
      int i = this.pos;
      this.pos = (i - 1);
      zzdqd.zza(localzzdqd, i);
      return;
    }
    zzazu().remove();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdql
 * JD-Core Version:    0.6.2
 */