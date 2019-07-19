package e.a.b.b;

import e.a.b.d.f;
import e.a.b.i;

class d extends c
{
  private String x;

  public d(int paramInt)
  {
    super(paramInt);
  }

  protected int a(char paramChar, int paramInt)
  {
    return this.x.indexOf(paramChar, paramInt);
  }

  public <T> T a(String paramString, f<T> paramf)
    throws e
  {
    this.b = paramf.q;
    this.x = paramString;
    this.w = paramString.length();
    return a(paramf);
  }

  protected void a(int paramInt1, int paramInt2)
  {
    this.j = this.x.substring(paramInt1, paramInt2);
  }

  public Object b(String paramString)
    throws e
  {
    return a(paramString, i.c.a);
  }

  protected void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= paramInt2 - 1) || (!Character.isWhitespace(this.x.charAt(paramInt1))));
    while (true)
    {
      if ((paramInt2 - 1 <= paramInt1) || (!Character.isWhitespace(this.x.charAt(paramInt2 - 1))))
      {
        a(paramInt1, paramInt2);
        return;
        paramInt1++;
        break;
      }
      paramInt2--;
    }
  }

  protected void d()
  {
    int i = 1 + this.k;
    this.k = i;
    if (i >= this.w)
    {
      this.a = '\032';
      return;
    }
    this.a = this.x.charAt(this.k);
  }

  protected void e()
    throws e
  {
    int i = 1 + this.k;
    this.k = i;
    if (i >= this.w)
    {
      this.a = '\032';
      throw new e(-1 + this.k, 3, "EOF");
    }
    this.a = this.x.charAt(this.k);
  }

  protected void f()
  {
    int i = 1 + this.k;
    this.k = i;
    if (i >= this.w)
    {
      this.a = '\032';
      return;
    }
    this.a = this.x.charAt(this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.b.d
 * JD-Core Version:    0.6.2
 */