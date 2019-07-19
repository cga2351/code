package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import javax.annotation.Nullable;

public class a extends ReactRootView
{

  @Nullable
  private ReactInstanceManager a;

  @Nullable
  private g b;

  public a(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    if (this.b != null)
      throw new IllegalStateException("GestureHandler already initialized for root view " + this);
    this.b = new g(this.a.getCurrentReactContext(), this);
  }

  public void b()
  {
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.b != null) && (this.b.a(paramMotionEvent)))
      return true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.b != null)
      this.b.a(paramBoolean);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString, @Nullable Bundle paramBundle)
  {
    super.startReactApplication(paramReactInstanceManager, paramString, paramBundle);
    this.a = paramReactInstanceManager;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.a
 * JD-Core Version:    0.6.2
 */