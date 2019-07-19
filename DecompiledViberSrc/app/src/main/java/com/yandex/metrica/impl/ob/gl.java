package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bw;
import java.util.List;

public class gl
  implements gr<hk, kt.a.a>
{
  private final gp a;
  private final gq b;

  public gl()
  {
    this(new gp(), new gq());
  }

  gl(gp paramgp, gq paramgq)
  {
    this.a = paramgp;
    this.b = paramgq;
  }

  public hk a(kt.a.a parama)
  {
    hp localhp = this.a.a(parama.b);
    long l1 = localhp.e;
    float f = localhp.f;
    int i = localhp.g;
    int j = localhp.h;
    long l2 = localhp.i;
    int k = localhp.j;
    boolean bool1 = localhp.k;
    long l3 = parama.c;
    long l4 = parama.d;
    long l5 = localhp.l;
    boolean bool2 = localhp.m;
    boolean bool3 = parama.e;
    if (bw.a(parama.f));
    for (List localList = null; ; localList = this.b.a(parama.f))
      return new hk(l1, f, i, j, l2, k, bool1, l3, l4, l5, bool2, bool3, localList);
  }

  public kt.a.a a(hk paramhk)
  {
    kt.a.a locala = new kt.a.a();
    locala.b = this.a.a(paramhk);
    locala.d = paramhk.b;
    locala.c = paramhk.a;
    locala.e = paramhk.c;
    if (paramhk.d == null);
    for (kt.a.a.a[] arrayOfa = new kt.a.a.a[0]; ; arrayOfa = this.b.a(paramhk.d))
    {
      locala.f = arrayOfa;
      return locala;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gl
 * JD-Core Version:    0.6.2
 */