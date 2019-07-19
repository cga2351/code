package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.recyclerview.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup
  implements NestedScrollingChild2, ScrollingView
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
  static final boolean ALLOW_THREAD_GAP_WORK = false;
  private static final int[] CLIP_TO_PADDING_ATTR;
  static final boolean DEBUG = false;
  static final int DEFAULT_ORIENTATION = 1;
  static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
  static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
  static final long FOREVER_NS = 9223372036854775807L;
  public static final int HORIZONTAL = 0;
  private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  static final int MAX_SCROLL_DURATION = 2000;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  static final boolean POST_UPDATES_ON_ANIMATION = false;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  static final String TRACE_PREFETCH_TAG = "RV Prefetch";
  static final String TRACE_SCROLL_TAG = "RV Scroll";
  static final boolean VERBOSE_TRACING = false;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator;
  RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private OnItemTouchListener mActiveOnItemTouchListener;
  Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  private EdgeEffect mBottomGlow;
  private ChildDrawingOrderCallback mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  boolean mDispatchItemsChangedEvent = false;
  private int mDispatchScrollCounter = 0;
  private int mEatenAccessibilityChangeFlags;
  private EdgeEffectFactory mEdgeEffectFactory = new EdgeEffectFactory();
  boolean mEnableFastScroller;
  boolean mFirstLayoutComplete;
  GapWorker mGapWorker;
  boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mInterceptRequestLayoutDepth = 0;
  boolean mIsAttached;
  ItemAnimator mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  LayoutManager mLayout;
  boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutWasDefered;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerViewDataObserver mObserver = new RecyclerViewDataObserver();
  private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  private OnFlingListener mOnFlingListener;
  private final ArrayList<OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  final List<ViewHolder> mPendingAccessibilityImportanceChange;
  private SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
  private boolean mPreserveFocusAfterLayout;
  final Recycler mRecycler = new Recycler();
  RecyclerListener mRecyclerListener;
  private EdgeEffect mRightGlow;
  private float mScaledHorizontalScrollFactor = 1.4E-45F;
  private float mScaledVerticalScrollFactor = 1.4E-45F;
  final int[] mScrollConsumed;
  private OnScrollListener mScrollListener;
  private List<OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  final int[] mScrollStepConsumed;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final State mState;
  final Rect mTempRect = new Rect();
  private final Rect mTempRect2 = new Rect();
  final RectF mTempRectF = new RectF();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new Runnable()
  {
    public void run()
    {
      if ((!RecyclerView.this.mFirstLayoutComplete) || (RecyclerView.this.isLayoutRequested()))
        return;
      if (!RecyclerView.this.mIsAttached)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.mLayoutFrozen)
      {
        RecyclerView.this.mLayoutWasDefered = true;
        return;
      }
      RecyclerView.this.consumePendingUpdateOperations();
    }
  };
  private VelocityTracker mVelocityTracker;
  final ViewFlinger mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();

  static
  {
    CLIP_TO_PADDING_ATTR = new int[] { 16842987 };
    boolean bool1;
    boolean bool2;
    label62: boolean bool3;
    label76: boolean bool4;
    label90: boolean bool5;
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool1 = true;
      FORCE_INVALIDATE_DISPLAY_LIST = bool1;
      if (Build.VERSION.SDK_INT < 23)
        break label179;
      bool2 = true;
      ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool2;
      if (Build.VERSION.SDK_INT < 16)
        break label184;
      bool3 = true;
      POST_UPDATES_ON_ANIMATION = bool3;
      if (Build.VERSION.SDK_INT < 21)
        break label189;
      bool4 = true;
      ALLOW_THREAD_GAP_WORK = bool4;
      if (Build.VERSION.SDK_INT > 15)
        break label194;
      bool5 = true;
      label105: FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool5;
      if (Build.VERSION.SDK_INT > 15)
        break label200;
    }
    label179: label184: label189: label194: label200: for (boolean bool6 = true; ; bool6 = false)
    {
      IGNORE_DETACHED_FOCUSED_CHILD = bool6;
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = AttributeSet.class;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Integer.TYPE;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = arrayOfClass;
      sQuinticInterpolator = new Interpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          float f = paramAnonymousFloat - 1.0F;
          return 1.0F + f * (f * (f * (f * f)));
        }
      };
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label62;
      bool3 = false;
      break label76;
      bool4 = false;
      break label90;
      bool5 = false;
      break label105;
    }
  }

  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPreserveFocusAfterLayout = i;
    this.mViewFlinger = new ViewFlinger();
    GapWorker.LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl;
    label363: boolean bool;
    if (ALLOW_THREAD_GAP_WORK)
    {
      localLayoutPrefetchRegistryImpl = new GapWorker.LayoutPrefetchRegistryImpl();
      this.mPrefetchRegistry = localLayoutPrefetchRegistryImpl;
      this.mState = new State();
      this.mItemsAddedOrRemoved = false;
      this.mItemsChanged = false;
      this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
      this.mPostedAnimatorRunner = false;
      this.mMinMaxLayoutPositions = new int[2];
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.mNestedOffsets = new int[2];
      this.mScrollStepConsumed = new int[2];
      this.mPendingAccessibilityImportanceChange = new ArrayList();
      this.mItemAnimatorRunner = new Runnable()
      {
        public void run()
        {
          if (RecyclerView.this.mItemAnimator != null)
            RecyclerView.this.mItemAnimator.runPendingAnimations();
          RecyclerView.this.mPostedAnimatorRunner = false;
        }
      };
      this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback()
      {
        public void processAppeared(RecyclerView.ViewHolder paramAnonymousViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
        {
          RecyclerView.this.animateAppearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
        }

        public void processDisappeared(RecyclerView.ViewHolder paramAnonymousViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
        {
          RecyclerView.this.mRecycler.unscrapView(paramAnonymousViewHolder);
          RecyclerView.this.animateDisappearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
        }

        public void processPersistent(RecyclerView.ViewHolder paramAnonymousViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
        {
          paramAnonymousViewHolder.setIsRecyclable(false);
          if (RecyclerView.this.mDataSetHasChangedAfterLayout)
            if (RecyclerView.this.mItemAnimator.animateChange(paramAnonymousViewHolder, paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2))
              RecyclerView.this.postAnimationRunner();
          while (!RecyclerView.this.mItemAnimator.animatePersistence(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2))
            return;
          RecyclerView.this.postAnimationRunner();
        }

        public void unused(RecyclerView.ViewHolder paramAnonymousViewHolder)
        {
          RecyclerView.this.mLayout.removeAndRecycleView(paramAnonymousViewHolder.itemView, RecyclerView.this.mRecycler);
        }
      };
      if (paramAttributeSet == null)
        break label682;
      TypedArray localTypedArray3 = paramContext.obtainStyledAttributes(paramAttributeSet, CLIP_TO_PADDING_ATTR, paramInt, 0);
      this.mClipToPadding = localTypedArray3.getBoolean(0, i);
      localTypedArray3.recycle();
      setScrollContainer(i);
      setFocusableInTouchMode(i);
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(localViewConfiguration, paramContext);
      this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(localViewConfiguration, paramContext);
      this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2)
        break label691;
      int j = i;
      label440: setWillNotDraw(j);
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
      initAdapterManager();
      initChildrenHelper();
      initAutofill();
      if (ViewCompat.getImportantForAccessibility(this) == 0)
        ViewCompat.setImportantForAccessibility(this, i);
      this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
      if (paramAttributeSet == null)
        break label697;
      TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
      String str = localTypedArray1.getString(R.styleable.RecyclerView_layoutManager);
      if (localTypedArray1.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1)
        setDescendantFocusability(262144);
      this.mEnableFastScroller = localTypedArray1.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
      if (this.mEnableFastScroller)
        initFastScroller((StateListDrawable)localTypedArray1.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), localTypedArray1.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)localTypedArray1.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), localTypedArray1.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
      localTypedArray1.recycle();
      createLayoutManager(paramContext, str, paramAttributeSet, paramInt, 0);
      if (Build.VERSION.SDK_INT >= 21)
      {
        TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, NESTED_SCROLLING_ATTRS, paramInt, 0);
        bool = localTypedArray2.getBoolean(0, i);
        localTypedArray2.recycle();
      }
    }
    while (true)
    {
      setNestedScrollingEnabled(bool);
      return;
      localLayoutPrefetchRegistryImpl = null;
      break;
      label682: this.mClipToPadding = bool;
      break label363;
      label691: int k = 0;
      break label440;
      label697: setDescendantFocusability(262144);
    }
  }

  private void addAnimatingView(ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    if (localView.getParent() == this);
    for (int i = 1; ; i = 0)
    {
      this.mRecycler.unscrapView(getChildViewHolder(localView));
      if (!paramViewHolder.isTmpDetached())
        break;
      this.mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.addView(localView, true);
      return;
    }
    this.mChildHelper.hide(localView);
  }

  private void animateChange(ViewHolder paramViewHolder1, ViewHolder paramViewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1)
      addAnimatingView(paramViewHolder1);
    if (paramViewHolder1 != paramViewHolder2)
    {
      if (paramBoolean2)
        addAnimatingView(paramViewHolder2);
      paramViewHolder1.mShadowedHolder = paramViewHolder2;
      addAnimatingView(paramViewHolder1);
      this.mRecycler.unscrapView(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    }
    if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner();
  }

  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }

  static void clearNestedRecyclerViewIfNotNested(ViewHolder paramViewHolder)
  {
    View localView;
    if (paramViewHolder.mNestedRecyclerView != null)
      localView = (View)paramViewHolder.mNestedRecyclerView.get();
    while (localView != null)
    {
      if (localView == paramViewHolder.itemView)
        return;
      ViewParent localViewParent = localView.getParent();
      if ((localViewParent instanceof View))
        localView = (View)localViewParent;
      else
        localView = null;
    }
    paramViewHolder.mNestedRecyclerView = null;
  }

  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      String str1 = paramString.trim();
      if (!str1.isEmpty())
      {
        String str2 = getFullClassName(paramContext, str1);
        try
        {
          Object localObject1;
          if (isInEditMode())
            localObject1 = getClass().getClassLoader();
          while (true)
          {
            Class localClass = ((ClassLoader)localObject1).loadClass(str2).asSubclass(LayoutManager.class);
            try
            {
              Constructor localConstructor2 = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
              arrayOfObject = new Object[4];
              arrayOfObject[0] = paramContext;
              arrayOfObject[1] = paramAttributeSet;
              arrayOfObject[2] = Integer.valueOf(paramInt1);
              arrayOfObject[3] = Integer.valueOf(paramInt2);
              localObject2 = localConstructor2;
              ((Constructor)localObject2).setAccessible(true);
              setLayoutManager((LayoutManager)((Constructor)localObject2).newInstance(arrayOfObject));
              return;
              ClassLoader localClassLoader = paramContext.getClassLoader();
              localObject1 = localClassLoader;
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              try
              {
                Constructor localConstructor1 = localClass.getConstructor(new Class[0]);
                Object localObject2 = localConstructor1;
                Object[] arrayOfObject = null;
              }
              catch (NoSuchMethodException localNoSuchMethodException2)
              {
                localNoSuchMethodException2.initCause(localNoSuchMethodException1);
                throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + str2, localNoSuchMethodException2);
              }
            }
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str2, localClassNotFoundException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str2, localInvocationTargetException);
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str2, localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str2, localIllegalAccessException);
        }
        catch (ClassCastException localClassCastException)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str2, localClassCastException);
        }
      }
    }
  }

  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    boolean bool;
    if (this.mMinMaxLayoutPositions[0] == paramInt1)
    {
      int i = this.mMinMaxLayoutPositions[1];
      bool = false;
      if (i == paramInt2);
    }
    else
    {
      bool = true;
    }
    return bool;
  }

  private void dispatchContentChangedIfNecessary()
  {
    int i = this.mEatenAccessibilityChangeFlags;
    this.mEatenAccessibilityChangeFlags = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }

  private void dispatchLayoutStep1()
  {
    int i = 1;
    this.mState.assertLayoutStep(i);
    fillRemainingScrollValues(this.mState);
    this.mState.mIsMeasuring = false;
    startInterceptRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    State localState = this.mState;
    int n;
    label144: ViewHolder localViewHolder2;
    if ((this.mState.mRunSimpleAnimations) && (this.mItemsChanged))
    {
      localState.mTrackOldChangeHolders = i;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
      this.mState.mItemCount = this.mAdapter.getItemCount();
      findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if (!this.mState.mRunSimpleAnimations)
        break label302;
      int m = this.mChildHelper.getChildCount();
      n = 0;
      if (n >= m)
        break label302;
      localViewHolder2 = getChildViewHolderInt(this.mChildHelper.getChildAt(n));
      if ((!localViewHolder2.shouldIgnore()) && ((!localViewHolder2.isInvalid()) || (this.mAdapter.hasStableIds())))
        break label202;
    }
    while (true)
    {
      n++;
      break label144;
      i = 0;
      break;
      label202: RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mItemAnimator.recordPreLayoutInformation(this.mState, localViewHolder2, ItemAnimator.buildAdapterChangeFlagsForAnimations(localViewHolder2), localViewHolder2.getUnmodifiedPayloads());
      this.mViewInfoStore.addToPreLayout(localViewHolder2, localItemHolderInfo2);
      if ((this.mState.mTrackOldChangeHolders) && (localViewHolder2.isUpdated()) && (!localViewHolder2.isRemoved()) && (!localViewHolder2.shouldIgnore()) && (!localViewHolder2.isInvalid()))
      {
        long l = getChangedHolderKey(localViewHolder2);
        this.mViewInfoStore.addToOldChangeHolders(l, localViewHolder2);
      }
    }
    label302: if (this.mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      boolean bool1 = this.mState.mStructureChanged;
      this.mState.mStructureChanged = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      this.mState.mStructureChanged = bool1;
      int j = 0;
      if (j < this.mChildHelper.getChildCount())
      {
        ViewHolder localViewHolder1 = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
        if (localViewHolder1.shouldIgnore());
        while (true)
        {
          j++;
          break;
          if (!this.mViewInfoStore.isInPreLayout(localViewHolder1))
          {
            int k = ItemAnimator.buildAdapterChangeFlagsForAnimations(localViewHolder1);
            boolean bool2 = localViewHolder1.hasAnyOfTheFlags(8192);
            if (!bool2)
              k |= 4096;
            RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mItemAnimator.recordPreLayoutInformation(this.mState, localViewHolder1, k, localViewHolder1.getUnmodifiedPayloads());
            if (bool2)
              recordAnimationInfoIfBouncedHiddenView(localViewHolder1, localItemHolderInfo1);
            else
              this.mViewInfoStore.addToAppearedInPreLayoutHolders(localViewHolder1, localItemHolderInfo1);
          }
        }
      }
      clearOldPositions();
    }
    while (true)
    {
      onExitLayoutOrScroll();
      stopInterceptRequestLayout(false);
      this.mState.mLayoutStep = 2;
      return;
      clearOldPositions();
    }
  }

  private void dispatchLayoutStep2()
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    this.mState.mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    this.mState.mStructureChanged = false;
    this.mPendingSavedState = null;
    State localState = this.mState;
    if ((this.mState.mRunSimpleAnimations) && (this.mItemAnimator != null));
    for (boolean bool = true; ; bool = false)
    {
      localState.mRunSimpleAnimations = bool;
      this.mState.mLayoutStep = 4;
      onExitLayoutOrScroll();
      stopInterceptRequestLayout(false);
      return;
    }
  }

  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.mLayoutStep = 1;
    if (this.mState.mRunSimpleAnimations)
    {
      int i = -1 + this.mChildHelper.getChildCount();
      if (i >= 0)
      {
        ViewHolder localViewHolder1 = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (localViewHolder1.shouldIgnore());
        while (true)
        {
          i--;
          break;
          long l = getChangedHolderKey(localViewHolder1);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mItemAnimator.recordPostLayoutInformation(this.mState, localViewHolder1);
          ViewHolder localViewHolder2 = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder2 != null) && (!localViewHolder2.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder2);
            boolean bool2 = this.mViewInfoStore.isDisappearing(localViewHolder1);
            if ((bool1) && (localViewHolder2 == localViewHolder1))
            {
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo1);
            }
            else
            {
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mViewInfoStore.popFromPreLayout(localViewHolder2);
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo1);
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo3 = this.mViewInfoStore.popFromPostLayout(localViewHolder1);
              if (localItemHolderInfo2 == null)
                handleMissingPreInfoForChangeError(l, localViewHolder1, localViewHolder2);
              else
                animateChange(localViewHolder2, localViewHolder1, localItemHolderInfo2, localItemHolderInfo3, bool1, bool2);
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo1);
          }
        }
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
    this.mDataSetHasChangedAfterLayout = false;
    this.mDispatchItemsChangedEvent = false;
    this.mState.mRunSimpleAnimations = false;
    this.mState.mRunPredictiveAnimations = false;
    this.mLayout.mRequestedSimpleAnimations = false;
    if (this.mRecycler.mChangedScrap != null)
      this.mRecycler.mChangedScrap.clear();
    if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.mLayout.mPrefetchMaxCountObserved = 0;
      this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
      this.mRecycler.updateViewCacheSize();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mViewInfoStore.clear();
    if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1]))
      dispatchOnScrolled(0, 0);
    recoverFocusFromState();
    resetFocusInfo();
  }

  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j;
    if (this.mActiveOnItemTouchListener != null)
    {
      if (i == 0)
        this.mActiveOnItemTouchListener = null;
    }
    else
    {
      if (i == 0)
        break label110;
      j = this.mOnItemTouchListeners.size();
    }
    for (int k = 0; k < j; k++)
    {
      OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)this.mOnItemTouchListeners.get(k);
      if (localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
        this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1))
          this.mActiveOnItemTouchListener = null;
        return true;
      }
    }
    label110: return false;
  }

  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 0))
      this.mActiveOnItemTouchListener = null;
    int j = this.mOnItemTouchListeners.size();
    for (int k = 0; k < j; k++)
    {
      OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)this.mOnItemTouchListeners.get(k);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (i != 3))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
    }
    return false;
  }

  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i = this.mChildHelper.getChildCount();
    if (i == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int j = 2147483647;
    int k = -2147483648;
    int m = 0;
    ViewHolder localViewHolder;
    int i1;
    if (m < i)
    {
      localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(m));
      if (localViewHolder.shouldIgnore())
        i1 = j;
    }
    while (true)
    {
      m++;
      j = i1;
      break;
      int n = localViewHolder.getLayoutPosition();
      if (n < j)
        j = n;
      if (n > k)
      {
        k = n;
        i1 = j;
        continue;
        paramArrayOfInt[0] = j;
        paramArrayOfInt[1] = k;
      }
      else
      {
        i1 = j;
      }
    }
  }

  static RecyclerView findNestedRecyclerView(View paramView)
  {
    if (!(paramView instanceof ViewGroup))
      return null;
    if ((paramView instanceof RecyclerView))
      return (RecyclerView)paramView;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i = localViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView localRecyclerView = findNestedRecyclerView(localViewGroup.getChildAt(j));
      if (localRecyclerView != null)
        return localRecyclerView;
    }
    return null;
  }

  private View findNextViewToFocus()
  {
    int i;
    int j;
    int k;
    label29: ViewHolder localViewHolder2;
    if (this.mState.mFocusedItemPosition != -1)
    {
      i = this.mState.mFocusedItemPosition;
      j = this.mState.getItemCount();
      k = i;
      if (k < j)
      {
        localViewHolder2 = findViewHolderForAdapterPosition(k);
        if (localViewHolder2 != null)
          break label80;
      }
    }
    for (int m = -1 + Math.min(j, i); ; m--)
    {
      if (m < 0)
        break label126;
      ViewHolder localViewHolder1 = findViewHolderForAdapterPosition(m);
      if (localViewHolder1 == null)
      {
        return null;
        i = 0;
        break;
        label80: if (localViewHolder2.itemView.hasFocusable())
          return localViewHolder2.itemView;
        k++;
        break label29;
      }
      if (localViewHolder1.itemView.hasFocusable())
        return localViewHolder1.itemView;
    }
    label126: return null;
  }

  static ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null)
      return null;
    return ((LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }

  static void getDecoratedBoundsWithMarginsInt(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramRect.set(paramView.getLeft() - localRect.left - localLayoutParams.leftMargin, paramView.getTop() - localRect.top - localLayoutParams.topMargin, paramView.getRight() + localRect.right + localLayoutParams.rightMargin, paramView.getBottom() + localRect.bottom + localLayoutParams.bottomMargin);
  }

  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    Object localObject = paramView;
    View localView;
    if ((!((View)localObject).isFocused()) && ((localObject instanceof ViewGroup)) && (((View)localObject).hasFocus()))
    {
      localView = ((ViewGroup)localObject).getFocusedChild();
      if (localView.getId() == -1)
        break label64;
    }
    label64: for (int j = localView.getId(); ; j = i)
    {
      i = j;
      localObject = localView;
      break;
      return i;
    }
  }

  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
      paramString = paramContext.getPackageName() + paramString;
    while (paramString.contains("."))
      return paramString;
    return RecyclerView.class.getPackage().getName() + '.' + paramString;
  }

  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null)
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    return this.mScrollingChildHelper;
  }

  private void handleMissingPreInfoForChangeError(long paramLong, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2)
  {
    int i = this.mChildHelper.getChildCount();
    int j = 0;
    if (j < i)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
      if (localViewHolder == paramViewHolder1);
      while (getChangedHolderKey(localViewHolder) != paramLong)
      {
        j++;
        break;
      }
      if ((this.mAdapter != null) && (this.mAdapter.hasStableIds()))
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localViewHolder + " \n View Holder 2:" + paramViewHolder1 + exceptionLabel());
      throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localViewHolder + " \n View Holder 2:" + paramViewHolder1 + exceptionLabel());
    }
    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + paramViewHolder2 + " cannot be found but it is necessary for " + paramViewHolder1 + exceptionLabel());
  }

  private boolean hasUpdatedView()
  {
    int i = this.mChildHelper.getChildCount();
    int j = 0;
    boolean bool = false;
    if (j < i)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore()));
      while (!localViewHolder.isUpdated())
      {
        j++;
        break;
      }
      bool = true;
    }
    return bool;
  }

  @SuppressLint({"InlinedApi"})
  private void initAutofill()
  {
    if (ViewCompat.getImportantForAutofill(this) == 0)
      ViewCompat.setImportantForAutofill(this, 8);
  }

  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new ChildHelper.Callback()
    {
      public void addView(View paramAnonymousView, int paramAnonymousInt)
      {
        RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
        RecyclerView.this.dispatchChildAttached(paramAnonymousView);
      }

      public void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localViewHolder != null)
        {
          if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + localViewHolder + RecyclerView.this.exceptionLabel());
          localViewHolder.clearTmpDetachFlag();
        }
        RecyclerView.this.attachViewToParent(paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }

      public void detachViewFromParent(int paramAnonymousInt)
      {
        View localView = getChildAt(paramAnonymousInt);
        if (localView != null)
        {
          RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
          if (localViewHolder != null)
          {
            if ((localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
              throw new IllegalArgumentException("called detach on an already detached child " + localViewHolder + RecyclerView.this.exceptionLabel());
            localViewHolder.addFlags(256);
          }
        }
        RecyclerView.this.detachViewFromParent(paramAnonymousInt);
      }

      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.this.getChildAt(paramAnonymousInt);
      }

      public int getChildCount()
      {
        return RecyclerView.this.getChildCount();
      }

      public RecyclerView.ViewHolder getChildViewHolder(View paramAnonymousView)
      {
        return RecyclerView.getChildViewHolderInt(paramAnonymousView);
      }

      public int indexOfChild(View paramAnonymousView)
      {
        return RecyclerView.this.indexOfChild(paramAnonymousView);
      }

      public void onEnteredHiddenState(View paramAnonymousView)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localViewHolder != null)
          localViewHolder.onEnteredHiddenState(RecyclerView.this);
      }

      public void onLeftHiddenState(View paramAnonymousView)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localViewHolder != null)
          localViewHolder.onLeftHiddenState(RecyclerView.this);
      }

      public void removeAllViews()
      {
        int i = getChildCount();
        for (int j = 0; j < i; j++)
        {
          View localView = getChildAt(j);
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeAllViews();
      }

      public void removeViewAt(int paramAnonymousInt)
      {
        View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
        if (localView != null)
        {
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeViewAt(paramAnonymousInt);
      }
    });
  }

  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt)
  {
    int i = -1;
    int j = 1;
    if ((paramView2 == null) || (paramView2 == this))
      j = 0;
    do
    {
      return j;
      if (findContainingItemView(paramView2) == null)
        return false;
    }
    while ((paramView1 == null) || (findContainingItemView(paramView1) == null));
    this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
    this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
    offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
    offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
    int k;
    label111: int m;
    if (this.mLayout.getLayoutDirection() == j)
    {
      k = i;
      if (((this.mTempRect.left >= this.mTempRect2.left) && (this.mTempRect.right > this.mTempRect2.left)) || (this.mTempRect.right >= this.mTempRect2.right))
        break label322;
      m = j;
    }
    while (true)
    {
      label166: if (((this.mTempRect.top < this.mTempRect2.top) || (this.mTempRect.bottom <= this.mTempRect2.top)) && (this.mTempRect.bottom < this.mTempRect2.bottom));
      for (i = j; ; i = 0)
        label322: 
        do
          switch (paramInt)
          {
          default:
            throw new IllegalArgumentException("Invalid direction: " + paramInt + exceptionLabel());
            k = j;
            break label111;
            if (((this.mTempRect.right <= this.mTempRect2.right) && (this.mTempRect.left < this.mTempRect2.right)) || (this.mTempRect.left <= this.mTempRect2.left))
              break label535;
            m = i;
            break label166;
          case 17:
          case 66:
          case 33:
          case 130:
          case 2:
          case 1:
          }
        while (((this.mTempRect.bottom > this.mTempRect2.bottom) || (this.mTempRect.top >= this.mTempRect2.bottom)) && (this.mTempRect.top > this.mTempRect2.top));
      if (m < 0)
        break;
      return false;
      if (m > 0)
        break;
      return false;
      if (i < 0)
        break;
      return false;
      if (i > 0)
        break;
      return false;
      boolean bool2;
      if (i <= 0)
      {
        bool2 = false;
        if (i == 0)
        {
          int i2 = k * m;
          bool2 = false;
          if (i2 < 0);
        }
      }
      else
      {
        bool2 = j;
      }
      return bool2;
      boolean bool1;
      if (i >= 0)
      {
        bool1 = false;
        if (i == 0)
        {
          int i1 = k * m;
          bool1 = false;
          if (i1 > 0);
        }
      }
      else
      {
        bool1 = j;
      }
      return bool1;
      label535: int n = 0;
    }
  }

  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId)
      if (i != 0)
        break label81;
    label81: for (int j = 1; ; j = 0)
    {
      this.mScrollPointerId = paramMotionEvent.getPointerId(j);
      int k = (int)(0.5F + paramMotionEvent.getX(j));
      this.mLastTouchX = k;
      this.mInitialTouchX = k;
      int m = (int)(0.5F + paramMotionEvent.getY(j));
      this.mLastTouchY = m;
      this.mInitialTouchY = m;
      return;
    }
  }

  private boolean predictiveItemAnimationsEnabled()
  {
    return (this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations());
  }

  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    boolean bool1 = true;
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      if (this.mDispatchItemsChangedEvent)
        this.mLayout.onItemsChanged(this);
    }
    int i;
    label61: boolean bool2;
    label121: State localState2;
    if (predictiveItemAnimationsEnabled())
    {
      this.mAdapterHelper.preProcess();
      if ((!this.mItemsAddedOrRemoved) && (!this.mItemsChanged))
        break label178;
      i = bool1;
      State localState1 = this.mState;
      if ((!this.mFirstLayoutComplete) || (this.mItemAnimator == null) || ((!this.mDataSetHasChangedAfterLayout) && (i == 0) && (!this.mLayout.mRequestedSimpleAnimations)) || ((this.mDataSetHasChangedAfterLayout) && (!this.mAdapter.hasStableIds())))
        break label183;
      bool2 = bool1;
      localState1.mRunSimpleAnimations = bool2;
      localState2 = this.mState;
      if ((!this.mState.mRunSimpleAnimations) || (i == 0) || (this.mDataSetHasChangedAfterLayout) || (!predictiveItemAnimationsEnabled()))
        break label189;
    }
    while (true)
    {
      localState2.mRunPredictiveAnimations = bool1;
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      break;
      label178: i = 0;
      break label61;
      label183: bool2 = false;
      break label121;
      label189: bool1 = false;
    }
  }

  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = 1;
    int j;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      j = i;
      if (paramFloat4 >= 0.0F)
        break label143;
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
    }
    while (true)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F))
        ViewCompat.postInvalidateOnAnimation(this);
      return;
      boolean bool = paramFloat2 < 0.0F;
      j = 0;
      if (!bool)
        break;
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      j = i;
      break;
      label143: if (paramFloat4 > 0.0F)
      {
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      }
      else
      {
        i = j;
      }
    }
  }

  private void recoverFocusFromState()
  {
    if ((!this.mPreserveFocusAfterLayout) || (this.mAdapter == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused())));
    View localView3;
    do
    {
      return;
      if (isFocused())
        break;
      localView3 = getFocusedChild();
      if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((localView3.getParent() == null) || (!localView3.hasFocus())))
      {
        if (this.mChildHelper.getChildCount() != 0)
          break;
        requestFocus();
        return;
      }
    }
    while (!this.mChildHelper.isHidden(localView3));
    if ((this.mState.mFocusedItemId != -1L) && (this.mAdapter.hasStableIds()));
    for (ViewHolder localViewHolder = findViewHolderForItemId(this.mState.mFocusedItemId); ; localViewHolder = null)
    {
      View localView1;
      label195: View localView2;
      if ((localViewHolder == null) || (this.mChildHelper.isHidden(localViewHolder.itemView)) || (!localViewHolder.itemView.hasFocusable()))
      {
        int i = this.mChildHelper.getChildCount();
        localView1 = null;
        if (i > 0)
          localView1 = findNextViewToFocus();
        if (localView1 == null)
          break label253;
        if (this.mState.mFocusedSubChildId == -1L)
          break label255;
        localView2 = localView1.findViewById(this.mState.mFocusedSubChildId);
        if ((localView2 == null) || (!localView2.isFocusable()))
          break label255;
      }
      while (true)
      {
        localView2.requestFocus();
        return;
        localView1 = localViewHolder.itemView;
        break label195;
        label253: break;
        label255: localView2 = localView1;
      }
    }
  }

  private void releaseGlows()
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    boolean bool = false;
    if (localEdgeEffect != null)
    {
      this.mLeftGlow.onRelease();
      bool = this.mLeftGlow.isFinished();
    }
    if (this.mTopGlow != null)
    {
      this.mTopGlow.onRelease();
      bool |= this.mTopGlow.isFinished();
    }
    if (this.mRightGlow != null)
    {
      this.mRightGlow.onRelease();
      bool |= this.mRightGlow.isFinished();
    }
    if (this.mBottomGlow != null)
    {
      this.mBottomGlow.onRelease();
      bool |= this.mBottomGlow.isFinished();
    }
    if (bool)
      ViewCompat.postInvalidateOnAnimation(this);
  }

  private void requestChildOnScreen(View paramView1, View paramView2)
  {
    boolean bool1 = true;
    View localView;
    LayoutManager localLayoutManager;
    Rect localRect1;
    boolean bool2;
    if (paramView2 != null)
    {
      localView = paramView2;
      this.mTempRect.set(0, 0, localView.getWidth(), localView.getHeight());
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if ((localLayoutParams instanceof LayoutParams))
      {
        LayoutParams localLayoutParams1 = (LayoutParams)localLayoutParams;
        if (!localLayoutParams1.mInsetsDirty)
        {
          Rect localRect2 = localLayoutParams1.mDecorInsets;
          Rect localRect3 = this.mTempRect;
          localRect3.left -= localRect2.left;
          Rect localRect4 = this.mTempRect;
          localRect4.right += localRect2.right;
          Rect localRect5 = this.mTempRect;
          localRect5.top -= localRect2.top;
          Rect localRect6 = this.mTempRect;
          localRect6.bottom += localRect2.bottom;
        }
      }
      if (paramView2 != null)
      {
        offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
        offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      }
      localLayoutManager = this.mLayout;
      localRect1 = this.mTempRect;
      if (this.mFirstLayoutComplete)
        break label221;
      bool2 = bool1;
      label197: if (paramView2 != null)
        break label227;
    }
    while (true)
    {
      localLayoutManager.requestChildRectangleOnScreen(this, paramView1, localRect1, bool2, bool1);
      return;
      localView = paramView1;
      break;
      label221: bool2 = false;
      break label197;
      label227: bool1 = false;
    }
  }

  private void resetFocusInfo()
  {
    this.mState.mFocusedItemId = -1L;
    this.mState.mFocusedItemPosition = -1;
    this.mState.mFocusedSubChildId = -1;
  }

  private void resetTouch()
  {
    if (this.mVelocityTracker != null)
      this.mVelocityTracker.clear();
    stopNestedScroll(0);
    releaseGlows();
  }

  private void saveFocusInfo()
  {
    if ((this.mPreserveFocusAfterLayout) && (hasFocus()) && (this.mAdapter != null));
    for (View localView = getFocusedChild(); ; localView = null)
    {
      if (localView == null);
      for (ViewHolder localViewHolder = null; localViewHolder == null; localViewHolder = findContainingViewHolder(localView))
      {
        resetFocusInfo();
        return;
      }
      State localState1 = this.mState;
      long l;
      State localState2;
      int i;
      if (this.mAdapter.hasStableIds())
      {
        l = localViewHolder.getItemId();
        localState1.mFocusedItemId = l;
        localState2 = this.mState;
        if (!this.mDataSetHasChangedAfterLayout)
          break label124;
        i = -1;
      }
      while (true)
      {
        localState2.mFocusedItemPosition = i;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(localViewHolder.itemView);
        return;
        l = -1L;
        break;
        label124: if (localViewHolder.isRemoved())
          i = localViewHolder.mOldPosition;
        else
          i = localViewHolder.getAdapterPosition();
      }
    }
  }

  private void setAdapterInternal(Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2))
      removeAndRecycleViews();
    this.mAdapterHelper.reset();
    Adapter localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    if (this.mLayout != null)
      this.mLayout.onAdapterChanged(localAdapter, this.mAdapter);
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    this.mState.mStructureChanged = true;
  }

  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    if (this.mLayout != null)
      this.mLayout.stopSmoothScroller();
  }

  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
      if (paramInt2 >= 0)
        break label66;
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    }
    while (true)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
        ViewCompat.postInvalidateOnAnimation(this);
      return;
      if (paramInt1 <= 0)
        break;
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
      break;
      label66: if (paramInt2 > 0)
      {
        ensureBottomGlow();
        this.mBottomGlow.onAbsorb(paramInt2);
      }
    }
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.mLayout == null) || (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2)))
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }

  public void addItemDecoration(ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }

  public void addItemDecoration(ItemDecoration paramItemDecoration, int paramInt)
  {
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    if (this.mItemDecorations.isEmpty())
      setWillNotDraw(false);
    if (paramInt < 0)
      this.mItemDecorations.add(paramItemDecoration);
    while (true)
    {
      markItemDecorInsetsDirty();
      requestLayout();
      return;
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
  }

  public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null)
      this.mOnChildAttachStateListeners = new ArrayList();
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }

  public void addOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }

  public void addOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners == null)
      this.mScrollListeners = new ArrayList();
    this.mScrollListeners.add(paramOnScrollListener);
  }

  void animateAppearance(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner();
  }

  void animateDisappearance(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner();
  }

  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null)
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
      throw new IllegalStateException(paramString + exceptionLabel());
    }
  }

  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null)
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0)
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
  }

  boolean canReuseUpdatedViewHolder(ViewHolder paramViewHolder)
  {
    return (this.mItemAnimator == null) || (this.mItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.mLayout.checkLayoutParams((LayoutParams)paramLayoutParams));
  }

  void clearOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore())
        localViewHolder.clearOldPosition();
    }
    this.mRecycler.clearOldPositions();
  }

  public void clearOnChildAttachStateChangeListeners()
  {
    if (this.mOnChildAttachStateListeners != null)
      this.mOnChildAttachStateListeners.clear();
  }

  public void clearOnScrollListeners()
  {
    if (this.mScrollListeners != null)
      this.mScrollListeners.clear();
  }

  public int computeHorizontalScrollExtent()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollHorizontally())
      return 0;
    return this.mLayout.computeHorizontalScrollExtent(this.mState);
  }

  public int computeHorizontalScrollOffset()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollHorizontally())
      return 0;
    return this.mLayout.computeHorizontalScrollOffset(this.mState);
  }

  public int computeHorizontalScrollRange()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollHorizontally())
      return 0;
    return this.mLayout.computeHorizontalScrollRange(this.mState);
  }

  public int computeVerticalScrollExtent()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollVertically())
      return 0;
    return this.mLayout.computeVerticalScrollExtent(this.mState);
  }

  public int computeVerticalScrollOffset()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollVertically())
      return 0;
    return this.mLayout.computeVerticalScrollOffset(this.mState);
  }

  public int computeVerticalScrollRange()
  {
    if (this.mLayout == null);
    while (!this.mLayout.canScrollVertically())
      return 0;
    return this.mLayout.computeVerticalScrollRange(this.mState);
  }

  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    boolean bool1 = false;
    if (localEdgeEffect != null)
    {
      boolean bool2 = this.mLeftGlow.isFinished();
      bool1 = false;
      if (!bool2)
      {
        bool1 = false;
        if (paramInt1 > 0)
        {
          this.mLeftGlow.onRelease();
          bool1 = this.mLeftGlow.isFinished();
        }
      }
    }
    if ((this.mRightGlow != null) && (!this.mRightGlow.isFinished()) && (paramInt1 < 0))
    {
      this.mRightGlow.onRelease();
      bool1 |= this.mRightGlow.isFinished();
    }
    if ((this.mTopGlow != null) && (!this.mTopGlow.isFinished()) && (paramInt2 > 0))
    {
      this.mTopGlow.onRelease();
      bool1 |= this.mTopGlow.isFinished();
    }
    if ((this.mBottomGlow != null) && (!this.mBottomGlow.isFinished()) && (paramInt2 < 0))
    {
      this.mBottomGlow.onRelease();
      bool1 |= this.mBottomGlow.isFinished();
    }
    if (bool1)
      ViewCompat.postInvalidateOnAnimation(this);
  }

  void consumePendingUpdateOperations()
  {
    if ((!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout))
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
    }
    label111: 
    do
    {
      do
        return;
      while (!this.mAdapterHelper.hasPendingUpdates());
      if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (!this.mLayoutWasDefered)
        {
          if (!hasUpdatedView())
            break label111;
          dispatchLayout();
        }
        while (true)
        {
          stopInterceptRequestLayout(true);
          onExitLayoutOrScroll();
          TraceCompat.endSection();
          return;
          this.mAdapterHelper.consumePostponedUpdates();
        }
      }
    }
    while (!this.mAdapterHelper.hasPendingUpdates());
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }

  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }

  void dispatchChildAttached(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null))
      this.mAdapter.onViewAttachedToWindow(localViewHolder);
    if (this.mOnChildAttachStateListeners != null)
      for (int i = -1 + this.mOnChildAttachStateListeners.size(); i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
  }

  void dispatchChildDetached(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null))
      this.mAdapter.onViewDetachedFromWindow(localViewHolder);
    if (this.mOnChildAttachStateListeners != null)
      for (int i = -1 + this.mOnChildAttachStateListeners.size(); i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
  }

  void dispatchLayout()
  {
    if (this.mAdapter == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.mState.mIsMeasuring = false;
    if (this.mState.mLayoutStep == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    while (true)
    {
      dispatchLayoutStep3();
      return;
      if ((this.mAdapterHelper.hasUpdates()) || (this.mLayout.getWidth() != getWidth()) || (this.mLayout.getHeight() != getHeight()))
      {
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
      }
      else
      {
        this.mLayout.setExactMeasureSpecsFrom(this);
      }
    }
  }

  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }

  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }

  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }

  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }

  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }

  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }

  void dispatchOnScrollStateChanged(int paramInt)
  {
    if (this.mLayout != null)
      this.mLayout.onScrollStateChanged(paramInt);
    onScrollStateChanged(paramInt);
    if (this.mScrollListener != null)
      this.mScrollListener.onScrollStateChanged(this, paramInt);
    if (this.mScrollListeners != null)
      for (int i = -1 + this.mScrollListeners.size(); i >= 0; i--)
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
  }

  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    this.mDispatchScrollCounter = (1 + this.mDispatchScrollCounter);
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    onScrolled(paramInt1, paramInt2);
    if (this.mScrollListener != null)
      this.mScrollListener.onScrolled(this, paramInt1, paramInt2);
    if (this.mScrollListeners != null)
      for (int k = -1 + this.mScrollListeners.size(); k >= 0; k--)
        ((OnScrollListener)this.mScrollListeners.get(k)).onScrolled(this, paramInt1, paramInt2);
    this.mDispatchScrollCounter = (-1 + this.mDispatchScrollCounter);
  }

  void dispatchPendingImportantForAccessibilityChanges()
  {
    int i = -1 + this.mPendingAccessibilityImportanceChange.size();
    if (i >= 0)
    {
      ViewHolder localViewHolder = (ViewHolder)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localViewHolder.itemView.getParent() != this) || (localViewHolder.shouldIgnore()));
      while (true)
      {
        i--;
        break;
        int j = localViewHolder.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localViewHolder.itemView, j);
          localViewHolder.mPendingAccessibilityState = -1;
        }
      }
    }
    this.mPendingAccessibilityImportanceChange.clear();
  }

  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }

  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    for (int k = 0; k < j; k++)
      ((ItemDecoration)this.mItemDecorations.get(k)).onDrawOver(paramCanvas, this, this.mState);
    int i9;
    int m;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()))
    {
      int i8 = paramCanvas.save();
      if (this.mClipToPadding)
      {
        i9 = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i9 + -getHeight(), 0.0F);
        if ((this.mLeftGlow == null) || (!this.mLeftGlow.draw(paramCanvas)))
          break label466;
        m = i;
        label129: paramCanvas.restoreToCount(i8);
      }
    }
    while (true)
    {
      int i7;
      label200: int i4;
      label255: int i5;
      if ((this.mTopGlow != null) && (!this.mTopGlow.isFinished()))
      {
        int i6 = paramCanvas.save();
        if (this.mClipToPadding)
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        if ((this.mTopGlow != null) && (this.mTopGlow.draw(paramCanvas)))
        {
          i7 = i;
          m |= i7;
          paramCanvas.restoreToCount(i6);
        }
      }
      else
      {
        if ((this.mRightGlow != null) && (!this.mRightGlow.isFinished()))
        {
          int i2 = paramCanvas.save();
          int i3 = getWidth();
          if (!this.mClipToPadding)
            break label478;
          i4 = getPaddingTop();
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i4, -i3);
          if ((this.mRightGlow == null) || (!this.mRightGlow.draw(paramCanvas)))
            break label484;
          i5 = i;
          label295: m |= i5;
          paramCanvas.restoreToCount(i2);
        }
        if ((this.mBottomGlow != null) && (!this.mBottomGlow.isFinished()))
        {
          int n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.mClipToPadding)
            break label490;
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label371: EdgeEffect localEdgeEffect = this.mBottomGlow;
          int i1 = 0;
          if (localEdgeEffect != null)
          {
            boolean bool = this.mBottomGlow.draw(paramCanvas);
            i1 = 0;
            if (bool)
              i1 = i;
          }
          m |= i1;
          paramCanvas.restoreToCount(n);
        }
        if ((m != 0) || (this.mItemAnimator == null) || (this.mItemDecorations.size() <= 0) || (!this.mItemAnimator.isRunning()))
          break label509;
      }
      while (true)
      {
        if (i != 0)
          ViewCompat.postInvalidateOnAnimation(this);
        return;
        i9 = 0;
        break;
        label466: m = 0;
        break label129;
        i7 = 0;
        break label200;
        label478: i4 = 0;
        break label255;
        label484: i5 = 0;
        break label295;
        label490: paramCanvas.translate(-getWidth(), -getHeight());
        break label371;
        label509: i = m;
      }
      m = 0;
    }
  }

  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }

  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null)
      return;
    this.mBottomGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
    if (this.mClipToPadding)
    {
      this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }

  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null)
      return;
    this.mLeftGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
    if (this.mClipToPadding)
    {
      this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }

  void ensureRightGlow()
  {
    if (this.mRightGlow != null)
      return;
    this.mRightGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
    if (this.mClipToPadding)
    {
      this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }

  void ensureTopGlow()
  {
    if (this.mTopGlow != null)
      return;
    this.mTopGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
    if (this.mClipToPadding)
    {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }

  String exceptionLabel()
  {
    return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
  }

  final void fillRemainingScrollValues(State paramState)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.mViewFlinger.mScroller;
      paramState.mRemainingScrollHorizontal = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramState.mRemainingScrollVertical = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramState.mRemainingScrollHorizontal = 0;
    paramState.mRemainingScrollVertical = 0;
  }

  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    for (int i = -1 + this.mChildHelper.getChildCount(); i >= 0; i--)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= f1 + localView.getLeft()) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= f2 + localView.getTop()) && (paramFloat2 <= f2 + localView.getBottom()))
        return localView;
    }
    return null;
  }

  public View findContainingItemView(View paramView)
  {
    Object localObject1 = paramView.getParent();
    Object localObject2 = paramView;
    while ((localObject1 != null) && (localObject1 != this) && ((localObject1 instanceof View)))
    {
      View localView = (View)localObject1;
      ViewParent localViewParent = localView.getParent();
      localObject2 = localView;
      localObject1 = localViewParent;
    }
    if (localObject1 == this)
      return localObject2;
    return null;
  }

  public ViewHolder findContainingViewHolder(View paramView)
  {
    View localView = findContainingItemView(paramView);
    if (localView == null)
      return null;
    return getChildViewHolder(localView);
  }

  public ViewHolder findViewHolderForAdapterPosition(int paramInt)
  {
    boolean bool = this.mDataSetHasChangedAfterLayout;
    Object localObject1 = null;
    if (bool);
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      int i = this.mChildHelper.getUnfilteredChildCount();
      j = 0;
      localObject2 = null;
      if (j >= i)
        break;
      localObject1 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localObject1 == null) || (((ViewHolder)localObject1).isRemoved()) || (getAdapterPositionFor((ViewHolder)localObject1) != paramInt))
        break label94;
    }
    while (!this.mChildHelper.isHidden(((ViewHolder)localObject1).itemView));
    while (true)
    {
      j++;
      localObject2 = localObject1;
      break;
      return localObject2;
      label94: localObject1 = localObject2;
    }
  }

  public ViewHolder findViewHolderForItemId(long paramLong)
  {
    Adapter localAdapter = this.mAdapter;
    Object localObject1 = null;
    if (localAdapter != null)
    {
      boolean bool = this.mAdapter.hasStableIds();
      localObject1 = null;
      if (bool)
        break label32;
    }
    label32: int j;
    Object localObject2;
    do
    {
      return localObject1;
      int i = this.mChildHelper.getUnfilteredChildCount();
      j = 0;
      localObject2 = null;
      if (j >= i)
        break;
      localObject1 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localObject1 == null) || (((ViewHolder)localObject1).isRemoved()) || (((ViewHolder)localObject1).getItemId() != paramLong))
        break label119;
    }
    while (!this.mChildHelper.isHidden(((ViewHolder)localObject1).itemView));
    while (true)
    {
      j++;
      localObject2 = localObject1;
      break;
      return localObject2;
      label119: localObject1 = localObject2;
    }
  }

  public ViewHolder findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }

  @Deprecated
  public ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }

  ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = 0;
    Object localObject1 = null;
    if (j < i)
    {
      localObject2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localObject2 != null) && (!((ViewHolder)localObject2).isRemoved()))
      {
        if (!paramBoolean)
          break label66;
        if (((ViewHolder)localObject2).mPosition == paramInt)
          break label75;
      }
      while (true)
      {
        j++;
        break;
        label66: if (((ViewHolder)localObject2).getLayoutPosition() == paramInt)
        {
          label75: if (!this.mChildHelper.isHidden(((ViewHolder)localObject2).itemView))
            break label101;
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    label101: return localObject2;
  }

  public boolean fling(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null)
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        do
          return false;
        while (this.mLayoutFrozen);
        bool1 = this.mLayout.canScrollHorizontally();
        bool2 = this.mLayout.canScrollVertically();
        if ((!bool1) || (Math.abs(paramInt1) < this.mMinFlingVelocity))
          paramInt1 = 0;
        if ((!bool2) || (Math.abs(paramInt2) < this.mMinFlingVelocity))
          paramInt2 = 0;
      }
      while (((paramInt1 == 0) && (paramInt2 == 0)) || (dispatchNestedPreFling(paramInt1, paramInt2)));
      if ((bool1) || (bool2));
      for (bool3 = true; ; bool3 = false)
      {
        dispatchNestedFling(paramInt1, paramInt2, bool3);
        if ((this.mOnFlingListener == null) || (!this.mOnFlingListener.onFling(paramInt1, paramInt2)))
          break;
        return true;
      }
    }
    while (!bool3);
    if (bool1);
    for (int i = 1; ; i = 0)
    {
      if (bool2)
        i |= 2;
      startNestedScroll(i, 1);
      int j = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt1, this.mMaxFlingVelocity));
      int k = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt2, this.mMaxFlingVelocity));
      this.mViewFlinger.fling(j, k);
      return true;
    }
  }

  public View focusSearch(View paramView, int paramInt)
  {
    int i = 1;
    View localView1 = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localView1 != null)
      return localView1;
    int j;
    FocusFinder localFocusFinder;
    int i2;
    label92: int i3;
    label107: int k;
    if ((this.mAdapter != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutFrozen))
    {
      j = i;
      localFocusFinder = FocusFinder.getInstance();
      if ((j == 0) || ((paramInt != 2) && (paramInt != i)))
        break label315;
      if (!this.mLayout.canScrollVertically())
        break label434;
      if (paramInt != 2)
        break label214;
      i2 = 130;
      if (localFocusFinder.findNextFocus(this, paramView, i2) != null)
        break label221;
      i3 = i;
      if (!FORCE_ABS_FOCUS_SEARCH_DIRECTION)
        break label427;
      paramInt = i2;
      k = i3;
    }
    while (true)
    {
      int m;
      label149: int n;
      label157: int i1;
      if ((k == 0) && (this.mLayout.canScrollHorizontally()))
        if (this.mLayout.getLayoutDirection() == i)
        {
          m = i;
          if (paramInt != 2)
            break label233;
          n = i;
          if ((n ^ m) == 0)
            break label239;
          i1 = 66;
          label169: if (localFocusFinder.findNextFocus(this, paramView, i1) != null)
            break label246;
          label181: if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
            paramInt = i1;
        }
      while (true)
      {
        if (i != 0)
        {
          consumePendingUpdateOperations();
          if (findContainingItemView(paramView) == null)
          {
            return null;
            j = 0;
            break;
            label214: i2 = 33;
            break label92;
            label221: i3 = 0;
            break label107;
            m = 0;
            break label149;
            label233: n = 0;
            break label157;
            label239: i1 = 17;
            break label169;
            label246: i = 0;
            break label181;
          }
          startInterceptRequestLayout();
          this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
          stopInterceptRequestLayout(false);
        }
        Object localObject = localFocusFinder.findNextFocus(this, paramView, paramInt);
        while (true)
        {
          label315: View localView2;
          if ((localObject != null) && (!((View)localObject).hasFocusable()))
          {
            if (getFocusedChild() == null)
            {
              return super.focusSearch(paramView, paramInt);
              localView2 = localFocusFinder.findNextFocus(this, paramView, paramInt);
              if ((localView2 == null) && (j != 0))
              {
                consumePendingUpdateOperations();
                if (findContainingItemView(paramView) == null)
                  return null;
                startInterceptRequestLayout();
                localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
              }
            }
            else
            {
              requestChildOnScreen((View)localObject, null);
              return paramView;
            }
          }
          else
          {
            if (isPreferredNextFocus(paramView, (View)localObject, paramInt));
            while (true)
            {
              return localObject;
              localObject = super.focusSearch(paramView, paramInt);
            }
            localObject = localView2;
          }
        }
        i = k;
      }
      label427: k = i3;
      continue;
      label434: k = 0;
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    return this.mLayout.generateDefaultLayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    return this.mLayout.generateLayoutParams(paramLayoutParams);
  }

  public Adapter getAdapter()
  {
    return this.mAdapter;
  }

  int getAdapterPositionFor(ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.hasAnyOfTheFlags(524)) || (!paramViewHolder.isBound()))
      return -1;
    return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
  }

  public int getBaseline()
  {
    if (this.mLayout != null)
      return this.mLayout.getBaseline();
    return super.getBaseline();
  }

  long getChangedHolderKey(ViewHolder paramViewHolder)
  {
    if (this.mAdapter.hasStableIds())
      return paramViewHolder.getItemId();
    return paramViewHolder.mPosition;
  }

  public int getChildAdapterPosition(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
      return localViewHolder.getAdapterPosition();
    return -1;
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mChildDrawingOrderCallback == null)
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    return this.mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }

  public long getChildItemId(View paramView)
  {
    if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds()));
    ViewHolder localViewHolder;
    do
    {
      return -1L;
      localViewHolder = getChildViewHolderInt(paramView);
    }
    while (localViewHolder == null);
    return localViewHolder.getItemId();
  }

  public int getChildLayoutPosition(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
      return localViewHolder.getLayoutPosition();
    return -1;
  }

  @Deprecated
  public int getChildPosition(View paramView)
  {
    return getChildAdapterPosition(paramView);
  }

  public ViewHolder getChildViewHolder(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this))
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    return getChildViewHolderInt(paramView);
  }

  public boolean getClipToPadding()
  {
    return this.mClipToPadding;
  }

  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }

  public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
  {
    getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }

  public EdgeEffectFactory getEdgeEffectFactory()
  {
    return this.mEdgeEffectFactory;
  }

  public ItemAnimator getItemAnimator()
  {
    return this.mItemAnimator;
  }

  Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mInsetsDirty)
      return localLayoutParams.mDecorInsets;
    if ((this.mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid())))
      return localLayoutParams.mDecorInsets;
    Rect localRect = localLayoutParams.mDecorInsets;
    localRect.set(0, 0, 0, 0);
    int i = this.mItemDecorations.size();
    for (int j = 0; j < i; j++)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((ItemDecoration)this.mItemDecorations.get(j)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
    }
    localLayoutParams.mInsetsDirty = false;
    return localRect;
  }

  public ItemDecoration getItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i))
      throw new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
    return (ItemDecoration)this.mItemDecorations.get(paramInt);
  }

  public int getItemDecorationCount()
  {
    return this.mItemDecorations.size();
  }

  public LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }

  public int getMaxFlingVelocity()
  {
    return this.mMaxFlingVelocity;
  }

  public int getMinFlingVelocity()
  {
    return this.mMinFlingVelocity;
  }

  long getNanoTime()
  {
    if (ALLOW_THREAD_GAP_WORK)
      return System.nanoTime();
    return 0L;
  }

  public OnFlingListener getOnFlingListener()
  {
    return this.mOnFlingListener;
  }

  public boolean getPreserveFocusAfterLayout()
  {
    return this.mPreserveFocusAfterLayout;
  }

  public RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }

  public int getScrollState()
  {
    return this.mScrollState;
  }

  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }

  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }

  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }

  public boolean hasPendingAdapterUpdates()
  {
    return (!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout) || (this.mAdapterHelper.hasPendingUpdates());
  }

  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback()
    {
      void dispatchUpdate(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        switch (paramAnonymousUpdateOp.cmd)
        {
        case 3:
        case 5:
        case 6:
        case 7:
        default:
          return;
        case 1:
          RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
          return;
        case 2:
          RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
          return;
        case 4:
          RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, paramAnonymousUpdateOp.payload);
          return;
        case 8:
        }
        RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, 1);
      }

      public RecyclerView.ViewHolder findViewHolder(int paramAnonymousInt)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.this.findViewHolderForPosition(paramAnonymousInt, true);
        if (localViewHolder == null);
        while (RecyclerView.this.mChildHelper.isHidden(localViewHolder.itemView))
          return null;
        return localViewHolder;
      }

      public void markViewHoldersUpdated(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        RecyclerView.this.viewRangeUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        RecyclerView.this.mItemsChanged = true;
      }

      public void offsetPositionsForAdd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForInsert(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }

      public void offsetPositionsForMove(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForMove(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }

      public void offsetPositionsForRemovingInvisible(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, true);
        RecyclerView.this.mItemsAddedOrRemoved = true;
        RecyclerView.State localState = RecyclerView.this.mState;
        localState.mDeletedInvisibleItemCountSincePreviousLayout = (paramAnonymousInt2 + localState.mDeletedInvisibleItemCountSincePreviousLayout);
      }

      public void offsetPositionsForRemovingLaidOutOrNewView(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, false);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }

      public void onDispatchFirstPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }

      public void onDispatchSecondPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }
    });
  }

  void initFastScroller(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 == null) || (paramDrawable1 == null) || (paramStateListDrawable2 == null) || (paramDrawable2 == null))
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    Resources localResources = getContext().getResources();
    new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
  }

  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }

  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0)
      return;
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    markItemDecorInsetsDirty();
    requestLayout();
  }

  boolean isAccessibilityEnabled()
  {
    return (this.mAccessibilityManager != null) && (this.mAccessibilityManager.isEnabled());
  }

  public boolean isAnimating()
  {
    return (this.mItemAnimator != null) && (this.mItemAnimator.isRunning());
  }

  public boolean isAttachedToWindow()
  {
    return this.mIsAttached;
  }

  public boolean isComputingLayout()
  {
    return this.mLayoutOrScrollCounter > 0;
  }

  public boolean isLayoutFrozen()
  {
    return this.mLayoutFrozen;
  }

  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }

  void jumpToPositionForSmoothScroller(int paramInt)
  {
    if (this.mLayout == null)
      return;
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }

  void markItemDecorInsetsDirty()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
      ((LayoutParams)this.mChildHelper.getUnfilteredChildAt(j).getLayoutParams()).mInsetsDirty = true;
    this.mRecycler.markItemDecorInsetsDirty();
  }

  void markKnownViewsInvalid()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
        localViewHolder.addFlags(6);
    }
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }

  public void offsetChildrenHorizontal(int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
      this.mChildHelper.getChildAt(j).offsetLeftAndRight(paramInt);
  }

  public void offsetChildrenVertical(int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
      this.mChildHelper.getChildAt(j).offsetTopAndBottom(paramInt);
  }

  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2, false);
        this.mState.mStructureChanged = true;
      }
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }

  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j;
    int k;
    if (paramInt1 < paramInt2)
    {
      j = -1;
      k = paramInt2;
    }
    ViewHolder localViewHolder;
    for (int m = paramInt1; ; m = paramInt2)
    {
      for (int n = 0; ; n++)
      {
        if (n >= i)
          break label128;
        localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n));
        if ((localViewHolder != null) && (localViewHolder.mPosition >= m) && (localViewHolder.mPosition <= k))
          break;
      }
      j = 1;
      k = paramInt1;
    }
    if (localViewHolder.mPosition == paramInt1)
      localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
    while (true)
    {
      this.mState.mStructureChanged = true;
      break;
      localViewHolder.offsetPosition(j, false);
    }
    label128: this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }

  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt2;
    int j = this.mChildHelper.getUnfilteredChildCount();
    int k = 0;
    if (k < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(k));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        if (localViewHolder.mPosition < i)
          break label83;
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
        this.mState.mStructureChanged = true;
      }
      while (true)
      {
        k++;
        break;
        label83: if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
      }
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }

  protected void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    this.mIsAttached = bool;
    float f;
    if ((this.mFirstLayoutComplete) && (!isLayoutRequested()))
    {
      this.mFirstLayoutComplete = bool;
      if (this.mLayout != null)
        this.mLayout.dispatchAttachedToWindow(this);
      this.mPostedAnimatorRunner = false;
      if (ALLOW_THREAD_GAP_WORK)
      {
        this.mGapWorker = ((GapWorker)GapWorker.sGapWorker.get());
        if (this.mGapWorker == null)
        {
          this.mGapWorker = new GapWorker();
          Display localDisplay = ViewCompat.getDisplay(this);
          if ((isInEditMode()) || (localDisplay == null))
            break label158;
          f = localDisplay.getRefreshRate();
          if (f < 30.0F)
            break label158;
        }
      }
    }
    while (true)
    {
      this.mGapWorker.mFrameIntervalNs = (()(1.0E+009F / f));
      GapWorker.sGapWorker.set(this.mGapWorker);
      this.mGapWorker.add(this);
      return;
      bool = false;
      break;
      label158: f = 60.0F;
    }
  }

  public void onChildAttachedToWindow(View paramView)
  {
  }

  public void onChildDetachedFromWindow(View paramView)
  {
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null)
      this.mItemAnimator.endAnimations();
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null)
      this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
    if ((ALLOW_THREAD_GAP_WORK) && (this.mGapWorker != null))
    {
      this.mGapWorker.remove(this);
      this.mGapWorker = null;
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.mItemDecorations.size();
    for (int j = 0; j < i; j++)
      ((ItemDecoration)this.mItemDecorations.get(j)).onDraw(paramCanvas, this, this.mState);
  }

  void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter = (1 + this.mLayoutOrScrollCounter);
  }

  void onExitLayoutOrScroll()
  {
    onExitLayoutOrScroll(true);
  }

  void onExitLayoutOrScroll(boolean paramBoolean)
  {
    this.mLayoutOrScrollCounter = (-1 + this.mLayoutOrScrollCounter);
    if (this.mLayoutOrScrollCounter < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
      }
    }
  }

  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null);
    label188: 
    while (true)
    {
      return false;
      if ((!this.mLayoutFrozen) && (paramMotionEvent.getAction() == 8))
      {
        float f3;
        float f2;
        float f1;
        if ((0x2 & paramMotionEvent.getSource()) != 0)
          if (this.mLayout.canScrollVertically())
          {
            f3 = -paramMotionEvent.getAxisValue(9);
            if (!this.mLayout.canScrollHorizontally())
              break label117;
            float f4 = paramMotionEvent.getAxisValue(10);
            f2 = f3;
            f1 = f4;
          }
        while (true)
        {
          if ((f2 == 0.0F) && (f1 == 0.0F))
            break label188;
          scrollByInternal((int)(f1 * this.mScaledHorizontalScrollFactor), (int)(f2 * this.mScaledVerticalScrollFactor), paramMotionEvent);
          return false;
          f3 = 0.0F;
          break;
          label117: f2 = f3;
          f1 = 0.0F;
          continue;
          if ((0x400000 & paramMotionEvent.getSource()) != 0)
          {
            f1 = paramMotionEvent.getAxisValue(26);
            if (this.mLayout.canScrollVertically())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.mLayout.canScrollHorizontally())
            {
              f2 = 0.0F;
            }
            else
            {
              f1 = 0.0F;
              f2 = 0.0F;
            }
          }
          else
          {
            f1 = 0.0F;
            f2 = 0.0F;
          }
        }
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayoutFrozen);
    do
    {
      return false;
      if (dispatchOnItemTouchIntercept(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
    }
    while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    boolean bool3;
    switch (i)
    {
    case 4:
    default:
      if (this.mScrollState == 1)
      {
        bool3 = true;
        return bool3;
      }
      break;
    case 0:
      label135: if (this.mIgnoreMotionEventTillDown)
        this.mIgnoreMotionEventTillDown = false;
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      int i6 = (int)(0.5F + paramMotionEvent.getX());
      this.mLastTouchX = i6;
      this.mInitialTouchX = i6;
      int i7 = (int)(0.5F + paramMotionEvent.getY());
      this.mLastTouchY = i7;
      this.mInitialTouchY = i7;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      int[] arrayOfInt = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      arrayOfInt[0] = 0;
      if (!bool1);
      break;
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    for (int i8 = 1; ; i8 = 0)
    {
      if (bool2)
        i8 |= 2;
      startNestedScroll(i8, 0);
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(j);
      int i4 = (int)(0.5F + paramMotionEvent.getX(j));
      this.mLastTouchX = i4;
      this.mInitialTouchX = i4;
      int i5 = (int)(0.5F + paramMotionEvent.getY(j));
      this.mLastTouchY = i5;
      this.mInitialTouchY = i5;
      break;
      int k = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (k < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int m = (int)(0.5F + paramMotionEvent.getX(k));
      int n = (int)(0.5F + paramMotionEvent.getY(k));
      if (this.mScrollState == 1)
        break;
      int i1 = m - this.mInitialTouchX;
      int i2 = n - this.mInitialTouchY;
      if ((bool1) && (Math.abs(i1) > this.mTouchSlop))
        this.mLastTouchX = m;
      for (int i3 = 1; ; i3 = 0)
      {
        if ((bool2) && (Math.abs(i2) > this.mTouchSlop))
        {
          this.mLastTouchY = n;
          i3 = 1;
        }
        if (i3 == 0)
          break;
        setScrollState(1);
        break;
        onPointerUp(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        break;
        cancelTouch();
        break;
        bool3 = false;
        break label135;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null)
      defaultOnMeasure(paramInt1, paramInt2);
    do
    {
      int k;
      do
      {
        return;
        if (!this.mLayout.isAutoMeasureEnabled())
          break;
        int i = View.MeasureSpec.getMode(paramInt1);
        int j = View.MeasureSpec.getMode(paramInt2);
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        k = 0;
        if (i == 1073741824)
        {
          k = 0;
          if (j == 1073741824)
            k = 1;
        }
      }
      while ((k != 0) || (this.mAdapter == null));
      if (this.mState.mLayoutStep == 1)
        dispatchLayoutStep1();
      this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
      this.mState.mIsMeasuring = true;
      dispatchLayoutStep2();
      this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    }
    while (!this.mLayout.shouldMeasureTwice());
    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.mState.mIsMeasuring = true;
    dispatchLayoutStep2();
    this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    return;
    if (this.mHasFixedSize)
    {
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      return;
    }
    if (this.mAdapterUpdateDuringMeasure)
    {
      startInterceptRequestLayout();
      onEnterLayoutOrScroll();
      processAdapterUpdatesAndSetAnimationFlags();
      onExitLayoutOrScroll();
      if (this.mState.mRunPredictiveAnimations)
      {
        this.mState.mInPreLayout = true;
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
        label268: if (this.mAdapter == null)
          break label365;
      }
    }
    label365: for (this.mState.mItemCount = this.mAdapter.getItemCount(); ; this.mState.mItemCount = 0)
    {
      startInterceptRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      stopInterceptRequestLayout(false);
      this.mState.mInPreLayout = false;
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      this.mState.mInPreLayout = false;
      break;
      if (!this.mState.mRunPredictiveAnimations)
        break label268;
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout())
      return false;
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
      super.onRestoreInstanceState(paramParcelable);
    do
    {
      return;
      this.mPendingSavedState = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    }
    while ((this.mLayout == null) || (this.mPendingSavedState.mLayoutState == null));
    this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null)
    {
      localSavedState.copyFrom(this.mPendingSavedState);
      return localSavedState;
    }
    if (this.mLayout != null)
    {
      localSavedState.mLayoutState = this.mLayout.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.mLayoutState = null;
    return localSavedState;
  }

  public void onScrollStateChanged(int paramInt)
  {
  }

  public void onScrolled(int paramInt1, int paramInt2)
  {
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
      invalidateGlows();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mLayoutFrozen) || (this.mIgnoreMotionEventTillDown));
    do
    {
      return false;
      if (dispatchOnItemTouch(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
    }
    while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (i == 0)
    {
      int[] arrayOfInt3 = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      arrayOfInt3[0] = 0;
    }
    localMotionEvent.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
    int k = 0;
    switch (i)
    {
    case 4:
    default:
      if (k == 0)
        this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      return true;
    case 0:
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      int i12 = (int)(0.5F + paramMotionEvent.getX());
      this.mLastTouchX = i12;
      this.mInitialTouchX = i12;
      int i13 = (int)(0.5F + paramMotionEvent.getY());
      this.mLastTouchY = i13;
      this.mInitialTouchY = i13;
      if (!bool1)
        break;
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    label789: label920: for (int i14 = 1; ; i14 = 0)
    {
      if (bool2)
        i14 |= 2;
      startNestedScroll(i14, 0);
      k = 0;
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(j);
      int i10 = (int)(0.5F + paramMotionEvent.getX(j));
      this.mLastTouchX = i10;
      this.mInitialTouchX = i10;
      int i11 = (int)(0.5F + paramMotionEvent.getY(j));
      this.mLastTouchY = i11;
      this.mInitialTouchY = i11;
      k = 0;
      break;
      int m = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (m < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int n = (int)(0.5F + paramMotionEvent.getX(m));
      int i1 = (int)(0.5F + paramMotionEvent.getY(m));
      int i2 = this.mLastTouchX - n;
      int i3 = this.mLastTouchY - i1;
      if (dispatchNestedPreScroll(i2, i3, this.mScrollConsumed, this.mScrollOffset, 0))
      {
        i2 -= this.mScrollConsumed[0];
        i3 -= this.mScrollConsumed[1];
        localMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
        int[] arrayOfInt1 = this.mNestedOffsets;
        arrayOfInt1[0] += this.mScrollOffset[0];
        int[] arrayOfInt2 = this.mNestedOffsets;
        arrayOfInt2[1] += this.mScrollOffset[1];
      }
      int i9;
      if (this.mScrollState != 1)
      {
        if ((!bool1) || (Math.abs(i2) <= this.mTouchSlop))
          break label936;
        if (i2 <= 0)
          break label765;
        i9 = i2 - this.mTouchSlop;
        label586: i2 = i9;
      }
      label795: label936: for (int i7 = 1; ; i7 = 0)
      {
        int i8;
        label623: int i5;
        if ((bool2) && (Math.abs(i3) > this.mTouchSlop))
        {
          if (i3 > 0)
          {
            i8 = i3 - this.mTouchSlop;
            i3 = i8;
            i7 = 1;
          }
        }
        else
        {
          if (i7 != 0)
            setScrollState(1);
          int i4 = this.mScrollState;
          k = 0;
          if (i4 != 1)
            break;
          this.mLastTouchX = (n - this.mScrollOffset[0]);
          this.mLastTouchY = (i1 - this.mScrollOffset[1]);
          if (!bool1)
            break label789;
          i5 = i2;
          label689: if (!bool2)
            break label795;
        }
        for (int i6 = i3; ; i6 = 0)
        {
          if (scrollByInternal(i5, i6, localMotionEvent))
            getParent().requestDisallowInterceptTouchEvent(true);
          GapWorker localGapWorker = this.mGapWorker;
          k = 0;
          if (localGapWorker == null)
            break;
          if (i2 == 0)
          {
            k = 0;
            if (i3 == 0)
              break;
          }
          this.mGapWorker.postFromTraversal(this, i2, i3);
          k = 0;
          break;
          label765: i9 = i2 + this.mTouchSlop;
          break label586;
          i8 = i3 + this.mTouchSlop;
          break label623;
          i5 = 0;
          break label689;
        }
        onPointerUp(paramMotionEvent);
        k = 0;
        break;
        this.mVelocityTracker.addMovement(localMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
          label854: if (!bool2)
            break label920;
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId); ; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2)))
            setScrollState(0);
          resetTouch();
          k = 1;
          break;
          f1 = 0.0F;
          break label854;
        }
        cancelTouch();
        k = 0;
        break;
      }
    }
  }

  void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }

  void processDataSetCompletelyChanged(boolean paramBoolean)
  {
    this.mDispatchItemsChangedEvent = (paramBoolean | this.mDispatchItemsChangedEvent);
    this.mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }

  void recordAnimationInfoIfBouncedHiddenView(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((this.mState.mTrackOldChangeHolders) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }

  void removeAndRecycleViews()
  {
    if (this.mItemAnimator != null)
      this.mItemAnimator.endAnimations();
    if (this.mLayout != null)
    {
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    }
    this.mRecycler.clear();
  }

  boolean removeAnimatingView(View paramView)
  {
    startInterceptRequestLayout();
    boolean bool1 = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool1)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(localViewHolder);
      this.mRecycler.recycleViewHolderInternal(localViewHolder);
    }
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      stopInterceptRequestLayout(bool2);
      return bool1;
    }
  }

  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if (!localViewHolder.isTmpDetached())
        break label36;
      localViewHolder.clearTmpDetachFlag();
    }
    label36: 
    while (localViewHolder.shouldIgnore())
    {
      paramView.clearAnimation();
      dispatchChildDetached(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localViewHolder + exceptionLabel());
  }

  public void removeItemDecoration(ItemDecoration paramItemDecoration)
  {
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty())
      if (getOverScrollMode() != 2)
        break label60;
    label60: for (boolean bool = true; ; bool = false)
    {
      setWillNotDraw(bool);
      markItemDecorInsetsDirty();
      requestLayout();
      return;
    }
  }

  public void removeItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i))
      throw new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
    removeItemDecoration(getItemDecorationAt(paramInt));
  }

  public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null)
      return;
    this.mOnChildAttachStateListeners.remove(paramOnChildAttachStateChangeListener);
  }

  public void removeOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener)
      this.mActiveOnItemTouchListener = null;
  }

  public void removeOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners != null)
      this.mScrollListeners.remove(paramOnScrollListener);
  }

  void repositionShadowingViews()
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView1 = this.mChildHelper.getChildAt(j);
      ViewHolder localViewHolder = getChildViewHolder(localView1);
      if ((localViewHolder != null) && (localViewHolder.mShadowingHolder != null))
      {
        View localView2 = localViewHolder.mShadowingHolder.itemView;
        int k = localView1.getLeft();
        int m = localView1.getTop();
        if ((k != localView2.getLeft()) || (m != localView2.getTop()))
          localView2.layout(k, m, k + localView2.getWidth(), m + localView2.getHeight());
      }
    }
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null))
      requestChildOnScreen(paramView1, paramView2);
    super.requestChildFocus(paramView1, paramView2);
  }

  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i = this.mOnItemTouchListeners.size();
    for (int j = 0; j < i; j++)
      ((OnItemTouchListener)this.mOnItemTouchListeners.get(j)).onRequestDisallowInterceptTouchEvent(paramBoolean);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  public void requestLayout()
  {
    if ((this.mInterceptRequestLayoutDepth == 0) && (!this.mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    this.mLayoutWasDefered = true;
  }

  void saveOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore())
        localViewHolder.saveOldPosition();
    }
  }

  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null);
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
        return;
      while (this.mLayoutFrozen);
      bool1 = this.mLayout.canScrollHorizontally();
      bool2 = this.mLayout.canScrollVertically();
    }
    while ((!bool1) && (!bool2));
    if (bool1)
      if (!bool2)
        break label73;
    while (true)
    {
      scrollByInternal(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label73: paramInt2 = 0;
    }
  }

  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    consumePendingUpdateOperations();
    int i;
    int j;
    int k;
    if (this.mAdapter != null)
    {
      scrollStep(paramInt1, paramInt2, this.mScrollStepConsumed);
      i = this.mScrollStepConsumed[0];
      j = this.mScrollStepConsumed[1];
      k = paramInt1 - i;
    }
    for (int m = paramInt2 - j; ; m = 0)
    {
      if (!this.mItemDecorations.isEmpty())
        invalidate();
      if (dispatchNestedScroll(i, j, k, m, this.mScrollOffset, 0))
      {
        this.mLastTouchX -= this.mScrollOffset[0];
        this.mLastTouchY -= this.mScrollOffset[1];
        if (paramMotionEvent != null)
          paramMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
        int[] arrayOfInt1 = this.mNestedOffsets;
        arrayOfInt1[0] += this.mScrollOffset[0];
        int[] arrayOfInt2 = this.mNestedOffsets;
        arrayOfInt2[1] += this.mScrollOffset[1];
      }
      while (true)
      {
        if ((i != 0) || (j != 0))
          dispatchOnScrolled(i, j);
        if (!awakenScrollBars())
          invalidate();
        boolean bool;
        if (i == 0)
        {
          bool = false;
          if (j == 0);
        }
        else
        {
          bool = true;
        }
        return bool;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!MotionEventCompat.isFromSource(paramMotionEvent, 8194)))
            pullGlows(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          considerReleasingGlowsOnScroll(paramInt1, paramInt2);
        }
      }
      i = 0;
      j = 0;
      k = 0;
    }
  }

  void scrollStep(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    fillRemainingScrollValues(this.mState);
    if (paramInt1 != 0);
    for (int i = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState); ; i = 0)
    {
      if (paramInt2 != 0);
      for (int j = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState); ; j = 0)
      {
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = i;
          paramArrayOfInt[1] = j;
        }
        return;
      }
    }
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }

  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen)
      return;
    stopScroll();
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }

  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent))
      return;
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }

  public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }

  public void setAdapter(Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    processDataSetCompletelyChanged(false);
    requestLayout();
  }

  public void setChildDrawingOrderCallback(ChildDrawingOrderCallback paramChildDrawingOrderCallback)
  {
    if (paramChildDrawingOrderCallback == this.mChildDrawingOrderCallback)
      return;
    this.mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    if (this.mChildDrawingOrderCallback != null);
    for (boolean bool = true; ; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }

  boolean setChildImportantForAccessibilityInternal(ViewHolder paramViewHolder, int paramInt)
  {
    if (isComputingLayout())
    {
      paramViewHolder.mPendingAccessibilityState = paramInt;
      this.mPendingAccessibilityImportanceChange.add(paramViewHolder);
      return false;
    }
    ViewCompat.setImportantForAccessibility(paramViewHolder.itemView, paramInt);
    return true;
  }

  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding)
      invalidateGlows();
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete)
      requestLayout();
  }

  public void setEdgeEffectFactory(EdgeEffectFactory paramEdgeEffectFactory)
  {
    Preconditions.checkNotNull(paramEdgeEffectFactory);
    this.mEdgeEffectFactory = paramEdgeEffectFactory;
    invalidateGlows();
  }

  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }

  public void setItemAnimator(ItemAnimator paramItemAnimator)
  {
    if (this.mItemAnimator != null)
    {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    if (this.mItemAnimator != null)
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
  }

  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }

  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutFrozen)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutFrozen = false;
        if ((this.mLayoutWasDefered) && (this.mLayout != null) && (this.mAdapter != null))
          requestLayout();
        this.mLayoutWasDefered = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.mLayoutFrozen = true;
    this.mIgnoreMotionEventTillDown = true;
    stopScroll();
  }

  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout)
      return;
    stopScroll();
    if (this.mLayout != null)
    {
      if (this.mItemAnimator != null)
        this.mItemAnimator.endAnimations();
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      this.mRecycler.clear();
      if (this.mIsAttached)
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      this.mLayout.setRecyclerView(null);
      this.mLayout = null;
    }
    while (true)
    {
      this.mChildHelper.removeAllViewsUnfiltered();
      this.mLayout = paramLayoutManager;
      if (paramLayoutManager == null)
        break label195;
      if (paramLayoutManager.mRecyclerView == null)
        break;
      throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView:" + paramLayoutManager.mRecyclerView.exceptionLabel());
      this.mRecycler.clear();
    }
    this.mLayout.setRecyclerView(this);
    if (this.mIsAttached)
      this.mLayout.dispatchAttachedToWindow(this);
    label195: this.mRecycler.updateViewCacheSize();
    requestLayout();
  }

  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }

  public void setOnFlingListener(OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }

  @Deprecated
  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }

  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }

  public void setRecycledViewPool(RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }

  public void setRecyclerListener(RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }

  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState)
      return;
    this.mScrollState = paramInt;
    if (paramInt != 2)
      stopScrollersInternal();
    dispatchOnScrollStateChanged(paramInt);
  }

  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default:
      Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + paramInt + "; using default value");
    case 0:
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    case 1:
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
  }

  public void setViewCacheExtension(ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }

  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool1 = isComputingLayout();
    boolean bool2 = false;
    if (bool1)
      if (paramAccessibilityEvent == null)
        break label51;
    label51: for (int i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent); ; i = 0)
    {
      int j = 0;
      if (i == 0);
      while (true)
      {
        this.mEatenAccessibilityChangeFlags = (j | this.mEatenAccessibilityChangeFlags);
        bool2 = true;
        return bool2;
        j = i;
      }
    }
  }

  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }

  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    if (this.mLayout == null)
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    while (true)
    {
      return;
      if (!this.mLayoutFrozen)
      {
        if (!this.mLayout.canScrollHorizontally())
          paramInt1 = 0;
        boolean bool = this.mLayout.canScrollVertically();
        int i = 0;
        if (!bool);
        while ((paramInt1 != 0) || (i != 0))
        {
          this.mViewFlinger.smoothScrollBy(paramInt1, i, paramInterpolator);
          return;
          i = paramInt2;
        }
      }
    }
  }

  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen)
      return;
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }

  void startInterceptRequestLayout()
  {
    this.mInterceptRequestLayoutDepth = (1 + this.mInterceptRequestLayoutDepth);
    if ((this.mInterceptRequestLayoutDepth == 1) && (!this.mLayoutFrozen))
      this.mLayoutWasDefered = false;
  }

  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }

  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }

  void stopInterceptRequestLayout(boolean paramBoolean)
  {
    if (this.mInterceptRequestLayoutDepth < 1)
      this.mInterceptRequestLayoutDepth = 1;
    if ((!paramBoolean) && (!this.mLayoutFrozen))
      this.mLayoutWasDefered = false;
    if (this.mInterceptRequestLayoutDepth == 1)
    {
      if ((paramBoolean) && (this.mLayoutWasDefered) && (!this.mLayoutFrozen) && (this.mLayout != null) && (this.mAdapter != null))
        dispatchLayout();
      if (!this.mLayoutFrozen)
        this.mLayoutWasDefered = false;
    }
    this.mInterceptRequestLayoutDepth = (-1 + this.mInterceptRequestLayoutDepth);
  }

  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }

  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }

  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }

  public void swapAdapter(Adapter paramAdapter, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    processDataSetCompletelyChanged(true);
    requestLayout();
  }

  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = paramInt1 + paramInt2;
    int k = 0;
    if (k < i)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(k);
      ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore()));
      while (true)
      {
        k++;
        break;
        if ((localViewHolder.mPosition >= paramInt1) && (localViewHolder.mPosition < j))
        {
          localViewHolder.addFlags(2);
          localViewHolder.addChangePayload(paramObject);
          ((LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
        }
      }
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }

  public static abstract class Adapter<VH extends RecyclerView.ViewHolder>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();

    public final void bindViewHolder(VH paramVH, int paramInt)
    {
      paramVH.mPosition = paramInt;
      if (hasStableIds())
        paramVH.mItemId = getItemId(paramInt);
      paramVH.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
      paramVH.clearPayload();
      ViewGroup.LayoutParams localLayoutParams = paramVH.itemView.getLayoutParams();
      if ((localLayoutParams instanceof RecyclerView.LayoutParams))
        ((RecyclerView.LayoutParams)localLayoutParams).mInsetsDirty = true;
      TraceCompat.endSection();
    }

    public final VH createViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      RecyclerView.ViewHolder localViewHolder;
      try
      {
        TraceCompat.beginSection("RV CreateView");
        localViewHolder = onCreateViewHolder(paramViewGroup, paramInt);
        if (localViewHolder.itemView.getParent() != null)
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
      finally
      {
        TraceCompat.endSection();
      }
      localViewHolder.mItemViewType = paramInt;
      TraceCompat.endSection();
      return localViewHolder;
    }

    public abstract int getItemCount();

    public long getItemId(int paramInt)
    {
      return -1L;
    }

    public int getItemViewType(int paramInt)
    {
      return 0;
    }

    public final boolean hasObservers()
    {
      return this.mObservable.hasObservers();
    }

    public final boolean hasStableIds()
    {
      return this.mHasStableIds;
    }

    public final void notifyDataSetChanged()
    {
      this.mObservable.notifyChanged();
    }

    public final void notifyItemChanged(int paramInt)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1);
    }

    public final void notifyItemChanged(int paramInt, Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
    }

    public final void notifyItemInserted(int paramInt)
    {
      this.mObservable.notifyItemRangeInserted(paramInt, 1);
    }

    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemMoved(paramInt1, paramInt2);
    }

    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }

    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }

    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }

    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }

    public final void notifyItemRemoved(int paramInt)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
    {
    }

    public abstract void onBindViewHolder(VH paramVH, int paramInt);

    public void onBindViewHolder(VH paramVH, int paramInt, List<Object> paramList)
    {
      onBindViewHolder(paramVH, paramInt);
    }

    public abstract VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);

    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
    {
    }

    public boolean onFailedToRecycleView(VH paramVH)
    {
      return false;
    }

    public void onViewAttachedToWindow(VH paramVH)
    {
    }

    public void onViewDetachedFromWindow(VH paramVH)
    {
    }

    public void onViewRecycled(VH paramVH)
    {
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.registerObserver(paramAdapterDataObserver);
    }

    public void setHasStableIds(boolean paramBoolean)
    {
      if (hasObservers())
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      this.mHasStableIds = paramBoolean;
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.unregisterObserver(paramAdapterDataObserver);
    }
  }

  static class AdapterDataObservable extends Observable<RecyclerView.AdapterDataObserver>
  {
    public boolean hasObservers()
    {
      return !this.mObservers.isEmpty();
    }

    public void notifyChanged()
    {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged();
    }

    public void notifyItemMoved(int paramInt1, int paramInt2)
    {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
    }

    public void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }

    public void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
    }

    public void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
    }

    public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
    }
  }

  public static abstract class AdapterDataObserver
  {
    public void onChanged()
    {
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2)
    {
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }

    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
    }

    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
    }
  }

  public static abstract interface ChildDrawingOrderCallback
  {
    public abstract int onGetChildDrawingOrder(int paramInt1, int paramInt2);
  }

  public static class EdgeEffectFactory
  {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;

    protected EdgeEffect createEdgeEffect(RecyclerView paramRecyclerView, int paramInt)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EdgeDirection
    {
    }
  }

  public static abstract class ItemAnimator
  {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private long mAddDuration = 120L;
    private long mChangeDuration = 250L;
    private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
    private ItemAnimatorListener mListener = null;
    private long mMoveDuration = 250L;
    private long mRemoveDuration = 120L;

    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = 0xE & paramViewHolder.mFlags;
      if (paramViewHolder.isInvalid())
        i = 4;
      int j;
      int k;
      do
      {
        do
          return i;
        while ((i & 0x4) != 0);
        j = paramViewHolder.getOldPosition();
        k = paramViewHolder.getAdapterPosition();
      }
      while ((j == -1) || (k == -1) || (j == k));
      return i | 0x800;
    }

    public abstract boolean animateAppearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);

    public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);

    public abstract boolean animateDisappearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);

    public abstract boolean animatePersistence(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
    {
      return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList)
    {
      return canReuseUpdatedViewHolder(paramViewHolder);
    }

    public final void dispatchAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationFinished(paramViewHolder);
      if (this.mListener != null)
        this.mListener.onAnimationFinished(paramViewHolder);
    }

    public final void dispatchAnimationStarted(RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationStarted(paramViewHolder);
    }

    public final void dispatchAnimationsFinished()
    {
      int i = this.mFinishedListeners.size();
      for (int j = 0; j < i; j++)
        ((ItemAnimatorFinishedListener)this.mFinishedListeners.get(j)).onAnimationsFinished();
      this.mFinishedListeners.clear();
    }

    public abstract void endAnimation(RecyclerView.ViewHolder paramViewHolder);

    public abstract void endAnimations();

    public long getAddDuration()
    {
      return this.mAddDuration;
    }

    public long getChangeDuration()
    {
      return this.mChangeDuration;
    }

    public long getMoveDuration()
    {
      return this.mMoveDuration;
    }

    public long getRemoveDuration()
    {
      return this.mRemoveDuration;
    }

    public abstract boolean isRunning();

    public final boolean isRunning(ItemAnimatorFinishedListener paramItemAnimatorFinishedListener)
    {
      boolean bool = isRunning();
      if (paramItemAnimatorFinishedListener != null)
      {
        if (!bool)
          paramItemAnimatorFinishedListener.onAnimationsFinished();
      }
      else
        return bool;
      this.mFinishedListeners.add(paramItemAnimatorFinishedListener);
      return bool;
    }

    public ItemHolderInfo obtainHolderInfo()
    {
      return new ItemHolderInfo();
    }

    public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
    }

    public void onAnimationStarted(RecyclerView.ViewHolder paramViewHolder)
    {
    }

    public ItemHolderInfo recordPostLayoutInformation(RecyclerView.State paramState, RecyclerView.ViewHolder paramViewHolder)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }

    public ItemHolderInfo recordPreLayoutInformation(RecyclerView.State paramState, RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }

    public abstract void runPendingAnimations();

    public void setAddDuration(long paramLong)
    {
      this.mAddDuration = paramLong;
    }

    public void setChangeDuration(long paramLong)
    {
      this.mChangeDuration = paramLong;
    }

    void setListener(ItemAnimatorListener paramItemAnimatorListener)
    {
      this.mListener = paramItemAnimatorListener;
    }

    public void setMoveDuration(long paramLong)
    {
      this.mMoveDuration = paramLong;
    }

    public void setRemoveDuration(long paramLong)
    {
      this.mRemoveDuration = paramLong;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface AdapterChanges
    {
    }

    public static abstract interface ItemAnimatorFinishedListener
    {
      public abstract void onAnimationsFinished();
    }

    static abstract interface ItemAnimatorListener
    {
      public abstract void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder);
    }

    public static class ItemHolderInfo
    {
      public int bottom;
      public int changeFlags;
      public int left;
      public int right;
      public int top;

      public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder)
      {
        return setFrom(paramViewHolder, 0);
      }

      public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder, int paramInt)
      {
        View localView = paramViewHolder.itemView;
        this.left = localView.getLeft();
        this.top = localView.getTop();
        this.right = localView.getRight();
        this.bottom = localView.getBottom();
        return this;
      }
    }
  }

  private class ItemAnimatorRestoreListener
    implements RecyclerView.ItemAnimator.ItemAnimatorListener
  {
    ItemAnimatorRestoreListener()
    {
    }

    public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      paramViewHolder.setIsRecyclable(true);
      if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null))
        paramViewHolder.mShadowedHolder = null;
      paramViewHolder.mShadowingHolder = null;
      if ((!paramViewHolder.shouldBeKeptAsChild()) && (!RecyclerView.this.removeAnimatingView(paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached()))
        RecyclerView.this.removeDetachedView(paramViewHolder.itemView, false);
    }
  }

  public static abstract class ItemDecoration
  {
    @Deprecated
    public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
    }

    @Deprecated
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView)
    {
    }

    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      onDraw(paramCanvas, paramRecyclerView);
    }

    @Deprecated
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView)
    {
    }

    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      onDrawOver(paramCanvas, paramRecyclerView);
    }
  }

  public static abstract class LayoutManager
  {
    boolean mAutoMeasure = false;
    ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
    private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }

      public int getChildCount()
      {
        return RecyclerView.LayoutManager.this.getChildCount();
      }

      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView) + localLayoutParams.rightMargin;
      }

      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView) - localLayoutParams.leftMargin;
      }

      public View getParent()
      {
        return RecyclerView.LayoutManager.this.mRecyclerView;
      }

      public int getParentEnd()
      {
        return RecyclerView.LayoutManager.this.getWidth() - RecyclerView.LayoutManager.this.getPaddingRight();
      }

      public int getParentStart()
      {
        return RecyclerView.LayoutManager.this.getPaddingLeft();
      }
    };
    boolean mIsAttachedToWindow = false;
    private boolean mItemPrefetchEnabled = true;
    private boolean mMeasurementCacheEnabled = true;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations = false;
    RecyclerView.SmoothScroller mSmoothScroller;
    ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
    private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }

      public int getChildCount()
      {
        return RecyclerView.LayoutManager.this.getChildCount();
      }

      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView) + localLayoutParams.bottomMargin;
      }

      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView) - localLayoutParams.topMargin;
      }

      public View getParent()
      {
        return RecyclerView.LayoutManager.this.mRecyclerView;
      }

      public int getParentEnd()
      {
        return RecyclerView.LayoutManager.this.getHeight() - RecyclerView.LayoutManager.this.getPaddingBottom();
      }

      public int getParentStart()
      {
        return RecyclerView.LayoutManager.this.getPaddingTop();
      }
    };
    private int mWidth;
    private int mWidthMode;

    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localViewHolder.isRemoved()))
      {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap()))
          break label128;
        if (!localViewHolder.isScrap())
          break label120;
        localViewHolder.unScrap();
        label68: this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      while (true)
      {
        if (localLayoutParams.mPendingInvalidate)
        {
          localViewHolder.itemView.invalidate();
          localLayoutParams.mPendingInvalidate = false;
        }
        return;
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
        break;
        label120: localViewHolder.clearReturnedFromScrapFlag();
        break label68;
        label128: if (paramView.getParent() == this.mRecyclerView)
        {
          int i = this.mChildHelper.indexOfChild(paramView);
          if (paramInt == -1)
            paramInt = this.mChildHelper.getChildCount();
          if (i == -1)
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView) + this.mRecyclerView.exceptionLabel());
          if (i != paramInt)
            this.mRecyclerView.mLayout.moveView(i, paramInt);
        }
        else
        {
          this.mChildHelper.addView(paramView, paramInt, false);
          localLayoutParams.mInsetsDirty = true;
          if ((this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning()))
            this.mSmoothScroller.onChildAttachedToWindow(paramView);
        }
      }
    }

    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getSize(paramInt1);
      switch (i)
      {
      default:
        j = Math.max(paramInt2, paramInt3);
      case 1073741824:
        return j;
      case -2147483648:
      }
      return Math.min(j, Math.max(paramInt2, paramInt3));
    }

    private void detachViewInternal(int paramInt, View paramView)
    {
      this.mChildHelper.detachViewFromParent(paramInt);
    }

    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i = 0;
      int j = Math.max(0, paramInt1 - paramInt3);
      int k;
      if (paramBoolean)
        if (paramInt4 >= 0)
        {
          k = 1073741824;
          j = paramInt4;
        }
      while (true)
      {
        return View.MeasureSpec.makeMeasureSpec(j, k);
        if (paramInt4 == -1)
        {
          switch (paramInt2)
          {
          default:
            paramInt2 = 0;
          case 1073741824:
          case -2147483648:
          case 0:
          }
          while (true)
          {
            j = i;
            k = paramInt2;
            break;
            i = j;
            continue;
            i = 0;
            paramInt2 = 0;
          }
        }
        if (paramInt4 == -2)
        {
          k = 0;
          j = 0;
          continue;
          if (paramInt4 >= 0)
          {
            k = 1073741824;
            j = paramInt4;
          }
          else if (paramInt4 == -1)
          {
            k = paramInt2;
          }
          else if (paramInt4 == -2)
          {
            if (paramInt2 != -2147483648)
            {
              k = 0;
              if (paramInt2 != 1073741824)
                continue;
            }
            k = -2147483648;
          }
        }
        else
        {
          k = 0;
          j = 0;
        }
      }
    }

    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = 1073741824;
      int j = Math.max(0, paramInt1 - paramInt2);
      if (paramBoolean)
        if (paramInt3 < 0);
      while (true)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, i);
        i = 0;
        paramInt3 = 0;
        continue;
        if (paramInt3 < 0)
          if (paramInt3 == -1)
          {
            paramInt3 = j;
          }
          else if (paramInt3 == -2)
          {
            i = -2147483648;
            paramInt3 = j;
          }
          else
          {
            i = 0;
            paramInt3 = 0;
          }
      }
    }

    private int[] getChildRectangleOnScreenScrollAmount(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth() - getPaddingRight();
      int m = getHeight() - getPaddingBottom();
      int n = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int i1 = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i2 = n + paramRect.width();
      int i3 = i1 + paramRect.height();
      int i4 = Math.min(0, n - i);
      int i5 = Math.min(0, i1 - j);
      int i6 = Math.max(0, i2 - k);
      int i7 = Math.max(0, i3 - m);
      int i9;
      if (getLayoutDirection() == 1)
        if (i6 != 0)
        {
          i9 = i6;
          if (i5 == 0)
            break label220;
        }
      label220: for (int i10 = i5; ; i10 = Math.min(i1 - j, i7))
      {
        arrayOfInt[0] = i9;
        arrayOfInt[1] = i10;
        return arrayOfInt;
        i6 = Math.max(i4, i2 - k);
        break;
        if (i4 != 0);
        for (int i8 = i4; ; i8 = Math.min(n - i, i6))
        {
          i9 = i8;
          break;
        }
      }
    }

    public static Properties getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      Properties localProperties = new Properties();
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      localProperties.orientation = localTypedArray.getInt(R.styleable.RecyclerView_android_orientation, 1);
      localProperties.spanCount = localTypedArray.getInt(R.styleable.RecyclerView_spanCount, 1);
      localProperties.reverseLayout = localTypedArray.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      localProperties.stackFromEnd = localTypedArray.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      localTypedArray.recycle();
      return localProperties;
    }

    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      View localView = paramRecyclerView.getFocusedChild();
      if (localView == null);
      int i;
      int j;
      int k;
      int m;
      Rect localRect;
      do
      {
        return false;
        i = getPaddingLeft();
        j = getPaddingTop();
        k = getWidth() - getPaddingRight();
        m = getHeight() - getPaddingBottom();
        localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
      }
      while ((localRect.left - paramInt1 >= k) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= m) || (localRect.bottom - paramInt2 <= j));
      return true;
    }

    private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = true;
      int i = View.MeasureSpec.getMode(paramInt2);
      int j = View.MeasureSpec.getSize(paramInt2);
      if ((paramInt3 > 0) && (paramInt1 != paramInt3))
        bool = false;
      do
      {
        do
        {
          return bool;
          switch (i)
          {
          case 0:
          default:
            return false;
          case -2147483648:
          case 1073741824:
          }
        }
        while (j >= paramInt1);
        return false;
      }
      while (j == paramInt1);
      return false;
    }

    private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.shouldIgnore())
        return;
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!this.mRecyclerView.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
        return;
      }
      detachViewAt(paramInt);
      paramRecycler.scrapView(paramView);
      this.mRecyclerView.mViewInfoStore.onViewDetached(localViewHolder);
    }

    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }

    public void addDisappearingView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, true);
    }

    public void addView(View paramView)
    {
      addView(paramView, -1);
    }

    public void addView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, false);
    }

    public void assertInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null)
        this.mRecyclerView.assertInLayoutOrScroll(paramString);
    }

    public void assertNotInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null)
        this.mRecyclerView.assertNotInLayoutOrScroll(paramString);
    }

    public void attachView(View paramView)
    {
      attachView(paramView, -1);
    }

    public void attachView(View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }

    public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isRemoved())
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      while (true)
      {
        this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
        return;
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      }
    }

    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (this.mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.mRecyclerView.getItemDecorInsetsForChild(paramView));
    }

    public boolean canScrollHorizontally()
    {
      return false;
    }

    public boolean canScrollVertically()
    {
      return false;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }

    public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
    {
    }

    public void collectInitialPrefetchPositions(int paramInt, LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
    {
    }

    public int computeHorizontalScrollExtent(RecyclerView.State paramState)
    {
      return 0;
    }

    public int computeHorizontalScrollOffset(RecyclerView.State paramState)
    {
      return 0;
    }

    public int computeHorizontalScrollRange(RecyclerView.State paramState)
    {
      return 0;
    }

    public int computeVerticalScrollExtent(RecyclerView.State paramState)
    {
      return 0;
    }

    public int computeVerticalScrollOffset(RecyclerView.State paramState)
    {
      return 0;
    }

    public int computeVerticalScrollRange(RecyclerView.State paramState)
    {
      return 0;
    }

    public void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
    {
      for (int i = -1 + getChildCount(); i >= 0; i--)
        scrapOrRecycleView(paramRecycler, i, getChildAt(i));
    }

    public void detachAndScrapView(View paramView, RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
    }

    public void detachAndScrapViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
    }

    public void detachView(View paramView)
    {
      int i = this.mChildHelper.indexOfChild(paramView);
      if (i >= 0)
        detachViewInternal(i, paramView);
    }

    public void detachViewAt(int paramInt)
    {
      detachViewInternal(paramInt, getChildAt(paramInt));
    }

    void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
    {
      this.mIsAttachedToWindow = true;
      onAttachedToWindow(paramRecyclerView);
    }

    void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      this.mIsAttachedToWindow = false;
      onDetachedFromWindow(paramRecyclerView, paramRecycler);
    }

    public void endAnimation(View paramView)
    {
      if (this.mRecyclerView.mItemAnimator != null)
        this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
    }

    public View findContainingItemView(View paramView)
    {
      if (this.mRecyclerView == null);
      View localView;
      do
      {
        return null;
        localView = this.mRecyclerView.findContainingItemView(paramView);
      }
      while ((localView == null) || (this.mChildHelper.isHidden(localView)));
      return localView;
    }

    public View findViewByPosition(int paramInt)
    {
      int i = getChildCount();
      int j = 0;
      if (j < i)
      {
        View localView = getChildAt(j);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if (localViewHolder == null);
        while ((localViewHolder.getLayoutPosition() != paramInt) || (localViewHolder.shouldIgnore()) || ((!this.mRecyclerView.mState.isPreLayout()) && (localViewHolder.isRemoved())))
        {
          j++;
          break;
        }
        return localView;
      }
      return null;
    }

    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();

    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams))
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }

    public int getBaseline()
    {
      return -1;
    }

    public int getBottomDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
    }

    public View getChildAt(int paramInt)
    {
      if (this.mChildHelper != null)
        return this.mChildHelper.getChildAt(paramInt);
      return null;
    }

    public int getChildCount()
    {
      if (this.mChildHelper != null)
        return this.mChildHelper.getChildCount();
      return 0;
    }

    public boolean getClipToPadding()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.mClipToPadding);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.mAdapter == null));
      while (!canScrollHorizontally())
        return 1;
      return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getDecoratedBottom(View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }

    public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
    {
      RecyclerView.getDecoratedBoundsWithMarginsInt(paramView, paramRect);
    }

    public int getDecoratedLeft(View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }

    public int getDecoratedMeasuredHeight(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
    }

    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredWidth() + localRect.left + localRect.right;
    }

    public int getDecoratedRight(View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }

    public int getDecoratedTop(View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }

    public View getFocusedChild()
    {
      if (this.mRecyclerView == null);
      View localView;
      do
      {
        return null;
        localView = this.mRecyclerView.getFocusedChild();
      }
      while ((localView == null) || (this.mChildHelper.isHidden(localView)));
      return localView;
    }

    public int getHeight()
    {
      return this.mHeight;
    }

    public int getHeightMode()
    {
      return this.mHeightMode;
    }

    public int getItemCount()
    {
      if (this.mRecyclerView != null);
      for (RecyclerView.Adapter localAdapter = this.mRecyclerView.getAdapter(); localAdapter != null; localAdapter = null)
        return localAdapter.getItemCount();
      return 0;
    }

    public int getItemViewType(View paramView)
    {
      return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
    }

    public int getLayoutDirection()
    {
      return ViewCompat.getLayoutDirection(this.mRecyclerView);
    }

    public int getLeftDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
    }

    public int getMinimumHeight()
    {
      return ViewCompat.getMinimumHeight(this.mRecyclerView);
    }

    public int getMinimumWidth()
    {
      return ViewCompat.getMinimumWidth(this.mRecyclerView);
    }

    public int getPaddingBottom()
    {
      if (this.mRecyclerView != null)
        return this.mRecyclerView.getPaddingBottom();
      return 0;
    }

    public int getPaddingEnd()
    {
      if (this.mRecyclerView != null)
        return ViewCompat.getPaddingEnd(this.mRecyclerView);
      return 0;
    }

    public int getPaddingLeft()
    {
      if (this.mRecyclerView != null)
        return this.mRecyclerView.getPaddingLeft();
      return 0;
    }

    public int getPaddingRight()
    {
      if (this.mRecyclerView != null)
        return this.mRecyclerView.getPaddingRight();
      return 0;
    }

    public int getPaddingStart()
    {
      if (this.mRecyclerView != null)
        return ViewCompat.getPaddingStart(this.mRecyclerView);
      return 0;
    }

    public int getPaddingTop()
    {
      if (this.mRecyclerView != null)
        return this.mRecyclerView.getPaddingTop();
      return 0;
    }

    public int getPosition(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }

    public int getRightDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.mAdapter == null));
      while (!canScrollVertically())
        return 1;
      return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getSelectionModeForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }

    public int getTopDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
    }

    public void getTransformedBoundingBox(View paramView, boolean paramBoolean, Rect paramRect)
    {
      if (paramBoolean)
      {
        Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
        paramRect.set(-localRect.left, -localRect.top, paramView.getWidth() + localRect.right, paramView.getHeight() + localRect.bottom);
      }
      while (true)
      {
        if (this.mRecyclerView != null)
        {
          Matrix localMatrix = paramView.getMatrix();
          if ((localMatrix != null) && (!localMatrix.isIdentity()))
          {
            RectF localRectF = this.mRecyclerView.mTempRectF;
            localRectF.set(paramRect);
            localMatrix.mapRect(localRectF);
            paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
          }
        }
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        return;
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
    }

    public int getWidth()
    {
      return this.mWidth;
    }

    public int getWidthMode()
    {
      return this.mWidthMode;
    }

    boolean hasFlexibleChildInBothOrientations()
    {
      int i = getChildCount();
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          ViewGroup.LayoutParams localLayoutParams = getChildAt(j).getLayoutParams();
          if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0))
            bool = true;
        }
        else
        {
          return bool;
        }
      }
    }

    public boolean hasFocus()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.hasFocus());
    }

    public void ignoreView(View paramView)
    {
      if ((paramView.getParent() != this.mRecyclerView) || (this.mRecyclerView.indexOfChild(paramView) == -1))
        throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      localViewHolder.addFlags(128);
      this.mRecyclerView.mViewInfoStore.removeViewHolder(localViewHolder);
    }

    public boolean isAttachedToWindow()
    {
      return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled()
    {
      return this.mAutoMeasure;
    }

    public boolean isFocused()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.isFocused());
    }

    public final boolean isItemPrefetchEnabled()
    {
      return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return false;
    }

    public boolean isMeasurementCacheEnabled()
    {
      return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling()
    {
      return (this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning());
    }

    public boolean isViewPartiallyVisible(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool1 = true;
      boolean bool2;
      if ((this.mHorizontalBoundCheck.isViewWithinBoundFlags(paramView, 24579)) && (this.mVerticalBoundCheck.isViewWithinBoundFlags(paramView, 24579)))
      {
        bool2 = bool1;
        if (!paramBoolean1)
          break label52;
        bool1 = bool2;
      }
      label52: 
      while (!bool2)
      {
        return bool1;
        bool2 = false;
        break;
      }
      return false;
    }

    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }

    public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.mDecorInsets;
      paramView.layout(paramInt1 + localRect.left + localLayoutParams.leftMargin, paramInt2 + localRect.top + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }

    public void measureChild(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int i = paramInt1 + (localRect.left + localRect.right);
      int j = paramInt2 + (localRect.top + localRect.bottom);
      int k = getChildMeasureSpec(getWidth(), getWidthMode(), i + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally());
      int m = getChildMeasureSpec(getHeight(), getHeightMode(), j + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, k, m, localLayoutParams))
        paramView.measure(k, m);
    }

    public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int i = paramInt1 + (localRect.left + localRect.right);
      int j = paramInt2 + (localRect.top + localRect.bottom);
      int k = getChildMeasureSpec(getWidth(), getWidthMode(), i + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, canScrollHorizontally());
      int m = getChildMeasureSpec(getHeight(), getHeightMode(), j + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, k, m, localLayoutParams))
        paramView.measure(k, m);
    }

    public void moveView(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null)
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.mRecyclerView.toString());
      detachViewAt(paramInt1);
      attachView(localView, paramInt2);
    }

    public void offsetChildrenHorizontal(int paramInt)
    {
      if (this.mRecyclerView != null)
        this.mRecyclerView.offsetChildrenHorizontal(paramInt);
    }

    public void offsetChildrenVertical(int paramInt)
    {
      if (this.mRecyclerView != null)
        this.mRecyclerView.offsetChildrenVertical(paramInt);
    }

    public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
    {
    }

    public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }

    public void onAttachedToWindow(RecyclerView paramRecyclerView)
    {
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView paramRecyclerView)
    {
    }

    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      onDetachedFromWindow(paramRecyclerView);
    }

    public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return null;
    }

    public void onInitializeAccessibilityEvent(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityEvent paramAccessibilityEvent)
    {
      int i = 1;
      if ((this.mRecyclerView == null) || (paramAccessibilityEvent == null))
        return;
      if ((this.mRecyclerView.canScrollVertically(i)) || (this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)) || (this.mRecyclerView.canScrollHorizontally(i)));
      while (true)
      {
        paramAccessibilityEvent.setScrollable(i);
        if (this.mRecyclerView.mAdapter == null)
          break;
        paramAccessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
        return;
        int j = 0;
      }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityEvent);
    }

    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      int i;
      if (canScrollVertically())
      {
        i = getPosition(paramView);
        if (!canScrollHorizontally())
          break label51;
      }
      label51: for (int j = getPosition(paramView); ; j = 0)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
        return;
        i = 0;
        break;
      }
    }

    void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!this.mChildHelper.isHidden(localViewHolder.itemView)))
        onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
    }

    public View onInterceptFocusSearch(View paramView, int paramInt)
    {
      return null;
    }

    public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
    }

    public void onItemsChanged(RecyclerView paramRecyclerView)
    {
    }

    public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
    }

    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
    }

    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }

    public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void onLayoutCompleted(RecyclerView.State paramState)
    {
    }

    public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
    {
      this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
    }

    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.State paramState, View paramView1, View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }

    @Deprecated
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.isComputingLayout());
    }

    public void onRestoreInstanceState(Parcelable paramParcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
      return null;
    }

    public void onScrollStateChanged(int paramInt)
    {
    }

    void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if (this.mSmoothScroller == paramSmoothScroller)
        this.mSmoothScroller = null;
    }

    boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
    {
      return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramInt, paramBundle);
    }

    public boolean performAccessibilityAction(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, Bundle paramBundle)
    {
      if (this.mRecyclerView == null);
      int k;
      int j;
      do
      {
        return false;
        switch (paramInt)
        {
        default:
          k = 0;
          j = 0;
        case 8192:
        case 4096:
        }
      }
      while ((j == 0) && (k == 0));
      this.mRecyclerView.smoothScrollBy(k, j);
      return true;
      if (this.mRecyclerView.canScrollVertically(-1));
      for (int i = -(getHeight() - getPaddingTop() - getPaddingBottom()); ; i = 0)
      {
        if (this.mRecyclerView.canScrollHorizontally(-1))
        {
          int n = -(getWidth() - getPaddingLeft() - getPaddingRight());
          j = i;
          k = n;
          break;
          if (!this.mRecyclerView.canScrollVertically(1))
            break label207;
        }
        label207: for (i = getHeight() - getPaddingTop() - getPaddingBottom(); ; i = 0)
        {
          if (this.mRecyclerView.canScrollHorizontally(1))
          {
            int m = getWidth() - getPaddingLeft() - getPaddingRight();
            j = i;
            k = m;
            break;
          }
          j = i;
          k = 0;
          break;
        }
      }
    }

    public boolean performAccessibilityActionForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }

    boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramInt, paramBundle);
    }

    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null)
        ViewCompat.postOnAnimation(this.mRecyclerView, paramRunnable);
    }

    public void removeAllViews()
    {
      for (int i = -1 + getChildCount(); i >= 0; i--)
        this.mChildHelper.removeViewAt(i);
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
    {
      for (int i = -1 + getChildCount(); i >= 0; i--)
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore())
          removeAndRecycleViewAt(i, paramRecycler);
    }

    void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
    {
      int i = paramRecycler.getScrapCount();
      int j = i - 1;
      if (j >= 0)
      {
        View localView = paramRecycler.getScrapViewAt(j);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if (localViewHolder.shouldIgnore());
        while (true)
        {
          j--;
          break;
          localViewHolder.setIsRecyclable(false);
          if (localViewHolder.isTmpDetached())
            this.mRecyclerView.removeDetachedView(localView, false);
          if (this.mRecyclerView.mItemAnimator != null)
            this.mRecyclerView.mItemAnimator.endAnimation(localViewHolder);
          localViewHolder.setIsRecyclable(true);
          paramRecycler.quickRecycleScrapView(localView);
        }
      }
      paramRecycler.clearScrap();
      if (i > 0)
        this.mRecyclerView.invalidate();
    }

    public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
    {
      removeView(paramView);
      paramRecycler.recycleView(paramView);
    }

    public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramRecycler.recycleView(localView);
    }

    public boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null)
        return this.mRecyclerView.removeCallbacks(paramRunnable);
      return false;
    }

    public void removeDetachedView(View paramView)
    {
      this.mRecyclerView.removeDetachedView(paramView, false);
    }

    public void removeView(View paramView)
    {
      this.mChildHelper.removeView(paramView);
    }

    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null)
        this.mChildHelper.removeViewAt(paramInt);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      int[] arrayOfInt = getChildRectangleOnScreenScrollAmount(paramRecyclerView, paramView, paramRect, paramBoolean1);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      boolean bool1;
      if (paramBoolean2)
      {
        boolean bool2 = isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j);
        bool1 = false;
        if (!bool2);
      }
      else if (i == 0)
      {
        bool1 = false;
        if (j == 0);
      }
      else
      {
        if (!paramBoolean1)
          break label79;
        paramRecyclerView.scrollBy(i, j);
      }
      while (true)
      {
        bool1 = true;
        return bool1;
        label79: paramRecyclerView.smoothScrollBy(i, j);
      }
    }

    public void requestLayout()
    {
      if (this.mRecyclerView != null)
        this.mRecyclerView.requestLayout();
    }

    public void requestSimpleAnimationsInNextLayout()
    {
      this.mRequestedSimpleAnimations = true;
    }

    public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }

    public void scrollToPosition(int paramInt)
    {
    }

    public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }

    @Deprecated
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      this.mAutoMeasure = paramBoolean;
    }

    void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }

    public final void setItemPrefetchEnabled(boolean paramBoolean)
    {
      if (paramBoolean != this.mItemPrefetchEnabled)
      {
        this.mItemPrefetchEnabled = paramBoolean;
        this.mPrefetchMaxCountObserved = 0;
        if (this.mRecyclerView != null)
          this.mRecyclerView.mRecycler.updateViewCacheSize();
      }
    }

    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((this.mWidthMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC))
        this.mWidth = 0;
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((this.mHeightMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC))
        this.mHeight = 0;
    }

    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      this.mRecyclerView.setMeasuredDimension(paramInt1, paramInt2);
    }

    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width() + getPaddingLeft() + getPaddingRight();
      int j = paramRect.height() + getPaddingTop() + getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i, getMinimumWidth()), chooseSize(paramInt2, j, getMinimumHeight()));
    }

    void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
    {
      int i = 2147483647;
      int j = -2147483648;
      int k = getChildCount();
      if (k == 0)
      {
        this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int m = 0;
      int n = j;
      int i1 = i;
      while (m < k)
      {
        View localView = getChildAt(m);
        Rect localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
        if (localRect.left < i1)
          i1 = localRect.left;
        if (localRect.right > n)
          n = localRect.right;
        if (localRect.top < i)
          i = localRect.top;
        if (localRect.bottom > j)
          j = localRect.bottom;
        m++;
      }
      this.mRecyclerView.mTempRect.set(i1, i, n, j);
      setMeasuredDimension(this.mRecyclerView.mTempRect, paramInt1, paramInt2);
    }

    public void setMeasurementCacheEnabled(boolean paramBoolean)
    {
      this.mMeasurementCacheEnabled = paramBoolean;
    }

    void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.mRecyclerView = null;
        this.mChildHelper = null;
        this.mWidth = 0;
      }
      for (this.mHeight = 0; ; this.mHeight = paramRecyclerView.getHeight())
      {
        this.mWidthMode = 1073741824;
        this.mHeightMode = 1073741824;
        return;
        this.mRecyclerView = paramRecyclerView;
        this.mChildHelper = paramRecyclerView.mChildHelper;
        this.mWidth = paramRecyclerView.getWidth();
      }
    }

    boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }

    boolean shouldMeasureTwice()
    {
      return false;
    }

    boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }

    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if ((this.mSmoothScroller != null) && (paramSmoothScroller != this.mSmoothScroller) && (this.mSmoothScroller.isRunning()))
        this.mSmoothScroller.stop();
      this.mSmoothScroller = paramSmoothScroller;
      this.mSmoothScroller.start(this.mRecyclerView, this);
    }

    public void stopIgnoringView(View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      localViewHolder.stopIgnoring();
      localViewHolder.resetInternal();
      localViewHolder.addFlags(4);
    }

    void stopSmoothScroller()
    {
      if (this.mSmoothScroller != null)
        this.mSmoothScroller.stop();
    }

    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }

    public static abstract interface LayoutPrefetchRegistry
    {
      public abstract void addPosition(int paramInt1, int paramInt2);
    }

    public static class Properties
    {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
    }
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    final Rect mDecorInsets = new Rect();
    boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.ViewHolder mViewHolder;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public int getViewAdapterPosition()
    {
      return this.mViewHolder.getAdapterPosition();
    }

    public int getViewLayoutPosition()
    {
      return this.mViewHolder.getLayoutPosition();
    }

    @Deprecated
    public int getViewPosition()
    {
      return this.mViewHolder.getPosition();
    }

    public boolean isItemChanged()
    {
      return this.mViewHolder.isUpdated();
    }

    public boolean isItemRemoved()
    {
      return this.mViewHolder.isRemoved();
    }

    public boolean isViewInvalid()
    {
      return this.mViewHolder.isInvalid();
    }

    public boolean viewNeedsUpdate()
    {
      return this.mViewHolder.needsUpdate();
    }
  }

  public static abstract interface OnChildAttachStateChangeListener
  {
    public abstract void onChildViewAttachedToWindow(View paramView);

    public abstract void onChildViewDetachedFromWindow(View paramView);
  }

  public static abstract class OnFlingListener
  {
    public abstract boolean onFling(int paramInt1, int paramInt2);
  }

  public static abstract interface OnItemTouchListener
  {
    public abstract boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);

    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);

    public abstract void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }

  public static abstract class OnScrollListener
  {
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
    }

    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Orientation
  {
  }

  public static class RecycledViewPool
  {
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount = 0;
    SparseArray<ScrapData> mScrap = new SparseArray();

    private ScrapData getScrapDataForType(int paramInt)
    {
      ScrapData localScrapData = (ScrapData)this.mScrap.get(paramInt);
      if (localScrapData == null)
      {
        localScrapData = new ScrapData();
        this.mScrap.put(paramInt, localScrapData);
      }
      return localScrapData;
    }

    void attach()
    {
      this.mAttachCount = (1 + this.mAttachCount);
    }

    public void clear()
    {
      for (int i = 0; i < this.mScrap.size(); i++)
        ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap.clear();
    }

    void detach()
    {
      this.mAttachCount = (-1 + this.mAttachCount);
    }

    void factorInBindTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mBindRunningAverageNs = runningAverage(localScrapData.mBindRunningAverageNs, paramLong);
    }

    void factorInCreateTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mCreateRunningAverageNs = runningAverage(localScrapData.mCreateRunningAverageNs, paramLong);
    }

    public RecyclerView.ViewHolder getRecycledView(int paramInt)
    {
      ScrapData localScrapData = (ScrapData)this.mScrap.get(paramInt);
      if ((localScrapData != null) && (!localScrapData.mScrapHeap.isEmpty()))
      {
        ArrayList localArrayList = localScrapData.mScrapHeap;
        return (RecyclerView.ViewHolder)localArrayList.remove(-1 + localArrayList.size());
      }
      return null;
    }

    public int getRecycledViewCount(int paramInt)
    {
      return getScrapDataForType(paramInt).mScrapHeap.size();
    }

    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      if (paramAdapter1 != null)
        detach();
      if ((!paramBoolean) && (this.mAttachCount == 0))
        clear();
      if (paramAdapter2 != null)
        attach();
    }

    public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = paramViewHolder.getItemViewType();
      ArrayList localArrayList = getScrapDataForType(i).mScrapHeap;
      if (((ScrapData)this.mScrap.get(i)).mMaxScrap <= localArrayList.size())
        return;
      paramViewHolder.resetInternal();
      localArrayList.add(paramViewHolder);
    }

    long runningAverage(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L)
        return paramLong2;
      return 3L * (paramLong1 / 4L) + paramLong2 / 4L;
    }

    public void setMaxRecycledViews(int paramInt1, int paramInt2)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt1);
      localScrapData.mMaxScrap = paramInt2;
      ArrayList localArrayList = localScrapData.mScrapHeap;
      while (localArrayList.size() > paramInt2)
        localArrayList.remove(-1 + localArrayList.size());
    }

    int size()
    {
      int i = 0;
      int j = 0;
      while (i < this.mScrap.size())
      {
        ArrayList localArrayList = ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap;
        if (localArrayList != null)
          j += localArrayList.size();
        i++;
      }
      return j;
    }

    boolean willBindInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mBindRunningAverageNs;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }

    boolean willCreateInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mCreateRunningAverageNs;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }

    static class ScrapData
    {
      long mBindRunningAverageNs = 0L;
      long mCreateRunningAverageNs = 0L;
      int mMaxScrap = 5;
      final ArrayList<RecyclerView.ViewHolder> mScrapHeap = new ArrayList();
    }
  }

  public final class Recycler
  {
    static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
    final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
    ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
    RecyclerView.RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax = 2;
    private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax = 2;

    public Recycler()
    {
    }

    private void attachAccessibilityDelegateOnBind(RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.this.isAccessibilityEnabled())
      {
        View localView = paramViewHolder.itemView;
        if (ViewCompat.getImportantForAccessibility(localView) == 0)
          ViewCompat.setImportantForAccessibility(localView, 1);
        if (!ViewCompat.hasAccessibilityDelegate(localView))
        {
          paramViewHolder.addFlags(16384);
          ViewCompat.setAccessibilityDelegate(localView, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
        }
      }
    }

    private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder.itemView instanceof ViewGroup))
        invalidateDisplayListInt((ViewGroup)paramViewHolder.itemView, false);
    }

    private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      for (int i = -1 + paramViewGroup.getChildCount(); i >= 0; i--)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup))
          invalidateDisplayListInt((ViewGroup)localView, true);
      }
      if (!paramBoolean)
        return;
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      int j = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(j);
    }

    private boolean tryBindViewHolderByDeadline(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, long paramLong)
    {
      paramViewHolder.mOwnerRecyclerView = RecyclerView.this;
      int i = paramViewHolder.getItemViewType();
      long l1 = RecyclerView.this.getNanoTime();
      if ((paramLong != 9223372036854775807L) && (!this.mRecyclerPool.willBindInTime(i, l1, paramLong)))
        return false;
      RecyclerView.this.mAdapter.bindViewHolder(paramViewHolder, paramInt1);
      long l2 = RecyclerView.this.getNanoTime();
      this.mRecyclerPool.factorInBindTime(paramViewHolder.getItemViewType(), l2 - l1);
      attachAccessibilityDelegateOnBind(paramViewHolder);
      if (RecyclerView.this.mState.isPreLayout())
        paramViewHolder.mPreLayoutPosition = paramInt2;
      return true;
    }

    void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
    {
      RecyclerView.clearNestedRecyclerViewIfNotNested(paramViewHolder);
      if (paramViewHolder.hasAnyOfTheFlags(16384))
      {
        paramViewHolder.setFlags(0, 16384);
        ViewCompat.setAccessibilityDelegate(paramViewHolder.itemView, null);
      }
      if (paramBoolean)
        dispatchViewRecycled(paramViewHolder);
      paramViewHolder.mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(paramViewHolder);
    }

    public void bindViewToPosition(View paramView, int paramInt)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder == null)
        throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
      int i = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
      if ((i < 0) || (i >= RecyclerView.this.mAdapter.getItemCount()))
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i + ")." + "state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      tryBindViewHolderByDeadline(localViewHolder, i, paramInt, 9223372036854775807L);
      ViewGroup.LayoutParams localLayoutParams = localViewHolder.itemView.getLayoutParams();
      RecyclerView.LayoutParams localLayoutParams1;
      if (localLayoutParams == null)
      {
        localLayoutParams1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
        localViewHolder.itemView.setLayoutParams(localLayoutParams1);
        localLayoutParams1.mInsetsDirty = true;
        localLayoutParams1.mViewHolder = localViewHolder;
        if (localViewHolder.itemView.getParent() != null)
          break label273;
      }
      label273: for (boolean bool = true; ; bool = false)
      {
        localLayoutParams1.mPendingInvalidate = bool;
        return;
        if (!RecyclerView.this.checkLayoutParams(localLayoutParams))
        {
          localLayoutParams1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(localLayoutParams);
          localViewHolder.itemView.setLayoutParams(localLayoutParams1);
          break;
        }
        localLayoutParams1 = (RecyclerView.LayoutParams)localLayoutParams;
        break;
      }
    }

    public void clear()
    {
      this.mAttachedScrap.clear();
      recycleAndClearCachedViews();
    }

    void clearOldPositions()
    {
      int i = 0;
      int j = this.mCachedViews.size();
      for (int k = 0; k < j; k++)
        ((RecyclerView.ViewHolder)this.mCachedViews.get(k)).clearOldPosition();
      int m = this.mAttachedScrap.size();
      for (int n = 0; n < m; n++)
        ((RecyclerView.ViewHolder)this.mAttachedScrap.get(n)).clearOldPosition();
      if (this.mChangedScrap != null)
      {
        int i1 = this.mChangedScrap.size();
        while (i < i1)
        {
          ((RecyclerView.ViewHolder)this.mChangedScrap.get(i)).clearOldPosition();
          i++;
        }
      }
    }

    void clearScrap()
    {
      this.mAttachedScrap.clear();
      if (this.mChangedScrap != null)
        this.mChangedScrap.clear();
    }

    public int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.mState.getItemCount()))
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State " + "item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      if (!RecyclerView.this.mState.isPreLayout())
        return paramInt;
      return RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
    }

    void dispatchViewRecycled(RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.this.mRecyclerListener != null)
        RecyclerView.this.mRecyclerListener.onViewRecycled(paramViewHolder);
      if (RecyclerView.this.mAdapter != null)
        RecyclerView.this.mAdapter.onViewRecycled(paramViewHolder);
      if (RecyclerView.this.mState != null)
        RecyclerView.this.mViewInfoStore.removeViewHolder(paramViewHolder);
    }

    RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
    {
      int i = 0;
      int j;
      if (this.mChangedScrap != null)
      {
        j = this.mChangedScrap.size();
        if (j != 0);
      }
      else
      {
        return null;
      }
      for (int k = 0; k < j; k++)
      {
        RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)this.mChangedScrap.get(k);
        if ((!localViewHolder2.wasReturnedFromScrap()) && (localViewHolder2.getLayoutPosition() == paramInt))
        {
          localViewHolder2.addFlags(32);
          return localViewHolder2;
        }
      }
      if (RecyclerView.this.mAdapter.hasStableIds())
      {
        int m = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
        if ((m > 0) && (m < RecyclerView.this.mAdapter.getItemCount()))
        {
          long l = RecyclerView.this.mAdapter.getItemId(m);
          while (i < j)
          {
            RecyclerView.ViewHolder localViewHolder1 = (RecyclerView.ViewHolder)this.mChangedScrap.get(i);
            if ((!localViewHolder1.wasReturnedFromScrap()) && (localViewHolder1.getItemId() == l))
            {
              localViewHolder1.addFlags(32);
              return localViewHolder1;
            }
            i++;
          }
        }
      }
      return null;
    }

    RecyclerView.RecycledViewPool getRecycledViewPool()
    {
      if (this.mRecyclerPool == null)
        this.mRecyclerPool = new RecyclerView.RecycledViewPool();
      return this.mRecyclerPool;
    }

    int getScrapCount()
    {
      return this.mAttachedScrap.size();
    }

    public List<RecyclerView.ViewHolder> getScrapList()
    {
      return this.mUnmodifiableAttachedScrap;
    }

    RecyclerView.ViewHolder getScrapOrCachedViewForId(long paramLong, int paramInt, boolean paramBoolean)
    {
      RecyclerView.ViewHolder localViewHolder;
      for (int i = -1 + this.mAttachedScrap.size(); i >= 0; i--)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
        if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            localViewHolder.addFlags(32);
            if ((localViewHolder.isRemoved()) && (!RecyclerView.this.mState.isPreLayout()))
              localViewHolder.setFlags(2, 14);
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            this.mAttachedScrap.remove(i);
            RecyclerView.this.removeDetachedView(localViewHolder.itemView, false);
            quickRecycleScrapView(localViewHolder.itemView);
          }
        }
      }
      for (int j = -1 + this.mCachedViews.size(); ; j--)
      {
        if (j < 0)
          break label225;
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localViewHolder.getItemId() == paramLong)
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            if (paramBoolean)
              break;
            this.mCachedViews.remove(j);
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            recycleCachedViewAt(j);
            return null;
          }
        }
      }
      label225: return null;
    }

    RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int paramInt, boolean paramBoolean)
    {
      int i = 0;
      int j = this.mAttachedScrap.size();
      RecyclerView.ViewHolder localViewHolder1;
      for (int k = 0; k < j; k++)
      {
        localViewHolder1 = (RecyclerView.ViewHolder)this.mAttachedScrap.get(k);
        if ((!localViewHolder1.wasReturnedFromScrap()) && (localViewHolder1.getLayoutPosition() == paramInt) && (!localViewHolder1.isInvalid()) && ((RecyclerView.this.mState.mInPreLayout) || (!localViewHolder1.isRemoved())))
        {
          localViewHolder1.addFlags(32);
          return localViewHolder1;
        }
      }
      if (!paramBoolean)
      {
        View localView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(paramInt);
        if (localView != null)
        {
          RecyclerView.ViewHolder localViewHolder2 = RecyclerView.getChildViewHolderInt(localView);
          RecyclerView.this.mChildHelper.unhide(localView);
          int n = RecyclerView.this.mChildHelper.indexOfChild(localView);
          if (n == -1)
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localViewHolder2 + RecyclerView.this.exceptionLabel());
          RecyclerView.this.mChildHelper.detachViewFromParent(n);
          scrapView(localView);
          localViewHolder2.addFlags(8224);
          return localViewHolder2;
        }
      }
      int m = this.mCachedViews.size();
      while (true)
      {
        if (i >= m)
          break label293;
        localViewHolder1 = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if ((!localViewHolder1.isInvalid()) && (localViewHolder1.getLayoutPosition() == paramInt))
        {
          if (paramBoolean)
            break;
          this.mCachedViews.remove(i);
          return localViewHolder1;
        }
        i++;
      }
      label293: return null;
    }

    View getScrapViewAt(int paramInt)
    {
      return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
    }

    public View getViewForPosition(int paramInt)
    {
      return getViewForPosition(paramInt, false);
    }

    View getViewForPosition(int paramInt, boolean paramBoolean)
    {
      return tryGetViewHolderForPositionByDeadline(paramInt, paramBoolean, 9223372036854775807L).itemView;
    }

    void markItemDecorInsetsDirty()
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(j)).itemView.getLayoutParams();
        if (localLayoutParams != null)
          localLayoutParams.mInsetsDirty = true;
      }
    }

    void markKnownViewsInvalid()
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localViewHolder != null)
        {
          localViewHolder.addFlags(6);
          localViewHolder.addChangePayload(null);
        }
      }
      if ((RecyclerView.this.mAdapter == null) || (!RecyclerView.this.mAdapter.hasStableIds()))
        recycleAndClearCachedViews();
    }

    void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if ((localViewHolder != null) && (localViewHolder.mPosition >= paramInt1))
          localViewHolder.offsetPosition(paramInt2, true);
      }
    }

    void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      int n;
      label25: RecyclerView.ViewHolder localViewHolder;
      if (paramInt1 < paramInt2)
      {
        i = -1;
        j = paramInt2;
        k = paramInt1;
        int m = this.mCachedViews.size();
        n = 0;
        if (n >= m)
          return;
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(n);
        if ((localViewHolder != null) && (localViewHolder.mPosition >= k) && (localViewHolder.mPosition <= j))
          break label88;
      }
      while (true)
      {
        n++;
        break label25;
        i = 1;
        j = paramInt1;
        k = paramInt2;
        break;
        label88: if (localViewHolder.mPosition == paramInt1)
          localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
        else
          localViewHolder.offsetPosition(i, false);
      }
    }

    void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = paramInt1 + paramInt2;
      int j = -1 + this.mCachedViews.size();
      if (j >= 0)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localViewHolder != null)
        {
          if (localViewHolder.mPosition < i)
            break label64;
          localViewHolder.offsetPosition(-paramInt2, paramBoolean);
        }
        while (true)
        {
          j--;
          break;
          label64: if (localViewHolder.mPosition >= paramInt1)
          {
            localViewHolder.addFlags(8);
            recycleCachedViewAt(j);
          }
        }
      }
    }

    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      clear();
      getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
    }

    void quickRecycleScrapView(View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      localViewHolder.mScrapContainer = null;
      localViewHolder.mInChangeScrap = false;
      localViewHolder.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(localViewHolder);
    }

    void recycleAndClearCachedViews()
    {
      for (int i = -1 + this.mCachedViews.size(); i >= 0; i--)
        recycleCachedViewAt(i);
      this.mCachedViews.clear();
      if (RecyclerView.ALLOW_THREAD_GAP_WORK)
        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
    }

    void recycleCachedViewAt(int paramInt)
    {
      addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(paramInt), true);
      this.mCachedViews.remove(paramInt);
    }

    public void recycleView(View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isTmpDetached())
        RecyclerView.this.removeDetachedView(paramView, false);
      if (localViewHolder.isScrap())
        localViewHolder.unScrap();
      while (true)
      {
        recycleViewHolderInternal(localViewHolder);
        return;
        if (localViewHolder.wasReturnedFromScrap())
          localViewHolder.clearReturnedFromScrapFlag();
      }
    }

    void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder.isScrap()) || (paramViewHolder.itemView.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramViewHolder.isScrap()).append(" isAttached:");
        if (paramViewHolder.itemView.getParent() != null);
        for (boolean bool1 = true; ; bool1 = false)
          throw new IllegalArgumentException(bool1 + RecyclerView.this.exceptionLabel());
      }
      if (paramViewHolder.isTmpDetached())
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramViewHolder + RecyclerView.this.exceptionLabel());
      if (paramViewHolder.shouldIgnore())
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
      boolean bool2 = paramViewHolder.doesTransientStatePreventRecycling();
      int i;
      int n;
      label305: int j;
      if ((RecyclerView.this.mAdapter != null) && (bool2) && (RecyclerView.this.mAdapter.onFailedToRecycleView(paramViewHolder)))
      {
        i = 1;
        if ((i == 0) && (!paramViewHolder.isRecyclable()))
          break label428;
        if ((this.mViewCacheMax <= 0) || (paramViewHolder.hasAnyOfTheFlags(526)))
          break label422;
        int m = this.mCachedViews.size();
        if ((m >= this.mViewCacheMax) && (m > 0))
        {
          recycleCachedViewAt(0);
          m--;
        }
        if ((RecyclerView.ALLOW_THREAD_GAP_WORK) && (m > 0) && (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(paramViewHolder.mPosition)))
        {
          n = m - 1;
          if (n >= 0)
          {
            int i1 = ((RecyclerView.ViewHolder)this.mCachedViews.get(n)).mPosition;
            if (RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(i1))
              break label416;
          }
          m = n + 1;
        }
        this.mCachedViews.add(m, paramViewHolder);
        j = 1;
        label361: k = 0;
        if (j == 0)
          addViewHolderToRecycledViewPool(paramViewHolder, true);
      }
      for (int k = 1; ; k = 0)
      {
        RecyclerView.this.mViewInfoStore.removeViewHolder(paramViewHolder);
        if ((j == 0) && (k == 0) && (bool2))
          paramViewHolder.mOwnerRecyclerView = null;
        return;
        i = 0;
        break;
        label416: n--;
        break label305;
        label422: j = 0;
        break label361;
        label428: j = 0;
      }
    }

    void recycleViewInternal(View paramView)
    {
      recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(paramView));
    }

    void scrapView(View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if ((localViewHolder.hasAnyOfTheFlags(12)) || (!localViewHolder.isUpdated()) || (RecyclerView.this.canReuseUpdatedViewHolder(localViewHolder)))
      {
        if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!RecyclerView.this.mAdapter.hasStableIds()))
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
        localViewHolder.setScrapContainer(this, false);
        this.mAttachedScrap.add(localViewHolder);
        return;
      }
      if (this.mChangedScrap == null)
        this.mChangedScrap = new ArrayList();
      localViewHolder.setScrapContainer(this, true);
      this.mChangedScrap.add(localViewHolder);
    }

    void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
    {
      if (this.mRecyclerPool != null)
        this.mRecyclerPool.detach();
      this.mRecyclerPool = paramRecycledViewPool;
      if ((this.mRecyclerPool != null) && (RecyclerView.this.getAdapter() != null))
        this.mRecyclerPool.attach();
    }

    void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
    {
      this.mViewCacheExtension = paramViewCacheExtension;
    }

    public void setViewCacheSize(int paramInt)
    {
      this.mRequestedCacheMax = paramInt;
      updateViewCacheSize();
    }

    RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int paramInt, boolean paramBoolean, long paramLong)
    {
      boolean bool1 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.mState.getItemCount()))
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      int i2;
      int i;
      RecyclerView.ViewHolder localViewHolder1;
      if (RecyclerView.this.mState.isPreLayout())
      {
        RecyclerView.ViewHolder localViewHolder3 = getChangedScrapViewForPosition(paramInt);
        if (localViewHolder3 != null)
        {
          i2 = bool1;
          i = i2;
          localViewHolder1 = localViewHolder3;
        }
      }
      while (true)
      {
        if (localViewHolder1 == null)
        {
          localViewHolder1 = getScrapOrHiddenOrCachedHolderForPosition(paramInt, paramBoolean);
          if (localViewHolder1 != null)
          {
            if (validateViewHolderForOffsetPosition(localViewHolder1))
              break label327;
            if (!paramBoolean)
            {
              localViewHolder1.addFlags(4);
              if (!localViewHolder1.isScrap())
                break label311;
              RecyclerView.this.removeDetachedView(localViewHolder1.itemView, false);
              localViewHolder1.unScrap();
              label188: recycleViewHolderInternal(localViewHolder1);
            }
            localViewHolder1 = null;
          }
        }
        label311: label327: int i1;
        RecyclerView.ViewHolder localViewHolder2;
        while (true)
          if (localViewHolder1 == null)
          {
            int m = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
            if ((m < 0) || (m >= RecyclerView.this.mAdapter.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + m + ")." + "state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
              i2 = 0;
              break;
              if (!localViewHolder1.wasReturnedFromScrap())
                break label188;
              localViewHolder1.clearReturnedFromScrapFlag();
              break label188;
              i = bool1;
              continue;
            }
            int n = RecyclerView.this.mAdapter.getItemViewType(m);
            if (RecyclerView.this.mAdapter.hasStableIds())
            {
              localViewHolder1 = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(m), n, paramBoolean);
              if (localViewHolder1 != null)
              {
                localViewHolder1.mPosition = m;
                i1 = bool1;
                if ((localViewHolder1 == null) && (this.mViewCacheExtension != null))
                {
                  View localView = this.mViewCacheExtension.getViewForPositionAndType(this, paramInt, n);
                  if (localView != null)
                  {
                    localViewHolder1 = RecyclerView.this.getChildViewHolder(localView);
                    if (localViewHolder1 == null)
                      throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                    if (localViewHolder1.shouldIgnore())
                      throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                  }
                }
                if (localViewHolder1 == null)
                {
                  localViewHolder1 = getRecycledViewPool().getRecycledView(n);
                  if (localViewHolder1 != null)
                  {
                    localViewHolder1.resetInternal();
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                      invalidateDisplayListInt(localViewHolder1);
                  }
                }
                if (localViewHolder1 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != 9223372036854775807L) && (!this.mRecyclerPool.willCreateInTime(n, l1, paramLong)))
                    return null;
                  localViewHolder1 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, n);
                  if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                  {
                    RecyclerView localRecyclerView = RecyclerView.findNestedRecyclerView(localViewHolder1.itemView);
                    if (localRecyclerView != null)
                      localViewHolder1.mNestedRecyclerView = new WeakReference(localRecyclerView);
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.mRecyclerPool.factorInCreateTime(n, l2 - l1);
                }
                localViewHolder2 = localViewHolder1;
              }
            }
          }
        for (int j = i1; ; j = i)
        {
          if ((j != 0) && (!RecyclerView.this.mState.isPreLayout()) && (localViewHolder2.hasAnyOfTheFlags(8192)))
          {
            localViewHolder2.setFlags(0, 8192);
            if (RecyclerView.this.mState.mRunSimpleAnimations)
            {
              int k = 0x1000 | RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(localViewHolder2);
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo = RecyclerView.this.mItemAnimator.recordPreLayoutInformation(RecyclerView.this.mState, localViewHolder2, k, localViewHolder2.getUnmodifiedPayloads());
              RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(localViewHolder2, localItemHolderInfo);
            }
          }
          boolean bool2;
          if ((RecyclerView.this.mState.isPreLayout()) && (localViewHolder2.isBound()))
          {
            localViewHolder2.mPreLayoutPosition = paramInt;
            bool2 = false;
          }
          while (true)
          {
            ViewGroup.LayoutParams localLayoutParams = localViewHolder2.itemView.getLayoutParams();
            RecyclerView.LayoutParams localLayoutParams1;
            if (localLayoutParams == null)
            {
              localLayoutParams1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
              localViewHolder2.itemView.setLayoutParams(localLayoutParams1);
              label849: localLayoutParams1.mViewHolder = localViewHolder2;
              if ((j == 0) || (!bool2))
                break label973;
            }
            while (true)
            {
              localLayoutParams1.mPendingInvalidate = bool1;
              return localViewHolder2;
              if ((localViewHolder2.isBound()) && (!localViewHolder2.needsUpdate()) && (!localViewHolder2.isInvalid()))
                break label979;
              bool2 = tryBindViewHolderByDeadline(localViewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
              break;
              if (!RecyclerView.this.checkLayoutParams(localLayoutParams))
              {
                localLayoutParams1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(localLayoutParams);
                localViewHolder2.itemView.setLayoutParams(localLayoutParams1);
                break label849;
              }
              localLayoutParams1 = (RecyclerView.LayoutParams)localLayoutParams;
              break label849;
              label973: bool1 = false;
            }
            label979: bool2 = false;
          }
          i1 = i;
          break;
          localViewHolder2 = localViewHolder1;
        }
        localViewHolder1 = null;
        i = 0;
      }
    }

    void unscrapView(RecyclerView.ViewHolder paramViewHolder)
    {
      if (paramViewHolder.mInChangeScrap)
        this.mChangedScrap.remove(paramViewHolder);
      while (true)
      {
        paramViewHolder.mScrapContainer = null;
        paramViewHolder.mInChangeScrap = false;
        paramViewHolder.clearReturnedFromScrapFlag();
        return;
        this.mAttachedScrap.remove(paramViewHolder);
      }
    }

    void updateViewCacheSize()
    {
      if (RecyclerView.this.mLayout != null);
      for (int i = RecyclerView.this.mLayout.mPrefetchMaxCountObserved; ; i = 0)
      {
        this.mViewCacheMax = (i + this.mRequestedCacheMax);
        for (int j = -1 + this.mCachedViews.size(); (j >= 0) && (this.mCachedViews.size() > this.mViewCacheMax); j--)
          recycleCachedViewAt(j);
      }
    }

    boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool = true;
      if (paramViewHolder.isRemoved())
        bool = RecyclerView.this.mState.isPreLayout();
      do
      {
        return bool;
        if ((paramViewHolder.mPosition < 0) || (paramViewHolder.mPosition >= RecyclerView.this.mAdapter.getItemCount()))
          throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramViewHolder + RecyclerView.this.exceptionLabel());
        if ((!RecyclerView.this.mState.isPreLayout()) && (RecyclerView.this.mAdapter.getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType()))
          return false;
      }
      while ((!RecyclerView.this.mAdapter.hasStableIds()) || (paramViewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(paramViewHolder.mPosition)));
      return false;
    }

    void viewRangeUpdate(int paramInt1, int paramInt2)
    {
      int i = paramInt1 + paramInt2;
      int j = -1 + this.mCachedViews.size();
      if (j >= 0)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localViewHolder == null);
        while (true)
        {
          j--;
          break;
          int k = localViewHolder.mPosition;
          if ((k >= paramInt1) && (k < i))
          {
            localViewHolder.addFlags(2);
            recycleCachedViewAt(j);
          }
        }
      }
    }
  }

  public static abstract interface RecyclerListener
  {
    public abstract void onViewRecycled(RecyclerView.ViewHolder paramViewHolder);
  }

  private class RecyclerViewDataObserver extends RecyclerView.AdapterDataObserver
  {
    RecyclerViewDataObserver()
    {
    }

    public void onChanged()
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.mState.mStructureChanged = true;
      RecyclerView.this.processDataSetCompletelyChanged(true);
      if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates())
        RecyclerView.this.requestLayout();
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(paramInt1, paramInt2, paramObject))
        triggerUpdateProcessor();
    }

    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(paramInt1, paramInt2))
        triggerUpdateProcessor();
    }

    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(paramInt1, paramInt2, paramInt3))
        triggerUpdateProcessor();
    }

    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(paramInt1, paramInt2))
        triggerUpdateProcessor();
    }

    void triggerUpdateProcessor()
    {
      if ((RecyclerView.POST_UPDATES_ON_ANIMATION) && (RecyclerView.this.mHasFixedSize) && (RecyclerView.this.mIsAttached))
      {
        ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
        return;
      }
      RecyclerView.this.mAdapterUpdateDuringMeasure = true;
      RecyclerView.this.requestLayout();
    }
  }

  public static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, null);
      }

      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public RecyclerView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new RecyclerView.SavedState[paramAnonymousInt];
      }
    };
    Parcelable mLayoutState;

    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null);
      while (true)
      {
        this.mLayoutState = paramParcel.readParcelable(paramClassLoader);
        return;
        paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
      }
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    void copyFrom(SavedState paramSavedState)
    {
      this.mLayoutState = paramSavedState.mLayoutState;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.mLayoutState, 0);
    }
  }

  public static class SimpleOnItemTouchListener
    implements RecyclerView.OnItemTouchListener
  {
    public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
    {
    }

    public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
    }
  }

  public static abstract class SmoothScroller
  {
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final Action mRecyclingAction = new Action(0, 0);
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;

    public PointF computeScrollVectorForPosition(int paramInt)
    {
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      if ((localLayoutManager instanceof ScrollVectorProvider))
        return ((ScrollVectorProvider)localLayoutManager).computeScrollVectorForPosition(paramInt);
      Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
      return null;
    }

    public View findViewByPosition(int paramInt)
    {
      return this.mRecyclerView.mLayout.findViewByPosition(paramInt);
    }

    public int getChildCount()
    {
      return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View paramView)
    {
      return this.mRecyclerView.getChildLayoutPosition(paramView);
    }

    public RecyclerView.LayoutManager getLayoutManager()
    {
      return this.mLayoutManager;
    }

    public int getTargetPosition()
    {
      return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int paramInt)
    {
      this.mRecyclerView.scrollToPosition(paramInt);
    }

    public boolean isPendingInitialRun()
    {
      return this.mPendingInitialRun;
    }

    public boolean isRunning()
    {
      return this.mRunning;
    }

    protected void normalize(PointF paramPointF)
    {
      float f = (float)Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
      paramPointF.x /= f;
      paramPointF.y /= f;
    }

    void onAnimation(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((!this.mRunning) || (this.mTargetPosition == -1) || (localRecyclerView == null))
        stop();
      if ((this.mPendingInitialRun) && (this.mTargetView == null) && (this.mLayoutManager != null))
      {
        PointF localPointF = computeScrollVectorForPosition(this.mTargetPosition);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F)))
          localRecyclerView.scrollStep((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
      }
      this.mPendingInitialRun = false;
      if (this.mTargetView != null)
      {
        if (getChildPosition(this.mTargetView) != this.mTargetPosition)
          break label225;
        onTargetFound(this.mTargetView, localRecyclerView.mState, this.mRecyclingAction);
        this.mRecyclingAction.runIfNecessary(localRecyclerView);
        stop();
      }
      while (true)
      {
        if (this.mRunning)
        {
          onSeekTargetStep(paramInt1, paramInt2, localRecyclerView.mState, this.mRecyclingAction);
          boolean bool = this.mRecyclingAction.hasJumpTarget();
          this.mRecyclingAction.runIfNecessary(localRecyclerView);
          if (bool)
          {
            if (!this.mRunning)
              break;
            this.mPendingInitialRun = true;
            localRecyclerView.mViewFlinger.postOnAnimation();
          }
        }
        return;
        label225: Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
        this.mTargetView = null;
      }
      stop();
    }

    protected void onChildAttachedToWindow(View paramView)
    {
      if (getChildPosition(paramView) == getTargetPosition())
        this.mTargetView = paramView;
    }

    protected abstract void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.State paramState, Action paramAction);

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void onTargetFound(View paramView, RecyclerView.State paramState, Action paramAction);

    public void setTargetPosition(int paramInt)
    {
      this.mTargetPosition = paramInt;
    }

    void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
    {
      if (this.mStarted)
        Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started " + "more than once. Each instance of" + getClass().getSimpleName() + " " + "is intended to only be used once. You should create a new instance for " + "each use.");
      this.mRecyclerView = paramRecyclerView;
      this.mLayoutManager = paramLayoutManager;
      if (this.mTargetPosition == -1)
        throw new IllegalArgumentException("Invalid target position");
      this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
      this.mRunning = true;
      this.mPendingInitialRun = true;
      this.mTargetView = findViewByPosition(getTargetPosition());
      onStart();
      this.mRecyclerView.mViewFlinger.postOnAnimation();
      this.mStarted = true;
    }

    protected final void stop()
    {
      if (!this.mRunning)
        return;
      this.mRunning = false;
      onStop();
      this.mRecyclerView.mState.mTargetPosition = -1;
      this.mTargetView = null;
      this.mTargetPosition = -1;
      this.mPendingInitialRun = false;
      this.mLayoutManager.onSmoothScrollerStopped(this);
      this.mLayoutManager = null;
      this.mRecyclerView = null;
    }

    public static class Action
    {
      public static final int UNDEFINED_DURATION = -2147483648;
      private boolean mChanged = false;
      private int mConsecutiveUpdates = 0;
      private int mDuration;
      private int mDx;
      private int mDy;
      private Interpolator mInterpolator;
      private int mJumpToPosition = -1;

      public Action(int paramInt1, int paramInt2)
      {
        this(paramInt1, paramInt2, -2147483648, null);
      }

      public Action(int paramInt1, int paramInt2, int paramInt3)
      {
        this(paramInt1, paramInt2, paramInt3, null);
      }

      public Action(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
      }

      private void validate()
      {
        if ((this.mInterpolator != null) && (this.mDuration < 1))
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        if (this.mDuration < 1)
          throw new IllegalStateException("Scroll duration must be a positive number");
      }

      public int getDuration()
      {
        return this.mDuration;
      }

      public int getDx()
      {
        return this.mDx;
      }

      public int getDy()
      {
        return this.mDy;
      }

      public Interpolator getInterpolator()
      {
        return this.mInterpolator;
      }

      boolean hasJumpTarget()
      {
        return this.mJumpToPosition >= 0;
      }

      public void jumpTo(int paramInt)
      {
        this.mJumpToPosition = paramInt;
      }

      void runIfNecessary(RecyclerView paramRecyclerView)
      {
        if (this.mJumpToPosition >= 0)
        {
          int i = this.mJumpToPosition;
          this.mJumpToPosition = -1;
          paramRecyclerView.jumpToPositionForSmoothScroller(i);
          this.mChanged = false;
          return;
        }
        if (this.mChanged)
        {
          validate();
          if (this.mInterpolator == null)
            if (this.mDuration == -2147483648)
              paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
          while (true)
          {
            this.mConsecutiveUpdates = (1 + this.mConsecutiveUpdates);
            if (this.mConsecutiveUpdates > 10)
              Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            this.mChanged = false;
            return;
            paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
            continue;
            paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
          }
        }
        this.mConsecutiveUpdates = 0;
      }

      public void setDuration(int paramInt)
      {
        this.mChanged = true;
        this.mDuration = paramInt;
      }

      public void setDx(int paramInt)
      {
        this.mChanged = true;
        this.mDx = paramInt;
      }

      public void setDy(int paramInt)
      {
        this.mChanged = true;
        this.mDy = paramInt;
      }

      public void setInterpolator(Interpolator paramInterpolator)
      {
        this.mChanged = true;
        this.mInterpolator = paramInterpolator;
      }

      public void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.mChanged = true;
      }
    }

    public static abstract interface ScrollVectorProvider
    {
      public abstract PointF computeScrollVectorForPosition(int paramInt);
    }
  }

  public static class State
  {
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    long mFocusedItemId;
    int mFocusedItemPosition;
    int mFocusedSubChildId;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPreviousLayoutItemCount = 0;
    int mRemainingScrollHorizontal;
    int mRemainingScrollVertical;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    boolean mStructureChanged = false;
    int mTargetPosition = -1;
    boolean mTrackOldChangeHolders = false;

    void assertLayoutStep(int paramInt)
    {
      if ((paramInt & this.mLayoutStep) == 0)
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
    }

    public boolean didStructureChange()
    {
      return this.mStructureChanged;
    }

    public <T> T get(int paramInt)
    {
      if (this.mData == null)
        return null;
      return this.mData.get(paramInt);
    }

    public int getItemCount()
    {
      if (this.mInPreLayout)
        return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
      return this.mItemCount;
    }

    public int getRemainingScrollHorizontal()
    {
      return this.mRemainingScrollHorizontal;
    }

    public int getRemainingScrollVertical()
    {
      return this.mRemainingScrollVertical;
    }

    public int getTargetScrollPosition()
    {
      return this.mTargetPosition;
    }

    public boolean hasTargetScrollPosition()
    {
      return this.mTargetPosition != -1;
    }

    public boolean isMeasuring()
    {
      return this.mIsMeasuring;
    }

    public boolean isPreLayout()
    {
      return this.mInPreLayout;
    }

    void prepareForNestedPrefetch(RecyclerView.Adapter paramAdapter)
    {
      this.mLayoutStep = 1;
      this.mItemCount = paramAdapter.getItemCount();
      this.mInPreLayout = false;
      this.mTrackOldChangeHolders = false;
      this.mIsMeasuring = false;
    }

    public void put(int paramInt, Object paramObject)
    {
      if (this.mData == null)
        this.mData = new SparseArray();
      this.mData.put(paramInt, paramObject);
    }

    public void remove(int paramInt)
    {
      if (this.mData == null)
        return;
      this.mData.remove(paramInt);
    }

    State reset()
    {
      this.mTargetPosition = -1;
      if (this.mData != null)
        this.mData.clear();
      this.mItemCount = 0;
      this.mStructureChanged = false;
      this.mIsMeasuring = false;
      return this;
    }

    public String toString()
    {
      return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
    }

    public boolean willRunPredictiveAnimations()
    {
      return this.mRunPredictiveAnimations;
    }

    public boolean willRunSimpleAnimations()
    {
      return this.mRunSimpleAnimations;
    }
  }

  public static abstract class ViewCacheExtension
  {
    public abstract View getViewForPositionAndType(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2);
  }

  class ViewFlinger
    implements Runnable
  {
    private boolean mEatRunOnAnimationRequest = false;
    Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    private boolean mReSchedulePostAnimationCallback = false;
    OverScroller mScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);

    ViewFlinger()
    {
    }

    private int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = Math.abs(paramInt1);
      int j = Math.abs(paramInt2);
      int k;
      int m;
      int n;
      if (i > j)
      {
        k = 1;
        m = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
        n = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (k == 0)
          break label142;
      }
      int i4;
      label142: for (int i1 = RecyclerView.this.getWidth(); ; i1 = RecyclerView.this.getHeight())
      {
        int i2 = i1 / 2;
        float f1 = Math.min(1.0F, 1.0F * n / i1);
        float f2 = i2 + i2 * distanceInfluenceForSnapDuration(f1);
        if (m <= 0)
          break label154;
        i4 = 4 * Math.round(1000.0F * Math.abs(f2 / m));
        return Math.min(i4, 2000);
        k = 0;
        break;
      }
      label154: if (k != 0);
      for (int i3 = i; ; i3 = j)
      {
        i4 = (int)(300.0F * (1.0F + i3 / i1));
        break;
      }
    }

    private void disableRunOnAnimationRequests()
    {
      this.mReSchedulePostAnimationCallback = false;
      this.mEatRunOnAnimationRequest = true;
    }

    private float distanceInfluenceForSnapDuration(float paramFloat)
    {
      return (float)Math.sin(0.4712389F * (paramFloat - 0.5F));
    }

    private void enableRunOnAnimationRequests()
    {
      this.mEatRunOnAnimationRequest = false;
      if (this.mReSchedulePostAnimationCallback)
        postOnAnimation();
    }

    public void fling(int paramInt1, int paramInt2)
    {
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      postOnAnimation();
    }

    void postOnAnimation()
    {
      if (this.mEatRunOnAnimationRequest)
      {
        this.mReSchedulePostAnimationCallback = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }

    public void run()
    {
      if (RecyclerView.this.mLayout == null)
      {
        stop();
        return;
      }
      disableRunOnAnimationRequests();
      RecyclerView.this.consumePendingUpdateOperations();
      OverScroller localOverScroller = this.mScroller;
      RecyclerView.SmoothScroller localSmoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
      int i;
      int j;
      int k;
      int m;
      int i13;
      int n;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.mScrollConsumed;
        i = localOverScroller.getCurrX();
        j = localOverScroller.getCurrY();
        k = i - this.mLastFlingX;
        m = j - this.mLastFlingY;
        this.mLastFlingX = i;
        this.mLastFlingY = j;
        if (!RecyclerView.this.dispatchNestedPreScroll(k, m, arrayOfInt, null, 1))
          break label785;
        i13 = k - arrayOfInt[0];
        n = m - arrayOfInt[1];
      }
      for (int i1 = i13; ; i1 = k)
      {
        int i2;
        int i3;
        int i4;
        int i5;
        int i12;
        if (RecyclerView.this.mAdapter != null)
        {
          RecyclerView.this.scrollStep(i1, n, RecyclerView.this.mScrollStepConsumed);
          i2 = RecyclerView.this.mScrollStepConsumed[0];
          i3 = RecyclerView.this.mScrollStepConsumed[1];
          i4 = i1 - i2;
          i5 = n - i3;
          if ((localSmoothScroller != null) && (!localSmoothScroller.isPendingInitialRun()) && (localSmoothScroller.isRunning()))
          {
            i12 = RecyclerView.this.mState.getItemCount();
            if (i12 != 0)
              break label625;
            localSmoothScroller.stop();
          }
        }
        while (true)
        {
          if (!RecyclerView.this.mItemDecorations.isEmpty())
            RecyclerView.this.invalidate();
          if (RecyclerView.this.getOverScrollMode() != 2)
            RecyclerView.this.considerReleasingGlowsOnScroll(i1, n);
          int i9;
          int i11;
          if ((!RecyclerView.this.dispatchNestedScroll(i2, i3, i4, i5, null, 1)) && ((i4 != 0) || (i5 != 0)))
          {
            i9 = (int)localOverScroller.getCurrVelocity();
            if (i4 == i)
              break label764;
            if (i4 >= 0)
              break label676;
            i11 = -i9;
          }
          label335: label356: label486: label625: label764: for (int i10 = i11; ; i10 = 0)
          {
            if (i5 != j)
              if (i5 < 0)
                i9 = -i9;
            while (true)
            {
              if (RecyclerView.this.getOverScrollMode() != 2)
                RecyclerView.this.absorbGlows(i10, i9);
              if (((i10 != 0) || (i4 == i) || (localOverScroller.getFinalX() == 0)) && ((i9 != 0) || (i5 == j) || (localOverScroller.getFinalY() == 0)))
                localOverScroller.abortAnimation();
              if ((i2 != 0) || (i3 != 0))
                RecyclerView.this.dispatchOnScrolled(i2, i3);
              if (!RecyclerView.this.awakenScrollBars())
                RecyclerView.this.invalidate();
              int i6;
              int i7;
              int i8;
              if ((n != 0) && (RecyclerView.this.mLayout.canScrollVertically()) && (i3 == n))
              {
                i6 = 1;
                if ((i1 == 0) || (!RecyclerView.this.mLayout.canScrollHorizontally()) || (i2 != i1))
                  break label711;
                i7 = 1;
                if (((i1 != 0) || (n != 0)) && (i7 == 0) && (i6 == 0))
                  break label717;
                i8 = 1;
                if ((!localOverScroller.isFinished()) && ((i8 != 0) || (RecyclerView.this.hasNestedScrollingParent(1))))
                  break label723;
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                  RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                RecyclerView.this.stopNestedScroll(1);
              }
              while (true)
              {
                if (localSmoothScroller != null)
                {
                  if (localSmoothScroller.isPendingInitialRun())
                    localSmoothScroller.onAnimation(0, 0);
                  if (!this.mReSchedulePostAnimationCallback)
                    localSmoothScroller.stop();
                }
                enableRunOnAnimationRequests();
                return;
                if (localSmoothScroller.getTargetPosition() >= i12)
                {
                  localSmoothScroller.setTargetPosition(i12 - 1);
                  localSmoothScroller.onAnimation(i1 - i4, n - i5);
                  break;
                }
                localSmoothScroller.onAnimation(i1 - i4, n - i5);
                break;
                if (i4 > 0)
                {
                  i11 = i9;
                  break label335;
                }
                i11 = 0;
                break label335;
                if (i5 > 0)
                  break label356;
                i9 = 0;
                break label356;
                i6 = 0;
                break label486;
                i7 = 0;
                break label514;
                i8 = 0;
                break label537;
                postOnAnimation();
                if (RecyclerView.this.mGapWorker != null)
                  RecyclerView.this.mGapWorker.postFromTraversal(RecyclerView.this, i1, n);
              }
              i9 = 0;
            }
          }
          label514: label537: label676: label711: label717: label723: i2 = 0;
          i3 = 0;
          i4 = 0;
          i5 = 0;
        }
        label785: n = m;
      }
    }

    public void smoothScrollBy(int paramInt1, int paramInt2)
    {
      smoothScrollBy(paramInt1, paramInt2, 0, 0);
    }

    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
    {
      smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.sQuinticInterpolator);
    }

    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4));
    }

    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.mScroller = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23)
        this.mScroller.computeScrollOffset();
      postOnAnimation();
    }

    public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
    {
      int i = computeScrollDuration(paramInt1, paramInt2, 0, 0);
      if (paramInterpolator == null)
        paramInterpolator = RecyclerView.sQuinticInterpolator;
      smoothScrollBy(paramInt1, paramInt2, i, paramInterpolator);
    }

    public void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.mScroller.abortAnimation();
    }
  }

  public static abstract class ViewHolder
  {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    public final View itemView;
    int mFlags;
    boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    RecyclerView.Recycler mScrapContainer = null;
    ViewHolder mShadowedHolder = null;
    ViewHolder mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;

    public ViewHolder(View paramView)
    {
      if (paramView == null)
        throw new IllegalArgumentException("itemView may not be null");
      this.itemView = paramView;
    }

    private void createPayloadsIfNeeded()
    {
      if (this.mPayloads == null)
      {
        this.mPayloads = new ArrayList();
        this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
      }
    }

    void addChangePayload(Object paramObject)
    {
      if (paramObject == null)
        addFlags(1024);
      while ((0x400 & this.mFlags) != 0)
        return;
      createPayloadsIfNeeded();
      this.mPayloads.add(paramObject);
    }

    void addFlags(int paramInt)
    {
      this.mFlags = (paramInt | this.mFlags);
    }

    void clearOldPosition()
    {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
    }

    void clearPayload()
    {
      if (this.mPayloads != null)
        this.mPayloads.clear();
      this.mFlags = (0xFFFFFBFF & this.mFlags);
    }

    void clearReturnedFromScrapFlag()
    {
      this.mFlags = (0xFFFFFFDF & this.mFlags);
    }

    void clearTmpDetachFlag()
    {
      this.mFlags = (0xFFFFFEFF & this.mFlags);
    }

    boolean doesTransientStatePreventRecycling()
    {
      return ((0x10 & this.mFlags) == 0) && (ViewCompat.hasTransientState(this.itemView));
    }

    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      this.mPosition = paramInt1;
    }

    public final int getAdapterPosition()
    {
      if (this.mOwnerRecyclerView == null)
        return -1;
      return this.mOwnerRecyclerView.getAdapterPositionFor(this);
    }

    public final long getItemId()
    {
      return this.mItemId;
    }

    public final int getItemViewType()
    {
      return this.mItemViewType;
    }

    public final int getLayoutPosition()
    {
      if (this.mPreLayoutPosition == -1)
        return this.mPosition;
      return this.mPreLayoutPosition;
    }

    public final int getOldPosition()
    {
      return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition()
    {
      if (this.mPreLayoutPosition == -1)
        return this.mPosition;
      return this.mPreLayoutPosition;
    }

    List<Object> getUnmodifiedPayloads()
    {
      if ((0x400 & this.mFlags) == 0)
      {
        if ((this.mPayloads == null) || (this.mPayloads.size() == 0))
          return FULLUPDATE_PAYLOADS;
        return this.mUnmodifiedPayloads;
      }
      return FULLUPDATE_PAYLOADS;
    }

    boolean hasAnyOfTheFlags(int paramInt)
    {
      return (paramInt & this.mFlags) != 0;
    }

    boolean isAdapterPositionUnknown()
    {
      return ((0x200 & this.mFlags) != 0) || (isInvalid());
    }

    boolean isBound()
    {
      return (0x1 & this.mFlags) != 0;
    }

    boolean isInvalid()
    {
      return (0x4 & this.mFlags) != 0;
    }

    public final boolean isRecyclable()
    {
      return ((0x10 & this.mFlags) == 0) && (!ViewCompat.hasTransientState(this.itemView));
    }

    boolean isRemoved()
    {
      return (0x8 & this.mFlags) != 0;
    }

    boolean isScrap()
    {
      return this.mScrapContainer != null;
    }

    boolean isTmpDetached()
    {
      return (0x100 & this.mFlags) != 0;
    }

    boolean isUpdated()
    {
      return (0x2 & this.mFlags) != 0;
    }

    boolean needsUpdate()
    {
      return (0x2 & this.mFlags) != 0;
    }

    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (this.mOldPosition == -1)
        this.mOldPosition = this.mPosition;
      if (this.mPreLayoutPosition == -1)
        this.mPreLayoutPosition = this.mPosition;
      if (paramBoolean)
        this.mPreLayoutPosition = (paramInt + this.mPreLayoutPosition);
      this.mPosition = (paramInt + this.mPosition);
      if (this.itemView.getLayoutParams() != null)
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
    }

    void onEnteredHiddenState(RecyclerView paramRecyclerView)
    {
      if (this.mPendingAccessibilityState != -1);
      for (this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState; ; this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView))
      {
        paramRecyclerView.setChildImportantForAccessibilityInternal(this, 4);
        return;
      }
    }

    void onLeftHiddenState(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    void resetInternal()
    {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
      this.mPendingAccessibilityState = -1;
      RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }

    void saveOldPosition()
    {
      if (this.mOldPosition == -1)
        this.mOldPosition = this.mPosition;
    }

    void setFlags(int paramInt1, int paramInt2)
    {
      this.mFlags = (this.mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }

    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = -1 + this.mIsRecyclableCount;
        this.mIsRecyclableCount = i;
        if (this.mIsRecyclableCount >= 0)
          break label64;
        this.mIsRecyclableCount = 0;
        Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
      }
      label64: 
      do
      {
        return;
        i = 1 + this.mIsRecyclableCount;
        break;
        if ((!paramBoolean) && (this.mIsRecyclableCount == 1))
        {
          this.mFlags = (0x10 | this.mFlags);
          return;
        }
      }
      while ((!paramBoolean) || (this.mIsRecyclableCount != 0));
      this.mFlags = (0xFFFFFFEF & this.mFlags);
    }

    void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
    {
      this.mScrapContainer = paramRecycler;
      this.mInChangeScrap = paramBoolean;
    }

    boolean shouldBeKeptAsChild()
    {
      return (0x10 & this.mFlags) != 0;
    }

    boolean shouldIgnore()
    {
      return (0x80 & this.mFlags) != 0;
    }

    void stopIgnoring()
    {
      this.mFlags = (0xFFFFFF7F & this.mFlags);
    }

    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
      StringBuilder localStringBuilder2;
      if (isScrap())
      {
        localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (!this.mInChangeScrap)
          break label299;
      }
      label299: for (String str = "[changeScrap]"; ; str = "[attachedScrap]")
      {
        localStringBuilder2.append(str);
        if (isInvalid())
          localStringBuilder1.append(" invalid");
        if (!isBound())
          localStringBuilder1.append(" unbound");
        if (needsUpdate())
          localStringBuilder1.append(" update");
        if (isRemoved())
          localStringBuilder1.append(" removed");
        if (shouldIgnore())
          localStringBuilder1.append(" ignored");
        if (isTmpDetached())
          localStringBuilder1.append(" tmpDetached");
        if (!isRecyclable())
          localStringBuilder1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        if (isAdapterPositionUnknown())
          localStringBuilder1.append(" undefined adapter position");
        if (this.itemView.getParent() == null)
          localStringBuilder1.append(" no parent");
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
      }
    }

    void unScrap()
    {
      this.mScrapContainer.unscrapView(this);
    }

    boolean wasReturnedFromScrap()
    {
      return (0x20 & this.mFlags) != 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.6.2
 */