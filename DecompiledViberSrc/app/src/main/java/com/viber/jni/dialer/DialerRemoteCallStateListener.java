package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerRemoteCallStateListener extends ControllerListener<DialerControllerDelegate.DialerRemoteCallState>
  implements DialerControllerDelegate.DialerRemoteCallState
{
  public void onPeerBusy()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerRemoteCallState paramAnonymousDialerRemoteCallState)
      {
        paramAnonymousDialerRemoteCallState.onPeerBusy();
      }
    });
  }

  public void onPeerRinging()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerRemoteCallState paramAnonymousDialerRemoteCallState)
      {
        paramAnonymousDialerRemoteCallState.onPeerRinging();
      }
    });
  }

  public void onStartRingback(final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerRemoteCallState paramAnonymousDialerRemoteCallState)
      {
        paramAnonymousDialerRemoteCallState.onStartRingback(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerRemoteCallStateListener
 * JD-Core Version:    0.6.2
 */