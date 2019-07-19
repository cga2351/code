package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzare
final class zzbfl
  implements zzdsv
{
  private final ByteBuffer zzaxl;

  zzbfl(ByteBuffer paramByteBuffer)
  {
    this.zzaxl = paramByteBuffer.duplicate();
  }

  public final void close()
    throws IOException
  {
  }

  public final long position()
    throws IOException
  {
    return this.zzaxl.position();
  }

  public final int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if ((this.zzaxl.remaining() == 0) && (paramByteBuffer.remaining() > 0))
      return -1;
    int i = Math.min(paramByteBuffer.remaining(), this.zzaxl.remaining());
    byte[] arrayOfByte = new byte[i];
    this.zzaxl.get(arrayOfByte);
    paramByteBuffer.put(arrayOfByte);
    return i;
  }

  public final long size()
    throws IOException
  {
    return this.zzaxl.limit();
  }

  public final void zzff(long paramLong)
    throws IOException
  {
    this.zzaxl.position((int)paramLong);
  }

  public final ByteBuffer zzi(long paramLong1, long paramLong2)
    throws IOException
  {
    int i = this.zzaxl.position();
    this.zzaxl.position((int)paramLong1);
    ByteBuffer localByteBuffer = this.zzaxl.slice();
    localByteBuffer.limit((int)paramLong2);
    this.zzaxl.position(i);
    return localByteBuffer;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfl
 * JD-Core Version:    0.6.2
 */