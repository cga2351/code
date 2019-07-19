package org.objectweb.asm;

public class ByteVector
{
  byte[] a;
  int b;

  public ByteVector()
  {
    this.a = new byte[64];
  }

  public ByteVector(int paramInt)
  {
    this.a = new byte[paramInt];
  }

  private void a(int paramInt)
  {
    int i = 2 * this.a.length;
    int j = paramInt + this.b;
    if (i > j);
    while (true)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
      this.a = arrayOfByte;
      return;
      i = j;
    }
  }

  ByteVector a(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i + 2 > this.a.length)
      a(2);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)paramInt1);
    int k = j + 1;
    arrayOfByte[j] = ((byte)paramInt2);
    this.b = k;
    return this;
  }

  ByteVector b(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i + 3 > this.a.length)
      a(3);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)paramInt1);
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt2 >>> 8));
    int m = k + 1;
    arrayOfByte[k] = ((byte)paramInt2);
    this.b = m;
    return this;
  }

  ByteVector c(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.length();
    int j = paramInt1;
    int k = paramInt1;
    if (j < i)
    {
      int i6 = paramString.charAt(j);
      if ((i6 >= 1) && (i6 <= 127))
        k++;
      while (true)
      {
        j++;
        break;
        if (i6 > 2047)
          k += 3;
        else
          k += 2;
      }
    }
    if (k > paramInt2)
      throw new IllegalArgumentException();
    int m = -2 + (this.b - paramInt1);
    if (m >= 0)
    {
      this.a[m] = ((byte)(k >>> 8));
      this.a[(m + 1)] = ((byte)k);
    }
    if (k + this.b - paramInt1 > this.a.length)
      a(k - paramInt1);
    int n = this.b;
    if (paramInt1 < i)
    {
      int i1 = paramString.charAt(paramInt1);
      int i3;
      if ((i1 >= 1) && (i1 <= 127))
      {
        byte[] arrayOfByte6 = this.a;
        i3 = n + 1;
        arrayOfByte6[n] = ((byte)i1);
      }
      while (true)
      {
        paramInt1++;
        n = i3;
        break;
        if (i1 > 2047)
        {
          byte[] arrayOfByte3 = this.a;
          int i4 = n + 1;
          arrayOfByte3[n] = ((byte)(0xE0 | 0xF & i1 >> 12));
          byte[] arrayOfByte4 = this.a;
          int i5 = i4 + 1;
          arrayOfByte4[i4] = ((byte)(0x80 | 0x3F & i1 >> 6));
          byte[] arrayOfByte5 = this.a;
          i3 = i5 + 1;
          arrayOfByte5[i5] = ((byte)(0x80 | i1 & 0x3F));
        }
        else
        {
          byte[] arrayOfByte1 = this.a;
          int i2 = n + 1;
          arrayOfByte1[n] = ((byte)(0xC0 | 0x1F & i1 >> 6));
          byte[] arrayOfByte2 = this.a;
          i3 = i2 + 1;
          arrayOfByte2[i2] = ((byte)(0x80 | i1 & 0x3F));
        }
      }
    }
    this.b = n;
    return this;
  }

  public ByteVector putByte(int paramInt)
  {
    int i = this.b;
    if (i + 1 > this.a.length)
      a(1);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)paramInt);
    this.b = j;
    return this;
  }

  public ByteVector putByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 + this.b > this.a.length)
      a(paramInt2);
    if (paramArrayOfByte != null)
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b = (paramInt2 + this.b);
    return this;
  }

  public ByteVector putInt(int paramInt)
  {
    int i = this.b;
    if (i + 4 > this.a.length)
      a(4);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 24));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 16));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(paramInt >>> 8));
    int n = m + 1;
    arrayOfByte[m] = ((byte)paramInt);
    this.b = n;
    return this;
  }

  public ByteVector putLong(long paramLong)
  {
    int i = this.b;
    if (i + 8 > this.a.length)
      a(8);
    byte[] arrayOfByte = this.a;
    int j = (int)(paramLong >>> 32);
    int k = i + 1;
    arrayOfByte[i] = ((byte)(j >>> 24));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(j >>> 16));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(j >>> 8));
    int i1 = n + 1;
    arrayOfByte[n] = ((byte)j);
    int i2 = (int)paramLong;
    int i3 = i1 + 1;
    arrayOfByte[i1] = ((byte)(i2 >>> 24));
    int i4 = i3 + 1;
    arrayOfByte[i3] = ((byte)(i2 >>> 16));
    int i5 = i4 + 1;
    arrayOfByte[i4] = ((byte)(i2 >>> 8));
    int i6 = i5 + 1;
    arrayOfByte[i5] = ((byte)i2);
    this.b = i6;
    return this;
  }

  public ByteVector putShort(int paramInt)
  {
    int i = this.b;
    if (i + 2 > this.a.length)
      a(2);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8));
    int k = j + 1;
    arrayOfByte[j] = ((byte)paramInt);
    this.b = k;
    return this;
  }

  public ByteVector putUTF8(String paramString)
  {
    int i = paramString.length();
    if (i > 65535)
      throw new IllegalArgumentException();
    int j = this.b;
    if (i + (j + 2) > this.a.length)
      a(i + 2);
    byte[] arrayOfByte = this.a;
    int k = j + 1;
    arrayOfByte[j] = ((byte)(i >>> 8));
    int m = k + 1;
    arrayOfByte[k] = ((byte)i);
    int n = 0;
    while (n < i)
    {
      int i1 = paramString.charAt(n);
      if ((i1 >= 1) && (i1 <= 127))
      {
        int i2 = m + 1;
        arrayOfByte[m] = ((byte)i1);
        n++;
        m = i2;
      }
      else
      {
        this.b = m;
        return c(paramString, n, 65535);
      }
    }
    this.b = m;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.ByteVector
 * JD-Core Version:    0.6.2
 */