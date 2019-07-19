package com.c.a.a.c;

import com.c.a.a.b.b;
import com.c.a.a.e;
import com.c.a.a.i;

public final class c extends i
{
  protected final c c;
  protected int d;
  protected int e;
  protected String f;
  protected c g = null;

  public c(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.c = paramc;
    this.d = paramInt2;
    this.e = paramInt3;
    this.b = -1;
  }

  public static c g()
  {
    return new c(null, 0, 1, 0);
  }

  public c a(int paramInt1, int paramInt2)
  {
    c localc1 = this.g;
    if (localc1 == null)
    {
      c localc2 = new c(this, 1, paramInt1, paramInt2);
      this.g = localc2;
      return localc2;
    }
    localc1.a(1, paramInt1, paramInt2);
    return localc1;
  }

  public e a(Object paramObject)
  {
    return new e(paramObject, -1L, this.d, this.e);
  }

  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = -1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = null;
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public c b(int paramInt1, int paramInt2)
  {
    c localc1 = this.g;
    if (localc1 == null)
    {
      c localc2 = new c(this, 2, paramInt1, paramInt2);
      this.g = localc2;
      return localc2;
    }
    localc1.a(2, paramInt1, paramInt2);
    return localc1;
  }

  public String h()
  {
    return this.f;
  }

  public c i()
  {
    return this.c;
  }

  public boolean j()
  {
    int i = 1 + this.b;
    this.b = i;
    return (this.a != 0) && (i > 0);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    switch (this.a)
    {
    default:
    case 0:
    case 1:
      while (true)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("/");
        continue;
        localStringBuilder.append('[');
        localStringBuilder.append(f());
        localStringBuilder.append(']');
      }
    case 2:
    }
    localStringBuilder.append('{');
    if (this.f != null)
    {
      localStringBuilder.append('"');
      b.a(localStringBuilder, this.f);
      localStringBuilder.append('"');
    }
    while (true)
    {
      localStringBuilder.append('}');
      break;
      localStringBuilder.append('?');
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.c
 * JD-Core Version:    0.6.2
 */