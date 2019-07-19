package com.viber.voip.user.editinfo;

import android.net.Uri;

public abstract interface ProfileImageRepository
{
  public abstract Uri getImageUri();

  public abstract String getViberImage();

  public abstract boolean isViberImageRemoved();

  public abstract void updateAvatar(Uri paramUri);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.ProfileImageRepository
 * JD-Core Version:    0.6.2
 */