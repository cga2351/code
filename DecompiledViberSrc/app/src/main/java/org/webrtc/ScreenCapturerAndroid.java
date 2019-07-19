package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;
import javax.annotation.Nullable;

@TargetApi(21)
public class ScreenCapturerAndroid
  implements VideoCapturer, VideoSink
{
  private static final int DISPLAY_FLAGS = 3;
  private static final int VIRTUAL_DISPLAY_DPI = 400;

  @Nullable
  private CapturerObserver capturerObserver;
  private int height;
  private boolean isDisposed = false;

  @Nullable
  private MediaProjection mediaProjection;
  private final MediaProjection.Callback mediaProjectionCallback;

  @Nullable
  private MediaProjectionManager mediaProjectionManager;
  private final Intent mediaProjectionPermissionResultData;
  private long numCapturedFrames = 0L;

  @Nullable
  private SurfaceTextureHelper surfaceTextureHelper;

  @Nullable
  private VirtualDisplay virtualDisplay;
  private int width;

  public ScreenCapturerAndroid(Intent paramIntent, MediaProjection.Callback paramCallback)
  {
    this.mediaProjectionPermissionResultData = paramIntent;
    this.mediaProjectionCallback = paramCallback;
  }

  private void checkNotDisposed()
  {
    if (this.isDisposed)
      throw new RuntimeException("capturer is disposed.");
  }

  private void createVirtualDisplay()
  {
    this.surfaceTextureHelper.setTextureSize(this.width, this.height);
    this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, 400, 3, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
  }

  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      checkNotDisposed();
      this.width = paramInt1;
      this.height = paramInt2;
      VirtualDisplay localVirtualDisplay = this.virtualDisplay;
      if (localVirtualDisplay == null);
      while (true)
      {
        return;
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable()
        {
          public void run()
          {
            ScreenCapturerAndroid.this.virtualDisplay.release();
            ScreenCapturerAndroid.this.createVirtualDisplay();
          }
        });
      }
    }
    finally
    {
    }
  }

  public void dispose()
  {
    try
    {
      this.isDisposed = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long getNumCapturedFrames()
  {
    return this.numCapturedFrames;
  }

  public void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    try
    {
      checkNotDisposed();
      if (paramCapturerObserver == null)
        throw new RuntimeException("capturerObserver not set.");
    }
    finally
    {
    }
    this.capturerObserver = paramCapturerObserver;
    if (paramSurfaceTextureHelper == null)
      throw new RuntimeException("surfaceTextureHelper not set.");
    this.surfaceTextureHelper = paramSurfaceTextureHelper;
    this.mediaProjectionManager = ((MediaProjectionManager)paramContext.getSystemService("media_projection"));
  }

  public boolean isScreencast()
  {
    return true;
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    this.numCapturedFrames = (1L + this.numCapturedFrames);
    this.capturerObserver.onFrameCaptured(paramVideoFrame);
  }

  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      checkNotDisposed();
      this.width = paramInt1;
      this.height = paramInt2;
      this.mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
      this.mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
      createVirtualDisplay();
      this.capturerObserver.onCapturerStarted(true);
      this.surfaceTextureHelper.startListening(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void stopCapture()
  {
    try
    {
      checkNotDisposed();
      ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable()
      {
        public void run()
        {
          ScreenCapturerAndroid.this.surfaceTextureHelper.stopListening();
          ScreenCapturerAndroid.this.capturerObserver.onCapturerStopped();
          if (ScreenCapturerAndroid.this.virtualDisplay != null)
          {
            ScreenCapturerAndroid.this.virtualDisplay.release();
            ScreenCapturerAndroid.access$202(ScreenCapturerAndroid.this, null);
          }
          if (ScreenCapturerAndroid.this.mediaProjection != null)
          {
            ScreenCapturerAndroid.this.mediaProjection.unregisterCallback(ScreenCapturerAndroid.this.mediaProjectionCallback);
            ScreenCapturerAndroid.this.mediaProjection.stop();
            ScreenCapturerAndroid.access$302(ScreenCapturerAndroid.this, null);
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.ScreenCapturerAndroid
 * JD-Core Version:    0.6.2
 */