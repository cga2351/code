package com.viber.common.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.viber.common.R.color;
import com.viber.common.R.dimen;
import java.lang.ref.WeakReference;

public class c
{
  private int A = -1;
  private final int[] B = new int[2];
  private final int[] C = new int[2];
  private final Point D = new Point();
  private final Point E = new Point();
  private final Point F = new Point();
  private final Runnable G = new Runnable()
  {
    public void run()
    {
      c.this.b();
    }
  };
  private final PopupWindow.OnDismissListener H = new PopupWindow.OnDismissListener()
  {
    public void onDismiss()
    {
      c.b(c.this).removeCallbacks(c.a(c.this));
      c.c(c.this);
      if (c.this.u != null)
        c.this.u.a();
    }
  };
  long a;
  int b;
  boolean c;
  boolean d;
  d e;
  int f;
  int g;
  int h;
  boolean i;
  boolean j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  CharSequence r;
  View s;
  a t;
  c u;
  int v;
  private final WeakReference<Activity> w;
  private final Handler x;
  private boolean y;
  private PopupWindow z;

  c(Activity paramActivity)
  {
    this.w = new WeakReference(paramActivity);
    this.x = new Handler();
  }

  private CharSequence a(CharSequence paramCharSequence)
  {
    int i1 = 0;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, paramCharSequence.length(), URLSpan.class);
    int i2 = arrayOfURLSpan.length;
    while (i1 < i2)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i1];
      int i3 = localSpannableStringBuilder.getSpanStart(localURLSpan);
      int i4 = localSpannableStringBuilder.getSpanEnd(localURLSpan);
      int i5 = localSpannableStringBuilder.getSpanFlags(localURLSpan);
      localSpannableStringBuilder.setSpan(new Tooltip.3(this, localURLSpan.getURL()), i3, i4, i5);
      localSpannableStringBuilder.removeSpan(localURLSpan);
      i1++;
    }
    return localSpannableStringBuilder;
  }

  private void a(Point paramPoint, TooltipView paramTooltipView)
  {
    if (!ViewCompat.isAttachedToWindow(this.s))
      return;
    this.z = new PopupWindow(paramTooltipView, paramTooltipView.getMeasuredWidth(), -2);
    PopupWindow localPopupWindow1 = this.z;
    boolean bool;
    int i1;
    label119: Handler localHandler;
    Runnable localRunnable;
    if ((0x1 & this.b) != 0)
    {
      bool = true;
      localPopupWindow1.setOutsideTouchable(bool);
      this.z.setTouchable(true);
      this.z.setFocusable(false);
      this.z.setClippingEnabled(false);
      this.z.setOnDismissListener(this.H);
      this.z.setBackgroundDrawable(new ColorDrawable(0));
      PopupWindow localPopupWindow2 = this.z;
      if (!this.c)
        break label214;
      i1 = 16973826;
      localPopupWindow2.setAnimationStyle(i1);
      this.z.showAtLocation(this.s, 0, paramPoint.x, paramPoint.y);
      if ((0x2 & this.b) != 0)
      {
        localHandler = this.x;
        localRunnable = this.G;
        if (this.a <= 0L)
          break label220;
      }
    }
    label214: label220: for (long l1 = this.a; ; l1 = 1000L)
    {
      localHandler.postDelayed(localRunnable, l1);
      this.z.setTouchInterceptor(new d(this));
      return;
      bool = false;
      break;
      i1 = 0;
      break label119;
    }
  }

  private void a(TooltipView paramTooltipView, Activity paramActivity)
  {
    int i1 = paramTooltipView.getMeasuredWidth();
    int i2 = paramTooltipView.getMeasuredHeight();
    if ((i1 == 0) && (i2 == 0))
    {
      paramTooltipView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i1 = paramTooltipView.getMeasuredWidth();
      i2 = paramTooltipView.getMeasuredHeight();
    }
    int i3 = paramActivity.getResources().getDimensionPixelOffset(R.dimen.vc__tooltip_horizontal_margin);
    this.s.getLocationInWindow(this.B);
    View localView;
    switch (3.a[this.t.ordinal()])
    {
    default:
      this.D.set(this.B[0] + Math.round(this.s.getWidth() / 2.0F), this.B[1] - this.k);
      this.F.set(this.D.x - Math.round(i1 / 2.0F), this.D.y - i2);
      Point localPoint1 = this.F;
      localPoint1.x += this.l;
      Point localPoint2 = this.F;
      localPoint2.y += this.m;
      Point localPoint3 = this.D;
      localPoint3.x += this.l;
      Point localPoint4 = this.D;
      localPoint4.y += this.m;
      localView = paramActivity.getWindow().getDecorView().findViewById(16908290);
      if (this.A == -1)
        if (this.F.x < i3)
        {
          this.F.x = i3;
          label302: this.A = (this.D.x - this.F.x);
        }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.E.set(this.D.x, this.D.y);
      this.s.getLocationOnScreen(this.C);
      Point localPoint5 = this.E;
      localPoint5.x += this.C[0] - this.B[0];
      Point localPoint6 = this.E;
      localPoint6.y += this.C[1] - this.B[1];
      return;
      this.D.set(this.B[0] - this.k, this.B[1] + Math.round(this.s.getHeight() / 2.0F));
      this.F.set(this.D.x - i1, this.D.y - Math.round(i2 / 2.0F));
      break;
      this.D.set(this.B[0] + this.s.getWidth() + this.k, this.B[1] + Math.round(this.s.getHeight() / 2.0F));
      this.F.set(this.D.x, this.D.y - Math.round(i2 / 2.0F));
      break;
      this.D.set(this.B[0] + Math.round(this.s.getWidth() / 2.0F), this.B[1] + this.s.getHeight() + this.k);
      this.F.set(this.D.x - Math.round(i1 / 2.0F), this.D.y);
      break;
      if (i1 + this.F.x <= localView.getWidth() - i3)
        break label302;
      this.F.x = (localView.getWidth() - i1 - i3);
      break label302;
      if ((this.t == a.a) || (this.t == a.b))
        this.F.x = (this.D.x - this.A);
    }
  }

  private void e()
  {
    int[] arrayOfInt1 = this.B;
    this.B[1] = 0;
    arrayOfInt1[0] = 0;
    int[] arrayOfInt2 = this.C;
    this.C[1] = 0;
    arrayOfInt2[0] = 0;
    this.D.set(0, 0);
    this.E.set(0, 0);
    this.F.set(0, 0);
    this.A = -1;
    this.z = null;
  }

  public void a()
  {
    Activity localActivity = (Activity)this.w.get();
    if ((localActivity == null) || (d()))
      return;
    this.x.removeCallbacks(this.G);
    TooltipView localTooltipView = new TooltipView(localActivity);
    localTooltipView.a(this.t);
    localTooltipView.a(this.f);
    localTooltipView.setTextColor(this.g);
    localTooltipView.setLinkTextColor(this.h);
    localTooltipView.setText(this.r);
    localTooltipView.setGravity(this.v);
    localTooltipView.a(this.d);
    localTooltipView.a(this.e);
    localTooltipView.setPadding(this.n, this.o, this.n, this.p);
    localTooltipView.setMaxWidth(this.q);
    if (this.i)
    {
      if (this.j)
        localTooltipView.setText(a(this.r));
      localTooltipView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    a(localTooltipView, localActivity);
    localTooltipView.a(this.E);
    a(this.F, localTooltipView);
  }

  public void b()
  {
    if (!d())
      return;
    try
    {
      this.z.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  public void c()
  {
    Activity localActivity = (Activity)this.w.get();
    if ((localActivity == null) || (!d()))
      return;
    TooltipView localTooltipView = (TooltipView)this.z.getContentView();
    if (this.y)
      this.A = -1;
    a(localTooltipView, localActivity);
    localTooltipView.a(this.E);
    this.z.update(this.F.x, this.F.y, -1, -1, true);
    this.z.getContentView().invalidate();
  }

  public boolean d()
  {
    return this.z != null;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }

  public static class b
  {
    private long a;
    private int b = 0;
    private boolean c;
    private View d;
    private CharSequence e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = 0;
    private int q = 0;
    private c.a r = c.a.a;
    private boolean s = true;
    private c.d t;
    private int u = 8388659;
    private c.c v;
    private boolean w = false;

    public b a(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public b a(long paramLong)
    {
      this.a = paramLong;
      this.b = (0x2 | this.b);
      return this;
    }

    public b a(View paramView)
    {
      this.d = paramView;
      return this;
    }

    public b a(c.a parama)
    {
      this.r = parama;
      return this;
    }

    public b a(c.c paramc)
    {
      this.v = paramc;
      return this;
    }

    public b a(c.d paramd)
    {
      this.t = paramd;
      return this;
    }

    public b a(CharSequence paramCharSequence)
    {
      this.f = 0;
      this.e = paramCharSequence;
      return this;
    }

    public b a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }

    public c a(Context paramContext)
    {
      if (this.d == null)
        throw new IllegalArgumentException("Tooltip must be attached to the anchor view");
      if (!(paramContext instanceof Activity))
        throw new IllegalArgumentException("Tooltip must be attached to activity context");
      c localc = new c((Activity)paramContext);
      localc.a = this.a;
      localc.b = this.b;
      localc.t = this.r;
      localc.s = this.d;
      CharSequence localCharSequence;
      int i1;
      label112: int i2;
      label131: Resources localResources;
      int i3;
      label192: int i4;
      label228: int i5;
      label248: int i6;
      if (this.f > 0)
      {
        localCharSequence = paramContext.getText(this.f);
        localc.r = localCharSequence;
        if (this.g == 0)
          break label345;
        i1 = this.g;
        localc.f = i1;
        if (this.h == 0)
          break label357;
        i2 = this.h;
        localc.g = i2;
        localc.h = ContextCompat.getColor(paramContext, R.color.vc__tooltip_text);
        localc.i = this.i;
        localc.j = this.j;
        localc.c = this.c;
        localResources = paramContext.getResources();
        if (this.o == -1)
          break label369;
        i3 = this.o;
        localc.k = i3;
        localc.l = this.p;
        localc.m = this.q;
        if (this.k == -1)
          break label382;
        i4 = this.k;
        localc.n = i4;
        if (this.l == -1)
          break label395;
        i5 = this.l;
        localc.o = i5;
        if (this.m == -1)
          break label408;
        i6 = this.m;
        label268: localc.p = i6;
        if (this.n == -1)
          break label421;
      }
      label395: label408: label421: for (int i7 = this.n; ; i7 = localResources.getDimensionPixelSize(R.dimen.vc__tooltip_max_width))
      {
        localc.q = i7;
        localc.d = this.s;
        localc.e = this.t;
        localc.u = this.v;
        localc.v = this.u;
        c.a(localc, this.w);
        return localc;
        localCharSequence = this.e;
        break;
        label345: i1 = ContextCompat.getColor(paramContext, R.color.vc__tooltip_background);
        break label112;
        label357: i2 = ContextCompat.getColor(paramContext, R.color.vc__tooltip_text);
        break label131;
        label369: i3 = localResources.getDimensionPixelOffset(R.dimen.vc__tooltip_offset);
        break label192;
        label382: i4 = localResources.getDimensionPixelOffset(R.dimen.vc__tooltip_horizontal_padding);
        break label228;
        i5 = localResources.getDimensionPixelOffset(R.dimen.vc__tooltip_vertical_padding);
        break label248;
        i6 = localResources.getDimensionPixelOffset(R.dimen.vc__tooltip_vertical_padding);
        break label268;
      }
    }

    public b b(int paramInt)
    {
      this.b = (paramInt | this.b);
      return this;
    }

    public b b(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }

    public b c(int paramInt)
    {
      this.e = null;
      this.f = paramInt;
      return this;
    }

    public b c(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }

    public b d(int paramInt)
    {
      this.g = paramInt;
      return this;
    }

    public b d(boolean paramBoolean)
    {
      this.s = paramBoolean;
      return this;
    }

    public b e(int paramInt)
    {
      this.p = paramInt;
      return this;
    }

    public b f(int paramInt)
    {
      this.o = paramInt;
      return this;
    }

    public b g(int paramInt)
    {
      this.k = paramInt;
      return this;
    }

    public b h(int paramInt)
    {
      this.l = paramInt;
      this.m = paramInt;
      return this;
    }

    public b i(int paramInt)
    {
      this.n = paramInt;
      return this;
    }
  }

  public static abstract interface c
  {
    public abstract void a();
  }

  public static enum d
  {
    final float c;

    static
    {
      d[] arrayOfd = new d[2];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
    }

    private d(float paramFloat)
    {
      this.c = paramFloat;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.c
 * JD-Core Version:    0.6.2
 */