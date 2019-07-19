package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.OkHttpNetworkFetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl.Builder;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

class ReactOkHttpNetworkFetcher extends OkHttpNetworkFetcher
{
  private static final String TAG = "ReactOkHttpNetworkFetcher";
  private final Executor mCancellationExecutor;
  private final OkHttpClient mOkHttpClient;

  public ReactOkHttpNetworkFetcher(OkHttpClient paramOkHttpClient)
  {
    super(paramOkHttpClient);
    this.mOkHttpClient = paramOkHttpClient;
    this.mCancellationExecutor = paramOkHttpClient.dispatcher().executorService();
  }

  private Map<String, String> getHeaders(ReadableMap paramReadableMap)
  {
    Object localObject;
    if (paramReadableMap == null)
      localObject = null;
    while (true)
    {
      return localObject;
      ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
      localObject = new HashMap();
      while (localReadableMapKeySetIterator.hasNextKey())
      {
        String str = localReadableMapKeySetIterator.nextKey();
        ((Map)localObject).put(str, paramReadableMap.getString(str));
      }
    }
  }

  public void fetch(OkHttpNetworkFetcher.OkHttpNetworkFetchState paramOkHttpNetworkFetchState, NetworkFetcher.Callback paramCallback)
  {
    paramOkHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
    Uri localUri = paramOkHttpNetworkFetchState.getUri();
    boolean bool = paramOkHttpNetworkFetchState.getContext().getImageRequest() instanceof ReactNetworkImageRequest;
    Map localMap = null;
    if (bool)
      localMap = getHeaders(((ReactNetworkImageRequest)paramOkHttpNetworkFetchState.getContext().getImageRequest()).getHeaders());
    if (localMap == null)
      localMap = Collections.emptyMap();
    fetchWithRequest(paramOkHttpNetworkFetchState, paramCallback, new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(localUri.toString()).headers(Headers.of(localMap)).get().build());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.ReactOkHttpNetworkFetcher
 * JD-Core Version:    0.6.2
 */