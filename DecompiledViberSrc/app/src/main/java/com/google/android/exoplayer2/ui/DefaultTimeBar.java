package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.google.android.exoplayer2.g.ag;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View
  implements g
{
  private long A;
  private int B;
  private boolean C;
  private long D;
  private long E;
  private long F;
  private long G;
  private int H;
  private long[] I;
  private boolean[] J;
  private final Rect a = new Rect();
  private final Rect b = new Rect();
  private final Rect c = new Rect();
  private final Rect d = new Rect();
  private final Paint e = new Paint();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private final Paint i = new Paint();
  private final Paint j = new Paint();
  private final Drawable k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final StringBuilder t;
  private final Formatter u;
  private final Runnable v;
  private final CopyOnWriteArraySet<g.a> w;
  private final int[] x;
  private final Point y;
  private int z;

  public DefaultTimeBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j.setAntiAlias(true);
    this.w = new CopyOnWriteArraySet();
    this.x = new int[2];
    this.y = new Point();
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.s = a(localDisplayMetrics, -50);
    int i1 = a(localDisplayMetrics, 4);
    int i2 = a(localDisplayMetrics, 26);
    int i3 = a(localDisplayMetrics, 4);
    int i4 = a(localDisplayMetrics, 12);
    int i5 = a(localDisplayMetrics, 0);
    int i6 = a(localDisplayMetrics, 16);
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.DefaultTimeBar, 0, 0);
    while (true)
    {
      try
      {
        this.k = localTypedArray.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
        if (this.k != null)
        {
          a(this.k);
          i2 = Math.max(this.k.getMinimumHeight(), i2);
        }
        this.l = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, i1);
        this.m = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, i2);
        this.n = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, i3);
        this.o = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, i4);
        this.p = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, i5);
        this.q = localTypedArray.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, i6);
        int i7 = localTypedArray.getInt(R.styleable.DefaultTimeBar_played_color, -1);
        int i8 = localTypedArray.getInt(R.styleable.DefaultTimeBar_scrubber_color, a(i7));
        int i9 = localTypedArray.getInt(R.styleable.DefaultTimeBar_buffered_color, c(i7));
        int i10 = localTypedArray.getInt(R.styleable.DefaultTimeBar_unplayed_color, b(i7));
        int i11 = localTypedArray.getInt(R.styleable.DefaultTimeBar_ad_marker_color, -1291845888);
        int i12 = localTypedArray.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, d(i11));
        this.e.setColor(i7);
        this.j.setColor(i8);
        this.f.setColor(i9);
        this.g.setColor(i10);
        this.h.setColor(i11);
        this.i.setColor(i12);
        localTypedArray.recycle();
        this.t = new StringBuilder();
        this.u = new Formatter(this.t, Locale.getDefault());
        this.v = new a(this);
        if (this.k == null)
          break label708;
        this.r = ((1 + this.k.getMinimumWidth()) / 2);
        this.E = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.z = 20;
        setFocusable(true);
        if (ag.a >= 16)
          b();
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.l = i1;
      this.m = i2;
      this.n = i3;
      this.o = i4;
      this.p = i5;
      this.q = i6;
      this.e.setColor(-1);
      this.j.setColor(a(-1));
      this.f.setColor(c(-1));
      this.g.setColor(b(-1));
      this.h.setColor(-1291845888);
      this.k = null;
      continue;
      label708: this.r = ((1 + Math.max(this.p, Math.max(this.o, this.q))) / 2);
    }
  }

  public static int a(int paramInt)
  {
    return 0xFF000000 | paramInt;
  }

  private static int a(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)(0.5F + paramInt * paramDisplayMetrics.density);
  }

  private Point a(MotionEvent paramMotionEvent)
  {
    getLocationOnScreen(this.x);
    this.y.set((int)paramMotionEvent.getRawX() - this.x[0], (int)paramMotionEvent.getRawY() - this.x[1]);
    return this.y;
  }

  private void a(float paramFloat)
  {
    this.d.right = ag.a((int)paramFloat, this.b.left, this.b.right);
  }

  private void a(Canvas paramCanvas)
  {
    int i1 = this.b.height();
    int i2 = this.b.centerY() - i1 / 2;
    int i3 = i2 + i1;
    if (this.E <= 0L)
      paramCanvas.drawRect(this.b.left, i2, this.b.right, i3, this.g);
    do
    {
      return;
      int i4 = this.c.left;
      int i5 = this.c.right;
      int i6 = Math.max(Math.max(this.b.left, i5), this.d.right);
      if (i6 < this.b.right)
        paramCanvas.drawRect(i6, i2, this.b.right, i3, this.g);
      int i7 = Math.max(i4, this.d.right);
      if (i5 > i7)
        paramCanvas.drawRect(i7, i2, i5, i3, this.f);
      if (this.d.width() > 0)
        paramCanvas.drawRect(this.d.left, i2, this.d.right, i3, this.e);
    }
    while (this.H == 0);
    long[] arrayOfLong = (long[])com.google.android.exoplayer2.g.a.a(this.I);
    boolean[] arrayOfBoolean = (boolean[])com.google.android.exoplayer2.g.a.a(this.J);
    int i8 = this.n / 2;
    int i9 = 0;
    label263: int i11;
    if (i9 < this.H)
    {
      int i10 = (int)(ag.a(arrayOfLong[i9], 0L, this.E) * this.b.width() / this.E) - i8;
      i11 = this.b.left + Math.min(this.b.width() - this.n, Math.max(0, i10));
      if (arrayOfBoolean[i9] == 0)
        break label378;
    }
    label378: for (Paint localPaint = this.i; ; localPaint = this.h)
    {
      paramCanvas.drawRect(i11, i2, i11 + this.n, i3, localPaint);
      i9++;
      break label263;
      break;
    }
  }

  private void a(boolean paramBoolean)
  {
    this.C = false;
    setPressed(false);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
      localViewParent.requestDisallowInterceptTouchEvent(false);
    invalidate();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
      ((g.a)localIterator.next()).a(this, getScrubberPosition(), paramBoolean);
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.a.contains((int)paramFloat1, (int)paramFloat2);
  }

  private boolean a(long paramLong)
  {
    if (this.E <= 0L)
      return false;
    long l1 = getScrubberPosition();
    this.D = ag.a(l1 + paramLong, 0L, this.E);
    if (this.D == l1)
      return false;
    if (!this.C)
      c();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
      ((g.a)localIterator.next()).b(this, this.D);
    d();
    return true;
  }

  private boolean a(Drawable paramDrawable)
  {
    return (ag.a >= 23) && (a(paramDrawable, getLayoutDirection()));
  }

  private static boolean a(Drawable paramDrawable, int paramInt)
  {
    return (ag.a >= 23) && (paramDrawable.setLayoutDirection(paramInt));
  }

  public static int b(int paramInt)
  {
    return 0x33000000 | 0xFFFFFF & paramInt;
  }

  @TargetApi(16)
  private void b()
  {
    if (getImportantForAccessibility() == 0)
      setImportantForAccessibility(1);
  }

  private void b(Canvas paramCanvas)
  {
    if (this.E <= 0L)
      return;
    int i1 = ag.a(this.d.right, this.d.left, this.b.right);
    int i2 = this.d.centerY();
    if (this.k == null)
    {
      int i5;
      if ((this.C) || (isFocused()))
        i5 = this.q;
      while (true)
      {
        int i6 = i5 / 2;
        paramCanvas.drawCircle(i1, i2, i6, this.j);
        return;
        if (isEnabled())
          i5 = this.o;
        else
          i5 = this.p;
      }
    }
    int i3 = this.k.getIntrinsicWidth();
    int i4 = this.k.getIntrinsicHeight();
    this.k.setBounds(i1 - i3 / 2, i2 - i4 / 2, i1 + i3 / 2, i2 + i4 / 2);
    this.k.draw(paramCanvas);
  }

  public static int c(int paramInt)
  {
    return 0xCC000000 | 0xFFFFFF & paramInt;
  }

  private void c()
  {
    this.C = true;
    setPressed(true);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
      localViewParent.requestDisallowInterceptTouchEvent(true);
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
      ((g.a)localIterator.next()).a(this, getScrubberPosition());
  }

  public static int d(int paramInt)
  {
    return 0x33000000 | 0xFFFFFF & paramInt;
  }

  private void d()
  {
    this.c.set(this.b);
    this.d.set(this.b);
    long l1;
    int i2;
    if (this.C)
    {
      l1 = this.D;
      if (this.E <= 0L)
        break label151;
      int i1 = (int)(this.b.width() * this.G / this.E);
      this.c.right = Math.min(i1 + this.b.left, this.b.right);
      i2 = (int)(l1 * this.b.width() / this.E);
    }
    for (this.d.right = Math.min(i2 + this.b.left, this.b.right); ; this.d.right = this.b.left)
    {
      invalidate(this.a);
      return;
      l1 = this.F;
      break;
      label151: this.c.right = this.b.left;
    }
  }

  private void e()
  {
    if ((this.k != null) && (this.k.isStateful()) && (this.k.setState(getDrawableState())))
      invalidate();
  }

  private long getPositionIncrement()
  {
    if (this.A == -9223372036854775807L)
    {
      if (this.E == -9223372036854775807L)
        return 0L;
      return this.E / this.z;
    }
    return this.A;
  }

  private String getProgressText()
  {
    return ag.a(this.t, this.u, this.F);
  }

  private long getScrubberPosition()
  {
    if ((this.b.width() <= 0) || (this.E == -9223372036854775807L))
      return 0L;
    return this.d.width() * this.E / this.b.width();
  }

  public void a(g.a parama)
  {
    this.w.add(parama);
  }

  public void a(long[] paramArrayOfLong, boolean[] paramArrayOfBoolean, int paramInt)
  {
    if ((paramInt == 0) || ((paramArrayOfLong != null) && (paramArrayOfBoolean != null)));
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.a(bool);
      this.H = paramInt;
      this.I = paramArrayOfLong;
      this.J = paramArrayOfBoolean;
      d();
      return;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    e();
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.k != null)
      this.k.jumpToCurrentState();
  }

  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    a(paramCanvas);
    b(paramCanvas);
    paramCanvas.restore();
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 4)
      paramAccessibilityEvent.getText().add(getProgressText());
    paramAccessibilityEvent.setClassName("android.widget.SeekBar");
  }

  @TargetApi(21)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
    paramAccessibilityNodeInfo.setContentDescription(getProgressText());
    if (this.E <= 0L);
    do
    {
      return;
      if (ag.a >= 21)
      {
        paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        return;
      }
    }
    while (ag.a < 16);
    paramAccessibilityNodeInfo.addAction(4096);
    paramAccessibilityNodeInfo.addAction(8192);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    long l1;
    if (isEnabled())
    {
      l1 = getPositionIncrement();
      switch (paramInt)
      {
      default:
      case 21:
      case 22:
      case 23:
      case 66:
      }
    }
    do
    {
      do
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        l1 = -l1;
      }
      while (!a(l1));
      removeCallbacks(this.v);
      postDelayed(this.v, 1000L);
      return true;
    }
    while (!this.C);
    removeCallbacks(this.v);
    this.v.run();
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = (paramInt4 - paramInt2 - this.m) / 2;
    int i3 = getPaddingLeft();
    int i4 = i1 - getPaddingRight();
    int i5 = i2 + (this.m - this.l) / 2;
    this.a.set(i3, i2, i4, i2 + this.m);
    this.b.set(this.a.left + this.r, i5, this.a.right - this.r, i5 + this.l);
    d();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 0)
      i2 = this.m;
    while (true)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), i2);
      e();
      return;
      if (i1 != 1073741824)
        i2 = Math.min(this.m, i2);
    }
  }

  public void onRtlPropertiesChanged(int paramInt)
  {
    if ((this.k != null) && (a(this.k, paramInt)))
      invalidate();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (this.E <= 0L))
      return false;
    Point localPoint = a(paramMotionEvent);
    int i1 = localPoint.x;
    int i2 = localPoint.y;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    do
    {
      do
      {
        do
          return false;
        while (!a(i1, i2));
        a(i1);
        c();
        this.D = getScrubberPosition();
        d();
        invalidate();
        return true;
      }
      while (!this.C);
      if (i2 < this.s)
      {
        int i4 = i1 - this.B;
        a(this.B + i4 / 3);
      }
      while (true)
      {
        this.D = getScrubberPosition();
        Iterator localIterator = this.w.iterator();
        while (localIterator.hasNext())
          ((g.a)localIterator.next()).b(this, this.D);
        this.B = i1;
        a(i1);
      }
      d();
      invalidate();
      return true;
    }
    while (!this.C);
    int i3 = paramMotionEvent.getAction();
    boolean bool = false;
    if (i3 == 3)
      bool = true;
    a(bool);
    return true;
  }

  @TargetApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle))
      return true;
    if (this.E <= 0L)
      return false;
    if (paramInt == 8192)
      if (a(-getPositionIncrement()))
        a(false);
    while (true)
    {
      sendAccessibilityEvent(4);
      return true;
      if (paramInt != 4096)
        break;
      if (a(getPositionIncrement()))
        a(false);
    }
    return false;
  }

  public void setAdMarkerColor(int paramInt)
  {
    this.h.setColor(paramInt);
    invalidate(this.a);
  }

  public void setBufferedColor(int paramInt)
  {
    this.f.setColor(paramInt);
    invalidate(this.a);
  }

  public void setBufferedPosition(long paramLong)
  {
    this.G = paramLong;
    d();
  }

  public void setDuration(long paramLong)
  {
    this.E = paramLong;
    if ((this.C) && (paramLong == -9223372036854775807L))
      a(true);
    d();
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if ((this.C) && (!paramBoolean))
      a(true);
  }

  public void setKeyCountIncrement(int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.a(bool);
      this.z = paramInt;
      this.A = -9223372036854775807L;
      return;
    }
  }

  public void setKeyTimeIncrement(long paramLong)
  {
    if (paramLong > 0L);
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.a(bool);
      this.z = -1;
      this.A = paramLong;
      return;
    }
  }

  public void setPlayedAdMarkerColor(int paramInt)
  {
    this.i.setColor(paramInt);
    invalidate(this.a);
  }

  public void setPlayedColor(int paramInt)
  {
    this.e.setColor(paramInt);
    invalidate(this.a);
  }

  public void setPosition(long paramLong)
  {
    this.F = paramLong;
    setContentDescription(getProgressText());
    d();
  }

  public void setScrubberColor(int paramInt)
  {
    this.j.setColor(paramInt);
    invalidate(this.a);
  }

  public void setUnplayedColor(int paramInt)
  {
    this.g.setColor(paramInt);
    invalidate(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.DefaultTimeBar
 * JD-Core Version:    0.6.2
 */