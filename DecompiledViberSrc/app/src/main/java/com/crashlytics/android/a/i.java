package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import c.a.a.a.a.f.c;
import c.a.a.a.a.f.d;

class i
{
  private final c a;

  i(c paramc)
  {
    this.a = paramc;
  }

  public static i a(Context paramContext)
  {
    return new i(new d(paramContext, "settings"));
  }

  @SuppressLint({"CommitPrefEdits"})
  public void a()
  {
    this.a.a(this.a.b().putBoolean("analytics_launched", true));
  }

  @SuppressLint({"CommitPrefEdits"})
  public boolean b()
  {
    return this.a.a().getBoolean("analytics_launched", false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.i
 * JD-Core Version:    0.6.2
 */