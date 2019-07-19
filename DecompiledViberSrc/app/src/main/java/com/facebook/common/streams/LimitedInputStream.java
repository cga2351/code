package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LimitedInputStream extends FilterInputStream
{
  private int mBytesToRead;
  private int mBytesToReadWhenMarked;

  public LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if (paramInputStream == null)
      throw new NullPointerException();
    if (paramInt < 0)
      throw new IllegalArgumentException("limit must be >= 0");
    this.mBytesToRead = paramInt;
    this.mBytesToReadWhenMarked = -1;
  }

  public int available()
    throws IOException
  {
    return Math.min(this.in.available(), this.mBytesToRead);
  }

  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      this.in.mark(paramInt);
      this.mBytesToReadWhenMarked = this.mBytesToRead;
    }
  }

  public int read()
    throws IOException
  {
    if (this.mBytesToRead == 0)
      return -1;
    int i = this.in.read();
    if (i != -1)
      this.mBytesToRead = (-1 + this.mBytesToRead);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j;
    if (this.mBytesToRead == 0)
      j = -1;
    do
    {
      return j;
      int i = Math.min(paramInt2, this.mBytesToRead);
      j = this.in.read(paramArrayOfByte, paramInt1, i);
    }
    while (j <= 0);
    this.mBytesToRead -= j;
    return j;
  }

  public void reset()
    throws IOException
  {
    if (!this.in.markSupported())
      throw new IOException("mark is not supported");
    if (this.mBytesToReadWhenMarked == -1)
      throw new IOException("mark not set");
    this.in.reset();
    this.mBytesToRead = this.mBytesToReadWhenMarked;
  }

  public long skip(long paramLong)
    throws IOException
  {
    long l1 = Math.min(paramLong, this.mBytesToRead);
    long l2 = this.in.skip(l1);
    this.mBytesToRead = ((int)(this.mBytesToRead - l2));
    return l2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.streams.LimitedInputStream
 * JD-Core Version:    0.6.2
 */