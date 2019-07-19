package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalExifThumbnailProducer
  implements ThumbnailProducer<EncodedImage>
{
  private static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;

  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
  private final ContentResolver mContentResolver;
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  public LocalExifThumbnailProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mContentResolver = paramContentResolver;
  }

  private EncodedImage buildEncodedImage(PooledByteBuffer paramPooledByteBuffer, ExifInterface paramExifInterface)
  {
    Pair localPair = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(paramPooledByteBuffer));
    int i = getRotationAngle(paramExifInterface);
    int j;
    if (localPair != null)
      j = ((Integer)localPair.first).intValue();
    while (true)
    {
      int k;
      CloseableReference localCloseableReference;
      if (localPair != null)
      {
        k = ((Integer)localPair.second).intValue();
        localCloseableReference = CloseableReference.of(paramPooledByteBuffer);
      }
      try
      {
        EncodedImage localEncodedImage = new EncodedImage(localCloseableReference);
        CloseableReference.closeSafely(localCloseableReference);
        localEncodedImage.setImageFormat(DefaultImageFormats.JPEG);
        localEncodedImage.setRotationAngle(i);
        localEncodedImage.setWidth(j);
        return localEncodedImage;
        j = -1;
        continue;
        k = -1;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }

  private int getRotationAngle(ExifInterface paramExifInterface)
  {
    return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(paramExifInterface.getAttribute("Orientation")));
  }

  public boolean canProvideImageForSize(ResizeOptions paramResizeOptions)
  {
    return ThumbnailSizeChecker.isImageBigEnough(512, 512, paramResizeOptions);
  }

  @VisibleForTesting
  boolean canReadAsFile(String paramString)
    throws IOException
  {
    if (paramString == null);
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    }
    while ((!localFile.exists()) || (!localFile.canRead()));
    return true;
  }

  @Nullable
  @VisibleForTesting
  ExifInterface getExifInterface(Uri paramUri)
  {
    String str = UriUtil.getRealPathFromUri(this.mContentResolver, paramUri);
    try
    {
      if (canReadAsFile(str))
      {
        ExifInterface localExifInterface = new ExifInterface(str);
        return localExifInterface;
      }
    }
    catch (StackOverflowError localStackOverflowError)
    {
      FLog.e(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
      return null;
    }
    catch (IOException localIOException)
    {
      label39: break label39;
    }
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    final StatefulProducerRunnable local1 = new StatefulProducerRunnable(paramConsumer, paramProducerContext.getListener(), "LocalExifThumbnailProducer", paramProducerContext.getId())
    {
      protected void disposeResult(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramAnonymousEncodedImage);
      }

      protected Map<String, String> getExtraMapOnSuccess(EncodedImage paramAnonymousEncodedImage)
      {
        if (paramAnonymousEncodedImage != null);
        for (boolean bool = true; ; bool = false)
          return ImmutableMap.of("createdThumbnail", Boolean.toString(bool));
      }

      protected EncodedImage getResult()
        throws Exception
      {
        Uri localUri = this.val$imageRequest.getSourceUri();
        ExifInterface localExifInterface = LocalExifThumbnailProducer.this.getExifInterface(localUri);
        if ((localExifInterface == null) || (!localExifInterface.hasThumbnail()))
          return null;
        byte[] arrayOfByte = localExifInterface.getThumbnail();
        PooledByteBuffer localPooledByteBuffer = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(arrayOfByte);
        return LocalExifThumbnailProducer.this.buildEncodedImage(localPooledByteBuffer, localExifInterface);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        local1.cancel();
      }
    });
    this.mExecutor.execute(local1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalExifThumbnailProducer
 * JD-Core Version:    0.6.2
 */