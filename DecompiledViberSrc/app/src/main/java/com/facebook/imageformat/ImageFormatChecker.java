package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class ImageFormatChecker
{
  private static ImageFormatChecker sInstance;

  @Nullable
  private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
  private final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
  private int mMaxHeaderLength;

  private ImageFormatChecker()
  {
    updateMaxHeaderLength();
  }

  public static ImageFormat getImageFormat(InputStream paramInputStream)
    throws IOException
  {
    return getInstance().determineImageFormat(paramInputStream);
  }

  // ERROR //
  public static ImageFormat getImageFormat(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 40	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokestatic 45	com/facebook/imageformat/ImageFormatChecker:getImageFormat	(Ljava/io/InputStream;)Lcom/facebook/imageformat/ImageFormat;
    //   13: astore 5
    //   15: aload_1
    //   16: invokestatic 51	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   19: aload 5
    //   21: areturn
    //   22: astore 7
    //   24: aconst_null
    //   25: astore_1
    //   26: getstatic 57	com/facebook/imageformat/ImageFormat:UNKNOWN	Lcom/facebook/imageformat/ImageFormat;
    //   29: astore 4
    //   31: aload_1
    //   32: invokestatic 51	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   35: aload 4
    //   37: areturn
    //   38: astore 6
    //   40: aconst_null
    //   41: astore_1
    //   42: aload 6
    //   44: astore_3
    //   45: aload_1
    //   46: invokestatic 51	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   49: aload_3
    //   50: athrow
    //   51: astore_3
    //   52: goto -7 -> 45
    //   55: astore_2
    //   56: goto -30 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/io/IOException
    //   0	9	38	finally
    //   9	15	51	finally
    //   26	31	51	finally
    //   9	15	55	java/io/IOException
  }

  public static ImageFormat getImageFormat_WrapIOException(InputStream paramInputStream)
  {
    try
    {
      ImageFormat localImageFormat = getImageFormat(paramInputStream);
      return localImageFormat;
    }
    catch (IOException localIOException)
    {
      throw Throwables.propagate(localIOException);
    }
  }

  public static ImageFormatChecker getInstance()
  {
    try
    {
      if (sInstance == null)
        sInstance = new ImageFormatChecker();
      ImageFormatChecker localImageFormatChecker = sInstance;
      return localImageFormatChecker;
    }
    finally
    {
    }
  }

  private static int readHeaderFromStream(int paramInt, InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    boolean bool;
    if (paramArrayOfByte.length >= paramInt)
      bool = true;
    while (true)
    {
      Preconditions.checkArgument(bool);
      if (paramInputStream.markSupported())
        try
        {
          paramInputStream.mark(paramInt);
          int i = ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
          return i;
          bool = false;
        }
        finally
        {
          paramInputStream.reset();
        }
    }
    return ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
  }

  private void updateMaxHeaderLength()
  {
    this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      while (localIterator.hasNext())
      {
        ImageFormat.FormatChecker localFormatChecker = (ImageFormat.FormatChecker)localIterator.next();
        this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, localFormatChecker.getHeaderSize());
      }
    }
  }

  public ImageFormat determineImageFormat(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    byte[] arrayOfByte = new byte[this.mMaxHeaderLength];
    int i = readHeaderFromStream(this.mMaxHeaderLength, paramInputStream, arrayOfByte);
    ImageFormat localImageFormat1 = this.mDefaultFormatChecker.determineFormat(arrayOfByte, i);
    if ((localImageFormat1 != null) && (localImageFormat1 != ImageFormat.UNKNOWN))
      return localImageFormat1;
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      while (localIterator.hasNext())
      {
        ImageFormat localImageFormat2 = ((ImageFormat.FormatChecker)localIterator.next()).determineFormat(arrayOfByte, i);
        if ((localImageFormat2 != null) && (localImageFormat2 != ImageFormat.UNKNOWN))
          return localImageFormat2;
      }
    }
    return ImageFormat.UNKNOWN;
  }

  public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> paramList)
  {
    this.mCustomImageFormatCheckers = paramList;
    updateMaxHeaderLength();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormatChecker
 * JD-Core Version:    0.6.2
 */