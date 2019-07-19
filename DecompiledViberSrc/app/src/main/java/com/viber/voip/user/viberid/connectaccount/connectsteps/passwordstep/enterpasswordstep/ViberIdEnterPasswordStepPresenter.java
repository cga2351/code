package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep;

import android.os.Parcelable;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdConnectValidator.PasswordValidationStrategy;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepPresenter;
import com.viber.voip.util.cj;

class ViberIdEnterPasswordStepPresenter extends ViberIdPasswordStepPresenter<ViberIdEnterPasswordStepView>
{
  private final Logger L = ViberEnv.getLogger(getClass());

  ViberIdEnterPasswordStepPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdPasswordStepRouter paramViberIdPasswordStepRouter, cj paramcj)
  {
    super(paramViberIdController, paramViberIdPasswordStepRouter, paramcj);
  }

  private void setContinueButtonState()
  {
    ViberIdEnterPasswordStepView localViberIdEnterPasswordStepView = (ViberIdEnterPasswordStepView)this.mView;
    if ((!this.mPendingRegistration) && (this.mPassword.length() >= ViberIdConnectValidator.PasswordValidationStrategy.ENTER.getMinPasswordLength()));
    for (boolean bool = true; ; bool = false)
    {
      localViberIdEnterPasswordStepView.setContinueButtonState(bool);
      return;
    }
  }

  private void showWrongPasswordError()
  {
    ((ViberIdEnterPasswordStepView)this.mView).showWrongPasswordError();
    ((ViberIdEnterPasswordStepView)this.mView).setContinueButtonState(false);
    this.mErrorDisplayed = true;
  }

  public void attach(ViberIdEnterPasswordStepView paramViberIdEnterPasswordStepView, Parcelable paramParcelable)
  {
    super.attach(paramViberIdEnterPasswordStepView, paramParcelable);
    ((ViberIdEnterPasswordStepView)this.mView).initViewState(this.mPassword, this.mPromotionsAgreed);
    if (TextUtils.isEmpty(this.mPassword))
      ((ViberIdEnterPasswordStepView)this.mView).setContinueButtonState(false);
    while (true)
    {
      if (this.mErrorDisplayed)
        showWrongPasswordError();
      return;
      setContinueButtonState();
    }
  }

  protected void handlePasswordInvalidError()
  {
    showWrongPasswordError();
  }

  protected void handlePasswordMustMatchErrorError()
  {
    showWrongPasswordError();
  }

  protected void handlePasswordValidationError(int paramInt)
  {
    showWrongPasswordError();
  }

  protected boolean isExistingEmail()
  {
    return true;
  }

  public void onPasswordTextChanged(String paramString)
  {
    String str = this.mPassword;
    super.onPasswordTextChanged(paramString);
    if (str.equals(paramString))
      return;
    ((ViberIdEnterPasswordStepView)this.mView).hideWrongPasswordError();
    setContinueButtonState();
  }

  protected int validatePassword()
  {
    return ViberIdConnectValidator.isValidPassword(this.mEmail, this.mPassword, this.mPassword, ViberIdConnectValidator.PasswordValidationStrategy.ENTER);
  }

  void validatePasswordOnFocusLost()
  {
    int i = ViberIdConnectValidator.isValidPassword(this.mEmail, this.mPassword, this.mPassword, ViberIdConnectValidator.PasswordValidationStrategy.ENTER);
    if ((this.mPassword.length() > 0) && (i != 0))
      handlePasswordValidationError(i);
    while (this.mPromotionsAgreed)
      return;
    showPromotionsAgreedTooltip();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep.ViberIdEnterPasswordStepPresenter
 * JD-Core Version:    0.6.2
 */