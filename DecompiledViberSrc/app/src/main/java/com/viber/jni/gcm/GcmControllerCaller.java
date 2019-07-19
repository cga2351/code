package com.viber.jni.gcm;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;

public class GcmControllerCaller extends ConnectedCaller
  implements GcmController
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int TASK_TOKEN = 1;
  private final GcmController mController;

  public GcmControllerCaller(Engine paramEngine, GcmController paramGcmController)
  {
    super(paramEngine);
    this.mController = paramGcmController;
  }

  public boolean updatePushToken(final String paramString)
  {
    runOnConnect(1, new Runnable()
    {
      public void run()
      {
        GcmControllerCaller.this.mController.updatePushToken(paramString);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.gcm.GcmControllerCaller
 * JD-Core Version:    0.6.2
 */