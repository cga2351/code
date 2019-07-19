package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzxe
{
  private static final zzxe zzcch = new zzxe(0, new int[0], new Object[0], false);
  private int count;
  private boolean zzbtn;
  private int zzbyg = -1;
  private Object[] zzcat;
  private int[] zzcci;

  private zzxe()
  {
    this(0, new int[8], new Object[8], true);
  }

  private zzxe(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.zzcci = paramArrayOfInt;
    this.zzcat = paramArrayOfObject;
    this.zzbtn = paramBoolean;
  }

  static zzxe zza(zzxe paramzzxe1, zzxe paramzzxe2)
  {
    int i = paramzzxe1.count + paramzzxe2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzxe1.zzcci, i);
    System.arraycopy(paramzzxe2.zzcci, 0, arrayOfInt, paramzzxe1.count, paramzzxe2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzxe1.zzcat, i);
    System.arraycopy(paramzzxe2.zzcat, 0, arrayOfObject, paramzzxe1.count, paramzzxe2.count);
    return new zzxe(i, arrayOfInt, arrayOfObject, true);
  }

  private static void zzb(int paramInt, Object paramObject, zzxy paramzzxy)
    throws IOException
  {
    int i = paramInt >>> 3;
    switch (paramInt & 0x7)
    {
    case 4:
    default:
      throw new RuntimeException(zzuv.zzwu());
    case 0:
      paramzzxy.zzi(i, ((Long)paramObject).longValue());
      return;
    case 5:
      paramzzxy.zzg(i, ((Integer)paramObject).intValue());
      return;
    case 1:
      paramzzxy.zzc(i, ((Long)paramObject).longValue());
      return;
    case 2:
      paramzzxy.zza(i, (zzte)paramObject);
      return;
    case 3:
    }
    if (paramzzxy.zzvm() == zzuo.zze.zzbyx)
    {
      paramzzxy.zzbm(i);
      ((zzxe)paramObject).zzb(paramzzxy);
      paramzzxy.zzbn(i);
      return;
    }
    paramzzxy.zzbn(i);
    ((zzxe)paramObject).zzb(paramzzxy);
    paramzzxy.zzbm(i);
  }

  public static zzxe zzyl()
  {
    return zzcch;
  }

  static zzxe zzym()
  {
    return new zzxe();
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
      if (!(paramObject instanceof zzxe))
        return false;
      zzxe localzzxe = (zzxe)paramObject;
      int j;
      int k;
      label80: int n;
      if (this.count == localzzxe.count)
      {
        int[] arrayOfInt1 = this.zzcci;
        int[] arrayOfInt2 = localzzxe.zzcci;
        int i = this.count;
        j = 0;
        if (j >= i)
          break label145;
        if (arrayOfInt1[j] == arrayOfInt2[j])
          break label139;
        k = 0;
        if (k != 0)
        {
          Object[] arrayOfObject1 = this.zzcat;
          Object[] arrayOfObject2 = localzzxe.zzcat;
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
    int[] arrayOfInt = this.zzcci;
    int m = this.count;
    int n = 0;
    int i1 = i;
    while (n < m)
    {
      i1 = i1 * 31 + arrayOfInt[n];
      n++;
    }
    int i2 = 31 * (k + i1);
    Object[] arrayOfObject = this.zzcat;
    int i3 = this.count;
    while (j < i3)
    {
      i = i * 31 + arrayOfObject[j].hashCode();
      j++;
    }
    return i2 + i;
  }

  final void zza(zzxy paramzzxy)
    throws IOException
  {
    if (paramzzxy.zzvm() == zzuo.zze.zzbyy)
      for (int j = -1 + this.count; j >= 0; j--)
        paramzzxy.zza(this.zzcci[j] >>> 3, this.zzcat[j]);
    for (int i = 0; i < this.count; i++)
      paramzzxy.zza(this.zzcci[i] >>> 3, this.zzcat[i]);
  }

  final void zzb(int paramInt, Object paramObject)
  {
    if (!this.zzbtn)
      throw new UnsupportedOperationException();
    if (this.count == this.zzcci.length)
      if (this.count >= 4)
        break label103;
    label103: for (int i = 8; ; i = this.count >> 1)
    {
      int j = i + this.count;
      this.zzcci = Arrays.copyOf(this.zzcci, j);
      this.zzcat = Arrays.copyOf(this.zzcat, j);
      this.zzcci[this.count] = paramInt;
      this.zzcat[this.count] = paramObject;
      this.count = (1 + this.count);
      return;
    }
  }

  public final void zzb(zzxy paramzzxy)
    throws IOException
  {
    if (this.count == 0);
    while (true)
    {
      return;
      if (paramzzxy.zzvm() == zzuo.zze.zzbyx)
        for (int j = 0; j < this.count; j++)
          zzb(this.zzcci[j], this.zzcat[j], paramzzxy);
      else
        for (int i = -1 + this.count; i >= 0; i--)
          zzb(this.zzcci[i], this.zzcat[i], paramzzxy);
    }
  }

  final void zzb(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.count; i++)
      zzvy.zzb(paramStringBuilder, paramInt, String.valueOf(this.zzcci[i] >>> 3), this.zzcat[i]);
  }

  public final void zzsw()
  {
    this.zzbtn = false;
  }

  public final int zzvx()
  {
    int i = this.zzbyg;
    if (i != -1)
      return i;
    int j = 0;
    int k = 0;
    if (j < this.count)
    {
      int m = this.zzcci[j];
      int n = m >>> 3;
      switch (m & 0x7)
      {
      case 4:
      default:
        throw new IllegalStateException(zzuv.zzwu());
      case 0:
        k += zztv.zze(n, ((Long)this.zzcat[j]).longValue());
      case 5:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        j++;
        break;
        k += zztv.zzk(n, ((Integer)this.zzcat[j]).intValue());
        continue;
        k += zztv.zzg(n, ((Long)this.zzcat[j]).longValue());
        continue;
        k += zztv.zzc(n, (zzte)this.zzcat[j]);
        continue;
        k += (zztv.zzbd(n) << 1) + ((zzxe)this.zzcat[j]).zzvx();
      }
    }
    this.zzbyg = k;
    return k;
  }

  public final int zzyn()
  {
    int i = this.zzbyg;
    if (i != -1)
      return i;
    int j = 0;
    int k = 0;
    while (j < this.count)
    {
      k += zztv.zzd(this.zzcci[j] >>> 3, (zzte)this.zzcat[j]);
      j++;
    }
    this.zzbyg = k;
    return k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxe
 * JD-Core Version:    0.6.2
 */