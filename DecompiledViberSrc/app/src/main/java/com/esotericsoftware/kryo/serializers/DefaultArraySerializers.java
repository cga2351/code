package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

public class DefaultArraySerializers
{
  public static class BooleanArraySerializer extends Serializer<boolean[]>
  {
    public BooleanArraySerializer()
    {
      setAcceptsNull(true);
    }

    public boolean[] copy(Kryo paramKryo, boolean[] paramArrayOfBoolean)
    {
      boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
      System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, arrayOfBoolean.length);
      return arrayOfBoolean;
    }

    public boolean[] read(Kryo paramKryo, Input paramInput, Class<boolean[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      boolean[] arrayOfBoolean;
      if (i == 0)
        arrayOfBoolean = null;
      while (true)
      {
        return arrayOfBoolean;
        int j = i - 1;
        arrayOfBoolean = new boolean[j];
        for (int k = 0; k < j; k++)
          arrayOfBoolean[k] = paramInput.readBoolean();
      }
    }

    public void write(Kryo paramKryo, Output paramOutput, boolean[] paramArrayOfBoolean)
    {
      int i = 0;
      if (paramArrayOfBoolean == null)
        paramOutput.writeVarInt(0, true);
      while (true)
      {
        return;
        paramOutput.writeVarInt(1 + paramArrayOfBoolean.length, true);
        int j = paramArrayOfBoolean.length;
        while (i < j)
        {
          paramOutput.writeBoolean(paramArrayOfBoolean[i]);
          i++;
        }
      }
    }
  }

  public static class ByteArraySerializer extends Serializer<byte[]>
  {
    public ByteArraySerializer()
    {
      setAcceptsNull(true);
    }

    public byte[] copy(Kryo paramKryo, byte[] paramArrayOfByte)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }

    public byte[] read(Kryo paramKryo, Input paramInput, Class<byte[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readBytes(i - 1);
    }

    public void write(Kryo paramKryo, Output paramOutput, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfByte.length, true);
      paramOutput.writeBytes(paramArrayOfByte);
    }
  }

  public static class CharArraySerializer extends Serializer<char[]>
  {
    public CharArraySerializer()
    {
      setAcceptsNull(true);
    }

    public char[] copy(Kryo paramKryo, char[] paramArrayOfChar)
    {
      char[] arrayOfChar = new char[paramArrayOfChar.length];
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, arrayOfChar.length);
      return arrayOfChar;
    }

    public char[] read(Kryo paramKryo, Input paramInput, Class<char[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readChars(i - 1);
    }

    public void write(Kryo paramKryo, Output paramOutput, char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfChar.length, true);
      paramOutput.writeChars(paramArrayOfChar);
    }
  }

  public static class DoubleArraySerializer extends Serializer<double[]>
  {
    public DoubleArraySerializer()
    {
      setAcceptsNull(true);
    }

    public double[] copy(Kryo paramKryo, double[] paramArrayOfDouble)
    {
      double[] arrayOfDouble = new double[paramArrayOfDouble.length];
      System.arraycopy(paramArrayOfDouble, 0, arrayOfDouble, 0, arrayOfDouble.length);
      return arrayOfDouble;
    }

    public double[] read(Kryo paramKryo, Input paramInput, Class<double[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readDoubles(i - 1);
    }

    public void write(Kryo paramKryo, Output paramOutput, double[] paramArrayOfDouble)
    {
      if (paramArrayOfDouble == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfDouble.length, true);
      paramOutput.writeDoubles(paramArrayOfDouble);
    }
  }

  public static class FloatArraySerializer extends Serializer<float[]>
  {
    public FloatArraySerializer()
    {
      setAcceptsNull(true);
    }

    public float[] copy(Kryo paramKryo, float[] paramArrayOfFloat)
    {
      float[] arrayOfFloat = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
      return arrayOfFloat;
    }

    public float[] read(Kryo paramKryo, Input paramInput, Class<float[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readFloats(i - 1);
    }

    public void write(Kryo paramKryo, Output paramOutput, float[] paramArrayOfFloat)
    {
      if (paramArrayOfFloat == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfFloat.length, true);
      paramOutput.writeFloats(paramArrayOfFloat);
    }
  }

  public static class IntArraySerializer extends Serializer<int[]>
  {
    public IntArraySerializer()
    {
      setAcceptsNull(true);
    }

    public int[] copy(Kryo paramKryo, int[] paramArrayOfInt)
    {
      int[] arrayOfInt = new int[paramArrayOfInt.length];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, arrayOfInt.length);
      return arrayOfInt;
    }

    public int[] read(Kryo paramKryo, Input paramInput, Class<int[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readInts(i - 1, false);
    }

    public void write(Kryo paramKryo, Output paramOutput, int[] paramArrayOfInt)
    {
      if (paramArrayOfInt == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfInt.length, true);
      paramOutput.writeInts(paramArrayOfInt, false);
    }
  }

  public static class LongArraySerializer extends Serializer<long[]>
  {
    public LongArraySerializer()
    {
      setAcceptsNull(true);
    }

    public long[] copy(Kryo paramKryo, long[] paramArrayOfLong)
    {
      long[] arrayOfLong = new long[paramArrayOfLong.length];
      System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, arrayOfLong.length);
      return arrayOfLong;
    }

    public long[] read(Kryo paramKryo, Input paramInput, Class<long[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readLongs(i - 1, false);
    }

    public void write(Kryo paramKryo, Output paramOutput, long[] paramArrayOfLong)
    {
      if (paramArrayOfLong == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfLong.length, true);
      paramOutput.writeLongs(paramArrayOfLong, false);
    }
  }

  public static class ObjectArraySerializer extends Serializer<Object[]>
  {
    private boolean elementsAreSameType;
    private boolean elementsCanBeNull = true;
    private Class[] generics;
    private final Class type;

    public ObjectArraySerializer(Kryo paramKryo, Class paramClass)
    {
      setAcceptsNull(true);
      this.type = paramClass;
      if ((0x10 & paramClass.getComponentType().getModifiers()) != 0);
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          setElementsAreSameType(true);
        return;
      }
    }

    public Object[] copy(Kryo paramKryo, Object[] paramArrayOfObject)
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), paramArrayOfObject.length);
      int i = 0;
      int j = paramArrayOfObject.length;
      while (i < j)
      {
        arrayOfObject[i] = paramKryo.copy(paramArrayOfObject[i]);
        i++;
      }
      return arrayOfObject;
    }

    public Object[] read(Kryo paramKryo, Input paramInput, Class<Object[]> paramClass)
    {
      int i = 0;
      int j = paramInput.readVarInt(true);
      if (j == 0)
      {
        arrayOfObject = null;
        return arrayOfObject;
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramClass.getComponentType(), j - 1);
      paramKryo.reference(arrayOfObject);
      Class localClass = arrayOfObject.getClass().getComponentType();
      if ((this.elementsAreSameType) || (Modifier.isFinal(localClass.getModifiers())))
      {
        Serializer localSerializer = paramKryo.getSerializer(localClass);
        localSerializer.setGenerics(paramKryo, this.generics);
        int k = arrayOfObject.length;
        label97: if (i < k)
        {
          if (!this.elementsCanBeNull)
            break label131;
          arrayOfObject[i] = paramKryo.readObjectOrNull(paramInput, localClass, localSerializer);
        }
        while (true)
        {
          i++;
          break label97;
          break;
          label131: arrayOfObject[i] = paramKryo.readObject(paramInput, localClass, localSerializer);
        }
      }
      int m = arrayOfObject.length;
      label153: if (i < m)
      {
        Registration localRegistration = paramKryo.readClass(paramInput);
        if (localRegistration == null)
          break label211;
        localRegistration.getSerializer().setGenerics(paramKryo, this.generics);
        arrayOfObject[i] = paramKryo.readObject(paramInput, localRegistration.getType(), localRegistration.getSerializer());
      }
      while (true)
      {
        i++;
        break label153;
        break;
        label211: arrayOfObject[i] = null;
      }
    }

    public void setElementsAreSameType(boolean paramBoolean)
    {
      this.elementsAreSameType = paramBoolean;
    }

    public void setElementsCanBeNull(boolean paramBoolean)
    {
      this.elementsCanBeNull = paramBoolean;
    }

    public void setGenerics(Kryo paramKryo, Class[] paramArrayOfClass)
    {
      if (Log.TRACE)
        Log.trace("kryo", "setting generics for ObjectArraySerializer");
      this.generics = paramArrayOfClass;
    }

    public void write(Kryo paramKryo, Output paramOutput, Object[] paramArrayOfObject)
    {
      int i = 0;
      if (paramArrayOfObject == null)
        paramOutput.writeVarInt(0, true);
      while (true)
      {
        return;
        paramOutput.writeVarInt(1 + paramArrayOfObject.length, true);
        Class localClass = paramArrayOfObject.getClass().getComponentType();
        if ((this.elementsAreSameType) || (Modifier.isFinal(localClass.getModifiers())))
        {
          Serializer localSerializer = paramKryo.getSerializer(localClass);
          localSerializer.setGenerics(paramKryo, this.generics);
          int j = paramArrayOfObject.length;
          label74: if (i < j)
          {
            if (!this.elementsCanBeNull)
              break label105;
            paramKryo.writeObjectOrNull(paramOutput, paramArrayOfObject[i], localSerializer);
          }
          while (true)
          {
            i++;
            break label74;
            break;
            label105: paramKryo.writeObject(paramOutput, paramArrayOfObject[i], localSerializer);
          }
        }
        int k = paramArrayOfObject.length;
        while (i < k)
        {
          if (paramArrayOfObject[i] != null)
            paramKryo.getSerializer(paramArrayOfObject[i].getClass()).setGenerics(paramKryo, this.generics);
          paramKryo.writeClassAndObject(paramOutput, paramArrayOfObject[i]);
          i++;
        }
      }
    }
  }

  public static class ShortArraySerializer extends Serializer<short[]>
  {
    public ShortArraySerializer()
    {
      setAcceptsNull(true);
    }

    public short[] copy(Kryo paramKryo, short[] paramArrayOfShort)
    {
      short[] arrayOfShort = new short[paramArrayOfShort.length];
      System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, arrayOfShort.length);
      return arrayOfShort;
    }

    public short[] read(Kryo paramKryo, Input paramInput, Class<short[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return paramInput.readShorts(i - 1);
    }

    public void write(Kryo paramKryo, Output paramOutput, short[] paramArrayOfShort)
    {
      if (paramArrayOfShort == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramArrayOfShort.length, true);
      paramOutput.writeShorts(paramArrayOfShort);
    }
  }

  public static class StringArraySerializer extends Serializer<String[]>
  {
    public StringArraySerializer()
    {
      setAcceptsNull(true);
    }

    public String[] copy(Kryo paramKryo, String[] paramArrayOfString)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, arrayOfString.length);
      return arrayOfString;
    }

    public String[] read(Kryo paramKryo, Input paramInput, Class<String[]> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      int j = i - 1;
      String[] arrayOfString = new String[j];
      boolean bool1 = paramKryo.getReferences();
      int k = 0;
      if (bool1)
      {
        boolean bool2 = paramKryo.getReferenceResolver().useReferences(String.class);
        k = 0;
        if (bool2)
        {
          Serializer localSerializer = paramKryo.getSerializer(String.class);
          for (int m = 0; m < j; m++)
            arrayOfString[m] = ((String)paramKryo.readObjectOrNull(paramInput, String.class, localSerializer));
        }
      }
      while (k < j)
      {
        arrayOfString[k] = paramInput.readString();
        k++;
      }
      return arrayOfString;
    }

    public void write(Kryo paramKryo, Output paramOutput, String[] paramArrayOfString)
    {
      int i = 0;
      if (paramArrayOfString == null)
        paramOutput.writeVarInt(0, true);
      while (true)
      {
        return;
        paramOutput.writeVarInt(1 + paramArrayOfString.length, true);
        if ((paramKryo.getReferences()) && (paramKryo.getReferenceResolver().useReferences(String.class)))
        {
          Serializer localSerializer = paramKryo.getSerializer(String.class);
          int k = paramArrayOfString.length;
          while (i < k)
          {
            paramKryo.writeObjectOrNull(paramOutput, paramArrayOfString[i], localSerializer);
            i++;
          }
        }
        else
        {
          int j = paramArrayOfString.length;
          while (i < j)
          {
            paramOutput.writeString(paramArrayOfString[i]);
            i++;
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.DefaultArraySerializers
 * JD-Core Version:    0.6.2
 */