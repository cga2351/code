package com.viber.svg.jni;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.View;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SvgOpenGLView extends GLSurfaceView
  implements SvgViewCommon
{
  private static final Logger L = Logger.create(SvgOpenGLView.class.getSimpleName());
  private static final String LOG_TAG = SvgSurfaceView.class.getSimpleName();
  private SvgViewBackend backend;
  private Runnable glRunnable;
  private boolean surfaceCreated;

  public SvgOpenGLView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public SvgOpenGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  private void init()
  {
    this.backend = new SvgViewBackend();
    setEGLContextClientVersion(2);
    setRenderer(new GLRenderer(null));
  }

  public View asView()
  {
    return this;
  }

  public SvgViewBackend getBackend()
  {
    return this.backend;
  }

  public void load(final String paramString1, final String paramString2, final int paramInt)
  {
    this.glRunnable = new Runnable()
    {
      public void run()
      {
        SvgOpenGLView.this.backend.load(paramString1, paramString2, paramInt);
      }
    };
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.backend.loadFromAsset(paramContext, paramString1, paramString2, paramInt);
  }

  public void setBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.backend = paramSvgViewBackend;
  }

  public void setClock(TimeAware.Clock paramClock)
  {
    this.backend.setClock(paramClock);
  }

  private class GLRenderer
    implements GLSurfaceView.Renderer
  {
    private int height;
    final float[] projectionMatrix = new float[16];
    private Canvas unusedCanvas = new Canvas();
    private int width;

    private GLRenderer()
    {
    }

    public void onDrawFrame(GL10 paramGL10)
    {
      GLES20.glClear(16640);
      if (SvgOpenGLView.this.glRunnable != null)
      {
        SvgOpenGLView.this.glRunnable.run();
        SvgOpenGLView.access$302(SvgOpenGLView.this, null);
      }
      SvgOpenGLView.this.backend.renderToCanvas(this.unusedCanvas, this.width, this.height);
    }

    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.width = paramInt1;
      this.height = paramInt2;
      SvgOpenGLView.L.debug("onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
      (paramInt1 / paramInt2);
      Matrix.orthoM(this.projectionMatrix, 0, 0.0F, 400.0F, 400.0F, 0.0F, -1000.0F, 1000.0F);
    }

    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      SvgOpenGLView.L.debug("onSurfaceCreated end");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgOpenGLView
 * JD-Core Version:    0.6.2
 */