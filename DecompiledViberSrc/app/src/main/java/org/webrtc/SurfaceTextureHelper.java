package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public class SurfaceTextureHelper
{
  private static final String TAG = "SurfaceTextureHelper";
  private final EglBase eglBase;
  private int frameRotation;
  private final Handler handler;
  private boolean hasPendingTexture = false;
  private boolean isQuitting = false;
  private volatile boolean isTextureInUse = false;

  @Nullable
  private VideoSink listener;
  private final int oesTextureId;

  @Nullable
  private VideoSink pendingListener;
  final Runnable setListenerRunnable = new Runnable()
  {
    public void run()
    {
      Logging.d("SurfaceTextureHelper", "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
      SurfaceTextureHelper.access$202(SurfaceTextureHelper.this, SurfaceTextureHelper.this.pendingListener);
      SurfaceTextureHelper.access$102(SurfaceTextureHelper.this, null);
      if (SurfaceTextureHelper.this.hasPendingTexture)
      {
        SurfaceTextureHelper.this.updateTexImage();
        SurfaceTextureHelper.access$302(SurfaceTextureHelper.this, false);
      }
    }
  };
  private final SurfaceTexture surfaceTexture;
  private int textureHeight;
  private int textureWidth;
  private final YuvConverter yuvConverter = new YuvConverter();

  private SurfaceTextureHelper(EglBase.Context paramContext, Handler paramHandler)
  {
    if (paramHandler.getLooper().getThread() != Thread.currentThread())
      throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    this.handler = paramHandler;
    this.eglBase = EglBase..CC.create$$STATIC$$(paramContext, EglBase.CONFIG_PIXEL_BUFFER);
    try
    {
      this.eglBase.createDummyPbufferSurface();
      this.eglBase.makeCurrent();
      this.oesTextureId = GlUtil.generateTexture(36197);
      this.surfaceTexture = new SurfaceTexture(this.oesTextureId);
      setOnFrameAvailableListener(this.surfaceTexture, new SurfaceTextureHelper..Lambda.0(this), paramHandler);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.eglBase.release();
      paramHandler.getLooper().quit();
      throw localRuntimeException;
    }
  }

  public static SurfaceTextureHelper create(final String paramString, EglBase.Context paramContext)
  {
    HandlerThread localHandlerThread = new HandlerThread(paramString);
    localHandlerThread.start();
    final Handler localHandler = new Handler(localHandlerThread.getLooper());
    return (SurfaceTextureHelper)ThreadUtils.invokeAtFrontUninterruptibly(localHandler, new Callable()
    {
      @Nullable
      public SurfaceTextureHelper call()
      {
        try
        {
          SurfaceTextureHelper localSurfaceTextureHelper = new SurfaceTextureHelper(SurfaceTextureHelper.this, localHandler, null);
          return localSurfaceTextureHelper;
        }
        catch (RuntimeException localRuntimeException)
        {
          Logging.e("SurfaceTextureHelper", paramString + " create failure", localRuntimeException);
        }
        return null;
      }
    });
  }

  private void release()
  {
    if (this.handler.getLooper().getThread() != Thread.currentThread())
      throw new IllegalStateException("Wrong thread.");
    if ((this.isTextureInUse) || (!this.isQuitting))
      throw new IllegalStateException("Unexpected release.");
    this.yuvConverter.release();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.oesTextureId;
    GLES20.glDeleteTextures(1, arrayOfInt, 0);
    this.surfaceTexture.release();
    this.eglBase.release();
    this.handler.getLooper().quit();
  }

  private void returnTextureFrame()
  {
    this.handler.post(new SurfaceTextureHelper..Lambda.4(this));
  }

  @TargetApi(21)
  private static void setOnFrameAvailableListener(SurfaceTexture paramSurfaceTexture, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener, paramHandler);
      return;
    }
    paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }

  private void tryDeliverTextureFrame()
  {
    if (this.handler.getLooper().getThread() != Thread.currentThread())
      throw new IllegalStateException("Wrong thread.");
    if ((this.isQuitting) || (!this.hasPendingTexture) || (this.isTextureInUse) || (this.listener == null))
      return;
    this.isTextureInUse = true;
    this.hasPendingTexture = false;
    updateTexImage();
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    long l = this.surfaceTexture.getTimestamp();
    if ((this.textureWidth == 0) || (this.textureHeight == 0))
      throw new RuntimeException("Texture size has not been set.");
    VideoFrame localVideoFrame = new VideoFrame(new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(arrayOfFloat), this.handler, this.yuvConverter, new SurfaceTextureHelper..Lambda.6(this)), this.frameRotation, l);
    this.listener.onFrame(localVideoFrame);
    localVideoFrame.release();
  }

  private void updateTexImage()
  {
    synchronized (EglBase.lock)
    {
      this.surfaceTexture.updateTexImage();
      return;
    }
  }

  public void dispose()
  {
    Logging.d("SurfaceTextureHelper", "dispose()");
    ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new SurfaceTextureHelper..Lambda.5(this));
  }

  public Handler getHandler()
  {
    return this.handler;
  }

  public SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }

  public boolean isTextureInUse()
  {
    return this.isTextureInUse;
  }

  public void setFrameRotation(int paramInt)
  {
    this.handler.post(new SurfaceTextureHelper..Lambda.3(this, paramInt));
  }

  public void setTextureSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
      throw new IllegalArgumentException("Texture width must be positive, but was " + paramInt1);
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("Texture height must be positive, but was " + paramInt2);
    this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    this.handler.post(new SurfaceTextureHelper..Lambda.2(this, paramInt1, paramInt2));
  }

  public void startListening(VideoSink paramVideoSink)
  {
    if ((this.listener != null) || (this.pendingListener != null))
      throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
    this.pendingListener = paramVideoSink;
    this.handler.post(this.setListenerRunnable);
  }

  public void stopListening()
  {
    Logging.d("SurfaceTextureHelper", "stopListening()");
    this.handler.removeCallbacks(this.setListenerRunnable);
    ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new SurfaceTextureHelper..Lambda.1(this));
  }

  @Deprecated
  public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer paramTextureBuffer)
  {
    return paramTextureBuffer.toI420();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SurfaceTextureHelper
 * JD-Core Version:    0.6.2
 */