package com.viber.voip.viberout.ui.products.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class AccountViewModel
  implements Parcelable
{
  public static final Parcelable.Creator<AccountViewModel> CREATOR = new Parcelable.Creator()
  {
    public AccountViewModel a(Parcel paramAnonymousParcel)
    {
      return new AccountViewModel(paramAnonymousParcel);
    }

    public AccountViewModel[] a(int paramAnonymousInt)
    {
      return new AccountViewModel[paramAnonymousInt];
    }
  };
  private final BalanceViewModel mBalance;
  private final List<PlanViewModel> mPlans;

  protected AccountViewModel(Parcel paramParcel)
  {
    this.mBalance = ((BalanceViewModel)paramParcel.readParcelable(BalanceViewModel.class.getClassLoader()));
    this.mPlans = paramParcel.createTypedArrayList(PlanViewModel.CREATOR);
  }

  public AccountViewModel(BalanceViewModel paramBalanceViewModel, List<PlanViewModel> paramList)
  {
    this.mBalance = paramBalanceViewModel;
    this.mPlans = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public BalanceViewModel getBalance()
  {
    return this.mBalance;
  }

  public List<PlanViewModel> getPlans()
  {
    return this.mPlans;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mBalance, paramInt);
    paramParcel.writeTypedList(this.mPlans);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.AccountViewModel
 * JD-Core Version:    0.6.2
 */