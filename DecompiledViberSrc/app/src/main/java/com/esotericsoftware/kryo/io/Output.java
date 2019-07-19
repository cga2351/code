package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.OutputStream;

public class Output extends OutputStream
{
  protected byte[] buffer;
  protected int capacity;
  protected int maxCapacity;
  protected OutputStream outputStream;
  protected int position;
  protected long total;

  public Output()
  {
  }

  public Output(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public Output(int paramInt1, int paramInt2)
  {
    if (paramInt2 < -1)
      throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt2);
    this.capacity = paramInt1;
    if (paramInt2 == -1)
      paramInt2 = 2147483647;
    this.maxCapacity = paramInt2;
    this.buffer = new byte[paramInt1];
  }

  public Output(OutputStream paramOutputStream)
  {
    this(4096, 4096);
    if (paramOutputStream == null)
      throw new IllegalArgumentException("outputStream cannot be null.");
    this.outputStream = paramOutputStream;
  }

  public Output(OutputStream paramOutputStream, int paramInt)
  {
    this(paramInt, paramInt);
    if (paramOutputStream == null)
      throw new IllegalArgumentException("outputStream cannot be null.");
    this.outputStream = paramOutputStream;
  }

  public Output(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }

  public Output(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("buffer cannot be null.");
    setBuffer(paramArrayOfByte, paramInt);
  }

  public static int intLength(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
      paramInt = paramInt << 1 ^ paramInt >> 31;
    if (paramInt >>> 7 == 0)
      return 1;
    if (paramInt >>> 14 == 0)
      return 2;
    if (paramInt >>> 21 == 0)
      return 3;
    if (paramInt >>> 28 == 0)
      return 4;
    return 5;
  }

  public static int longLength(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean)
      paramLong = paramLong << 1 ^ paramLong >> 63;
    if (paramLong >>> 7 == 0L)
      return 1;
    if (paramLong >>> 14 == 0L)
      return 2;
    if (paramLong >>> 21 == 0L)
      return 3;
    if (paramLong >>> 28 == 0L)
      return 4;
    if (paramLong >>> 35 == 0L)
      return 5;
    if (paramLong >>> 42 == 0L)
      return 6;
    if (paramLong >>> 49 == 0L)
      return 7;
    if (paramLong >>> 56 == 0L)
      return 8;
    return 9;
  }

  private void writeAscii_slow(String paramString, int paramInt)
    throws KryoException
  {
    byte[] arrayOfByte = this.buffer;
    int i = 0;
    int j = Math.min(paramInt, this.capacity - this.position);
    while (i < paramInt)
    {
      paramString.getBytes(i, i + j, arrayOfByte, this.position);
      i += j;
      this.position = (j + this.position);
      j = Math.min(paramInt - i, this.capacity);
      if (require(j))
        arrayOfByte = this.buffer;
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
        byte[] arrayOfByte6 = this.buffer;
        int i2 = this.position;
        this.position = (i2 + 1);
        arrayOfByte6[i2] = ((byte)i);
      }
      while (true)
      {
        paramInt2++;
        break;
        if (i > 2047)
        {
          byte[] arrayOfByte3 = this.buffer;
          int m = this.position;
          this.position = (m + 1);
          arrayOfByte3[m] = ((byte)(0xE0 | 0xF & i >> 12));
          require(2);
          byte[] arrayOfByte4 = this.buffer;
          int n = this.position;
          this.position = (n + 1);
          arrayOfByte4[n] = ((byte)(0x80 | 0x3F & i >> 6));
          byte[] arrayOfByte5 = this.buffer;
          int i1 = this.position;
          this.position = (i1 + 1);
          arrayOfByte5[i1] = ((byte)(0x80 | i & 0x3F));
        }
        else
        {
          byte[] arrayOfByte1 = this.buffer;
          int j = this.position;
          this.position = (j + 1);
          arrayOfByte1[j] = ((byte)(0xC0 | 0x1F & i >> 6));
          require(1);
          byte[] arrayOfByte2 = this.buffer;
          int k = this.position;
          this.position = (k + 1);
          arrayOfByte2[k] = ((byte)(0x80 | i & 0x3F));
        }
      }
    }
  }

  private void writeUtf8Length(int paramInt)
  {
    if (paramInt >>> 6 == 0)
    {
      require(1);
      byte[] arrayOfByte5 = this.buffer;
      int i10 = this.position;
      this.position = (i10 + 1);
      arrayOfByte5[i10] = ((byte)(paramInt | 0x80));
      return;
    }
    if (paramInt >>> 13 == 0)
    {
      require(2);
      byte[] arrayOfByte4 = this.buffer;
      int i8 = this.position;
      this.position = (i8 + 1);
      arrayOfByte4[i8] = ((byte)(0x80 | (paramInt | 0x40)));
      int i9 = this.position;
      this.position = (i9 + 1);
      arrayOfByte4[i9] = ((byte)(paramInt >>> 6));
      return;
    }
    if (paramInt >>> 20 == 0)
    {
      require(3);
      byte[] arrayOfByte3 = this.buffer;
      int i5 = this.position;
      this.position = (i5 + 1);
      arrayOfByte3[i5] = ((byte)(0x80 | (paramInt | 0x40)));
      int i6 = this.position;
      this.position = (i6 + 1);
      arrayOfByte3[i6] = ((byte)(0x80 | paramInt >>> 6));
      int i7 = this.position;
      this.position = (i7 + 1);
      arrayOfByte3[i7] = ((byte)(paramInt >>> 13));
      return;
    }
    if (paramInt >>> 27 == 0)
    {
      require(4);
      byte[] arrayOfByte2 = this.buffer;
      int i1 = this.position;
      this.position = (i1 + 1);
      arrayOfByte2[i1] = ((byte)(0x80 | (paramInt | 0x40)));
      int i2 = this.position;
      this.position = (i2 + 1);
      arrayOfByte2[i2] = ((byte)(0x80 | paramInt >>> 6));
      int i3 = this.position;
      this.position = (i3 + 1);
      arrayOfByte2[i3] = ((byte)(0x80 | paramInt >>> 13));
      int i4 = this.position;
      this.position = (i4 + 1);
      arrayOfByte2[i4] = ((byte)(paramInt >>> 20));
      return;
    }
    require(5);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte1[i] = ((byte)(0x80 | (paramInt | 0x40)));
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte1[j] = ((byte)(0x80 | paramInt >>> 6));
    int k = this.position;
    this.position = (k + 1);
    arrayOfByte1[k] = ((byte)(0x80 | paramInt >>> 13));
    int m = this.position;
    this.position = (m + 1);
    arrayOfByte1[m] = ((byte)(0x80 | paramInt >>> 20));
    int n = this.position;
    this.position = (n + 1);
    arrayOfByte1[n] = ((byte)(paramInt >>> 27));
  }

  public void clear()
  {
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
      this.outputStream.write(this.buffer, 0, this.position);
      this.total += this.position;
      this.position = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new KryoException(localIOException);
    }
  }

  public byte[] getBuffer()
  {
    return this.buffer;
  }

  public OutputStream getOutputStream()
  {
    return this.outputStream;
  }

  public final int position()
  {
    return this.position;
  }

  protected boolean require(int paramInt)
    throws KryoException
  {
    if (this.capacity - this.position >= paramInt)
      return false;
    if (paramInt > this.maxCapacity)
      throw new KryoException("Buffer overflow. Max capacity: " + this.maxCapacity + ", required: " + paramInt);
    flush();
    while (this.capacity - this.position < paramInt)
    {
      if (this.capacity == this.maxCapacity)
        throw new KryoException("Buffer overflow. Available: " + (this.capacity - this.position) + ", required: " + paramInt);
      if (this.capacity == 0)
        this.capacity = 1;
      this.capacity = Math.min(2 * this.capacity, this.maxCapacity);
      if (this.capacity < 0)
        this.capacity = this.maxCapacity;
      byte[] arrayOfByte = new byte[this.capacity];
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.position);
      this.buffer = arrayOfByte;
    }
    return true;
  }

  public void setBuffer(byte[] paramArrayOfByte)
  {
    setBuffer(paramArrayOfByte, paramArrayOfByte.length);
  }

  public void setBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("buffer cannot be null.");
    if (paramInt < -1)
      throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt);
    this.buffer = paramArrayOfByte;
    if (paramInt == -1)
      paramInt = 2147483647;
    this.maxCapacity = paramInt;
    this.capacity = paramArrayOfByte.length;
    this.position = 0;
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

  public byte[] toBytes()
  {
    byte[] arrayOfByte = new byte[this.position];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.position);
    return arrayOfByte;
  }

  public final long total()
  {
    return this.total + this.position;
  }

  public void write(int paramInt)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
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
    switch (i)
    {
    default:
      if (this.capacity - this.position < i)
        writeAscii_slow(paramString, i);
      break;
    case 0:
    case 1:
    }
    while (true)
    {
      byte[] arrayOfByte = this.buffer;
      int j = -1 + this.position;
      arrayOfByte[j] = ((byte)(0x80 | arrayOfByte[j]));
      return;
      writeByte(129);
      return;
      writeByte(130);
      writeByte(paramString.charAt(0));
      return;
      paramString.getBytes(0, i, this.buffer, this.position);
      this.position = (i + this.position);
    }
  }

  public void writeBoolean(boolean paramBoolean)
    throws KryoException
  {
    int i = 1;
    if (this.position == this.capacity)
      require(i);
    byte[] arrayOfByte = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    if (paramBoolean);
    while (true)
    {
      arrayOfByte[j] = ((byte)i);
      return;
      i = 0;
    }
  }

  public void writeByte(byte paramByte)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void writeByte(int paramInt)
    throws KryoException
  {
    if (this.position == this.capacity)
      require(1);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
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
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
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
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte1[i] = ((byte)(paramChar >>> '\b'));
    byte[] arrayOfByte2 = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte2[j] = ((byte)paramChar);
  }

  public void writeChars(char[] paramArrayOfChar)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      writeChar(paramArrayOfChar[i]);
      i++;
    }
  }

  public int writeDouble(double paramDouble1, double paramDouble2, boolean paramBoolean)
    throws KryoException
  {
    return writeLong(()(paramDouble1 * paramDouble2), paramBoolean);
  }

  public void writeDouble(double paramDouble)
    throws KryoException
  {
    writeLong(Double.doubleToLongBits(paramDouble));
  }

  public void writeDoubles(double[] paramArrayOfDouble)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfDouble.length;
    while (i < j)
    {
      writeDouble(paramArrayOfDouble[i]);
      i++;
    }
  }

  public int writeFloat(float paramFloat1, float paramFloat2, boolean paramBoolean)
    throws KryoException
  {
    return writeInt((int)(paramFloat1 * paramFloat2), paramBoolean);
  }

  public void writeFloat(float paramFloat)
    throws KryoException
  {
    writeInt(Float.floatToIntBits(paramFloat));
  }

  public void writeFloats(float[] paramArrayOfFloat)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      writeFloat(paramArrayOfFloat[i]);
      i++;
    }
  }

  public int writeInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    return writeVarInt(paramInt, paramBoolean);
  }

  public void writeInt(int paramInt)
    throws KryoException
  {
    require(4);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 24));
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte[j] = ((byte)(paramInt >> 16));
    int k = this.position;
    this.position = (k + 1);
    arrayOfByte[k] = ((byte)(paramInt >> 8));
    int m = this.position;
    this.position = (m + 1);
    arrayOfByte[m] = ((byte)paramInt);
  }

  public void writeInts(int[] paramArrayOfInt)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      writeInt(paramArrayOfInt[i]);
      i++;
    }
  }

  public void writeInts(int[] paramArrayOfInt, boolean paramBoolean)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      writeInt(paramArrayOfInt[i], paramBoolean);
      i++;
    }
  }

  public int writeLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    return writeVarLong(paramLong, paramBoolean);
  }

  public void writeLong(long paramLong)
    throws KryoException
  {
    require(8);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 56));
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 48));
    int k = this.position;
    this.position = (k + 1);
    arrayOfByte[k] = ((byte)(int)(paramLong >>> 40));
    int m = this.position;
    this.position = (m + 1);
    arrayOfByte[m] = ((byte)(int)(paramLong >>> 32));
    int n = this.position;
    this.position = (n + 1);
    arrayOfByte[n] = ((byte)(int)(paramLong >>> 24));
    int i1 = this.position;
    this.position = (i1 + 1);
    arrayOfByte[i1] = ((byte)(int)(paramLong >>> 16));
    int i2 = this.position;
    this.position = (i2 + 1);
    arrayOfByte[i2] = ((byte)(int)(paramLong >>> 8));
    int i3 = this.position;
    this.position = (i3 + 1);
    arrayOfByte[i3] = ((byte)(int)paramLong);
  }

  public void writeLongs(long[] paramArrayOfLong)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      writeLong(paramArrayOfLong[i]);
      i++;
    }
  }

  public void writeLongs(long[] paramArrayOfLong, boolean paramBoolean)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      writeLong(paramArrayOfLong[i], paramBoolean);
      i++;
    }
  }

  public void writeShort(int paramInt)
    throws KryoException
  {
    require(2);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte1[i] = ((byte)(paramInt >>> 8));
    byte[] arrayOfByte2 = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte2[j] = ((byte)paramInt);
  }

  public void writeShorts(short[] paramArrayOfShort)
    throws KryoException
  {
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      writeShort(paramArrayOfShort[i]);
      i++;
    }
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
    byte[] arrayOfByte;
    if (j >= i)
      arrayOfByte = this.buffer;
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
        if (k >= i)
          break;
        writeString_slow(paramCharSequence, i, k);
        return;
      }
      i1 = m + 1;
      arrayOfByte[m] = ((byte)n);
      k++;
    }
  }

  public void writeString(String paramString)
    throws KryoException
  {
    int i = 1;
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
    int i4;
    if ((j > i) && (j < 64))
    {
      i4 = 0;
      if (i4 < j)
        if (paramString.charAt(i4) <= '')
          break label117;
    }
    for (i = 0; ; i = 0)
    {
      if (i != 0)
      {
        if (this.capacity - this.position < j)
          writeAscii_slow(paramString, j);
        while (true)
        {
          byte[] arrayOfByte2 = this.buffer;
          int i3 = -1 + this.position;
          arrayOfByte2[i3] = ((byte)(0x80 | arrayOfByte2[i3]));
          return;
          label117: i4++;
          break;
          paramString.getBytes(0, j, this.buffer, this.position);
          this.position = (j + this.position);
        }
      }
      writeUtf8Length(j + 1);
      int k = this.capacity - this.position;
      int m = 0;
      byte[] arrayOfByte1;
      if (k >= j)
        arrayOfByte1 = this.buffer;
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
          if (m >= j)
            break;
          writeString_slow(paramString, j, m);
          return;
        }
        i2 = n + 1;
        arrayOfByte1[n] = ((byte)i1);
        m++;
      }
    }
  }

  public int writeVarInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramInt = paramInt << 1 ^ paramInt >> 31;
    if (paramInt >>> 7 == 0)
    {
      require(1);
      byte[] arrayOfByte15 = this.buffer;
      int i10 = this.position;
      this.position = (i10 + 1);
      arrayOfByte15[i10] = ((byte)paramInt);
      return 1;
    }
    if (paramInt >>> 14 == 0)
    {
      require(2);
      byte[] arrayOfByte13 = this.buffer;
      int i8 = this.position;
      this.position = (i8 + 1);
      arrayOfByte13[i8] = ((byte)(0x80 | paramInt & 0x7F));
      byte[] arrayOfByte14 = this.buffer;
      int i9 = this.position;
      this.position = (i9 + 1);
      arrayOfByte14[i9] = ((byte)(paramInt >>> 7));
      return 2;
    }
    if (paramInt >>> 21 == 0)
    {
      require(3);
      byte[] arrayOfByte10 = this.buffer;
      int i5 = this.position;
      this.position = (i5 + 1);
      arrayOfByte10[i5] = ((byte)(0x80 | paramInt & 0x7F));
      byte[] arrayOfByte11 = this.buffer;
      int i6 = this.position;
      this.position = (i6 + 1);
      arrayOfByte11[i6] = ((byte)(0x80 | paramInt >>> 7));
      byte[] arrayOfByte12 = this.buffer;
      int i7 = this.position;
      this.position = (i7 + 1);
      arrayOfByte12[i7] = ((byte)(paramInt >>> 14));
      return 3;
    }
    if (paramInt >>> 28 == 0)
    {
      require(4);
      byte[] arrayOfByte6 = this.buffer;
      int i1 = this.position;
      this.position = (i1 + 1);
      arrayOfByte6[i1] = ((byte)(0x80 | paramInt & 0x7F));
      byte[] arrayOfByte7 = this.buffer;
      int i2 = this.position;
      this.position = (i2 + 1);
      arrayOfByte7[i2] = ((byte)(0x80 | paramInt >>> 7));
      byte[] arrayOfByte8 = this.buffer;
      int i3 = this.position;
      this.position = (i3 + 1);
      arrayOfByte8[i3] = ((byte)(0x80 | paramInt >>> 14));
      byte[] arrayOfByte9 = this.buffer;
      int i4 = this.position;
      this.position = (i4 + 1);
      arrayOfByte9[i4] = ((byte)(paramInt >>> 21));
      return 4;
    }
    require(5);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte1[i] = ((byte)(0x80 | paramInt & 0x7F));
    byte[] arrayOfByte2 = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte2[j] = ((byte)(0x80 | paramInt >>> 7));
    byte[] arrayOfByte3 = this.buffer;
    int k = this.position;
    this.position = (k + 1);
    arrayOfByte3[k] = ((byte)(0x80 | paramInt >>> 14));
    byte[] arrayOfByte4 = this.buffer;
    int m = this.position;
    this.position = (m + 1);
    arrayOfByte4[m] = ((byte)(0x80 | paramInt >>> 21));
    byte[] arrayOfByte5 = this.buffer;
    int n = this.position;
    this.position = (n + 1);
    arrayOfByte5[n] = ((byte)(paramInt >>> 28));
    return 5;
  }

  public int writeVarLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramLong = paramLong << 1 ^ paramLong >> 63;
    if (paramLong >>> 7 == 0L)
    {
      require(1);
      byte[] arrayOfByte45 = this.buffer;
      int i40 = this.position;
      this.position = (i40 + 1);
      arrayOfByte45[i40] = ((byte)(int)paramLong);
      return 1;
    }
    if (paramLong >>> 14 == 0L)
    {
      require(2);
      byte[] arrayOfByte43 = this.buffer;
      int i38 = this.position;
      this.position = (i38 + 1);
      arrayOfByte43[i38] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte44 = this.buffer;
      int i39 = this.position;
      this.position = (i39 + 1);
      arrayOfByte44[i39] = ((byte)(int)(paramLong >>> 7));
      return 2;
    }
    if (paramLong >>> 21 == 0L)
    {
      require(3);
      byte[] arrayOfByte40 = this.buffer;
      int i35 = this.position;
      this.position = (i35 + 1);
      arrayOfByte40[i35] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte41 = this.buffer;
      int i36 = this.position;
      this.position = (i36 + 1);
      arrayOfByte41[i36] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte42 = this.buffer;
      int i37 = this.position;
      this.position = (i37 + 1);
      arrayOfByte42[i37] = ((byte)(int)(paramLong >>> 14));
      return 3;
    }
    if (paramLong >>> 28 == 0L)
    {
      require(4);
      byte[] arrayOfByte36 = this.buffer;
      int i31 = this.position;
      this.position = (i31 + 1);
      arrayOfByte36[i31] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte37 = this.buffer;
      int i32 = this.position;
      this.position = (i32 + 1);
      arrayOfByte37[i32] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte38 = this.buffer;
      int i33 = this.position;
      this.position = (i33 + 1);
      arrayOfByte38[i33] = ((byte)(int)(0x80 | paramLong >>> 14));
      byte[] arrayOfByte39 = this.buffer;
      int i34 = this.position;
      this.position = (i34 + 1);
      arrayOfByte39[i34] = ((byte)(int)(paramLong >>> 21));
      return 4;
    }
    if (paramLong >>> 35 == 0L)
    {
      require(5);
      byte[] arrayOfByte31 = this.buffer;
      int i26 = this.position;
      this.position = (i26 + 1);
      arrayOfByte31[i26] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte32 = this.buffer;
      int i27 = this.position;
      this.position = (i27 + 1);
      arrayOfByte32[i27] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte33 = this.buffer;
      int i28 = this.position;
      this.position = (i28 + 1);
      arrayOfByte33[i28] = ((byte)(int)(0x80 | paramLong >>> 14));
      byte[] arrayOfByte34 = this.buffer;
      int i29 = this.position;
      this.position = (i29 + 1);
      arrayOfByte34[i29] = ((byte)(int)(0x80 | paramLong >>> 21));
      byte[] arrayOfByte35 = this.buffer;
      int i30 = this.position;
      this.position = (i30 + 1);
      arrayOfByte35[i30] = ((byte)(int)(paramLong >>> 28));
      return 5;
    }
    if (paramLong >>> 42 == 0L)
    {
      require(6);
      byte[] arrayOfByte25 = this.buffer;
      int i20 = this.position;
      this.position = (i20 + 1);
      arrayOfByte25[i20] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte26 = this.buffer;
      int i21 = this.position;
      this.position = (i21 + 1);
      arrayOfByte26[i21] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte27 = this.buffer;
      int i22 = this.position;
      this.position = (i22 + 1);
      arrayOfByte27[i22] = ((byte)(int)(0x80 | paramLong >>> 14));
      byte[] arrayOfByte28 = this.buffer;
      int i23 = this.position;
      this.position = (i23 + 1);
      arrayOfByte28[i23] = ((byte)(int)(0x80 | paramLong >>> 21));
      byte[] arrayOfByte29 = this.buffer;
      int i24 = this.position;
      this.position = (i24 + 1);
      arrayOfByte29[i24] = ((byte)(int)(0x80 | paramLong >>> 28));
      byte[] arrayOfByte30 = this.buffer;
      int i25 = this.position;
      this.position = (i25 + 1);
      arrayOfByte30[i25] = ((byte)(int)(paramLong >>> 35));
      return 6;
    }
    if (paramLong >>> 49 == 0L)
    {
      require(7);
      byte[] arrayOfByte18 = this.buffer;
      int i13 = this.position;
      this.position = (i13 + 1);
      arrayOfByte18[i13] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte19 = this.buffer;
      int i14 = this.position;
      this.position = (i14 + 1);
      arrayOfByte19[i14] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte20 = this.buffer;
      int i15 = this.position;
      this.position = (i15 + 1);
      arrayOfByte20[i15] = ((byte)(int)(0x80 | paramLong >>> 14));
      byte[] arrayOfByte21 = this.buffer;
      int i16 = this.position;
      this.position = (i16 + 1);
      arrayOfByte21[i16] = ((byte)(int)(0x80 | paramLong >>> 21));
      byte[] arrayOfByte22 = this.buffer;
      int i17 = this.position;
      this.position = (i17 + 1);
      arrayOfByte22[i17] = ((byte)(int)(0x80 | paramLong >>> 28));
      byte[] arrayOfByte23 = this.buffer;
      int i18 = this.position;
      this.position = (i18 + 1);
      arrayOfByte23[i18] = ((byte)(int)(0x80 | paramLong >>> 35));
      byte[] arrayOfByte24 = this.buffer;
      int i19 = this.position;
      this.position = (i19 + 1);
      arrayOfByte24[i19] = ((byte)(int)(paramLong >>> 42));
      return 7;
    }
    if (paramLong >>> 56 == 0L)
    {
      require(8);
      byte[] arrayOfByte10 = this.buffer;
      int i5 = this.position;
      this.position = (i5 + 1);
      arrayOfByte10[i5] = ((byte)(int)(0x80 | 0x7F & paramLong));
      byte[] arrayOfByte11 = this.buffer;
      int i6 = this.position;
      this.position = (i6 + 1);
      arrayOfByte11[i6] = ((byte)(int)(0x80 | paramLong >>> 7));
      byte[] arrayOfByte12 = this.buffer;
      int i7 = this.position;
      this.position = (i7 + 1);
      arrayOfByte12[i7] = ((byte)(int)(0x80 | paramLong >>> 14));
      byte[] arrayOfByte13 = this.buffer;
      int i8 = this.position;
      this.position = (i8 + 1);
      arrayOfByte13[i8] = ((byte)(int)(0x80 | paramLong >>> 21));
      byte[] arrayOfByte14 = this.buffer;
      int i9 = this.position;
      this.position = (i9 + 1);
      arrayOfByte14[i9] = ((byte)(int)(0x80 | paramLong >>> 28));
      byte[] arrayOfByte15 = this.buffer;
      int i10 = this.position;
      this.position = (i10 + 1);
      arrayOfByte15[i10] = ((byte)(int)(0x80 | paramLong >>> 35));
      byte[] arrayOfByte16 = this.buffer;
      int i11 = this.position;
      this.position = (i11 + 1);
      arrayOfByte16[i11] = ((byte)(int)(0x80 | paramLong >>> 42));
      byte[] arrayOfByte17 = this.buffer;
      int i12 = this.position;
      this.position = (i12 + 1);
      arrayOfByte17[i12] = ((byte)(int)(paramLong >>> 49));
      return 8;
    }
    require(9);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte1[i] = ((byte)(int)(0x80 | 0x7F & paramLong));
    byte[] arrayOfByte2 = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    arrayOfByte2[j] = ((byte)(int)(0x80 | paramLong >>> 7));
    byte[] arrayOfByte3 = this.buffer;
    int k = this.position;
    this.position = (k + 1);
    arrayOfByte3[k] = ((byte)(int)(0x80 | paramLong >>> 14));
    byte[] arrayOfByte4 = this.buffer;
    int m = this.position;
    this.position = (m + 1);
    arrayOfByte4[m] = ((byte)(int)(0x80 | paramLong >>> 21));
    byte[] arrayOfByte5 = this.buffer;
    int n = this.position;
    this.position = (n + 1);
    arrayOfByte5[n] = ((byte)(int)(0x80 | paramLong >>> 28));
    byte[] arrayOfByte6 = this.buffer;
    int i1 = this.position;
    this.position = (i1 + 1);
    arrayOfByte6[i1] = ((byte)(int)(0x80 | paramLong >>> 35));
    byte[] arrayOfByte7 = this.buffer;
    int i2 = this.position;
    this.position = (i2 + 1);
    arrayOfByte7[i2] = ((byte)(int)(0x80 | paramLong >>> 42));
    byte[] arrayOfByte8 = this.buffer;
    int i3 = this.position;
    this.position = (i3 + 1);
    arrayOfByte8[i3] = ((byte)(int)(0x80 | paramLong >>> 49));
    byte[] arrayOfByte9 = this.buffer;
    int i4 = this.position;
    this.position = (i4 + 1);
    arrayOfByte9[i4] = ((byte)(int)(paramLong >>> 56));
    return 9;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.Output
 * JD-Core Version:    0.6.2
 */