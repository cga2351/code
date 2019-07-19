package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.e.b;

public abstract interface IInAppMessageWebViewClientListener
{
  public abstract void onCloseAction(b paramb, String paramString, Bundle paramBundle);

  public abstract void onCustomEventAction(b paramb, String paramString, Bundle paramBundle);

  public abstract void onNewsfeedAction(b paramb, String paramString, Bundle paramBundle);

  public abstract void onOtherUrlAction(b paramb, String paramString, Bundle paramBundle);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
 * JD-Core Version:    0.6.2
 */