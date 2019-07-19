package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

final class FieldSerializerAnnotationsUtil
{
  public FieldSerializerAnnotationsUtil(FieldSerializer paramFieldSerializer)
  {
  }

  public void processAnnotatedFields(FieldSerializer paramFieldSerializer)
  {
    FieldSerializer.CachedField[] arrayOfCachedField = paramFieldSerializer.getFields();
    int i = arrayOfCachedField.length;
    int j = 0;
    Field localField;
    label381: Class localClass1;
    label400: Class localClass2;
    Serializer localSerializer1;
    label538: Serializer localSerializer2;
    label546: boolean bool1;
    boolean bool2;
    Class localClass3;
    Class localClass4;
    if (j < i)
    {
      localField = arrayOfCachedField[j].getField();
      if (localField.isAnnotationPresent(FieldSerializer.Bind.class))
      {
        Class localClass9 = ((FieldSerializer.Bind)localField.getAnnotation(FieldSerializer.Bind.class)).value();
        Serializer localSerializer4 = ReflectionSerializerFactory.makeSerializer(paramFieldSerializer.getKryo(), localClass9, localField.getClass());
        arrayOfCachedField[j].setSerializer(localSerializer4);
      }
      CollectionSerializer.BindCollection localBindCollection;
      Class localClass7;
      if (((!localField.isAnnotationPresent(CollectionSerializer.BindCollection.class)) || (!localField.isAnnotationPresent(MapSerializer.BindMap.class))) || (localField.isAnnotationPresent(CollectionSerializer.BindCollection.class)))
      {
        if (arrayOfCachedField[j].serializer != null)
          throw new RuntimeException("CollectionSerialier.Bind cannot be used with field " + arrayOfCachedField[j].getField().getDeclaringClass().getName() + "." + arrayOfCachedField[j].getField().getName() + ", because it has a serializer already.");
        localBindCollection = (CollectionSerializer.BindCollection)localField.getAnnotation(CollectionSerializer.BindCollection.class);
        if (!Collection.class.isAssignableFrom(arrayOfCachedField[j].field.getType()))
          break label400;
        localClass7 = localBindCollection.elementSerializer();
        if (localClass7 == Serializer.class)
          localClass7 = null;
        if (localClass7 != null)
          break label381;
      }
      for (Serializer localSerializer3 = null; ; localSerializer3 = ReflectionSerializerFactory.makeSerializer(paramFieldSerializer.getKryo(), localClass7, localField.getClass()))
      {
        boolean bool3 = localBindCollection.elementsCanBeNull();
        Class localClass8 = localBindCollection.elementClass();
        if (localClass8 == Object.class)
          localClass8 = null;
        CollectionSerializer localCollectionSerializer = new CollectionSerializer();
        localCollectionSerializer.setElementsCanBeNull(bool3);
        localCollectionSerializer.setElementClass(localClass8, localSerializer3);
        arrayOfCachedField[j].setSerializer(localCollectionSerializer);
        if (!localField.isAnnotationPresent(MapSerializer.BindMap.class))
          break label652;
        if (arrayOfCachedField[j].serializer == null)
          break;
        throw new RuntimeException("MapSerialier.Bind cannot be used with field " + arrayOfCachedField[j].getField().getDeclaringClass().getName() + "." + arrayOfCachedField[j].getField().getName() + ", because it has a serializer already.");
      }
      throw new RuntimeException("CollectionSerialier.Bind should be used only with fields implementing java.util.Collection, but field " + arrayOfCachedField[j].getField().getDeclaringClass().getName() + "." + arrayOfCachedField[j].getField().getName() + " does not implement it.");
      MapSerializer.BindMap localBindMap = (MapSerializer.BindMap)localField.getAnnotation(MapSerializer.BindMap.class);
      if (Map.class.isAssignableFrom(arrayOfCachedField[j].field.getType()))
      {
        localClass1 = localBindMap.valueSerializer();
        localClass2 = localBindMap.keySerializer();
        if (localClass1 == Serializer.class)
          localClass1 = null;
        if (localClass2 == Serializer.class)
          localClass2 = null;
        if (localClass1 == null)
        {
          localSerializer1 = null;
          if (localClass2 != null)
            break label677;
          localSerializer2 = null;
          bool1 = localBindMap.valuesCanBeNull();
          bool2 = localBindMap.keysCanBeNull();
          localClass3 = localBindMap.keyClass();
          localClass4 = localBindMap.valueClass();
          if (localClass3 != Object.class)
            break label766;
        }
      }
    }
    label652: label677: label766: for (Class localClass5 = null; ; localClass5 = localClass3)
    {
      if (localClass4 == Object.class);
      for (Class localClass6 = null; ; localClass6 = localClass4)
      {
        MapSerializer localMapSerializer = new MapSerializer();
        localMapSerializer.setKeysCanBeNull(bool2);
        localMapSerializer.setValuesCanBeNull(bool1);
        localMapSerializer.setKeyClass(localClass5, localSerializer2);
        localMapSerializer.setValueClass(localClass6, localSerializer1);
        arrayOfCachedField[j].setSerializer(localMapSerializer);
        j++;
        break;
        localSerializer1 = ReflectionSerializerFactory.makeSerializer(paramFieldSerializer.getKryo(), localClass1, localField.getClass());
        break label538;
        localSerializer2 = ReflectionSerializerFactory.makeSerializer(paramFieldSerializer.getKryo(), localClass2, localField.getClass());
        break label546;
        throw new RuntimeException("MapSerialier.Bind should be used only with fields implementing java.util.Map, but field " + arrayOfCachedField[j].getField().getDeclaringClass().getName() + "." + arrayOfCachedField[j].getField().getName() + " does not implement it.");
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.FieldSerializerAnnotationsUtil
 * JD-Core Version:    0.6.2
 */