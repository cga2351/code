package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzyf
  implements Cloneable
{
  private Object value;
  private zzyd<?, ?> zzcfc;
  private List<zzyk> zzcfd = new ArrayList();

  private final byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzf()];
    zza(zzya.zzo(arrayOfByte));
    return arrayOfByte;
  }

  private final zzyf zzzc()
  {
    zzyf localzzyf = new zzyf();
    try
    {
      localzzyf.zzcfc = this.zzcfc;
      if (this.zzcfd == null)
        localzzyf.zzcfd = null;
      while (true)
      {
        if (this.value == null)
          break label379;
        if (!(this.value instanceof zzyi))
          break;
        localzzyf.value = ((zzyi)((zzyi)this.value).clone());
        return localzzyf;
        localzzyf.zzcfd.addAll(this.zzcfd);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((this.value instanceof byte[]))
    {
      localzzyf.value = ((byte[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof byte[][]))
    {
      byte[][] arrayOfByte = (byte[][])this.value;
      byte[][] arrayOfByte1 = new byte[arrayOfByte.length][];
      localzzyf.value = arrayOfByte1;
      for (int j = 0; j < arrayOfByte.length; j++)
        arrayOfByte1[j] = ((byte[])arrayOfByte[j].clone());
    }
    if ((this.value instanceof boolean[]))
    {
      localzzyf.value = ((boolean[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof int[]))
    {
      localzzyf.value = ((int[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof long[]))
    {
      localzzyf.value = ((long[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof float[]))
    {
      localzzyf.value = ((float[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof double[]))
    {
      localzzyf.value = ((double[])this.value).clone();
      return localzzyf;
    }
    if ((this.value instanceof zzyi[]))
    {
      zzyi[] arrayOfzzyi1 = (zzyi[])this.value;
      zzyi[] arrayOfzzyi2 = new zzyi[arrayOfzzyi1.length];
      localzzyf.value = arrayOfzzyi2;
      for (int i = 0; i < arrayOfzzyi1.length; i++)
        arrayOfzzyi2[i] = ((zzyi)arrayOfzzyi1[i].clone());
    }
    label379: return localzzyf;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    zzyf localzzyf;
    zzyd localzzyd1;
    zzyd localzzyd2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof zzyf;
        bool2 = false;
      }
      while (!bool1);
      localzzyf = (zzyf)paramObject;
      if ((this.value == null) || (localzzyf.value == null))
        break;
      localzzyd1 = this.zzcfc;
      localzzyd2 = localzzyf.zzcfc;
      bool2 = false;
    }
    while (localzzyd1 != localzzyd2);
    if (!this.zzcfc.zzcew.isArray())
      return this.value.equals(localzzyf.value);
    if ((this.value instanceof byte[]))
      return Arrays.equals((byte[])this.value, (byte[])localzzyf.value);
    if ((this.value instanceof int[]))
      return Arrays.equals((int[])this.value, (int[])localzzyf.value);
    if ((this.value instanceof long[]))
      return Arrays.equals((long[])this.value, (long[])localzzyf.value);
    if ((this.value instanceof float[]))
      return Arrays.equals((float[])this.value, (float[])localzzyf.value);
    if ((this.value instanceof double[]))
      return Arrays.equals((double[])this.value, (double[])localzzyf.value);
    if ((this.value instanceof boolean[]))
      return Arrays.equals((boolean[])this.value, (boolean[])localzzyf.value);
    return Arrays.deepEquals((Object[])this.value, (Object[])localzzyf.value);
    if ((this.zzcfd != null) && (localzzyf.zzcfd != null))
      return this.zzcfd.equals(localzzyf.zzcfd);
    try
    {
      boolean bool3 = Arrays.equals(toByteArray(), localzzyf.toByteArray());
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

  final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.value != null)
    {
      zzyd localzzyd = this.zzcfc;
      Object localObject1 = this.value;
      if (localzzyd.zzcex)
      {
        int i = Array.getLength(localObject1);
        for (int j = 0; j < i; j++)
        {
          Object localObject2 = Array.get(localObject1, j);
          if (localObject2 != null)
            localzzyd.zza(localObject2, paramzzya);
        }
      }
      localzzyd.zza(localObject1, paramzzya);
    }
    while (true)
    {
      return;
      Iterator localIterator = this.zzcfd.iterator();
      while (localIterator.hasNext())
      {
        zzyk localzzyk = (zzyk)localIterator.next();
        paramzzya.zzcd(localzzyk.tag);
        paramzzya.zzp(localzzyk.zzbtz);
      }
    }
  }

  final void zza(zzyk paramzzyk)
    throws IOException
  {
    if (this.zzcfd != null)
    {
      this.zzcfd.add(paramzzyk);
      return;
    }
    Object localObject;
    if ((this.value instanceof zzyi))
    {
      byte[] arrayOfByte = paramzzyk.zzbtz;
      zzxz localzzxz = zzxz.zzj(arrayOfByte, 0, arrayOfByte.length);
      int i = localzzxz.zzvb();
      if (i != arrayOfByte.length - zzya.zzbe(i))
        throw zzyh.zzzd();
      localObject = ((zzyi)this.value).zza(localzzxz);
    }
    while (true)
    {
      this.zzcfc = this.zzcfc;
      this.value = localObject;
      this.zzcfd = null;
      return;
      if ((this.value instanceof zzyi[]))
      {
        zzyi[] arrayOfzzyi1 = (zzyi[])this.zzcfc.zzai(Collections.singletonList(paramzzyk));
        zzyi[] arrayOfzzyi2 = (zzyi[])this.value;
        localObject = (zzyi[])Arrays.copyOf(arrayOfzzyi2, arrayOfzzyi2.length + arrayOfzzyi1.length);
        System.arraycopy(arrayOfzzyi1, 0, localObject, arrayOfzzyi2.length, arrayOfzzyi1.length);
      }
      else if ((this.value instanceof zzvv))
      {
        zzvv localzzvv = (zzvv)this.zzcfc.zzai(Collections.singletonList(paramzzyk));
        localObject = ((zzvv)this.value).zzwh().zza(localzzvv).zzwo();
      }
      else if ((this.value instanceof zzvv[]))
      {
        zzvv[] arrayOfzzvv1 = (zzvv[])this.zzcfc.zzai(Collections.singletonList(paramzzyk));
        zzvv[] arrayOfzzvv2 = (zzvv[])this.value;
        localObject = (zzvv[])Arrays.copyOf(arrayOfzzvv2, arrayOfzzvv2.length + arrayOfzzvv1.length);
        System.arraycopy(arrayOfzzvv1, 0, localObject, arrayOfzzvv2.length, arrayOfzzvv1.length);
      }
      else
      {
        localObject = this.zzcfc.zzai(Collections.singletonList(paramzzyk));
      }
    }
  }

  final <T> T zzb(zzyd<?, T> paramzzyd)
  {
    if (this.value != null)
    {
      if (!this.zzcfc.equals(paramzzyd))
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
    }
    else
    {
      this.zzcfc = paramzzyd;
      this.value = paramzzyd.zzai(this.zzcfd);
      this.zzcfd = null;
    }
    return this.value;
  }

  final int zzf()
  {
    int i = 0;
    if (this.value != null)
    {
      zzyd localzzyd = this.zzcfc;
      Object localObject1 = this.value;
      if (localzzyd.zzcex)
      {
        int k = Array.getLength(localObject1);
        for (int m = 0; m < k; m++)
        {
          Object localObject2 = Array.get(localObject1, m);
          if (localObject2 != null)
            i += localzzyd.zzao(localObject2);
        }
      }
      i = localzzyd.zzao(localObject1);
      return i;
    }
    Iterator localIterator = this.zzcfd.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      zzyk localzzyk = (zzyk)localIterator.next();
      j += 0 + zzya.zzbl(localzzyk.tag) + localzzyk.zzbtz.length;
    }
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyf
 * JD-Core Version:    0.6.2
 */