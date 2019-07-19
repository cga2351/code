package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class a extends FrameLayout
  implements p.a
{
  private static final int[] a = { 16842912 };
  private final int b;
  private float c;
  private float d;
  private float e;
  private int f;
  private boolean g;
  private ImageView h;
  private final TextView i;
  private final TextView j;
  private int k = -1;
  private j l;
  private ColorStateList m;

  public a(Context paramContext)
  {
    this(paramContext, null);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    this.b = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    this.h = ((ImageView)findViewById(R.id.icon));
    this.i = ((TextView)findViewById(R.id.smallLabel));
    this.j = ((TextView)findViewById(R.id.largeLabel));
    ViewCompat.setImportantForAccessibility(this.i, 2);
    ViewCompat.setImportantForAccessibility(this.j, 2);
    setFocusable(true);
    a(this.i.getTextSize(), this.j.getTextSize());
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    this.c = (paramFloat1 - paramFloat2);
    this.d = (1.0F * paramFloat2 / paramFloat1);
    this.e = (1.0F * paramFloat1 / paramFloat2);
  }

  private void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }

  private void a(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }

  public void a(j paramj, int paramInt)
  {
    this.l = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    if (!TextUtils.isEmpty(paramj.getContentDescription()))
      setContentDescription(paramj.getContentDescription());
    TooltipCompat.setTooltipText(this, paramj.getTooltipText());
    if (paramj.isVisible());
    for (int n = 0; ; n = 8)
    {
      setVisibility(n);
      return;
    }
  }

  public boolean a()
  {
    return false;
  }

  public j getItemData()
  {
    return this.l;
  }

  public int getItemPosition()
  {
    return this.k;
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.l != null) && (this.l.isCheckable()) && (this.l.isChecked()))
      mergeDrawableStates(arrayOfInt, a);
    return arrayOfInt;
  }

  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }

  public void setChecked(boolean paramBoolean)
  {
    this.j.setPivotX(this.j.getWidth() / 2);
    this.j.setPivotY(this.j.getBaseline());
    this.i.setPivotX(this.i.getWidth() / 2);
    this.i.setPivotY(this.i.getBaseline());
    switch (this.f)
    {
    default:
    case -1:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      return;
      if (this.g)
      {
        if (paramBoolean)
        {
          a(this.h, this.b, 49);
          a(this.j, 1.0F, 1.0F, 0);
        }
        while (true)
        {
          this.i.setVisibility(4);
          break;
          a(this.h, this.b, 17);
          a(this.j, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        a(this.h, (int)(this.b + this.c), 49);
        a(this.j, 1.0F, 1.0F, 0);
        a(this.i, this.d, this.d, 4);
      }
      else
      {
        a(this.h, this.b, 49);
        a(this.j, this.e, this.e, 4);
        a(this.i, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          a(this.h, this.b, 49);
          a(this.j, 1.0F, 1.0F, 0);
        }
        while (true)
        {
          this.i.setVisibility(4);
          break;
          a(this.h, this.b, 17);
          a(this.j, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          a(this.h, (int)(this.b + this.c), 49);
          a(this.j, 1.0F, 1.0F, 0);
          a(this.i, this.d, this.d, 4);
        }
        else
        {
          a(this.h, this.b, 49);
          a(this.j, this.e, this.e, 4);
          a(this.i, 1.0F, 1.0F, 0);
          continue;
          a(this.h, this.b, 17);
          this.j.setVisibility(8);
          this.i.setVisibility(8);
        }
      }
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }

  public void setIcon(Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState;
    if (paramDrawable != null)
    {
      localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
        break label38;
    }
    while (true)
    {
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      DrawableCompat.setTintList(paramDrawable, this.m);
      this.h.setImageDrawable(paramDrawable);
      return;
      label38: paramDrawable = localConstantState.newDrawable();
    }
  }

  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.h.setLayoutParams(localLayoutParams);
  }

  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.m = paramColorStateList;
    if (this.l != null)
      setIcon(this.l.getIcon());
  }

  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0);
    for (Drawable localDrawable = null; ; localDrawable = ContextCompat.getDrawable(getContext(), paramInt))
    {
      setItemBackground(localDrawable);
      return;
    }
  }

  public void setItemBackground(Drawable paramDrawable)
  {
    ViewCompat.setBackground(this, paramDrawable);
  }

  public void setItemPosition(int paramInt)
  {
    this.k = paramInt;
  }

  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      if (this.l == null)
        break label38;
    }
    label38: for (int n = 1; ; n = 0)
    {
      if (n != 0)
        setChecked(this.l.isChecked());
      return;
    }
  }

  public void setShifting(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if (this.l == null)
        break label38;
    }
    label38: for (int n = 1; ; n = 0)
    {
      if (n != 0)
        setChecked(this.l.isChecked());
      return;
    }
  }

  public void setTextAppearanceActive(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.j, paramInt);
    a(this.i.getTextSize(), this.j.getTextSize());
  }

  public void setTextAppearanceInactive(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.i, paramInt);
    a(this.i.getTextSize(), this.j.getTextSize());
  }

  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.i.setTextColor(paramColorStateList);
      this.j.setTextColor(paramColorStateList);
    }
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.i.setText(paramCharSequence);
    this.j.setText(paramCharSequence);
    if ((this.l == null) || (TextUtils.isEmpty(this.l.getContentDescription())))
      setContentDescription(paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.a
 * JD-Core Version:    0.6.2
 */