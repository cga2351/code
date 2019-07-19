package com.viber.voip.user.viberid.connectaccount.connectsteps;

import com.viber.common.dialogs.m.c;
import com.viber.voip.user.actions.ConnectionAwareAction.ConnectionAwareView;

public abstract interface StepView extends m.c, ConnectionAwareAction.ConnectionAwareView
{
  public abstract void handleOutsideClick();

  public abstract void hideProgress();

  public abstract void setContinueButtonState(boolean paramBoolean);

  public abstract void showProgress();

  public abstract void showRegistrationGeneralError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.StepView
 * JD-Core Version:    0.6.2
 */