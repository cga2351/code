package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.net.Uri.Builder;
import b.g;
import b.i;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class PartialDiskCacheProducer
  implements Producer<EncodedImage>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
  private final ByteArrayPool mByteArrayPool;
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  public PartialDiskCacheProducer(BufferedDiskCache paramBufferedDiskCache, CacheKeyFactory paramCacheKeyFactory, PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mInputProducer = paramProducer;
  }

  private static Uri createUriForPartialCacheKey(ImageRequest paramImageRequest)
  {
    return paramImageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", "true").build();
  }

  @Nullable
  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, boolean paramBoolean, int paramInt)
  {
    if (!paramProducerListener.requiresExtraMap(paramString))
      return null;
    if (paramBoolean)
      return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean), "encodedImageSize", String.valueOf(paramInt));
    return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean));
  }

  private static boolean isTaskCancelled(i<?> parami)
  {
    return (parami.c()) || ((parami.d()) && ((parami.f() instanceof CancellationException)));
  }

  private g<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext, final CacheKey paramCacheKey)
  {
    final String str = paramProducerContext.getId();
    return new g()
    {
      public Void then(i<EncodedImage> paramAnonymousi)
        throws Exception
      {
        if (PartialDiskCacheProducer.isTaskCancelled(paramAnonymousi))
        {
          this.val$listener.onProducerFinishWithCancellation(str, "PartialDiskCacheProducer", null);
          paramConsumer.onCancellation();
          return null;
        }
        if (paramAnonymousi.d())
        {
          this.val$listener.onProducerFinishWithFailure(str, "PartialDiskCacheProducer", paramAnonymousi.f(), null);
          PartialDiskCacheProducer.this.startInputProducer(paramConsumer, paramProducerContext, paramCacheKey, null);
          return null;
        }
        EncodedImage localEncodedImage = (EncodedImage)paramAnonymousi.e();
        if (localEncodedImage != null)
        {
          this.val$listener.onProducerFinishWithSuccess(str, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(this.val$listener, str, true, localEncodedImage.getSize()));
          BytesRange localBytesRange = BytesRange.toMax(-1 + localEncodedImage.getSize());
          localEncodedImage.setBytesRange(localBytesRange);
          int i = localEncodedImage.getSize();
          ImageRequest localImageRequest = paramProducerContext.getImageRequest();
          if (localBytesRange.contains(localImageRequest.getBytesRange()))
          {
            this.val$listener.onUltimateProducerReached(str, "PartialDiskCacheProducer", true);
            paramConsumer.onNewResult(localEncodedImage, 9);
            return null;
          }
          paramConsumer.onNewResult(localEncodedImage, 8);
          SettableProducerContext localSettableProducerContext = new SettableProducerContext(ImageRequestBuilder.fromRequest(localImageRequest).setBytesRange(BytesRange.from(i - 1)).build(), paramProducerContext);
          PartialDiskCacheProducer.this.startInputProducer(paramConsumer, localSettableProducerContext, paramCacheKey, localEncodedImage);
          return null;
        }
        this.val$listener.onProducerFinishWithSuccess(str, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(this.val$listener, str, false, 0));
        PartialDiskCacheProducer.this.startInputProducer(paramConsumer, paramProducerContext, paramCacheKey, localEncodedImage);
        return null;
      }
    };
  }

  private void startInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, CacheKey paramCacheKey, @Nullable EncodedImage paramEncodedImage)
  {
    PartialDiskCacheConsumer localPartialDiskCacheConsumer = new PartialDiskCacheConsumer(paramConsumer, this.mDefaultBufferedDiskCache, paramCacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, paramEncodedImage, null);
    this.mInputProducer.produceResults(localPartialDiskCacheConsumer, paramProducerContext);
  }

  private void subscribeTaskForRequestCancellation(final AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramAtomicBoolean.set(true);
      }
    });
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    if (!localImageRequest.isDiskCacheEnabled())
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "PartialDiskCacheProducer");
    Uri localUri = createUriForPartialCacheKey(localImageRequest);
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(localImageRequest, localUri, paramProducerContext.getCallerContext());
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    this.mDefaultBufferedDiskCache.get(localCacheKey, localAtomicBoolean).a(onFinishDiskReads(paramConsumer, paramProducerContext, localCacheKey));
    subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
  }

  private static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private static final int READ_SIZE = 16384;
    private final ByteArrayPool mByteArrayPool;
    private final BufferedDiskCache mDefaultBufferedDiskCache;

    @Nullable
    private final EncodedImage mPartialEncodedImageFromCache;
    private final CacheKey mPartialImageCacheKey;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    private PartialDiskCacheConsumer(Consumer<EncodedImage> paramConsumer, BufferedDiskCache paramBufferedDiskCache, CacheKey paramCacheKey, PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, @Nullable EncodedImage paramEncodedImage)
    {
      super();
      this.mDefaultBufferedDiskCache = paramBufferedDiskCache;
      this.mPartialImageCacheKey = paramCacheKey;
      this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
      this.mByteArrayPool = paramByteArrayPool;
      this.mPartialEncodedImageFromCache = paramEncodedImage;
    }

    private void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
      throws IOException
    {
      byte[] arrayOfByte = (byte[])this.mByteArrayPool.get(16384);
      int i = paramInt;
      while (true)
      {
        if (i > 0);
        try
        {
          int j = paramInputStream.read(arrayOfByte, 0, Math.min(16384, i));
          if (j >= 0)
          {
            if (j > 0)
            {
              paramOutputStream.write(arrayOfByte, 0, j);
              i -= j;
            }
          }
          else
          {
            this.mByteArrayPool.release(arrayOfByte);
            if (i > 0)
            {
              Locale localLocale = (Locale)null;
              Object[] arrayOfObject = new Object[2];
              arrayOfObject[0] = Integer.valueOf(paramInt);
              arrayOfObject[1] = Integer.valueOf(i);
              throw new IOException(String.format(localLocale, "Failed to read %d bytes - finished %d short", arrayOfObject));
            }
          }
        }
        finally
        {
          this.mByteArrayPool.release(arrayOfByte);
        }
      }
    }

    private PooledByteBufferOutputStream merge(EncodedImage paramEncodedImage1, EncodedImage paramEncodedImage2)
      throws IOException
    {
      int i = paramEncodedImage2.getSize() + paramEncodedImage2.getBytesRange().from;
      PooledByteBufferOutputStream localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
      int j = paramEncodedImage2.getBytesRange().from;
      copy(paramEncodedImage1.getInputStream(), localPooledByteBufferOutputStream, j);
      copy(paramEncodedImage2.getInputStream(), localPooledByteBufferOutputStream, paramEncodedImage2.getSize());
      return localPooledByteBufferOutputStream;
    }

    // ERROR //
    private void sendFinalResultToConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 129	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
      //   4: invokestatic 135	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   7: astore_2
      //   8: new 96	com/facebook/imagepipeline/image/EncodedImage
      //   11: dup
      //   12: aload_2
      //   13: invokespecial 138	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   16: astore_3
      //   17: aload_3
      //   18: invokevirtual 142	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   21: aload_0
      //   22: invokevirtual 146	com/facebook/imagepipeline/producers/PartialDiskCacheProducer$PartialDiskCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   25: aload_3
      //   26: iconst_1
      //   27: invokeinterface 152 3 0
      //   32: aload_3
      //   33: invokestatic 156	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   36: aload_2
      //   37: invokestatic 158	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   40: return
      //   41: astore 4
      //   43: aconst_null
      //   44: astore_3
      //   45: aload_3
      //   46: invokestatic 156	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   49: aload_2
      //   50: invokestatic 158	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   53: aload 4
      //   55: athrow
      //   56: astore 4
      //   58: goto -13 -> 45
      //
      // Exception table:
      //   from	to	target	type
      //   8	17	41	finally
      //   17	32	56	finally
    }

    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      if (isNotLast(paramInt))
        return;
      if ((this.mPartialEncodedImageFromCache != null) && (paramEncodedImage.getBytesRange() != null))
        try
        {
          sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, paramEncodedImage));
          paramEncodedImage.close();
          this.mPartialEncodedImageFromCache.close();
          this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
          return;
        }
        catch (IOException localIOException)
        {
          while (true)
          {
            FLog.e("PartialDiskCacheProducer", "Error while merging image data", localIOException);
            getConsumer().onFailure(localIOException);
            paramEncodedImage.close();
            this.mPartialEncodedImageFromCache.close();
          }
        }
        finally
        {
          paramEncodedImage.close();
          this.mPartialEncodedImageFromCache.close();
        }
      if ((statusHasFlag(paramInt, 8)) && (isLast(paramInt)) && (paramEncodedImage.getImageFormat() != ImageFormat.UNKNOWN))
      {
        this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, paramEncodedImage);
        getConsumer().onNewResult(paramEncodedImage, paramInt);
        return;
      }
      getConsumer().onNewResult(paramEncodedImage, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.PartialDiskCacheProducer
 * JD-Core Version:    0.6.2
 */