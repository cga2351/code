package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzap extends FilterInputStream
{
  private final long zzcd;
  private long zzce;

  zzap(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.zzcd = paramLong;
  }

  public final int read()
    throws IOException
  {
    int i = super.read();
    if (i != -1)
      this.zzce = (1L + this.zzce);
    return i;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1)
      this.zzce += i;
    return i;
  }

  final long zzo()
  {
    return this.zzcd - this.zzce;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzap
 * JD-Core Version:    0.6.2
 */