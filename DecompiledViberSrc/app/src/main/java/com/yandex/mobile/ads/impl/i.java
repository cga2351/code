package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.Window;
import android.widget.RelativeLayout;

final class i
  implements k
{
  public final j a(Context paramContext, RelativeLayout paramRelativeLayout, ResultReceiver paramResultReceiver, m paramm, Intent paramIntent, Window paramWindow)
  {
    String str = paramIntent.getStringExtra("extra_browser_url");
    if (!TextUtils.isEmpty(str))
      return new h(paramContext, paramRelativeLayout, paramm, paramWindow, str);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.i
 * JD-Core Version:    0.6.2
 */