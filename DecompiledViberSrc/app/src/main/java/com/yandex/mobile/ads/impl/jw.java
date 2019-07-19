package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.Rating;

public final class jw
  implements View.OnTouchListener
{
  private static volatile jw a;
  private static final Object b = new Object();
  private final Handler c = new Handler();
  private final GestureDetector d;
  private boolean e;

  private jw(Context paramContext)
  {
    this.d = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener())
    {
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        return super.onTouchEvent(paramAnonymousMotionEvent);
      }
    };
  }

  public static jw a(Context paramContext)
  {
    if (a == null);
    synchronized (b)
    {
      if (a == null)
        a = new jw(paramContext);
      return a;
    }
  }

  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    if (((paramView instanceof TextView)) || ((paramView instanceof Rating)))
    {
      if (paramMotionEvent.getAction() == 1)
      {
        if ((Build.VERSION.SDK_INT >= 11) && (paramView != null) && (!this.e))
        {
          paramView.setAlpha(paramView.getAlpha() / 2.0F);
          this.e = true;
        }
        this.c.postDelayed(new Runnable()
        {
          public final void run()
          {
            jw.a(jw.this, paramView);
          }
        }
        , 100L);
      }
      return this.d.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jw
 * JD-Core Version:    0.6.2
 */