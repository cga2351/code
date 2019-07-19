package com.viber.voip.videoconvert.gpu.f;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.view.Surface;
import com.viber.voip.videoconvert.gpu.encoders.c.c;
import java.io.IOException;

@TargetApi(18)
public class b extends c
  implements d
{
  private static String g = "PlayerVideoSource";
  private MediaPlayer h;
  private String i;
  private boolean j;
  private long k;
  private com.viber.voip.videoconvert.gpu.c.b l = null;
  private d.a m;

  public b(String paramString)
  {
    this.i = paramString;
  }

  public void a()
  {
    long l1 = f();
    long l2 = g();
    if ((this.d == 90L) || (this.d == 270L))
    {
      l1 = g();
      l2 = f();
    }
    if (this.m.a != null)
    {
      this.l = this.m.a;
      return;
    }
    this.l = com.viber.voip.videoconvert.gpu.c.c.a(l1, l2);
  }

  public void a(d.a parama)
  {
    super.a(parama);
    this.m = parama;
    this.h = new MediaPlayer();
    this.h.setSurface(new Surface(j()));
    this.h.setVolume(0.0F, 0.0F);
    this.j = false;
    this.h.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        if (b.this.a != null)
          b.this.a.a();
        b.a(b.this, true);
        b.this.f.e();
      }
    });
    this.h.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (b.this.a != null)
          b.this.a.b();
        return false;
      }
    });
    try
    {
      this.h.setDataSource(this.i);
      this.h.prepare();
      a();
      return;
    }
    catch (IOException localIOException)
    {
      com.viber.voip.videoconvert.e.a().a("I/O error occurred: " + localIOException.getMessage());
      throw new RuntimeException("I/O error occurred: " + localIOException.getMessage());
    }
  }

  public void a(com.viber.voip.videoconvert.gpu.opengl.e parame, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, c.c paramc)
  {
    a(parame, paramc);
    if (this.l != null)
      this.l.a(paramArrayOfFloat1, 0);
    parame.a(i(), paramArrayOfFloat1, paramArrayOfFloat2);
  }

  public void b()
  {
    this.h.start();
  }

  public void c()
  {
    this.h.stop();
  }

  public void d()
  {
    this.h.reset();
    this.h.release();
    this.h = null;
    super.d();
  }

  public long e()
  {
    if (!this.j)
      this.k = (1000L * (1000L * this.h.getCurrentPosition()));
    return this.k;
  }

  public long f()
  {
    return this.h.getVideoWidth();
  }

  public long g()
  {
    return this.h.getVideoHeight();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.f.b
 * JD-Core Version:    0.6.2
 */