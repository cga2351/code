package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zztq
{
  int zzbua;
  int zzbub = 100;
  private int zzbuc = 2147483647;
  zztt zzbud;
  private boolean zzbue = false;

  static zztq zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    zzts localzzts = new zzts(paramArrayOfByte, paramInt1, paramInt2, false, null);
    try
    {
      localzzts.zzas(paramInt2);
      return localzzts;
    }
    catch (zzuv localzzuv)
    {
      throw new IllegalArgumentException(localzzuv);
    }
  }

  public static zztq zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza(paramArrayOfByte, paramInt1, paramInt2, false);
  }

  public abstract double readDouble()
    throws IOException;

  public abstract float readFloat()
    throws IOException;

  public abstract String readString()
    throws IOException;

  public abstract <T extends zzvv> T zza(zzwf<T> paramzzwf, zzub paramzzub)
    throws IOException;

  public abstract void zzap(int paramInt)
    throws zzuv;

  public abstract boolean zzaq(int paramInt)
    throws IOException;

  public final int zzar(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException(47 + "Recursion limit cannot be negative: " + paramInt);
    int i = this.zzbub;
    this.zzbub = paramInt;
    return i;
  }

  public abstract int zzas(int paramInt)
    throws zzuv;

  public abstract void zzat(int paramInt);

  public abstract void zzau(int paramInt)
    throws IOException;

  public abstract int zzuj()
    throws IOException;

  public abstract long zzuk()
    throws IOException;

  public abstract long zzul()
    throws IOException;

  public abstract int zzum()
    throws IOException;

  public abstract long zzun()
    throws IOException;

  public abstract int zzuo()
    throws IOException;

  public abstract boolean zzup()
    throws IOException;

  public abstract String zzuq()
    throws IOException;

  public abstract zzte zzur()
    throws IOException;

  public abstract int zzus()
    throws IOException;

  public abstract int zzut()
    throws IOException;

  public abstract int zzuu()
    throws IOException;

  public abstract long zzuv()
    throws IOException;

  public abstract int zzuw()
    throws IOException;

  public abstract long zzux()
    throws IOException;

  abstract long zzuy()
    throws IOException;

  public abstract boolean zzuz()
    throws IOException;

  public abstract int zzva();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztq
 * JD-Core Version:    0.6.2
 */