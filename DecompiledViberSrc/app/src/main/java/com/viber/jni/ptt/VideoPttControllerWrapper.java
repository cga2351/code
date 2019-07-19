package com.viber.jni.ptt;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.media.player.d.e;

public class VideoPttControllerWrapper
  implements VideoPttController
{
  private static final Logger L = ViberEnv.getLogger();
  private final VideoPttController mVideoPttController;

  public VideoPttControllerWrapper(VideoPttController paramVideoPttController)
  {
    this.mVideoPttController = paramVideoPttController;
  }

  private void pauseEmbeddedMedia()
  {
    ViberApplication.getInstance().getPlayerWindowManager().b();
  }

  public void handleInitVideoPttRecord()
  {
    pauseEmbeddedMedia();
    this.mVideoPttController.handleInitVideoPttRecord();
  }

  public void handleStartVideoPttRecord(Object paramObject, String paramString)
  {
    this.mVideoPttController.handleStartVideoPttRecord(paramObject, paramString);
  }

  public void handleStopVideoPttRecord()
  {
    this.mVideoPttController.handleStopVideoPttRecord();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ptt.VideoPttControllerWrapper
 * JD-Core Version:    0.6.2
 */