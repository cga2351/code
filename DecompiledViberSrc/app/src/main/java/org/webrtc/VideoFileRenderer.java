package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

public class VideoFileRenderer
  implements VideoSink
{
  private static final String TAG = "VideoFileRenderer";
  private EglBase eglBase;
  private final HandlerThread fileThread;
  private final Handler fileThreadHandler;
  private int frameCount;
  private final int outputFileHeight;
  private final String outputFileName;
  private final int outputFileWidth;
  private final ByteBuffer outputFrameBuffer;
  private final int outputFrameSize;
  private final HandlerThread renderThread;
  private final Handler renderThreadHandler;
  private final FileOutputStream videoOutFile;
  private YuvConverter yuvConverter;

  public VideoFileRenderer(String paramString, int paramInt1, int paramInt2, final EglBase.Context paramContext)
    throws IOException
  {
    if ((paramInt1 % 2 == 1) || (paramInt2 % 2 == 1))
      throw new IllegalArgumentException("Does not support uneven width or height");
    this.outputFileName = paramString;
    this.outputFileWidth = paramInt1;
    this.outputFileHeight = paramInt2;
    this.outputFrameSize = (3 * (paramInt1 * paramInt2) / 2);
    this.outputFrameBuffer = ByteBuffer.allocateDirect(this.outputFrameSize);
    this.videoOutFile = new FileOutputStream(paramString);
    this.videoOutFile.write(("YUV4MPEG2 C420 W" + paramInt1 + " H" + paramInt2 + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
    this.renderThread = new HandlerThread("VideoFileRendererRenderThread");
    this.renderThread.start();
    this.renderThreadHandler = new Handler(this.renderThread.getLooper());
    this.fileThread = new HandlerThread("VideoFileRendererFileThread");
    this.fileThread.start();
    this.fileThreadHandler = new Handler(this.fileThread.getLooper());
    ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new Runnable()
    {
      public void run()
      {
        VideoFileRenderer.access$002(VideoFileRenderer.this, EglBase..CC.create$$STATIC$$(paramContext, EglBase.CONFIG_PIXEL_BUFFER));
        VideoFileRenderer.this.eglBase.createDummyPbufferSurface();
        VideoFileRenderer.this.eglBase.makeCurrent();
        VideoFileRenderer.access$102(VideoFileRenderer.this, new YuvConverter());
      }
    });
  }

  private void renderFrameOnRenderThread(VideoFrame paramVideoFrame)
  {
    VideoFrame.Buffer localBuffer1 = paramVideoFrame.getBuffer();
    int i;
    int j;
    label38: float f1;
    float f2;
    int k;
    int m;
    if (paramVideoFrame.getRotation() % 180 == 0)
    {
      i = this.outputFileWidth;
      if (paramVideoFrame.getRotation() % 180 != 0)
        break label184;
      j = this.outputFileHeight;
      f1 = localBuffer1.getWidth() / localBuffer1.getHeight();
      f2 = i / j;
      k = localBuffer1.getWidth();
      m = localBuffer1.getHeight();
      if (f2 <= f1)
        break label193;
      m = (int)(m * (f1 / f2));
    }
    while (true)
    {
      VideoFrame.Buffer localBuffer2 = localBuffer1.cropAndScale((localBuffer1.getWidth() - k) / 2, (localBuffer1.getHeight() - m) / 2, k, m, i, j);
      paramVideoFrame.release();
      VideoFrame.I420Buffer localI420Buffer = localBuffer2.toI420();
      localBuffer2.release();
      this.fileThreadHandler.post(new VideoFileRenderer..Lambda.1(this, localI420Buffer, paramVideoFrame));
      return;
      i = this.outputFileHeight;
      break;
      label184: j = this.outputFileWidth;
      break label38;
      label193: k = (int)(k * (f2 / f1));
    }
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    paramVideoFrame.retain();
    this.renderThreadHandler.post(new VideoFileRenderer..Lambda.0(this, paramVideoFrame));
  }

  public void release()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.renderThreadHandler.post(new VideoFileRenderer..Lambda.2(this, localCountDownLatch));
    ThreadUtils.awaitUninterruptibly(localCountDownLatch);
    this.fileThreadHandler.post(new VideoFileRenderer..Lambda.3(this));
    try
    {
      this.fileThread.join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      Logging.e("VideoFileRenderer", "Interrupted while waiting for the write to disk to complete.", localInterruptedException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoFileRenderer
 * JD-Core Version:    0.6.2
 */