package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.OutputStream;

public final class FastOutput extends Output
{
  public FastOutput()
  {
  }

  public FastOutput(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public FastOutput(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public FastOutput(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public FastOutput(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }

  public FastOutput(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }

  public FastOutput(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }

  public int writeInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    writeInt(paramInt);
    return 4;
  }

  public int writeLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    writeLong(paramLong);
    return 8;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.FastOutput
 * JD-Core Version:    0.6.2
 */