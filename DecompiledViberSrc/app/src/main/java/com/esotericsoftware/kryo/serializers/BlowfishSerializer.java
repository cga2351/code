package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishSerializer extends Serializer
{
  private static SecretKeySpec keySpec;
  private final Serializer serializer;

  public BlowfishSerializer(Serializer paramSerializer, byte[] paramArrayOfByte)
  {
    this.serializer = paramSerializer;
    keySpec = new SecretKeySpec(paramArrayOfByte, "Blowfish");
  }

  private static Cipher getCipher(int paramInt)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("Blowfish");
      localCipher.init(paramInt, keySpec);
      return localCipher;
    }
    catch (Exception localException)
    {
      throw new KryoException(localException);
    }
  }

  public Object copy(Kryo paramKryo, Object paramObject)
  {
    return this.serializer.copy(paramKryo, paramObject);
  }

  public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
  {
    CipherInputStream localCipherInputStream = new CipherInputStream(paramInput, getCipher(2));
    return this.serializer.read(paramKryo, new Input(localCipherInputStream, 256), paramClass);
  }

  public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
  {
    CipherOutputStream localCipherOutputStream = new CipherOutputStream(paramOutput, getCipher(1));
    Output local1 = new Output(localCipherOutputStream, 256)
    {
      public void close()
        throws KryoException
      {
      }
    };
    this.serializer.write(paramKryo, local1, paramObject);
    local1.flush();
    try
    {
      localCipherOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.BlowfishSerializer
 * JD-Core Version:    0.6.2
 */