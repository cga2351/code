package com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep;

import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountView;

abstract interface RetypePasswordDialogView extends DisconnectAccountView
{
  public abstract void closeRetypePasswordDialog();

  public abstract void hidePasswordDialogProgress();

  public abstract void hideWrongPasswordError();

  public abstract void setDialogButtonsState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

  public abstract void setDialogPassword(String paramString);

  public abstract void setRetypeDialogCancelableState(boolean paramBoolean);

  public abstract void showPasswordDialogProgress();

  public abstract void showRetypePasswordAttemptsExceededError();

  public abstract void showRetypePasswordDialog(String paramString);

  public abstract void showRetypePasswordGeneralError();

  public abstract void showWrongPasswordError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.RetypePasswordDialogView
 * JD-Core Version:    0.6.2
 */