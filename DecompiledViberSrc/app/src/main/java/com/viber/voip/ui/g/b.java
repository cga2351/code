package com.viber.voip.ui.g;

import com.viber.voip.ui.g.a.a;

public class b<I extends c, S extends a> extends e<I, S>
{
  private final d<I, S>[] a;

  @SafeVarargs
  public b(d<I, S>[] paramArrayOfd)
  {
    this.a = paramArrayOfd;
  }

  public void a()
  {
    super.a();
    d[] arrayOfd = this.a;
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++)
      arrayOfd[j].a();
  }

  public void a(I paramI, S paramS)
  {
    super.a(paramI, paramS);
    d[] arrayOfd = this.a;
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++)
      arrayOfd[j].a(paramI, paramS);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.g.b
 * JD-Core Version:    0.6.2
 */