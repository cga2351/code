package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzww
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private Iterator<Map.Entry<K, V>> zzcbz;
  private boolean zzcce;

  private zzww(zzwo paramzzwo)
  {
  }

  private final Iterator<Map.Entry<K, V>> zzyh()
  {
    if (this.zzcbz == null)
      this.zzcbz = zzwo.zzc(this.zzcca).entrySet().iterator();
    return this.zzcbz;
  }

  public final boolean hasNext()
  {
    return (1 + this.pos < zzwo.zzb(this.zzcca).size()) || ((!zzwo.zzc(this.zzcca).isEmpty()) && (zzyh().hasNext()));
  }

  public final void remove()
  {
    if (!this.zzcce)
      throw new IllegalStateException("remove() was called before next()");
    this.zzcce = false;
    zzwo.zza(this.zzcca);
    if (this.pos < zzwo.zzb(this.zzcca).size())
    {
      zzwo localzzwo = this.zzcca;
      int i = this.pos;
      this.pos = (i - 1);
      zzwo.zza(localzzwo, i);
      return;
    }
    zzyh().remove();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzww
 * JD-Core Version:    0.6.2
 */