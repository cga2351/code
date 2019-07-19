package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.br.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ha
  implements gr<mw, kt.a>
{
  private gp a = new gp();
  private gl b = new gl();
  private gz c = new gz();
  private gw d = new gw();
  private go e = new go();
  private gt f = new gt();
  private hb g = new hb();
  private gx h = new gx();

  public kt.a a(mw parammw)
  {
    kt.a locala = new kt.a();
    locala.B = parammw.A;
    locala.C = parammw.B;
    if (parammw.a != null)
      locala.b = parammw.a;
    if (parammw.b != null)
      locala.y = parammw.b;
    if (parammw.c != null)
      locala.z = parammw.c;
    if (parammw.i != null)
      locala.h = ((String[])parammw.i.toArray(new String[parammw.i.size()]));
    if (parammw.j != null)
      locala.i = ((String[])parammw.j.toArray(new String[parammw.j.size()]));
    if (parammw.d != null)
      locala.d = ((String[])parammw.d.toArray(new String[parammw.d.size()]));
    if (parammw.h != null)
      locala.g = ((String[])parammw.h.toArray(new String[parammw.h.size()]));
    if (parammw.k != null)
      locala.t = ((String[])parammw.k.toArray(new String[parammw.k.size()]));
    if (parammw.o != null)
      locala.k = this.a.a(parammw.o);
    if (parammw.p != null)
      locala.l = this.b.a(parammw.p);
    if (parammw.q != null)
      locala.m = this.c.a(parammw.q);
    if (parammw.l != null)
      locala.o = parammw.l;
    if (parammw.e != null)
      locala.e = parammw.e;
    if (parammw.f != null)
      locala.f = parammw.f;
    if (parammw.g != null)
      locala.A = parammw.g;
    if (parammw.r != null)
      locala.r = parammw.r;
    locala.j = this.e.a(parammw.n);
    if (parammw.m != null)
      locala.p = parammw.m;
    locala.q = parammw.u;
    locala.c = parammw.s;
    locala.v = parammw.t;
    if (parammw.v != null)
    {
      List localList = parammw.v;
      kt.a.e[] arrayOfe = new kt.a.e[localList.size()];
      Iterator localIterator = localList.iterator();
      for (int i = 0; localIterator.hasNext(); i++)
      {
        br.a locala1 = (br.a)localIterator.next();
        arrayOfe[i] = this.d.a(locala1);
      }
      locala.n = arrayOfe;
    }
    if (parammw.w != null)
      locala.s = parammw.w;
    if (parammw.y != null)
      locala.w = this.f.a(parammw.y);
    if (parammw.z != null)
      locala.x = this.h.a(parammw.z);
    if (parammw.x != null)
      locala.u = this.g.a(parammw.x);
    locala.D = parammw.C;
    return locala;
  }

  public mw a(kt.a parama)
  {
    mw.a locala1 = new mw.a(this.e.a(parama.j)).a(parama.b).b(parama.y).c(parama.z).g(parama.o).d(parama.e).a(Arrays.asList(parama.d)).b(Arrays.asList(parama.g)).d(Arrays.asList(parama.i)).c(Arrays.asList(parama.h)).e(parama.f).f(parama.A).e(Arrays.asList(parama.t)).i(parama.r).h(parama.p).b(parama.q).a(parama.c).a(parama.v);
    kt.a.e[] arrayOfe = parama.n;
    ArrayList localArrayList = new ArrayList(arrayOfe.length);
    int i = arrayOfe.length;
    for (int j = 0; j < i; j++)
    {
      kt.a.e locale = arrayOfe[j];
      localArrayList.add(this.d.a(locale));
    }
    mw.a locala2 = locala1.f(localArrayList).b(parama.B).c(parama.C).j(parama.s).c(parama.D);
    if (parama.k != null)
      locala2.a(this.a.a(parama.k));
    if (parama.l != null)
      locala2.a(this.b.a(parama.l));
    if (parama.m != null)
      locala2.a(this.c.a(parama.m));
    if (parama.w != null)
      locala2.g(this.f.a(parama.w));
    if (parama.x != null)
      locala2.a(this.h.a(parama.x));
    if (parama.u != null)
      locala2.a(this.g.a(parama.u));
    return locala2.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ha
 * JD-Core Version:    0.6.2
 */