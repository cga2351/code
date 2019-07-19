package com.viber.voip.camera.d;

import android.content.Context;
import android.content.SharedPreferences;

public final class a
{
  private static volatile a a;
  private SharedPreferences b;

  private a()
  {
  }

  private a(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("com_viber_voip_camera_pref_file", 0);
  }

  public static String A()
  {
    return "preference_video_stabilization";
  }

  public static String B()
  {
    return "preference_force_video_4k";
  }

  public static String C()
  {
    return "preference_video_bitrate";
  }

  public static String D()
  {
    return "preference_video_file_max_size";
  }

  public static String E()
  {
    return "preference_video_fps";
  }

  public static String F()
  {
    return "preference_video_max_duration";
  }

  public static String G()
  {
    return "preference_video_restart";
  }

  public static String H()
  {
    return "preference_video_flash";
  }

  public static String I()
  {
    return "preference_record_audio";
  }

  public static String J()
  {
    return "preference_record_audio_channels";
  }

  public static String K()
  {
    return "preference_record_audio_src";
  }

  public static String L()
  {
    return "preference_preview_size";
  }

  public static String M()
  {
    return "preference_rotate_preview";
  }

  public static String N()
  {
    return "preference_lock_orientation";
  }

  public static String O()
  {
    return "preference_timer";
  }

  public static String P()
  {
    return "preference_timer_beep";
  }

  public static String Q()
  {
    return "preference_burst_mode";
  }

  public static String R()
  {
    return "preference_burst_interval";
  }

  public static String S()
  {
    return "preference_shutter_sound";
  }

  public static SharedPreferences a(Context paramContext)
  {
    return b(paramContext.getApplicationContext()).b;
  }

  public static String a()
  {
    return "done_first_time";
  }

  public static String a(int paramInt)
  {
    return "flash_value_" + paramInt;
  }

  public static String a(int paramInt, boolean paramBoolean)
  {
    return "focus_value_" + paramInt + "_" + paramBoolean;
  }

  private static a b(Context paramContext)
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new a(paramContext);
      return a;
    }
    finally
    {
    }
  }

  public static String b()
  {
    return "is_video";
  }

  public static String b(int paramInt)
  {
    return "camera_resolution_" + paramInt;
  }

  public static String c()
  {
    return "last_opened_camera";
  }

  public static String c(int paramInt)
  {
    return "video_quality_" + paramInt;
  }

  public static String d()
  {
    return "preference_should_support_media_record_key";
  }

  public static String e()
  {
    return "preference_exposure";
  }

  public static String f()
  {
    return "preference_color_effect";
  }

  public static String g()
  {
    return "preference_scene_mode";
  }

  public static String h()
  {
    return "preference_white_balance";
  }

  public static String i()
  {
    return "preference_iso";
  }

  public static String j()
  {
    return "preference_exposure_time";
  }

  public static String k()
  {
    return "preference_volume_keys";
  }

  public static String l()
  {
    return "preference_quality";
  }

  public static String m()
  {
    return "preference_auto_stabilise";
  }

  public static String n()
  {
    return "preference_gps_direction";
  }

  public static String o()
  {
    return "preference_touch_capture";
  }

  public static String p()
  {
    return "preference_pause_preview";
  }

  public static String q()
  {
    return "preference_show_when_locked";
  }

  public static String r()
  {
    return "preference_keep_display_on";
  }

  public static String s()
  {
    return "preference_max_brightness";
  }

  public static String t()
  {
    return "preference_using_saf";
  }

  public static String u()
  {
    return "preference_save_location";
  }

  public static String v()
  {
    return "preference_save_location_saf";
  }

  public static String w()
  {
    return "preference_save_photo_prefix";
  }

  public static String x()
  {
    return "preference_save_video_prefix";
  }

  public static String y()
  {
    return "preference_grid";
  }

  public static String z()
  {
    return "preference_face_detection";
  }

  public static final class a
  {
    private int a;
    private boolean b;
    private String c;
    private int d;
    private int e;
    private long f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private String k;

    public String a()
    {
      return this.k;
    }

    public int b()
    {
      return this.a;
    }

    public boolean c()
    {
      return this.b;
    }

    public String d()
    {
      return this.c;
    }

    public int e()
    {
      return this.d;
    }

    public int f()
    {
      return this.e;
    }

    public long g()
    {
      return this.f;
    }

    public boolean h()
    {
      return this.j;
    }

    public boolean i()
    {
      return this.g;
    }

    public boolean j()
    {
      return this.h;
    }

    public boolean k()
    {
      return this.i;
    }

    public static final class a
    {
      private boolean a = false;
      private String b = null;
      private int c = -1;
      private int d = -1;
      private long e = -1L;
      private int f = -1;
      private boolean g = false;
      private boolean h = true;
      private boolean i = false;
      private boolean j = false;
      private String k = "volume_really_nothing";

      public a a(int paramInt)
      {
        this.f = paramInt;
        return this;
      }

      public a a(long paramLong)
      {
        this.e = paramLong;
        return this;
      }

      public a a(String paramString)
      {
        this.b = paramString;
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = paramBoolean;
        return this;
      }

      public a.a a()
      {
        a.a locala = new a.a(null);
        a.a.a(locala, this.k);
        a.a.a(locala, this.f);
        a.a.a(locala, this.a);
        a.a.b(locala, this.b);
        a.a.b(locala, this.c);
        a.a.c(locala, this.d);
        a.a.a(locala, this.e);
        a.a.b(locala, this.g);
        a.a.c(locala, this.h);
        a.a.d(locala, this.i);
        a.a.e(locala, this.j);
        return locala;
      }

      public a b(int paramInt)
      {
        this.d = paramInt;
        return this;
      }

      public a b(boolean paramBoolean)
      {
        this.j = paramBoolean;
        return this;
      }

      public a c(boolean paramBoolean)
      {
        this.h = paramBoolean;
        return this;
      }

      public a d(boolean paramBoolean)
      {
        this.i = paramBoolean;
        return this;
      }

      public a e(boolean paramBoolean)
      {
        this.g = paramBoolean;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.d.a
 * JD-Core Version:    0.6.2
 */