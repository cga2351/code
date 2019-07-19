package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.a.a;
import com.appboy.f.c;
import java.util.EnumSet;
import java.util.Set;
import org.json.JSONArray;

public class gj
{
  private static final String a = c.a(gj.class);
  private final SharedPreferences b;

  public gj(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("com.appboy.override.configuration.cache", 0);
  }

  private static void a(SharedPreferences.Editor paramEditor, String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return;
    paramEditor.putBoolean(paramString, paramBoolean.booleanValue());
  }

  private static void a(SharedPreferences.Editor paramEditor, String paramString, Integer paramInteger)
  {
    if (paramInteger == null)
      return;
    paramEditor.putInt(paramString, paramInteger.intValue());
  }

  private static void a(SharedPreferences.Editor paramEditor, String paramString1, String paramString2)
  {
    if (paramString2 == null)
      return;
    paramEditor.putString(paramString1, paramString2);
  }

  private static void a(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet)
  {
    if (paramSet == null)
      return;
    paramEditor.putStringSet(paramString, paramSet);
  }

  public int a(String paramString, int paramInt)
  {
    return this.b.getInt(paramString, paramInt);
  }

  public String a(String paramString1, String paramString2)
  {
    return this.b.getString(paramString1, paramString2);
  }

  public Set<String> a(String paramString, Set<String> paramSet)
  {
    return this.b.getStringSet(paramString, paramSet);
  }

  public void a()
  {
    c.b(a, "Clearing Braze Override configuration cache");
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.clear();
    localEditor.apply();
  }

  void a(SharedPreferences.Editor paramEditor, String paramString, Enum paramEnum)
  {
    if (paramEnum == null)
      return;
    a(paramEditor, paramString, paramEnum.toString());
  }

  public void a(a parama)
  {
    c.c(a, "Setting Braze Override configuration with config: " + parama);
    SharedPreferences.Editor localEditor = this.b.edit();
    a(localEditor, "com_appboy_api_key", parama.a());
    a(localEditor, "com_appboy_server_target", parama.q());
    a(localEditor, "com_appboy_sdk_flavor", parama.r());
    a(localEditor, "com_appboy_newsfeed_unread_visual_indicator_on", parama.m());
    a(localEditor, "com_appboy_custom_endpoint", parama.d());
    a(localEditor, "com_appboy_push_small_notification_icon", parama.b());
    a(localEditor, "com_appboy_push_large_notification_icon", parama.c());
    a(localEditor, "com_appboy_session_timeout", parama.e());
    a(localEditor, "com_appboy_default_notification_accent_color", parama.f());
    a(localEditor, "com_appboy_trigger_action_minimum_time_interval_seconds", parama.g());
    a(localEditor, "com_appboy_push_adm_messaging_registration_enabled", parama.h());
    a(localEditor, "com_appboy_handle_push_deep_links_automatically", parama.i());
    a(localEditor, "com_appboy_notifications_enabled_tracking_on", parama.j());
    a(localEditor, "com_appboy_disable_location_collection", parama.k());
    a(localEditor, "com_appboy_data_flush_interval_bad_network", parama.n());
    a(localEditor, "com_appboy_data_flush_interval_good_network", parama.o());
    a(localEditor, "com_appboy_data_flush_interval_great_network", parama.p());
    a(localEditor, "com_appboy_default_notification_channel_name", parama.s());
    a(localEditor, "com_appboy_default_notification_channel_description", parama.t());
    a(localEditor, "com_appboy_push_deep_link_back_stack_activity_enabled", parama.u());
    a(localEditor, "com_appboy_push_deep_link_back_stack_activity_class_name", parama.v());
    a(localEditor, "com_appboy_session_start_based_timeout_enabled", parama.w());
    a(localEditor, "com_appboy_firebase_cloud_messaging_registration_enabled", parama.x());
    a(localEditor, "com_appboy_firebase_cloud_messaging_sender_id", parama.y());
    a(localEditor, "com_appboy_content_cards_unread_visual_indicator_enabled", parama.z());
    a(localEditor, "com_appboy_device_object_whitelisting_enabled", parama.B());
    a(localEditor, "com_appboy_device_in_app_message_accessibility_exclusive_mode_enabled", parama.C());
    a(localEditor, "com_appboy_push_wake_screen_for_notification_enabled", parama.D());
    a(localEditor, "com_appboy_push_notification_html_rendering_enabled", parama.E());
    if (parama.l() != null)
      a(localEditor, "com_appboy_locale_api_key_map", new JSONArray(parama.l()).toString());
    EnumSet localEnumSet = parama.A();
    if (localEnumSet != null)
      a(localEditor, "com_appboy_device_object_whitelist", dj.a(localEnumSet));
    localEditor.apply();
  }

  public boolean a(String paramString)
  {
    return this.b.contains(paramString);
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.b.getBoolean(paramString, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gj
 * JD-Core Version:    0.6.2
 */