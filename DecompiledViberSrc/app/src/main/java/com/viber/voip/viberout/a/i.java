package com.viber.voip.viberout.a;

import com.viber.voip.api.a.b.a.d;
import com.viber.voip.api.a.b.a.j;
import com.viber.voip.api.a.b.a.m;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import com.viber.voip.viberout.ui.products.model.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class i
{
  private static final String a = i.class.getSimpleName();
  private final t b;
  private final a c;
  private final l d;
  private final List<a> e = new ArrayList();

  @Inject
  public i(t paramt, a parama, l paraml)
  {
    this.b = paramt;
    this.c = parama;
    this.d = paraml;
  }

  private List<PlanModel> a(List<j> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      localArrayList.add(this.c.a(localj));
    }
    return localArrayList;
  }

  private String b(String paramString)
  {
    return a + "_" + paramString;
  }

  public List<RateModel> a(int paramInt, String paramString)
  {
    List localList1 = this.d.b(b(paramString));
    List localList2 = this.d.a(b(paramString));
    if ((paramInt < 0) || (localList1 == null) || (paramInt >= localList1.size()))
      return Collections.emptyList();
    return this.c.a(localList2, ((d)localList1.get(paramInt)).a());
  }

  public void a()
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((a)this.e.get(j)).b();
  }

  public void a(a parama)
  {
    this.e.add(parama);
  }

  public void a(final String paramString)
  {
    this.b.b(paramString, new t.c()
    {
      public void a()
      {
        i.this.a();
      }

      public void a(List<j> paramAnonymousList, List<d> paramAnonymousList1, List<m> paramAnonymousList2)
      {
        i.a(i.this).a(i.a(i.this, paramString), paramAnonymousList2);
        i.a(i.this).b(i.a(i.this, paramString), paramAnonymousList1);
        List localList1 = i.a(i.this, paramAnonymousList);
        List localList2 = i.b(i.this).a(paramAnonymousList1);
        int i = 0;
        int j = paramAnonymousList1.size();
        if (i < j)
          if (!((d)paramAnonymousList1.get(i)).c());
        for (int k = i; ; k = -1)
        {
          i.this.a(localList2, k, localList1);
          return;
          i++;
          break;
        }
      }

      public void b()
      {
        i.this.b();
      }
    });
  }

  public void a(List<CreditModel> paramList, int paramInt, List<PlanModel> paramList1)
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((a)this.e.get(j)).a(paramList, paramInt, paramList1);
  }

  public CreditModel b(int paramInt, String paramString)
  {
    List localList = this.d.b(b(paramString));
    if ((paramInt < 0) || (paramInt >= localList.size()))
      return null;
    return this.c.a((d)localList.get(paramInt));
  }

  public void b()
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((a)this.e.get(j)).c();
  }

  public void b(a parama)
  {
    this.e.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void a(List<CreditModel> paramList, int paramInt, List<PlanModel> paramList1);

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.i
 * JD-Core Version:    0.6.2
 */