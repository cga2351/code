package com.yandex.mobile.ads.impl;

import android.content.Intent;

public final class oo extends ov
{
  private Intent b;

  public oo()
  {
  }

  public oo(oh paramoh)
  {
    super(paramoh);
  }

  public final String getMessage()
  {
    if (this.b != null)
      return "User needs to (re)enter credentials.";
    return super.getMessage();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oo
 * JD-Core Version:    0.6.2
 */