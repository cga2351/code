package com.my.target.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.ap;
import com.my.target.as;
import com.my.target.as.a;
import com.my.target.av;
import com.my.target.b.c.a.g;
import com.my.target.bj;
import com.my.target.common.a.b;
import com.my.target.dp;
import com.my.target.ec;

public final class f
  implements as.a, l
{
  private final as a;
  private final av b;
  private final FrameLayout c;
  private b d;
  private l.a e;
  private long f;
  private long g;
  private g h;

  private f(Context paramContext)
  {
    this.a = new as(paramContext);
    this.b = new av(paramContext);
    this.c = new FrameLayout(paramContext);
    this.b.setContentDescription("Close");
    bj.a(this.b, "close_button");
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams1.gravity = 8388613;
    this.b.setVisibility(8);
    this.b.setLayoutParams(localLayoutParams1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams2.gravity = 1;
    this.a.setLayoutParams(localLayoutParams2);
    this.c.addView(this.a);
    if (this.b.getParent() == null)
      this.c.addView(this.b);
    Bitmap localBitmap = ap.a(bj.a(paramContext).c(28));
    if (localBitmap != null)
      this.b.a(localBitmap, false);
  }

  public static f a(Context paramContext)
  {
    return new f(paramContext);
  }

  private void a(long paramLong)
  {
    this.a.removeCallbacks(this.d);
    this.f = System.currentTimeMillis();
    this.a.postDelayed(this.d, paramLong);
  }

  private void g()
  {
    if (this.e != null)
      this.e.a();
  }

  final l.a a()
  {
    return this.e;
  }

  public final void a(g paramg)
  {
    this.h = paramg;
    this.d = new b(this.b);
    this.a.setBannerWebViewListener(this);
    String str = paramg.I();
    if (str != null)
    {
      this.a.a(null, str);
      b localb = paramg.D();
      if (localb != null)
        this.b.a(localb.e(), false);
      this.b.setOnClickListener(new a(this));
      if (paramg.E() <= 0.0F)
        break label160;
      dp.a("banner will be allowed to close in " + paramg.E() + " seconds");
      a(()(1000.0F * paramg.E()));
    }
    while (true)
    {
      if (this.e != null)
        this.e.a(paramg, this.c.getContext());
      return;
      g();
      return;
      label160: dp.a("banner is allowed to close");
      this.b.setVisibility(0);
    }
  }

  public final void a(l.a parama)
  {
    this.e = parama;
  }

  public final void a(ec paramec)
  {
  }

  public final void a(String paramString)
  {
    g();
  }

  public final void b(String paramString)
  {
    if (this.e != null)
      this.e.a(this.h, paramString, this.c.getContext());
  }

  public final void c()
  {
    if (this.f > 0L)
    {
      long l = System.currentTimeMillis() - this.f;
      if ((l > 0L) && (l < this.g))
        this.g -= l;
    }
    else
    {
      return;
    }
    this.g = 0L;
  }

  public final void e()
  {
    this.c.removeView(this.a);
    this.a.destroy();
  }

  public final View f()
  {
    return this.c;
  }

  public final void l_()
  {
  }

  public final void m_()
  {
    if (this.g > 0L)
      a(this.g);
  }

  private static final class a
    implements View.OnClickListener
  {
    private final f a;

    a(f paramf)
    {
      this.a = paramf;
    }

    public final void onClick(View paramView)
    {
      l.a locala = this.a.a();
      if (locala != null)
        locala.b();
    }
  }

  private static final class b
    implements Runnable
  {
    private final av a;

    b(av paramav)
    {
      this.a = paramav;
    }

    public final void run()
    {
      dp.a("banner became just closeable");
      this.a.setVisibility(0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.f
 * JD-Core Version:    0.6.2
 */