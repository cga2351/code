package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.i;

public final class nm
{
  private final bz a;
  private final i b;
  private final nl c;
  private final nr d;

  public nm(Context paramContext, bz parambz, af paramaf)
  {
    this.a = parambz;
    this.b = paramaf.e();
    this.c = new nl(paramContext);
    this.d = new nr(paramContext);
  }

  public final void a(Context paramContext, lr paramlr)
  {
    Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse(paramlr.d()));
    Intent localIntent2;
    if (this.d.a(localIntent1))
    {
      String str1 = paramlr.b();
      lh locallh = this.c.a(str1);
      Bitmap localBitmap = this.b.a(locallh);
      if (localBitmap != null)
      {
        this.a.a(fd.b.x);
        String str2 = paramlr.c();
        localIntent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent2.putExtra("android.intent.extra.shortcut.NAME", str2);
        localIntent2.putExtra("android.intent.extra.shortcut.ICON", localBitmap);
        localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
        localIntent2.putExtra("duplicate", false);
      }
    }
    try
    {
      paramContext.sendBroadcast(localIntent2);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nm
 * JD-Core Version:    0.6.2
 */