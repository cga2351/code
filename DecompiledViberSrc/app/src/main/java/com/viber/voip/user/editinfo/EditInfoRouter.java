package com.viber.voip.user.editinfo;

import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountRouter;

public abstract interface EditInfoRouter extends DisconnectAccountRouter
{
  public abstract void goToChangeEmailScreen();

  public abstract void goToChangePasswordScreen();

  public abstract void goToEditInfoScreen();

  public abstract void goToMoreScreen();

  public abstract boolean tryGoBack();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoRouter
 * JD-Core Version:    0.6.2
 */