package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import org.greenrobot.eventbus.EventBus;

public abstract class ViberIdStepPresenter<V extends StepView, R extends ViberIdStepRouters.ViberIdBaseStepRouter>
{
  protected final ViberIdController mController;
  protected String mEmail = "";
  protected boolean mErrorDisplayed = false;
  private final cj mReachability;
  protected final R mRouter;
  protected V mView = (StepView)cl.c(getClass());

  public ViberIdStepPresenter(ViberIdController paramViberIdController, R paramR, cj paramcj)
  {
    this.mController = paramViberIdController;
    this.mRouter = paramR;
    this.mReachability = paramcj;
  }

  public void attach(V paramV, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      SavedState localSavedState = (SavedState)paramParcelable;
      this.mEmail = localSavedState.email;
      this.mErrorDisplayed = localSavedState.errorDisplayed;
    }
    this.mView = paramV;
    this.mController.getEventBus().register(this);
  }

  public void detach()
  {
    this.mView = ((StepView)cl.c(getClass()));
    this.mController.getEventBus().unregister(this);
    this.mEmail = "";
    this.mErrorDisplayed = false;
  }

  protected Parcelable getSavedState()
  {
    return new SavedState(this.mEmail, this.mErrorDisplayed);
  }

  void handleFocusOutClick()
  {
    this.mView.handleOutsideClick();
  }

  public void onContinueButtonClick()
  {
  }

  protected <Param> void performActionOnConnect(Action<Param> paramAction, Param paramParam)
  {
    new ConnectionAwareAction(paramAction, this.mView, this.mReachability).execute(paramParam);
  }

  public void setEmail(String paramString)
  {
    if (paramString != null)
      this.mEmail = paramString;
  }

  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ViberIdStepPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdStepPresenter.SavedState(paramAnonymousParcel);
      }

      public ViberIdStepPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ViberIdStepPresenter.SavedState[paramAnonymousInt];
      }
    };
    public final String email;
    public final boolean errorDisplayed;

    protected SavedState(Parcel paramParcel)
    {
      this.email = paramParcel.readString();
      if (paramParcel.readByte() > 0);
      for (boolean bool = true; ; bool = false)
      {
        this.errorDisplayed = bool;
        return;
      }
    }

    public SavedState(String paramString, boolean paramBoolean)
    {
      this.email = paramString;
      this.errorDisplayed = paramBoolean;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.email);
      if (this.errorDisplayed);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepPresenter
 * JD-Core Version:    0.6.2
 */