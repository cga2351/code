package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class EncodedImage
  implements Closeable
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  public static final int UNKNOWN_HEIGHT = -1;
  public static final int UNKNOWN_ROTATION_ANGLE = -1;
  public static final int UNKNOWN_STREAM_SIZE = -1;
  public static final int UNKNOWN_WIDTH = -1;

  @Nullable
  private BytesRange mBytesRange;
  private int mExifOrientation = 0;
  private int mHeight = -1;
  private ImageFormat mImageFormat = ImageFormat.UNKNOWN;

  @Nullable
  private final Supplier<FileInputStream> mInputStreamSupplier;

  @Nullable
  private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
  private int mRotationAngle = -1;
  private int mSampleSize = 1;
  private int mStreamSize = -1;
  private int mWidth = -1;

  public EncodedImage(Supplier<FileInputStream> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    this.mPooledByteBufferRef = null;
    this.mInputStreamSupplier = paramSupplier;
  }

  public EncodedImage(Supplier<FileInputStream> paramSupplier, int paramInt)
  {
    this(paramSupplier);
    this.mStreamSize = paramInt;
  }

  public EncodedImage(CloseableReference<PooledByteBuffer> paramCloseableReference)
  {
    Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
    this.mPooledByteBufferRef = paramCloseableReference.clone();
    this.mInputStreamSupplier = null;
  }

  public static EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null)
      return paramEncodedImage.cloneOrNull();
    return null;
  }

  public static void closeSafely(@Nullable EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null)
      paramEncodedImage.close();
  }

  public static boolean isMetaDataAvailable(EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage.mRotationAngle >= 0) && (paramEncodedImage.mWidth >= 0) && (paramEncodedImage.mHeight >= 0);
  }

  public static boolean isValid(@Nullable EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage != null) && (paramEncodedImage.isValid());
  }

  // ERROR //
  private Pair<Integer, Integer> readImageSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 107	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 113	com/facebook/imageutils/BitmapUtil:decodeDimensions	(Ljava/io/InputStream;)Landroid/util/Pair;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +33 -> 48
    //   18: aload_0
    //   19: aload 4
    //   21: getfield 119	android/util/Pair:first	Ljava/lang/Object;
    //   24: checkcast 121	java/lang/Integer
    //   27: invokevirtual 125	java/lang/Integer:intValue	()I
    //   30: putfield 50	com/facebook/imagepipeline/image/EncodedImage:mWidth	I
    //   33: aload_0
    //   34: aload 4
    //   36: getfield 128	android/util/Pair:second	Ljava/lang/Object;
    //   39: checkcast 121	java/lang/Integer
    //   42: invokevirtual 125	java/lang/Integer:intValue	()I
    //   45: putfield 52	com/facebook/imagepipeline/image/EncodedImage:mHeight	I
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 131	java/io/InputStream:close	()V
    //   56: aload 4
    //   58: areturn
    //   59: astore_2
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 131	java/io/InputStream:close	()V
    //   68: aload_2
    //   69: athrow
    //   70: astore 5
    //   72: aload 4
    //   74: areturn
    //   75: astore_3
    //   76: goto -8 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	59	finally
    //   18	48	59	finally
    //   52	56	70	java/io/IOException
    //   64	68	75	java/io/IOException
  }

  private Pair<Integer, Integer> readWebPImageSize()
  {
    Pair localPair = WebpUtil.getSize(getInputStream());
    if (localPair != null)
    {
      this.mWidth = ((Integer)localPair.first).intValue();
      this.mHeight = ((Integer)localPair.second).intValue();
    }
    return localPair;
  }

  public EncodedImage cloneOrNull()
  {
    EncodedImage localEncodedImage;
    if (this.mInputStreamSupplier != null)
    {
      localEncodedImage = new EncodedImage(this.mInputStreamSupplier, this.mStreamSize);
      if (localEncodedImage != null)
        localEncodedImage.copyMetaDataFrom(this);
      return localEncodedImage;
    }
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference == null)
      localEncodedImage = null;
    while (true)
    {
      CloseableReference.closeSafely(localCloseableReference);
      break;
      try
      {
        localEncodedImage = new EncodedImage(localCloseableReference);
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }

  public void close()
  {
    CloseableReference.closeSafely(this.mPooledByteBufferRef);
  }

  public void copyMetaDataFrom(EncodedImage paramEncodedImage)
  {
    this.mImageFormat = paramEncodedImage.getImageFormat();
    this.mWidth = paramEncodedImage.getWidth();
    this.mHeight = paramEncodedImage.getHeight();
    this.mRotationAngle = paramEncodedImage.getRotationAngle();
    this.mExifOrientation = paramEncodedImage.getExifOrientation();
    this.mSampleSize = paramEncodedImage.getSampleSize();
    this.mStreamSize = paramEncodedImage.getSize();
    this.mBytesRange = paramEncodedImage.getBytesRange();
  }

  public CloseableReference<PooledByteBuffer> getByteBufferRef()
  {
    return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
  }

  @Nullable
  public BytesRange getBytesRange()
  {
    return this.mBytesRange;
  }

  public int getExifOrientation()
  {
    return this.mExifOrientation;
  }

  public String getFirstBytesAsHexString(int paramInt)
  {
    CloseableReference localCloseableReference = getByteBufferRef();
    if (localCloseableReference == null)
      return "";
    int i = Math.min(getSize(), paramInt);
    byte[] arrayOfByte = new byte[i];
    StringBuilder localStringBuilder;
    try
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)localCloseableReference.get();
      if (localPooledByteBuffer == null)
        return "";
      localPooledByteBuffer.read(0, arrayOfByte, 0, i);
      localCloseableReference.close();
      localStringBuilder = new StringBuilder(2 * arrayOfByte.length);
      int j = arrayOfByte.length;
      for (int k = 0; k < j; k++)
      {
        byte b = arrayOfByte[k];
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b);
        localStringBuilder.append(String.format("%02X", arrayOfObject));
      }
    }
    finally
    {
      localCloseableReference.close();
    }
    return localStringBuilder.toString();
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public ImageFormat getImageFormat()
  {
    return this.mImageFormat;
  }

  public InputStream getInputStream()
  {
    if (this.mInputStreamSupplier != null)
      return (InputStream)this.mInputStreamSupplier.get();
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference != null)
      try
      {
        PooledByteBufferInputStream localPooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer)localCloseableReference.get());
        return localPooledByteBufferInputStream;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    return null;
  }

  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }

  public int getSampleSize()
  {
    return this.mSampleSize;
  }

  public int getSize()
  {
    if ((this.mPooledByteBufferRef != null) && (this.mPooledByteBufferRef.get() != null))
      return ((PooledByteBuffer)this.mPooledByteBufferRef.get()).size();
    return this.mStreamSize;
  }

  @VisibleForTesting
  public SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly()
  {
    try
    {
      if (this.mPooledByteBufferRef != null)
      {
        SharedReference localSharedReference2 = this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly();
        localSharedReference1 = localSharedReference2;
        return localSharedReference1;
      }
      SharedReference localSharedReference1 = null;
    }
    finally
    {
    }
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public boolean isCompleteAt(int paramInt)
  {
    if (this.mImageFormat != DefaultImageFormats.JPEG);
    while (this.mInputStreamSupplier != null)
      return true;
    Preconditions.checkNotNull(this.mPooledByteBufferRef);
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)this.mPooledByteBufferRef.get();
    if ((localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isValid()
  {
    try
    {
      if (!CloseableReference.isValid(this.mPooledByteBufferRef))
      {
        Supplier localSupplier = this.mInputStreamSupplier;
        if (localSupplier == null);
      }
      else
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void parseMetaData()
  {
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
    this.mImageFormat = localImageFormat;
    if (DefaultImageFormats.isWebpFormat(localImageFormat));
    for (Pair localPair = readWebPImageSize(); (localImageFormat == DefaultImageFormats.JPEG) && (this.mRotationAngle == -1); localPair = readImageSize())
    {
      if (localPair != null)
      {
        this.mExifOrientation = JfifUtil.getOrientation(getInputStream());
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(this.mExifOrientation);
      }
      return;
    }
    this.mRotationAngle = 0;
  }

  public void setBytesRange(@Nullable BytesRange paramBytesRange)
  {
    this.mBytesRange = paramBytesRange;
  }

  public void setExifOrientation(int paramInt)
  {
    this.mExifOrientation = paramInt;
  }

  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }

  public void setImageFormat(ImageFormat paramImageFormat)
  {
    this.mImageFormat = paramImageFormat;
  }

  public void setRotationAngle(int paramInt)
  {
    this.mRotationAngle = paramInt;
  }

  public void setSampleSize(int paramInt)
  {
    this.mSampleSize = paramInt;
  }

  public void setStreamSize(int paramInt)
  {
    this.mStreamSize = paramInt;
  }

  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.EncodedImage
 * JD-Core Version:    0.6.2
 */