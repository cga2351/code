package com.appboy.ui.inappmessage.listeners;

import com.appboy.e.b;
import com.appboy.e.n;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;

public class AppboyDefaultInAppMessageManagerListener
  implements IInAppMessageManagerListener
{
  public InAppMessageOperation beforeInAppMessageDisplayed(b paramb)
  {
    return InAppMessageOperation.DISPLAY_NOW;
  }

  public boolean onInAppMessageButtonClicked(n paramn, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }

  public boolean onInAppMessageClicked(b paramb, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }

  public void onInAppMessageDismissed(b paramb)
  {
  }

  @Deprecated
  public boolean onInAppMessageReceived(b paramb)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyDefaultInAppMessageManagerListener
 * JD-Core Version:    0.6.2
 */