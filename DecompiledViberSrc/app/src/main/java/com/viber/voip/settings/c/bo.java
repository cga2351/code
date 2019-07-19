package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.jni.Engine;
import com.viber.jni.im2.CMessageReceivedMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2Receiver;
import com.viber.jni.im2.Location;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.bh;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bo extends m
{
  public bo(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private void d()
  {
    av.a(av.e.b).post(new Runnable()
    {
      public void run()
      {
        ViberApplication.getInstance().getEngine(true).getExchanger().getIm2Receiver().onCMessageReceivedMsg(new CMessageReceivedMsg("+19543291690", System.currentTimeMillis(), "Test VLN message", System.currentTimeMillis(), 4194304, 0, new Location(0, 0), 0, "", "", null, "+19543291690", System.currentTimeMillis(), 0, 0, "Forwarding content message info", 0, 0, "+19543291690", ""));
      }
    });
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.bh.a.c(), "Show 'New!' badge in more screen").a(Boolean.valueOf(d.bh.a.f())).a());
    f(new x(this.a, x.a.a, d.bh.c.c(), "Reset VLN discoverability").a(this).a());
    f(new x(this.a, x.a.a, "emulate_vln_message_key", "Emulate VLN message").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("vln_key");
    paramPreferenceGroup.c("Viber Local Number");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals(d.bh.c.c()))
    {
      d.bh.c.e();
      return true;
    }
    if (str.equals("emulate_vln_message_key"))
      d();
    return super.a(paramPreference);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bo
 * JD-Core Version:    0.6.2
 */