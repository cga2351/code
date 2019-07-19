package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzq
  implements Cloneable
{
  private Object value;
  private zzo<?, ?> zzhi;
  private List<zzv> zzhj = new ArrayList();

  private final byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzg()];
    zza(zzl.zzb(arrayOfByte));
    return arrayOfByte;
  }

  private final zzq zzt()
  {
    zzq localzzq = new zzq();
    try
    {
      localzzq.zzhi = this.zzhi;
      if (this.zzhj == null)
        localzzq.zzhj = null;
      while (true)
      {
        if (this.value == null)
          break label379;
        if (!(this.value instanceof zzt))
          break;
        localzzq.value = ((zzt)((zzt)this.value).clone());
        return localzzq;
        localzzq.zzhj.addAll(this.zzhj);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((this.value instanceof byte[]))
    {
      localzzq.value = ((byte[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof byte[][]))
    {
      byte[][] arrayOfByte = (byte[][])this.value;
      byte[][] arrayOfByte1 = new byte[arrayOfByte.length][];
      localzzq.value = arrayOfByte1;
      for (int j = 0; j < arrayOfByte.length; j++)
        arrayOfByte1[j] = ((byte[])arrayOfByte[j].clone());
    }
    if ((this.value instanceof boolean[]))
    {
      localzzq.value = ((boolean[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof int[]))
    {
      localzzq.value = ((int[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof long[]))
    {
      localzzq.value = ((long[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof float[]))
    {
      localzzq.value = ((float[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof double[]))
    {
      localzzq.value = ((double[])this.value).clone();
      return localzzq;
    }
    if ((this.value instanceof zzt[]))
    {
      zzt[] arrayOfzzt1 = (zzt[])this.value;
      zzt[] arrayOfzzt2 = new zzt[arrayOfzzt1.length];
      localzzq.value = arrayOfzzt2;
      for (int i = 0; i < arrayOfzzt1.length; i++)
        arrayOfzzt2[i] = ((zzt)arrayOfzzt1[i].clone());
    }
    label379: return localzzq;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    zzq localzzq;
    zzo localzzo1;
    zzo localzzo2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof zzq;
        bool2 = false;
      }
      while (!bool1);
      localzzq = (zzq)paramObject;
      if ((this.value == null) || (localzzq.value == null))
        break;
      localzzo1 = this.zzhi;
      localzzo2 = localzzq.zzhi;
      bool2 = false;
    }
    while (localzzo1 != localzzo2);
    if (!this.zzhi.zzhd.isArray())
      return this.value.equals(localzzq.value);
    if ((this.value instanceof byte[]))
      return Arrays.equals((byte[])this.value, (byte[])localzzq.value);
    if ((this.value instanceof int[]))
      return Arrays.equals((int[])this.value, (int[])localzzq.value);
    if ((this.value instanceof long[]))
      return Arrays.equals((long[])this.value, (long[])localzzq.value);
    if ((this.value instanceof float[]))
      return Arrays.equals((float[])this.value, (float[])localzzq.value);
    if ((this.value instanceof double[]))
      return Arrays.equals((double[])this.value, (double[])localzzq.value);
    if ((this.value instanceof boolean[]))
      return Arrays.equals((boolean[])this.value, (boolean[])localzzq.value);
    return Arrays.deepEquals((Object[])this.value, (Object[])localzzq.value);
    if ((this.zzhj != null) && (localzzq.zzhj != null))
      return this.zzhj.equals(localzzq.zzhj);
    try
    {
      boolean bool3 = Arrays.equals(toByteArray(), localzzq.toByteArray());
      return bool3;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }

  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }

  final void zza(zzl paramzzl)
    throws IOException
  {
    if (this.value != null)
      throw new NoSuchMethodError();
    Iterator localIterator = this.zzhj.iterator();
    while (localIterator.hasNext())
    {
      zzv localzzv = (zzv)localIterator.next();
      paramzzl.zzl(localzzv.tag);
      paramzzl.zzc(localzzv.zzhm);
    }
  }

  final void zza(zzv paramzzv)
    throws IOException
  {
    if (this.zzhj != null)
    {
      this.zzhj.add(paramzzv);
      return;
    }
    if ((this.value instanceof zzt))
    {
      byte[] arrayOfByte = paramzzv.zzhm;
      zzk localzzk = zzk.zza(arrayOfByte, 0, arrayOfByte.length);
      int i = localzzk.zzk();
      if (i != arrayOfByte.length - zzl.zzi(i))
        throw zzs.zzu();
      zzt localzzt = ((zzt)this.value).zza(localzzk);
      this.zzhi = this.zzhi;
      this.value = localzzt;
      this.zzhj = null;
      return;
    }
    if ((this.value instanceof zzt[]))
    {
      Collections.singletonList(paramzzv);
      throw new NoSuchMethodError();
    }
    Collections.singletonList(paramzzv);
    throw new NoSuchMethodError();
  }

  final int zzg()
  {
    if (this.value != null)
      throw new NoSuchMethodError();
    Iterator localIterator = this.zzhj.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      zzv localzzv = (zzv)localIterator.next();
      i += 0 + zzl.zzm(localzzv.tag) + localzzv.zzhm.length;
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzq
 * JD-Core Version:    0.6.2
 */