package com.viber.voip.user;

import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProfileNotification
{
  private final e mBannerDisplayExpirationTimeMillisPref;
  private final b mShowMoreNotificationBannerBadgePref;
  private final UserData mUserData;

  ProfileNotification(UserData paramUserData, e parame, b paramb)
  {
    this.mUserData = paramUserData;
    this.mBannerDisplayExpirationTimeMillisPref = parame;
    this.mShowMoreNotificationBannerBadgePref = paramb;
  }

  private boolean hasDetails()
  {
    return (this.mUserData.getImage() != null) && (!da.a(this.mUserData.getViberName()));
  }

  private boolean isBannerExpired()
  {
    return this.mBannerDisplayExpirationTimeMillisPref.d() < System.currentTimeMillis();
  }

  public void clear()
  {
    resetBanner();
    resetBadge();
  }

  public String getExpirationPrefKey()
  {
    return this.mBannerDisplayExpirationTimeMillisPref.c();
  }

  public boolean hasImage()
  {
    return this.mUserData.getImage() != null;
  }

  public boolean hasName()
  {
    return !da.a(this.mUserData.getViberName());
  }

  void init()
  {
    if ((hasDetails()) || (isBannerExpired()))
      clear();
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    if (hasDetails())
      clear();
  }

  public void resetBadge()
  {
    this.mShowMoreNotificationBannerBadgePref.e();
  }

  public void resetBanner()
  {
    this.mBannerDisplayExpirationTimeMillisPref.e();
  }

  public boolean showBadge()
  {
    return (this.mShowMoreNotificationBannerBadgePref.d()) && (!hasDetails());
  }

  public boolean showBanner()
  {
    return (!isBannerExpired()) && (!hasDetails());
  }

  public void updateState()
  {
    if (hasDetails())
    {
      clear();
      return;
    }
    this.mBannerDisplayExpirationTimeMillisPref.a(259200000L + System.currentTimeMillis());
    this.mShowMoreNotificationBannerBadgePref.a(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.ProfileNotification
 * JD-Core Version:    0.6.2
 */