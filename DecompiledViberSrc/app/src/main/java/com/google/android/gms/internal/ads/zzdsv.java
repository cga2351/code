package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface zzdsv extends Closeable
{
  public abstract void close()
    throws IOException;

  public abstract long position()
    throws IOException;

  public abstract int read(ByteBuffer paramByteBuffer)
    throws IOException;

  public abstract long size()
    throws IOException;

  public abstract void zzff(long paramLong)
    throws IOException;

  public abstract ByteBuffer zzi(long paramLong1, long paramLong2)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsv
 * JD-Core Version:    0.6.2
 */