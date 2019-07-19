package com.esotericsoftware.kryo.io;

import java.io.DataOutput;
import java.io.IOException;

public class KryoDataOutput
  implements DataOutput
{
  protected Output output;

  public KryoDataOutput(Output paramOutput)
  {
    setOutput(paramOutput);
  }

  public void setOutput(Output paramOutput)
  {
    this.output = paramOutput;
  }

  public void write(int paramInt)
    throws IOException
  {
    this.output.write(paramInt);
  }

  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.output.write(paramArrayOfByte);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.output.write(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    this.output.writeBoolean(paramBoolean);
  }

  public void writeByte(int paramInt)
    throws IOException
  {
    this.output.writeByte(paramInt);
  }

  public void writeBytes(String paramString)
    throws IOException
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
      this.output.write((byte)paramString.charAt(j));
  }

  public void writeChar(int paramInt)
    throws IOException
  {
    this.output.writeChar((char)paramInt);
  }

  public void writeChars(String paramString)
    throws IOException
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      this.output.write(0xFF & k >>> 8);
      this.output.write(0xFF & k >>> 0);
    }
  }

  public void writeDouble(double paramDouble)
    throws IOException
  {
    this.output.writeDouble(paramDouble);
  }

  public void writeFloat(float paramFloat)
    throws IOException
  {
    this.output.writeFloat(paramFloat);
  }

  public void writeInt(int paramInt)
    throws IOException
  {
    this.output.writeInt(paramInt);
  }

  public void writeLong(long paramLong)
    throws IOException
  {
    this.output.writeLong(paramLong);
  }

  public void writeShort(int paramInt)
    throws IOException
  {
    this.output.writeShort(paramInt);
  }

  public void writeUTF(String paramString)
    throws IOException
  {
    this.output.writeString(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.KryoDataOutput
 * JD-Core Version:    0.6.2
 */