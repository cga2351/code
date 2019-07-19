package org.objectweb.asm;

public class Label
{
  int a;
  int b;
  int c;
  private int d;
  private int[] e;
  int f;
  int g;
  Frame h;
  Label i;
  public Object info;
  Edge j;
  Label k;

  private void a(int paramInt1, int paramInt2)
  {
    if (this.e == null)
      this.e = new int[6];
    if (this.d >= this.e.length)
    {
      int[] arrayOfInt3 = new int[6 + this.e.length];
      System.arraycopy(this.e, 0, arrayOfInt3, 0, this.e.length);
      this.e = arrayOfInt3;
    }
    int[] arrayOfInt1 = this.e;
    int m = this.d;
    this.d = (m + 1);
    arrayOfInt1[m] = paramInt1;
    int[] arrayOfInt2 = this.e;
    int n = this.d;
    this.d = (n + 1);
    arrayOfInt2[n] = paramInt2;
  }

  Label a()
  {
    if (this.h == null)
      return this;
    return this.h.b;
  }

  void a(long paramLong, int paramInt)
  {
    if ((0x400 & this.a) == 0)
    {
      this.a = (0x400 | this.a);
      this.e = new int[1 + paramInt / 32];
    }
    int[] arrayOfInt = this.e;
    int m = (int)(paramLong >>> 32);
    arrayOfInt[m] |= (int)paramLong;
  }

  void a(MethodWriter paramMethodWriter, ByteVector paramByteVector, int paramInt, boolean paramBoolean)
  {
    if ((0x2 & this.a) == 0)
    {
      if (paramBoolean)
      {
        a(-1 - paramInt, paramByteVector.b);
        paramByteVector.putInt(-1);
        return;
      }
      a(paramInt, paramByteVector.b);
      paramByteVector.putShort(-1);
      return;
    }
    if (paramBoolean)
    {
      paramByteVector.putInt(this.c - paramInt);
      return;
    }
    paramByteVector.putShort(this.c - paramInt);
  }

  boolean a(long paramLong)
  {
    int m = 0x400 & this.a;
    boolean bool = false;
    if (m != 0)
    {
      int n = this.e[((int)(paramLong >>> 32))] & (int)paramLong;
      bool = false;
      if (n != 0)
        bool = true;
    }
    return bool;
  }

  boolean a(Label paramLabel)
  {
    if (((0x400 & this.a) == 0) || ((0x400 & paramLabel.a) == 0));
    while (true)
    {
      return false;
      for (int m = 0; m < this.e.length; m++)
        if ((this.e[m] & paramLabel.e[m]) != 0)
          return true;
    }
  }

  boolean a(MethodWriter paramMethodWriter, int paramInt, byte[] paramArrayOfByte)
  {
    int m = 0;
    this.a = (0x2 | this.a);
    this.c = paramInt;
    boolean bool = false;
    while (m < this.d)
    {
      int[] arrayOfInt1 = this.e;
      int n = m + 1;
      int i1 = arrayOfInt1[m];
      int[] arrayOfInt2 = this.e;
      m = n + 1;
      int i2 = arrayOfInt2[n];
      if (i1 >= 0)
      {
        int i7 = paramInt - i1;
        int i8;
        if ((i7 < -32768) || (i7 > 32767))
        {
          i8 = 0xFF & paramArrayOfByte[(i2 - 1)];
          if (i8 > 168)
            break label156;
          paramArrayOfByte[(i2 - 1)] = ((byte)(i8 + 49));
        }
        while (true)
        {
          bool = true;
          int i9 = i2 + 1;
          paramArrayOfByte[i2] = ((byte)(i7 >>> 8));
          paramArrayOfByte[i9] = ((byte)i7);
          break;
          label156: paramArrayOfByte[(i2 - 1)] = ((byte)(i8 + 20));
        }
      }
      int i3 = 1 + (i1 + paramInt);
      int i4 = i2 + 1;
      paramArrayOfByte[i2] = ((byte)(i3 >>> 24));
      int i5 = i4 + 1;
      paramArrayOfByte[i4] = ((byte)(i3 >>> 16));
      int i6 = i5 + 1;
      paramArrayOfByte[i5] = ((byte)(i3 >>> 8));
      paramArrayOfByte[i6] = ((byte)i3);
    }
    return bool;
  }

  void b(Label paramLabel, long paramLong, int paramInt)
  {
    while (this != null)
    {
      Label localLabel1 = this.k;
      this.k = null;
      if (paramLabel != null)
      {
        if ((0x800 & this.a) != 0)
        {
          this = localLabel1;
        }
        else
        {
          this.a = (0x800 | this.a);
          if (((0x100 & this.a) != 0) && (!a(paramLabel)))
          {
            Edge localEdge3 = new Edge();
            localEdge3.a = this.f;
            localEdge3.b = paramLabel.j.b;
            localEdge3.c = this.j;
            this.j = localEdge3;
          }
        }
      }
      else
      {
        Label localLabel2;
        while (true)
        {
          Edge localEdge1 = this.j;
          localLabel2 = localLabel1;
          for (Edge localEdge2 = localEdge1; localEdge2 != null; localEdge2 = localEdge2.c)
            if ((((0x80 & this.a) == 0) || (localEdge2 != this.j.c)) && (localEdge2.b.k == null))
            {
              localEdge2.b.k = localLabel2;
              localLabel2 = localEdge2.b;
            }
          if (a(paramLong))
          {
            this = localLabel1;
            break;
          }
          a(paramLong, paramInt);
        }
        this = localLabel2;
      }
    }
  }

  public int getOffset()
  {
    if ((0x2 & this.a) == 0)
      throw new IllegalStateException("Label offset position has not been resolved yet");
    return this.c;
  }

  public String toString()
  {
    return "L" + System.identityHashCode(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.Label
 * JD-Core Version:    0.6.2
 */