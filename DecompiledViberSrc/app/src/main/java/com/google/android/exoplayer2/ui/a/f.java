package com.google.android.exoplayer2.ui.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.aa.c;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(15)
public final class f extends GLSurfaceView
{
  private final SensorManager a;
  private final Sensor b;
  private final a c;
  private final b d;
  private final Handler e = new Handler(Looper.getMainLooper());
  private final i f;
  private final c g;
  private c h;
  private SurfaceTexture i;
  private Surface j;
  private aa.c k;

  public f(Context paramContext)
  {
    this(paramContext, null);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = ((SensorManager)a.a(paramContext.getSystemService("sensor")));
    int m = ag.a;
    Sensor localSensor = null;
    if (m >= 18)
      localSensor = this.a.getDefaultSensor(15);
    if (localSensor == null)
      localSensor = this.a.getDefaultSensor(11);
    this.b = localSensor;
    this.g = new c();
    this.d = new b(this.g);
    this.f = new i(paramContext, this.d, 25.0F);
    this.c = new a(((WindowManager)a.a((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay(), this.f, this.d);
    setEGLContextClientVersion(2);
    setRenderer(this.d);
    setOnTouchListener(this.f);
  }

  private static void a(SurfaceTexture paramSurfaceTexture, Surface paramSurface)
  {
    if (paramSurfaceTexture != null)
      paramSurfaceTexture.release();
    if (paramSurface != null)
      paramSurface.release();
  }

  private void b(SurfaceTexture paramSurfaceTexture)
  {
    this.e.post(new h(this, paramSurfaceTexture));
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.e.post(new g(this));
  }

  public void onPause()
  {
    if (this.b != null)
      this.a.unregisterListener(this.c);
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    if (this.b != null)
      this.a.registerListener(this.c, this.b, 0);
  }

  public void setDefaultStereoMode(int paramInt)
  {
    this.g.a(paramInt);
  }

  public void setSingleTapListener(e parame)
  {
    this.f.a(parame);
  }

  public void setSurfaceListener(c paramc)
  {
    this.h = paramc;
  }

  public void setVideoComponent(aa.c paramc)
  {
    if (paramc == this.k);
    do
    {
      return;
      if (this.k != null)
      {
        if (this.j != null)
          this.k.a(this.j);
        this.k.b(this.g);
        this.k.b(this.g);
      }
      this.k = paramc;
    }
    while (this.k == null);
    this.k.a(this.g);
    this.k.a(this.g);
    this.k.b(this.j);
  }

  private static class a
    implements SensorEventListener
  {
    private final float[] a = new float[16];
    private final float[] b = new float[16];
    private final float[] c = new float[3];
    private final Display d;
    private final i e;
    private final f.b f;

    public a(Display paramDisplay, i parami, f.b paramb)
    {
      this.d = paramDisplay;
      this.e = parami;
      this.f = paramb;
    }

    public void onAccuracyChanged(Sensor paramSensor, int paramInt)
    {
    }

    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      int i = 130;
      int j = 129;
      SensorManager.getRotationMatrixFromVector(this.b, paramSensorEvent.values);
      switch (this.d.getRotation())
      {
      default:
        i = 2;
        j = 1;
      case 2:
      case 3:
      case 1:
      }
      while (true)
      {
        SensorManager.remapCoordinateSystem(this.b, j, i, this.a);
        SensorManager.remapCoordinateSystem(this.a, 1, 131, this.b);
        SensorManager.getOrientation(this.b, this.c);
        float f1 = this.c[2];
        this.e.a(f1);
        Matrix.rotateM(this.a, 0, 90.0F, 1.0F, 0.0F, 0.0F);
        this.f.a(this.a, f1);
        return;
        j = i;
        i = 1;
        continue;
        i = j;
        j = 2;
      }
    }
  }

  class b
    implements GLSurfaceView.Renderer, i.a
  {
    private final c b;
    private final float[] c = new float[16];
    private final float[] d = new float[16];
    private final float[] e = new float[16];
    private final float[] f = new float[16];
    private final float[] g = new float[16];
    private float h;
    private float i;
    private final float[] j = new float[16];
    private final float[] k = new float[16];

    public b(c arg2)
    {
      Object localObject;
      this.b = localObject;
      Matrix.setIdentityM(this.e, 0);
      Matrix.setIdentityM(this.f, 0);
      Matrix.setIdentityM(this.g, 0);
      this.i = 3.141593F;
    }

    private float a(float paramFloat)
    {
      if (paramFloat > 1.0F);
      for (int m = 1; m != 0; m = 0)
        return (float)(2.0D * Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0D)) / paramFloat)));
      return 90.0F;
    }

    private void a()
    {
      Matrix.setRotateM(this.f, 0, -this.h, (float)Math.cos(this.i), (float)Math.sin(this.i), 0.0F);
    }

    public void a(PointF paramPointF)
    {
      try
      {
        this.h = paramPointF.y;
        a();
        Matrix.setRotateM(this.g, 0, -paramPointF.x, 0.0F, 1.0F, 0.0F);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void a(float[] paramArrayOfFloat, float paramFloat)
    {
      try
      {
        System.arraycopy(paramArrayOfFloat, 0, this.e, 0, this.e.length);
        this.i = (-paramFloat);
        a();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onDrawFrame(GL10 paramGL10)
    {
      try
      {
        Matrix.multiplyMM(this.k, 0, this.e, 0, this.g, 0);
        Matrix.multiplyMM(this.j, 0, this.f, 0, this.k, 0);
        Matrix.multiplyMM(this.d, 0, this.c, 0, this.j, 0);
        this.b.a(this.d, 0);
        return;
      }
      finally
      {
      }
    }

    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      float f1 = paramInt1 / paramInt2;
      float f2 = a(f1);
      Matrix.perspectiveM(this.c, 0, f2, f1, 0.1F, 100.0F);
    }

    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      try
      {
        f.a(f.this, this.b.a());
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  public static abstract interface c
  {
    public abstract void a(Surface paramSurface);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.a.f
 * JD-Core Version:    0.6.2
 */