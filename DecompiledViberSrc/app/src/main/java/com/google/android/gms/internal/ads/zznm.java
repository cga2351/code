package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class zznm
  implements zzno
{
  private static final byte[] zzaht = new byte[4096];
  private long zzahv;
  private final zzrv zzazi;
  private final long zzazj;
  private byte[] zzazk;
  private int zzazl;
  private int zzazm;

  public zznm(zzrv paramzzrv, long paramLong1, long paramLong2)
  {
    this.zzazi = paramzzrv;
    this.zzahv = paramLong1;
    this.zzazj = paramLong2;
    this.zzazk = new byte[65536];
  }

  private final int zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws InterruptedException, IOException
  {
    if (Thread.interrupted())
      throw new InterruptedException();
    int i = this.zzazi.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
    if (i == -1)
    {
      if ((paramInt3 == 0) && (paramBoolean))
        return -1;
      throw new EOFException();
    }
    return paramInt3 + i;
  }

  private final int zzas(int paramInt)
  {
    int i = Math.min(this.zzazm, paramInt);
    zzat(i);
    return i;
  }

  private final void zzat(int paramInt)
  {
    this.zzazm -= paramInt;
    this.zzazl = 0;
    byte[] arrayOfByte = this.zzazk;
    if (this.zzazm < this.zzazk.length - 524288)
      arrayOfByte = new byte[65536 + this.zzazm];
    System.arraycopy(this.zzazk, paramInt, arrayOfByte, 0, this.zzazm);
    this.zzazk = arrayOfByte;
  }

  private final void zzau(int paramInt)
  {
    if (paramInt != -1)
      this.zzahv += paramInt;
  }

  private final int zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.zzazm == 0)
      return 0;
    int i = Math.min(this.zzazm, paramInt2);
    System.arraycopy(this.zzazk, 0, paramArrayOfByte, paramInt1, i);
    zzat(i);
    return i;
  }

  private final boolean zze(int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int i = paramInt + this.zzazl;
    if (i > this.zzazk.length)
    {
      int k = zzsy.zzd(this.zzazk.length << 1, 65536 + i, i + 524288);
      this.zzazk = Arrays.copyOf(this.zzazk, k);
    }
    int j = Math.min(this.zzazm - this.zzazl, paramInt);
    while (j < paramInt)
    {
      j = zza(this.zzazk, this.zzazl, paramInt, j, false);
      if (j == -1)
        return false;
    }
    this.zzazl = (paramInt + this.zzazl);
    this.zzazm = Math.max(this.zzazm, this.zzazl);
    return true;
  }

  public final long getLength()
  {
    return this.zzazj;
  }

  public final long getPosition()
  {
    return this.zzahv;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    int i = zzd(paramArrayOfByte, paramInt1, paramInt2);
    if (i == 0)
      i = zza(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    zzau(i);
    return i;
  }

  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    zza(paramArrayOfByte, paramInt1, paramInt2, false);
  }

  public final boolean zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    for (int i = zzd(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = zza(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean));
    zzau(i);
    return i != -1;
  }

  public final int zzaq(int paramInt)
    throws IOException, InterruptedException
  {
    int i = zzas(paramInt);
    if (i == 0)
      i = zza(zzaht, 0, Math.min(paramInt, zzaht.length), 0, true);
    zzau(i);
    return i;
  }

  public final void zzar(int paramInt)
    throws IOException, InterruptedException
  {
    zze(paramInt, false);
  }

  public final void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    if (zze(paramInt2, false))
      System.arraycopy(this.zzazk, this.zzazl - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
  }

  public final void zzig()
  {
    this.zzazl = 0;
  }

  public final void zzr(int paramInt)
    throws IOException, InterruptedException
  {
    for (int i = zzas(paramInt); (i < paramInt) && (i != -1); i = zza(zzaht, -i, Math.min(paramInt, i + zzaht.length), i, false));
    zzau(i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznm
 * JD-Core Version:    0.6.2
 */