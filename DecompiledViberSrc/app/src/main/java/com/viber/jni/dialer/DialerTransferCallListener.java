package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerTransferCallListener extends ControllerListener<DialerControllerDelegate.DialerTransferCall>
  implements DialerControllerDelegate.DialerTransferCall
{
  public void onTransferFailed(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerTransferCall paramAnonymousDialerTransferCall)
      {
        paramAnonymousDialerTransferCall.onTransferFailed(paramInt);
      }
    });
  }

  public void onTransferReplyOK(final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerTransferCall paramAnonymousDialerTransferCall)
      {
        paramAnonymousDialerTransferCall.onTransferReplyOK(paramLong);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerTransferCallListener
 * JD-Core Version:    0.6.2
 */