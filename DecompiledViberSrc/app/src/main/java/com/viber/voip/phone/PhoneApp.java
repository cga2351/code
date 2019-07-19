package com.viber.voip.phone;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.raw;
import com.viber.voip.ViberEnv;
import com.viber.voip.p.a;
import com.viber.voip.settings.d.m;
import com.viber.voip.util.dk;

public class PhoneApp
{
  private static final Logger L = ViberEnv.getLogger("PhoneApp");
  private static final String LOG_TAG = "PhoneApp";
  private a mCallProximityHelper;
  private final Context mContext;
  private PowerManager.WakeLock mWakeLock;
  private WakeState mWakeState = WakeState.SLEEP;
  private WifiManager.WifiLock mWifiLock;
  private Object mutex = new Object();
  private PowerManager pm;
  private WifiManager wm;

  public PhoneApp(Context paramContext)
  {
    this.mContext = paramContext;
    this.pm = ((PowerManager)paramContext.getSystemService("power"));
    this.wm = ((WifiManager)paramContext.getSystemService("wifi"));
    this.mWakeLock = this.pm.newWakeLock(805306394, "PhoneApp");
    this.mWifiLock = this.wm.createWifiLock(1, "VoipServiceWifiLock");
    initProximityHelper();
  }

  public a getCallProximityHelper()
  {
    return this.mCallProximityHelper;
  }

  public Uri getViberRingtoneUri(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && ((paramBoolean2) || (d.m.a.d())));
    for (int i = 1; ; i = 0)
    {
      Uri localUri = Uri.parse(d.m.c.d());
      if (i == 0)
        break;
      return localUri;
    }
    if (paramBoolean1);
    for (int j = R.raw.transfer_in; ; j = R.raw.viber_ring)
      return dk.a(j, this.mContext);
  }

  public void initProximityHelper()
  {
    this.mCallProximityHelper = com.viber.voip.p.b.a(this.mContext);
  }

  public void lockWifi(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mWifiLock.isHeld()))
      this.mWifiLock.acquire();
    while ((paramBoolean) || (!this.mWifiLock.isHeld()))
      return;
    this.mWifiLock.release();
  }

  void requestWakeState(WakeState paramWakeState)
  {
    synchronized (this.mutex)
    {
      if (this.mWakeState != paramWakeState);
      switch (1.$SwitchMap$com$viber$voip$phone$PhoneApp$WakeState[paramWakeState.ordinal()])
      {
      default:
        if (this.mWakeLock.isHeld())
          this.mWakeLock.release();
        this.mWakeState = paramWakeState;
        return;
      case 1:
      }
      this.mWakeLock.acquire();
    }
  }

  public void updateWakeState(int paramInt)
  {
    int i;
    int j;
    label14: int k;
    label23: int m;
    label31: int n;
    if (paramInt == 5)
    {
      i = 1;
      if (paramInt != 4)
        break label91;
      j = 1;
      if (paramInt != 7)
        break label96;
      k = 1;
      if (paramInt != 3)
        break label102;
      m = 1;
      if (paramInt != 6)
        break label108;
      n = 1;
      label40: int i1;
      if ((i == 0) && (j == 0) && (k == 0) && (m == 0))
      {
        i1 = 0;
        if (n == 0);
      }
      else
      {
        i1 = 1;
      }
      if (i1 == 0)
        break label114;
    }
    label91: label96: label102: label108: label114: for (WakeState localWakeState = WakeState.FULL; ; localWakeState = WakeState.SLEEP)
    {
      requestWakeState(localWakeState);
      return;
      i = 0;
      break;
      j = 0;
      break label14;
      k = 0;
      break label23;
      m = 0;
      break label31;
      n = 0;
      break label40;
    }
  }

  public static enum WakeState
  {
    static
    {
      FULL = new WakeState("FULL", 1);
      WakeState[] arrayOfWakeState = new WakeState[2];
      arrayOfWakeState[0] = SLEEP;
      arrayOfWakeState[1] = FULL;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PhoneApp
 * JD-Core Version:    0.6.2
 */