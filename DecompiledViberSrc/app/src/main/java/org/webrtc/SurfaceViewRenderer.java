package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SurfaceViewRenderer extends SurfaceView
  implements SurfaceHolder.Callback, RendererCommon.RendererEvents, VideoSink
{
  private static final String TAG = "SurfaceViewRenderer";
  private final SurfaceEglRenderer eglRenderer = new SurfaceEglRenderer(this.resourceName);
  private boolean enableFixedSize;
  private RendererCommon.RendererEvents rendererEvents;
  private final String resourceName = getResourceName();
  private int rotatedFrameHeight;
  private int rotatedFrameWidth;
  private int surfaceHeight;
  private int surfaceWidth;
  private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();

  public SurfaceViewRenderer(Context paramContext)
  {
    super(paramContext);
    getHolder().addCallback(this);
    getHolder().addCallback(this.eglRenderer);
  }

  public SurfaceViewRenderer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getHolder().addCallback(this);
    getHolder().addCallback(this.eglRenderer);
  }

  private String getResourceName()
  {
    try
    {
      String str = getResources().getResourceEntryName(getId());
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
    }
    return "";
  }

  private void logD(String paramString)
  {
    Logging.d("SurfaceViewRenderer", this.resourceName + ": " + paramString);
  }

  private void postOrRun(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }

  private void updateSurfaceSize()
  {
    ThreadUtils.checkIsOnMainThread();
    if ((this.enableFixedSize) && (this.rotatedFrameWidth != 0) && (this.rotatedFrameHeight != 0) && (getWidth() != 0) && (getHeight() != 0))
    {
      float f = getWidth() / getHeight();
      int i;
      if (this.rotatedFrameWidth / this.rotatedFrameHeight > f)
        i = (int)(f * this.rotatedFrameHeight);
      for (int j = this.rotatedFrameHeight; ; j = (int)(this.rotatedFrameWidth / f))
      {
        int k = Math.min(getWidth(), i);
        int m = Math.min(getHeight(), j);
        logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + k + "x" + m + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if ((k != this.surfaceWidth) || (m != this.surfaceHeight))
        {
          this.surfaceWidth = k;
          this.surfaceHeight = m;
          getHolder().setFixedSize(k, m);
        }
        return;
        i = this.rotatedFrameWidth;
      }
    }
    this.surfaceHeight = 0;
    this.surfaceWidth = 0;
    getHolder().setSizeFromLayout();
  }

  public void addFrameListener(EglRenderer.FrameListener paramFrameListener, float paramFloat)
  {
    this.eglRenderer.addFrameListener(paramFrameListener, paramFloat);
  }

  public void addFrameListener(EglRenderer.FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer)
  {
    this.eglRenderer.addFrameListener(paramFrameListener, paramFloat, paramGlDrawer);
  }

  public void clearImage()
  {
    this.eglRenderer.clearImage();
  }

  public void disableFpsReduction()
  {
    this.eglRenderer.disableFpsReduction();
  }

  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents paramRendererEvents)
  {
    init(paramContext, paramRendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
  }

  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents paramRendererEvents, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    ThreadUtils.checkIsOnMainThread();
    this.rendererEvents = paramRendererEvents;
    this.rotatedFrameWidth = 0;
    this.rotatedFrameHeight = 0;
    this.eglRenderer.init(paramContext, this, paramArrayOfInt, paramGlDrawer);
  }

  public void onFirstFrameRendered()
  {
    if (this.rendererEvents != null)
      this.rendererEvents.onFirstFrameRendered();
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    this.eglRenderer.onFrame(paramVideoFrame);
  }

  public void onFrameResolutionChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.rendererEvents != null)
      this.rendererEvents.onFrameResolutionChanged(paramInt1, paramInt2, paramInt3);
    if ((paramInt3 == 0) || (paramInt3 == 180));
    for (int i = paramInt1; ; i = paramInt2)
    {
      if ((paramInt3 == 0) || (paramInt3 == 180))
        paramInt1 = paramInt2;
      postOrRun(new SurfaceViewRenderer..Lambda.0(this, i, paramInt1));
      return;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadUtils.checkIsOnMainThread();
    this.eglRenderer.setLayoutAspectRatio((paramInt3 - paramInt1) / (paramInt4 - paramInt2));
    updateSurfaceSize();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ThreadUtils.checkIsOnMainThread();
    Point localPoint = this.videoLayoutMeasure.measure(paramInt1, paramInt2, this.rotatedFrameWidth, this.rotatedFrameHeight);
    setMeasuredDimension(localPoint.x, localPoint.y);
    logD("onMeasure(). New size: " + localPoint.x + "x" + localPoint.y);
  }

  public void pauseVideo()
  {
    this.eglRenderer.pauseVideo();
  }

  public void release()
  {
    this.eglRenderer.release();
  }

  public void removeFrameListener(EglRenderer.FrameListener paramFrameListener)
  {
    this.eglRenderer.removeFrameListener(paramFrameListener);
  }

  public void setEnableHardwareScaler(boolean paramBoolean)
  {
    ThreadUtils.checkIsOnMainThread();
    this.enableFixedSize = paramBoolean;
    updateSurfaceSize();
  }

  public void setFpsReduction(float paramFloat)
  {
    this.eglRenderer.setFpsReduction(paramFloat);
  }

  public void setMirror(boolean paramBoolean)
  {
    this.eglRenderer.setMirror(paramBoolean);
  }

  public void setScalingType(RendererCommon.ScalingType paramScalingType)
  {
    ThreadUtils.checkIsOnMainThread();
    this.videoLayoutMeasure.setScalingType(paramScalingType);
    requestLayout();
  }

  public void setScalingType(RendererCommon.ScalingType paramScalingType1, RendererCommon.ScalingType paramScalingType2)
  {
    ThreadUtils.checkIsOnMainThread();
    this.videoLayoutMeasure.setScalingType(paramScalingType1, paramScalingType2);
    requestLayout();
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    this.surfaceHeight = 0;
    this.surfaceWidth = 0;
    updateSurfaceSize();
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SurfaceViewRenderer
 * JD-Core Version:    0.6.2
 */