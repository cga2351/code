package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;

public class KryoDataInput
  implements DataInput
{
  protected Input input;

  public KryoDataInput(Input paramInput)
  {
    setInput(paramInput);
  }

  public boolean readBoolean()
    throws IOException
  {
    return this.input.readBoolean();
  }

  public byte readByte()
    throws IOException
  {
    return this.input.readByte();
  }

  public char readChar()
    throws IOException
  {
    return this.input.readChar();
  }

  public double readDouble()
    throws IOException
  {
    return this.input.readDouble();
  }

  public float readFloat()
    throws IOException
  {
    return this.input.readFloat();
  }

  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.input.readBytes(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (KryoException localKryoException)
    {
      throw new EOFException(localKryoException.getMessage());
    }
  }

  public int readInt()
    throws IOException
  {
    return this.input.readInt();
  }

  public String readLine()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }

  public long readLong()
    throws IOException
  {
    return this.input.readLong();
  }

  public short readShort()
    throws IOException
  {
    return this.input.readShort();
  }

  public String readUTF()
    throws IOException
  {
    return this.input.readString();
  }

  public int readUnsignedByte()
    throws IOException
  {
    return this.input.readByteUnsigned();
  }

  public int readUnsignedShort()
    throws IOException
  {
    return this.input.readShortUnsigned();
  }

  public void setInput(Input paramInput)
  {
    this.input = paramInput;
  }

  public int skipBytes(int paramInt)
    throws IOException
  {
    return (int)this.input.skip(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.KryoDataInput
 * JD-Core Version:    0.6.2
 */