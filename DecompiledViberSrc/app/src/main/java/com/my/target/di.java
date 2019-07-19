package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public final class di extends ViewGroup
  implements View.OnTouchListener
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private final ax g;
  private final TextView h;
  private final TextView i;
  private final Button j;
  private final bj k;
  private final ay l;
  private final TextView m;
  private final HashMap<View, Boolean> n = new HashMap();
  private final boolean o;
  private View.OnClickListener p;
  private int q;
  private int r;
  private int s;

  public di(boolean paramBoolean, Context paramContext)
  {
    super(paramContext);
    this.o = paramBoolean;
    this.k = bj.a(paramContext);
    this.g = new ax(paramContext);
    this.h = new TextView(paramContext);
    this.i = new TextView(paramContext);
    this.j = new Button(paramContext);
    this.l = new ay(paramContext);
    this.m = new TextView(paramContext);
    bj.a(this, 0, 0, -3355444, this.k.c(1), 0);
    this.r = this.k.c(2);
    this.s = this.k.c(12);
    this.g.setId(b);
    this.j.setId(a);
    this.j.setPadding(this.k.c(15), this.k.c(10), this.k.c(15), this.k.c(10));
    this.j.setMinimumWidth(this.k.c(100));
    this.j.setTransformationMethod(null);
    this.j.setSingleLine();
    if (this.o)
    {
      this.j.setTextSize(20.0F);
      this.j.setEllipsize(TextUtils.TruncateAt.END);
      if (Build.VERSION.SDK_INT >= 21)
        this.j.setElevation(this.k.c(2));
      this.q = this.k.c(12);
      bj.a(this.j, -16733198, -16746839, this.k.c(2));
      this.j.setTextColor(-1);
      this.h.setId(c);
      if (!this.o)
        break label622;
      this.h.setTextSize(20.0F);
      label353: this.h.setTextColor(-16777216);
      this.h.setTypeface(null, 1);
      this.h.setLines(1);
      this.h.setEllipsize(TextUtils.TruncateAt.END);
      this.i.setId(d);
      this.i.setTextColor(-7829368);
      this.i.setLines(2);
      if (!this.o)
        break label634;
      this.i.setTextSize(20.0F);
      label432: this.i.setEllipsize(TextUtils.TruncateAt.END);
      this.l.setId(e);
      if (!this.o)
        break label646;
      this.l.setStarSize(this.k.c(24));
    }
    while (true)
    {
      this.l.setStarsPadding(this.k.c(4));
      this.m.setId(f);
      bj.a(this, "card_view");
      bj.a(this.h, "card_title_text");
      bj.a(this.i, "card_description_text");
      bj.a(this.m, "card_domain_text");
      bj.a(this.j, "card_cta_button");
      bj.a(this.l, "card_stars_view");
      bj.a(this.g, "card_image");
      addView(this.g);
      addView(this.i);
      addView(this.h);
      addView(this.j);
      addView(this.l);
      addView(this.m);
      return;
      this.j.setTextSize(18.0F);
      break;
      label622: this.h.setTextSize(18.0F);
      break label353;
      label634: this.i.setTextSize(18.0F);
      break label432;
      label646: this.l.setStarSize(this.k.c(18));
    }
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(View.OnClickListener paramOnClickListener, g paramg)
  {
    this.p = paramOnClickListener;
    if ((paramOnClickListener == null) || (paramg == null))
    {
      super.setOnClickListener(null);
      this.j.setOnClickListener(null);
      return;
    }
    setOnTouchListener(this);
    this.g.setOnTouchListener(this);
    this.h.setOnTouchListener(this);
    this.i.setOnTouchListener(this);
    this.l.setOnTouchListener(this);
    this.m.setOnTouchListener(this);
    this.j.setOnTouchListener(this);
    HashMap localHashMap1 = this.n;
    ax localax = this.g;
    boolean bool1;
    boolean bool2;
    label143: boolean bool3;
    label184: boolean bool4;
    label226: boolean bool5;
    label268: HashMap localHashMap6;
    TextView localTextView3;
    if ((paramg.f) || (paramg.o))
    {
      bool1 = true;
      localHashMap1.put(localax, Boolean.valueOf(bool1));
      HashMap localHashMap2 = this.n;
      if ((!paramg.n) && (!paramg.o))
        break label379;
      bool2 = true;
      localHashMap2.put(this, Boolean.valueOf(bool2));
      HashMap localHashMap3 = this.n;
      TextView localTextView1 = this.h;
      if ((!paramg.c) && (!paramg.o))
        break label385;
      bool3 = true;
      localHashMap3.put(localTextView1, Boolean.valueOf(bool3));
      HashMap localHashMap4 = this.n;
      TextView localTextView2 = this.i;
      if ((!paramg.d) && (!paramg.o))
        break label391;
      bool4 = true;
      localHashMap4.put(localTextView2, Boolean.valueOf(bool4));
      HashMap localHashMap5 = this.n;
      ay localay = this.l;
      if ((!paramg.g) && (!paramg.o))
        break label397;
      bool5 = true;
      localHashMap5.put(localay, Boolean.valueOf(bool5));
      localHashMap6 = this.n;
      localTextView3 = this.m;
      if ((!paramg.l) && (!paramg.o))
        break label403;
    }
    label385: label391: label397: label403: for (boolean bool6 = true; ; bool6 = false)
    {
      localHashMap6.put(localTextView3, Boolean.valueOf(bool6));
      HashMap localHashMap7 = this.n;
      Button localButton = this.j;
      boolean bool7;
      if (!paramg.i)
      {
        boolean bool8 = paramg.o;
        bool7 = false;
        if (!bool8);
      }
      else
      {
        bool7 = true;
      }
      localHashMap7.put(localButton, Boolean.valueOf(bool7));
      return;
      bool1 = false;
      break;
      label379: bool2 = false;
      break label143;
      bool3 = false;
      break label184;
      bool4 = false;
      break label226;
      bool5 = false;
      break label268;
    }
  }

  public final Button getCtaButtonView()
  {
    return this.j;
  }

  public final TextView getDescriptionTextView()
  {
    return this.i;
  }

  public final TextView getDomainTextView()
  {
    return this.m;
  }

  public final ay getRatingView()
  {
    return this.l;
  }

  public final ax getSmartImageView()
  {
    return this.g;
  }

  public final TextView getTitleTextView()
  {
    return this.h;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1 - 2 * this.r;
    if ((!this.o) && (getResources().getConfiguration().orientation == 2));
    for (int i2 = 1; ; i2 = 0)
    {
      this.g.layout(0, 0, this.g.getMeasuredWidth(), this.g.getMeasuredHeight());
      if (i2 == 0)
        break;
      this.h.setTypeface(null, 1);
      this.h.layout(0, this.g.getBottom(), i1, this.g.getBottom() + this.h.getMeasuredHeight());
      bj.a(this, 0, 0);
      this.i.layout(0, 0, 0, 0);
      this.j.layout(0, 0, 0, 0);
      this.l.layout(0, 0, 0, 0);
      this.m.layout(0, 0, 0, 0);
      return;
    }
    this.h.setTypeface(null, 0);
    bj.a(this, 0, 0, -3355444, this.k.c(1), 0);
    this.h.layout(this.r + this.s, this.g.getBottom(), this.h.getMeasuredWidth() + this.r + this.s, this.g.getBottom() + this.h.getMeasuredHeight());
    this.i.layout(this.r + this.s, this.h.getBottom(), this.i.getMeasuredWidth() + this.r + this.s, this.h.getBottom() + this.i.getMeasuredHeight());
    int i3 = (i1 - this.j.getMeasuredWidth()) / 2;
    this.j.layout(i3, paramInt4 - this.j.getMeasuredHeight() - this.s, i3 + this.j.getMeasuredWidth(), paramInt4 - this.s);
    int i4 = (i1 - this.l.getMeasuredWidth()) / 2;
    this.l.layout(i4, this.j.getTop() - this.s - this.l.getMeasuredHeight(), i4 + this.l.getMeasuredWidth(), this.j.getTop() - this.s);
    int i5 = (i1 - this.m.getMeasuredWidth()) / 2;
    this.m.layout(i5, this.j.getTop() - this.m.getMeasuredHeight() - this.s, i5 + this.m.getMeasuredWidth(), this.j.getTop() - this.s);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3;
    if ((!this.o) && (getResources().getConfiguration().orientation == 2))
    {
      i3 = 1;
      if (i1 != 0)
        break label391;
    }
    label391: for (int i4 = 0; ; i4 = -2147483648)
    {
      int i5 = i2 - 2 * this.r;
      int i6 = i1 - 2 * this.r;
      if (i3 != 0)
      {
        this.h.measure(View.MeasureSpec.makeMeasureSpec(i1, i4), View.MeasureSpec.makeMeasureSpec(i5, -2147483648));
        this.i.measure(0, 0);
        this.l.measure(0, 0);
        this.m.measure(0, 0);
        this.j.measure(0, 0);
        label125: if (i3 == 0)
          break label335;
      }
      label335: for (int i7 = i2 - this.h.getMeasuredHeight() - this.r; ; i7 = i2 - this.j.getMeasuredHeight() - 2 * this.q - Math.max(this.l.getMeasuredHeight(), this.m.getMeasuredHeight()) - this.i.getMeasuredHeight() - this.h.getMeasuredHeight())
      {
        if (i7 > i1)
          i7 = i1;
        this.g.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        setMeasuredDimension(i7, i2);
        return;
        i3 = 0;
        break;
        this.h.measure(View.MeasureSpec.makeMeasureSpec(i6 - 2 * this.s, i4), View.MeasureSpec.makeMeasureSpec(i5, -2147483648));
        this.i.measure(View.MeasureSpec.makeMeasureSpec(i6 - 2 * this.s, i4), View.MeasureSpec.makeMeasureSpec(i5, -2147483648));
        this.l.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), View.MeasureSpec.makeMeasureSpec(i5, -2147483648));
        this.m.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), View.MeasureSpec.makeMeasureSpec(i5, -2147483648));
        this.j.measure(View.MeasureSpec.makeMeasureSpec(i6 - 2 * this.s, i4), View.MeasureSpec.makeMeasureSpec(i5 - 2 * this.s, -2147483648));
        break label125;
      }
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.n.containsKey(paramView))
      return false;
    boolean bool = ((Boolean)this.n.get(paramView)).booleanValue();
    paramView.setClickable(bool);
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
      if (bool)
        if (paramView == this.j)
        {
          this.j.setPressed(true);
        }
        else
        {
          setBackgroundColor(-3806472);
          continue;
          if (this.p != null)
            this.p.onClick(paramView);
          if (bool)
            if (paramView == this.j)
            {
              this.j.setPressed(false);
            }
            else
            {
              bj.a(this, 0, 0, -3355444, this.k.c(1), 0);
              continue;
              if (bool)
                if (paramView == this.j)
                  this.j.setPressed(false);
                else
                  bj.a(this, 0, 0, -3355444, this.k.c(1), 0);
            }
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.di
 * JD-Core Version:    0.6.2
 */