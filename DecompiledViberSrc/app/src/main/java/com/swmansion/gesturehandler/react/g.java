package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.b;
import com.swmansion.gesturehandler.d;

public class g
{
  private final ReactContext a;
  private final d b;
  private final b c;
  private final ReactRootView d;
  private boolean e = false;
  private boolean f = false;

  public g(ReactContext paramReactContext, ViewGroup paramViewGroup)
  {
    UiThreadUtil.assertOnUiThread();
    int i = paramViewGroup.getId();
    if (i < 1)
      throw new IllegalStateException("Expect view tag to be set for " + paramViewGroup);
    RNGestureHandlerModule localRNGestureHandlerModule = (RNGestureHandlerModule)paramReactContext.getNativeModule(RNGestureHandlerModule.class);
    f localf = localRNGestureHandlerModule.getRegistry();
    this.d = a(paramViewGroup);
    Log.i("ReactNative", "[GESTURE HANDLER] Initialize gesture handler for root view " + this.d);
    this.a = paramReactContext;
    this.b = new d(paramViewGroup, localf, new j());
    this.b.a(0.1F);
    this.c = new a(null);
    this.c.c(-i);
    localf.a(this.c);
    localf.a(this.c.d(), i);
    localRNGestureHandlerModule.registerRootHelper(this);
  }

  private static ReactRootView a(ViewGroup paramViewGroup)
  {
    UiThreadUtil.assertOnUiThread();
    for (Object localObject = paramViewGroup; (localObject != null) && (!(localObject instanceof ReactRootView)); localObject = ((ViewParent)localObject).getParent());
    if (localObject == null)
      throw new IllegalStateException("View " + paramViewGroup + " has not been mounted under ReactRootView");
    return (ReactRootView)localObject;
  }

  private void c()
  {
    if ((this.c != null) && (this.c.i() == 2))
    {
      this.c.l();
      this.c.n();
    }
  }

  public void a()
  {
    Log.i("ReactNative", "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.d);
    RNGestureHandlerModule localRNGestureHandlerModule = (RNGestureHandlerModule)this.a.getNativeModule(RNGestureHandlerModule.class);
    localRNGestureHandlerModule.getRegistry().b(this.c.d());
    localRNGestureHandlerModule.unregisterRootHelper(this);
  }

  void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          g.b(g.this);
        }
      });
  }

  public void a(boolean paramBoolean)
  {
    if ((this.b != null) && (!this.f))
      c();
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.f = true;
    this.b.a(paramMotionEvent);
    this.f = false;
    return this.e;
  }

  public ReactRootView b()
  {
    return this.d;
  }

  private class a extends b
  {
    private a()
    {
    }

    protected void a()
    {
      g.a(g.this, true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      g.a(g.this).onChildStartedNativeGesture(localMotionEvent);
    }

    protected void a(MotionEvent paramMotionEvent)
    {
      if (i() == 0)
      {
        m();
        g.a(g.this, false);
      }
      if (paramMotionEvent.getActionMasked() == 1)
        n();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.g
 * JD-Core Version:    0.6.2
 */