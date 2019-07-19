package com.viber.voip.viberout.ui.products.coupon;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import javax.inject.Inject;

public class ViberOutCouponPresenter extends BaseMvpPresenter<a, State>
{
  private State a = new State();

  protected State a()
  {
    return this.a;
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    if (paramState != null)
    {
      this.a = paramState;
      ((a)this.mView).b(this.a.couponText);
    }
  }

  public void a(String paramString)
  {
    this.a.couponText = paramString;
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      ((a)this.mView).a();
  }

  public void b()
  {
    ((a)this.mView).a(this.a.couponText);
  }

  static class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutCouponPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutCouponPresenter.State(paramAnonymousParcel);
      }

      public ViberOutCouponPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutCouponPresenter.State[paramAnonymousInt];
      }
    };
    String couponText;

    State()
    {
      this.couponText = "";
    }

    protected State(Parcel paramParcel)
    {
      this.couponText = paramParcel.readString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.couponText);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter
 * JD-Core Version:    0.6.2
 */