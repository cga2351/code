package com.viber.voip.viberout.ui.products.countryplans;

import android.arch.lifecycle.h;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.ae;
import com.viber.voip.util.u;
import com.viber.voip.viberout.a.e.a;
import com.viber.voip.viberout.a.i;
import com.viber.voip.viberout.a.i.a;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class ViberOutCountryPlansInfoPresenter extends BaseMvpPresenter<f, State>
  implements e.a, i.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final i b;
  private final com.viber.voip.viberout.a.e c;
  private final com.viber.voip.analytics.story.m.e d;
  private CountryModel e;
  private String f = "Plans";
  private State g = new State();

  @Inject
  public ViberOutCountryPlansInfoPresenter(i parami, com.viber.voip.viberout.a.e parame, com.viber.voip.analytics.story.m.e parame1)
  {
    this.b = parami;
    this.c = parame;
    this.d = parame1;
  }

  private RateModel b(int paramInt)
  {
    List localList = this.b.a(paramInt, f());
    if (u.a(localList))
      return null;
    return (RateModel)localList.get(0);
  }

  private String f()
  {
    if (this.e != null)
      return this.e.getCode();
    return null;
  }

  public void a()
  {
    d();
  }

  public void a(int paramInt)
  {
    CreditModel localCreditModel = this.b.b(paramInt, f());
    RateModel localRateModel = b(paramInt);
    this.g.selectedCredit = localCreditModel;
    this.g.selectedOffer = paramInt;
    ((f)this.mView).a(this.g.credits, paramInt, localCreditModel, localRateModel);
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.a(this);
    this.c.a(this);
    if (paramState == null)
    {
      d();
      return;
    }
    this.g = paramState;
    if ((this.g.credits == null) || (this.g.credits.isEmpty()));
    for (int i = 1; ; i = 0)
    {
      int j;
      if (this.g.plans != null)
      {
        boolean bool = this.g.plans.isEmpty();
        j = 0;
        if (!bool);
      }
      else
      {
        j = 1;
      }
      if ((i == 0) || (j == 0))
        break;
      d();
      return;
    }
    ((f)this.mView).c();
    ((f)this.mView).a(this.g.credits, this.g.selectedOffer, this.g.selectedCredit, b(this.g.selectedOffer));
    ((f)this.mView).a(this.g.plans);
  }

  void a(CountryModel paramCountryModel)
  {
    this.e = paramCountryModel;
  }

  public void a(CreditModel paramCreditModel)
  {
    ((f)this.mView).b(paramCreditModel);
    this.d.a(paramCreditModel.getAmount());
  }

  public void a(PlanModel paramPlanModel)
  {
    ((f)this.mView).a(paramPlanModel);
  }

  void a(String paramString)
  {
    this.f = paramString;
  }

  public void a(List<CreditModel> paramList, int paramInt, List<PlanModel> paramList1)
  {
    this.g.credits = paramList;
    this.g.plans = paramList1;
    this.g.rates = this.b.a(paramInt, f());
    this.g.selectedOffer = paramInt;
    CreditModel localCreditModel = this.b.b(paramInt, f());
    if (localCreditModel != null)
      this.g.selectedCredit = localCreditModel;
    RateModel localRateModel = b(paramInt);
    ((f)this.mView).c();
    ((f)this.mView).a(this.g.credits, this.g.selectedOffer, this.g.selectedCredit, localRateModel);
    ((f)this.mView).a(this.g.plans);
    if (this.e != null)
      this.d.a(this.f, this.e.getName(), paramList.size() + paramList1.size(), ae.b());
  }

  public void b()
  {
    ((f)this.mView).a();
  }

  public void b(PlanModel paramPlanModel)
  {
    ((f)this.mView).b(paramPlanModel);
  }

  public void c()
  {
  }

  void d()
  {
    ((f)this.mView).b();
    this.b.a(f());
  }

  protected State e()
  {
    return this.g;
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.c.b(this);
  }

  static class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutCountryPlansInfoPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutCountryPlansInfoPresenter.State(paramAnonymousParcel);
      }

      public ViberOutCountryPlansInfoPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutCountryPlansInfoPresenter.State[paramAnonymousInt];
      }
    };
    List<CreditModel> credits = Collections.emptyList();
    List<PlanModel> plans = Collections.emptyList();
    List<RateModel> rates = Collections.emptyList();
    CreditModel selectedCredit;
    int selectedOffer;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      this.credits = paramParcel.createTypedArrayList(CreditModel.CREATOR);
      this.selectedOffer = paramParcel.readInt();
      this.rates = paramParcel.createTypedArrayList(RateModel.CREATOR);
      this.selectedCredit = ((CreditModel)paramParcel.readParcelable(getClass().getClassLoader()));
      this.plans = paramParcel.createTypedArrayList(PlanModel.CREATOR);
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeTypedList(this.credits);
      paramParcel.writeInt(this.selectedOffer);
      paramParcel.writeTypedList(this.rates);
      paramParcel.writeParcelable(this.selectedCredit, 0);
      paramParcel.writeTypedList(this.plans);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.ViberOutCountryPlansInfoPresenter
 * JD-Core Version:    0.6.2
 */