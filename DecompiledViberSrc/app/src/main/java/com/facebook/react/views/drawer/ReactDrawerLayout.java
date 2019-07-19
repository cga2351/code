package com.facebook.react.views.drawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.NativeGestureUtil;

class ReactDrawerLayout extends DrawerLayout
{
  public static final int DEFAULT_DRAWER_WIDTH = -1;
  private int mDrawerPosition = 8388611;
  private int mDrawerWidth = -1;

  public ReactDrawerLayout(ReactContext paramReactContext)
  {
    super(paramReactContext);
  }

  void closeDrawer()
  {
    closeDrawer(this.mDrawerPosition);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (super.onInterceptTouchEvent(paramMotionEvent))
      {
        NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
        return true;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w("ReactNative", "Error intercepting touch event.", localIllegalArgumentException);
    }
    return false;
  }

  void openDrawer()
  {
    openDrawer(this.mDrawerPosition);
  }

  void setDrawerPosition(int paramInt)
  {
    this.mDrawerPosition = paramInt;
    setDrawerProperties();
  }

  void setDrawerProperties()
  {
    if (getChildCount() == 2)
    {
      View localView = getChildAt(1);
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.gravity = this.mDrawerPosition;
      localLayoutParams.width = this.mDrawerWidth;
      localView.setLayoutParams(localLayoutParams);
      localView.setClickable(true);
    }
  }

  void setDrawerWidth(int paramInt)
  {
    this.mDrawerWidth = paramInt;
    setDrawerProperties();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.drawer.ReactDrawerLayout
 * JD-Core Version:    0.6.2
 */