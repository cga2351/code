package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.stickers.a.a;
import com.viber.voip.stickers.i;

public class be extends m
{
  public be(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    if (i.a().b().ab_());
    for (String str = "ALL"; ; str = d.ax.q.d())
    {
      f(new x(this.a, x.a.a, d.ax.q.c(), "Sticker Clicker Packages").a(str).a(this).a());
      f(new x(this.a, x.a.c, d.ax.w.c(), "Use custom url for sticker clickers").b(d.ax.w.d()).a(this).a());
      f(new x(this.a, x.a.d, d.ax.x.c(), "Sticker clickers custom url").a("It overrides url for fetching sticker clickers ad").a());
      f(new x(this.a, x.a.c, d.ax.y.c(), "Display clickers ads report status").a("impression - blue, view - red").a());
      return;
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("sticker_clickers");
    paramPreferenceGroup.c("Sticker clickers (Debug option)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.be
 * JD-Core Version:    0.6.2
 */