package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.my.target.b.c.a.i;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
public final class cy extends FrameLayout
  implements View.OnTouchListener
{
  private final TextView a;
  private final TextView b;
  private final TextView c;
  private final LinearLayout d;
  private final LinearLayout e;
  private final TextView f;
  private final ay g;
  private final TextView h;
  private final bj i;
  private final boolean j;
  private final HashMap<View, Boolean> k = new HashMap();
  private String l;
  private View.OnClickListener m;

  public cy(Context paramContext, bj parambj, boolean paramBoolean)
  {
    super(paramContext);
    this.a = new TextView(paramContext);
    this.b = new TextView(paramContext);
    this.c = new TextView(paramContext);
    this.d = new LinearLayout(paramContext);
    this.f = new TextView(paramContext);
    this.g = new ay(paramContext);
    this.h = new TextView(paramContext);
    this.e = new LinearLayout(paramContext);
    bj.a(this.a, "title_text");
    bj.a(this.c, "description_text");
    bj.a(this.f, "disclaimer_text");
    bj.a(this.g, "stars_view");
    bj.a(this.h, "votes_text");
    this.i = parambj;
    this.j = paramBoolean;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(g paramg, View.OnClickListener paramOnClickListener)
  {
    if (paramg.o)
    {
      setOnClickListener(paramOnClickListener);
      bj.a(this, -1, -3806472);
      return;
    }
    this.m = paramOnClickListener;
    this.a.setOnTouchListener(this);
    this.b.setOnTouchListener(this);
    this.c.setOnTouchListener(this);
    this.g.setOnTouchListener(this);
    this.h.setOnTouchListener(this);
    setOnTouchListener(this);
    this.k.put(this.a, Boolean.valueOf(paramg.c));
    if ("store".equals(this.l))
      this.k.put(this.b, Boolean.valueOf(paramg.m));
    while (true)
    {
      this.k.put(this.c, Boolean.valueOf(paramg.d));
      this.k.put(this.g, Boolean.valueOf(paramg.g));
      this.k.put(this.h, Boolean.valueOf(paramg.h));
      this.k.put(this, Boolean.valueOf(paramg.n));
      return;
      this.k.put(this.b, Boolean.valueOf(paramg.l));
    }
  }

  final void a(boolean paramBoolean)
  {
    this.e.setOrientation(1);
    this.e.setGravity(1);
    this.a.setGravity(1);
    this.a.setTextColor(-16777216);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams1.gravity = 1;
    localLayoutParams1.leftMargin = this.i.c(8);
    localLayoutParams1.rightMargin = this.i.c(8);
    this.a.setLayoutParams(localLayoutParams1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams2.gravity = 1;
    this.b.setLayoutParams(localLayoutParams2);
    this.b.setLines(1);
    this.b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.c.setGravity(1);
    this.c.setTextColor(-16777216);
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-2, -2);
    FrameLayout.LayoutParams localLayoutParams6;
    if (paramBoolean)
    {
      this.c.setTextSize(2, 12.0F);
      this.c.setLines(2);
      this.c.setEllipsize(TextUtils.TruncateAt.END);
      localLayoutParams3.topMargin = 0;
      localLayoutParams3.leftMargin = this.i.c(4);
      localLayoutParams3.rightMargin = this.i.c(4);
      localLayoutParams3.gravity = 1;
      this.c.setLayoutParams(localLayoutParams3);
      this.d.setOrientation(0);
      FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams4.gravity = 1;
      this.d.setLayoutParams(localLayoutParams4);
      FrameLayout.LayoutParams localLayoutParams5 = new FrameLayout.LayoutParams(this.i.c(73), this.i.c(12));
      localLayoutParams5.topMargin = this.i.c(4);
      localLayoutParams5.rightMargin = this.i.c(4);
      this.g.setLayoutParams(localLayoutParams5);
      this.h.setTextColor(-6710887);
      this.h.setTextSize(2, 14.0F);
      this.f.setTextColor(-6710887);
      this.f.setGravity(1);
      localLayoutParams6 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams6.gravity = 1;
      if (!paramBoolean)
        break label597;
      localLayoutParams6.leftMargin = this.i.c(4);
    }
    for (localLayoutParams6.rightMargin = this.i.c(4); ; localLayoutParams6.rightMargin = this.i.c(16))
    {
      localLayoutParams6.gravity = 1;
      this.f.setLayoutParams(localLayoutParams6);
      FrameLayout.LayoutParams localLayoutParams7 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams7.gravity = 17;
      addView(this.e, localLayoutParams7);
      this.e.addView(this.a);
      this.e.addView(this.b);
      this.e.addView(this.d);
      this.e.addView(this.c);
      this.e.addView(this.f);
      this.d.addView(this.g);
      this.d.addView(this.h);
      return;
      this.c.setTextSize(2, 16.0F);
      localLayoutParams3.topMargin = this.i.c(8);
      localLayoutParams3.leftMargin = this.i.c(16);
      localLayoutParams3.rightMargin = this.i.c(16);
      break;
      label597: localLayoutParams6.leftMargin = this.i.c(16);
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.k.containsKey(paramView))
      return false;
    if (!((Boolean)this.k.get(paramView)).booleanValue())
      return true;
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return true;
      setBackgroundColor(-3806472);
      continue;
      setBackgroundColor(-1);
      if (this.m != null)
      {
        this.m.onClick(paramView);
        continue;
        setBackgroundColor(-1);
      }
    }
  }

  public final void setBanner(i parami)
  {
    this.l = parami.m();
    this.a.setText(parami.p());
    this.c.setText(parami.f());
    this.g.setRating(parami.n());
    this.h.setText(String.valueOf(parami.t()));
    if ("store".equals(parami.m()))
    {
      bj.a(this.b, "category_text");
      String str1 = parami.c();
      String str2 = parami.o();
      String str3 = "";
      if (!TextUtils.isEmpty(str1))
        str3 = str3 + str1;
      if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str2)))
        str3 = str3 + ", ";
      if (!TextUtils.isEmpty(str2))
        str3 = str3 + str2;
      if (!TextUtils.isEmpty(str3))
      {
        this.b.setText(str3);
        this.b.setVisibility(0);
        this.d.setVisibility(0);
        this.d.setGravity(16);
        if (parami.n() <= 0.0F)
          break label365;
        this.g.setVisibility(0);
        if (parami.t() <= 0)
          break label353;
        this.h.setVisibility(0);
        label260: this.b.setTextColor(-3355444);
        label270: if (!TextUtils.isEmpty(parami.g()))
          break label438;
        this.f.setVisibility(8);
      }
    }
    while (true)
    {
      if (!this.j)
        break label460;
      this.a.setTextSize(2, 32.0F);
      this.c.setTextSize(2, 24.0F);
      this.f.setTextSize(2, 18.0F);
      this.b.setTextSize(2, 18.0F);
      return;
      this.b.setVisibility(8);
      break;
      label353: this.h.setVisibility(8);
      break label260;
      label365: this.g.setVisibility(8);
      this.h.setVisibility(8);
      break label260;
      bj.a(this.b, "domain_text");
      this.d.setVisibility(8);
      this.b.setText(parami.h());
      this.d.setVisibility(8);
      this.b.setTextColor(-16733198);
      break label270;
      label438: this.f.setVisibility(0);
      this.f.setText(parami.g());
    }
    label460: this.a.setTextSize(2, 20.0F);
    this.c.setTextSize(2, 16.0F);
    this.f.setTextSize(2, 14.0F);
    this.b.setTextSize(2, 16.0F);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cy
 * JD-Core Version:    0.6.2
 */