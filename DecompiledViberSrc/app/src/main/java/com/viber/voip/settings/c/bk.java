package com.viber.voip.settings.c;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.ViberApplication;
import com.viber.voip.banner.i;
import com.viber.voip.gallery.GalleryCoach;
import com.viber.voip.market.GenericMarketDialogActivity;
import com.viber.voip.market.ViberOutWelcomeActivity;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.dz;
import com.viber.voip.viberout.ui.FreeOfferWebActivity;

public class bk extends m
{
  public bk(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "pref_launch_gallery", "Launch Gallery").a(this).a());
    f(new x(this.a, x.a.a, "pref_launch_splash", "Launch Splash").a(this).a());
    f(new x(this.a, x.a.a, "pref_launch_vo_welcome", "Launch Viber Out Welcome").a(this).a());
    f(new x(this.a, x.a.a, "pref_launch_gen_market", "Launch Generic Market").a(this).a());
    f(new x(this.a, x.a.a, "pref_launch_sticker_purchase", "Launch Sticker Purchase").a(this).a());
    f(new x(this.a, x.a.a, "pref_offer", "Launch Free Offer").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("ui_screens");
    paramPreferenceGroup.c("UI Screens (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -338902942:
    case 207912791:
    case -1286871860:
    case -973044485:
    case -1634354880:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (str.equals("pref_launch_gallery"))
        {
          i = 0;
          continue;
          if (str.equals("pref_launch_splash"))
          {
            i = 1;
            continue;
            if (str.equals("pref_launch_vo_welcome"))
            {
              i = 2;
              continue;
              if (str.equals("pref_launch_gen_market"))
              {
                i = 3;
                continue;
                if (str.equals("pref_offer"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    Intent localIntent = new Intent(this.a, GalleryCoach.class);
    localIntent.setFlags(335544320);
    ViberApplication.getApplication().startActivity(localIntent);
    return false;
    dz.a(this.a, i.a("Splash", "https://www.viber.com/"));
    return false;
    ViberOutWelcomeActivity.l();
    return false;
    GenericMarketDialogActivity.a("https://www.viber.com", "Generic market");
    return false;
    FreeOfferWebActivity.x();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bk
 * JD-Core Version:    0.6.2
 */