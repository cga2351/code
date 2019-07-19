package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.design.R.dimen;
import android.support.transition.b;
import android.support.transition.n;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.ArrayList;

public class c extends ViewGroup
  implements android.support.v7.view.menu.p
{
  private static final int[] a = { 16842912 };
  private static final int[] b = { -16842910 };
  private final android.support.transition.p c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final View.OnClickListener i;
  private final Pools.Pool<a> j = new Pools.SynchronizedPool(5);
  private boolean k;
  private int l;
  private a[] m;
  private int n = 0;
  private int o = 0;
  private ColorStateList p;
  private int q;
  private ColorStateList r;
  private final ColorStateList s;
  private int t;
  private int u;
  private Drawable v;
  private int w;
  private int[] x;
  private BottomNavigationPresenter y;
  private h z;

  public c(Context paramContext)
  {
    this(paramContext, null);
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.d = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.e = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.f = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.g = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.h = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.s = a(16842808);
    this.c = new b();
    this.c.a(0);
    this.c.c(115L);
    this.c.b(new FastOutSlowInInterpolator());
    this.c.a(new i());
    this.i = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        j localj = ((a)paramAnonymousView).getItemData();
        if (!c.b(c.this).a(localj, c.a(c.this), 0))
          localj.setChecked(true);
      }
    };
    this.x = new int[5];
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
      if (paramInt2 <= 3);
    while (paramInt1 == 0)
    {
      return true;
      return false;
    }
    return false;
  }

  private a getNewItem()
  {
    a locala = (a)this.j.acquire();
    if (locala == null)
      locala = new a(getContext());
    return locala;
  }

  public ColorStateList a(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, localTypedValue, true));
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = android.support.v7.a.a.a.a(getContext(), localTypedValue.resourceId);
    }
    while (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, localTypedValue, true));
    int i1 = localTypedValue.data;
    int i2 = localColorStateList.getDefaultColor();
    int[][] arrayOfInt = new int[3][];
    arrayOfInt[0] = b;
    arrayOfInt[1] = a;
    arrayOfInt[2] = EMPTY_STATE_SET;
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = localColorStateList.getColorForState(b, i2);
    arrayOfInt1[1] = i1;
    arrayOfInt1[2] = i2;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  public boolean a()
  {
    return this.k;
  }

  public void b()
  {
    removeAllViews();
    if (this.m != null)
      for (a locala2 : this.m)
        if (locala2 != null)
          this.j.release(locala2);
    if (this.z.size() == 0)
    {
      this.n = 0;
      this.o = 0;
      this.m = null;
      return;
    }
    this.m = new a[this.z.size()];
    boolean bool = a(this.l, this.z.j().size());
    int i1 = 0;
    if (i1 < this.z.size())
    {
      this.y.a(true);
      this.z.getItem(i1).setCheckable(true);
      this.y.a(false);
      a locala1 = getNewItem();
      this.m[i1] = locala1;
      locala1.setIconTintList(this.p);
      locala1.setIconSize(this.q);
      locala1.setTextColor(this.s);
      locala1.setTextAppearanceInactive(this.t);
      locala1.setTextAppearanceActive(this.u);
      locala1.setTextColor(this.r);
      if (this.v != null)
        locala1.setItemBackground(this.v);
      while (true)
      {
        locala1.setShifting(bool);
        locala1.setLabelVisibilityMode(this.l);
        locala1.a((j)this.z.getItem(i1), 0);
        locala1.setItemPosition(i1);
        locala1.setOnClickListener(this.i);
        addView(locala1);
        i1++;
        break;
        locala1.setItemBackground(this.w);
      }
    }
    this.o = Math.min(-1 + this.z.size(), this.o);
    this.z.getItem(this.o).setChecked(true);
  }

  void b(int paramInt)
  {
    int i1 = this.z.size();
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        MenuItem localMenuItem = this.z.getItem(i2);
        if (paramInt == localMenuItem.getItemId())
        {
          this.n = paramInt;
          this.o = i2;
          localMenuItem.setChecked(true);
        }
      }
      else
      {
        return;
      }
  }

  public void c()
  {
    if ((this.z == null) || (this.m == null));
    while (true)
    {
      return;
      int i1 = this.z.size();
      if (i1 != this.m.length)
      {
        b();
        return;
      }
      int i2 = this.n;
      for (int i3 = 0; i3 < i1; i3++)
      {
        MenuItem localMenuItem = this.z.getItem(i3);
        if (localMenuItem.isChecked())
        {
          this.n = localMenuItem.getItemId();
          this.o = i3;
        }
      }
      if (i2 != this.n)
        n.a(this, this.c);
      boolean bool = a(this.l, this.z.j().size());
      for (int i4 = 0; i4 < i1; i4++)
      {
        this.y.a(true);
        this.m[i4].setLabelVisibilityMode(this.l);
        this.m[i4].setShifting(bool);
        this.m[i4].a((j)this.z.getItem(i4), 0);
        this.y.a(false);
      }
    }
  }

  public ColorStateList getIconTintList()
  {
    return this.p;
  }

  public Drawable getItemBackground()
  {
    if ((this.m != null) && (this.m.length > 0))
      return this.m[0].getBackground();
    return this.v;
  }

  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.w;
  }

  public int getItemIconSize()
  {
    return this.q;
  }

  public int getItemTextAppearanceActive()
  {
    return this.u;
  }

  public int getItemTextAppearanceInactive()
  {
    return this.t;
  }

  public ColorStateList getItemTextColor()
  {
    return this.r;
  }

  public int getLabelVisibilityMode()
  {
    return this.l;
  }

  public int getSelectedItemId()
  {
    return this.n;
  }

  public int getWindowAnimations()
  {
    return 0;
  }

  public void initialize(h paramh)
  {
    this.z = paramh;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = 0;
    int i5 = 0;
    while (i4 < i1)
    {
      View localView = getChildAt(i4);
      if (localView.getVisibility() == 8)
      {
        i4++;
      }
      else
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
          localView.layout(i2 - i5 - localView.getMeasuredWidth(), 0, i2 - i5, i3);
        while (true)
        {
          i5 += localView.getMeasuredWidth();
          break;
          localView.layout(i5, 0, i5 + localView.getMeasuredWidth(), i3);
        }
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = this.z.j().size();
    int i4 = getChildCount();
    int i5 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    if ((a(this.l, i3)) && (this.k))
    {
      View localView2 = getChildAt(this.o);
      int i11 = this.g;
      if (localView2.getVisibility() != 8)
      {
        localView2.measure(View.MeasureSpec.makeMeasureSpec(this.f, -2147483648), i5);
        i11 = Math.max(i11, localView2.getMeasuredWidth());
      }
      int i12;
      int i13;
      label169: int i16;
      int i17;
      int i18;
      label198: int i20;
      if (localView2.getVisibility() != 8)
      {
        i12 = i1;
        i13 = i3 - i12;
        int i14 = Math.min(i2 - i13 * this.e, Math.min(i11, this.f));
        int i15 = i2 - i14;
        if (i13 != 0)
          break label290;
        i16 = Math.min(i15 / i1, this.d);
        i17 = i2 - i14 - i13 * i16;
        i18 = 0;
        if (i18 >= i4)
          break label428;
        if (getChildAt(i18).getVisibility() == 8)
          break label303;
        int[] arrayOfInt2 = this.x;
        if (i18 != this.o)
          break label296;
        i20 = i14;
        label238: arrayOfInt2[i18] = i20;
        if (i17 <= 0)
          break label311;
        int[] arrayOfInt3 = this.x;
        arrayOfInt3[i18] = (1 + arrayOfInt3[i18]);
      }
      label290: label296: label303: label311: for (int i19 = i17 - 1; ; i19 = i17)
      {
        i18++;
        i17 = i19;
        break label198;
        i12 = 0;
        break;
        i1 = i13;
        break label169;
        i20 = i16;
        break label238;
        this.x[i18] = 0;
      }
    }
    else
    {
      int i8;
      if (i3 == 0)
      {
        int i6 = Math.min(i2 / i1, this.f);
        int i7 = i2 - i6 * i3;
        i8 = 0;
        label349: if (i8 >= i4)
          break label428;
        if (getChildAt(i8).getVisibility() == 8)
          break label417;
        this.x[i8] = i6;
        if (i7 > 0)
        {
          int[] arrayOfInt1 = this.x;
          arrayOfInt1[i8] = (1 + arrayOfInt1[i8]);
          i7--;
        }
      }
      while (true)
      {
        i8++;
        break label349;
        i1 = i3;
        break;
        label417: this.x[i8] = 0;
      }
    }
    label428: int i9 = 0;
    int i10 = 0;
    if (i9 < i4)
    {
      View localView1 = getChildAt(i9);
      if (localView1.getVisibility() == 8);
      while (true)
      {
        i9++;
        break;
        localView1.measure(View.MeasureSpec.makeMeasureSpec(this.x[i9], 1073741824), i5);
        localView1.getLayoutParams().width = localView1.getMeasuredWidth();
        i10 += localView1.getMeasuredWidth();
      }
    }
    setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.h, i5, 0));
  }

  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.p = paramColorStateList;
    if (this.m != null)
    {
      a[] arrayOfa = this.m;
      int i1 = arrayOfa.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfa[i2].setIconTintList(paramColorStateList);
    }
  }

  public void setItemBackground(Drawable paramDrawable)
  {
    this.v = paramDrawable;
    if (this.m != null)
    {
      a[] arrayOfa = this.m;
      int i1 = arrayOfa.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfa[i2].setItemBackground(paramDrawable);
    }
  }

  public void setItemBackgroundRes(int paramInt)
  {
    this.w = paramInt;
    if (this.m != null)
    {
      a[] arrayOfa = this.m;
      int i1 = arrayOfa.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfa[i2].setItemBackground(paramInt);
    }
  }

  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setItemIconSize(int paramInt)
  {
    this.q = paramInt;
    if (this.m != null)
    {
      a[] arrayOfa = this.m;
      int i1 = arrayOfa.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfa[i2].setIconSize(paramInt);
    }
  }

  public void setItemTextAppearanceActive(int paramInt)
  {
    this.u = paramInt;
    if (this.m != null)
      for (a locala : this.m)
      {
        locala.setTextAppearanceActive(paramInt);
        if (this.r != null)
          locala.setTextColor(this.r);
      }
  }

  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.t = paramInt;
    if (this.m != null)
      for (a locala : this.m)
      {
        locala.setTextAppearanceInactive(paramInt);
        if (this.r != null)
          locala.setTextColor(this.r);
      }
  }

  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.r = paramColorStateList;
    if (this.m != null)
    {
      a[] arrayOfa = this.m;
      int i1 = arrayOfa.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfa[i2].setTextColor(paramColorStateList);
    }
  }

  public void setLabelVisibilityMode(int paramInt)
  {
    this.l = paramInt;
  }

  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.y = paramBottomNavigationPresenter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.c
 * JD-Core Version:    0.6.2
 */