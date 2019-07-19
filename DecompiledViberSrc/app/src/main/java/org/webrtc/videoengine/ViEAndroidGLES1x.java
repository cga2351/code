package org.webrtc.videoengine;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ViEAndroidGLES1x extends GLSurfaceView
{
  int[] GL_CAPS_DISABLE = { 2912, 2896, 2884, 3008, 3042, 3058, 3024, 2960, 2929, 2903 };
  private Ctl ctl = null;
  private ReentrantLock nativeFunctionLock = new ReentrantLock();
  private boolean nativeFunctionsRegisted = false;
  private long nativeObject = 0L;
  private boolean openGLCreated = false;
  private GLRenderer renderer = new GLRenderer(null);
  private Ctl selfCtl = new Ctl()
  {
    public void onGotCaps(GL10 paramAnonymousGL10, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4)
    {
    }

    public void onPrepare()
    {
    }

    public void onRenderFrame(GL10 paramAnonymousGL10)
    {
      ViEAndroidGLES1x.this.onDrawFrame(paramAnonymousGL10);
    }

    public void onSurfaceSizeChange(GL10 paramAnonymousGL10, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ViEAndroidGLES1x.access$102(ViEAndroidGLES1x.this, true);
      ViEAndroidGLES1x.access$202(ViEAndroidGLES1x.this, paramAnonymousInt1);
      ViEAndroidGLES1x.access$302(ViEAndroidGLES1x.this, paramAnonymousInt2);
      ViEAndroidGLES1x.this.nativeFunctionLock.lock();
      if ((ViEAndroidGLES1x.this.nativeFunctionsRegisted) && (ViEAndroidGLES1x.this.CreateOpenGLNative(ViEAndroidGLES1x.this.nativeObject, paramAnonymousInt1, paramAnonymousInt2) == 0))
        ViEAndroidGLES1x.access$802(ViEAndroidGLES1x.this, true);
      ViEAndroidGLES1x.this.nativeFunctionLock.unlock();
    }
  };
  public AtomicBoolean supportsDrawTexture = new AtomicBoolean(false);
  public AtomicBoolean supportsETC1 = new AtomicBoolean(false);
  public AtomicBoolean supportsVBOs = new AtomicBoolean(false);
  private boolean surfaceCreated = false;
  private int viewHeight = 0;
  private int viewWidth = 0;

  public ViEAndroidGLES1x(Context paramContext)
  {
    super(paramContext);
    this.ctl.onPrepare();
    setRenderer(this.renderer);
    requestFocus();
    setDrawingCacheEnabled(false);
    setWillNotCacheDrawing(true);
    setFocusableInTouchMode(true);
    setRenderMode(0);
    setDebugFlags(2);
  }

  private native int CreateOpenGLNative(long paramLong, int paramInt1, int paramInt2);

  private native void DrawNative(long paramLong);

  public static boolean UseOpenGL2(Object paramObject)
  {
    return ViEAndroidGLES1x.class.isInstance(paramObject);
  }

  public void DeRegisterNativeObject()
  {
    this.nativeFunctionLock.lock();
    this.nativeFunctionsRegisted = false;
    this.openGLCreated = false;
    this.nativeObject = 0L;
    this.nativeFunctionLock.unlock();
  }

  public void ReDraw()
  {
    if (this.surfaceCreated)
      requestRender();
  }

  public void RegisterNativeObject(long paramLong)
  {
    this.nativeFunctionLock.lock();
    this.nativeObject = paramLong;
    this.nativeFunctionsRegisted = true;
    this.nativeFunctionLock.unlock();
  }

  public void onDrawFrame(GL10 paramGL10)
  {
    this.nativeFunctionLock.lock();
    if ((!this.nativeFunctionsRegisted) || (!this.surfaceCreated))
      this.nativeFunctionLock.unlock();
    do
    {
      return;
      if (this.openGLCreated)
        break;
    }
    while (CreateOpenGLNative(this.nativeObject, this.viewWidth, this.viewHeight) != 0);
    this.openGLCreated = true;
    DrawNative(this.nativeObject);
    this.nativeFunctionLock.unlock();
  }

  public static abstract interface Ctl
  {
    public abstract void onGotCaps(GL10 paramGL10, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);

    public abstract void onPrepare();

    public abstract void onRenderFrame(GL10 paramGL10);

    public abstract void onSurfaceSizeChange(GL10 paramGL10, int paramInt1, int paramInt2);
  }

  private class GLRenderer
    implements GLSurfaceView.Renderer
  {
    private GLRenderer()
    {
    }

    public void onDrawFrame(GL10 paramGL10)
    {
      ViEAndroidGLES1x.this.ctl.onRenderFrame(paramGL10);
    }

    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = ViEAndroidGLES1x.this.GL_CAPS_DISABLE;
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++)
        paramGL10.glDisable(arrayOfInt[j]);
      paramGL10.glShadeModel(7424);
      ViEAndroidGLES1x.this.ctl.onSurfaceSizeChange(paramGL10, paramInt1, paramInt2);
    }

    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      String str1 = " " + paramGL10.glGetString(7939) + " ";
      String str2 = paramGL10.glGetString(7938);
      boolean bool1 = paramGL10.glGetString(7937).contains("PixelFlinger");
      boolean bool2 = str2.contains(" 1.0");
      ViEAndroidGLES1x.this.supportsDrawTexture.set(str1.contains(" GL_OES_draw_texture "));
      ViEAndroidGLES1x.this.supportsETC1.set(str1.contains(" GL_OES_compressed_ETC1_RGB8_texture "));
      AtomicBoolean localAtomicBoolean = ViEAndroidGLES1x.this.supportsVBOs;
      if ((!bool1) && ((!bool2) || (str1.contains("vertex_buffer_object "))));
      for (boolean bool3 = true; ; bool3 = false)
      {
        localAtomicBoolean.set(bool3);
        ViEAndroidGLES1x.this.ctl.onGotCaps(paramGL10, ViEAndroidGLES1x.this.supportsDrawTexture.get(), ViEAndroidGLES1x.this.supportsETC1.get(), ViEAndroidGLES1x.this.supportsVBOs.get(), bool1);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViEAndroidGLES1x
 * JD-Core Version:    0.6.2
 */