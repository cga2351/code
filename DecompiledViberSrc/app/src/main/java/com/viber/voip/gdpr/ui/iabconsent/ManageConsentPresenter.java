package com.viber.voip.gdpr.ui.iabconsent;

import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.gdpr.a.a;
import com.viber.voip.gdpr.a.a.a;
import com.viber.voip.gdpr.a.a.b;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.ViberActionRunner.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ManageConsentPresenter extends BaseMvpPresenter<i, State>
  implements d
{
  private static final Logger a = ViberEnv.getLogger("ManageConsentPresenter");
  private final a b;
  private List<p> c;
  private List<r> d;

  public ManageConsentPresenter(a parama)
  {
    this.b = parama;
  }

  private void a()
  {
    this.c = new ArrayList(a.a.values().length);
    for (a.a locala : a.a.values())
    {
      boolean bool2 = this.b.a(locala);
      this.c.add(new a(locala, bool2, null));
    }
    List localList = this.b.a();
    this.d = new ArrayList(a.a.values().length);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      boolean bool1 = this.b.a(localb);
      this.d.add(new b(localb, bool1, null));
    }
    ((i)this.mView).a(this.c);
    ((i)this.mView).b(this.d);
  }

  public void a(int paramInt)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    Iterator localIterator1 = this.c.iterator();
    while (localIterator1.hasNext())
    {
      p localp = (p)localIterator1.next();
      localArrayMap1.put(localp.a(), Boolean.valueOf(localp.b()));
    }
    ArrayMap localArrayMap2 = new ArrayMap();
    Iterator localIterator2 = this.d.iterator();
    while (localIterator2.hasNext())
    {
      r localr = (r)localIterator2.next();
      localArrayMap2.put(localr.a(), Boolean.valueOf(localr.b()));
    }
    this.b.a(localArrayMap1, localArrayMap2, paramInt);
    ((i)this.mView).a();
  }

  public void a(a.b paramb)
  {
    OpenUrlAction localOpenUrlAction = new OpenUrlAction(paramb.b());
    localOpenUrlAction.setIsExternal(false);
    ViberActionRunner.ae.a(ViberApplication.getApplication(), false, localOpenUrlAction);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    a();
  }

  private static class a
    implements p
  {
    private final a.a a;
    private boolean b;

    private a(a.a parama, boolean paramBoolean)
    {
      this.a = parama;
      this.b = paramBoolean;
    }

    public a.a a()
    {
      return this.a;
    }

    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public boolean b()
    {
      return this.b;
    }
  }

  private static class b
    implements r
  {
    private final a.b a;
    private boolean b;

    private b(a.b paramb, boolean paramBoolean)
    {
      this.a = paramb;
      this.b = paramBoolean;
    }

    public a.b a()
    {
      return this.a;
    }

    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public boolean b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.ManageConsentPresenter
 * JD-Core Version:    0.6.2
 */