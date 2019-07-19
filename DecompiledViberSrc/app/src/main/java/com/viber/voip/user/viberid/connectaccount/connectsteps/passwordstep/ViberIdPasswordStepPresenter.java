package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdRegistrationEvent;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepPresenter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepPresenter.SavedState;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.util.cj;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class ViberIdPasswordStepPresenter<V extends ViberIdPasswordStepView> extends ViberIdStepPresenter<V, ViberIdStepRouters.ViberIdPasswordStepRouter>
{
  private final Logger L = ViberEnv.getLogger(getClass());
  protected String mPassword = "";
  protected boolean mPendingRegistration;
  protected boolean mPromotionsAgreed;
  protected boolean mShowToolTip = true;

  protected ViberIdPasswordStepPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdPasswordStepRouter paramViberIdPasswordStepRouter, cj paramcj)
  {
    super(paramViberIdController, paramViberIdPasswordStepRouter, paramcj);
  }

  private void register()
  {
    int i = validatePassword();
    if (i == 0)
    {
      performActionOnConnect(new Action()
      {
        public void execute(Void paramAnonymousVoid)
        {
          ((ViberIdPasswordStepView)ViberIdPasswordStepPresenter.this.mView).showProgress();
          ViberIdPasswordStepPresenter.this.mController.registerViberId(ViberIdPasswordStepPresenter.this.mEmail, ViberIdPasswordStepPresenter.this.mPassword, ViberIdPasswordStepPresenter.this.isExistingEmail(), ViberIdPasswordStepPresenter.this.mPromotionsAgreed);
        }
      }
      , null);
      return;
    }
    handlePasswordValidationError(i);
  }

  private void showPendingRegistrationIfNeeded()
  {
    if (this.mPendingRegistration)
      ((ViberIdPasswordStepView)this.mView).showProgress();
  }

  public void attach(V paramV, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof PasswordSavedState))
    {
      PasswordSavedState localPasswordSavedState = (PasswordSavedState)paramParcelable;
      this.mPassword = localPasswordSavedState.password;
      this.mPromotionsAgreed = localPasswordSavedState.promotionsAgreed;
      this.mShowToolTip = localPasswordSavedState.showToolTip;
    }
    super.attach(paramV, paramParcelable);
    showPendingRegistrationIfNeeded();
  }

  public void detach()
  {
    super.detach();
    this.mPassword = "";
    this.mPromotionsAgreed = false;
    this.mShowToolTip = true;
  }

  protected Parcelable getSavedState()
  {
    return new PasswordSavedState(this.mEmail, this.mErrorDisplayed, this.mPassword, this.mPromotionsAgreed, this.mShowToolTip);
  }

  protected abstract void handlePasswordInvalidError();

  protected abstract void handlePasswordMustMatchErrorError();

  protected abstract void handlePasswordValidationError(int paramInt);

  protected abstract boolean isExistingEmail();

  public boolean onBackPressed()
  {
    ((ViberIdStepRouters.ViberIdPasswordStepRouter)this.mRouter).showEmailStep(this.mEmail);
    return true;
  }

  public void onContinueButtonClick()
  {
    if ((!this.mPromotionsAgreed) && (this.mShowToolTip))
    {
      showPromotionsAgreedTooltip();
      return;
    }
    register();
  }

  public void onDialog4001Action(int paramInt)
  {
    if (-1 == paramInt)
      ((ViberIdStepRouters.ViberIdPasswordStepRouter)this.mRouter).openEditInfo();
  }

  public void onDialog4005Action(int paramInt)
  {
    if (-1 == paramInt)
      ((ViberIdStepRouters.ViberIdPasswordStepRouter)this.mRouter).closeViberIdConnect();
  }

  public void onPasswordTextChanged(String paramString)
  {
    if (this.mPassword.equals(paramString))
      return;
    if (paramString == null)
      paramString = "";
    this.mPassword = paramString;
    this.mErrorDisplayed = false;
  }

  public void onPromotionCheckboxStateChanged(boolean paramBoolean)
  {
    this.mPromotionsAgreed = paramBoolean;
    if (!paramBoolean)
      showPromotionsAgreedTooltip();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdRegistrationResult(ViberIdEvents.ViberIdRegistrationEvent paramViberIdRegistrationEvent)
  {
    ((ViberIdPasswordStepView)this.mView).hideProgress();
    if (1 == paramViberIdRegistrationEvent.status)
    {
      this.mController.sendFreeStickerPackMessage();
      ((ViberIdPasswordStepView)this.mView).showCreateAccountSuccessDialog();
      return;
    }
    if (9 == paramViberIdRegistrationEvent.status)
    {
      ((ViberIdPasswordStepView)this.mView).showTooManyRequestsDialog();
      return;
    }
    if (6 == paramViberIdRegistrationEvent.status)
    {
      handlePasswordInvalidError();
      return;
    }
    if (8 == paramViberIdRegistrationEvent.status)
    {
      handlePasswordMustMatchErrorError();
      return;
    }
    ((ViberIdPasswordStepView)this.mView).showCreateAccountErrorDialog();
  }

  public void setPassword(String paramString)
  {
    this.mPassword = paramString;
    this.mPendingRegistration = true;
    this.mShowToolTip = false;
  }

  void setPromotionsAgreed(boolean paramBoolean)
  {
    this.mPromotionsAgreed = paramBoolean;
  }

  protected void showPromotionsAgreedTooltip()
  {
    if (this.mShowToolTip)
    {
      this.mShowToolTip = false;
      ((ViberIdPasswordStepView)this.mView).showPromotionsAgreedTooltip();
    }
  }

  protected abstract int validatePassword();

  public static class PasswordSavedState extends ViberIdStepPresenter.SavedState
  {
    public static final Parcelable.Creator<PasswordSavedState> CREATOR = new Parcelable.Creator()
    {
      public ViberIdPasswordStepPresenter.PasswordSavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdPasswordStepPresenter.PasswordSavedState(paramAnonymousParcel);
      }

      public ViberIdPasswordStepPresenter.PasswordSavedState[] newArray(int paramAnonymousInt)
      {
        return new ViberIdPasswordStepPresenter.PasswordSavedState[paramAnonymousInt];
      }
    };
    public final String password;
    public final boolean promotionsAgreed;
    public final boolean showToolTip;

    protected PasswordSavedState(Parcel paramParcel)
    {
      super();
      this.password = paramParcel.readString();
      boolean bool2;
      if (paramParcel.readByte() > 0)
      {
        bool2 = bool1;
        this.promotionsAgreed = bool2;
        if (paramParcel.readByte() <= 0)
          break label47;
      }
      while (true)
      {
        this.showToolTip = bool1;
        return;
        bool2 = false;
        break;
        label47: bool1 = false;
      }
    }

    public PasswordSavedState(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(paramBoolean1);
      this.password = paramString2;
      this.promotionsAgreed = paramBoolean2;
      this.showToolTip = paramBoolean3;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.password);
      if (this.promotionsAgreed);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepPresenter
 * JD-Core Version:    0.6.2
 */