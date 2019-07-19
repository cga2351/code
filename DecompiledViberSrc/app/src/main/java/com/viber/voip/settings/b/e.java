package com.viber.voip.settings.b;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.bk;
import org.greenrobot.eventbus.EventBus;

public class e
{
  public static class a
  {
    public static final f a = new f("reg_viber_country", "");
    public static final f b = new f("reg_viber_country_code", "0");
    public static final f c = new f("reg_viber_country_code_string", "");
    public static final c d = new c("reg_viber_country_code_string_version", 0);
    public static final f e = new f("reg_viber_phone_num", "0");
    public static final f f = new f("reg_viber_phone_num_canonized", null);
    public static final f g = new f("pgEncryptedPhoneNumber", "");
    public static final f h = new f("reg_member_id", null);
    public static final f i = new f("reg_viber_id", null);
    public static final f j = new f("webEncryptedPhoneNumber", "");
    public static final f k = new f("device_key", "");
    public static final f l = new f("viber_udid", "");
    public static final b m = new b("is_activated", false);
    public static final d n = new d("pref_activation_date", 0L);
    public static final b o = new b("came_from_secondary_activation", false);
    public static final f p = new f("activated_sim_serial", "");
    public static final a q = new a(bk.b().getResources(), R.string.pref_deactivate_key);
    public static final c r = new c("activation_step", 4);
    public static final b s = new b("app_launched", false);
    public static final f t = new f("deferred_link", "");

    public static class a
    {
      public static final f a = new f("use_as_secondary", a());
      public static final f b = new f("secondary_device_key", "");
      public static final f c = new f("secondary_udid", "");

      private static String a()
      {
        if (new com.viber.voip.app.b(bk.b(), new com.viber.voip.g.b.b()
        {
          protected EventBus a()
          {
            return com.viber.voip.h.a.b();
          }
        }).a(bk.b()))
          return "secondary";
        return "primary";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.e
 * JD-Core Version:    0.6.2
 */