package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer
  implements Producer<EncodedImage>
{

  @VisibleForTesting
  static final int DEFAULT_JPEG_QUALITY = 85;
  private static final String DOWNSAMPLE_ENUMERATOR_KEY = "downsampleEnumerator";
  private static final String FRACTION_KEY = "Fraction";
  private static final int FULL_ROUND = 360;
  private static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of(arrayOfInteger);

  @VisibleForTesting
  static final int MAX_JPEG_SCALE_NUMERATOR = 8;

  @VisibleForTesting
  static final int MIN_TRANSFORM_INTERVAL_MS = 100;
  private static final String ORIGINAL_SIZE_KEY = "Original size";
  public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
  private static final String REQUESTED_SIZE_KEY = "Requested size";
  private static final String ROTATION_ANGLE_KEY = "rotationAngle";
  private static final String SOFTWARE_ENUMERATOR_KEY = "softwareEnumerator";
  private final Executor mExecutor;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final boolean mResizingEnabled;
  private final boolean mUseDownsamplingRatio;

  static
  {
    Integer[] arrayOfInteger = new Integer[4];
    arrayOfInteger[0] = Integer.valueOf(2);
    arrayOfInteger[1] = Integer.valueOf(7);
    arrayOfInteger[2] = Integer.valueOf(4);
    arrayOfInteger[3] = Integer.valueOf(5);
  }

  public ResizeAndRotateProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, boolean paramBoolean1, Producer<EncodedImage> paramProducer, boolean paramBoolean2)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mResizingEnabled = paramBoolean1;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mUseDownsamplingRatio = paramBoolean2;
  }

  @VisibleForTesting
  static int calculateDownsampleNumerator(int paramInt)
  {
    return Math.max(1, 8 / paramInt);
  }

  @VisibleForTesting
  static float determineResizeRatio(ResizeOptions paramResizeOptions, int paramInt1, int paramInt2)
  {
    float f;
    if (paramResizeOptions == null)
      f = 1.0F;
    do
    {
      return f;
      f = Math.max(paramResizeOptions.width / paramInt1, paramResizeOptions.height / paramInt2);
      if (f * paramInt1 > paramResizeOptions.maxBitmapSize)
        f = paramResizeOptions.maxBitmapSize / paramInt1;
    }
    while (f * paramInt2 <= paramResizeOptions.maxBitmapSize);
    return paramResizeOptions.maxBitmapSize / paramInt2;
  }

  private static int extractOrientationFromMetadata(EncodedImage paramEncodedImage)
  {
    switch (paramEncodedImage.getRotationAngle())
    {
    default:
      return 0;
    case 90:
    case 180:
    case 270:
    }
    return paramEncodedImage.getRotationAngle();
  }

  private static int getForceRotatedInvertedExifOrientation(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    int i = paramEncodedImage.getExifOrientation();
    int j = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(i));
    if (j < 0)
      throw new IllegalArgumentException("Only accepts inverted exif orientations");
    boolean bool = paramRotationOptions.useImageMetadata();
    int k = 0;
    if (!bool)
      k = paramRotationOptions.getForcedAngle();
    int m = k / 90;
    return ((Integer)INVERTED_EXIF_ORIENTATIONS.get((m + j) % INVERTED_EXIF_ORIENTATIONS.size())).intValue();
  }

  private static int getRotationAngle(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    int i;
    if (!paramRotationOptions.rotationEnabled())
      i = 0;
    do
    {
      return i;
      i = extractOrientationFromMetadata(paramEncodedImage);
    }
    while (paramRotationOptions.useImageMetadata());
    return (i + paramRotationOptions.getForcedAngle()) % 360;
  }

  private static int getSoftwareNumerator(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    int i1;
    if (!paramBoolean)
    {
      i1 = 8;
      return i1;
    }
    ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
    if (localResizeOptions == null)
      return 8;
    int i = getRotationAngle(paramImageRequest.getRotationOptions(), paramEncodedImage);
    if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(paramEncodedImage.getExifOrientation())));
    for (int j = getForceRotatedInvertedExifOrientation(paramImageRequest.getRotationOptions(), paramEncodedImage); ; j = 0)
    {
      int k;
      int m;
      if ((i == 90) || (i == 270) || (j == 5) || (j == 7))
      {
        k = 1;
        if (k == 0)
          break label145;
        m = paramEncodedImage.getHeight();
        label101: if (k == 0)
          break label154;
      }
      label145: label154: for (int n = paramEncodedImage.getWidth(); ; n = paramEncodedImage.getHeight())
      {
        i1 = roundNumerator(determineResizeRatio(localResizeOptions, m, n), localResizeOptions.roundUpFraction);
        if (i1 <= 8)
          break label163;
        return 8;
        k = 0;
        break;
        m = paramEncodedImage.getWidth();
        break label101;
      }
      label163: if (i1 >= 1)
        break;
      return 1;
    }
  }

  @VisibleForTesting
  static int roundNumerator(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat2 + 8.0F * paramFloat1);
  }

  private static boolean shouldResize(int paramInt)
  {
    return paramInt < 8;
  }

  private static boolean shouldRotate(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    return (!paramRotationOptions.canDeferUntilRendered()) && ((getRotationAngle(paramRotationOptions, paramEncodedImage) != 0) || (shouldRotateUsingExifOrientation(paramRotationOptions, paramEncodedImage)));
  }

  private static boolean shouldRotateUsingExifOrientation(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    if ((!paramRotationOptions.rotationEnabled()) || (paramRotationOptions.canDeferUntilRendered()))
    {
      paramEncodedImage.setExifOrientation(0);
      return false;
    }
    return INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(paramEncodedImage.getExifOrientation()));
  }

  private static TriState shouldTransform(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if ((paramEncodedImage == null) || (paramEncodedImage.getImageFormat() == ImageFormat.UNKNOWN))
      return TriState.UNSET;
    if (paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG)
      return TriState.NO;
    if ((shouldRotate(paramImageRequest.getRotationOptions(), paramEncodedImage)) || (shouldResize(getSoftwareNumerator(paramImageRequest, paramEncodedImage, paramBoolean))));
    for (boolean bool = true; ; bool = false)
      return TriState.valueOf(bool);
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new TransformingConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }

  private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private boolean mIsCancelled = false;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;

    public TransformingConsumer(ProducerContext arg2)
    {
      super();
      Object localObject;
      this.mProducerContext = localObject;
      JobScheduler.JobRunnable local1 = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt)
        {
          ResizeAndRotateProducer.TransformingConsumer.this.doTransform(paramAnonymousEncodedImage, paramAnonymousInt);
        }
      };
      this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, local1, 100);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
          ResizeAndRotateProducer.TransformingConsumer.access$402(ResizeAndRotateProducer.TransformingConsumer.this, true);
          localConsumer.onCancellation();
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          if (ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected())
            ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
        }
      });
    }

    // ERROR //
    private void doTransform(EncodedImage paramEncodedImage, int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_0
      //   3: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   6: invokeinterface 71 1 0
      //   11: aload_0
      //   12: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   15: invokeinterface 75 1 0
      //   20: ldc 77
      //   22: invokeinterface 83 3 0
      //   27: aload_0
      //   28: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   31: invokeinterface 87 1 0
      //   36: astore 4
      //   38: aload_0
      //   39: getfield 17	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   42: invokestatic 91	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$700	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;
      //   45: invokeinterface 97 1 0
      //   50: astore 5
      //   52: aload 4
      //   54: aload_1
      //   55: aload_0
      //   56: getfield 17	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   59: invokestatic 101	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$500	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   62: invokestatic 105	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$800	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I
      //   65: istore 10
      //   67: aload 4
      //   69: aload_1
      //   70: invokestatic 111	com/facebook/imagepipeline/producers/DownsampleUtil:determineSampleSize	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   73: istore 11
      //   75: iload 11
      //   77: invokestatic 115	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:calculateDownsampleNumerator	(I)I
      //   80: istore 12
      //   82: aload_0
      //   83: getfield 17	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   86: invokestatic 118	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$900	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   89: ifeq +182 -> 271
      //   92: iload 12
      //   94: istore 13
      //   96: aload_1
      //   97: invokevirtual 124	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
      //   100: astore 14
      //   102: aload 14
      //   104: astore 9
      //   106: invokestatic 128	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$1000	()Lcom/facebook/common/internal/ImmutableList;
      //   109: aload_1
      //   110: invokevirtual 132	com/facebook/imagepipeline/image/EncodedImage:getExifOrientation	()I
      //   113: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   116: invokevirtual 144	com/facebook/common/internal/ImmutableList:contains	(Ljava/lang/Object;)Z
      //   119: istore 15
      //   121: aconst_null
      //   122: astore_3
      //   123: iload 15
      //   125: ifeq +153 -> 278
      //   128: aload 4
      //   130: invokevirtual 150	com/facebook/imagepipeline/request/ImageRequest:getRotationOptions	()Lcom/facebook/imagepipeline/common/RotationOptions;
      //   133: aload_1
      //   134: invokestatic 154	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$1100	(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   137: istore 16
      //   139: aload_0
      //   140: aload_1
      //   141: aload 4
      //   143: iload 13
      //   145: iload 12
      //   147: iload 10
      //   149: iconst_0
      //   150: invokespecial 158	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/request/ImageRequest;IIII)Ljava/util/Map;
      //   153: astore_3
      //   154: aload 9
      //   156: aload 5
      //   158: iload 16
      //   160: iload 13
      //   162: bipush 85
      //   164: invokestatic 164	com/facebook/imagepipeline/nativecode/JpegTranscoder:transcodeJpegWithExifOrientation	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   167: aload 5
      //   169: invokevirtual 170	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
      //   172: invokestatic 176	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   175: astore 17
      //   177: new 120	com/facebook/imagepipeline/image/EncodedImage
      //   180: dup
      //   181: aload 17
      //   183: invokespecial 179	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   186: astore 18
      //   188: aload 18
      //   190: getstatic 185	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
      //   193: invokevirtual 189	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
      //   196: aload 18
      //   198: invokevirtual 193	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   201: aload_0
      //   202: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   205: invokeinterface 71 1 0
      //   210: aload_0
      //   211: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   214: invokeinterface 75 1 0
      //   219: ldc 77
      //   221: aload_3
      //   222: invokeinterface 197 4 0
      //   227: iload 11
      //   229: iconst_1
      //   230: if_icmpeq +8 -> 238
      //   233: iload_2
      //   234: bipush 16
      //   236: ior
      //   237: istore_2
      //   238: aload_0
      //   239: invokevirtual 201	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   242: aload 18
      //   244: iload_2
      //   245: invokeinterface 207 3 0
      //   250: aload 18
      //   252: invokestatic 211	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   255: aload 17
      //   257: invokestatic 213	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   260: aload 9
      //   262: invokestatic 219	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   265: aload 5
      //   267: invokevirtual 222	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   270: return
      //   271: iload 10
      //   273: istore 13
      //   275: goto -179 -> 96
      //   278: aload 4
      //   280: invokevirtual 150	com/facebook/imagepipeline/request/ImageRequest:getRotationOptions	()Lcom/facebook/imagepipeline/common/RotationOptions;
      //   283: aload_1
      //   284: invokestatic 225	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$1200	(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   287: istore 21
      //   289: aload_0
      //   290: aload_1
      //   291: aload 4
      //   293: iload 13
      //   295: iload 12
      //   297: iload 10
      //   299: iload 21
      //   301: invokespecial 158	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/request/ImageRequest;IIII)Ljava/util/Map;
      //   304: astore_3
      //   305: aload 9
      //   307: aload 5
      //   309: iload 21
      //   311: iload 13
      //   313: bipush 85
      //   315: invokestatic 228	com/facebook/imagepipeline/nativecode/JpegTranscoder:transcodeJpeg	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   318: goto -151 -> 167
      //   321: astore 6
      //   323: aload 9
      //   325: astore 7
      //   327: aload_0
      //   328: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   331: invokeinterface 71 1 0
      //   336: aload_0
      //   337: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   340: invokeinterface 75 1 0
      //   345: ldc 77
      //   347: aload 6
      //   349: aload_3
      //   350: invokeinterface 232 5 0
      //   355: iload_2
      //   356: invokestatic 236	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:isLast	(I)Z
      //   359: ifeq +14 -> 373
      //   362: aload_0
      //   363: invokevirtual 201	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   366: aload 6
      //   368: invokeinterface 240 2 0
      //   373: aload 7
      //   375: invokestatic 219	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   378: aload 5
      //   380: invokevirtual 222	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   383: return
      //   384: astore 20
      //   386: aload 18
      //   388: invokestatic 211	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   391: aload 20
      //   393: athrow
      //   394: astore 19
      //   396: aload 17
      //   398: invokestatic 213	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   401: aload 19
      //   403: athrow
      //   404: astore 8
      //   406: aload 9
      //   408: invokestatic 219	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   411: aload 5
      //   413: invokevirtual 222	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   416: aload 8
      //   418: athrow
      //   419: astore 8
      //   421: aconst_null
      //   422: astore 9
      //   424: goto -18 -> 406
      //   427: astore 8
      //   429: aload 7
      //   431: astore 9
      //   433: goto -27 -> 406
      //   436: astore 6
      //   438: aconst_null
      //   439: astore 7
      //   441: aconst_null
      //   442: astore_3
      //   443: goto -116 -> 327
      //
      // Exception table:
      //   from	to	target	type
      //   106	121	321	java/lang/Exception
      //   128	167	321	java/lang/Exception
      //   167	177	321	java/lang/Exception
      //   255	260	321	java/lang/Exception
      //   278	318	321	java/lang/Exception
      //   396	404	321	java/lang/Exception
      //   196	227	384	finally
      //   238	250	384	finally
      //   177	196	394	finally
      //   250	255	394	finally
      //   386	394	394	finally
      //   106	121	404	finally
      //   128	167	404	finally
      //   167	177	404	finally
      //   255	260	404	finally
      //   278	318	404	finally
      //   396	404	404	finally
      //   52	92	419	finally
      //   96	102	419	finally
      //   327	373	427	finally
      //   52	92	436	java/lang/Exception
      //   96	102	436	java/lang/Exception
    }

    private Map<String, String> getExtraMap(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId()))
        return null;
      String str1 = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
      String str2;
      if (paramImageRequest.getResizeOptions() != null)
      {
        str2 = paramImageRequest.getResizeOptions().width + "x" + paramImageRequest.getResizeOptions().height;
        if (paramInt1 <= 0)
          break label262;
      }
      label262: for (String str3 = paramInt1 + "/8"; ; str3 = "")
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Original size", str1);
        localHashMap.put("Requested size", str2);
        localHashMap.put("Fraction", str3);
        localHashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
        localHashMap.put("downsampleEnumerator", Integer.toString(paramInt2));
        localHashMap.put("softwareEnumerator", Integer.toString(paramInt3));
        localHashMap.put("rotationAngle", Integer.toString(paramInt4));
        return ImmutableMap.copyOf(localHashMap);
        str2 = "Unspecified";
        break;
      }
    }

    private EncodedImage moveImage(EncodedImage paramEncodedImage)
    {
      EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      paramEncodedImage.close();
      return localEncodedImage;
    }

    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, int paramInt)
    {
      if (this.mIsCancelled);
      boolean bool;
      do
      {
        TriState localTriState;
        do
        {
          do
          {
            return;
            bool = isLast(paramInt);
            if (paramEncodedImage != null)
              break;
          }
          while (!bool);
          getConsumer().onNewResult(null, 1);
          return;
          localTriState = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), paramEncodedImage, ResizeAndRotateProducer.this.mResizingEnabled);
        }
        while ((!bool) && (localTriState == TriState.UNSET));
        if (localTriState != TriState.YES)
        {
          if ((!this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered()) && (paramEncodedImage.getRotationAngle() != 0) && (paramEncodedImage.getRotationAngle() != -1))
          {
            paramEncodedImage = moveImage(paramEncodedImage);
            paramEncodedImage.setRotationAngle(0);
          }
          getConsumer().onNewResult(paramEncodedImage, paramInt);
          return;
        }
      }
      while ((!this.mJobScheduler.updateJob(paramEncodedImage, paramInt)) || ((!bool) && (!this.mProducerContext.isIntermediateResultExpected())));
      this.mJobScheduler.scheduleJob();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ResizeAndRotateProducer
 * JD-Core Version:    0.6.2
 */