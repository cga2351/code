package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ByteBufferOutput extends Output
{
  protected static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
  ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
  protected ByteBuffer niobuffer;
  protected boolean varIntsEnabled = true;

  public ByteBufferOutput()
  {
  }

  public ByteBufferOutput(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public ByteBufferOutput(int paramInt1, int paramInt2)
  {
    if (paramInt2 < -1)
      throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt2);
    this.capacity = paramInt1;
    if (paramInt2 == -1)
      paramInt2 = 2147483647;
    this.maxCapacity = paramInt2;
    this.niobuffer = ByteBuffer.allocateDirect(paramInt1);
    this.niobuffer.order(this.byteOrder);
  }

  public ByteBufferOutput(long paramLong, int paramInt)
  {
    this.niobuffer = UnsafeUtil.getDirectBufferAt(paramLong, paramInt);
    setBuffer(this.niobuffer, paramInt);
  }

  public ByteBufferOutput(OutputStream paramOutputStream)
  {
    this(4096, 4096);
    if (paramOutputStream == null)
      throw new IllegalArgumentException("outputStream cannot be null.");
    this.outputStream = paramOutputStream;
  }

  public ByteBufferOutput(OutputStream paramOutputStream, int paramInt)
  {
    this(paramInt, paramInt);
    if (paramOutputStream == null)
      throw new IllegalArgumentException("outputStream cannot be null.");
    this.outputStream = paramOutputStream;
  }

  public ByteBufferOutput(ByteBuffer paramByteBuffer)
  {
    setBuffer(paramByteBuffer);
  }

  public ByteBufferOutput(ByteBuffer paramByteBuffer, int paramInt)
  {
    setBuffer(paramByteBuffer, paramInt);
  }

  private boolean isNativeOrder()
  {
    return this.byteOrder == nativeOrder;
  }

  private void writeAscii_slow(String paramString, int paramInt)
    throws KryoException
  {
    ByteBuffer localByteBuffer1 = this.niobuffer;
    int i = Math.min(paramInt, this.capacity - this.position);
    int j = 0;
    ByteBuffer localByteBuffer2 = localByteBuffer1;
    int k = i;
    while (j < paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      paramString.getBytes(j, j + k, arrayOfByte, 0);
      localByteBuffer2.put(arrayOfByte, 0, k);
      j += k;
      this.position = (k + this.position);
      k = Math.min(paramInt - j, this.capacity);
      if (require(k))
        localByteBuffer2 = this.niobuffer;
    }
  }

  private void writeString_slow(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
    {
      if (this.position == this.capacity)
        require(Math.min(this.capacity, paramInt1 - paramInt2));
      int i = paramCharSequence.charAt(paramInt2);
      if (i <= 127)
      {
        ByteBuffer localByteBuffer6 = this.niobuffer;
        int i2 = this.position;
        this.position = (i2 + 1);
        localByteBuffer6.put(i2, (byte)i);
      }
      while (true)
      {
        paramInt2++;
        break;
        if (i > 2047)
        {
          ByteBuffer localByteBuffer3 = this.niobuffer;
          int m = this.position;
          this.position = (m + 1);
          localByteBuffer3.put(m, (byte)(0xE0 | 0xF & i >> 12));
          require(2);
          ByteBuffer localByteBuffer4 = this.niobuffer;
          int n = this.position;
          this.position = (n + 1);
          localByteBuffer4.put(n, (byte)(0x80 | 0x3F & i >> 6));
          ByteBuffer localByteBuffer5 = this.niobuffer;
          int i1 = this.position;
          this.position = (i1 + 1);
          localByteBuffer5.put(i1, (byte)(0x80 | i & 0x3F));
        }
        else
        {
          ByteBuffer localByteBuffer1 = this.niobuffer;
          int j = this.position;
          this.position = (j + 1);
          localByteBuffer1.put(j, (byte)(0xC0 | 0x1F & i >> 6));
          require(1);
          ByteBuffer localByteBuffer2 = this.niobuffer;
          int k = this.position;
          this.position = (k + 1);
          localByteBuffer2.put(k, (byte)(0x80 | i & 0x3F));
        }
      }
    }
  }

  private void writeUtf8Length(int paramInt)
  {
    if (paramInt >>> 6 == 0)
    {
      require(1);
      this.niobuffer.put((byte)(paramInt | 0x80));
      this.position = (1 + this.position);
      return;
    }
    if (paramInt >>> 13 == 0)
    {
      require(2);
      this.niobuffer.put((byte)(0x80 | (paramInt | 0x40)));
      this.niobuffer.put((byte)(paramInt >>> 6));
      this.position = (2 + this.position);
      return;
    }
    if (paramInt >>> 20 == 0)
    {
      require(3);
      this.niobuffer.put((byte)(0x80 | (paramInt | 0x40)));
      this.niobuffer.put((byte)(0x80 | paramInt >>> 6));
      this.niobuffer.put((byte)(paramInt >>> 13));
      this.position = (3 + this.position);
      return;
    }
    if (paramInt >>> 27 == 0)
    {
      require(4);
      this.niobuffer.put((byte)(0x80 | (paramInt | 0x40)));
      this.niobuffer.put((byte)(0x80 | paramInt >>> 6));
      this.niobuffer.put((byte)(0x80 | paramInt >>> 13));
      this.niobuffer.put((byte)(paramInt >>> 20));
      this.position = (4 + this.position);
      return;
    }
    require(5);
    this.niobuffer.put((byte)(0x80 | (paramInt | 0x40)));
    this.niobuffer.put((byte)(0x80 | paramInt >>> 6));
    this.niobuffer.put((byte)(0x80 | paramInt >>> 13));
    this.niobuffer.put((byte)(0x80 | paramInt >>> 20));
    this.niobuffer.put((byte)(paramInt >>> 27));
    this.position = (5 + this.position);
  }

  public void clear()
  {
    this.niobuffer.clear();
    this.position = 0;
    this.total = 0L;
  }

  public void close()
    throws KryoException
  {
    flush();
    if (this.outputStream != null);
    try
    {
      this.outputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public void flush()
    throws KryoException
  {
    if (this.outputStream == null)
      return;
    try
    {
      byte[] arrayOfByte = new byte[this.position];
      this.niobuffer.position(0);
      this.niobuffer.get(arrayOfByte);
      this.niobuffer.position(0);
      this.outputStream.write(arrayOfByte, 0, this.position);
      this.total += this.position;
      this.position = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }

  public ByteBuffer getByteBuffer()
  {
    this.niobuffer.position(this.position);
    return this.niobuffer;
  }

  public OutputStream getOutputStream()
  {
    return this.outputStream;
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

  public void release()
  {
    clear();
    UnsafeUtil.releaseBuffer(this.niobuffer);
    this.niobuffer = null;
  }

  protected boolean require(int paramInt)
    throws KryoException
  {
    if (this.capacity - this.position >= paramInt)
      return false;
    if (paramInt > this.maxCapacity)
      throw new KryoException("Buffer overflow. Max capacity: " + this.maxCapacity + ", required: " + paramInt);
    flush();
    if (this.capacity - this.position < paramInt)
    {
      if (this.capacity == this.maxCapacity)
        throw new KryoException("Buffer overflow. Available: " + (this.capacity - this.position) + ", required: " + paramInt);
      if (this.capacity == 0)
        this.capacity = 1;
      this.capacity = Math.min(2 * this.capacity, this.maxCapacity);
      if (this.capacity < 0)
        this.capacity = this.maxCapacity;
      if ((this.niobuffer != null) && (!this.niobuffer.isDirect()));
      for (ByteBuffer localByteBuffer = ByteBuffer.allocate(this.capacity); ; localByteBuffer = ByteBuffer.allocateDirect(this.capacity))
      {
        this.niobuffer.position(0);
        localByteBuffer.put(this.niobuffer);
        localByteBuffer.order(this.byteOrder);
        this.niobuffer = localByteBuffer;
        break;
      }
    }
    return true;
  }

  public void setBuffer(ByteBuffer paramByteBuffer)
  {
    setBuffer(paramByteBuffer, paramByteBuffer.capacity());
  }

  public void setBuffer(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("buffer cannot be null.");
    if (paramInt < -1)
      throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt);
    this.niobuffer = paramByteBuffer;
    if (paramInt == -1)
      paramInt = 2147483647;
    this.maxCapacity = paramInt;
    this.byteOrder = paramByteBuffer.order();
    this.capacity = paramByteBuffer.capacity();
    this.position = paramByteBuffer.position();
    this.total = 0L;
    this.outputStream = null;
  }

  public void setOutputStream(OutputStream paramOutputStream)
  {
    this.outputStream = paramOutputStream;
    this.position = 0;
    this.total = 0L;
  }

  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }

  public void setVarIntsEnabled(boolean paramBoolean)
  {
    this.varIntsEnabled = paramBoolean;
  }

  public byte[] toBytes()
  {
    byte[] arrayOfByte = new byte[this.position];
    this.niobuffer.position(this.position);
    this.niobuffer.position(0);
    this.niobuffer.get(arrayOfByte, 0, this.position);
    return arrayOfByte;
  }

  public void write(int paramInt)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    this.niobuffer.put((byte)paramInt);
    this.position = (1 + this.position);
  }

  public void write(byte[] paramArrayOfByte)
    throws KryoException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    writeBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void writeAscii(String paramString)
    throws KryoException
  {
    if (paramString == null)
    {
      writeByte(128);
      return;
    }
    int i = paramString.length();
    if (i == 0)
    {
      writeByte(129);
      return;
    }
    if (this.capacity - this.position < i)
      writeAscii_slow(paramString, i);
    while (true)
    {
      this.niobuffer.put(-1 + this.position, (byte)(0x80 | this.niobuffer.get(-1 + this.position)));
      return;
      byte[] arrayOfByte = paramString.getBytes();
      this.niobuffer.put(arrayOfByte, 0, arrayOfByte.length);
      this.position = (i + this.position);
    }
  }

  public void writeBoolean(boolean paramBoolean)
    throws KryoException
  {
    int i = 1;
    require(i);
    ByteBuffer localByteBuffer = this.niobuffer;
    if (paramBoolean);
    while (true)
    {
      localByteBuffer.put((byte)i);
      this.position = (1 + this.position);
      return;
      i = 0;
    }
  }

  public void writeByte(byte paramByte)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    this.niobuffer.put(paramByte);
    this.position = (1 + this.position);
  }

  public void writeByte(int paramInt)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    this.niobuffer.put((byte)paramInt);
    this.position = (1 + this.position);
  }

  public void writeBytes(byte[] paramArrayOfByte)
    throws KryoException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    writeBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    int i = Math.min(this.capacity - this.position, paramInt2);
    while (true)
    {
      this.niobuffer.put(paramArrayOfByte, paramInt1, i);
      this.position = (i + this.position);
      paramInt2 -= i;
      if (paramInt2 == 0)
        return;
      paramInt1 += i;
      i = Math.min(this.capacity, paramInt2);
      require(i);
    }
  }

  public void writeChar(char paramChar)
    throws KryoException
  {
    require(2);
    this.niobuffer.putChar(paramChar);
    this.position = (2 + this.position);
  }

  public void writeChars(char[] paramArrayOfChar)
    throws KryoException
  {
    if ((this.capacity - this.position >= 2 * paramArrayOfChar.length) && (isNativeOrder()))
    {
      this.niobuffer.asCharBuffer().put(paramArrayOfChar);
      this.position += 2 * paramArrayOfChar.length;
      return;
    }
    super.writeChars(paramArrayOfChar);
  }

  public int writeDouble(double paramDouble1, double paramDouble2, boolean paramBoolean)
    throws KryoException
  {
    return writeLong(()(paramDouble1 * paramDouble2), paramBoolean);
  }

  public void writeDouble(double paramDouble)
    throws KryoException
  {
    require(8);
    this.niobuffer.putDouble(paramDouble);
    this.position = (8 + this.position);
  }

  public void writeDoubles(double[] paramArrayOfDouble)
    throws KryoException
  {
    if ((this.capacity - this.position >= 8 * paramArrayOfDouble.length) && (isNativeOrder()))
    {
      this.niobuffer.asDoubleBuffer().put(paramArrayOfDouble);
      this.position += 8 * paramArrayOfDouble.length;
      return;
    }
    super.writeDoubles(paramArrayOfDouble);
  }

  public int writeFloat(float paramFloat1, float paramFloat2, boolean paramBoolean)
    throws KryoException
  {
    return writeInt((int)(paramFloat1 * paramFloat2), paramBoolean);
  }

  public void writeFloat(float paramFloat)
    throws KryoException
  {
    require(4);
    this.niobuffer.putFloat(paramFloat);
    this.position = (4 + this.position);
  }

  public void writeFloats(float[] paramArrayOfFloat)
    throws KryoException
  {
    if ((this.capacity - this.position >= 4 * paramArrayOfFloat.length) && (isNativeOrder()))
    {
      this.niobuffer.asFloatBuffer().put(paramArrayOfFloat);
      this.position += 4 * paramArrayOfFloat.length;
      return;
    }
    super.writeFloats(paramArrayOfFloat);
  }

  public int writeInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
    {
      writeInt(paramInt);
      return 4;
    }
    return writeVarInt(paramInt, paramBoolean);
  }

  public void writeInt(int paramInt)
    throws KryoException
  {
    require(4);
    this.niobuffer.putInt(paramInt);
    this.position = (4 + this.position);
  }

  public void writeInts(int[] paramArrayOfInt)
    throws KryoException
  {
    if ((this.capacity - this.position >= 4 * paramArrayOfInt.length) && (isNativeOrder()))
    {
      this.niobuffer.asIntBuffer().put(paramArrayOfInt);
      this.position += 4 * paramArrayOfInt.length;
      return;
    }
    super.writeInts(paramArrayOfInt);
  }

  public int writeLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
    {
      writeLong(paramLong);
      return 8;
    }
    return writeVarLong(paramLong, paramBoolean);
  }

  public void writeLong(long paramLong)
    throws KryoException
  {
    require(8);
    this.niobuffer.putLong(paramLong);
    this.position = (8 + this.position);
  }

  public int writeLongS(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramLong = paramLong << 1 ^ paramLong >> 63;
    if (paramLong >>> 7 == 0L)
    {
      require(1);
      this.niobuffer.put((byte)(int)paramLong);
      this.position = (1 + this.position);
      return 1;
    }
    if (paramLong >>> 14 == 0L)
    {
      require(2);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(paramLong >>> 7));
      this.position = (2 + this.position);
      return 2;
    }
    if (paramLong >>> 21 == 0L)
    {
      require(3);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(paramLong >>> 14));
      this.position = (3 + this.position);
      return 3;
    }
    if (paramLong >>> 28 == 0L)
    {
      require(4);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
      this.niobuffer.put((byte)(int)(paramLong >>> 21));
      this.position = (4 + this.position);
      return 4;
    }
    if (paramLong >>> 35 == 0L)
    {
      require(5);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 21));
      this.niobuffer.put((byte)(int)(paramLong >>> 28));
      this.position = (5 + this.position);
      return 5;
    }
    if (paramLong >>> 42 == 0L)
    {
      require(6);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 21));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 28));
      this.niobuffer.put((byte)(int)(paramLong >>> 35));
      this.position = (6 + this.position);
      return 6;
    }
    if (paramLong >>> 49 == 0L)
    {
      require(7);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 21));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 28));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 35));
      this.niobuffer.put((byte)(int)(paramLong >>> 42));
      this.position = (7 + this.position);
      return 7;
    }
    if (paramLong >>> 56 == 0L)
    {
      require(8);
      this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 21));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 28));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 35));
      this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 42));
      this.niobuffer.put((byte)(int)(paramLong >>> 49));
      this.position = (8 + this.position);
      return 8;
    }
    require(9);
    this.niobuffer.put((byte)(int)(0x80 | 0x7F & paramLong));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 7));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 14));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 21));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 28));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 35));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 42));
    this.niobuffer.put((byte)(int)(0x80 | paramLong >>> 49));
    this.niobuffer.put((byte)(int)(paramLong >>> 56));
    this.position = (9 + this.position);
    return 9;
  }

  public void writeLongs(long[] paramArrayOfLong)
    throws KryoException
  {
    if ((this.capacity - this.position >= 8 * paramArrayOfLong.length) && (isNativeOrder()))
    {
      this.niobuffer.asLongBuffer().put(paramArrayOfLong);
      this.position += 8 * paramArrayOfLong.length;
      return;
    }
    super.writeLongs(paramArrayOfLong);
  }

  public void writeShort(int paramInt)
    throws KryoException
  {
    require(2);
    this.niobuffer.putShort((short)paramInt);
    this.position = (2 + this.position);
  }

  public void writeShorts(short[] paramArrayOfShort)
    throws KryoException
  {
    if ((this.capacity - this.position >= 2 * paramArrayOfShort.length) && (isNativeOrder()))
    {
      this.niobuffer.asShortBuffer().put(paramArrayOfShort);
      this.position += 2 * paramArrayOfShort.length;
      return;
    }
    super.writeShorts(paramArrayOfShort);
  }

  public void writeString(CharSequence paramCharSequence)
    throws KryoException
  {
    if (paramCharSequence == null)
    {
      writeByte(128);
      return;
    }
    int i = paramCharSequence.length();
    if (i == 0)
    {
      writeByte(129);
      return;
    }
    writeUtf8Length(i + 1);
    int j = this.capacity - this.position;
    int k = 0;
    if (j >= i);
    int i1;
    for (int m = this.position; ; m = i1)
    {
      int n;
      if (k < i)
      {
        n = paramCharSequence.charAt(k);
        if (n <= 127);
      }
      else
      {
        this.position = m;
        this.niobuffer.position(m);
        if (k < i)
          writeString_slow(paramCharSequence, i, k);
        this.niobuffer.position(this.position);
        return;
      }
      ByteBuffer localByteBuffer = this.niobuffer;
      i1 = m + 1;
      localByteBuffer.put(m, (byte)n);
      k++;
    }
  }

  public void writeString(String paramString)
    throws KryoException
  {
    int i = 1;
    this.niobuffer.position(this.position);
    if (paramString == null)
    {
      writeByte(128);
      return;
    }
    int j = paramString.length();
    if (j == 0)
    {
      writeByte(129);
      return;
    }
    int i3;
    if ((j > i) && (j < 64))
    {
      i3 = 0;
      if (i3 < j)
        if (paramString.charAt(i3) <= '')
          break label139;
    }
    for (i = 0; ; i = 0)
    {
      if (i != 0)
      {
        if (this.capacity - this.position < j)
          writeAscii_slow(paramString, j);
        while (true)
        {
          this.niobuffer.put(-1 + this.position, (byte)(0x80 | this.niobuffer.get(-1 + this.position)));
          return;
          label139: i3++;
          break;
          byte[] arrayOfByte = paramString.getBytes();
          this.niobuffer.put(arrayOfByte, 0, arrayOfByte.length);
          this.position = (j + this.position);
        }
      }
      writeUtf8Length(j + 1);
      int k = this.capacity - this.position;
      int m = 0;
      if (k >= j);
      int i2;
      for (int n = this.position; ; n = i2)
      {
        int i1;
        if (m < j)
        {
          i1 = paramString.charAt(m);
          if (i1 <= 127);
        }
        else
        {
          this.position = n;
          this.niobuffer.position(n);
          if (m < j)
            writeString_slow(paramString, j, m);
          this.niobuffer.position(this.position);
          return;
        }
        ByteBuffer localByteBuffer = this.niobuffer;
        i2 = n + 1;
        localByteBuffer.put(n, (byte)i1);
        m++;
      }
    }
  }

  public int writeVarInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    if (!paramBoolean)
      paramInt = paramInt << 1 ^ paramInt >> 31;
    int i = paramInt & 0x7F;
    int j = paramInt >>> 7;
    if (j == 0)
    {
      writeByte(i);
      return 1;
    }
    int k = i | 0x80 | (j & 0x7F) << 8;
    int m = j >>> 7;
    if (m == 0)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(k);
      this.niobuffer.order(this.byteOrder);
      this.position = (-2 + this.position);
      this.niobuffer.position(this.position);
      return 2;
    }
    int n = k | 0x8000 | (m & 0x7F) << 16;
    int i1 = m >>> 7;
    if (i1 == 0)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(n);
      this.niobuffer.order(this.byteOrder);
      this.position = (-1 + this.position);
      this.niobuffer.position(this.position);
      return 3;
    }
    int i2 = n | 0x800000 | (i1 & 0x7F) << 24;
    int i3 = i1 >>> 7;
    if (i3 == 0)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(i2);
      this.niobuffer.order(this.byteOrder);
      this.position = (0 + this.position);
      return 4;
    }
    long l = 0xFFFFFFFF & (i2 | 0x80000000) | i3 << 32;
    this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
    writeLong(l);
    this.niobuffer.order(this.byteOrder);
    this.position = (-3 + this.position);
    this.niobuffer.position(this.position);
    return 5;
  }

  public int writeVarLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramLong = paramLong << 1 ^ paramLong >> 63;
    int i = (int)(0x7F & paramLong);
    long l1 = paramLong >>> 7;
    if (l1 == 0L)
    {
      writeByte(i);
      return 1;
    }
    int j = (int)(i | 0x80 | (0x7F & l1) << 8);
    long l2 = l1 >>> 7;
    if (l2 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(j);
      this.niobuffer.order(this.byteOrder);
      this.position = (-2 + this.position);
      this.niobuffer.position(this.position);
      return 2;
    }
    int k = (int)(j | 0x8000 | (0x7F & l2) << 16);
    long l3 = l2 >>> 7;
    if (l3 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(k);
      this.niobuffer.order(this.byteOrder);
      this.position = (-1 + this.position);
      this.niobuffer.position(this.position);
      return 3;
    }
    int m = (int)(k | 0x800000 | (0x7F & l3) << 24);
    long l4 = l3 >>> 7;
    if (l4 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeInt(m);
      this.niobuffer.order(this.byteOrder);
      this.position = (0 + this.position);
      return 4;
    }
    long l5 = 0xFFFFFFFF & (m | 0x80000000) | (0x7F & l4) << 32;
    long l6 = l4 >>> 7;
    if (l6 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeLong(l5);
      this.niobuffer.order(this.byteOrder);
      this.position = (-3 + this.position);
      this.niobuffer.position(this.position);
      return 5;
    }
    long l7 = l5 | 0x0 | (0x7F & l6) << 40;
    long l8 = l6 >>> 7;
    if (l8 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeLong(l7);
      this.niobuffer.order(this.byteOrder);
      this.position = (-2 + this.position);
      this.niobuffer.position(this.position);
      return 6;
    }
    long l9 = l7 | 0x0 | (0x7F & l8) << 48;
    long l10 = l8 >>> 7;
    if (l10 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeLong(l9);
      this.niobuffer.order(this.byteOrder);
      this.position = (-1 + this.position);
      this.niobuffer.position(this.position);
      return 7;
    }
    long l11 = l9 | 0x0 | (0x7F & l10) << 56;
    long l12 = l10 >>> 7;
    if (l12 == 0L)
    {
      this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
      writeLong(l11);
      this.niobuffer.order(this.byteOrder);
      return 8;
    }
    long l13 = l11 | 0x0;
    this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
    writeLong(l13);
    this.niobuffer.order(this.byteOrder);
    write((byte)(int)l12);
    return 9;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.ByteBufferOutput
 * JD-Core Version:    0.6.2
 */