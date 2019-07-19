package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.util.IntArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

abstract interface FieldSerializerUnsafeUtil
{
  public abstract void createUnsafeCacheFieldsAndRegions(List<Field> paramList, List<FieldSerializer.CachedField> paramList1, int paramInt, IntArray paramIntArray);

  public abstract long getObjectFieldOffset(Field paramField);

  public static class Factory
  {
    static Constructor<FieldSerializerUnsafeUtil> fieldSerializerUnsafeUtilConstructor;

    static
    {
      try
      {
        fieldSerializerUnsafeUtilConstructor = FieldSerializer.class.getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtilImpl").getConstructor(new Class[] { FieldSerializer.class });
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    static FieldSerializerUnsafeUtil getInstance(FieldSerializer paramFieldSerializer)
    {
      if (fieldSerializerUnsafeUtilConstructor != null)
        try
        {
          FieldSerializerUnsafeUtil localFieldSerializerUnsafeUtil = (FieldSerializerUnsafeUtil)fieldSerializerUnsafeUtilConstructor.newInstance(new Object[] { paramFieldSerializer });
          return localFieldSerializerUnsafeUtil;
        }
        catch (Exception localException)
        {
        }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
 * JD-Core Version:    0.6.2
 */