package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSerializer extends Serializer<Map>
{
  private Class keyClass;
  private Class keyGenericType;
  private Serializer keySerializer;
  private boolean keysCanBeNull = true;
  private Class valueClass;
  private Class valueGenericType;
  private Serializer valueSerializer;
  private boolean valuesCanBeNull = true;

  public Map copy(Kryo paramKryo, Map paramMap)
  {
    Map localMap = createCopy(paramKryo, paramMap);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localMap.put(paramKryo.copy(localEntry.getKey()), paramKryo.copy(localEntry.getValue()));
    }
    return localMap;
  }

  protected Map create(Kryo paramKryo, Input paramInput, Class<Map> paramClass)
  {
    return (Map)paramKryo.newInstance(paramClass);
  }

  protected Map createCopy(Kryo paramKryo, Map paramMap)
  {
    return (Map)paramKryo.newInstance(paramMap.getClass());
  }

  public Map read(Kryo paramKryo, Input paramInput, Class<Map> paramClass)
  {
    Map localMap = create(paramKryo, paramInput, paramClass);
    int i = paramInput.readInt(true);
    Class localClass1 = this.keyClass;
    Class localClass2 = this.valueClass;
    Serializer localSerializer1 = this.keySerializer;
    if (this.keyGenericType != null)
    {
      localClass1 = this.keyGenericType;
      if (localSerializer1 == null)
        localSerializer1 = paramKryo.getSerializer(localClass1);
      this.keyGenericType = null;
    }
    Serializer localSerializer2 = this.valueSerializer;
    if (this.valueGenericType != null)
    {
      localClass2 = this.valueGenericType;
      if (localSerializer2 == null)
        localSerializer2 = paramKryo.getSerializer(localClass2);
      this.valueGenericType = null;
    }
    paramKryo.reference(localMap);
    int j = 0;
    if (j < i)
    {
      Object localObject1;
      label141: Object localObject2;
      if (localSerializer1 != null)
        if (this.keysCanBeNull)
        {
          localObject1 = paramKryo.readObjectOrNull(paramInput, localClass1, localSerializer1);
          if (localSerializer2 == null)
            break label220;
          if (!this.valuesCanBeNull)
            break label206;
          localObject2 = paramKryo.readObjectOrNull(paramInput, localClass2, localSerializer2);
        }
      while (true)
      {
        localMap.put(localObject1, localObject2);
        j++;
        break;
        localObject1 = paramKryo.readObject(paramInput, localClass1, localSerializer1);
        break label141;
        localObject1 = paramKryo.readClassAndObject(paramInput);
        break label141;
        label206: localObject2 = paramKryo.readObject(paramInput, localClass2, localSerializer2);
        continue;
        label220: localObject2 = paramKryo.readClassAndObject(paramInput);
      }
    }
    return localMap;
  }

  public void setGenerics(Kryo paramKryo, Class[] paramArrayOfClass)
  {
    this.keyGenericType = null;
    this.valueGenericType = null;
    if ((paramArrayOfClass != null) && (paramArrayOfClass.length > 0))
    {
      if ((paramArrayOfClass[0] != null) && (paramKryo.isFinal(paramArrayOfClass[0])))
        this.keyGenericType = paramArrayOfClass[0];
      if ((paramArrayOfClass.length > 1) && (paramArrayOfClass[1] != null) && (paramKryo.isFinal(paramArrayOfClass[1])))
        this.valueGenericType = paramArrayOfClass[1];
    }
  }

  public void setKeyClass(Class paramClass, Serializer paramSerializer)
  {
    this.keyClass = paramClass;
    this.keySerializer = paramSerializer;
  }

  public void setKeysCanBeNull(boolean paramBoolean)
  {
    this.keysCanBeNull = paramBoolean;
  }

  public void setValueClass(Class paramClass, Serializer paramSerializer)
  {
    this.valueClass = paramClass;
    this.valueSerializer = paramSerializer;
  }

  public void setValuesCanBeNull(boolean paramBoolean)
  {
    this.valuesCanBeNull = paramBoolean;
  }

  public void write(Kryo paramKryo, Output paramOutput, Map paramMap)
  {
    paramOutput.writeInt(paramMap.size(), true);
    Serializer localSerializer1 = this.keySerializer;
    if (this.keyGenericType != null)
    {
      if (localSerializer1 == null)
        localSerializer1 = paramKryo.getSerializer(this.keyGenericType);
      this.keyGenericType = null;
    }
    Serializer localSerializer2 = localSerializer1;
    Serializer localSerializer3 = this.valueSerializer;
    if (this.valueGenericType != null)
    {
      if (localSerializer3 == null)
        localSerializer3 = paramKryo.getSerializer(this.valueGenericType);
      this.valueGenericType = null;
    }
    Serializer localSerializer4 = localSerializer3;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localSerializer2 != null)
        if (this.keysCanBeNull)
          paramKryo.writeObjectOrNull(paramOutput, localEntry.getKey(), localSerializer2);
      while (true)
        if (localSerializer4 != null)
        {
          if (this.valuesCanBeNull)
          {
            paramKryo.writeObjectOrNull(paramOutput, localEntry.getValue(), localSerializer4);
            break;
            paramKryo.writeObject(paramOutput, localEntry.getKey(), localSerializer2);
            continue;
            paramKryo.writeClassAndObject(paramOutput, localEntry.getKey());
            continue;
          }
          paramKryo.writeObject(paramOutput, localEntry.getValue(), localSerializer4);
          break;
        }
      paramKryo.writeClassAndObject(paramOutput, localEntry.getValue());
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface BindMap
  {
    public abstract Class<?> keyClass();

    public abstract Class<? extends Serializer> keySerializer();

    public abstract boolean keysCanBeNull();

    public abstract Class<?> valueClass();

    public abstract Class<? extends Serializer> valueSerializer();

    public abstract boolean valuesCanBeNull();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.MapSerializer
 * JD-Core Version:    0.6.2
 */