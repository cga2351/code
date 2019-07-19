package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep;

import com.viber.voip.user.viberid.connectaccount.connectsteps.StepView;

public abstract interface ViberIdPasswordStepView extends StepView
{
  public abstract void showCreateAccountErrorDialog();

  public abstract void showCreateAccountSuccessDialog();

  public abstract void showEmailWasSentDialog();

  public abstract void showPromotionsAgreedTooltip();

  public abstract void showTooManyRequestsDialog();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepView
 * JD-Core Version:    0.6.2
 */