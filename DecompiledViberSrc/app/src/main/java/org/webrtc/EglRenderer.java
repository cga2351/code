package org.webrtc;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class EglRenderer
  implements VideoSink
{
  private static final long LOG_INTERVAL_SEC = 4L;
  private static final String TAG = "EglRenderer";
  private final GlTextureFrameBuffer bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
  private final Matrix drawMatrix = new Matrix();

  @Nullable
  private RendererCommon.GlDrawer drawer;

  @Nullable
  private EglBase eglBase;
  private final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation(null);
  private final Object fpsReductionLock = new Object();
  private final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
  private final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList();
  private final Object frameLock = new Object();
  private int framesDropped;
  private int framesReceived;
  private int framesRendered;
  private final Object handlerLock = new Object();
  private float layoutAspectRatio;
  private final Object layoutLock = new Object();
  private final Runnable logStatisticsRunnable = new Runnable()
  {
    public void run()
    {
      EglRenderer.this.logStatistics();
      synchronized (EglRenderer.this.handlerLock)
      {
        if (EglRenderer.this.renderThreadHandler != null)
        {
          EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
          EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
        return;
      }
    }
  };
  private long minRenderPeriodNs;
  private boolean mirror;
  protected final String name;
  private long nextFrameTimeNs;

  @Nullable
  private VideoFrame pendingFrame;
  private long renderSwapBufferTimeNs;

  @Nullable
  private Handler renderThreadHandler;
  private long renderTimeNs;
  private final Object statisticsLock = new Object();
  private long statisticsStartTimeNs;

  public EglRenderer(String paramString)
  {
    this.name = paramString;
  }

  private String averageTimeAsString(long paramLong, int paramInt)
  {
    if (paramInt <= 0)
      return "NA";
    return TimeUnit.NANOSECONDS.toMicros(paramLong / paramInt) + " μs";
  }

  private void clearSurfaceOnRenderThread(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.eglBase != null) && (this.eglBase.hasSurface()))
    {
      logD("clearSurface");
      GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      GLES20.glClear(16384);
      this.eglBase.swapBuffers();
    }
  }

  private void createEglSurfaceInternal(Object paramObject)
  {
    this.eglSurfaceCreationRunnable.setSurface(paramObject);
    postToRenderThread(this.eglSurfaceCreationRunnable);
  }

  private void logD(String paramString)
  {
    Logging.d("EglRenderer", this.name + paramString);
  }

  private void logStatistics()
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#.0");
    long l1 = System.nanoTime();
    synchronized (this.statisticsLock)
    {
      long l2 = l1 - this.statisticsStartTimeNs;
      if (l2 <= 0L)
        return;
      float f = (float)(this.framesRendered * TimeUnit.SECONDS.toNanos(1L)) / (float)l2;
      logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(l2) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + localDecimalFormat.format(f) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
      resetStatistics(l1);
      return;
    }
  }

  private void notifyCallbacks(VideoFrame paramVideoFrame, boolean paramBoolean)
  {
    if (this.frameListeners.isEmpty());
    while (true)
    {
      return;
      this.drawMatrix.reset();
      this.drawMatrix.preTranslate(0.5F, 0.5F);
      if (this.mirror)
        this.drawMatrix.preScale(-1.0F, 1.0F);
      this.drawMatrix.preScale(1.0F, -1.0F);
      this.drawMatrix.preTranslate(-0.5F, -0.5F);
      Iterator localIterator = this.frameListeners.iterator();
      while (localIterator.hasNext())
      {
        FrameListenerAndParams localFrameListenerAndParams = (FrameListenerAndParams)localIterator.next();
        if ((paramBoolean) || (!localFrameListenerAndParams.applyFpsReduction))
        {
          localIterator.remove();
          int i = (int)(localFrameListenerAndParams.scale * paramVideoFrame.getRotatedWidth());
          int j = (int)(localFrameListenerAndParams.scale * paramVideoFrame.getRotatedHeight());
          if ((i == 0) || (j == 0))
          {
            localFrameListenerAndParams.listener.onFrame(null);
          }
          else
          {
            this.bitmapTextureFramebuffer.setSize(i, j);
            GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GLES20.glClear(16384);
            this.frameDrawer.drawFrame(paramVideoFrame, localFrameListenerAndParams.drawer, this.drawMatrix, 0, 0, i, j);
            ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(4 * (i * j));
            GLES20.glViewport(0, 0, i, j);
            GLES20.glReadPixels(0, 0, i, j, 6408, 5121, localByteBuffer);
            GLES20.glBindFramebuffer(36160, 0);
            GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
            Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
            localBitmap.copyPixelsFromBuffer(localByteBuffer);
            localFrameListenerAndParams.listener.onFrame(localBitmap);
          }
        }
      }
    }
  }

  private void postToRenderThread(Runnable paramRunnable)
  {
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler != null)
        this.renderThreadHandler.post(paramRunnable);
      return;
    }
  }

  private void renderFrameOnRenderThread()
  {
    VideoFrame localVideoFrame;
    synchronized (this.frameLock)
    {
      if (this.pendingFrame == null)
        return;
      localVideoFrame = this.pendingFrame;
      this.pendingFrame = null;
      if ((this.eglBase == null) || (!this.eglBase.hasSurface()))
      {
        logD("Dropping frame - No surface");
        localVideoFrame.release();
        return;
      }
    }
    while (true)
    {
      boolean bool;
      long l1;
      float f1;
      float f2;
      float f4;
      float f3;
      long l2;
      long l3;
      synchronized (this.fpsReductionLock)
      {
        if (this.minRenderPeriodNs == 9223372036854775807L)
        {
          bool = false;
          l1 = System.nanoTime();
          f1 = localVideoFrame.getRotatedWidth() / localVideoFrame.getRotatedHeight();
          synchronized (this.layoutLock)
          {
            if (this.layoutAspectRatio != 0.0F)
            {
              f2 = this.layoutAspectRatio;
              if (f1 <= f2)
                break label453;
              f4 = f2 / f1;
              f3 = 1.0F;
              this.drawMatrix.reset();
              this.drawMatrix.preTranslate(0.5F, 0.5F);
              if (this.mirror)
                this.drawMatrix.preScale(-1.0F, 1.0F);
              this.drawMatrix.preScale(f4, f3);
              this.drawMatrix.preTranslate(-0.5F, -0.5F);
              if (bool)
              {
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                GLES20.glClear(16384);
                this.frameDrawer.drawFrame(localVideoFrame, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                l2 = System.nanoTime();
                this.eglBase.swapBuffers();
                l3 = System.nanoTime();
              }
            }
          }
        }
      }
      synchronized (this.statisticsLock)
      {
        this.framesRendered = (1 + this.framesRendered);
        this.renderTimeNs += l3 - l1;
        this.renderSwapBufferTimeNs += l3 - l2;
        notifyCallbacks(localVideoFrame, bool);
        localVideoFrame.release();
        return;
        if (this.minRenderPeriodNs <= 0L)
        {
          bool = true;
          continue;
        }
        long l4 = System.nanoTime();
        if (l4 < this.nextFrameTimeNs)
        {
          logD("Skipping frame rendering - fps reduction is active.");
          bool = false;
          continue;
        }
        this.nextFrameTimeNs += this.minRenderPeriodNs;
        this.nextFrameTimeNs = Math.max(this.nextFrameTimeNs, l4);
        bool = true;
        continue;
        localObject4 = finally;
        throw localObject4;
        f2 = f1;
        continue;
        localObject6 = finally;
        throw localObject6;
        label453: f3 = f1 / f2;
        f4 = 1.0F;
      }
    }
  }

  private void resetStatistics(long paramLong)
  {
    synchronized (this.statisticsLock)
    {
      this.statisticsStartTimeNs = paramLong;
      this.framesReceived = 0;
      this.framesDropped = 0;
      this.framesRendered = 0;
      this.renderTimeNs = 0L;
      this.renderSwapBufferTimeNs = 0L;
      return;
    }
  }

  public void addFrameListener(FrameListener paramFrameListener, float paramFloat)
  {
    addFrameListener(paramFrameListener, paramFloat, null, false);
  }

  public void addFrameListener(FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer)
  {
    addFrameListener(paramFrameListener, paramFloat, paramGlDrawer, false);
  }

  public void addFrameListener(FrameListener paramFrameListener, float paramFloat, @Nullable RendererCommon.GlDrawer paramGlDrawer, boolean paramBoolean)
  {
    postToRenderThread(new EglRenderer..Lambda.3(this, paramGlDrawer, paramFrameListener, paramFloat, paramBoolean));
  }

  public void clearImage()
  {
    clearImage(0.0F, 0.0F, 0.0F, 0.0F);
  }

  public void clearImage(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null)
        return;
      this.renderThreadHandler.postAtFrontOfQueue(new EglRenderer..Lambda.7(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
      return;
    }
  }

  public void createEglSurface(SurfaceTexture paramSurfaceTexture)
  {
    createEglSurfaceInternal(paramSurfaceTexture);
  }

  public void createEglSurface(Surface paramSurface)
  {
    createEglSurfaceInternal(paramSurface);
  }

  public void disableFpsReduction()
  {
    setFpsReduction((1.0F / 1.0F));
  }

  public void init(@Nullable EglBase.Context paramContext, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler != null)
        throw new IllegalStateException(this.name + "Already initialized");
    }
    logD("Initializing EglRenderer");
    this.drawer = paramGlDrawer;
    HandlerThread localHandlerThread = new HandlerThread(this.name + "EglRenderer");
    localHandlerThread.start();
    this.renderThreadHandler = new HandlerWithExceptionCallback(localHandlerThread.getLooper(), new Runnable()
    {
      public void run()
      {
        synchronized (EglRenderer.this.handlerLock)
        {
          EglRenderer.access$302(EglRenderer.this, null);
          return;
        }
      }
    });
    ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new EglRenderer..Lambda.0(this, paramContext, paramArrayOfInt));
    this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
    resetStatistics(System.nanoTime());
    this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    synchronized (this.statisticsLock)
    {
      this.framesReceived = (1 + this.framesReceived);
    }
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null)
        logD("Dropping frame - Not initialized or already released.");
      while (true)
      {
        return;
        localObject2 = finally;
        throw localObject2;
        synchronized (this.frameLock)
        {
          if (this.pendingFrame != null)
          {
            i = 1;
            if (i != 0)
              this.pendingFrame.release();
            this.pendingFrame = paramVideoFrame;
            this.pendingFrame.retain();
            this.renderThreadHandler.post(new EglRenderer..Lambda.5(this));
            if (i == 0)
              continue;
            synchronized (this.statisticsLock)
            {
              this.framesDropped = (1 + this.framesDropped);
              return;
            }
          }
          int i = 0;
        }
      }
    }
  }

  public void pauseVideo()
  {
    setFpsReduction(0.0F);
  }

  public void printStackTrace()
  {
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null);
      for (Thread localThread = null; localThread != null; localThread = this.renderThreadHandler.getLooper().getThread())
      {
        StackTraceElement[] arrayOfStackTraceElement = localThread.getStackTrace();
        if (arrayOfStackTraceElement.length <= 0)
          break;
        logD("EglRenderer stack trace:");
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
          logD(arrayOfStackTraceElement[j].toString());
      }
      return;
    }
  }

  public void release()
  {
    logD("Releasing.");
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null)
      {
        logD("Already released");
        return;
      }
      this.renderThreadHandler.removeCallbacks(this.logStatisticsRunnable);
      this.renderThreadHandler.postAtFrontOfQueue(new EglRenderer..Lambda.1(this, localCountDownLatch));
      Looper localLooper = this.renderThreadHandler.getLooper();
      this.renderThreadHandler.post(new EglRenderer..Lambda.2(this, localLooper));
      this.renderThreadHandler = null;
      ThreadUtils.awaitUninterruptibly(localCountDownLatch);
    }
    synchronized (this.frameLock)
    {
      if (this.pendingFrame != null)
      {
        this.pendingFrame.release();
        this.pendingFrame = null;
      }
      logD("Releasing done.");
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  public void releaseEglSurface(Runnable paramRunnable)
  {
    this.eglSurfaceCreationRunnable.setSurface(null);
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler != null)
      {
        this.renderThreadHandler.removeCallbacks(this.eglSurfaceCreationRunnable);
        this.renderThreadHandler.postAtFrontOfQueue(new EglRenderer..Lambda.6(this, paramRunnable));
        return;
      }
      paramRunnable.run();
      return;
    }
  }

  public void removeFrameListener(FrameListener paramFrameListener)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null)
        return;
      if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread())
        throw new RuntimeException("removeFrameListener must not be called on the render thread.");
    }
    postToRenderThread(new EglRenderer..Lambda.4(this, localCountDownLatch, paramFrameListener));
    ThreadUtils.awaitUninterruptibly(localCountDownLatch);
  }

  public void setFpsReduction(float paramFloat)
  {
    logD("setFpsReduction: " + paramFloat);
    synchronized (this.fpsReductionLock)
    {
      long l = this.minRenderPeriodNs;
      if (paramFloat <= 0.0F)
      {
        this.minRenderPeriodNs = 9223372036854775807L;
        if (this.minRenderPeriodNs != l)
          this.nextFrameTimeNs = System.nanoTime();
        return;
      }
      this.minRenderPeriodNs = (()((float)TimeUnit.SECONDS.toNanos(1L) / paramFloat));
    }
  }

  public void setLayoutAspectRatio(float paramFloat)
  {
    logD("setLayoutAspectRatio: " + paramFloat);
    synchronized (this.layoutLock)
    {
      this.layoutAspectRatio = paramFloat;
      return;
    }
  }

  public void setMirror(boolean paramBoolean)
  {
    logD("setMirror: " + paramBoolean);
    synchronized (this.layoutLock)
    {
      this.mirror = paramBoolean;
      return;
    }
  }

  private class EglSurfaceCreation
    implements Runnable
  {
    private Object surface;

    private EglSurfaceCreation()
    {
    }

    public void run()
    {
      try
      {
        if ((this.surface != null) && (EglRenderer.this.eglBase != null) && (!EglRenderer.this.eglBase.hasSurface()))
        {
          if (!(this.surface instanceof Surface))
            break label85;
          EglRenderer.this.eglBase.createSurface((Surface)this.surface);
        }
        while (true)
        {
          EglRenderer.this.eglBase.makeCurrent();
          GLES20.glPixelStorei(3317, 1);
          return;
          label85: if (!(this.surface instanceof SurfaceTexture))
            break;
          EglRenderer.this.eglBase.createSurface((SurfaceTexture)this.surface);
        }
      }
      finally
      {
      }
      throw new IllegalStateException("Invalid surface: " + this.surface);
    }

    public void setSurface(Object paramObject)
    {
      try
      {
        this.surface = paramObject;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  public static abstract interface FrameListener
  {
    public abstract void onFrame(Bitmap paramBitmap);
  }

  private static class FrameListenerAndParams
  {
    public final boolean applyFpsReduction;
    public final RendererCommon.GlDrawer drawer;
    public final EglRenderer.FrameListener listener;
    public final float scale;

    public FrameListenerAndParams(EglRenderer.FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer, boolean paramBoolean)
    {
      this.listener = paramFrameListener;
      this.scale = paramFloat;
      this.drawer = paramGlDrawer;
      this.applyFpsReduction = paramBoolean;
    }
  }

  private static class HandlerWithExceptionCallback extends Handler
  {
    private final Runnable exceptionCallback;

    public HandlerWithExceptionCallback(Looper paramLooper, Runnable paramRunnable)
    {
      super();
      this.exceptionCallback = paramRunnable;
    }

    public void dispatchMessage(Message paramMessage)
    {
      try
      {
        super.dispatchMessage(paramMessage);
        return;
      }
      catch (Exception localException)
      {
        Logging.e("EglRenderer", "Exception on EglRenderer thread", localException);
        this.exceptionCallback.run();
        throw localException;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.EglRenderer
 * JD-Core Version:    0.6.2
 */