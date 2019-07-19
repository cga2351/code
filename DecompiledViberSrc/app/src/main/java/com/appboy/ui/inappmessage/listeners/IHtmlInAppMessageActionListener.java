package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.e.b;

public abstract interface IHtmlInAppMessageActionListener
{
  public abstract void onCloseClicked(b paramb, String paramString, Bundle paramBundle);

  public abstract boolean onCustomEventFired(b paramb, String paramString, Bundle paramBundle);

  public abstract boolean onNewsfeedClicked(b paramb, String paramString, Bundle paramBundle);

  public abstract boolean onOtherUrlAction(b paramb, String paramString, Bundle paramBundle);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
 * JD-Core Version:    0.6.2
 */