package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.Window;
import android.widget.RelativeLayout;

public final class gz
  implements k
{
  private static boolean a(Intent paramIntent)
  {
    try
    {
      boolean bool = paramIntent.getBooleanExtra("extra_interstitial_isShouldOpenLinksInApp", false);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public final j a(Context paramContext, RelativeLayout paramRelativeLayout, ResultReceiver paramResultReceiver, m paramm, Intent paramIntent, Window paramWindow)
  {
    v localv = gx.a().b();
    if (localv != null);
    for (String str = (String)localv.r(); !TextUtils.isEmpty(str); str = null)
    {
      boolean bool = a(paramIntent);
      hc localhc = new hc(localv, str);
      return new gy(paramContext, paramRelativeLayout, new co(paramContext, bool, paramResultReceiver), paramm, paramWindow, localhc);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gz
 * JD-Core Version:    0.6.2
 */