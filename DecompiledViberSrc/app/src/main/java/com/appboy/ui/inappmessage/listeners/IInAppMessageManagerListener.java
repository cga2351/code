package com.appboy.ui.inappmessage.listeners;

import com.appboy.e.b;
import com.appboy.e.n;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;

public abstract interface IInAppMessageManagerListener
{
  public abstract InAppMessageOperation beforeInAppMessageDisplayed(b paramb);

  public abstract boolean onInAppMessageButtonClicked(n paramn, InAppMessageCloser paramInAppMessageCloser);

  public abstract boolean onInAppMessageClicked(b paramb, InAppMessageCloser paramInAppMessageCloser);

  public abstract void onInAppMessageDismissed(b paramb);

  @Deprecated
  public abstract boolean onInAppMessageReceived(b paramb);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener
 * JD-Core Version:    0.6.2
 */