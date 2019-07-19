package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzdqv extends AbstractList<String>
  implements zzdos, RandomAccess
{
  private final zzdos zzhlh;

  public zzdqv(zzdos paramzzdos)
  {
    this.zzhlh = paramzzdos;
  }

  public final Iterator<String> iterator()
  {
    return new zzdqx(this);
  }

  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzdqw(this, paramInt);
  }

  public final int size()
  {
    return this.zzhlh.size();
  }

  public final List<?> zzayo()
  {
    return this.zzhlh.zzayo();
  }

  public final zzdos zzayp()
  {
    return this;
  }

  public final void zzdb(zzdmq paramzzdmq)
  {
    throw new UnsupportedOperationException();
  }

  public final Object zzgq(int paramInt)
  {
    return this.zzhlh.zzgq(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqv
 * JD-Core Version:    0.6.2
 */