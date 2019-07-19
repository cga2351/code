package com.viber.jni.lastonline;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;
import java.util.Arrays;

public class LastOnlineControllerCaller extends ConnectedCaller
  implements LastOnlineController
{
  private static final Logger L = ViberEnv.getLogger();
  private LastOnlineController mOnlineController;

  public LastOnlineControllerCaller(LastOnlineController paramLastOnlineController, Engine paramEngine)
  {
    super(paramEngine);
    this.mOnlineController = paramLastOnlineController;
  }

  public boolean handleGetLastOnline(final String[] paramArrayOfString, final int paramInt)
  {
    runOnConnect(Arrays.toString(paramArrayOfString).hashCode(), new Runnable()
    {
      public void run()
      {
        if (LastOnlineControllerCaller.this.mEngine.isReady())
          LastOnlineControllerCaller.this.mOnlineController.handleGetLastOnline(paramArrayOfString, paramInt);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.lastonline.LastOnlineControllerCaller
 * JD-Core Version:    0.6.2
 */