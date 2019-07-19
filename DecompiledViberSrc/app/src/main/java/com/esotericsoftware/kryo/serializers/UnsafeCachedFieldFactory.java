package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import java.lang.reflect.Field;

class UnsafeCachedFieldFactory
  implements FieldSerializer.CachedFieldFactory
{
  public FieldSerializer.CachedField createCachedField(Class paramClass, Field paramField, FieldSerializer paramFieldSerializer)
  {
    if (paramClass.isPrimitive())
    {
      if (paramClass == Boolean.TYPE)
        return new UnsafeCacheFields.UnsafeBooleanField(paramField);
      if (paramClass == Byte.TYPE)
        return new UnsafeCacheFields.UnsafeByteField(paramField);
      if (paramClass == Character.TYPE)
        return new UnsafeCacheFields.UnsafeCharField(paramField);
      if (paramClass == Short.TYPE)
        return new UnsafeCacheFields.UnsafeShortField(paramField);
      if (paramClass == Integer.TYPE)
        return new UnsafeCacheFields.UnsafeIntField(paramField);
      if (paramClass == Long.TYPE)
        return new UnsafeCacheFields.UnsafeLongField(paramField);
      if (paramClass == Float.TYPE)
        return new UnsafeCacheFields.UnsafeFloatField(paramField);
      if (paramClass == Double.TYPE)
        return new UnsafeCacheFields.UnsafeDoubleField(paramField);
      return new UnsafeCacheFields.UnsafeObjectField(paramFieldSerializer);
    }
    if ((paramClass == String.class) && ((!paramFieldSerializer.kryo.getReferences()) || (!paramFieldSerializer.kryo.getReferenceResolver().useReferences(String.class))))
      return new UnsafeCacheFields.UnsafeStringField(paramField);
    return new UnsafeCacheFields.UnsafeObjectField(paramFieldSerializer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.UnsafeCachedFieldFactory
 * JD-Core Version:    0.6.2
 */