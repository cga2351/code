package com.viber.jni.settings;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SettingsListener extends ControllerListener<SettingsControllerDelegate>
  implements SettingsControllerDelegate
{
  public void onChangeLastOnlineSettingsReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SettingsControllerDelegate paramAnonymousSettingsControllerDelegate)
      {
        paramAnonymousSettingsControllerDelegate.onChangeLastOnlineSettingsReply(paramInt1, paramInt2);
      }
    });
  }

  public void onChangeReadNotificationsSettingsReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SettingsControllerDelegate paramAnonymousSettingsControllerDelegate)
      {
        paramAnonymousSettingsControllerDelegate.onChangeReadNotificationsSettingsReply(paramInt1, paramInt2);
      }
    });
  }

  public void onChangeUserActivitySettingsReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SettingsControllerDelegate paramAnonymousSettingsControllerDelegate)
      {
        paramAnonymousSettingsControllerDelegate.onChangeUserActivitySettingsReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.settings.SettingsListener
 * JD-Core Version:    0.6.2
 */