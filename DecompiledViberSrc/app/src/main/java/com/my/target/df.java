package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.my.target.b.c.a.i;
import com.my.target.common.a.c;

@SuppressLint({"ViewConstructor"})
public final class df extends ViewGroup
{
  private final ax a;
  private final bj b;
  private final boolean c;
  private final av d;
  private final b e;
  private final dm f;
  private final FrameLayout g;
  private final ProgressBar h;
  private final boolean i;
  private bn j;
  private c k;
  private a l;
  private int m;
  private int n;
  private Bitmap o;
  private boolean p = true;

  public df(Context paramContext, bj parambj, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.b = parambj;
    this.c = paramBoolean1;
    this.i = paramBoolean2;
    this.a = new ax(paramContext);
    this.d = new av(paramContext);
    this.h = new ProgressBar(paramContext, null, 16842874);
    this.g = new FrameLayout(paramContext);
    bj.a(this.g, 0, 868608760);
    this.f = new dm(paramContext);
    this.e = new b((byte)0);
  }

  private void b(i parami)
  {
    this.g.setVisibility(0);
    setOnClickListener(null);
    this.d.setVisibility(8);
    com.my.target.common.a.b localb = parami.l();
    if ((localb != null) && (localb.f() != null))
    {
      this.n = localb.b();
      this.m = localb.c();
      if ((this.n == 0) || (this.m == 0))
      {
        this.n = localb.f().getWidth();
        this.m = localb.f().getHeight();
      }
      this.a.setImageBitmap(localb.f());
      this.a.setClickable(false);
    }
  }

  public final void a()
  {
    bj.a(this.d, "play_button");
    bj.a(this.a, "media_image");
    bj.a(this.f, "video_texture");
    this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.a.setAdjustViewBounds(true);
    addView(this.f);
    this.h.setVisibility(8);
    addView(this.a);
    addView(this.h);
    addView(this.d);
    addView(this.g);
  }

  public final void a(int paramInt)
  {
    if (this.j != null);
    switch (paramInt)
    {
    default:
      this.j.g();
      return;
    case 1:
      this.j.e();
      return;
    case 0:
    }
    this.j.f();
  }

  public final void a(i parami)
  {
    b(parami);
  }

  final void a(i parami, int paramInt)
  {
    if (parami.I() != null)
    {
      this.g.setVisibility(8);
      k localk = parami.I();
      if (localk != null)
      {
        this.k = ((c)localk.F());
        if (this.k != null)
        {
          if ((!this.i) || (!bf.a()))
            break label171;
          this.j = bo.a(getContext());
          this.j.a(this.l);
          this.n = this.k.b();
          this.m = this.k.c();
          com.my.target.common.a.b localb1 = localk.M();
          if (localb1 == null)
            break label181;
          this.o = localb1.f();
          this.a.setImageBitmap(this.o);
        }
      }
      while (true)
      {
        if (paramInt != 1)
        {
          com.my.target.common.a.b localb3 = parami.J();
          if ((localb3 == null) || (localb3.f() == null))
            break label215;
          this.d.a(localb3.f(), true);
        }
        return;
        label171: this.j = dn.k();
        break;
        label181: com.my.target.common.a.b localb2 = parami.l();
        if (localb2 != null)
        {
          this.o = localb2.f();
          this.a.setImageBitmap(this.o);
        }
      }
      label215: if (this.c);
      for (int i1 = this.b.c(140); ; i1 = this.b.c(96))
      {
        this.d.a(com.my.target.b.e.b.c(i1), false);
        return;
      }
    }
    b(parami);
  }

  final void a(boolean paramBoolean)
  {
    if (this.j != null)
      this.j.d();
    this.a.setVisibility(0);
    this.a.setImageBitmap(this.o);
    this.p = paramBoolean;
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      return;
    }
    this.a.setOnClickListener(null);
    this.d.setOnClickListener(null);
    setOnClickListener(null);
  }

  public final void b()
  {
    if (this.j != null)
      this.j.b();
    this.j = null;
  }

  public final void c()
  {
    this.a.setOnClickListener(this.e);
    this.d.setOnClickListener(this.e);
    setOnClickListener(this.e);
  }

  public final boolean d()
  {
    return (this.j != null) && (this.j.j());
  }

  public final boolean e()
  {
    return (this.j != null) && (this.j.c());
  }

  public final void f()
  {
    if (this.j != null)
    {
      if (this.k != null)
      {
        this.j.h();
        this.a.setVisibility(8);
      }
      this.d.setVisibility(8);
    }
  }

  public final void g()
  {
    if (this.j != null)
    {
      this.j.i();
      this.a.setVisibility(0);
      Bitmap localBitmap = this.f.getScreenShot();
      if ((localBitmap != null) && (this.j.a()))
        this.a.setImageBitmap(localBitmap);
      if (this.p)
        this.d.setVisibility(0);
    }
  }

  public final FrameLayout getClickableLayout()
  {
    return this.g;
  }

  public final bn getVideoPlayer()
  {
    return this.j;
  }

  public final void h()
  {
    this.a.setVisibility(8);
    this.h.setVisibility(8);
  }

  final void i()
  {
    this.d.setVisibility(8);
    this.h.setVisibility(0);
    if ((this.k != null) && (this.j != null))
    {
      this.j.a(this.l);
      this.j.a(this.k, this.f);
    }
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        int i2 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        int i4 = (paramInt3 - paramInt1 - i2) / 2;
        int i5 = (paramInt4 - paramInt2 - i3) / 2;
        localView.layout(i4, i5, i2 + i4, i3 + i5);
      }
    }
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if ((this.m == 0) || (this.n == 0))
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
      return;
    }
    int i7;
    int i5;
    int i8;
    int i6;
    if ((i3 == 0) && (i4 == 0))
    {
      i7 = this.m;
      i5 = this.n;
      i8 = -2147483648;
      i6 = -2147483648;
    }
    while (true)
    {
      if ((i7 == 0) || (i8 == 0))
        i7 = (int)(i5 / this.n * this.m);
      if ((i5 == 0) || (i6 == 0))
        i5 = (int)(i7 / this.m * this.n);
      float f1 = this.n / this.m;
      int i10;
      int i11;
      int i12;
      label194: View localView;
      if (i5 / f1 > i7)
      {
        int i14 = (int)(f1 * i7);
        int i15 = i7;
        i10 = i14;
        i11 = i15;
        i12 = 0;
        if (i12 >= getChildCount())
          break label306;
        localView = getChildAt(i12);
        if (localView.getVisibility() != 8)
          if ((localView != this.a) && (localView != this.g) && (localView != this.f))
            break label298;
      }
      label298: for (int i13 = 1073741824; ; i13 = -2147483648)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i10, i13), View.MeasureSpec.makeMeasureSpec(i11, i13));
        i12++;
        break label194;
        int i9 = (int)(i5 / f1);
        i10 = i5;
        i11 = i9;
        break;
      }
      label306: setMeasuredDimension(i10, i11);
      return;
      i5 = i2;
      i6 = i1;
      i7 = i4;
      i8 = i3;
    }
  }

  public final void setInterstitialPromoViewListener(a parama)
  {
    this.l = parama;
    if (this.j != null)
      this.j.a(parama);
  }

  public static abstract interface a extends AudioManager.OnAudioFocusChangeListener, bn.a
  {
    public abstract void a();

    public abstract void i();

    public abstract void j();
  }

  private final class b
    implements View.OnClickListener
  {
    private b()
    {
    }

    public final void onClick(View paramView)
    {
      if (df.a(df.this) == null)
        return;
      if ((!df.this.d()) && (!df.this.e()))
      {
        df.a(df.this).a();
        return;
      }
      if (!df.this.e())
      {
        df.a(df.this).i();
        return;
      }
      df.a(df.this).j();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.df
 * JD-Core Version:    0.6.2
 */