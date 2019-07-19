package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

public final class zzib
  implements zzie
{
  private static final byte[] zzaht = new byte[4096];
  private final zzjp zzahu;
  private long zzahv;
  private long zzcd;

  public zzib(zzjp paramzzjp, long paramLong1, long paramLong2)
  {
    this.zzahu = paramzzjp;
    this.zzahv = paramLong1;
    this.zzcd = paramLong2;
  }

  public final long getPosition()
  {
    return this.zzahv;
  }

  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    zza(paramArrayOfByte, paramInt1, paramInt2, false);
  }

  public final boolean zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int i = paramInt2;
    while (i > 0)
    {
      if (Thread.interrupted())
        throw new InterruptedException();
      int j = this.zzahu.read(paramArrayOfByte, paramInt1, i);
      if (j == -1)
      {
        if ((paramBoolean) && (i == paramInt2))
          return false;
        throw new EOFException();
      }
      paramInt1 += j;
      i -= j;
    }
    this.zzahv += paramInt2;
    return true;
  }

  public final void zzr(int paramInt)
    throws IOException, InterruptedException
  {
    int i = paramInt;
    while (i > 0)
    {
      if (Thread.interrupted())
        throw new InterruptedException();
      int j = this.zzahu.read(zzaht, 0, Math.min(zzaht.length, i));
      if (j == -1)
        throw new EOFException();
      i -= j;
    }
    this.zzahv += paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzib
 * JD-Core Version:    0.6.2
 */