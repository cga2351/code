package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateSerializer extends Serializer
{
  private int compressionLevel = 4;
  private boolean noHeaders = true;
  private final Serializer serializer;

  public DeflateSerializer(Serializer paramSerializer)
  {
    this.serializer = paramSerializer;
  }

  public Object copy(Kryo paramKryo, Object paramObject)
  {
    return this.serializer.copy(paramKryo, paramObject);
  }

  public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
  {
    return paramKryo.readObject(new Input(new InflaterInputStream(new InputChunked(paramInput, 256), new Inflater(this.noHeaders)), 256), paramClass, this.serializer);
  }

  public void setCompressionLevel(int paramInt)
  {
    this.compressionLevel = paramInt;
  }

  public void setNoHeaders(boolean paramBoolean)
  {
    this.noHeaders = paramBoolean;
  }

  public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
  {
    Deflater localDeflater = new Deflater(this.compressionLevel, this.noHeaders);
    OutputChunked localOutputChunked = new OutputChunked(paramOutput, 256);
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localOutputChunked, localDeflater);
    Output localOutput = new Output(localDeflaterOutputStream, 256);
    paramKryo.writeObject(localOutput, paramObject, this.serializer);
    localOutput.flush();
    try
    {
      localDeflaterOutputStream.finish();
      localOutputChunked.endChunks();
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.DeflateSerializer
 * JD-Core Version:    0.6.2
 */