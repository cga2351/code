package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ByteBufferInput extends Input
{
  protected static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
  ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
  protected ByteBuffer niobuffer;
  protected boolean varIntsEnabled = true;

  public ByteBufferInput()
  {
  }

  public ByteBufferInput(int paramInt)
  {
    this.capacity = paramInt;
    this.niobuffer = ByteBuffer.allocateDirect(paramInt);
    this.niobuffer.order(this.byteOrder);
  }

  public ByteBufferInput(long paramLong, int paramInt)
  {
    setBuffer(UnsafeUtil.getDirectBufferAt(paramLong, paramInt));
  }

  public ByteBufferInput(InputStream paramInputStream)
  {
    this(4096);
    if (paramInputStream == null)
      throw new IllegalArgumentException("inputStream cannot be null.");
    this.inputStream = paramInputStream;
  }

  public ByteBufferInput(InputStream paramInputStream, int paramInt)
  {
    this(paramInt);
    if (paramInputStream == null)
      throw new IllegalArgumentException("inputStream cannot be null.");
    this.inputStream = paramInputStream;
  }

  public ByteBufferInput(ByteBuffer paramByteBuffer)
  {
    setBuffer(paramByteBuffer);
  }

  public ByteBufferInput(byte[] paramArrayOfByte)
  {
    setBuffer(paramArrayOfByte);
  }

  private boolean isNativeOrder()
  {
    return this.byteOrder == nativeOrder;
  }

  private int optional(int paramInt)
    throws KryoException
  {
    int i = -1;
    int j = this.limit - this.position;
    if (j >= paramInt)
      i = paramInt;
    int k;
    int m;
    do
    {
      return i;
      k = Math.min(paramInt, this.capacity);
      m = fill(this.niobuffer, this.limit, this.capacity - this.limit);
      if (m != i)
        break;
    }
    while (j == 0);
    return Math.min(j, k);
    int n = j + m;
    if (n >= k)
    {
      this.limit = (m + this.limit);
      return k;
    }
    this.niobuffer.compact();
    this.total += this.position;
    this.position = 0;
    label125: int i1 = fill(this.niobuffer, n, this.capacity - n);
    if (i1 == i);
    while (true)
    {
      this.limit = n;
      this.niobuffer.position(this.position);
      if (n == 0)
        break;
      return Math.min(n, k);
      n += i1;
      if (n < k)
        break label125;
    }
  }

  private String readAscii()
  {
    int i = this.position;
    int j = i - 1;
    int k = this.limit;
    while (true)
    {
      if (i == k)
        return readAscii_slow();
      int m = i + 1;
      if ((0x80 & this.niobuffer.get()) != 0)
      {
        this.niobuffer.put(m - 1, (byte)(0x7F & this.niobuffer.get(m - 1)));
        byte[] arrayOfByte = new byte[m - j];
        this.niobuffer.position(j);
        this.niobuffer.get(arrayOfByte);
        String str = new String(arrayOfByte, 0, 0, m - j);
        this.niobuffer.put(m - 1, (byte)(0x80 | this.niobuffer.get(m - 1)));
        this.position = m;
        this.niobuffer.position(this.position);
        return str;
      }
      i = m;
    }
  }

  private String readAscii_slow()
  {
    this.position = (-1 + this.position);
    int i = this.limit - this.position;
    if (i > this.chars.length)
      this.chars = new char[i * 2];
    Object localObject = this.chars;
    int j = this.position;
    int k = this.limit;
    int m = j;
    for (int n = 0; m < k; n++)
    {
      localObject[n] = ((char)this.niobuffer.get(m));
      m++;
    }
    this.position = this.limit;
    while (true)
    {
      require(1);
      this.position = (1 + this.position);
      int i1 = this.niobuffer.get();
      if (i == localObject.length)
      {
        char[] arrayOfChar = new char[i * 2];
        System.arraycopy(localObject, 0, arrayOfChar, 0, i);
        this.chars = arrayOfChar;
        localObject = arrayOfChar;
      }
      if ((i1 & 0x80) == 128)
      {
        int i3 = i + 1;
        localObject[i] = ((char)(i1 & 0x7F));
        return new String((char[])localObject, 0, i3);
      }
      int i2 = i + 1;
      localObject[i] = ((char)i1);
      i = i2;
    }
  }

  private int readInt_slow(boolean paramBoolean)
  {
    this.position = (1 + this.position);
    int i = this.niobuffer.get();
    int j = i & 0x7F;
    if ((i & 0x80) != 0)
    {
      require(1);
      this.position = (1 + this.position);
      int k = this.niobuffer.get();
      j |= (k & 0x7F) << 7;
      if ((k & 0x80) != 0)
      {
        require(1);
        this.position = (1 + this.position);
        int m = this.niobuffer.get();
        j |= (m & 0x7F) << 14;
        if ((m & 0x80) != 0)
        {
          require(1);
          this.position = (1 + this.position);
          int n = this.niobuffer.get();
          j |= (n & 0x7F) << 21;
          if ((n & 0x80) != 0)
          {
            require(1);
            this.position = (1 + this.position);
            j |= (0x7F & this.niobuffer.get()) << 28;
          }
        }
      }
    }
    if (paramBoolean)
      return j;
    return j >>> 1 ^ -(j & 0x1);
  }

  private long readLong_slow(boolean paramBoolean)
  {
    this.position = (1 + this.position);
    int i = this.niobuffer.get();
    long l = i & 0x7F;
    if ((i & 0x80) != 0)
    {
      require(1);
      this.position = (1 + this.position);
      int j = this.niobuffer.get();
      l |= (j & 0x7F) << 7;
      if ((j & 0x80) != 0)
      {
        require(1);
        this.position = (1 + this.position);
        int k = this.niobuffer.get();
        l |= (k & 0x7F) << 14;
        if ((k & 0x80) != 0)
        {
          require(1);
          this.position = (1 + this.position);
          int m = this.niobuffer.get();
          l |= (m & 0x7F) << 21;
          if ((m & 0x80) != 0)
          {
            require(1);
            this.position = (1 + this.position);
            int n = this.niobuffer.get();
            l |= (n & 0x7F) << 28;
            if ((n & 0x80) != 0)
            {
              require(1);
              this.position = (1 + this.position);
              int i1 = this.niobuffer.get();
              l |= (i1 & 0x7F) << 35;
              if ((i1 & 0x80) != 0)
              {
                require(1);
                this.position = (1 + this.position);
                int i2 = this.niobuffer.get();
                l |= (i2 & 0x7F) << 42;
                if ((i2 & 0x80) != 0)
                {
                  require(1);
                  this.position = (1 + this.position);
                  int i3 = this.niobuffer.get();
                  l |= (i3 & 0x7F) << 49;
                  if ((i3 & 0x80) != 0)
                  {
                    require(1);
                    this.position = (1 + this.position);
                    l |= this.niobuffer.get() << 56;
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!paramBoolean)
      l = l >>> 1 ^ -(l & 1L);
    return l;
  }

  private void readUtf8(int paramInt)
  {
    char[] arrayOfChar = this.chars;
    int i = 0;
    int j = Math.min(require(1), paramInt);
    int k = this.position;
    while (true)
    {
      int m;
      if (i < j)
      {
        k++;
        m = this.niobuffer.get();
        if (m < 0)
          k--;
      }
      else
      {
        this.position = k;
        if (i < paramInt)
        {
          this.niobuffer.position(k);
          readUtf8_slow(paramInt, i);
        }
        return;
      }
      int n = i + 1;
      arrayOfChar[i] = ((char)m);
      i = n;
    }
  }

  private int readUtf8Length(int paramInt)
  {
    int i = paramInt & 0x3F;
    if ((paramInt & 0x40) != 0)
    {
      this.position = (1 + this.position);
      int j = this.niobuffer.get();
      i |= (j & 0x7F) << 6;
      if ((j & 0x80) != 0)
      {
        this.position = (1 + this.position);
        int k = this.niobuffer.get();
        i |= (k & 0x7F) << 13;
        if ((k & 0x80) != 0)
        {
          this.position = (1 + this.position);
          int m = this.niobuffer.get();
          i |= (m & 0x7F) << 20;
          if ((m & 0x80) != 0)
          {
            this.position = (1 + this.position);
            i |= (0x7F & this.niobuffer.get()) << 27;
          }
        }
      }
    }
    return i;
  }

  private int readUtf8Length_slow(int paramInt)
  {
    int i = paramInt & 0x3F;
    if ((paramInt & 0x40) != 0)
    {
      require(1);
      this.position = (1 + this.position);
      int j = this.niobuffer.get();
      i |= (j & 0x7F) << 6;
      if ((j & 0x80) != 0)
      {
        require(1);
        this.position = (1 + this.position);
        int k = this.niobuffer.get();
        i |= (k & 0x7F) << 13;
        if ((k & 0x80) != 0)
        {
          require(1);
          this.position = (1 + this.position);
          int m = this.niobuffer.get();
          i |= (m & 0x7F) << 20;
          if ((m & 0x80) != 0)
          {
            require(1);
            this.position = (1 + this.position);
            i |= (0x7F & this.niobuffer.get()) << 27;
          }
        }
      }
    }
    return i;
  }

  private void readUtf8_slow(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.chars;
    if (paramInt2 < paramInt1)
    {
      if (this.position == this.limit)
        require(1);
      this.position = (1 + this.position);
      int i = 0xFF & this.niobuffer.get();
      switch (i >> 4)
      {
      case 8:
      case 9:
      case 10:
      case 11:
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 12:
      case 13:
      case 14:
      }
      while (true)
      {
        paramInt2++;
        break;
        arrayOfChar[paramInt2] = ((char)i);
        continue;
        if (this.position == this.limit)
          require(1);
        this.position = (1 + this.position);
        arrayOfChar[paramInt2] = ((char)((i & 0x1F) << 6 | 0x3F & this.niobuffer.get()));
        continue;
        require(2);
        this.position = (2 + this.position);
        int j = this.niobuffer.get();
        int k = this.niobuffer.get();
        arrayOfChar[paramInt2] = ((char)((i & 0xF) << 12 | (j & 0x3F) << 6 | k & 0x3F));
      }
    }
  }

  public boolean canReadInt()
    throws KryoException
  {
    if (this.limit - this.position >= 5);
    int m;
    ByteBuffer localByteBuffer4;
    int n;
    do
    {
      int k;
      ByteBuffer localByteBuffer3;
      do
      {
        int j;
        ByteBuffer localByteBuffer2;
        do
        {
          int i;
          ByteBuffer localByteBuffer1;
          do
          {
            return true;
            if (optional(5) <= 0)
              return false;
            i = this.position;
            localByteBuffer1 = this.niobuffer;
            j = i + 1;
          }
          while ((0x80 & localByteBuffer1.get(i)) == 0);
          if (j == this.limit)
            return false;
          localByteBuffer2 = this.niobuffer;
          k = j + 1;
        }
        while ((0x80 & localByteBuffer2.get(j)) == 0);
        if (k == this.limit)
          return false;
        localByteBuffer3 = this.niobuffer;
        m = k + 1;
      }
      while ((0x80 & localByteBuffer3.get(k)) == 0);
      if (m == this.limit)
        return false;
      localByteBuffer4 = this.niobuffer;
      n = m + 1;
    }
    while (((0x80 & localByteBuffer4.get(m)) == 0) || (n != this.limit));
    return false;
  }

  public boolean canReadLong()
    throws KryoException
  {
    if (this.limit - this.position >= 9);
    int i3;
    ByteBuffer localByteBuffer8;
    int i4;
    do
    {
      int i2;
      ByteBuffer localByteBuffer7;
      do
      {
        int i1;
        ByteBuffer localByteBuffer6;
        do
        {
          int n;
          ByteBuffer localByteBuffer5;
          do
          {
            int m;
            ByteBuffer localByteBuffer4;
            do
            {
              int k;
              ByteBuffer localByteBuffer3;
              do
              {
                int j;
                ByteBuffer localByteBuffer2;
                do
                {
                  int i;
                  ByteBuffer localByteBuffer1;
                  do
                  {
                    return true;
                    if (optional(5) <= 0)
                      return false;
                    i = this.position;
                    localByteBuffer1 = this.niobuffer;
                    j = i + 1;
                  }
                  while ((0x80 & localByteBuffer1.get(i)) == 0);
                  if (j == this.limit)
                    return false;
                  localByteBuffer2 = this.niobuffer;
                  k = j + 1;
                }
                while ((0x80 & localByteBuffer2.get(j)) == 0);
                if (k == this.limit)
                  return false;
                localByteBuffer3 = this.niobuffer;
                m = k + 1;
              }
              while ((0x80 & localByteBuffer3.get(k)) == 0);
              if (m == this.limit)
                return false;
              localByteBuffer4 = this.niobuffer;
              n = m + 1;
            }
            while ((0x80 & localByteBuffer4.get(m)) == 0);
            if (n == this.limit)
              return false;
            localByteBuffer5 = this.niobuffer;
            i1 = n + 1;
          }
          while ((0x80 & localByteBuffer5.get(n)) == 0);
          if (i1 == this.limit)
            return false;
          localByteBuffer6 = this.niobuffer;
          i2 = i1 + 1;
        }
        while ((0x80 & localByteBuffer6.get(i1)) == 0);
        if (i2 == this.limit)
          return false;
        localByteBuffer7 = this.niobuffer;
        i3 = i2 + 1;
      }
      while ((0x80 & localByteBuffer7.get(i2)) == 0);
      if (i3 == this.limit)
        return false;
      localByteBuffer8 = this.niobuffer;
      i4 = i3 + 1;
    }
    while (((0x80 & localByteBuffer8.get(i3)) == 0) || (i4 != this.limit));
    return false;
  }

  public void close()
    throws KryoException
  {
    if (this.inputStream != null);
    try
    {
      this.inputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  protected int fill(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    throws KryoException
  {
    int i;
    if (this.inputStream == null)
      i = -1;
    while (true)
    {
      return i;
      try
      {
        byte[] arrayOfByte = new byte[paramInt2];
        i = this.inputStream.read(arrayOfByte, 0, paramInt2);
        paramByteBuffer.position(paramInt1);
        if (i < 0)
          continue;
        paramByteBuffer.put(arrayOfByte, 0, i);
        paramByteBuffer.position(paramInt1);
        return i;
      }
      catch (IOException localIOException)
      {
        throw new KryoException(localIOException);
      }
    }
  }

  public ByteBuffer getByteBuffer()
  {
    return this.niobuffer;
  }

  public InputStream getInputStream()
  {
    return this.inputStream;
  }

  public boolean getVarIntsEnabled()
  {
    return this.varIntsEnabled;
  }

  public ByteOrder order()
  {
    return this.byteOrder;
  }

  public void order(ByteOrder paramByteOrder)
  {
    this.byteOrder = paramByteOrder;
  }

  public int read()
    throws KryoException
  {
    if (optional(1) <= 0)
      return -1;
    this.niobuffer.position(this.position);
    this.position = (1 + this.position);
    return 0xFF & this.niobuffer.get();
  }

  public int read(byte[] paramArrayOfByte)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    int i = Math.min(this.limit - this.position, paramInt2);
    int j = paramInt2;
    this.niobuffer.get(paramArrayOfByte, paramInt1, i);
    this.position = (i + this.position);
    j -= i;
    if (j == 0);
    while (true)
    {
      return paramInt2 - j;
      paramInt1 += i;
      i = optional(j);
      if (i == -1)
      {
        if (paramInt2 == j)
          return -1;
      }
      else
        if (this.position != this.limit)
          break;
    }
  }

  public boolean readBoolean()
    throws KryoException
  {
    require(1);
    this.position = (1 + this.position);
    return this.niobuffer.get() == 1;
  }

  public byte readByte()
    throws KryoException
  {
    this.niobuffer.position(this.position);
    require(1);
    this.position = (1 + this.position);
    return this.niobuffer.get();
  }

  public int readByteUnsigned()
    throws KryoException
  {
    require(1);
    this.position = (1 + this.position);
    return 0xFF & this.niobuffer.get();
  }

  public void readBytes(byte[] paramArrayOfByte)
    throws KryoException
  {
    readBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    int i = Math.min(this.limit - this.position, paramInt2);
    while (true)
    {
      this.niobuffer.get(paramArrayOfByte, paramInt1, i);
      this.position = (i + this.position);
      paramInt2 -= i;
      if (paramInt2 == 0)
        return;
      paramInt1 += i;
      i = Math.min(paramInt2, this.capacity);
      require(i);
    }
  }

  public byte[] readBytes(int paramInt)
    throws KryoException
  {
    byte[] arrayOfByte = new byte[paramInt];
    readBytes(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }

  public char readChar()
    throws KryoException
  {
    require(2);
    this.position = (2 + this.position);
    return this.niobuffer.getChar();
  }

  public char[] readChars(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 2) && (isNativeOrder()))
    {
      char[] arrayOfChar = new char[paramInt];
      this.niobuffer.asCharBuffer().get(arrayOfChar);
      this.position += paramInt * 2;
      this.niobuffer.position(this.position);
      return arrayOfChar;
    }
    return super.readChars(paramInt);
  }

  public double readDouble()
    throws KryoException
  {
    require(8);
    this.position = (8 + this.position);
    return this.niobuffer.getDouble();
  }

  public double readDouble(double paramDouble, boolean paramBoolean)
    throws KryoException
  {
    return readLong(paramBoolean) / paramDouble;
  }

  public double[] readDoubles(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 8) && (isNativeOrder()))
    {
      double[] arrayOfDouble = new double[paramInt];
      this.niobuffer.asDoubleBuffer().get(arrayOfDouble);
      this.position += paramInt * 8;
      this.niobuffer.position(this.position);
      return arrayOfDouble;
    }
    return super.readDoubles(paramInt);
  }

  public float readFloat()
    throws KryoException
  {
    require(4);
    this.position = (4 + this.position);
    return this.niobuffer.getFloat();
  }

  public float readFloat(float paramFloat, boolean paramBoolean)
    throws KryoException
  {
    return readInt(paramBoolean) / paramFloat;
  }

  public float[] readFloats(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 4) && (isNativeOrder()))
    {
      float[] arrayOfFloat = new float[paramInt];
      this.niobuffer.asFloatBuffer().get(arrayOfFloat);
      this.position += paramInt * 4;
      this.niobuffer.position(this.position);
      return arrayOfFloat;
    }
    return super.readFloats(paramInt);
  }

  public int readInt()
    throws KryoException
  {
    require(4);
    this.position = (4 + this.position);
    return this.niobuffer.getInt();
  }

  public int readInt(boolean paramBoolean)
    throws KryoException
  {
    if (this.varIntsEnabled)
      return readVarInt(paramBoolean);
    return readInt();
  }

  public int[] readInts(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 4) && (isNativeOrder()))
    {
      int[] arrayOfInt = new int[paramInt];
      this.niobuffer.asIntBuffer().get(arrayOfInt);
      this.position += paramInt * 4;
      this.niobuffer.position(this.position);
      return arrayOfInt;
    }
    return super.readInts(paramInt);
  }

  public long readLong()
    throws KryoException
  {
    require(8);
    this.position = (8 + this.position);
    return this.niobuffer.getLong();
  }

  public long readLong(boolean paramBoolean)
    throws KryoException
  {
    if (this.varIntsEnabled)
      return readVarLong(paramBoolean);
    return readLong();
  }

  public long[] readLongs(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 8) && (isNativeOrder()))
    {
      long[] arrayOfLong = new long[paramInt];
      this.niobuffer.asLongBuffer().get(arrayOfLong);
      this.position += paramInt * 8;
      this.niobuffer.position(this.position);
      return arrayOfLong;
    }
    return super.readLongs(paramInt);
  }

  public short readShort()
    throws KryoException
  {
    require(2);
    this.position = (2 + this.position);
    return this.niobuffer.getShort();
  }

  public int readShortUnsigned()
    throws KryoException
  {
    require(2);
    this.position = (2 + this.position);
    return this.niobuffer.getShort();
  }

  public short[] readShorts(int paramInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= paramInt * 2) && (isNativeOrder()))
    {
      short[] arrayOfShort = new short[paramInt];
      this.niobuffer.asShortBuffer().get(arrayOfShort);
      this.position += paramInt * 2;
      this.niobuffer.position(this.position);
      return arrayOfShort;
    }
    return super.readShorts(paramInt);
  }

  public String readString()
  {
    this.niobuffer.position(this.position);
    int i = require(1);
    this.position = (1 + this.position);
    int j = this.niobuffer.get();
    if ((j & 0x80) == 0)
      return readAscii();
    if (i >= 5);
    for (int k = readUtf8Length(j); ; k = readUtf8Length_slow(j))
      switch (k)
      {
      default:
        int m = k - 1;
        if (this.chars.length < m)
          this.chars = new char[m];
        readUtf8(m);
        return new String(this.chars, 0, m);
      case 0:
      case 1:
      }
    return null;
    return "";
  }

  public StringBuilder readStringBuilder()
  {
    this.niobuffer.position(this.position);
    int i = require(1);
    this.position = (1 + this.position);
    int j = this.niobuffer.get();
    if ((j & 0x80) == 0)
      return new StringBuilder(readAscii());
    if (i >= 5);
    for (int k = readUtf8Length(j); ; k = readUtf8Length_slow(j))
      switch (k)
      {
      default:
        int m = k - 1;
        if (this.chars.length < m)
          this.chars = new char[m];
        readUtf8(m);
        StringBuilder localStringBuilder = new StringBuilder(m);
        localStringBuilder.append(this.chars, 0, m);
        return localStringBuilder;
      case 0:
      case 1:
      }
    return null;
    return new StringBuilder("");
  }

  public int readVarInt(boolean paramBoolean)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    int j;
    if (require(1) < 5)
      j = readInt_slow(paramBoolean);
    do
    {
      return j;
      this.position = (1 + this.position);
      int i = this.niobuffer.get();
      j = i & 0x7F;
      if ((i & 0x80) != 0)
      {
        this.position = (1 + this.position);
        int k = this.niobuffer.get();
        j |= (k & 0x7F) << 7;
        if ((k & 0x80) != 0)
        {
          this.position = (1 + this.position);
          int m = this.niobuffer.get();
          j |= (m & 0x7F) << 14;
          if ((m & 0x80) != 0)
          {
            this.position = (1 + this.position);
            int n = this.niobuffer.get();
            j |= (n & 0x7F) << 21;
            if ((n & 0x80) != 0)
            {
              this.position = (1 + this.position);
              j |= (0x7F & this.niobuffer.get()) << 28;
            }
          }
        }
      }
    }
    while (paramBoolean);
    return j >>> 1 ^ -(j & 0x1);
  }

  public long readVarLong(boolean paramBoolean)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    long l;
    if (require(1) < 9)
      l = readLong_slow(paramBoolean);
    do
    {
      return l;
      this.position = (1 + this.position);
      int i = this.niobuffer.get();
      l = i & 0x7F;
      if ((i & 0x80) != 0)
      {
        this.position = (1 + this.position);
        int j = this.niobuffer.get();
        l |= (j & 0x7F) << 7;
        if ((j & 0x80) != 0)
        {
          this.position = (1 + this.position);
          int k = this.niobuffer.get();
          l |= (k & 0x7F) << 14;
          if ((k & 0x80) != 0)
          {
            this.position = (1 + this.position);
            int m = this.niobuffer.get();
            l |= (m & 0x7F) << 21;
            if ((m & 0x80) != 0)
            {
              this.position = (1 + this.position);
              int n = this.niobuffer.get();
              l |= (n & 0x7F) << 28;
              if ((n & 0x80) != 0)
              {
                this.position = (1 + this.position);
                int i1 = this.niobuffer.get();
                l |= (i1 & 0x7F) << 35;
                if ((i1 & 0x80) != 0)
                {
                  this.position = (1 + this.position);
                  int i2 = this.niobuffer.get();
                  l |= (i2 & 0x7F) << 42;
                  if ((i2 & 0x80) != 0)
                  {
                    this.position = (1 + this.position);
                    int i3 = this.niobuffer.get();
                    l |= (i3 & 0x7F) << 49;
                    if ((i3 & 0x80) != 0)
                    {
                      this.position = (1 + this.position);
                      l |= this.niobuffer.get() << 56;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    while (paramBoolean);
    return l >>> 1 ^ -(l & 1L);
  }

  public void release()
  {
    close();
    UnsafeUtil.releaseBuffer(this.niobuffer);
    this.niobuffer = null;
  }

  protected final int require(int paramInt)
    throws KryoException
  {
    int i = this.limit - this.position;
    if (i >= paramInt)
      return i;
    if (paramInt > this.capacity)
      throw new KryoException("Buffer too small: capacity: " + this.capacity + ", required: " + paramInt);
    if (i > 0)
    {
      int k = fill(this.niobuffer, this.limit, this.capacity - this.limit);
      if (k == -1)
        throw new KryoException("Buffer underflow.");
      i += k;
      if (i >= paramInt)
      {
        this.limit = (k + this.limit);
        return i;
      }
    }
    this.niobuffer.position(this.position);
    this.niobuffer.compact();
    this.total += this.position;
    this.position = 0;
    int j = fill(this.niobuffer, i, this.capacity - i);
    if (j == -1)
      if (i < paramInt);
    while (true)
    {
      this.limit = i;
      this.niobuffer.position(0);
      return i;
      throw new KryoException("Buffer underflow.");
      i += j;
      if (i < paramInt)
        break;
    }
  }

  public void rewind()
  {
    super.rewind();
    this.niobuffer.position(0);
  }

  public void setBuffer(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("buffer cannot be null.");
    this.niobuffer = paramByteBuffer;
    this.position = paramByteBuffer.position();
    this.limit = paramByteBuffer.limit();
    this.capacity = paramByteBuffer.capacity();
    this.total = 0L;
    this.inputStream = null;
  }

  public void setBuffer(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.position(0);
    localByteBuffer.limit(paramArrayOfByte.length);
    localByteBuffer.order(this.byteOrder);
    setBuffer(localByteBuffer);
  }

  public void setInputStream(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
    this.limit = 0;
    rewind();
  }

  public void setVarIntsEnabled(boolean paramBoolean)
  {
    this.varIntsEnabled = paramBoolean;
  }

  public long skip(long paramLong)
    throws KryoException
  {
    int i;
    for (long l = paramLong; l > 0L; l -= i)
    {
      i = (int)Math.min(2147483647L, l);
      skip(i);
    }
    return paramLong;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.ByteBufferInput
 * JD-Core Version:    0.6.2
 */