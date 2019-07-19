package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public final class ns
{
  public static Context a(Context paramContext)
  {
    int i = 0;
    Context localContext = paramContext;
    while ((localContext instanceof ContextWrapper))
    {
      int j = i + 1;
      if (i >= 10)
        break;
      if ((localContext instanceof Activity))
        return localContext;
      localContext = ((ContextWrapper)localContext).getBaseContext();
      i = j;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ns
 * JD-Core Version:    0.6.2
 */