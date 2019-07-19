package com.facebook.react.views.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

public class ReactHorizontalScrollView extends HorizontalScrollView
  implements ReactClippingViewGroup
{

  @Nullable
  private static Field sScrollerField;
  private static boolean sTriedToGetScrollerField = false;
  private boolean mActivelyScrolling;

  @Nullable
  private Rect mClippingRect;
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
  private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
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

  public ReactHorizontalScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ReactHorizontalScrollView(Context paramContext, @Nullable FpsListener paramFpsListener)
  {
    super(paramContext);
    this.mFpsListener = paramFpsListener;
    this.mScroller = getOverScrollerFromParent();
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
    int i = Math.max(0, computeHorizontalScrollRange() - getWidth());
    int j = predictFinalScrollPosition(paramInt);
    int k = getWidth() - ViewCompat.getPaddingStart(this) - ViewCompat.getPaddingEnd(this);
    int m;
    int i15;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)
    {
      m = 1;
      if (m == 0)
        break label592;
      i15 = i - j;
      paramInt = -paramInt;
    }
    label270: label308: label575: label581: label592: for (int n = i15; ; n = j)
    {
      int i4;
      int i3;
      int i2;
      int i1;
      int i5;
      int i6;
      int i7;
      OverScroller localOverScroller;
      int i8;
      int i9;
      int i10;
      if (this.mSnapOffsets != null)
      {
        i4 = ((Integer)this.mSnapOffsets.get(0)).intValue();
        i3 = ((Integer)this.mSnapOffsets.get(-1 + this.mSnapOffsets.size())).intValue();
        i2 = i;
        int i12 = 0;
        int i13 = 0;
        while (true)
          if (i13 < this.mSnapOffsets.size())
          {
            int i14 = ((Integer)this.mSnapOffsets.get(i13)).intValue();
            if ((i14 <= n) && (n - i14 < n - i12))
              i12 = i14;
            if ((i14 >= n) && (i14 - n < i2 - n))
              i2 = i14;
            i13++;
            continue;
            m = 0;
            break;
          }
        i1 = i12;
        if (n - i1 >= i2 - n)
          break label464;
        i5 = i1;
        i6 = getScrollX();
        if (m != 0)
          i6 = i - i6;
        if ((this.mSnapToEnd) || (n < i3))
          break label478;
        if (i6 < i3)
          break label471;
        i7 = Math.min(Math.max(0, n), i);
        if (m != 0)
        {
          i7 = i - i7;
          paramInt = -paramInt;
        }
        if (this.mScroller == null)
          break label581;
        this.mActivelyScrolling = true;
        localOverScroller = this.mScroller;
        i8 = getScrollX();
        i9 = getScrollY();
        if (paramInt == 0)
          break label563;
        i10 = paramInt;
        label371: if ((i7 != 0) && (i7 != i))
          break label575;
      }
      for (int i11 = k / 2; ; i11 = 0)
      {
        localOverScroller.fling(i8, i9, i10, 0, i7, i7, 0, 0, i11, 0);
        postInvalidateOnAnimation();
        return;
        double d1 = getSnapInterval();
        double d2 = n / d1;
        i1 = (int)(d1 * Math.floor(d2));
        i2 = Math.min((int)(d1 * Math.ceil(d2)), i);
        i3 = i;
        i4 = 0;
        break;
        label464: i5 = i2;
        break label270;
        label471: n = i3;
        break label308;
        label478: if ((!this.mSnapToStart) && (n <= i4))
        {
          if (i6 <= i4)
            break label308;
          n = i4;
          break label308;
        }
        if (paramInt > 0)
        {
          paramInt += (int)(10.0D * (i2 - n));
          n = i2;
          break label308;
        }
        if (paramInt < 0)
        {
          paramInt -= (int)(10.0D * (n - i1));
          n = i1;
          break label308;
        }
        n = i5;
        break label308;
        i10 = i7 - getScrollX();
        break label371;
      }
      smoothScrollTo(i7, getScrollY());
      return;
    }
  }

  // ERROR //
  @Nullable
  private OverScroller getOverScrollerFromParent()
  {
    // Byte code:
    //   0: getstatic 51	com/facebook/react/views/scroll/ReactHorizontalScrollView:sTriedToGetScrollerField	Z
    //   3: ifne +24 -> 27
    //   6: iconst_1
    //   7: putstatic 51	com/facebook/react/views/scroll/ReactHorizontalScrollView:sTriedToGetScrollerField	Z
    //   10: ldc 4
    //   12: ldc 254
    //   14: invokevirtual 260	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   17: putstatic 262	com/facebook/react/views/scroll/ReactHorizontalScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   20: getstatic 262	com/facebook/react/views/scroll/ReactHorizontalScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   23: iconst_1
    //   24: invokevirtual 268	java/lang/reflect/Field:setAccessible	(Z)V
    //   27: getstatic 262	com/facebook/react/views/scroll/ReactHorizontalScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   30: ifnull +67 -> 97
    //   33: getstatic 262	com/facebook/react/views/scroll/ReactHorizontalScrollView:sScrollerField	Ljava/lang/reflect/Field;
    //   36: aload_0
    //   37: invokevirtual 270	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_2
    //   41: aload_2
    //   42: instanceof 226
    //   45: ifeq +27 -> 72
    //   48: aload_2
    //   49: checkcast 226	android/widget/OverScroller
    //   52: astore 4
    //   54: aload 4
    //   56: areturn
    //   57: astore 5
    //   59: ldc_w 272
    //   62: ldc_w 274
    //   65: invokestatic 280	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: goto -42 -> 27
    //   72: ldc_w 272
    //   75: ldc_w 282
    //   78: invokestatic 280	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aconst_null
    //   83: areturn
    //   84: astore_1
    //   85: new 284	java/lang/RuntimeException
    //   88: dup
    //   89: ldc_w 286
    //   92: aload_1
    //   93: invokespecial 289	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: aconst_null
    //   98: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	27	57	java/lang/NoSuchFieldException
    //   33	54	84	java/lang/IllegalAccessException
    //   72	82	84	java/lang/IllegalAccessException
  }

  private int getSnapInterval()
  {
    if (this.mSnapInterval != 0)
      return this.mSnapInterval;
    return getWidth();
  }

  private void handlePostTouchScrolling(int paramInt1, int paramInt2)
  {
    if ((!this.mSendMomentumEvents) && (!this.mPagingEnabled) && (!isScrollPerfLoggingEnabled()));
    while (this.mPostTouchRunnable != null)
      return;
    if (this.mSendMomentumEvents)
      ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, paramInt1, paramInt2);
    this.mActivelyScrolling = false;
    this.mPostTouchRunnable = new Runnable()
    {
      private boolean mSnappingToPage = false;

      public void run()
      {
        if (ReactHorizontalScrollView.this.mActivelyScrolling)
        {
          ReactHorizontalScrollView.access$002(ReactHorizontalScrollView.this, false);
          ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20L);
          return;
        }
        if ((ReactHorizontalScrollView.this.mPagingEnabled) && (!this.mSnappingToPage))
        {
          this.mSnappingToPage = true;
          ReactHorizontalScrollView.this.flingAndSnap(0);
          ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20L);
          return;
        }
        if (ReactHorizontalScrollView.this.mSendMomentumEvents)
          ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
        ReactHorizontalScrollView.access$402(ReactHorizontalScrollView.this, null);
        ReactHorizontalScrollView.this.disableFpsListener();
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
    int i = Math.max(0, computeHorizontalScrollRange() - getWidth());
    int j = getWidth() - ViewCompat.getPaddingStart(this) - ViewCompat.getPaddingEnd(this);
    localOverScroller.fling(getScrollX(), getScrollY(), paramInt, 0, 0, i, 0, 0, j / 2, 0);
    return localOverScroller.getFinalX();
  }

  private void smoothScrollAndSnap(int paramInt)
  {
    double d1 = getSnapInterval();
    double d2 = getScrollX();
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
        smoothScrollTo((int)d4, getScrollY());
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
      if ((this.mEndBackground != null) && (localView != null) && (localView.getRight() < getWidth()))
      {
        this.mEndBackground.setBounds(localView.getRight(), 0, getWidth(), getHeight());
        this.mEndBackground.draw(paramCanvas);
      }
    }
    super.draw(paramCanvas);
  }

  public void flashScrollIndicators()
  {
    awakenScrollBars();
  }

  public void fling(int paramInt)
  {
    int i = (int)(Math.abs(paramInt) * Math.signum(this.mOnScrollDispatchHelper.getXFlingVelocity()));
    if (this.mPagingEnabled)
      flingAndSnap(i);
    while (true)
    {
      handlePostTouchScrolling(i, 0);
      return;
      if (this.mScroller != null)
      {
        int j = getWidth() - ViewCompat.getPaddingStart(this) - ViewCompat.getPaddingEnd(this);
        this.mScroller.fling(getScrollX(), getScrollY(), i, 0, 0, 2147483647, 0, 0, j / 2, 0);
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

  protected void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.mRect);
    String str = this.mOverflow;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 466743410:
    }
    while (true)
    {
      switch (i)
      {
      default:
        paramCanvas.clipRect(this.mRect);
      case 0:
      }
      super.onDraw(paramCanvas);
      return;
      if (str.equals("visible"))
        i = 0;
    }
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

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mScroller != null) && (!this.mScroller.isFinished()) && (this.mScroller.getCurrX() != this.mScroller.getFinalX()))
    {
      int i = computeHorizontalScrollRange() - getWidth();
      if (paramInt1 >= i)
      {
        this.mScroller.abortAnimation();
        paramInt1 = i;
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
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollView
 * JD-Core Version:    0.6.2
 */