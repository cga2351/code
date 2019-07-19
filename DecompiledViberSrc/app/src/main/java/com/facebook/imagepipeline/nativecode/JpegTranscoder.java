package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class JpegTranscoder
{
  public static final int MAX_QUALITY = 100;
  public static final int MAX_SCALE_NUMERATOR = 16;
  public static final int MIN_QUALITY = 0;
  public static final int MIN_SCALE_NUMERATOR = 1;
  public static final int SCALE_DENOMINATOR = 8;

  static
  {
    ImagePipelineNativeLoader.load();
  }

  public static boolean isExifOrientationAllowed(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    return true;
  }

  public static boolean isRotationAngleAllowed(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 270) && (paramInt % 90 == 0);
  }

  @DoNotStrip
  private static native void nativeTranscodeJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;

  @DoNotStrip
  private static native void nativeTranscodeJpegWithExifOrientation(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;

  public static void transcodeJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    boolean bool1;
    boolean bool2;
    label22: boolean bool3;
    if (paramInt2 >= 1)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 > 16)
        break label113;
      bool2 = true;
      Preconditions.checkArgument(bool2);
      if (paramInt3 < 0)
        break label119;
      bool3 = true;
      label35: Preconditions.checkArgument(bool3);
      if (paramInt3 > 100)
        break label125;
    }
    label113: label119: label125: for (boolean bool4 = true; ; bool4 = false)
    {
      Preconditions.checkArgument(bool4);
      Preconditions.checkArgument(isRotationAngleAllowed(paramInt1));
      boolean bool5;
      if (paramInt2 == 8)
      {
        bool5 = false;
        if (paramInt1 == 0);
      }
      else
      {
        bool5 = true;
      }
      Preconditions.checkArgument(bool5, "no transformation requested");
      nativeTranscodeJpeg((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream), paramInt1, paramInt2, paramInt3);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label22;
      bool3 = false;
      break label35;
    }
  }

  public static void transcodeJpegWithExifOrientation(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    boolean bool1;
    boolean bool2;
    label22: boolean bool3;
    if (paramInt2 >= 1)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 > 16)
        break label114;
      bool2 = true;
      Preconditions.checkArgument(bool2);
      if (paramInt3 < 0)
        break label120;
      bool3 = true;
      label35: Preconditions.checkArgument(bool3);
      if (paramInt3 > 100)
        break label126;
    }
    label114: label120: label126: for (boolean bool4 = true; ; bool4 = false)
    {
      Preconditions.checkArgument(bool4);
      Preconditions.checkArgument(isExifOrientationAllowed(paramInt1));
      boolean bool5;
      if (paramInt2 == 8)
      {
        bool5 = false;
        if (paramInt1 == 1);
      }
      else
      {
        bool5 = true;
      }
      Preconditions.checkArgument(bool5, "no transformation requested");
      nativeTranscodeJpegWithExifOrientation((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream), paramInt1, paramInt2, paramInt3);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label22;
      bool3 = false;
      break label35;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.JpegTranscoder
 * JD-Core Version:    0.6.2
 */