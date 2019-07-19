package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerializer extends Serializer
{
  public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
  {
    try
    {
      ObjectMap localObjectMap = paramKryo.getGraphContext();
      ObjectInputStream localObjectInputStream = (ObjectInputStream)localObjectMap.get(this);
      if (localObjectInputStream == null)
      {
        localObjectInputStream = new ObjectInputStream(paramInput);
        localObjectMap.put(this, localObjectInputStream);
      }
      Object localObject = localObjectInputStream.readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new KryoException("Error during Java deserialization.", localException);
    }
  }

  public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
  {
    try
    {
      ObjectMap localObjectMap = paramKryo.getGraphContext();
      ObjectOutputStream localObjectOutputStream = (ObjectOutputStream)localObjectMap.get(this);
      if (localObjectOutputStream == null)
      {
        localObjectOutputStream = new ObjectOutputStream(paramOutput);
        localObjectMap.put(this, localObjectOutputStream);
      }
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      return;
    }
    catch (Exception localException)
    {
      throw new KryoException("Error during Java serialization.", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.JavaSerializer
 * JD-Core Version:    0.6.2
 */