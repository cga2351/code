package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import java.lang.reflect.Field;

class AsmCachedFieldFactory
  implements FieldSerializer.CachedFieldFactory
{
  public FieldSerializer.CachedField createCachedField(Class paramClass, Field paramField, FieldSerializer paramFieldSerializer)
  {
    if (paramClass.isPrimitive())
    {
      if (paramClass == Boolean.TYPE)
        return new AsmCacheFields.AsmBooleanField();
      if (paramClass == Byte.TYPE)
        return new AsmCacheFields.AsmByteField();
      if (paramClass == Character.TYPE)
        return new AsmCacheFields.AsmCharField();
      if (paramClass == Short.TYPE)
        return new AsmCacheFields.AsmShortField();
      if (paramClass == Integer.TYPE)
        return new AsmCacheFields.AsmIntField();
      if (paramClass == Long.TYPE)
        return new AsmCacheFields.AsmLongField();
      if (paramClass == Float.TYPE)
        return new AsmCacheFields.AsmFloatField();
      if (paramClass == Double.TYPE)
        return new AsmCacheFields.AsmDoubleField();
      return new AsmCacheFields.AsmObjectField(paramFieldSerializer);
    }
    if ((paramClass == String.class) && ((!paramFieldSerializer.kryo.getReferences()) || (!paramFieldSerializer.kryo.getReferenceResolver().useReferences(String.class))))
      return new AsmCacheFields.AsmStringField();
    return new AsmCacheFields.AsmObjectField(paramFieldSerializer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.AsmCachedFieldFactory
 * JD-Core Version:    0.6.2
 */