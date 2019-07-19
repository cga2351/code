package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

public final class zzdqt
{
  private static final zzdqt zzhlf = new zzdqt(0, new int[0], new Object[0], false);
  private int count;
  private boolean zzhci;
  private int zzhhe = -1;
  private Object[] zzhjr;
  private int[] zzhlg;

  private zzdqt()
  {
    this(0, new int[8], new Object[8], true);
  }

  private zzdqt(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.zzhlg = paramArrayOfInt;
    this.zzhjr = paramArrayOfObject;
    this.zzhci = paramBoolean;
  }

  static zzdqt zza(zzdqt paramzzdqt1, zzdqt paramzzdqt2)
  {
    int i = paramzzdqt1.count + paramzzdqt2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzdqt1.zzhlg, i);
    System.arraycopy(paramzzdqt2.zzhlg, 0, arrayOfInt, paramzzdqt1.count, paramzzdqt2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzdqt1.zzhjr, i);
    System.arraycopy(paramzzdqt2.zzhjr, 0, arrayOfObject, paramzzdqt1.count, paramzzdqt2.count);
    return new zzdqt(i, arrayOfInt, arrayOfObject, true);
  }

  public static zzdqt zzazz()
  {
    return zzhlf;
  }

  private static void zzb(int paramInt, Object paramObject, zzdrn paramzzdrn)
    throws IOException
  {
    int i = paramInt >>> 3;
    switch (paramInt & 0x7)
    {
    case 4:
    default:
      throw new RuntimeException(zzdoj.zzayi());
    case 0:
      paramzzdrn.zzp(i, ((Long)paramObject).longValue());
      return;
    case 5:
      paramzzdrn.zzaa(i, ((Integer)paramObject).intValue());
      return;
    case 1:
      paramzzdrn.zzj(i, ((Long)paramObject).longValue());
      return;
    case 2:
      paramzzdrn.zza(i, (zzdmq)paramObject);
      return;
    case 3:
    }
    if (paramzzdrn.zzawy() == zzdoa.zze.zzhhv)
    {
      paramzzdrn.zzgm(i);
      ((zzdqt)paramObject).zzb(paramzzdrn);
      paramzzdrn.zzgn(i);
      return;
    }
    paramzzdrn.zzgn(i);
    ((zzdqt)paramObject).zzb(paramzzdrn);
    paramzzdrn.zzgm(i);
  }

  static zzdqt zzbaa()
  {
    return new zzdqt();
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    label139: label145: label151: label157: label161: 
    while (true)
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof zzdqt))
        return false;
      zzdqt localzzdqt = (zzdqt)paramObject;
      int j;
      int k;
      label80: int n;
      if (this.count == localzzdqt.count)
      {
        int[] arrayOfInt1 = this.zzhlg;
        int[] arrayOfInt2 = localzzdqt.zzhlg;
        int i = this.count;
        j = 0;
        if (j >= i)
          break label145;
        if (arrayOfInt1[j] == arrayOfInt2[j])
          break label139;
        k = 0;
        if (k != 0)
        {
          Object[] arrayOfObject1 = this.zzhjr;
          Object[] arrayOfObject2 = localzzdqt.zzhjr;
          int m = this.count;
          n = 0;
          label106: if (n >= m)
            break label157;
          if (arrayOfObject1[n].equals(arrayOfObject2[n]))
            break label151;
        }
      }
      for (int i1 = 0; ; i1 = 1)
      {
        if (i1 != 0)
          break label161;
        return false;
        j++;
        break;
        k = 1;
        break label80;
        n++;
        break label106;
      }
    }
  }

  public final int hashCode()
  {
    int i = 17;
    int j = 0;
    int k = 31 * (527 + this.count);
    int[] arrayOfInt = this.zzhlg;
    int m = this.count;
    int n = 0;
    int i1 = i;
    while (n < m)
    {
      i1 = i1 * 31 + arrayOfInt[n];
      n++;
    }
    int i2 = 31 * (k + i1);
    Object[] arrayOfObject = this.zzhjr;
    int i3 = this.count;
    while (j < i3)
    {
      i = i * 31 + arrayOfObject[j].hashCode();
      j++;
    }
    return i2 + i;
  }

  final void zza(zzdrn paramzzdrn)
    throws IOException
  {
    if (paramzzdrn.zzawy() == zzdoa.zze.zzhhw)
      for (int j = -1 + this.count; j >= 0; j--)
        paramzzdrn.zzb(this.zzhlg[j] >>> 3, this.zzhjr[j]);
    for (int i = 0; i < this.count; i++)
      paramzzdrn.zzb(this.zzhlg[i] >>> 3, this.zzhjr[i]);
  }

  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.count; i++)
      zzdpm.zza(paramStringBuilder, paramInt, String.valueOf(this.zzhlg[i] >>> 3), this.zzhjr[i]);
  }

  public final void zzavj()
  {
    this.zzhci = false;
  }

  public final int zzaxj()
  {
    int i = this.zzhhe;
    if (i != -1)
      return i;
    int j = 0;
    int k = 0;
    if (j < this.count)
    {
      int m = this.zzhlg[j];
      int n = m >>> 3;
      switch (m & 0x7)
      {
      case 4:
      default:
        throw new IllegalStateException(zzdoj.zzayi());
      case 0:
        k += zzdnh.zzl(n, ((Long)this.zzhjr[j]).longValue());
      case 5:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        j++;
        break;
        k += zzdnh.zzae(n, ((Integer)this.zzhjr[j]).intValue());
        continue;
        k += zzdnh.zzn(n, ((Long)this.zzhjr[j]).longValue());
        continue;
        k += zzdnh.zzc(n, (zzdmq)this.zzhjr[j]);
        continue;
        k += (zzdnh.zzgd(n) << 1) + ((zzdqt)this.zzhjr[j]).zzaxj();
      }
    }
    this.zzhhe = k;
    return k;
  }

  public final void zzb(zzdrn paramzzdrn)
    throws IOException
  {
    if (this.count == 0);
    while (true)
    {
      return;
      if (paramzzdrn.zzawy() == zzdoa.zze.zzhhv)
        for (int j = 0; j < this.count; j++)
          zzb(this.zzhlg[j], this.zzhjr[j], paramzzdrn);
      else
        for (int i = -1 + this.count; i >= 0; i--)
          zzb(this.zzhlg[i], this.zzhjr[i], paramzzdrn);
    }
  }

  public final int zzbab()
  {
    int i = this.zzhhe;
    if (i != -1)
      return i;
    int j = 0;
    int k = 0;
    while (j < this.count)
    {
      k += zzdnh.zzd(this.zzhlg[j] >>> 3, (zzdmq)this.zzhjr[j]);
      j++;
    }
    this.zzhhe = k;
    return k;
  }

  final void zzc(int paramInt, Object paramObject)
  {
    if (!this.zzhci)
      throw new UnsupportedOperationException();
    if (this.count == this.zzhlg.length)
      if (this.count >= 4)
        break label103;
    label103: for (int i = 8; ; i = this.count >> 1)
    {
      int j = i + this.count;
      this.zzhlg = Arrays.copyOf(this.zzhlg, j);
      this.zzhjr = Arrays.copyOf(this.zzhjr, j);
      this.zzhlg[this.count] = paramInt;
      this.zzhjr[this.count] = paramObject;
      this.count = (1 + this.count);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqt
 * JD-Core Version:    0.6.2
 */