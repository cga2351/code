package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerLocalCallStateListener extends ControllerListener<DialerControllerDelegate.DialerLocalCallState>
  implements DialerControllerDelegate.DialerLocalCallState
{
  public void onCallEnded(final long paramLong, boolean paramBoolean, final String paramString, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerLocalCallState paramAnonymousDialerLocalCallState)
      {
        paramAnonymousDialerLocalCallState.onCallEnded(paramLong, paramString, paramInt1, paramInt2, this.val$dialType);
      }
    });
  }

  public void onCallStarted(final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerLocalCallState paramAnonymousDialerLocalCallState)
      {
        paramAnonymousDialerLocalCallState.onCallStarted(paramBoolean1, paramBoolean2, paramInt);
      }
    });
  }

  public void onHangup()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerLocalCallState paramAnonymousDialerLocalCallState)
      {
        paramAnonymousDialerLocalCallState.onHangup();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerLocalCallStateListener
 * JD-Core Version:    0.6.2
 */