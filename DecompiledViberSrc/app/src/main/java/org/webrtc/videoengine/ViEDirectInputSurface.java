package org.webrtc.videoengine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import android.view.SurfaceView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ViEDirectInputSurface extends SurfaceView
{
  private static final Logger L = ViberEnv.getLogger();
  private CodecInputSurface mInputSurface = null;
  private SurfaceTextureManager mStManager = null;
  private Surface mSurface = null;

  protected ViEDirectInputSurface()
  {
    this(ViberApplication.getApplication());
  }

  public ViEDirectInputSurface(Context paramContext)
  {
    super(paramContext);
  }

  protected ViEDirectInputSurface(Surface paramSurface)
  {
    this(ViberApplication.getApplication());
    reset(paramSurface);
  }

  public final SurfaceTexture getSurfaceTexture()
  {
    if (this.mStManager != null)
      return this.mStManager.getSurfaceTexture();
    return null;
  }

  public final void refresh(long paramLong)
  {
    try
    {
      this.mInputSurface.makeCurrent();
      this.mStManager.awaitNewImage();
      this.mStManager.drawImage();
      this.mInputSurface.setPresentationTime(this.mStManager.getSurfaceTexture().getTimestamp());
      this.mInputSurface.swapBuffers();
      this.mInputSurface.freeCurrent();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public final void release()
  {
    if (this.mStManager != null)
      this.mStManager.release();
    if (this.mInputSurface != null)
      this.mInputSurface.release();
    this.mStManager = null;
    this.mInputSurface = null;
    this.mSurface = null;
  }

  protected void reset(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    this.mInputSurface = new CodecInputSurface(this.mSurface);
    this.mInputSurface.makeCurrent();
    this.mStManager = new SurfaceTextureManager(null);
  }

  private static class CodecInputSurface
  {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private Surface mSurface;

    public CodecInputSurface(Surface paramSurface)
    {
      if (paramSurface == null)
        throw new NullPointerException();
      this.mSurface = paramSurface;
      eglSetup();
    }

    private void checkEglError(String paramString)
    {
      int i = EGL14.eglGetError();
      if (i != 12288)
        throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }

    private void eglSetup()
    {
      this.mEGLDisplay = EGL14.eglGetDisplay(0);
      if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
        throw new RuntimeException("unable to get EGL14 display");
      int[] arrayOfInt1 = new int[2];
      if (!EGL14.eglInitialize(this.mEGLDisplay, arrayOfInt1, 0, arrayOfInt1, 1))
        throw new RuntimeException("unable to initialize EGL14");
      int[] arrayOfInt2 = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt3 = new int[1];
      EGL14.eglChooseConfig(this.mEGLDisplay, arrayOfInt2, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt3, 0);
      checkEglError("eglCreateContext RGB888+recordable ES2");
      int[] arrayOfInt4 = { 12440, 2, 12344 };
      this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, arrayOfEGLConfig[0], EGL14.EGL_NO_CONTEXT, arrayOfInt4, 0);
      checkEglError("eglCreateContext");
      int[] arrayOfInt5 = { 12344 };
      this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, arrayOfEGLConfig[0], this.mSurface, arrayOfInt5, 0);
      checkEglError("eglCreateWindowSurface");
    }

    public void freeCurrent()
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      checkEglError("eglMakeCurrent");
    }

    public final Surface getSurface()
    {
      return this.mSurface;
    }

    public void makeCurrent()
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
      checkEglError("eglMakeCurrent");
    }

    public void release()
    {
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEGLDisplay);
      }
      if (this.mSurface != null)
        this.mSurface.release();
      this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
      this.mEGLContext = EGL14.EGL_NO_CONTEXT;
      this.mEGLSurface = EGL14.EGL_NO_SURFACE;
      this.mSurface = null;
    }

    public void setPresentationTime(long paramLong)
    {
      EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, paramLong);
      checkEglError("eglPresentationTimeANDROID");
    }

    public boolean swapBuffers()
    {
      boolean bool = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
      checkEglError("eglSwapBuffers");
      return bool;
    }
  }

  private static class STextureRender
  {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private float[] mMVPMatrix = new float[16];
    private int mProgram;
    private float[] mSTMatrix = new float[16];
    private int mTextureID = -12345;
    private FloatBuffer mTriangleVertices = ByteBuffer.allocateDirect(4 * this.mTriangleVerticesData.length).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final float[] mTriangleVerticesData = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    private int maPositionHandle;
    private int maTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;

    public STextureRender()
    {
      this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
      Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    public static void checkLocation(int paramInt, String paramString)
    {
      if (paramInt < 0)
        throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }

    private int createProgram(String paramString1, String paramString2)
    {
      int i = loadShader(35633, paramString1);
      if (i == 0);
      int j;
      do
      {
        return 0;
        j = loadShader(35632, paramString2);
      }
      while (j == 0);
      int k = GLES20.glCreateProgram();
      if (k == 0);
      GLES20.glAttachShader(k, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(k, j);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(k);
      int[] arrayOfInt = new int[1];
      GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] != 1)
      {
        GLES20.glDeleteProgram(k);
        return 0;
      }
      return k;
    }

    private int loadShader(int paramInt, String paramString)
    {
      int i = GLES20.glCreateShader(paramInt);
      checkGlError("glCreateShader type=" + paramInt);
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      int[] arrayOfInt = new int[1];
      GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] == 0)
      {
        GLES20.glDeleteShader(i);
        return 0;
      }
      return i;
    }

    public void changeFragmentShader(String paramString)
    {
      if (paramString == null)
        paramString = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
      GLES20.glDeleteProgram(this.mProgram);
      this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", paramString);
      if (this.mProgram == 0)
        throw new RuntimeException("failed creating program");
    }

    public void checkGlError(String paramString)
    {
      int i = GLES20.glGetError();
      if (i != 0)
        throw new RuntimeException(paramString + ": glError " + i);
    }

    public void drawFrame(SurfaceTexture paramSurfaceTexture)
    {
      checkGlError("onDrawFrame start");
      paramSurfaceTexture.getTransformMatrix(this.mSTMatrix);
      GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glUseProgram(this.mProgram);
      checkGlError("glUseProgram");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.mTextureID);
      this.mTriangleVertices.position(0);
      GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
      checkGlError("glVertexAttribPointer maPosition");
      GLES20.glEnableVertexAttribArray(this.maPositionHandle);
      checkGlError("glEnableVertexAttribArray maPositionHandle");
      this.mTriangleVertices.position(3);
      GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, this.mTriangleVertices);
      checkGlError("glVertexAttribPointer maTextureHandle");
      GLES20.glEnableVertexAttribArray(this.maTextureHandle);
      checkGlError("glEnableVertexAttribArray maTextureHandle");
      Matrix.setIdentityM(this.mMVPMatrix, 0);
      GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
      GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
      GLES20.glDrawArrays(5, 0, 4);
      checkGlError("glDrawArrays");
      GLES20.glBindTexture(36197, 0);
    }

    public int getTextureId()
    {
      return this.mTextureID;
    }

    public void surfaceCreated()
    {
      this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
      if (this.mProgram == 0)
        throw new RuntimeException("failed creating program");
      this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
      checkLocation(this.maPositionHandle, "aPosition");
      this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
      checkLocation(this.maTextureHandle, "aTextureCoord");
      this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
      checkLocation(this.muMVPMatrixHandle, "uMVPMatrix");
      this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
      checkLocation(this.muSTMatrixHandle, "uSTMatrix");
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.mTextureID = arrayOfInt[0];
      GLES20.glBindTexture(36197, this.mTextureID);
      checkGlError("glBindTexture mTextureID");
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      checkGlError("glTexParameter");
    }
  }

  private static class SurfaceTextureManager
    implements SurfaceTexture.OnFrameAvailableListener
  {
    private boolean mFrameAvailable;
    private Object mFrameSyncObject = new Object();
    private SurfaceTexture mSurfaceTexture;
    private ViEDirectInputSurface.STextureRender mTextureRender = new ViEDirectInputSurface.STextureRender();

    public SurfaceTextureManager(SurfaceTexture paramSurfaceTexture)
    {
      this.mTextureRender.surfaceCreated();
      if (paramSurfaceTexture == null);
      for (this.mSurfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId()); ; this.mSurfaceTexture = paramSurfaceTexture)
      {
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        return;
      }
    }

    public void awaitNewImage()
    {
      synchronized (this.mFrameSyncObject)
      {
        while (true)
        {
          boolean bool = this.mFrameAvailable;
          if (!bool)
            try
            {
              this.mFrameSyncObject.wait(2500L);
              if (!this.mFrameAvailable)
                throw new RuntimeException("Camera frame wait timed out");
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
        }
      }
      this.mFrameAvailable = false;
      this.mTextureRender.checkGlError("before updateTexImage");
      this.mSurfaceTexture.updateTexImage();
    }

    public void changeFragmentShader(String paramString)
    {
      this.mTextureRender.changeFragmentShader(paramString);
    }

    public void drawImage()
    {
      this.mTextureRender.drawFrame(this.mSurfaceTexture);
    }

    public SurfaceTexture getSurfaceTexture()
    {
      return this.mSurfaceTexture;
    }

    public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      synchronized (this.mFrameSyncObject)
      {
        if (this.mFrameAvailable)
          throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
      this.mFrameAvailable = true;
      this.mFrameSyncObject.notifyAll();
    }

    public void release()
    {
      this.mTextureRender = null;
      this.mSurfaceTexture = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViEDirectInputSurface
 * JD-Core Version:    0.6.2
 */