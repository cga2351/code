package com.slidingmenu.lib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;

public class c extends ViewGroup
{
  private static final Logger a = ViberEnv.getLogger();
  private int b = 0;
  private a c;
  private View d;
  private View e;
  private int f = (int)TypedValue.applyDimension(1, 48.0F, getResources().getDisplayMetrics());
  private int g;
  private SlidingMenu.a h;
  private boolean i;
  private int j;
  private boolean k;
  private final Paint l = new Paint();
  private float m;
  private Drawable n;
  private Drawable o;
  private int p;
  private float q;
  private boolean r = true;
  private Bitmap s;
  private View t;

  public c(Context paramContext)
  {
    this(paramContext, null);
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int getSelectorTop()
  {
    return this.t.getTop() + (this.t.getHeight() - this.s.getHeight()) / 2;
  }

  public int a(int paramInt)
  {
    if (paramInt > 1)
      paramInt = 2;
    while ((this.j == 0) && (paramInt > 1))
    {
      return 0;
      if (paramInt < 1)
        paramInt = 0;
    }
    if ((this.j == 1) && (paramInt < 1))
      return 2;
    return paramInt;
  }

  public int a(View paramView)
  {
    if ((this.j == 0) || (this.j == 2))
      return paramView.getLeft() - getBehindWidth();
    if (this.j == 1)
      return paramView.getLeft();
    return 0;
  }

  public int a(View paramView, int paramInt)
  {
    if (this.j == 0)
      switch (paramInt)
      {
      case 1:
      default:
      case 0:
      case 2:
      }
    while (true)
    {
      return paramView.getLeft();
      return paramView.getLeft() - getBehindWidth();
      return paramView.getLeft();
      if (this.j == 1)
        switch (paramInt)
        {
        case 1:
        default:
          break;
        case 0:
          return paramView.getLeft();
        case 2:
          return paramView.getLeft() + getBehindWidth();
        }
      else if (this.j == 2)
        switch (paramInt)
        {
        case 1:
        default:
        case 0:
        case 2:
        }
    }
    return paramView.getLeft() - getBehindWidth();
    return paramView.getLeft() + getBehindWidth();
  }

  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.j == 0)
      if (paramInt1 < paramView.getLeft())
        break label268;
    label139: label268: for (int i1 = 4; ; i1 = 0)
    {
      scrollTo((int)((paramInt1 + getBehindWidth()) * this.m), paramInt2);
      if (i1 == 4)
        a.a("behind INVISIBLE", new Object[0]);
      setVisibility(i1);
      return;
      if (this.j == 1)
        if (paramInt1 > paramView.getLeft())
          break label262;
      for (i1 = 4; ; i1 = 0)
      {
        scrollTo((int)(getBehindWidth() - getWidth() + (paramInt1 - getBehindWidth()) * this.m), paramInt2);
        break;
        if (this.j == 2)
        {
          View localView1 = this.d;
          int i2;
          int i3;
          if (paramInt1 >= paramView.getLeft())
          {
            i2 = 4;
            localView1.setVisibility(i2);
            View localView2 = this.e;
            if (paramInt1 > paramView.getLeft())
              break label212;
            i3 = 4;
            label163: localView2.setVisibility(i3);
            if (paramInt1 != 0)
              break label218;
          }
          label212: label218: for (i1 = 4; ; i1 = 0)
          {
            if (paramInt1 > paramView.getLeft())
              break label224;
            scrollTo((int)((paramInt1 + getBehindWidth()) * this.m), paramInt2);
            break;
            i2 = 0;
            break label139;
            i3 = 0;
            break label163;
          }
          label224: scrollTo((int)(getBehindWidth() - getWidth() + (paramInt1 - getBehindWidth()) * this.m), paramInt2);
          break;
        }
        i1 = 0;
        break;
      }
    }
  }

  public void a(View paramView, Canvas paramCanvas)
  {
    if ((this.n == null) || (this.p <= 0))
      return;
    int i1;
    if (this.j == 0)
      i1 = paramView.getLeft() - this.p;
    while (true)
    {
      this.n.setBounds(i1, 0, i1 + this.p, getHeight());
      this.n.draw(paramCanvas);
      return;
      if (this.j == 1)
      {
        if (this.e == null)
        {
          i1 = paramView.getRight();
        }
        else
        {
          if (this.o != null)
          {
            int i3 = paramView.getRight();
            this.o.setBounds(i3, 0, i3 + this.p, getHeight());
            this.o.draw(paramCanvas);
          }
          i1 = paramView.getLeft() - this.p;
        }
      }
      else if (this.j == 2)
      {
        if (this.o != null)
        {
          int i2 = paramView.getRight();
          this.o.setBounds(i2, 0, i2 + this.p, getHeight());
          this.o.draw(paramCanvas);
        }
        i1 = paramView.getLeft() - this.p;
      }
      else
      {
        i1 = 0;
      }
    }
  }

  public void a(View paramView, Canvas paramCanvas, float paramFloat)
  {
    if (!this.k)
      return;
    int i1 = (int)(255.0F * this.q * Math.abs(1.0F - paramFloat));
    this.l.setColor(Color.argb(i1, 0, 0, 0));
    int i3;
    int i2;
    if (this.j == 0)
    {
      i3 = paramView.getLeft() - getBehindWidth();
      i2 = paramView.getLeft();
    }
    while (true)
    {
      paramCanvas.drawRect(i3, 0.0F, i2, getHeight(), this.l);
      return;
      if (this.j == 1)
      {
        i3 = paramView.getRight();
        i2 = paramView.getRight() + getBehindWidth();
      }
      else if (this.j == 2)
      {
        int i4 = paramView.getLeft() - getBehindWidth();
        int i5 = paramView.getLeft();
        paramCanvas.drawRect(i4, 0.0F, i5, getHeight(), this.l);
        i3 = paramView.getRight();
        i2 = paramView.getRight() + getBehindWidth();
      }
      else
      {
        i2 = 0;
        i3 = 0;
      }
    }
  }

  public boolean a(float paramFloat)
  {
    if (this.j == 0)
      if (paramFloat <= 0.0F);
    do
    {
      do
      {
        return true;
        return false;
        if (this.j != 1)
          break;
      }
      while (paramFloat < 0.0F);
      return false;
    }
    while (this.j == 2);
    return false;
  }

  public boolean a(View paramView, int paramInt, float paramFloat)
  {
    switch (this.b)
    {
    default:
      return false;
    case 1:
      return true;
    case 0:
    }
    return b(paramView, paramInt, paramFloat);
  }

  public int b(View paramView)
  {
    if (this.j == 0)
      return paramView.getLeft();
    if ((this.j == 1) || (this.j == 2))
      return paramView.getLeft() + getBehindWidth();
    return 0;
  }

  public void b(View paramView, Canvas paramCanvas, float paramFloat)
  {
    if (!this.r);
    while ((this.s == null) || (this.t == null) || (!((String)this.t.getTag(R.id.selected_view)).equals("CustomViewBehindSelectedView")))
      return;
    paramCanvas.save();
    int i1 = (int)(paramFloat * this.s.getWidth());
    if (this.j == 0)
    {
      int i4 = paramView.getLeft();
      int i5 = i4 - i1;
      paramCanvas.clipRect(i5, 0, i4, getHeight());
      paramCanvas.drawBitmap(this.s, i5, getSelectorTop(), null);
    }
    while (true)
    {
      paramCanvas.restore();
      return;
      if (this.j == 1)
      {
        int i2 = paramView.getRight();
        int i3 = i1 + i2;
        paramCanvas.clipRect(i2, 0, i3, getHeight());
        paramCanvas.drawBitmap(this.s, i3 - this.s.getWidth(), getSelectorTop(), null);
      }
    }
  }

  public boolean b(float paramFloat)
  {
    if (this.j == 0)
      if (paramFloat >= 0.0F);
    do
    {
      do
      {
        return true;
        return false;
        if (this.j != 1)
          break;
      }
      while (paramFloat > 0.0F);
      return false;
    }
    while (this.j == 2);
    return false;
  }

  public boolean b(View paramView, int paramInt)
  {
    int i1 = paramView.getLeft();
    int i2 = paramView.getRight();
    if (this.j == 0)
      if ((paramInt < i1) || (paramInt > i1 + this.f));
    do
    {
      do
      {
        return true;
        return false;
        if (this.j != 1)
          break;
      }
      while ((paramInt <= i2) && (paramInt >= i2 - this.f));
      return false;
      if (this.j != 2)
        break;
    }
    while (((paramInt >= i1) && (paramInt <= i1 + this.f)) || ((paramInt <= i2) && (paramInt >= i2 - this.f)));
    return false;
    return false;
  }

  public boolean b(View paramView, int paramInt, float paramFloat)
  {
    if ((this.j == 0) || ((this.j == 2) && (paramInt == 0)))
      if (paramFloat < paramView.getLeft());
    do
    {
      return true;
      return false;
      if ((this.j != 1) && ((this.j != 2) || (paramInt != 2)))
        break;
    }
    while (paramFloat <= paramView.getRight());
    return false;
    return false;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.h != null)
    {
      paramCanvas.save();
      this.h.a(paramCanvas, this.c.getPercentOpen());
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }

  public int getBehindWidth()
  {
    return this.d.getWidth();
  }

  public View getContent()
  {
    return this.d;
  }

  public int getMarginThreshold()
  {
    return this.f;
  }

  public int getMode()
  {
    return this.j;
  }

  public float getScrollScale()
  {
    return this.m;
  }

  public View getSecondaryContent()
  {
    return this.e;
  }

  public int getWidthOffset()
  {
    return this.g;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.i;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    this.d.layout(0, 0, i1 - this.g, i2);
    if (this.e != null)
      this.e.layout(0, 0, i1 - this.g, i2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(0, paramInt1);
    int i2 = getDefaultSize(0, paramInt2);
    setMeasuredDimension(i1, i2);
    int i3 = getChildMeasureSpec(paramInt1, 0, i1 - this.g);
    int i4 = getChildMeasureSpec(paramInt2, 0, i2);
    this.d.measure(i3, i4);
    if (this.e != null)
      this.e.measure(i3, i4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.i;
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
    if (this.h != null)
      invalidate();
  }

  public void setCanvasTransformer(SlidingMenu.a parama)
  {
    this.h = parama;
  }

  public void setChildrenEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setContent(View paramView)
  {
    if (this.d != null)
      removeView(this.d);
    if (paramView.getParent() != null)
      return;
    this.d = paramView;
    addView(this.d);
  }

  public void setCustomViewAbove(a parama)
  {
    this.c = parama;
  }

  public void setFadeDegree(float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat < 0.0F))
      throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
    this.q = paramFloat;
  }

  public void setFadeEnabled(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setMarginThreshold(int paramInt)
  {
    this.f = paramInt;
  }

  public void setMode(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      this.j = paramInt;
      return;
      if (this.d != null)
        this.d.setVisibility(0);
      if (this.e != null)
      {
        this.e.setVisibility(4);
        continue;
        if ((this.d != null) && (this.e != null))
        {
          this.d.setVisibility(4);
          this.e.setVisibility(0);
        }
        else
        {
          if (this.d != null)
            this.d.setVisibility(0);
          if (this.e != null)
            this.e.setVisibility(4);
        }
      }
    }
  }

  public void setScrollScale(float paramFloat)
  {
    this.m = paramFloat;
  }

  public void setSecondaryContent(View paramView)
  {
    if (this.e != null)
      removeView(this.e);
    this.e = paramView;
    addView(this.e);
  }

  public void setSecondaryShadowDrawable(Drawable paramDrawable)
  {
    this.o = paramDrawable;
    invalidate();
  }

  public void setSelectedView(View paramView)
  {
    if (this.t != null)
    {
      this.t.setTag(R.id.selected_view, null);
      this.t = null;
    }
    if ((paramView != null) && (paramView.getParent() != null))
    {
      this.t = paramView;
      this.t.setTag(R.id.selected_view, "CustomViewBehindSelectedView");
      invalidate();
    }
  }

  public void setSelectorBitmap(Bitmap paramBitmap)
  {
    this.s = paramBitmap;
    refreshDrawableState();
  }

  public void setSelectorEnabled(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.n = paramDrawable;
    invalidate();
  }

  public void setShadowWidth(int paramInt)
  {
    this.p = paramInt;
    invalidate();
  }

  public void setTouchMode(int paramInt)
  {
    this.b = paramInt;
  }

  public void setWidthOffset(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.slidingmenu.lib.c
 * JD-Core Version:    0.6.2
 */