package com.viber.voip.user.more;

import android.content.Intent;

class MoreArguments
{
  private final int mCdrOrigin;
  private final boolean mShowShare;

  MoreArguments(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("show_share", false)))
      paramIntent.removeExtra("show_share");
    for (this.mShowShare = i; ; this.mShowShare = false)
    {
      if (paramIntent != null)
        i = paramIntent.getIntExtra("cdr_origin", i);
      this.mCdrOrigin = i;
      return;
    }
  }

  public int getCdrOrigin()
  {
    return this.mCdrOrigin;
  }

  public boolean showShare()
  {
    return this.mShowShare;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreArguments
 * JD-Core Version:    0.6.2
 */