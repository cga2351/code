package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerHoldStateListener extends ControllerListener<DialerControllerDelegate.DialerHoldState>
  implements DialerControllerDelegate.DialerHoldState
{
  public void localHold()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerHoldState paramAnonymousDialerHoldState)
      {
        paramAnonymousDialerHoldState.localHold();
      }
    });
  }

  public void localUnhold()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerHoldState paramAnonymousDialerHoldState)
      {
        paramAnonymousDialerHoldState.localUnhold();
      }
    });
  }

  public void peerHold()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerHoldState paramAnonymousDialerHoldState)
      {
        paramAnonymousDialerHoldState.peerHold();
      }
    });
  }

  public void peerUnhold()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerHoldState paramAnonymousDialerHoldState)
      {
        paramAnonymousDialerHoldState.peerUnhold();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerHoldStateListener
 * JD-Core Version:    0.6.2
 */