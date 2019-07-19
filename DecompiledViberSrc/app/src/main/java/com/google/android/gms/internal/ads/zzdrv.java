package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzdrv
{
  protected volatile int zzhnx = -1;

  public static final byte[] zza(zzdrv paramzzdrv)
  {
    byte[] arrayOfByte = new byte[paramzzdrv.zzaxj()];
    int i = arrayOfByte.length;
    try
    {
      zzdro localzzdro = zzdro.zzp(arrayOfByte, 0, i);
      paramzzdrv.zza(localzzdro);
      localzzdro.zzawv();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public String toString()
  {
    return zzdrw.zzb(this);
  }

  public void zza(zzdro paramzzdro)
    throws IOException
  {
  }

  public final int zzaxj()
  {
    int i = zzor();
    this.zzhnx = i;
    return i;
  }

  public zzdrv zzbal()
    throws CloneNotSupportedException
  {
    return (zzdrv)super.clone();
  }

  protected int zzor()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrv
 * JD-Core Version:    0.6.2
 */