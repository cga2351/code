package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import javax.annotation.Nullable;

public class h extends ReactViewGroup
{

  @Nullable
  private g a;

  public h(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    if (this.a != null)
      this.a.a();
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((g)Assertions.assertNotNull(this.a)).a(paramMotionEvent))
      return true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a == null)
      this.a = new g((ReactContext)getContext(), this);
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ((g)Assertions.assertNotNull(this.a)).a(paramBoolean);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.h
 * JD-Core Version:    0.6.2
 */