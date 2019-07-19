package com.viber.voip.settings.c;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.common.b.g;
import com.viber.common.dialogs.l.a;
import com.viber.provider.contacts.a.c;
import com.viber.provider.contacts.a.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.b.e.a;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.schedule.o;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.b.f;
import com.viber.voip.settings.d.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ai;
import com.viber.voip.settings.d.am;
import com.viber.voip.settings.d.an;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.ay;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.bl;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.at;
import com.viber.voip.util.de;

public class bb extends m
{
  private Activity b;
  private boolean c = false;

  public bb(Activity paramActivity, Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramActivity;
  }

  private void d()
  {
    ad.j().d();
  }

  private void e()
  {
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("viber", Boolean.valueOf(false));
        bb.this.a.getContentResolver().delete(a.g.a, null, null);
        bb.this.a.getContentResolver().update(a.c.a, localContentValues, null, null);
        com.viber.voip.contacts.c.f.a.a(ViberApplication.getApplication()).e();
        ao.a(ViberApplication.isTablet(bb.this.a));
        ViberApplication.getInstance().setActivated(false);
        UserManager.from(bb.this.a).getRegistrationValues().o();
        ViberApplication.exit(bb.a(bb.this), false);
      }
    });
  }

  protected void a()
  {
    af localaf = UserManager.from(this.a).getRegistrationValues();
    x localx = new x(this.a, x.a.a, "user_info_debug", "UserInfo:");
    StringBuilder localStringBuilder = new StringBuilder().append("Migration State:");
    if (com.viber.voip.memberid.d.c());
    for (String str = " finished"; ; str = " not finished")
    {
      f(localx.a(str + "\nMemberId: " + localaf.l()).a());
      f(new x(this.a, x.a.c, d.a.j.c(), "Allow empty user name").a(Boolean.valueOf(d.a.j.f())).a());
      f(new x(this.a, x.a.a, "traffic", "Traffic statistics from last boot").a("Uploaded: " + String.valueOf(de.b()) + "MB\nDownloaded: " + String.valueOf(de.c()) + "MB").a(this).a());
      f(new x(this.a, x.a.b, d.az.a.c(), "Server config").a(d.az.a.f()).b("Server").a(new CharSequence[] { "Prod", "Int", "Dev" }).b(new CharSequence[] { "prod", "int", "FDD", "staging" }).a(this).a());
      f(new x(this.a, x.a.b, e.a.a.a.c(), "Device type").a(ViberApplication.isTablet(this.a)).b("Type").a(new CharSequence[] { "Primary", "Secondary" }).b(new CharSequence[] { "primary", "secondary" }).a(this).a(e.a.a.a.f()).a());
      f(new x(this.a, x.a.b, d.an.a.c(), "Audio PTTv2 Bit depth").a("Current bit depth : " + d.an.a.d() + " bit").b("Bit depth").a(new CharSequence[] { "8", "16" }).b(new CharSequence[] { "8", "16" }).a(this).a(d.an.a.f()).a());
      f(new x(this.a, x.a.b, d.an.b.c(), "Audio PTTv2 Sample rate").a("Current sample rate : " + d.an.b.d()).b("Sample rate").a(new CharSequence[] { "16000", "22050", "32000", "44100" }).b(new CharSequence[] { "16000", "22050", "32000", "44100" }).a(this).a(d.an.b.f()).a());
      f(new x(this.a, x.a.a, "clean_rakuten_id_key", "Clear RakutenID").a("This will clear rakuten id and reset integration state (can't be undone)").a(this).a());
      f(new x(this.a, x.a.b, d.bl.d.c(), "VPTTv2 video bitrate").a("Current bit depth : " + d.bl.d + " bit").b("Video bitrate").a(new CharSequence[] { "1000000", "1500000", "2000000", "2500000", "3000000" }).b(new CharSequence[] { "1000000", "1500000", "2000000", "2500000", "3000000" }).a(this).a(d.bl.d.f()).a());
      f(new x(this.a, x.a.a, "clear_gallery_key", "Clear Gallery Coach").a("Clear Gallery Coach shown flag").a(this).a());
      f(new x(this.a, x.a.a, "clear_last_online_key", "Clear Last Online").a("Clear Last Online timer").a(this).a());
      f(new x(this.a, x.a.a, "new_sticker_pkg_key", "New Stickers package").a("Increment new stickers pakages count").a(this).a());
      f(new x(this.a, x.a.c, d.ax.r.c(), "Enable free stickers").a(Boolean.valueOf(d.ax.r.f())).a());
      f(new x(this.a, x.a.a, "clear_terms_key", "Clear Terms And Conditions").a("Clear terms and conditions shown flag").a(this).a());
      f(new x(this.a, x.a.c, d.ad.c.c(), "Trim cache debug mode").a("Trim caches after 30 seconds being in background").a(Boolean.valueOf(d.ad.c.f())).a(this).a());
      f(new x(this.a, x.a.a, "force_trim_cache", "Force trim cache").a("Force trim cache").a(this).a());
      f(new x(this.a, x.a.a, "emulate_service_message_receive", "Emulate service message").a(this).a());
      f(new x(this.a, x.a.c, d.ad.A.c(), "Disable banners and ads").a("Disable all promo banners and ads").a(Boolean.valueOf(d.ad.A.f())).a());
      f(new x(this.a, x.a.c, d.ad.D.c(), "Show hidden conversations").a("Show hidden conversations in conversation list").a(Boolean.valueOf(d.ad.D.f())).a());
      f(new x(this.a, x.a.a, "pref_show_remote_splash", "Show remote splash").a("With custom URL").a(this).a());
      f(new x(this.a, x.a.c, d.ad.F.c(), "SD unmount").a("Emulate SD card unmount").a(Boolean.valueOf(d.ad.F.f())).a());
      f(new x(this.a, x.a.c, d.ad.G.c(), "Low storage").a("Emulate low storage space").a(Boolean.valueOf(d.ad.G.f())).a());
      f(new x(this.a, x.a.b, d.ai.a.c(), "MsgInfo parser type").a(d.ai.a.d()).a(d.ai.a.f()).a(e.a.a()).b(e.a.a()).a(this).a());
      f(new x(this.a, x.a.a, "clear_native_check_timer", "Clear native check timer").a("Clear native check timer").a(this).a());
      f(new x(this.a, x.a.a, "clear_native_check_value", "Clear native report checksum").a("Clear native report checksum").a(this).a());
      f(new x(this.a, x.a.c, d.ad.O.c(), "Clear media received thumbnails").a(Boolean.valueOf(d.ad.O.f())).a());
      f(new x(this.a, x.a.c, d.ad.P.c(), "Reupload media on forward").a(Boolean.valueOf(d.ad.P.f())).a());
      f(new x(this.a, x.a.c, d.ad.E.c(), "Use short keep-alive interval (60s)").a(Boolean.valueOf(d.ad.E.f())).a(this).a());
      f(new x(this.a, x.a.c, d.ad.S.c(), "Use short refresh data timeout").a("Timeout will be set to 1 minute").a(Boolean.valueOf(d.ad.S.f())).a(this).a());
      f(new x(this.a, x.a.c, d.ad.U.c(), "Force Rakuten Logo Title").a("Rakuten logo will always be displayed (Requires app restart)").a(Boolean.valueOf(d.ad.U.f())).a());
      f(new x(this.a, x.a.c, d.ay.e.c(), "Display 'Clear Data' on 'Manage Storage' screen").b(d.ay.e.d()).a());
      f(new x(this.a, x.a.a, "debug_clear_all_local_data", "Clear Data").a("Remove all files like 'Clear Data' from Android Settings").a(this).a());
      f(new x(this.a, x.a.c, d.r.I.c(), "Emulate timeout for downloading custom sounds").b(d.r.I.d()).a());
      return;
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("settings_key");
    paramPreferenceGroup.c("Settings (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("clean_rakuten_id_key"))
      com.viber.voip.rakuten.a.a().k();
    do
    {
      return false;
      if (str.equals("clear_gallery_key"))
      {
        d.am.a.b();
        return false;
      }
      if (str.equals("clear_last_online_key"))
      {
        d.bf.g.b();
        return false;
      }
      if (str.equals("new_sticker_pkg_key"))
      {
        o localo = com.viber.voip.schedule.d.a().c();
        localo.a(1 + localo.g());
        localo.i();
        return false;
      }
      if (str.equals("clear_terms_key"))
      {
        d.ap.b.b();
        return false;
      }
      if (str.equals(d.ad.c.c()))
      {
        boolean bool = ((CheckBoxPreference)paramPreference).b();
        d.ad.c.a(bool);
        return false;
      }
      if (str.equals("force_trim_cache"))
      {
        com.viber.voip.b.c.a.h.a(this.a).a();
        return false;
      }
      if (str.equals("emulate_service_message_receive"))
      {
        d();
        return false;
      }
      if ("pref_show_remote_splash".equals(str))
      {
        ad.k().d();
        return false;
      }
      if (str.equals("traffic"))
      {
        if (this.c)
        {
          de.a();
          Toast.makeText(this.a, "Statistic cleared!", 0).show();
          this.c = false;
          return false;
        }
        de.d();
        Toast.makeText(this.a, "Tap again to clear statistic", 0).show();
        this.c = true;
        return false;
      }
      if (str.equals("clear_native_check_timer"))
      {
        d.ad.M.b();
        ViberApplication.preferences().b("check_time", "");
        return false;
      }
      if (str.equals("clear_native_check_value"))
      {
        d.ad.N.b();
        ViberApplication.preferences().b("new_checksum", "");
        return false;
      }
    }
    while (!paramPreference.C().equals("debug_clear_all_local_data"));
    at.b();
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals(d.az.a.c()))
    {
      ViberApplication.getInstance().showToast("sever config changed to " + paramObject.toString());
      paramPreference.b("Current server type : " + paramObject.toString());
      e();
      return true;
    }
    if (str.equals(e.a.a.a.c()))
    {
      ViberApplication.getInstance().showToast("Device type changed to " + paramObject.toString());
      paramPreference.b("Current device type : " + paramObject.toString());
      e();
      return true;
    }
    if (str.equals(d.ai.a.c()))
    {
      com.viber.voip.flatbuffers.b.e.a(e.a.valueOf((String)paramObject));
      com.viber.voip.flatbuffers.b.e.b(e.a.valueOf((String)paramObject));
      paramPreference.b((CharSequence)paramObject);
      return true;
    }
    if (str.equals(d.ad.E.c()))
    {
      Toast.makeText(this.a, "Restart Viber to apply changes", 1).show();
      return true;
    }
    if (str.equals(d.an.a.c()))
    {
      paramPreference.b("Current bit depth : " + paramObject.toString() + " bit");
      return true;
    }
    if (str.equals(d.an.b.c()))
    {
      paramPreference.b("Current sample rate : " + paramObject.toString());
      return true;
    }
    if (str.equals(d.ad.S.c()))
      return true;
    if (str.equals(d.bl.d.c()))
    {
      paramPreference.b("Current vptt video bitrate : " + paramObject.toString());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bb
 * JD-Core Version:    0.6.2
 */