package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.f;
import com.viber.voip.registration.ao.b;
import com.viber.voip.registration.s;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.d.x;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.ViberActionRunner.h;

public class g extends m
{
  private static final Logger b = ViberEnv.getLogger();

  public g(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private CharSequence a(com.viber.voip.backup.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return this.a.getString(parama.c());
    case 1:
      return "3 minutes (debug)";
    case 2:
      return "10 minutes (debug)";
    case 3:
      return "15 minutes (debug)";
    case 4:
    }
    return "Not set (user's never chosen any value)";
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "debug_backup_clear_account_key", "Clear Backup Google Account").a("Removes account and backup info").a(this).a());
    f(new x(this.a, x.a.a, "debug_backup_clear_backup_info_key", "Clear Backup Info").a(this).a());
    f(new x(this.a, x.a.a, "debug_backup_reset_backup_info_update_time_key", "Reset Backup Info last update time").a("Backup info will be updated immediately after Backup screen will be opened").a(this).a());
    f(new x(this.a, x.a.c, d.j.o.c(), "Show backup/restore duration").a(Boolean.valueOf(d.j.o.f())).a());
    f(new x(this.a, x.a.a, "debug_open_auto_backup_promo_screen", "Open Auto Backup Promo screen").a(this).a());
    com.viber.voip.backup.a locala = com.viber.voip.backup.a.a(d.j.g.d());
    x localx1 = new x(this.a, x.a.b, "debug_auto_backup_period", "Change Auto Backup period");
    CharSequence[] arrayOfCharSequence1 = new CharSequence[8];
    arrayOfCharSequence1[0] = a(com.viber.voip.backup.a.f);
    arrayOfCharSequence1[1] = a(com.viber.voip.backup.a.g);
    arrayOfCharSequence1[2] = a(com.viber.voip.backup.a.h);
    arrayOfCharSequence1[3] = a(com.viber.voip.backup.a.c);
    arrayOfCharSequence1[4] = a(com.viber.voip.backup.a.d);
    arrayOfCharSequence1[5] = a(com.viber.voip.backup.a.e);
    arrayOfCharSequence1[6] = a(com.viber.voip.backup.a.b);
    arrayOfCharSequence1[7] = a(com.viber.voip.backup.a.a);
    x localx2 = localx1.a(arrayOfCharSequence1);
    CharSequence[] arrayOfCharSequence2 = new CharSequence[8];
    arrayOfCharSequence2[0] = String.valueOf(com.viber.voip.backup.a.f.a());
    arrayOfCharSequence2[1] = String.valueOf(com.viber.voip.backup.a.g.a());
    arrayOfCharSequence2[2] = String.valueOf(com.viber.voip.backup.a.h.a());
    arrayOfCharSequence2[3] = String.valueOf(com.viber.voip.backup.a.c.a());
    arrayOfCharSequence2[4] = String.valueOf(com.viber.voip.backup.a.d.a());
    arrayOfCharSequence2[5] = String.valueOf(com.viber.voip.backup.a.e.a());
    arrayOfCharSequence2[6] = String.valueOf(com.viber.voip.backup.a.b.a());
    arrayOfCharSequence2[7] = String.valueOf(com.viber.voip.backup.a.a.a());
    f(localx2.b(arrayOfCharSequence2).a(String.valueOf(com.viber.voip.backup.a.a.a())).c(String.valueOf(locala.a())).a((String)a(locala)).a(this).a());
    f(new x(this.a, x.a.a, "debug_upload_keychain_to_drive", "Upload QR keychain (devkey) to Drive").a("Drive account: " + new com.viber.backup.drive.a(d.x.a).a()).a(this).a());
    f(new x(this.a, x.a.a, "debug_delete_keychain_from_drive", "Delete QR keychain (devkey) from Drive").a("Drive account: " + new com.viber.backup.drive.a(d.x.a).a()).a(this).a());
    f(new x(this.a, x.a.d, "debug_change_keychain_modified_time", "Change QR keychain modified time").a("Current time: " + d.x.c.d()).a(Long.toString(d.x.c.d())).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("backup_debug_settings_key");
    paramPreferenceGroup.c("Backup");
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
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      break;
    case 265577866:
    case -2116761880:
    case -187297874:
    case 583727570:
    case -1282311087:
    case 74935850:
    }
    while (true)
    {
      return super.a(paramPreference);
      if (!str.equals("debug_backup_clear_account_key"))
        break;
      i = 0;
      break;
      if (!str.equals("debug_backup_clear_backup_info_key"))
        break;
      i = 1;
      break;
      if (!str.equals("debug_backup_reset_backup_info_update_time_key"))
        break;
      i = 2;
      break;
      if (!str.equals("debug_open_auto_backup_promo_screen"))
        break;
      i = 3;
      break;
      if (!str.equals("debug_upload_keychain_to_drive"))
        break;
      i = 4;
      break;
      if (!str.equals("debug_delete_keychain_from_drive"))
        break;
      i = 5;
      break;
      new com.viber.voip.backup.b.b(this.a).a(null);
      Toast.makeText(this.a, "Backup Account & Backup Info have been cleared", 0).show();
      continue;
      f.b().c();
      Toast.makeText(this.a, "Backup Info has been cleared", 0).show();
      continue;
      d.j.c.e();
      Toast.makeText(this.a, "Backup Info last update time has been reset", 0).show();
      continue;
      ViberActionRunner.h.b(this.a);
      continue;
      av.a(av.e.k).post(new h(this, paramPreference));
      continue;
      av.a(av.e.k).post(new i(this, paramPreference));
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
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
      case 1:
      }
      break;
    case 1439326650:
    case -429184695:
    }
    while (true)
    {
      return super.a(paramPreference, paramObject);
      if (!str.equals("debug_auto_backup_period"))
        break;
      i = 0;
      break;
      if (!str.equals("debug_change_keychain_modified_time"))
        break;
      i = 1;
      break;
      com.viber.voip.backup.auto.b localb = new com.viber.voip.backup.auto.b(d.j.k);
      com.viber.voip.backup.auto.d locald1 = new com.viber.voip.backup.auto.d(d.j.j);
      com.viber.voip.backup.b localb1 = new com.viber.voip.backup.b(this.a, d.j.g, localb, locald1, p.a.a);
      com.viber.voip.backup.a locala = com.viber.voip.backup.a.a(Long.parseLong((String)paramObject));
      localb1.a(locala);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c((String)paramObject));
      paramPreference.b(a(locala));
      continue;
      try
      {
        long l = Long.parseLong((String)paramObject);
        paramPreference.b("Current time: " + paramObject);
        ((EditTextPreference)paramPreference).a((String)paramObject);
        s.a(ao.b.f, Long.toString(l));
        com.viber.backup.a.d locald = com.viber.backup.a.d.a(this.a);
        locald.c(false);
        locald.a(false);
        Toast.makeText(this.a, "New value is set. \nKeychain will NOT be uploaded automatically to Drive.", 1).show();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Toast.makeText(this.a, "Error. New value isn't set.", 0).show();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.g
 * JD-Core Version:    0.6.2
 */