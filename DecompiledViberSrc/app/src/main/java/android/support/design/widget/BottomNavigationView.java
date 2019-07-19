package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.attr;
import android.support.design.R.color;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.design.internal.j;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView extends FrameLayout
{
  private static final int MENU_PRESENTER_ID = 1;
  private final h menu;
  private MenuInflater menuInflater;
  private final c menuView;
  private final BottomNavigationPresenter presenter = new BottomNavigationPresenter();
  private OnNavigationItemReselectedListener reselectedListener;
  private OnNavigationItemSelectedListener selectedListener;

  public BottomNavigationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }

  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.menu = new b(paramContext);
    this.menuView = new c(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.menuView.setLayoutParams(localLayoutParams);
    this.presenter.a(this.menuView);
    this.presenter.a(1);
    this.menuView.setPresenter(this.presenter);
    this.menu.a(this.presenter);
    this.presenter.initForMenu(getContext(), this.menu);
    int[] arrayOfInt1 = R.styleable.BottomNavigationView;
    int i = R.style.Widget_Design_BottomNavigationView;
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
    arrayOfInt2[1] = R.styleable.BottomNavigationView_itemTextAppearanceActive;
    TintTypedArray localTintTypedArray = j.b(paramContext, paramAttributeSet, arrayOfInt1, paramInt, i, arrayOfInt2);
    if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_itemIconTint))
      this.menuView.setIconTintList(localTintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
    while (true)
    {
      setItemIconSize(localTintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
      if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive))
        setItemTextAppearanceInactive(localTintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
      if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive))
        setItemTextAppearanceActive(localTintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
      if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextColor))
        setItemTextColor(localTintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
      if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_elevation))
        ViewCompat.setElevation(this, localTintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
      setLabelVisibilityMode(localTintTypedArray.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
      setItemHorizontalTranslationEnabled(localTintTypedArray.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
      int j = localTintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
      this.menuView.setItemBackgroundRes(j);
      if (localTintTypedArray.hasValue(R.styleable.BottomNavigationView_menu))
        inflateMenu(localTintTypedArray.getResourceId(R.styleable.BottomNavigationView_menu, 0));
      localTintTypedArray.recycle();
      addView(this.menuView, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
        addCompatibilityTopDivider(paramContext);
      this.menu.a(new h.a()
      {
        public boolean onMenuItemSelected(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          if ((BottomNavigationView.this.reselectedListener != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()))
            BottomNavigationView.this.reselectedListener.onNavigationItemReselected(paramAnonymousMenuItem);
          while ((BottomNavigationView.this.selectedListener != null) && (!BottomNavigationView.this.selectedListener.onNavigationItemSelected(paramAnonymousMenuItem)))
            return true;
          return false;
        }

        public void onMenuModeChange(h paramAnonymoush)
        {
        }
      });
      return;
      this.menuView.setIconTintList(this.menuView.a(16842808));
    }
  }

  private void addCompatibilityTopDivider(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.design_bottom_navigation_shadow_color));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(localView);
  }

  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null)
      this.menuInflater = new g(getContext());
    return this.menuInflater;
  }

  public Drawable getItemBackground()
  {
    return this.menuView.getItemBackground();
  }

  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.menuView.getItemBackgroundRes();
  }

  public int getItemIconSize()
  {
    return this.menuView.getItemIconSize();
  }

  public ColorStateList getItemIconTintList()
  {
    return this.menuView.getIconTintList();
  }

  public int getItemTextAppearanceActive()
  {
    return this.menuView.getItemTextAppearanceActive();
  }

  public int getItemTextAppearanceInactive()
  {
    return this.menuView.getItemTextAppearanceInactive();
  }

  public ColorStateList getItemTextColor()
  {
    return this.menuView.getItemTextColor();
  }

  public int getLabelVisibilityMode()
  {
    return this.menuView.getLabelVisibilityMode();
  }

  public int getMaxItemCount()
  {
    return 5;
  }

  public Menu getMenu()
  {
    return this.menu;
  }

  public int getSelectedItemId()
  {
    return this.menuView.getSelectedItemId();
  }

  public void inflateMenu(int paramInt)
  {
    this.presenter.a(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.a(false);
    this.presenter.updateMenuView(true);
  }

  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.menuView.a();
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
    this.menu.b(localSavedState.menuPresenterState);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.menuPresenterState = new Bundle();
    this.menu.a(localSavedState.menuPresenterState);
    return localSavedState;
  }

  public void setItemBackground(Drawable paramDrawable)
  {
    this.menuView.setItemBackground(paramDrawable);
  }

  public void setItemBackgroundResource(int paramInt)
  {
    this.menuView.setItemBackgroundRes(paramInt);
  }

  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.menuView.a() != paramBoolean)
    {
      this.menuView.setItemHorizontalTranslationEnabled(paramBoolean);
      this.presenter.updateMenuView(false);
    }
  }

  public void setItemIconSize(int paramInt)
  {
    this.menuView.setItemIconSize(paramInt);
  }

  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }

  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.menuView.setIconTintList(paramColorStateList);
  }

  public void setItemTextAppearanceActive(int paramInt)
  {
    this.menuView.setItemTextAppearanceActive(paramInt);
  }

  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.menuView.setItemTextAppearanceInactive(paramInt);
  }

  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.menuView.setItemTextColor(paramColorStateList);
  }

  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.menuView.getLabelVisibilityMode() != paramInt)
    {
      this.menuView.setLabelVisibilityMode(paramInt);
      this.presenter.updateMenuView(false);
    }
  }

  public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener)
  {
    this.reselectedListener = paramOnNavigationItemReselectedListener;
  }

  public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.selectedListener = paramOnNavigationItemSelectedListener;
  }

  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if ((localMenuItem != null) && (!this.menu.a(localMenuItem, this.presenter, 0)))
      localMenuItem.setChecked(true);
  }

  public static abstract interface OnNavigationItemReselectedListener
  {
    public abstract void onNavigationItemReselected(MenuItem paramMenuItem);
  }

  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(MenuItem paramMenuItem);
  }

  static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomNavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, null);
      }

      public BottomNavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public BottomNavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationView.SavedState[paramAnonymousInt];
      }
    };
    Bundle menuPresenterState;

    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      readFromParcel(paramParcel, paramClassLoader);
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    private void readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.menuPresenterState = paramParcel.readBundle(paramClassLoader);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuPresenterState);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.6.2
 */