package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Field;

public class CompatibleFieldSerializer<T> extends FieldSerializer<T>
{
  public CompatibleFieldSerializer(Kryo paramKryo, Class paramClass)
  {
    super(paramKryo, paramClass);
  }

  public T read(Kryo paramKryo, Input paramInput, Class<T> paramClass)
  {
    Object localObject = create(paramKryo, paramInput, paramClass);
    paramKryo.reference(localObject);
    ObjectMap localObjectMap = paramKryo.getGraphContext();
    FieldSerializer.CachedField[] arrayOfCachedField1 = (FieldSerializer.CachedField[])localObjectMap.get(this);
    if (arrayOfCachedField1 == null)
    {
      int m = paramInput.readVarInt(true);
      if (Log.TRACE)
        Log.trace("kryo", "Read " + m + " field names.");
      String[] arrayOfString = new String[m];
      for (int n = 0; n < m; n++)
        arrayOfString[n] = paramInput.readString();
      arrayOfCachedField1 = new FieldSerializer.CachedField[m];
      FieldSerializer.CachedField[] arrayOfCachedField2 = getFields();
      int i1 = arrayOfString.length;
      int i2 = 0;
      if (i2 < i1)
      {
        String str = arrayOfString[i2];
        int i3 = 0;
        int i4 = arrayOfCachedField2.length;
        label158: if (i3 < i4)
          if (arrayOfCachedField2[i3].field.getName().equals(str))
            arrayOfCachedField1[i2] = arrayOfCachedField2[i3];
        while (true)
        {
          i2++;
          break;
          i3++;
          break label158;
          if (Log.TRACE)
            Log.trace("kryo", "Ignore obsolete field: " + str);
        }
      }
      localObjectMap.put(this, arrayOfCachedField1);
    }
    InputChunked localInputChunked = new InputChunked(paramInput, 1024);
    int i;
    int k;
    label280: FieldSerializer.CachedField localCachedField;
    if (getGenerics() != null)
    {
      i = 1;
      int j = arrayOfCachedField1.length;
      k = 0;
      if (k >= j)
        break label370;
      localCachedField = arrayOfCachedField1[k];
      if ((localCachedField != null) && (i != 0))
        localCachedField = getField(localCachedField.field.getName());
      if (localCachedField != null)
        break label353;
      if (Log.TRACE)
        Log.trace("kryo", "Skip obsolete field.");
      localInputChunked.nextChunks();
    }
    while (true)
    {
      k++;
      break label280;
      i = 0;
      break;
      label353: localCachedField.read(localInputChunked, localObject);
      localInputChunked.nextChunks();
    }
    label370: return localObject;
  }

  public void write(Kryo paramKryo, Output paramOutput, T paramT)
  {
    int i = 0;
    FieldSerializer.CachedField[] arrayOfCachedField = getFields();
    ObjectMap localObjectMap = paramKryo.getGraphContext();
    if (!localObjectMap.containsKey(this))
    {
      localObjectMap.put(this, null);
      if (Log.TRACE)
        Log.trace("kryo", "Write " + arrayOfCachedField.length + " field names.");
      paramOutput.writeVarInt(arrayOfCachedField.length, true);
      int k = arrayOfCachedField.length;
      for (int m = 0; m < k; m++)
        paramOutput.writeString(arrayOfCachedField[m].field.getName());
    }
    OutputChunked localOutputChunked = new OutputChunked(paramOutput, 1024);
    int j = arrayOfCachedField.length;
    while (i < j)
    {
      arrayOfCachedField[i].write(localOutputChunked, paramT);
      localOutputChunked.endChunks();
      i++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer
 * JD-Core Version:    0.6.2
 */