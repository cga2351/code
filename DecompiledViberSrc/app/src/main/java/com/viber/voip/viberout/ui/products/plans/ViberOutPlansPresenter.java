package com.viber.voip.viberout.ui.products.plans;

import android.arch.lifecycle.h;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.viberout.a.e;
import com.viber.voip.viberout.a.e.a;
import com.viber.voip.viberout.a.g.a;
import com.viber.voip.viberout.a.p;
import com.viber.voip.viberout.a.p.a;
import com.viber.voip.viberout.ui.products.account.AccountViewModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

class ViberOutPlansPresenter extends BaseMvpPresenter<k, State>
  implements e.a, g.a, p.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final p b;
  private final e c;
  private final com.viber.voip.viberout.a.g d;
  private final com.viber.voip.analytics.g e;
  private State f = new State();
  private String g;

  @Inject
  public ViberOutPlansPresenter(p paramp, e parame, com.viber.voip.viberout.a.g paramg, com.viber.voip.analytics.g paramg1)
  {
    this.b = paramp;
    this.c = parame;
    this.d = paramg;
    this.e = paramg1;
  }

  public void a()
  {
    f();
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
  }

  public void a(PlanModel paramPlanModel)
  {
    ((k)this.mView).a(paramPlanModel);
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.a(this);
    this.c.a(this);
    this.d.a(this);
    if (paramState == null)
    {
      f();
      return;
    }
    this.f = paramState;
    if ((this.f.plans == null) || (this.f.plans.isEmpty()))
    {
      f();
      return;
    }
    ((k)this.mView).a(this.f.plans, this.f.hasUnlimitedPlans);
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public void a(Collection<List<PlanModel>> paramCollection, boolean paramBoolean)
  {
    this.f.plans = paramCollection;
    this.f.hasUnlimitedPlans = paramBoolean;
    ((k)this.mView).a(paramCollection, paramBoolean);
  }

  public void b()
  {
    ((k)this.mView).a();
  }

  public void b(PlanModel paramPlanModel)
  {
    ((k)this.mView).b(paramPlanModel);
  }

  public void c()
  {
    ((k)this.mView).a();
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
    this.b.a(this.g);
  }

  protected State g()
  {
    return this.f;
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.c.b(this);
    this.d.b(this);
  }

  static class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutPlansPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutPlansPresenter.State(paramAnonymousParcel);
      }

      public ViberOutPlansPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutPlansPresenter.State[paramAnonymousInt];
      }
    };
    boolean hasUnlimitedPlans;
    Collection<List<PlanModel>> plans = Collections.emptyList();

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      ArrayList localArrayList = new ArrayList();
      paramParcel.readList(localArrayList, getClass().getClassLoader());
      this.plans = localArrayList;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeList(new ArrayList(this.plans));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.ViberOutPlansPresenter
 * JD-Core Version:    0.6.2
 */