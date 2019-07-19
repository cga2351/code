package com.mopub.mobileads;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;

public class ViewGestureDetector extends GestureDetector
{
  private final View a;
  private AdAlertGestureListener b;

  public ViewGestureDetector(Context paramContext, View paramView, AdReport paramAdReport)
  {
    this(paramContext, paramView, new AdAlertGestureListener(paramView, paramAdReport));
  }

  private ViewGestureDetector(Context paramContext, View paramView, AdAlertGestureListener paramAdAlertGestureListener)
  {
    super(paramContext, paramAdAlertGestureListener);
    this.b = paramAdAlertGestureListener;
    this.a = paramView;
    setIsLongpressEnabled(false);
  }

  private boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    if ((paramMotionEvent == null) || (paramView == null));
    float f1;
    float f2;
    do
    {
      return false;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    }
    while ((f1 < 0.0F) || (f1 > paramView.getWidth()) || (f2 < 0.0F) || (f2 > paramView.getHeight()));
    return true;
  }

  void a()
  {
    this.b.b();
  }

  public boolean isClicked()
  {
    return this.b.d();
  }

  public void onResetUserClick()
  {
    this.b.c();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 1:
    case 2:
    }
    do
    {
      return bool;
      this.b.a();
      return bool;
    }
    while (a(paramMotionEvent, this.a));
    a();
    return bool;
  }

  @VisibleForTesting
  public void setClicked(boolean paramBoolean)
  {
    this.b.a = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.ViewGestureDetector
 * JD-Core Version:    0.6.2
 */