package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerCallInterruptionListener extends ControllerListener<DialerControllerDelegate.DialerCallInterruption>
  implements DialerControllerDelegate.DialerCallInterruption
{
  public void onDataInterruption(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallInterruption paramAnonymousDialerCallInterruption)
      {
        paramAnonymousDialerCallInterruption.onDataInterruption(paramBoolean);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerCallInterruptionListener
 * JD-Core Version:    0.6.2
 */