package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl.Builder;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState>
{
  private static final String FETCH_TIME = "fetch_time";
  private static final String IMAGE_SIZE = "image_size";
  private static final String QUEUE_TIME = "queue_time";
  private static final String TAG = "OkHttpNetworkFetchProducer";
  private static final String TOTAL_TIME = "total_time";
  private final Call.Factory mCallFactory;
  private Executor mCancellationExecutor;

  public OkHttpNetworkFetcher(Call.Factory paramFactory, Executor paramExecutor)
  {
    this.mCallFactory = paramFactory;
    this.mCancellationExecutor = paramExecutor;
  }

  public OkHttpNetworkFetcher(OkHttpClient paramOkHttpClient)
  {
    this(paramOkHttpClient, paramOkHttpClient.dispatcher().executorService());
  }

  private void handleException(Call paramCall, Exception paramException, NetworkFetcher.Callback paramCallback)
  {
    if (paramCall.isCanceled())
    {
      paramCallback.onCancellation();
      return;
    }
    paramCallback.onFailure(paramException);
  }

  public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new OkHttpNetworkFetchState(paramConsumer, paramProducerContext);
  }

  public void fetch(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, NetworkFetcher.Callback paramCallback)
  {
    paramOkHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
    Uri localUri = paramOkHttpNetworkFetchState.getUri();
    try
    {
      Request.Builder localBuilder = new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(localUri.toString()).get();
      BytesRange localBytesRange = paramOkHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
      if (localBytesRange != null)
        localBuilder.addHeader("Range", localBytesRange.toHttpRangeHeaderValue());
      fetchWithRequest(paramOkHttpNetworkFetchState, paramCallback, localBuilder.build());
      return;
    }
    catch (Exception localException)
    {
      paramCallback.onFailure(localException);
    }
  }

  protected void fetchWithRequest(final OkHttpNetworkFetchState paramOkHttpNetworkFetchState, final NetworkFetcher.Callback paramCallback, Request paramRequest)
  {
    final Call localCall = this.mCallFactory.newCall(paramRequest);
    paramOkHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          localCall.cancel();
          return;
        }
        OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable()
        {
          public void run()
          {
            OkHttpNetworkFetcher.1.this.val$call.cancel();
          }
        });
      }
    });
    localCall.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, paramAnonymousIOException, paramCallback);
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        long l1 = 0L;
        paramOkHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
        ResponseBody localResponseBody = paramAnonymousResponse.body();
        while (true)
        {
          long l2;
          try
          {
            if (!paramAnonymousResponse.isSuccessful())
            {
              OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, new IOException("Unexpected HTTP code " + paramAnonymousResponse), paramCallback);
              return;
            }
            BytesRange localBytesRange = BytesRange.fromContentRangeHeader(paramAnonymousResponse.header("Content-Range"));
            if ((localBytesRange != null) && ((localBytesRange.from != 0) || (localBytesRange.to != 2147483647)))
            {
              paramOkHttpNetworkFetchState.setResponseBytesRange(localBytesRange);
              paramOkHttpNetworkFetchState.setOnNewResultStatusFlags(8);
            }
            l2 = localResponseBody.contentLength();
            if (l2 < l1)
            {
              paramCallback.onResponse(localResponseBody.byteStream(), (int)l1);
              return;
            }
          }
          catch (Exception localException)
          {
            OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, localException, paramCallback);
            return;
          }
          finally
          {
            localResponseBody.close();
          }
          l1 = l2;
        }
      }
    });
  }

  public Map<String, String> getExtraMap(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(paramOkHttpNetworkFetchState.responseTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("fetch_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.responseTime));
    localHashMap.put("total_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }

  public void onFetchCompletion(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    paramOkHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
  }

  public static class OkHttpNetworkFetchState extends FetchState
  {
    public long fetchCompleteTime;
    public long responseTime;
    public long submitTime;

    public OkHttpNetworkFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
    {
      super(paramProducerContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher
 * JD-Core Version:    0.6.2
 */