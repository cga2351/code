package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.a.a;
import android.support.design.internal.j;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/AppBarLayout$Behavior;")
public class AppBarLayout extends LinearLayout
{
  private static final int INVALID_SCROLL_RANGE = -1;
  static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
  static final int PENDING_ACTION_COLLAPSED = 2;
  static final int PENDING_ACTION_EXPANDED = 1;
  static final int PENDING_ACTION_FORCE = 8;
  static final int PENDING_ACTION_NONE;
  private int downPreScrollRange = -1;
  private int downScrollRange = -1;
  private boolean haveChildWithInterpolator;
  private WindowInsetsCompat lastInsets;
  private boolean liftOnScroll;
  private boolean liftable;
  private boolean liftableOverride;
  private boolean lifted;
  private List<BaseOnOffsetChangedListener> listeners;
  private int pendingAction = 0;
  private int[] tmpStatesArray;
  private int totalScrollRange = -1;

  public AppBarLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
      ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, paramAttributeSet, 0, R.style.Widget_Design_AppBarLayout);
    }
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout, new int[0]);
    ViewCompat.setBackground(this, localTypedArray.getDrawable(R.styleable.AppBarLayout_android_background));
    if (localTypedArray.hasValue(R.styleable.AppBarLayout_expanded))
      setExpanded(localTypedArray.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
    if ((Build.VERSION.SDK_INT >= 21) && (localTypedArray.hasValue(R.styleable.AppBarLayout_elevation)))
      ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, localTypedArray.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (localTypedArray.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster))
        setKeyboardNavigationCluster(localTypedArray.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
      if (localTypedArray.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus))
        setTouchscreenBlocksFocus(localTypedArray.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
    }
    this.liftOnScroll = localTypedArray.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
    localTypedArray.recycle();
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return AppBarLayout.this.onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }

  private boolean hasCollapsibleChild()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
      if (((LayoutParams)getChildAt(j).getLayoutParams()).isCollapsible())
        return true;
    return false;
  }

  private void invalidateScrollRanges()
  {
    this.totalScrollRange = -1;
    this.downPreScrollRange = -1;
    this.downScrollRange = -1;
  }

  private void setExpanded(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2)
        break label52;
    }
    label52: for (int j = 4; ; j = 0)
    {
      int k = j | i;
      int m = 0;
      if (paramBoolean3)
        m = 8;
      this.pendingAction = (m | k);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }

  private boolean setLiftableState(boolean paramBoolean)
  {
    if (this.liftable != paramBoolean)
    {
      this.liftable = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }

  public void addOnOffsetChangedListener(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if (this.listeners == null)
      this.listeners = new ArrayList();
    if ((paramBaseOnOffsetChangedListener != null) && (!this.listeners.contains(paramBaseOnOffsetChangedListener)))
      this.listeners.add(paramBaseOnOffsetChangedListener);
  }

  public void addOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    addOnOffsetChangedListener(paramOnOffsetChangedListener);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  void dispatchOffsetUpdates(int paramInt)
  {
    if (this.listeners != null)
    {
      int i = this.listeners.size();
      for (int j = 0; j < i; j++)
      {
        BaseOnOffsetChangedListener localBaseOnOffsetChangedListener = (BaseOnOffsetChangedListener)this.listeners.get(j);
        if (localBaseOnOffsetChangedListener != null)
          localBaseOnOffsetChangedListener.onOffsetChanged(this, paramInt);
      }
    }
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -2);
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams)))
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  int getDownNestedPreScrollRange()
  {
    if (this.downPreScrollRange != -1)
      return this.downPreScrollRange;
    int i = -1 + getChildCount();
    int j = 0;
    View localView;
    int m;
    int n;
    int i2;
    int i1;
    if (i >= 0)
    {
      localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      m = localView.getMeasuredHeight();
      n = localLayoutParams.scrollFlags;
      if ((n & 0x5) == 5)
      {
        i2 = j + (localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        if ((n & 0x8) != 0)
          i1 = i2 + ViewCompat.getMinimumHeight(localView);
      }
    }
    while (true)
    {
      i--;
      j = i1;
      break;
      if ((n & 0x2) != 0)
      {
        i1 = i2 + (m - ViewCompat.getMinimumHeight(localView));
      }
      else
      {
        i1 = i2 + (m - getTopInset());
        continue;
        if (j > 0)
        {
          int k = Math.max(0, j);
          this.downPreScrollRange = k;
          return k;
        }
        i1 = j;
      }
    }
  }

  int getDownNestedScrollRange()
  {
    if (this.downScrollRange != -1)
      return this.downScrollRange;
    int i = getChildCount();
    int j = 0;
    int k = 0;
    View localView;
    if (j < i)
    {
      localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight() + (localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      int i2 = localLayoutParams.scrollFlags;
      if ((i2 & 0x1) != 0)
      {
        k += i1;
        if ((i2 & 0x2) == 0);
      }
    }
    for (int m = k - (ViewCompat.getMinimumHeight(localView) + getTopInset()); ; m = k)
    {
      int n = Math.max(0, m);
      this.downScrollRange = n;
      return n;
      j++;
      break;
    }
  }

  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i = getTopInset();
    int j = ViewCompat.getMinimumHeight(this);
    if (j != 0)
      return i + j * 2;
    int k = getChildCount();
    if (k >= 1);
    for (int m = ViewCompat.getMinimumHeight(getChildAt(k - 1)); m != 0; m = 0)
      return i + m * 2;
    return getHeight() / 3;
  }

  int getPendingAction()
  {
    return this.pendingAction;
  }

  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }

  final int getTopInset()
  {
    if (this.lastInsets != null)
      return this.lastInsets.getSystemWindowInsetTop();
    return 0;
  }

  public final int getTotalScrollRange()
  {
    if (this.totalScrollRange != -1)
      return this.totalScrollRange;
    int i = getChildCount();
    int j = 0;
    int k = 0;
    View localView;
    if (j < i)
    {
      localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      int i2 = localLayoutParams.scrollFlags;
      if ((i2 & 0x1) != 0)
      {
        k += i1 + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((i2 & 0x2) == 0);
      }
    }
    for (int m = k - ViewCompat.getMinimumHeight(localView); ; m = k)
    {
      int n = Math.max(0, m - getTopInset());
      this.totalScrollRange = n;
      return n;
      j++;
      break;
    }
  }

  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }

  boolean hasChildWithInterpolator()
  {
    return this.haveChildWithInterpolator;
  }

  boolean hasScrollableChildren()
  {
    return getTotalScrollRange() != 0;
  }

  public boolean isLiftOnScroll()
  {
    return this.liftOnScroll;
  }

  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.tmpStatesArray == null)
      this.tmpStatesArray = new int[4];
    int[] arrayOfInt1 = this.tmpStatesArray;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    int i;
    int j;
    label64: int k;
    if (this.liftable)
    {
      i = R.attr.state_liftable;
      arrayOfInt1[0] = i;
      if ((!this.liftable) || (!this.lifted))
        break label125;
      j = R.attr.state_lifted;
      arrayOfInt1[1] = j;
      if (!this.liftable)
        break label134;
      k = R.attr.state_collapsible;
      label81: arrayOfInt1[2] = k;
      if ((!this.liftable) || (!this.lifted))
        break label143;
    }
    label134: label143: for (int m = R.attr.state_collapsed; ; m = -R.attr.state_collapsed)
    {
      arrayOfInt1[3] = m;
      return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      i = -R.attr.state_liftable;
      break;
      label125: j = -R.attr.state_lifted;
      break label64;
      k = -R.attr.state_collapsible;
      break label81;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateScrollRanges();
    this.haveChildWithInterpolator = false;
    int i = getChildCount();
    int j = 0;
    if (j < i)
    {
      if (((LayoutParams)getChildAt(j).getLayoutParams()).getScrollInterpolator() != null)
        this.haveChildWithInterpolator = true;
    }
    else if (!this.liftableOverride)
      if ((!this.liftOnScroll) && (!hasCollapsibleChild()))
        break label97;
    label97: for (boolean bool = true; ; bool = false)
    {
      setLiftableState(bool);
      return;
      j++;
      break;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    invalidateScrollRanges();
  }

  WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    boolean bool = ViewCompat.getFitsSystemWindows(this);
    WindowInsetsCompat localWindowInsetsCompat = null;
    if (bool)
      localWindowInsetsCompat = paramWindowInsetsCompat;
    if (!ObjectsCompat.equals(this.lastInsets, localWindowInsetsCompat))
    {
      this.lastInsets = localWindowInsetsCompat;
      invalidateScrollRanges();
    }
    return paramWindowInsetsCompat;
  }

  public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if ((this.listeners != null) && (paramBaseOnOffsetChangedListener != null))
      this.listeners.remove(paramBaseOnOffsetChangedListener);
  }

  public void removeOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    removeOnOffsetChangedListener(paramOnOffsetChangedListener);
  }

  void resetPendingAction()
  {
    this.pendingAction = 0;
  }

  public void setExpanded(boolean paramBoolean)
  {
    setExpanded(paramBoolean, ViewCompat.isLaidOut(this));
  }

  public void setExpanded(boolean paramBoolean1, boolean paramBoolean2)
  {
    setExpanded(paramBoolean1, paramBoolean2, true);
  }

  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.liftOnScroll = paramBoolean;
  }

  public boolean setLiftable(boolean paramBoolean)
  {
    this.liftableOverride = true;
    return setLiftableState(paramBoolean);
  }

  public boolean setLifted(boolean paramBoolean)
  {
    return setLiftedState(paramBoolean);
  }

  boolean setLiftedState(boolean paramBoolean)
  {
    if (this.lifted != paramBoolean)
    {
      this.lifted = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }

  public void setOrientation(int paramInt)
  {
    if (paramInt != 1)
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    super.setOrientation(paramInt);
  }

  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
      ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, paramFloat);
  }

  protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T>
  {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout = -1;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private BaseDragCallback onDragCallback;

    public BaseBehavior()
    {
    }

    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    private void animateOffsetTo(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt, float paramFloat)
    {
      int i = Math.abs(getTopBottomOffsetForScrollingSibling() - paramInt);
      float f = Math.abs(paramFloat);
      if (f > 0.0F);
      for (int j = 3 * Math.round(1000.0F * (i / f)); ; j = (int)(150.0F * (1.0F + i / paramT.getHeight())))
      {
        animateOffsetWithDuration(paramCoordinatorLayout, paramT, paramInt, j);
        return;
      }
    }

    private void animateOffsetWithDuration(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt1, int paramInt2)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if (i == paramInt1)
      {
        if ((this.offsetAnimator != null) && (this.offsetAnimator.isRunning()))
          this.offsetAnimator.cancel();
        return;
      }
      if (this.offsetAnimator == null)
      {
        this.offsetAnimator = new ValueAnimator();
        this.offsetAnimator.setInterpolator(a.e);
        this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppBarLayout.BaseBehavior.this.setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
      while (true)
      {
        this.offsetAnimator.setDuration(Math.min(paramInt2, 600));
        this.offsetAnimator.setIntValues(new int[] { i, paramInt1 });
        this.offsetAnimator.start();
        return;
        this.offsetAnimator.cancel();
      }
    }

    private boolean canScrollChildren(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView)
    {
      return (paramT.hasScrollableChildren()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
    }

    private static boolean checkFlag(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }

    private View findFirstScrollingChild(CoordinatorLayout paramCoordinatorLayout)
    {
      int i = paramCoordinatorLayout.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = paramCoordinatorLayout.getChildAt(j);
        if ((localView instanceof NestedScrollingChild))
          return localView;
      }
      return null;
    }

    private static View getAppBarChildOnOffset(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      for (int k = 0; k < j; k++)
      {
        View localView = paramAppBarLayout.getChildAt(k);
        if ((i >= localView.getTop()) && (i <= localView.getBottom()))
          return localView;
      }
      return null;
    }

    private int getChildIndexOnOffset(T paramT, int paramInt)
    {
      int i = 0;
      int j = paramT.getChildCount();
      int k;
      int m;
      int i2;
      int n;
      if (i < j)
      {
        View localView = paramT.getChildAt(i);
        k = localView.getTop();
        m = localView.getBottom();
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        if (!checkFlag(localLayoutParams.getScrollFlags(), 32))
          break label106;
        i2 = k - localLayoutParams.topMargin;
        n = m + localLayoutParams.bottomMargin;
      }
      for (int i1 = i2; ; i1 = k)
      {
        if ((i1 <= -paramInt) && (n >= -paramInt))
          return i;
        i++;
        break;
        return -1;
        label106: n = m;
      }
    }

    private int interpolateOffset(T paramT, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramT.getChildCount();
      int k = 0;
      View localView;
      Interpolator localInterpolator;
      int n;
      if (k < j)
      {
        localView = paramT.getChildAt(k);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((i < localView.getTop()) || (i > localView.getBottom()))
          break label191;
        if (localInterpolator != null)
        {
          int m = localLayoutParams.getScrollFlags();
          if ((m & 0x1) == 0)
            break label197;
          n = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
          if ((m & 0x2) != 0)
            n -= ViewCompat.getMinimumHeight(localView);
        }
      }
      while (true)
      {
        if (ViewCompat.getFitsSystemWindows(localView))
          n -= paramT.getTopInset();
        if (n > 0)
        {
          int i1 = i - localView.getTop();
          int i2 = Math.round(n * localInterpolator.getInterpolation(i1 / n));
          paramInt = Integer.signum(paramInt) * (i2 + localView.getTop());
        }
        return paramInt;
        label191: k++;
        break;
        label197: n = 0;
      }
    }

    private boolean shouldJumpElevationState(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      List localList = paramCoordinatorLayout.getDependents(paramT);
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)((View)localList.get(j)).getLayoutParams()).getBehavior();
        if ((localBehavior instanceof AppBarLayout.ScrollingViewBehavior))
          return ((AppBarLayout.ScrollingViewBehavior)localBehavior).getOverlayTop() != 0;
      }
      return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      int j = getChildIndexOnOffset(paramT, i);
      View localView;
      AppBarLayout.LayoutParams localLayoutParams;
      int k;
      int m;
      int n;
      int i1;
      if (j >= 0)
      {
        localView = paramT.getChildAt(j);
        localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        k = localLayoutParams.getScrollFlags();
        if ((k & 0x11) == 17)
        {
          m = -localView.getTop();
          n = -localView.getBottom();
          if (j == -1 + paramT.getChildCount())
            n += paramT.getTopInset();
          if (!checkFlag(k, 2))
            break label172;
          n += ViewCompat.getMinimumHeight(localView);
          i1 = m;
        }
      }
      while (true)
      {
        if (checkFlag(k, 32))
        {
          i1 += localLayoutParams.topMargin;
          n -= localLayoutParams.bottomMargin;
        }
        if (i < (n + i1) / 2);
        while (true)
        {
          animateOffsetTo(paramCoordinatorLayout, paramT, MathUtils.clamp(n, -paramT.getTotalScrollRange(), 0), 0.0F);
          return;
          label172: if (!checkFlag(k, 5))
            break label215;
          i1 = n + ViewCompat.getMinimumHeight(localView);
          if (i < i1)
            break;
          n = i1;
          i1 = m;
          break;
          n = i1;
        }
        label215: i1 = m;
      }
    }

    private void stopNestedScrollIfNeeded(int paramInt1, T paramT, View paramView, int paramInt2)
    {
      if (paramInt2 == 1)
      {
        int i = getTopBottomOffsetForScrollingSibling();
        if (((paramInt1 < 0) && (i == 0)) || ((paramInt1 > 0) && (i == -paramT.getDownNestedScrollRange())))
          ViewCompat.stopNestedScroll(paramView, 1);
      }
    }

    private void updateAppBarLayoutDrawableState(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      boolean bool1 = true;
      View localView1 = getAppBarChildOnOffset(paramT, paramInt1);
      int i;
      int j;
      boolean bool2;
      if (localView1 != null)
      {
        i = ((AppBarLayout.LayoutParams)localView1.getLayoutParams()).getScrollFlags();
        if ((i & 0x1) == 0)
          break label198;
        j = ViewCompat.getMinimumHeight(localView1);
        if ((paramInt2 <= 0) || ((i & 0xC) == 0))
          break label154;
        if (-paramInt1 < localView1.getBottom() - j - paramT.getTopInset())
          break label148;
        bool2 = bool1;
      }
      while (true)
      {
        if (paramT.isLiftOnScroll())
        {
          View localView2 = findFirstScrollingChild(paramCoordinatorLayout);
          if (localView2 != null)
            if (localView2.getScrollY() <= 0)
              break label192;
        }
        while (true)
        {
          bool2 = bool1;
          boolean bool3 = paramT.setLiftedState(bool2);
          if ((Build.VERSION.SDK_INT >= 11) && ((paramBoolean) || ((bool3) && (shouldJumpElevationState(paramCoordinatorLayout, paramT)))))
            paramT.jumpDrawablesToCurrentState();
          return;
          label148: bool2 = false;
          break;
          label154: if ((i & 0x2) == 0)
            break label198;
          if (-paramInt1 >= localView1.getBottom() - j - paramT.getTopInset())
          {
            bool2 = bool1;
            break;
          }
          bool2 = false;
          break;
          label192: bool1 = false;
        }
        label198: bool2 = false;
      }
    }

    boolean canDragView(T paramT)
    {
      if (this.onDragCallback != null)
        return this.onDragCallback.canDrag(paramT);
      if (this.lastNestedScrollingChildRef != null)
      {
        View localView = (View)this.lastNestedScrollingChildRef.get();
        return (localView != null) && (localView.isShown()) && (!localView.canScrollVertically(-1));
      }
      return true;
    }

    int getMaxDragOffset(T paramT)
    {
      return -paramT.getDownNestedScrollRange();
    }

    int getScrollRangeForDragFling(T paramT)
    {
      return paramT.getTotalScrollRange();
    }

    int getTopBottomOffsetForScrollingSibling()
    {
      return getTopAndBottomOffset() + this.offsetDelta;
    }

    boolean isOffsetAnimatorRunning()
    {
      return (this.offsetAnimator != null) && (this.offsetAnimator.isRunning());
    }

    void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      snapToChildIfNeeded(paramCoordinatorLayout, paramT);
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      View localView;
      int m;
      int n;
      if ((this.offsetToChildIndexOnLayout >= 0) && ((i & 0x8) == 0))
      {
        localView = paramT.getChildAt(this.offsetToChildIndexOnLayout);
        m = -localView.getBottom();
        if (this.offsetToChildIndexOnLayoutIsMinHeight)
        {
          n = m + (ViewCompat.getMinimumHeight(localView) + paramT.getTopInset());
          setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, n);
        }
      }
      while (true)
      {
        paramT.resetPendingAction();
        this.offsetToChildIndexOnLayout = -1;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -paramT.getTotalScrollRange(), 0));
        updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, getTopAndBottomOffset(), 0, true);
        paramT.dispatchOffsetUpdates(getTopAndBottomOffset());
        return bool;
        n = m + Math.round(localView.getHeight() * this.offsetToChildIndexOnLayoutPerc);
        break;
        if (i != 0)
        {
          int j;
          if ((i & 0x4) != 0)
            j = 1;
          while (true)
            if ((i & 0x2) != 0)
            {
              int k = -paramT.getUpNestedPreScrollRange();
              if (j != 0)
              {
                animateOffsetTo(paramCoordinatorLayout, paramT, k, 0.0F);
                break;
                j = 0;
                continue;
              }
              setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, k);
              break;
            }
          if ((i & 0x1) != 0)
            if (j != 0)
              animateOffsetTo(paramCoordinatorLayout, paramT, 0, 0.0F);
            else
              setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, 0);
        }
      }
    }

    public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.LayoutParams)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.onMeasureChild(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.onMeasureChild(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      int i;
      if (paramInt2 != 0)
      {
        if (paramInt2 >= 0)
          break label60;
        i = -paramT.getTotalScrollRange();
      }
      for (int j = i + paramT.getDownNestedPreScrollRange(); ; j = 0)
      {
        if (i != j)
        {
          paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramT, paramInt2, i, j);
          stopNestedScrollIfNeeded(paramInt2, paramT, paramView, paramInt3);
        }
        return;
        label60: i = -paramT.getUpNestedPreScrollRange();
      }
    }

    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt4 < 0)
      {
        scroll(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
        stopNestedScrollIfNeeded(paramInt4, paramT, paramView, paramInt5);
      }
      if (paramT.isLiftOnScroll())
      {
        int i = paramView.getScrollY();
        boolean bool = false;
        if (i > 0)
          bool = true;
        paramT.setLiftedState(bool);
      }
    }

    public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        SavedState localSavedState = (SavedState)paramParcelable;
        super.onRestoreInstanceState(paramCoordinatorLayout, paramT, localSavedState.getSuperState());
        this.offsetToChildIndexOnLayout = localSavedState.firstVisibleChildIndex;
        this.offsetToChildIndexOnLayoutPerc = localSavedState.firstVisibleChildPercentageShown;
        this.offsetToChildIndexOnLayoutIsMinHeight = localSavedState.firstVisibleChildAtMinimumHeight;
        return;
      }
      super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable);
      this.offsetToChildIndexOnLayout = -1;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      Parcelable localParcelable = super.onSaveInstanceState(paramCoordinatorLayout, paramT);
      int i = getTopAndBottomOffset();
      int j = paramT.getChildCount();
      for (int k = 0; k < j; k++)
      {
        View localView = paramT.getChildAt(k);
        int m = i + localView.getBottom();
        if ((i + localView.getTop() <= 0) && (m >= 0))
        {
          SavedState localSavedState = new SavedState(localParcelable);
          localSavedState.firstVisibleChildIndex = k;
          int n = ViewCompat.getMinimumHeight(localView) + paramT.getTopInset();
          boolean bool = false;
          if (m == n)
            bool = true;
          localSavedState.firstVisibleChildAtMinimumHeight = bool;
          localSavedState.firstVisibleChildPercentageShown = (m / localView.getHeight());
          return localSavedState;
        }
      }
      return localParcelable;
    }

    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      if (((paramInt1 & 0x2) != 0) && ((paramT.isLiftOnScroll()) || (canScrollChildren(paramCoordinatorLayout, paramT, paramView1))));
      for (boolean bool = true; ; bool = false)
      {
        if ((bool) && (this.offsetAnimator != null))
          this.offsetAnimator.cancel();
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = paramInt2;
        return bool;
      }
    }

    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      if ((this.lastStartedType == 0) || (paramInt == 1))
        snapToChildIfNeeded(paramCoordinatorLayout, paramT);
      this.lastNestedScrollingChildRef = new WeakReference(paramView);
    }

    public void setDragCallback(BaseDragCallback paramBaseDragCallback)
    {
      this.onDragCallback = paramBaseDragCallback;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
      {
        int j = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
        int k = 0;
        int m;
        int n;
        if (i != j)
        {
          if (!paramT.hasChildWithInterpolator())
            break label138;
          m = interpolateOffset(paramT, j);
          boolean bool = setTopAndBottomOffset(m);
          n = i - j;
          this.offsetDelta = (j - m);
          if ((!bool) && (paramT.hasChildWithInterpolator()))
            paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
          paramT.dispatchOffsetUpdates(getTopAndBottomOffset());
          if (j >= i)
            break label145;
        }
        label138: label145: for (int i1 = -1; ; i1 = 1)
        {
          updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, j, i1, false);
          k = n;
          return k;
          m = j;
          break;
        }
      }
      this.offsetDelta = 0;
      return 0;
    }

    public static abstract class BaseDragCallback<T extends AppBarLayout>
    {
      public abstract boolean canDrag(T paramT);
    }

    protected static class SavedState extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, null);
        }

        public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
        }

        public AppBarLayout.BaseBehavior.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppBarLayout.BaseBehavior.SavedState[paramAnonymousInt];
        }
      };
      boolean firstVisibleChildAtMinimumHeight;
      int firstVisibleChildIndex;
      float firstVisibleChildPercentageShown;

      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        this.firstVisibleChildIndex = paramParcel.readInt();
        this.firstVisibleChildPercentageShown = paramParcel.readFloat();
        if (paramParcel.readByte() != 0);
        for (boolean bool = true; ; bool = false)
        {
          this.firstVisibleChildAtMinimumHeight = bool;
          return;
        }
      }

      public SavedState(Parcelable paramParcelable)
      {
        super();
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.firstVisibleChildIndex);
        paramParcel.writeFloat(this.firstVisibleChildPercentageShown);
        if (this.firstVisibleChildAtMinimumHeight);
        for (int i = 1; ; i = 0)
        {
          paramParcel.writeByte((byte)i);
          return;
        }
      }
    }
  }

  public static abstract interface BaseOnOffsetChangedListener<T extends AppBarLayout>
  {
    public abstract void onOffsetChanged(T paramT, int paramInt);
  }

  public static class Behavior extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior()
    {
    }

    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public static abstract class DragCallback extends AppBarLayout.BaseBehavior.BaseDragCallback<AppBarLayout>
    {
    }
  }

  public static class LayoutParams extends LinearLayout.LayoutParams
  {
    static final int COLLAPSIBLE_FLAGS = 10;
    static final int FLAG_QUICK_RETURN = 5;
    static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    int scrollFlags = 1;
    Interpolator scrollInterpolator;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2, paramFloat);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_Layout);
      this.scrollFlags = localTypedArray.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (localTypedArray.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator))
        this.scrollInterpolator = AnimationUtils.loadInterpolator(paramContext, localTypedArray.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      localTypedArray.recycle();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.scrollFlags = paramLayoutParams.scrollFlags;
      this.scrollInterpolator = paramLayoutParams.scrollInterpolator;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }

    public int getScrollFlags()
    {
      return this.scrollFlags;
    }

    public Interpolator getScrollInterpolator()
    {
      return this.scrollInterpolator;
    }

    boolean isCollapsible()
    {
      return ((0x1 & this.scrollFlags) == 1) && ((0xA & this.scrollFlags) != 0);
    }

    public void setScrollFlags(int paramInt)
    {
      this.scrollFlags = paramInt;
    }

    public void setScrollInterpolator(Interpolator paramInterpolator)
    {
      this.scrollInterpolator = paramInterpolator;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ScrollFlags
    {
    }
  }

  public static abstract interface OnOffsetChangedListener extends AppBarLayout.BaseOnOffsetChangedListener<AppBarLayout>
  {
    public abstract void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt);
  }

  public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior()
    {
    }

    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      setOverlayTop(localTypedArray.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      localTypedArray.recycle();
    }

    private static int getAppBarLayoutOffset(AppBarLayout paramAppBarLayout)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
      if ((localBehavior instanceof AppBarLayout.BaseBehavior))
        return ((AppBarLayout.BaseBehavior)localBehavior).getTopBottomOffsetForScrollingSibling();
      return 0;
    }

    private void offsetChildAsNeeded(View paramView1, View paramView2)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
      if ((localBehavior instanceof AppBarLayout.BaseBehavior))
      {
        AppBarLayout.BaseBehavior localBaseBehavior = (AppBarLayout.BaseBehavior)localBehavior;
        ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + localBaseBehavior.offsetDelta + getVerticalLayoutGap() - getOverlapPixelsForOffset(paramView2));
      }
    }

    private void updateLiftedStateIfNeeded(View paramView1, View paramView2)
    {
      AppBarLayout localAppBarLayout;
      if ((paramView2 instanceof AppBarLayout))
      {
        localAppBarLayout = (AppBarLayout)paramView2;
        if (localAppBarLayout.isLiftOnScroll())
          if (paramView1.getScrollY() <= 0)
            break label37;
      }
      label37: for (boolean bool = true; ; bool = false)
      {
        localAppBarLayout.setLiftedState(bool);
        return;
      }
    }

    AppBarLayout findFirstDependency(List<View> paramList)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)paramList.get(j);
        if ((localView instanceof AppBarLayout))
          return (AppBarLayout)localView;
      }
      return null;
    }

    float getOverlapRatioForOffset(View paramView)
    {
      int i;
      int j;
      int k;
      if ((paramView instanceof AppBarLayout))
      {
        AppBarLayout localAppBarLayout = (AppBarLayout)paramView;
        i = localAppBarLayout.getTotalScrollRange();
        j = localAppBarLayout.getDownNestedPreScrollRange();
        k = getAppBarLayoutOffset(localAppBarLayout);
        if ((j == 0) || (i + k > j))
          break label45;
      }
      label45: int m;
      do
      {
        return 0.0F;
        m = i - j;
      }
      while (m == 0);
      return 1.0F + k / m;
    }

    int getScrollRange(View paramView)
    {
      if ((paramView instanceof AppBarLayout))
        return ((AppBarLayout)paramView).getTotalScrollRange();
      return super.getScrollRange(paramView);
    }

    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      offsetChildAsNeeded(paramView1, paramView2);
      updateLiftedStateIfNeeded(paramView1, paramView2);
      return false;
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        Rect localRect = this.tempRect1;
        localRect.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!localRect.contains(paramRect))
        {
          if (!paramBoolean);
          for (boolean bool = true; ; bool = false)
          {
            localAppBarLayout.setExpanded(false, bool);
            return true;
          }
        }
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout
 * JD-Core Version:    0.6.2
 */