package org.objenesis.instantiator.basic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class ObjectInputStreamInstantiator<T>
  implements ObjectInstantiator<T>
{
  private ObjectInputStream inputStream;

  public ObjectInputStreamInstantiator(Class<T> paramClass)
  {
    if (Serializable.class.isAssignableFrom(paramClass))
      try
      {
        this.inputStream = new ObjectInputStream(new MockStream(paramClass));
        return;
      }
      catch (IOException localIOException)
      {
        throw new Error("IOException: " + localIOException.getMessage());
      }
    throw new ObjenesisException(new NotSerializableException(paramClass + " not serializable"));
  }

  public T newInstance()
  {
    try
    {
      Object localObject = this.inputStream.readObject();
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new Error("ClassNotFoundException: " + localClassNotFoundException.getMessage());
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }

  private static class MockStream extends InputStream
  {
    private static byte[] HEADER;
    private static final int[] NEXT = { 1, 2, 2 };
    private static byte[] REPEATING_DATA;
    private final byte[] FIRST_DATA;
    private byte[][] buffers;
    private byte[] data = HEADER;
    private int pointer = 0;
    private int sequence = 0;

    static
    {
      initialize();
    }

    public MockStream(Class<?> paramClass)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      try
      {
        localDataOutputStream.writeByte(115);
        localDataOutputStream.writeByte(114);
        localDataOutputStream.writeUTF(paramClass.getName());
        localDataOutputStream.writeLong(ObjectStreamClass.lookup(paramClass).getSerialVersionUID());
        localDataOutputStream.writeByte(2);
        localDataOutputStream.writeShort(0);
        localDataOutputStream.writeByte(120);
        localDataOutputStream.writeByte(112);
        this.FIRST_DATA = localByteArrayOutputStream.toByteArray();
        byte[][] arrayOfByte = new byte[3][];
        arrayOfByte[0] = HEADER;
        arrayOfByte[1] = this.FIRST_DATA;
        arrayOfByte[2] = REPEATING_DATA;
        this.buffers = arrayOfByte;
        return;
      }
      catch (IOException localIOException)
      {
        throw new Error("IOException: " + localIOException.getMessage());
      }
    }

    private void advanceBuffer()
    {
      this.pointer = 0;
      this.sequence = NEXT[this.sequence];
      this.data = this.buffers[this.sequence];
    }

    private static void initialize()
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream1 = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream1 = new DataOutputStream(localByteArrayOutputStream1);
        localDataOutputStream1.writeShort(-21267);
        localDataOutputStream1.writeShort(5);
        HEADER = localByteArrayOutputStream1.toByteArray();
        ByteArrayOutputStream localByteArrayOutputStream2 = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream2 = new DataOutputStream(localByteArrayOutputStream2);
        localDataOutputStream2.writeByte(115);
        localDataOutputStream2.writeByte(113);
        localDataOutputStream2.writeInt(8257536);
        REPEATING_DATA = localByteArrayOutputStream2.toByteArray();
        return;
      }
      catch (IOException localIOException)
      {
        throw new Error("IOException: " + localIOException.getMessage());
      }
    }

    public int available()
      throws IOException
    {
      return 2147483647;
    }

    public int read()
      throws IOException
    {
      byte[] arrayOfByte = this.data;
      int i = this.pointer;
      this.pointer = (i + 1);
      int j = arrayOfByte[i];
      if (this.pointer >= this.data.length)
        advanceBuffer();
      return j;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = this.data.length - this.pointer;
      int j = paramInt2;
      while (i <= j)
      {
        System.arraycopy(this.data, this.pointer, paramArrayOfByte, paramInt1, i);
        paramInt1 += i;
        j -= i;
        advanceBuffer();
        i = this.data.length - this.pointer;
      }
      if (j > 0)
      {
        System.arraycopy(this.data, this.pointer, paramArrayOfByte, paramInt1, j);
        this.pointer = (j + this.pointer);
      }
      return paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.ObjectInputStreamInstantiator
 * JD-Core Version:    0.6.2
 */