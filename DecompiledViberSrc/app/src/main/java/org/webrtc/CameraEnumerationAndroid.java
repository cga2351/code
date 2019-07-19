package org.webrtc;

import android.graphics.ImageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraEnumerationAndroid
{
  static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList(Arrays.asList(arrayOfSize));
  private static final String TAG = "CameraEnumerationAndroid";

  static
  {
    Size[] arrayOfSize = new Size[20];
    arrayOfSize[0] = new Size(160, 120);
    arrayOfSize[1] = new Size(240, 160);
    arrayOfSize[2] = new Size(320, 240);
    arrayOfSize[3] = new Size(400, 240);
    arrayOfSize[4] = new Size(480, 320);
    arrayOfSize[5] = new Size(640, 360);
    arrayOfSize[6] = new Size(640, 480);
    arrayOfSize[7] = new Size(768, 480);
    arrayOfSize[8] = new Size(854, 480);
    arrayOfSize[9] = new Size(800, 600);
    arrayOfSize[10] = new Size(960, 540);
    arrayOfSize[11] = new Size(960, 640);
    arrayOfSize[12] = new Size(1024, 576);
    arrayOfSize[13] = new Size(1024, 600);
    arrayOfSize[14] = new Size(1280, 720);
    arrayOfSize[15] = new Size(1280, 1024);
    arrayOfSize[16] = new Size(1920, 1080);
    arrayOfSize[17] = new Size(1920, 1440);
    arrayOfSize[18] = new Size(2560, 1440);
    arrayOfSize[19] = new Size(3840, 2160);
  }

  public static CameraEnumerationAndroid.CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> paramList, int paramInt)
  {
    return (CameraEnumerationAndroid.CaptureFormat.FramerateRange)Collections.min(paramList, new ClosestComparator(paramInt)
    {
      private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
      private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
      private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
      private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
      private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
      private static final int MIN_FPS_THRESHOLD = 8000;

      private int progressivePenalty(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousInt1 < paramAnonymousInt2)
          return paramAnonymousInt1 * paramAnonymousInt3;
        return paramAnonymousInt2 * paramAnonymousInt3 + paramAnonymousInt4 * (paramAnonymousInt1 - paramAnonymousInt2);
      }

      int diff(CameraEnumerationAndroid.CaptureFormat.FramerateRange paramAnonymousFramerateRange)
      {
        return progressivePenalty(paramAnonymousFramerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs(1000 * this.val$requestedFps - paramAnonymousFramerateRange.max), 5000, 1, 3);
      }
    });
  }

  public static Size getClosestSupportedSize(List<Size> paramList, int paramInt1, final int paramInt2)
  {
    return (Size)Collections.min(paramList, new ClosestComparator(paramInt1)
    {
      int diff(Size paramAnonymousSize)
      {
        return Math.abs(this.val$requestedWidth - paramAnonymousSize.width) + Math.abs(paramInt2 - paramAnonymousSize.height);
      }
    });
  }

  static void reportCameraResolution(Histogram paramHistogram, Size paramSize)
  {
    paramHistogram.addSample(1 + COMMON_RESOLUTIONS.indexOf(paramSize));
  }

  public static class CaptureFormat
  {
    public final FramerateRange framerate;
    public final int height;
    public final int imageFormat = 17;
    public final int width;

    public CaptureFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.framerate = new FramerateRange(paramInt3, paramInt4);
    }

    public CaptureFormat(int paramInt1, int paramInt2, FramerateRange paramFramerateRange)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.framerate = paramFramerateRange;
    }

    public static int frameSize(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 != 17)
        throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
      return paramInt1 * paramInt2 * ImageFormat.getBitsPerPixel(paramInt3) / 8;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof CaptureFormat));
      CaptureFormat localCaptureFormat;
      do
      {
        return false;
        localCaptureFormat = (CaptureFormat)paramObject;
      }
      while ((this.width != localCaptureFormat.width) || (this.height != localCaptureFormat.height) || (!this.framerate.equals(localCaptureFormat.framerate)));
      return true;
    }

    public int frameSize()
    {
      return frameSize(this.width, this.height, 17);
    }

    public int hashCode()
    {
      return 1 + 251 * (65497 * this.width + this.height) + this.framerate.hashCode();
    }

    public String toString()
    {
      return this.width + "x" + this.height + "@" + this.framerate;
    }

    public static class FramerateRange
    {
      public int max;
      public int min;

      public FramerateRange(int paramInt1, int paramInt2)
      {
        this.min = paramInt1;
        this.max = paramInt2;
      }

      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof FramerateRange));
        FramerateRange localFramerateRange;
        do
        {
          return false;
          localFramerateRange = (FramerateRange)paramObject;
        }
        while ((this.min != localFramerateRange.min) || (this.max != localFramerateRange.max));
        return true;
      }

      public int hashCode()
      {
        return 1 + 65537 * this.min + this.max;
      }

      public String toString()
      {
        return "[" + this.min / 1000.0F + ":" + this.max / 1000.0F + "]";
      }
    }
  }

  private static abstract class ClosestComparator<T>
    implements Comparator<T>
  {
    public int compare(T paramT1, T paramT2)
    {
      return diff(paramT1) - diff(paramT2);
    }

    abstract int diff(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CameraEnumerationAndroid
 * JD-Core Version:    0.6.2
 */