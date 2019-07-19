package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzk
{
  private final byte[] buffer;
  private final int zzgr;
  private final int zzgs;
  private int zzgt;
  private int zzgu;
  private int zzgv;
  private int zzgw;
  private int zzgx = 2147483647;
  private int zzgy;
  private int zzgz = 64;
  private int zzha = 67108864;

  private zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.zzgr = paramInt1;
    int i = paramInt1 + paramInt2;
    this.zzgt = i;
    this.zzgs = i;
    this.zzgv = paramInt1;
  }

  public static zzk zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzk(paramArrayOfByte, 0, paramInt2);
  }

  private final void zzh(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw zzs.zzv();
    if (paramInt + this.zzgv > this.zzgx)
    {
      zzh(this.zzgx - this.zzgv);
      throw zzs.zzu();
    }
    if (paramInt <= this.zzgt - this.zzgv)
    {
      this.zzgv = (paramInt + this.zzgv);
      return;
    }
    throw zzs.zzu();
  }

  private final void zzo()
  {
    this.zzgt += this.zzgu;
    int i = this.zzgt;
    if (i > this.zzgx)
    {
      this.zzgu = (i - this.zzgx);
      this.zzgt -= this.zzgu;
      return;
    }
    this.zzgu = 0;
  }

  private final byte zzq()
    throws IOException
  {
    if (this.zzgv == this.zzgt)
      throw zzs.zzu();
    byte[] arrayOfByte = this.buffer;
    int i = this.zzgv;
    this.zzgv = (i + 1);
    return arrayOfByte[i];
  }

  public final int getPosition()
  {
    return this.zzgv - this.zzgr;
  }

  public final byte[] readBytes()
    throws IOException
  {
    int i = zzk();
    if (i < 0)
      throw zzs.zzv();
    if (i == 0)
      return zzw.zzhy;
    if (i > this.zzgt - this.zzgv)
      throw zzs.zzu();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, this.zzgv, arrayOfByte, 0, i);
    this.zzgv = (i + this.zzgv);
    return arrayOfByte;
  }

  public final String readString()
    throws IOException
  {
    int i = zzk();
    if (i < 0)
      throw zzs.zzv();
    if (i > this.zzgt - this.zzgv)
      throw zzs.zzu();
    String str = new String(this.buffer, this.zzgv, i, zzr.UTF_8);
    this.zzgv = (i + this.zzgv);
    return str;
  }

  public final void zza(zzt paramzzt)
    throws IOException
  {
    int i = zzk();
    if (this.zzgy >= this.zzgz)
      throw new zzs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    int j = zze(i);
    this.zzgy = (1 + this.zzgy);
    paramzzt.zza(this);
    zzc(0);
    this.zzgy = (-1 + this.zzgy);
    zzf(j);
  }

  public final byte[] zzb(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return zzw.zzhy;
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1 + this.zzgr;
    System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }

  public final void zzc(int paramInt)
    throws zzs
  {
    if (this.zzgw != paramInt)
      throw new zzs("Protocol message end-group tag did not match expected tag.");
  }

  final void zzc(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.zzgv - this.zzgr)
    {
      int i = this.zzgv - this.zzgr;
      throw new IllegalArgumentException(50 + "Position " + paramInt1 + " is beyond current " + i);
    }
    if (paramInt1 < 0)
      throw new IllegalArgumentException(24 + "Bad position " + paramInt1);
    this.zzgv = (paramInt1 + this.zzgr);
    this.zzgw = paramInt2;
  }

  public final boolean zzd(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default:
      throw new zzs("Protocol message tag had invalid wire type.");
    case 0:
      zzk();
      return true;
    case 1:
      zzn();
      return true;
    case 2:
      zzh(zzk());
      return true;
    case 3:
      int i;
      do
        i = zzj();
      while ((i != 0) && (zzd(i)));
      zzc(0x4 | paramInt >>> 3 << 3);
      return true;
    case 4:
      return false;
    case 5:
    }
    zzm();
    return true;
  }

  public final int zze(int paramInt)
    throws zzs
  {
    if (paramInt < 0)
      throw zzs.zzv();
    int i = paramInt + this.zzgv;
    int j = this.zzgx;
    if (i > j)
      throw zzs.zzu();
    this.zzgx = i;
    zzo();
    return j;
  }

  public final void zzf(int paramInt)
  {
    this.zzgx = paramInt;
    zzo();
  }

  public final void zzg(int paramInt)
  {
    zzc(paramInt, this.zzgw);
  }

  public final int zzj()
    throws IOException
  {
    if (this.zzgv == this.zzgt)
    {
      this.zzgw = 0;
      return 0;
    }
    this.zzgw = zzk();
    if (this.zzgw == 0)
      throw new zzs("Protocol message contained an invalid tag (zero).");
    return this.zzgw;
  }

  public final int zzk()
    throws IOException
  {
    int i = zzq();
    if (i >= 0);
    int i4;
    do
    {
      return i;
      int j = i & 0x7F;
      int k = zzq();
      if (k >= 0)
        return j | k << 7;
      int m = j | (k & 0x7F) << 7;
      int n = zzq();
      if (n >= 0)
        return m | n << 14;
      int i1 = m | (n & 0x7F) << 14;
      int i2 = zzq();
      if (i2 >= 0)
        return i1 | i2 << 21;
      int i3 = i1 | (i2 & 0x7F) << 21;
      i4 = zzq();
      i = i3 | i4 << 28;
    }
    while (i4 >= 0);
    for (int i5 = 0; ; i5++)
    {
      if (i5 >= 5)
        break label151;
      if (zzq() >= 0)
        break;
    }
    label151: throw zzs.zzw();
  }

  public final long zzl()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
      i += 7;
    }
    throw zzs.zzw();
  }

  public final int zzm()
    throws IOException
  {
    int i = zzq();
    int j = zzq();
    int k = zzq();
    int m = zzq();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }

  public final long zzn()
    throws IOException
  {
    int i = zzq();
    int j = zzq();
    int k = zzq();
    int m = zzq();
    int n = zzq();
    int i1 = zzq();
    int i2 = zzq();
    int i3 = zzq();
    return 0xFF & i | (0xFF & j) << 8 | (0xFF & k) << 16 | (0xFF & m) << 24 | (0xFF & n) << 32 | (0xFF & i1) << 40 | (0xFF & i2) << 48 | (0xFF & i3) << 56;
  }

  public final int zzp()
  {
    if (this.zzgx == 2147483647)
      return -1;
    int i = this.zzgv;
    return this.zzgx - i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzk
 * JD-Core Version:    0.6.2
 */