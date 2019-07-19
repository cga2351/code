package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R.id;
import android.support.design.R.styleable;
import android.support.design.a.a;
import android.support.design.internal.j;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout extends FrameLayout
{
  private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
  final CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
  private boolean collapsingTitleEnabled;
  private Drawable contentScrim;
  int currentOffset;
  private boolean drawCollapsingTitle;
  private View dummyView;
  private int expandedMarginBottom;
  private int expandedMarginEnd;
  private int expandedMarginStart;
  private int expandedMarginTop;
  WindowInsetsCompat lastInsets;
  private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
  private boolean refreshToolbar = true;
  private int scrimAlpha;
  private long scrimAnimationDuration;
  private ValueAnimator scrimAnimator;
  private int scrimVisibleHeightTrigger = -1;
  private boolean scrimsAreShown;
  Drawable statusBarScrim;
  private final Rect tmpRect = new Rect();
  private Toolbar toolbar;
  private View toolbarDirectChild;
  private int toolbarId;

  public CollapsingToolbarLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.collapsingTextHelper.setTextSizeInterpolator(a.e);
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, android.support.design.R.style.Widget_Design_CollapsingToolbar, new int[0]);
    this.collapsingTextHelper.setExpandedTextGravity(localTypedArray.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.collapsingTextHelper.setCollapsedTextGravity(localTypedArray.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    int i = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.expandedMarginBottom = i;
    this.expandedMarginEnd = i;
    this.expandedMarginTop = i;
    this.expandedMarginStart = i;
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart))
      this.expandedMarginStart = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd))
      this.expandedMarginEnd = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop))
      this.expandedMarginTop = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom))
      this.expandedMarginBottom = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    this.collapsingTitleEnabled = localTypedArray.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(localTypedArray.getText(R.styleable.CollapsingToolbarLayout_title));
    this.collapsingTextHelper.setExpandedTextAppearance(android.support.design.R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.collapsingTextHelper.setCollapsedTextAppearance(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance))
      this.collapsingTextHelper.setExpandedTextAppearance(localTypedArray.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    if (localTypedArray.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance))
      this.collapsingTextHelper.setCollapsedTextAppearance(localTypedArray.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    this.scrimVisibleHeightTrigger = localTypedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    this.scrimAnimationDuration = localTypedArray.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(localTypedArray.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(localTypedArray.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    this.toolbarId = localTypedArray.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    localTypedArray.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return CollapsingToolbarLayout.this.onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }

  private void animateScrim(int paramInt)
  {
    ensureToolbar();
    TimeInterpolator localTimeInterpolator;
    if (this.scrimAnimator == null)
    {
      this.scrimAnimator = new ValueAnimator();
      this.scrimAnimator.setDuration(this.scrimAnimationDuration);
      ValueAnimator localValueAnimator2 = this.scrimAnimator;
      if (paramInt > this.scrimAlpha)
      {
        localTimeInterpolator = a.c;
        localValueAnimator2.setInterpolator(localTimeInterpolator);
        this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
    }
    while (true)
    {
      ValueAnimator localValueAnimator1 = this.scrimAnimator;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = this.scrimAlpha;
      arrayOfInt[1] = paramInt;
      localValueAnimator1.setIntValues(arrayOfInt);
      this.scrimAnimator.start();
      return;
      localTimeInterpolator = a.d;
      break;
      if (this.scrimAnimator.isRunning())
        this.scrimAnimator.cancel();
    }
  }

  private void ensureToolbar()
  {
    if (!this.refreshToolbar)
      return;
    this.toolbar = null;
    this.toolbarDirectChild = null;
    if (this.toolbarId != -1)
    {
      this.toolbar = ((Toolbar)findViewById(this.toolbarId));
      if (this.toolbar != null)
        this.toolbarDirectChild = findDirectChild(this.toolbar);
    }
    int j;
    View localView;
    if (this.toolbar == null)
    {
      int i = getChildCount();
      j = 0;
      if (j >= i)
        break label121;
      localView = getChildAt(j);
      if (!(localView instanceof Toolbar))
        break label115;
    }
    label115: label121: for (Toolbar localToolbar = (Toolbar)localView; ; localToolbar = null)
    {
      this.toolbar = localToolbar;
      updateDummyView();
      this.refreshToolbar = false;
      return;
      j++;
      break;
    }
  }

  private View findDirectChild(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    while ((localViewParent != this) && (localViewParent != null))
    {
      if ((localViewParent instanceof View))
        localView = (View)localViewParent;
      localViewParent = localViewParent.getParent();
    }
    return localView;
  }

  private static int getHeightWithMargins(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
      return paramView.getHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
    }
    return paramView.getHeight();
  }

  static ViewOffsetHelper getViewOffsetHelper(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = (ViewOffsetHelper)paramView.getTag(R.id.view_offset_helper);
    if (localViewOffsetHelper == null)
    {
      localViewOffsetHelper = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.view_offset_helper, localViewOffsetHelper);
    }
    return localViewOffsetHelper;
  }

  private boolean isToolbarChild(View paramView)
  {
    if ((this.toolbarDirectChild == null) || (this.toolbarDirectChild == this))
      if (paramView != this.toolbar);
    while (paramView == this.toolbarDirectChild)
    {
      return true;
      return false;
    }
    return false;
  }

  private void updateContentDescriptionFromTitle()
  {
    setContentDescription(getTitle());
  }

  private void updateDummyView()
  {
    if ((!this.collapsingTitleEnabled) && (this.dummyView != null))
    {
      ViewParent localViewParent = this.dummyView.getParent();
      if ((localViewParent instanceof ViewGroup))
        ((ViewGroup)localViewParent).removeView(this.dummyView);
    }
    if ((this.collapsingTitleEnabled) && (this.toolbar != null))
    {
      if (this.dummyView == null)
        this.dummyView = new View(getContext());
      if (this.dummyView.getParent() == null)
        this.toolbar.addView(this.dummyView, -1, -1);
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ensureToolbar();
    if ((this.toolbar == null) && (this.contentScrim != null) && (this.scrimAlpha > 0))
    {
      this.contentScrim.mutate().setAlpha(this.scrimAlpha);
      this.contentScrim.draw(paramCanvas);
    }
    if ((this.collapsingTitleEnabled) && (this.drawCollapsingTitle))
      this.collapsingTextHelper.draw(paramCanvas);
    if ((this.statusBarScrim != null) && (this.scrimAlpha > 0))
      if (this.lastInsets == null)
        break label153;
    label153: for (int i = this.lastInsets.getSystemWindowInsetTop(); ; i = 0)
    {
      if (i > 0)
      {
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), i - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(paramCanvas);
      }
      return;
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if ((this.contentScrim != null) && (this.scrimAlpha > 0) && (isToolbarChild(paramView)))
    {
      this.contentScrim.mutate().setAlpha(this.scrimAlpha);
      this.contentScrim.draw(paramCanvas);
    }
    for (int i = 1; ; i = 0)
    {
      boolean bool;
      if (!super.drawChild(paramCanvas, paramView, paramLong))
      {
        bool = false;
        if (i == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable1 = this.statusBarScrim;
    boolean bool1 = false;
    if (localDrawable1 != null)
    {
      boolean bool2 = localDrawable1.isStateful();
      bool1 = false;
      if (bool2)
        bool1 = false | localDrawable1.setState(arrayOfInt);
    }
    Drawable localDrawable2 = this.contentScrim;
    if ((localDrawable2 != null) && (localDrawable2.isStateful()))
      bool1 |= localDrawable2.setState(arrayOfInt);
    if (this.collapsingTextHelper != null)
      bool1 |= this.collapsingTextHelper.setState(arrayOfInt);
    if (bool1)
      invalidate();
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }

  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }

  public int getCollapsedTitleGravity()
  {
    return this.collapsingTextHelper.getCollapsedTextGravity();
  }

  public Typeface getCollapsedTitleTypeface()
  {
    return this.collapsingTextHelper.getCollapsedTypeface();
  }

  public Drawable getContentScrim()
  {
    return this.contentScrim;
  }

  public int getExpandedTitleGravity()
  {
    return this.collapsingTextHelper.getExpandedTextGravity();
  }

  public int getExpandedTitleMarginBottom()
  {
    return this.expandedMarginBottom;
  }

  public int getExpandedTitleMarginEnd()
  {
    return this.expandedMarginEnd;
  }

  public int getExpandedTitleMarginStart()
  {
    return this.expandedMarginStart;
  }

  public int getExpandedTitleMarginTop()
  {
    return this.expandedMarginTop;
  }

  public Typeface getExpandedTitleTypeface()
  {
    return this.collapsingTextHelper.getExpandedTypeface();
  }

  final int getMaxOffsetForPinChild(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = getViewOffsetHelper(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.getLayoutTop() - paramView.getHeight() - localLayoutParams.bottomMargin;
  }

  int getScrimAlpha()
  {
    return this.scrimAlpha;
  }

  public long getScrimAnimationDuration()
  {
    return this.scrimAnimationDuration;
  }

  public int getScrimVisibleHeightTrigger()
  {
    if (this.scrimVisibleHeightTrigger >= 0)
      return this.scrimVisibleHeightTrigger;
    if (this.lastInsets != null);
    for (int i = this.lastInsets.getSystemWindowInsetTop(); ; i = 0)
    {
      int j = ViewCompat.getMinimumHeight(this);
      if (j <= 0)
        break;
      return Math.min(i + j * 2, getHeight());
    }
    return getHeight() / 3;
  }

  public Drawable getStatusBarScrim()
  {
    return this.statusBarScrim;
  }

  public CharSequence getTitle()
  {
    if (this.collapsingTitleEnabled)
      return this.collapsingTextHelper.getText();
    return null;
  }

  public boolean isTitleEnabled()
  {
    return this.collapsingTitleEnabled;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (this.onOffsetChangedListener == null)
        this.onOffsetChangedListener = new OffsetUpdateListener();
      ((AppBarLayout)localViewParent).addOnOffsetChangedListener(this.onOffsetChangedListener);
      ViewCompat.requestApplyInsets(this);
    }
  }

  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    if ((this.onOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout)))
      ((AppBarLayout)localViewParent).removeOnOffsetChangedListener(this.onOffsetChangedListener);
    super.onDetachedFromWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    int j = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.lastInsets != null)
    {
      int i11 = this.lastInsets.getSystemWindowInsetTop();
      int i12 = getChildCount();
      for (int i13 = 0; i13 < i12; i13++)
      {
        View localView = getChildAt(i13);
        if ((!ViewCompat.getFitsSystemWindows(localView)) && (localView.getTop() < i11))
          ViewCompat.offsetTopAndBottom(localView, i11);
      }
    }
    int m;
    label148: Object localObject;
    label161: int i2;
    label210: int i6;
    label260: CollapsingTextHelper localCollapsingTextHelper2;
    int i7;
    label309: int i8;
    int i9;
    if ((this.collapsingTitleEnabled) && (this.dummyView != null))
    {
      if ((!ViewCompat.isAttachedToWindow(this.dummyView)) || (this.dummyView.getVisibility() != 0))
        break label401;
      m = i;
      this.drawCollapsingTitle = m;
      if (this.drawCollapsingTitle)
      {
        if (ViewCompat.getLayoutDirection(this) != i)
          break label407;
        if (this.toolbarDirectChild == null)
          break label413;
        localObject = this.toolbarDirectChild;
        int n = getMaxOffsetForPinChild((View)localObject);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        CollapsingTextHelper localCollapsingTextHelper1 = this.collapsingTextHelper;
        int i1 = this.tmpRect.left;
        if (i == 0)
          break label422;
        i2 = this.toolbar.getTitleMarginEnd();
        int i3 = i1 + i2;
        int i4 = n + this.tmpRect.top + this.toolbar.getTitleMarginTop();
        int i5 = this.tmpRect.right;
        if (i == 0)
          break label434;
        i6 = this.toolbar.getTitleMarginStart();
        localCollapsingTextHelper1.setCollapsedBounds(i3, i4, i6 + i5, n + this.tmpRect.bottom - this.toolbar.getTitleMarginBottom());
        localCollapsingTextHelper2 = this.collapsingTextHelper;
        if (i == 0)
          break label446;
        i7 = this.expandedMarginEnd;
        i8 = this.tmpRect.top + this.expandedMarginTop;
        i9 = paramInt3 - paramInt1;
        if (i == 0)
          break label455;
      }
    }
    label401: label407: label413: label422: label434: label446: label455: for (int i10 = this.expandedMarginStart; ; i10 = this.expandedMarginEnd)
    {
      localCollapsingTextHelper2.setExpandedBounds(i7, i8, i9 - i10, paramInt4 - paramInt2 - this.expandedMarginBottom);
      this.collapsingTextHelper.recalculate();
      int k = getChildCount();
      while (j < k)
      {
        getViewOffsetHelper(getChildAt(j)).onViewLayout();
        j++;
      }
      m = 0;
      break;
      i = 0;
      break label148;
      localObject = this.toolbar;
      break label161;
      i2 = this.toolbar.getTitleMarginStart();
      break label210;
      i6 = this.toolbar.getTitleMarginEnd();
      break label260;
      i7 = this.expandedMarginStart;
      break label309;
    }
    if (this.toolbar != null)
    {
      if ((this.collapsingTitleEnabled) && (TextUtils.isEmpty(this.collapsingTextHelper.getText())))
        setTitle(this.toolbar.getTitle());
      if ((this.toolbarDirectChild != null) && (this.toolbarDirectChild != this))
        break label533;
      setMinimumHeight(getHeightWithMargins(this.toolbar));
    }
    while (true)
    {
      updateScrimVisibility();
      return;
      label533: setMinimumHeight(getHeightWithMargins(this.toolbarDirectChild));
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ensureToolbar();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.lastInsets != null);
    for (int j = this.lastInsets.getSystemWindowInsetTop(); ; j = 0)
    {
      if ((i == 0) && (j > 0))
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(j + getMeasuredHeight(), 1073741824));
      return;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.contentScrim != null)
      this.contentScrim.setBounds(0, 0, paramInt1, paramInt2);
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
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }

  public void setCollapsedTitleGravity(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextGravity(paramInt);
  }

  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextAppearance(paramInt);
  }

  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }

  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.collapsingTextHelper.setCollapsedTextColor(paramColorStateList);
  }

  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    this.collapsingTextHelper.setCollapsedTypeface(paramTypeface);
  }

  public void setContentScrim(Drawable paramDrawable)
  {
    if (this.contentScrim != paramDrawable)
    {
      if (this.contentScrim != null)
        this.contentScrim.setCallback(null);
      Drawable localDrawable = null;
      if (paramDrawable != null)
        localDrawable = paramDrawable.mutate();
      this.contentScrim = localDrawable;
      if (this.contentScrim != null)
      {
        this.contentScrim.setBounds(0, 0, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }

  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }

  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }

  public void setExpandedTitleGravity(int paramInt)
  {
    this.collapsingTextHelper.setExpandedTextGravity(paramInt);
  }

  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.expandedMarginStart = paramInt1;
    this.expandedMarginTop = paramInt2;
    this.expandedMarginEnd = paramInt3;
    this.expandedMarginBottom = paramInt4;
    requestLayout();
  }

  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.expandedMarginBottom = paramInt;
    requestLayout();
  }

  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.expandedMarginEnd = paramInt;
    requestLayout();
  }

  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.expandedMarginStart = paramInt;
    requestLayout();
  }

  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.expandedMarginTop = paramInt;
    requestLayout();
  }

  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setExpandedTextAppearance(paramInt);
  }

  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.collapsingTextHelper.setExpandedTextColor(paramColorStateList);
  }

  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    this.collapsingTextHelper.setExpandedTypeface(paramTypeface);
  }

  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.scrimAlpha)
    {
      if ((this.contentScrim != null) && (this.toolbar != null))
        ViewCompat.postInvalidateOnAnimation(this.toolbar);
      this.scrimAlpha = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  public void setScrimAnimationDuration(long paramLong)
  {
    this.scrimAnimationDuration = paramLong;
  }

  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.scrimVisibleHeightTrigger != paramInt)
    {
      this.scrimVisibleHeightTrigger = paramInt;
      updateScrimVisibility();
    }
  }

  public void setScrimsShown(boolean paramBoolean)
  {
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode()));
    for (boolean bool = true; ; bool = false)
    {
      setScrimsShown(paramBoolean, bool);
      return;
    }
  }

  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 255;
    if (this.scrimsAreShown != paramBoolean1)
    {
      if (!paramBoolean2)
        break label36;
      if (!paramBoolean1)
        break label31;
    }
    while (true)
    {
      animateScrim(i);
      this.scrimsAreShown = paramBoolean1;
      return;
      label31: i = 0;
    }
    label36: if (paramBoolean1);
    while (true)
    {
      setScrimAlpha(i);
      break;
      i = 0;
    }
  }

  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2;
    if (this.statusBarScrim != paramDrawable)
    {
      if (this.statusBarScrim != null)
        this.statusBarScrim.setCallback(null);
      Drawable localDrawable1 = null;
      if (paramDrawable != null)
        localDrawable1 = paramDrawable.mutate();
      this.statusBarScrim = localDrawable1;
      if (this.statusBarScrim != null)
      {
        if (this.statusBarScrim.isStateful())
          this.statusBarScrim.setState(getDrawableState());
        DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
        localDrawable2 = this.statusBarScrim;
        if (getVisibility() != 0)
          break label129;
      }
    }
    label129: for (boolean bool = true; ; bool = false)
    {
      localDrawable2.setVisible(bool, false);
      this.statusBarScrim.setCallback(this);
      this.statusBarScrim.setAlpha(this.scrimAlpha);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
  }

  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }

  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.collapsingTextHelper.setText(paramCharSequence);
    updateContentDescriptionFromTitle();
  }

  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.collapsingTitleEnabled)
    {
      this.collapsingTitleEnabled = paramBoolean;
      updateContentDescriptionFromTitle();
      updateDummyView();
      requestLayout();
    }
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      if ((this.statusBarScrim != null) && (this.statusBarScrim.isVisible() != bool))
        this.statusBarScrim.setVisible(bool, false);
      if ((this.contentScrim != null) && (this.contentScrim.isVisible() != bool))
        this.contentScrim.setVisible(bool, false);
      return;
    }
  }

  final void updateScrimVisibility()
  {
    if ((this.contentScrim != null) || (this.statusBarScrim != null))
      if (getHeight() + this.currentOffset >= getScrimVisibleHeightTrigger())
        break label38;
    label38: for (boolean bool = true; ; bool = false)
    {
      setScrimsShown(bool);
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.contentScrim) || (paramDrawable == this.statusBarScrim);
  }

  public static class LayoutParams extends FrameLayout.LayoutParams
  {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
    int collapseMode = 0;
    float parallaxMult = 0.5F;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingToolbarLayout_Layout);
      this.collapseMode = localTypedArray.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      setParallaxMultiplier(localTypedArray.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
      localTypedArray.recycle();
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
    }

    public int getCollapseMode()
    {
      return this.collapseMode;
    }

    public float getParallaxMultiplier()
    {
      return this.parallaxMult;
    }

    public void setCollapseMode(int paramInt)
    {
      this.collapseMode = paramInt;
    }

    public void setParallaxMultiplier(float paramFloat)
    {
      this.parallaxMult = paramFloat;
    }
  }

  private class OffsetUpdateListener
    implements AppBarLayout.OnOffsetChangedListener
  {
    OffsetUpdateListener()
    {
    }

    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      CollapsingToolbarLayout.this.currentOffset = paramInt;
      int i;
      int k;
      label41: View localView;
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      ViewOffsetHelper localViewOffsetHelper;
      if (CollapsingToolbarLayout.this.lastInsets != null)
      {
        i = CollapsingToolbarLayout.this.lastInsets.getSystemWindowInsetTop();
        int j = CollapsingToolbarLayout.this.getChildCount();
        k = 0;
        if (k >= j)
          break label160;
        localView = CollapsingToolbarLayout.this.getChildAt(k);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)localView.getLayoutParams();
        localViewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(localView);
        switch (localLayoutParams.collapseMode)
        {
        default:
        case 1:
        case 2:
        }
      }
      while (true)
      {
        k++;
        break label41;
        i = 0;
        break;
        localViewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-paramInt, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(localView)));
        continue;
        localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * localLayoutParams.parallaxMult));
      }
      label160: CollapsingToolbarLayout.this.updateScrimVisibility();
      if ((CollapsingToolbarLayout.this.statusBarScrim != null) && (i > 0))
        ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
      int m = CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this) - i;
      CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction(Math.abs(paramInt) / m);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.6.2
 */