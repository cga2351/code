package com.viber.voip.viberout.a;

import com.viber.voip.api.a.b.a.d;
import com.viber.voip.api.a.b.a.j;
import com.viber.voip.api.a.b.a.m;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class p
  implements r.a
{
  private final r a;
  private final a b;
  private final List<a> c = new ArrayList();

  @Inject
  public p(r paramr, a parama)
  {
    this.a = paramr;
    this.b = parama;
  }

  private void a(String paramString, List<j> paramList, Map<String, List<PlanModel>> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (!localj.k())
        break;
      PlanModel localPlanModel = this.b.a(localj);
      localIterator.remove();
      localArrayList.add(localPlanModel);
      paramMap.put(paramString, localArrayList);
    }
  }

  private void b()
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).d();
  }

  public void a()
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).e();
  }

  public void a(a parama)
  {
    if (this.c.isEmpty())
      this.a.a(this);
    this.c.add(parama);
  }

  public void a(String paramString)
  {
    this.a.a(paramString);
  }

  public void a(Collection<List<PlanModel>> paramCollection, boolean paramBoolean)
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).a(paramCollection, paramBoolean);
  }

  public void a(List<j> paramList, List<d> paramList1, List<m> paramList2)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ArrayList localArrayList = new ArrayList(paramList);
    a("grouping_of_first_multiple_destination_key", localArrayList, localLinkedHashMap);
    Iterator localIterator = localArrayList.iterator();
    boolean bool1 = false;
    boolean bool2;
    if (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.k())
        break label198;
      Object localObject = (List)localLinkedHashMap.get(localj.a());
      if (localObject == null)
      {
        localObject = new ArrayList();
        localLinkedHashMap.put(localj.a(), localObject);
      }
      PlanModel localPlanModel = this.b.a(localj);
      localIterator.remove();
      ((List)localObject).add(localPlanModel);
      if ((bool1) || (localPlanModel.isUnlimited()))
        bool2 = true;
    }
    while (true)
    {
      bool1 = bool2;
      break;
      bool2 = false;
      continue;
      a("grouping_of_last_multiple_destination_key", localArrayList, localLinkedHashMap);
      a(localLinkedHashMap.values(), bool1);
      return;
      label198: bool2 = bool1;
    }
  }

  public void b(a parama)
  {
    this.c.remove(parama);
    if (this.c.isEmpty())
      this.a.b(this);
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
    public abstract void a(Collection<List<PlanModel>> paramCollection, boolean paramBoolean);

    public abstract void d();

    public abstract void e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.p
 * JD-Core Version:    0.6.2
 */