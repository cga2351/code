package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoObjectInput;
import com.esotericsoftware.kryo.io.KryoObjectOutput;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;

public class ExternalizableSerializer extends Serializer
{
  private ObjectMap<Class, JavaSerializer> javaSerializerByType;
  private KryoObjectInput objectInput = null;
  private KryoObjectOutput objectOutput = null;

  private JavaSerializer getCachedSerializer(Class paramClass)
  {
    if (this.javaSerializerByType == null)
    {
      this.javaSerializerByType = new ObjectMap();
      return null;
    }
    return (JavaSerializer)this.javaSerializerByType.get(paramClass);
  }

  private JavaSerializer getJavaSerializerIfRequired(Class paramClass)
  {
    JavaSerializer localJavaSerializer = getCachedSerializer(paramClass);
    if ((localJavaSerializer == null) && (isJavaSerializerRequired(paramClass)))
      localJavaSerializer = new JavaSerializer();
    return localJavaSerializer;
  }

  private ObjectInput getObjectInput(Kryo paramKryo, Input paramInput)
  {
    if (this.objectInput == null)
      this.objectInput = new KryoObjectInput(paramKryo, paramInput);
    while (true)
    {
      return this.objectInput;
      this.objectInput.setInput(paramInput);
    }
  }

  private ObjectOutput getObjectOutput(Kryo paramKryo, Output paramOutput)
  {
    if (this.objectOutput == null)
      this.objectOutput = new KryoObjectOutput(paramKryo, paramOutput);
    while (true)
    {
      return this.objectOutput;
      this.objectOutput.setOutput(paramOutput);
    }
  }

  private static boolean hasInheritableReplaceMethod(Class paramClass, String paramString)
  {
    while (true)
    {
      Object localObject = null;
      if (paramClass != null);
      try
      {
        Method localMethod = paramClass.getDeclaredMethod(paramString, new Class[0]);
        localObject = localMethod;
        boolean bool = false;
        if (localObject != null)
        {
          Class localClass = localObject.getReturnType();
          bool = false;
          if (localClass == Object.class)
            bool = true;
        }
        return bool;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramClass = paramClass.getSuperclass();
      }
    }
  }

  private boolean isJavaSerializerRequired(Class paramClass)
  {
    return (hasInheritableReplaceMethod(paramClass, "writeReplace")) || (hasInheritableReplaceMethod(paramClass, "readResolve"));
  }

  private Object readExternal(Kryo paramKryo, Input paramInput, Class paramClass)
  {
    try
    {
      Externalizable localExternalizable = (Externalizable)paramClass.newInstance();
      localExternalizable.readExternal(getObjectInput(paramKryo, paramInput));
      return localExternalizable;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new KryoException(localClassCastException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new KryoException(localClassNotFoundException);
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new KryoException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new KryoException(localIllegalAccessException);
    }
  }

  private void writeExternal(Kryo paramKryo, Output paramOutput, Object paramObject)
  {
    try
    {
      ((Externalizable)paramObject).writeExternal(getObjectOutput(paramKryo, paramOutput));
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new KryoException(localClassCastException);
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }

  public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
  {
    JavaSerializer localJavaSerializer = getJavaSerializerIfRequired(paramClass);
    if (localJavaSerializer == null)
      return readExternal(paramKryo, paramInput, paramClass);
    return localJavaSerializer.read(paramKryo, paramInput, paramClass);
  }

  public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
  {
    JavaSerializer localJavaSerializer = getJavaSerializerIfRequired(paramObject.getClass());
    if (localJavaSerializer == null)
    {
      writeExternal(paramKryo, paramOutput, paramObject);
      return;
    }
    localJavaSerializer.write(paramKryo, paramOutput, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.ExternalizableSerializer
 * JD-Core Version:    0.6.2
 */