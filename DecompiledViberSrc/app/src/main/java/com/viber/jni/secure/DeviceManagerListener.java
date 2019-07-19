package com.viber.jni.secure;

import com.viber.jni.CSecondaryDeviceDetails;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DeviceManagerListener extends ControllerListener<DeviceManagerDelegate>
  implements DeviceManagerDelegate
{
  public void onSecondaryDeviceDetails(final CSecondaryDeviceDetails paramCSecondaryDeviceDetails)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DeviceManagerDelegate paramAnonymousDeviceManagerDelegate)
      {
        paramAnonymousDeviceManagerDelegate.onSecondaryDeviceDetails(paramCSecondaryDeviceDetails);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.DeviceManagerListener
 * JD-Core Version:    0.6.2
 */