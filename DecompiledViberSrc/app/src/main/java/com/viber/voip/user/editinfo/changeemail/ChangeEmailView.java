package com.viber.voip.user.editinfo.changeemail;

import com.viber.voip.user.actions.ConnectionAwareAction.ConnectionAwareView;
import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountView;

public abstract interface ChangeEmailView extends ConnectionAwareAction.ConnectionAwareView, DisconnectAccountView
{
  public abstract void hideProgress();

  public abstract void hideSoftKeyboard();

  public abstract void renderCurrentEmail(String paramString);

  public abstract void setDoneButtonState(boolean paramBoolean);

  public abstract void showDisconnectConfirmationDialog();

  public abstract void showGenericError();

  public abstract void showInvalidEmailError();

  public abstract void showPasswordNotMatchedError();

  public abstract void showProgress();

  public abstract void showSuccessDialog();

  public abstract void showTooManyRequestsError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.changeemail.ChangeEmailView
 * JD-Core Version:    0.6.2
 */