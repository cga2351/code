package com.my.target;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.my.target.common.a.c;

public final class dn
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener, bn
{
  private final bh a = bh.a(200);
  private final a b = new a();
  private final MediaPlayer c;
  private bn.a d;
  private TextureView e;
  private Surface f;
  private c g;
  private int h = 0;
  private float i = 1.0F;
  private int j;

  private dn(MediaPlayer paramMediaPlayer)
  {
    this.c = paramMediaPlayer;
  }

  private void a(Surface paramSurface)
  {
    this.c.setSurface(paramSurface);
    if ((this.f != null) && (this.f != paramSurface))
      this.f.release();
    this.f = paramSurface;
  }

  public static bn k()
  {
    return new dn(new MediaPlayer());
  }

  private void n()
  {
    if (this.e != null)
    {
      if (this.e.getSurfaceTextureListener() == this)
        break label32;
      Log.w("DefaultVideoPlayer", "SurfaceTextureListener already unset or replaced.");
    }
    while (true)
    {
      this.e = null;
      return;
      label32: this.e.setSurfaceTextureListener(null);
    }
  }

  private boolean o()
  {
    return (this.h > 0) && (this.h <= 4);
  }

  public final void a(float paramFloat)
  {
    this.i = paramFloat;
    if (o())
      this.c.setVolume(paramFloat, paramFloat);
    if (this.d != null)
      this.d.a(paramFloat);
  }

  // ERROR //
  @android.annotation.SuppressLint({"Recycle"})
  public final void a(Uri paramUri, TextureView paramTextureView)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 130	com/my/target/dp:a	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 54	com/my/target/dn:h	I
    //   9: ifeq +15 -> 24
    //   12: aload_0
    //   13: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   16: invokevirtual 133	android/media/MediaPlayer:reset	()V
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 54	com/my/target/dn:h	I
    //   24: aload_0
    //   25: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   28: aload_0
    //   29: invokevirtual 137	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   32: aload_0
    //   33: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   36: aload_0
    //   37: invokevirtual 141	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   40: aload_0
    //   41: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   44: aload_0
    //   45: invokevirtual 145	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   48: aload_0
    //   49: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   52: aload_2
    //   53: invokevirtual 149	android/view/TextureView:getContext	()Landroid/content/Context;
    //   56: aload_1
    //   57: invokevirtual 153	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   60: aload_0
    //   61: getfield 61	com/my/target/dn:d	Lcom/my/target/bn$a;
    //   64: ifnull +12 -> 76
    //   67: aload_0
    //   68: getfield 61	com/my/target/dn:d	Lcom/my/target/bn$a;
    //   71: invokeinterface 155 1 0
    //   76: aload_0
    //   77: invokespecial 157	com/my/target/dn:n	()V
    //   80: aload_0
    //   81: aload_2
    //   82: putfield 82	com/my/target/dn:e	Landroid/view/TextureView;
    //   85: aload_2
    //   86: invokevirtual 88	android/view/TextureView:getSurfaceTextureListener	()Landroid/view/TextureView$SurfaceTextureListener;
    //   89: ifnull +11 -> 100
    //   92: ldc 90
    //   94: ldc 159
    //   96: invokestatic 98	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 102	android/view/TextureView:setSurfaceTextureListener	(Landroid/view/TextureView$SurfaceTextureListener;)V
    //   105: aload_2
    //   106: invokevirtual 162	android/view/TextureView:isAvailable	()Z
    //   109: ifeq +84 -> 193
    //   112: aload_2
    //   113: invokevirtual 166	android/view/TextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   116: astore 4
    //   118: aconst_null
    //   119: astore 5
    //   121: aload 4
    //   123: ifnonnull +76 -> 199
    //   126: aload_0
    //   127: aload 5
    //   129: invokespecial 168	com/my/target/dn:a	(Landroid/view/Surface;)V
    //   132: aload_0
    //   133: getfield 58	com/my/target/dn:c	Landroid/media/MediaPlayer;
    //   136: invokevirtual 171	android/media/MediaPlayer:prepareAsync	()V
    //   139: return
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 61	com/my/target/dn:d	Lcom/my/target/bn$a;
    //   145: ifnull +16 -> 161
    //   148: aload_0
    //   149: getfield 61	com/my/target/dn:d	Lcom/my/target/bn$a;
    //   152: aload_3
    //   153: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   156: invokeinterface 176 2 0
    //   161: new 178	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 180
    //   167: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_3
    //   171: invokevirtual 185	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 130	com/my/target/dp:a	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: iconst_5
    //   185: putfield 54	com/my/target/dn:h	I
    //   188: aload_3
    //   189: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   192: return
    //   193: aconst_null
    //   194: astore 4
    //   196: goto -78 -> 118
    //   199: new 71	android/view/Surface
    //   202: dup
    //   203: aload 4
    //   205: invokespecial 196	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   208: astore 5
    //   210: goto -84 -> 126
    //   213: astore 6
    //   215: ldc 198
    //   217: invokestatic 130	com/my/target/dp:a	(Ljava/lang/String;)V
    //   220: return
    //
    // Exception table:
    //   from	to	target	type
    //   48	60	140	java/lang/Exception
    //   132	139	213	java/lang/IllegalStateException
  }

  public final void a(bn.a parama)
  {
    this.d = parama;
  }

  public final void a(c paramc, TextureView paramTextureView)
  {
    String str = (String)paramc.d();
    if (str != null);
    for (Uri localUri = Uri.parse(str); ; localUri = Uri.parse(paramc.a()))
    {
      this.g = paramc;
      a(localUri, paramTextureView);
      return;
    }
  }

  public final boolean a()
  {
    return (this.h > 0) && (this.h < 3);
  }

  public final void b()
  {
    this.h = 5;
    this.a.b(this.b);
    n();
    a(null);
    if (o());
    try
    {
      this.c.stop();
      this.c.release();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        dp.a("stop called in wrong state");
    }
  }

  public final boolean c()
  {
    return this.h == 2;
  }

  public final void d()
  {
    this.a.b(this.b);
    try
    {
      this.c.stop();
      if (this.d != null)
        this.d.b();
      this.h = 3;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        dp.a("stop called in wrong state");
    }
  }

  public final void e()
  {
    a(0.2F);
  }

  public final void f()
  {
    a(0.0F);
  }

  public final void g()
  {
    a(1.0F);
  }

  public final void h()
  {
    if (this.h == 2)
      this.a.a(this.b);
    try
    {
      this.c.start();
      if (this.j <= 0);
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      try
      {
        this.c.seekTo(this.j);
        this.j = 0;
        this.h = 1;
        if (this.d != null)
          this.d.e();
        return;
        localIllegalStateException1 = localIllegalStateException1;
        dp.a("start called in wrong state");
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        while (true)
          dp.a("seekTo called in wrong state");
      }
    }
  }

  public final void i()
  {
    if (this.h == 1)
    {
      this.j = this.c.getCurrentPosition();
      this.a.b(this.b);
    }
    try
    {
      this.c.pause();
      this.h = 2;
      if (this.d != null)
        this.d.d();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        dp.a("pause called in wrong state");
    }
  }

  public final boolean j()
  {
    return this.h == 1;
  }

  public final long l()
  {
    if (o())
      return this.c.getCurrentPosition();
    return 0L;
  }

  public final float m()
  {
    if (o())
      return this.c.getDuration() / 1000.0F;
    return 0.0F;
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.h = 4;
    if (this.d != null)
      this.d.g();
  }

  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.a.b(this.b);
    n();
    a(null);
    String str1;
    String str2;
    if (this.d != null)
    {
      str1 = "Unknown error";
      str2 = "Unknown";
      if (paramInt1 == 100)
        str1 = "Server died";
      if (paramInt2 != -1004)
        break label147;
      str2 = "IO error";
    }
    while (true)
    {
      String str3 = str1 + " (reason: " + str2 + ")";
      dp.a("DefaultVideoPlayerVideo error: " + str3);
      this.d.a(str3);
      if (this.h > 0)
        this.c.reset();
      this.h = 0;
      return true;
      label147: if (paramInt2 == -1007)
        str2 = "Malformed error";
      else if (paramInt2 == -1010)
        str2 = "Unsupported error";
      else if (paramInt2 == -110)
        str2 = "Timed out error";
      else if (paramInt2 == -2147483648)
        str2 = "Low-level system error";
    }
  }

  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.setVolume(this.i, this.i);
    if (this.d != null)
      this.d.c();
    this.a.a(this.b);
    this.h = 1;
    try
    {
      paramMediaPlayer.start();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      dp.a("start called in wrong state");
    }
  }

  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    a(new Surface(paramSurfaceTexture));
  }

  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    a(null);
    return true;
  }

  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
  }

  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
  }

  final class a
    implements Runnable
  {
    a()
    {
    }

    public final void run()
    {
      if (dn.a(dn.this) != null)
      {
        float f1 = (float)dn.this.l() / 1000.0F;
        float f2 = dn.this.m();
        if (f2 > 0.0F)
          dn.a(dn.this).a(f1, f2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dn
 * JD-Core Version:    0.6.2
 */