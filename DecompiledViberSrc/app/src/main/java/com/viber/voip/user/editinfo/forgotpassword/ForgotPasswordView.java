package com.viber.voip.user.editinfo.forgotpassword;

import com.viber.voip.user.actions.ConnectionAwareAction.ConnectionAwareView;

public abstract interface ForgotPasswordView extends ConnectionAwareAction.ConnectionAwareView
{
  public abstract void showEmailWasSentDialog();

  public abstract void showGenericError();

  public abstract void showTooManyRequestsError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordView
 * JD-Core Version:    0.6.2
 */