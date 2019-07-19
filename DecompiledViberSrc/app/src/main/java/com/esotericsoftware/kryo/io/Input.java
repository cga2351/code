package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.InputStream;

public class Input extends InputStream
{
  protected byte[] buffer;
  protected int capacity;
  protected char[] chars = new char[32];
  protected InputStream inputStream;
  protected int limit;
  protected int position;
  protected long total;

  public Input()
  {
  }

  public Input(int paramInt)
  {
    this.capacity = paramInt;
    this.buffer = new byte[paramInt];
  }

  public Input(InputStream paramInputStream)
  {
    this(4096);
    if (paramInputStream == null)
      throw new IllegalArgumentException("inputStream cannot be null.");
    this.inputStream = paramInputStream;
  }

  public Input(InputStream paramInputStream, int paramInt)
  {
    this(paramInt);
    if (paramInputStream == null)
      throw new IllegalArgumentException("inputStream cannot be null.");
    this.inputStream = paramInputStream;
  }

  public Input(byte[] paramArrayOfByte)
  {
    setBuffer(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public Input(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    setBuffer(paramArrayOfByte, paramInt1, paramInt2);
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
      m = fill(this.buffer, this.limit, this.capacity - this.limit);
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
    System.arraycopy(this.buffer, this.position, this.buffer, 0, n);
    this.total += this.position;
    this.position = 0;
    label135: int i1 = fill(this.buffer, n, this.capacity - n);
    if (i1 == i);
    while (true)
    {
      this.limit = n;
      if (n == 0)
        break;
      return Math.min(n, k);
      n += i1;
      if (n < k)
        break label135;
    }
  }

  private String readAscii()
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    int j = i - 1;
    int k = this.limit;
    while (true)
    {
      if (i == k)
        return readAscii_slow();
      int m = i + 1;
      if ((0x80 & arrayOfByte[i]) != 0)
      {
        int n = m - 1;
        arrayOfByte[n] = ((byte)(0x7F & arrayOfByte[n]));
        String str = new String(arrayOfByte, 0, j, m - j);
        int i1 = m - 1;
        arrayOfByte[i1] = ((byte)(0x80 | arrayOfByte[i1]));
        this.position = m;
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
    byte[] arrayOfByte = this.buffer;
    int j = this.position;
    int k = this.limit;
    int m = j;
    for (int n = 0; m < k; n++)
    {
      localObject[n] = ((char)arrayOfByte[m]);
      m++;
    }
    this.position = this.limit;
    while (true)
    {
      require(1);
      int i1 = this.position;
      this.position = (i1 + 1);
      int i2 = arrayOfByte[i1];
      if (i == localObject.length)
      {
        char[] arrayOfChar = new char[i * 2];
        System.arraycopy(localObject, 0, arrayOfChar, 0, i);
        this.chars = arrayOfChar;
        localObject = arrayOfChar;
      }
      if ((i2 & 0x80) == 128)
      {
        int i4 = i + 1;
        localObject[i] = ((char)(i2 & 0x7F));
        return new String((char[])localObject, 0, i4);
      }
      int i3 = i + 1;
      localObject[i] = ((char)i2);
      i = i3;
    }
  }

  private int readInt_slow(boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    int j = arrayOfByte1[i];
    int k = j & 0x7F;
    if ((j & 0x80) != 0)
    {
      require(1);
      byte[] arrayOfByte2 = this.buffer;
      int m = this.position;
      this.position = (m + 1);
      int n = arrayOfByte2[m];
      k |= (n & 0x7F) << 7;
      if ((n & 0x80) != 0)
      {
        require(1);
        int i1 = this.position;
        this.position = (i1 + 1);
        int i2 = arrayOfByte2[i1];
        k |= (i2 & 0x7F) << 14;
        if ((i2 & 0x80) != 0)
        {
          require(1);
          int i3 = this.position;
          this.position = (i3 + 1);
          int i4 = arrayOfByte2[i3];
          k |= (i4 & 0x7F) << 21;
          if ((i4 & 0x80) != 0)
          {
            require(1);
            int i5 = this.position;
            this.position = (i5 + 1);
            k |= (0x7F & arrayOfByte2[i5]) << 28;
          }
        }
      }
    }
    if (paramBoolean)
      return k;
    return k >>> 1 ^ -(k & 0x1);
  }

  private long readLong_slow(boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    int j = arrayOfByte1[i];
    long l = j & 0x7F;
    if ((j & 0x80) != 0)
    {
      require(1);
      byte[] arrayOfByte2 = this.buffer;
      int k = this.position;
      this.position = (k + 1);
      int m = arrayOfByte2[k];
      l |= (m & 0x7F) << 7;
      if ((m & 0x80) != 0)
      {
        require(1);
        int n = this.position;
        this.position = (n + 1);
        int i1 = arrayOfByte2[n];
        l |= (i1 & 0x7F) << 14;
        if ((i1 & 0x80) != 0)
        {
          require(1);
          int i2 = this.position;
          this.position = (i2 + 1);
          int i3 = arrayOfByte2[i2];
          l |= (i3 & 0x7F) << 21;
          if ((i3 & 0x80) != 0)
          {
            require(1);
            int i4 = this.position;
            this.position = (i4 + 1);
            int i5 = arrayOfByte2[i4];
            l |= (i5 & 0x7F) << 28;
            if ((i5 & 0x80) != 0)
            {
              require(1);
              int i6 = this.position;
              this.position = (i6 + 1);
              int i7 = arrayOfByte2[i6];
              l |= (i7 & 0x7F) << 35;
              if ((i7 & 0x80) != 0)
              {
                require(1);
                int i8 = this.position;
                this.position = (i8 + 1);
                int i9 = arrayOfByte2[i8];
                l |= (i9 & 0x7F) << 42;
                if ((i9 & 0x80) != 0)
                {
                  require(1);
                  int i10 = this.position;
                  this.position = (i10 + 1);
                  int i11 = arrayOfByte2[i10];
                  l |= (i11 & 0x7F) << 49;
                  if ((i11 & 0x80) != 0)
                  {
                    require(1);
                    int i12 = this.position;
                    this.position = (i12 + 1);
                    l |= arrayOfByte2[i12] << 56;
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
    byte[] arrayOfByte = this.buffer;
    char[] arrayOfChar = this.chars;
    int i = Math.min(require(1), paramInt);
    int j = this.position;
    int k = 0;
    while (true)
    {
      int m;
      int n;
      if (k < i)
      {
        m = j + 1;
        n = arrayOfByte[j];
        if (n < 0)
          j = m - 1;
      }
      else
      {
        this.position = j;
        if (k < paramInt)
          readUtf8_slow(paramInt, k);
        return;
      }
      int i1 = k + 1;
      arrayOfChar[k] = ((char)n);
      k = i1;
      j = m;
    }
  }

  private int readUtf8Length(int paramInt)
  {
    int i = paramInt & 0x3F;
    if ((paramInt & 0x40) != 0)
    {
      byte[] arrayOfByte = this.buffer;
      int j = this.position;
      this.position = (j + 1);
      int k = arrayOfByte[j];
      i |= (k & 0x7F) << 6;
      if ((k & 0x80) != 0)
      {
        int m = this.position;
        this.position = (m + 1);
        int n = arrayOfByte[m];
        i |= (n & 0x7F) << 13;
        if ((n & 0x80) != 0)
        {
          int i1 = this.position;
          this.position = (i1 + 1);
          int i2 = arrayOfByte[i1];
          i |= (i2 & 0x7F) << 20;
          if ((i2 & 0x80) != 0)
          {
            int i3 = this.position;
            this.position = (i3 + 1);
            i |= (0x7F & arrayOfByte[i3]) << 27;
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
      byte[] arrayOfByte = this.buffer;
      int j = this.position;
      this.position = (j + 1);
      int k = arrayOfByte[j];
      i |= (k & 0x7F) << 6;
      if ((k & 0x80) != 0)
      {
        require(1);
        int m = this.position;
        this.position = (m + 1);
        int n = arrayOfByte[m];
        i |= (n & 0x7F) << 13;
        if ((n & 0x80) != 0)
        {
          require(1);
          int i1 = this.position;
          this.position = (i1 + 1);
          int i2 = arrayOfByte[i1];
          i |= (i2 & 0x7F) << 20;
          if ((i2 & 0x80) != 0)
          {
            require(1);
            int i3 = this.position;
            this.position = (i3 + 1);
            i |= (0x7F & arrayOfByte[i3]) << 27;
          }
        }
      }
    }
    return i;
  }

  private void readUtf8_slow(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.chars;
    byte[] arrayOfByte = this.buffer;
    if (paramInt2 < paramInt1)
    {
      if (this.position == this.limit)
        require(1);
      int i = this.position;
      this.position = (i + 1);
      int j = 0xFF & arrayOfByte[i];
      switch (j >> 4)
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
        arrayOfChar[paramInt2] = ((char)j);
        continue;
        if (this.position == this.limit)
          require(1);
        int i2 = (j & 0x1F) << 6;
        int i3 = this.position;
        this.position = (i3 + 1);
        arrayOfChar[paramInt2] = ((char)(i2 | 0x3F & arrayOfByte[i3]));
        continue;
        require(2);
        int k = (j & 0xF) << 12;
        int m = this.position;
        this.position = (m + 1);
        int n = k | (0x3F & arrayOfByte[m]) << 6;
        int i1 = this.position;
        this.position = (i1 + 1);
        arrayOfChar[paramInt2] = ((char)(n | 0x3F & arrayOfByte[i1]));
      }
    }
  }

  public int available()
    throws IOException
  {
    int i = this.limit - this.position;
    if (this.inputStream != null);
    for (int j = this.inputStream.available(); ; j = 0)
      return j + i;
  }

  public boolean canReadInt()
    throws KryoException
  {
    if (this.limit - this.position >= 5);
    int m;
    byte[] arrayOfByte4;
    int n;
    do
    {
      int k;
      byte[] arrayOfByte3;
      do
      {
        int j;
        byte[] arrayOfByte2;
        do
        {
          int i;
          byte[] arrayOfByte1;
          do
          {
            return true;
            if (optional(5) <= 0)
              return false;
            i = this.position;
            arrayOfByte1 = this.buffer;
            j = i + 1;
          }
          while ((0x80 & arrayOfByte1[i]) == 0);
          if (j == this.limit)
            return false;
          arrayOfByte2 = this.buffer;
          k = j + 1;
        }
        while ((0x80 & arrayOfByte2[j]) == 0);
        if (k == this.limit)
          return false;
        arrayOfByte3 = this.buffer;
        m = k + 1;
      }
      while ((0x80 & arrayOfByte3[k]) == 0);
      if (m == this.limit)
        return false;
      arrayOfByte4 = this.buffer;
      n = m + 1;
    }
    while (((0x80 & arrayOfByte4[m]) == 0) || (n != this.limit));
    return false;
  }

  public boolean canReadLong()
    throws KryoException
  {
    if (this.limit - this.position >= 9);
    int i3;
    byte[] arrayOfByte8;
    int i4;
    do
    {
      int i2;
      byte[] arrayOfByte7;
      do
      {
        int i1;
        byte[] arrayOfByte6;
        do
        {
          int n;
          byte[] arrayOfByte5;
          do
          {
            int m;
            byte[] arrayOfByte4;
            do
            {
              int k;
              byte[] arrayOfByte3;
              do
              {
                int j;
                byte[] arrayOfByte2;
                do
                {
                  int i;
                  byte[] arrayOfByte1;
                  do
                  {
                    return true;
                    if (optional(5) <= 0)
                      return false;
                    i = this.position;
                    arrayOfByte1 = this.buffer;
                    j = i + 1;
                  }
                  while ((0x80 & arrayOfByte1[i]) == 0);
                  if (j == this.limit)
                    return false;
                  arrayOfByte2 = this.buffer;
                  k = j + 1;
                }
                while ((0x80 & arrayOfByte2[j]) == 0);
                if (k == this.limit)
                  return false;
                arrayOfByte3 = this.buffer;
                m = k + 1;
              }
              while ((0x80 & arrayOfByte3[k]) == 0);
              if (m == this.limit)
                return false;
              arrayOfByte4 = this.buffer;
              n = m + 1;
            }
            while ((0x80 & arrayOfByte4[m]) == 0);
            if (n == this.limit)
              return false;
            arrayOfByte5 = this.buffer;
            i1 = n + 1;
          }
          while ((0x80 & arrayOfByte5[n]) == 0);
          if (i1 == this.limit)
            return false;
          arrayOfByte6 = this.buffer;
          i2 = i1 + 1;
        }
        while ((0x80 & arrayOfByte6[i1]) == 0);
        if (i2 == this.limit)
          return false;
        arrayOfByte7 = this.buffer;
        i3 = i2 + 1;
      }
      while ((0x80 & arrayOfByte7[i2]) == 0);
      if (i3 == this.limit)
        return false;
      arrayOfByte8 = this.buffer;
      i4 = i3 + 1;
    }
    while (((0x80 & arrayOfByte8[i3]) == 0) || (i4 != this.limit));
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

  public boolean eof()
  {
    return optional(1) <= 0;
  }

  protected int fill(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    if (this.inputStream == null)
      return -1;
    try
    {
      int i = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      return i;
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

  public InputStream getInputStream()
  {
    return this.inputStream;
  }

  public final int limit()
  {
    return this.limit;
  }

  public final int position()
  {
    return this.position;
  }

  public int read()
    throws KryoException
  {
    if (optional(1) <= 0)
      return -1;
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    return 0xFF & arrayOfByte[i];
  }

  public int read(byte[] paramArrayOfByte)
    throws KryoException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws KryoException
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    int i = Math.min(this.limit - this.position, paramInt2);
    int j = paramInt2;
    System.arraycopy(this.buffer, this.position, paramArrayOfByte, paramInt1, i);
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
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i] == 1;
  }

  public byte readByte()
    throws KryoException
  {
    require(1);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i];
  }

  public int readByteUnsigned()
    throws KryoException
  {
    require(1);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    return 0xFF & arrayOfByte[i];
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
      System.arraycopy(this.buffer, this.position, paramArrayOfByte, paramInt1, i);
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
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.buffer;
    int k = this.position;
    this.position = (k + 1);
    return (char)(j | 0xFF & arrayOfByte2[k]);
  }

  public char[] readChars(int paramInt)
    throws KryoException
  {
    char[] arrayOfChar = new char[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfChar[i] = readChar();
    return arrayOfChar;
  }

  public double readDouble()
    throws KryoException
  {
    return Double.longBitsToDouble(readLong());
  }

  public double readDouble(double paramDouble, boolean paramBoolean)
    throws KryoException
  {
    return readLong(paramBoolean) / paramDouble;
  }

  public double[] readDoubles(int paramInt)
    throws KryoException
  {
    double[] arrayOfDouble = new double[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfDouble[i] = readDouble();
    return arrayOfDouble;
  }

  public float readFloat()
    throws KryoException
  {
    return Float.intBitsToFloat(readInt());
  }

  public float readFloat(float paramFloat, boolean paramBoolean)
    throws KryoException
  {
    return readInt(paramBoolean) / paramFloat;
  }

  public float[] readFloats(int paramInt)
    throws KryoException
  {
    float[] arrayOfFloat = new float[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfFloat[i] = readFloat();
    return arrayOfFloat;
  }

  public int readInt()
    throws KryoException
  {
    require(4);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 4);
    return (0xFF & arrayOfByte[i]) << 24 | (0xFF & arrayOfByte[(i + 1)]) << 16 | (0xFF & arrayOfByte[(i + 2)]) << 8 | 0xFF & arrayOfByte[(i + 3)];
  }

  public int readInt(boolean paramBoolean)
    throws KryoException
  {
    return readVarInt(paramBoolean);
  }

  public int[] readInts(int paramInt)
    throws KryoException
  {
    int[] arrayOfInt = new int[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfInt[i] = readInt();
    return arrayOfInt;
  }

  public int[] readInts(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    int[] arrayOfInt = new int[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfInt[i] = readInt(paramBoolean);
    return arrayOfInt;
  }

  public long readLong()
    throws KryoException
  {
    require(8);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i] << 56;
    int j = this.position;
    this.position = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte[j]) << 48;
    int k = this.position;
    this.position = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte[k]) << 40;
    int m = this.position;
    this.position = (m + 1);
    long l4 = l3 | (0xFF & arrayOfByte[m]) << 32;
    int n = this.position;
    this.position = (n + 1);
    long l5 = l4 | (0xFF & arrayOfByte[n]) << 24;
    int i1 = this.position;
    this.position = (i1 + 1);
    long l6 = l5 | (0xFF & arrayOfByte[i1]) << 16;
    int i2 = this.position;
    this.position = (i2 + 1);
    long l7 = l6 | (0xFF & arrayOfByte[i2]) << 8;
    int i3 = this.position;
    this.position = (i3 + 1);
    return l7 | 0xFF & arrayOfByte[i3];
  }

  public long readLong(boolean paramBoolean)
    throws KryoException
  {
    return readVarLong(paramBoolean);
  }

  public long[] readLongs(int paramInt)
    throws KryoException
  {
    long[] arrayOfLong = new long[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfLong[i] = readLong();
    return arrayOfLong;
  }

  public long[] readLongs(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    long[] arrayOfLong = new long[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfLong[i] = readLong(paramBoolean);
    return arrayOfLong;
  }

  public short readShort()
    throws KryoException
  {
    require(2);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.buffer;
    int k = this.position;
    this.position = (k + 1);
    return (short)(j | 0xFF & arrayOfByte2[k]);
  }

  public int readShortUnsigned()
    throws KryoException
  {
    require(2);
    byte[] arrayOfByte1 = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.buffer;
    int k = this.position;
    this.position = (k + 1);
    return j | 0xFF & arrayOfByte2[k];
  }

  public short[] readShorts(int paramInt)
    throws KryoException
  {
    short[] arrayOfShort = new short[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfShort[i] = readShort();
    return arrayOfShort;
  }

  public String readString()
  {
    int i = require(1);
    byte[] arrayOfByte = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    int k = arrayOfByte[j];
    if ((k & 0x80) == 0)
      return readAscii();
    if (i >= 5);
    for (int m = readUtf8Length(k); ; m = readUtf8Length_slow(k))
      switch (m)
      {
      default:
        int n = m - 1;
        if (this.chars.length < n)
          this.chars = new char[n];
        readUtf8(n);
        return new String(this.chars, 0, n);
      case 0:
      case 1:
      }
    return null;
    return "";
  }

  public StringBuilder readStringBuilder()
  {
    int i = require(1);
    byte[] arrayOfByte = this.buffer;
    int j = this.position;
    this.position = (j + 1);
    int k = arrayOfByte[j];
    if ((k & 0x80) == 0)
      return new StringBuilder(readAscii());
    if (i >= 5);
    for (int m = readUtf8Length(k); ; m = readUtf8Length_slow(k))
      switch (m)
      {
      default:
        int n = m - 1;
        if (this.chars.length < n)
          this.chars = new char[n];
        readUtf8(n);
        StringBuilder localStringBuilder = new StringBuilder(n);
        localStringBuilder.append(this.chars, 0, n);
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
    int k;
    if (require(1) < 5)
      k = readInt_slow(paramBoolean);
    do
    {
      return k;
      byte[] arrayOfByte1 = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      int j = arrayOfByte1[i];
      k = j & 0x7F;
      if ((j & 0x80) != 0)
      {
        byte[] arrayOfByte2 = this.buffer;
        int m = this.position;
        this.position = (m + 1);
        int n = arrayOfByte2[m];
        k |= (n & 0x7F) << 7;
        if ((n & 0x80) != 0)
        {
          int i1 = this.position;
          this.position = (i1 + 1);
          int i2 = arrayOfByte2[i1];
          k |= (i2 & 0x7F) << 14;
          if ((i2 & 0x80) != 0)
          {
            int i3 = this.position;
            this.position = (i3 + 1);
            int i4 = arrayOfByte2[i3];
            k |= (i4 & 0x7F) << 21;
            if ((i4 & 0x80) != 0)
            {
              int i5 = this.position;
              this.position = (i5 + 1);
              k |= (0x7F & arrayOfByte2[i5]) << 28;
            }
          }
        }
      }
    }
    while (paramBoolean);
    return k >>> 1 ^ -(k & 0x1);
  }

  public long readVarLong(boolean paramBoolean)
    throws KryoException
  {
    long l;
    if (require(1) < 9)
      l = readLong_slow(paramBoolean);
    do
    {
      return l;
      byte[] arrayOfByte1 = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      int j = arrayOfByte1[i];
      l = j & 0x7F;
      if ((j & 0x80) != 0)
      {
        byte[] arrayOfByte2 = this.buffer;
        int k = this.position;
        this.position = (k + 1);
        int m = arrayOfByte2[k];
        l |= (m & 0x7F) << 7;
        if ((m & 0x80) != 0)
        {
          int n = this.position;
          this.position = (n + 1);
          int i1 = arrayOfByte2[n];
          l |= (i1 & 0x7F) << 14;
          if ((i1 & 0x80) != 0)
          {
            int i2 = this.position;
            this.position = (i2 + 1);
            int i3 = arrayOfByte2[i2];
            l |= (i3 & 0x7F) << 21;
            if ((i3 & 0x80) != 0)
            {
              int i4 = this.position;
              this.position = (i4 + 1);
              int i5 = arrayOfByte2[i4];
              l |= (i5 & 0x7F) << 28;
              if ((i5 & 0x80) != 0)
              {
                int i6 = this.position;
                this.position = (i6 + 1);
                int i7 = arrayOfByte2[i6];
                l |= (i7 & 0x7F) << 35;
                if ((i7 & 0x80) != 0)
                {
                  int i8 = this.position;
                  this.position = (i8 + 1);
                  int i9 = arrayOfByte2[i8];
                  l |= (i9 & 0x7F) << 42;
                  if ((i9 & 0x80) != 0)
                  {
                    int i10 = this.position;
                    this.position = (i10 + 1);
                    int i11 = arrayOfByte2[i10];
                    l |= (i11 & 0x7F) << 49;
                    if ((i11 & 0x80) != 0)
                    {
                      int i12 = this.position;
                      this.position = (i12 + 1);
                      l |= arrayOfByte2[i12] << 56;
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

  protected int require(int paramInt)
    throws KryoException
  {
    int i = this.limit - this.position;
    if (i >= paramInt)
      return i;
    if (paramInt > this.capacity)
      throw new KryoException("Buffer too small: capacity: " + this.capacity + ", required: " + paramInt);
    if (i > 0)
    {
      int k = fill(this.buffer, this.limit, this.capacity - this.limit);
      if (k == -1)
        throw new KryoException("Buffer underflow.");
      i += k;
      if (i >= paramInt)
      {
        this.limit = (k + this.limit);
        return i;
      }
    }
    System.arraycopy(this.buffer, this.position, this.buffer, 0, i);
    this.total += this.position;
    this.position = 0;
    int j = fill(this.buffer, i, this.capacity - i);
    if (j == -1)
      if (i < paramInt);
    while (true)
    {
      this.limit = i;
      return i;
      throw new KryoException("Buffer underflow.");
      i += j;
      if (i < paramInt)
        break;
    }
  }

  public void rewind()
  {
    this.position = 0;
    this.total = 0L;
  }

  public void setBuffer(byte[] paramArrayOfByte)
  {
    setBuffer(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void setBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("bytes cannot be null.");
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.limit = (paramInt1 + paramInt2);
    this.capacity = paramArrayOfByte.length;
    this.total = 0L;
    this.inputStream = null;
  }

  public void setInputStream(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
    this.limit = 0;
    rewind();
  }

  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }

  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }

  public void setTotal(int paramInt)
  {
    this.total = paramInt;
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

  public void skip(int paramInt)
    throws KryoException
  {
    int i = Math.min(this.limit - this.position, paramInt);
    while (true)
    {
      this.position = (i + this.position);
      paramInt -= i;
      if (paramInt == 0)
        return;
      i = Math.min(paramInt, this.capacity);
      require(i);
    }
  }

  public long total()
  {
    return this.total + this.position;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.Input
 * JD-Core Version:    0.6.2
 */