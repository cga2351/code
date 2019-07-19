package org.webrtc.videoengine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class ViEAndroidGLES20 extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final boolean DEBUG;
  private static final Logger L = ViberEnv.getLogger("ViEAndroidGLES20 - (WEBRTC-JR)");
  private ReentrantLock nativeFunctionLock = new ReentrantLock();
  private boolean nativeFunctionsRegisted = false;
  private long nativeObject = 0L;
  private boolean openGLCreated = false;
  private boolean surfaceCreated = false;
  private int viewHeight = 0;
  private int viewWidth = 0;

  public ViEAndroidGLES20(Context paramContext)
  {
    super(paramContext);
    init(false, 0, 0);
  }

  public ViEAndroidGLES20(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext);
    init(paramBoolean, paramInt1, paramInt2);
  }

  private native int CreateOpenGLNative(long paramLong, int paramInt1, int paramInt2);

  private native void DrawNative(long paramLong);

  public static boolean IsSupported(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
  }

  public static boolean UseOpenGL2(Object paramObject)
  {
    return ViEAndroidGLES20.class.isInstance(paramObject);
  }

  private static void checkEglError(String paramString, EGL10 paramEGL10)
  {
    while (paramEGL10.eglGetError() != 12288);
  }

  private void init(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
      getHolder().setFormat(-3);
    setEGLContextFactory(new ContextFactory(null));
    if (paramBoolean);
    for (ConfigChooser localConfigChooser = new ConfigChooser(8, 8, 8, 8, paramInt1, paramInt2); ; localConfigChooser = new ConfigChooser(5, 6, 5, 0, paramInt1, paramInt2))
    {
      setEGLConfigChooser(localConfigChooser);
      setRenderer(this);
      setRenderMode(0);
      return;
    }
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

  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.surfaceCreated = true;
    this.viewWidth = paramInt1;
    this.viewHeight = paramInt2;
    this.nativeFunctionLock.lock();
    if ((this.nativeFunctionsRegisted) && (CreateOpenGLNative(this.nativeObject, paramInt1, paramInt2) == 0))
      this.openGLCreated = true;
    this.nativeFunctionLock.unlock();
  }

  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
  }

  private static class ConfigChooser
    implements GLSurfaceView.EGLConfigChooser
  {
    private static int EGL_OPENGL_ES2_BIT = 4;
    private static int[] s_configAttribs2 = arrayOfInt;
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[1];

    static
    {
      int[] arrayOfInt = new int[9];
      arrayOfInt[0] = 12324;
      arrayOfInt[1] = 4;
      arrayOfInt[2] = 12323;
      arrayOfInt[3] = 4;
      arrayOfInt[4] = 12322;
      arrayOfInt[5] = 4;
      arrayOfInt[6] = 12352;
      arrayOfInt[7] = EGL_OPENGL_ES2_BIT;
      arrayOfInt[8] = 12344;
    }

    public ConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.mRedSize = paramInt1;
      this.mGreenSize = paramInt2;
      this.mBlueSize = paramInt3;
      this.mAlphaSize = paramInt4;
      this.mDepthSize = paramInt5;
      this.mStencilSize = paramInt6;
    }

    private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue))
        paramInt2 = this.mValue[0];
      return paramInt2;
    }

    private void printConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int i = 0;
      int[] arrayOfInt1 = { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 };
      String[] arrayOfString = { "EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT" };
      int[] arrayOfInt2 = new int[1];
      if (i < arrayOfInt1.length)
      {
        int j = arrayOfInt1[i];
        arrayOfString[i];
        if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, j, arrayOfInt2));
        while (true)
        {
          i++;
          break;
          while (paramEGL10.eglGetError() != 12288);
        }
      }
    }

    private void printConfigs(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int i = paramArrayOfEGLConfig.length;
      for (int j = 0; j < i; j++)
        printConfig(paramEGL10, paramEGLDisplay, paramArrayOfEGLConfig[j]);
    }

    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, s_configAttribs2, null, 0, arrayOfInt);
      int i = arrayOfInt[0];
      if (i <= 0)
        throw new IllegalArgumentException("No configs match configSpec");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      paramEGL10.eglChooseConfig(paramEGLDisplay, s_configAttribs2, arrayOfEGLConfig, i, arrayOfInt);
      return chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    }

    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int i = paramArrayOfEGLConfig.length;
      int j = 0;
      if (j < i)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[j];
        int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k < this.mDepthSize) || (m < this.mStencilSize));
        int n;
        int i1;
        int i2;
        int i3;
        do
        {
          j++;
          break;
          n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          i2 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          i3 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        }
        while ((n != this.mRedSize) || (i1 != this.mGreenSize) || (i2 != this.mBlueSize) || (i3 != this.mAlphaSize));
        return localEGLConfig;
      }
      return null;
    }
  }

  private static class ContextFactory
    implements GLSurfaceView.EGLContextFactory
  {
    private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      ViEAndroidGLES20.checkEglError("Before eglCreateContext", paramEGL10);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = EGL_CONTEXT_CLIENT_VERSION;
      arrayOfInt[1] = 2;
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
      ViEAndroidGLES20.checkEglError("After eglCreateContext", paramEGL10);
      return localEGLContext;
    }

    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViEAndroidGLES20
 * JD-Core Version:    0.6.2
 */