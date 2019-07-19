package com.viber.voip.user;

import android.graphics.Bitmap;

public final class SocialUserDetails
{
  private final String userName;
  private final Bitmap userPhoto;

  public SocialUserDetails(String paramString, Bitmap paramBitmap)
  {
    if (paramString == null)
      throw new IllegalArgumentException("userName must be not null");
    if (paramBitmap == null)
      throw new IllegalArgumentException("userPhoto must be not null");
    this.userName = paramString;
    this.userPhoto = paramBitmap;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public Bitmap getUserPhoto()
  {
    return this.userPhoto;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.SocialUserDetails
 * JD-Core Version:    0.6.2
 */