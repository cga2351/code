package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.dimen;
import android.support.design.R.styleable;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V>
{
  private static final float HIDE_FRICTION = 0.1F;
  private static final float HIDE_THRESHOLD = 0.5F;
  public static final int PEEK_HEIGHT_AUTO = -1;
  public static final int STATE_COLLAPSED = 4;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_EXPANDED = 3;
  public static final int STATE_HALF_EXPANDED = 6;
  public static final int STATE_HIDDEN = 5;
  public static final int STATE_SETTLING = 2;
  int activePointerId;
  private BottomSheetCallback callback;
  int collapsedOffset;
  private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getLeft();
    }

    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = BottomSheetBehavior.this.getExpandedOffset();
      if (BottomSheetBehavior.this.hideable);
      for (int j = BottomSheetBehavior.this.parentHeight; ; j = BottomSheetBehavior.this.collapsedOffset)
        return MathUtils.clamp(paramAnonymousInt1, i, j);
    }

    public int getViewVerticalDragRange(View paramAnonymousView)
    {
      if (BottomSheetBehavior.this.hideable)
        return BottomSheetBehavior.this.parentHeight;
      return BottomSheetBehavior.this.collapsedOffset;
    }

    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1)
        BottomSheetBehavior.this.setStateInternal(1);
    }

    public void onViewPositionChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      BottomSheetBehavior.this.dispatchOnSlide(paramAnonymousInt2);
    }

    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int i = 6;
      int j = 3;
      int m;
      if (paramAnonymousFloat2 < 0.0F)
        if (BottomSheetBehavior.this.fitToContents)
          m = BottomSheetBehavior.this.fitToContentsOffset;
      while (BottomSheetBehavior.this.viewDragHelper.settleCapturedViewAt(paramAnonymousView.getLeft(), m))
      {
        BottomSheetBehavior.this.setStateInternal(2);
        ViewCompat.postOnAnimation(paramAnonymousView, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.halfExpandedOffset);
        for (int i1 = BottomSheetBehavior.this.halfExpandedOffset; ; i1 = 0)
        {
          m = i1;
          j = i;
          break;
          i = j;
        }
        if ((BottomSheetBehavior.this.hideable) && (BottomSheetBehavior.this.shouldHide(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.collapsedOffset) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
        {
          m = BottomSheetBehavior.this.parentHeight;
          j = 5;
        }
        else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          int k = paramAnonymousView.getTop();
          if (BottomSheetBehavior.this.fitToContents)
          {
            if (Math.abs(k - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(k - BottomSheetBehavior.this.collapsedOffset))
            {
              m = BottomSheetBehavior.this.fitToContentsOffset;
            }
            else
            {
              m = BottomSheetBehavior.this.collapsedOffset;
              j = 4;
            }
          }
          else if (k < BottomSheetBehavior.this.halfExpandedOffset)
          {
            int n = Math.abs(k - BottomSheetBehavior.this.collapsedOffset);
            m = 0;
            if (k >= n)
            {
              m = BottomSheetBehavior.this.halfExpandedOffset;
              j = i;
            }
          }
          else if (Math.abs(k - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(k - BottomSheetBehavior.this.collapsedOffset))
          {
            m = BottomSheetBehavior.this.halfExpandedOffset;
            j = i;
          }
          else
          {
            m = BottomSheetBehavior.this.collapsedOffset;
            j = 4;
          }
        }
        else
        {
          m = BottomSheetBehavior.this.collapsedOffset;
          j = 4;
        }
      }
      BottomSheetBehavior.this.setStateInternal(j);
    }

    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1);
      View localView;
      do
      {
        do
          return false;
        while (BottomSheetBehavior.this.touchingScrollingChild);
        if ((BottomSheetBehavior.this.state != 3) || (BottomSheetBehavior.this.activePointerId != paramAnonymousInt))
          break;
        localView = (View)BottomSheetBehavior.this.nestedScrollingChildRef.get();
      }
      while ((localView != null) && (localView.canScrollVertically(-1)));
      if ((BottomSheetBehavior.this.viewRef != null) && (BottomSheetBehavior.this.viewRef.get() == paramAnonymousView));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  };
  private boolean fitToContents = true;
  int fitToContentsOffset;
  int halfExpandedOffset;
  boolean hideable;
  private boolean ignoreEvents;
  private Map<View, Integer> importantForAccessibilityMap;
  private int initialY;
  private int lastNestedScrollDy;
  private int lastPeekHeight;
  private float maximumVelocity;
  private boolean nestedScrolled;
  WeakReference<View> nestedScrollingChildRef;
  int parentHeight;
  private int peekHeight;
  private boolean peekHeightAuto;
  private int peekHeightMin;
  private boolean skipCollapsed;
  int state = 4;
  boolean touchingScrollingChild;
  private VelocityTracker velocityTracker;
  ViewDragHelper viewDragHelper;
  WeakReference<V> viewRef;

  public BottomSheetBehavior()
  {
  }

  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = localTypedArray.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1))
      setPeekHeight(localTypedValue.data);
    while (true)
    {
      setHideable(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
      setFitToContents(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
      setSkipCollapsed(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
      localTypedArray.recycle();
      this.maximumVelocity = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      setPeekHeight(localTypedArray.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    }
  }

  private void calculateCollapsedOffset()
  {
    if (this.fitToContents)
    {
      this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
      return;
    }
    this.collapsedOffset = (this.parentHeight - this.lastPeekHeight);
  }

  public static <V extends View> BottomSheetBehavior<V> from(V paramV)
  {
    ViewGroup.LayoutParams localLayoutParams = paramV.getLayoutParams();
    if (!(localLayoutParams instanceof CoordinatorLayout.LayoutParams))
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior();
    if (!(localBehavior instanceof BottomSheetBehavior))
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    return (BottomSheetBehavior)localBehavior;
  }

  private int getExpandedOffset()
  {
    if (this.fitToContents)
      return this.fitToContentsOffset;
    return 0;
  }

  private float getYVelocity()
  {
    if (this.velocityTracker == null)
      return 0.0F;
    this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
    return this.velocityTracker.getYVelocity(this.activePointerId);
  }

  private void reset()
  {
    this.activePointerId = -1;
    if (this.velocityTracker != null)
    {
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }

  private void updateImportantForAccessibility(boolean paramBoolean)
  {
    if (this.viewRef == null);
    do
    {
      CoordinatorLayout localCoordinatorLayout;
      int i;
      do
      {
        ViewParent localViewParent;
        do
        {
          return;
          localViewParent = ((View)this.viewRef.get()).getParent();
        }
        while (!(localViewParent instanceof CoordinatorLayout));
        localCoordinatorLayout = (CoordinatorLayout)localViewParent;
        i = localCoordinatorLayout.getChildCount();
        if ((Build.VERSION.SDK_INT < 16) || (!paramBoolean))
          break;
      }
      while (this.importantForAccessibilityMap != null);
      this.importantForAccessibilityMap = new HashMap(i);
      int j = 0;
      if (j < i)
      {
        View localView = localCoordinatorLayout.getChildAt(j);
        if (localView == this.viewRef.get());
        while (true)
        {
          j++;
          break;
          if (!paramBoolean)
          {
            if ((this.importantForAccessibilityMap != null) && (this.importantForAccessibilityMap.containsKey(localView)))
              ViewCompat.setImportantForAccessibility(localView, ((Integer)this.importantForAccessibilityMap.get(localView)).intValue());
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 16)
              this.importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
            ViewCompat.setImportantForAccessibility(localView, 4);
          }
        }
      }
    }
    while (paramBoolean);
    this.importantForAccessibilityMap = null;
  }

  void dispatchOnSlide(int paramInt)
  {
    View localView = (View)this.viewRef.get();
    if ((localView != null) && (this.callback != null))
    {
      if (paramInt > this.collapsedOffset)
        this.callback.onSlide(localView, (this.collapsedOffset - paramInt) / (this.parentHeight - this.collapsedOffset));
    }
    else
      return;
    this.callback.onSlide(localView, (this.collapsedOffset - paramInt) / (this.collapsedOffset - getExpandedOffset()));
  }

  View findScrollingChild(View paramView)
  {
    if (ViewCompat.isNestedScrollingEnabled(paramView))
      return paramView;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = findScrollingChild(localViewGroup.getChildAt(j));
        if (localView != null)
          return localView;
      }
    }
    return null;
  }

  public final int getPeekHeight()
  {
    if (this.peekHeightAuto)
      return -1;
    return this.peekHeight;
  }

  int getPeekHeightMin()
  {
    return this.peekHeightMin;
  }

  public boolean getSkipCollapsed()
  {
    return this.skipCollapsed;
  }

  public final int getState()
  {
    return this.state;
  }

  public boolean isFitToContents()
  {
    return this.fitToContents;
  }

  public boolean isHideable()
  {
    return this.hideable;
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (!paramV.isShown())
    {
      this.ignoreEvents = i;
      return false;
    }
    int k = paramMotionEvent.getActionMasked();
    if (k == 0)
      reset();
    if (this.velocityTracker == null)
      this.velocityTracker = VelocityTracker.obtain();
    this.velocityTracker.addMovement(paramMotionEvent);
    switch (k)
    {
    case 2:
    default:
    case 1:
    case 3:
    case 0:
    }
    while ((!this.ignoreEvents) && (this.viewDragHelper != null) && (this.viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent)))
    {
      return i;
      this.touchingScrollingChild = false;
      this.activePointerId = -1;
      if (this.ignoreEvents)
      {
        this.ignoreEvents = false;
        return false;
        int m = (int)paramMotionEvent.getX();
        this.initialY = ((int)paramMotionEvent.getY());
        View localView1;
        if (this.nestedScrollingChildRef != null)
        {
          localView1 = (View)this.nestedScrollingChildRef.get();
          label175: if ((localView1 != null) && (paramCoordinatorLayout.isPointInChildBounds(localView1, m, this.initialY)))
          {
            this.activePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.touchingScrollingChild = i;
          }
          if ((this.activePointerId != -1) || (paramCoordinatorLayout.isPointInChildBounds(paramV, m, this.initialY)))
            break label254;
        }
        label254: int i1;
        for (int n = i; ; i1 = 0)
        {
          this.ignoreEvents = n;
          break;
          localView1 = null;
          break label175;
        }
      }
    }
    View localView2;
    if (this.nestedScrollingChildRef != null)
    {
      localView2 = (View)this.nestedScrollingChildRef.get();
      if ((k != 2) || (localView2 == null) || (this.ignoreEvents) || (this.state == i) || (paramCoordinatorLayout.isPointInChildBounds(localView2, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (this.viewDragHelper == null) || (Math.abs(this.initialY - paramMotionEvent.getY()) <= this.viewDragHelper.getTouchSlop()))
        break label366;
    }
    while (true)
    {
      return i;
      localView2 = null;
      break;
      label366: int j = 0;
    }
  }

  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramV)))
      paramV.setFitsSystemWindows(true);
    int i = paramV.getTop();
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
    this.parentHeight = paramCoordinatorLayout.getHeight();
    if (this.peekHeightAuto)
    {
      if (this.peekHeightMin == 0)
        this.peekHeightMin = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - 9 * paramCoordinatorLayout.getWidth() / 16);
      this.fitToContentsOffset = Math.max(0, this.parentHeight - paramV.getHeight());
      this.halfExpandedOffset = (this.parentHeight / 2);
      calculateCollapsedOffset();
      if (this.state != 3)
        break label200;
      ViewCompat.offsetTopAndBottom(paramV, getExpandedOffset());
    }
    while (true)
    {
      if (this.viewDragHelper == null)
        this.viewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, this.dragCallback);
      this.viewRef = new WeakReference(paramV);
      this.nestedScrollingChildRef = new WeakReference(findScrollingChild(paramV));
      return true;
      this.lastPeekHeight = this.peekHeight;
      break;
      label200: if (this.state == 6)
        ViewCompat.offsetTopAndBottom(paramV, this.halfExpandedOffset);
      else if ((this.hideable) && (this.state == 5))
        ViewCompat.offsetTopAndBottom(paramV, this.parentHeight);
      else if (this.state == 4)
        ViewCompat.offsetTopAndBottom(paramV, this.collapsedOffset);
      else if ((this.state == 1) || (this.state == 2))
        ViewCompat.offsetTopAndBottom(paramV, i - paramV.getTop());
    }
  }

  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.nestedScrollingChildRef.get()) && ((this.state != 3) || (super.onNestedPreFling(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }

  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1);
    while (paramView != (View)this.nestedScrollingChildRef.get())
      return;
    int i = paramV.getTop();
    int j = i - paramInt2;
    if (paramInt2 > 0)
      if (j < getExpandedOffset())
      {
        paramArrayOfInt[1] = (i - getExpandedOffset());
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        setStateInternal(3);
      }
    while (true)
    {
      dispatchOnSlide(paramV.getTop());
      this.lastNestedScrollDy = paramInt2;
      this.nestedScrolled = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
      setStateInternal(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)))
        if ((j <= this.collapsedOffset) || (this.hideable))
        {
          paramArrayOfInt[1] = paramInt2;
          ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
          setStateInternal(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.collapsedOffset);
          ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
          setStateInternal(4);
        }
    }
  }

  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramV, localSavedState.getSuperState());
    if ((localSavedState.state == 1) || (localSavedState.state == 2))
    {
      this.state = 4;
      return;
    }
    this.state = localSavedState.state;
  }

  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramV), this.state);
  }

  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.lastNestedScrollDy = 0;
    this.nestedScrolled = false;
    int i = paramInt1 & 0x2;
    boolean bool = false;
    if (i != 0)
      bool = true;
    return bool;
  }

  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    int i = 3;
    if (paramV.getTop() == getExpandedOffset())
      setStateInternal(i);
    while ((paramView != this.nestedScrollingChildRef.get()) || (!this.nestedScrolled))
      return;
    int j;
    if (this.lastNestedScrollDy > 0)
    {
      j = getExpandedOffset();
      if (!this.viewDragHelper.smoothSlideViewTo(paramV, paramV.getLeft(), j))
        break label293;
      setStateInternal(2);
      ViewCompat.postOnAnimation(paramV, new SettleRunnable(paramV, i));
    }
    while (true)
    {
      this.nestedScrolled = false;
      return;
      if ((this.hideable) && (shouldHide(paramV, getYVelocity())))
      {
        j = this.parentHeight;
        i = 5;
        break;
      }
      if (this.lastNestedScrollDy == 0)
      {
        int k = paramV.getTop();
        if (this.fitToContents)
        {
          if (Math.abs(k - this.fitToContentsOffset) < Math.abs(k - this.collapsedOffset))
          {
            j = this.fitToContentsOffset;
            break;
          }
          j = this.collapsedOffset;
          i = 4;
          break;
        }
        if (k < this.halfExpandedOffset)
        {
          if (k < Math.abs(k - this.collapsedOffset))
          {
            j = 0;
            break;
          }
          j = this.halfExpandedOffset;
          i = 6;
          break;
        }
        if (Math.abs(k - this.halfExpandedOffset) < Math.abs(k - this.collapsedOffset))
        {
          j = this.halfExpandedOffset;
          i = 6;
          break;
        }
        j = this.collapsedOffset;
        i = 4;
        break;
      }
      j = this.collapsedOffset;
      i = 4;
      break;
      label293: setStateInternal(i);
    }
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (!paramV.isShown())
      i = 0;
    do
    {
      int j;
      do
      {
        return i;
        j = paramMotionEvent.getActionMasked();
      }
      while ((this.state == i) && (j == 0));
      if (this.viewDragHelper != null)
        this.viewDragHelper.processTouchEvent(paramMotionEvent);
      if (j == 0)
        reset();
      if (this.velocityTracker == null)
        this.velocityTracker = VelocityTracker.obtain();
      this.velocityTracker.addMovement(paramMotionEvent);
      if ((j == 2) && (!this.ignoreEvents) && (Math.abs(this.initialY - paramMotionEvent.getY()) > this.viewDragHelper.getTouchSlop()))
        this.viewDragHelper.captureChildView(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    while (!this.ignoreEvents);
    return false;
  }

  public void setBottomSheetCallback(BottomSheetCallback paramBottomSheetCallback)
  {
    this.callback = paramBottomSheetCallback;
  }

  public void setFitToContents(boolean paramBoolean)
  {
    if (this.fitToContents == paramBoolean)
      return;
    this.fitToContents = paramBoolean;
    if (this.viewRef != null)
      calculateCollapsedOffset();
    if ((this.fitToContents) && (this.state == 6));
    for (int i = 3; ; i = this.state)
    {
      setStateInternal(i);
      return;
    }
  }

  public void setHideable(boolean paramBoolean)
  {
    this.hideable = paramBoolean;
  }

  public final void setPeekHeight(int paramInt)
  {
    boolean bool = true;
    if (paramInt == -1)
    {
      if (this.peekHeightAuto)
        break label100;
      this.peekHeightAuto = bool;
    }
    while (true)
    {
      if ((bool) && (this.state == 4) && (this.viewRef != null))
      {
        View localView = (View)this.viewRef.get();
        if (localView != null)
          localView.requestLayout();
      }
      return;
      if ((this.peekHeightAuto) || (this.peekHeight != paramInt))
      {
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, paramInt);
        this.collapsedOffset = (this.parentHeight - paramInt);
      }
      else
      {
        label100: bool = false;
      }
    }
  }

  public void setSkipCollapsed(boolean paramBoolean)
  {
    this.skipCollapsed = paramBoolean;
  }

  public final void setState(final int paramInt)
  {
    if (paramInt == this.state);
    final View localView;
    do
    {
      do
      {
        return;
        if (this.viewRef != null)
          break;
      }
      while ((paramInt != 4) && (paramInt != 3) && (paramInt != 6) && ((!this.hideable) || (paramInt != 5)));
      this.state = paramInt;
      return;
      localView = (View)this.viewRef.get();
    }
    while (localView == null);
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(localView)))
    {
      localView.post(new Runnable()
      {
        public void run()
        {
          BottomSheetBehavior.this.startSettlingAnimation(localView, paramInt);
        }
      });
      return;
    }
    startSettlingAnimation(localView, paramInt);
  }

  void setStateInternal(int paramInt)
  {
    if (this.state == paramInt)
      return;
    this.state = paramInt;
    if ((paramInt == 6) || (paramInt == 3))
      updateImportantForAccessibility(true);
    while (true)
    {
      View localView = (View)this.viewRef.get();
      if ((localView == null) || (this.callback == null))
        break;
      this.callback.onStateChanged(localView, paramInt);
      return;
      if ((paramInt == 5) || (paramInt == 4))
        updateImportantForAccessibility(false);
    }
  }

  boolean shouldHide(View paramView, float paramFloat)
  {
    if (this.skipCollapsed);
    do
    {
      return true;
      if (paramView.getTop() < this.collapsedOffset)
        return false;
    }
    while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.collapsedOffset) / this.peekHeight > 0.5F);
    return false;
  }

  void startSettlingAnimation(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4)
      i = this.collapsedOffset;
    while (this.viewDragHelper.smoothSlideViewTo(paramView, paramView.getLeft(), i))
    {
      setStateInternal(2);
      ViewCompat.postOnAnimation(paramView, new SettleRunnable(paramView, paramInt));
      return;
      if (paramInt == 6)
      {
        i = this.halfExpandedOffset;
        if ((this.fitToContents) && (i <= this.fitToContentsOffset))
        {
          i = this.fitToContentsOffset;
          paramInt = 3;
        }
      }
      else if (paramInt == 3)
      {
        i = getExpandedOffset();
      }
      else if ((this.hideable) && (paramInt == 5))
      {
        i = this.parentHeight;
      }
      else
      {
        throw new IllegalArgumentException("Illegal state argument: " + paramInt);
      }
    }
    setStateInternal(paramInt);
  }

  public static abstract class BottomSheetCallback
  {
    public abstract void onSlide(View paramView, float paramFloat);

    public abstract void onStateChanged(View paramView, int paramInt);
  }

  protected static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, null);
      }

      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public BottomSheetBehavior.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomSheetBehavior.SavedState[paramAnonymousInt];
      }
    };
    final int state;

    public SavedState(Parcel paramParcel)
    {
      this(paramParcel, null);
    }

    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.state = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
    }
  }

  private class SettleRunnable
    implements Runnable
  {
    private final int targetState;
    private final View view;

    SettleRunnable(View paramInt, int arg3)
    {
      this.view = paramInt;
      int i;
      this.targetState = i;
    }

    public void run()
    {
      if ((BottomSheetBehavior.this.viewDragHelper != null) && (BottomSheetBehavior.this.viewDragHelper.continueSettling(true)))
      {
        ViewCompat.postOnAnimation(this.view, this);
        return;
      }
      BottomSheetBehavior.this.setStateInternal(this.targetState);
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface State
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.6.2
 */