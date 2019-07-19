package com.c.a.a.e;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final a b;
  private final LinkedList<byte[]> c = new LinkedList();
  private int d;
  private byte[] e;
  private int f;

  public b()
  {
    this(null);
  }

  public b(a parama)
  {
    this(parama, 500);
  }

  public b(a parama, int paramInt)
  {
    this.b = parama;
    if (parama == null)
    {
      this.e = new byte[paramInt];
      return;
    }
    this.e = parama.a(a.a.c);
  }

  private void e()
  {
    int i = 262144;
    this.d += this.e.length;
    int j = Math.max(this.d >> 1, 1000);
    if (j > i);
    while (true)
    {
      this.c.add(this.e);
      this.e = new byte[i];
      this.f = 0;
      return;
      i = j;
    }
  }

  public void a()
  {
    this.d = 0;
    this.f = 0;
    if (!this.c.isEmpty())
      this.c.clear();
  }

  public void a(int paramInt)
  {
    if (this.f >= this.e.length)
      e();
    byte[] arrayOfByte = this.e;
    int i = this.f;
    this.f = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }

  public byte[] b()
  {
    int i = this.d + this.f;
    if (i == 0)
      return a;
    byte[] arrayOfByte1 = new byte[i];
    Iterator localIterator = this.c.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte2 = (byte[])localIterator.next();
      int m = arrayOfByte2.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, m);
      j += m;
    }
    System.arraycopy(this.e, 0, arrayOfByte1, j, this.f);
    int k = j + this.f;
    if (k != i)
      throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + k + " bytes");
    if (!this.c.isEmpty())
      a();
    return arrayOfByte1;
  }

  public byte[] b(int paramInt)
  {
    this.f = paramInt;
    return b();
  }

  public byte[] c()
  {
    a();
    return this.e;
  }

  public void close()
  {
  }

  public byte[] d()
  {
    e();
    return this.e;
  }

  public void flush()
  {
  }

  public void write(int paramInt)
  {
    a(paramInt);
  }

  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (true)
    {
      int i = Math.min(this.e.length - this.f, paramInt2);
      if (i > 0)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.f, i);
        paramInt1 += i;
        this.f = (i + this.f);
        paramInt2 -= i;
      }
      if (paramInt2 <= 0)
        return;
      e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.e.b
 * JD-Core Version:    0.6.2
 */