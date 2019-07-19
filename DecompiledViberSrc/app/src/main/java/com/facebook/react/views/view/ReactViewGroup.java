package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.animation.Animation;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.yoga.YogaConstants;
import javax.annotation.Nullable;

public class ReactViewGroup extends ViewGroup
  implements ReactHitSlopView, ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactZIndexedViewGroup
{
  private static final int ARRAY_CAPACITY_INCREMENT = 12;
  private static final int DEFAULT_BACKGROUND_COLOR;
  private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
  private static final Rect sHelperRect = new Rect();

  @Nullable
  private View[] mAllChildren = null;
  private int mAllChildrenCount;
  private float mBackfaceOpacity = 1.0F;
  private String mBackfaceVisibility = "visible";

  @Nullable
  private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;

  @Nullable
  private Rect mClippingRect;
  private final ViewGroupDrawingOrderHelper mDrawingOrderHelper;

  @Nullable
  private Rect mHitSlopRect;
  private int mLayoutDirection;
  private boolean mNeedsOffscreenAlphaCompositing = false;

  @Nullable
  private OnInterceptTouchEventListener mOnInterceptTouchEventListener;

  @Nullable
  private String mOverflow;

  @Nullable
  private Path mPath;
  private PointerEvents mPointerEvents = PointerEvents.AUTO;

  @Nullable
  private ReactViewBackgroundDrawable mReactBackgroundDrawable;
  private boolean mRemoveClippedSubviews = false;

  public ReactViewGroup(Context paramContext)
  {
    super(paramContext);
    setClipChildren(false);
    this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
  }

  private void addInArray(View paramView, int paramInt)
  {
    View[] arrayOfView = (View[])Assertions.assertNotNull(this.mAllChildren);
    int i = this.mAllChildrenCount;
    int j = arrayOfView.length;
    if (paramInt == i)
    {
      if (j == i)
      {
        this.mAllChildren = new View[j + 12];
        System.arraycopy(arrayOfView, 0, this.mAllChildren, 0, j);
        arrayOfView = this.mAllChildren;
      }
      int k = this.mAllChildrenCount;
      this.mAllChildrenCount = (k + 1);
      arrayOfView[k] = paramView;
      return;
    }
    if (paramInt < i)
    {
      if (j == i)
      {
        this.mAllChildren = new View[j + 12];
        System.arraycopy(arrayOfView, 0, this.mAllChildren, 0, paramInt);
        System.arraycopy(arrayOfView, paramInt, this.mAllChildren, paramInt + 1, i - paramInt);
        arrayOfView = this.mAllChildren;
      }
      while (true)
      {
        arrayOfView[paramInt] = paramView;
        this.mAllChildrenCount = (1 + this.mAllChildrenCount);
        return;
        System.arraycopy(arrayOfView, paramInt, arrayOfView, paramInt + 1, i - paramInt);
      }
    }
    throw new IndexOutOfBoundsException("index=" + paramInt + " count=" + i);
  }

  private void dispatchOverflowDraw(Canvas paramCanvas)
  {
    String str;
    int i;
    if (this.mOverflow != null)
    {
      str = this.mOverflow;
      i = -1;
      switch (str.hashCode())
      {
      default:
        switch (i)
        {
        default:
        case 0:
        case 1:
        }
        break;
      case 466743410:
      case -1217487446:
      }
    }
    do
    {
      return;
      if (!str.equals("visible"))
        break;
      i = 0;
      break;
      if (!str.equals("hidden"))
        break;
      i = 1;
      break;
    }
    while (this.mPath == null);
    this.mPath.rewind();
    return;
    float f1 = getWidth();
    float f2 = getHeight();
    ReactViewBackgroundDrawable localReactViewBackgroundDrawable = this.mReactBackgroundDrawable;
    float f3 = 0.0F;
    float f4 = 0.0F;
    RectF localRectF1;
    float f10;
    float f11;
    float f12;
    float f13;
    int k;
    float f16;
    float f17;
    float f18;
    float f19;
    if (localReactViewBackgroundDrawable != null)
    {
      localRectF1 = this.mReactBackgroundDrawable.getDirectionAwareBorderInsets();
      if ((localRectF1.top <= 0.0F) && (localRectF1.left <= 0.0F) && (localRectF1.bottom <= 0.0F))
      {
        boolean bool = localRectF1.right < 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        if (!bool);
      }
      else
      {
        f4 = 0.0F + localRectF1.left;
        f3 = 0.0F + localRectF1.top;
        f1 -= localRectF1.right;
        f2 -= localRectF1.bottom;
      }
      float f9 = this.mReactBackgroundDrawable.getFullBorderRadius();
      f10 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f9, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT);
      f11 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f9, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT);
      f12 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f9, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT);
      f13 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f9, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT);
      if (Build.VERSION.SDK_INT < 17)
        break label910;
      if (this.mLayoutDirection == 1)
      {
        k = 1;
        f16 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START);
        f17 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END);
        f18 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START);
        f19 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END);
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext()))
          break label777;
        if (!YogaConstants.isUndefined(f16))
          break label942;
      }
    }
    while (true)
    {
      if (YogaConstants.isUndefined(f17));
      for (float f22 = f11; ; f22 = f17)
      {
        if (YogaConstants.isUndefined(f18));
        for (float f15 = f12; ; f15 = f18)
        {
          if (YogaConstants.isUndefined(f19));
          for (float f23 = f13; ; f23 = f19)
          {
            float f24;
            label438: label443: label452: label457: float f14;
            if (k != 0)
            {
              f24 = f22;
              if (k == 0)
                break label756;
              if (k == 0)
                break label763;
              f12 = f23;
              if (k == 0)
                break label770;
              f14 = f10;
              f10 = f24;
            }
            while (true)
            {
              float f5;
              float f6;
              float f7;
              float f8;
              if ((f10 > 0.0F) || (f14 > 0.0F) || (f15 > 0.0F) || (f12 > 0.0F))
              {
                if (this.mPath == null)
                  this.mPath = new Path();
                this.mPath.rewind();
                Path localPath = this.mPath;
                RectF localRectF2 = new RectF(f4, f3, f1, f2);
                float[] arrayOfFloat = new float[8];
                arrayOfFloat[0] = Math.max(f10 - localRectF1.left, 0.0F);
                arrayOfFloat[1] = Math.max(f10 - localRectF1.top, 0.0F);
                arrayOfFloat[2] = Math.max(f14 - localRectF1.right, 0.0F);
                arrayOfFloat[3] = Math.max(f14 - localRectF1.top, 0.0F);
                arrayOfFloat[4] = Math.max(f15 - localRectF1.right, 0.0F);
                arrayOfFloat[5] = Math.max(f15 - localRectF1.bottom, 0.0F);
                arrayOfFloat[6] = Math.max(f12 - localRectF1.left, 0.0F);
                arrayOfFloat[7] = Math.max(f12 - localRectF1.bottom, 0.0F);
                localPath.addRoundRect(localRectF2, arrayOfFloat, Path.Direction.CW);
                paramCanvas.clipPath(this.mPath);
                f5 = f4;
                f6 = f3;
                f7 = f1;
                f8 = f2;
              }
              for (int j = 1; ; j = 0)
              {
                if (j != 0)
                  break label908;
                paramCanvas.clipRect(new RectF(f5, f6, f7, f8));
                return;
                k = 0;
                break;
                f24 = f10;
                break label438;
                label756: f10 = f22;
                break label443;
                label763: f12 = f15;
                break label452;
                label770: f15 = f23;
                break label457;
                label777: float f20;
                label786: label791: float f21;
                if (k != 0)
                {
                  f20 = f17;
                  if (k == 0)
                    break label867;
                  if (k == 0)
                    break label874;
                  f21 = f19;
                  label800: if (k == 0)
                    break label881;
                }
                while (true)
                {
                  if (!YogaConstants.isUndefined(f20))
                    f10 = f20;
                  if (!YogaConstants.isUndefined(f16))
                    f11 = f16;
                  if (!YogaConstants.isUndefined(f21))
                    f12 = f21;
                  if (YogaConstants.isUndefined(f18))
                    break label910;
                  f14 = f11;
                  f15 = f18;
                  break;
                  f20 = f16;
                  break label786;
                  label867: f16 = f17;
                  break label791;
                  label874: f21 = f18;
                  break label800;
                  label881: f18 = f19;
                }
                f5 = f4;
                f6 = f3;
                f7 = f1;
                f8 = f2;
              }
              label908: break;
              label910: f14 = f11;
              f15 = f13;
            }
          }
        }
      }
      label942: f10 = f16;
    }
  }

  private ReactViewBackgroundDrawable getOrCreateReactViewBackground()
  {
    int i = 1;
    Drawable localDrawable;
    if (this.mReactBackgroundDrawable == null)
    {
      this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
      localDrawable = getBackground();
      updateBackgroundDrawable(null);
      if (localDrawable != null)
        break label89;
      updateBackgroundDrawable(this.mReactBackgroundDrawable);
      if (Build.VERSION.SDK_INT >= 17)
        if (!I18nUtil.getInstance().isRTL(getContext()))
          break label120;
    }
    while (true)
    {
      this.mLayoutDirection = i;
      this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
      return this.mReactBackgroundDrawable;
      label89: Drawable[] arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = this.mReactBackgroundDrawable;
      arrayOfDrawable[i] = localDrawable;
      updateBackgroundDrawable(new LayerDrawable(arrayOfDrawable));
      break;
      label120: i = 0;
    }
  }

  private int indexOfChildInAllChildren(View paramView)
  {
    int i = this.mAllChildrenCount;
    View[] arrayOfView = (View[])Assertions.assertNotNull(this.mAllChildren);
    for (int j = 0; j < i; j++)
      if (arrayOfView[j] == paramView)
        return j;
    return -1;
  }

  private void removeFromArray(int paramInt)
  {
    View[] arrayOfView = (View[])Assertions.assertNotNull(this.mAllChildren);
    int i = this.mAllChildrenCount;
    if (paramInt == i - 1)
    {
      int k = -1 + this.mAllChildrenCount;
      this.mAllChildrenCount = k;
      arrayOfView[k] = null;
      return;
    }
    if ((paramInt >= 0) && (paramInt < i))
    {
      System.arraycopy(arrayOfView, paramInt + 1, arrayOfView, paramInt, -1 + (i - paramInt));
      int j = -1 + this.mAllChildrenCount;
      this.mAllChildrenCount = j;
      arrayOfView[j] = null;
      return;
    }
    throw new IndexOutOfBoundsException();
  }

  private void updateBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackground(paramDrawable);
  }

  private void updateClippingToRect(Rect paramRect)
  {
    int i = 0;
    Assertions.assertNotNull(this.mAllChildren);
    int j = 0;
    while (i < this.mAllChildrenCount)
    {
      updateSubviewClipStatus(paramRect, i, j);
      if (this.mAllChildren[i].getParent() == null)
        j++;
      i++;
    }
  }

  private void updateSubviewClipStatus(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = 1;
    View localView = ((View[])Assertions.assertNotNull(this.mAllChildren))[paramInt1];
    sHelperRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
    boolean bool = paramRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
    Animation localAnimation = localView.getAnimation();
    if ((localAnimation != null) && (!localAnimation.hasEnded()))
    {
      int k = i;
      if ((bool) || (localView.getParent() == null) || (k != 0))
        break label168;
      super.removeViewsInLayout(paramInt1 - paramInt2, i);
    }
    while (true)
    {
      if ((i != 0) && ((localView instanceof ReactClippingViewGroup)))
      {
        ReactClippingViewGroup localReactClippingViewGroup = (ReactClippingViewGroup)localView;
        if (localReactClippingViewGroup.getRemoveClippedSubviews())
          localReactClippingViewGroup.updateClippingRect();
      }
      return;
      int m = 0;
      break;
      label168: if ((bool) && (localView.getParent() == null))
      {
        super.addViewInLayout(localView, paramInt1 - paramInt2, sDefaultLayoutParam, i);
        invalidate();
      }
      else if (!bool)
      {
        int j = 0;
      }
    }
  }

  private void updateSubviewClipStatus(View paramView)
  {
    int i = 0;
    if ((!this.mRemoveClippedSubviews) || (getParent() == null));
    label142: label163: 
    while (true)
    {
      return;
      Assertions.assertNotNull(this.mClippingRect);
      Assertions.assertNotNull(this.mAllChildren);
      sHelperRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      boolean bool1 = this.mClippingRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
      boolean bool2;
      label98: int j;
      if (paramView.getParent() != null)
      {
        bool2 = true;
        if (bool1 == bool2)
          break label142;
        j = 0;
      }
      while (true)
      {
        if (i >= this.mAllChildrenCount)
          break label163;
        if (this.mAllChildren[i] == paramView)
        {
          updateSubviewClipStatus(this.mClippingRect, i, j);
          return;
          bool2 = false;
          break label98;
          break;
        }
        if (this.mAllChildren[i].getParent() == null)
          j++;
        i++;
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mDrawingOrderHelper.handleAddView(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  void addViewWithSubviewClippingEnabled(View paramView, int paramInt)
  {
    addViewWithSubviewClippingEnabled(paramView, paramInt, sDefaultLayoutParam);
  }

  void addViewWithSubviewClippingEnabled(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    int i = 0;
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    addInArray(paramView, paramInt);
    for (int j = 0; j < paramInt; j++)
      if (this.mAllChildren[j].getParent() == null)
        i++;
    updateSubviewClipStatus(this.mClippingRect, paramInt, i);
    paramView.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      dispatchOverflowDraw(paramCanvas);
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      FLog.e("ReactNative", "NullPointerException when executing ViewGroup.dispatchDraw method", localNullPointerException);
      return;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      RootView localRootView = RootViewUtil.getRootView(this);
      if (localRootView != null)
      {
        localRootView.handleException(localStackOverflowError);
        return;
      }
      if ((getContext() instanceof ReactContext))
      {
        ((ReactContext)getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, localStackOverflowError));
        return;
      }
      throw localStackOverflowError;
    }
  }

  @TargetApi(23)
  public void dispatchProvideStructure(ViewStructure paramViewStructure)
  {
    try
    {
      super.dispatchProvideStructure(paramViewStructure);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      FLog.e("ReactNative", "NullPointerException when executing dispatchProvideStructure", localNullPointerException);
    }
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
  }

  int getAllChildrenCount()
  {
    return this.mAllChildrenCount;
  }

  @VisibleForTesting
  public int getBackgroundColor()
  {
    if (getBackground() != null)
      return ((ReactViewBackgroundDrawable)getBackground()).getColor();
    return 0;
  }

  View getChildAtWithSubviewClippingEnabled(int paramInt)
  {
    return ((View[])Assertions.assertNotNull(this.mAllChildren))[paramInt];
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.mDrawingOrderHelper.getChildDrawingOrder(paramInt1, paramInt2);
  }

  public void getClippingRect(Rect paramRect)
  {
    paramRect.set(this.mClippingRect);
  }

  @Nullable
  public Rect getHitSlopRect()
  {
    return this.mHitSlopRect;
  }

  @Nullable
  public String getOverflow()
  {
    return this.mOverflow;
  }

  public PointerEvents getPointerEvents()
  {
    return this.mPointerEvents;
  }

  public boolean getRemoveClippedSubviews()
  {
    return this.mRemoveClippedSubviews;
  }

  public int getZIndexMappedChildIndex(int paramInt)
  {
    if (this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder())
      paramInt = this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), paramInt);
    return paramInt;
  }

  public boolean hasOverlappingRendering()
  {
    return this.mNeedsOffscreenAlphaCompositing;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mOnInterceptTouchEventListener != null) && (this.mOnInterceptTouchEventListener.onInterceptTouchEvent(this, paramMotionEvent)));
    while ((this.mPointerEvents == PointerEvents.NONE) || (this.mPointerEvents == PointerEvents.BOX_ONLY))
      return true;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  public void onRtlPropertiesChanged(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (this.mReactBackgroundDrawable != null))
      this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mPointerEvents != PointerEvents.NONE) && (this.mPointerEvents != PointerEvents.BOX_NONE);
  }

  void removeAllViewsWithSubviewClippingEnabled()
  {
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mAllChildren);
    for (int i = 0; i < this.mAllChildrenCount; i++)
      this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    removeAllViewsInLayout();
    this.mAllChildrenCount = 0;
  }

  public void removeView(View paramView)
  {
    this.mDrawingOrderHelper.handleRemoveView(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.removeView(paramView);
  }

  public void removeViewAt(int paramInt)
  {
    this.mDrawingOrderHelper.handleRemoveView(getChildAt(paramInt));
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.removeViewAt(paramInt);
  }

  void removeViewWithSubviewClippingEnabled(View paramView)
  {
    int i = 0;
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    paramView.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    int j = indexOfChildInAllChildren(paramView);
    if (this.mAllChildren[j].getParent() != null)
    {
      for (int k = 0; k < j; k++)
        if (this.mAllChildren[k].getParent() == null)
          i++;
      super.removeViewsInLayout(j - i, 1);
    }
    removeFromArray(j);
  }

  @SuppressLint({"MissingSuperCall"})
  public void requestLayout()
  {
  }

  public void setBackfaceVisibility(String paramString)
  {
    this.mBackfaceVisibility = paramString;
    setBackfaceVisibilityDependantOpacity();
  }

  public void setBackfaceVisibilityDependantOpacity()
  {
    if (this.mBackfaceVisibility.equals("visible"))
    {
      setAlpha(this.mBackfaceOpacity);
      return;
    }
    float f1 = getRotationX();
    float f2 = getRotationY();
    if ((f1 >= -90.0F) && (f1 < 90.0F) && (f2 >= -90.0F) && (f2 < 90.0F));
    for (int i = 1; i != 0; i = 0)
    {
      setAlpha(this.mBackfaceOpacity);
      return;
    }
    setAlpha(0.0F);
  }

  public void setBackground(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((paramInt == 0) && (this.mReactBackgroundDrawable == null))
      return;
    getOrCreateReactViewBackground().setColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    getOrCreateReactViewBackground().setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    ReactViewBackgroundDrawable localReactViewBackgroundDrawable = getOrCreateReactViewBackground();
    localReactViewBackgroundDrawable.setRadius(paramFloat);
    if (Build.VERSION.SDK_INT < 18)
      if (!localReactViewBackgroundDrawable.hasRoundedBorders())
        break label42;
    label42: for (int i = 1; ; i = 2)
    {
      if (i != getLayerType())
        setLayerType(i, null);
      return;
    }
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    ReactViewBackgroundDrawable localReactViewBackgroundDrawable = getOrCreateReactViewBackground();
    localReactViewBackgroundDrawable.setRadius(paramFloat, paramInt);
    if (Build.VERSION.SDK_INT < 18)
      if (!localReactViewBackgroundDrawable.hasRoundedBorders())
        break label46;
    label46: for (int i = 1; ; i = 2)
    {
      if (i != getLayerType())
        setLayerType(i, null);
      return;
    }
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    getOrCreateReactViewBackground().setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    getOrCreateReactViewBackground().setBorderWidth(paramInt, paramFloat);
  }

  public void setHitSlopRect(@Nullable Rect paramRect)
  {
    this.mHitSlopRect = paramRect;
  }

  public void setNeedsOffscreenAlphaCompositing(boolean paramBoolean)
  {
    this.mNeedsOffscreenAlphaCompositing = paramBoolean;
  }

  public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.mOnInterceptTouchEventListener = paramOnInterceptTouchEventListener;
  }

  public void setOpacityIfPossible(float paramFloat)
  {
    this.mBackfaceOpacity = paramFloat;
    setBackfaceVisibilityDependantOpacity();
  }

  public void setOverflow(String paramString)
  {
    this.mOverflow = paramString;
    invalidate();
  }

  void setPointerEvents(PointerEvents paramPointerEvents)
  {
    this.mPointerEvents = paramPointerEvents;
  }

  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean == this.mRemoveClippedSubviews)
      return;
    this.mRemoveClippedSubviews = paramBoolean;
    if (paramBoolean)
    {
      this.mClippingRect = new Rect();
      ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
      this.mAllChildrenCount = getChildCount();
      this.mAllChildren = new View[Math.max(12, this.mAllChildrenCount)];
      this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener(this, null);
      while (i < this.mAllChildrenCount)
      {
        View localView = getChildAt(i);
        this.mAllChildren[i] = localView;
        localView.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        i++;
      }
      updateClippingRect();
      return;
    }
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
    for (int j = 0; j < this.mAllChildrenCount; j++)
      this.mAllChildren[j].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    getDrawingRect(this.mClippingRect);
    updateClippingToRect(this.mClippingRect);
    this.mAllChildren = null;
    this.mClippingRect = null;
    this.mAllChildrenCount = 0;
    this.mChildrenLayoutChangeListener = null;
  }

  public void setTranslucentBackgroundDrawable(@Nullable Drawable paramDrawable)
  {
    updateBackgroundDrawable(null);
    if ((this.mReactBackgroundDrawable != null) && (paramDrawable != null))
    {
      arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = this.mReactBackgroundDrawable;
      arrayOfDrawable[1] = paramDrawable;
      updateBackgroundDrawable(new LayerDrawable(arrayOfDrawable));
    }
    while (paramDrawable == null)
    {
      Drawable[] arrayOfDrawable;
      return;
    }
    updateBackgroundDrawable(paramDrawable);
  }

  public void updateClippingRect()
  {
    if (!this.mRemoveClippedSubviews)
      return;
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
    updateClippingToRect(this.mClippingRect);
  }

  public void updateDrawingOrder()
  {
    this.mDrawingOrderHelper.update();
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    invalidate();
  }

  private static final class ChildrenLayoutChangeListener
    implements View.OnLayoutChangeListener
  {
    private final ReactViewGroup mParent;

    private ChildrenLayoutChangeListener(ReactViewGroup paramReactViewGroup)
    {
      this.mParent = paramReactViewGroup;
    }

    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (this.mParent.getRemoveClippedSubviews())
        this.mParent.updateSubviewClipStatus(paramView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewGroup
 * JD-Core Version:    0.6.2
 */