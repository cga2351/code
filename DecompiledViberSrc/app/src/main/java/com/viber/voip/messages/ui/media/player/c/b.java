package com.viber.voip.messages.ui.media.player.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec.a;
import com.viber.voip.messages.ui.media.player.MediaPlayer.a;
import com.viber.voip.util.da;
import com.viber.voip.util.e.f;

public abstract class b<V extends View> extends FrameLayout
  implements MediaPlayer
{
  private static final com.viber.common.a.e c = ViberEnv.getLogger();
  private int d = 0;
  private View e;
  protected MediaPlayer.a g = a;
  protected V h;
  protected View i;
  protected String j;
  protected String k;
  protected int l;
  protected ImageView.ScaleType m = ImageView.ScaleType.FIT_CENTER;
  protected boolean n = true;
  protected long o = 0L;
  protected long p = 0L;
  protected c q = new c();
  protected int r = 0;
  protected boolean s;
  protected String t;
  protected com.viber.voip.util.e.e u;
  protected f v;
  protected Handler w;
  protected boolean x = true;
  protected int y = 0;

  public b(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.d == paramInt));
    do
    {
      do
      {
        do
          return;
        while (!f(paramInt));
        this.d = paramInt;
        if ((paramInt == 0) && (this.x))
        {
          h();
          return;
        }
        int i1 = a(paramInt);
        if (i1 <= 0)
        {
          h();
          return;
        }
        if ((this.e == null) || (!Integer.valueOf(i1).equals(this.e.getTag())))
        {
          h();
          this.e = inflate(getContext(), i1, null);
          this.e.setTag(Integer.valueOf(i1));
        }
      }
      while (this.e == null);
      a(this.e, paramInt);
    }
    while (this.e.getParent() != null);
    addView(this.e);
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (this.i == null);
    Rect localRect;
    do
    {
      return;
      localRect = new Rect();
      this.i.getHitRect(localRect);
    }
    while (!localRect.contains(paramInt1, paramInt2));
    this.g.c(this);
  }

  private void g()
  {
    if (this.x);
    for (float f = 1.0F; ; f = 0.0F)
    {
      if ((this.h != null) && (f != this.h.getAlpha()))
        this.h.setAlpha(f);
      return;
    }
  }

  private void h()
  {
    if (this.e != null)
    {
      removeView(this.e);
      this.e = null;
    }
  }

  protected int a(int paramInt)
  {
    return 0;
  }

  public void a()
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      setLayoutParams(localLayoutParams);
    }
  }

  public void a(long paramLong)
  {
  }

  protected void a(Context paramContext)
  {
    this.h = c(paramContext);
    l();
    m();
    n();
  }

  protected void a(View paramView, int paramInt)
  {
  }

  protected void a(b<V>.a paramb)
  {
    a(paramb, 0L);
  }

  protected void a(b<V>.a paramb, long paramLong)
  {
    if (paramLong > 0L)
    {
      this.w.postDelayed(paramb, paramLong);
      return;
    }
    this.w.post(paramb);
  }

  public void b()
  {
  }

  protected void b(Context paramContext)
  {
    this.w = av.e.a.a();
    this.u = com.viber.voip.util.e.e.a(paramContext);
    this.v = f.a();
    if (this.h == null)
      a(paramContext);
  }

  protected void b(b<V>.a paramb)
  {
    this.w.removeCallbacks(paramb);
  }

  protected abstract V c(Context paramContext);

  public boolean c()
  {
    return (4 == this.r) || (3 == this.r);
  }

  protected final void d(int paramInt)
  {
    a(paramInt, false);
  }

  public boolean d()
  {
    return 5 == this.r;
  }

  protected void e()
  {
    setState(0);
    if (this.h != null)
      f();
  }

  protected final void e(int paramInt)
  {
    a(paramInt, true);
  }

  protected void f()
  {
    this.h = null;
  }

  protected boolean f(int paramInt)
  {
    return true;
  }

  public String getActionReplyData()
  {
    return this.t;
  }

  public long getCurrentPositionMillis()
  {
    return this.p;
  }

  protected final int getCurrentPreviewState()
  {
    return this.d;
  }

  @SuppressLint({"WrongConstant"})
  public MediaPlayer.VisualSpec getCurrentVisualSpec()
  {
    return MediaPlayer.VisualSpec.builder().b(getPlayerType()).a(this.j).b(this.k).a(this.l).a(this.m).a(this.x).c(this.y).b(this.s).c(this.t).a();
  }

  public long getDurationMillis()
  {
    return this.o;
  }

  public String getSourceUrl()
  {
    return this.j;
  }

  public int getThumbnailResource()
  {
    return this.l;
  }

  public ImageView.ScaleType getThumbnailScaleType()
  {
    return this.m;
  }

  public String getThumbnailUrl()
  {
    return this.k;
  }

  protected void l()
  {
    g();
  }

  protected void m()
  {
    addView(this.h, new FrameLayout.LayoutParams(-1, -1, 17));
  }

  protected void n()
  {
    if (this.i != null)
    {
      removeView(this.i);
      this.i = null;
    }
    if (this.y > 0)
    {
      this.i = LayoutInflater.from(getContext()).inflate(this.y, this, false);
      addView(this.i);
    }
  }

  protected void o()
  {
    if (this.h == null)
      a(getContext());
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.q.a())
      o();
    this.q.b();
  }

  protected void onDetachedFromWindow()
  {
    this.q.b(c());
    super.onDetachedFromWindow();
    if (!this.q.a())
      e();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
      b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  public void p()
  {
    e();
  }

  public boolean q()
  {
    return this.x;
  }

  public boolean r()
  {
    return this.s;
  }

  protected boolean s()
  {
    return this.h == null;
  }

  public void setActionReplyData(String paramString)
  {
    this.t = paramString;
  }

  public final void setCallbacks(MediaPlayer.a parama)
  {
    if (parama == null)
      parama = a;
    this.g = parama;
  }

  public void setHasVisualContent(boolean paramBoolean)
  {
    this.x = paramBoolean;
    g();
  }

  public void setLogoLayoutId(int paramInt)
  {
    this.y = paramInt;
    n();
  }

  public void setLoop(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void setSourceUrl(String paramString)
  {
    if (!da.a(paramString, this.j))
    {
      this.j = paramString;
      e(1);
    }
  }

  protected void setState(int paramInt)
  {
    this.r = paramInt;
  }

  public void setTemporaryDetaching(boolean paramBoolean)
  {
    this.q.a(paramBoolean);
  }

  public void setThumbnailResource(int paramInt)
  {
    this.k = null;
    this.l = paramInt;
  }

  public void setThumbnailScaleType(ImageView.ScaleType paramScaleType)
  {
    this.m = paramScaleType;
  }

  public void setThumbnailUrl(String paramString)
  {
    this.l = 0;
    this.k = paramString;
  }

  public void setVisualSpec(MediaPlayer.VisualSpec paramVisualSpec)
  {
    setHasVisualContent(paramVisualSpec.hasVisualContent());
    setLogoLayoutId(paramVisualSpec.getLogoLayoutId());
    setThumbnailScaleType(paramVisualSpec.getThumbnailScaleType());
    if (!da.a(paramVisualSpec.getThumbnailUrl()))
      setThumbnailUrl(paramVisualSpec.getThumbnailUrl());
    while (true)
    {
      setSourceUrl(paramVisualSpec.getSourceUrl());
      setLoop(paramVisualSpec.isLoop());
      setActionReplyData(paramVisualSpec.getActionReplyData());
      return;
      if (paramVisualSpec.getThumbnailResource() > 0)
        setThumbnailResource(paramVisualSpec.getThumbnailResource());
      else
        setThumbnailUrl(null);
    }
  }

  protected abstract class a
    implements Runnable
  {
    protected a()
    {
    }

    protected abstract void a();

    public final void run()
    {
      if (!b.this.s())
        a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.b
 * JD-Core Version:    0.6.2
 */