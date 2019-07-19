package com.c.a.a.b;

import com.c.a.a.e.a.a;
import com.c.a.a.e.a.b;
import com.c.a.a.e.e;

public final class d
{
  protected final Object a;
  protected com.c.a.a.a b;
  protected final boolean c;
  protected final com.c.a.a.e.a d;
  protected byte[] e = null;
  protected byte[] f = null;
  protected byte[] g = null;
  protected char[] h = null;
  protected char[] i = null;
  protected char[] j = null;

  public d(com.c.a.a.e.a parama, Object paramObject, boolean paramBoolean)
  {
    this.d = parama;
    this.a = paramObject;
    this.c = paramBoolean;
  }

  public Object a()
  {
    return this.a;
  }

  public void a(com.c.a.a.a parama)
  {
    this.b = parama;
  }

  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte != this.e)
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      this.e = null;
      this.d.a(a.a.a, paramArrayOfByte);
    }
  }

  public void a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.h)
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      this.h = null;
      this.d.a(a.b.a, paramArrayOfChar);
    }
  }

  public com.c.a.a.a b()
  {
    return this.b;
  }

  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte != this.f)
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      this.f = null;
      this.d.a(a.a.b, paramArrayOfByte);
    }
  }

  public void b(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.i)
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      this.i = null;
      this.d.a(a.b.b, paramArrayOfChar);
    }
  }

  public void c(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.j)
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      this.j = null;
      this.d.a(a.b.d, paramArrayOfChar);
    }
  }

  public boolean c()
  {
    return this.c;
  }

  public e d()
  {
    return new e(this.d);
  }

  public byte[] e()
  {
    if (this.e != null)
      throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
    this.e = this.d.a(a.a.a);
    return this.e;
  }

  public byte[] f()
  {
    if (this.f != null)
      throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
    this.f = this.d.a(a.a.b);
    return this.f;
  }

  public char[] g()
  {
    if (this.h != null)
      throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
    this.h = this.d.a(a.b.a);
    return this.h;
  }

  public char[] h()
  {
    if (this.i != null)
      throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
    this.i = this.d.a(a.b.b);
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.d
 * JD-Core Version:    0.6.2
 */