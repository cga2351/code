package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzdrt
  implements Cloneable
{
  private Object value;
  private zzdrr<?, ?> zzhnu;
  private List<Object> zzhnv = new ArrayList();

  private final byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzor()];
    zza(zzdro.zzaf(arrayOfByte));
    return arrayOfByte;
  }

  private final zzdrt zzbam()
  {
    zzdrt localzzdrt = new zzdrt();
    try
    {
      localzzdrt.zzhnu = this.zzhnu;
      if (this.zzhnv == null)
        localzzdrt.zzhnv = null;
      while (true)
      {
        if (this.value == null)
          break label379;
        if (!(this.value instanceof zzdrv))
          break;
        localzzdrt.value = ((zzdrv)((zzdrv)this.value).clone());
        return localzzdrt;
        localzzdrt.zzhnv.addAll(this.zzhnv);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((this.value instanceof byte[]))
    {
      localzzdrt.value = ((byte[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof byte[][]))
    {
      byte[][] arrayOfByte = (byte[][])this.value;
      byte[][] arrayOfByte1 = new byte[arrayOfByte.length][];
      localzzdrt.value = arrayOfByte1;
      for (int j = 0; j < arrayOfByte.length; j++)
        arrayOfByte1[j] = ((byte[])arrayOfByte[j].clone());
    }
    if ((this.value instanceof boolean[]))
    {
      localzzdrt.value = ((boolean[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof int[]))
    {
      localzzdrt.value = ((int[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof long[]))
    {
      localzzdrt.value = ((long[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof float[]))
    {
      localzzdrt.value = ((float[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof double[]))
    {
      localzzdrt.value = ((double[])this.value).clone();
      return localzzdrt;
    }
    if ((this.value instanceof zzdrv[]))
    {
      zzdrv[] arrayOfzzdrv1 = (zzdrv[])this.value;
      zzdrv[] arrayOfzzdrv2 = new zzdrv[arrayOfzzdrv1.length];
      localzzdrt.value = arrayOfzzdrv2;
      for (int i = 0; i < arrayOfzzdrv1.length; i++)
        arrayOfzzdrv2[i] = ((zzdrv)arrayOfzzdrv1[i].clone());
    }
    label379: return localzzdrt;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    zzdrt localzzdrt;
    zzdrr localzzdrr1;
    zzdrr localzzdrr2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof zzdrt;
        bool2 = false;
      }
      while (!bool1);
      localzzdrt = (zzdrt)paramObject;
      if ((this.value == null) || (localzzdrt.value == null))
        break;
      localzzdrr1 = this.zzhnu;
      localzzdrr2 = localzzdrt.zzhnu;
      bool2 = false;
    }
    while (localzzdrr1 != localzzdrr2);
    if (!this.zzhnu.zzhnp.isArray())
      return this.value.equals(localzzdrt.value);
    if ((this.value instanceof byte[]))
      return Arrays.equals((byte[])this.value, (byte[])localzzdrt.value);
    if ((this.value instanceof int[]))
      return Arrays.equals((int[])this.value, (int[])localzzdrt.value);
    if ((this.value instanceof long[]))
      return Arrays.equals((long[])this.value, (long[])localzzdrt.value);
    if ((this.value instanceof float[]))
      return Arrays.equals((float[])this.value, (float[])localzzdrt.value);
    if ((this.value instanceof double[]))
      return Arrays.equals((double[])this.value, (double[])localzzdrt.value);
    if ((this.value instanceof boolean[]))
      return Arrays.equals((boolean[])this.value, (boolean[])localzzdrt.value);
    return Arrays.deepEquals((Object[])this.value, (Object[])localzzdrt.value);
    if ((this.zzhnv != null) && (localzzdrt.zzhnv != null))
      return this.zzhnv.equals(localzzdrt.zzhnv);
    try
    {
      boolean bool3 = Arrays.equals(toByteArray(), localzzdrt.toByteArray());
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

  final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.value != null)
      throw new NoSuchMethodError();
    Iterator localIterator = this.zzhnv.iterator();
    if (localIterator.hasNext())
    {
      localIterator.next();
      throw new NoSuchMethodError();
    }
  }

  final int zzor()
  {
    if (this.value != null)
      throw new NoSuchMethodError();
    Iterator localIterator = this.zzhnv.iterator();
    if (localIterator.hasNext())
    {
      localIterator.next();
      throw new NoSuchMethodError();
    }
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrt
 * JD-Core Version:    0.6.2
 */