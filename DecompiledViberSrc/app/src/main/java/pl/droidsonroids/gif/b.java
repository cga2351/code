package pl.droidsonroids.gif;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.MediaController.MediaPlayerControl;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b extends Drawable
  implements Animatable, MediaController.MediaPlayerControl
{
  final ScheduledThreadPoolExecutor a;
  volatile boolean b;
  long c;
  protected final Paint d;
  final Bitmap e;
  final GifInfoHandle f;
  final ConcurrentLinkedQueue<a> g;
  final boolean h;
  final i i;
  ScheduledFuture<?> j;
  private final Rect k;
  private ColorStateList l;
  private PorterDuffColorFilter m;
  private PorterDuff.Mode n;
  private final m o;
  private final Rect p;
  private int q;
  private int r;
  private pl.droidsonroids.gif.a.a s;

  b(GifInfoHandle paramGifInfoHandle, b paramb, ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, boolean paramBoolean)
  {
    this.b = bool1;
    this.c = -9223372036854775808L;
    this.k = new Rect();
    this.d = new Paint(6);
    this.g = new ConcurrentLinkedQueue();
    this.o = new m(this);
    this.h = paramBoolean;
    Bitmap localBitmap1;
    if (paramScheduledThreadPoolExecutor != null)
    {
      this.a = paramScheduledThreadPoolExecutor;
      this.f = paramGifInfoHandle;
      localBitmap1 = null;
      if (paramb == null);
    }
    while (true)
    {
      synchronized (paramb.f)
      {
        boolean bool2 = paramb.f.m();
        localBitmap1 = null;
        if (!bool2)
        {
          int i1 = paramb.f.p();
          int i2 = this.f.p();
          localBitmap1 = null;
          if (i1 >= i2)
          {
            int i3 = paramb.f.o();
            int i4 = this.f.o();
            localBitmap1 = null;
            if (i3 >= i4)
            {
              paramb.l();
              localBitmap1 = paramb.e;
              localBitmap1.eraseColor(0);
            }
          }
        }
        if (localBitmap1 == null)
        {
          this.e = Bitmap.createBitmap(this.f.o(), this.f.p(), Bitmap.Config.ARGB_8888);
          Bitmap localBitmap2 = this.e;
          if (paramGifInfoHandle.r())
            break label337;
          localBitmap2.setHasAlpha(bool1);
          this.p = new Rect(0, 0, this.f.o(), this.f.p());
          this.i = new i(this);
          this.o.a();
          this.q = this.f.o();
          this.r = this.f.p();
          return;
          paramScheduledThreadPoolExecutor = g.a();
        }
      }
      this.e = localBitmap1;
      continue;
      label337: bool1 = false;
    }
  }

  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null))
      return null;
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }

  private void l()
  {
    this.b = false;
    this.i.removeMessages(-1);
    this.f.a();
  }

  private void m()
  {
    if (this.j != null)
      this.j.cancel(false);
    this.i.removeMessages(-1);
  }

  public void a(int paramInt)
  {
    this.f.a(paramInt);
  }

  void a(long paramLong)
  {
    if (this.h)
    {
      this.c = 0L;
      this.i.sendEmptyMessageAtTime(-1, 0L);
      return;
    }
    m();
    this.j = this.a.schedule(this.o, Math.max(paramLong, 0L), TimeUnit.MILLISECONDS);
  }

  public void a(pl.droidsonroids.gif.a.a parama)
  {
    this.s = parama;
    if (this.s != null)
      this.s.a(this.k);
  }

  public boolean a()
  {
    return this.f.m();
  }

  public Bitmap b(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException("Frame index is not positive");
    synchronized (this.f)
    {
      this.f.b(paramInt, this.e);
      Bitmap localBitmap = h();
      this.i.sendEmptyMessageAtTime(-1, 0L);
      return localBitmap;
    }
  }

  public void b()
  {
    this.a.execute(new n(this)
    {
      public void a()
      {
        if (b.this.f.c())
          b.this.start();
      }
    });
  }

  public int c()
  {
    return this.f.e();
  }

  public boolean canPause()
  {
    return true;
  }

  public boolean canSeekBackward()
  {
    return d() > 1;
  }

  public boolean canSeekForward()
  {
    return d() > 1;
  }

  public int d()
  {
    return this.f.q();
  }

  public void draw(Canvas paramCanvas)
  {
    int i1;
    if ((this.m != null) && (this.d.getColorFilter() == null))
    {
      this.d.setColorFilter(this.m);
      i1 = 1;
      if (this.s != null)
        break label153;
      paramCanvas.drawBitmap(this.e, this.p, this.k, this.d);
    }
    while (true)
    {
      if (i1 != 0)
        this.d.setColorFilter(null);
      if ((this.h) && (this.b) && (this.c != -9223372036854775808L))
      {
        long l1 = Math.max(0L, this.c - SystemClock.uptimeMillis());
        this.c = -9223372036854775808L;
        this.a.remove(this.o);
        this.j = this.a.schedule(this.o, l1, TimeUnit.MILLISECONDS);
      }
      return;
      i1 = 0;
      break;
      label153: this.s.a(paramCanvas, this.d, this.e);
    }
  }

  public int e()
  {
    return this.e.getRowBytes() * this.e.getHeight();
  }

  public long f()
  {
    long l1 = this.f.k();
    if (Build.VERSION.SDK_INT >= 19)
      return l1 + this.e.getAllocationByteCount();
    return l1 + e();
  }

  public final Paint g()
  {
    return this.d;
  }

  public int getAlpha()
  {
    return this.d.getAlpha();
  }

  public int getAudioSessionId()
  {
    return 0;
  }

  public int getBufferPercentage()
  {
    return 100;
  }

  public ColorFilter getColorFilter()
  {
    return this.d.getColorFilter();
  }

  public int getCurrentPosition()
  {
    return this.f.h();
  }

  public int getDuration()
  {
    return this.f.g();
  }

  public int getIntrinsicHeight()
  {
    return this.r;
  }

  public int getIntrinsicWidth()
  {
    return this.q;
  }

  public int getOpacity()
  {
    if ((!this.f.r()) || (this.d.getAlpha() < 255))
      return -2;
    return -1;
  }

  public Bitmap h()
  {
    Bitmap localBitmap = this.e.copy(this.e.getConfig(), this.e.isMutable());
    localBitmap.setHasAlpha(this.e.hasAlpha());
    return localBitmap;
  }

  public int i()
  {
    return this.f.i();
  }

  public boolean isPlaying()
  {
    return this.b;
  }

  public boolean isRunning()
  {
    return this.b;
  }

  public boolean isStateful()
  {
    return (super.isStateful()) || ((this.l != null) && (this.l.isStateful()));
  }

  public int j()
  {
    int i1 = this.f.j();
    if ((i1 == 0) || (i1 < this.f.e()))
      return i1;
    return i1 - 1;
  }

  public pl.droidsonroids.gif.a.a k()
  {
    return this.s;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.k.set(paramRect);
    if (this.s != null)
      this.s.a(paramRect);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if ((this.l != null) && (this.n != null))
    {
      this.m = a(this.l, this.n);
      return true;
    }
    return false;
  }

  public void pause()
  {
    stop();
  }

  public void seekTo(final int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Position is not positive");
    this.a.execute(new n(this)
    {
      public void a()
      {
        b.this.f.a(paramInt, b.this.e);
        this.c.i.sendEmptyMessageAtTime(-1, 0L);
      }
    });
  }

  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }

  @Deprecated
  public void setDither(boolean paramBoolean)
  {
    this.d.setDither(paramBoolean);
    invalidateSelf();
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.d.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    this.l = paramColorStateList;
    this.m = a(paramColorStateList, this.n);
    invalidateSelf();
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.n = paramMode;
    this.m = a(this.l, paramMode);
    invalidateSelf();
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (!this.h)
    {
      if (!paramBoolean1)
        break label36;
      if (paramBoolean2)
        b();
      if (bool)
        start();
    }
    label36: 
    while (!bool)
      return bool;
    stop();
    return bool;
  }

  public void start()
  {
    try
    {
      if (this.b)
        return;
      this.b = true;
      a(this.f.b());
      return;
    }
    finally
    {
    }
  }

  public void stop()
  {
    try
    {
      if (!this.b)
        return;
      this.b = false;
      m();
      this.f.d();
      return;
    }
    finally
    {
    }
  }

  public String toString()
  {
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.f.o());
    arrayOfObject[1] = Integer.valueOf(this.f.p());
    arrayOfObject[2] = Integer.valueOf(this.f.q());
    arrayOfObject[3] = Integer.valueOf(this.f.f());
    return String.format(localLocale, "GIF: size: %dx%d, frames: %d, error: %d", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.b
 * JD-Core Version:    0.6.2
 */