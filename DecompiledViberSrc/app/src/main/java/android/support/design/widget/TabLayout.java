package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.design.internal.j;
import android.support.design.internal.k;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.a.c;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView
{
  private static final int ANIMATION_DURATION = 300;
  static final int DEFAULT_GAP_TEXT_ICON = 8;
  private static final int DEFAULT_HEIGHT = 48;
  private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
  static final int FIXED_WRAP_GUTTER_MIN = 16;
  public static final int GRAVITY_CENTER = 1;
  public static final int GRAVITY_FILL = 0;
  public static final int INDICATOR_GRAVITY_BOTTOM = 0;
  public static final int INDICATOR_GRAVITY_CENTER = 1;
  public static final int INDICATOR_GRAVITY_STRETCH = 3;
  public static final int INDICATOR_GRAVITY_TOP = 2;
  private static final int INVALID_WIDTH = -1;
  private static final int MIN_INDICATOR_WIDTH = 24;
  public static final int MODE_FIXED = 1;
  public static final int MODE_SCROLLABLE = 0;
  private static final int TAB_MIN_WIDTH_MARGIN = 56;
  private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
  private AdapterChangeListener adapterChangeListener;
  private int contentInsetStart;
  private BaseOnTabSelectedListener currentVpSelectedListener;
  boolean inlineLabel;
  int mode;
  private TabLayoutOnPageChangeListener pageChangeListener;
  private PagerAdapter pagerAdapter;
  private DataSetObserver pagerAdapterObserver;
  private final int requestedTabMaxWidth;
  private final int requestedTabMinWidth;
  private ValueAnimator scrollAnimator;
  private final int scrollableTabMinWidth;
  private BaseOnTabSelectedListener selectedListener;
  private final ArrayList<BaseOnTabSelectedListener> selectedListeners = new ArrayList();
  private Tab selectedTab;
  private boolean setupViewPagerImplicitly;
  private final SlidingTabIndicator slidingTabIndicator;
  final int tabBackgroundResId;
  int tabGravity;
  ColorStateList tabIconTint;
  PorterDuff.Mode tabIconTintMode;
  int tabIndicatorAnimationDuration;
  boolean tabIndicatorFullWidth;
  int tabIndicatorGravity;
  int tabMaxWidth = 2147483647;
  int tabPaddingBottom;
  int tabPaddingEnd;
  int tabPaddingStart;
  int tabPaddingTop;
  ColorStateList tabRippleColorStateList;
  Drawable tabSelectedIndicator;
  int tabTextAppearance;
  ColorStateList tabTextColors;
  float tabTextMultiLineSize;
  float tabTextSize;
  private final RectF tabViewContentBounds = new RectF();
  private final Pools.Pool<TabView> tabViewPool = new Pools.SimplePool(12);
  private final ArrayList<Tab> tabs = new ArrayList();
  boolean unboundedRipple;
  ViewPager viewPager;

  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.tabStyle);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.slidingTabIndicator = new SlidingTabIndicator(paramContext);
    super.addView(this.slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
    int[] arrayOfInt1 = android.support.design.R.styleable.TabLayout;
    int i = R.style.Widget_Design_TabLayout;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = android.support.design.R.styleable.TabLayout_tabTextAppearance;
    TypedArray localTypedArray1 = j.a(paramContext, paramAttributeSet, arrayOfInt1, paramInt, i, arrayOfInt2);
    this.slidingTabIndicator.setSelectedIndicatorHeight(localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, -1));
    this.slidingTabIndicator.setSelectedIndicatorColor(localTypedArray1.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
    setSelectedTabIndicator(android.support.design.e.a.b(paramContext, localTypedArray1, android.support.design.R.styleable.TabLayout_tabIndicator));
    setSelectedTabIndicatorGravity(localTypedArray1.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorFullWidth(localTypedArray1.getBoolean(android.support.design.R.styleable.TabLayout_tabIndicatorFullWidth, true));
    int j = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
    this.tabPaddingBottom = j;
    this.tabPaddingEnd = j;
    this.tabPaddingTop = j;
    this.tabPaddingStart = j;
    this.tabPaddingStart = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
    this.tabPaddingTop = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
    this.tabPaddingEnd = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
    this.tabPaddingBottom = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
    this.tabTextAppearance = localTypedArray1.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(this.tabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
    try
    {
      this.tabTextSize = localTypedArray2.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      this.tabTextColors = android.support.design.e.a.a(paramContext, localTypedArray2, android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
      localTypedArray2.recycle();
      if (localTypedArray1.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor))
        this.tabTextColors = android.support.design.e.a.a(paramContext, localTypedArray1, android.support.design.R.styleable.TabLayout_tabTextColor);
      if (localTypedArray1.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor))
      {
        int k = localTypedArray1.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0);
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), k);
      }
      this.tabIconTint = android.support.design.e.a.a(paramContext, localTypedArray1, android.support.design.R.styleable.TabLayout_tabIconTint);
      this.tabIconTintMode = k.a(localTypedArray1.getInt(android.support.design.R.styleable.TabLayout_tabIconTintMode, -1), null);
      this.tabRippleColorStateList = android.support.design.e.a.a(paramContext, localTypedArray1, android.support.design.R.styleable.TabLayout_tabRippleColor);
      this.tabIndicatorAnimationDuration = localTypedArray1.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
      this.requestedTabMinWidth = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
      this.requestedTabMaxWidth = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
      this.tabBackgroundResId = localTypedArray1.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
      this.contentInsetStart = localTypedArray1.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
      this.mode = localTypedArray1.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
      this.tabGravity = localTypedArray1.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
      this.inlineLabel = localTypedArray1.getBoolean(android.support.design.R.styleable.TabLayout_tabInlineLabel, false);
      this.unboundedRipple = localTypedArray1.getBoolean(android.support.design.R.styleable.TabLayout_tabUnboundedRipple, false);
      localTypedArray1.recycle();
      Resources localResources = getResources();
      this.tabTextMultiLineSize = localResources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.scrollableTabMinWidth = localResources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      applyModeAndGravity();
      return;
    }
    finally
    {
      localTypedArray2.recycle();
    }
  }

  private void addTabFromItemView(TabItem paramTabItem)
  {
    Tab localTab = newTab();
    if (paramTabItem.text != null)
      localTab.setText(paramTabItem.text);
    if (paramTabItem.icon != null)
      localTab.setIcon(paramTabItem.icon);
    if (paramTabItem.customLayout != 0)
      localTab.setCustomView(paramTabItem.customLayout);
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
      localTab.setContentDescription(paramTabItem.getContentDescription());
    addTab(localTab);
  }

  private void addTabView(Tab paramTab)
  {
    TabView localTabView = paramTab.view;
    this.slidingTabIndicator.addView(localTabView, paramTab.getPosition(), createLayoutParamsForTabs());
  }

  private void addViewInternal(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      addTabFromItemView((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }

  private void animateToTab(int paramInt)
  {
    if (paramInt == -1)
      return;
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.slidingTabIndicator.childrenNeedLayout()))
    {
      setScrollPosition(paramInt, 0.0F, true);
      return;
    }
    int i = getScrollX();
    int j = calculateScrollXForTab(paramInt, 0.0F);
    if (i != j)
    {
      ensureScrollAnimator();
      this.scrollAnimator.setIntValues(new int[] { i, j });
      this.scrollAnimator.start();
    }
    this.slidingTabIndicator.animateIndicatorToPosition(paramInt, this.tabIndicatorAnimationDuration);
  }

  private void applyModeAndGravity()
  {
    if (this.mode == 0);
    for (int i = Math.max(0, this.contentInsetStart - this.tabPaddingStart); ; i = 0)
    {
      ViewCompat.setPaddingRelative(this.slidingTabIndicator, i, 0, 0, 0);
      switch (this.mode)
      {
      default:
      case 1:
      case 0:
      }
      while (true)
      {
        updateTabViews(true);
        return;
        this.slidingTabIndicator.setGravity(1);
        continue;
        this.slidingTabIndicator.setGravity(8388611);
      }
    }
  }

  private int calculateScrollXForTab(int paramInt, float paramFloat)
  {
    int i = this.mode;
    int j = 0;
    View localView1;
    View localView2;
    if (i == 0)
    {
      localView1 = this.slidingTabIndicator.getChildAt(paramInt);
      if (paramInt + 1 >= this.slidingTabIndicator.getChildCount())
        break label125;
      localView2 = this.slidingTabIndicator.getChildAt(paramInt + 1);
      if (localView1 == null)
        break label131;
    }
    int n;
    int i1;
    label131: for (int k = localView1.getWidth(); ; k = 0)
    {
      int m = 0;
      if (localView2 != null)
        m = localView2.getWidth();
      n = localView1.getLeft() + k / 2 - getWidth() / 2;
      i1 = (int)(paramFloat * (0.5F * (m + k)));
      if (ViewCompat.getLayoutDirection(this) != 0)
        break label137;
      j = i1 + n;
      return j;
      label125: localView2 = null;
      break;
    }
    label137: return n - i1;
  }

  private void configureTab(Tab paramTab, int paramInt)
  {
    paramTab.setPosition(paramInt);
    this.tabs.add(paramInt, paramTab);
    int i = this.tabs.size();
    for (int j = paramInt + 1; j < i; j++)
      ((Tab)this.tabs.get(j)).setPosition(j);
  }

  private static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    int[][] arrayOfInt = new int[2][];
    int[] arrayOfInt1 = new int[2];
    arrayOfInt[0] = SELECTED_STATE_SET;
    arrayOfInt1[0] = paramInt2;
    arrayOfInt[1] = EMPTY_STATE_SET;
    arrayOfInt1[1] = paramInt1;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private LinearLayout.LayoutParams createLayoutParamsForTabs()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    updateTabViewLayoutParams(localLayoutParams);
    return localLayoutParams;
  }

  private TabView createTabView(Tab paramTab)
  {
    if (this.tabViewPool != null);
    for (TabView localTabView = (TabView)this.tabViewPool.acquire(); ; localTabView = null)
    {
      if (localTabView == null)
        localTabView = new TabView(getContext());
      localTabView.setTab(paramTab);
      localTabView.setFocusable(true);
      localTabView.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(paramTab.contentDesc))
        break;
      localTabView.setContentDescription(paramTab.text);
      return localTabView;
    }
    localTabView.setContentDescription(paramTab.contentDesc);
    return localTabView;
  }

  private void dispatchTabReselected(Tab paramTab)
  {
    for (int i = -1 + this.selectedListeners.size(); i >= 0; i--)
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabReselected(paramTab);
  }

  private void dispatchTabSelected(Tab paramTab)
  {
    for (int i = -1 + this.selectedListeners.size(); i >= 0; i--)
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabSelected(paramTab);
  }

  private void dispatchTabUnselected(Tab paramTab)
  {
    for (int i = -1 + this.selectedListeners.size(); i >= 0; i--)
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabUnselected(paramTab);
  }

  private void ensureScrollAnimator()
  {
    if (this.scrollAnimator == null)
    {
      this.scrollAnimator = new ValueAnimator();
      this.scrollAnimator.setInterpolator(android.support.design.a.a.b);
      this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
      this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }

  private int getDefaultHeight()
  {
    int i = this.tabs.size();
    int j = 0;
    if (j < i)
    {
      Tab localTab = (Tab)this.tabs.get(j);
      if ((localTab == null) || (localTab.getIcon() == null) || (TextUtils.isEmpty(localTab.getText())));
    }
    for (int k = 1; ; k = 0)
    {
      if ((k != 0) && (!this.inlineLabel))
      {
        return 72;
        j++;
        break;
      }
      return 48;
    }
  }

  private int getTabMinWidth()
  {
    if (this.requestedTabMinWidth != -1)
      return this.requestedTabMinWidth;
    if (this.mode == 0)
      return this.scrollableTabMinWidth;
    return 0;
  }

  private int getTabScrollRange()
  {
    return Math.max(0, this.slidingTabIndicator.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }

  private void removeTabViewAt(int paramInt)
  {
    TabView localTabView = (TabView)this.slidingTabIndicator.getChildAt(paramInt);
    this.slidingTabIndicator.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      this.tabViewPool.release(localTabView);
    }
    requestLayout();
  }

  private void setSelectedTabView(int paramInt)
  {
    int i = this.slidingTabIndicator.getChildCount();
    if (paramInt < i)
    {
      int j = 0;
      if (j < i)
      {
        View localView = this.slidingTabIndicator.getChildAt(j);
        boolean bool1;
        if (j == paramInt)
        {
          bool1 = true;
          label38: localView.setSelected(bool1);
          if (j != paramInt)
            break label72;
        }
        label72: for (boolean bool2 = true; ; bool2 = false)
        {
          localView.setActivated(bool2);
          j++;
          break;
          bool1 = false;
          break label38;
        }
      }
    }
  }

  private void setupWithViewPager(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.viewPager != null)
    {
      if (this.pageChangeListener != null)
        this.viewPager.removeOnPageChangeListener(this.pageChangeListener);
      if (this.adapterChangeListener != null)
        this.viewPager.removeOnAdapterChangeListener(this.adapterChangeListener);
    }
    if (this.currentVpSelectedListener != null)
    {
      removeOnTabSelectedListener(this.currentVpSelectedListener);
      this.currentVpSelectedListener = null;
    }
    if (paramViewPager != null)
    {
      this.viewPager = paramViewPager;
      if (this.pageChangeListener == null)
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
      this.pageChangeListener.reset();
      paramViewPager.addOnPageChangeListener(this.pageChangeListener);
      this.currentVpSelectedListener = new ViewPagerOnTabSelectedListener(paramViewPager);
      addOnTabSelectedListener(this.currentVpSelectedListener);
      PagerAdapter localPagerAdapter = paramViewPager.getAdapter();
      if (localPagerAdapter != null)
        setPagerAdapter(localPagerAdapter, paramBoolean1);
      if (this.adapterChangeListener == null)
        this.adapterChangeListener = new AdapterChangeListener();
      this.adapterChangeListener.setAutoRefresh(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.adapterChangeListener);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    while (true)
    {
      this.setupViewPagerImplicitly = paramBoolean2;
      return;
      this.viewPager = null;
      setPagerAdapter(null, false);
    }
  }

  private void updateAllTabs()
  {
    int i = this.tabs.size();
    for (int j = 0; j < i; j++)
      ((Tab)this.tabs.get(j)).updateView();
  }

  private void updateTabViewLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.tabGravity == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }

  public void addOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (!this.selectedListeners.contains(paramBaseOnTabSelectedListener))
      this.selectedListeners.add(paramBaseOnTabSelectedListener);
  }

  public void addTab(Tab paramTab)
  {
    addTab(paramTab, this.tabs.isEmpty());
  }

  public void addTab(Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, this.tabs.isEmpty());
  }

  public void addTab(Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.parent != this)
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    configureTab(paramTab, paramInt);
    addTabView(paramTab);
    if (paramBoolean)
      paramTab.select();
  }

  public void addTab(Tab paramTab, boolean paramBoolean)
  {
    addTab(paramTab, this.tabs.size(), paramBoolean);
  }

  public void addView(View paramView)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, int paramInt)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }

  public void clearOnTabSelectedListeners()
  {
    this.selectedListeners.clear();
  }

  protected Tab createTabFromPool()
  {
    Tab localTab = (Tab)tabPool.acquire();
    if (localTab == null)
      localTab = new Tab();
    return localTab;
  }

  int dpToPx(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }

  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }

  public int getSelectedTabPosition()
  {
    if (this.selectedTab != null)
      return this.selectedTab.getPosition();
    return -1;
  }

  public Tab getTabAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount()))
      return null;
    return (Tab)this.tabs.get(paramInt);
  }

  public int getTabCount()
  {
    return this.tabs.size();
  }

  public int getTabGravity()
  {
    return this.tabGravity;
  }

  public ColorStateList getTabIconTint()
  {
    return this.tabIconTint;
  }

  public int getTabIndicatorGravity()
  {
    return this.tabIndicatorGravity;
  }

  int getTabMaxWidth()
  {
    return this.tabMaxWidth;
  }

  public int getTabMode()
  {
    return this.mode;
  }

  public ColorStateList getTabRippleColor()
  {
    return this.tabRippleColorStateList;
  }

  public Drawable getTabSelectedIndicator()
  {
    return this.tabSelectedIndicator;
  }

  public ColorStateList getTabTextColors()
  {
    return this.tabTextColors;
  }

  public boolean hasUnboundedRipple()
  {
    return this.unboundedRipple;
  }

  public boolean isInlineLabel()
  {
    return this.inlineLabel;
  }

  public boolean isTabIndicatorFullWidth()
  {
    return this.tabIndicatorFullWidth;
  }

  public Tab newTab()
  {
    Tab localTab = createTabFromPool();
    localTab.parent = this;
    localTab.view = createTabView(localTab);
    return localTab;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.viewPager == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager))
        setupWithViewPager((ViewPager)localViewParent, true, true);
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.setupViewPagerImplicitly)
    {
      setupWithViewPager(null);
      this.setupViewPagerImplicitly = false;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++)
    {
      View localView = this.slidingTabIndicator.getChildAt(i);
      if ((localView instanceof TabView))
        ((TabView)localView).drawBackground(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    int k;
    int i1;
    label78: View localView;
    int m;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default:
      k = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.requestedTabMaxWidth > 0)
        {
          i1 = this.requestedTabMaxWidth;
          this.tabMaxWidth = i1;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == i)
        {
          localView = getChildAt(0);
          switch (this.mode)
          {
          default:
            m = 0;
          case 0:
          case 1:
          }
        }
      }
      break;
    case -2147483648:
    case 0:
    }
    while (true)
    {
      if (m != 0)
      {
        int n = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), n);
      }
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(j, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      break;
      i1 = k - dpToPx(56);
      break label78;
      if (localView.getMeasuredWidth() < getMeasuredWidth())
        m = i;
      else
        m = 0;
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth());
    while (true)
    {
      m = i;
      break;
      i = 0;
    }
  }

  void populateFromPagerAdapter()
  {
    removeAllTabs();
    if (this.pagerAdapter != null)
    {
      int i = this.pagerAdapter.getCount();
      for (int j = 0; j < i; j++)
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(j)), false);
      if ((this.viewPager != null) && (i > 0))
      {
        int k = this.viewPager.getCurrentItem();
        if ((k != getSelectedTabPosition()) && (k < getTabCount()))
          selectTab(getTabAt(k));
      }
    }
  }

  protected boolean releaseFromTabPool(Tab paramTab)
  {
    return tabPool.release(paramTab);
  }

  public void removeAllTabs()
  {
    for (int i = -1 + this.slidingTabIndicator.getChildCount(); i >= 0; i--)
      removeTabViewAt(i);
    Iterator localIterator = this.tabs.iterator();
    while (localIterator.hasNext())
    {
      Tab localTab = (Tab)localIterator.next();
      localIterator.remove();
      localTab.reset();
      releaseFromTabPool(localTab);
    }
    this.selectedTab = null;
  }

  public void removeOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    this.selectedListeners.remove(paramBaseOnTabSelectedListener);
  }

  public void removeTab(Tab paramTab)
  {
    if (paramTab.parent != this)
      throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    removeTabAt(paramTab.getPosition());
  }

  public void removeTabAt(int paramInt)
  {
    if (this.selectedTab != null);
    for (int i = this.selectedTab.getPosition(); ; i = 0)
    {
      removeTabViewAt(paramInt);
      Tab localTab1 = (Tab)this.tabs.remove(paramInt);
      if (localTab1 != null)
      {
        localTab1.reset();
        releaseFromTabPool(localTab1);
      }
      int j = this.tabs.size();
      for (int k = paramInt; k < j; k++)
        ((Tab)this.tabs.get(k)).setPosition(k);
    }
    if (i == paramInt)
      if (!this.tabs.isEmpty())
        break label118;
    label118: for (Tab localTab2 = null; ; localTab2 = (Tab)this.tabs.get(Math.max(0, paramInt - 1)))
    {
      selectTab(localTab2);
      return;
    }
  }

  void selectTab(Tab paramTab)
  {
    selectTab(paramTab, true);
  }

  void selectTab(Tab paramTab, boolean paramBoolean)
  {
    Tab localTab = this.selectedTab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        dispatchTabReselected(paramTab);
        animateToTab(paramTab.getPosition());
      }
      return;
    }
    int i;
    if (paramTab != null)
    {
      i = paramTab.getPosition();
      label38: if (paramBoolean)
      {
        if (((localTab != null) && (localTab.getPosition() != -1)) || (i == -1))
          break label110;
        setScrollPosition(i, 0.0F, true);
      }
    }
    while (true)
    {
      if (i != -1)
        setSelectedTabView(i);
      this.selectedTab = paramTab;
      if (localTab != null)
        dispatchTabUnselected(localTab);
      if (paramTab == null)
        break;
      dispatchTabSelected(paramTab);
      return;
      i = -1;
      break label38;
      label110: animateToTab(i);
    }
  }

  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.inlineLabel != paramBoolean)
    {
      this.inlineLabel = paramBoolean;
      for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++)
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView))
          ((TabView)localView).updateOrientation();
      }
      applyModeAndGravity();
    }
  }

  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }

  @Deprecated
  public void setOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (this.selectedListener != null)
      removeOnTabSelectedListener(this.selectedListener);
    this.selectedListener = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null)
      addOnTabSelectedListener(paramBaseOnTabSelectedListener);
  }

  void setPagerAdapter(PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.pagerAdapter != null) && (this.pagerAdapterObserver != null))
      this.pagerAdapter.unregisterDataSetObserver(this.pagerAdapterObserver);
    this.pagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (this.pagerAdapterObserver == null)
        this.pagerAdapterObserver = new PagerAdapterObserver();
      paramPagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
    }
    populateFromPagerAdapter();
  }

  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ensureScrollAnimator();
    this.scrollAnimator.addListener(paramAnimatorListener);
  }

  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }

  void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramFloat + paramInt);
    if ((i < 0) || (i >= this.slidingTabIndicator.getChildCount()));
    do
    {
      return;
      if (paramBoolean2)
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(paramInt, paramFloat);
      if ((this.scrollAnimator != null) && (this.scrollAnimator.isRunning()))
        this.scrollAnimator.cancel();
      scrollTo(calculateScrollXForTab(paramInt, paramFloat), 0);
    }
    while (!paramBoolean1);
    setSelectedTabView(i);
  }

  public void setSelectedTabIndicator(int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(android.support.v7.a.a.a.b(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }

  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    if (this.tabSelectedIndicator != paramDrawable)
    {
      this.tabSelectedIndicator = paramDrawable;
      ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }
  }

  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.slidingTabIndicator.setSelectedIndicatorColor(paramInt);
  }

  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.tabIndicatorGravity != paramInt)
    {
      this.tabIndicatorGravity = paramInt;
      ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }
  }

  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.slidingTabIndicator.setSelectedIndicatorHeight(paramInt);
  }

  public void setTabGravity(int paramInt)
  {
    if (this.tabGravity != paramInt)
    {
      this.tabGravity = paramInt;
      applyModeAndGravity();
    }
  }

  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.tabIconTint != paramColorStateList)
    {
      this.tabIconTint = paramColorStateList;
      updateAllTabs();
    }
  }

  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(android.support.v7.a.a.a.a(getContext(), paramInt));
  }

  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.tabIndicatorFullWidth = paramBoolean;
    ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
  }

  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      applyModeAndGravity();
    }
  }

  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.tabRippleColorStateList != paramColorStateList)
    {
      this.tabRippleColorStateList = paramColorStateList;
      for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++)
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView))
          ((TabView)localView).updateBackgroundDrawable(getContext());
      }
    }
  }

  public void setTabRippleColorResource(int paramInt)
  {
    setTabRippleColor(android.support.v7.a.a.a.a(getContext(), paramInt));
  }

  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(createColorStateList(paramInt1, paramInt2));
  }

  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.tabTextColors != paramColorStateList)
    {
      this.tabTextColors = paramColorStateList;
      updateAllTabs();
    }
  }

  @Deprecated
  public void setTabsFromPagerAdapter(PagerAdapter paramPagerAdapter)
  {
    setPagerAdapter(paramPagerAdapter, false);
  }

  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.unboundedRipple != paramBoolean)
    {
      this.unboundedRipple = paramBoolean;
      for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++)
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView))
          ((TabView)localView).updateBackgroundDrawable(getContext());
      }
    }
  }

  public void setUnboundedRippleResource(int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }

  public void setupWithViewPager(ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }

  public void setupWithViewPager(ViewPager paramViewPager, boolean paramBoolean)
  {
    setupWithViewPager(paramViewPager, paramBoolean, false);
  }

  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }

  void updateTabViews(boolean paramBoolean)
  {
    for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++)
    {
      View localView = this.slidingTabIndicator.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      updateTabViewLayoutParams((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean)
        localView.requestLayout();
    }
  }

  private class AdapterChangeListener
    implements ViewPager.OnAdapterChangeListener
  {
    private boolean autoRefresh;

    AdapterChangeListener()
    {
    }

    public void onAdapterChanged(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
    {
      if (TabLayout.this.viewPager == paramViewPager)
        TabLayout.this.setPagerAdapter(paramPagerAdapter2, this.autoRefresh);
    }

    void setAutoRefresh(boolean paramBoolean)
    {
      this.autoRefresh = paramBoolean;
    }
  }

  public static abstract interface BaseOnTabSelectedListener<T extends TabLayout.Tab>
  {
    public abstract void onTabReselected(T paramT);

    public abstract void onTabSelected(T paramT);

    public abstract void onTabUnselected(T paramT);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Mode
  {
  }

  public static abstract interface OnTabSelectedListener extends TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>
  {
  }

  private class PagerAdapterObserver extends DataSetObserver
  {
    PagerAdapterObserver()
    {
    }

    public void onChanged()
    {
      TabLayout.this.populateFromPagerAdapter();
    }

    public void onInvalidated()
    {
      TabLayout.this.populateFromPagerAdapter();
    }
  }

  private class SlidingTabIndicator extends LinearLayout
  {
    private final GradientDrawable defaultSelectionIndicator;
    private ValueAnimator indicatorAnimator;
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int selectedIndicatorHeight;
    private final Paint selectedIndicatorPaint;
    int selectedPosition = -1;
    float selectionOffset;

    SlidingTabIndicator(Context arg2)
    {
      super();
      setWillNotDraw(false);
      this.selectedIndicatorPaint = new Paint();
      this.defaultSelectionIndicator = new GradientDrawable();
    }

    private void calculateTabViewContentBounds(TabLayout.TabView paramTabView, RectF paramRectF)
    {
      int i = TabLayout.TabView.access$500(paramTabView);
      if (i < TabLayout.this.dpToPx(24))
        i = TabLayout.this.dpToPx(24);
      int j = (paramTabView.getLeft() + paramTabView.getRight()) / 2;
      int k = j - i / 2;
      int m = j + i / 2;
      paramRectF.set(k, 0.0F, m, 0.0F);
    }

    private void updateIndicatorPosition()
    {
      View localView1 = getChildAt(this.selectedPosition);
      int j;
      int i;
      int k;
      int m;
      int i1;
      int n;
      if ((localView1 != null) && (localView1.getWidth() > 0))
      {
        j = localView1.getLeft();
        i = localView1.getRight();
        if ((!TabLayout.this.tabIndicatorFullWidth) && ((localView1 instanceof TabLayout.TabView)))
        {
          calculateTabViewContentBounds((TabLayout.TabView)localView1, TabLayout.this.tabViewContentBounds);
          int i2 = (int)TabLayout.this.tabViewContentBounds.left;
          int i3 = (int)TabLayout.this.tabViewContentBounds.right;
          j = i2;
          i = i3;
        }
        if ((this.selectionOffset > 0.0F) && (this.selectedPosition < -1 + getChildCount()))
        {
          View localView2 = getChildAt(1 + this.selectedPosition);
          k = localView2.getLeft();
          m = localView2.getRight();
          if ((TabLayout.this.tabIndicatorFullWidth) || (!(localView2 instanceof TabLayout.TabView)))
            break label256;
          calculateTabViewContentBounds((TabLayout.TabView)localView2, TabLayout.this.tabViewContentBounds);
          i1 = (int)TabLayout.this.tabViewContentBounds.left;
          n = (int)TabLayout.this.tabViewContentBounds.right;
        }
      }
      while (true)
      {
        j = (int)(this.selectionOffset * i1 + (1.0F - this.selectionOffset) * j);
        i = (int)(this.selectionOffset * n + (1.0F - this.selectionOffset) * i);
        while (true)
        {
          setIndicatorPosition(j, i);
          return;
          i = -1;
          j = i;
        }
        label256: n = m;
        i1 = k;
      }
    }

    void animateIndicatorToPosition(final int paramInt1, int paramInt2)
    {
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning()))
        this.indicatorAnimator.cancel();
      View localView = getChildAt(paramInt1);
      if (localView == null)
        updateIndicatorPosition();
      final int i;
      final int j;
      final int k;
      final int m;
      do
      {
        return;
        i = localView.getLeft();
        j = localView.getRight();
        if ((!TabLayout.this.tabIndicatorFullWidth) && ((localView instanceof TabLayout.TabView)))
        {
          calculateTabViewContentBounds((TabLayout.TabView)localView, TabLayout.this.tabViewContentBounds);
          i = (int)TabLayout.this.tabViewContentBounds.left;
          j = (int)TabLayout.this.tabViewContentBounds.right;
        }
        k = this.indicatorLeft;
        m = this.indicatorRight;
      }
      while ((k == i) && (m == j));
      ValueAnimator localValueAnimator = new ValueAnimator();
      this.indicatorAnimator = localValueAnimator;
      localValueAnimator.setInterpolator(android.support.design.a.a.b);
      localValueAnimator.setDuration(paramInt2);
      localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = paramAnonymousValueAnimator.getAnimatedFraction();
          TabLayout.SlidingTabIndicator.this.setIndicatorPosition(android.support.design.a.a.a(k, i, f), android.support.design.a.a.a(m, j, f));
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          TabLayout.SlidingTabIndicator.this.selectedPosition = paramInt1;
          TabLayout.SlidingTabIndicator.this.selectionOffset = 0.0F;
        }
      });
      localValueAnimator.start();
    }

    boolean childrenNeedLayout()
    {
      int i = getChildCount();
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          if (getChildAt(j).getWidth() <= 0)
            bool = true;
        }
        else
          return bool;
      }
    }

    public void draw(Canvas paramCanvas)
    {
      if (TabLayout.this.tabSelectedIndicator != null);
      for (int i = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight(); ; i = 0)
      {
        if (this.selectedIndicatorHeight >= 0)
          i = this.selectedIndicatorHeight;
        int j = TabLayout.this.tabIndicatorGravity;
        int k = 0;
        Object localObject;
        label115: Drawable localDrawable;
        switch (j)
        {
        default:
          i = 0;
        case 2:
          if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
          {
            if (TabLayout.this.tabSelectedIndicator == null)
              break label229;
            localObject = TabLayout.this.tabSelectedIndicator;
            localDrawable = DrawableCompat.wrap((Drawable)localObject);
            localDrawable.setBounds(this.indicatorLeft, k, this.indicatorRight, i);
            if (this.selectedIndicatorPaint != null)
            {
              if (Build.VERSION.SDK_INT != 21)
                break label238;
              localDrawable.setColorFilter(this.selectedIndicatorPaint.getColor(), PorterDuff.Mode.SRC_IN);
            }
          }
          break;
        case 0:
        case 1:
        case 3:
        }
        while (true)
        {
          localDrawable.draw(paramCanvas);
          super.draw(paramCanvas);
          return;
          k = getHeight() - i;
          i = getHeight();
          break;
          k = (getHeight() - i) / 2;
          i = (i + getHeight()) / 2;
          break;
          i = getHeight();
          k = 0;
          break;
          label229: localObject = this.defaultSelectionIndicator;
          break label115;
          label238: DrawableCompat.setTint(localDrawable, this.selectedIndicatorPaint.getColor());
        }
      }
    }

    float getIndicatorPosition()
    {
      return this.selectedPosition + this.selectionOffset;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning()))
      {
        this.indicatorAnimator.cancel();
        long l = this.indicatorAnimator.getDuration();
        animateIndicatorToPosition(this.selectedPosition, Math.round((1.0F - this.indicatorAnimator.getAnimatedFraction()) * (float)l));
        return;
      }
      updateIndicatorPosition();
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int i = 0;
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
        break label17;
      label17: 
      while ((TabLayout.this.mode != 1) || (TabLayout.this.tabGravity != 1))
        return;
      int j = getChildCount();
      int k = 0;
      int m = 0;
      label52: View localView;
      if (k < j)
      {
        localView = getChildAt(k);
        if (localView.getVisibility() != 0)
          break label234;
      }
      label133: label217: label228: label234: for (int i3 = Math.max(m, localView.getMeasuredWidth()); ; i3 = m)
      {
        k++;
        m = i3;
        break label52;
        if (m <= 0)
          break;
        int n = TabLayout.this.dpToPx(16);
        int i1;
        if (m * j <= getMeasuredWidth() - n * 2)
        {
          i1 = 0;
          if (i1 >= j)
            break label217;
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getChildAt(i1).getLayoutParams();
          if ((localLayoutParams.width == m) && (localLayoutParams.weight == 0.0F))
            break label228;
          localLayoutParams.width = m;
          localLayoutParams.weight = 0.0F;
        }
        for (int i2 = 1; ; i2 = i)
        {
          i1++;
          i = i2;
          break label133;
          TabLayout.this.tabGravity = 0;
          TabLayout.this.updateTabViews(false);
          i = 1;
          if (i == 0)
            break;
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
      }
    }

    public void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.layoutDirection != paramInt))
      {
        requestLayout();
        this.layoutDirection = paramInt;
      }
    }

    void setIndicatorPosition(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.indicatorLeft) || (paramInt2 != this.indicatorRight))
      {
        this.indicatorLeft = paramInt1;
        this.indicatorRight = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }

    void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
    {
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning()))
        this.indicatorAnimator.cancel();
      this.selectedPosition = paramInt;
      this.selectionOffset = paramFloat;
      updateIndicatorPosition();
    }

    void setSelectedIndicatorColor(int paramInt)
    {
      if (this.selectedIndicatorPaint.getColor() != paramInt)
      {
        this.selectedIndicatorPaint.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }

    void setSelectedIndicatorHeight(int paramInt)
    {
      if (this.selectedIndicatorHeight != paramInt)
      {
        this.selectedIndicatorHeight = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }

  public static class Tab
  {
    public static final int INVALID_POSITION = -1;
    private CharSequence contentDesc;
    private View customView;
    private Drawable icon;
    public TabLayout parent;
    private int position = -1;
    private Object tag;
    private CharSequence text;
    public TabLayout.TabView view;

    public CharSequence getContentDescription()
    {
      if (this.view == null)
        return null;
      return this.view.getContentDescription();
    }

    public View getCustomView()
    {
      return this.customView;
    }

    public Drawable getIcon()
    {
      return this.icon;
    }

    public int getPosition()
    {
      return this.position;
    }

    public Object getTag()
    {
      return this.tag;
    }

    public CharSequence getText()
    {
      return this.text;
    }

    public boolean isSelected()
    {
      if (this.parent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return this.parent.getSelectedTabPosition() == this.position;
    }

    void reset()
    {
      this.parent = null;
      this.view = null;
      this.tag = null;
      this.icon = null;
      this.text = null;
      this.contentDesc = null;
      this.position = -1;
      this.customView = null;
    }

    public void select()
    {
      if (this.parent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      this.parent.selectTab(this);
    }

    public Tab setContentDescription(int paramInt)
    {
      if (this.parent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setContentDescription(this.parent.getResources().getText(paramInt));
    }

    public Tab setContentDescription(CharSequence paramCharSequence)
    {
      this.contentDesc = paramCharSequence;
      updateView();
      return this;
    }

    public Tab setCustomView(int paramInt)
    {
      return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(paramInt, this.view, false));
    }

    public Tab setCustomView(View paramView)
    {
      this.customView = paramView;
      updateView();
      return this;
    }

    public Tab setIcon(int paramInt)
    {
      if (this.parent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setIcon(android.support.v7.a.a.a.b(this.parent.getContext(), paramInt));
    }

    public Tab setIcon(Drawable paramDrawable)
    {
      this.icon = paramDrawable;
      updateView();
      return this;
    }

    void setPosition(int paramInt)
    {
      this.position = paramInt;
    }

    public Tab setTag(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }

    public Tab setText(int paramInt)
    {
      if (this.parent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setText(this.parent.getResources().getText(paramInt));
    }

    public Tab setText(CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(this.contentDesc)) && (!TextUtils.isEmpty(paramCharSequence)))
        this.view.setContentDescription(paramCharSequence);
      this.text = paramCharSequence;
      updateView();
      return this;
    }

    void updateView()
    {
      if (this.view != null)
        this.view.update();
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TabGravity
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TabIndicatorGravity
  {
  }

  public static class TabLayoutOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int previousScrollState;
    private int scrollState;
    private final WeakReference<TabLayout> tabLayoutRef;

    public TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
    {
      this.tabLayoutRef = new WeakReference(paramTabLayout);
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      this.previousScrollState = this.scrollState;
      this.scrollState = paramInt;
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)this.tabLayoutRef.get();
      if (localTabLayout != null)
        if ((this.scrollState == 2) && (this.previousScrollState != 1))
          break label73;
      label73: for (boolean bool1 = true; ; bool1 = false)
      {
        boolean bool2;
        if (this.scrollState == 2)
        {
          int i = this.previousScrollState;
          bool2 = false;
          if (i == 0);
        }
        else
        {
          bool2 = true;
        }
        localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
        return;
      }
    }

    public void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.tabLayoutRef.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount()))
        if ((this.scrollState != 0) && ((this.scrollState != 2) || (this.previousScrollState != 0)))
          break label66;
      label66: for (boolean bool = true; ; bool = false)
      {
        localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
        return;
      }
    }

    void reset()
    {
      this.scrollState = 0;
      this.previousScrollState = 0;
    }
  }

  class TabView extends LinearLayout
  {
    private Drawable baseBackgroundDrawable;
    private ImageView customIconView;
    private TextView customTextView;
    private View customView;
    private int defaultMaxLines = 2;
    private ImageView iconView;
    private TabLayout.Tab tab;
    private TextView textView;

    public TabView(Context arg2)
    {
      super();
      updateBackgroundDrawable(localContext);
      ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
      setGravity(17);
      if (TabLayout.this.inlineLabel);
      for (int i = 0; ; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        return;
      }
    }

    private float approximateLineWidth(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }

    private void drawBackground(Canvas paramCanvas)
    {
      if (this.baseBackgroundDrawable != null)
      {
        this.baseBackgroundDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.baseBackgroundDrawable.draw(paramCanvas);
      }
    }

    private int getContentWidth()
    {
      int i = 0;
      View[] arrayOfView = new View[3];
      arrayOfView[0] = this.textView;
      arrayOfView[1] = this.iconView;
      arrayOfView[2] = this.customView;
      int j = arrayOfView.length;
      int k = 0;
      int m = 0;
      int n = 0;
      if (k < j)
      {
        View localView = arrayOfView[k];
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          if (n == 0)
            break label106;
          m = Math.min(m, localView.getLeft());
          label82: if (n == 0)
            break label116;
        }
        label106: label116: for (i = Math.max(i, localView.getRight()); ; i = localView.getRight())
        {
          n = 1;
          k++;
          break;
          m = localView.getLeft();
          break label82;
        }
      }
      return i - m;
    }

    private void updateBackgroundDrawable(Context paramContext)
    {
      GradientDrawable localGradientDrawable1;
      GradientDrawable localGradientDrawable2;
      ColorStateList localColorStateList;
      Object localObject2;
      label148: Object localObject1;
      if (TabLayout.this.tabBackgroundResId != 0)
      {
        this.baseBackgroundDrawable = android.support.v7.a.a.a.b(paramContext, TabLayout.this.tabBackgroundResId);
        if ((this.baseBackgroundDrawable != null) && (this.baseBackgroundDrawable.isStateful()))
          this.baseBackgroundDrawable.setState(getDrawableState());
        localGradientDrawable1 = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable1).setColor(0);
        if (TabLayout.this.tabRippleColorStateList == null)
          break label228;
        localGradientDrawable2 = new GradientDrawable();
        localGradientDrawable2.setCornerRadius(1.0E-005F);
        localGradientDrawable2.setColor(-1);
        localColorStateList = android.support.design.f.a.a(TabLayout.this.tabRippleColorStateList);
        if (Build.VERSION.SDK_INT < 21)
          break label190;
        if (TabLayout.this.unboundedRipple)
          localGradientDrawable1 = null;
        boolean bool = TabLayout.this.unboundedRipple;
        localObject2 = null;
        if (!bool)
          break label184;
        localObject1 = new RippleDrawable(localColorStateList, localGradientDrawable1, (Drawable)localObject2);
      }
      while (true)
      {
        ViewCompat.setBackground(this, (Drawable)localObject1);
        TabLayout.this.invalidate();
        return;
        this.baseBackgroundDrawable = null;
        break;
        label184: localObject2 = localGradientDrawable2;
        break label148;
        label190: Drawable localDrawable = DrawableCompat.wrap(localGradientDrawable2);
        DrawableCompat.setTintList(localDrawable, localColorStateList);
        localObject1 = new LayerDrawable(new Drawable[] { localGradientDrawable1, localDrawable });
        continue;
        label228: localObject1 = localGradientDrawable1;
      }
    }

    private void updateTextAndIcon(TextView paramTextView, ImageView paramImageView)
    {
      Drawable localDrawable;
      CharSequence localCharSequence1;
      label47: label70: int i;
      label81: label106: ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if ((this.tab != null) && (this.tab.getIcon() != null))
      {
        localDrawable = DrawableCompat.wrap(this.tab.getIcon()).mutate();
        if (this.tab == null)
          break label221;
        localCharSequence1 = this.tab.getText();
        if (paramImageView != null)
        {
          if (localDrawable == null)
            break label227;
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        if (TextUtils.isEmpty(localCharSequence1))
          break label241;
        i = 1;
        if (paramTextView != null)
        {
          if (i == 0)
            break label247;
          paramTextView.setText(localCharSequence1);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
        if (paramImageView != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          if ((i == 0) || (paramImageView.getVisibility() != 0))
            break label310;
        }
      }
      label297: label303: label310: for (int j = TabLayout.this.dpToPx(8); ; j = 0)
      {
        label185: CharSequence localCharSequence2;
        label201: CharSequence localCharSequence3;
        if (TabLayout.this.inlineLabel)
        {
          if (j != MarginLayoutParamsCompat.getMarginEnd(localMarginLayoutParams))
          {
            MarginLayoutParamsCompat.setMarginEnd(localMarginLayoutParams, j);
            localMarginLayoutParams.bottomMargin = 0;
            paramImageView.setLayoutParams(localMarginLayoutParams);
            paramImageView.requestLayout();
          }
          if (this.tab == null)
            break label297;
          localCharSequence2 = this.tab.contentDesc;
          localCharSequence3 = null;
          if (i == 0)
            break label303;
        }
        while (true)
        {
          TooltipCompat.setTooltipText(this, localCharSequence3);
          return;
          localDrawable = null;
          break;
          label221: localCharSequence1 = null;
          break label47;
          label227: paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
          break label70;
          label241: i = 0;
          break label81;
          label247: paramTextView.setVisibility(8);
          paramTextView.setText(null);
          break label106;
          if (j == localMarginLayoutParams.bottomMargin)
            break label185;
          localMarginLayoutParams.bottomMargin = j;
          MarginLayoutParamsCompat.setMarginEnd(localMarginLayoutParams, 0);
          paramImageView.setLayoutParams(localMarginLayoutParams);
          paramImageView.requestLayout();
          break label185;
          localCharSequence2 = null;
          break label201;
          localCharSequence3 = localCharSequence2;
        }
      }
    }

    protected void drawableStateChanged()
    {
      super.drawableStateChanged();
      int[] arrayOfInt = getDrawableState();
      Drawable localDrawable = this.baseBackgroundDrawable;
      boolean bool1 = false;
      if (localDrawable != null)
      {
        boolean bool2 = this.baseBackgroundDrawable.isStateful();
        bool1 = false;
        if (bool2)
          bool1 = false | this.baseBackgroundDrawable.setState(arrayOfInt);
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
    }

    public TabLayout.Tab getTab()
    {
      return this.tab;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(a.c.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(a.c.class.getName());
    }

    public void onMeasure(int paramInt1, int paramInt2)
    {
      int i = 1;
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = TabLayout.this.getTabMaxWidth();
      if ((m > 0) && ((k == 0) || (j > m)))
        paramInt1 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, -2147483648);
      super.onMeasure(paramInt1, paramInt2);
      float f1;
      int n;
      if (this.textView != null)
      {
        f1 = TabLayout.this.tabTextSize;
        n = this.defaultMaxLines;
        if ((this.iconView == null) || (this.iconView.getVisibility() != 0))
          break label248;
        n = i;
      }
      while (true)
      {
        float f2 = this.textView.getTextSize();
        int i1 = this.textView.getLineCount();
        int i2 = TextViewCompat.getMaxLines(this.textView);
        if ((f1 != f2) || ((i2 >= 0) && (n != i2)))
        {
          if ((TabLayout.this.mode == i) && (f1 > f2) && (i1 == i))
          {
            Layout localLayout = this.textView.getLayout();
            if ((localLayout == null) || (approximateLineWidth(localLayout, 0, f1) > getMeasuredWidth() - getPaddingLeft() - getPaddingRight()))
              i = 0;
          }
          if (i != 0)
          {
            this.textView.setTextSize(0, f1);
            this.textView.setMaxLines(n);
            super.onMeasure(paramInt1, paramInt2);
          }
        }
        return;
        label248: if ((this.textView != null) && (this.textView.getLineCount() > i))
          f1 = TabLayout.this.tabTextMultiLineSize;
      }
    }

    public boolean performClick()
    {
      boolean bool = super.performClick();
      if (this.tab != null)
      {
        if (!bool)
          playSoundEffect(0);
        this.tab.select();
        bool = true;
      }
      return bool;
    }

    void reset()
    {
      setTab(null);
      setSelected(false);
    }

    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean);
      for (int i = 1; ; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16))
          sendAccessibilityEvent(4);
        if (this.textView != null)
          this.textView.setSelected(paramBoolean);
        if (this.iconView != null)
          this.iconView.setSelected(paramBoolean);
        if (this.customView != null)
          this.customView.setSelected(paramBoolean);
        return;
      }
    }

    void setTab(TabLayout.Tab paramTab)
    {
      if (paramTab != this.tab)
      {
        this.tab = paramTab;
        update();
      }
    }

    final void update()
    {
      TabLayout.Tab localTab = this.tab;
      View localView;
      label140: Drawable localDrawable;
      if (localTab != null)
      {
        localView = localTab.getCustomView();
        if (localView == null)
          break label395;
        ViewParent localViewParent = localView.getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null)
            ((ViewGroup)localViewParent).removeView(localView);
          addView(localView);
        }
        this.customView = localView;
        if (this.textView != null)
          this.textView.setVisibility(8);
        if (this.iconView != null)
        {
          this.iconView.setVisibility(8);
          this.iconView.setImageDrawable(null);
        }
        this.customTextView = ((TextView)localView.findViewById(16908308));
        if (this.customTextView != null)
          this.defaultMaxLines = TextViewCompat.getMaxLines(this.customTextView);
        this.customIconView = ((ImageView)localView.findViewById(16908294));
        if (this.customView != null)
          break label434;
        if (this.iconView == null)
        {
          ImageView localImageView = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
          addView(localImageView, 0);
          this.iconView = localImageView;
        }
        if ((localTab == null) || (localTab.getIcon() == null))
          break label428;
        localDrawable = DrawableCompat.wrap(localTab.getIcon()).mutate();
        label210: if (localDrawable != null)
        {
          DrawableCompat.setTintList(localDrawable, TabLayout.this.tabIconTint);
          if (TabLayout.this.tabIconTintMode != null)
            DrawableCompat.setTintMode(localDrawable, TabLayout.this.tabIconTintMode);
        }
        if (this.textView == null)
        {
          TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
          addView(localTextView);
          this.textView = localTextView;
          this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
        }
        TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
        if (TabLayout.this.tabTextColors != null)
          this.textView.setTextColor(TabLayout.this.tabTextColors);
        updateTextAndIcon(this.textView, this.iconView);
        label349: if ((localTab != null) && (!TextUtils.isEmpty(localTab.contentDesc)))
          setContentDescription(localTab.contentDesc);
        if ((localTab == null) || (!localTab.isSelected()))
          break label463;
      }
      label395: label428: label434: label463: for (boolean bool = true; ; bool = false)
      {
        setSelected(bool);
        return;
        localView = null;
        break;
        if (this.customView != null)
        {
          removeView(this.customView);
          this.customView = null;
        }
        this.customTextView = null;
        this.customIconView = null;
        break label140;
        localDrawable = null;
        break label210;
        if ((this.customTextView == null) && (this.customIconView == null))
          break label349;
        updateTextAndIcon(this.customTextView, this.customIconView);
        break label349;
      }
    }

    final void updateOrientation()
    {
      if (TabLayout.this.inlineLabel);
      for (int i = 0; ; i = 1)
      {
        setOrientation(i);
        if ((this.customTextView == null) && (this.customIconView == null))
          break;
        updateTextAndIcon(this.customTextView, this.customIconView);
        return;
      }
      updateTextAndIcon(this.textView, this.iconView);
    }
  }

  public static class ViewPagerOnTabSelectedListener
    implements TabLayout.OnTabSelectedListener
  {
    private final ViewPager viewPager;

    public ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
    {
      this.viewPager = paramViewPager;
    }

    public void onTabReselected(TabLayout.Tab paramTab)
    {
    }

    public void onTabSelected(TabLayout.Tab paramTab)
    {
      this.viewPager.setCurrentItem(paramTab.getPosition());
    }

    public void onTabUnselected(TabLayout.Tab paramTab)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.6.2
 */