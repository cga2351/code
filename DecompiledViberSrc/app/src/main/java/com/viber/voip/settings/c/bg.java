package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.google.d.f;
import com.viber.common.b.h;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSyncDataToMyDevicesMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.manager.SyncHistoryCommunicator.SyncHistoryMessage;
import com.viber.voip.messages.controller.manager.SyncHistoryCommunicator.SyncHistoryMessage.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.bz;
import com.viber.voip.util.da;
import java.util.Locale;

public class bg extends m
{
  private f b;
  private final Im2Exchanger c = ViberApplication.getInstance().getEngine(true).getExchanger();
  private final PhoneController d = ViberApplication.getInstance().getEngine(true).getPhoneController();

  public bg(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private SyncHistoryCommunicator.SyncHistoryMessage a(String paramString1, String paramString2)
  {
    long l;
    SyncHistoryCommunicator.SyncHistoryMessage.a locala;
    if (paramString2 != null)
    {
      l = bz.b(paramString2);
      locala = SyncHistoryCommunicator.SyncHistoryMessage.builder().a(paramString1).b("c67860e57af3348f63783bb1854b6efc3f742187");
      if (l >= 0L)
        break label50;
    }
    label50: for (Long localLong = null; ; localLong = Long.valueOf(l))
    {
      return locala.a(localLong).a();
      l = -1L;
      break;
    }
  }

  private String a(String paramString)
  {
    String str = da.b(paramString, "*");
    return String.format(Locale.US, "Simulate test to display Approve Request on Primary (sync messages from token: %s)", new Object[] { str });
  }

  private void a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(d().b(paramSyncHistoryMessage).getBytes(), 0, 1L, this.d.generateSequence(), 0L);
    this.c.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private f d()
  {
    if (this.b == null)
      this.b = new f();
    return this.b;
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "pref_sync_history_send_handshake", "Send Handshake").a("Simulate test that Primary supports Sync History feature").a(this).a());
    f(new x(this.a, x.a.a, "pref_sync_history_approve_request", "Send Approve Request").a("Simulate test to display Approve Request on Primary").a(this).a());
    f(new x(this.a, x.a.d, d.j.p.c(), "Send Approve Request with Token").a(a(d.j.p.d())).a(d.j.p.f()).a(this).a());
    f(new x(this.a, x.a.a, "pref_sync_history_send_canceled", "Send Canceled").a("Simulate test to cancel any Sync History process on Primary").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("sync_history_from_primary_group_key");
    paramPreferenceGroup.c("Sync History from Primary (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if ("pref_sync_history_send_handshake".equals(paramPreference.C()))
      a(a("Handshake", null));
    while (true)
    {
      return super.a(paramPreference);
      if ("pref_sync_history_approve_request".equals(paramPreference.C()))
        a(a("Request", null));
      else if ("pref_sync_history_send_canceled".equals(paramPreference.C()))
        a(a("Canceled", null));
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (d.j.p.c().equals(paramPreference.C()))
    {
      String str = paramObject.toString();
      paramPreference.b(a(str));
      a(a("Request", str));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bg
 * JD-Core Version:    0.6.2
 */