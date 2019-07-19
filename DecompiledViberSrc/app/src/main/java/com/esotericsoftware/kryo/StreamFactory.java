package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface StreamFactory
{
  public abstract Input getInput();

  public abstract Input getInput(int paramInt);

  public abstract Input getInput(InputStream paramInputStream);

  public abstract Input getInput(InputStream paramInputStream, int paramInt);

  public abstract Input getInput(byte[] paramArrayOfByte);

  public abstract Input getInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public abstract Output getOutput();

  public abstract Output getOutput(int paramInt);

  public abstract Output getOutput(int paramInt1, int paramInt2);

  public abstract Output getOutput(OutputStream paramOutputStream);

  public abstract Output getOutput(OutputStream paramOutputStream, int paramInt);

  public abstract Output getOutput(byte[] paramArrayOfByte);

  public abstract Output getOutput(byte[] paramArrayOfByte, int paramInt);

  public abstract void setKryo(Kryo paramKryo);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.StreamFactory
 * JD-Core Version:    0.6.2
 */