package com.c.a.a.b;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

public class l extends a
{
  protected final boolean g;
  protected char h = '\000';
  protected int i = 0;
  protected int j = 0;
  protected final boolean k;

  public l(d paramd, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramd, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    this.g = paramBoolean;
    boolean bool = false;
    if (paramInputStream != null)
      bool = true;
    this.k = bool;
  }

  private void a(int paramInt1, int paramInt2)
    throws IOException
  {
    int m = paramInt1 + this.j;
    int n = this.i;
    throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + n + ", byte #" + m + ")");
  }

  private void a(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    int m = -1 + (this.j + this.d);
    int n = paramInt2 + this.i;
    throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + n + ", byte #" + m + ")");
  }

  private boolean a(int paramInt)
    throws IOException
  {
    this.j += this.e - paramInt;
    if (paramInt > 0)
    {
      if (this.d > 0)
      {
        for (int i1 = 0; i1 < paramInt; i1++)
          this.c[i1] = this.c[(i1 + this.d)];
        this.d = 0;
      }
      this.e = paramInt;
      if (this.e >= 4)
        break label230;
      if (this.b != null)
        break label201;
    }
    label201: for (int n = -1; ; n = this.b.read(this.c, this.e, this.c.length - this.e))
    {
      if (n < 1)
      {
        if (n < 0)
        {
          if (this.k)
            a();
          a(this.e, 4);
        }
        b();
      }
      this.e = (n + this.e);
      break;
      this.d = 0;
      int m;
      if (this.b == null)
        m = -1;
      while (m < 1)
      {
        this.e = 0;
        if (m < 0)
        {
          if (this.k)
            a();
          return false;
          m = this.b.read(this.c);
        }
        else
        {
          b();
        }
      }
      this.e = m;
      break;
    }
    label230: return true;
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c == null)
      paramInt2 = -1;
    while (paramInt2 < 1)
      return paramInt2;
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length))
      a(paramArrayOfChar, paramInt1, paramInt2);
    int m = paramInt2 + paramInt1;
    int i1;
    if (this.h != 0)
    {
      i1 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = this.h;
      this.h = '\000';
    }
    while (true)
    {
      int i4;
      int i5;
      label144: int i2;
      if (i1 < m)
      {
        i4 = this.d;
        if (this.g)
        {
          i5 = this.c[i4] << 24 | (0xFF & this.c[(i4 + 1)]) << 16 | (0xFF & this.c[(i4 + 2)]) << 8 | 0xFF & this.c[(i4 + 3)];
          this.d = (4 + this.d);
          if (i5 <= 65535)
            break label368;
          if (i5 > 1114111)
            a(i5, i1 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
          int i6 = i5 - 65536;
          i2 = i1 + 1;
          paramArrayOfChar[i1] = ((char)(55296 + (i6 >> 10)));
          i5 = 0xDC00 | i6 & 0x3FF;
          if (i2 < m)
            break label372;
          this.h = ((char)i5);
        }
      }
      while (true)
      {
        int i3 = i2 - paramInt1;
        this.i = (i3 + this.i);
        return i3;
        int n = this.e - this.d;
        if ((n >= 4) || (a(n)))
          break label410;
        return -1;
        i5 = 0xFF & this.c[i4] | (0xFF & this.c[(i4 + 1)]) << 8 | (0xFF & this.c[(i4 + 2)]) << 16 | this.c[(i4 + 3)] << 24;
        break label144;
        label368: i2 = i1;
        label372: i1 = i2 + 1;
        paramArrayOfChar[i2] = ((char)i5);
        if (this.d < this.e)
          break;
        i2 = i1;
        continue;
        i2 = i1;
      }
      label410: i1 = paramInt1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.l
 * JD-Core Version:    0.6.2
 */