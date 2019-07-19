package com.viber.jni.settings;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CChangeSettingsMsg;
import com.viber.jni.im2.CChangeSettingsReplyMsg;
import com.viber.jni.im2.CChangeSettingsReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.r;
import java.util.concurrent.TimeUnit;

public class Im2ChangeSettingsSender
  implements CChangeSettingsReplyMsg.Receiver
{
  private static final Logger L = ViberEnv.getLogger();
  private static final long SCHEDULE_HANDLE_CHANGE_SETTINGS_DELAY_MILLIS = TimeUnit.SECONDS.toMillis(1L);
  private final ConnectionController mConnectionController;
  private final ConnectionDelegate mConnectionDelegate = new ConnectionDelegate()
  {
    public void onConnect()
    {
      if (d.ad.i.d() > 0)
        Im2ChangeSettingsSender.this.scheduleHandleChangeSettings();
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };
  private final Im2Exchanger mExchanger;
  private final Runnable mHandleChangeSettingsAction = new Im2ChangeSettingsSender..Lambda.0(this);
  private volatile boolean mInitialized = false;
  private final PhoneController mPhoneController;
  private SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener;
  private final Handler mWorkerHandler;

  public Im2ChangeSettingsSender(Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, ConnectionController paramConnectionController, Handler paramHandler)
  {
    this.mExchanger = paramIm2Exchanger;
    this.mPhoneController = paramPhoneController;
    this.mConnectionController = paramConnectionController;
    this.mWorkerHandler = paramHandler;
  }

  private void handleChangeSettings()
  {
    int i = this.mPhoneController.generateSequence();
    d.ad.i.a(i);
    if (!this.mConnectionController.isConnected())
      return;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    label60: long l;
    if (!d.m.f.d())
    {
      bool1 = true;
      bool2 = d.ad.r.d();
      if (d.r.B.d())
        break label112;
      bool3 = true;
      l = com.viber.voip.gdpr.d.b();
      if (d.ad.V.d())
        break label118;
    }
    label112: label118: for (boolean bool4 = true; ; bool4 = false)
    {
      CChangeSettingsMsg localCChangeSettingsMsg = new CChangeSettingsMsg(true, true, bool1, i, bool2, bool3, l, bool4);
      this.mExchanger.handleCChangeSettingsMsg(localCChangeSettingsMsg);
      return;
      bool1 = false;
      break;
      bool3 = false;
      break label60;
    }
  }

  private void scheduleHandleChangeSettings()
  {
    this.mWorkerHandler.removeCallbacks(this.mHandleChangeSettingsAction);
    this.mWorkerHandler.postDelayed(this.mHandleChangeSettingsAction, SCHEDULE_HANDLE_CHANGE_SETTINGS_DELAY_MILLIS);
  }

  public void init(ConnectionListener paramConnectionListener)
  {
    if (this.mInitialized)
      return;
    this.mInitialized = true;
    paramConnectionListener.registerDelegate(this.mConnectionDelegate, this.mWorkerHandler);
    Handler localHandler = this.mWorkerHandler;
    a[] arrayOfa = new a[8];
    arrayOfa[0] = d.f.b;
    arrayOfa[1] = d.f.c;
    arrayOfa[2] = d.f.d;
    arrayOfa[3] = d.f.e;
    arrayOfa[4] = d.r.B;
    arrayOfa[5] = d.ad.r;
    arrayOfa[6] = d.m.f;
    arrayOfa[7] = d.ad.V;
    this.mPreferenceChangeListener = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        if (!ao.f())
          Im2ChangeSettingsSender.this.scheduleHandleChangeSettings();
      }
    };
    com.viber.voip.settings.d.a(this.mPreferenceChangeListener);
  }

  public void onCChangeSettingsReplyMsg(CChangeSettingsReplyMsg paramCChangeSettingsReplyMsg)
  {
    if ((paramCChangeSettingsReplyMsg.status == 1) && (paramCChangeSettingsReplyMsg.sequence.intValue() == d.ad.i.d()))
      d.ad.i.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.settings.Im2ChangeSettingsSender
 * JD-Core Version:    0.6.2
 */