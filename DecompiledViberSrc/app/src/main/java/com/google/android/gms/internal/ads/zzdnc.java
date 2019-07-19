package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzdnc
{
  int zzhcz;
  int zzhda = 100;
  private int zzhdb = 2147483647;
  zzdnf zzhdc;
  private boolean zzhdd = false;

  static zzdnc zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    zzdne localzzdne = new zzdne(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, null);
    try
    {
      localzzdne.zzfr(paramInt2);
      return localzzdne;
    }
    catch (zzdoj localzzdoj)
    {
      throw new IllegalArgumentException(localzzdoj);
    }
  }

  public static long zzfi(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }

  public static int zzft(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }

  public abstract double readDouble()
    throws IOException;

  public abstract float readFloat()
    throws IOException;

  public abstract String readString()
    throws IOException;

  public abstract int zzavu()
    throws IOException;

  public abstract long zzavv()
    throws IOException;

  public abstract long zzavw()
    throws IOException;

  public abstract int zzavx()
    throws IOException;

  public abstract long zzavy()
    throws IOException;

  public abstract int zzavz()
    throws IOException;

  public abstract boolean zzawa()
    throws IOException;

  public abstract String zzawb()
    throws IOException;

  public abstract zzdmq zzawc()
    throws IOException;

  public abstract int zzawd()
    throws IOException;

  public abstract int zzawe()
    throws IOException;

  public abstract int zzawf()
    throws IOException;

  public abstract long zzawg()
    throws IOException;

  public abstract int zzawh()
    throws IOException;

  public abstract long zzawi()
    throws IOException;

  abstract long zzawj()
    throws IOException;

  public abstract boolean zzawk()
    throws IOException;

  public abstract int zzawl();

  public abstract void zzfp(int paramInt)
    throws zzdoj;

  public abstract boolean zzfq(int paramInt)
    throws IOException;

  public abstract int zzfr(int paramInt)
    throws zzdoj;

  public abstract void zzfs(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnc
 * JD-Core Version:    0.6.2
 */