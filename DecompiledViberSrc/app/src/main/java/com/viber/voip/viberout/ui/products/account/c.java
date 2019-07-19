package com.viber.voip.viberout.ui.products.account;

import android.content.res.Resources;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.api.a.b.a.b;
import com.viber.voip.api.a.b.a.i;
import com.viber.voip.api.a.b.a.k;
import com.viber.voip.api.a.b.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class c
{
  private final Resources a;
  private final com.viber.voip.viberout.ui.products.a b;

  @Inject
  public c(Resources paramResources, com.viber.voip.viberout.ui.products.a parama)
  {
    this.a = paramResources;
    this.b = parama;
  }

  private BalanceViewModel a(l paraml)
  {
    if (paraml.a() <= 0.5D);
    for (int i = R.color.credit_balance_low; ; i = R.color.credit_balance)
      return new BalanceViewModel(i, paraml.b());
  }

  private PlanViewModel a(b paramb)
  {
    Object localObject2;
    String str1;
    int j;
    String str2;
    if ("subscription".equals(paramb.d()))
    {
      Resources localResources2 = this.a;
      int k = R.string.vo_my_account_subscription;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramb.a();
      if (paramb.c().b())
      {
        localObject2 = this.a.getString(R.string.unlimited);
        arrayOfObject2[1] = localObject2;
        arrayOfObject2[2] = a(paramb.b());
        str1 = com.viber.common.d.c.a(localResources2, k, arrayOfObject2);
        j = b(paramb);
        str2 = a(paramb.c());
        if (paramb.e() == null)
          break label241;
      }
    }
    label241: for (String str3 = paramb.e().b(); ; str3 = null)
    {
      return new PlanViewModel(str1, j, paramb.c().b(), str2, str3, paramb.d());
      localObject2 = Integer.valueOf(paramb.c().a());
      break;
      Resources localResources1 = this.a;
      int i = R.string.vo_my_account_calling_plan;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramb.a();
      if (paramb.c().b());
      for (Object localObject1 = this.a.getString(R.string.unlimited); ; localObject1 = Integer.valueOf(paramb.c().a()))
      {
        arrayOfObject1[1] = localObject1;
        str1 = com.viber.common.d.c.a(localResources1, i, arrayOfObject1);
        break;
      }
    }
  }

  private String a(i parami)
  {
    if (parami.b())
      return "";
    Resources localResources = this.a;
    int i = R.string.vo_my_account_min_left;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(parami.c());
    return localResources.getString(i, arrayOfObject);
  }

  private String a(k paramk)
  {
    return this.b.a(paramk.b(), paramk.a());
  }

  private int b(b paramb)
  {
    if (paramb.c().b())
      return 100;
    return Math.round(100.0F * (paramb.c().c() / paramb.c().a()));
  }

  public AccountViewModel a(l paraml, List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(a((b)localIterator.next()));
    return new AccountViewModel(a(paraml), localArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.c
 * JD-Core Version:    0.6.2
 */