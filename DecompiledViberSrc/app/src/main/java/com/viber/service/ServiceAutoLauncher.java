package com.viber.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.gdpr.GdprUserBirthdayWatcher;
import org.webrtc.videoengine.VideoCaptureDeviceInfoAndroid;

public class ServiceAutoLauncher extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ViberApplication.getInstance().initApplication();
    VideoCaptureDeviceInfoAndroid.removeSavedJson();
    GdprUserBirthdayWatcher.a(paramContext.getApplicationContext());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.ServiceAutoLauncher
 * JD-Core Version:    0.6.2
 */