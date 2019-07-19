package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.my.target.b.c.a.i;

@SuppressLint({"ViewConstructor"})
public final class dg extends RelativeLayout
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private final cy e;
  private final Button f;
  private final at g;
  private final da h;
  private final bj i;
  private final boolean j;

  public dg(Context paramContext, bj parambj, boolean paramBoolean)
  {
    super(paramContext);
    this.i = parambj;
    this.j = paramBoolean;
    this.h = new da(paramContext, parambj, paramBoolean);
    bj.a(this.h, "footer_layout");
    this.e = new cy(paramContext, parambj, paramBoolean);
    bj.a(this.e, "body_layout");
    this.f = new Button(paramContext);
    bj.a(this.f, "cta_button");
    this.g = new at(paramContext);
    bj.a(this.g, "age_bordering");
  }

  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = Math.max(paramInt2, paramInt1) / 8;
    this.e.a(paramBoolean);
    this.h.a();
    View localView = new View(getContext());
    localView.setBackgroundColor(-5592406);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 1));
    this.h.setId(b);
    this.h.a(k, paramBoolean);
    this.f.setId(c);
    this.f.setPadding(this.i.c(15), 0, this.i.c(15), 0);
    this.f.setMinimumWidth(this.i.c(100));
    this.f.setTransformationMethod(null);
    this.f.setSingleLine();
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    this.g.setId(a);
    this.g.a(1, -7829368);
    this.g.setPadding(this.i.c(2), 0, 0, 0);
    this.g.setTextColor(-1118482);
    this.g.setMaxEms(5);
    this.g.a(1, -1118482, this.i.c(3));
    this.g.setBackgroundColor(1711276032);
    this.e.setId(d);
    RelativeLayout.LayoutParams localLayoutParams2;
    int m;
    label349: int n;
    label398: label425: RelativeLayout.LayoutParams localLayoutParams3;
    if (paramBoolean)
    {
      this.e.setPadding(this.i.c(4), this.i.c(4), this.i.c(4), this.i.c(4));
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams1.addRule(2, b);
      this.e.setLayoutParams(localLayoutParams1);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramBoolean)
        break label626;
      m = this.i.c(8);
      localLayoutParams2.setMargins(this.i.c(16), m, this.i.c(16), this.i.c(4));
      if (Build.VERSION.SDK_INT < 17)
        break label640;
      localLayoutParams2.addRule(21, -1);
      this.g.setLayoutParams(localLayoutParams2);
      if (!this.j)
        break label651;
      n = this.i.c(64);
      localLayoutParams3 = new RelativeLayout.LayoutParams(-2, n);
      localLayoutParams3.addRule(14, -1);
      localLayoutParams3.addRule(8, d);
      if (!paramBoolean)
        break label665;
    }
    label640: label651: label665: for (localLayoutParams3.bottomMargin = ((int)(-this.i.c(52) / 1.5D)); ; localLayoutParams3.bottomMargin = (-this.i.c(52) / 2))
    {
      this.f.setLayoutParams(localLayoutParams3);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, k);
      localLayoutParams4.addRule(12, -1);
      this.h.setLayoutParams(localLayoutParams4);
      addView(this.e);
      addView(localView);
      addView(this.g);
      addView(this.h);
      addView(this.f);
      setClickable(true);
      if (!this.j)
        break label685;
      this.f.setTextSize(2, 32.0F);
      return;
      this.e.setPadding(this.i.c(16), this.i.c(16), this.i.c(16), this.i.c(16));
      break;
      label626: m = this.i.c(16);
      break label349;
      localLayoutParams2.addRule(11, -1);
      break label398;
      n = this.i.c(52);
      break label425;
    }
    label685: this.f.setTextSize(2, 22.0F);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(final g paramg, final View.OnClickListener paramOnClickListener)
  {
    this.e.a(paramg, paramOnClickListener);
    if (paramg.o)
    {
      this.f.setOnClickListener(paramOnClickListener);
      return;
    }
    if (paramg.i)
    {
      this.f.setOnClickListener(paramOnClickListener);
      this.f.setEnabled(true);
    }
    while (true)
    {
      this.g.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (!paramg.j)
            return true;
          switch (paramAnonymousMotionEvent.getAction())
          {
          case 2:
          default:
            return true;
          case 0:
            dg.a(dg.this).setBackgroundColor(-3806472);
            return true;
          case 1:
            dg.a(dg.this).setBackgroundColor(-1);
            paramOnClickListener.onClick(paramAnonymousView);
            return true;
          case 3:
          }
          dg.this.setBackgroundColor(-1);
          return true;
        }
      });
      return;
      this.f.setOnClickListener(null);
      this.f.setEnabled(false);
    }
  }

  public final void setBanner(i parami)
  {
    this.e.setBanner(parami);
    this.h.setBanner(parami);
    this.f.setText(parami.d());
    this.h.setBackgroundColor(parami.L());
    if (TextUtils.isEmpty(parami.a()))
      this.g.setVisibility(8);
    while (true)
    {
      int k = parami.M();
      int m = parami.N();
      int n = parami.O();
      bj.a(this.f, k, m, this.i.c(2));
      this.f.setTextColor(n);
      return;
      this.g.setText(parami.a());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dg
 * JD-Core Version:    0.6.2
 */