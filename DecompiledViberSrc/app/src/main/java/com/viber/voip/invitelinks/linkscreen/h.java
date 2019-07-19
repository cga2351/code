package com.viber.voip.invitelinks.linkscreen;

import android.app.Activity;
import android.net.Uri;
import com.viber.voip.analytics.g;
import com.viber.voip.util.da;

class h extends a
{
  public h(Activity paramActivity, g paramg)
  {
    super(paramActivity, paramg, false, null);
  }

  protected boolean a(String paramString, Uri paramUri)
  {
    return (paramUri == null) || (da.a(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.h
 * JD-Core Version:    0.6.2
 */