package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.impl.lm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static bd a(o paramo, ll paramll)
  {
    List localList1 = a(paramll.d(), paramo.c().e());
    List localList2 = a(paramll.e(), paramo.c().f());
    return new bd(paramll.c(), localList1, localList2);
  }

  public static c a(o paramo, bd parambd, bb parambb, r paramr)
  {
    return new c(paramo, new ad(new l(parambd.a(), al.a())), parambd, parambb, paramr);
  }

  public static y a(Context paramContext, o paramo, i parami, s params)
  {
    ArrayList localArrayList = new ArrayList();
    List localList1 = paramo.c().c();
    bc localbc = params.b();
    r localr1 = params.a();
    Iterator localIterator = localList1.iterator();
    while (localIterator.hasNext())
    {
      ll localll = (ll)localIterator.next();
      bb localbb = localbc.a(localll);
      u localu = new u(paramContext, localll, parami, localbb);
      List localList3 = a(localll.d(), null);
      List localList4 = a(localll.e(), null);
      c localc = a(paramo, new bd(localll.c(), localList3, localList4), localbb, localr1);
      if (NativeAdType.CONTENT == localll.b())
        localArrayList.add(new as(paramContext, localll, localu, parami, localc));
      else if (NativeAdType.APP_INSTALL == localll.b())
        localArrayList.add(new am(paramContext, localll, localu, parami, localc));
      else if (NativeAdType.IMAGE == localll.b())
        localArrayList.add(new ax(paramContext, localll, localu, parami, localc));
    }
    List localList2 = a(localArrayList);
    r localr2 = params.a();
    lm locallm = paramo.c();
    bd localbd = new bd(locallm.b(), a(null, locallm.e()), a(null, locallm.f()));
    return new aa(paramContext, localArrayList, parami, new c(paramo, new ab(localList2, new z(localbd.a(), al.a())), localbd, new ac(localbd.a()), localr2));
  }

  private static <T> List<T> a(T paramT, List<T> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramT != null)
      localArrayList.add(paramT);
    if (paramList != null)
      localArrayList.addAll(paramList);
    return localArrayList;
  }

  private static List<aw> a(List<? extends NativeGenericAd> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add((aw)localIterator.next());
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.n
 * JD-Core Version:    0.6.2
 */