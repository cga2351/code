package com.viber.voip.user.editinfo.diconnectaccount;

import com.viber.voip.user.actions.ConnectionAwareAction.ConnectionAwareView;

public abstract interface DisconnectAccountView extends ConnectionAwareAction.ConnectionAwareView
{
  public abstract void hideDisconnectAccountProgress();

  public abstract void showDisconnectAccountError();

  public abstract void showDisconnectAccountProgress();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountView
 * JD-Core Version:    0.6.2
 */