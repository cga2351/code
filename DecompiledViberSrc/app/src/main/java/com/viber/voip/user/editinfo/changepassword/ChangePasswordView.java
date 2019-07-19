package com.viber.voip.user.editinfo.changepassword;

import com.viber.voip.user.actions.ConnectionAwareAction.ConnectionAwareView;

public abstract interface ChangePasswordView extends ConnectionAwareAction.ConnectionAwareView
{
  public abstract void hideCurrentPasswordIsInvalidError();

  public abstract void hideNewPasswordIsInvalidError();

  public abstract void hidePasswordNotMatchedError();

  public abstract void hideProgress();

  public abstract void hideSoftKeyboard();

  public abstract void setCurrentPasswordInputState(boolean paramBoolean);

  public abstract void setDoneButtonState(boolean paramBoolean);

  public abstract void setNewPasswordInputState(boolean paramBoolean);

  public abstract void setRetypePasswordInputState(boolean paramBoolean);

  public abstract void showCurrentPasswordIsInvalidError();

  public abstract void showGenericError();

  public abstract void showNewPasswordIsInvalidError();

  public abstract void showPasswordNotMatchedError();

  public abstract void showProgress();

  public abstract void showSuccessDialog();

  public abstract void showTooManyRequestsError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.changepassword.ChangePasswordView
 * JD-Core Version:    0.6.2
 */