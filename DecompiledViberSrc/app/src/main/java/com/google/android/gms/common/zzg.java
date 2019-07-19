package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzg extends zze
{
  private static final WeakReference<byte[]> zzw = new WeakReference(null);
  private WeakReference<byte[]> zzv = zzw;

  zzg(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  final byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte = (byte[])this.zzv.get();
      if (arrayOfByte == null)
      {
        arrayOfByte = zzd();
        this.zzv = new WeakReference(arrayOfByte);
      }
      return arrayOfByte;
    }
    finally
    {
    }
  }

  protected abstract byte[] zzd();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzg
 * JD-Core Version:    0.6.2
 */