package org.webrtc;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class SurfaceEglRenderer extends EglRenderer
  implements SurfaceHolder.Callback
{
  private static final String TAG = "SurfaceEglRenderer";
  private int frameRotation;
  private boolean isFirstFrameRendered;
  private boolean isRenderingPaused = false;
  private final Object layoutLock = new Object();
  private RendererCommon.RendererEvents rendererEvents;
  private int rotatedFrameHeight;
  private int rotatedFrameWidth;

  public SurfaceEglRenderer(String paramString)
  {
    super(paramString);
  }

  private void logD(String paramString)
  {
    Logging.d("SurfaceEglRenderer", this.name + ": " + paramString);
  }

  private void updateFrameDimensionsAndReportEvents(VideoFrame paramVideoFrame)
  {
    synchronized (this.layoutLock)
    {
      if (this.isRenderingPaused)
        return;
      if (!this.isFirstFrameRendered)
      {
        this.isFirstFrameRendered = true;
        logD("Reporting first rendered frame.");
        if (this.rendererEvents != null)
          this.rendererEvents.onFirstFrameRendered();
      }
      if ((this.rotatedFrameWidth != paramVideoFrame.getRotatedWidth()) || (this.rotatedFrameHeight != paramVideoFrame.getRotatedHeight()) || (this.frameRotation != paramVideoFrame.getRotation()))
      {
        logD("Reporting frame resolution changed to " + paramVideoFrame.getBuffer().getWidth() + "x" + paramVideoFrame.getBuffer().getHeight() + " with rotation " + paramVideoFrame.getRotation());
        if (this.rendererEvents != null)
          this.rendererEvents.onFrameResolutionChanged(paramVideoFrame.getBuffer().getWidth(), paramVideoFrame.getBuffer().getHeight(), paramVideoFrame.getRotation());
        this.rotatedFrameWidth = paramVideoFrame.getRotatedWidth();
        this.rotatedFrameHeight = paramVideoFrame.getRotatedHeight();
        this.frameRotation = paramVideoFrame.getRotation();
      }
      return;
    }
  }

  public void disableFpsReduction()
  {
    synchronized (this.layoutLock)
    {
      this.isRenderingPaused = false;
      super.disableFpsReduction();
      return;
    }
  }

  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents paramRendererEvents, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    ThreadUtils.checkIsOnMainThread();
    this.rendererEvents = paramRendererEvents;
    synchronized (this.layoutLock)
    {
      this.isFirstFrameRendered = false;
      this.rotatedFrameWidth = 0;
      this.rotatedFrameHeight = 0;
      this.frameRotation = 0;
      super.init(paramContext, paramArrayOfInt, paramGlDrawer);
      return;
    }
  }

  public void init(EglBase.Context paramContext, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    init(paramContext, null, paramArrayOfInt, paramGlDrawer);
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    updateFrameDimensionsAndReportEvents(paramVideoFrame);
    super.onFrame(paramVideoFrame);
  }

  public void pauseVideo()
  {
    synchronized (this.layoutLock)
    {
      this.isRenderingPaused = true;
      super.pauseVideo();
      return;
    }
  }

  public void setFpsReduction(float paramFloat)
  {
    Object localObject1 = this.layoutLock;
    boolean bool;
    if (paramFloat == 0.0F)
      bool = true;
    try
    {
      while (true)
      {
        this.isRenderingPaused = bool;
        super.setFpsReduction(paramFloat);
        return;
        bool = false;
      }
    }
    finally
    {
    }
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadUtils.checkIsOnMainThread();
    logD("surfaceChanged: format: " + paramInt1 + " size: " + paramInt2 + "x" + paramInt3);
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    createEglSurface(paramSurfaceHolder.getSurface());
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Objects.requireNonNull(localCountDownLatch);
    releaseEglSurface(SurfaceEglRenderer..Lambda.0.get$Lambda(localCountDownLatch));
    ThreadUtils.awaitUninterruptibly(localCountDownLatch);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SurfaceEglRenderer
 * JD-Core Version:    0.6.2
 */