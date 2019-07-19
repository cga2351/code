package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.adjust.sdk.ActivityHandler;
import com.adjust.sdk.Adjust;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.z;
import com.viber.deviceinfo.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.http.OkHttpClientFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ag extends m
{
  private static final Logger b = ViberEnv.getLogger();

  public ag(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private void d()
  {
    ad.c().b(false).d();
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        try
        {
          Adjust.setEnabled(false);
          ActivityHandler.deleteActivityState(ag.this.a);
          ActivityHandler.deleteAttribution(ag.this.a);
          ActivityHandler.deleteSessionCallbackParameters(ag.this.a);
          ActivityHandler.deleteSessionPartnerParameters(ag.this.a);
          String str1 = "https://app.adjust.com/forget_device?app_token=vzpmna78ud8m&android_id=" + a.a().e();
          OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
          Request.Builder localBuilder1 = new Request.Builder().url(str1);
          Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
          localResponse.code();
          String str2 = localResponse.body().string();
          if (localResponse.isSuccessful())
          {
            String str3 = "Local adjust info is cleared. Adjust remote info:" + str2;
            Toast.makeText(ag.this.a, str3, 0).show();
          }
          while (true)
          {
            return;
            ad.a("Couldn't clear remote Adjust info. Status:" + str2).d();
          }
        }
        catch (Exception localException)
        {
          ad.a("Couldn't clear adjust info. Error:" + localException.toString()).d();
          return;
        }
        finally
        {
          z.a(ViberApplication.getApplication(), DialogCode.D_PROGRESS_OVERLAY);
        }
      }
    });
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "pref_clear_adjust", "Clear Adjust").a("To test:1.Clear Adjust 2.Uninstall Viber 3.Open deferred deep link 4.Install Viber from any source").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("groupinvitelinks_key");
    paramPreferenceGroup.c("Group Invite Links (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    int i = -1;
    switch (str.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      }
      break;
    case -1713777059:
    }
    while (true)
    {
      return super.a(paramPreference);
      if (!str.equals("pref_clear_adjust"))
        break;
      i = 0;
      break;
      d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ag
 * JD-Core Version:    0.6.2
 */