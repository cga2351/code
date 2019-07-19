package com.c.a.a.b;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class m extends Writer
{
  protected final d a;
  OutputStream b;
  byte[] c;
  final int d;
  int e;
  int f = 0;

  public m(d paramd, OutputStream paramOutputStream)
  {
    this.a = paramd;
    this.b = paramOutputStream;
    this.c = paramd.f();
    this.d = (-4 + this.c.length);
    this.e = 0;
  }

  private int a(int paramInt)
    throws IOException
  {
    int i = this.f;
    this.f = 0;
    if ((paramInt < 56320) || (paramInt > 57343))
      throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(paramInt) + "; illegal combination");
    return 65536 + (i - 55296 << 10) + (paramInt - 56320);
  }

  private void b(int paramInt)
    throws IOException
  {
    if (paramInt > 1114111)
      throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319)
        throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
      throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
    }
    throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
  }

  public Writer append(char paramChar)
    throws IOException
  {
    write(paramChar);
    return this;
  }

  public void close()
    throws IOException
  {
    if (this.b != null)
    {
      if (this.e > 0)
      {
        this.b.write(this.c, 0, this.e);
        this.e = 0;
      }
      OutputStream localOutputStream = this.b;
      this.b = null;
      byte[] arrayOfByte = this.c;
      if (arrayOfByte != null)
      {
        this.c = null;
        this.a.b(arrayOfByte);
      }
      localOutputStream.close();
      int i = this.f;
      this.f = 0;
      if (i > 0)
        b(i);
    }
  }

  public void flush()
    throws IOException
  {
    if (this.b != null)
    {
      if (this.e > 0)
      {
        this.b.write(this.c, 0, this.e);
        this.e = 0;
      }
      this.b.flush();
    }
  }

  public void write(int paramInt)
    throws IOException
  {
    if (this.f > 0)
      paramInt = a(paramInt);
    while ((paramInt < 55296) || (paramInt > 57343))
    {
      if (this.e >= this.d)
      {
        this.b.write(this.c, 0, this.e);
        this.e = 0;
      }
      if (paramInt >= 128)
        break;
      byte[] arrayOfByte10 = this.c;
      int i4 = this.e;
      this.e = (i4 + 1);
      arrayOfByte10[i4] = ((byte)paramInt);
      return;
    }
    if (paramInt > 56319)
      b(paramInt);
    this.f = paramInt;
    return;
    int i = this.e;
    int n;
    if (paramInt < 2048)
    {
      byte[] arrayOfByte8 = this.c;
      int i3 = i + 1;
      arrayOfByte8[i] = ((byte)(0xC0 | paramInt >> 6));
      byte[] arrayOfByte9 = this.c;
      n = i3 + 1;
      arrayOfByte9[i3] = ((byte)(0x80 | paramInt & 0x3F));
    }
    while (true)
    {
      this.e = n;
      return;
      if (paramInt <= 65535)
      {
        byte[] arrayOfByte5 = this.c;
        int i1 = i + 1;
        arrayOfByte5[i] = ((byte)(0xE0 | paramInt >> 12));
        byte[] arrayOfByte6 = this.c;
        int i2 = i1 + 1;
        arrayOfByte6[i1] = ((byte)(0x80 | 0x3F & paramInt >> 6));
        byte[] arrayOfByte7 = this.c;
        n = i2 + 1;
        arrayOfByte7[i2] = ((byte)(0x80 | paramInt & 0x3F));
      }
      else
      {
        if (paramInt > 1114111)
          b(paramInt);
        byte[] arrayOfByte1 = this.c;
        int j = i + 1;
        arrayOfByte1[i] = ((byte)(0xF0 | paramInt >> 18));
        byte[] arrayOfByte2 = this.c;
        int k = j + 1;
        arrayOfByte2[j] = ((byte)(0x80 | 0x3F & paramInt >> 12));
        byte[] arrayOfByte3 = this.c;
        int m = k + 1;
        arrayOfByte3[k] = ((byte)(0x80 | 0x3F & paramInt >> 6));
        byte[] arrayOfByte4 = this.c;
        n = m + 1;
        arrayOfByte4[m] = ((byte)(0x80 | paramInt & 0x3F));
      }
    }
  }

  public void write(String paramString)
    throws IOException
  {
    write(paramString, 0, paramString.length());
  }

  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1)
        write(paramString.charAt(paramInt1));
      return;
    }
    if (this.f > 0)
    {
      int i21 = paramInt1 + 1;
      int i22 = paramString.charAt(paramInt1);
      paramInt2--;
      write(a(i22));
      paramInt1 = i21;
    }
    int i = this.e;
    byte[] arrayOfByte = this.c;
    int j = this.d;
    int k = paramInt2 + paramInt1;
    int m = paramInt1;
    int n;
    int i1;
    int i12;
    int i13;
    label167: int i15;
    int i16;
    label182: int i17;
    int i18;
    while (true)
      if (m < k)
      {
        if (i >= j)
        {
          this.b.write(arrayOfByte, 0, i);
          i = 0;
        }
        n = m + 1;
        i1 = paramString.charAt(m);
        if (i1 >= 128)
          break label579;
        int i11 = i + 1;
        arrayOfByte[i] = ((byte)i1);
        i12 = k - n;
        i13 = j - i11;
        if (i12 <= i13)
          break label572;
        int i14 = i13 + n;
        i15 = i11;
        i16 = n;
        if (i16 >= i14)
        {
          int i20 = i15;
          m = i16;
          i = i20;
        }
        else
        {
          i17 = i16 + 1;
          i18 = paramString.charAt(i16);
          if (i18 >= 128)
          {
            i = i15;
            m = i17;
          }
        }
      }
    for (int i2 = i18; ; i2 = i1)
    {
      if (i2 < 2048)
      {
        int i10 = i + 1;
        arrayOfByte[i] = ((byte)(0xC0 | i2 >> 6));
        i = i10 + 1;
        arrayOfByte[i10] = ((byte)(0x80 | i2 & 0x3F));
        break;
        int i19 = i15 + 1;
        arrayOfByte[i15] = ((byte)i18);
        i15 = i19;
        i16 = i17;
        break label182;
      }
      if ((i2 < 55296) || (i2 > 57343))
      {
        int i3 = i + 1;
        arrayOfByte[i] = ((byte)(0xE0 | i2 >> 12));
        int i4 = i3 + 1;
        arrayOfByte[i3] = ((byte)(0x80 | 0x3F & i2 >> 6));
        i = i4 + 1;
        arrayOfByte[i4] = ((byte)(0x80 | i2 & 0x3F));
        break;
      }
      if (i2 > 56319)
      {
        this.e = i;
        b(i2);
      }
      this.f = i2;
      if (m >= k)
      {
        this.e = i;
        return;
      }
      int i5 = m + 1;
      int i6 = a(paramString.charAt(m));
      if (i6 > 1114111)
      {
        this.e = i;
        b(i6);
      }
      int i7 = i + 1;
      arrayOfByte[i] = ((byte)(0xF0 | i6 >> 18));
      int i8 = i7 + 1;
      arrayOfByte[i7] = ((byte)(0x80 | 0x3F & i6 >> 12));
      int i9 = i8 + 1;
      arrayOfByte[i8] = ((byte)(0x80 | 0x3F & i6 >> 6));
      i = i9 + 1;
      arrayOfByte[i9] = ((byte)(0x80 | i6 & 0x3F));
      m = i5;
      break;
      label572: i13 = i12;
      break label167;
      label579: m = n;
    }
  }

  public void write(char[] paramArrayOfChar)
    throws IOException
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1)
        write(paramArrayOfChar[paramInt1]);
      return;
    }
    if (this.f > 0)
    {
      int i21 = paramInt1 + 1;
      int i22 = paramArrayOfChar[paramInt1];
      paramInt2--;
      write(a(i22));
      paramInt1 = i21;
    }
    int i = this.e;
    byte[] arrayOfByte = this.c;
    int j = this.d;
    int k = paramInt2 + paramInt1;
    int m = paramInt1;
    int n;
    int i1;
    int i12;
    int i13;
    label161: int i15;
    int i16;
    label176: int i17;
    int i18;
    while (true)
      if (m < k)
      {
        if (i >= j)
        {
          this.b.write(arrayOfByte, 0, i);
          i = 0;
        }
        n = m + 1;
        i1 = paramArrayOfChar[m];
        if (i1 >= 128)
          break label569;
        int i11 = i + 1;
        arrayOfByte[i] = ((byte)i1);
        i12 = k - n;
        i13 = j - i11;
        if (i12 <= i13)
          break label562;
        int i14 = i13 + n;
        i15 = i11;
        i16 = n;
        if (i16 >= i14)
        {
          int i20 = i15;
          m = i16;
          i = i20;
        }
        else
        {
          i17 = i16 + 1;
          i18 = paramArrayOfChar[i16];
          if (i18 >= 128)
          {
            i = i15;
            m = i17;
          }
        }
      }
    for (int i2 = i18; ; i2 = i1)
    {
      if (i2 < 2048)
      {
        int i10 = i + 1;
        arrayOfByte[i] = ((byte)(0xC0 | i2 >> 6));
        i = i10 + 1;
        arrayOfByte[i10] = ((byte)(0x80 | i2 & 0x3F));
        break;
        int i19 = i15 + 1;
        arrayOfByte[i15] = ((byte)i18);
        i15 = i19;
        i16 = i17;
        break label176;
      }
      if ((i2 < 55296) || (i2 > 57343))
      {
        int i3 = i + 1;
        arrayOfByte[i] = ((byte)(0xE0 | i2 >> 12));
        int i4 = i3 + 1;
        arrayOfByte[i3] = ((byte)(0x80 | 0x3F & i2 >> 6));
        i = i4 + 1;
        arrayOfByte[i4] = ((byte)(0x80 | i2 & 0x3F));
        break;
      }
      if (i2 > 56319)
      {
        this.e = i;
        b(i2);
      }
      this.f = i2;
      if (m >= k)
      {
        this.e = i;
        return;
      }
      int i5 = m + 1;
      int i6 = a(paramArrayOfChar[m]);
      if (i6 > 1114111)
      {
        this.e = i;
        b(i6);
      }
      int i7 = i + 1;
      arrayOfByte[i] = ((byte)(0xF0 | i6 >> 18));
      int i8 = i7 + 1;
      arrayOfByte[i7] = ((byte)(0x80 | 0x3F & i6 >> 12));
      int i9 = i8 + 1;
      arrayOfByte[i8] = ((byte)(0x80 | 0x3F & i6 >> 6));
      i = i9 + 1;
      arrayOfByte[i9] = ((byte)(0x80 | i6 & 0x3F));
      m = i5;
      break;
      label562: i13 = i12;
      break label161;
      label569: m = n;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.m
 * JD-Core Version:    0.6.2
 */