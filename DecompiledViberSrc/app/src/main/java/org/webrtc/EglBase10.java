package org.webrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import javax.annotation.Nullable;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class EglBase10
  implements EglBase
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private final EGL10 egl = (EGL10)EGLContext.getEGL();

  @Nullable
  private EGLConfig eglConfig = getEglConfig(this.eglDisplay, paramArrayOfInt);
  private EGLContext eglContext = createEglContext(paramContext, this.eglDisplay, this.eglConfig);
  private EGLDisplay eglDisplay = getEglDisplay();
  private EGLSurface eglSurface = EGL10.EGL_NO_SURFACE;

  public EglBase10(Context paramContext, int[] paramArrayOfInt)
  {
  }

  private void checkIsNotReleased()
  {
    if ((this.eglDisplay == EGL10.EGL_NO_DISPLAY) || (this.eglContext == EGL10.EGL_NO_CONTEXT) || (this.eglConfig == null))
      throw new RuntimeException("This object has been released");
  }

  private EGLContext createEglContext(@Nullable Context paramContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if ((paramContext != null) && (paramContext.eglContext == EGL10.EGL_NO_CONTEXT))
      throw new RuntimeException("Invalid sharedContext");
    int[] arrayOfInt = { 12440, 2, 12344 };
    EGLContext localEGLContext1;
    if (paramContext == null)
      localEGLContext1 = EGL10.EGL_NO_CONTEXT;
    EGLContext localEGLContext2;
    synchronized (EglBase.lock)
    {
      localEGLContext2 = this.egl.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext1, arrayOfInt);
      if (localEGLContext2 == EGL10.EGL_NO_CONTEXT)
      {
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(this.egl.eglGetError()));
        localEGLContext1 = paramContext.eglContext;
      }
    }
    return localEGLContext2;
  }

  private void createSurfaceInternal(Object paramObject)
  {
    if ((!(paramObject instanceof SurfaceHolder)) && (!(paramObject instanceof SurfaceTexture)))
      throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
    checkIsNotReleased();
    if (this.eglSurface != EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("Already has an EGLSurface");
    int[] arrayOfInt = { 12344 };
    this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, paramObject, arrayOfInt);
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(this.egl.eglGetError()));
  }

  private EGLConfig getEglConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.egl.eglChooseConfig(paramEGLDisplay, paramArrayOfInt, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt))
      throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    if (arrayOfInt[0] <= 0)
      throw new RuntimeException("Unable to find any matching EGL config");
    EGLConfig localEGLConfig = arrayOfEGLConfig[0];
    if (localEGLConfig == null)
      throw new RuntimeException("eglChooseConfig returned null");
    return localEGLConfig;
  }

  private EGLDisplay getEglDisplay()
  {
    EGLDisplay localEGLDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (localEGLDisplay == EGL10.EGL_NO_DISPLAY)
      throw new RuntimeException("Unable to get EGL10 display: 0x" + Integer.toHexString(this.egl.eglGetError()));
    int[] arrayOfInt = new int[2];
    if (!this.egl.eglInitialize(localEGLDisplay, arrayOfInt))
      throw new RuntimeException("Unable to initialize EGL10: 0x" + Integer.toHexString(this.egl.eglGetError()));
    return localEGLDisplay;
  }

  public void createDummyPbufferSurface()
  {
    createPbufferSurface(1, 1);
  }

  public void createPbufferSurface(int paramInt1, int paramInt2)
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("Already has an EGLSurface");
    int[] arrayOfInt = { 12375, paramInt1, 12374, paramInt2, 12344 };
    this.eglSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, arrayOfInt);
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("Failed to create pixel buffer surface with size " + paramInt1 + "x" + paramInt2 + ": 0x" + Integer.toHexString(this.egl.eglGetError()));
  }

  public void createSurface(SurfaceTexture paramSurfaceTexture)
  {
    createSurfaceInternal(paramSurfaceTexture);
  }

  public void createSurface(Surface paramSurface)
  {
    createSurfaceInternal(new SurfaceHolder()
    {
      private final Surface surface;

      public void addCallback(SurfaceHolder.Callback paramAnonymousCallback)
      {
      }

      public Surface getSurface()
      {
        return this.surface;
      }

      @Nullable
      public Rect getSurfaceFrame()
      {
        return null;
      }

      public boolean isCreating()
      {
        return false;
      }

      @Nullable
      public Canvas lockCanvas()
      {
        return null;
      }

      @Nullable
      public Canvas lockCanvas(Rect paramAnonymousRect)
      {
        return null;
      }

      public void removeCallback(SurfaceHolder.Callback paramAnonymousCallback)
      {
      }

      public void setFixedSize(int paramAnonymousInt1, int paramAnonymousInt2)
      {
      }

      public void setFormat(int paramAnonymousInt)
      {
      }

      public void setKeepScreenOn(boolean paramAnonymousBoolean)
      {
      }

      public void setSizeFromLayout()
      {
      }

      @Deprecated
      public void setType(int paramAnonymousInt)
      {
      }

      public void unlockCanvasAndPost(Canvas paramAnonymousCanvas)
      {
      }
    });
  }

  public void detachCurrent()
  {
    synchronized (EglBase.lock)
    {
      if (!this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT))
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }
  }

  public EglBase.Context getEglBaseContext()
  {
    return new Context(this.eglContext);
  }

  public boolean hasSurface()
  {
    return this.eglSurface != EGL10.EGL_NO_SURFACE;
  }

  public void makeCurrent()
  {
    checkIsNotReleased();
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("No EGLSurface - can't make current");
    synchronized (EglBase.lock)
    {
      if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext))
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }
  }

  public void release()
  {
    checkIsNotReleased();
    releaseSurface();
    detachCurrent();
    this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
    this.egl.eglTerminate(this.eglDisplay);
    this.eglContext = EGL10.EGL_NO_CONTEXT;
    this.eglDisplay = EGL10.EGL_NO_DISPLAY;
    this.eglConfig = null;
  }

  public void releaseSurface()
  {
    if (this.eglSurface != EGL10.EGL_NO_SURFACE)
    {
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
      this.eglSurface = EGL10.EGL_NO_SURFACE;
    }
  }

  public int surfaceHeight()
  {
    int[] arrayOfInt = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, arrayOfInt);
    return arrayOfInt[0];
  }

  public int surfaceWidth()
  {
    int[] arrayOfInt = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, arrayOfInt);
    return arrayOfInt[0];
  }

  public void swapBuffers()
  {
    checkIsNotReleased();
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
      throw new RuntimeException("No EGLSurface - can't swap buffers");
    synchronized (EglBase.lock)
    {
      this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
      return;
    }
  }

  public void swapBuffers(long paramLong)
  {
    swapBuffers();
  }

  public static class Context
    implements EglBase.Context
  {
    private final EGLContext eglContext;

    public Context(EGLContext paramEGLContext)
    {
      this.eglContext = paramEGLContext;
    }

    public long getNativeEglContext()
    {
      return 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.EglBase10
 * JD-Core Version:    0.6.2
 */