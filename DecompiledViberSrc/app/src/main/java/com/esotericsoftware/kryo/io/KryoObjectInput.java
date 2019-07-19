package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.ObjectInput;

public class KryoObjectInput extends KryoDataInput
  implements ObjectInput
{
  private final Kryo kryo;

  public KryoObjectInput(Kryo paramKryo, Input paramInput)
  {
    super(paramInput);
    this.kryo = paramKryo;
  }

  public int available()
    throws IOException
  {
    return 0;
  }

  public void close()
    throws IOException
  {
    this.input.close();
  }

  public int read()
    throws IOException
  {
    return this.input.read();
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.input.read(paramArrayOfByte);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.input.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public Object readObject()
    throws ClassNotFoundException, IOException
  {
    return this.kryo.readClassAndObject(this.input);
  }

  public long skip(long paramLong)
    throws IOException
  {
    return this.input.skip(paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.KryoObjectInput
 * JD-Core Version:    0.6.2
 */