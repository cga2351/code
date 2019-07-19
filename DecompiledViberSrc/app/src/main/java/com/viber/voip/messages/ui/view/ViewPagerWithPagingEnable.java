package com.viber.voip.messages.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ViewPagerWithPagingEnable extends ViewPager
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b = true;
  private a c;

  public ViewPagerWithPagingEnable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
      }
    return false;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.c != null) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)))
      this.c.a(paramInt1, paramInt2);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
      }
    return false;
  }

  public void setOnSizeChangeListener(a parama)
  {
    this.c = parama;
  }

  public void setPagingEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable
 * JD-Core Version:    0.6.2
 */