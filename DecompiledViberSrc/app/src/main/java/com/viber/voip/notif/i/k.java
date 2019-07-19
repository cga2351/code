package com.viber.voip.notif.i;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.viber.common.d.a;
import com.viber.voip.util.ae;
import com.viber.voip.util.br;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class k
{
  private boolean a;
  private Calendar b;
  private Calendar c;
  private ContentObserver d;
  private Context e;
  private Handler f;

  public k(Context paramContext, Handler paramHandler)
  {
    this.e = paramContext;
    this.f = paramHandler;
  }

  private void c()
  {
    int i = 1;
    try
    {
      int j;
      int k;
      if (Settings.System.getInt(this.e.getContentResolver(), "dormant_switch_onoff") == i)
      {
        j = i;
        if (Settings.System.getInt(this.e.getContentResolver(), "dormant_disable_notifications") != i)
          break label198;
        k = i;
        label39: if ((j != 0) && (k != 0))
        {
          this.a = true;
          if (Settings.System.getInt(this.e.getContentResolver(), "dormant_always") != i)
            break label204;
        }
      }
      while (true)
      {
        if (i != 0)
        {
          this.b = null;
          this.c = null;
          return;
        }
        int m = Settings.System.getInt(this.e.getContentResolver(), "dormant_start_hour");
        int n = Settings.System.getInt(this.e.getContentResolver(), "dormant_start_min");
        int i1 = Settings.System.getInt(this.e.getContentResolver(), "dormant_end_hour");
        int i2 = Settings.System.getInt(this.e.getContentResolver(), "dormant_end_min");
        this.b = new GregorianCalendar(0, 0, 0, m, n);
        this.c = new GregorianCalendar(0, 0, 0, i1, i2);
        return;
        this.a = false;
        this.b = null;
        this.c = null;
        return;
        j = 0;
        break;
        label198: k = 0;
        break label39;
        label204: i = 0;
      }
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
    }
  }

  public boolean a()
  {
    return (this.a) && (ae.a(this.b, this.c));
  }

  public void b()
  {
    if ((br.a.a()) && (a.b()) && (!a.g()))
    {
      c();
      this.d = new ContentObserver(this.f)
      {
        public void onChange(boolean paramAnonymousBoolean)
        {
          k.a(k.this);
        }
      };
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_switch_onoff"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_disable_notifications"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_always"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_start_hour"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_start_min"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_end_hour"), false, this.d);
      this.e.getContentResolver().registerContentObserver(Settings.System.getUriFor("dormant_end_min"), false, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.k
 * JD-Core Version:    0.6.2
 */