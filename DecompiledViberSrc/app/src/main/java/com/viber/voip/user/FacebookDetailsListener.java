package com.viber.voip.user;

abstract interface FacebookDetailsListener
{
  public abstract void onLoaded(SocialUserDetails paramSocialUserDetails);

  public abstract void onLoadingCanceled();

  public abstract void onLoadingError(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.FacebookDetailsListener
 * JD-Core Version:    0.6.2
 */