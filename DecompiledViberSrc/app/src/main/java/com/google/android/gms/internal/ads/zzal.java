package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzal
{
  private static final Comparator<byte[]> zzbw = new zzam();
  private final List<byte[]> zzbs = new ArrayList();
  private final List<byte[]> zzbt = new ArrayList(64);
  private int zzbu = 0;
  private final int zzbv = 4096;

  public zzal(int paramInt)
  {
  }

  private final void zzn()
  {
    try
    {
      if (this.zzbu > this.zzbv)
      {
        byte[] arrayOfByte = (byte[])this.zzbs.remove(0);
        this.zzbt.remove(arrayOfByte);
        this.zzbu -= arrayOfByte.length;
      }
    }
    finally
    {
    }
  }

  public final void zza(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null);
    try
    {
      int i = paramArrayOfByte.length;
      int j = this.zzbv;
      if (i > j);
      while (true)
      {
        return;
        this.zzbs.add(paramArrayOfByte);
        int k = Collections.binarySearch(this.zzbt, paramArrayOfByte, zzbw);
        if (k < 0)
          k = -1 + -k;
        this.zzbt.add(k, paramArrayOfByte);
        this.zzbu += paramArrayOfByte.length;
        zzn();
      }
    }
    finally
    {
    }
  }

  public final byte[] zzc(int paramInt)
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte;
      if (i < this.zzbt.size())
      {
        arrayOfByte = (byte[])this.zzbt.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.zzbu -= arrayOfByte.length;
          this.zzbt.remove(i);
          this.zzbs.remove(arrayOfByte);
        }
      }
      while (true)
      {
        return arrayOfByte;
        i++;
        break;
        arrayOfByte = new byte[paramInt];
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzal
 * JD-Core Version:    0.6.2
 */