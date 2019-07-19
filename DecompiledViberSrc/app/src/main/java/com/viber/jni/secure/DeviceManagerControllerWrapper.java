package com.viber.jni.secure;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;

public class DeviceManagerControllerWrapper extends ConnectedCaller
  implements DeviceManagerController
{
  private static final Logger L = ViberEnv.getLogger();
  private final DeviceManagerController mDeviceManagerController;

  public DeviceManagerControllerWrapper(Engine paramEngine, DeviceManagerController paramDeviceManagerController)
  {
    super(paramEngine);
    this.mDeviceManagerController = paramDeviceManagerController;
  }

  public boolean handleGetSecondaryDeviceDetails()
  {
    runOnConnect(1, new Runnable()
    {
      public void run()
      {
        DeviceManagerControllerWrapper.this.mDeviceManagerController.handleGetSecondaryDeviceDetails();
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.DeviceManagerControllerWrapper
 * JD-Core Version:    0.6.2
 */