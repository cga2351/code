package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.InputStream;

public final class FastInput extends Input
{
  public FastInput()
  {
  }

  public FastInput(int paramInt)
  {
    super(paramInt);
  }

  public FastInput(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public FastInput(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
  }

  public FastInput(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  public FastInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
  }

  public int readInt(boolean paramBoolean)
    throws KryoException
  {
    return readInt();
  }

  public long readLong(boolean paramBoolean)
    throws KryoException
  {
    return readLong();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.FastInput
 * JD-Core Version:    0.6.2
 */