package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public final class ef
{
  private final gb a = new gb();

  public static <T extends View,  extends gb.a> ei a(T paramT)
  {
    boolean bool = gb.a(paramT);
    int i = 0;
    RectF localRectF = null;
    int j;
    Rect localRect;
    if (bool)
    {
      j = dh.e(paramT);
      localRect = new Rect();
      if (!paramT.getLocalVisibleRect(localRect))
        break label172;
      localRect.offset(paramT.getLeft(), paramT.getTop());
    }
    while (true)
    {
      Context localContext = paramT.getContext();
      localRectF = null;
      if (localRect != null)
      {
        int k = dh.a(localContext, localRect.left);
        int m = dh.a(localContext, localRect.top);
        int n = dh.a(localContext, localRect.right);
        int i1 = dh.a(localContext, localRect.bottom);
        int i2 = n - k;
        int i3 = i1 - m;
        localRectF = null;
        if (i2 > 0)
        {
          localRectF = null;
          if (i3 > 0)
            localRectF = new RectF(k, m, n, i1);
        }
      }
      i = j;
      return new ei(i, localRectF);
      label172: localRect = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ef
 * JD-Core Version:    0.6.2
 */