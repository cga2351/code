package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeMemoryOutput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

class UnsafeCacheFields
{
  static final class UnsafeBooleanField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeBooleanField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putBoolean(paramObject2, this.offset, UnsafeUtil.unsafe().getBoolean(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putBoolean(paramObject, this.offset, paramInput.readBoolean());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeBoolean(UnsafeUtil.unsafe().getBoolean(paramObject, this.offset));
    }
  }

  static final class UnsafeByteField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeByteField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putByte(paramObject2, this.offset, UnsafeUtil.unsafe().getByte(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putByte(paramObject, this.offset, paramInput.readByte());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeByte(UnsafeUtil.unsafe().getByte(paramObject, this.offset));
    }
  }

  static abstract class UnsafeCachedField extends FieldSerializer.CachedField
  {
    UnsafeCachedField(long paramLong)
    {
      this.offset = paramLong;
    }
  }

  static final class UnsafeCharField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeCharField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putChar(paramObject2, this.offset, UnsafeUtil.unsafe().getChar(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putChar(paramObject, this.offset, paramInput.readChar());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeChar(UnsafeUtil.unsafe().getChar(paramObject, this.offset));
    }
  }

  static final class UnsafeDoubleField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeDoubleField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putDouble(paramObject2, this.offset, UnsafeUtil.unsafe().getDouble(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putDouble(paramObject, this.offset, paramInput.readDouble());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeDouble(UnsafeUtil.unsafe().getDouble(paramObject, this.offset));
    }
  }

  static final class UnsafeFloatField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeFloatField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putFloat(paramObject2, this.offset, UnsafeUtil.unsafe().getFloat(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putFloat(paramObject, this.offset, paramInput.readFloat());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeFloat(UnsafeUtil.unsafe().getFloat(paramObject, this.offset));
    }
  }

  static final class UnsafeIntField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeIntField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putInt(paramObject2, this.offset, UnsafeUtil.unsafe().getInt(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        UnsafeUtil.unsafe().putInt(paramObject, this.offset, paramInput.readInt(false));
        return;
      }
      UnsafeUtil.unsafe().putInt(paramObject, this.offset, paramInput.readInt());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        paramOutput.writeInt(UnsafeUtil.unsafe().getInt(paramObject, this.offset), false);
        return;
      }
      paramOutput.writeInt(UnsafeUtil.unsafe().getInt(paramObject, this.offset));
    }
  }

  static final class UnsafeLongField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeLongField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putLong(paramObject2, this.offset, UnsafeUtil.unsafe().getLong(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        UnsafeUtil.unsafe().putLong(paramObject, this.offset, paramInput.readLong(false));
        return;
      }
      UnsafeUtil.unsafe().putLong(paramObject, this.offset, paramInput.readLong());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        paramOutput.writeLong(UnsafeUtil.unsafe().getLong(paramObject, this.offset), false);
        return;
      }
      paramOutput.writeLong(UnsafeUtil.unsafe().getLong(paramObject, this.offset));
    }
  }

  static final class UnsafeObjectField extends ObjectField
  {
    public UnsafeObjectField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        if (this.offset != -1L)
        {
          UnsafeUtil.unsafe().putObject(paramObject2, this.offset, this.kryo.copy(UnsafeUtil.unsafe().getObject(paramObject1, this.offset)));
          return;
        }
        throw new KryoException("Unknown offset");
      }
      catch (KryoException localKryoException2)
      {
        localKryoException2.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException2;
      }
      catch (RuntimeException localRuntimeException)
      {
        KryoException localKryoException1 = new KryoException(localRuntimeException);
        localKryoException1.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException1;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      if (this.offset >= 0L)
        return UnsafeUtil.unsafe().getObject(paramObject, this.offset);
      throw new KryoException("Unknown offset");
    }

    public void setField(Object paramObject1, Object paramObject2)
      throws IllegalArgumentException, IllegalAccessException
    {
      if (this.offset != -1L)
      {
        UnsafeUtil.unsafe().putObject(paramObject1, this.offset, paramObject2);
        return;
      }
      throw new KryoException("Unknown offset");
    }
  }

  static final class UnsafeRegionField extends UnsafeCacheFields.UnsafeCachedField
  {
    static final boolean bulkReadsSupported;
    final long len;

    public UnsafeRegionField(long paramLong1, long paramLong2)
    {
      super();
      this.len = paramLong2;
    }

    private void readSlow(Input paramInput, Object paramObject)
    {
      Unsafe localUnsafe = UnsafeUtil.unsafe();
      for (long l = this.offset; l < this.offset + this.len - 8L; l += 8L)
        localUnsafe.putLong(paramObject, l, paramInput.readLong());
      if (l < this.offset + this.len)
        while (l < this.offset + this.len)
        {
          localUnsafe.putByte(paramObject, l, paramInput.readByte());
          l += 1L;
        }
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().copyMemory(paramObject1, this.offset, paramObject2, this.offset, this.len);
    }

    public final void read(Input paramInput, Object paramObject)
    {
      readSlow(paramInput, paramObject);
    }

    public final void write(Output paramOutput, Object paramObject)
    {
      if ((paramOutput instanceof UnsafeOutput))
        ((UnsafeOutput)paramOutput).writeBytes(paramObject, this.offset, this.len);
      while (true)
      {
        return;
        if ((paramOutput instanceof UnsafeMemoryOutput))
        {
          ((UnsafeMemoryOutput)paramOutput).writeBytes(paramObject, this.offset, this.len);
          return;
        }
        Unsafe localUnsafe = UnsafeUtil.unsafe();
        for (long l = this.offset; l < this.offset + this.len - 8L; l += 8L)
          paramOutput.writeLong(localUnsafe.getLong(paramObject, l));
        if (l < this.offset + this.len)
          while (l < this.offset + this.len)
          {
            paramOutput.write(localUnsafe.getByte(paramObject, l));
            l += 1L;
          }
      }
    }
  }

  static final class UnsafeShortField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeShortField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putShort(paramObject2, this.offset, UnsafeUtil.unsafe().getShort(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putShort(paramObject, this.offset, paramInput.readShort());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeShort(UnsafeUtil.unsafe().getShort(paramObject, this.offset));
    }
  }

  static final class UnsafeStringField extends UnsafeCacheFields.UnsafeCachedField
  {
    public UnsafeStringField(Field paramField)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      UnsafeUtil.unsafe().putObject(paramObject2, this.offset, UnsafeUtil.unsafe().getObject(paramObject1, this.offset));
    }

    public void read(Input paramInput, Object paramObject)
    {
      UnsafeUtil.unsafe().putObject(paramObject, this.offset, paramInput.readString());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeString((String)UnsafeUtil.unsafe().getObject(paramObject, this.offset));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.UnsafeCacheFields
 * JD-Core Version:    0.6.2
 */