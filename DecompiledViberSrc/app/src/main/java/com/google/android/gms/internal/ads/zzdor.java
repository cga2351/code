package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdor extends zzdmk<String>
  implements zzdos, RandomAccess
{
  private static final zzdor zzhix;
  private static final zzdos zzhiy = zzhix;
  private final List<Object> zzhiz;

  static
  {
    zzdor localzzdor = new zzdor();
    zzhix = localzzdor;
    localzzdor.zzavj();
  }

  public zzdor()
  {
    this(10);
  }

  public zzdor(int paramInt)
  {
    this(new ArrayList(paramInt));
  }

  private zzdor(ArrayList<Object> paramArrayList)
  {
    this.zzhiz = paramArrayList;
  }

  private static String zzac(Object paramObject)
  {
    if ((paramObject instanceof String))
      return (String)paramObject;
    if ((paramObject instanceof zzdmq))
      return ((zzdmq)paramObject).zzavn();
    return zzdoc.zzae((byte[])paramObject);
  }

  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzavk();
    if ((paramCollection instanceof zzdos))
      paramCollection = ((zzdos)paramCollection).zzayo();
    boolean bool = this.zzhiz.addAll(paramInt, paramCollection);
    this.modCount = (1 + this.modCount);
    return bool;
  }

  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }

  public final void clear()
  {
    zzavk();
    this.zzhiz.clear();
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.zzhiz.size();
  }

  public final List<?> zzayo()
  {
    return Collections.unmodifiableList(this.zzhiz);
  }

  public final zzdos zzayp()
  {
    if (zzavi())
      this = new zzdqv(this);
    return this;
  }

  public final void zzdb(zzdmq paramzzdmq)
  {
    zzavk();
    this.zzhiz.add(paramzzdmq);
    this.modCount = (1 + this.modCount);
  }

  public final Object zzgq(int paramInt)
  {
    return this.zzhiz.get(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdor
 * JD-Core Version:    0.6.2
 */