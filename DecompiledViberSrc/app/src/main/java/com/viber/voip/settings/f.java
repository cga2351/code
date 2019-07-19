package com.viber.voip.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.b.j;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.m;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.extensions.i;
import com.viber.voip.messages.ui.MessageComposerView.b;
import com.viber.voip.settings.b.c;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.util.cv;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class f
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a()
  {
    int i = d.ad.l.d();
    if ((i == 0) && (!e.a.m.d()))
    {
      b();
      d.ad.l.a(157);
      i = 157;
    }
    if (i < 157)
    {
      a(i, 157);
      d.ad.l.a(157);
    }
  }

  private static void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = j.c();
    SharedPreferences.Editor localEditor = j.d();
    if (paramInt1 == 0)
      a(localSharedPreferences, localEditor, paramInt1);
    if (a(paramInt1, paramInt2, 63))
      a(localSharedPreferences);
    if (a(paramInt1, paramInt2, 76))
      b(localSharedPreferences, localEditor);
    if (a(paramInt1, paramInt2, 78))
      c(localSharedPreferences, localEditor);
    if (a(paramInt1, paramInt2, 84))
      d.r.i.a(d.r.h.d());
    if (a(paramInt1, paramInt2, 85))
      d(localSharedPreferences, localEditor);
    if (a(paramInt1, paramInt2, 92))
      e(localSharedPreferences, localEditor);
    if (a(paramInt1, paramInt2, 93))
      d();
    if (a(paramInt1, paramInt2, 91))
    {
      cv.a().a(0, System.currentTimeMillis());
      cv.a().a(0);
      if (d.ax.i.d() == MessageComposerView.b.a.ordinal())
        d.ax.i.a(MessageComposerView.b.b.ordinal());
    }
    if (a(paramInt1, paramInt2, 95))
      d.ax.m.b();
    if (a(paramInt1, paramInt2, 98))
      a(localEditor);
    if (a(paramInt1, paramInt2, 99))
    {
      d.r.q.b();
      d.ax.i.a(MessageComposerView.b.a.ordinal());
    }
    if (a(paramInt1, paramInt2, 102))
      ViberApplication.preferences().b("ps_ad");
    if (a(paramInt1, paramInt2, 106))
      d.ax.m.b();
    if (a(paramInt1, paramInt2, 107))
      i.a().d();
    if ((a(paramInt1, paramInt2, 112)) && (com.viber.common.d.a.j()))
      d.m.b.a(true);
    if (a(paramInt1, paramInt2, 114))
      a(new String[] { "pref_ask_restore_on_wi_fi_key", "pref_pending_restore_state_key" });
    if (a(paramInt1, paramInt2, 115))
      a(new String[] { "apptimize_cache_smCap", "last_sm_cap_period_start", "received_service_messages_count_during_day", "debug_sm_cap_period_millis" });
    if (a(paramInt1, paramInt2, 122))
      a(new String[] { "pref_ask_restore_on_wi_fi_key", "pref_pending_restore_state_key", "apptimize_cache_smCap", "last_sm_cap_period_start", "received_service_messages_count_during_day", "debug_sm_cap_period_millis" });
    if (a(paramInt1, paramInt2, 123))
      d.v.k.a(true);
    if (a(paramInt1, paramInt2, 124))
    {
      a(new String[] { "accept_terms_and_policies_state", "accept_terms_and_policies_state_v2" });
      if (d.be.d.d() == com.viber.voip.notif.h.a)
        d.be.d.a(com.viber.voip.notif.h.b);
    }
    if ((a(paramInt1, paramInt2, 126)) && (ViberApplication.isActivated()))
    {
      int i = e.a.r.d();
      if (i != 8)
      {
        e.a.r.a(8);
        String str3 = "User is activated but activation step is wrong: " + i;
        a.a(new Throwable(str3), str3);
      }
    }
    if (a(paramInt1, paramInt2, 127))
    {
      d.n.b.e();
      a(new String[] { "chat_ex_youtube_available", "chat_ex_favourite_links_available" });
    }
    if (a(paramInt1, paramInt2, 128))
      a(new String[] { "apptimize_cache_bottomNav" });
    if (a(paramInt1, paramInt2, 129))
      a(new String[] { "VIBER_OUT_NEW_WELCOME_SHOWN", "VIBER_OUT_NEW_WELCOME_INSTALL_TIMESTAMP", "VIBER_OUT_NEW_WELCOME_WEEK_DAY", "VIBER_OUT_NEW_WELCOME_ENTRY_COUNT", "VIBER_OUT_NEW_WELCOME_BALANCE_CHECK_DATE", "VIBER_OUT_NEW_WELCOME_BALANCE", "VIBER_OUT_NEW_WELCOME_CONTACTS_BANNER_CLOSED" });
    if (a(paramInt1, paramInt2, 130))
      d.c.c.a(System.currentTimeMillis());
    if (a(paramInt1, paramInt2, 131))
      a(new String[] { "last_interested_chat_ex_pa_id", "next_to_last_interested_chat_ex_pa_id" });
    if (a(paramInt1, paramInt2, 132))
      e();
    if (a(paramInt1, paramInt2, 133))
    {
      d.i.g.e();
      d.i.a.e();
      d.i.i.e();
      d.i.b.e();
      d.i.h.e();
      d.i.c.e();
      String str2 = d.i.d.d();
      if ((!TextUtils.isEmpty(str2)) && (str2.contains("10000406")))
        d.i.f.e();
      if (d.i.f.d())
      {
        d.i.e.e();
        d.i.d.e();
      }
    }
    if (a(paramInt1, paramInt2, 134))
      f();
    if (a(paramInt1, paramInt2, 135))
      d.v.n.a(true);
    if (a(paramInt1, paramInt2, 136))
      a(new String[] { "should_restore_apps" });
    boolean bool2;
    if (a(paramInt1, paramInt2, 137))
    {
      com.viber.common.b.g localg = j.b();
      if (localg.a("apptimize_cache_translate_a _message"))
        localg.b("wasabi_cache_translateMessages", localg.a("apptimize_cache_translate_a _message", false));
      if (localg.a("apptimize_cache_shopchatEnabled"))
        localg.b("wasabi_cache_shopchatEnabled", localg.a("apptimize_cache_shopchatEnabled", false));
      if (localg.a("apptimize_cache_businessInbox"))
      {
        if (localg.a("apptimize_cache_businessInbox", 0) == 1)
        {
          bool2 = true;
          localg.b("wasabi_cache_businessInbox", bool2);
        }
      }
      else
      {
        if (localg.a("apptimize_cache_appNexus"))
          localg.b("wasabi_cache_appNexus", localg.a("apptimize_cache_appNexus", ""));
        a(new String[] { "apptimize_cache_appNexus", "apptimize_cache_businessInbox", "apptimize_cache_translate_a _message", "apptimize_cache_enterBirthdate", "apptimize_cache_shareChatScreen", "apptimize_cache_quickAnswer", "apptimize_cache_new_feature_flag_variable_22", "open_links_in_internal_browser", "apptimize_cache_inviteTextContent", "apptimize_cache_inviteContact", "apptimize_cache_discoverScreenDestination", "apptimize_cache_chatExSayHi", "apptimize_cache_voSubsciptions", "apptimize_cache_hideViberDetails", "apptimize_cache_apptimize_test_feature", "apptimize_cache_shopchatEnabled", "server_apptimize_key" });
      }
    }
    else
    {
      if (a(paramInt1, paramInt2, 139))
        c();
      if (a(paramInt1, paramInt2, 140))
        a(new String[] { "pref_saved_to_favorites_bot_first_time", "pref_conversation_group_amount", "pref_conversation_one_on_one_amount", "pref_conversation_participant_amount", "pref_conversation_follower_amount", "pref_conversation_community_admin_amount", "pref_conversation_community_member_amount", "pref_conversation_community_follower_amount", "sessions_total", "registration_method", "public groups created total", "public groups followed total", "account created date", "free calls total", "vo calls total", "free_stickers_total", "paid_stickers_total", "MIXPANEL_ALIAS_ID", "mixpanel_key" });
      if (a(paramInt1, paramInt2, 141))
      {
        d.n.d.b();
        d.n.b.e();
      }
      if (a(paramInt1, paramInt2, 142))
      {
        z localz = new z();
        av.a(av.e.d).post(new g(localz));
      }
      if (a(paramInt1, paramInt2, 143))
        a(new String[] { "pref_ptt_forceclean_key", "pref_ptt_autoclean_key", "pref_audio_ptt_autoclean_dirsize_key", "pref_video_ptt_autoclean_dirsize_key" });
      if (a(paramInt1, paramInt2, 145))
      {
        String str1 = d.i.d.d();
        if ((!m.c(str1)) && ((str1 == null) || (!str1.contains("darcula"))))
          break label1843;
      }
    }
    label1843: for (boolean bool1 = true; ; bool1 = false)
    {
      d.i.f.a(bool1);
      if (bool1)
      {
        d.i.d.e();
        d.i.e.e();
      }
      if (a(paramInt1, paramInt2, 146))
        a(new String[] { "migration_to_mid_finished" });
      if (a(paramInt1, paramInt2, 147))
        a(new String[] { "sound_settings_video_enabled" });
      if (a(paramInt1, paramInt2, 148))
        g();
      if (a(paramInt1, paramInt2, 149))
        a(new String[] { "show_discoverability", "discoverability_state", "debug_enable_discoverability" });
      if ((a(paramInt1, paramInt2, 150)) && (j.b().a("pref_language_v1", false)))
        d.ad.a.c.a("en");
      if (a(paramInt1, paramInt2, 151))
        a(new String[] { "show_darcula_theme_ftue", "show_darcula_ftue_tracked", "show_darcula_ftue_highlight" });
      if (a(paramInt1, paramInt2, 152))
        a(new String[] { "write_pin_confirmation_dialog_show_count" });
      if (a(paramInt1, paramInt2, 153))
        a(new String[] { "debug_operator_plan_type_key", "debug_operator_plan_data_url_key", "debug_group_operator_plan_type_key" });
      if ((a(paramInt1, paramInt2, 155)) && (com.viber.common.d.a.o()))
      {
        d.ag.a.a(false);
        d.ag.c.a(false);
      }
      if (a(paramInt1, paramInt2, 156))
        a(new String[] { "public_groups_badges_count_bool" });
      if (a(paramInt1, paramInt2, 157))
        d.f.s.b();
      d.i.b.a(0L);
      return;
      bool2 = false;
      break;
    }
  }

  private static void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.remove("pref_engagement_shown_count").commit();
  }

  private static void a(SharedPreferences paramSharedPreferences)
  {
    int i = paramSharedPreferences.getInt(d.i.c.c() + d.i.a.d(), -1);
    if (i != -1)
      d.i.c.a(i);
  }

  private static void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    int i = d.ad.l.d();
    if ((i < 2) && (i < 1))
    {
      boolean bool1 = paramSharedPreferences.getBoolean("pref_auto_receive_photos_key", true);
      boolean bool2 = paramSharedPreferences.getBoolean("pref_auto_receive_videos_key", false);
      paramEditor.remove("pref_auto_receive_videos_key");
      paramEditor.remove("pref_auto_receive_photos_key");
      if ((bool1) && (bool2))
        d.af.a.a(true);
    }
  }

  private static void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, int paramInt)
  {
    Iterator localIterator = ViberApplication.preferences().b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof Boolean))
        paramEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
      else if ((localObject instanceof Float))
        paramEditor.putFloat(str, ((Float)localObject).floatValue());
      else if ((localObject instanceof Integer))
        paramEditor.putInt(str, ((Integer)localObject).intValue());
      else if ((localObject instanceof Long))
        paramEditor.putLong(str, ((Long)localObject).longValue());
      else if ((localObject instanceof String))
        paramEditor.putString(str, (String)localObject);
    }
    paramEditor.commit();
    a(paramSharedPreferences, paramEditor);
    d.ad.l.a(paramInt);
  }

  private static void a(com.viber.backup.a.d paramd)
  {
    String str = com.viber.voip.backup.f.b().a();
    if (!TextUtils.isEmpty(str))
    {
      new com.viber.backup.drive.a(d.x.a).a(str);
      paramd.h();
    }
    paramd.a(true);
  }

  private static void a(String[] paramArrayOfString)
  {
    com.viber.common.b.g localg = j.b();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      localg.b(paramArrayOfString[j]);
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt3) && (paramInt2 >= paramInt3);
  }

  private static void b()
  {
    c();
  }

  private static void b(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    String str = paramSharedPreferences.getString("sound_settings_video", "1");
    j.b().b("sound_settings_video_enabled", str.equals("1"));
    paramEditor.remove("sound_settings_video").commit();
  }

  private static void c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = TimeUnit.DAYS.toMillis(14L);
    d.m.t.a(l1 + l2);
  }

  private static void c(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    d.ad.I.a(paramSharedPreferences.contains("recent_calls_current_language"));
    paramEditor.remove("recent_calls_current_language").commit();
  }

  private static void d()
  {
    d.s.b.a(true);
  }

  private static void d(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    d.bb.b.a(paramSharedPreferences.getInt("app_badge_count", 0) - d.bb.a.d());
    paramEditor.remove("app_badge_count").commit();
  }

  private static void e()
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    com.viber.backup.a.d locald;
    if (ViberApplication.isActivated())
    {
      locald = com.viber.backup.a.d.a(ViberApplication.getApplication());
      if (locald.b())
        localViberApplication.getBackupManager().b();
    }
    else
    {
      return;
    }
    a(locald);
  }

  private static void e(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    if (com.viber.common.d.a.g())
      d.ag.a.a(false);
  }

  private static void f()
  {
    ViberApplication.getInstance();
    com.viber.backup.a.d locald = com.viber.backup.a.d.a(ViberApplication.getApplication());
    if ((locald.g()) && (ViberApplication.isActivated()))
      a(locald);
  }

  private static void g()
  {
    if (ViberApplication.isActivated())
    {
      d.at.b.a(0);
      d.at.c.a(2);
      d.f.a.a(true);
    }
    if (!d.r.J.a())
      d.r.J.a(true);
    if (e.a.r.d() == 6)
      e.a.r.a(7);
    if (e.a.r.d() == 14)
      e.a.r.a(15);
    if (e.a.r.d() == 17)
      e.a.r.a(18);
    a(new String[] { "mark_as_unread_new_label_display_count", "show_edit_messages_promo_banner", "mark_as_read_first_visit_time", "show_explanatory_mentions_tooltip", "was_reply_tooltip_shown", "was_pin_tooltip_shown", "was_save_to_favorites_links_tooltip_shown", "was_save_to_favorites_gifs_tooltip_shown", "was_save_to_favorites_videos_tooltip_shown", "save_to_favorites_tooltip_duration", "save_to_favorites_links_tooltip_showing_time", "save_to_favorites_gifs_tooltip_showing_time", "save_to_favorites_videos_tooltip_showing_time", "conversation_tooltip_duration", "time_bomb_tooltip_counter", "doodle_promo_tooltip_counter", "chat_ex_awareness_tooltip_state", "pa_info_show_tooltips", "was_inivte_members_tooltip_shown", "can_show_business_inbox_promotion_tooltip", "show_sound_sticker_pack_tooltip", "share_and_shop_menu_tooltip_counter", "share_and_shop_menu_button_first_time_trigger", "PREF_REFERRAL_TOOLTIP_SHOW_COUNT" });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.f
 * JD-Core Version:    0.6.2
 */