package f;

import javax.annotation.Nullable;

final class p
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  p f;
  p g;

  p()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }

  p(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }

  p a()
  {
    this.d = true;
    return new p(this.a, this.b, this.c, true, false);
  }

  public p a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b))
      throw new IllegalArgumentException();
    p localp;
    if (paramInt >= 1024)
      localp = a();
    while (true)
    {
      localp.c = (paramInt + localp.b);
      this.b = (paramInt + this.b);
      this.g.a(localp);
      return localp;
      localp = q.a();
      System.arraycopy(this.a, this.b, localp.a, 0, paramInt);
    }
  }

  public p a(p paramp)
  {
    paramp.g = this;
    paramp.f = this.f;
    this.f.g = paramp;
    this.f = paramp;
    return paramp;
  }

  public void a(p paramp, int paramInt)
  {
    if (!paramp.e)
      throw new IllegalArgumentException();
    if (paramInt + paramp.c > 8192)
    {
      if (paramp.d)
        throw new IllegalArgumentException();
      if (paramInt + paramp.c - paramp.b > 8192)
        throw new IllegalArgumentException();
      System.arraycopy(paramp.a, paramp.b, paramp.a, 0, paramp.c - paramp.b);
      paramp.c -= paramp.b;
      paramp.b = 0;
    }
    System.arraycopy(this.a, this.b, paramp.a, paramp.c, paramInt);
    paramp.c = (paramInt + paramp.c);
    this.b = (paramInt + this.b);
  }

  p b()
  {
    return new p((byte[])this.a.clone(), this.b, this.c, false, true);
  }

  @Nullable
  public p c()
  {
    if (this.f != this);
    for (p localp = this.f; ; localp = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localp;
    }
  }

  public void d()
  {
    if (this.g == this)
      throw new IllegalStateException();
    if (!this.g.e);
    while (true)
    {
      return;
      int i = this.c - this.b;
      int j = 8192 - this.g.c;
      if (this.g.d);
      for (int k = 0; i <= k + j; k = this.g.b)
      {
        a(this.g, i);
        c();
        q.a(this);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.p
 * JD-Core Version:    0.6.2
 */