package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.OutputStream;

public class OutputChunked extends Output
{
  public OutputChunked()
  {
    super(2048);
  }

  public OutputChunked(int paramInt)
  {
    super(paramInt);
  }

  public OutputChunked(OutputStream paramOutputStream)
  {
    super(paramOutputStream, 2048);
  }

  public OutputChunked(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }

  private void writeChunkSize()
    throws IOException
  {
    int i = position();
    if (Log.TRACE)
      Log.trace("kryo", "Write chunk: " + i);
    OutputStream localOutputStream = getOutputStream();
    if ((i & 0xFFFFFF80) == 0)
    {
      localOutputStream.write(i);
      return;
    }
    localOutputStream.write(0x80 | i & 0x7F);
    int j = i >>> 7;
    if ((j & 0xFFFFFF80) == 0)
    {
      localOutputStream.write(j);
      return;
    }
    localOutputStream.write(0x80 | j & 0x7F);
    int k = j >>> 7;
    if ((k & 0xFFFFFF80) == 0)
    {
      localOutputStream.write(k);
      return;
    }
    localOutputStream.write(0x80 | k & 0x7F);
    int m = k >>> 7;
    if ((m & 0xFFFFFF80) == 0)
    {
      localOutputStream.write(m);
      return;
    }
    localOutputStream.write(0x80 | m & 0x7F);
    localOutputStream.write(m >>> 7);
  }

  public void endChunks()
  {
    flush();
    if (Log.TRACE)
      Log.trace("kryo", "End chunks.");
    try
    {
      getOutputStream().write(0);
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }

  public void flush()
    throws KryoException
  {
    if (position() > 0);
    try
    {
      writeChunkSize();
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.OutputChunked
 * JD-Core Version:    0.6.2
 */