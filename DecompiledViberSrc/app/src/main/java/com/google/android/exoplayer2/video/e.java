package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.g.ag;

@TargetApi(16)
public final class e
{
  private final WindowManager a;
  private final b b;
  private final a c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private boolean i;
  private long j;
  private long k;
  private long l;

  public e()
  {
    this(null);
  }

  public e(Context paramContext)
  {
    a locala;
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationContext();
      this.a = ((WindowManager)paramContext.getSystemService("window"));
      if (this.a == null)
        break label87;
      if (ag.a < 17)
        break label82;
      locala = a(paramContext);
      label47: this.c = locala;
    }
    for (this.b = b.a(); ; this.b = null)
    {
      this.d = -9223372036854775807L;
      this.e = -9223372036854775807L;
      return;
      this.a = null;
      break;
      label82: locala = null;
      break label47;
      label87: this.c = null;
    }
  }

  private static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong2 + paramLong3 * ((paramLong1 - paramLong2) / paramLong3);
    long l3;
    if (paramLong1 <= l1)
      l3 = l1 - paramLong3;
    while (l1 - paramLong1 < paramLong1 - l3)
    {
      return l1;
      long l2 = l1 + paramLong3;
      l3 = l1;
      l1 = l2;
    }
    return l3;
  }

  @TargetApi(17)
  private a a(Context paramContext)
  {
    DisplayManager localDisplayManager = (DisplayManager)paramContext.getSystemService("display");
    if (localDisplayManager == null)
      return null;
    return new a(localDisplayManager);
  }

  private boolean b(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1 - this.k;
    return Math.abs(paramLong2 - this.j - l1) > 20000000L;
  }

  private void c()
  {
    Display localDisplay = this.a.getDefaultDisplay();
    if (localDisplay != null)
    {
      this.d = (()(1000000000.0D / localDisplay.getRefreshRate()));
      this.e = (80L * this.d / 100L);
    }
  }

  public long a(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1 * 1000L;
    long l3;
    long l2;
    if (this.i)
    {
      if (paramLong1 != this.f)
      {
        this.l = (1L + this.l);
        this.g = this.h;
      }
      if (this.l >= 6L)
      {
        l3 = (l1 - this.k) / this.l + this.g;
        if (b(l3, paramLong2))
        {
          this.i = false;
          l2 = paramLong2;
          l3 = l1;
          if (!this.i)
          {
            this.k = l1;
            this.j = paramLong2;
            this.l = 0L;
            this.i = true;
          }
          this.f = paramLong1;
          this.h = l3;
          if ((this.b != null) && (this.d != -9223372036854775807L))
            break label195;
        }
      }
    }
    label195: long l4;
    do
    {
      return l2;
      l2 = l3 + this.j - this.k;
      break;
      if (b(l1, paramLong2))
        this.i = false;
      l2 = paramLong2;
      l3 = l1;
      break;
      l4 = this.b.a;
    }
    while (l4 == -9223372036854775807L);
    return a(l2, l4, this.d) - this.e;
  }

  public void a()
  {
    this.i = false;
    if (this.a != null)
    {
      this.b.b();
      if (this.c != null)
        this.c.a();
      c();
    }
  }

  public void b()
  {
    if (this.a != null)
    {
      if (this.c != null)
        this.c.b();
      this.b.c();
    }
  }

  @TargetApi(17)
  private final class a
    implements DisplayManager.DisplayListener
  {
    private final DisplayManager b;

    public a(DisplayManager arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a()
    {
      this.b.registerDisplayListener(this, null);
    }

    public void b()
    {
      this.b.unregisterDisplayListener(this);
    }

    public void onDisplayAdded(int paramInt)
    {
    }

    public void onDisplayChanged(int paramInt)
    {
      if (paramInt == 0)
        e.a(e.this);
    }

    public void onDisplayRemoved(int paramInt)
    {
    }
  }

  private static final class b
    implements Handler.Callback, Choreographer.FrameCallback
  {
    private static final b b = new b();
    public volatile long a = -9223372036854775807L;
    private final Handler c;
    private final HandlerThread d = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer e;
    private int f;

    private b()
    {
      this.d.start();
      this.c = ag.a(this.d.getLooper(), this);
      this.c.sendEmptyMessage(0);
    }

    public static b a()
    {
      return b;
    }

    private void d()
    {
      this.e = Choreographer.getInstance();
    }

    private void e()
    {
      this.f = (1 + this.f);
      if (this.f == 1)
        this.e.postFrameCallback(this);
    }

    private void f()
    {
      this.f = (-1 + this.f);
      if (this.f == 0)
      {
        this.e.removeFrameCallback(this);
        this.a = -9223372036854775807L;
      }
    }

    public void b()
    {
      this.c.sendEmptyMessage(1);
    }

    public void c()
    {
      this.c.sendEmptyMessage(2);
    }

    public void doFrame(long paramLong)
    {
      this.a = paramLong;
      this.e.postFrameCallbackDelayed(this, 500L);
    }

    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return false;
      case 0:
        d();
        return true;
      case 1:
        e();
        return true;
      case 2:
      }
      f();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.e
 * JD-Core Version:    0.6.2
 */