package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends d
  implements p.a
{
  private static final int[] d = { 16842912 };
  boolean c;
  private final int e;
  private boolean f;
  private final CheckedTextView g;
  private FrameLayout h;
  private j i;
  private ColorStateList j;
  private boolean k;
  private Drawable l;
  private final AccessibilityDelegateCompat m = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      paramAnonymousAccessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.c);
    }
  };

  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    this.e = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    this.g = ((CheckedTextView)findViewById(R.id.design_menu_item_text));
    this.g.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.g, this.m);
  }

  private boolean c()
  {
    return (this.i.getTitle() == null) && (this.i.getIcon() == null) && (this.i.getActionView() != null);
  }

  private void d()
  {
    if (c())
    {
      this.g.setVisibility(8);
      if (this.h != null)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams2 = (LinearLayoutCompat.LayoutParams)this.h.getLayoutParams();
        localLayoutParams2.width = -1;
        this.h.setLayoutParams(localLayoutParams2);
      }
    }
    do
    {
      return;
      this.g.setVisibility(0);
    }
    while (this.h == null);
    LinearLayoutCompat.LayoutParams localLayoutParams1 = (LinearLayoutCompat.LayoutParams)this.h.getLayoutParams();
    localLayoutParams1.width = -2;
    this.h.setLayoutParams(localLayoutParams1);
  }

  private StateListDrawable e()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(d, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }

  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.h == null)
        this.h = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      this.h.removeAllViews();
      this.h.addView(paramView);
    }
  }

  public void a(j paramj, int paramInt)
  {
    this.i = paramj;
    if (paramj.isVisible());
    for (int n = 0; ; n = 8)
    {
      setVisibility(n);
      if (getBackground() == null)
        ViewCompat.setBackground(this, e());
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      TooltipCompat.setTooltipText(this, paramj.getTooltipText());
      d();
      return;
    }
  }

  public boolean a()
  {
    return false;
  }

  public void b()
  {
    if (this.h != null)
      this.h.removeAllViews();
    this.g.setCompoundDrawables(null, null, null, null);
  }

  public j getItemData()
  {
    return this.i;
  }

  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.i != null) && (this.i.isCheckable()) && (this.i.isChecked()))
      mergeDrawableStates(arrayOfInt, d);
    return arrayOfInt;
  }

  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      this.m.sendAccessibilityEvent(this.g, 2048);
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.g.setChecked(paramBoolean);
  }

  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }

  public void setIcon(Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState;
    if (paramDrawable != null)
      if (this.k)
      {
        localConstantState = paramDrawable.getConstantState();
        if (localConstantState == null)
        {
          paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
          DrawableCompat.setTintList(paramDrawable, this.j);
        }
      }
      else
      {
        paramDrawable.setBounds(0, 0, this.e, this.e);
      }
    while (true)
    {
      TextViewCompat.setCompoundDrawablesRelative(this.g, paramDrawable, null, null, null);
      return;
      paramDrawable = localConstantState.newDrawable();
      break;
      if (this.f)
      {
        if (this.l == null)
        {
          this.l = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
          if (this.l != null)
            this.l.setBounds(0, 0, this.e, this.e);
        }
        paramDrawable = this.l;
      }
    }
  }

  public void setIconPadding(int paramInt)
  {
    this.g.setCompoundDrawablePadding(paramInt);
  }

  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.j = paramColorStateList;
    if (this.j != null);
    for (boolean bool = true; ; bool = false)
    {
      this.k = bool;
      if (this.i != null)
        setIcon(this.i.getIcon());
      return;
    }
  }

  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.g, paramInt);
  }

  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.g.setTextColor(paramColorStateList);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.g.setText(paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.6.2
 */