package com.viber.voip.user.more.listitems.providers;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a.a;
import com.viber.voip.settings.a.a.d;
import com.viber.voip.user.ProfileNotification;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ProfileBannerProvider
{
  private a.d mButtonProvider;
  private final Context mContext;
  private final boolean mIsTabletMoreTab;
  private final ProfileNotification mProfileNotification;
  private a.d mTitleProvider;
  private a.a mVisibilityProvider;

  public ProfileBannerProvider(Context paramContext, ProfileNotification paramProfileNotification, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mProfileNotification = paramProfileNotification;
    this.mIsTabletMoreTab = paramBoolean;
  }

  public a.d getButtonProvider()
  {
    if (this.mButtonProvider == null)
      this.mButtonProvider = new ProfileBannerProvider..Lambda.1(this);
    return this.mButtonProvider;
  }

  public int getProfileBannerType()
  {
    boolean bool1 = this.mProfileNotification.hasImage();
    boolean bool2 = this.mProfileNotification.hasName();
    if ((bool1) && (!bool2))
      return 0;
    if ((!bool1) && (bool2))
      return 1;
    return 2;
  }

  public a.d getTitleProvider()
  {
    if (this.mTitleProvider == null)
      this.mTitleProvider = new ProfileBannerProvider..Lambda.0(this.mContext.getString(R.string.more_notification_banner_profile_is_not_complete_text));
    return this.mTitleProvider;
  }

  public a.a getVisibilityProvider()
  {
    if (this.mVisibilityProvider == null)
      this.mVisibilityProvider = new ProfileBannerProvider..Lambda.2(this);
    return this.mVisibilityProvider;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BannerType
  {
    public static final int ADD_NAME = 0;
    public static final int ADD_PHOTO = 1;
    public static final int COMPLETE_PROFILE = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.providers.ProfileBannerProvider
 * JD-Core Version:    0.6.2
 */