package com.viber.jni.settings;

import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.g;

public class SettingsControllerStorage
  implements ConnectionDelegate, SettingsController, SettingsControllerDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  private SettingsController mController;

  public SettingsControllerStorage(SettingsController paramSettingsController)
  {
    this.mController = paramSettingsController;
  }

  public boolean handleChangeLastOnlineSettings(int paramInt)
  {
    d.bf.f.a(paramInt);
    return this.mController.handleChangeLastOnlineSettings(paramInt);
  }

  public boolean handleChangeReadNotificationsSettings(int paramInt)
  {
    d.ag.g.a(paramInt);
    return this.mController.handleChangeReadNotificationsSettings(paramInt);
  }

  public boolean handleChangeUserActivitySettings(int paramInt)
  {
    d.g.b.a(paramInt);
    return this.mController.handleChangeUserActivitySettings(paramInt);
  }

  public void onChangeLastOnlineSettingsReply(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
      d.bf.f.b();
  }

  public void onChangeReadNotificationsSettingsReply(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
      d.ag.g.b();
  }

  public void onChangeUserActivitySettingsReply(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
      d.g.b.b();
  }

  public void onConnect()
  {
    if (d.bf.f.a())
    {
      int k = d.bf.f.d();
      this.mController.handleChangeLastOnlineSettings(k);
    }
    if (d.ag.g.a())
    {
      int j = d.ag.g.d();
      this.mController.handleChangeReadNotificationsSettings(j);
    }
    if (d.g.b.a())
    {
      int i = d.g.b.d();
      this.mController.handleChangeUserActivitySettings(i);
    }
  }

  public void onConnectionStateChange(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.settings.SettingsControllerStorage
 * JD-Core Version:    0.6.2
 */