package com.c.a.a.c;

import com.c.a.a.b.d;
import com.c.a.a.b.l;
import com.c.a.a.d.b;
import com.c.a.a.f;
import com.c.a.a.k;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class a
{
  protected final d a;
  protected final InputStream b;
  protected final byte[] c;
  protected int d;
  protected boolean e = true;
  protected int f = 0;
  private int g;
  private int h;
  private final boolean i;

  public a(d paramd, InputStream paramInputStream)
  {
    this.a = paramd;
    this.b = paramInputStream;
    this.c = paramd.e();
    this.g = 0;
    this.h = 0;
    this.d = 0;
    this.i = true;
  }

  private void a(String paramString)
    throws IOException
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }

  private boolean b(int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default:
    case 65279:
    case -131072:
    case 65534:
    case -16842752:
    }
    int j;
    while (true)
    {
      j = paramInt >>> 16;
      if (j != 65279)
        break;
      this.g = (2 + this.g);
      this.f = 2;
      this.e = true;
      return true;
      this.e = true;
      this.g = (4 + this.g);
      this.f = 4;
      return true;
      this.g = (4 + this.g);
      this.f = 4;
      this.e = false;
      return true;
      a("2143");
      a("3412");
    }
    if (j == 65534)
    {
      this.g = (2 + this.g);
      this.f = 2;
      this.e = false;
      return true;
    }
    if (paramInt >>> 8 == 15711167)
    {
      this.g = (3 + this.g);
      this.f = 1;
      this.e = true;
      return true;
    }
    return false;
  }

  private boolean c(int paramInt)
    throws IOException
  {
    if (paramInt >> 8 == 0)
      this.e = true;
    while (true)
    {
      this.f = 4;
      boolean bool = true;
      int j;
      do
      {
        return bool;
        if ((0xFFFFFF & paramInt) == 0)
        {
          this.e = false;
          break;
        }
        if ((0xFF00FFFF & paramInt) == 0)
        {
          a("3412");
          break;
        }
        j = 0xFFFF00FF & paramInt;
        bool = false;
      }
      while (j != 0);
      a("2143");
    }
  }

  private boolean d(int paramInt)
  {
    if ((0xFF00 & paramInt) == 0);
    for (this.e = true; ; this.e = false)
    {
      this.f = 2;
      boolean bool = true;
      int j;
      do
      {
        return bool;
        j = paramInt & 0xFF;
        bool = false;
      }
      while (j != 0);
    }
  }

  public com.c.a.a.a a()
    throws IOException, f
  {
    int j = 1;
    int k;
    com.c.a.a.a locala;
    if (a(4))
    {
      k = this.c[this.g] << 24 | (0xFF & this.c[(1 + this.g)]) << 16 | (0xFF & this.c[(2 + this.g)]) << 8 | 0xFF & this.c[(3 + this.g)];
      if (b(k))
      {
        if (j != 0)
          break label177;
        locala = com.c.a.a.a.a;
      }
    }
    while (true)
    {
      this.a.a(locala);
      return locala;
      if ((c(k)) || (d(k >>> 16)))
        break;
      do
      {
        j = 0;
        break;
      }
      while ((!a(2)) || (!d((0xFF & this.c[this.g]) << 8 | 0xFF & this.c[(1 + this.g)])));
      break;
      label177: switch (this.f)
      {
      case 3:
      default:
        throw new RuntimeException("Internal error");
      case 1:
        locala = com.c.a.a.a.a;
        break;
      case 2:
        if (this.e)
          locala = com.c.a.a.a.b;
        else
          locala = com.c.a.a.a.c;
        break;
      case 4:
        if (this.e)
          locala = com.c.a.a.a.d;
        else
          locala = com.c.a.a.a.e;
        break;
      }
    }
  }

  public com.c.a.a.g a(int paramInt, k paramk, com.c.a.a.d.a parama, b paramb, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, f
  {
    if ((a() == com.c.a.a.a.a) && (paramBoolean1))
    {
      com.c.a.a.d.a locala = parama.a(paramBoolean1, paramBoolean2);
      return new g(this.a, paramInt, this.b, paramk, locala, this.c, this.g, this.h, this.i);
    }
    return new e(this.a, paramInt, b(), paramk, paramb.a(paramBoolean1, paramBoolean2));
  }

  protected boolean a(int paramInt)
    throws IOException
  {
    int j = 1;
    label37: int n;
    for (int k = this.h - this.g; ; k = n + k)
    {
      if (k < paramInt)
        if (this.b != null)
          break label37;
      for (int m = -1; m < j; n = this.b.read(this.c, this.h, this.c.length - this.h))
      {
        j = 0;
        return j;
      }
      this.h = (n + this.h);
    }
  }

  public Reader b()
    throws IOException
  {
    com.c.a.a.a locala = this.a.b();
    switch (1.a[locala.ordinal()])
    {
    default:
      throw new RuntimeException("Internal error");
    case 1:
    case 2:
      return new l(this.a, this.b, this.c, this.g, this.h, this.a.b().b());
    case 3:
    case 4:
    case 5:
    }
    InputStream localInputStream = this.b;
    Object localObject;
    if (localInputStream == null)
      localObject = new ByteArrayInputStream(this.c, this.g, this.h);
    while (true)
    {
      return new InputStreamReader((InputStream)localObject, locala.a());
      if (this.g < this.h)
        localObject = new com.c.a.a.b.g(this.a, localInputStream, this.c, this.g, this.h);
      else
        localObject = localInputStream;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.a
 * JD-Core Version:    0.6.2
 */