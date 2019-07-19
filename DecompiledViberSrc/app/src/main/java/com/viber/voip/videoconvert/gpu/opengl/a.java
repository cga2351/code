package com.viber.voip.videoconvert.gpu.opengl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.viber.voip.videoconvert.e;
import java.nio.ByteBuffer;

@TargetApi(18)
public class a
  implements c
{
  protected EGLDisplay a = EGL14.EGL_NO_DISPLAY;
  protected EGLContext b = EGL14.EGL_NO_CONTEXT;
  protected EGLSurface c = EGL14.EGL_NO_SURFACE;
  private Surface d;

  public void a(long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.a, this.c, paramLong);
    a("eglPresentationTimeANDROID");
  }

  public void a(Surface paramSurface)
  {
    this.d = paramSurface;
  }

  public void a(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288)
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
  }

  public void doneCurrent()
  {
    EGL14.eglMakeCurrent(this.a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    a("eglDoneCurrent");
  }

  public int getDataType()
  {
    return 5121;
  }

  public String getExtensions()
  {
    String str = GLES20.glGetString(7939);
    a("glGetString(GLES20.GL_EXTENSIONS)");
    return str;
  }

  public int getPixelFormat()
  {
    return 6408;
  }

  public String getRenderer()
  {
    String str = GLES20.glGetString(7937);
    a("glGetString(GLES20.GL_RENDERER)");
    return str;
  }

  public String getVendor()
  {
    String str = GLES20.glGetString(7936);
    a("glGetString(GLES20.GL_VENDOR)");
    return str;
  }

  public void init()
  {
    this.a = EGL14.eglGetDisplay(0);
    if (this.a == EGL14.EGL_NO_DISPLAY)
      throw new RuntimeException("unable to get EGL14 display");
    int[] arrayOfInt1 = new int[2];
    if (!EGL14.eglInitialize(this.a, arrayOfInt1, 0, arrayOfInt1, 1))
      throw new RuntimeException("unable to initialize EGL14");
    int[] arrayOfInt2 = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt3 = new int[1];
    EGL14.eglChooseConfig(this.a, arrayOfInt2, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt3, 0);
    a("eglCreateContext RGB888+recordable ES2");
    int[] arrayOfInt4 = { 12440, 2, 12344 };
    this.b = EGL14.eglCreateContext(this.a, arrayOfEGLConfig[0], EGL14.EGL_NO_CONTEXT, arrayOfInt4, 0);
    a("eglCreateContext");
    int[] arrayOfInt5 = { 12344 };
    this.c = EGL14.eglCreateWindowSurface(this.a, arrayOfEGLConfig[0], this.d, arrayOfInt5, 0);
    a("eglCreateWindowSurface");
  }

  public boolean isExtensionSupported(String paramString)
  {
    String[] arrayOfString = getExtensions().split(" ");
    for (int i = 0; ; i++)
    {
      int j = arrayOfString.length;
      boolean bool = false;
      if (i < j)
      {
        if (arrayOfString[i].compareTo(paramString) == 0)
          bool = true;
      }
      else
        return bool;
    }
  }

  public void makeCurrent()
  {
    EGL14.eglMakeCurrent(this.a, this.c, this.c, this.b);
    a("eglMakeCurrent");
  }

  public void optimize()
  {
  }

  public void readPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.position(0);
    GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
    a("glReadPixels");
  }

  public void release(boolean paramBoolean)
  {
    e.a().a("releasing input surface");
    if (this.d != null)
    {
      this.d.release();
      this.d = null;
    }
    e.a().a("releasing opengl context");
    if (this.a != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      a("eglMakeCurrent");
      EGL14.eglDestroySurface(this.a, this.c);
      a("eglDestroySurface");
      EGL14.eglDestroyContext(this.a, this.b);
      a("eglDestroyContext");
      EGL14.eglTerminate(this.a);
      a("eglTerminate");
      if (paramBoolean)
      {
        e.a().a("calling eglReleaseThread");
        EGL14.eglReleaseThread();
        e.a().a("eglReleaseThread called");
        a("eglReleaseThread");
      }
    }
    this.a = EGL14.EGL_NO_DISPLAY;
    this.b = EGL14.EGL_NO_CONTEXT;
    this.c = EGL14.EGL_NO_SURFACE;
    e.a().a("released gl wrapper");
  }

  public boolean swapBuffers()
  {
    boolean bool = EGL14.eglSwapBuffers(this.a, this.c);
    a("eglSwapBuffers");
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.a
 * JD-Core Version:    0.6.2
 */