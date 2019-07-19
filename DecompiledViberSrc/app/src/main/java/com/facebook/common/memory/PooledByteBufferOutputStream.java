package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream
{
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
    }
  }

  public abstract int size();

  public abstract PooledByteBuffer toByteBuffer();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteBufferOutputStream
 * JD-Core Version:    0.6.2
 */