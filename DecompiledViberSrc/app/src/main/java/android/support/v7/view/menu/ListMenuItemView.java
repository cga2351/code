package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout
  implements p.a, AbsListView.SelectionBoundsAdjuster
{
  private j a;
  private ImageView b;
  private RadioButton c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private ImageView g;
  private ImageView h;
  private LinearLayout i;
  private Drawable j;
  private int k;
  private Context l;
  private boolean m;
  private Drawable n;
  private boolean o;
  private int p;
  private LayoutInflater q;
  private boolean r;

  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }

  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.j = localTintTypedArray.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.k = localTintTypedArray.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.m = localTintTypedArray.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.l = paramContext;
    this.n = localTintTypedArray.getDrawable(R.styleable.MenuView_subMenuArrow);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, R.attr.dropDownListViewStyle, 0);
    this.o = localTypedArray.hasValue(0);
    localTintTypedArray.recycle();
    localTypedArray.recycle();
  }

  private void a(View paramView)
  {
    a(paramView, -1);
  }

  private void a(View paramView, int paramInt)
  {
    if (this.i != null)
    {
      this.i.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }

  private void b()
  {
    this.b = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
    a(this.b, 0);
  }

  private void c()
  {
    this.c = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    a(this.c);
  }

  private void d()
  {
    this.e = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    a(this.e);
  }

  private LayoutInflater getInflater()
  {
    if (this.q == null)
      this.q = LayoutInflater.from(getContext());
    return this.q;
  }

  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.g != null)
    {
      localImageView = this.g;
      if (!paramBoolean)
        break label24;
    }
    label24: for (int i1 = 0; ; i1 = 8)
    {
      localImageView.setVisibility(i1);
      return;
    }
  }

  public void a(j paramj, int paramInt)
  {
    this.a = paramj;
    this.p = paramInt;
    if (paramj.isVisible());
    for (int i1 = 0; ; i1 = 8)
    {
      setVisibility(i1);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      a(paramj.e(), paramj.c());
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      return;
    }
  }

  public void a(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.a.e()));
    for (int i1 = 0; ; i1 = 8)
    {
      if (i1 == 0)
        this.f.setText(this.a.d());
      if (this.f.getVisibility() != i1)
        this.f.setVisibility(i1);
      return;
    }
  }

  public boolean a()
  {
    return false;
  }

  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.h != null) && (this.h.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
      paramRect.top += this.h.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    }
  }

  public j getItemData()
  {
    return this.a;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackground(this, this.j);
    this.d = ((TextView)findViewById(R.id.title));
    if (this.k != -1)
      this.d.setTextAppearance(this.l, this.k);
    this.f = ((TextView)findViewById(R.id.shortcut));
    this.g = ((ImageView)findViewById(R.id.submenuarrow));
    if (this.g != null)
      this.g.setImageDrawable(this.n);
    this.h = ((ImageView)findViewById(R.id.group_divider));
    this.i = ((LinearLayout)findViewById(R.id.content));
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.m))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0))
        localLayoutParams1.width = localLayoutParams.height;
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c == null) && (this.e == null));
    label121: 
    do
    {
      return;
      Object localObject1;
      if (this.a.f())
      {
        if (this.c == null)
          c();
        localObject1 = this.c;
      }
      for (Object localObject2 = this.e; ; localObject2 = this.c)
      {
        if (!paramBoolean)
          break label121;
        ((CompoundButton)localObject1).setChecked(this.a.isChecked());
        if (((CompoundButton)localObject1).getVisibility() != 0)
          ((CompoundButton)localObject1).setVisibility(0);
        if ((localObject2 == null) || (((CompoundButton)localObject2).getVisibility() == 8))
          break;
        ((CompoundButton)localObject2).setVisibility(8);
        return;
        if (this.e == null)
          d();
        localObject1 = this.e;
      }
      if (this.e != null)
        this.e.setVisibility(8);
    }
    while (this.c == null);
    this.c.setVisibility(8);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.a.f())
      if (this.c == null)
        c();
    for (Object localObject = this.c; ; localObject = this.e)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.e == null)
        d();
    }
  }

  public void setForceShowIcon(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.m = paramBoolean;
  }

  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.h != null)
    {
      localImageView = this.h;
      if ((this.o) || (!paramBoolean))
        break label31;
    }
    label31: for (int i1 = 0; ; i1 = 8)
    {
      localImageView.setVisibility(i1);
      return;
    }
  }

  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if ((this.a.h()) || (this.r))
    {
      i1 = 1;
      if ((i1 != 0) || (this.m))
        break label36;
    }
    label36: 
    while ((this.b == null) && (paramDrawable == null) && (!this.m))
    {
      return;
      i1 = 0;
      break;
    }
    if (this.b == null)
      b();
    if ((paramDrawable != null) || (this.m))
    {
      ImageView localImageView = this.b;
      if (i1 != 0);
      while (true)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.b.getVisibility() == 0)
          break;
        this.b.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.b.setVisibility(8);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0)
        this.d.setVisibility(0);
    }
    while (this.d.getVisibility() == 8)
      return;
    this.d.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.6.2
 */