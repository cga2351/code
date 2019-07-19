package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class CloseableLayout extends FrameLayout
{
  private final int a;
  private OnCloseListener b;
  private final StateListDrawable c = new StateListDrawable();
  private ClosePosition d = ClosePosition.TOP_RIGHT;
  private final int e;
  private final int f;
  private final int g;
  private boolean h;
  private final Rect i = new Rect();
  private final Rect j = new Rect();
  private final Rect k = new Rect();
  private final Rect l = new Rect();
  private boolean m;
  private a n;

  public CloseableLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public CloseableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CloseableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(paramContext));
    this.c.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(paramContext));
    this.c.setState(EMPTY_STATE_SET);
    this.c.setCallback(this);
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = Dips.asIntPixels(50.0F, paramContext);
    this.f = Dips.asIntPixels(30.0F, paramContext);
    this.g = Dips.asIntPixels(8.0F, paramContext);
    setWillNotDraw(false);
    this.m = true;
  }

  private void a(ClosePosition paramClosePosition, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    Gravity.apply(paramClosePosition.a(), paramInt, paramInt, paramRect1, paramRect2);
  }

  private void a(ClosePosition paramClosePosition, Rect paramRect1, Rect paramRect2)
  {
    a(paramClosePosition, this.f, paramRect1, paramRect2);
  }

  private void c()
  {
    playSoundEffect(0);
    if (this.b != null)
      this.b.onClose();
  }

  private void setClosePressed(boolean paramBoolean)
  {
    if (paramBoolean == b())
      return;
    StateListDrawable localStateListDrawable = this.c;
    if (paramBoolean);
    for (int[] arrayOfInt = SELECTED_STATE_SET; ; arrayOfInt = EMPTY_STATE_SET)
    {
      localStateListDrawable.setState(arrayOfInt);
      invalidate(this.j);
      return;
    }
  }

  @VisibleForTesting
  boolean a()
  {
    return (this.m) || (this.c.isVisible());
  }

  @VisibleForTesting
  boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= this.j.left - paramInt3) && (paramInt2 >= this.j.top - paramInt3) && (paramInt1 < paramInt3 + this.j.right) && (paramInt2 < paramInt3 + this.j.bottom);
  }

  public void applyCloseRegionBounds(ClosePosition paramClosePosition, Rect paramRect1, Rect paramRect2)
  {
    a(paramClosePosition, this.e, paramRect1, paramRect2);
  }

  @VisibleForTesting
  boolean b()
  {
    return this.c.getState() == SELECTED_STATE_SET;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.h)
    {
      this.h = false;
      this.i.set(0, 0, getWidth(), getHeight());
      applyCloseRegionBounds(this.d, this.i, this.j);
      this.l.set(this.j);
      this.l.inset(this.g, this.g);
      a(this.d, this.l, this.k);
      this.c.setBounds(this.k);
    }
    if (this.c.isVisible())
      this.c.draw(paramCanvas);
  }

  @VisibleForTesting
  Rect getCloseBounds()
  {
    return this.j;
  }

  @VisibleForTesting
  public boolean isCloseVisible()
  {
    return this.c.isVisible();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0)
      return false;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), 0);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.a)) || (!a()))
    {
      setClosePressed(false);
      super.onTouchEvent(paramMotionEvent);
      bool = false;
    }
    do
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      case 2:
      default:
        return bool;
      case 0:
        setClosePressed(bool);
        return bool;
      case 3:
        setClosePressed(false);
        return bool;
      case 1:
      }
    }
    while (!b());
    if (this.n == null)
      this.n = new a(null);
    postDelayed(this.n, ViewConfiguration.getPressedStateDuration());
    c();
    return bool;
  }

  public void setCloseAlwaysInteractable(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  @VisibleForTesting
  void setCloseBoundChanged(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  @VisibleForTesting
  void setCloseBounds(Rect paramRect)
  {
    this.j.set(paramRect);
  }

  public void setClosePosition(ClosePosition paramClosePosition)
  {
    Preconditions.checkNotNull(paramClosePosition);
    this.d = paramClosePosition;
    this.h = true;
    invalidate();
  }

  public void setCloseVisible(boolean paramBoolean)
  {
    if (this.c.setVisible(paramBoolean, false))
      invalidate(this.j);
  }

  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    this.b = paramOnCloseListener;
  }

  public static enum ClosePosition
  {
    private final int a;

    static
    {
      TOP_CENTER = new ClosePosition("TOP_CENTER", 1, 49);
      TOP_RIGHT = new ClosePosition("TOP_RIGHT", 2, 53);
      CENTER = new ClosePosition("CENTER", 3, 17);
      BOTTOM_LEFT = new ClosePosition("BOTTOM_LEFT", 4, 83);
      BOTTOM_CENTER = new ClosePosition("BOTTOM_CENTER", 5, 81);
      BOTTOM_RIGHT = new ClosePosition("BOTTOM_RIGHT", 6, 85);
      ClosePosition[] arrayOfClosePosition = new ClosePosition[7];
      arrayOfClosePosition[0] = TOP_LEFT;
      arrayOfClosePosition[1] = TOP_CENTER;
      arrayOfClosePosition[2] = TOP_RIGHT;
      arrayOfClosePosition[3] = CENTER;
      arrayOfClosePosition[4] = BOTTOM_LEFT;
      arrayOfClosePosition[5] = BOTTOM_CENTER;
      arrayOfClosePosition[6] = BOTTOM_RIGHT;
    }

    private ClosePosition(int paramInt)
    {
      this.a = paramInt;
    }

    int a()
    {
      return this.a;
    }
  }

  public static abstract interface OnCloseListener
  {
    public abstract void onClose();
  }

  private final class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      CloseableLayout.a(CloseableLayout.this, false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.CloseableLayout
 * JD-Core Version:    0.6.2
 */