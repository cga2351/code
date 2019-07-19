package com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep;

import com.viber.voip.user.viberid.connectaccount.connectsteps.StepView;

abstract interface ViberIdEmailStepView extends StepView
{
  public abstract void hideEmailNotValidMessage();

  public abstract void initEmail();

  public abstract void setEmail(String paramString);

  public abstract void showEmailAttemptsExceededError();

  public abstract void showEmailNotValidMessage();

  public abstract void showEmailStatusErrorDialog();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.ViberIdEmailStepView
 * JD-Core Version:    0.6.2
 */