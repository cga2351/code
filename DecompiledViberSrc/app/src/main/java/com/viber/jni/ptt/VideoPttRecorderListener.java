package com.viber.jni.ptt;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class VideoPttRecorderListener extends ControllerListener<VideoPttControllerDelegate.VideoRecorder>
  implements VideoPttControllerDelegate.VideoRecorder
{
  public void onVideoPttRecordError(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoRecorder paramAnonymousVideoRecorder)
      {
        paramAnonymousVideoRecorder.onVideoPttRecordError(paramInt);
      }
    });
  }

  public void onVideoPttRecordInited()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoRecorder paramAnonymousVideoRecorder)
      {
        paramAnonymousVideoRecorder.onVideoPttRecordInited();
      }
    });
  }

  public void onVideoPttRecordStarted()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoRecorder paramAnonymousVideoRecorder)
      {
        paramAnonymousVideoRecorder.onVideoPttRecordStarted();
      }
    });
  }

  public void onVideoPttRecordStopped(final String paramString, final boolean paramBoolean, final byte[] paramArrayOfByte)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(VideoPttControllerDelegate.VideoRecorder paramAnonymousVideoRecorder)
      {
        paramAnonymousVideoRecorder.onVideoPttRecordStopped(paramString, paramBoolean, paramArrayOfByte);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ptt.VideoPttRecorderListener
 * JD-Core Version:    0.6.2
 */