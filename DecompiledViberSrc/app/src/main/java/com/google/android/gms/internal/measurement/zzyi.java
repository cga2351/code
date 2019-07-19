package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzyi
{
  protected volatile int zzcff = -1;

  public static final <T extends zzyi> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzyh
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static final void zza(zzyi paramzzyi, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzya localzzya = zzya.zzk(paramArrayOfByte, 0, paramInt2);
      paramzzyi.zza(localzzya);
      localzzya.zzza();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  private static final <T extends zzyi> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzyh
  {
    try
    {
      zzxz localzzxz = zzxz.zzj(paramArrayOfByte, 0, paramInt2);
      paramT.zza(localzzxz);
      localzzxz.zzap(0);
      return paramT;
    }
    catch (zzyh localzzyh)
    {
      throw localzzyh;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public String toString()
  {
    return zzyj.zzc(this);
  }

  public abstract zzyi zza(zzxz paramzzxz)
    throws IOException;

  public void zza(zzya paramzzya)
    throws IOException
  {
  }

  protected int zzf()
  {
    return 0;
  }

  public final int zzvx()
  {
    int i = zzf();
    this.zzcff = i;
    return i;
  }

  public zzyi zzzb()
    throws CloneNotSupportedException
  {
    return (zzyi)super.clone();
  }

  public final int zzzh()
  {
    if (this.zzcff < 0)
      zzvx();
    return this.zzcff;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyi
 * JD-Core Version:    0.6.2
 */