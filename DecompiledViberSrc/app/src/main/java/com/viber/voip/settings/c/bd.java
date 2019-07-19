package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.jni.DeviceFlagsManager;
import com.viber.voip.SoundSettingsActivity;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.sound.NativeMediaDelegate;

public class bd extends m
{
  public bd(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "sound_settings_key", "Sound Settings").a(new Intent(this.a, SoundSettingsActivity.class)).a());
    f(new x(this.a, x.a.c, d.m.j.c(), "Use WebRTC EC").b(d.m.j.d()).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("sound_key");
    paramPreferenceGroup.c("Sound (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.m.j.c()))
    {
      boolean bool = ((CheckBoxPreference)paramPreference).b();
      d.m.j.a(bool);
      NativeMediaDelegate.setDeviceFlags(DeviceFlagsManager.getFlagsForDeviceModel());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bd
 * JD-Core Version:    0.6.2
 */