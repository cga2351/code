package com.viber.voip.viberout.ui.products.search.country;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.u;
import com.viber.voip.viberout.a.n;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class ViberOutCountrySearchPresenter extends BaseMvpPresenter<b, State>
{
  private final n a;
  private final Handler b;
  private State c = new State();

  @Inject
  ViberOutCountrySearchPresenter(n paramn, Handler paramHandler)
  {
    this.a = paramn;
    this.b = paramHandler;
  }

  private void c(List<CountryModel> paramList)
  {
    this.b.post(new j(this, paramList));
  }

  public void a()
  {
    ((b)this.mView).a();
    this.b.post(new i(this));
  }

  public void a(CountryModel paramCountryModel)
  {
    ((b)this.mView).a(paramCountryModel);
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    if (paramState != null)
    {
      this.c = paramState;
      if (!u.a(this.c.mCountries))
        c(this.c.mCountries);
    }
  }

  void a(CharSequence paramCharSequence)
  {
    State.access$102(this.c, paramCharSequence);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      a();
  }

  protected State b()
  {
    return this.c;
  }

  public static final class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutCountrySearchPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutCountrySearchPresenter.State(paramAnonymousParcel);
      }

      public ViberOutCountrySearchPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutCountrySearchPresenter.State[paramAnonymousInt];
      }
    };
    private List<CountryModel> mCountries;
    private CharSequence mSearchText;

    public State()
    {
      this(Collections.emptyList(), "");
    }

    protected State(Parcel paramParcel)
    {
      super();
      this.mCountries = paramParcel.createTypedArrayList(CountryModel.CREATOR);
      this.mSearchText = paramParcel.readString();
    }

    public State(List<CountryModel> paramList, CharSequence paramCharSequence)
    {
      this.mCountries = paramList;
      this.mSearchText = paramCharSequence;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeTypedList(this.mCountries);
      paramParcel.writeString(this.mSearchText.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter
 * JD-Core Version:    0.6.2
 */