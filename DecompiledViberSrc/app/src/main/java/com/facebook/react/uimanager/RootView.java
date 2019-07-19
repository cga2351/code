package com.facebook.react.uimanager;

import android.view.MotionEvent;

public abstract interface RootView
{
  public abstract void handleException(Throwable paramThrowable);

  public abstract void onChildStartedNativeGesture(MotionEvent paramMotionEvent);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.RootView
 * JD-Core Version:    0.6.2
 */