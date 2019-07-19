package com.appboy.ui.inappmessage.listeners;

import android.os.Bundle;
import com.appboy.e.b;

public class AppboyDefaultHtmlInAppMessageActionListener
  implements IHtmlInAppMessageActionListener
{
  public void onCloseClicked(b paramb, String paramString, Bundle paramBundle)
  {
  }

  public boolean onCustomEventFired(b paramb, String paramString, Bundle paramBundle)
  {
    return false;
  }

  public boolean onNewsfeedClicked(b paramb, String paramString, Bundle paramBundle)
  {
    return false;
  }

  public boolean onOtherUrlAction(b paramb, String paramString, Bundle paramBundle)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyDefaultHtmlInAppMessageActionListener
 * JD-Core Version:    0.6.2
 */