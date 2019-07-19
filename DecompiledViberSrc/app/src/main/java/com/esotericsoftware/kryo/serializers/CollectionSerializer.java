package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer extends Serializer<Collection>
{
  private Class elementClass;
  private boolean elementsCanBeNull = true;
  private Class genericType;
  private Serializer serializer;

  public CollectionSerializer()
  {
  }

  public CollectionSerializer(Class paramClass, Serializer paramSerializer)
  {
    setElementClass(paramClass, paramSerializer);
  }

  public CollectionSerializer(Class paramClass, Serializer paramSerializer, boolean paramBoolean)
  {
    setElementClass(paramClass, paramSerializer);
    this.elementsCanBeNull = paramBoolean;
  }

  public Collection copy(Kryo paramKryo, Collection paramCollection)
  {
    Collection localCollection = createCopy(paramKryo, paramCollection);
    paramKryo.reference(localCollection);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localCollection.add(paramKryo.copy(localIterator.next()));
    return localCollection;
  }

  protected Collection create(Kryo paramKryo, Input paramInput, Class<Collection> paramClass)
  {
    return (Collection)paramKryo.newInstance(paramClass);
  }

  protected Collection createCopy(Kryo paramKryo, Collection paramCollection)
  {
    return (Collection)paramKryo.newInstance(paramCollection.getClass());
  }

  public Collection read(Kryo paramKryo, Input paramInput, Class<Collection> paramClass)
  {
    Collection localCollection = create(paramKryo, paramInput, paramClass);
    paramKryo.reference(localCollection);
    int i = paramInput.readVarInt(true);
    if ((localCollection instanceof ArrayList))
      ((ArrayList)localCollection).ensureCapacity(i);
    Class localClass = this.elementClass;
    Serializer localSerializer = this.serializer;
    if (this.genericType != null)
    {
      if (localSerializer == null)
      {
        localClass = this.genericType;
        localSerializer = paramKryo.getSerializer(this.genericType);
      }
      this.genericType = null;
    }
    if (localSerializer != null)
    {
      boolean bool = this.elementsCanBeNull;
      int k = 0;
      if (bool)
        while (k < i)
        {
          localCollection.add(paramKryo.readObjectOrNull(paramInput, localClass, localSerializer));
          k++;
        }
      while (k < i)
      {
        localCollection.add(paramKryo.readObject(paramInput, localClass, localSerializer));
        k++;
      }
    }
    for (int j = 0; j < i; j++)
      localCollection.add(paramKryo.readClassAndObject(paramInput));
    return localCollection;
  }

  public void setElementClass(Class paramClass, Serializer paramSerializer)
  {
    this.elementClass = paramClass;
    this.serializer = paramSerializer;
  }

  public void setElementsCanBeNull(boolean paramBoolean)
  {
    this.elementsCanBeNull = paramBoolean;
  }

  public void setGenerics(Kryo paramKryo, Class[] paramArrayOfClass)
  {
    this.genericType = null;
    if ((paramArrayOfClass != null) && (paramArrayOfClass.length > 0) && (paramKryo.isFinal(paramArrayOfClass[0])))
      this.genericType = paramArrayOfClass[0];
  }

  public void write(Kryo paramKryo, Output paramOutput, Collection paramCollection)
  {
    paramOutput.writeVarInt(paramCollection.size(), true);
    Serializer localSerializer = this.serializer;
    if (this.genericType != null)
    {
      if (localSerializer == null)
        localSerializer = paramKryo.getSerializer(this.genericType);
      this.genericType = null;
    }
    if (localSerializer != null)
    {
      if (this.elementsCanBeNull)
      {
        Iterator localIterator3 = paramCollection.iterator();
        while (localIterator3.hasNext())
          paramKryo.writeObjectOrNull(paramOutput, localIterator3.next(), localSerializer);
      }
      Iterator localIterator2 = paramCollection.iterator();
      while (localIterator2.hasNext())
        paramKryo.writeObject(paramOutput, localIterator2.next(), localSerializer);
    }
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
      paramKryo.writeClassAndObject(paramOutput, localIterator1.next());
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface BindCollection
  {
    public abstract Class<?> elementClass();

    public abstract Class<? extends Serializer> elementSerializer();

    public abstract boolean elementsCanBeNull();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.CollectionSerializer
 * JD-Core Version:    0.6.2
 */