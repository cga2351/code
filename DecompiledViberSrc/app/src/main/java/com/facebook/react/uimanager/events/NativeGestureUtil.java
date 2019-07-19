package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;

public class NativeGestureUtil
{
  public static void notifyNativeGestureStarted(View paramView, MotionEvent paramMotionEvent)
  {
    RootViewUtil.getRootView(paramView).onChildStartedNativeGesture(paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.NativeGestureUtil
 * JD-Core Version:    0.6.2
 */