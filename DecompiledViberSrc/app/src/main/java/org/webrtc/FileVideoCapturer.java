package org.webrtc;

import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class FileVideoCapturer
  implements VideoCapturer
{
  private static final String TAG = "FileVideoCapturer";
  private CapturerObserver capturerObserver;
  private final TimerTask tickTask = new TimerTask()
  {
    public void run()
    {
      FileVideoCapturer.this.tick();
    }
  };
  private final Timer timer = new Timer();
  private final VideoReader videoReader;

  public FileVideoCapturer(String paramString)
    throws IOException
  {
    try
    {
      this.videoReader = new VideoReaderY4M(paramString);
      return;
    }
    catch (IOException localIOException)
    {
      Logging.d("FileVideoCapturer", "Could not open video file: " + paramString);
      throw localIOException;
    }
  }

  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void dispose()
  {
    this.videoReader.close();
  }

  public void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    this.capturerObserver = paramCapturerObserver;
  }

  public boolean isScreencast()
  {
    return false;
  }

  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.timer.schedule(this.tickTask, 0L, 1000 / paramInt3);
  }

  public void stopCapture()
    throws InterruptedException
  {
    this.timer.cancel();
  }

  public void tick()
  {
    this.capturerObserver.onFrameCaptured(this.videoReader.getNextFrame());
  }

  private static abstract interface VideoReader
  {
    public abstract void close();

    public abstract VideoFrame getNextFrame();
  }

  private static class VideoReaderY4M
    implements FileVideoCapturer.VideoReader
  {
    private static final int FRAME_DELIMETER_LENGTH = 0;
    private static final String TAG = "VideoReaderY4M";
    private static final String Y4M_FRAME_DELIMETER = "FRAME";
    private final int frameHeight;
    private final int frameWidth;
    private final RandomAccessFile mediaFile;
    private final FileChannel mediaFileChannel;
    private final long videoStart;

    public VideoReaderY4M(String paramString)
      throws IOException
    {
      this.mediaFile = new RandomAccessFile(paramString, "r");
      this.mediaFileChannel = this.mediaFile.getChannel();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = this.mediaFile.read();
      if (i == -1)
        throw new RuntimeException("Found end of file before end of header for file: " + paramString);
      String str1;
      int k;
      int m;
      int n;
      label123: String str2;
      if (i == 10)
      {
        this.videoStart = this.mediaFileChannel.position();
        String[] arrayOfString = localStringBuilder.toString().split("[ ]");
        str1 = "";
        int j = arrayOfString.length;
        k = 0;
        m = 0;
        n = 0;
        if (k >= j)
          break label231;
        str2 = arrayOfString[k];
        switch (str2.charAt(0))
        {
        default:
        case 'W':
        case 'H':
        case 'C':
        }
      }
      while (true)
      {
        k++;
        break label123;
        localStringBuilder.append((char)i);
        break;
        n = Integer.parseInt(str2.substring(1));
        continue;
        m = Integer.parseInt(str2.substring(1));
        continue;
        str1 = str2.substring(1);
      }
      label231: Logging.d("VideoReaderY4M", "Color space: " + str1);
      if ((!str1.equals("420")) && (!str1.equals("420mpeg2")))
        throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
      if ((n % 2 == 1) || (m % 2 == 1))
        throw new IllegalArgumentException("Does not support odd width or height");
      this.frameWidth = n;
      this.frameHeight = m;
      Logging.d("VideoReaderY4M", "frame dim: (" + n + ", " + m + ")");
    }

    public void close()
    {
      try
      {
        this.mediaFile.close();
        return;
      }
      catch (IOException localIOException)
      {
        Logging.e("VideoReaderY4M", "Problem closing file", localIOException);
      }
    }

    public VideoFrame getNextFrame()
    {
      long l = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
      JavaI420Buffer localJavaI420Buffer = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
      ByteBuffer localByteBuffer1 = localJavaI420Buffer.getDataY();
      ByteBuffer localByteBuffer2 = localJavaI420Buffer.getDataU();
      ByteBuffer localByteBuffer3 = localJavaI420Buffer.getDataV();
      int i = (1 + this.frameHeight) / 2;
      (this.frameHeight * localJavaI420Buffer.getStrideY());
      (i * localJavaI420Buffer.getStrideU());
      (i * localJavaI420Buffer.getStrideV());
      ByteBuffer localByteBuffer4;
      try
      {
        localByteBuffer4 = ByteBuffer.allocate(FRAME_DELIMETER_LENGTH);
        if (this.mediaFileChannel.read(localByteBuffer4) < FRAME_DELIMETER_LENGTH)
        {
          this.mediaFileChannel.position(this.videoStart);
          if (this.mediaFileChannel.read(localByteBuffer4) < FRAME_DELIMETER_LENGTH)
            throw new RuntimeException("Error looping video");
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
      String str = new String(localByteBuffer4.array(), Charset.forName("US-ASCII"));
      if (!str.equals("FRAME\n"))
        throw new RuntimeException("Frames should be delimited by FRAME plus newline, found delimter was: '" + str + "'");
      this.mediaFileChannel.read(localByteBuffer1);
      this.mediaFileChannel.read(localByteBuffer2);
      this.mediaFileChannel.read(localByteBuffer3);
      return new VideoFrame(localJavaI420Buffer, 0, l);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.FileVideoCapturer
 * JD-Core Version:    0.6.2
 */