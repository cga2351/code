package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.my.target.b.c.a.f;
import com.my.target.b.c.a.i;
import com.my.target.common.a.b;
import java.util.HashMap;
import java.util.List;

public final class dl extends ViewGroup
  implements View.OnTouchListener, dd
{
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private static final int g = bj.a();
  private static final int h = bj.a();
  private final TextView i;
  private final TextView j;
  private final TextView k;
  private final av l;
  private final bj m;
  private final ax n;
  private final dk o;
  private final HashMap<View, Boolean> p;
  private final Button q;
  private final int r;
  private final int s;
  private final int t;
  private final boolean u;
  private final double v;
  private dd.a w;

  public dl(Context paramContext)
  {
    super(paramContext);
    bj.a(this, -1, -3806472);
    boolean bool;
    double d1;
    if ((0xF & paramContext.getResources().getConfiguration().screenLayout) >= 3)
    {
      bool = true;
      this.u = bool;
      if (!this.u)
        break label738;
      d1 = 0.5D;
      label47: this.v = d1;
      this.l = new av(paramContext);
      this.m = bj.a(paramContext);
      this.i = new TextView(paramContext);
      this.j = new TextView(paramContext);
      this.k = new TextView(paramContext);
      this.n = new ax(paramContext);
      this.q = new Button(paramContext);
      this.o = new dk(paramContext);
      this.l.setId(b);
      this.l.setContentDescription("close");
      this.l.setVisibility(4);
      this.n.setId(c);
      this.n.setContentDescription("icon");
      this.i.setId(d);
      this.i.setLines(1);
      this.i.setEllipsize(TextUtils.TruncateAt.END);
      this.j.setId(g);
      this.j.setLines(1);
      this.j.setEllipsize(TextUtils.TruncateAt.END);
      this.k.setId(f);
      this.k.setTextColor(-16777216);
      this.q.setId(h);
      this.q.setPadding(this.m.c(15), this.m.c(10), this.m.c(15), this.m.c(10));
      this.q.setMinimumWidth(this.m.c(100));
      this.q.setMaxEms(12);
      this.q.setTransformationMethod(null);
      this.q.setSingleLine();
      this.q.setTextSize(18.0F);
      this.q.setEllipsize(TextUtils.TruncateAt.END);
      if (Build.VERSION.SDK_INT >= 21)
        this.q.setElevation(this.m.c(2));
      bj.a(this.q, -16733198, -16746839, this.m.c(2));
      this.q.setTextColor(-1);
      this.o.setId(e);
      this.o.setPadding(0, 0, 0, this.m.c(8));
      this.o.setSideSlidesMargins(this.m.c(10));
      if (!this.u)
        break label745;
      this.s = this.m.c(18);
      this.r = this.s;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager != null)
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.i.setTextSize(this.m.d(24));
      this.k.setTextSize(this.m.d(20));
      this.j.setTextSize(this.m.d(20));
      this.t = this.m.c(96);
      this.i.setTypeface(null, 1);
    }
    while (true)
    {
      bj.a(this, "ad_view");
      bj.a(this.i, "title_text");
      bj.a(this.k, "description_text");
      bj.a(this.n, "icon_image");
      bj.a(this.l, "close_button");
      bj.a(this.j, "category_text");
      addView(this.o);
      addView(this.n);
      addView(this.i);
      addView(this.j);
      addView(this.k);
      addView(this.l);
      addView(this.q);
      this.p = new HashMap();
      return;
      bool = false;
      break;
      label738: d1 = 0.7D;
      break label47;
      label745: this.r = this.m.c(12);
      this.s = this.m.c(10);
      this.i.setTextSize(22.0F);
      this.k.setTextSize(18.0F);
      this.j.setTextSize(18.0F);
      this.t = this.m.c(64);
    }
  }

  public final void f()
  {
    this.l.setVisibility(0);
  }

  public final View getCloseButton()
  {
    return this.l;
  }

  public final int[] getNumbersOfCurrentShowingCards()
  {
    int i1 = 0;
    int i2 = this.o.getCardLayoutManager().findFirstVisibleItemPosition();
    int i3 = this.o.getCardLayoutManager().findLastCompletelyVisibleItemPosition();
    int[] arrayOfInt;
    if ((i2 == -1) || (i3 == -1))
      arrayOfInt = new int[0];
    while (true)
    {
      return arrayOfInt;
      int i4 = 1 + (i3 - i2);
      arrayOfInt = new int[i4];
      while (i1 < i4)
      {
        int i5 = i2 + 1;
        arrayOfInt[i1] = i2;
        i1++;
        i2 = i5;
      }
    }
  }

  public final View getView()
  {
    return this;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    this.l.layout(paramInt3 - this.l.getMeasuredWidth(), paramInt2, paramInt3, paramInt2 + this.l.getMeasuredHeight());
    int i3;
    int i5;
    if ((i2 > i1) || (this.u))
    {
      i3 = this.l.getBottom();
      int i4 = this.o.getMeasuredHeight() + Math.max(this.i.getMeasuredHeight() + this.j.getMeasuredHeight(), this.n.getMeasuredHeight()) + this.k.getMeasuredHeight() + 2 * this.s;
      if (i4 >= i2)
        break label763;
      i5 = (i2 - i4) / 2;
      if (i5 <= i3)
        break label763;
    }
    while (true)
    {
      this.n.layout(paramInt1 + this.s, i5, paramInt1 + this.n.getMeasuredWidth() + this.s, i5 + (paramInt2 + this.n.getMeasuredHeight()));
      this.i.layout(this.n.getRight(), i5, this.n.getRight() + this.i.getMeasuredWidth(), i5 + this.i.getMeasuredHeight());
      this.j.layout(this.n.getRight(), this.i.getBottom(), this.n.getRight() + this.j.getMeasuredWidth(), this.i.getBottom() + this.j.getMeasuredHeight());
      int i6 = Math.max(Math.max(this.n.getBottom(), this.j.getBottom()), this.i.getBottom());
      this.k.layout(paramInt1 + this.s, i6, paramInt1 + this.s + this.k.getMeasuredWidth(), i6 + this.k.getMeasuredHeight());
      int i7 = Math.max(i6, this.k.getBottom()) + this.s;
      this.o.layout(paramInt1 + this.s, i7, paramInt3, i7 + this.o.getMeasuredHeight());
      dk localdk = this.o;
      if (!this.u);
      for (boolean bool = true; ; bool = false)
      {
        localdk.a(bool);
        return;
      }
      this.o.a(false);
      this.n.layout(this.s, paramInt4 - this.s - this.n.getMeasuredHeight(), this.s + this.n.getMeasuredWidth(), paramInt4 - this.s);
      int i8 = (Math.max(this.n.getMeasuredHeight(), this.q.getMeasuredHeight()) - this.i.getMeasuredHeight() - this.j.getMeasuredHeight()) / 2;
      if (i8 < 0)
        i8 = 0;
      this.j.layout(this.n.getRight(), paramInt4 - this.s - i8 - this.j.getMeasuredHeight(), this.n.getRight() + this.j.getMeasuredWidth(), paramInt4 - this.s - i8);
      this.i.layout(this.n.getRight(), this.j.getTop() - this.i.getMeasuredHeight(), this.n.getRight() + this.i.getMeasuredWidth(), this.j.getTop());
      int i9 = (Math.max(this.n.getMeasuredHeight(), this.i.getMeasuredHeight() + this.j.getMeasuredHeight()) - this.q.getMeasuredHeight()) / 2;
      if (i9 < 0)
        i9 = 0;
      this.q.layout(paramInt3 - this.s - this.q.getMeasuredWidth(), paramInt4 - this.s - i9 - this.q.getMeasuredHeight(), paramInt3 - this.s, paramInt4 - this.s - i9);
      this.o.layout(this.s, this.s, paramInt3, this.s + this.o.getMeasuredHeight());
      this.k.layout(0, 0, 0, 0);
      return;
      label763: i5 = i3;
    }
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.l.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
    this.n.measure(View.MeasureSpec.makeMeasureSpec(this.t, -2147483648), View.MeasureSpec.makeMeasureSpec(this.t, -2147483648));
    int i4;
    int i5;
    if ((i2 > i1) || (this.u))
    {
      this.q.setVisibility(8);
      int i3 = this.l.getMeasuredHeight();
      if (this.u)
        i3 = this.s;
      this.i.measure(View.MeasureSpec.makeMeasureSpec(i1 - 2 * this.s - this.n.getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.j.measure(View.MeasureSpec.makeMeasureSpec(i1 - 2 * this.s - this.n.getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.k.measure(View.MeasureSpec.makeMeasureSpec(i1 - 2 * this.s, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      i4 = i2 - i3 - Math.max(this.i.getMeasuredHeight() + this.j.getMeasuredHeight(), this.n.getMeasuredHeight() - 2 * this.s) - this.k.getMeasuredHeight();
      i5 = i1 - this.s;
      if ((i2 > i1) && (i4 / i2 > this.v))
        i4 = (int)(i2 * this.v);
      if (this.u)
        this.o.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - 2 * this.s, -2147483648));
    }
    while (true)
    {
      setMeasuredDimension(i1, i2);
      return;
      this.o.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - 2 * this.s, 1073741824));
      continue;
      this.q.setVisibility(0);
      this.q.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      int i6 = this.q.getMeasuredWidth();
      if (i6 > i1 / 2 - 2 * this.s)
        this.q.measure(View.MeasureSpec.makeMeasureSpec(i1 / 2 - 2 * this.s, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.i.measure(View.MeasureSpec.makeMeasureSpec(i1 - this.n.getMeasuredWidth() - i6 - this.r - this.s, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.j.measure(View.MeasureSpec.makeMeasureSpec(i1 - this.n.getMeasuredWidth() - i6 - this.r - this.s, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.o.measure(View.MeasureSpec.makeMeasureSpec(i1 - this.s, -2147483648), View.MeasureSpec.makeMeasureSpec(i2 - Math.max(this.n.getMeasuredHeight(), Math.max(this.q.getMeasuredHeight(), this.i.getMeasuredHeight() + this.j.getMeasuredHeight())) - 2 * this.s - this.o.getPaddingBottom() - this.o.getPaddingTop(), -2147483648));
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.p.containsKey(paramView))
      return false;
    if (!((Boolean)this.p.get(paramView)).booleanValue())
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
      if (this.w != null)
      {
        this.w.a();
        continue;
        setBackgroundColor(-1);
      }
    }
  }

  public final void setBanner(i parami)
  {
    b localb1 = parami.D();
    if ((localb1 != null) && (localb1.f() != null))
    {
      this.l.a(localb1.f(), true);
      this.q.setText(parami.d());
      b localb2 = parami.j();
      if (localb2 != null)
      {
        this.n.setPlaceholderHeight(localb2.c());
        this.n.setPlaceholderWidth(localb2.b());
        be.a(localb2, this.n);
      }
      this.i.setTextColor(-16777216);
      this.i.setText(parami.p());
      String str1 = parami.c();
      String str2 = parami.o();
      String str3 = "";
      if (!TextUtils.isEmpty(str1))
        str3 = str3 + str1;
      if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str2)))
        str3 = str3 + ", ";
      if (!TextUtils.isEmpty(str2))
        str3 = str3 + str2;
      if (TextUtils.isEmpty(str3))
        break label300;
      this.j.setText(str3);
      this.j.setVisibility(0);
    }
    while (true)
    {
      this.k.setText(parami.f());
      List localList = parami.P();
      this.o.a(localList);
      return;
      Bitmap localBitmap = ap.a(this.m.c(28));
      if (localBitmap == null)
        break;
      this.l.a(localBitmap, false);
      break;
      label300: this.j.setVisibility(8);
    }
  }

  public final void setCarouselListener(a parama)
  {
    this.o.setCarouselListener(parama);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void setClickArea(g paramg)
  {
    boolean bool = true;
    if (paramg.o)
    {
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (dl.a(dl.this) != null)
            dl.a(dl.this).a();
        }
      });
      bj.a(this, -1, -3806472);
      setClickable(bool);
      return;
    }
    this.i.setOnTouchListener(this);
    this.j.setOnTouchListener(this);
    this.n.setOnTouchListener(this);
    this.k.setOnTouchListener(this);
    this.q.setOnTouchListener(this);
    setOnTouchListener(this);
    this.p.put(this.i, Boolean.valueOf(paramg.c));
    this.p.put(this.j, Boolean.valueOf(paramg.m));
    this.p.put(this.n, Boolean.valueOf(paramg.e));
    this.p.put(this.k, Boolean.valueOf(paramg.d));
    HashMap localHashMap = this.p;
    Button localButton = this.q;
    if ((paramg.n) || (paramg.i));
    while (true)
    {
      localHashMap.put(localButton, Boolean.valueOf(bool));
      this.p.put(this, Boolean.valueOf(paramg.n));
      return;
      bool = false;
    }
  }

  public final void setInterstitialPromoViewListener(dd.a parama)
  {
    this.w = parama;
  }

  public static abstract interface a
  {
    public abstract void a(f paramf);

    public abstract void a(List<f> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dl
 * JD-Core Version:    0.6.2
 */