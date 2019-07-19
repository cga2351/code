package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView
{
  private static final String TAG = "ActionBarContextView";
  private View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;

  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }

  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    ViewCompat.setBackground(this, localTintTypedArray.getDrawable(R.styleable.ActionMode_background));
    this.mTitleStyleRes = localTintTypedArray.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = localTintTypedArray.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = localTintTypedArray.getLayoutDimension(R.styleable.ActionMode_height, 0);
    this.mCloseItemLayout = localTintTypedArray.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    localTintTypedArray.recycle();
  }

  private void initTitle()
  {
    int i = 8;
    int j = 1;
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(-1 + getChildCount()));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (this.mTitleStyleRes != 0)
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      if (this.mSubtitleStyleRes != 0)
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    int k;
    label166: TextView localTextView;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      k = j;
      if (TextUtils.isEmpty(this.mSubtitle))
        break label232;
      localTextView = this.mSubtitleView;
      if (j == 0)
        break label237;
    }
    label232: label237: for (int m = 0; ; m = i)
    {
      localTextView.setVisibility(m);
      LinearLayout localLinearLayout = this.mTitleLayout;
      if ((k != 0) || (j != 0))
        i = 0;
      localLinearLayout.setVisibility(i);
      if (this.mTitleLayout.getParent() == null)
        addView(this.mTitleLayout);
      return;
      k = 0;
      break;
      j = 0;
      break label166;
    }
  }

  public void closeMode()
  {
    if (this.mClose == null)
      killMode();
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }

  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }

  public CharSequence getTitle()
  {
    return this.mTitle;
  }

  public boolean hideOverflowMenu()
  {
    if (this.mActionMenuPresenter != null)
      return this.mActionMenuPresenter.hideOverflowMenu();
    return false;
  }

  public void initForMode(final b paramb)
  {
    if (this.mClose == null)
    {
      this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      addView(this.mClose);
    }
    while (true)
    {
      this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramb.c();
        }
      });
      h localh = (h)paramb.b();
      if (this.mActionMenuPresenter != null)
        this.mActionMenuPresenter.dismissPopupMenus();
      this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
      this.mActionMenuPresenter.setReserveOverflow(true);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      localh.a(this.mActionMenuPresenter, this.mPopupContext);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      ViewCompat.setBackground(this.mMenuView, null);
      addView(this.mMenuView, localLayoutParams);
      return;
      if (this.mClose.getParent() == null)
        addView(this.mClose);
    }
  }

  public boolean isOverflowMenuShowing()
  {
    if (this.mActionMenuPresenter != null)
      return this.mActionMenuPresenter.isOverflowMenuShowing();
    return false;
  }

  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }

  public void killMode()
  {
    removeAllViews();
    this.mCustomView = null;
    this.mMenuView = null;
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.mTitle);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int i;
    int j;
    int k;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i1;
    label87: int i2;
    label99: int i3;
    if (bool1)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      if ((this.mClose == null) || (this.mClose.getVisibility() == 8))
        break label312;
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      if (!bool1)
        break label272;
      i1 = localMarginLayoutParams.rightMargin;
      if (!bool1)
        break label282;
      i2 = localMarginLayoutParams.leftMargin;
      i3 = next(i, i1, bool1);
    }
    label272: label282: label306: label312: for (int m = next(i3 + positionChild(this.mClose, i3, j, k, bool1), i2, bool1); ; m = i)
    {
      if ((this.mTitleLayout != null) && (this.mCustomView == null) && (this.mTitleLayout.getVisibility() != 8))
        m += positionChild(this.mTitleLayout, m, j, k, bool1);
      if (this.mCustomView != null)
        (m + positionChild(this.mCustomView, m, j, k, bool1));
      int n;
      label223: ActionMenuView localActionMenuView;
      if (bool1)
      {
        n = getPaddingLeft();
        if (this.mMenuView != null)
        {
          localActionMenuView = this.mMenuView;
          if (bool1)
            break label306;
        }
      }
      for (boolean bool2 = true; ; bool2 = false)
      {
        (n + positionChild(localActionMenuView, n, j, k, bool2));
        return;
        i = getPaddingLeft();
        break;
        i1 = localMarginLayoutParams.leftMargin;
        break label87;
        i2 = localMarginLayoutParams.rightMargin;
        break label99;
        n = paramInt3 - paramInt1 - getPaddingRight();
        break label223;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1073741824;
    int j = 0;
    if (View.MeasureSpec.getMode(paramInt1) != i)
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
    if (View.MeasureSpec.getMode(paramInt2) == 0)
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    int k = View.MeasureSpec.getSize(paramInt1);
    int m;
    int i1;
    int i2;
    int i3;
    int i11;
    label304: int i12;
    label330: label337: int i7;
    label366: int i8;
    label396: label416: int i5;
    label452: int i6;
    if (this.mContentHeight > 0)
    {
      m = this.mContentHeight;
      int n = getPaddingTop() + getPaddingBottom();
      i1 = k - getPaddingLeft() - getPaddingRight();
      i2 = m - n;
      i3 = View.MeasureSpec.makeMeasureSpec(i2, -2147483648);
      if (this.mClose != null)
      {
        int i13 = measureChildView(this.mClose, i1, i3, 0);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        i1 = i13 - (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
      }
      if ((this.mMenuView != null) && (this.mMenuView.getParent() == this))
        i1 = measureChildView(this.mMenuView, i1, i3, 0);
      if ((this.mTitleLayout != null) && (this.mCustomView == null))
      {
        if (!this.mTitleOptional)
          break label512;
        int i9 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mTitleLayout.measure(i9, i3);
        int i10 = this.mTitleLayout.getMeasuredWidth();
        if (i10 > i1)
          break label499;
        i11 = 1;
        if (i11 != 0)
          i1 -= i10;
        LinearLayout localLinearLayout = this.mTitleLayout;
        if (i11 == 0)
          break label505;
        i12 = 0;
        localLinearLayout.setVisibility(i12);
      }
      if (this.mCustomView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = this.mCustomView.getLayoutParams();
        if (localLayoutParams.width == -2)
          break label530;
        i7 = i;
        if (localLayoutParams.width >= 0)
          i1 = Math.min(localLayoutParams.width, i1);
        if (localLayoutParams.height == -2)
          break label538;
        if (localLayoutParams.height < 0)
          break label545;
        i8 = Math.min(localLayoutParams.height, i2);
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(i1, i7), View.MeasureSpec.makeMeasureSpec(i8, i));
      }
      if (this.mContentHeight > 0)
        break label561;
      int i4 = getChildCount();
      i5 = 0;
      if (j >= i4)
        break label552;
      i6 = n + getChildAt(j).getMeasuredHeight();
      if (i6 <= i5)
        break label570;
    }
    while (true)
    {
      j++;
      i5 = i6;
      break label452;
      m = View.MeasureSpec.getSize(paramInt2);
      break;
      label499: i11 = 0;
      break label304;
      label505: i12 = 8;
      break label330;
      label512: i1 = measureChildView(this.mTitleLayout, i1, i3, 0);
      break label337;
      label530: i7 = -2147483648;
      break label366;
      label538: i = -2147483648;
      break label396;
      label545: i8 = i2;
      break label416;
      label552: setMeasuredDimension(k, i5);
      return;
      label561: setMeasuredDimension(k, m);
      return;
      label570: i6 = i5;
    }
  }

  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }

  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null)
      removeView(this.mCustomView);
    this.mCustomView = paramView;
    if ((paramView != null) && (this.mTitleLayout != null))
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null)
      addView(paramView);
    requestLayout();
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }

  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional)
      requestLayout();
    this.mTitleOptional = paramBoolean;
  }

  public boolean shouldDelayChildPressedState()
  {
    return false;
  }

  public boolean showOverflowMenu()
  {
    if (this.mActionMenuPresenter != null)
      return this.mActionMenuPresenter.showOverflowMenu();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.6.2
 */