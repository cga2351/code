package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.InputStream;

public class InputChunked extends Input
{
  private int chunkSize = -1;

  public InputChunked()
  {
    super(2048);
  }

  public InputChunked(int paramInt)
  {
    super(paramInt);
  }

  public InputChunked(InputStream paramInputStream)
  {
    super(paramInputStream, 2048);
  }

  public InputChunked(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
  }

  private void readChunkSize()
  {
    int i = 0;
    while (true)
    {
      int j;
      int k;
      try
      {
        InputStream localInputStream = getInputStream();
        j = 0;
        if (j >= 32)
          break;
        k = localInputStream.read();
        if (k == -1)
          throw new KryoException("Buffer underflow.");
      }
      catch (IOException localIOException)
      {
        throw new KryoException(localIOException);
      }
      i |= (k & 0x7F) << j;
      if ((k & 0x80) == 0)
      {
        this.chunkSize = i;
        if (Log.TRACE)
          Log.trace("kryo", "Read chunk: " + this.chunkSize);
        return;
      }
      j += 7;
    }
    throw new KryoException("Malformed integer.");
  }

  protected int fill(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    if (this.chunkSize == -1)
      readChunkSize();
    while (this.chunkSize != 0)
    {
      int i = super.fill(paramArrayOfByte, paramInt1, Math.min(this.chunkSize, paramInt2));
      this.chunkSize -= i;
      if (this.chunkSize == 0)
        readChunkSize();
      return i;
    }
    return -1;
  }

  public void nextChunks()
  {
    if (this.chunkSize == -1)
      readChunkSize();
    while (this.chunkSize > 0)
      skip(this.chunkSize);
    this.chunkSize = -1;
    if (Log.TRACE)
      Log.trace("kryo", "Next chunks.");
  }

  public void rewind()
  {
    super.rewind();
    this.chunkSize = -1;
  }

  public void setBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super.setBuffer(paramArrayOfByte, paramInt1, paramInt2);
    this.chunkSize = -1;
  }

  public void setInputStream(InputStream paramInputStream)
  {
    super.setInputStream(paramInputStream);
    this.chunkSize = -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.InputChunked
 * JD-Core Version:    0.6.2
 */