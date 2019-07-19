package com.viber.voip.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.viber.common.b.i;
import com.viber.common.b.j;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g.a.b;
import com.viber.voip.ap;
import com.viber.voip.av.e;
import com.viber.voip.bk;
import com.viber.voip.contacts.b.b;
import com.viber.voip.messages.ui.MessageComposerView.b;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.registration.o;
import com.viber.voip.stickers.x.a;
import com.viber.voip.ui.j.ax;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public final class d
{
  public static final int a = R.string.pref_google_analytics_key;
  public static final int b = R.string.pref_allow_content_personalization_key;
  public static final int c = R.string.pref_allow_interest_based_ads_key;
  public static final int d = R.string.pref_allow_location_based_services_key;
  public static final int e = R.string.pref_pixie_mode_key;
  public static final int f = R.string.pref_last_online_key;

  public static void a()
  {
    com.viber.voip.h.a.b().post(new a());
    j.e();
  }

  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    j.a(paramOnSharedPreferenceChangeListener);
  }

  public static void b(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    j.b(paramOnSharedPreferenceChangeListener);
  }

  private static Context c()
  {
    return bk.b();
  }

  private static Resources d()
  {
    return c().getResources();
  }

  public static class a
  {
    public static final com.viber.common.b.a a = new com.viber.common.b.a(d.b(), R.string.pref_category_backup_and_restore_key);
    public static final com.viber.common.b.a b = new com.viber.common.b.a(d.b(), R.string.pref_category_manage_secondaries_key);
    public static final com.viber.common.b.a c = new com.viber.common.b.a(d.b(), R.string.pref_category_change_phone_number_key);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("sim_serial", "");
    public static final com.viber.common.b.h e = new com.viber.common.b.h("last_authorized_canonized_phone_number", null);
    public static final com.viber.common.b.h f = new com.viber.common.b.h("last_used_activation_code", null);
    public static final com.viber.common.b.a g = new com.viber.common.b.a(d.b(), R.string.pref_category_purchases_key);
    public static final com.viber.common.b.a h = new com.viber.common.b.a(d.b(), R.string.pref_restore_subscriptions_key);
    public static final com.viber.common.b.a i = new com.viber.common.b.a(d.b(), R.string.pref_restore_stickers_key);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("debug_allow_empty_user_name", false);
  }

  public static class aa
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("sim_mcc_code", null);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("sim_mnc_code", null);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("network_mcc_code", null);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("network_mnc_code", null);
  }

  public static class ab
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("media_upload_base_url_manual", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("media_download_base_url_manual", false);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("media_upload_base_url", ap.n(ap.d()));
    public static final com.viber.common.b.h d = new com.viber.common.b.h("media_download_base_url", ap.o(ap.d()));
    public static final com.viber.common.b.b e = new com.viber.common.b.b("blur_conversation_media_thumbnails", true);
  }

  public static class ac
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("force_migration", false);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("member_id_migration_state", 0);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("backup_migration_finished", true);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("debug_crash_on_invalid_participant_info", true);
  }

  public static class ad
  {
    public static final com.viber.common.b.b A = new com.viber.common.b.b("disable_banners_debug_key", false);
    public static final com.viber.common.b.b B = new com.viber.common.b.b("force_show_launch_splash", false);
    public static final com.viber.common.b.b C = new com.viber.common.b.b("force_show_message_sent_splash", false);
    public static final com.viber.common.b.b D = new com.viber.common.b.b("show_hidden_conversation_debug_key", false);
    public static final com.viber.common.b.b E = new com.viber.common.b.b("use_short_keep_alive_interval", false);
    public static final com.viber.common.b.b F = new com.viber.common.b.b("emulate_sdcard_unmount", false);
    public static final com.viber.common.b.b G = new com.viber.common.b.b("emulate_low_storage_space", false);
    public static final com.viber.common.b.h H = new com.viber.common.b.h("video_converter_request_hint", "");
    public static final com.viber.common.b.b I = new com.viber.common.b.b("should_update_contact_name_letters", false);
    public static final com.viber.common.b.d J = new com.viber.common.b.d("scanner_camera_index", -1);
    public static final com.viber.common.b.b K = new com.viber.common.b.b("should_show_user_blocked_splash", false);
    public static final com.viber.common.b.h L = new com.viber.common.b.h("blocked_user_captcha_url", "");
    public static final com.viber.common.b.e M = new com.viber.common.b.e("last_checksum_check", 0L);
    public static final com.viber.common.b.e N = new com.viber.common.b.e("new_checksum_value", 0L);
    public static final com.viber.common.b.b O = new com.viber.common.b.b("clear_media_received_thumbnails", false);
    public static final com.viber.common.b.b P = new com.viber.common.b.b("reupload_media_on_forward", false);
    public static final com.viber.common.b.b Q = new com.viber.common.b.b("has_miui_rom", false);
    public static final com.viber.common.b.e R = new com.viber.common.b.e("server_delta_time", 9223372036854775807L);
    public static final com.viber.common.b.b S = new com.viber.common.b.b("pref_use_short_refresh_data_timeout", false);
    public static final com.viber.common.b.e T = new com.viber.common.b.e("pref_latest_connect_time", -1L);
    public static final com.viber.common.b.b U = new com.viber.common.b.b("debug_force_rakuten_logo_title", false);
    public static final com.viber.common.b.b V = new com.viber.common.b.b(d.b(), R.string.pref_use_p2p_key, R.string.pref_use_p2p_default);
    public static final com.viber.common.b.h a = new com.viber.common.b.h("webview_user_agent", "");
    public static final com.viber.common.b.b b = new com.viber.common.b.b("PREF_DELETE_EMPTY_FILES", true);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("trimcache_debugmode_key", false);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("video_converter_enabled", false);
    public static final com.viber.common.b.h e = new com.viber.common.b.h("LAST_NOTIFICATION_JSON", null);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("enable_strict_mode", false);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("enable_detect_memory_leaks", false);
    public static final com.viber.common.b.d h = new com.viber.common.b.d("forward_selection", 0);
    public static final com.viber.common.b.d i = new com.viber.common.b.d("sync_changed_settings_sequence", 0);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("PREF_IS_VIBER_UPGRADED", false);
    public static final com.viber.common.b.b k = new com.viber.common.b.b("pref_need_force_update", false);
    public static final com.viber.common.b.d l = new com.viber.common.b.d("PREFERENCES_VERSION_CODE", 0);
    public static final com.viber.common.b.h m = new com.viber.common.b.h("PREF_CURRENT_LOCALE", "");
    public static final com.viber.common.b.b n = new com.viber.common.b.b("pref_maps_version", false);
    public static final com.viber.common.b.e o = new com.viber.common.b.e("last_wear_info_check", 0L);
    public static final com.viber.common.b.b p = new com.viber.common.b.b("wear_info_reported", false);
    public static final com.viber.common.b.h q = new com.viber.common.b.h("pref_wear_current_id", "");
    public static final com.viber.common.b.b r = new com.viber.common.b.b(d.b(), R.string.pref_show_your_photo_key, R.string.pref_show_your_photo_default);
    public static final com.viber.common.b.a s = new com.viber.common.b.a(d.b(), R.string.pref_privacy_policy_key);
    public static final com.viber.common.b.a t = new com.viber.common.b.a(d.b(), R.string.pref_hidden_chats_key);
    public static final com.viber.common.b.a u = new com.viber.common.b.a(d.b(), R.string.pref_learn_more_hidden_chats_key);
    public static final com.viber.common.b.a v = new com.viber.common.b.a(d.b(), R.string.pref_change_pin_key);
    public static final com.viber.common.b.a w = new com.viber.common.b.a(d.b(), R.string.pref_reset_pin_key);
    public static final com.viber.common.b.a x = new com.viber.common.b.a(d.b(), R.string.pref_category_manage_storage_key);
    public static final com.viber.common.b.h y = new com.viber.common.b.h("pref_debug_notification_json_url", a());
    public static final com.viber.common.b.b z = new com.viber.common.b.b(d.b(), R.string.pref_hide_image_folder_key, R.string.pref_hide_image_folder_default);

    private static String a()
    {
      return ap.g(ap.d());
    }

    public static class a
    {
      public static final com.viber.common.b.h a = new com.viber.common.b.h("PREF_LAST_SYNCED_LANGUAGE", null);
      public static final com.viber.common.b.h b = new com.viber.common.b.h("PREF_LAST_SYNCED_OS_LANGUAGE", null);
      public static final com.viber.common.b.h c = new com.viber.common.b.h(d.b(), R.string.pref_ui_language_key, "");
      public static final com.viber.common.b.b d = new com.viber.common.b.b("force_burmese_always_visible", false);
    }
  }

  public static final class ae
  {
    public static final com.viber.common.b.e a = new com.viber.common.b.e("more_notification_banner_display_expiration_time_millis", 0L);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("show_more_notification_banner_badge", false);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("more_sticker_market_subtext_state", 0);
  }

  public static class af
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b(d.b(), R.string.pref_auto_receive_media_on_mobile_key, R.string.pref_auto_receive_media_on_mobile_default);
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), R.string.pref_auto_receive_media_on_wifi_key, R.string.pref_auto_receive_media_on_wifi_default);
    public static final com.viber.common.b.b c = new com.viber.common.b.b(d.b(), R.string.pref_restrict_data_usage_key, false);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("pref_wifi_policy", a());
    public static final com.viber.common.b.h e = new com.viber.common.b.h(d.b(), d.e, b());
    public static final com.viber.common.b.b f = new com.viber.common.b.b("check_data_roaming", true);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("isConnectivityTestOn", false);
    public static final com.viber.common.b.h h = new com.viber.common.b.h("DOWNLOAD_VALVE_DATA", "");
    public static final com.viber.common.b.b i = new com.viber.common.b.b("DOWNLOAD_VALVE_DEBUG_ENABLED", false);

    private static String a()
    {
      if (com.viber.common.d.a.k())
        return "pref_wifi_policy_use_device_settings";
      return "pref_wifi_policy_always_connected";
    }

    private static String b()
    {
      switch (0)
      {
      default:
        return "pref_pixie_mode_auto";
      case 1:
        return "pref_pixie_mode_always_on";
      case 2:
      }
      return "pref_pixie_mode_off";
    }
  }

  public static class ag
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b(d.b(), R.string.pref_popup_enabled_key, R.string.pref_popup_enabled_default);
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), R.string.pref_show_preview_key, R.string.pref_show_preview_default);
    public static final com.viber.common.b.b c = new com.viber.common.b.b(d.b(), R.string.pref_unlock_screen_for_popup_key, R.string.pref_unlock_screen_for_popup_default);
    public static final com.viber.common.b.b d = new com.viber.common.b.b(d.b(), R.string.pref_light_up_screen_key, R.string.pref_light_up_screen_default);
    public static final com.viber.common.b.b e = new com.viber.common.b.b(d.b(), R.string.pref_notification_icon_key, R.string.pref_notification_icon_default);
    public static final com.viber.common.b.b f = new com.viber.common.b.b(d.b(), R.string.pref_read_status_key, R.string.pref_read_status_default);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("read_state_dirty", 1);
    public static final com.viber.common.b.b h = new com.viber.common.b.b(d.b(), R.string.pref_outgoing_messages_sounds_key, R.string.pref_outgoing_messages_sounds_default);
    public static final com.viber.common.b.h i = new com.viber.common.b.h(d.b(), R.string.pref_notification_sound_key, Settings.System.DEFAULT_NOTIFICATION_URI.toString());
    public static final com.viber.common.b.b j = new com.viber.common.b.b(d.b(), R.string.pref_global_notifications_enabled_key, R.string.pref_global_notifications_enabled_default);
    public static final com.viber.common.b.b k = new com.viber.common.b.b("show_notificaiton_channel_id", false);
    public static final com.viber.common.b.h l = new com.viber.common.b.h("disabled_notification_channels", "");
    public static final com.viber.common.b.d m = new com.viber.common.b.d("channels_version_code", 0);
  }

  public static class ah
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("PREF_OPENIAB_STORE", 0);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("PREF_OPENIAB_STORE_NAME", null);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("pref_enable_product_cache", false);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("billing_client", true);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("pref_subs_support", true);
  }

  public static class ai
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("msginfo_parser", com.viber.voip.flatbuffers.b.e.a.name());
  }

  public static class aj
  {
    public static final b a = new b("draw_over_other_apps_minimized_call_attempts", 3);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("camera_need_reinit", false);
  }

  public static class ak
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("need_upgrade_db", false);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("upgrade_old_version_db", -1);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("upgrade_new_version_db", -1);
  }

  public static abstract class al
    implements SharedPreferences.OnSharedPreferenceChangeListener
  {
    private Handler mHandler;
    private Map<String, com.viber.common.b.a> mPrefs = new HashMap();

    public al(Handler paramHandler, com.viber.common.b.a[] paramArrayOfa)
    {
      if (paramHandler != null);
      for (this.mHandler = paramHandler; ; this.mHandler = av.e.g.a())
      {
        int i = paramArrayOfa.length;
        for (int j = 0; j < i; j++)
        {
          com.viber.common.b.a locala = paramArrayOfa[j];
          this.mPrefs.put(locala.c(), locala);
        }
      }
    }

    public al(com.viber.common.b.a[] paramArrayOfa)
    {
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
      {
        com.viber.common.b.a locala = paramArrayOfa[j];
        this.mPrefs.put(locala.c(), locala);
      }
      this.mHandler = av.e.g.a();
    }

    public abstract void onPreferencesChanged(com.viber.common.b.a parama);

    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, final String paramString)
    {
      if ((this.mPrefs.isEmpty()) || (this.mPrefs.containsKey(paramString)))
      {
        if (Looper.myLooper() == this.mHandler.getLooper())
          onPreferencesChanged((com.viber.common.b.a)this.mPrefs.get(paramString));
      }
      else
        return;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          d.al.this.onPreferencesChanged((com.viber.common.b.a)d.al.this.mPrefs.get(paramString));
        }
      });
    }
  }

  public static class am
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("gallery_coach_show", true);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("show_carlos_messages", true);
  }

  public static class an
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("pref_audio_ptt_bit_depth", "16");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("pref_audio_ptt_sample_rate", "32000");
  }

  public static final class ao
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("pref_force_enable_pa_age_restricted", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("pref_force_enable_pa_send_message_reply_suspended", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("pref_force_enable_pa_send_message_reply_deleted", false);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("pref_force_disable_pa_webhook", false);
    public static final com.viber.common.b.h e = new com.viber.common.b.h("pref_pa_reply_keyboard_config", "");
    public static final com.viber.common.b.b f = new com.viber.common.b.b("debug_ads_fetching_custom_url_enabled", false);
    public static final com.viber.common.b.h g = new com.viber.common.b.h("debug_ads_fetching_custom_url", "");
    public static final com.viber.common.b.b h = new com.viber.common.b.b("pref_force_bot_only_pa", false);
    public static final com.viber.common.b.d i = new com.viber.common.b.d("debug_ads_fetching_timeout_in_ms", (int)TimeUnit.SECONDS.toMillis(5L));
  }

  public static class ap
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("PREF_VIBES_CUSTOM_BASE_URL", a());
    public static final com.viber.common.b.b b = new com.viber.common.b.b("terms_and_conditions", true);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("guidelines_and_conditions", true);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("pref_vibes_enabled_2", 0);
    public static final com.viber.common.b.e e = new com.viber.common.b.e("public_groups_updated_latest_token", 0L);

    private static String a()
    {
      return ap.f(ap.d());
    }
  }

  public static class aq
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("PREF_REACT_CODE_PUSH_TOKEN", "iaprUs_QSjC15pCOdbCRIRfXPh-OB1bwTNqsM");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("PREF_REACT_BASE_API_URL", "");
    public static final com.viber.common.b.h c = new com.viber.common.b.h("PREF_REACT_DEBUG_JS_BUNDLE_URL", "");
    public static final com.viber.common.b.b d = new com.viber.common.b.b("PREF_REACT_ENABLE_JS_BUNDLE_DEBUG", false);
  }

  public static final class ar
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("registration_cdr_enabled", false);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("keychain_restore_from_backup_error", 0);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("not_using_quick_reg_reason", 2);
  }

  public static class as
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b(d.b(), R.string.pref_secure_api_enabled_key, R.string.pref_secure_api_enabled_default);
    public static final com.viber.common.b.a b = new com.viber.common.b.a(d.b(), R.string.pref_clear_trusted_contacts_key);
  }

  public static class at
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("postponed_session_step", -1);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("birthdate_screen_state", 1);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("say_hi_screen_state", 0);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("app_boy_screen_state", 0);
  }

  public static class au
  {
    public static final com.viber.common.b.a a = new com.viber.common.b.a(d.b(), R.string.pref_facebook_connect_key);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("debug_force_rakuten_sharing", false);
  }

  public static class av
  {
    public static final com.viber.common.b.h A = new com.viber.common.b.h("sound_settings_video_vp9", "1");
    public static final com.viber.common.b.h a = new com.viber.common.b.h("sound_settings_audio_driver", "0");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("sound_settings_hw_agc_key", "0");
    public static final com.viber.common.b.h c = new com.viber.common.b.h("sound_settings_hw_iir_key", "0");
    public static final com.viber.common.b.h d = new com.viber.common.b.h("sound_settings_hw_ns_key", "0");
    public static final com.viber.common.b.h e = new com.viber.common.b.h("sound_settings_sw_agc_key", "0");
    public static final com.viber.common.b.h f = new com.viber.common.b.h("sound_settings_sw_aec_key", "0");
    public static final com.viber.common.b.h g = new com.viber.common.b.h("sound_settings_sw_ns_key", "0");
    public static final com.viber.common.b.h h = new com.viber.common.b.h("sound_settings_vad_key", "0");
    public static final com.viber.common.b.h i = new com.viber.common.b.h("sound_settings_rxns_key", "0");
    public static final com.viber.common.b.h j = new com.viber.common.b.h("sound_settings_ns_key", "0");
    public static final com.viber.common.b.h k = new com.viber.common.b.h("sound_settings_rxagc_key", "0");
    public static final com.viber.common.b.h l = new com.viber.common.b.h("sound_settings_agc_key", "0");
    public static final com.viber.common.b.h m = new com.viber.common.b.h("sound_settings_aec_key", "0");
    public static final com.viber.common.b.h n = new com.viber.common.b.h("sound_settings_speaker_vad_key", "0");
    public static final com.viber.common.b.h o = new com.viber.common.b.h("sound_settings_speaker_rxns_key", "0");
    public static final com.viber.common.b.h p = new com.viber.common.b.h("sound_settings_speaker_ns_key", "0");
    public static final com.viber.common.b.h q = new com.viber.common.b.h("sound_settings_speaker_rxagc_key", "0");
    public static final com.viber.common.b.h r = new com.viber.common.b.h("sound_settings_speaker_agc_key", "0");
    public static final com.viber.common.b.h s = new com.viber.common.b.h("sound_settings_speaker_aec_key", "0");
    public static final com.viber.common.b.h t = new com.viber.common.b.h("sound_settings_codec_key", "0");
    public static final com.viber.common.b.h u = new com.viber.common.b.h("sound_settings_vve_debug_voice_rtpdebug_key", "0");
    public static final com.viber.common.b.h v = new com.viber.common.b.h("sound_settings_vve_debug_video_rtpdebug_key", "0");
    public static final com.viber.common.b.h w = new com.viber.common.b.h("sound_settings_vve_debug_video_capture_key", "0");
    public static final com.viber.common.b.a x = new com.viber.common.b.a("sound_settings_vve_debug_clear_key");
    public static final com.viber.common.b.h y = new com.viber.common.b.h("sound_settings_htc_hwaec", "0");
    public static final com.viber.common.b.h z = new com.viber.common.b.h("sound_settings_video_h264", "1");
  }

  public static class aw
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("stat_emails_reported", false);
  }

  public static class ax
  {
    public static final com.viber.common.b.b A = new com.viber.common.b.b("PREF_UPGRADE_DEFAULT_STICKER_PACKAGES", true);
    public static final com.viber.common.b.d a = new com.viber.common.b.d("STIKERS_DOWNLOAD_RESOLUTION", 0);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("STIKERS_ICON_DOWNLOAD_RESOLUTION", 0);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("STIKERS_COLOR_ICON_DOWNLOAD_RESOLUTION", 0);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("PORT_AVAILABLE_SCREEN_WIDTH", 0);
    public static final com.viber.common.b.d e = new com.viber.common.b.d("LAND_AVAILABLE_SCREEN_WIDTH", 0);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("pref_sticker_controller_version", -1);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("PREF_UPGRADE_STICKER_PACKAGES_NAME", true);
    public static final com.viber.common.b.b h = new com.viber.common.b.b("PREF_UPGRADE_STICKER_PACKAGES_WITH_SOUND", true);
    public static final com.viber.common.b.d i = new com.viber.common.b.d("pref_menu_content_switch", MessageComposerView.b.b.ordinal());
    public static final com.viber.common.b.d j = new com.viber.common.b.d("pref_package", 400);
    public static final com.viber.common.b.d k = new com.viber.common.b.d("pref_preiview_screen_package", 133600);
    public static final com.viber.common.b.d l = new com.viber.common.b.d("pref_downloaded_package", 400);
    public static final com.viber.common.b.h m = new com.viber.common.b.h("pack_count_last_modified_time", "");
    public static final com.viber.common.b.d n = new com.viber.common.b.d("watched_sticker_pack_count", 0);
    public static final com.viber.common.b.d o = new com.viber.common.b.d("all_sticker_pack_count", 0);
    public static final com.viber.common.b.h p = new com.viber.common.b.h("svg_sticker_mode", x.a.a.toString());
    public static final com.viber.common.b.h q = new com.viber.common.b.h("pref_sticker_clicker_packages", "");
    public static final com.viber.common.b.b r = new com.viber.common.b.b("enable_free_stickers_key", false);
    public static final com.viber.common.b.b s = new com.viber.common.b.b("PREF_MARKET_CONSUME_ON_DELETE_STICKER_PACKAGES", false);
    public static final com.viber.common.b.h t = new com.viber.common.b.h("sticker_cluster_id", "0");
    public static final com.viber.common.b.e u = new com.viber.common.b.e("sticker_cluster_id_next_request_time", 0L);
    public static final com.viber.common.b.b v = new com.viber.common.b.b("debug_emulate_sticker_load_oom_error", false);
    public static final com.viber.common.b.b w = new com.viber.common.b.b("pref_debug_sticker_clickers_fetching_custom_url_enabled", false);
    public static final com.viber.common.b.h x = new com.viber.common.b.h("pref_debug_sticker_clickers_fetching_custom_url", "");
    public static final com.viber.common.b.b y = new com.viber.common.b.b("display_ads_report_status", false);
    public static final i z = new i("sticker_pack_with_sound_ids", Collections.emptySet());
  }

  public static class ay
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("secure_storage_type", com.viber.voip.model.a.b.a());
    public static final com.viber.common.b.b b = new com.viber.common.b.b("secure_storage_back_migration_tried", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("debug_snappy_simulate_open_error", false);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("debug_snappy_simulate_read_error", false);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("debug_show_clear_local_data_on_manage_screen", false);
  }

  public static class az
  {

    @Deprecated
    public static final com.viber.common.b.h a = new com.viber.common.b.h("pref_server_selector", "prod");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("pref_fdd_server_name", "");
  }

  public static class b
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("last_registered_code", null);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("last_registered_number", null);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("used_resend_sms_attempts_map", null);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("activation_type", null);
    public static final b e = new b("registration_reminder_count", 0);
    public static final com.viber.common.b.e f = new com.viber.common.b.e("new_user_activation_date", 0L);
  }

  public static class ba
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("swipe_to_reply", 1);
  }

  public static class bb
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("badges_count", 0);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("public_badges_count", 0);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("community_badges_count", 0);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("marked_as_unread_conversations_count", 0);
    public static final com.viber.common.b.e e = new com.viber.common.b.e("latest_unread_public_messages_time", 0L);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("viber_news_new_badge", false);
    public static final com.viber.common.b.h g = new com.viber.common.b.h("json_watched", "");

    public static int a()
    {
      return 0;
    }
  }

  public static class bc
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("current_theme", ax.a.a());
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), R.string.pref_dark_theme_key, R.string.pref_dark_theme_default);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("debug_show_quick_theme_switcher", false);
  }

  public static final class bd
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("show_translation_tooltip", true);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("force_translation_tooltip", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("show_translation_dialog", true);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("translation_lang", Locale.getDefault().getLanguage());
  }

  public static class be
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("PREF_SUGGEST_UPDATE_LAST_VERS", "");
    public static final com.viber.common.b.b b = new com.viber.common.b.b("PREF_SUGGEST_UPDATE_SKIP", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("require_accept_terms_and_policies", false);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("terms_and_policies_state", com.viber.voip.notif.h.a);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("dummy_banned_gp", false);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("request_update_disable", false);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("disable_cancelable_require_update_dialog", false);
  }

  public static class bf
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("encryptedMemberId", "");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("display_name", "");
    public static final com.viber.common.b.h c = new com.viber.common.b.h("image_uri", "");
    public static final com.viber.common.b.b d = new com.viber.common.b.b("server_uploaded", true);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("name_server_uploaded", true);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("last_online_dirty", 1);
    public static final com.viber.common.b.e g = new com.viber.common.b.e("last_online_last_changed_time", 0L);
    public static final com.viber.common.b.b h = new com.viber.common.b.b("last_online_settings_enable_alarmed", false);
    public static final com.viber.common.b.b i = new com.viber.common.b.b("last_online_show_change_settings_dialog", false);
    public static final com.viber.common.b.b j = new com.viber.common.b.b(d.b(), d.f, R.string.pref_last_online_default);
    public static final com.viber.common.b.b k = new com.viber.common.b.b("show_report_user_location_option", false);
    public static final com.viber.common.b.d l = new com.viber.common.b.d("update_user_birthdate_request_sequence", 0);
    public static final com.viber.common.b.b m = new com.viber.common.b.b("need_fetch_user_birthdate_from_server", false);
    public static final com.viber.common.b.d n = new com.viber.common.b.d("receive_user_birthdate_latest_seq", -1);
    public static final com.viber.common.b.b o = new com.viber.common.b.b("is_reffered_install", false);
    public static final com.viber.common.b.d p = new com.viber.common.b.d("user_details_server_state_during_registration", 0);
  }

  public static class bg
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("pref_viber_id_email", "");
    public static final com.viber.common.b.d b = new com.viber.common.b.d("pref_viber_id_version", 0);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("pref_viber_id_registered_on_current_device", false);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("pref_viber_id_promo_json_config", "");
    public static final com.viber.common.b.h e = new com.viber.common.b.h("pref_viber_id_promo_stickers_json_last_modified_time", "");
    public static final com.viber.common.b.h f = new com.viber.common.b.h("pref_debug_viber_id_promo_stickers_json_url", ap.i(ap.d()));
    public static final com.viber.common.b.b g = new com.viber.common.b.b("pref_viber_id_show_details_updated_on_r_side_dialog", false);
    public static final com.viber.common.b.h h = new com.viber.common.b.h("pref_debug_viber_id_promo_stickers_sync_period", String.valueOf(ViberIdPromoStickerPackHelper.SYNC_VIBER_ID_PROMO_STICKERS_JSON_DELAY_MILLIS));
  }

  public static final class bh
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("vln_show_new_badge", true);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("vln_show_active_badge", false);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("vln_show_discoverability", 1);
  }

  public static final class bi
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("pref_debug_news_provider_id", 0);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("pref_debug_news_custom_url", "");
    public static final com.viber.common.b.d c = new com.viber.common.b.d("pref_debug_news_feed_orientation", 1);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("pref_debug_news_cache_time_millis", 0);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("pref_debug_news_open_article_on_new_screen", false);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("pref_debug_news_detect_article_strategy", 0);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("pref_debug_news_entry_point", 3);
  }

  public static class bj
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("vo_have_billing_account", false);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("PREF_VIBER_OUT_PRODUCT_IDS", null);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("PREF_VO_CUSTOM_BASE_URL", a());
    public static final com.viber.common.b.h d = new com.viber.common.b.h("PREF_VIBER_OUT_BALANCE", "");
    public static final com.viber.common.b.c e = new com.viber.common.b.c("PREF_VIBER_OUT_BALANCE_VALUE", 0.0F);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("PREF_VIBER_OUT_CALLING_PLANS_COUNT", 0);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("VIBER_OUT_SHOULD_WARN_ABOUT_LOW_BALANCE", false);
    public static final com.viber.common.b.e h = new com.viber.common.b.e("VIBER_OUT_LAST_BALANCE_FETCH_TIME", 0L);
    public static final com.viber.common.b.b i = new com.viber.common.b.b("viber_out_use_legacy_dialog", false);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("viber_out_show_more_plans", false);
    public static final com.viber.common.b.b k = new com.viber.common.b.b("viber_out_use_fyber", false);
    public static final com.viber.common.b.h l = new com.viber.common.b.h("VIBER_OUT_TOP_AB_COUNTRIES", null);
    public static final com.viber.common.b.h m = new com.viber.common.b.h("VIBER_OUT_TOP_VIBER_OUT_CALLS_COUNTRIES", null);
    public static final com.viber.common.b.h n = new com.viber.common.b.h("VIBER_OUT_TOP_VIBER_CALLS_COUNTRIES", null);
    public static final com.viber.common.b.d o = new com.viber.common.b.d("PRODUCTS_DEFAULT_TAB", 0);
    public static final com.viber.common.b.b p = new com.viber.common.b.b("WORLD_CREDTINS_TOOLTIP", true);
    public static final com.viber.common.b.b q = new com.viber.common.b.b(d.b(), R.string.pref_referral_enabled_key, R.string.pref_referral_enabled_default);
    public static final com.viber.common.b.e r = new com.viber.common.b.e("restore_purchase_interval_start_time", 0L);
    public static final com.viber.common.b.d s = new com.viber.common.b.d("restore_purchase_interval_attempts", 0);

    private static String a()
    {
      return ap.a(ap.d());
    }
  }

  public static class bk
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("viber_wallet_base_url", ap.c(ap.d()));
    public static final com.viber.common.b.b b = new com.viber.common.b.b("viber_wallet_debug_use_test_page", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("viber_wallet_debug_use_bridge_security", true);
  }

  public static class bl
  {
    public static final com.viber.common.b.e a = new com.viber.common.b.e("ivm_heart_shape_start_date", f.getTimeInMillis());
    public static final com.viber.common.b.e b = new com.viber.common.b.e("ivm_heart_shape_end_date", f.getTimeInMillis() + g);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("debug_ivm_heart_shape_valid_days", String.valueOf(g));
    public static final com.viber.common.b.h d = new com.viber.common.b.h("pref_video_ptt_video_bitrate", "2000000");
    public static final com.viber.common.b.d e = new com.viber.common.b.d("ivm_max_duration_mills", 20000);
    private static final Calendar f;
    private static final long g = TimeUnit.DAYS.toMillis(5L);

    static
    {
      f = Calendar.getInstance();
      f.set(2019, 1, 11, 0, 0, 0);
    }
  }

  public static class bm
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("wallet_type", "wu");
    public static final com.viber.common.b.d b = new com.viber.common.b.d("wallet_service_id", 5002);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("wallet_revision", 0);
    public static final com.viber.common.b.e d = new com.viber.common.b.e("wallet_updated", 0L);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("wallet_is_whitelist", true);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("wallet_support_payments", false);
    public static final com.viber.common.b.h g = new com.viber.common.b.h("wallet_base_url", ap.b(ap.d()));
    public static final com.viber.common.b.h h = new com.viber.common.b.h("wallet_json_url", ap.d(ap.d()));
    public static final com.viber.common.b.b i = new com.viber.common.b.b("wallet_debug_update", false);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("rakuten_wallet_new_fuature", true);
    public static final com.viber.common.b.h k = new com.viber.common.b.h("wallet_json_last_modified_time", "");

    public static class a
    {
      public static final com.viber.common.b.b a = new com.viber.common.b.b("wallet_wu_first_welcome", true);
      public static final com.viber.common.b.b b = new com.viber.common.b.b("wallet_wu_first_transaction", true);
      public static final com.viber.common.b.b c = new com.viber.common.b.b("wallet_wu_agreement_accepted", false);
      public static final com.viber.common.b.b d = new com.viber.common.b.b("wallet_wu_enable_debug", false);
      public static final com.viber.common.b.h e = new com.viber.common.b.h("wallet_type_debug", "");
    }
  }

  public static class bn
  {
    public static final com.viber.common.b.e a = new com.viber.common.b.e("pref_wasabi_update_happened_date", 0L);
    public static final com.viber.common.b.e b = new com.viber.common.b.e("wasabi_update_interval_sec", TimeUnit.HOURS.toSeconds(24L));
    public static final com.viber.common.b.h c = new com.viber.common.b.h("wasabi_update_interval_sec_debug", String.valueOf(TimeUnit.HOURS.toSeconds(24L)));
    public static final com.viber.common.b.h d = new com.viber.common.b.h("wasabi_base_url", ap.p(ap.d()));
  }

  public static final class c
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("adinfo_gender_pref", 0);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("adinfo_age_pref", "");
    public static final com.viber.common.b.e c = new com.viber.common.b.e("adinfo_next_update_time_pref", -1L);
  }

  public static final class d
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("debug_appnexus_logging", true);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("debug_appnexus_use_sdk_browser", false);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("debug_show_video_ads_button", false);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("debug_ads_native_error_simulation", 0);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("debug_goole_ad_withou_image_simulation", false);
    public static final com.viber.common.b.h f = new com.viber.common.b.h("debug_google_mediation_sdk", null);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("debug_ad_expiration_time", -1);
  }

  public static class e
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("advertising_id", "");
    public static final com.viber.common.b.b b = new com.viber.common.b.b("advertising_limited", false);
  }

  public static class f
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("appboy_campaigns_enabled", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), d.a, R.string.pref_google_analytics_default);
    public static final com.viber.common.b.b c = new com.viber.common.b.b(d.b(), d.b, R.string.pref_allow_content_personalization_default);
    public static final com.viber.common.b.b d = new com.viber.common.b.b(d.b(), d.c, R.string.pref_allow_interest_based_ads_default);
    public static final com.viber.common.b.b e = new com.viber.common.b.b(d.b(), d.d, R.string.pref_allow_location_based_services_default);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("PREF_ADJUST_SINGLE_REPORTING_ON", true);
    public static final com.viber.common.b.b g = new com.viber.common.b.b("pref_sticker_purchaser", false);
    public static final com.viber.common.b.b h = new com.viber.common.b.b("pref_dark_mode_cdr", false);
    public static final com.viber.common.b.b i = new com.viber.common.b.b("PREF_ADX_TABLE_USED_BY_ADJUST", false);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("PREF_MIXPANEL_USE_DEBUG_ACCOUNT", false);
    public static final com.viber.common.b.d k = new com.viber.common.b.d("PREF_APPBOY_BANNER_POSITION_INDEX", com.appboy.b.a.h.b.ordinal());
    public static final com.viber.common.b.h l = new com.viber.common.b.h(d.b(), R.string.pref_appboy_api_key, R.string.com_appboy_api_key);
    public static final com.viber.common.b.d m = new com.viber.common.b.d("appboy_sp_version", 0);
    public static final com.viber.common.b.e n = new com.viber.common.b.e("dest_report_time", 0L);
    public static final com.viber.common.b.b o = new com.viber.common.b.b("appboy_top5_ab_countries_reported", false);
    public static final com.viber.common.b.d p = new com.viber.common.b.d("appboy_fresh_user_det", 0);
    public static final com.viber.common.b.b q = new com.viber.common.b.b("has_desktop", false);
    public static final com.viber.common.b.h r = new com.viber.common.b.h("mixpanel_identifier", "");
    public static final com.viber.common.b.d s = new com.viber.common.b.d("mixpanel_braze_integration_hash", 0);
    public static final com.viber.common.b.h t = new com.viber.common.b.h("debug_mixpanel_identifier_postfix", "");
    public static final com.viber.common.b.h u = new com.viber.common.b.h("debug_mixpanel_endpoint", "");
  }

  public static class g
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("APPS_API_SUPPORTED", false);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("user_activity_dirty", 1);
    public static final com.viber.common.b.b c = new com.viber.common.b.b("recover_apps_info_v1_pref", true);
    public static final com.viber.common.b.b d = new com.viber.common.b.b("click_macro_always_on", false);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("unregister_apps_on_uninstall", true);
    public static final com.viber.common.b.h f = new com.viber.common.b.h("debug_apps_info_sync_period_seconds", Long.toString(TimeUnit.HOURS.toSeconds(24L)));
  }

  public static final class h
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("feed_auth_token", null);
  }

  public static class i
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("PREF_BACKGROUNDS_REVISION", 0);
    public static final com.viber.common.b.e b = new com.viber.common.b.e("PREF_LAST_BG_CONFIG_UPDATE", 0L);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("PREF_COUNT_BACKGROUNDS", 0);
    public static final com.viber.common.b.h d = new com.viber.common.b.h("default_background_portrait", "");
    public static final com.viber.common.b.h e = new com.viber.common.b.h("default_background_landscape", "");
    public static final com.viber.common.b.b f = new com.viber.common.b.b(d.b(), R.string.pref_default_background_key, R.string.pref_default_background_value);
    public static final com.viber.common.b.h g = new com.viber.common.b.h("pref_default_background_id", "c10000999");
    public static final com.viber.common.b.h h = new com.viber.common.b.h("pref_debug_backgrounds_config_json_url", a());
    public static final com.viber.common.b.h i = new com.viber.common.b.h("bg_config_last_modified_time", "");
    public static final com.viber.common.b.b j = new com.viber.common.b.b("anim_bg_change_slowly", false);

    private static String a()
    {
      return ap.e(ap.d());
    }
  }

  public static final class j
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h(d.b(), R.string.pref_backup_account_key, null);
    public static final com.viber.common.b.h b = new com.viber.common.b.h(d.b(), R.string.pref_last_backup_id_key, null);
    public static final com.viber.common.b.e c = new com.viber.common.b.e(d.b().getString(R.string.pref_last_backup_info_check_key), 0L);
    public static final com.viber.common.b.e d = new com.viber.common.b.e(d.b().getString(R.string.pref_last_backup_update_key), 0L);
    public static final com.viber.common.b.e e = new com.viber.common.b.e(d.b().getString(R.string.pref_last_backup_size_key), 0L);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("pref_last_backup_metadata_version_key", 0);
    public static final com.viber.common.b.e g = new com.viber.common.b.e(d.b().getString(R.string.pref_auto_backup_period_key), com.viber.voip.backup.a.a.a());
    public static final com.viber.common.b.e h = new com.viber.common.b.e("pref_auto_backup_promotion_displayed_date_key", 0L);
    public static final com.viber.common.b.d i = new com.viber.common.b.d("pref_auto_backup_promotion_displayed_viber_version", 0);
    public static final com.viber.common.b.d j = new com.viber.common.b.d("pref_auto_backup_retry_attempts_on_start", -1);
    public static final com.viber.common.b.e k = new com.viber.common.b.e("pref_auto_backup_happened_date", 0L);
    public static final com.viber.common.b.b l = new com.viber.common.b.b("pref_update_backup_metadata", false);
    public static final com.viber.common.b.b m = new com.viber.common.b.b("email_message_history", false);
    public static final com.viber.common.b.b n = new com.viber.common.b.b(d.b(), R.string.pref_restore_completed_key, false);
    public static final com.viber.common.b.b o = new com.viber.common.b.b(d.b(), R.string.pref_debug_show_backup_restore_duration_key, false);
    public static final com.viber.common.b.h p = new com.viber.common.b.h("debug_send_sync_history_approve_request_with_token", "");
  }

  public static class k
  {
    public static final com.viber.common.b.e a = new com.viber.common.b.e("notifications_off_banner_min_time_to_display", 0L);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("show_notifications_off_banner", false);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("current_banner_mode_on_chats_screen", 0);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("current_banner_mode_on_calls_screen", 0);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("debug_notifications_off_close_delay", false);
    public static final com.viber.common.b.e f = new com.viber.common.b.e("show_notifications_off_splash_time", 0L);
    public static final b g = new b("notifications_off_display_counter", 0);
    public static final com.viber.common.b.b h = new com.viber.common.b.b("do_not_show_notifications_off_banner_again", false);
    public static final com.viber.common.b.b i = new com.viber.common.b.b("debug_do_not_show_notifications_off_banner_cb_visible", false);
  }

  public static final class l
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("business_inbox_state_hash_pref", 0);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("can_send_business_inbox_promotion_message", true);
    public static final com.viber.common.b.e c = new com.viber.common.b.e("business_inbox_autoclean_period", TimeUnit.HOURS.toSeconds(24L));
    public static final com.viber.common.b.e d = new com.viber.common.b.e("business_inbox_autoclean_max_message_age", TimeUnit.DAYS.toMillis(30L));
    public static final com.viber.common.b.b e = new com.viber.common.b.b("delete_business_inbox", false);
  }

  public static class m
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b(d.b(), R.string.pref_use_system_ringtone_key, R.string.pref_use_system_ringtone_default);
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), R.string.pref_vibrate_when_ringing_key, R.string.pref_vibrate_when_ringing_default);
    public static final com.viber.common.b.h c = new com.viber.common.b.h(d.b(), R.string.pref_call_ringtone_key, Settings.System.DEFAULT_RINGTONE_URI.toString());
    public static final com.viber.common.b.b d = new com.viber.common.b.b("dialpad_vibrate", true);
    public static final com.viber.common.b.b e = new com.viber.common.b.b(d.b(), R.string.pref_viber_calls_in_force_key, R.string.pref_viber_calls_in_force_default);
    public static final com.viber.common.b.b f = new com.viber.common.b.b(d.b(), R.string.pref_viber_calls_in_key, R.string.pref_viber_calls_in_default);
    public static final com.viber.common.b.b g = new com.viber.common.b.b(d.b(), R.string.pref_viber_calls_in_dialog_shown_key, R.string.pref_viber_calls_in_dialog_shown_default);
    public static final com.viber.common.b.b h = new com.viber.common.b.b(d.b(), R.string.pref_hd_video_calls_key, R.string.pref_hd_video_calls_default);
    public static final com.viber.common.b.b i = new com.viber.common.b.b(d.b(), R.string.pref_viber_calls_not_viber_force_key, R.string.pref_viber_calls_not_viber_force_default);
    public static final com.viber.common.b.b j = new com.viber.common.b.b("webrtc_ec_enabled", true);
    public static final com.viber.common.b.b k = new com.viber.common.b.b(d.b(), R.string.pref_proximity_turn_off_screen, ViberApplication.getInstance().getDevicesManager().a());
    public static final com.viber.common.b.d l = new com.viber.common.b.d("call_min_time_count", -1);
    public static final com.viber.common.b.h m = new com.viber.common.b.h("capture_device_list", "");
    public static final com.viber.common.b.b n = new com.viber.common.b.b("pref_debug_ads_fetching_custom_url_enabled", false);
    public static final com.viber.common.b.h o = new com.viber.common.b.h("pref_debug_ads_fetching_custom_url", "");
    public static final com.viber.common.b.b p = new com.viber.common.b.b("pref_debug_display_ads_report_status_after_calls", false);
    public static final com.viber.common.b.h q = new com.viber.common.b.h("pref_debug_ads_custom_placement_id", "");
    public static final com.viber.common.b.h r = new com.viber.common.b.h("pref_debug_ads_custom_ad_refresh_time", "");
    public static final com.viber.common.b.b s = new com.viber.common.b.b("pref_debug_force_obtain_user_details_from_participant_info", false);
    public static final com.viber.common.b.e t = new com.viber.common.b.e("audio_conference_2_weeks_after_release_date", 0L);
    public static final com.viber.common.b.d u = new com.viber.common.b.d("audio_conference_number", 1);
    public static final com.viber.common.b.b v = new com.viber.common.b.b("show_conversation_group_call_tooltip", true);
    public static final com.viber.common.b.d w = new com.viber.common.b.d("conference_max_members", 5);
    public static final com.viber.common.b.h x = new com.viber.common.b.h("opus_bitrate", "12000");
    public static final com.viber.common.b.b y = new com.viber.common.b.b("transport_cc_audio", false);
    public static final com.viber.common.b.h z = new com.viber.common.b.h("ptime", "60");
  }

  public static final class n
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("chat_ex_emphasize_enabled", false);
    public static final com.viber.common.b.e b = new com.viber.common.b.e("last_sync_chat_extensions_meta_data_time", 0L);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("last_used_chat_ex_id", "");
    public static final com.viber.common.b.h d = new com.viber.common.b.h("chat_ex_pa_id", "");
    public static final com.viber.common.b.h e = new com.viber.common.b.h("chat_ex_last_viewed_uri", "");
    public static final com.viber.common.b.h f = new com.viber.common.b.h("list_chat_extensions_uris", "");

    @Deprecated
    public static final com.viber.common.b.h g = new com.viber.common.b.h("list_chat_ex_meta", "");
    public static final com.viber.common.b.b h = new com.viber.common.b.b("show_carrier_zero_rate_dialog_chat_ex", true);
    public static final com.viber.common.b.e i = new com.viber.common.b.e("chat_ex_new_service_indication_set_time", 0L);
    public static final com.viber.common.b.h j = new com.viber.common.b.h("chat_ex_favorite_links_bot_uri", "");
    public static final com.viber.common.b.b k = new com.viber.common.b.b("chatex_redesign_user", false);
    public static final com.viber.common.b.d l = new com.viber.common.b.d("chatex_suggestions_tooltip_shown_count", 0);
    public static final com.viber.common.b.h m = new com.viber.common.b.h("debug_suggestions_json_url", ap.q(ap.d()));
    public static final com.viber.common.b.h n = new com.viber.common.b.h("suggestions_json_last_modified_time", "");
    public static final com.viber.common.b.h o = new com.viber.common.b.h(a.b.s.c(), "");
  }

  public static final class o
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("first_community_created", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("debug_ignore_public_group_change", false);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("pref_community_latest_unsent_mute_reply_data_seq", -1);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("pref_community_latest_unsent_mute_request_data_seq", -1);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("pref_get_my_community_settings_pending", false);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("debug_attach_invitation_info_to_message", false);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("debug_community_members_count_threshold_to_add_referral", 500);
  }

  public static class p
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("AddressBookVersion", 1);
    public static final com.viber.common.b.b b = new com.viber.common.b.b(d.b(), R.string.pref_contact_joined_viber_key, R.string.pref_contact_joined_viber_default);
    public static final com.viber.common.b.b c = new com.viber.common.b.b(d.b(), R.string.pref_contact_show_all_key, R.string.pref_contact_show_all_default);
    public static final com.viber.common.b.a d = new com.viber.common.b.a(d.b(), R.string.pref_block_list_key);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("PREF_CONTCATS_SYNC_ACCOUT_SYNCING", false);
    public static final com.viber.common.b.b f = new com.viber.common.b.b("PREF_CONTCATS_SYNC_ACCOUT_REQUEST", true);
    public static final com.viber.common.b.b g = new com.viber.common.b.b(d.b(), R.string.pref_account_and_sync_key, R.string.pref_account_and_sync_default);
    public static final com.viber.common.b.d h = new com.viber.common.b.d("contacts_filter", b.b.b.ordinal());
    public static final com.viber.common.b.d i = new com.viber.common.b.d("ViberAccountVersion", 1);
    public static final com.viber.common.b.h j = new com.viber.common.b.h("selected_account", null);
    public static final com.viber.common.b.d k = new com.viber.common.b.d("pref_sync_account_connector_version", -1);
    public static final com.viber.common.b.b l = new com.viber.common.b.b("preff_dialog_failed_shown", false);
    public static final com.viber.common.b.b m = new com.viber.common.b.b("pref_block_list_dirty_bit", true);
    public static final com.viber.common.b.h n = new com.viber.common.b.h("pref_engagement_expired_period", String.valueOf(com.viber.voip.util.b.c.a));
    public static final com.viber.common.b.h o = new com.viber.common.b.h("pref_debug_engagement_stickers_json_url", a());
    public static final com.viber.common.b.h p = new com.viber.common.b.h("pref_engagement_json_sync_period", String.valueOf(com.viber.voip.util.b.c.b));
    public static final com.viber.common.b.h q = new com.viber.common.b.h("pref_engagement_json_last_modified_time", "");
    public static final com.viber.common.b.h r = new com.viber.common.b.h("pref_engagement_json_config", "");
    public static final com.viber.common.b.d s = new com.viber.common.b.d("pref_emid_mapping_state", 3);
    public static final com.viber.common.b.d t = new com.viber.common.b.d("pref_participants_emid_mapping_state", 3);
    public static final com.viber.common.b.d u = new com.viber.common.b.d("pref_debug_latest_viber_contacts_count", -1);
    public static final com.viber.common.b.d v = new com.viber.common.b.d("pref_viber_contacts_count", 0);

    private static String a()
    {
      return ap.h(ap.d());
    }
  }

  public static class q
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("sync_success_seq", -1);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("sync_las_seq", -1);
    public static final com.viber.common.b.d c = new com.viber.common.b.d("seq", 100);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("sync_state", 0);
    public static final com.viber.common.b.b e = new com.viber.common.b.b("recanonization_in_progress", false);
  }

  public static class r
  {
    public static final com.viber.common.b.d A;
    public static final com.viber.common.b.b B;
    public static final com.viber.common.b.e C;
    public static final com.viber.common.b.b D;
    public static final com.viber.common.b.b E;
    public static final com.viber.common.b.b F;
    public static final com.viber.common.b.b G;
    public static final com.viber.common.b.b H;
    public static final com.viber.common.b.b I;
    public static final com.viber.common.b.b J;
    public static final com.viber.common.b.b K;
    public static final com.viber.common.b.b a;
    public static final com.viber.common.b.b b;
    public static final com.viber.common.b.a c;
    public static final com.viber.common.b.a d;
    public static final com.viber.common.b.h e;
    public static final com.viber.common.b.d f;
    public static final com.viber.common.b.d g;
    public static final com.viber.common.b.b h;
    public static final com.viber.common.b.b i;
    public static final com.viber.common.b.b j;
    public static final com.viber.common.b.b k;
    public static final com.viber.common.b.d l;
    public static final com.viber.common.b.d m;
    public static final i n;
    public static final com.viber.common.b.d o;
    public static final com.viber.common.b.h p;
    public static final com.viber.common.b.h q;
    public static final com.viber.common.b.h r;
    public static final com.viber.common.b.h s;
    public static final com.viber.common.b.b t;
    public static final com.viber.common.b.b u;
    public static final com.viber.common.b.d v;
    public static final com.viber.common.b.b w;
    public static final com.viber.common.b.b x;
    public static final com.viber.common.b.b y;
    public static final com.viber.common.b.b z;

    static
    {
      boolean bool = true;
      a = new com.viber.common.b.b(d.b(), R.string.pref_enter_to_send_key, Build.HARDWARE.equals("arc"));
      b = new com.viber.common.b.b(d.b(), R.string.pref_receive_location_based_messages_key, R.string.pref_receive_location_based_messages_default);
      c = new com.viber.common.b.a(d.b(), R.string.pref_email_msg_history_key);
      d = new com.viber.common.b.a(d.b(), R.string.pref_clear_msg_history_key);
      e = new com.viber.common.b.h("pref_set_socks5_proxy_key", "");
      f = new com.viber.common.b.d("keyboard_height_portrait", ExpandablePanelLayout.a);
      g = new com.viber.common.b.d("keyboard_height_landscape", ExpandablePanelLayout.a);
      h = new com.viber.common.b.b("need_recover_groups", bool);
      i = new com.viber.common.b.b("need_recover_public_accounts", bool);
      j = new com.viber.common.b.b("spam_control", false);
      k = new com.viber.common.b.b("time_bomb_warning_dialog", bool);
      l = new com.viber.common.b.d("default_message_send_button", 4);
      m = new com.viber.common.b.d("number_audio_video_ptt_switches_in_row", 0);
      n = new i("keyboard_extension_feature_disabled_names", Collections.emptySet());
      o = new com.viber.common.b.d("number_send_engagement_sticker_packs", 0);
      p = new com.viber.common.b.h(d.b(), R.string.pref_share_and_shop_public_account_id_key, "");
      q = new com.viber.common.b.h("share_and_shop_keyboard_data", "");
      r = new com.viber.common.b.h("share_and_shop_catalog_override", "");
      s = new com.viber.common.b.h("share_and_shop_server_override", "");
      t = new com.viber.common.b.b("share_and_shop_new_install_tracked", false);
      u = new com.viber.common.b.b("disable_secret_chat_screenshot_protection", false);
      v = new com.viber.common.b.d("embedded_media_support_state", 0);
      w = new com.viber.common.b.b("sticker_search_icon_engagement", bool);
      x = new com.viber.common.b.b("show_carrier_zero_rate_dialog_gifs", bool);
      y = new com.viber.common.b.b("show_deleted_messages", false);
      z = new com.viber.common.b.b("debug_small_timeout", false);
      A = new com.viber.common.b.d("debug_broadcast_list_max_number_of_recipients", 50);
      B = new com.viber.common.b.b(d.b(), R.string.pref_receive_business_messages_key, R.string.pref_receive_business_messages_default);
      C = new com.viber.common.b.e("ftue_search_msg_end_time", 0L);
      D = new com.viber.common.b.b("open_links_pref_manually_changed", false);
      Resources localResources = d.b();
      int i1 = R.string.pref_screenshot_editing_key;
      if (!com.viber.common.d.a.m());
      while (true)
      {
        E = new com.viber.common.b.b(localResources, i1, bool);
        F = new com.viber.common.b.b("show_share_viber_chats_trigger", false);
        G = new com.viber.common.b.b("emulate_send_message_error_reply", false);
        H = new com.viber.common.b.b("force_30_sec_snooze_life", false);
        I = new com.viber.common.b.b("timeout_for_cs", false);
        J = new com.viber.common.b.b("show_create_poll_tooptip", false);
        K = new com.viber.common.b.b("was_community_poll_snackbar_shown", false);
        return;
        bool = false;
      }
    }
  }

  public static class s
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("debug_dont_keep_scene_state", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("show_promo_icon_on_preview", false);
  }

  public static final class t
  {
    public static final com.viber.common.b.d a = new com.viber.common.b.d("engagement_say_hi_default_media_type", 1);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("engagement_say_hi_suggested_contacts", true);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("pref_say_hi_engagement_json_last_modified_time", "");
    public static final com.viber.common.b.h d = new com.viber.common.b.h("pref_debug_say_hi_engagement_stickers_json_url", ap.j(ap.d()));
    public static final com.viber.common.b.h e = new com.viber.common.b.h("pref_debug_say_hi_engagement_json_sync_period", String.valueOf(com.viber.voip.util.b.c.b));
    public static final com.viber.common.b.h f = new com.viber.common.b.h("pref_say_hi_engagement_json_config", "");
    public static final com.viber.common.b.b g = new com.viber.common.b.b("say_hi_suggested_sent", false);
    public static final b h = new b("say_hi_engagement_auto_display_count", 0);
    public static final com.viber.common.b.e i = new com.viber.common.b.e("say_hi_engagement_auto_display_last_time", 0L);
    public static final com.viber.common.b.h j = new com.viber.common.b.h("debug_say_hi_engagement_auto_display_expire_period_millis", String.valueOf(TimeUnit.HOURS.toMillis(24L)));
    public static final com.viber.common.b.h k = new com.viber.common.b.h("pref_debug_marketing_engagement_stickers_json_url", ap.k(ap.d()));
  }

  public static final class u
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("gcm_token", "");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("gcm_ext_token", "");
    public static final com.viber.common.b.d c = new com.viber.common.b.d("gcm_reg_version", 0);
    public static final com.viber.common.b.d d = new com.viber.common.b.d("gcm_ext_reg_version", 0);
  }

  public static class v
  {
    public static final com.viber.common.b.a a = new com.viber.common.b.a(d.b(), R.string.pref_request_your_data_key);
    public static final com.viber.common.b.a b = new com.viber.common.b.a(d.b(), R.string.pref_delete_your_data_key);
    public static final com.viber.common.b.a c = new com.viber.common.b.a(d.b(), R.string.pref_personal_data_key);
    public static final com.viber.common.b.a d = new com.viber.common.b.a(d.b(), R.string.pref_manage_ads_key);
    public static final com.viber.common.b.d e = new com.viber.common.b.d("pref_gdpr_request_your_data_default_response", -2147483648);
    public static final com.viber.common.b.d f = new com.viber.common.b.d("pref_gdpr_delete_your_data_default_response", -2147483648);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("pref_gdpr_delete_data_default_limit_days", 14);
    public static final com.viber.common.b.d h = new com.viber.common.b.d("pref_gdpr_selected_user_age_kind", 0);
    public static final com.viber.common.b.e i = new com.viber.common.b.e("pref_gdpr_selected_user_birthdate_millis", -9223372036854775808L);
    public static final com.viber.common.b.d j = new com.viber.common.b.d("pref_gdpr_latest_unsent_reply_data_seq", -1);
    public static final com.viber.common.b.b k = new com.viber.common.b.b("pref_gdpr_need_force_send_reply_data", false);
    public static final com.viber.common.b.e l = new com.viber.common.b.e("pref_gdpr_latest_connect_time", -1L);
    public static final com.viber.common.b.d m = new com.viber.common.b.d("pref_gdpr_latest_unsent_request_data_seq", -1);
    public static final com.viber.common.b.b n = new com.viber.common.b.b("pref_gdpr_need_force_send_request_data", false);
    public static final com.viber.common.b.b o = new com.viber.common.b.b("pref_gdpr_use_short_request_data_timeout", false);
    public static final com.viber.common.b.b p = new com.viber.common.b.b("pref_location_based_services_toggle_interacted", false);
    public static final com.viber.common.b.h q = new com.viber.common.b.h("gdpr_consent_string", "");
    public static final com.viber.common.b.d r = new com.viber.common.b.d("gdpr_consent_string_last_version", 1);
    public static final com.viber.common.b.d s = new com.viber.common.b.d("gdpr_consent_string_accepted_version", 0);
    public static final com.viber.common.b.b t = new com.viber.common.b.b("debug_gdpr_consent_string_test_page", false);
    public static final com.viber.common.b.b u = new com.viber.common.b.b("gdpr_consent_google", true);
  }

  public static class w
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("html5_game_app_id", "1035");
    public static final com.viber.common.b.h b = new com.viber.common.b.h("html5_game_identity", "Bmdeq9aHeOoVtE7gS3B07tfj7Bc=");
    public static final com.viber.common.b.h c = new com.viber.common.b.h("html5_game_permission", "7");
    public static final com.viber.common.b.h d = new com.viber.common.b.h("html5_game_url", "");
  }

  public static class x
  {
    public static final com.viber.common.b.h a = new com.viber.common.b.h("pref_keychain_account", null);
    public static final com.viber.common.b.d b = new com.viber.common.b.d("pref_keychain_backup_state", 0);
    public static final com.viber.common.b.e c = new com.viber.common.b.e("pref_keychain_modified_date", 0L);
  }

  public static class y
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("pref_one_time_dl_crash", false);
    public static final com.viber.common.b.h b = new com.viber.common.b.h("log_level", com.viber.common.a.e.a.a.name());
  }

  public static class z
  {
    public static final com.viber.common.b.b a = new com.viber.common.b.b("PREF_MARKET_PRODUCTS_SYNCED", false);
    public static final com.viber.common.b.b b = new com.viber.common.b.b("PREF_MARKET_ENABLE_URL_CHANGE", false);
    public static final com.viber.common.b.h c = new com.viber.common.b.h("PREF_MARKET_API_CUSTOM_URL", b());
    public static final com.viber.common.b.h d = new com.viber.common.b.h("pref_market_base_custom_url", a());
    public static final com.viber.common.b.h e = new com.viber.common.b.h("stickers_games_update_period_key", String.valueOf(TimeUnit.HOURS.toSeconds(8L)));
    public static final com.viber.common.b.d f = new com.viber.common.b.d("PREF_MARKET_VISIT_COUNT", 0);
    public static final com.viber.common.b.d g = new com.viber.common.b.d("PREF_GAMES_MARKET_VISIT_COUNT", 0);
    public static final com.viber.common.b.d h = new com.viber.common.b.d("PREF_VO_PURCHASE_DIALOG_VISIT_COUNT", 0);
    public static final com.viber.common.b.d i = new com.viber.common.b.d("PREF_VO_CC_CHECKOUT_VISIT_COUNT", 0);
    public static final com.viber.common.b.d j = new com.viber.common.b.d("PREF_VO_WELCOME_VISIT_COUNT", 0);
    public static final com.viber.common.b.d k = new com.viber.common.b.d("PREF_VO_CALLING_PLAN_VISIT_COUNT", 0);
    public static final com.viber.common.b.d l = new com.viber.common.b.d("PREF_VO_CALLING_PLAN_SUGGESTION_VISIT_COUNT", 0);
    public static final com.viber.common.b.d m = new com.viber.common.b.d("PREF_VO_COUPONS_VISIT_COUNT", 0);
    public static final com.viber.common.b.h n = new com.viber.common.b.h("pref_sticker_market_web_flags", null);
    public static final com.viber.common.b.h o = new com.viber.common.b.h("pref_debug_web_flags", null);

    private static String a()
    {
      return ap.l(ap.d());
    }

    private static String b()
    {
      return ap.m(ap.d());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.d
 * JD-Core Version:    0.6.2
 */