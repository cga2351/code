package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.voip.settings.d.o;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class u extends m
{
  public u(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.o.a.c(), "First community created").a(Boolean.valueOf(d.o.a.f())).a("For displaying community intro carousel").a());
    f(new x(this.a, x.a.c, d.o.b.c(), "Ignore public group changes").a(Boolean.valueOf(d.o.b.f())).a("To test case when user missed update (after inbox was cleared)").a());
    f(new x(this.a, x.a.a, "pref_clear_communities_cache", "Trim communities cache").a(this).a());
    f(new x(this.a, x.a.c, d.o.f.c(), "Send message with Invite MsgInfo").a(Boolean.valueOf(d.o.f.f())).a(this).a());
    f(new x(this.a, x.a.c, d.r.K.c(), "Was community poll snackbar shown").a(Boolean.valueOf(d.r.K.f())).a(this).a());
    String str = String.valueOf(d.o.g.d());
    f(new x(this.a, x.a.d, "pref_item_community_members_count_to_add_referral", "Members count threshold to add referral").a(str).a(str).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("community_key");
    paramPreferenceGroup.c("Community");
  }

  public boolean a(Preference paramPreference)
  {
    if ("pref_clear_communities_cache".equals(paramPreference.C()))
    {
      this.a.sendBroadcast(new Intent("com.viber.voip.action.APP_ON_TRIM_CACHE"));
      return true;
    }
    return super.a(paramPreference);
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if ("pref_item_community_members_count_to_add_referral".equals(paramPreference.C()))
      try
      {
        d.o.g.a(Integer.parseInt((String)paramObject));
        paramPreference.b((String)paramObject);
        return true;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return super.a(paramPreference, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.u
 * JD-Core Version:    0.6.2
 */