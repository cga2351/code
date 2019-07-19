package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzwi<E> extends zzta<E>
{
  private static final zzwi<Object> zzcbo;
  private final List<E> zzcab;

  static
  {
    zzwi localzzwi = new zzwi();
    zzcbo = localzzwi;
    localzzwi.zzsw();
  }

  zzwi()
  {
    this(new ArrayList(10));
  }

  private zzwi(List<E> paramList)
  {
    this.zzcab = paramList;
  }

  public static <E> zzwi<E> zzxu()
  {
    return zzcbo;
  }

  public final void add(int paramInt, E paramE)
  {
    zzua();
    this.zzcab.add(paramInt, paramE);
    this.modCount = (1 + this.modCount);
  }

  public final E get(int paramInt)
  {
    return this.zzcab.get(paramInt);
  }

  public final E remove(int paramInt)
  {
    zzua();
    Object localObject = this.zzcab.remove(paramInt);
    this.modCount = (1 + this.modCount);
    return localObject;
  }

  public final E set(int paramInt, E paramE)
  {
    zzua();
    Object localObject = this.zzcab.set(paramInt, paramE);
    this.modCount = (1 + this.modCount);
    return localObject;
  }

  public final int size()
  {
    return this.zzcab.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwi
 * JD-Core Version:    0.6.2
 */