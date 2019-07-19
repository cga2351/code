package com.viber.jni.lastonline;

import com.viber.dexshared.Logger;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.voip.ViberEnv;

public class LastOnlineListener extends ControllerListener<LastOnlineDelegate>
  implements LastOnlineDelegate
{
  private static final Logger L = ViberEnv.getLogger();

  public void onLastOnline(final OnlineContactInfo[] paramArrayOfOnlineContactInfo, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LastOnlineDelegate paramAnonymousLastOnlineDelegate)
      {
        paramAnonymousLastOnlineDelegate.onLastOnline(paramArrayOfOnlineContactInfo, paramInt);
      }
    });
  }

  public boolean onLastOnlineLocal(final OnlineContactInfo[] paramArrayOfOnlineContactInfo, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LastOnlineDelegate paramAnonymousLastOnlineDelegate)
      {
        paramAnonymousLastOnlineDelegate.onLastOnline(paramArrayOfOnlineContactInfo, paramInt);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.lastonline.LastOnlineListener
 * JD-Core Version:    0.6.2
 */