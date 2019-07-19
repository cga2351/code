package com.google.android.exoplayer2.g;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

@TargetApi(17)
public final class f
  implements SurfaceTexture.OnFrameAvailableListener, Runnable
{
  private static final int[] a = { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 };
  private final Handler b;
  private final int[] c;
  private final b d;
  private EGLDisplay e;
  private EGLContext f;
  private EGLSurface g;
  private SurfaceTexture h;

  public f(Handler paramHandler)
  {
    this(paramHandler, null);
  }

  public f(Handler paramHandler, b paramb)
  {
    this.b = paramHandler;
    this.d = paramb;
    this.c = new int[1];
  }

  private static EGLConfig a(EGLDisplay paramEGLDisplay)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    boolean bool = EGL14.eglChooseConfig(paramEGLDisplay, a, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
    if ((!bool) || (arrayOfInt[0] <= 0) || (arrayOfEGLConfig[0] == null))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Boolean.valueOf(bool);
      arrayOfObject[1] = Integer.valueOf(arrayOfInt[0]);
      arrayOfObject[2] = arrayOfEGLConfig[0];
      throw new a(ag.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", arrayOfObject), null);
    }
    return arrayOfEGLConfig[0];
  }

  private static EGLContext a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int[] arrayOfInt;
    if (paramInt == 0)
    {
      arrayOfInt = new int[3];
      arrayOfInt[0] = 12440;
      arrayOfInt[1] = 2;
      arrayOfInt[2] = 12344;
    }
    EGLContext localEGLContext;
    while (true)
    {
      localEGLContext = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL14.EGL_NO_CONTEXT, arrayOfInt, 0);
      if (localEGLContext != null)
        break;
      throw new a("eglCreateContext failed", null);
      arrayOfInt = new int[] { 12440, 2, 12992, 1, 12344 };
    }
    return localEGLContext;
  }

  private static EGLSurface a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int paramInt)
  {
    EGLSurface localEGLSurface;
    if (paramInt == 1)
    {
      localEGLSurface = EGL14.EGL_NO_SURFACE;
      if (!EGL14.eglMakeCurrent(paramEGLDisplay, localEGLSurface, localEGLSurface, paramEGLContext))
        throw new a("eglMakeCurrent failed", null);
    }
    else
    {
      if (paramInt == 2);
      for (int[] arrayOfInt = { 12375, 1, 12374, 1, 12992, 1, 12344 }; ; arrayOfInt = new int[] { 12375, 1, 12374, 1, 12344 })
      {
        localEGLSurface = EGL14.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, arrayOfInt, 0);
        if (localEGLSurface != null)
          break;
        throw new a("eglCreatePbufferSurface failed", null);
      }
    }
    return localEGLSurface;
  }

  private static void a(int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    int i = GLES20.glGetError();
    if (i != 0)
      throw new a("glGenTextures failed. Error: " + Integer.toHexString(i), null);
  }

  private void c()
  {
    if (this.d != null)
      this.d.a();
  }

  private static EGLDisplay d()
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay == null)
      throw new a("eglGetDisplay failed", null);
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(localEGLDisplay, arrayOfInt, 0, arrayOfInt, 1))
      throw new a("eglInitialize failed", null);
    return localEGLDisplay;
  }

  public void a()
  {
    this.b.removeCallbacks(this);
    try
    {
      if (this.h != null)
      {
        this.h.release();
        GLES20.glDeleteTextures(1, this.c, 0);
      }
      return;
    }
    finally
    {
      if ((this.e != null) && (!this.e.equals(EGL14.EGL_NO_DISPLAY)))
        EGL14.eglMakeCurrent(this.e, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      if ((this.g != null) && (!this.g.equals(EGL14.EGL_NO_SURFACE)))
        EGL14.eglDestroySurface(this.e, this.g);
      if (this.f != null)
        EGL14.eglDestroyContext(this.e, this.f);
      if (ag.a >= 19)
        EGL14.eglReleaseThread();
      if ((this.e != null) && (!this.e.equals(EGL14.EGL_NO_DISPLAY)))
        EGL14.eglTerminate(this.e);
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = null;
    }
  }

  public void a(int paramInt)
  {
    this.e = d();
    EGLConfig localEGLConfig = a(this.e);
    this.f = a(this.e, localEGLConfig, paramInt);
    this.g = a(this.e, localEGLConfig, this.f, paramInt);
    a(this.c);
    this.h = new SurfaceTexture(this.c[0]);
    this.h.setOnFrameAvailableListener(this);
  }

  public SurfaceTexture b()
  {
    return (SurfaceTexture)a.a(this.h);
  }

  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.b.post(this);
  }

  public void run()
  {
    c();
    if (this.h != null);
    try
    {
      this.h.updateTexImage();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  public static final class a extends RuntimeException
  {
    private a(String paramString)
    {
      super();
    }
  }

  public static abstract interface b
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.f
 * JD-Core Version:    0.6.2
 */