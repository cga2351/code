package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class PooledByteBufferInputStream extends InputStream
{

  @VisibleForTesting
  int mMark;

  @VisibleForTesting
  int mOffset;

  @VisibleForTesting
  final PooledByteBuffer mPooledByteBuffer;

  public PooledByteBufferInputStream(PooledByteBuffer paramPooledByteBuffer)
  {
    if (!paramPooledByteBuffer.isClosed());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mPooledByteBuffer = ((PooledByteBuffer)Preconditions.checkNotNull(paramPooledByteBuffer));
      this.mOffset = 0;
      this.mMark = 0;
      return;
    }
  }

  public int available()
  {
    return this.mPooledByteBuffer.size() - this.mOffset;
  }

  public void mark(int paramInt)
  {
    this.mMark = this.mOffset;
  }

  public boolean markSupported()
  {
    return true;
  }

  public int read()
  {
    if (available() <= 0)
      return -1;
    PooledByteBuffer localPooledByteBuffer = this.mPooledByteBuffer;
    int i = this.mOffset;
    this.mOffset = (i + 1);
    return 0xFF & localPooledByteBuffer.read(i);
  }

  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
      throw new ArrayIndexOutOfBoundsException("length=" + paramArrayOfByte.length + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    int i = available();
    if (i <= 0)
      return -1;
    if (paramInt2 <= 0)
      return 0;
    int j = Math.min(i, paramInt2);
    this.mPooledByteBuffer.read(this.mOffset, paramArrayOfByte, paramInt1, j);
    this.mOffset = (j + this.mOffset);
    return j;
  }

  public void reset()
  {
    this.mOffset = this.mMark;
  }

  public long skip(long paramLong)
  {
    if (paramLong >= 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      int i = Math.min((int)paramLong, available());
      this.mOffset = (i + this.mOffset);
      return i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteBufferInputStream
 * JD-Core Version:    0.6.2
 */