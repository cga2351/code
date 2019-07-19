package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.a;
import android.support.v7.app.a.a;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.u;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup
{
  private static final String TAG = "Toolbar";
  private o.a mActionMenuPresenterCallback;
  int mButtonGravity;
  ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private int mContentInsetEndWithActions;
  private int mContentInsetStartWithNavigation;
  private RtlSpacingHelper mContentInsets;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  View mExpandedActionView;
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private final ArrayList<View> mHiddenViews = new ArrayList();
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  private h.a mMenuBuilderCallback;
  private ActionMenuView mMenuView;
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.mOnMenuItemClickListener != null)
        return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(paramAnonymousMenuItem);
      return false;
    }
  };
  private ImageButton mNavButtonView;
  OnMenuItemClickListener mOnMenuItemClickListener;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new Runnable()
  {
    public void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private int mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<View> mTempViews = new ArrayList();
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private int mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;

  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }

  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }

  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = localTintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = localTintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = localTintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = localTintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    if (localTintTypedArray.hasValue(R.styleable.Toolbar_titleMargins))
      i = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i);
    this.mTitleMarginBottom = i;
    this.mTitleMarginTop = i;
    this.mTitleMarginEnd = i;
    this.mTitleMarginStart = i;
    int j = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (j >= 0)
      this.mTitleMarginStart = j;
    int k = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (k >= 0)
      this.mTitleMarginEnd = k;
    int m = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (m >= 0)
      this.mTitleMarginTop = m;
    int n = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (n >= 0)
      this.mTitleMarginBottom = n;
    this.mMaxButtonHeight = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    int i1 = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    int i2 = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int i3 = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int i4 = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    ensureContentInsets();
    this.mContentInsets.setAbsolute(i3, i4);
    if ((i1 != -2147483648) || (i2 != -2147483648))
      this.mContentInsets.setRelative(i1, i2);
    this.mContentInsetStartWithNavigation = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.mContentInsetEndWithActions = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.mCollapseIcon = localTintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = localTintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
    CharSequence localCharSequence1 = localTintTypedArray.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(localCharSequence1))
      setTitle(localCharSequence1);
    CharSequence localCharSequence2 = localTintTypedArray.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(localCharSequence2))
      setSubtitle(localCharSequence2);
    this.mPopupContext = getContext();
    setPopupTheme(localTintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    Drawable localDrawable1 = localTintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (localDrawable1 != null)
      setNavigationIcon(localDrawable1);
    CharSequence localCharSequence3 = localTintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(localCharSequence3))
      setNavigationContentDescription(localCharSequence3);
    Drawable localDrawable2 = localTintTypedArray.getDrawable(R.styleable.Toolbar_logo);
    if (localDrawable2 != null)
      setLogo(localDrawable2);
    CharSequence localCharSequence4 = localTintTypedArray.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(localCharSequence4))
      setLogoDescription(localCharSequence4);
    if (localTintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor))
      setTitleTextColor(localTintTypedArray.getColor(R.styleable.Toolbar_titleTextColor, -1));
    if (localTintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor))
      setSubtitleTextColor(localTintTypedArray.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
    localTintTypedArray.recycle();
  }

  private void addCustomViewsWithGravity(List<View> paramList, int paramInt)
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(this) == i);
    int j;
    int k;
    int m;
    while (true)
    {
      j = getChildCount();
      k = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
      paramList.clear();
      m = 0;
      if (i == 0)
        break;
      for (int n = j - 1; n >= 0; n--)
      {
        View localView2 = getChildAt(n);
        LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        if ((localLayoutParams2.mViewType == 0) && (shouldLayout(localView2)) && (getChildHorizontalGravity(localLayoutParams2.gravity) == k))
          paramList.add(localView2);
      }
      i = 0;
    }
    while (m < j)
    {
      View localView1 = getChildAt(m);
      LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
      if ((localLayoutParams1.mViewType == 0) && (shouldLayout(localView1)) && (getChildHorizontalGravity(localLayoutParams1.gravity) == k))
        paramList.add(localView1);
      m++;
    }
  }

  private void addSystemView(View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    LayoutParams localLayoutParams1;
    if (localLayoutParams == null)
      localLayoutParams1 = generateDefaultLayoutParams();
    while (true)
    {
      localLayoutParams1.mViewType = 1;
      if ((!paramBoolean) || (this.mExpandedActionView == null))
        break;
      paramView.setLayoutParams(localLayoutParams1);
      this.mHiddenViews.add(paramView);
      return;
      if (!checkLayoutParams(localLayoutParams))
        localLayoutParams1 = generateLayoutParams(localLayoutParams);
      else
        localLayoutParams1 = (LayoutParams)localLayoutParams;
    }
    addView(paramView, localLayoutParams1);
  }

  private void ensureContentInsets()
  {
    if (this.mContentInsets == null)
      this.mContentInsets = new RtlSpacingHelper();
  }

  private void ensureLogoView()
  {
    if (this.mLogoView == null)
      this.mLogoView = new AppCompatImageView(getContext());
  }

  private void ensureMenu()
  {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null)
    {
      h localh = (h)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null)
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
      this.mMenuView.setExpandedActionViewsExclusive(true);
      localh.a(this.mExpandedMenuPresenter, this.mPopupContext);
    }
  }

  private void ensureMenuView()
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = new ActionMenuView(getContext());
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800005 | 0x70 & this.mButtonGravity);
      this.mMenuView.setLayoutParams(localLayoutParams);
      addSystemView(this.mMenuView, false);
    }
  }

  private void ensureNavButtonView()
  {
    if (this.mNavButtonView == null)
    {
      this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | 0x70 & this.mButtonGravity);
      this.mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }

  private int getChildHorizontalGravity(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0x7 & GravityCompat.getAbsoluteGravity(paramInt, i);
    switch (j)
    {
    case 2:
    case 4:
    default:
      if (i == 1)
        j = 5;
      break;
    case 1:
    case 3:
    case 5:
      return j;
    }
    return 3;
  }

  private int getChildTop(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i3;
    if (paramInt > 0)
    {
      j = (i - paramInt) / 2;
      switch (getChildVerticalGravity(localLayoutParams.gravity))
      {
      default:
        k = getPaddingTop();
        m = getPaddingBottom();
        n = getHeight();
        i1 = (n - k - m - i) / 2;
        if (i1 < localLayoutParams.topMargin)
          i3 = localLayoutParams.topMargin;
        break;
      case 48:
      case 80:
      }
    }
    while (true)
    {
      return i3 + k;
      j = 0;
      break;
      return getPaddingTop() - j;
      return getHeight() - getPaddingBottom() - i - localLayoutParams.bottomMargin - j;
      int i2 = n - m - i - i1 - k;
      if (i2 < localLayoutParams.bottomMargin)
        i3 = Math.max(0, i1 - (localLayoutParams.bottomMargin - i2));
      else
        i3 = i1;
    }
  }

  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    switch (i)
    {
    default:
      i = 0x70 & this.mGravity;
    case 16:
    case 48:
    case 80:
    }
    return i;
  }

  private int getHorizontalMargins(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(localMarginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(localMarginLayoutParams);
  }

  private MenuInflater getMenuInflater()
  {
    return new g(getContext());
  }

  private int getVerticalMargins(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
  }

  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramList.size();
    int m = 0;
    int n = 0;
    int i1 = j;
    int i2 = i;
    while (m < k)
    {
      View localView = (View)paramList.get(m);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i3 = localLayoutParams.leftMargin - i2;
      int i4 = localLayoutParams.rightMargin - i1;
      int i5 = Math.max(0, i3);
      int i6 = Math.max(0, i4);
      i2 = Math.max(0, -i3);
      i1 = Math.max(0, -i4);
      int i7 = n + (i6 + (i5 + localView.getMeasuredWidth()));
      m++;
      n = i7;
    }
    return n;
  }

  private boolean isChildOrHidden(View paramView)
  {
    return (paramView.getParent() == this) || (this.mHiddenViews.contains(paramView));
  }

  private static boolean isCustomView(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).mViewType == 0;
  }

  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = paramInt1 + Math.max(0, i);
    paramArrayOfInt[0] = Math.max(0, -i);
    int k = getChildTop(paramView, paramInt2);
    int m = paramView.getMeasuredWidth();
    paramView.layout(j, k, j + m, k + paramView.getMeasuredHeight());
    return j + (m + localLayoutParams.rightMargin);
  }

  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    int j = paramInt1 - Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    int k = getChildTop(paramView, paramInt2);
    int m = paramView.getMeasuredWidth();
    paramView.layout(j - m, k, j, k + paramView.getMeasuredHeight());
    return j - (m + localLayoutParams.leftMargin);
  }

  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + (k + (getPaddingLeft() + getPaddingRight())), localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height));
    return k + paramView.getMeasuredWidth();
  }

  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, paramInt2 + (getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin), localMarginLayoutParams.width);
    int j = getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height);
    int k = View.MeasureSpec.getMode(j);
    if ((k != 1073741824) && (paramInt5 >= 0))
    {
      if (k != 0)
        paramInt5 = Math.min(View.MeasureSpec.getSize(j), paramInt5);
      j = View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824);
    }
    paramView.measure(i, j);
  }

  private void postShowOverflowMenu()
  {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }

  private boolean shouldCollapse()
  {
    if (!this.mCollapsible)
      return false;
    int i = getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label55;
      View localView = getChildAt(j);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0))
        break;
    }
    label55: return true;
  }

  private boolean shouldLayout(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }

  void addChildrenForExpandedActionView()
  {
    for (int i = -1 + this.mHiddenViews.size(); i >= 0; i--)
      addView((View)this.mHiddenViews.get(i));
    this.mHiddenViews.clear();
  }

  public boolean canShowOverflowMenu()
  {
    return (getVisibility() == 0) && (this.mMenuView != null) && (this.mMenuView.isOverflowReserved());
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }

  public void collapseActionView()
  {
    if (this.mExpandedMenuPresenter == null);
    for (j localj = null; ; localj = this.mExpandedMenuPresenter.mCurrentExpandedItem)
    {
      if (localj != null)
        localj.collapseActionView();
      return;
    }
  }

  public void dismissPopupMenus()
  {
    if (this.mMenuView != null)
      this.mMenuView.dismissPopupMenus();
  }

  void ensureCollapseButtonView()
  {
    if (this.mCollapseButtonView == null)
    {
      this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | 0x70 & this.mButtonGravity);
      localLayoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams(localLayoutParams);
      this.mCollapseButtonView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
      return new LayoutParams((LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof a.a))
      return new LayoutParams((a.a)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  public int getContentInsetEnd()
  {
    if (this.mContentInsets != null)
      return this.mContentInsets.getEnd();
    return 0;
  }

  public int getContentInsetEndWithActions()
  {
    if (this.mContentInsetEndWithActions != -2147483648)
      return this.mContentInsetEndWithActions;
    return getContentInsetEnd();
  }

  public int getContentInsetLeft()
  {
    if (this.mContentInsets != null)
      return this.mContentInsets.getLeft();
    return 0;
  }

  public int getContentInsetRight()
  {
    if (this.mContentInsets != null)
      return this.mContentInsets.getRight();
    return 0;
  }

  public int getContentInsetStart()
  {
    if (this.mContentInsets != null)
      return this.mContentInsets.getStart();
    return 0;
  }

  public int getContentInsetStartWithNavigation()
  {
    if (this.mContentInsetStartWithNavigation != -2147483648)
      return this.mContentInsetStartWithNavigation;
    return getContentInsetStart();
  }

  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.mMenuView != null)
    {
      h localh = this.mMenuView.peekMenu();
      if ((localh != null) && (localh.hasVisibleItems()))
        i = 1;
    }
    while (true)
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        i = 0;
      }
      else
      {
        return getContentInsetEnd();
        i = 0;
      }
  }

  public int getCurrentContentInsetLeft()
  {
    if (ViewCompat.getLayoutDirection(this) == 1)
      return getCurrentContentInsetEnd();
    return getCurrentContentInsetStart();
  }

  public int getCurrentContentInsetRight()
  {
    if (ViewCompat.getLayoutDirection(this) == 1)
      return getCurrentContentInsetStart();
    return getCurrentContentInsetEnd();
  }

  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null)
      return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    return getContentInsetStart();
  }

  public Drawable getLogo()
  {
    if (this.mLogoView != null)
      return this.mLogoView.getDrawable();
    return null;
  }

  public CharSequence getLogoDescription()
  {
    if (this.mLogoView != null)
      return this.mLogoView.getContentDescription();
    return null;
  }

  public Menu getMenu()
  {
    ensureMenu();
    return this.mMenuView.getMenu();
  }

  public CharSequence getNavigationContentDescription()
  {
    if (this.mNavButtonView != null)
      return this.mNavButtonView.getContentDescription();
    return null;
  }

  public Drawable getNavigationIcon()
  {
    if (this.mNavButtonView != null)
      return this.mNavButtonView.getDrawable();
    return null;
  }

  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.mOuterActionMenuPresenter;
  }

  public Drawable getOverflowIcon()
  {
    ensureMenu();
    return this.mMenuView.getOverflowIcon();
  }

  Context getPopupContext()
  {
    return this.mPopupContext;
  }

  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }

  public CharSequence getSubtitle()
  {
    return this.mSubtitleText;
  }

  public CharSequence getTitle()
  {
    return this.mTitleText;
  }

  public int getTitleMarginBottom()
  {
    return this.mTitleMarginBottom;
  }

  public int getTitleMarginEnd()
  {
    return this.mTitleMarginEnd;
  }

  public int getTitleMarginStart()
  {
    return this.mTitleMarginStart;
  }

  public int getTitleMarginTop()
  {
    return this.mTitleMarginTop;
  }

  public DecorToolbar getWrapper()
  {
    if (this.mWrapper == null)
      this.mWrapper = new ToolbarWidgetWrapper(this, true);
    return this.mWrapper;
  }

  public boolean hasExpandedActionView()
  {
    return (this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null);
  }

  public boolean hideOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.hideOverflowMenu());
  }

  public void inflateMenu(int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }

  public boolean isOverflowMenuShowPending()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowPending());
  }

  public boolean isOverflowMenuShowing()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowing());
  }

  public boolean isTitleTruncated()
  {
    if (this.mTitleTextView == null);
    while (true)
    {
      return false;
      Layout localLayout = this.mTitleTextView.getLayout();
      if (localLayout != null)
      {
        int i = localLayout.getLineCount();
        for (int j = 0; j < i; j++)
          if (localLayout.getEllipsisCount(j) > 0)
            return true;
      }
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }

  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9)
      this.mEatingHover = false;
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool))
        this.mEatingHover = true;
    }
    if ((i == 10) || (i == 3))
      this.mEatingHover = false;
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int[] arrayOfInt;
    int i5;
    label92: int i6;
    int i7;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i = 1;
      j = getWidth();
      k = getHeight();
      m = getPaddingLeft();
      n = getPaddingRight();
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      i3 = j - n;
      arrayOfInt = this.mTempMargins;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      int i4 = ViewCompat.getMinimumHeight(this);
      if (i4 < 0)
        break label901;
      i5 = Math.min(i4, paramInt4 - paramInt2);
      if (!shouldLayout(this.mNavButtonView))
        break label1642;
      if (i == 0)
        break label907;
      i6 = layoutChildRight(this.mNavButtonView, i3, arrayOfInt, i5);
      i7 = m;
    }
    while (true)
    {
      label128: label160: label192: int i10;
      int i11;
      label292: int i12;
      int i13;
      if (shouldLayout(this.mCollapseButtonView))
      {
        if (i != 0)
          i6 = layoutChildRight(this.mCollapseButtonView, i6, arrayOfInt, i5);
      }
      else
      {
        if (shouldLayout(this.mMenuView))
        {
          if (i == 0)
            break label949;
          i7 = layoutChildLeft(this.mMenuView, i7, arrayOfInt, i5);
        }
        int i8 = getCurrentContentInsetLeft();
        int i9 = getCurrentContentInsetRight();
        arrayOfInt[0] = Math.max(0, i8 - i7);
        arrayOfInt[1] = Math.max(0, i9 - (j - n - i6));
        i10 = Math.max(i7, i8);
        i11 = Math.min(i6, j - n - i9);
        if (shouldLayout(this.mExpandedActionView))
        {
          if (i == 0)
            break label968;
          i11 = layoutChildRight(this.mExpandedActionView, i11, arrayOfInt, i5);
        }
        if (!shouldLayout(this.mLogoView))
          break label1631;
        if (i == 0)
          break label987;
        i12 = layoutChildRight(this.mLogoView, i11, arrayOfInt, i5);
        i13 = i10;
      }
      while (true)
      {
        label328: boolean bool1 = shouldLayout(this.mTitleTextView);
        boolean bool2 = shouldLayout(this.mSubtitleTextView);
        int i14 = 0;
        if (bool1)
        {
          LayoutParams localLayoutParams8 = (LayoutParams)this.mTitleTextView.getLayoutParams();
          i14 = 0 + (localLayoutParams8.topMargin + this.mTitleTextView.getMeasuredHeight() + localLayoutParams8.bottomMargin);
        }
        LayoutParams localLayoutParams7;
        if (bool2)
          localLayoutParams7 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
        for (int i15 = i14 + (localLayoutParams7.topMargin + this.mSubtitleTextView.getMeasuredHeight() + localLayoutParams7.bottomMargin); ; i15 = i14)
        {
          TextView localTextView1;
          label453: TextView localTextView2;
          label464: LayoutParams localLayoutParams1;
          LayoutParams localLayoutParams2;
          int i16;
          label517: int i55;
          int i57;
          if ((bool1) || (bool2))
          {
            if (!bool1)
              break label1014;
            localTextView1 = this.mTitleTextView;
            if (!bool2)
              break label1023;
            localTextView2 = this.mSubtitleTextView;
            localLayoutParams1 = (LayoutParams)localTextView1.getLayoutParams();
            localLayoutParams2 = (LayoutParams)localTextView2.getLayoutParams();
            if (((!bool1) || (this.mTitleTextView.getMeasuredWidth() <= 0)) && ((!bool2) || (this.mSubtitleTextView.getMeasuredWidth() <= 0)))
              break label1032;
            i16 = 1;
            switch (0x70 & this.mGravity)
            {
            default:
              i55 = (k - i1 - i2 - i15) / 2;
              if (i55 < localLayoutParams1.topMargin + this.mTitleMarginTop)
                i57 = localLayoutParams1.topMargin + this.mTitleMarginTop;
              break;
            case 48:
            case 80:
            }
          }
          label1155: 
          while (true)
          {
            label594: int i17 = i1 + i57;
            label601: int i42;
            label617: int i44;
            int i54;
            if (i != 0)
              if (i16 != 0)
              {
                i42 = this.mTitleMarginStart;
                int i43 = i42 - arrayOfInt[1];
                i44 = i12 - Math.max(0, i43);
                arrayOfInt[1] = Math.max(0, -i43);
                if (!bool1)
                  break label1610;
                LayoutParams localLayoutParams6 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                int i52 = i44 - this.mTitleTextView.getMeasuredWidth();
                int i53 = i17 + this.mTitleTextView.getMeasuredHeight();
                this.mTitleTextView.layout(i52, i17, i44, i53);
                i54 = i52 - this.mTitleMarginEnd;
                i17 = i53 + localLayoutParams6.bottomMargin;
              }
            label901: label907: label949: label968: label1610: for (int i45 = i54; ; i45 = i44)
            {
              int i51;
              if (bool2)
              {
                LayoutParams localLayoutParams5 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                int i48 = i17 + localLayoutParams5.topMargin;
                int i49 = i44 - this.mSubtitleTextView.getMeasuredWidth();
                int i50 = i48 + this.mSubtitleTextView.getMeasuredHeight();
                this.mSubtitleTextView.layout(i49, i48, i44, i50);
                i51 = i44 - this.mTitleMarginEnd;
                (i50 + localLayoutParams5.bottomMargin);
              }
              for (int i46 = i51; ; i46 = i44)
              {
                if (i16 != 0);
                for (int i47 = Math.min(i45, i46); ; i47 = i44)
                {
                  i12 = i47;
                  addCustomViewsWithGravity(this.mTempViews, 3);
                  int i23 = this.mTempViews.size();
                  int i24 = 0;
                  int i25 = i13;
                  label987: label1014: label1023: int i18;
                  int i41;
                  int i20;
                  while (true)
                    if (i24 < i23)
                    {
                      i25 = layoutChildLeft((View)this.mTempViews.get(i24), i25, arrayOfInt, i5);
                      i24++;
                      continue;
                      i = 0;
                      break;
                      i5 = 0;
                      break label92;
                      i7 = layoutChildLeft(this.mNavButtonView, m, arrayOfInt, i5);
                      i6 = i3;
                      break label128;
                      i7 = layoutChildLeft(this.mCollapseButtonView, i7, arrayOfInt, i5);
                      break label160;
                      i6 = layoutChildRight(this.mMenuView, i6, arrayOfInt, i5);
                      break label192;
                      i10 = layoutChildLeft(this.mExpandedActionView, i10, arrayOfInt, i5);
                      break label292;
                      int i58 = layoutChildLeft(this.mLogoView, i10, arrayOfInt, i5);
                      i12 = i11;
                      i13 = i58;
                      break label328;
                      localTextView1 = this.mSubtitleTextView;
                      break label453;
                      localTextView2 = this.mTitleTextView;
                      break label464;
                      i16 = 0;
                      break label517;
                      i17 = getPaddingTop() + localLayoutParams1.topMargin + this.mTitleMarginTop;
                      break label601;
                      int i56 = k - i2 - i15 - i55 - i1;
                      if (i56 >= localLayoutParams1.bottomMargin + this.mTitleMarginBottom)
                        break label1617;
                      i57 = Math.max(0, i55 - (localLayoutParams2.bottomMargin + this.mTitleMarginBottom - i56));
                      break label594;
                      i17 = k - i2 - localLayoutParams2.bottomMargin - this.mTitleMarginBottom - i15;
                      break label601;
                      i42 = 0;
                      break label617;
                      if (i16 != 0)
                      {
                        i18 = this.mTitleMarginStart;
                        int i19 = i18 - arrayOfInt[0];
                        i13 += Math.max(0, i19);
                        arrayOfInt[0] = Math.max(0, -i19);
                        if (!bool1)
                          break label1585;
                        LayoutParams localLayoutParams4 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                        int i38 = i13 + this.mTitleTextView.getMeasuredWidth();
                        int i39 = i17 + this.mTitleTextView.getMeasuredHeight();
                        this.mTitleTextView.layout(i13, i17, i38, i39);
                        int i40 = i38 + this.mTitleMarginEnd;
                        i41 = i39 + localLayoutParams4.bottomMargin;
                        i20 = i40;
                      }
                    }
                  for (int i21 = i41; ; i21 = i17)
                  {
                    int i37;
                    if (bool2)
                    {
                      LayoutParams localLayoutParams3 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                      int i34 = i21 + localLayoutParams3.topMargin;
                      int i35 = i13 + this.mSubtitleTextView.getMeasuredWidth();
                      int i36 = i34 + this.mSubtitleTextView.getMeasuredHeight();
                      this.mSubtitleTextView.layout(i13, i34, i35, i36);
                      i37 = i35 + this.mTitleMarginEnd;
                      (i36 + localLayoutParams3.bottomMargin);
                    }
                    for (int i22 = i37; ; i22 = i13)
                    {
                      if (i16 == 0)
                        break label1583;
                      i13 = Math.max(i20, i22);
                      break;
                      i18 = 0;
                      break label1155;
                      addCustomViewsWithGravity(this.mTempViews, 5);
                      int i26 = this.mTempViews.size();
                      for (int i27 = 0; i27 < i26; i27++)
                        i12 = layoutChildRight((View)this.mTempViews.get(i27), i12, arrayOfInt, i5);
                      addCustomViewsWithGravity(this.mTempViews, 1);
                      int i28 = getViewListMeasuredWidth(this.mTempViews, arrayOfInt);
                      int i29 = m + (j - m - n) / 2 - i28 / 2;
                      int i30 = i28 + i29;
                      if (i29 < i25)
                        i29 = i25;
                      while (true)
                      {
                        int i31 = this.mTempViews.size();
                        int i32 = 0;
                        int i33 = i29;
                        while (i32 < i31)
                        {
                          i33 = layoutChildLeft((View)this.mTempViews.get(i32), i33, arrayOfInt, i5);
                          i32++;
                        }
                        if (i30 > i12)
                          i29 -= i30 - i12;
                      }
                      this.mTempViews.clear();
                      return;
                    }
                    break;
                    i20 = i13;
                  }
                }
              }
            }
            label1032: label1583: label1585: label1617: i57 = i55;
          }
        }
        label1631: i12 = i11;
        i13 = i10;
      }
      label1642: i6 = i3;
      i7 = m;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mTempMargins;
    int i;
    int j;
    int i5;
    int i7;
    int i8;
    int i9;
    label499: View localView;
    int i20;
    int i21;
    if (ViewUtils.isLayoutRtl(this))
    {
      i = 0;
      j = 1;
      boolean bool1 = shouldLayout(this.mNavButtonView);
      int k = 0;
      int m = 0;
      int n = 0;
      if (bool1)
      {
        measureChildConstrained(this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        k = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int i23 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        m = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        n = i23;
      }
      if (shouldLayout(this.mCollapseButtonView))
      {
        measureChildConstrained(this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        k = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        n = Math.max(n, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        m = View.combineMeasuredStates(m, this.mCollapseButtonView.getMeasuredState());
      }
      int i1 = getCurrentContentInsetStart();
      int i2 = 0 + Math.max(i1, k);
      arrayOfInt[j] = Math.max(0, i1 - k);
      boolean bool2 = shouldLayout(this.mMenuView);
      int i3 = 0;
      if (bool2)
      {
        measureChildConstrained(this.mMenuView, paramInt1, i2, paramInt2, 0, this.mMaxButtonHeight);
        i3 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        n = Math.max(n, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        m = View.combineMeasuredStates(m, this.mMenuView.getMeasuredState());
      }
      int i4 = getCurrentContentInsetEnd();
      i5 = i2 + Math.max(i4, i3);
      arrayOfInt[i] = Math.max(0, i4 - i3);
      if (shouldLayout(this.mExpandedActionView))
      {
        i5 += measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i5, paramInt2, 0, arrayOfInt);
        n = Math.max(n, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        m = View.combineMeasuredStates(m, this.mExpandedActionView.getMeasuredState());
      }
      if (shouldLayout(this.mLogoView))
      {
        i5 += measureChildCollapseMargins(this.mLogoView, paramInt1, i5, paramInt2, 0, arrayOfInt);
        n = Math.max(n, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        m = View.combineMeasuredStates(m, this.mLogoView.getMeasuredState());
      }
      int i6 = getChildCount();
      i7 = 0;
      i8 = n;
      i9 = m;
      if (i7 >= i6)
        break label623;
      localView = getChildAt(i7);
      if (((LayoutParams)localView.getLayoutParams()).mViewType != 0)
        break label913;
      if (shouldLayout(localView))
        break label568;
      i20 = i9;
      i21 = i8;
    }
    while (true)
    {
      i7++;
      i9 = i20;
      i8 = i21;
      break label499;
      i = 1;
      j = 0;
      break;
      label568: i5 += measureChildCollapseMargins(localView, paramInt1, i5, paramInt2, 0, arrayOfInt);
      int i22 = Math.max(i8, localView.getMeasuredHeight() + getVerticalMargins(localView));
      i20 = View.combineMeasuredStates(i9, localView.getMeasuredState());
      i21 = i22;
      continue;
      label623: int i10 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int i11 = this.mTitleMarginStart + this.mTitleMarginEnd;
      boolean bool3 = shouldLayout(this.mTitleTextView);
      int i12 = 0;
      int i13 = 0;
      if (bool3)
      {
        measureChildCollapseMargins(this.mTitleTextView, paramInt1, i5 + i11, paramInt2, i10, arrayOfInt);
        i13 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        i12 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        i9 = View.combineMeasuredStates(i9, this.mTitleTextView.getMeasuredState());
      }
      if (shouldLayout(this.mSubtitleTextView))
      {
        i13 = Math.max(i13, measureChildCollapseMargins(this.mSubtitleTextView, paramInt1, i5 + i11, paramInt2, i10 + i12, arrayOfInt));
        i12 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
        i9 = View.combineMeasuredStates(i9, this.mSubtitleTextView.getMeasuredState());
      }
      int i14 = i13 + i5;
      int i15 = Math.max(i8, i12);
      int i16 = i14 + (getPaddingLeft() + getPaddingRight());
      int i17 = i15 + (getPaddingTop() + getPaddingBottom());
      int i18 = View.resolveSizeAndState(Math.max(i16, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i9);
      int i19 = View.resolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), paramInt2, i9 << 16);
      if (shouldCollapse())
        i19 = 0;
      setMeasuredDimension(i18, i19);
      return;
      label913: i20 = i9;
      i21 = i8;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.mMenuView != null);
    for (h localh = this.mMenuView.peekMenu(); ; localh = null)
    {
      if ((localSavedState.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (localh != null))
      {
        MenuItem localMenuItem = localh.findItem(localSavedState.expandedMenuItemId);
        if (localMenuItem != null)
          localMenuItem.expandActionView();
      }
      if (!localSavedState.isOverflowOpen)
        break;
      postShowOverflowMenu();
      return;
    }
  }

  public void onRtlPropertiesChanged(int paramInt)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt);
    ensureContentInsets();
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (paramInt == i);
    while (true)
    {
      localRtlSpacingHelper.setDirection(i);
      return;
      i = 0;
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null))
      localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.mEatingTouch = false;
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool))
        this.mEatingTouch = true;
    }
    if ((i == 1) || (i == 3))
      this.mEatingTouch = false;
    return true;
  }

  void removeChildrenForExpandedActionView()
  {
    for (int i = -1 + getChildCount(); i >= 0; i--)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).mViewType != 2) && (localView != this.mMenuView))
      {
        removeViewAt(i);
        this.mHiddenViews.add(localView);
      }
    }
  }

  public void setCollapsible(boolean paramBoolean)
  {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }

  public void setContentInsetEndWithActions(int paramInt)
  {
    if (paramInt < 0)
      paramInt = -2147483648;
    if (paramInt != this.mContentInsetEndWithActions)
    {
      this.mContentInsetEndWithActions = paramInt;
      if (getNavigationIcon() != null)
        requestLayout();
    }
  }

  public void setContentInsetStartWithNavigation(int paramInt)
  {
    if (paramInt < 0)
      paramInt = -2147483648;
    if (paramInt != this.mContentInsetStartWithNavigation)
    {
      this.mContentInsetStartWithNavigation = paramInt;
      if (getNavigationIcon() != null)
        requestLayout();
    }
  }

  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setAbsolute(paramInt1, paramInt2);
  }

  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setRelative(paramInt1, paramInt2);
  }

  public void setLogo(int paramInt)
  {
    setLogo(a.b(getContext(), paramInt));
  }

  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (!isChildOrHidden(this.mLogoView))
        addSystemView(this.mLogoView, true);
    }
    while (true)
    {
      if (this.mLogoView != null)
        this.mLogoView.setImageDrawable(paramDrawable);
      return;
      if ((this.mLogoView != null) && (isChildOrHidden(this.mLogoView)))
      {
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
      }
    }
  }

  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }

  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureLogoView();
    if (this.mLogoView != null)
      this.mLogoView.setContentDescription(paramCharSequence);
  }

  public void setMenu(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.mMenuView == null));
    h localh;
    do
    {
      return;
      ensureMenuView();
      localh = this.mMenuView.peekMenu();
    }
    while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.mOuterActionMenuPresenter);
      localh.b(this.mExpandedMenuPresenter);
    }
    if (this.mExpandedMenuPresenter == null)
      this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.mPopupContext);
      paramh.a(this.mExpandedMenuPresenter, this.mPopupContext);
    }
    while (true)
    {
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setPresenter(paramActionMenuPresenter);
      this.mOuterActionMenuPresenter = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.initForMenu(this.mPopupContext, null);
      this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
    }
  }

  public void setMenuCallbacks(o.a parama, h.a parama1)
  {
    this.mActionMenuPresenterCallback = parama;
    this.mMenuBuilderCallback = parama1;
    if (this.mMenuView != null)
      this.mMenuView.setMenuCallbacks(parama, parama1);
  }

  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0);
    for (CharSequence localCharSequence = getContext().getText(paramInt); ; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }

  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureNavButtonView();
    if (this.mNavButtonView != null)
      this.mNavButtonView.setContentDescription(paramCharSequence);
  }

  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(a.b(getContext(), paramInt));
  }

  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (!isChildOrHidden(this.mNavButtonView))
        addSystemView(this.mNavButtonView, true);
    }
    while (true)
    {
      if (this.mNavButtonView != null)
        this.mNavButtonView.setImageDrawable(paramDrawable);
      return;
      if ((this.mNavButtonView != null) && (isChildOrHidden(this.mNavButtonView)))
      {
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
      }
    }
  }

  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }

  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }

  public void setOverflowIcon(Drawable paramDrawable)
  {
    ensureMenu();
    this.mMenuView.setOverflowIcon(paramDrawable);
  }

  public void setPopupTheme(int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
        this.mPopupContext = getContext();
    }
    else
    {
      return;
    }
    this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
  }

  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mSubtitleTextView == null)
      {
        Context localContext = getContext();
        this.mSubtitleTextView = new AppCompatTextView(localContext);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mSubtitleTextAppearance != 0)
          this.mSubtitleTextView.setTextAppearance(localContext, this.mSubtitleTextAppearance);
        if (this.mSubtitleTextColor != 0)
          this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
      }
      if (!isChildOrHidden(this.mSubtitleTextView))
        addSystemView(this.mSubtitleTextView, true);
    }
    while (true)
    {
      if (this.mSubtitleTextView != null)
        this.mSubtitleTextView.setText(paramCharSequence);
      this.mSubtitleText = paramCharSequence;
      return;
      if ((this.mSubtitleTextView != null) && (isChildOrHidden(this.mSubtitleTextView)))
      {
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
      }
    }
  }

  public void setSubtitleTextAppearance(Context paramContext, int paramInt)
  {
    this.mSubtitleTextAppearance = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextAppearance(paramContext, paramInt);
  }

  public void setSubtitleTextColor(int paramInt)
  {
    this.mSubtitleTextColor = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextColor(paramInt);
  }

  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mTitleTextView == null)
      {
        Context localContext = getContext();
        this.mTitleTextView = new AppCompatTextView(localContext);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mTitleTextAppearance != 0)
          this.mTitleTextView.setTextAppearance(localContext, this.mTitleTextAppearance);
        if (this.mTitleTextColor != 0)
          this.mTitleTextView.setTextColor(this.mTitleTextColor);
      }
      if (!isChildOrHidden(this.mTitleTextView))
        addSystemView(this.mTitleTextView, true);
    }
    while (true)
    {
      if (this.mTitleTextView != null)
        this.mTitleTextView.setText(paramCharSequence);
      this.mTitleText = paramCharSequence;
      return;
      if ((this.mTitleTextView != null) && (isChildOrHidden(this.mTitleTextView)))
      {
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
      }
    }
  }

  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTitleMarginStart = paramInt1;
    this.mTitleMarginTop = paramInt2;
    this.mTitleMarginEnd = paramInt3;
    this.mTitleMarginBottom = paramInt4;
    requestLayout();
  }

  public void setTitleMarginBottom(int paramInt)
  {
    this.mTitleMarginBottom = paramInt;
    requestLayout();
  }

  public void setTitleMarginEnd(int paramInt)
  {
    this.mTitleMarginEnd = paramInt;
    requestLayout();
  }

  public void setTitleMarginStart(int paramInt)
  {
    this.mTitleMarginStart = paramInt;
    requestLayout();
  }

  public void setTitleMarginTop(int paramInt)
  {
    this.mTitleMarginTop = paramInt;
    requestLayout();
  }

  public void setTitleTextAppearance(Context paramContext, int paramInt)
  {
    this.mTitleTextAppearance = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextAppearance(paramContext, paramInt);
  }

  public void setTitleTextColor(int paramInt)
  {
    this.mTitleTextColor = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextColor(paramInt);
  }

  public boolean showOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.showOverflowMenu());
  }

  private class ExpandedActionViewMenuPresenter
    implements o
  {
    j mCurrentExpandedItem;
    h mMenu;

    ExpandedActionViewMenuPresenter()
    {
    }

    public boolean collapseItemActionView(h paramh, j paramj)
    {
      if ((Toolbar.this.mExpandedActionView instanceof c))
        ((c)Toolbar.this.mExpandedActionView).onActionViewCollapsed();
      Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
      Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
      Toolbar.this.mExpandedActionView = null;
      Toolbar.this.addChildrenForExpandedActionView();
      this.mCurrentExpandedItem = null;
      Toolbar.this.requestLayout();
      paramj.e(false);
      return true;
    }

    public boolean expandItemActionView(h paramh, j paramj)
    {
      Toolbar.this.ensureCollapseButtonView();
      ViewParent localViewParent1 = Toolbar.this.mCollapseButtonView.getParent();
      if (localViewParent1 != Toolbar.this)
      {
        if ((localViewParent1 instanceof ViewGroup))
          ((ViewGroup)localViewParent1).removeView(Toolbar.this.mCollapseButtonView);
        Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
      }
      Toolbar.this.mExpandedActionView = paramj.getActionView();
      this.mCurrentExpandedItem = paramj;
      ViewParent localViewParent2 = Toolbar.this.mExpandedActionView.getParent();
      if (localViewParent2 != Toolbar.this)
      {
        if ((localViewParent2 instanceof ViewGroup))
          ((ViewGroup)localViewParent2).removeView(Toolbar.this.mExpandedActionView);
        Toolbar.LayoutParams localLayoutParams = Toolbar.this.generateDefaultLayoutParams();
        localLayoutParams.gravity = (0x800003 | 0x70 & Toolbar.this.mButtonGravity);
        localLayoutParams.mViewType = 2;
        Toolbar.this.mExpandedActionView.setLayoutParams(localLayoutParams);
        Toolbar.this.addView(Toolbar.this.mExpandedActionView);
      }
      Toolbar.this.removeChildrenForExpandedActionView();
      Toolbar.this.requestLayout();
      paramj.e(true);
      if ((Toolbar.this.mExpandedActionView instanceof c))
        ((c)Toolbar.this.mExpandedActionView).onActionViewExpanded();
      return true;
    }

    public boolean flagActionItems()
    {
      return false;
    }

    public int getId()
    {
      return 0;
    }

    public p getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }

    public void initForMenu(Context paramContext, h paramh)
    {
      if ((this.mMenu != null) && (this.mCurrentExpandedItem != null))
        this.mMenu.d(this.mCurrentExpandedItem);
      this.mMenu = paramh;
    }

    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
    }

    public void onRestoreInstanceState(Parcelable paramParcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
      return null;
    }

    public boolean onSubMenuSelected(u paramu)
    {
      return false;
    }

    public void setCallback(o.a parama)
    {
    }

    public void updateMenuView(boolean paramBoolean)
    {
      int i;
      int j;
      if (this.mCurrentExpandedItem != null)
      {
        h localh = this.mMenu;
        i = 0;
        if (localh != null)
          j = this.mMenu.size();
      }
      for (int k = 0; ; k++)
      {
        i = 0;
        if (k < j)
        {
          if (this.mMenu.getItem(k) == this.mCurrentExpandedItem)
            i = 1;
        }
        else
        {
          if (i == 0)
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
          return;
        }
      }
    }
  }

  public static class LayoutParams extends a.a
  {
    static final int CUSTOM = 0;
    static final int EXPANDED = 2;
    static final int SYSTEM = 1;
    int mViewType = 0;

    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public LayoutParams(a.a parama)
    {
      super();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.mViewType = paramLayoutParams.mViewType;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      copyMarginsFromCompat(paramMarginLayoutParams);
    }

    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }

  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }

  public static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, null);
      }

      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public Toolbar.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Toolbar.SavedState[paramAnonymousInt];
      }
    };
    int expandedMenuItemId;
    boolean isOverflowOpen;

    public SavedState(Parcel paramParcel)
    {
      this(paramParcel, null);
    }

    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.expandedMenuItemId = paramParcel.readInt();
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isOverflowOpen = bool;
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
      paramParcel.writeInt(this.expandedMenuItemId);
      if (this.isOverflowOpen);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar
 * JD-Core Version:    0.6.2
 */