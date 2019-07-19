package com.mixpanel.android.c;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class g
{
  public g(MixpanelAPI paramMixpanelAPI, Activity paramActivity)
  {
    a(paramMixpanelAPI, paramActivity);
  }

  private View.OnTouchListener a(final MixpanelAPI paramMixpanelAPI)
  {
    return new View.OnTouchListener()
    {
      private long c = -1L;
      private long d = -1L;
      private int e = 0;
      private long f = -1L;
      private boolean g = false;
      private final int h = 100;
      private final int i = 1000;
      private final int j = 2500;

      private void a()
      {
        this.d = -1L;
        this.c = -1L;
        this.e = 0;
        this.f = -1L;
        this.g = false;
      }

      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getPointerCount() > 2)
          a();
        do
        {
          return false;
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          case 2:
          case 3:
          case 4:
          default:
            return false;
          case 0:
            this.d = System.currentTimeMillis();
            return false;
          case 5:
            if (System.currentTimeMillis() - this.d < 100L)
            {
              if (System.currentTimeMillis() - this.f > 1000L)
                a();
              this.c = System.currentTimeMillis();
              this.g = true;
              return false;
            }
            a();
            return false;
          case 6:
            if (this.g)
            {
              this.d = System.currentTimeMillis();
              return false;
            }
            a();
            return false;
          case 1:
          }
        }
        while (System.currentTimeMillis() - this.d >= 100L);
        if (System.currentTimeMillis() - this.c >= 2500L)
        {
          if (this.e == 3)
          {
            paramMixpanelAPI.track("$ab_gesture1");
            a();
          }
          this.e = 0;
          return false;
        }
        this.f = System.currentTimeMillis();
        if (this.e < 4)
        {
          this.e = (1 + this.e);
          return false;
        }
        if (this.e == 4)
        {
          paramMixpanelAPI.track("$ab_gesture2");
          a();
          return false;
        }
        a();
        return false;
      }
    };
  }

  private void a(MixpanelAPI paramMixpanelAPI, Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setOnTouchListener(a(paramMixpanelAPI));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.g
 * JD-Core Version:    0.6.2
 */