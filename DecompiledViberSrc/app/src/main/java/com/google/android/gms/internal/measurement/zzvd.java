package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvd extends zzta<String>
  implements zzve, RandomAccess
{
  private static final zzvd zzbzz;
  private static final zzve zzcaa = zzbzz;
  private final List<Object> zzcab;

  static
  {
    zzvd localzzvd = new zzvd();
    zzbzz = localzzvd;
    localzzvd.zzsw();
  }

  public zzvd()
  {
    this(10);
  }

  public zzvd(int paramInt)
  {
    this(new ArrayList(paramInt));
  }

  private zzvd(ArrayList<Object> paramArrayList)
  {
    this.zzcab = paramArrayList;
  }

  private static String zzaa(Object paramObject)
  {
    if ((paramObject instanceof String))
      return (String)paramObject;
    if ((paramObject instanceof zzte))
      return ((zzte)paramObject).zzud();
    return zzuq.zzm((byte[])paramObject);
  }

  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzua();
    if ((paramCollection instanceof zzve))
      paramCollection = ((zzve)paramCollection).zzxb();
    boolean bool = this.zzcab.addAll(paramInt, paramCollection);
    this.modCount = (1 + this.modCount);
    return bool;
  }

  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }

  public final void clear()
  {
    zzua();
    this.zzcab.clear();
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.zzcab.size();
  }

  public final Object zzbp(int paramInt)
  {
    return this.zzcab.get(paramInt);
  }

  public final void zzc(zzte paramzzte)
  {
    zzua();
    this.zzcab.add(paramzzte);
    this.modCount = (1 + this.modCount);
  }

  public final List<?> zzxb()
  {
    return Collections.unmodifiableList(this.zzcab);
  }

  public final zzve zzxc()
  {
    if (zztz())
      this = new zzxg(this);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvd
 * JD-Core Version:    0.6.2
 */