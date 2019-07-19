package com.viber.jni.settings;

import com.viber.jni.connection.ConnectionController;
import com.viber.jni.controller.PhoneControllerCaller;
import com.viber.jni.controller.PhoneControllerCaller.MultiCallerCallback;

public class SettingsControllerCaller extends PhoneControllerCaller<SettingsController>
  implements SettingsController
{
  public SettingsControllerCaller(SettingsController paramSettingsController, ConnectionController paramConnectionController)
  {
    super(paramSettingsController, paramConnectionController);
  }

  public boolean handleChangeLastOnlineSettings(final int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(SettingsController paramAnonymousSettingsController)
      {
        return paramAnonymousSettingsController.handleChangeLastOnlineSettings(paramInt);
      }
    });
  }

  public boolean handleChangeReadNotificationsSettings(final int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(SettingsController paramAnonymousSettingsController)
      {
        return paramAnonymousSettingsController.handleChangeReadNotificationsSettings(paramInt);
      }
    });
  }

  public boolean handleChangeUserActivitySettings(final int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(SettingsController paramAnonymousSettingsController)
      {
        return paramAnonymousSettingsController.handleChangeUserActivitySettings(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.settings.SettingsControllerCaller
 * JD-Core Version:    0.6.2
 */