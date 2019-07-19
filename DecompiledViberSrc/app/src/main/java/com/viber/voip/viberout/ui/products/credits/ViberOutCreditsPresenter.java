package com.viber.voip.viberout.ui.products.credits;

import android.arch.lifecycle.h;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.g.a;
import com.viber.voip.viberout.a.j;
import com.viber.voip.viberout.a.j.a;
import com.viber.voip.viberout.ui.products.account.AccountViewModel;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

class ViberOutCreditsPresenter extends BaseMvpPresenter<f, State>
  implements g.a, j.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final j b;
  private final g c;
  private final e d;
  private String e;
  private State f = new State();

  @Inject
  public ViberOutCreditsPresenter(j paramj, g paramg, e parame)
  {
    this.b = paramj;
    this.c = paramg;
    this.d = parame;
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    this.f.selectedOffer = paramInt;
    this.f.rates = this.b.a(paramInt);
    ((f)this.mView).a(this.f.rates);
    CreditModel localCreditModel = this.b.b(paramInt);
    if (localCreditModel != null)
    {
      this.f.selectedCredit = localCreditModel;
      ((f)this.mView).c(localCreditModel);
    }
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.a(this);
    this.c.a(this);
    if (paramState == null)
    {
      e();
      return;
    }
    this.f = paramState;
    if ((this.f.credits == null) || (this.f.credits.isEmpty()))
    {
      e();
      return;
    }
    ((f)this.mView).b(this.f.stickyButtonPosition);
    ((f)this.mView).a(this.f.credits, this.f.selectedOffer);
    ((f)this.mView).a(this.f.rates);
    ((f)this.mView).c(this.f.selectedCredit);
    ((f)this.mView).a(this.f.isStickyButtonVisible);
  }

  public void a(CreditModel paramCreditModel)
  {
    this.d.a(paramCreditModel.getAmount());
    ((f)this.mView).b(paramCreditModel);
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(List<CreditModel> paramList, int paramInt)
  {
    this.f.credits = paramList;
    this.f.selectedOffer = paramInt;
    this.f.rates = this.b.a(paramInt);
    ((f)this.mView).a(paramList, paramInt);
    ((f)this.mView).a(this.f.rates);
    CreditModel localCreditModel = this.b.b(paramInt);
    if (localCreditModel != null)
    {
      this.f.selectedCredit = localCreditModel;
      ((f)this.mView).c(localCreditModel);
    }
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    this.f.isStickyButtonVisible = paramBoolean;
    this.f.stickyButtonPosition = paramInt;
    ((f)this.mView).a(paramBoolean);
  }

  public void b()
  {
    ((f)this.mView).a();
  }

  public void c()
  {
    ((f)this.mView).a();
  }

  public void d()
  {
  }

  public void e()
  {
    this.b.a(this.e);
  }

  protected State f()
  {
    return this.f;
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
      public ViberOutCreditsPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutCreditsPresenter.State(paramAnonymousParcel);
      }

      public ViberOutCreditsPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutCreditsPresenter.State[paramAnonymousInt];
      }
    };
    List<CreditModel> credits = Collections.emptyList();
    boolean isStickyButtonVisible;
    List<RateModel> rates = Collections.emptyList();
    CreditModel selectedCredit;
    int selectedOffer;
    int stickyButtonPosition;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      this.credits = paramParcel.createTypedArrayList(CreditModel.CREATOR);
      this.selectedOffer = paramParcel.readInt();
      this.rates = paramParcel.createTypedArrayList(RateModel.CREATOR);
      this.selectedCredit = ((CreditModel)paramParcel.readParcelable(getClass().getClassLoader()));
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isStickyButtonVisible = bool;
        this.stickyButtonPosition = paramParcel.readInt();
        return;
      }
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
      boolean bool = this.isStickyButtonVisible;
      int i = 0;
      if (bool)
        i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.stickyButtonPosition);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.ViberOutCreditsPresenter
 * JD-Core Version:    0.6.2
 */