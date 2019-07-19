package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.settings.ui.d.a;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.dv;
import java.io.File;

public class z extends m
{
  private final d.a b;

  public z(Context paramContext, PreferenceScreen paramPreferenceScreen, d.a parama)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = parama;
  }

  protected void a()
  {
    File localFile1 = dv.d.b(this.a, "viber_messages", false);
    File localFile2 = dv.d.b(this.a, "viber_data", false);
    if (localFile1 != null)
    {
      f(new x(this.a, x.a.a, "backup_msg_key", "Backup Messages").a("Copy into " + localFile1.getPath()).a(this).a());
      f(new x(this.a, x.a.a, "restore_msg_key", "Restore Messages").a("Restore from " + localFile1.getPath()).a(this).a());
    }
    if (localFile2 != null)
    {
      f(new x(this.a, x.a.a, "backup_contacts_key", "Backup Contacts").a("Copy into " + localFile2.getPath()).a(this).a());
      f(new x(this.a, x.a.a, "restore_contacts_key", "Restore Contacts").a("Restore from " + localFile2.getPath()).a(this).a());
    }
    f(new x(this.a, x.a.a, "log_messages_indexes_key", "Log messages indexes").a("Write all indexes of table 'messages' to log").a(this).a());
    f(new x(this.a, x.a.a, "recreate_messages_indexes_key", "Recreate messages db indexes").a("Recreate all messages Db indexes").a(this).a());
    f(new x(this.a, x.a.a, "clear_messages_db_key", "Clear messages DB").a("Clear messages Db").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("database_key");
    paramPreferenceGroup.c("Database (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    final String str = paramPreference.C();
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        if (str.equals("backup_msg_key"))
          z.a(z.this).a();
        do
        {
          return;
          if (str.equals("restore_msg_key"))
          {
            z.a(z.this).b();
            return;
          }
          if (str.equals("backup_msg_key"))
          {
            z.a(z.this).a();
            return;
          }
          if (str.equals("backup_contacts_key"))
          {
            z.a(z.this).c();
            return;
          }
          if (str.equals("restore_contacts_key"))
          {
            z.a(z.this).d();
            return;
          }
          if (str.equals("log_messages_indexes_key"))
          {
            d.a(ViberApplication.getApplication()).h();
            return;
          }
          if (str.equals("recreate_messages_indexes_key"))
          {
            d.a(ViberApplication.getApplication(), true);
            return;
          }
        }
        while (!str.equals("clear_messages_db_key"));
        ab.b().u();
        ViberApplication.exit(null, true);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.z
 * JD-Core Version:    0.6.2
 */