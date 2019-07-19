package e.a.b.b;

import java.io.IOException;

abstract class c extends b
{
  protected int w;

  public c(int paramInt)
  {
    super(paramInt);
  }

  protected abstract int a(char paramChar, int paramInt);

  protected abstract void a(int paramInt1, int paramInt2);

  protected void a(boolean[] paramArrayOfBoolean)
    throws IOException
  {
    int i = this.k;
    c(paramArrayOfBoolean);
    b(i, this.k);
  }

  protected Object b(boolean[] paramArrayOfBoolean)
    throws e, IOException
  {
    int i = this.k;
    d();
    i();
    if ((this.a != '.') && (this.a != 'E') && (this.a != 'e'))
    {
      j();
      if ((this.a >= 0) && (this.a < '~') && (paramArrayOfBoolean[this.a] == 0) && (this.a != '\032'))
      {
        c(paramArrayOfBoolean);
        b(i, this.k);
        if (!this.n)
          throw new e(this.k, 1, this.j);
        return this.j;
      }
      b(i, this.k);
      return a(this.j);
    }
    if (this.a == '.')
    {
      d();
      i();
    }
    if ((this.a != 'E') && (this.a != 'e'))
    {
      j();
      if ((this.a >= 0) && (this.a < '~') && (paramArrayOfBoolean[this.a] == 0) && (this.a != '\032'))
      {
        c(paramArrayOfBoolean);
        b(i, this.k);
        if (!this.n)
          throw new e(this.k, 1, this.j);
        return this.j;
      }
      b(i, this.k);
      return c();
    }
    this.h.a('E');
    d();
    if ((this.a == '+') || (this.a == '-') || ((this.a >= '0') && (this.a <= '9')))
    {
      this.h.a(this.a);
      d();
      i();
      j();
      if ((this.a >= 0) && (this.a < '~') && (paramArrayOfBoolean[this.a] == 0) && (this.a != '\032'))
      {
        c(paramArrayOfBoolean);
        b(i, this.k);
        if (!this.n)
          throw new e(this.k, 1, this.j);
        return this.j;
      }
      b(i, this.k);
      return c();
    }
    c(paramArrayOfBoolean);
    b(i, this.k);
    if (!this.n)
      throw new e(this.k, 1, this.j);
    if (!this.l)
      b();
    return this.j;
  }

  protected abstract void b(int paramInt1, int paramInt2);

  protected void g()
    throws e, IOException
  {
    if ((!this.o) && (this.a == '\''))
    {
      if (this.n)
      {
        a(c);
        return;
      }
      throw new e(this.k, 0, Character.valueOf(this.a));
    }
    int i = a(this.a, 1 + this.k);
    if (i == -1)
      throw new e(this.w, 3, null);
    a(1 + this.k, i);
    if (this.j.indexOf('\\') == -1)
    {
      a();
      this.k = i;
      d();
      return;
    }
    this.h.a();
    h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.b.c
 * JD-Core Version:    0.6.2
 */