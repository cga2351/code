package com.viber.voip.stickers.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.BitmapBackedSvgView;
import com.viber.svg.jni.SvgOpenGLView;
import com.viber.svg.jni.SvgView;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.svg.jni.SvgViewCommon;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.x;
import com.viber.voip.util.dj;
import com.viber.voip.util.s;

public class StickerSvgContainer extends FrameLayout
  implements b.a
{
  private static final Logger d = ViberEnv.getLogger();
  int a = 0;
  a b;
  b c;
  private SvgViewCommon e;
  private int f;
  private int g;
  private Handler h = av.a(av.e.f);
  private c i;
  private b j = null;
  private Sticker k;
  private Sticker l;

  public StickerSvgContainer(Context paramContext)
  {
    super(paramContext);
  }

  public StickerSvgContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public StickerSvgContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((this.e instanceof BitmapBackedSvgView))
    {
      DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
      float f1 = (localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F / 1000000.0F;
      int m = (int)(paramInt1 / f1);
      int n = (int)(paramInt2 / f1);
      ((BitmapBackedSvgView)this.e).initBuffer(m, n);
      this.f = m;
      this.g = n;
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
  }

  private void j()
  {
    if (this.k == null);
    do
    {
      return;
      if (this.i == null)
        break;
    }
    while (this.i.b().id == this.k.id);
    c();
    this.l = null;
    a(this.k.getConversationWidth(), this.k.getConversationHeight());
    this.i = new c(this.k, new Runnable()
    {
      public void run()
      {
        if (StickerSvgContainer.this.a == 1)
          StickerSvgContainer.this.e();
      }
    });
    this.h.post(this.i);
  }

  private SvgViewCommon k()
  {
    switch (3.a[x.a.ordinal()])
    {
    default:
      return null;
    case 1:
    case 2:
    case 4:
    case 5:
      return l();
    case 3:
    }
    return new SvgOpenGLView(getContext());
  }

  private SvgViewCommon l()
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    float f1 = (localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F;
    if (f1 > 1000000.0F)
    {
      float f2 = f1 / 1000000.0F;
      if (f2 * f2 >= 2.0F)
        return new BitmapBackedSvgView(getContext());
      return new SvgView(getContext());
    }
    return new SvgView(getContext());
  }

  private void setClock(b paramb)
  {
    this.j = paramb;
    paramb.a(this);
    this.e.setClock(paramb);
  }

  public void a()
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        StickerSvgContainer.this.h();
      }
    });
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a != 2) && (this.a != 1))
    {
      this.a = 1;
      if ((this.b != null) && (paramBoolean1))
        this.b.onStartAnimation();
    }
    if (!i())
      j();
    do
    {
      do
      {
        return;
        if (paramBoolean2)
          setClock(new b(getMaxTime(), this));
        if (this.a != 2)
          break;
      }
      while (this.j == null);
      this.j.c();
      return;
      if ((this.b != null) && (paramBoolean1))
        this.b.onPlayAnimation();
    }
    while (this.c == null);
    this.c.a(this);
  }

  public void b()
  {
    if (this.e != null)
      removeView(this.e.asView());
    this.e = k();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.e.asView(), localLayoutParams);
  }

  public void c()
  {
    if (this.i != null)
    {
      this.i.a();
      this.h.removeCallbacks(this.i);
      this.i = null;
    }
  }

  public void d()
  {
    this.j = null;
    this.l = null;
    this.a = 0;
  }

  public void e()
  {
    a(true, true);
  }

  public boolean f()
  {
    if (this.a != 1)
      return false;
    if (this.j != null)
      this.j.c();
    this.a = 2;
    return true;
  }

  public boolean g()
  {
    if (this.a != 2)
      return false;
    if (i())
    {
      if (this.j != null)
        break label92;
      setClock(new b(getMaxTime(), this));
      if (this.b != null)
        this.b.onPlayAnimation();
      if (this.c != null)
        this.c.a(this);
    }
    while (true)
    {
      this.e.asView().invalidate();
      this.a = 1;
      return true;
      label92: this.j.d();
    }
  }

  public SvgViewBackend getBackend()
  {
    return this.e.getBackend();
  }

  public double getMaxTime()
  {
    return this.e.getBackend().getMaxTime();
  }

  public void h()
  {
    if (this.a == 0);
    do
    {
      return;
      if (this.j != null)
        this.j.b();
      c();
      invalidate();
      this.a = 0;
    }
    while (this.b == null);
    this.b.onStopAnimation();
  }

  public boolean i()
  {
    return (this.k != null) && (this.l != null) && (this.k.id == this.l.id);
  }

  public void setAnimationCallback(a parama)
  {
    this.b = parama;
  }

  public void setBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.e.setBackend(paramSvgViewBackend);
    setClock((b)paramSvgViewBackend.getClock());
  }

  public void setLoadedSticker(Sticker paramSticker)
  {
    this.l = paramSticker;
    this.j = null;
  }

  public void setShowCallback(b paramb)
  {
    this.c = paramb;
  }

  public void setSticker(Sticker paramSticker)
  {
    this.k = paramSticker;
    switch (3.a[x.a.ordinal()])
    {
    default:
      dj.a(this);
    case 3:
      return;
    case 1:
    case 2:
    }
    setLayerType(1, null);
  }

  public static abstract interface a
  {
    public abstract void onPlayAnimation();

    public abstract void onStartAnimation();

    public abstract void onStopAnimation();
  }

  public static abstract interface b
  {
    public abstract void a(StickerSvgContainer paramStickerSvgContainer);
  }

  class c extends s
  {
    Sticker a;

    public c(Sticker paramRunnable, Runnable arg3)
    {
      super();
      this.a = paramRunnable;
    }

    protected void ac_()
    {
      StickerSvgContainer.a(StickerSvgContainer.this).load(this.a.getOrigPath(), String.valueOf(this.a.id), x.b);
      this.c.post(new Runnable()
      {
        public void run()
        {
          StickerSvgContainer.this.setLoadedSticker(StickerSvgContainer.c.this.a);
          StickerSvgContainer.this.requestLayout();
        }
      });
    }

    public Sticker b()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.StickerSvgContainer
 * JD-Core Version:    0.6.2
 */