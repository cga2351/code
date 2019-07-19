package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.id;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.user.more.listitems.providers.ProfileBannerProvider;

public class ProfileNotificationItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final ProfileBannerProvider mProfileBannerProvider;

  public ProfileNotificationItemCreator(Context paramContext, ProfileBannerProvider paramProfileBannerProvider)
  {
    this.mContext = paramContext;
    this.mProfileBannerProvider = paramProfileBannerProvider;
  }

  public a create()
  {
    return new a.b(this.mContext, R.id.profile_banner, 2).a(this.mProfileBannerProvider.getTitleProvider()).b(this.mProfileBannerProvider.getButtonProvider()).a(this.mProfileBannerProvider.getVisibilityProvider()).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.ProfileNotificationItemCreator
 * JD-Core Version:    0.6.2
 */