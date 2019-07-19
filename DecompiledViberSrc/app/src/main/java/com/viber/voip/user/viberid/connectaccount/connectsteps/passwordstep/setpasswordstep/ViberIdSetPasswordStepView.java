package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep;

import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordStepView;

abstract interface ViberIdSetPasswordStepView extends ViberIdPasswordStepView
{
  public abstract void hidePasswordInvalidError();

  public abstract void hidePasswordMustMatchError();

  public abstract void initViewState(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void setRetypePasswordFieldState(boolean paramBoolean);

  public abstract void showPasswordInvalidError();

  public abstract void showPasswordMustMatchError();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep.ViberIdSetPasswordStepView
 * JD-Core Version:    0.6.2
 */