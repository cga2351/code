package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.p.a;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends b
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  OverflowMenuButton mOverflowButton;
  OverflowPopup mOverflowPopup;
  private Drawable mPendingOverflowIcon;
  private boolean mPendingOverflowIconSet;
  private ActionMenuPopupCallback mPopupCallback;
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
  OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;

  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }

  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    View localView;
    if (localViewGroup == null)
    {
      localView = null;
      return localView;
    }
    int i = localViewGroup.getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label68;
      localView = localViewGroup.getChildAt(j);
      if (((localView instanceof p.a)) && (((p.a)localView).getItemData() == paramMenuItem))
        break;
    }
    label68: return null;
  }

  public void bindItemView(j paramj, p.a parama)
  {
    parama.a(paramj, 0);
    ActionMenuView localActionMenuView = (ActionMenuView)this.mMenuView;
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)parama;
    localActionMenuItemView.setItemInvoker(localActionMenuView);
    if (this.mPopupCallback == null)
      this.mPopupCallback = new ActionMenuPopupCallback();
    localActionMenuItemView.setPopupCallback(this.mPopupCallback);
  }

  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }

  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton)
      return false;
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }

  public boolean flagActionItems()
  {
    int i;
    ArrayList localArrayList1;
    int j;
    int k;
    int m;
    ViewGroup localViewGroup;
    int n;
    int i1;
    int i2;
    int i3;
    label64: j localj3;
    if (this.mMenu != null)
    {
      ArrayList localArrayList2 = this.mMenu.j();
      i = localArrayList2.size();
      localArrayList1 = localArrayList2;
      j = this.mMaxItems;
      k = this.mActionItemWidthLimit;
      m = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.mMenuView;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      if (i3 >= i)
        break label146;
      localj3 = (j)localArrayList1.get(i3);
      if (!localj3.k())
        break label126;
      n++;
      label92: if ((!this.mExpandedActionViewsExclusive) || (!localj3.isActionViewExpanded()))
        break label849;
    }
    label146: label310: label447: label833: label849: for (int i31 = 0; ; i31 = j)
    {
      i3++;
      j = i31;
      break label64;
      i = 0;
      localArrayList1 = null;
      break;
      label126: if (localj3.j())
      {
        i1++;
        break label92;
      }
      i2 = 1;
      break label92;
      if ((this.mReserveOverflow) && ((i2 != 0) || (n + i1 > j)))
        j--;
      int i4 = j - n;
      SparseBooleanArray localSparseBooleanArray = this.mActionButtonGroups;
      localSparseBooleanArray.clear();
      int i5;
      int i30;
      if (this.mStrictWidthLimit)
      {
        i5 = k / this.mMinCellSize;
        i30 = k % this.mMinCellSize;
      }
      for (int i6 = this.mMinCellSize + i30 / i5; ; i6 = 0)
      {
        int i7 = 0;
        int i8 = 0;
        int i9 = i5;
        j localj1;
        View localView2;
        int i10;
        int i28;
        if (i7 < i)
        {
          localj1 = (j)localArrayList1.get(i7);
          if (localj1.k())
          {
            localView2 = getItemView(localj1, this.mScrapActionButtonView, localViewGroup);
            if (this.mScrapActionButtonView == null)
              this.mScrapActionButtonView = localView2;
            if (this.mStrictWidthLimit)
            {
              i9 -= ActionMenuView.measureChildForCells(localView2, i6, i9, m, 0);
              i10 = localView2.getMeasuredWidth();
              i28 = k - i10;
              if (i8 != 0)
                break label833;
            }
          }
        }
        while (true)
        {
          int i29 = localj1.getGroupId();
          if (i29 != 0)
            localSparseBooleanArray.put(i29, true);
          localj1.d(true);
          int i11 = i28;
          int i12 = i4;
          i7++;
          k = i11;
          i4 = i12;
          i8 = i10;
          break;
          localView2.measure(m, m);
          break label310;
          int i13;
          boolean bool1;
          boolean bool2;
          View localView1;
          int i22;
          int i21;
          int i25;
          boolean bool3;
          int i14;
          int i15;
          if (localj1.j())
          {
            i13 = localj1.getGroupId();
            bool1 = localSparseBooleanArray.get(i13);
            if (((i4 > 0) || (bool1)) && (k > 0) && ((!this.mStrictWidthLimit) || (i9 > 0)))
            {
              bool2 = true;
              if (!bool2)
                break label818;
              localView1 = getItemView(localj1, this.mScrapActionButtonView, localViewGroup);
              if (this.mScrapActionButtonView == null)
                this.mScrapActionButtonView = localView1;
              if (!this.mStrictWidthLimit)
                break label638;
              int i26 = ActionMenuView.measureChildForCells(localView1, i6, i9, m, 0);
              int i27 = i9 - i26;
              if (i26 != 0)
                break label811;
              i22 = 0;
              i21 = i27;
              int i23 = localView1.getMeasuredWidth();
              k -= i23;
              if (i8 == 0)
                i8 = i23;
              if (!this.mStrictWidthLimit)
                break label668;
              if (k < 0)
                break label662;
              i25 = 1;
              bool3 = i22 & i25;
              i14 = i8;
              i15 = i21;
            }
          }
          while (true)
          {
            int i16;
            if ((bool3) && (i13 != 0))
            {
              localSparseBooleanArray.put(i13, true);
              i16 = i4;
            }
            while (true)
            {
              if (bool3)
                i16--;
              localj1.d(bool3);
              i10 = i14;
              i11 = k;
              int i17 = i15;
              i12 = i16;
              i9 = i17;
              break;
              bool2 = false;
              break label447;
              label638: localView1.measure(m, m);
              int i20 = bool2;
              i21 = i9;
              i22 = i20;
              break label519;
              i25 = 0;
              break label557;
              if (k + i8 > 0);
              for (int i24 = 1; ; i24 = 0)
              {
                bool3 = i22 & i24;
                i14 = i8;
                i15 = i21;
                break;
              }
              if (bool1)
              {
                localSparseBooleanArray.put(i13, false);
                int i18 = i4;
                int i19 = 0;
                while (true)
                  if (i19 < i7)
                  {
                    j localj2 = (j)localArrayList1.get(i19);
                    if (localj2.getGroupId() == i13)
                    {
                      if (localj2.i())
                        i18++;
                      localj2.d(false);
                    }
                    i19++;
                    continue;
                    localj1.d(false);
                    i10 = i8;
                    i11 = k;
                    i12 = i4;
                    break;
                    return true;
                  }
                i16 = i18;
              }
              else
              {
                i16 = i4;
              }
            }
            i22 = bool2;
            break label515;
            bool3 = bool2;
            i14 = i8;
            i15 = i9;
          }
          i10 = i8;
        }
        i5 = 0;
      }
    }
  }

  public View getItemView(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.m()))
      localView = super.getItemView(paramj, paramView, paramViewGroup);
    if (paramj.isActionViewExpanded());
    for (int i = 8; ; i = 0)
    {
      localView.setVisibility(i);
      ActionMenuView localActionMenuView = (ActionMenuView)paramViewGroup;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (!localActionMenuView.checkLayoutParams(localLayoutParams))
        localView.setLayoutParams(localActionMenuView.generateLayoutParams(localLayoutParams));
      return localView;
    }
  }

  public p getMenuView(ViewGroup paramViewGroup)
  {
    p localp1 = this.mMenuView;
    p localp2 = super.getMenuView(paramViewGroup);
    if (localp1 != localp2)
      ((ActionMenuView)localp2).setPresenter(this);
    return localp2;
  }

  public Drawable getOverflowIcon()
  {
    if (this.mOverflowButton != null)
      return this.mOverflowButton.getDrawable();
    if (this.mPendingOverflowIconSet)
      return this.mPendingOverflowIcon;
    return null;
  }

  public boolean hideOverflowMenu()
  {
    if ((this.mPostedOpenRunnable != null) && (this.mMenuView != null))
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    }
    OverflowPopup localOverflowPopup = this.mOverflowPopup;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.dismiss();
      return true;
    }
    return false;
  }

  public boolean hideSubMenus()
  {
    if (this.mActionButtonPopup != null)
    {
      this.mActionButtonPopup.dismiss();
      return true;
    }
    return false;
  }

  public void initForMenu(Context paramContext, h paramh)
  {
    super.initForMenu(paramContext, paramh);
    Resources localResources = paramContext.getResources();
    a locala = a.a(paramContext);
    if (!this.mReserveOverflowSet)
      this.mReserveOverflow = locala.b();
    if (!this.mWidthLimitSet)
      this.mWidthLimit = locala.c();
    if (!this.mMaxItemsSet)
      this.mMaxItems = locala.a();
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
        if (this.mPendingOverflowIconSet)
        {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    while (true)
    {
      this.mActionItemWidthLimit = i;
      this.mMinCellSize = ((int)(56.0F * localResources.getDisplayMetrics().density));
      this.mScrapActionButtonView = null;
      return;
      this.mOverflowButton = null;
    }
  }

  public boolean isOverflowMenuShowPending()
  {
    return (this.mPostedOpenRunnable != null) || (isOverflowMenuShowing());
  }

  public boolean isOverflowMenuShowing()
  {
    return (this.mOverflowPopup != null) && (this.mOverflowPopup.isShowing());
  }

  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramh, paramBoolean);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet)
      this.mMaxItems = a.a(this.mContext).a();
    if (this.mMenu != null)
      this.mMenu.a(true);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState));
    MenuItem localMenuItem;
    do
    {
      SavedState localSavedState;
      do
      {
        return;
        localSavedState = (SavedState)paramParcelable;
      }
      while (localSavedState.openSubMenuId <= 0);
      localMenuItem = this.mMenu.findItem(localSavedState.openSubMenuId);
    }
    while (localMenuItem == null);
    onSubMenuSelected((u)localMenuItem.getSubMenu());
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }

  public boolean onSubMenuSelected(u paramu)
  {
    if (!paramu.hasVisibleItems());
    View localView;
    do
    {
      return false;
      for (u localu = paramu; localu.t() != this.mMenu; localu = (u)localu.t());
      localView = findViewForItem(localu.getItem());
    }
    while (localView == null);
    this.mOpenSubMenuId = paramu.getItem().getItemId();
    int i = paramu.size();
    int j = 0;
    if (j < i)
    {
      MenuItem localMenuItem = paramu.getItem(j);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null));
    }
    for (boolean bool = true; ; bool = false)
    {
      this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, paramu, localView);
      this.mActionButtonPopup.setForceShowIcon(bool);
      this.mActionButtonPopup.show();
      super.onSubMenuSelected(paramu);
      return true;
      j++;
      break;
    }
  }

  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
      super.onSubMenuSelected(null);
    while (this.mMenu == null)
      return;
    this.mMenu.b(false);
  }

  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }

  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }

  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }

  public void setOverflowIcon(Drawable paramDrawable)
  {
    if (this.mOverflowButton != null)
    {
      this.mOverflowButton.setImageDrawable(paramDrawable);
      return;
    }
    this.mPendingOverflowIconSet = true;
    this.mPendingOverflowIcon = paramDrawable;
  }

  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }

  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }

  public boolean shouldIncludeItem(int paramInt, j paramj)
  {
    return paramj.i();
  }

  public boolean showOverflowMenu()
  {
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null) && (!this.mMenu.m().isEmpty()))
    {
      this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }

  public void updateMenuView(boolean paramBoolean)
  {
    int i = 1;
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    if (this.mMenu != null)
    {
      ArrayList localArrayList2 = this.mMenu.l();
      int n = localArrayList2.size();
      for (int i1 = 0; i1 < n; i1++)
      {
        ActionProvider localActionProvider = ((j)localArrayList2.get(i1)).getSupportActionProvider();
        if (localActionProvider != null)
          localActionProvider.setSubUiVisibilityListener(this);
      }
    }
    ArrayList localArrayList1;
    int j;
    int k;
    int m;
    if (this.mMenu != null)
    {
      localArrayList1 = this.mMenu.m();
      boolean bool = this.mReserveOverflow;
      j = 0;
      if (bool)
      {
        j = 0;
        if (localArrayList1 != null)
        {
          k = localArrayList1.size();
          if (k != i)
            break label263;
          if (((j)localArrayList1.get(0)).isActionViewExpanded())
            break label257;
          m = i;
          label147: j = m;
        }
      }
      if (j == 0)
        break label279;
      if (this.mOverflowButton == null)
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
      ViewGroup localViewGroup = (ViewGroup)this.mOverflowButton.getParent();
      if (localViewGroup != this.mMenuView)
      {
        if (localViewGroup != null)
          localViewGroup.removeView(this.mOverflowButton);
        ActionMenuView localActionMenuView = (ActionMenuView)this.mMenuView;
        localActionMenuView.addView(this.mOverflowButton, localActionMenuView.generateOverflowButtonLayoutParams());
      }
    }
    while (true)
    {
      ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
      return;
      localArrayList1 = null;
      break;
      label257: m = 0;
      break label147;
      label263: if (k > 0);
      while (true)
      {
        j = i;
        break;
        i = 0;
      }
      label279: if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView))
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
    }
  }

  private class ActionButtonSubmenu extends n
  {
    public ActionButtonSubmenu(Context paramu, u paramView, View arg4)
    {
      super(paramView, localView, false, R.attr.actionOverflowMenuStyle);
      if (!((j)paramView.getItem()).i())
        if (ActionMenuPresenter.this.mOverflowButton != null)
          break label61;
      label61: for (Object localObject = (View)ActionMenuPresenter.this.mMenuView; ; localObject = ActionMenuPresenter.this.mOverflowButton)
      {
        setAnchorView((View)localObject);
        setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        return;
      }
    }

    protected void onDismiss()
    {
      ActionMenuPresenter.this.mActionButtonPopup = null;
      ActionMenuPresenter.this.mOpenSubMenuId = 0;
      super.onDismiss();
    }
  }

  private class ActionMenuPopupCallback extends ActionMenuItemView.b
  {
    ActionMenuPopupCallback()
    {
    }

    public s getPopup()
    {
      if (ActionMenuPresenter.this.mActionButtonPopup != null)
        return ActionMenuPresenter.this.mActionButtonPopup.getPopup();
      return null;
    }
  }

  private class OpenOverflowRunnable
    implements Runnable
  {
    private ActionMenuPresenter.OverflowPopup mPopup;

    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup arg2)
    {
      Object localObject;
      this.mPopup = localObject;
    }

    public void run()
    {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.g();
      View localView = (View)ActionMenuPresenter.this.mMenuView;
      if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow()))
        ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
      ActionMenuPresenter.this.mPostedOpenRunnable = null;
    }
  }

  private class OverflowMenuButton extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView
  {
    private final float[] mTempPts = new float[2];

    public OverflowMenuButton(Context arg2)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TooltipCompat.setTooltipText(this, getContentDescription());
      setOnTouchListener(new ForwardingListener(this)
      {
        public s getPopup()
        {
          if (ActionMenuPresenter.this.mOverflowPopup == null)
            return null;
          return ActionMenuPresenter.this.mOverflowPopup.getPopup();
        }

        public boolean onForwardingStarted()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }

        public boolean onForwardingStopped()
        {
          if (ActionMenuPresenter.this.mPostedOpenRunnable != null)
            return false;
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }

    public boolean needsDividerAfter()
    {
      return false;
    }

    public boolean needsDividerBefore()
    {
      return false;
    }

    public boolean performClick()
    {
      if (super.performClick())
        return true;
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }

    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        int j = getHeight();
        int k = Math.max(i, j) / 2;
        int m = getPaddingLeft() - getPaddingRight();
        int n = getPaddingTop() - getPaddingBottom();
        int i1 = (i + m) / 2;
        int i2 = (j + n) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i1 - k, i2 - k, i1 + k, i2 + k);
      }
      return bool;
    }
  }

  private class OverflowPopup extends n
  {
    public OverflowPopup(Context paramh, h paramView, View paramBoolean, boolean arg5)
    {
      super(paramView, paramBoolean, bool, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }

    protected void onDismiss()
    {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.close();
      ActionMenuPresenter.this.mOverflowPopup = null;
      super.onDismiss();
    }
  }

  private class PopupPresenterCallback
    implements o.a
  {
    PopupPresenterCallback()
    {
    }

    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      if ((paramh instanceof u))
        paramh.q().b(false);
      o.a locala = ActionMenuPresenter.this.getCallback();
      if (locala != null)
        locala.onCloseMenu(paramh, paramBoolean);
    }

    public boolean onOpenSubMenu(h paramh)
    {
      if (paramh == null)
        return false;
      ActionMenuPresenter.this.mOpenSubMenuId = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.getCallback();
      if (locala != null);
      for (boolean bool = locala.onOpenSubMenu(paramh); ; bool = false)
        return bool;
    }
  }

  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }

      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int openSubMenuId;

    SavedState()
    {
    }

    SavedState(Parcel paramParcel)
    {
      this.openSubMenuId = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.openSubMenuId);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.6.2
 */