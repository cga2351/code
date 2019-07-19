package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class NetworkFetchProducer
  implements Producer<EncodedImage>
{
  public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
  public static final String PRODUCER_NAME = "NetworkFetchProducer";
  private static final int READ_SIZE = 16384;

  @VisibleForTesting
  static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100L;
  private final ByteArrayPool mByteArrayPool;
  private final NetworkFetcher mNetworkFetcher;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  public NetworkFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, NetworkFetcher paramNetworkFetcher)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mNetworkFetcher = paramNetworkFetcher;
  }

  protected static float calculateProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
      return paramInt1 / paramInt2;
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }

  @Nullable
  private Map<String, String> getExtraMap(FetchState paramFetchState, int paramInt)
  {
    if (!paramFetchState.getListener().requiresExtraMap(paramFetchState.getId()))
      return null;
    return this.mNetworkFetcher.getExtraMap(paramFetchState, paramInt);
  }

  // ERROR //
  private void notifyConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, int paramInt, @Nullable com.facebook.imagepipeline.common.BytesRange paramBytesRange, Consumer<EncodedImage> paramConsumer)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 92	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
    //   4: invokestatic 98	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    //   7: astore 5
    //   9: new 100	com/facebook/imagepipeline/image/EncodedImage
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 103	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   18: astore 6
    //   20: aload 6
    //   22: aload_3
    //   23: invokevirtual 107	com/facebook/imagepipeline/image/EncodedImage:setBytesRange	(Lcom/facebook/imagepipeline/common/BytesRange;)V
    //   26: aload 6
    //   28: invokevirtual 110	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
    //   31: aload 4
    //   33: aload 6
    //   35: iload_2
    //   36: invokeinterface 116 3 0
    //   41: aload 6
    //   43: invokestatic 120	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   46: aload 5
    //   48: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   51: return
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 6
    //   57: aload 6
    //   59: invokestatic 120	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   62: aload 5
    //   64: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   67: aload 7
    //   69: athrow
    //   70: astore 7
    //   72: goto -15 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   9	20	52	finally
    //   20	41	70	finally
  }

  private void onCancellation(FetchState paramFetchState)
  {
    paramFetchState.getListener().onProducerFinishWithCancellation(paramFetchState.getId(), "NetworkFetchProducer", null);
    paramFetchState.getConsumer().onCancellation();
  }

  private void onFailure(FetchState paramFetchState, Throwable paramThrowable)
  {
    paramFetchState.getListener().onProducerFinishWithFailure(paramFetchState.getId(), "NetworkFetchProducer", paramThrowable, null);
    paramFetchState.getListener().onUltimateProducerReached(paramFetchState.getId(), "NetworkFetchProducer", false);
    paramFetchState.getConsumer().onFailure(paramThrowable);
  }

  private boolean shouldPropagateIntermediateResults(FetchState paramFetchState)
  {
    if (!paramFetchState.getContext().isIntermediateResultExpected())
      return false;
    return this.mNetworkFetcher.shouldPropagate(paramFetchState);
  }

  protected void handleFinalResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    Map localMap = getExtraMap(paramFetchState, paramPooledByteBufferOutputStream.size());
    ProducerListener localProducerListener = paramFetchState.getListener();
    localProducerListener.onProducerFinishWithSuccess(paramFetchState.getId(), "NetworkFetchProducer", localMap);
    localProducerListener.onUltimateProducerReached(paramFetchState.getId(), "NetworkFetchProducer", true);
    notifyConsumer(paramPooledByteBufferOutputStream, 0x1 | paramFetchState.getOnNewResultStatusFlags(), paramFetchState.getResponseBytesRange(), paramFetchState.getConsumer());
  }

  protected void maybeHandleIntermediateResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    long l = SystemClock.uptimeMillis();
    if ((shouldPropagateIntermediateResults(paramFetchState)) && (l - paramFetchState.getLastIntermediateResultTimeMs() >= 100L))
    {
      paramFetchState.setLastIntermediateResultTimeMs(l);
      paramFetchState.getListener().onProducerEvent(paramFetchState.getId(), "NetworkFetchProducer", "intermediate_result");
      notifyConsumer(paramPooledByteBufferOutputStream, paramFetchState.getOnNewResultStatusFlags(), paramFetchState.getResponseBytesRange(), paramFetchState.getConsumer());
    }
  }

  protected void onResponse(FetchState paramFetchState, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInt > 0);
    byte[] arrayOfByte;
    for (PooledByteBufferOutputStream localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(paramInt); ; localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream())
    {
      arrayOfByte = (byte[])this.mByteArrayPool.get(16384);
      try
      {
        while (true)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i < 0)
            break;
          if (i > 0)
          {
            localPooledByteBufferOutputStream.write(arrayOfByte, 0, i);
            maybeHandleIntermediateResult(localPooledByteBufferOutputStream, paramFetchState);
            float f = calculateProgress(localPooledByteBufferOutputStream.size(), paramInt);
            paramFetchState.getConsumer().onProgressUpdate(f);
          }
        }
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
        localPooledByteBufferOutputStream.close();
      }
    }
    this.mNetworkFetcher.onFetchCompletion(paramFetchState, localPooledByteBufferOutputStream.size());
    handleFinalResult(localPooledByteBufferOutputStream, paramFetchState);
    this.mByteArrayPool.release(arrayOfByte);
    localPooledByteBufferOutputStream.close();
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "NetworkFetchProducer");
    final FetchState localFetchState = this.mNetworkFetcher.createFetchState(paramConsumer, paramProducerContext);
    this.mNetworkFetcher.fetch(localFetchState, new NetworkFetcher.Callback()
    {
      public void onCancellation()
      {
        NetworkFetchProducer.this.onCancellation(localFetchState);
      }

      public void onFailure(Throwable paramAnonymousThrowable)
      {
        NetworkFetchProducer.this.onFailure(localFetchState, paramAnonymousThrowable);
      }

      public void onResponse(InputStream paramAnonymousInputStream, int paramAnonymousInt)
        throws IOException
      {
        NetworkFetchProducer.this.onResponse(localFetchState, paramAnonymousInputStream, paramAnonymousInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.NetworkFetchProducer
 * JD-Core Version:    0.6.2
 */