package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep;

import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordView;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepView;

abstract interface ViberIdEnterPasswordStepView extends ForgotPasswordView, ViberIdPasswordStepView
{
  public abstract void hideWrongPasswordError();

  public abstract void initViewState(String paramString, boolean paramBoolean);

  public abstract void showWrongPasswordError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep.ViberIdEnterPasswordStepView
 * JD-Core Version:    0.6.2
 */