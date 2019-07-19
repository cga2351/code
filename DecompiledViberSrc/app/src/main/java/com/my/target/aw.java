package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

public class aw extends WebView
{
  private a a;
  private boolean b;
  private boolean c;
  private int d;

  @SuppressLint({"SetJavaScriptEnabled"})
  public aw(Context paramContext)
  {
    super(paramContext);
    if (getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      getSettings().setJavaScriptEnabled(true);
      getSettings().setDomStorageEnabled(true);
      getSettings().setAppCacheEnabled(true);
      getSettings().setAppCachePath(getContext().getCacheDir().getAbsolutePath());
      getSettings().setAllowFileAccess(false);
      getSettings().setAllowContentAccess(false);
      if (Build.VERSION.SDK_INT >= 16)
      {
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
      }
      final b localb = new b(getContext(), this);
      localb.a(new aw.b.a()
      {
        public void a()
        {
          aw.a(aw.this, true);
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          localb.a(paramAnonymousMotionEvent);
          return false;
        }
      });
      return;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 / paramInt2 > 1.0F);
    for (int i = 2; ; i = 1)
    {
      if (i != this.d)
      {
        this.d = i;
        if (this.a != null)
          this.a.a();
      }
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    dp.a("MraidWebView: pause, finishing " + paramBoolean);
    if (paramBoolean)
    {
      stopLoading();
      loadUrl("");
    }
    onPause();
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean b()
  {
    return this.b;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    super.onMeasure(paramInt1, paramInt2);
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      if (bool != this.b)
      {
        this.b = bool;
        if (this.a != null)
          this.a.a(this.b);
      }
      return;
    }
  }

  public void setClicked(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void setVisibilityChangedListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean);
  }

  private static class b extends GestureDetector
  {
    private final View a;
    private a b;

    public b(Context paramContext, View paramView)
    {
      this(paramContext, paramView, new GestureDetector.SimpleOnGestureListener());
    }

    private b(Context paramContext, View paramView, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
    {
      super(paramSimpleOnGestureListener);
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

    public void a(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 0:
      case 2:
      }
      do
      {
        return;
        if (this.b != null)
        {
          dp.a("Gestures: user clicked");
          this.b.a();
          return;
        }
        dp.a("View's onUserClick() is not registered.");
        return;
        onTouchEvent(paramMotionEvent);
        return;
      }
      while (!a(paramMotionEvent, this.a));
      onTouchEvent(paramMotionEvent);
    }

    public void a(a parama)
    {
      this.b = parama;
    }

    public static abstract interface a
    {
      public abstract void a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.aw
 * JD-Core Version:    0.6.2
 */