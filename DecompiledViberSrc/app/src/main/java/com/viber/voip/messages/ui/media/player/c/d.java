package com.viber.voip.messages.ui.media.player.c;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.support.v4.content.ContextCompat;
import com.viber.common.a.e;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.media.h;
import com.viber.voip.messages.ui.media.h.a;
import com.viber.voip.widget.ak;

public final class d extends a<ak>
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  private static final e z = ViberEnv.getLogger();
  private boolean A = true;
  private final a B = new a(null);
  private MediaPlayer C;
  private h D;
  private final h.a E = new h.a()
  {
    public boolean a()
    {
      if ((d.this.h != null) && (((ak)d.this.h).b()) && (-1 != d.this.r) && (!d.this.c()) && (!d.this.q.a()))
      {
        d.this.a();
        return true;
      }
      return false;
    }

    public boolean b()
    {
      if ((d.this.h != null) && (((ak)d.this.h).b()) && (d.this.c()) && (!d.this.q.a()))
      {
        d.this.b();
        return true;
      }
      return false;
    }
  };

  public d(Context paramContext)
  {
    super(paramContext);
  }

  private void t()
  {
    a(new b.a(this.p)
    {
      protected void a()
      {
        d.this.a(this.a);
        if (4 == d.this.r)
          ((ak)d.this.h).start();
        while (true)
        {
          d.a.a(d.a(d.this));
          d.this.setState(d.this.r);
          return;
          ((ak)d.this.h).pause();
        }
      }
    });
  }

  private void u()
  {
    if (this.D.c())
      this.D.a(this.E);
  }

  private void v()
  {
    if (this.D.c())
      this.D.a();
  }

  protected void b(long paramLong)
  {
    super.b(paramLong);
    ((ak)this.h).seekTo((int)paramLong);
  }

  protected void b(long paramLong, boolean paramBoolean)
  {
    if (!this.A)
    {
      t();
      return;
    }
    super.b(paramLong, paramBoolean);
  }

  protected void b(Context paramContext)
  {
    super.b(paramContext);
    setBackgroundColor(ContextCompat.getColor(getContext(), R.color.solid));
    this.D = new h(paramContext);
  }

  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.A = false;
    u();
  }

  protected ak d(Context paramContext)
  {
    return new ak(paramContext);
  }

  protected void e()
  {
    v();
    super.e();
  }

  protected void f()
  {
    ((ak)this.h).a();
    super.f();
  }

  protected void g()
  {
    super.g();
    ((ak)this.h).start();
  }

  protected int getErrorPreviewStateMessage()
  {
    return R.string.embedded_media_content_unavailable;
  }

  public int getPlayerType()
  {
    return 0;
  }

  protected void h()
  {
    super.h();
    ((ak)this.h).pause();
  }

  protected void i()
  {
    super.i();
    ((ak)this.h).a();
    this.A = true;
    ((ak)this.h).setVideoPath(this.c);
    ((ak)this.h).setOnPreparedListener(this);
    ((ak)this.h).setOnErrorListener(this);
    ((ak)this.h).setOnCompletionListener(this);
    if (com.viber.common.d.a.b())
      ((ak)this.h).setOnInfoListener(this);
  }

  protected void j()
  {
    super.j();
    v();
  }

  protected void o()
  {
    super.o();
    this.d = true;
    a(false);
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    k();
  }

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return c(0);
  }

  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.C = paramMediaPlayer;
    this.C.setLooping(r());
    b(((ak)this.h).getDuration(), false);
  }

  protected void setState(int paramInt)
  {
    super.setState(paramInt);
    switch (paramInt)
    {
    default:
      a.a(this.B);
      b(this.B);
      v();
      return;
    case 3:
    case 4:
    case 5:
    }
    b(this.B);
    a(this.B);
  }

  private class a extends b<ak>.a
  {
    private boolean b;
    private boolean c;

    private a()
    {
      super();
      b();
    }

    private void b()
    {
      this.b = true;
      this.c = true;
    }

    protected void a()
    {
      if (d.b(d.this) == null);
      while (true)
      {
        return;
        try
        {
          l1 = d.b(d.this).getDuration();
          long l3 = Math.min(d.b(d.this).getCurrentPosition(), l1);
          l2 = l3;
          i = 1;
          if (i == 0)
            continue;
          if ((((ak)d.this.h).isPlaying()) && (this.b))
          {
            this.b = false;
            this.c = true;
            d.this.b(d.c(d.this));
            if (!((ak)d.this.h).isPlaying())
              continue;
            d.this.a(l1, l2);
            d.this.a(this, 250L);
            return;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          while (true)
          {
            long l1 = d.this.o;
            long l2 = d.this.p;
            int i = 0;
            continue;
            if ((!((ak)d.this.h).isPlaying()) && (this.c))
            {
              this.c = false;
              this.b = true;
              d.this.j();
            }
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.d
 * JD-Core Version:    0.6.2
 */