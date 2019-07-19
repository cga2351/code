package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzxz
{
  private final byte[] buffer;
  private int zzbua;
  private int zzbub = 64;
  private int zzbuc = 67108864;
  private int zzbug;
  private int zzbui;
  private int zzbuj = 2147483647;
  private final int zzceo;
  private final int zzcep;
  private int zzceq;
  private int zzcer;
  private zztq zzces;

  private zzxz(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.zzceo = paramInt1;
    int i = paramInt1 + paramInt2;
    this.zzceq = i;
    this.zzcep = i;
    this.zzcer = paramInt1;
  }

  private final void zzau(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw zzyh.zzze();
    if (paramInt + this.zzcer > this.zzbuj)
    {
      zzau(this.zzbuj - this.zzcer);
      throw zzyh.zzzd();
    }
    if (paramInt <= this.zzceq - this.zzcer)
    {
      this.zzcer = (paramInt + this.zzcer);
      return;
    }
    throw zzyh.zzzd();
  }

  public static zzxz zzj(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzxz(paramArrayOfByte, 0, paramInt2);
  }

  public static zzxz zzn(byte[] paramArrayOfByte)
  {
    return zzj(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  private final void zzvf()
  {
    this.zzceq += this.zzbug;
    int i = this.zzceq;
    if (i > this.zzbuj)
    {
      this.zzbug = (i - this.zzbuj);
      this.zzceq -= this.zzbug;
      return;
    }
    this.zzbug = 0;
  }

  private final byte zzvg()
    throws IOException
  {
    if (this.zzcer == this.zzceq)
      throw zzyh.zzzd();
    byte[] arrayOfByte = this.buffer;
    int i = this.zzcer;
    this.zzcer = (i + 1);
    return arrayOfByte[i];
  }

  private final zztq zzyx()
    throws IOException
  {
    if (this.zzces == null)
      this.zzces = zztq.zzd(this.buffer, this.zzceo, this.zzcep);
    int i = this.zzces.zzva();
    int j = this.zzcer - this.zzceo;
    if (i > j)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(j);
      throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", arrayOfObject));
    }
    this.zzces.zzau(j - i);
    this.zzces.zzar(this.zzbub - this.zzbua);
    return this.zzces;
  }

  public final int getPosition()
  {
    return this.zzcer - this.zzceo;
  }

  public final String readString()
    throws IOException
  {
    int i = zzvb();
    if (i < 0)
      throw zzyh.zzze();
    if (i > this.zzceq - this.zzcer)
      throw zzyh.zzzd();
    String str = new String(this.buffer, this.zzcer, i, zzyg.UTF_8);
    this.zzcer = (i + this.zzcer);
    return str;
  }

  public final <T extends zzuo<T, ?>> T zza(zzwf<T> paramzzwf)
    throws IOException
  {
    try
    {
      zzuo localzzuo = (zzuo)zzyx().zza(paramzzwf, zzub.zzvs());
      zzaq(this.zzbui);
      return localzzuo;
    }
    catch (zzuv localzzuv)
    {
      throw new zzyh("", localzzuv);
    }
  }

  public final void zza(zzyi paramzzyi)
    throws IOException
  {
    int i = zzvb();
    if (this.zzbua >= this.zzbub)
      throw zzyh.zzzg();
    int j = zzas(i);
    this.zzbua = (1 + this.zzbua);
    paramzzyi.zza(this);
    zzap(0);
    this.zzbua = (-1 + this.zzbua);
    zzat(j);
  }

  public final void zza(zzyi paramzzyi, int paramInt)
    throws IOException
  {
    if (this.zzbua >= this.zzbub)
      throw zzyh.zzzg();
    this.zzbua = (1 + this.zzbua);
    paramzzyi.zza(this);
    zzap(0x4 | paramInt << 3);
    this.zzbua = (-1 + this.zzbua);
  }

  public final void zzap(int paramInt)
    throws zzyh
  {
    if (this.zzbui != paramInt)
      throw new zzyh("Protocol message end-group tag did not match expected tag.");
  }

  public final boolean zzaq(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default:
      throw new zzyh("Protocol message tag had invalid wire type.");
    case 0:
      zzvb();
      return true;
    case 1:
      zzve();
      return true;
    case 2:
      zzau(zzvb());
      return true;
    case 3:
      int i;
      do
        i = zzuj();
      while ((i != 0) && (zzaq(i)));
      zzap(0x4 | paramInt >>> 3 << 3);
      return true;
    case 4:
      return false;
    case 5:
    }
    zzvd();
    return true;
  }

  public final int zzas(int paramInt)
    throws zzyh
  {
    if (paramInt < 0)
      throw zzyh.zzze();
    int i = paramInt + this.zzcer;
    int j = this.zzbuj;
    if (i > j)
      throw zzyh.zzzd();
    this.zzbuj = i;
    zzvf();
    return j;
  }

  public final void zzat(int paramInt)
  {
    this.zzbuj = paramInt;
    zzvf();
  }

  public final void zzcb(int paramInt)
  {
    zzt(paramInt, this.zzbui);
  }

  public final byte[] zzs(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return zzyl.zzcfq;
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1 + this.zzceo;
    System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }

  final void zzt(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.zzcer - this.zzceo)
    {
      int i = this.zzcer - this.zzceo;
      throw new IllegalArgumentException(50 + "Position " + paramInt1 + " is beyond current " + i);
    }
    if (paramInt1 < 0)
      throw new IllegalArgumentException(24 + "Bad position " + paramInt1);
    this.zzcer = (paramInt1 + this.zzceo);
    this.zzbui = paramInt2;
  }

  public final int zzuj()
    throws IOException
  {
    if (this.zzcer == this.zzceq)
    {
      this.zzbui = 0;
      return 0;
    }
    this.zzbui = zzvb();
    if (this.zzbui == 0)
      throw new zzyh("Protocol message contained an invalid tag (zero).");
    return this.zzbui;
  }

  public final boolean zzup()
    throws IOException
  {
    return zzvb() != 0;
  }

  public final int zzvb()
    throws IOException
  {
    int i = zzvg();
    if (i >= 0);
    int i4;
    do
    {
      return i;
      int j = i & 0x7F;
      int k = zzvg();
      if (k >= 0)
        return j | k << 7;
      int m = j | (k & 0x7F) << 7;
      int n = zzvg();
      if (n >= 0)
        return m | n << 14;
      int i1 = m | (n & 0x7F) << 14;
      int i2 = zzvg();
      if (i2 >= 0)
        return i1 | i2 << 21;
      int i3 = i1 | (i2 & 0x7F) << 21;
      i4 = zzvg();
      i = i3 | i4 << 28;
    }
    while (i4 >= 0);
    for (int i5 = 0; ; i5++)
    {
      if (i5 >= 5)
        break label151;
      if (zzvg() >= 0)
        break;
    }
    label151: throw zzyh.zzzf();
  }

  public final long zzvc()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzvg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
      i += 7;
    }
    throw zzyh.zzzf();
  }

  public final int zzvd()
    throws IOException
  {
    int i = zzvg();
    int j = zzvg();
    int k = zzvg();
    int m = zzvg();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }

  public final long zzve()
    throws IOException
  {
    int i = zzvg();
    int j = zzvg();
    int k = zzvg();
    int m = zzvg();
    int n = zzvg();
    int i1 = zzvg();
    int i2 = zzvg();
    int i3 = zzvg();
    return 0xFF & i | (0xFF & j) << 8 | (0xFF & k) << 16 | (0xFF & m) << 24 | (0xFF & n) << 32 | (0xFF & i1) << 40 | (0xFF & i2) << 48 | (0xFF & i3) << 56;
  }

  public final int zzyy()
  {
    if (this.zzbuj == 2147483647)
      return -1;
    int i = this.zzcer;
    return this.zzbuj - i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxz
 * JD-Core Version:    0.6.2
 */