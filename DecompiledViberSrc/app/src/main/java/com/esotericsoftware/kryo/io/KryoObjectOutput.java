package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.ObjectOutput;

public class KryoObjectOutput extends KryoDataOutput
  implements ObjectOutput
{
  private final Kryo kryo;

  public KryoObjectOutput(Kryo paramKryo, Output paramOutput)
  {
    super(paramOutput);
    this.kryo = paramKryo;
  }

  public void close()
    throws IOException
  {
    this.output.close();
  }

  public void flush()
    throws IOException
  {
    this.output.flush();
  }

  public void writeObject(Object paramObject)
    throws IOException
  {
    this.kryo.writeClassAndObject(this.output, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.KryoObjectOutput
 * JD-Core Version:    0.6.2
 */