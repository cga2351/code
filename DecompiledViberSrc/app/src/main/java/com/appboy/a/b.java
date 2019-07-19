package com.appboy.a;

import a.a.bj;
import a.a.dj;
import a.a.gj;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.appboy.b.f;
import com.appboy.b.j;
import com.appboy.f.g;
import com.appboy.f.i;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class b extends c
{
  private static final String c = com.appboy.f.c.a(b.class);
  private final Context d;

  public b(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
  }

  private String C()
  {
    return a("com_appboy_server_target", "PROD");
  }

  private int a(a parama)
  {
    if (parama.equals(a.b));
    for (String str1 = "com_appboy_push_large_notification_icon"; this.a.containsKey(str1); str1 = "com_appboy_push_small_notification_icon")
      return ((Integer)this.a.get(str1)).intValue();
    if (this.b.a(str1))
    {
      String str2 = this.b.a(str1, "");
      int j = this.d.getResources().getIdentifier(str2, "drawable", g.a(this.d));
      this.a.put(str1, Integer.valueOf(j));
      com.appboy.f.c.b(c, "Using runtime override value for key: " + str1 + " and value: " + str2);
      return j;
    }
    int i = this.d.getResources().getIdentifier(str1, "drawable", g.a(this.d));
    this.a.put(str1, Integer.valueOf(i));
    return i;
  }

  public boolean A()
  {
    return a("com_appboy_push_wake_screen_for_notification_enabled", true);
  }

  public boolean B()
  {
    return a("com_appboy_push_notification_html_rendering_enabled", false);
  }

  public String a()
  {
    if ("STAGING".equals(C().toUpperCase(Locale.US)))
      return "https://sondheim.appboy.com/api/v3/";
    return "https://sdk.iad-01.braze.com/api/v3/";
  }

  // ERROR //
  public String a(Locale paramLocale)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: getstatic 18	com/appboy/a/b:c	Ljava/lang/String;
    //   7: ldc 157
    //   9: invokestatic 122	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   12: pop
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 69	com/appboy/a/b:b	La/a/gj;
    //   19: ldc 159
    //   21: invokevirtual 74	a/a/gj:a	(Ljava/lang/String;)Z
    //   24: ifeq +105 -> 129
    //   27: aload_0
    //   28: getfield 69	com/appboy/a/b:b	La/a/gj;
    //   31: ldc 159
    //   33: aconst_null
    //   34: invokevirtual 77	a/a/gj:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 10
    //   39: new 161	org/json/JSONArray
    //   42: dup
    //   43: aload 10
    //   45: invokespecial 164	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   48: astore 11
    //   50: aload 11
    //   52: invokevirtual 167	org/json/JSONArray:length	()I
    //   55: anewarray 144	java/lang/String
    //   58: astore 14
    //   60: iconst_0
    //   61: istore 16
    //   63: iload 16
    //   65: aload 11
    //   67: invokevirtual 167	org/json/JSONArray:length	()I
    //   70: if_icmpge +41 -> 111
    //   73: aload 14
    //   75: iload 16
    //   77: aload 11
    //   79: iload 16
    //   81: invokevirtual 171	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   84: aastore
    //   85: iinc 16 1
    //   88: goto -25 -> 63
    //   91: astore 12
    //   93: aload 12
    //   95: astore 13
    //   97: aconst_null
    //   98: astore 14
    //   100: getstatic 18	com/appboy/a/b:c	Ljava/lang/String;
    //   103: ldc 173
    //   105: aload 13
    //   107: invokestatic 176	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: pop
    //   111: aload 14
    //   113: astore_2
    //   114: aload_2
    //   115: ifnonnull +25 -> 140
    //   118: getstatic 18	com/appboy/a/b:c	Ljava/lang/String;
    //   121: ldc 178
    //   123: invokestatic 122	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: aconst_null
    //   128: areturn
    //   129: aload_0
    //   130: ldc 159
    //   132: aconst_null
    //   133: invokevirtual 181	com/appboy/a/b:a	(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
    //   136: astore_2
    //   137: goto -23 -> 114
    //   140: aload_2
    //   141: arraylength
    //   142: istore_3
    //   143: iconst_0
    //   144: istore 4
    //   146: iload 4
    //   148: iload_3
    //   149: if_icmpge +105 -> 254
    //   152: aload_2
    //   153: iload 4
    //   155: aaload
    //   156: astore 5
    //   158: aload 5
    //   160: ldc 183
    //   162: invokestatic 187	com/appboy/f/i:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   165: iconst_1
    //   166: if_icmpeq +9 -> 175
    //   169: iinc 4 1
    //   172: goto -26 -> 146
    //   175: aload 5
    //   177: ldc 183
    //   179: invokevirtual 191	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   182: astore 6
    //   184: aload 6
    //   186: arraylength
    //   187: iconst_2
    //   188: if_icmpne -19 -> 169
    //   191: aload 6
    //   193: iconst_0
    //   194: aaload
    //   195: invokevirtual 194	java/lang/String:trim	()Ljava/lang/String;
    //   198: getstatic 142	java/util/Locale:US	Ljava/util/Locale;
    //   201: invokevirtual 197	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   204: astore 7
    //   206: aload 7
    //   208: aload_1
    //   209: invokevirtual 198	java/util/Locale:toString	()Ljava/lang/String;
    //   212: getstatic 142	java/util/Locale:US	Ljava/util/Locale;
    //   215: invokevirtual 197	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   218: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: istore 8
    //   223: aload 7
    //   225: aload_1
    //   226: invokevirtual 201	java/util/Locale:getCountry	()Ljava/lang/String;
    //   229: getstatic 142	java/util/Locale:US	Ljava/util/Locale;
    //   232: invokevirtual 197	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   235: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifne +8 -> 246
    //   241: iload 8
    //   243: ifeq -74 -> 169
    //   246: aload 6
    //   248: iconst_1
    //   249: aaload
    //   250: invokevirtual 194	java/lang/String:trim	()Ljava/lang/String;
    //   253: areturn
    //   254: aconst_null
    //   255: areturn
    //   256: astore 13
    //   258: goto -158 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   39	60	91	org/json/JSONException
    //   63	85	256	org/json/JSONException
  }

  public bj b()
  {
    bj localbj = (bj)this.a.get("com_appboy_api_key");
    String str;
    if (localbj == null)
    {
      str = this.b.a("com_appboy_api_key", null);
      if (str == null)
        break label168;
      com.appboy.f.c.c(c, "Found an override api key. Using it to configure Appboy.");
    }
    while (true)
    {
      if (str != null)
      {
        localbj = new bj(str);
        this.a.put("com_appboy_api_key", localbj);
      }
      if (localbj != null)
        break;
      com.appboy.f.c.e(c, "****************************************************");
      com.appboy.f.c.e(c, "**                                                **");
      com.appboy.f.c.e(c, "**                 !! WARNING !!                  **");
      com.appboy.f.c.e(c, "**                                                **");
      com.appboy.f.c.e(c, "**     No API key set in res/values/appboy.xml    **");
      com.appboy.f.c.e(c, "** No cached API Key found from Appboy.configure  **");
      com.appboy.f.c.e(c, "**          Braze functionality disabled          **");
      com.appboy.f.c.e(c, "**                                                **");
      com.appboy.f.c.e(c, "****************************************************");
      throw new RuntimeException("Unable to read the Braze API key from the res/values/appboy.xml file. See log for more details.");
      label168: str = a(Locale.getDefault());
      if (str != null)
        com.appboy.f.c.c(c, "Found a locale that matches the current locale in appboy.xml. Using the associated api key");
      else
        str = b("com_appboy_api_key", null);
    }
    return localbj;
  }

  public boolean c()
  {
    return a("com_appboy_push_adm_messaging_registration_enabled", false);
  }

  public boolean d()
  {
    boolean bool1 = a("com_appboy_disable_location_collection", false);
    boolean bool2 = false;
    if (!bool1)
      bool2 = true;
    return bool2;
  }

  public int e()
  {
    return a(a.a);
  }

  public int f()
  {
    return a(a.b);
  }

  public long g()
  {
    return a("com_appboy_trigger_action_minimum_time_interval_seconds", 30);
  }

  public int h()
  {
    return a("com_appboy_session_timeout", 10);
  }

  public int i()
  {
    if (this.a.containsKey("version_code"))
      return ((Integer)this.a.get("version_code")).intValue();
    try
    {
      String str = g.a(this.d);
      i = this.d.getPackageManager().getPackageInfo(str, 0).versionCode;
      this.a.put("version_code", Integer.valueOf(i));
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        com.appboy.f.c.d(c, "Unable to read the version code.", localException);
        int i = -1;
      }
    }
  }

  public String j()
  {
    return a("com_appboy_custom_endpoint", null);
  }

  public boolean k()
  {
    return a("com_appboy_handle_push_deep_links_automatically", false);
  }

  public boolean l()
  {
    return a("com_appboy_newsfeed_unread_visual_indicator_on", true);
  }

  public String m()
  {
    return a("com_appboy_default_notification_channel_name", "General");
  }

  public String n()
  {
    return a("com_appboy_default_notification_channel_description", "");
  }

  public int o()
  {
    if (this.a.containsKey("application_icon"))
      return ((Integer)this.a.get("application_icon")).intValue();
    String str = this.d.getPackageName();
    try
    {
      i = this.d.getPackageManager().getApplicationInfo(str, 0).icon;
      this.a.put("application_icon", Integer.valueOf(i));
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      while (true)
      {
        int i;
        com.appboy.f.c.e(c, "Cannot find package named " + str);
        try
        {
          i = this.d.getPackageManager().getApplicationInfo(this.d.getPackageName(), 0).icon;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          com.appboy.f.c.e(c, "Cannot find package named " + str);
          i = 0;
        }
      }
    }
  }

  public int p()
  {
    return a("com_appboy_default_notification_accent_color", 0);
  }

  public j q()
  {
    String str = a("com_appboy_sdk_flavor", null);
    if (i.c(str))
      return null;
    try
    {
      j localj = j.valueOf(str.toUpperCase(Locale.US));
      return localj;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(c, "Exception while parsing stored SDK flavor. Returning null.", localException);
    }
    return null;
  }

  public boolean r()
  {
    return a("com_appboy_push_deep_link_back_stack_activity_enabled", true);
  }

  public String s()
  {
    return a("com_appboy_push_deep_link_back_stack_activity_class_name", "");
  }

  public boolean t()
  {
    return a("com_appboy_session_start_based_timeout_enabled", false);
  }

  public boolean u()
  {
    return a("com_appboy_firebase_cloud_messaging_registration_enabled", false);
  }

  public boolean v()
  {
    return a("com_appboy_content_cards_unread_visual_indicator_enabled", true);
  }

  public String w()
  {
    return a("com_appboy_firebase_cloud_messaging_sender_id", null);
  }

  public EnumSet<f> x()
  {
    if (this.a.containsKey("com_appboy_device_object_whitelist"))
      return (EnumSet)this.a.get("com_appboy_device_object_whitelist");
    EnumSet localEnumSet = dj.a(f.class, a("com_appboy_device_object_whitelist", new HashSet()));
    this.a.put("com_appboy_device_object_whitelist", localEnumSet);
    return localEnumSet;
  }

  public boolean y()
  {
    return a("com_appboy_device_object_whitelisting_enabled", false);
  }

  public boolean z()
  {
    return a("com_appboy_device_in_app_message_accessibility_exclusive_mode_enabled", false);
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.a.b
 * JD-Core Version:    0.6.2
 */