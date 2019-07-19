package com.crashlytics.android.c;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import c.a.a.a.a.f.c;
import c.a.a.a.a.f.d;

@SuppressLint({"CommitPrefEdits"})
class ak
{
  private final c a;
  private final l b;

  public ak(c paramc, l paraml)
  {
    this.a = paramc;
    this.b = paraml;
  }

  public static ak a(c paramc, l paraml)
  {
    return new ak(paramc, paraml);
  }

  void a(boolean paramBoolean)
  {
    this.a.a(this.a.b().putBoolean("always_send_reports_opt_in", paramBoolean));
  }

  boolean a()
  {
    d locald;
    if (!this.a.a().contains("preferences_migration_complete"))
    {
      locald = new d(this.b);
      if ((this.a.a().contains("always_send_reports_opt_in")) || (!locald.a().contains("always_send_reports_opt_in")))
        break label161;
    }
    label161: for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        boolean bool = locald.a().getBoolean("always_send_reports_opt_in", false);
        this.a.a(this.a.b().putBoolean("always_send_reports_opt_in", bool));
      }
      this.a.a(this.a.b().putBoolean("preferences_migration_complete", true));
      return this.a.a().getBoolean("always_send_reports_opt_in", false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ak
 * JD-Core Version:    0.6.2
 */