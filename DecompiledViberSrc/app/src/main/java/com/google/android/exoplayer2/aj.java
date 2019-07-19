package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.b.d.b;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.video.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public class aj extends a
  implements aa.b, aa.c, j
{
  private com.google.android.exoplayer2.b.b A;
  private float B;
  private n C;
  private List<com.google.android.exoplayer2.e.b> D;
  private com.google.android.exoplayer2.video.d E;
  private com.google.android.exoplayer2.video.a.a F;
  private boolean G;
  protected final ad[] b;
  private final l c;
  private final Handler d;
  private final a e;
  private final CopyOnWriteArraySet<f> f;
  private final CopyOnWriteArraySet<e> g;
  private final CopyOnWriteArraySet<k> h;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> i;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.video.h> j;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.b.g> k;
  private final com.google.android.exoplayer2.f.d l;
  private final com.google.android.exoplayer2.a.a m;
  private final com.google.android.exoplayer2.b.d n;
  private Format o;
  private Format p;
  private Surface q;
  private boolean r;
  private int s;
  private SurfaceHolder t;
  private TextureView u;
  private int v;
  private int w;
  private com.google.android.exoplayer2.c.d x;
  private com.google.android.exoplayer2.c.d y;
  private int z;

  protected aj(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params, com.google.android.exoplayer2.drm.l<p> paraml, com.google.android.exoplayer2.f.d paramd, a.a parama, Looper paramLooper)
  {
    this(paramContext, paramah, paramh, params, paraml, paramd, parama, com.google.android.exoplayer2.g.b.a, paramLooper);
  }

  protected aj(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params, com.google.android.exoplayer2.drm.l<p> paraml, com.google.android.exoplayer2.f.d paramd, a.a parama, com.google.android.exoplayer2.g.b paramb, Looper paramLooper)
  {
    this.l = paramd;
    this.e = new a(null);
    this.f = new CopyOnWriteArraySet();
    this.g = new CopyOnWriteArraySet();
    this.h = new CopyOnWriteArraySet();
    this.i = new CopyOnWriteArraySet();
    this.j = new CopyOnWriteArraySet();
    this.k = new CopyOnWriteArraySet();
    this.d = new Handler(paramLooper);
    this.b = paramah.a(this.d, this.e, this.e, this.e, this.e, paraml);
    this.B = 1.0F;
    this.z = 0;
    this.A = com.google.android.exoplayer2.b.b.a;
    this.s = 1;
    this.D = Collections.emptyList();
    this.c = new l(this.b, paramh, params, paramd, paramb, paramLooper);
    this.m = parama.a(this.c, paramb);
    a(this.m);
    this.j.add(this.m);
    this.f.add(this.m);
    this.k.add(this.m);
    this.g.add(this.m);
    a(this.m);
    paramd.a(this.d, this.m);
    if ((paraml instanceof com.google.android.exoplayer2.drm.i))
      ((com.google.android.exoplayer2.drm.i)paraml).a(this.d, this.m);
    this.n = new com.google.android.exoplayer2.b.d(paramContext, this.e);
  }

  private void D()
  {
    if (this.u != null)
    {
      if (this.u.getSurfaceTextureListener() == this.e)
        break label59;
      com.google.android.exoplayer2.g.l.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
    }
    while (true)
    {
      this.u = null;
      if (this.t != null)
      {
        this.t.removeCallback(this.e);
        this.t = null;
      }
      return;
      label59: this.u.setSurfaceTextureListener(null);
    }
  }

  private void E()
  {
    float f1 = this.B * this.n.a();
    for (ad localad : this.b)
      if (localad.a() == 1)
        this.c.a(localad).a(2).a(Float.valueOf(f1)).i();
  }

  private void F()
  {
    if (Looper.myLooper() != i())
      if (!this.G)
        break label33;
    label33: for (Object localObject = null; ; localObject = new IllegalStateException())
    {
      com.google.android.exoplayer2.g.l.a("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://google.github.io/ExoPlayer/faqs.html#what-do-player-is-accessed-on-the-wrong-thread-warnings-mean", (Throwable)localObject);
      this.G = true;
      return;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.v) || (paramInt2 != this.w))
    {
      this.v = paramInt1;
      this.w = paramInt2;
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).onSurfaceSizeChanged(paramInt1, paramInt2);
    }
  }

  private void a(Surface paramSurface, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (ad localad : this.b)
      if (localad.a() == 2)
        localArrayList.add(this.c.a(localad).a(1).a(paramSurface).i());
    if ((this.q != null) && (this.q != paramSurface))
      try
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          ((ac)localIterator.next()).k();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        if (this.r)
          this.q.release();
      }
    this.q = paramSurface;
    this.r = paramBoolean;
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    int i1 = 1;
    l locall = this.c;
    int i2;
    if ((paramBoolean) && (paramInt != -1))
    {
      i2 = i1;
      if (paramInt == i1)
        break label40;
    }
    while (true)
    {
      locall.a(i2, i1);
      return;
      int i3 = 0;
      break;
      label40: i1 = 0;
    }
  }

  public TrackGroupArray A()
  {
    F();
    return this.c.A();
  }

  public com.google.android.exoplayer2.trackselection.g B()
  {
    F();
    return this.c.B();
  }

  public ak C()
  {
    F();
    return this.c.C();
  }

  public void a(float paramFloat)
  {
    F();
    float f1 = ag.a(paramFloat, 0.0F, 1.0F);
    if (this.B == f1);
    while (true)
    {
      return;
      this.B = f1;
      E();
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
        ((e)localIterator.next()).a(f1);
    }
  }

  public void a(int paramInt)
  {
    F();
    this.c.a(paramInt);
  }

  public void a(int paramInt, long paramLong)
  {
    F();
    this.m.a();
    this.c.a(paramInt, paramLong);
  }

  public void a(Surface paramSurface)
  {
    F();
    if ((paramSurface != null) && (paramSurface == this.q))
      b(null);
  }

  public void a(SurfaceHolder paramSurfaceHolder)
  {
    F();
    D();
    this.t = paramSurfaceHolder;
    if (paramSurfaceHolder == null)
    {
      a(null, false);
      a(0, 0);
      return;
    }
    paramSurfaceHolder.addCallback(this.e);
    Surface localSurface = paramSurfaceHolder.getSurface();
    if ((localSurface != null) && (localSurface.isValid()))
    {
      a(localSurface, false);
      Rect localRect = paramSurfaceHolder.getSurfaceFrame();
      a(localRect.width(), localRect.height());
      return;
    }
    a(null, false);
    a(0, 0);
  }

  public void a(SurfaceView paramSurfaceView)
  {
    if (paramSurfaceView == null);
    for (SurfaceHolder localSurfaceHolder = null; ; localSurfaceHolder = paramSurfaceView.getHolder())
    {
      a(localSurfaceHolder);
      return;
    }
  }

  public void a(TextureView paramTextureView)
  {
    F();
    D();
    this.u = paramTextureView;
    if (paramTextureView == null)
    {
      a(null, true);
      a(0, 0);
      return;
    }
    if (paramTextureView.getSurfaceTextureListener() != null)
      com.google.android.exoplayer2.g.l.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
    paramTextureView.setSurfaceTextureListener(this.e);
    if (paramTextureView.isAvailable());
    for (SurfaceTexture localSurfaceTexture = paramTextureView.getSurfaceTexture(); localSurfaceTexture == null; localSurfaceTexture = null)
    {
      a(null, true);
      a(0, 0);
      return;
    }
    a(new Surface(localSurfaceTexture), true);
    a(paramTextureView.getWidth(), paramTextureView.getHeight());
  }

  public void a(aa.a parama)
  {
    F();
    this.c.a(parama);
  }

  public void a(com.google.android.exoplayer2.b.b paramb)
  {
    a(paramb, false);
  }

  public void a(com.google.android.exoplayer2.b.b paramb, boolean paramBoolean)
  {
    F();
    if (!ag.a(this.A, paramb))
    {
      this.A = paramb;
      for (ad localad : this.b)
        if (localad.a() == 1)
          this.c.a(localad).a(3).a(paramb).i();
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
        ((e)localIterator.next()).a(paramb);
    }
    com.google.android.exoplayer2.b.d locald = this.n;
    if (paramBoolean);
    while (true)
    {
      int i1 = locald.a(paramb, l(), j());
      a(l(), i1);
      return;
      paramb = null;
    }
  }

  public void a(k paramk)
  {
    if (!this.D.isEmpty())
      paramk.a(this.D);
    this.h.add(paramk);
  }

  public void a(com.google.android.exoplayer2.metadata.d paramd)
  {
    this.i.add(paramd);
  }

  public void a(n paramn)
  {
    a(paramn, true, true);
  }

  public void a(n paramn, boolean paramBoolean1, boolean paramBoolean2)
  {
    F();
    if (this.C != null)
    {
      this.C.a(this.m);
      this.m.b();
    }
    this.C = paramn;
    paramn.a(this.d, this.m);
    int i1 = this.n.a(l());
    a(l(), i1);
    this.c.a(paramn, paramBoolean1, paramBoolean2);
  }

  public void a(com.google.android.exoplayer2.video.a.a parama)
  {
    F();
    this.F = parama;
    for (ad localad : this.b)
      if (localad.a() == 5)
        this.c.a(localad).a(7).a(parama).i();
  }

  public void a(com.google.android.exoplayer2.video.d paramd)
  {
    F();
    this.E = paramd;
    for (ad localad : this.b)
      if (localad.a() == 2)
        this.c.a(localad).a(6).a(paramd).i();
  }

  public void a(f paramf)
  {
    this.f.add(paramf);
  }

  public void a(boolean paramBoolean)
  {
    F();
    a(paramBoolean, this.n.a(paramBoolean, j()));
  }

  public int b(int paramInt)
  {
    F();
    return this.c.b(paramInt);
  }

  public void b(Surface paramSurface)
  {
    F();
    D();
    a(paramSurface, false);
    int i1 = 0;
    if (paramSurface == null);
    while (true)
    {
      a(i1, i1);
      return;
      i1 = -1;
    }
  }

  public void b(SurfaceHolder paramSurfaceHolder)
  {
    F();
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder == this.t))
      a(null);
  }

  public void b(SurfaceView paramSurfaceView)
  {
    if (paramSurfaceView == null);
    for (SurfaceHolder localSurfaceHolder = null; ; localSurfaceHolder = paramSurfaceView.getHolder())
    {
      b(localSurfaceHolder);
      return;
    }
  }

  public void b(TextureView paramTextureView)
  {
    F();
    if ((paramTextureView != null) && (paramTextureView == this.u))
      a(null);
  }

  public void b(aa.a parama)
  {
    F();
    this.c.b(parama);
  }

  public void b(k paramk)
  {
    this.h.remove(paramk);
  }

  public void b(com.google.android.exoplayer2.video.a.a parama)
  {
    F();
    if (this.F != parama);
    while (true)
    {
      return;
      for (ad localad : this.b)
        if (localad.a() == 5)
          this.c.a(localad).a(7).a(null).i();
    }
  }

  public void b(com.google.android.exoplayer2.video.d paramd)
  {
    F();
    if (this.E != paramd);
    while (true)
    {
      return;
      for (ad localad : this.b)
        if (localad.a() == 2)
          this.c.a(localad).a(6).a(null).i();
    }
  }

  public void b(f paramf)
  {
    this.f.remove(paramf);
  }

  public void b(boolean paramBoolean)
  {
    F();
    this.c.b(paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    F();
    this.c.c(paramBoolean);
    if (this.C != null)
    {
      this.C.a(this.m);
      this.m.b();
      if (paramBoolean)
        this.C = null;
    }
    this.n.b();
    this.D = Collections.emptyList();
  }

  public aa.c g()
  {
    return this;
  }

  public aa.b h()
  {
    return this;
  }

  public Looper i()
  {
    return this.c.i();
  }

  public int j()
  {
    F();
    return this.c.j();
  }

  public i k()
  {
    F();
    return this.c.k();
  }

  public boolean l()
  {
    F();
    return this.c.l();
  }

  public int m()
  {
    F();
    return this.c.m();
  }

  public boolean n()
  {
    F();
    return this.c.n();
  }

  public y o()
  {
    F();
    return this.c.o();
  }

  public float p()
  {
    return this.B;
  }

  public void q()
  {
    this.n.b();
    this.c.p();
    D();
    if (this.q != null)
    {
      if (this.r)
        this.q.release();
      this.q = null;
    }
    if (this.C != null)
    {
      this.C.a(this.m);
      this.C = null;
    }
    this.l.a(this.m);
    this.D = Collections.emptyList();
  }

  public int r()
  {
    F();
    return this.c.r();
  }

  public long s()
  {
    F();
    return this.c.s();
  }

  public long t()
  {
    F();
    return this.c.t();
  }

  public long u()
  {
    F();
    return this.c.u();
  }

  public boolean v()
  {
    F();
    return this.c.v();
  }

  public int w()
  {
    F();
    return this.c.w();
  }

  public int x()
  {
    F();
    return this.c.x();
  }

  public long y()
  {
    F();
    return this.c.y();
  }

  public long z()
  {
    F();
    return this.c.z();
  }

  private final class a
    implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, d.b, com.google.android.exoplayer2.b.g, k, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.video.h
  {
    private a()
    {
    }

    public void a(float paramFloat)
    {
      aj.i(aj.this);
    }

    public void a(int paramInt)
    {
      if (aj.e(aj.this) == paramInt);
      while (true)
      {
        return;
        aj.a(aj.this, paramInt);
        Iterator localIterator1 = aj.f(aj.this).iterator();
        while (localIterator1.hasNext())
        {
          e locale = (e)localIterator1.next();
          if (!aj.d(aj.this).contains(locale))
            locale.a(paramInt);
        }
        Iterator localIterator2 = aj.d(aj.this).iterator();
        while (localIterator2.hasNext())
          ((com.google.android.exoplayer2.b.g)localIterator2.next()).a(paramInt);
      }
    }

    public void a(int paramInt, long paramLong)
    {
      Iterator localIterator = aj.a(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator.next()).a(paramInt, paramLong);
    }

    public void a(int paramInt, long paramLong1, long paramLong2)
    {
      Iterator localIterator = aj.d(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.b.g)localIterator.next()).a(paramInt, paramLong1, paramLong2);
    }

    public void a(Surface paramSurface)
    {
      if (aj.c(aj.this) == paramSurface)
      {
        Iterator localIterator2 = aj.b(aj.this).iterator();
        while (localIterator2.hasNext())
          ((f)localIterator2.next()).onRenderedFirstFrame();
      }
      Iterator localIterator1 = aj.a(aj.this).iterator();
      while (localIterator1.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator1.next()).a(paramSurface);
    }

    public void a(Format paramFormat)
    {
      aj.a(aj.this, paramFormat);
      Iterator localIterator = aj.a(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator.next()).a(paramFormat);
    }

    public void a(com.google.android.exoplayer2.c.d paramd)
    {
      aj.a(aj.this, paramd);
      Iterator localIterator = aj.a(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator.next()).a(paramd);
    }

    public void a(Metadata paramMetadata)
    {
      Iterator localIterator = aj.h(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.metadata.d)localIterator.next()).a(paramMetadata);
    }

    public void a(String paramString, long paramLong1, long paramLong2)
    {
      Iterator localIterator = aj.a(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator.next()).a(paramString, paramLong1, paramLong2);
    }

    public void a(List<com.google.android.exoplayer2.e.b> paramList)
    {
      aj.a(aj.this, paramList);
      Iterator localIterator = aj.g(aj.this).iterator();
      while (localIterator.hasNext())
        ((k)localIterator.next()).a(paramList);
    }

    public void b(int paramInt)
    {
      aj.a(aj.this, aj.this.l(), paramInt);
    }

    public void b(Format paramFormat)
    {
      aj.b(aj.this, paramFormat);
      Iterator localIterator = aj.d(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.b.g)localIterator.next()).b(paramFormat);
    }

    public void b(com.google.android.exoplayer2.c.d paramd)
    {
      Iterator localIterator = aj.a(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator.next()).b(paramd);
      aj.a(aj.this, null);
      aj.a(aj.this, null);
    }

    public void b(String paramString, long paramLong1, long paramLong2)
    {
      Iterator localIterator = aj.d(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.b.g)localIterator.next()).b(paramString, paramLong1, paramLong2);
    }

    public void c(com.google.android.exoplayer2.c.d paramd)
    {
      aj.b(aj.this, paramd);
      Iterator localIterator = aj.d(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.b.g)localIterator.next()).c(paramd);
    }

    public void d(com.google.android.exoplayer2.c.d paramd)
    {
      Iterator localIterator = aj.d(aj.this).iterator();
      while (localIterator.hasNext())
        ((com.google.android.exoplayer2.b.g)localIterator.next()).d(paramd);
      aj.b(aj.this, null);
      aj.b(aj.this, null);
      aj.a(aj.this, 0);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      aj.a(aj.this, new Surface(paramSurfaceTexture), true);
      aj.a(aj.this, paramInt1, paramInt2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      aj.a(aj.this, null, true);
      aj.a(aj.this, 0, 0);
      return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      aj.a(aj.this, paramInt1, paramInt2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
    }

    public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      Iterator localIterator1 = aj.b(aj.this).iterator();
      while (localIterator1.hasNext())
      {
        f localf = (f)localIterator1.next();
        if (!aj.a(aj.this).contains(localf))
          localf.onVideoSizeChanged(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      Iterator localIterator2 = aj.a(aj.this).iterator();
      while (localIterator2.hasNext())
        ((com.google.android.exoplayer2.video.h)localIterator2.next()).onVideoSizeChanged(paramInt1, paramInt2, paramInt3, paramFloat);
    }

    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      aj.a(aj.this, paramInt2, paramInt3);
    }

    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      aj.a(aj.this, paramSurfaceHolder.getSurface(), false);
    }

    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      aj.a(aj.this, null, false);
      aj.a(aj.this, 0, 0);
    }
  }

  @Deprecated
  public static abstract interface b extends f
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.aj
 * JD-Core Version:    0.6.2
 */