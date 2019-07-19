package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerCallbackListener extends ControllerListener<DialerControllerDelegate.DialerCallback>
  implements DialerControllerDelegate.DialerCallback
{
  public void hideCallBack()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallback paramAnonymousDialerCallback)
      {
        paramAnonymousDialerCallback.hideCallBack();
      }
    });
  }

  public void showCallBack(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallback paramAnonymousDialerCallback)
      {
        paramAnonymousDialerCallback.showCallBack(paramInt1, paramInt2);
      }
    });
  }

  public void showCallBlocked(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallback paramAnonymousDialerCallback)
      {
        paramAnonymousDialerCallback.showCallBlocked(paramInt1, paramInt2);
      }
    });
  }

  public void showDialog(final int paramInt, final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallback paramAnonymousDialerCallback)
      {
        paramAnonymousDialerCallback.showDialog(paramInt, paramString);
      }
    });
  }

  public void switchToGSM(final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerCallback paramAnonymousDialerCallback)
      {
        paramAnonymousDialerCallback.switchToGSM(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerCallbackListener
 * JD-Core Version:    0.6.2
 */