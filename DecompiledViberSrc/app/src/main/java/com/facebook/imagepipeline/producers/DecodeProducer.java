package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class DecodeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
  public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
  public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
  public static final String EXTRA_IS_FINAL = "isFinal";
  public static final String PRODUCER_NAME = "DecodeProducer";
  public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
  public static final String SAMPLE_SIZE = "sampleSize";
  private final ByteArrayPool mByteArrayPool;
  private final boolean mDecodeCancellationEnabled;
  private final boolean mDownsampleEnabled;
  private final boolean mDownsampleEnabledForNetwork;
  private final Executor mExecutor;
  private final ImageDecoder mImageDecoder;
  private final Producer<EncodedImage> mInputProducer;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;

  public DecodeProducer(ByteArrayPool paramByteArrayPool, Executor paramExecutor, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Producer<EncodedImage> paramProducer)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mImageDecoder = ((ImageDecoder)Preconditions.checkNotNull(paramImageDecoder));
    this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramProgressiveJpegConfig));
    this.mDownsampleEnabled = paramBoolean1;
    this.mDownsampleEnabledForNetwork = paramBoolean2;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mDecodeCancellationEnabled = paramBoolean3;
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    if (!UriUtil.isNetworkUri(paramProducerContext.getImageRequest().getSourceUri()));
    for (Object localObject = new LocalImagesProgressiveDecoder(paramConsumer, paramProducerContext, this.mDecodeCancellationEnabled); ; localObject = new NetworkImagesProgressiveDecoder(paramConsumer, paramProducerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled))
    {
      this.mInputProducer.produceResults((Consumer)localObject, paramProducerContext);
      return;
    }
  }

  private class LocalImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder
  {
    public LocalImagesProgressiveDecoder(ProducerContext paramBoolean, boolean arg3)
    {
      super(paramBoolean, localProducerContext, bool);
    }

    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return paramEncodedImage.getSize();
    }

    protected QualityInfo getQualityInfo()
    {
      return ImmutableQualityInfo.of(0, false, false);
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        boolean bool1 = isNotLast(paramInt);
        if (bool1);
        boolean bool2;
        for (boolean bool3 = false; ; bool3 = bool2)
        {
          return bool3;
          bool2 = super.updateDecodeJob(paramEncodedImage, paramInt);
        }
      }
      finally
      {
      }
    }
  }

  private class NetworkImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder
  {
    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;

    public NetworkImagesProgressiveDecoder(ProducerContext paramProgressiveJpegParser, ProgressiveJpegParser paramProgressiveJpegConfig, ProgressiveJpegConfig paramBoolean, boolean arg5)
    {
      super(paramProgressiveJpegParser, paramProgressiveJpegConfig, bool);
      this.mProgressiveJpegParser = ((ProgressiveJpegParser)Preconditions.checkNotNull(paramBoolean));
      Object localObject;
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(localObject));
      this.mLastScheduledScanNumber = 0;
    }

    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return this.mProgressiveJpegParser.getBestScanEndOffset();
    }

    protected QualityInfo getQualityInfo()
    {
      return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        boolean bool1 = super.updateDecodeJob(paramEncodedImage, paramInt);
        if (((isNotLast(paramInt)) || (statusHasFlag(paramInt, 8))) && (!statusHasFlag(paramInt, 4)) && (EncodedImage.isValid(paramEncodedImage)) && (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG))
        {
          boolean bool2 = this.mProgressiveJpegParser.parseMoreData(paramEncodedImage);
          if (bool2)
            break label74;
          bool1 = false;
        }
        while (true)
        {
          return bool1;
          label74: int i = this.mProgressiveJpegParser.getBestScanNumber();
          if (i <= this.mLastScheduledScanNumber)
            bool1 = false;
          else if ((i < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber)) && (!this.mProgressiveJpegParser.isEndMarkerRead()))
            bool1 = false;
          else
            this.mLastScheduledScanNumber = i;
        }
      }
      finally
      {
      }
    }
  }

  private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>>
  {
    private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
    private final String TAG = "ProgressiveDecoder";
    private final ImageDecodeOptions mImageDecodeOptions;

    @GuardedBy("this")
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener mProducerListener;

    public ProgressiveDecoder(ProducerContext paramBoolean, boolean arg3)
    {
      super();
      final ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
      this.mProducerListener = localProducerContext.getListener();
      this.mImageDecodeOptions = localProducerContext.getImageRequest().getImageDecodeOptions();
      this.mIsFinished = false;
      JobScheduler.JobRunnable local1 = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt)
        {
          if (paramAnonymousEncodedImage != null)
          {
            if ((DecodeProducer.this.mDownsampleEnabled) || (!BaseConsumer.statusHasFlag(paramAnonymousInt, 16)))
            {
              ImageRequest localImageRequest = localProducerContext.getImageRequest();
              if ((DecodeProducer.this.mDownsampleEnabledForNetwork) || (!UriUtil.isNetworkUri(localImageRequest.getSourceUri())))
                paramAnonymousEncodedImage.setSampleSize(DownsampleUtil.determineSampleSize(localImageRequest, paramAnonymousEncodedImage));
            }
            DecodeProducer.ProgressiveDecoder.this.doDecode(paramAnonymousEncodedImage, paramAnonymousInt);
          }
        }
      };
      this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, local1, this.mImageDecodeOptions.minDecodeIntervalMs);
      final boolean bool;
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          if (bool)
            DecodeProducer.ProgressiveDecoder.this.handleCancellation();
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          if (DecodeProducer.ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected())
            DecodeProducer.ProgressiveDecoder.this.mJobScheduler.scheduleJob();
        }
      });
    }

    private void doDecode(EncodedImage paramEncodedImage, int paramInt)
    {
      if ((paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG) && (isNotLast(paramInt)));
      while ((isFinished()) || (!EncodedImage.isValid(paramEncodedImage)))
        return;
      ImageFormat localImageFormat = paramEncodedImage.getImageFormat();
      String str1;
      String str2;
      String str3;
      boolean bool1;
      int i;
      label110: boolean bool2;
      String str4;
      if (localImageFormat != null)
      {
        str1 = localImageFormat.getName();
        str2 = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
        str3 = String.valueOf(paramEncodedImage.getSampleSize());
        bool1 = isLast(paramInt);
        if ((!bool1) || (statusHasFlag(paramInt, 8)))
          break label349;
        i = 1;
        bool2 = statusHasFlag(paramInt, 4);
        ResizeOptions localResizeOptions = this.mProducerContext.getImageRequest().getResizeOptions();
        if (localResizeOptions == null)
          break label355;
        str4 = localResizeOptions.width + "x" + localResizeOptions.height;
      }
      while (true)
      {
        try
        {
          while (true)
          {
            long l = this.mJobScheduler.getQueuedTime();
            String str5 = String.valueOf(this.mProducerContext.getImageRequest().getSourceUri());
            int j;
            Object localObject2;
            Object localObject3;
            if ((i != 0) || (bool2))
            {
              j = paramEncodedImage.getSize();
              break label519;
              localObject2 = ImmutableQualityInfo.FULL_QUALITY;
              this.mProducerListener.onProducerStart(this.mProducerContext.getId(), "DecodeProducer");
              localObject3 = null;
            }
            else
            {
              try
              {
                CloseableImage localCloseableImage = DecodeProducer.this.mImageDecoder.decode(paramEncodedImage, j, (QualityInfo)localObject2, this.mImageDecodeOptions);
                localObject3 = localCloseableImage;
                int k = paramEncodedImage.getSampleSize();
                if (k != 1)
                  paramInt |= 16;
                Map localMap2 = getExtraMap(localObject3, l, (QualityInfo)localObject2, bool1, str1, str2, str4, str3);
                this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), "DecodeProducer", localMap2);
                handleResult(localObject3, paramInt);
                return;
                str1 = "unknown";
                break;
                label349: i = 0;
                break label110;
                label355: str4 = "unknown";
                continue;
                j = getIntermediateImageEndOffset(paramEncodedImage);
                break label519;
                QualityInfo localQualityInfo = getQualityInfo();
                localObject2 = localQualityInfo;
              }
              catch (DecodeException localDecodeException)
              {
                EncodedImage localEncodedImage = localDecodeException.getEncodedImage();
                Object[] arrayOfObject = new Object[4];
                arrayOfObject[0] = localDecodeException.getMessage();
                arrayOfObject[1] = str5;
                arrayOfObject[2] = localEncodedImage.getFirstBytesAsHexString(10);
                arrayOfObject[3] = Integer.valueOf(localEncodedImage.getSize());
                FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", arrayOfObject);
                throw localDecodeException;
              }
              catch (Exception localException)
              {
                Map localMap1 = getExtraMap(localObject3, l, (QualityInfo)localObject2, bool1, str1, str2, str4, str3);
                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), "DecodeProducer", localException, localMap1);
                handleError(localException);
                return;
              }
            }
          }
        }
        finally
        {
          EncodedImage.closeSafely(paramEncodedImage);
        }
        label519: if (i == 0)
          if (!bool2);
      }
    }

    private Map<String, String> getExtraMap(@Nullable CloseableImage paramCloseableImage, long paramLong, QualityInfo paramQualityInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId()))
        return null;
      String str1 = String.valueOf(paramLong);
      String str2 = String.valueOf(paramQualityInfo.isOfGoodEnoughQuality());
      String str3 = String.valueOf(paramBoolean);
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        Bitmap localBitmap = ((CloseableStaticBitmap)paramCloseableImage).getUnderlyingBitmap();
        String str4 = localBitmap.getWidth() + "x" + localBitmap.getHeight();
        HashMap localHashMap2 = new HashMap(8);
        localHashMap2.put("bitmapSize", str4);
        localHashMap2.put("queueTime", str1);
        localHashMap2.put("hasGoodQuality", str2);
        localHashMap2.put("isFinal", str3);
        localHashMap2.put("encodedImageSize", paramString2);
        localHashMap2.put("imageFormat", paramString1);
        localHashMap2.put("requestedImageSize", paramString3);
        localHashMap2.put("sampleSize", paramString4);
        return ImmutableMap.copyOf(localHashMap2);
      }
      HashMap localHashMap1 = new HashMap(7);
      localHashMap1.put("queueTime", str1);
      localHashMap1.put("hasGoodQuality", str2);
      localHashMap1.put("isFinal", str3);
      localHashMap1.put("encodedImageSize", paramString2);
      localHashMap1.put("imageFormat", paramString1);
      localHashMap1.put("requestedImageSize", paramString3);
      localHashMap1.put("sampleSize", paramString4);
      return ImmutableMap.copyOf(localHashMap1);
    }

    private void handleCancellation()
    {
      maybeFinish(true);
      getConsumer().onCancellation();
    }

    private void handleError(Throwable paramThrowable)
    {
      maybeFinish(true);
      getConsumer().onFailure(paramThrowable);
    }

    private void handleResult(CloseableImage paramCloseableImage, int paramInt)
    {
      CloseableReference localCloseableReference = CloseableReference.of(paramCloseableImage);
      try
      {
        maybeFinish(isLast(paramInt));
        getConsumer().onNewResult(localCloseableReference, paramInt);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }

    private boolean isFinished()
    {
      try
      {
        boolean bool = this.mIsFinished;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    private void maybeFinish(boolean paramBoolean)
    {
      if (paramBoolean);
      try
      {
        if (this.mIsFinished)
          return;
        getConsumer().onProgressUpdate(1.0F);
        this.mIsFinished = true;
        this.mJobScheduler.clearJob();
        return;
      }
      finally
      {
      }
    }

    protected abstract int getIntermediateImageEndOffset(EncodedImage paramEncodedImage);

    protected abstract QualityInfo getQualityInfo();

    public void onCancellationImpl()
    {
      handleCancellation();
    }

    public void onFailureImpl(Throwable paramThrowable)
    {
      handleError(paramThrowable);
    }

    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      boolean bool1 = isLast(paramInt);
      if ((bool1) && (!EncodedImage.isValid(paramEncodedImage)))
        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
      boolean bool2;
      do
      {
        do
          return;
        while (!updateDecodeJob(paramEncodedImage, paramInt));
        bool2 = statusHasFlag(paramInt, 4);
      }
      while ((!bool1) && (!bool2) && (!this.mProducerContext.isIntermediateResultExpected()));
      this.mJobScheduler.scheduleJob();
    }

    protected void onProgressUpdateImpl(float paramFloat)
    {
      super.onProgressUpdateImpl(0.99F * paramFloat);
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      return this.mJobScheduler.updateJob(paramEncodedImage, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DecodeProducer
 * JD-Core Version:    0.6.2
 */