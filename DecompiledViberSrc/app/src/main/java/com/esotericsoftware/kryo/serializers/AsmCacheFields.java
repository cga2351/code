package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.reflectasm.FieldAccess;

class AsmCacheFields
{
  static final class AsmBooleanField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setBoolean(paramObject2, this.accessIndex, this.access.getBoolean(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setBoolean(paramObject, this.accessIndex, paramInput.readBoolean());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeBoolean(this.access.getBoolean(paramObject, this.accessIndex));
    }
  }

  static final class AsmByteField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setByte(paramObject2, this.accessIndex, this.access.getByte(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setByte(paramObject, this.accessIndex, paramInput.readByte());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeByte(this.access.getByte(paramObject, this.accessIndex));
    }
  }

  static abstract class AsmCachedField extends FieldSerializer.CachedField
  {
  }

  static final class AsmCharField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setChar(paramObject2, this.accessIndex, this.access.getChar(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setChar(paramObject, this.accessIndex, paramInput.readChar());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeChar(this.access.getChar(paramObject, this.accessIndex));
    }
  }

  static final class AsmDoubleField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setDouble(paramObject2, this.accessIndex, this.access.getDouble(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setDouble(paramObject, this.accessIndex, paramInput.readDouble());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeDouble(this.access.getDouble(paramObject, this.accessIndex));
    }
  }

  static final class AsmFloatField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setFloat(paramObject2, this.accessIndex, this.access.getFloat(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setFloat(paramObject, this.accessIndex, paramInput.readFloat());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeFloat(this.access.getFloat(paramObject, this.accessIndex));
    }
  }

  static final class AsmIntField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setInt(paramObject2, this.accessIndex, this.access.getInt(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        this.access.setInt(paramObject, this.accessIndex, paramInput.readInt(false));
        return;
      }
      this.access.setInt(paramObject, this.accessIndex, paramInput.readInt());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        paramOutput.writeInt(this.access.getInt(paramObject, this.accessIndex), false);
        return;
      }
      paramOutput.writeInt(this.access.getInt(paramObject, this.accessIndex));
    }
  }

  static final class AsmLongField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setLong(paramObject2, this.accessIndex, this.access.getLong(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        this.access.setLong(paramObject, this.accessIndex, paramInput.readLong(false));
        return;
      }
      this.access.setLong(paramObject, this.accessIndex, paramInput.readLong());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      if (this.varIntsEnabled)
      {
        paramOutput.writeLong(this.access.getLong(paramObject, this.accessIndex), false);
        return;
      }
      paramOutput.writeLong(this.access.getLong(paramObject, this.accessIndex));
    }
  }

  static final class AsmObjectField extends ObjectField
  {
    public AsmObjectField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        if (this.accessIndex != -1)
        {
          this.access.set(paramObject2, this.accessIndex, this.kryo.copy(this.access.get(paramObject1, this.accessIndex)));
          return;
        }
        throw new KryoException("Unknown acess index");
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
      if (this.accessIndex != -1)
        return this.access.get(paramObject, this.accessIndex);
      throw new KryoException("Unknown acess index");
    }

    public void setField(Object paramObject1, Object paramObject2)
      throws IllegalArgumentException, IllegalAccessException
    {
      if (this.accessIndex != -1)
      {
        this.access.set(paramObject1, this.accessIndex, paramObject2);
        return;
      }
      throw new KryoException("Unknown acess index");
    }
  }

  static final class AsmShortField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.setShort(paramObject2, this.accessIndex, this.access.getShort(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.setShort(paramObject, this.accessIndex, paramInput.readShort());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeShort(this.access.getShort(paramObject, this.accessIndex));
    }
  }

  static final class AsmStringField extends AsmCacheFields.AsmCachedField
  {
    public void copy(Object paramObject1, Object paramObject2)
    {
      this.access.set(paramObject2, this.accessIndex, this.access.getString(paramObject1, this.accessIndex));
    }

    public void read(Input paramInput, Object paramObject)
    {
      this.access.set(paramObject, this.accessIndex, paramInput.readString());
    }

    public void write(Output paramOutput, Object paramObject)
    {
      paramOutput.writeString(this.access.getString(paramObject, this.accessIndex));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.AsmCacheFields
 * JD-Core Version:    0.6.2
 */