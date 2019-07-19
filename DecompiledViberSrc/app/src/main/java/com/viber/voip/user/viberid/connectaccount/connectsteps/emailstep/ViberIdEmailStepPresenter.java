package com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep;

import android.os.Parcelable;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdEmailStatusEvent;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepPresenter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdEmailStepRouter;
import com.viber.voip.util.cj;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ViberIdEmailStepPresenter extends ViberIdStepPresenter<ViberIdEmailStepView, ViberIdStepRouters.ViberIdEmailStepRouter>
{
  private static final Logger L = ViberEnv.getLogger();

  ViberIdEmailStepPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdEmailStepRouter paramViberIdEmailStepRouter, cj paramcj)
  {
    super(paramViberIdController, paramViberIdEmailStepRouter, paramcj);
  }

  private void checkEmailStatus()
  {
    if (ViberIdConnectValidator.isValidEmail(this.mEmail))
    {
      performActionOnConnect(new Action()
      {
        public void execute(Void paramAnonymousVoid)
        {
          ((ViberIdEmailStepView)ViberIdEmailStepPresenter.this.mView).showProgress();
          ViberIdEmailStepPresenter.this.mController.checkEmailStatus(ViberIdEmailStepPresenter.this.mEmail);
        }
      }
      , null);
      return;
    }
    handleInvalidEmail();
  }

  private void handleInvalidEmail()
  {
    this.mErrorDisplayed = true;
    ((ViberIdEmailStepView)this.mView).showEmailNotValidMessage();
    ((ViberIdEmailStepView)this.mView).setContinueButtonState(false);
  }

  private void setContinueButtonState()
  {
    ViberIdEmailStepView localViberIdEmailStepView = (ViberIdEmailStepView)this.mView;
    if (this.mEmail.length() > 0);
    for (boolean bool = true; ; bool = false)
    {
      localViberIdEmailStepView.setContinueButtonState(bool);
      return;
    }
  }

  public void attach(ViberIdEmailStepView paramViberIdEmailStepView, Parcelable paramParcelable)
  {
    super.attach(paramViberIdEmailStepView, paramParcelable);
    if (TextUtils.isEmpty(this.mEmail))
    {
      ((ViberIdEmailStepView)this.mView).setContinueButtonState(false);
      ((ViberIdEmailStepView)this.mView).initEmail();
    }
    while (true)
    {
      if (this.mErrorDisplayed)
        handleInvalidEmail();
      return;
      setContinueButtonState();
      ((ViberIdEmailStepView)this.mView).setEmail(this.mEmail);
    }
  }

  public void detach()
  {
    super.detach();
    this.mController.cancelEmailStatusCheck();
  }

  public void onContinueButtonClick()
  {
    checkEmailStatus();
  }

  void onEmailFieldFocusChanged(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mEmail.length() > 0) && (!ViberIdConnectValidator.isValidEmail(this.mEmail)))
      handleInvalidEmail();
  }

  void onEmailTextChanged(String paramString)
  {
    if (this.mEmail.equals(paramString))
      return;
    if (paramString == null)
      paramString = "";
    this.mEmail = paramString;
    this.mErrorDisplayed = false;
    ((ViberIdEmailStepView)this.mView).hideEmailNotValidMessage();
    setContinueButtonState();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdEmailStatusReceived(ViberIdEvents.ViberIdEmailStatusEvent paramViberIdEmailStatusEvent)
  {
    ((ViberIdEmailStepView)this.mView).hideProgress();
    if (3 == paramViberIdEmailStatusEvent.status)
    {
      ((ViberIdStepRouters.ViberIdEmailStepRouter)this.mRouter).showSetPasswordStep(paramViberIdEmailStatusEvent.email, paramViberIdEmailStatusEvent.promotionsAgreed);
      return;
    }
    if (4 == paramViberIdEmailStatusEvent.status)
    {
      ((ViberIdStepRouters.ViberIdEmailStepRouter)this.mRouter).showEnterPasswordStep(paramViberIdEmailStatusEvent.email, paramViberIdEmailStatusEvent.promotionsAgreed);
      return;
    }
    if (5 == paramViberIdEmailStatusEvent.status)
    {
      handleInvalidEmail();
      return;
    }
    if (6 == paramViberIdEmailStatusEvent.status)
    {
      ((ViberIdEmailStepView)this.mView).showEmailAttemptsExceededError();
      return;
    }
    ((ViberIdEmailStepView)this.mView).showEmailStatusErrorDialog();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.ViberIdEmailStepPresenter
 * JD-Core Version:    0.6.2
 */