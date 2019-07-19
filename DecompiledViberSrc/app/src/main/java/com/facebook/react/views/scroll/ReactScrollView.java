package com.facebook.react.views.scroll;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.List;
import javax.annotation.Nullable;

public class ReactScrollView extends ScrollView
  implements View.OnLayoutChangeListener, ViewGroup.OnHierarchyChangeListener, ReactClippingViewGroup
{

  @Nullable
  private static Field sScrollerField;
  private static boolean sTriedToGetScrollerField = false;
  private boolean mActivelyScrolling;

  @Nullable
  private Rect mClippingRect;
  private View mContentView;
  private float mDecelerationRate = 0.985F;
  private boolean mDragging;

  @Nullable
  private Drawable mEndBackground;
  private int mEndFillColor = 0;

  @Nullable
  private FpsListener mFpsListener = null;
  private final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();

  @Nullable
  private String mOverflow = "hidden";
  private boolean mPagingEnabled = false;

  @Nullable
  private Runnable mPostTouchRunnable;
  private ReactViewBackgroundManager mReactBackgroundManager;
  private final Rect mRect = new Rect();
  private boolean mRemoveClippedSubviews;
  private boolean mScrollEnabled = true;

  @Nullable
  private String mScrollPerfTag;

  @Nullable
  private final OverScroller mScroller;
  private boolean mSendMomentumEvents;
  private int mSnapInterval = 0;

  @Nullable
  private List<Integer> mSnapOffsets;
  private boolean mSnapToEnd = true;
  private boolean mSnapToStart = true;
  private final VelocityHelper mVelocityHelper = new VelocityHelper();

  public ReactScrollView(ReactContext paramReactContext)
  {
    this(paramReactContext, null);
  }

  public ReactScrollView(ReactContext paramReactContext, @Nullable FpsListener paramFpsListener)
  {
    super(paramReactContext);
    this.mFpsListener = paramFpsListener;
    this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
    this.mScroller = getOverScrollerFromParent();
    setOnHierarchyChangeListener(this);
    setScrollBarStyle(33554432);
  }

  private void disableFpsListener()
  {
    if (isScrollPerfLoggingEnabled())
    {
      Assertions.assertNotNull(this.mFpsListener);
      Assertions.assertNotNull(this.mScrollPerfTag);
      this.mFpsListener.disable(this.mScrollPerfTag);
    }
  }

  private void enableFpsListener()
  {
    if (isScrollPerfLoggingEnabled())
    {
      Assertions.assertNotNull(this.mFpsListener);
      Assertions.assertNotNull(this.mScrollPerfTag);
      this.mFpsListener.enable(this.mScrollPerfTag);
    }
  }

  private void flingAndSnap(int paramInt)
  {
    if (getChildCount() <= 0)
      return;
    if ((this.mSnapInterval == 0) && (this.mSnapOffsets == null))
    {
      smoothScrollAndSnap(paramInt);
      return;
    }
    int i = getMaxScrollY();
    int j = predictFinalScrollPosition(paramInt);
    int k = getHeight() - getPaddingBottom() - getPaddingTop();
    int n;
    int m;
    int i1;
    int i2;
    int i3;
    label225: label250: int i4;
    OverScroller localOverScroller;
    int i5;
    int i6;
    int i7;
    if (this.mSnapOffsets != null)
    {
      int i9 = ((Integer)this.mSnapOffsets.get(0)).intValue();
      int i10 = ((Integer)this.mSnapOffsets.get(-1 + this.mSnapOffsets.size())).intValue();
      n = i;
      int i11 = 0;
      for (int i12 = 0; i12 < this.mSnapOffsets.size(); i12++)
      {
        int i13 = ((Integer)this.mSnapOffsets.get(i12)).intValue();
        if ((i13 <= j) && (j - i13 < j - i11))
          i11 = i13;
        if ((i13 >= j) && (i13 - j < n - j))
          n = i13;
      }
      m = i11;
      i1 = i10;
      i2 = i9;
      if (j - m >= n - j)
        break label391;
      i3 = m;
      if ((this.mSnapToEnd) || (j < i1))
        break label405;
      if (getScrollY() < i1)
        break label398;
      n = j;
      i4 = Math.min(Math.max(0, n), i);
      if (this.mScroller == null)
        break label509;
      this.mActivelyScrolling = true;
      localOverScroller = this.mScroller;
      i5 = getScrollX();
      i6 = getScrollY();
      if (paramInt == 0)
        break label491;
      i7 = paramInt;
      label299: if ((i4 != 0) && (i4 != i))
        break label503;
    }
    label391: label398: label405: label491: label503: for (int i8 = k / 2; ; i8 = 0)
    {
      localOverScroller.fling(i5, i6, 0, i7, 0, 0, i4, i4, 0, i8);
      postInvalidateOnAnimation();
      return;
      double d1 = getSnapInterval();
      double d2 = j / d1;
      m = (int)(d1 * Math.floor(d2));
      n = Math.min((int)(d1 * Math.ceil(d2)), i);
      i1 = i;
      i2 = 0;
      break;
      i3 = n;
      break label225;
      n = i1;
      break label250;
      if ((!this.mSnapToStart) && (j <= i2))
      {
        if (getScrollY() <= i2)
        {
          n = j;
          break label250;
        }
        n = i2;
        break label250;
      }
      if (paramInt > 0)
      {
        paramInt += (int)(10.0D * (n - j));
        break label250;
      }
      if (paramInt < 0)
      {
        paramInt -= (int)(10.0D * (j - m));
        n = m;
        break label250;
      }
      n = i3;
      break label250;
      i7 = i4 - getScrollY();
      break label299;
    }
    label509: smoothScrollTo(getScrollX(), i4);
  }

  private int getMaxScrollY()
  {
    return Math.max(0, this.mContentView.getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
  }

  // ERROR //
  @Nullable
  private OverScroller getOverScrollerFromParent()
  {
    // Byte code:
    //   0: getstatic 57	com/facebook/react/views/scroll/ReactScrollView:sTriedToGetScrollerField	Z
    //   3: ifne +25 -> 28
    //   6: iconst_1
    //   7: putstatic 57	com/facebook/react/views/scroll/ReactScrollView:sTriedToGetScrollerField	Z
    //   10: ldc 4
    //   12: ldc_w 259
    //   15: invokevirtual 265	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   18: putstatic 267	com/facebook/react/views/scroll/ReactScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   21: getstatic 267	com/facebook/react/views/scroll/ReactScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   24: iconst_1
    //   25: invokevirtual 273	java/lang/reflect/Field:setAccessible	(Z)V
    //   28: getstatic 267	com/facebook/react/views/scroll/ReactScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   31: ifnull +67 -> 98
    //   34: getstatic 267	com/facebook/react/views/scroll/ReactScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   37: aload_0
    //   38: invokevirtual 275	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_2
    //   42: aload_2
    //   43: instanceof 226
    //   46: ifeq +27 -> 73
    //   49: aload_2
    //   50: checkcast 226	android/widget/OverScroller
    //   53: astore 4
    //   55: aload 4
    //   57: areturn
    //   58: astore 5
    //   60: ldc_w 277
    //   63: ldc_w 279
    //   66: invokestatic 285	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   69: pop
    //   70: goto -42 -> 28
    //   73: ldc_w 277
    //   76: ldc_w 287
    //   79: invokestatic 285	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aconst_null
    //   84: areturn
    //   85: astore_1
    //   86: new 289	java/lang/RuntimeException
    //   89: dup
    //   90: ldc_w 291
    //   93: aload_1
    //   94: invokespecial 294	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: aconst_null
    //   99: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	28	58	java/lang/NoSuchFieldException
    //   34	55	85	java/lang/IllegalAccessException
    //   73	83	85	java/lang/IllegalAccessException
  }

  private int getSnapInterval()
  {
    if (this.mSnapInterval != 0)
      return this.mSnapInterval;
    return getHeight();
  }

  private void handlePostTouchScrolling(int paramInt1, int paramInt2)
  {
    if ((!this.mSendMomentumEvents) && (!this.mPagingEnabled) && (!isScrollPerfLoggingEnabled()));
    while (this.mPostTouchRunnable != null)
      return;
    if (this.mSendMomentumEvents)
    {
      enableFpsListener();
      ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, paramInt1, paramInt2);
    }
    this.mActivelyScrolling = false;
    this.mPostTouchRunnable = new Runnable()
    {
      private boolean mSnappingToPage = false;

      public void run()
      {
        if (ReactScrollView.this.mActivelyScrolling)
        {
          ReactScrollView.access$002(ReactScrollView.this, false);
          ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20L);
          return;
        }
        if ((ReactScrollView.this.mPagingEnabled) && (!this.mSnappingToPage))
        {
          this.mSnappingToPage = true;
          ReactScrollView.this.flingAndSnap(0);
          ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20L);
          return;
        }
        if (ReactScrollView.this.mSendMomentumEvents)
          ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
        ReactScrollView.access$402(ReactScrollView.this, null);
        ReactScrollView.this.disableFpsListener();
      }
    };
    ViewCompat.postOnAnimationDelayed(this, this.mPostTouchRunnable, 20L);
  }

  private boolean isScrollPerfLoggingEnabled()
  {
    return (this.mFpsListener != null) && (this.mScrollPerfTag != null) && (!this.mScrollPerfTag.isEmpty());
  }

  private int predictFinalScrollPosition(int paramInt)
  {
    OverScroller localOverScroller = new OverScroller(getContext());
    localOverScroller.setFriction(1.0F - this.mDecelerationRate);
    int i = getMaxScrollY();
    int j = getHeight() - getPaddingBottom() - getPaddingTop();
    localOverScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, 0, i, 0, j / 2);
    return localOverScroller.getFinalY();
  }

  private void smoothScrollAndSnap(int paramInt)
  {
    double d1 = getSnapInterval();
    double d2 = getScrollY();
    double d3 = predictFinalScrollPosition(paramInt);
    int i = (int)Math.floor(d2 / d1);
    int j = (int)Math.ceil(d2 / d1);
    int k = (int)Math.round(d2 / d1);
    int m = (int)Math.round(d3 / d1);
    if ((paramInt > 0) && (j == i))
    {
      j++;
      if ((paramInt <= 0) || (k >= j) || (m <= i))
        break label142;
    }
    while (true)
    {
      double d4 = d1 * j;
      if (d4 != d2)
      {
        this.mActivelyScrolling = true;
        smoothScrollTo(getScrollX(), (int)d4);
      }
      return;
      if ((paramInt >= 0) || (i != j))
        break;
      i--;
      break;
      label142: if ((paramInt < 0) && (k > i) && (m < j))
        j = i;
      else
        j = k;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mEndFillColor != 0)
    {
      View localView = getChildAt(0);
      if ((this.mEndBackground != null) && (localView != null) && (localView.getBottom() < getHeight()))
      {
        this.mEndBackground.setBounds(0, localView.getBottom(), getWidth(), getHeight());
        this.mEndBackground.draw(paramCanvas);
      }
    }
    getDrawingRect(this.mRect);
    String str = this.mOverflow;
    switch (str.hashCode())
    {
    default:
    case 466743410:
    }
    for (int i = -1; ; i = 0)
    {
      switch (i)
      {
      default:
        paramCanvas.clipRect(this.mRect);
      case 0:
      }
      super.draw(paramCanvas);
      return;
      if (!str.equals("visible"))
        break;
    }
  }

  public void flashScrollIndicators()
  {
    awakenScrollBars();
  }

  public void fling(int paramInt)
  {
    int i = (int)(Math.abs(paramInt) * Math.signum(this.mOnScrollDispatchHelper.getYFlingVelocity()));
    if (this.mPagingEnabled)
      flingAndSnap(i);
    while (true)
    {
      handlePostTouchScrolling(0, i);
      return;
      if (this.mScroller != null)
      {
        int j = getHeight() - getPaddingBottom() - getPaddingTop();
        this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, 2147483647, 0, j / 2);
        ViewCompat.postInvalidateOnAnimation(this);
      }
      else
      {
        super.fling(i);
      }
    }
  }

  public void getClippingRect(Rect paramRect)
  {
    paramRect.set((Rect)Assertions.assertNotNull(this.mClippingRect));
  }

  public boolean getRemoveClippedSubviews()
  {
    return this.mRemoveClippedSubviews;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public void onChildViewAdded(View paramView1, View paramView2)
  {
    this.mContentView = paramView2;
    this.mContentView.addOnLayoutChangeListener(this);
  }

  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.mContentView.removeOnLayoutChangeListener(this);
    this.mContentView = null;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled);
    while (true)
    {
      return false;
      try
      {
        if (super.onInterceptTouchEvent(paramMotionEvent))
        {
          NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
          ReactScrollViewHelper.emitScrollBeginDragEvent(this);
          this.mDragging = true;
          enableFpsListener();
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.w("ReactNative", "Error intercepting touch event.", localIllegalArgumentException);
      }
    }
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    scrollTo(getScrollX(), getScrollY());
  }

  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mContentView == null);
    int i;
    int j;
    do
    {
      return;
      i = getScrollY();
      j = getMaxScrollY();
    }
    while (i <= j);
    scrollTo(getScrollX(), j);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mScroller != null) && (!this.mScroller.isFinished()) && (this.mScroller.getCurrY() != this.mScroller.getFinalY()))
    {
      int i = getMaxScrollY();
      if (paramInt2 >= i)
      {
        this.mScroller.abortAnimation();
        paramInt2 = i;
      }
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mActivelyScrolling = true;
    if (this.mOnScrollDispatchHelper.onScrollChanged(paramInt1, paramInt2))
    {
      if (this.mRemoveClippedSubviews)
        updateClippingRect();
      ReactScrollViewHelper.emitScrollEvent(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled)
      return false;
    this.mVelocityHelper.calculateVelocity(paramMotionEvent);
    if (((0xFF & paramMotionEvent.getAction()) == 1) && (this.mDragging))
    {
      float f1 = this.mVelocityHelper.getXVelocity();
      float f2 = this.mVelocityHelper.getYVelocity();
      ReactScrollViewHelper.emitScrollEndDragEvent(this, f1, f2);
      this.mDragging = false;
      handlePostTouchScrolling(Math.round(f1), Math.round(f2));
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mReactBackgroundManager.setBackgroundColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mReactBackgroundManager.setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    this.mReactBackgroundManager.setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    this.mReactBackgroundManager.setBorderWidth(paramInt, paramFloat);
  }

  public void setDecelerationRate(float paramFloat)
  {
    this.mDecelerationRate = paramFloat;
    if (this.mScroller != null)
      this.mScroller.setFriction(1.0F - this.mDecelerationRate);
  }

  public void setEndFillColor(int paramInt)
  {
    if (paramInt != this.mEndFillColor)
    {
      this.mEndFillColor = paramInt;
      this.mEndBackground = new ColorDrawable(this.mEndFillColor);
    }
  }

  public void setOverflow(String paramString)
  {
    this.mOverflow = paramString;
    invalidate();
  }

  public void setPagingEnabled(boolean paramBoolean)
  {
    this.mPagingEnabled = paramBoolean;
  }

  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mClippingRect == null))
      this.mClippingRect = new Rect();
    this.mRemoveClippedSubviews = paramBoolean;
    updateClippingRect();
  }

  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }

  public void setScrollPerfTag(@Nullable String paramString)
  {
    this.mScrollPerfTag = paramString;
  }

  public void setSendMomentumEvents(boolean paramBoolean)
  {
    this.mSendMomentumEvents = paramBoolean;
  }

  public void setSnapInterval(int paramInt)
  {
    this.mSnapInterval = paramInt;
  }

  public void setSnapOffsets(List<Integer> paramList)
  {
    this.mSnapOffsets = paramList;
  }

  public void setSnapToEnd(boolean paramBoolean)
  {
    this.mSnapToEnd = paramBoolean;
  }

  public void setSnapToStart(boolean paramBoolean)
  {
    this.mSnapToStart = paramBoolean;
  }

  public void updateClippingRect()
  {
    if (!this.mRemoveClippedSubviews);
    View localView;
    do
    {
      return;
      Assertions.assertNotNull(this.mClippingRect);
      ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
      localView = getChildAt(0);
    }
    while (!(localView instanceof ReactClippingViewGroup));
    ((ReactClippingViewGroup)localView).updateClippingRect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollView
 * JD-Core Version:    0.6.2
 */