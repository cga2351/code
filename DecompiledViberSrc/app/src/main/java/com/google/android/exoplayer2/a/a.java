package com.google.android.exoplayer2.a;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.ak.a;
import com.google.android.exoplayer2.ak.b;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.f.d.a;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.o.b;
import com.google.android.exoplayer2.source.o.c;
import com.google.android.exoplayer2.video.f;
import com.google.android.exoplayer2.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class a
  implements aa.a, e, com.google.android.exoplayer2.b.g, com.google.android.exoplayer2.drm.h, d.a, com.google.android.exoplayer2.metadata.d, o, f, com.google.android.exoplayer2.video.h
{
  private final CopyOnWriteArraySet<b> a;
  private final com.google.android.exoplayer2.g.b b;
  private final ak.b c;
  private final c d;
  private aa e;

  protected a(aa paramaa, com.google.android.exoplayer2.g.b paramb)
  {
    if (paramaa != null)
      this.e = paramaa;
    this.b = ((com.google.android.exoplayer2.g.b)com.google.android.exoplayer2.g.a.a(paramb));
    this.a = new CopyOnWriteArraySet();
    this.d = new c();
    this.c = new ak.b();
  }

  private b.a a(b paramb)
  {
    com.google.android.exoplayer2.g.a.a(this.e);
    if (paramb == null)
    {
      int i = this.e.r();
      paramb = this.d.a(i);
      if (paramb == null)
      {
        ak localak = this.e.C();
        int j;
        if (i < localak.b())
        {
          j = 1;
          if (j == 0)
            break label78;
        }
        while (true)
        {
          return a(localak, i, null);
          j = 0;
          break;
          label78: localak = ak.a;
        }
      }
    }
    return a(paramb.b, paramb.c, paramb.a);
  }

  private b.a d(int paramInt, n.a parama)
  {
    com.google.android.exoplayer2.g.a.a(this.e);
    if (parama != null)
    {
      b localb = this.d.a(parama);
      if (localb != null)
        return a(localb);
      return a(ak.a, paramInt, parama);
    }
    ak localak = this.e.C();
    int i;
    if (paramInt < localak.b())
    {
      i = 1;
      if (i == 0)
        break label87;
    }
    while (true)
    {
      return a(localak, paramInt, null);
      i = 0;
      break;
      label87: localak = ak.a;
    }
  }

  private b.a g()
  {
    return a(this.d.b());
  }

  private b.a h()
  {
    return a(this.d.a());
  }

  private b.a i()
  {
    return a(this.d.c());
  }

  private b.a j()
  {
    return a(this.d.d());
  }

  @RequiresNonNull({"player"})
  protected b.a a(ak paramak, int paramInt, n.a parama)
  {
    long l1 = 0L;
    int i = 1;
    if (paramak.a());
    for (n.a locala = null; ; locala = parama)
    {
      long l2 = this.b.a();
      int j;
      if ((paramak == this.e.C()) && (paramInt == this.e.r()))
      {
        j = i;
        if ((locala == null) || (!locala.a()))
          break label171;
        if ((j == 0) || (this.e.w() != locala.b) || (this.e.x() != locala.c))
          break label165;
        label109: if (i != 0)
          l1 = this.e.t();
      }
      while (true)
      {
        return new b.a(l2, paramak, paramInt, locala, l1, this.e.t(), this.e.u());
        j = 0;
        break;
        label165: i = 0;
        break label109;
        label171: if (j != 0)
          l1 = this.e.y();
        else if (!paramak.a())
          l1 = paramak.a(paramInt, this.c).a();
      }
    }
  }

  public final void a()
  {
    if (!this.d.e())
    {
      b.a locala = h();
      this.d.f();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).a(locala);
    }
  }

  public void a(float paramFloat)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramFloat);
  }

  public final void a(int paramInt)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).d(locala, paramInt);
  }

  public final void a(int paramInt, long paramLong)
  {
    b.a locala = g();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramInt, paramLong);
  }

  public final void a(int paramInt, long paramLong1, long paramLong2)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, paramInt, paramLong1, paramLong2);
  }

  public final void a(int paramInt, n.a parama)
  {
    this.d.a(paramInt, parama);
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).c(locala);
  }

  public final void a(int paramInt, n.a parama, o.b paramb, o.c paramc)
  {
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramb, paramc);
  }

  public final void a(int paramInt, n.a parama, o.b paramb, o.c paramc, IOException paramIOException, boolean paramBoolean)
  {
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramb, paramc, paramIOException, paramBoolean);
  }

  public final void a(int paramInt, n.a parama, o.c paramc)
  {
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramc);
  }

  public final void a(Surface paramSurface)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramSurface);
  }

  public final void a(Format paramFormat)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 2, paramFormat);
  }

  public void a(com.google.android.exoplayer2.b.b paramb)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramb);
  }

  public final void a(com.google.android.exoplayer2.c.d paramd)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 2, paramd);
  }

  public final void a(Metadata paramMetadata)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramMetadata);
  }

  public final void a(Exception paramException)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramException);
  }

  public final void a(String paramString, long paramLong1, long paramLong2)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 2, paramString, paramLong2);
  }

  public final void b()
  {
    Iterator localIterator = new ArrayList(c.a(this.d)).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      b(localb.c, localb.a);
    }
  }

  public final void b(int paramInt, long paramLong1, long paramLong2)
  {
    b.a locala = j();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramInt, paramLong1, paramLong2);
  }

  public final void b(int paramInt, n.a parama)
  {
    b.a locala = d(paramInt, parama);
    if (this.d.b(parama))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).d(locala);
    }
  }

  public final void b(int paramInt, n.a parama, o.b paramb, o.c paramc)
  {
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, paramb, paramc);
  }

  public final void b(Format paramFormat)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 1, paramFormat);
  }

  public final void b(com.google.android.exoplayer2.c.d paramd)
  {
    b.a locala = g();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, 2, paramd);
  }

  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 1, paramString, paramLong2);
  }

  public final void c()
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).f(locala);
  }

  public final void c(int paramInt, n.a parama)
  {
    this.d.c(parama);
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).e(locala);
  }

  public final void c(int paramInt, n.a parama, o.b paramb, o.c paramc)
  {
    b.a locala = d(paramInt, parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).c(locala, paramb, paramc);
  }

  public final void c(com.google.android.exoplayer2.c.d paramd)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, 1, paramd);
  }

  public final void d()
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).g(locala);
  }

  public final void d(com.google.android.exoplayer2.c.d paramd)
  {
    b.a locala = g();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, 1, paramd);
  }

  public final void e()
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).h(locala);
  }

  public final void f()
  {
    b.a locala = g();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).i(locala);
  }

  public final void onLoadingChanged(boolean paramBoolean)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, paramBoolean);
  }

  public final void onPlaybackParametersChanged(y paramy)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramy);
  }

  public final void onPlayerError(i parami)
  {
    if (parami.a == 0);
    for (b.a locala = j(); ; locala = h())
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).a(locala, parami);
    }
  }

  public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramBoolean, paramInt);
  }

  public final void onPositionDiscontinuity(int paramInt)
  {
    this.d.b(paramInt);
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(locala, paramInt);
  }

  public final void onRenderedFirstFrame()
  {
  }

  public final void onRepeatModeChanged(int paramInt)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).c(locala, paramInt);
  }

  public final void onSeekProcessed()
  {
    if (this.d.e())
    {
      this.d.g();
      b.a locala = h();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).b(locala);
    }
  }

  public final void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramBoolean);
  }

  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramInt1, paramInt2);
  }

  public final void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
  {
    this.d.a(paramak);
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramInt);
  }

  public final void onTracksChanged(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g paramg)
  {
    b.a locala = h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramTrackGroupArray, paramg);
  }

  public final void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    b.a locala = i();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(locala, paramInt1, paramInt2, paramInt3, paramFloat);
  }

  public static class a
  {
    public a a(aa paramaa, com.google.android.exoplayer2.g.b paramb)
    {
      return new a(paramaa, paramb);
    }
  }

  private static final class b
  {
    public final n.a a;
    public final ak b;
    public final int c;

    public b(n.a parama, ak paramak, int paramInt)
    {
      this.a = parama;
      this.b = paramak;
      this.c = paramInt;
    }
  }

  private static final class c
  {
    private final ArrayList<a.b> a = new ArrayList();
    private final HashMap<n.a, a.b> b = new HashMap();
    private final ak.a c = new ak.a();
    private a.b d;
    private a.b e;
    private ak f = ak.a;
    private boolean g;

    private a.b a(a.b paramb, ak paramak)
    {
      int i = paramak.a(paramb.a.a);
      if (i == -1)
        return paramb;
      int j = paramak.a(i, this.c).c;
      return new a.b(paramb.a, paramak, j);
    }

    private void h()
    {
      if (!this.a.isEmpty())
        this.d = ((a.b)this.a.get(0));
    }

    public a.b a()
    {
      if ((this.a.isEmpty()) || (this.f.a()) || (this.g))
        return null;
      return (a.b)this.a.get(0);
    }

    public a.b a(int paramInt)
    {
      int i = 0;
      Object localObject2;
      for (Object localObject1 = null; i < this.a.size(); localObject1 = localObject2)
      {
        localObject2 = (a.b)this.a.get(i);
        int j = this.f.a(((a.b)localObject2).a.a);
        if ((j != -1) && (this.f.a(j, this.c).c == paramInt))
        {
          if (localObject1 != null)
            return null;
        }
        else
          localObject2 = localObject1;
        i++;
      }
      return localObject1;
    }

    public a.b a(n.a parama)
    {
      return (a.b)this.b.get(parama);
    }

    public void a(int paramInt, n.a parama)
    {
      int i;
      if (this.f.a(parama.a) != -1)
      {
        i = 1;
        if (i == 0)
          break label92;
      }
      label92: for (ak localak = this.f; ; localak = ak.a)
      {
        a.b localb = new a.b(parama, localak, paramInt);
        this.a.add(localb);
        this.b.put(parama, localb);
        if ((this.a.size() == 1) && (!this.f.a()))
          h();
        return;
        i = 0;
        break;
      }
    }

    public void a(ak paramak)
    {
      for (int i = 0; i < this.a.size(); i++)
      {
        a.b localb = a((a.b)this.a.get(i), paramak);
        this.a.set(i, localb);
        this.b.put(localb.a, localb);
      }
      if (this.e != null)
        this.e = a(this.e, paramak);
      this.f = paramak;
      h();
    }

    public a.b b()
    {
      return this.d;
    }

    public void b(int paramInt)
    {
      h();
    }

    public boolean b(n.a parama)
    {
      a.b localb1 = (a.b)this.b.remove(parama);
      if (localb1 == null)
        return false;
      this.a.remove(localb1);
      if ((this.e != null) && (parama.equals(this.e.a)))
        if (!this.a.isEmpty())
          break label69;
      label69: for (a.b localb2 = null; ; localb2 = (a.b)this.a.get(0))
      {
        this.e = localb2;
        return true;
      }
    }

    public a.b c()
    {
      return this.e;
    }

    public void c(n.a parama)
    {
      this.e = ((a.b)this.b.get(parama));
    }

    public a.b d()
    {
      if (this.a.isEmpty())
        return null;
      return (a.b)this.a.get(-1 + this.a.size());
    }

    public boolean e()
    {
      return this.g;
    }

    public void f()
    {
      this.g = true;
    }

    public void g()
    {
      this.g = false;
      h();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.a.a
 * JD-Core Version:    0.6.2
 */