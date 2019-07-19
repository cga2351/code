package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final class zzdpx<E> extends zzdmk<E>
{
  private static final zzdpx<Object> zzhkm;
  private final List<E> zzhiz;

  static
  {
    zzdpx localzzdpx = new zzdpx(new ArrayList(0));
    zzhkm = localzzdpx;
    localzzdpx.zzavj();
  }

  zzdpx()
  {
    this(new ArrayList(10));
  }

  private zzdpx(List<E> paramList)
  {
    this.zzhiz = paramList;
  }

  public static <E> zzdpx<E> zzazh()
  {
    return zzhkm;
  }

  public final void add(int paramInt, E paramE)
  {
    zzavk();
    this.zzhiz.add(paramInt, paramE);
    this.modCount = (1 + this.modCount);
  }

  public final E get(int paramInt)
  {
    return this.zzhiz.get(paramInt);
  }

  public final E remove(int paramInt)
  {
    zzavk();
    Object localObject = this.zzhiz.remove(paramInt);
    this.modCount = (1 + this.modCount);
    return localObject;
  }

  public final E set(int paramInt, E paramE)
  {
    zzavk();
    Object localObject = this.zzhiz.set(paramInt, paramE);
    this.modCount = (1 + this.modCount);
    return localObject;
  }

  public final int size()
  {
    return this.zzhiz.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpx
 * JD-Core Version:    0.6.2
 */