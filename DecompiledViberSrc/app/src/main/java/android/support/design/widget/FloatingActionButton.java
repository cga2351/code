package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.a.h;
import android.support.design.d.c;
import android.support.design.internal.j;
import android.support.design.internal.k;
import android.support.design.stateful.ExtendableSavedState;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/FloatingActionButton$Behavior;")
public class FloatingActionButton extends VisibilityAwareImageButton
  implements android.support.design.d.a, TintableBackgroundView, TintableImageSourceView
{
  private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
  private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
  private static final String LOG_TAG = "FloatingActionButton";
  public static final int NO_CUSTOM_SIZE = 0;
  public static final int SIZE_AUTO = -1;
  public static final int SIZE_MINI = 1;
  public static final int SIZE_NORMAL;
  private ColorStateList backgroundTint;
  private PorterDuff.Mode backgroundTintMode;
  private int borderWidth;
  boolean compatPadding;
  private int customSize;
  private final c expandableWidgetHelper;
  private final AppCompatImageHelper imageHelper;
  private PorterDuff.Mode imageMode;
  private int imagePadding;
  private ColorStateList imageTint;
  private FloatingActionButtonImpl impl;
  private int maxImageSize;
  private ColorStateList rippleColor;
  final Rect shadowPadding = new Rect();
  private int size;
  private final Rect touchArea = new Rect();

  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.floatingActionButtonStyle);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.FloatingActionButton, paramInt, R.style.Widget_Design_FloatingActionButton, new int[0]);
    this.backgroundTint = android.support.design.e.a.a(paramContext, localTypedArray, R.styleable.FloatingActionButton_backgroundTint);
    this.backgroundTintMode = k.a(localTypedArray.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    this.rippleColor = android.support.design.e.a.a(paramContext, localTypedArray, R.styleable.FloatingActionButton_rippleColor);
    this.size = localTypedArray.getInt(R.styleable.FloatingActionButton_fabSize, -1);
    this.customSize = localTypedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = localTypedArray.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = localTypedArray.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = localTypedArray.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.compatPadding = localTypedArray.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    this.maxImageSize = localTypedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
    h localh1 = h.a(paramContext, localTypedArray, R.styleable.FloatingActionButton_showMotionSpec);
    h localh2 = h.a(paramContext, localTypedArray, R.styleable.FloatingActionButton_hideMotionSpec);
    localTypedArray.recycle();
    this.imageHelper = new AppCompatImageHelper(this);
    this.imageHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.expandableWidgetHelper = new c(this);
    getImpl().setBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
    getImpl().setElevation(f1);
    getImpl().setHoveredFocusedTranslationZ(f2);
    getImpl().setPressedTranslationZ(f3);
    getImpl().setMaxImageSize(this.maxImageSize);
    getImpl().setShowMotionSpec(localh1);
    getImpl().setHideMotionSpec(localh2);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  private FloatingActionButtonImpl createImpl()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    return new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
  }

  private FloatingActionButtonImpl getImpl()
  {
    if (this.impl == null)
      this.impl = createImpl();
    return this.impl;
  }

  private int getSizeDimension(int paramInt)
  {
    if (this.customSize != 0)
      return this.customSize;
    Resources localResources = getResources();
    switch (paramInt)
    {
    case 0:
    default:
      return localResources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
    case -1:
      if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470)
        return getSizeDimension(1);
      return getSizeDimension(0);
    case 1:
    }
    return localResources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
  }

  private void offsetRectWithShadow(Rect paramRect)
  {
    paramRect.left += this.shadowPadding.left;
    paramRect.top += this.shadowPadding.top;
    paramRect.right -= this.shadowPadding.right;
    paramRect.bottom -= this.shadowPadding.bottom;
  }

  private void onApplySupportImageTint()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
      return;
    if (this.imageTint == null)
    {
      DrawableCompat.clearColorFilter(localDrawable);
      return;
    }
    int i = this.imageTint.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.imageMode;
    if (localMode == null)
      localMode = PorterDuff.Mode.SRC_IN;
    localDrawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, localMode));
  }

  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default:
      throw new IllegalArgumentException();
    case -2147483648:
      paramInt1 = Math.min(paramInt1, j);
    case 0:
      return paramInt1;
    case 1073741824:
    }
    return j;
  }

  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null)
      return null;
    return new FloatingActionButtonImpl.InternalVisibilityChangedListener()
    {
      public void onHidden()
      {
        paramOnVisibilityChangedListener.onHidden(FloatingActionButton.this);
      }

      public void onShown()
      {
        paramOnVisibilityChangedListener.onShown(FloatingActionButton.this);
      }
    };
  }

  public void addOnHideAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().addOnHideAnimationListener(paramAnimatorListener);
  }

  public void addOnShowAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().addOnShowAnimationListener(paramAnimatorListener);
  }

  public void clearCustomSize()
  {
    setCustomSize(0);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().onDrawableStateChanged(getDrawableState());
  }

  public ColorStateList getBackgroundTintList()
  {
    return this.backgroundTint;
  }

  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.backgroundTintMode;
  }

  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }

  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().getHoveredFocusedTranslationZ();
  }

  public float getCompatPressedTranslationZ()
  {
    return getImpl().getPressedTranslationZ();
  }

  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }

  @Deprecated
  public boolean getContentRect(Rect paramRect)
  {
    boolean bool1 = ViewCompat.isLaidOut(this);
    boolean bool2 = false;
    if (bool1)
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      offsetRectWithShadow(paramRect);
      bool2 = true;
    }
    return bool2;
  }

  public int getCustomSize()
  {
    return this.customSize;
  }

  public int getExpandedComponentIdHint()
  {
    return this.expandableWidgetHelper.c();
  }

  public h getHideMotionSpec()
  {
    return getImpl().getHideMotionSpec();
  }

  public void getMeasuredContentRect(Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    offsetRectWithShadow(paramRect);
  }

  @Deprecated
  public int getRippleColor()
  {
    if (this.rippleColor != null)
      return this.rippleColor.getDefaultColor();
    return 0;
  }

  public ColorStateList getRippleColorStateList()
  {
    return this.rippleColor;
  }

  public h getShowMotionSpec()
  {
    return getImpl().getShowMotionSpec();
  }

  public int getSize()
  {
    return this.size;
  }

  int getSizeDimension()
  {
    return getSizeDimension(this.size);
  }

  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }

  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }

  public ColorStateList getSupportImageTintList()
  {
    return this.imageTint;
  }

  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.imageMode;
  }

  public boolean getUseCompatPadding()
  {
    return this.compatPadding;
  }

  public void hide()
  {
    hide(null);
  }

  public void hide(OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    hide(paramOnVisibilityChangedListener, true);
  }

  void hide(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().hide(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }

  public boolean isExpanded()
  {
    return this.expandableWidgetHelper.a();
  }

  public boolean isOrWillBeHidden()
  {
    return getImpl().isOrWillBeHidden();
  }

  public boolean isOrWillBeShown()
  {
    return getImpl().isOrWillBeShown();
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.imagePadding = ((i - this.maxImageSize) / 2);
    getImpl().updatePadding();
    int j = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(j + this.shadowPadding.left + this.shadowPadding.right, j + this.shadowPadding.top + this.shadowPadding.bottom);
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    ExtendableSavedState localExtendableSavedState = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(localExtendableSavedState.getSuperState());
    this.expandableWidgetHelper.a((Bundle)localExtendableSavedState.extendableStates.get("expandableWidgetHelper"));
  }

  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    localExtendableSavedState.extendableStates.put("expandableWidgetHelper", this.expandableWidgetHelper.b());
    return localExtendableSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getContentRect(this.touchArea)) && (!this.touchArea.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      return false;
    return super.onTouchEvent(paramMotionEvent);
  }

  public void removeOnHideAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().removeOnHideAnimationListener(paramAnimatorListener);
  }

  public void removeOnShowAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().removeOnShowAnimationListener(paramAnimatorListener);
  }

  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.backgroundTint != paramColorStateList)
    {
      this.backgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }

  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.backgroundTintMode != paramMode)
    {
      this.backgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }

  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }

  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }

  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().setHoveredFocusedTranslationZ(paramFloat);
  }

  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }

  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().setPressedTranslationZ(paramFloat);
  }

  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }

  public void setCustomSize(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Custom size must be non-negative");
    this.customSize = paramInt;
  }

  public boolean setExpanded(boolean paramBoolean)
  {
    return this.expandableWidgetHelper.a(paramBoolean);
  }

  public void setExpandedComponentIdHint(int paramInt)
  {
    this.expandableWidgetHelper.a(paramInt);
  }

  public void setHideMotionSpec(h paramh)
  {
    getImpl().setHideMotionSpec(paramh);
  }

  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(h.a(getContext(), paramInt));
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    getImpl().updateImageMatrixScale();
  }

  public void setImageResource(int paramInt)
  {
    this.imageHelper.setImageResource(paramInt);
  }

  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }

  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.rippleColor != paramColorStateList)
    {
      this.rippleColor = paramColorStateList;
      getImpl().setRippleColor(this.rippleColor);
    }
  }

  public void setShowMotionSpec(h paramh)
  {
    getImpl().setShowMotionSpec(paramh);
  }

  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(h.a(getContext(), paramInt));
  }

  public void setSize(int paramInt)
  {
    this.customSize = 0;
    if (paramInt != this.size)
    {
      this.size = paramInt;
      requestLayout();
    }
  }

  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }

  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }

  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.imageTint != paramColorStateList)
    {
      this.imageTint = paramColorStateList;
      onApplySupportImageTint();
    }
  }

  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.imageMode != paramMode)
    {
      this.imageMode = paramMode;
      onApplySupportImageTint();
    }
  }

  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.compatPadding != paramBoolean)
    {
      this.compatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }

  public void show()
  {
    show(null);
  }

  public void show(OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    show(paramOnVisibilityChangedListener, true);
  }

  void show(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }

  protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T>
  {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean autoHideEnabled;
    private FloatingActionButton.OnVisibilityChangedListener internalAutoHideListener;
    private Rect tmpRect;

    public BaseBehavior()
    {
      this.autoHideEnabled = true;
    }

    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      this.autoHideEnabled = localTypedArray.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      localTypedArray.recycle();
    }

    private static boolean isBottomSheet(View paramView)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.LayoutParams))
        return ((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior() instanceof BottomSheetBehavior;
      return false;
    }

    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = paramFloatingActionButton.shadowPadding;
      CoordinatorLayout.LayoutParams localLayoutParams;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - localLayoutParams.rightMargin)
          break label101;
        i = localRect.right;
      }
      while (true)
      {
        int m;
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - localLayoutParams.bottomMargin)
          m = localRect.bottom;
        while (true)
        {
          if (m != 0)
            ViewCompat.offsetTopAndBottom(paramFloatingActionButton, m);
          if (i != 0)
            ViewCompat.offsetLeftAndRight(paramFloatingActionButton, i);
          return;
          label101: if (paramFloatingActionButton.getLeft() > localLayoutParams.leftMargin)
            break label156;
          i = -localRect.left;
          break;
          int j = paramFloatingActionButton.getTop();
          int k = localLayoutParams.topMargin;
          m = 0;
          if (j <= k)
            m = -localRect.top;
        }
        label156: i = 0;
      }
    }

    private boolean shouldUpdateVisibility(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (!this.autoHideEnabled)
        return false;
      if (localLayoutParams.getAnchorId() != paramView.getId())
        return false;
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }

    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramAppBarLayout, paramFloatingActionButton))
        return false;
      if (this.tmpRect == null)
        this.tmpRect = new Rect();
      Rect localRect = this.tmpRect;
      DescendantOffsetUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent())
        paramFloatingActionButton.hide(this.internalAutoHideListener, false);
      while (true)
      {
        return true;
        paramFloatingActionButton.show(this.internalAutoHideListener, false);
      }
    }

    private boolean updateFabVisibilityForBottomSheet(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramView, paramFloatingActionButton))
        return false;
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + localLayoutParams.topMargin)
        paramFloatingActionButton.hide(this.internalAutoHideListener, false);
      while (true)
      {
        return true;
        paramFloatingActionButton.show(this.internalAutoHideListener, false);
      }
    }

    public boolean getInsetDodgeRect(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, Rect paramRect)
    {
      Rect localRect = paramFloatingActionButton.shadowPadding;
      paramRect.set(paramFloatingActionButton.getLeft() + localRect.left, paramFloatingActionButton.getTop() + localRect.top, paramFloatingActionButton.getRight() - localRect.right, paramFloatingActionButton.getBottom() - localRect.bottom);
      return true;
    }

    public boolean isAutoHideEnabled()
    {
      return this.autoHideEnabled;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams.dodgeInsetEdges == 0)
        paramLayoutParams.dodgeInsetEdges = 80;
    }

    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout))
        updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      while (true)
      {
        return false;
        if (isBottomSheet(paramView))
          updateFabVisibilityForBottomSheet(paramView, paramFloatingActionButton);
      }
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = localList.size();
      for (int j = 0; ; j++)
      {
        View localView;
        if (j < i)
        {
          localView = (View)localList.get(j);
          if (!(localView instanceof AppBarLayout))
            break label76;
          if (!updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton))
            continue;
        }
        label76: 
        while ((isBottomSheet(localView)) && (updateFabVisibilityForBottomSheet(localView, paramFloatingActionButton)))
        {
          paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
          offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
          return true;
        }
      }
    }

    public void setAutoHideEnabled(boolean paramBoolean)
    {
      this.autoHideEnabled = paramBoolean;
    }

    public void setInternalAutoHideListener(FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
    {
      this.internalAutoHideListener = paramOnVisibilityChangedListener;
    }
  }

  public static class Behavior extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior()
    {
    }

    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }

  public static abstract class OnVisibilityChangedListener
  {
    public void onHidden(FloatingActionButton paramFloatingActionButton)
    {
    }

    public void onShown(FloatingActionButton paramFloatingActionButton)
    {
    }
  }

  private class ShadowDelegateImpl
    implements ShadowViewDelegate
  {
    ShadowDelegateImpl()
    {
    }

    public float getRadius()
    {
      return FloatingActionButton.this.getSizeDimension() / 2.0F;
    }

    public boolean isCompatPaddingEnabled()
    {
      return FloatingActionButton.this.compatPadding;
    }

    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.this.setBackgroundDrawable(paramDrawable);
    }

    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.shadowPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton.this.setPadding(paramInt1 + FloatingActionButton.this.imagePadding, paramInt2 + FloatingActionButton.this.imagePadding, paramInt3 + FloatingActionButton.this.imagePadding, paramInt4 + FloatingActionButton.this.imagePadding);
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Size
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * JD-Core Version:    0.6.2
 */