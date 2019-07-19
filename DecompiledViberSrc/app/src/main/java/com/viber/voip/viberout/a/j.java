package com.viber.voip.viberout.a;

import com.viber.voip.api.a.b.a.d;
import com.viber.voip.api.a.b.a.m;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import com.viber.voip.viberout.ui.products.model.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class j
  implements r.a
{
  private static final String a = j.class.getSimpleName();
  private final r b;
  private final a c;
  private final List<a> d = new ArrayList();
  private final l e;

  @Inject
  public j(r paramr, a parama, l paraml)
  {
    this.b = paramr;
    this.c = parama;
    this.e = paraml;
  }

  public List<RateModel> a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.e.b(a).size()))
      return Collections.emptyList();
    return this.c.a(this.e.a(a), ((d)this.e.b(a).get(paramInt)).a());
  }

  public void a()
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).a();
  }

  public void a(a parama)
  {
    if (this.d.isEmpty())
      this.b.a(this);
    this.d.add(parama);
  }

  public void a(String paramString)
  {
    this.b.a(paramString);
  }

  public void a(List<CreditModel> paramList, int paramInt)
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).a(paramList, paramInt);
  }

  public void a(List<com.viber.voip.api.a.b.a.j> paramList, List<d> paramList1, List<m> paramList2)
  {
    this.e.a(a, paramList2);
    this.e.b(a, paramList1);
    int i = 0;
    int j = paramList1.size();
    if (i < j)
      if (!((d)paramList1.get(i)).c());
    for (int k = i; ; k = -1)
    {
      a(this.c.a(paramList1), k);
      return;
      i++;
      break;
    }
  }

  public CreditModel b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.e.b(a).size()))
      return null;
    return this.c.a((d)this.e.b(a).get(paramInt));
  }

  public void b()
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).d();
  }

  public void b(a parama)
  {
    this.d.remove(parama);
    if (this.d.isEmpty())
      this.b.b(this);
  }

  public void c()
  {
    a();
  }

  public void d()
  {
    b();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(List<CreditModel> paramList, int paramInt);

    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.j
 * JD-Core Version:    0.6.2
 */