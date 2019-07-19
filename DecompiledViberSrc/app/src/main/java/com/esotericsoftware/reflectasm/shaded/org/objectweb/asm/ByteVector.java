package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

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
    int j = this.b;
    if (i + (j + 2) > this.a.length)
      a(i + 2);
    byte[] arrayOfByte1 = this.a;
    int k = j + 1;
    arrayOfByte1[j] = ((byte)(i >>> 8));
    int m = k + 1;
    arrayOfByte1[k] = ((byte)i);
    int n = 0;
    byte[] arrayOfByte2;
    while (true)
      if (n < i)
      {
        int i2 = paramString.charAt(n);
        if ((i2 >= 1) && (i2 <= 127))
        {
          int i11 = m + 1;
          arrayOfByte1[m] = ((byte)i2);
          n++;
          m = i11;
        }
        else
        {
          int i3 = n;
          int i4 = n;
          if (i3 < i)
          {
            int i10 = paramString.charAt(i3);
            if ((i10 >= 1) && (i10 <= 127))
              i4++;
            while (true)
            {
              i3++;
              break;
              if (i10 > 2047)
                i4 += 3;
              else
                i4 += 2;
            }
          }
          arrayOfByte1[this.b] = ((byte)(i4 >>> 8));
          arrayOfByte1[(1 + this.b)] = ((byte)i4);
          if (i4 + (2 + this.b) > arrayOfByte1.length)
          {
            this.b = m;
            a(i4 + 2);
            arrayOfByte2 = this.a;
            if (n < i)
            {
              int i5 = paramString.charAt(n);
              int i7;
              if ((i5 >= 1) && (i5 <= 127))
              {
                i7 = m + 1;
                arrayOfByte2[m] = ((byte)i5);
              }
              while (true)
              {
                n++;
                m = i7;
                break;
                if (i5 > 2047)
                {
                  int i8 = m + 1;
                  arrayOfByte2[m] = ((byte)(0xE0 | 0xF & i5 >> 12));
                  int i9 = i8 + 1;
                  arrayOfByte2[i8] = ((byte)(0x80 | 0x3F & i5 >> 6));
                  i7 = i9 + 1;
                  arrayOfByte2[i9] = ((byte)(0x80 | i5 & 0x3F));
                }
                else
                {
                  int i6 = m + 1;
                  arrayOfByte2[m] = ((byte)(0xC0 | 0x1F & i5 >> 6));
                  i7 = i6 + 1;
                  arrayOfByte2[i6] = ((byte)(0x80 | i5 & 0x3F));
                }
              }
            }
          }
        }
      }
    for (int i1 = m; ; i1 = m)
    {
      this.b = i1;
      return this;
      arrayOfByte2 = arrayOfByte1;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ByteVector
 * JD-Core Version:    0.6.2
 */