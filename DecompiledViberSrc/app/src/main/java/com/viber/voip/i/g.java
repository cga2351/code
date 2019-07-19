package com.viber.voip.i;

import com.viber.common.b.a;
import com.viber.common.b.h;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.bz;

class g extends f
{
  protected h h;
  private d.al i;

  g(String paramString1, String paramString2, int[] paramArrayOfInt, String[] paramArrayOfString, int paramInt, d[] paramArrayOfd)
  {
    super(paramString1, paramString2, paramArrayOfInt, paramArrayOfString, paramInt, paramArrayOfd);
  }

  g(String paramString1, String paramString2, d[] paramArrayOfd)
  {
    super(paramString1, paramString2, paramArrayOfd);
  }

  private d.al n()
  {
    if (this.i == null)
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = this.h;
      this.i = new d.al(arrayOfa)
      {
        public void onPreferencesChanged(a paramAnonymousa)
        {
          g.this.m();
        }
      };
    }
    return this.i;
  }

  protected int a()
  {
    return this.d;
  }

  protected int g()
  {
    int j = bz.a(this.h.d(), this.d);
    if (this.d == j)
      j = this.d;
    while (l())
      return j;
    return this.d;
  }

  public final int h()
  {
    return bz.a(this.h.d(), this.d);
  }

  protected void k()
  {
    super.k();
    this.h = new h(this.e, String.valueOf(a()));
    com.viber.voip.settings.d.a(n());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.g
 * JD-Core Version:    0.6.2
 */