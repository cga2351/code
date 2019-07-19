package com.yandex.mobile.ads.impl;

import android.os.Build.VERSION;
import android.view.View;

public final class el
  implements ek
{
  private final boolean a = false;
  private final boolean b = false;
  private final boolean c = false;
  private final boolean d = false;
  private final boolean e;

  public el(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 11)
      bool = paramView.isHardwareAccelerated();
    this.e = bool;
  }

  public final String a()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(this.e);
    return String.format("supports: {inlineVideo: %s}", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.el
 * JD-Core Version:    0.6.2
 */