package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.g.a;

public abstract interface h
{
  public abstract void a(int paramInt, long paramLong);

  public abstract void a(Surface paramSurface);

  public abstract void a(Format paramFormat);

  public abstract void a(d paramd);

  public abstract void a(String paramString, long paramLong1, long paramLong2);

  public abstract void b(d paramd);

  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat);

  public static final class a
  {
    private final Handler a;
    private final h b;

    public a(Handler paramHandler, h paramh)
    {
      if (paramh != null);
      for (Handler localHandler = (Handler)a.a(paramHandler); ; localHandler = null)
      {
        this.a = localHandler;
        this.b = paramh;
        return;
      }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      if (this.b != null)
        this.a.post(new m(this, paramInt1, paramInt2, paramInt3, paramFloat));
    }

    public void a(int paramInt, long paramLong)
    {
      if (this.b != null)
        this.a.post(new l(this, paramInt, paramLong));
    }

    public void a(Surface paramSurface)
    {
      if (this.b != null)
        this.a.post(new n(this, paramSurface));
    }

    public void a(Format paramFormat)
    {
      if (this.b != null)
        this.a.post(new k(this, paramFormat));
    }

    public void a(d paramd)
    {
      if (this.b != null)
        this.a.post(new i(this, paramd));
    }

    public void a(String paramString, long paramLong1, long paramLong2)
    {
      if (this.b != null)
        this.a.post(new j(this, paramString, paramLong1, paramLong2));
    }

    public void b(d paramd)
    {
      if (this.b != null)
        this.a.post(new o(this, paramd));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.h
 * JD-Core Version:    0.6.2
 */