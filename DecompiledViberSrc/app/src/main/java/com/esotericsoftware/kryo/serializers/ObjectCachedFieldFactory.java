package com.esotericsoftware.kryo.serializers;

import java.lang.reflect.Field;

class ObjectCachedFieldFactory
  implements FieldSerializer.CachedFieldFactory
{
  public FieldSerializer.CachedField createCachedField(Class paramClass, Field paramField, FieldSerializer paramFieldSerializer)
  {
    if (paramClass.isPrimitive())
    {
      if (paramClass == Boolean.TYPE)
        return new ObjectField.ObjectBooleanField(paramFieldSerializer);
      if (paramClass == Byte.TYPE)
        return new ObjectField.ObjectByteField(paramFieldSerializer);
      if (paramClass == Character.TYPE)
        return new ObjectField.ObjectCharField(paramFieldSerializer);
      if (paramClass == Short.TYPE)
        return new ObjectField.ObjectShortField(paramFieldSerializer);
      if (paramClass == Integer.TYPE)
        return new ObjectField.ObjectIntField(paramFieldSerializer);
      if (paramClass == Long.TYPE)
        return new ObjectField.ObjectLongField(paramFieldSerializer);
      if (paramClass == Float.TYPE)
        return new ObjectField.ObjectFloatField(paramFieldSerializer);
      if (paramClass == Double.TYPE)
        return new ObjectField.ObjectDoubleField(paramFieldSerializer);
      return new ObjectField(paramFieldSerializer);
    }
    return new ObjectField(paramFieldSerializer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.ObjectCachedFieldFactory
 * JD-Core Version:    0.6.2
 */