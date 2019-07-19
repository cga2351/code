package com.viber.voip.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class ak extends TextureView
  implements MediaController.MediaPlayerControl
{
  private MediaPlayer.OnBufferingUpdateListener A = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      ak.e(ak.this, paramAnonymousInt);
    }
  };
  MediaPlayer.OnVideoSizeChangedListener a = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ak.a(ak.this, paramAnonymousMediaPlayer.getVideoWidth());
      ak.b(ak.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((ak.a(ak.this) != 0) && (ak.b(ak.this) != 0))
      {
        ak.this.getSurfaceTexture().setDefaultBufferSize(ak.a(ak.this), ak.b(ak.this));
        ak.this.requestLayout();
      }
    }
  };
  MediaPlayer.OnPreparedListener b = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      ak.c(ak.this, 2);
      ak.a(ak.this, ak.b(ak.this, ak.c(ak.this, true)));
      if (ak.c(ak.this) != null)
        ak.c(ak.this).onPrepared(ak.d(ak.this));
      if (ak.e(ak.this) != null)
        ak.e(ak.this).setEnabled(true);
      ak.a(ak.this, paramAnonymousMediaPlayer.getVideoWidth());
      ak.b(ak.this, paramAnonymousMediaPlayer.getVideoHeight());
      int i = ak.f(ak.this);
      if (i != 0)
        ak.this.seekTo(i);
      if ((ak.a(ak.this) != 0) && (ak.b(ak.this) != 0))
      {
        ak.this.getSurfaceTexture().setDefaultBufferSize(ak.a(ak.this), ak.b(ak.this));
        if (ak.g(ak.this) == 3)
        {
          ak.this.start();
          if (ak.e(ak.this) != null)
            ak.e(ak.this).show();
        }
      }
      while (ak.g(ak.this) != 3)
      {
        do
          return;
        while ((ak.this.isPlaying()) || ((i == 0) && (ak.this.getCurrentPosition() <= 0)) || (ak.e(ak.this) == null));
        ak.e(ak.this).show(0);
        return;
      }
      ak.this.start();
    }
  };
  TextureView.SurfaceTextureListener c = new TextureView.SurfaceTextureListener()
  {
    public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ak.a(ak.this, new Surface(paramAnonymousSurfaceTexture));
      ak.k(ak.this);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      if (ak.l(ak.this) != null)
      {
        ak.l(ak.this).release();
        ak.a(ak.this, null);
      }
      if (ak.e(ak.this) != null)
        ak.e(ak.this).hide();
      ak.d(ak.this, true);
      return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = 1;
      int j;
      if (ak.g(ak.this) == 3)
      {
        j = i;
        if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0))
          break label84;
      }
      while (true)
      {
        if ((ak.d(ak.this) != null) && (j != 0) && (i != 0))
        {
          if (ak.f(ak.this) != 0)
            ak.this.seekTo(ak.f(ak.this));
          ak.this.start();
        }
        return;
        j = 0;
        break;
        label84: i = 0;
      }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
    }
  };
  private Uri d;
  private Map<String, String> e;
  private int f = 0;
  private int g = 0;
  private Surface h = null;
  private MediaPlayer i = null;
  private int j;
  private int k = 0;
  private int l = 0;
  private MediaController m;
  private MediaPlayer.OnCompletionListener n;
  private MediaPlayer.OnPreparedListener o;
  private int p;
  private MediaPlayer.OnErrorListener q;
  private MediaPlayer.OnInfoListener r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w = true;
  private MediaPlayer.OnCompletionListener x = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      ak.c(ak.this, 5);
      ak.d(ak.this, 5);
      if (ak.e(ak.this) != null)
        ak.e(ak.this).hide();
      if (ak.h(ak.this) != null)
        ak.h(ak.this).onCompletion(ak.d(ak.this));
    }
  };
  private MediaPlayer.OnInfoListener y = new MediaPlayer.OnInfoListener()
  {
    public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (ak.i(ak.this) != null)
        ak.i(ak.this).onInfo(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
      return true;
    }
  };
  private MediaPlayer.OnErrorListener z = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ak.c(ak.this, -1);
      ak.d(ak.this, -1);
      if (ak.e(ak.this) != null)
        ak.e(ak.this).hide();
      if ((ak.j(ak.this) != null) && (ak.j(ak.this).onError(ak.d(ak.this), paramAnonymousInt1, paramAnonymousInt2)));
      while (ak.this.getWindowToken() == null)
        return true;
      ak.this.getContext().getResources();
      if (paramAnonymousInt1 == 200);
      for (int i = 17039381; ; i = 17039377)
      {
        new AlertDialog.Builder(ak.this.getContext()).setMessage(i).setPositiveButton(17039376, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (ak.h(ak.this) != null)
              ak.h(ak.this).onCompletion(ak.d(ak.this));
          }
        }).setCancelable(false).show();
        return true;
      }
    }
  };

  public ak(Context paramContext)
  {
    this(paramContext, null);
  }

  public ak(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ak(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(this.c);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.f = 0;
    this.g = 0;
  }

  private void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.reset();
      this.i.release();
      this.i = null;
      this.f = 0;
      if (paramBoolean)
        this.g = 0;
      if (this.w)
        ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }

  private void c()
  {
    if ((this.h == null) || (Build.VERSION.SDK_INT < 16))
      return;
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, null);
    int[] arrayOfInt1 = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 };
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, arrayOfInt1, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt2);
    EGLConfig localEGLConfig = arrayOfEGLConfig[0];
    EGLContext localEGLContext = localEGL10.eglCreateContext(localEGLDisplay, localEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    EGLSurface localEGLSurface = localEGL10.eglCreateWindowSurface(localEGLDisplay, localEGLConfig, this.h, new int[] { 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, localEGLContext);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    localEGL10.eglSwapBuffers(localEGLDisplay, localEGLSurface);
    localEGL10.eglDestroySurface(localEGLDisplay, localEGLSurface);
    localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroyContext(localEGLDisplay, localEGLContext);
    localEGL10.eglTerminate(localEGLDisplay);
  }

  private void d()
  {
    if ((this.d == null) || (this.h == null))
      return;
    a(false);
    if (this.w)
      ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
    try
    {
      this.i = new MediaPlayer();
      if (this.j != 0)
      {
        this.i.setAudioSessionId(this.j);
        this.i.setOnPreparedListener(this.b);
        this.i.setOnVideoSizeChangedListener(this.a);
        this.i.setOnCompletionListener(this.x);
        this.i.setOnErrorListener(this.z);
        this.i.setOnInfoListener(this.y);
        this.i.setOnBufferingUpdateListener(this.A);
        this.p = 0;
        this.i.setDataSource(getContext().getApplicationContext(), this.d, this.e);
        this.i.setSurface(this.h);
        this.i.setAudioStreamType(3);
        this.i.setScreenOnWhilePlaying(true);
        this.i.prepareAsync();
        this.f = 1;
        e();
        return;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.f = -1;
        this.g = -1;
        this.z.onError(this.i, 1, 0);
        return;
        this.j = this.i.getAudioSessionId();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.f = -1;
      this.g = -1;
      this.z.onError(this.i, 1, 0);
    }
  }

  private void e()
  {
    if ((this.i != null) && (this.m != null))
    {
      this.m.setMediaPlayer(this);
      if (!(getParent() instanceof View))
        break label60;
    }
    label60: for (Object localObject = (View)getParent(); ; localObject = this)
    {
      this.m.setAnchorView((View)localObject);
      this.m.setEnabled(b());
      return;
    }
  }

  private void f()
  {
    if (this.m.isShowing())
    {
      this.m.hide();
      return;
    }
    this.m.show();
  }

  public void a()
  {
    if (this.i != null)
    {
      this.i.stop();
      this.i.release();
      this.i = null;
      this.f = 0;
      this.g = 0;
      if (this.w)
        ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
    c();
  }

  public void a(Uri paramUri, Map<String, String> paramMap)
  {
    this.d = paramUri;
    this.e = paramMap;
    this.s = 0;
    d();
    requestLayout();
    invalidate();
  }

  public boolean b()
  {
    return (this.i != null) && (this.f != -1) && (this.f != 0) && (this.f != 1);
  }

  public boolean canPause()
  {
    return this.t;
  }

  public boolean canSeekBackward()
  {
    return this.u;
  }

  public boolean canSeekForward()
  {
    return this.v;
  }

  public int getAudioSessionId()
  {
    if (this.j == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.j = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.j;
  }

  public int getBufferPercentage()
  {
    if (this.i != null)
      return this.p;
    return 0;
  }

  public int getCurrentPosition()
  {
    if (b())
      return this.i.getCurrentPosition();
    return 0;
  }

  public int getDuration()
  {
    if (b())
      return this.i.getDuration();
    return -1;
  }

  public boolean isPlaying()
  {
    return (b()) && (this.i.isPlaying());
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ak.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(ak.class.getName());
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6))
    {
      i1 = 1;
      if ((!b()) || (i1 == 0) || (this.m == null))
        break label182;
      if ((paramInt != 79) && (paramInt != 85))
        break label114;
      if (!this.i.isPlaying())
        break label101;
      pause();
      this.m.show();
    }
    label101: label114: 
    do
    {
      do
      {
        return true;
        i1 = 0;
        break;
        start();
        this.m.hide();
        return true;
        if (paramInt != 126)
          break label143;
      }
      while (this.i.isPlaying());
      start();
      this.m.hide();
      return true;
      if ((paramInt != 86) && (paramInt != 127))
        break label178;
    }
    while (!this.i.isPlaying());
    label143: pause();
    this.m.show();
    return true;
    label178: f();
    label182: return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(this.k, paramInt1);
    int i2 = getDefaultSize(this.l, paramInt2);
    int i3;
    int i4;
    int i5;
    if ((this.k > 0) && (this.l > 0))
    {
      i3 = View.MeasureSpec.getMode(paramInt1);
      i4 = View.MeasureSpec.getSize(paramInt1);
      i5 = View.MeasureSpec.getMode(paramInt2);
      i2 = View.MeasureSpec.getSize(paramInt2);
      if ((i3 != 1073741824) || (i5 != 1073741824))
        break label148;
      if (i2 * this.k >= i4 * this.l)
        break label111;
      i1 = i2 * this.k / this.l;
    }
    label148: label314: 
    while (true)
    {
      setMeasuredDimension(i1, i2);
      return;
      label111: if (i2 * this.k > i4 * this.l)
      {
        i2 = i4 * this.l / this.k;
        i1 = i4;
        continue;
        int i8;
        if (i3 == 1073741824)
        {
          i8 = i4 * this.l / this.k;
          if ((i5 == -2147483648) && (i8 > i2))
            i1 = i4;
        }
        else if (i5 == 1073741824)
        {
          i1 = i2 * this.k / this.l;
          if ((i3 == -2147483648) && (i1 > i4))
            i1 = i4;
        }
        else
        {
          int i6 = this.k;
          int i7 = this.l;
          if ((i5 == -2147483648) && (i7 > i2));
          for (i1 = i2 * this.k / this.l; ; i1 = i6)
          {
            if ((i3 != -2147483648) || (i1 <= i4))
              break label314;
            i2 = i4 * this.l / this.k;
            i1 = i4;
            break;
            i2 = i7;
          }
          continue;
          i2 = i8;
          i1 = i4;
        }
      }
      else
      {
        i1 = i4;
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((b()) && (this.m != null))
      f();
    return false;
  }

  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((b()) && (this.m != null))
      f();
    return false;
  }

  public void pause()
  {
    if ((b()) && (this.i.isPlaying()))
    {
      this.i.pause();
      this.f = 4;
    }
    this.g = 4;
  }

  public void seekTo(int paramInt)
  {
    if (b())
    {
      this.i.seekTo(paramInt);
      this.s = 0;
      return;
    }
    this.s = paramInt;
  }

  public void setMediaController(MediaController paramMediaController)
  {
    if (this.m != null)
      this.m.hide();
    this.m = paramMediaController;
    e();
  }

  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.n = paramOnCompletionListener;
  }

  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.q = paramOnErrorListener;
  }

  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.r = paramOnInfoListener;
  }

  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.o = paramOnPreparedListener;
  }

  public void setShouldRequestAudioFocus(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }

  public void setVideoURI(Uri paramUri)
  {
    a(paramUri, null);
  }

  public void start()
  {
    if (b())
    {
      this.i.start();
      this.f = 3;
    }
    this.g = 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ak
 * JD-Core Version:    0.6.2
 */