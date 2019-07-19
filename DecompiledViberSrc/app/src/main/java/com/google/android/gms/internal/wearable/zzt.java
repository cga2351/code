package com.google.android.gms.internal.wearable;

import java.io.IOException;

public abstract class zzt
{
  protected volatile int zzhl = -1;

  public static final <T extends zzt> T zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzs
  {
    try
    {
      zzk localzzk = zzk.zza(paramArrayOfByte, 0, paramInt2);
      paramT.zza(localzzk);
      localzzk.zzc(0);
      return paramT;
    }
    catch (zzs localzzs)
    {
      throw localzzs;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public static final byte[] zzb(zzt paramzzt)
  {
    byte[] arrayOfByte = new byte[paramzzt.zzx()];
    int i = arrayOfByte.length;
    try
    {
      zzl localzzl = zzl.zzb(arrayOfByte, 0, i);
      paramzzt.zza(localzzl);
      localzzl.zzr();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public String toString()
  {
    return zzu.zzc(this);
  }

  public abstract zzt zza(zzk paramzzk)
    throws IOException;

  public void zza(zzl paramzzl)
    throws IOException
  {
  }

  protected int zzg()
  {
    return 0;
  }

  public zzt zzs()
    throws CloneNotSupportedException
  {
    return (zzt)super.clone();
  }

  public final int zzx()
  {
    int i = zzg();
    this.zzhl = i;
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzt
 * JD-Core Version:    0.6.2
 */