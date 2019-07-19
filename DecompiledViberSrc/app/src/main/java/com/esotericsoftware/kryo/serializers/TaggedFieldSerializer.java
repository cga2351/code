package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashSet;

public class TaggedFieldSerializer<T> extends FieldSerializer<T>
{
  private boolean[] deprecated;
  private int[] tags;
  private int writeFieldCount;

  public TaggedFieldSerializer(Kryo paramKryo, Class paramClass)
  {
    super(paramKryo, paramClass);
  }

  protected void initializeCachedFields()
  {
    FieldSerializer.CachedField[] arrayOfCachedField1 = getFields();
    int i = arrayOfCachedField1.length;
    for (int j = 0; j < i; j++)
      if (arrayOfCachedField1[j].getField().getAnnotation(Tag.class) == null)
      {
        if (Log.TRACE)
          Log.trace("kryo", "Ignoring field without tag: " + arrayOfCachedField1[j]);
        super.removeField(arrayOfCachedField1[j]);
      }
    FieldSerializer.CachedField[] arrayOfCachedField2 = getFields();
    this.tags = new int[arrayOfCachedField2.length];
    this.deprecated = new boolean[arrayOfCachedField2.length];
    this.writeFieldCount = arrayOfCachedField2.length;
    int k = arrayOfCachedField2.length;
    for (int m = 0; m < k; m++)
    {
      Field localField = arrayOfCachedField2[m].getField();
      this.tags[m] = ((Tag)localField.getAnnotation(Tag.class)).value();
      if (localField.getAnnotation(Deprecated.class) != null)
      {
        this.deprecated[m] = true;
        this.writeFieldCount = (-1 + this.writeFieldCount);
      }
    }
    this.removedFields.clear();
  }

  public T read(Kryo paramKryo, Input paramInput, Class<T> paramClass)
  {
    Object localObject = create(paramKryo, paramInput, paramClass);
    paramKryo.reference(localObject);
    int i = paramInput.readVarInt(true);
    int[] arrayOfInt = this.tags;
    FieldSerializer.CachedField[] arrayOfCachedField = getFields();
    for (int j = 0; j < i; j++)
    {
      int k = paramInput.readVarInt(true);
      int m = arrayOfInt.length;
      FieldSerializer.CachedField localCachedField;
      for (int n = 0; ; n++)
      {
        localCachedField = null;
        if (n < m)
        {
          if (arrayOfInt[n] == k)
            localCachedField = arrayOfCachedField[n];
        }
        else
        {
          if (localCachedField != null)
            break;
          throw new KryoException("Unknown field tag: " + k + " (" + getType().getName() + ")");
        }
      }
      localCachedField.read(paramInput, localObject);
    }
    return localObject;
  }

  public void removeField(FieldSerializer.CachedField paramCachedField)
  {
    super.removeField(paramCachedField);
    initializeCachedFields();
  }

  public void removeField(String paramString)
  {
    super.removeField(paramString);
    initializeCachedFields();
  }

  public void write(Kryo paramKryo, Output paramOutput, T paramT)
  {
    FieldSerializer.CachedField[] arrayOfCachedField = getFields();
    paramOutput.writeVarInt(this.writeFieldCount, true);
    int i = 0;
    int j = arrayOfCachedField.length;
    if (i < j)
    {
      if (this.deprecated[i] != 0);
      while (true)
      {
        i++;
        break;
        paramOutput.writeVarInt(this.tags[i], true);
        arrayOfCachedField[i].write(paramOutput, paramT);
      }
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface Tag
  {
    public abstract int value();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.TaggedFieldSerializer
 * JD-Core Version:    0.6.2
 */