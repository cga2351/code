package com.viber.jni.ptt;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class VideoPttPlayerListener extends ControllerListener<VideoPttControllerDelegate.VideoPlayer>
  implements VideoPttControllerDelegate.VideoPlayer
{
  public void onVideoPttPlayError(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoPlayer paramAnonymousVideoPlayer)
      {
        paramAnonymousVideoPlayer.onVideoPttPlayError(paramInt1, paramInt2);
      }
    });
  }

  public void onVideoPttPlayRestarted(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoPlayer paramAnonymousVideoPlayer)
      {
        paramAnonymousVideoPlayer.onVideoPttPlayRestarted(paramInt);
      }
    });
  }

  public void onVideoPttPlayStarted(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoPlayer paramAnonymousVideoPlayer)
      {
        paramAnonymousVideoPlayer.onVideoPttPlayStarted(paramInt);
      }
    });
  }

  public void onVideoPttPlayStopped(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoPlayer paramAnonymousVideoPlayer)
      {
        paramAnonymousVideoPlayer.onVideoPttPlayStopped(paramInt);
      }
    });
  }

  public void onVideoPttPlayStopping(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoPlayer paramAnonymousVideoPlayer)
      {
        paramAnonymousVideoPlayer.onVideoPttPlayStopping(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ptt.VideoPttPlayerListener
 * JD-Core Version:    0.6.2
 */