package com.swmansion.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGestureHandlerButtonViewManager extends ViewGroupManager<a>
{
  public a createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new a(paramThemedReactContext);
  }

  public String getName()
  {
    return "RNGestureHandlerButton";
  }

  protected void onAfterUpdateTransaction(a parama)
  {
    a.a(parama);
  }

  @ReactProp(name="borderRadius")
  public void setBorderRadius(a parama, float paramFloat)
  {
    parama.a(paramFloat);
  }

  @ReactProp(name="borderless")
  public void setBorderless(a parama, boolean paramBoolean)
  {
    parama.b(paramBoolean);
  }

  @ReactProp(name="enabled")
  public void setEnabled(a parama, boolean paramBoolean)
  {
    parama.setEnabled(paramBoolean);
  }

  @ReactProp(name="foreground")
  @TargetApi(23)
  public void setForeground(a parama, boolean paramBoolean)
  {
    parama.a(paramBoolean);
  }

  @ReactProp(name="rippleColor")
  public void setRippleColor(a parama, Integer paramInteger)
  {
    parama.a(paramInteger);
  }

  static class a extends ViewGroup
  {
    static TypedValue a = new TypedValue();
    static a b;
    int c = 0;
    Integer d;
    boolean e = false;
    boolean f = false;
    float g = 0.0F;
    boolean h = false;

    public a(Context paramContext)
    {
      super();
      setClickable(true);
      setFocusable(true);
      this.h = true;
    }

    private Drawable a(Drawable paramDrawable)
    {
      if ((this.d != null) && (paramDrawable != null) && (Build.VERSION.SDK_INT >= 21) && ((paramDrawable instanceof RippleDrawable)))
      {
        int[][] arrayOfInt = { { 16842910 } };
        int[] arrayOfInt1 = new int[1];
        arrayOfInt1[0] = this.d.intValue();
        ColorStateList localColorStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
        ((RippleDrawable)paramDrawable).setColor(localColorStateList);
      }
      return paramDrawable;
    }

    private void a()
    {
      if (!this.h);
      do
      {
        return;
        this.h = false;
        if (this.c == 0)
          setBackground(null);
        if (Build.VERSION.SDK_INT >= 23)
          setForeground(null);
        if ((!this.e) || (Build.VERSION.SDK_INT < 23))
          break;
        setForeground(a(b()));
      }
      while (this.c == 0);
      setBackgroundColor(this.c);
      return;
      if ((this.c == 0) && (this.d == null))
      {
        setBackground(b());
        return;
      }
      PaintDrawable localPaintDrawable1 = new PaintDrawable(this.c);
      Drawable localDrawable = b();
      if (this.g != 0.0F)
      {
        localPaintDrawable1.setCornerRadius(this.g);
        if ((Build.VERSION.SDK_INT >= 21) && ((localDrawable instanceof RippleDrawable)))
        {
          PaintDrawable localPaintDrawable2 = new PaintDrawable(-1);
          localPaintDrawable2.setCornerRadius(this.g);
          ((RippleDrawable)localDrawable).setDrawableByLayerId(16908334, localPaintDrawable2);
        }
      }
      a(localDrawable);
      setBackground(new LayerDrawable(new Drawable[] { localPaintDrawable1, localDrawable }));
    }

    private Drawable b()
    {
      int i = Build.VERSION.SDK_INT;
      if ((this.f) && (i >= 21));
      for (String str = "selectableItemBackgroundBorderless"; ; str = "selectableItemBackground")
      {
        int j = getResources().getIdentifier(str, "attr", "android");
        getContext().getTheme().resolveAttribute(j, a, true);
        if (i < 21)
          break;
        return getResources().getDrawable(a.resourceId, getContext().getTheme());
      }
      return getResources().getDrawable(a.resourceId);
    }

    public void a(float paramFloat)
    {
      this.g = (paramFloat * getResources().getDisplayMetrics().density);
      this.h = true;
    }

    public void a(Integer paramInteger)
    {
      this.d = paramInteger;
      this.h = true;
    }

    public void a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      this.h = true;
    }

    public void b(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }

    public void dispatchDrawableHotspotChanged(float paramFloat1, float paramFloat2)
    {
    }

    public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
    {
      if ((b == null) || (b == this))
        super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (super.onInterceptTouchEvent(paramMotionEvent));
      do
      {
        return true;
        onTouchEvent(paramMotionEvent);
      }
      while (isPressed());
      return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void setBackgroundColor(int paramInt)
    {
      this.c = paramInt;
      this.h = true;
    }

    public void setPressed(boolean paramBoolean)
    {
      if ((paramBoolean) && (b == null))
        b = this;
      if ((!paramBoolean) || (b == this))
        super.setPressed(paramBoolean);
      if ((!paramBoolean) && (b == this))
        b = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager
 * JD-Core Version:    0.6.2
 */