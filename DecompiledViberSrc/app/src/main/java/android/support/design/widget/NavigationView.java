package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.e;
import android.support.design.internal.f;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.a.a.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;

public class NavigationView extends android.support.design.internal.h
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
  OnNavigationItemSelectedListener listener;
  private final int maxWidth;
  private final e menu;
  private MenuInflater menuInflater;
  private final f presenter = new f();

  public NavigationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, android.support.design.R.attr.navigationViewStyle);
  }

  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.menu = new e(paramContext);
    TintTypedArray localTintTypedArray = android.support.design.internal.j.b(paramContext, paramAttributeSet, R.styleable.NavigationView, paramInt, R.style.Widget_Design_NavigationView, new int[0]);
    ViewCompat.setBackground(this, localTintTypedArray.getDrawable(R.styleable.NavigationView_android_background));
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_elevation))
      ViewCompat.setElevation(this, localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
    ViewCompat.setFitsSystemWindows(this, localTintTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
    this.maxWidth = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
    ColorStateList localColorStateList1;
    int i;
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemIconTint))
    {
      localColorStateList1 = localTintTypedArray.getColorStateList(R.styleable.NavigationView_itemIconTint);
      if (!localTintTypedArray.hasValue(R.styleable.NavigationView_itemTextAppearance))
        break label431;
      i = localTintTypedArray.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
    }
    for (int j = 1; ; j = 0)
    {
      boolean bool = localTintTypedArray.hasValue(R.styleable.NavigationView_itemTextColor);
      ColorStateList localColorStateList2 = null;
      if (bool)
        localColorStateList2 = localTintTypedArray.getColorStateList(R.styleable.NavigationView_itemTextColor);
      if ((j == 0) && (localColorStateList2 == null))
        localColorStateList2 = createDefaultColorStateList(16842806);
      Drawable localDrawable = localTintTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
      if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemHorizontalPadding))
      {
        int m = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemHorizontalPadding, 0);
        this.presenter.e(m);
      }
      int k = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconPadding, 0);
      this.menu.a(new h.a()
      {
        public boolean onMenuItemSelected(android.support.v7.view.menu.h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.listener != null) && (NavigationView.this.listener.onNavigationItemSelected(paramAnonymousMenuItem));
        }

        public void onMenuModeChange(android.support.v7.view.menu.h paramAnonymoush)
        {
        }
      });
      this.presenter.a(1);
      this.presenter.initForMenu(paramContext, this.menu);
      this.presenter.a(localColorStateList1);
      if (j != 0)
        this.presenter.d(i);
      this.presenter.b(localColorStateList2);
      this.presenter.a(localDrawable);
      this.presenter.f(k);
      this.menu.a(this.presenter);
      addView((View)this.presenter.a(this));
      if (localTintTypedArray.hasValue(R.styleable.NavigationView_menu))
        inflateMenu(localTintTypedArray.getResourceId(R.styleable.NavigationView_menu, 0));
      if (localTintTypedArray.hasValue(R.styleable.NavigationView_headerLayout))
        inflateHeaderView(localTintTypedArray.getResourceId(R.styleable.NavigationView_headerLayout, 0));
      localTintTypedArray.recycle();
      return;
      localColorStateList1 = createDefaultColorStateList(16842808);
      break;
      label431: i = 0;
    }
  }

  private ColorStateList createDefaultColorStateList(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, localTypedValue, true));
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.a(getContext(), localTypedValue.resourceId);
    }
    while (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, localTypedValue, true));
    int i = localTypedValue.data;
    int j = localColorStateList.getDefaultColor();
    int[][] arrayOfInt = new int[3][];
    arrayOfInt[0] = DISABLED_STATE_SET;
    arrayOfInt[1] = CHECKED_STATE_SET;
    arrayOfInt[2] = EMPTY_STATE_SET;
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = localColorStateList.getColorForState(DISABLED_STATE_SET, j);
    arrayOfInt1[1] = i;
    arrayOfInt1[2] = j;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null)
      this.menuInflater = new g(getContext());
    return this.menuInflater;
  }

  public void addHeaderView(View paramView)
  {
    this.presenter.a(paramView);
  }

  public MenuItem getCheckedItem()
  {
    return this.presenter.a();
  }

  public int getHeaderCount()
  {
    return this.presenter.b();
  }

  public View getHeaderView(int paramInt)
  {
    return this.presenter.c(paramInt);
  }

  public Drawable getItemBackground()
  {
    return this.presenter.e();
  }

  public int getItemHorizontalPadding()
  {
    return this.presenter.f();
  }

  public int getItemIconPadding()
  {
    return this.presenter.g();
  }

  public ColorStateList getItemIconTintList()
  {
    return this.presenter.c();
  }

  public ColorStateList getItemTextColor()
  {
    return this.presenter.d();
  }

  public Menu getMenu()
  {
    return this.menu;
  }

  public View inflateHeaderView(int paramInt)
  {
    return this.presenter.b(paramInt);
  }

  public void inflateMenu(int paramInt)
  {
    this.presenter.a(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.a(false);
    this.presenter.updateMenuView(false);
  }

  protected void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.presenter.a(paramWindowInsetsCompat);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    case 1073741824:
    default:
    case -2147483648:
    case 0:
    }
    while (true)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
      continue;
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
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
    this.menu.b(localSavedState.menuState);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.menuState = new Bundle();
    this.menu.a(localSavedState.menuState);
    return localSavedState;
  }

  public void removeHeaderView(View paramView)
  {
    this.presenter.b(paramView);
  }

  public void setCheckedItem(int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if (localMenuItem != null)
      this.presenter.a((android.support.v7.view.menu.j)localMenuItem);
  }

  public void setCheckedItem(MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = this.menu.findItem(paramMenuItem.getItemId());
    if (localMenuItem != null)
    {
      this.presenter.a((android.support.v7.view.menu.j)localMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }

  public void setItemBackground(Drawable paramDrawable)
  {
    this.presenter.a(paramDrawable);
  }

  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }

  public void setItemHorizontalPadding(int paramInt)
  {
    this.presenter.e(paramInt);
  }

  public void setItemHorizontalPaddingResource(int paramInt)
  {
    this.presenter.e(getResources().getDimensionPixelSize(paramInt));
  }

  public void setItemIconPadding(int paramInt)
  {
    this.presenter.f(paramInt);
  }

  public void setItemIconPaddingResource(int paramInt)
  {
    this.presenter.f(getResources().getDimensionPixelSize(paramInt));
  }

  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.presenter.a(paramColorStateList);
  }

  public void setItemTextAppearance(int paramInt)
  {
    this.presenter.d(paramInt);
  }

  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.presenter.b(paramColorStateList);
  }

  public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.listener = paramOnNavigationItemSelectedListener;
  }

  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(MenuItem paramMenuItem);
  }

  public static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, null);
      }

      public NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public NavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new NavigationView.SavedState[paramAnonymousInt];
      }
    };
    public Bundle menuState;

    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.menuState = paramParcel.readBundle(paramClassLoader);
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuState);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.6.2
 */