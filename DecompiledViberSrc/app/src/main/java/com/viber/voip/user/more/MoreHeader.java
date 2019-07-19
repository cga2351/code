package com.viber.voip.user.more;

import android.net.Uri;

public abstract interface MoreHeader
{
  public abstract void adjustTopBar();

  public abstract void destroy();

  public abstract void init();

  public abstract void setUserName(CharSequence paramCharSequence);

  public abstract void setUserPhoneNumber(CharSequence paramCharSequence);

  public abstract void setUserPhoto(Uri paramUri);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreHeader
 * JD-Core Version:    0.6.2
 */