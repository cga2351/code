package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzl extends FilterInputStream
{
  private long zzh;
  private long zzi = -1L;

  zzl(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    zzg.checkNotNull(paramInputStream);
    if (1048576L >= 0L);
    for (int i = 1; i == 0; i = 0)
      throw new IllegalArgumentException(String.valueOf("limit must be non-negative"));
    this.zzh = 1048576L;
  }

  public final int available()
    throws IOException
  {
    return (int)Math.min(this.in.available(), this.zzh);
  }

  public final void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.zzi = this.zzh;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final int read()
    throws IOException
  {
    if (this.zzh == 0L)
      return -1;
    int i = this.in.read();
    if (i != -1)
      this.zzh -= 1L;
    return i;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.zzh == 0L)
      return -1;
    int i = (int)Math.min(paramInt2, this.zzh);
    int j = this.in.read(paramArrayOfByte, paramInt1, i);
    if (j != -1)
      this.zzh -= j;
    return j;
  }

  public final void reset()
    throws IOException
  {
    try
    {
      if (!this.in.markSupported())
        throw new IOException("Mark not supported");
    }
    finally
    {
    }
    if (this.zzi == -1L)
      throw new IOException("Mark not set");
    this.in.reset();
    this.zzh = this.zzi;
  }

  public final long skip(long paramLong)
    throws IOException
  {
    long l1 = Math.min(paramLong, this.zzh);
    long l2 = this.in.skip(l1);
    this.zzh -= l2;
    return l2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzl
 * JD-Core Version:    0.6.2
 */