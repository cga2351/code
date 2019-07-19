package com.viber.voip.apps;

import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.CGetAppDetails;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.apps.AppsController;
import com.viber.jni.apps.AppsControllerDelegate.AppDetailsReceiver;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.g;
import com.viber.voip.util.cu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class h
  implements AppsControllerDelegate.AppDetailsReceiver
{
  private static final Logger a = ViberEnv.getLogger();
  private final AppsController b;
  private final a c;
  private final cu<b> d;

  public h(AppsController paramAppsController)
  {
    this.b = paramAppsController;
    this.c = new a();
    this.d = new cu(5);
  }

  private c a(List<Integer> paramList)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.c.a(paramList).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (a(localb))
        localArrayList2.add(Integer.valueOf(localb.a()));
      if (localb.h())
        localArrayList3.add(localb);
      localArrayList1.remove(Integer.valueOf(localb.a()));
    }
    b(localArrayList1);
    localArrayList2.addAll(localArrayList1);
    return new c(localArrayList3, localArrayList2, null);
  }

  private void a(int paramInt, b paramb)
  {
    this.d.put(paramInt, paramb);
  }

  private void a(c paramc, a parama)
  {
    List localList = paramc.b();
    if (localList.isEmpty())
    {
      if (parama != null)
        parama.onAppInfoReady(Collections.emptyList(), false);
      return;
    }
    final int[] arrayOfInt = new int[localList.size()];
    Iterator localIterator = localList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Integer localInteger = (Integer)localIterator.next();
      j = i + 1;
      arrayOfInt[i] = localInteger.intValue();
    }
    final b localb = new b(parama, paramc.a());
    ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
    {
      public void initialized(Engine paramAnonymousEngine)
      {
        int i = paramAnonymousEngine.getPhoneController().generateSequence();
        h.a(h.this, i, localb);
        h.a(h.this).handleGetAppDetails(arrayOfInt, i);
      }
    });
  }

  private boolean a(b paramb)
  {
    return !paramb.h();
  }

  private void b(int paramInt, a parama)
  {
    a(Collections.singletonList(Integer.valueOf(paramInt)), parama);
  }

  private void b(List<Integer> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.c.a(b.a(localInteger.intValue()));
    }
  }

  public b a(int paramInt)
  {
    b localb = this.c.a(paramInt);
    if ((localb != null) && (!a(localb)))
      return localb;
    return null;
  }

  public void a()
  {
    this.c.d();
    d.g.a.a(false);
  }

  public void a(int paramInt, a parama)
  {
    b localb = this.c.a(paramInt);
    if (localb == null)
      localb = b.a(paramInt);
    localb.a(true);
    this.c.a(localb);
    if (!localb.h())
      b(paramInt, parama);
  }

  public void a(int paramInt, boolean paramBoolean, a parama)
  {
    a(Collections.singletonList(Integer.valueOf(paramInt)), paramBoolean, parama);
  }

  public void a(a parama)
  {
    List localList = this.c.c();
    a(new c(Collections.emptyList(), localList, null), parama);
  }

  public void a(List<Integer> paramList, a parama)
  {
    a(new c(Collections.emptyList(), paramList, null), parama);
  }

  public void a(List<Integer> paramList, boolean paramBoolean, a parama)
  {
    if (paramList.isEmpty())
      if (parama != null)
        parama.onAppInfoReady(Collections.emptyList(), false);
    c localc;
    do
    {
      return;
      localc = a(paramList);
      if ((localc.a().size() != paramList.size()) && (paramBoolean))
        break;
    }
    while (parama == null);
    parama.onAppInfoReady(localc.a(), true);
    return;
    a(localc, parama);
  }

  public void onGetAppDetails(CGetAppDetails[] paramArrayOfCGetAppDetails, int paramInt1, int paramInt2)
  {
    b localb = (b)this.d.get(paramInt1);
    if (localb != null)
    {
      this.d.remove(paramInt1);
      localb.onGetAppDetails(paramArrayOfCGetAppDetails, paramInt1, paramInt2);
    }
  }

  public static abstract interface a
  {
    public abstract void onAppInfoFailed();

    public abstract void onAppInfoReady(List<b> paramList, boolean paramBoolean);
  }

  private final class b
    implements AppsControllerDelegate.AppDetailsReceiver
  {
    private final h.a b;
    private final List<b> c;

    public b(List<b> arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.c = localObject2;
    }

    public void onGetAppDetails(CGetAppDetails[] paramArrayOfCGetAppDetails, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0)
      {
        localLinkedHashSet = new LinkedHashSet(this.c.size() + paramArrayOfCGetAppDetails.length);
        if (!this.c.isEmpty())
          localLinkedHashSet.addAll(this.c);
        i = paramArrayOfCGetAppDetails.length;
        for (j = 0; j < i; j++)
        {
          localb = new b(paramArrayOfCGetAppDetails[j]);
          h.b(h.this).b(localb);
          if (localb.h())
            localLinkedHashSet.add(localb);
        }
        if (this.b != null)
          this.b.onAppInfoReady(new ArrayList(localLinkedHashSet), false);
      }
      while (this.b == null)
      {
        LinkedHashSet localLinkedHashSet;
        int i;
        int j;
        b localb;
        return;
      }
      this.b.onAppInfoFailed();
    }
  }

  public static class c extends Pair<List<b>, List<Integer>>
  {
    private c(List<b> paramList, List<Integer> paramList1)
    {
      super(paramList1);
    }

    public List<b> a()
    {
      return (List)this.first;
    }

    public List<Integer> b()
    {
      return (List)this.second;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.h
 * JD-Core Version:    0.6.2
 */