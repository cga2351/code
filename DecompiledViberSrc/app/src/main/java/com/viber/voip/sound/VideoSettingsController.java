package com.viber.voip.sound;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.DeviceFlagsManager;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.av;

public class VideoSettingsController
  implements SharedPreferences.OnSharedPreferenceChangeListener, Engine.InitializedListener
{
  private static final Logger L = ViberEnv.getLogger();

  public VideoSettingsController()
  {
    d.a(this);
  }

  private void applyVideo264Setting()
  {
    if (!"0".equals(d.av.z.d()));
    for (int i = 1; i != 0; i = 0)
    {
      NativeMediaDelegate.setDeviceFlags(0x80 | DeviceFlagsManager.getFlagsForDeviceModel());
      return;
    }
    NativeMediaDelegate.setDeviceFlags(0xFFFFFF7F & DeviceFlagsManager.getFlagsForDeviceModel());
  }

  private void applyVideoEnabledSetting(DialerController paramDialerController)
  {
    NativeMediaDelegate.setDeviceFlags(0x40 | DeviceFlagsManager.getFlagsForDeviceModel());
    paramDialerController.setEnableVideo(true);
  }

  private void applyVideoVP9Setting()
  {
    if (!"0".equals(d.av.A.d()));
    for (int i = 1; i != 0; i = 0)
    {
      NativeMediaDelegate.setDeviceFlags(0x100 | DeviceFlagsManager.getFlagsForDeviceModel());
      return;
    }
    NativeMediaDelegate.setDeviceFlags(0xFFFFFEFF & DeviceFlagsManager.getFlagsForDeviceModel());
  }

  private void safeApplyVideo264Setting(Engine paramEngine)
  {
    paramEngine.addInitializedListener(new Engine.InitializedListener()
    {
      public void initialized(Engine paramAnonymousEngine)
      {
        VideoSettingsController.this.applyVideo264Setting();
      }
    });
  }

  private void safeApplyVideoEnabledSetting(Engine paramEngine)
  {
    paramEngine.addInitializedListener(new Engine.InitializedListener()
    {
      public void initialized(Engine paramAnonymousEngine)
      {
        VideoSettingsController.this.applyVideoEnabledSetting(paramAnonymousEngine.getDialerController());
      }
    });
  }

  private void safeApplyVideoVP9Setting(Engine paramEngine)
  {
    paramEngine.addInitializedListener(new Engine.InitializedListener()
    {
      public void initialized(Engine paramAnonymousEngine)
      {
        VideoSettingsController.this.applyVideoVP9Setting();
      }
    });
  }

  public void initialized(Engine paramEngine)
  {
    applyVideoEnabledSetting(paramEngine.getDialerController());
    applyVideo264Setting();
    applyVideoVP9Setting();
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramString.equals(d.av.z.c()))
      safeApplyVideo264Setting(ViberApplication.getInstance().getEngine(false));
    while (!paramString.equals(d.av.A.c()))
      return;
    safeApplyVideoVP9Setting(ViberApplication.getInstance().getEngine(false));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.VideoSettingsController
 * JD-Core Version:    0.6.2
 */