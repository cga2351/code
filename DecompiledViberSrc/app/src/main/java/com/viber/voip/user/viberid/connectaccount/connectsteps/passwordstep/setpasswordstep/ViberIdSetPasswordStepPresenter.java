package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdConnectValidator.PasswordValidationStrategy;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepPresenter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepPresenter.PasswordSavedState;
import com.viber.voip.util.cj;

class ViberIdSetPasswordStepPresenter extends ViberIdPasswordStepPresenter<ViberIdSetPasswordStepView>
{
  private final Logger L = ViberEnv.getLogger(getClass());
  private boolean mRetypeErrorDisplayed = false;
  private String mRetypedPassword = "";

  ViberIdSetPasswordStepPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdPasswordStepRouter paramViberIdPasswordStepRouter, cj paramcj)
  {
    super(paramViberIdController, paramViberIdPasswordStepRouter, paramcj);
  }

  private void hidePasswordMustMatchError()
  {
    this.mRetypeErrorDisplayed = false;
    ((ViberIdSetPasswordStepView)this.mView).hidePasswordMustMatchError();
  }

  private void setContinueButtonState()
  {
    if ((!this.mPendingRegistration) && (!this.mErrorDisplayed) && (!this.mRetypeErrorDisplayed) && (this.mPassword.length() > 0) && (this.mRetypedPassword.length() > 0));
    for (boolean bool = true; ; bool = false)
    {
      ((ViberIdSetPasswordStepView)this.mView).setContinueButtonState(bool);
      return;
    }
  }

  private void setRetypeFieldState()
  {
    ViberIdSetPasswordStepView localViberIdSetPasswordStepView = (ViberIdSetPasswordStepView)this.mView;
    if (this.mPassword.length() >= ViberIdConnectValidator.PasswordValidationStrategy.CREATE.getMinPasswordLength());
    for (boolean bool = true; ; bool = false)
    {
      localViberIdSetPasswordStepView.setRetypePasswordFieldState(bool);
      return;
    }
  }

  public void attach(ViberIdSetPasswordStepView paramViberIdSetPasswordStepView, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SetPasswordSavedState))
    {
      SetPasswordSavedState localSetPasswordSavedState = (SetPasswordSavedState)paramParcelable;
      this.mRetypedPassword = localSetPasswordSavedState.retypedPassword;
      this.mRetypeErrorDisplayed = localSetPasswordSavedState.retypeErrorDisplayed;
    }
    super.attach(paramViberIdSetPasswordStepView, paramParcelable);
    paramViberIdSetPasswordStepView.initViewState(this.mPassword, this.mRetypedPassword, this.mPromotionsAgreed);
    setContinueButtonState();
    if (this.mErrorDisplayed)
      handlePasswordInvalidError();
    if (this.mRetypeErrorDisplayed)
      handlePasswordMustMatchErrorError();
    setRetypeFieldState();
  }

  public void detach()
  {
    super.detach();
    this.mRetypedPassword = "";
    this.mRetypeErrorDisplayed = false;
  }

  protected Parcelable getSavedState()
  {
    return new SetPasswordSavedState(this.mEmail, this.mErrorDisplayed, this.mRetypeErrorDisplayed, this.mPassword, this.mRetypedPassword, this.mPromotionsAgreed, this.mShowToolTip);
  }

  protected void handlePasswordInvalidError()
  {
    ((ViberIdSetPasswordStepView)this.mView).showPasswordInvalidError();
    ((ViberIdSetPasswordStepView)this.mView).setContinueButtonState(false);
    this.mErrorDisplayed = true;
  }

  protected void handlePasswordMustMatchErrorError()
  {
    ((ViberIdSetPasswordStepView)this.mView).showPasswordMustMatchError();
    ((ViberIdSetPasswordStepView)this.mView).setContinueButtonState(false);
    this.mRetypeErrorDisplayed = true;
  }

  protected void handlePasswordValidationError(int paramInt)
  {
    if ((1 == paramInt) || (2 == paramInt))
      handlePasswordInvalidError();
    while (3 != paramInt)
      return;
    handlePasswordMustMatchErrorError();
  }

  protected boolean isExistingEmail()
  {
    return false;
  }

  void onPasswordFieldFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mPassword.length() == 0));
    do
    {
      return;
      int i = ViberIdConnectValidator.isValidPassword(this.mEmail, this.mPassword, this.mPassword, ViberIdConnectValidator.PasswordValidationStrategy.CREATE);
      if (i != 0)
      {
        handlePasswordValidationError(i);
        return;
      }
    }
    while (!this.mRetypedPassword.equals(this.mPassword));
    hidePasswordMustMatchError();
    ((ViberIdSetPasswordStepView)this.mView).setContinueButtonState(true);
  }

  public void onPasswordTextChanged(String paramString)
  {
    String str = this.mPassword;
    super.onPasswordTextChanged(paramString);
    if (str.equals(paramString))
      return;
    ((ViberIdSetPasswordStepView)this.mView).hidePasswordInvalidError();
    setRetypeFieldState();
    if (this.mRetypedPassword.equals(this.mPassword))
      hidePasswordMustMatchError();
    setContinueButtonState();
  }

  void onRetypedPasswordFieldFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mRetypedPassword.length() == 0));
    do
    {
      return;
      if (!this.mRetypedPassword.equals(this.mPassword))
      {
        handlePasswordValidationError(3);
        return;
      }
    }
    while (this.mPromotionsAgreed);
    showPromotionsAgreedTooltip();
  }

  void onRetypedPasswordTextChanged(String paramString)
  {
    if (this.mRetypedPassword.equals(paramString))
      return;
    if (paramString == null)
      paramString = "";
    hidePasswordMustMatchError();
    this.mRetypedPassword = paramString;
    setContinueButtonState();
  }

  public void setPassword(String paramString)
  {
    super.setPassword(paramString);
    this.mRetypedPassword = paramString;
  }

  protected int validatePassword()
  {
    return ViberIdConnectValidator.isValidPassword(this.mEmail, this.mPassword, this.mRetypedPassword, ViberIdConnectValidator.PasswordValidationStrategy.CREATE);
  }

  static class SetPasswordSavedState extends ViberIdPasswordStepPresenter.PasswordSavedState
  {
    public static final Parcelable.Creator<SetPasswordSavedState> CREATOR = new Parcelable.Creator()
    {
      public ViberIdSetPasswordStepPresenter.SetPasswordSavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdSetPasswordStepPresenter.SetPasswordSavedState(paramAnonymousParcel);
      }

      public ViberIdSetPasswordStepPresenter.SetPasswordSavedState[] newArray(int paramAnonymousInt)
      {
        return new ViberIdSetPasswordStepPresenter.SetPasswordSavedState[paramAnonymousInt];
      }
    };
    final boolean retypeErrorDisplayed;
    final String retypedPassword;

    SetPasswordSavedState(Parcel paramParcel)
    {
      super();
      this.retypedPassword = paramParcel.readString();
      if (paramParcel.readByte() > 0);
      for (boolean bool = true; ; bool = false)
      {
        this.retypeErrorDisplayed = bool;
        return;
      }
    }

    public SetPasswordSavedState(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3, boolean paramBoolean4)
    {
      super(paramBoolean1, paramString2, paramBoolean3, paramBoolean4);
      this.retypedPassword = paramString3;
      this.retypeErrorDisplayed = paramBoolean2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.retypedPassword);
      int j;
      if (this.showToolTip)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        if (!this.retypeErrorDisplayed)
          break label53;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        j = 0;
        break;
        label53: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep.ViberIdSetPasswordStepPresenter
 * JD-Core Version:    0.6.2
 */