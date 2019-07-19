package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerVideoListener extends ControllerListener<DialerControllerDelegate.DialerVideo>
  implements DialerControllerDelegate.DialerVideo
{
  public int onPeerVideoEnded(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onPeerVideoEnded(paramInt);
      }
    });
    return 0;
  }

  public int onPeerVideoStarted()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onPeerVideoStarted();
      }
    });
    return 0;
  }

  public void onSelfVideoEnded(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onSelfVideoEnded(paramInt);
      }
    });
  }

  public void onSelfVideoStarted()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onSelfVideoStarted();
      }
    });
  }

  public void onVideoCallEnded()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onVideoCallEnded();
      }
    });
  }

  public void onVideoCompatibility(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerVideo paramAnonymousDialerVideo)
      {
        paramAnonymousDialerVideo.onVideoCompatibility(paramBoolean1, paramBoolean2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerVideoListener
 * JD-Core Version:    0.6.2
 */