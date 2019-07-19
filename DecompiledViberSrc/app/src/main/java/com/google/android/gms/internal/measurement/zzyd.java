package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzyd<M extends zzyc<M>, T>
{
  public final int tag;
  private final int type;
  private final zzuo<?, ?> zzbyi;
  protected final Class<T> zzcew;
  protected final boolean zzcex;

  private zzyd(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this(11, paramClass, null, 810, false);
  }

  private zzyd(int paramInt1, Class<T> paramClass, zzuo<?, ?> paramzzuo, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.zzcew = paramClass;
    this.tag = paramInt2;
    this.zzcex = false;
    this.zzbyi = null;
  }

  public static <M extends zzyc<M>, T extends zzyi> zzyd<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzyd(11, paramClass, 810, false);
  }

  private final Object zze(zzxz paramzzxz)
  {
    Class localClass;
    if (this.zzcex)
      localClass = this.zzcew.getComponentType();
    try
    {
      switch (this.type)
      {
      default:
        int i = this.type;
        throw new IllegalArgumentException(24 + "Unknown type " + i);
      case 10:
      case 11:
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
      {
        String str2 = String.valueOf(localClass);
        throw new IllegalArgumentException(33 + String.valueOf(str2).length() + "Error creating instance of class " + str2, localInstantiationException);
        localClass = this.zzcew;
      }
      zzyi localzzyi2 = (zzyi)localClass.newInstance();
      paramzzxz.zza(localzzyi2, this.tag >>> 3);
      return localzzyi2;
      zzyi localzzyi1 = (zzyi)localClass.newInstance();
      paramzzxz.zza(localzzyi1);
      return localzzyi1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      String str1 = String.valueOf(localClass);
      throw new IllegalArgumentException(33 + String.valueOf(str1).length() + "Error creating instance of class " + str1, localIllegalAccessException);
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Error reading extension field", localIOException);
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzyd localzzyd;
    do
    {
      return true;
      if (!(paramObject instanceof zzyd))
        return false;
      localzzyd = (zzyd)paramObject;
    }
    while ((this.type == localzzyd.type) && (this.zzcew == localzzyd.zzcew) && (this.tag == localzzyd.tag) && (this.zzcex == localzzyd.zzcex));
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 * (1147 + this.type) + this.zzcew.hashCode()) + this.tag);
    if (this.zzcex);
    for (int j = 1; ; j = 0)
      return j + i;
  }

  protected final void zza(Object paramObject, zzya paramzzya)
  {
    try
    {
      paramzzya.zzcd(this.tag);
      switch (this.type)
      {
      default:
        int j = this.type;
        throw new IllegalArgumentException(24 + "Unknown type " + j);
      case 10:
      case 11:
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
    int i = this.tag >>> 3;
    ((zzyi)paramObject).zza(paramzzya);
    paramzzya.zzc(i, 4);
    return;
    paramzzya.zzb((zzyi)paramObject);
  }

  final T zzai(List<zzyk> paramList)
  {
    int i = 0;
    Object localObject;
    if (paramList == null)
      localObject = null;
    while (true)
    {
      return localObject;
      if (!this.zzcex)
        break;
      ArrayList localArrayList = new ArrayList();
      for (int j = 0; j < paramList.size(); j++)
      {
        zzyk localzzyk1 = (zzyk)paramList.get(j);
        if (localzzyk1.zzbtz.length != 0)
          localArrayList.add(zze(zzxz.zzn(localzzyk1.zzbtz)));
      }
      int k = localArrayList.size();
      if (k == 0)
        return null;
      localObject = this.zzcew.cast(Array.newInstance(this.zzcew.getComponentType(), k));
      while (i < k)
      {
        Array.set(localObject, i, localArrayList.get(i));
        i++;
      }
    }
    if (paramList.isEmpty())
      return null;
    zzyk localzzyk2 = (zzyk)paramList.get(-1 + paramList.size());
    return this.zzcew.cast(zze(zzxz.zzn(localzzyk2.zzbtz)));
  }

  protected final int zzao(Object paramObject)
  {
    int i = this.tag >>> 3;
    switch (this.type)
    {
    default:
      int j = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + j);
    case 10:
      zzyi localzzyi = (zzyi)paramObject;
      return (zzya.zzbd(i) << 1) + localzzyi.zzvx();
    case 11:
    }
    return zzya.zzb(i, (zzyi)paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyd
 * JD-Core Version:    0.6.2
 */