package com.viber.voip.ui.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

class c extends ConstraintLayout
{
  private ImageView g;
  private TextView h;
  private TextView i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private int o;
  private float p;
  private float q;
  private final Interpolator r = new AccelerateInterpolator();
  private final Interpolator s = new OvershootInterpolator();

  c(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.layout.view_bottom_navigation_item, this, true);
    this.g = ((ImageView)findViewById(R.id.bottomBarItemIcon));
    this.h = ((TextView)findViewById(R.id.bottomBarItemTitle));
    this.i = ((TextView)findViewById(R.id.bottomBarItemBadge));
    this.i.setScaleX(0.0F);
    this.i.setScaleY(0.0F);
    this.i.setAlpha(0.0F);
    Resources localResources = paramContext.getResources();
    this.p = localResources.getDimensionPixelSize(R.dimen.bottom_navigation_text_size_active);
    this.q = localResources.getDimensionPixelSize(R.dimen.bottom_navigation_text_size_inactive);
    this.n = localResources.getDimensionPixelSize(R.dimen.bottom_navigation_margin_top_active);
    this.o = localResources.getDimensionPixelSize(R.dimen.bottom_navigation_margin_top_inactive);
  }

  void a(float paramFloat)
  {
    this.i.setTextSize(0, paramFloat);
  }

  void a(Drawable paramDrawable)
  {
    this.g.setImageDrawable(paramDrawable);
  }

  void a(CharSequence paramCharSequence)
  {
    this.h.setText(paramCharSequence);
  }

  void a(boolean paramBoolean)
  {
    if (paramBoolean == this.k)
      return;
    this.k = paramBoolean;
    int i1;
    label26: float f;
    if (this.k)
    {
      i1 = this.n;
      if (!this.k)
        break label143;
      f = this.p;
      label38: if (!this.k)
        break label151;
    }
    label143: label151: for (int i2 = this.l; ; i2 = this.m)
    {
      this.h.setTextColor(i2);
      this.g.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
      this.h.setTextSize(0, f);
      if (!(this.g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        break;
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, i1, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
      this.g.requestLayout();
      return;
      i1 = this.o;
      break label26;
      f = this.q;
      break label38;
    }
  }

  void b(int paramInt)
  {
    this.l = paramInt;
    if (this.k)
    {
      this.h.setTextColor(paramInt);
      this.g.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    }
  }

  void b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    if (!bool)
      this.i.setText(paramString);
    if ((this.j) && (!bool))
      return;
    if (!bool)
    {
      this.j = true;
      this.i.setScaleX(0.0F);
      this.i.setScaleY(0.0F);
      this.i.setAlpha(0.0F);
      this.i.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(150L).setInterpolator(this.s);
      return;
    }
    this.j = false;
    this.i.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setDuration(150L).setInterpolator(this.r);
  }

  boolean b()
  {
    return this.k;
  }

  void c(int paramInt)
  {
    this.m = paramInt;
    if (!this.k)
    {
      this.h.setTextColor(paramInt);
      this.g.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    }
  }

  void d(int paramInt)
  {
    this.i.setTextColor(paramInt);
  }

  void e(int paramInt)
  {
    this.i.setBackgroundResource(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.bottomnavigation.c
 * JD-Core Version:    0.6.2
 */