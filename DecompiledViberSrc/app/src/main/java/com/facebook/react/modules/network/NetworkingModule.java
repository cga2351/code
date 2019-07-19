package com.facebook.react.modules.network;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import f.f;
import f.j;
import f.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

@ReactModule(name="Networking")
public final class NetworkingModule extends ReactContextBaseJavaModule
{
  private static final int CHUNK_TIMEOUT_NS = 100000000;
  private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
  private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
  private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
  protected static final String NAME = "Networking";
  private static final String REQUEST_BODY_KEY_BASE64 = "base64";
  private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
  private static final String REQUEST_BODY_KEY_STRING = "string";
  private static final String REQUEST_BODY_KEY_URI = "uri";
  private static final String TAG = "NetworkingModule";
  private static final String USER_AGENT_HEADER_NAME = "user-agent";
  private final OkHttpClient mClient;
  private final ForwardingCookieHandler mCookieHandler;
  private final CookieJarContainer mCookieJarContainer;

  @Nullable
  private final String mDefaultUserAgent;
  private final List<RequestBodyHandler> mRequestBodyHandlers = new ArrayList();
  private final Set<Integer> mRequestIds;
  private final List<ResponseHandler> mResponseHandlers = new ArrayList();
  private boolean mShuttingDown;
  private final List<UriHandler> mUriHandlers = new ArrayList();

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, null, OkHttpClientProvider.createClient(paramReactApplicationContext), null);
  }

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, String paramString)
  {
    this(paramReactApplicationContext, paramString, OkHttpClientProvider.createClient(paramReactApplicationContext), null);
  }

  NetworkingModule(ReactApplicationContext paramReactApplicationContext, @Nullable String paramString, OkHttpClient paramOkHttpClient)
  {
    this(paramReactApplicationContext, paramString, paramOkHttpClient, null);
  }

  NetworkingModule(ReactApplicationContext paramReactApplicationContext, @Nullable String paramString, OkHttpClient paramOkHttpClient, @Nullable List<NetworkInterceptorCreator> paramList)
  {
    super(paramReactApplicationContext);
    if (paramList != null)
    {
      OkHttpClient.Builder localBuilder = paramOkHttpClient.newBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localBuilder.addNetworkInterceptor(((NetworkInterceptorCreator)localIterator.next()).create());
      paramOkHttpClient = localBuilder.build();
    }
    this.mClient = paramOkHttpClient;
    this.mCookieHandler = new ForwardingCookieHandler(paramReactApplicationContext);
    this.mCookieJarContainer = ((CookieJarContainer)this.mClient.cookieJar());
    this.mShuttingDown = false;
    this.mDefaultUserAgent = paramString;
    this.mRequestIds = new HashSet();
  }

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, List<NetworkInterceptorCreator> paramList)
  {
    this(paramReactApplicationContext, null, OkHttpClientProvider.createClient(paramReactApplicationContext), paramList);
  }

  private void addRequest(int paramInt)
  {
    try
    {
      this.mRequestIds.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void cancelAllRequests()
  {
    try
    {
      Iterator localIterator = this.mRequestIds.iterator();
      while (localIterator.hasNext())
        cancelRequest(((Integer)localIterator.next()).intValue());
    }
    finally
    {
    }
    this.mRequestIds.clear();
  }

  private void cancelRequest(final int paramInt)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(paramInt));
      }
    }
    .execute(new Void[0]);
  }

  @Nullable
  private MultipartBody.Builder constructMultipartBody(ReadableArray paramReadableArray, String paramString, int paramInt)
  {
    DeviceEventManagerModule.RCTDeviceEventEmitter localRCTDeviceEventEmitter = getEventEmitter();
    MultipartBody.Builder localBuilder = new MultipartBody.Builder();
    localBuilder.setType(MediaType.parse(paramString));
    int i = paramReadableArray.size();
    int j = 0;
    ReadableMap localReadableMap;
    Headers localHeaders;
    MediaType localMediaType;
    if (j < i)
    {
      localReadableMap = paramReadableArray.getMap(j);
      localHeaders = extractHeaders(localReadableMap.getArray("headers"), null);
      if (localHeaders == null)
      {
        ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Missing or invalid header format for FormData part.", null);
        return null;
      }
      String str1 = localHeaders.get("content-type");
      if (str1 == null)
        break label282;
      localMediaType = MediaType.parse(str1);
      localHeaders = localHeaders.newBuilder().removeAll("content-type").build();
    }
    while (true)
    {
      if (localReadableMap.hasKey("string"))
        localBuilder.addPart(localHeaders, RequestBody.create(localMediaType, localReadableMap.getString("string")));
      while (true)
      {
        j++;
        break;
        if (localReadableMap.hasKey("uri"))
        {
          if (localMediaType == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Binary FormData part needs a content-type header.", null);
            return null;
          }
          String str2 = localReadableMap.getString("uri");
          InputStream localInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), str2);
          if (localInputStream == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Could not retrieve file for uri " + str2, null);
            return null;
          }
          localBuilder.addPart(localHeaders, RequestBodyUtil.create(localMediaType, localInputStream));
        }
        else
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Unrecognized FormData part.", null);
        }
      }
      return localBuilder;
      label282: localMediaType = null;
    }
  }

  @Nullable
  private Headers extractHeaders(@Nullable ReadableArray paramReadableArray, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableArray == null)
      return null;
    Headers.Builder localBuilder = new Headers.Builder();
    int i = paramReadableArray.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label109;
      ReadableArray localReadableArray = paramReadableArray.getArray(j);
      if ((localReadableArray == null) || (localReadableArray.size() != 2))
        break;
      String str1 = HeaderUtil.stripHeaderName(localReadableArray.getString(0));
      String str2 = HeaderUtil.stripHeaderValue(localReadableArray.getString(1));
      if ((str1 == null) || (str2 == null))
        break;
      localBuilder.add(str1, str2);
    }
    label109: if ((localBuilder.get("user-agent") == null) && (this.mDefaultUserAgent != null))
      localBuilder.add("user-agent", this.mDefaultUserAgent);
    if ((paramReadableMap != null) && (paramReadableMap.hasKey("string")));
    for (int k = 1; ; k = 0)
    {
      if (k == 0)
        localBuilder.removeAll("content-encoding");
      return localBuilder.build();
    }
  }

  private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter()
  {
    return (DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
  }

  private void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, ResponseBody paramResponseBody)
    throws IOException
  {
    long l1 = -1L;
    try
    {
      localProgressResponseBody = (ProgressResponseBody)paramResponseBody;
      long l3 = localProgressResponseBody.totalBytesRead();
      l2 = l3;
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        ProgressResponseBody localProgressResponseBody;
        long l2;
        long l4 = localProgressResponseBody.contentLength();
        l1 = l4;
        while (true)
        {
          label33: if (paramResponseBody.contentType() == null);
          InputStream localInputStream;
          for (Charset localCharset = StandardCharsets.UTF_8; ; localCharset = paramResponseBody.contentType().charset(StandardCharsets.UTF_8))
          {
            ProgressiveStringDecoder localProgressiveStringDecoder = new ProgressiveStringDecoder(localCharset);
            localInputStream = paramResponseBody.byteStream();
            try
            {
              byte[] arrayOfByte = new byte[8192];
              while (true)
              {
                int i = localInputStream.read(arrayOfByte);
                if (i == -1)
                  break;
                ResponseUtil.onIncrementalDataReceived(paramRCTDeviceEventEmitter, paramInt, localProgressiveStringDecoder.decodeNext(arrayOfByte, i), l2, l1);
              }
            }
            finally
            {
              localInputStream.close();
            }
          }
          localInputStream.close();
          return;
          localClassCastException1 = localClassCastException1;
          l2 = l1;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        break label33;
      }
    }
  }

  private void removeRequest(int paramInt)
  {
    try
    {
      this.mRequestIds.remove(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static boolean shouldDispatch(long paramLong1, long paramLong2)
  {
    return 100000000L + paramLong2 < paramLong1;
  }

  private static WritableMap translateHeaders(Headers paramHeaders)
  {
    WritableMap localWritableMap = Arguments.createMap();
    int i = 0;
    if (i < paramHeaders.size())
    {
      String str = paramHeaders.name(i);
      if (localWritableMap.hasKey(str))
        localWritableMap.putString(str, localWritableMap.getString(str) + ", " + paramHeaders.value(i));
      while (true)
      {
        i++;
        break;
        localWritableMap.putString(str, paramHeaders.value(i));
      }
    }
    return localWritableMap;
  }

  private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody paramRequestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, final int paramInt)
  {
    if (paramRequestBody == null)
      return null;
    return RequestBodyUtil.createProgressRequest(paramRequestBody, new ProgressListener()
    {
      long last = System.nanoTime();

      public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
      {
        long l = System.nanoTime();
        if ((paramAnonymousBoolean) || (NetworkingModule.shouldDispatch(l, this.last)))
        {
          ResponseUtil.onDataSend(paramRCTDeviceEventEmitter, paramInt, paramAnonymousLong1, paramAnonymousLong2);
          this.last = l;
        }
      }
    });
  }

  @ReactMethod
  public void abortRequest(int paramInt)
  {
    cancelRequest(paramInt);
    removeRequest(paramInt);
  }

  public void addRequestBodyHandler(RequestBodyHandler paramRequestBodyHandler)
  {
    this.mRequestBodyHandlers.add(paramRequestBodyHandler);
  }

  public void addResponseHandler(ResponseHandler paramResponseHandler)
  {
    this.mResponseHandlers.add(paramResponseHandler);
  }

  public void addUriHandler(UriHandler paramUriHandler)
  {
    this.mUriHandlers.add(paramUriHandler);
  }

  @ReactMethod
  public void clearCookies(com.facebook.react.bridge.Callback paramCallback)
  {
    this.mCookieHandler.clearCookies(paramCallback);
  }

  public String getName()
  {
    return "Networking";
  }

  public void initialize()
  {
    this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
  }

  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
    cancelAllRequests();
    this.mCookieHandler.destroy();
    this.mCookieJarContainer.removeCookieJar();
    this.mRequestBodyHandlers.clear();
    this.mResponseHandlers.clear();
    this.mUriHandlers.clear();
  }

  public void removeRequestBodyHandler(RequestBodyHandler paramRequestBodyHandler)
  {
    this.mRequestBodyHandlers.remove(paramRequestBodyHandler);
  }

  public void removeResponseHandler(ResponseHandler paramResponseHandler)
  {
    this.mResponseHandlers.remove(paramResponseHandler);
  }

  public void removeUriHandler(UriHandler paramUriHandler)
  {
    this.mUriHandlers.remove(paramUriHandler);
  }

  @ReactMethod
  public void sendRequest(String paramString1, String paramString2, int paramInt1, ReadableArray paramReadableArray, ReadableMap paramReadableMap, String paramString3, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    try
    {
      sendRequestInternal(paramString1, paramString2, paramInt1, paramReadableArray, paramReadableMap, paramString3, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    catch (Throwable localThrowable)
    {
      FLog.e("NetworkingModule", "Failed to send url request: " + paramString2, localThrowable);
      ResponseUtil.onRequestError(getEventEmitter(), paramInt1, localThrowable.getMessage(), localThrowable);
    }
  }

  public void sendRequestInternal(String paramString1, String paramString2, final int paramInt1, ReadableArray paramReadableArray, ReadableMap paramReadableMap, final String paramString3, final boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    final DeviceEventManagerModule.RCTDeviceEventEmitter localRCTDeviceEventEmitter = getEventEmitter();
    try
    {
      Uri localUri = Uri.parse(paramString2);
      Iterator localIterator1 = this.mUriHandlers.iterator();
      while (localIterator1.hasNext())
      {
        UriHandler localUriHandler = (UriHandler)localIterator1.next();
        if (localUriHandler.supports(localUri, paramString3))
        {
          ResponseUtil.onDataReceived(localRCTDeviceEventEmitter, paramInt1, localUriHandler.fetch(localUri));
          ResponseUtil.onRequestSuccess(localRCTDeviceEventEmitter, paramInt1);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, localIOException.getMessage(), localIOException);
      return;
    }
    Request.Builder localBuilder;
    OkHttpClient localOkHttpClient;
    Headers localHeaders;
    try
    {
      localBuilder = new Request.Builder().url(paramString2);
      if (paramInt1 != 0)
        localBuilder.tag(Integer.valueOf(paramInt1));
      OkHttpClient.Builder localBuilder1 = this.mClient.newBuilder();
      if (!paramBoolean2)
        localBuilder1.cookieJar(CookieJar.NO_COOKIES);
      if (paramBoolean1)
        localBuilder1.addNetworkInterceptor(new Interceptor()
        {
          public Response intercept(Interceptor.Chain paramAnonymousChain)
            throws IOException
          {
            Response localResponse = paramAnonymousChain.proceed(paramAnonymousChain.request());
            ProgressResponseBody localProgressResponseBody = new ProgressResponseBody(localResponse.body(), new ProgressListener()
            {
              long last = System.nanoTime();

              public void onProgress(long paramAnonymous2Long1, long paramAnonymous2Long2, boolean paramAnonymous2Boolean)
              {
                long l = System.nanoTime();
                if ((!paramAnonymous2Boolean) && (!NetworkingModule.shouldDispatch(l, this.last)));
                while (NetworkingModule.1.this.val$responseType.equals("text"))
                  return;
                ResponseUtil.onDataReceivedProgress(NetworkingModule.1.this.val$eventEmitter, NetworkingModule.1.this.val$requestId, paramAnonymous2Long1, paramAnonymous2Long2);
                this.last = l;
              }
            });
            return localResponse.newBuilder().body(localProgressResponseBody).build();
          }
        });
      if (paramInt2 != this.mClient.connectTimeoutMillis())
        localBuilder1.connectTimeout(paramInt2, TimeUnit.MILLISECONDS);
      localOkHttpClient = localBuilder1.build();
      localHeaders = extractHeaders(paramReadableArray, paramReadableMap);
      if (localHeaders == null)
      {
        ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Unrecognized headers format", null);
        return;
      }
    }
    catch (Exception localException)
    {
      ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, localException.getMessage(), null);
      return;
    }
    String str1 = localHeaders.get("content-type");
    String str2 = localHeaders.get("content-encoding");
    localBuilder.headers(localHeaders);
    RequestBodyHandler localRequestBodyHandler;
    if (paramReadableMap != null)
    {
      Iterator localIterator2 = this.mRequestBodyHandlers.iterator();
      do
      {
        if (!localIterator2.hasNext())
          break;
        localRequestBodyHandler = (RequestBodyHandler)localIterator2.next();
      }
      while (!localRequestBodyHandler.supports(paramReadableMap));
    }
    while (true)
    {
      Object localObject;
      if ((paramReadableMap == null) || (paramString1.toLowerCase().equals("get")) || (paramString1.toLowerCase().equals("head")))
        localObject = RequestBodyUtil.getEmptyBody(paramString1);
      while (true)
      {
        label356: localBuilder.method(paramString1, wrapRequestBodyWithProgressEmitter((RequestBody)localObject, localRCTDeviceEventEmitter, paramInt1));
        addRequest(paramInt1);
        localOkHttpClient.newCall(localBuilder.build()).enqueue(new okhttp3.Callback()
        {
          public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
          {
            if (NetworkingModule.this.mShuttingDown)
              return;
            NetworkingModule.this.removeRequest(paramInt1);
            if (paramAnonymousIOException.getMessage() != null);
            for (String str = paramAnonymousIOException.getMessage(); ; str = "Error while executing request: " + paramAnonymousIOException.getClass().getSimpleName())
            {
              ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, str, paramAnonymousIOException);
              return;
            }
          }

          public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
            throws IOException
          {
            if (NetworkingModule.this.mShuttingDown)
              return;
            NetworkingModule.this.removeRequest(paramInt1);
            ResponseUtil.onResponseReceived(localRCTDeviceEventEmitter, paramInt1, paramAnonymousResponse.code(), NetworkingModule.translateHeaders(paramAnonymousResponse.headers()), paramAnonymousResponse.request().url().toString());
            while (true)
            {
              ResponseBody localResponseBody1;
              try
              {
                localResponseBody1 = paramAnonymousResponse.body();
                if ((!"gzip".equalsIgnoreCase(paramAnonymousResponse.header("Content-Encoding"))) || (localResponseBody1 == null))
                  break label410;
                j localj = new j(localResponseBody1.source());
                String str1 = paramAnonymousResponse.header("Content-Type");
                if (str1 != null)
                {
                  localMediaType = MediaType.parse(str1);
                  localResponseBody2 = ResponseBody.create(localMediaType, -1L, l.a(localj));
                  Iterator localIterator = NetworkingModule.this.mResponseHandlers.iterator();
                  if (!localIterator.hasNext())
                    break label238;
                  NetworkingModule.ResponseHandler localResponseHandler = (NetworkingModule.ResponseHandler)localIterator.next();
                  if (!localResponseHandler.supports(paramString3))
                    continue;
                  WritableMap localWritableMap = localResponseHandler.toResponseData(localResponseBody2);
                  ResponseUtil.onDataReceived(localRCTDeviceEventEmitter, paramInt1, localWritableMap);
                  ResponseUtil.onRequestSuccess(localRCTDeviceEventEmitter, paramInt1);
                  return;
                }
              }
              catch (IOException localIOException1)
              {
                ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, localIOException1.getMessage(), localIOException1);
                return;
              }
              MediaType localMediaType = null;
              continue;
              label238: if ((paramBoolean1) && (paramString3.equals("text")))
              {
                NetworkingModule.this.readWithProgress(localRCTDeviceEventEmitter, paramInt1, localResponseBody2);
                ResponseUtil.onRequestSuccess(localRCTDeviceEventEmitter, paramInt1);
                return;
              }
              Object localObject = "";
              boolean bool = paramString3.equals("text");
              if (bool);
              while (true)
              {
                try
                {
                  String str3 = localResponseBody2.string();
                  localObject = str3;
                  ResponseUtil.onDataReceived(localRCTDeviceEventEmitter, paramInt1, (String)localObject);
                  ResponseUtil.onRequestSuccess(localRCTDeviceEventEmitter, paramInt1);
                  return;
                }
                catch (IOException localIOException2)
                {
                  if (paramAnonymousResponse.request().method().equalsIgnoreCase("HEAD"))
                    continue;
                  ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, localIOException2.getMessage(), localIOException2);
                  continue;
                }
                if (paramString3.equals("base64"))
                {
                  String str2 = Base64.encodeToString(localResponseBody2.bytes(), 2);
                  localObject = str2;
                }
              }
              label410: ResponseBody localResponseBody2 = localResponseBody1;
            }
          }
        });
        return;
        if (localRequestBodyHandler != null)
        {
          localObject = localRequestBodyHandler.toRequestBody(paramReadableMap, str1);
        }
        else if (paramReadableMap.hasKey("string"))
        {
          if (str1 == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
            return;
          }
          String str6 = paramReadableMap.getString("string");
          MediaType localMediaType = MediaType.parse(str1);
          if (RequestBodyUtil.isGzipEncoding(str2))
          {
            localObject = RequestBodyUtil.createGzip(localMediaType, str6);
            if (localObject == null)
              ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Failed to gzip request body", null);
          }
          else
          {
            if (localMediaType == null);
            for (Charset localCharset = StandardCharsets.UTF_8; ; localCharset = localMediaType.charset(StandardCharsets.UTF_8))
            {
              localObject = RequestBody.create(localMediaType, str6.getBytes(localCharset));
              break;
            }
          }
        }
        else if (paramReadableMap.hasKey("base64"))
        {
          if (str1 == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
            return;
          }
          String str5 = paramReadableMap.getString("base64");
          localObject = RequestBody.create(MediaType.parse(str1), f.b(str5));
        }
        else
        {
          if (!paramReadableMap.hasKey("uri"))
            break;
          if (str1 == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
            return;
          }
          String str4 = paramReadableMap.getString("uri");
          InputStream localInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), str4);
          if (localInputStream == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Could not retrieve file for uri " + str4, null);
            return;
          }
          localObject = RequestBodyUtil.create(MediaType.parse(str1), localInputStream);
        }
      }
      if (paramReadableMap.hasKey("formData"))
        if (str1 != null)
          break label768;
      label768: for (String str3 = "multipart/form-data"; ; str3 = str1)
      {
        MultipartBody.Builder localBuilder2 = constructMultipartBody(paramReadableMap.getArray("formData"), str3, paramInt1);
        if (localBuilder2 == null)
          break;
        localObject = localBuilder2.build();
        break label356;
        localObject = RequestBodyUtil.getEmptyBody(paramString1);
        break label356;
      }
      localRequestBodyHandler = null;
    }
  }

  public static abstract interface RequestBodyHandler
  {
    public abstract boolean supports(ReadableMap paramReadableMap);

    public abstract RequestBody toRequestBody(ReadableMap paramReadableMap, String paramString);
  }

  public static abstract interface ResponseHandler
  {
    public abstract boolean supports(String paramString);

    public abstract WritableMap toResponseData(ResponseBody paramResponseBody)
      throws IOException;
  }

  public static abstract interface UriHandler
  {
    public abstract WritableMap fetch(Uri paramUri)
      throws IOException;

    public abstract boolean supports(Uri paramUri, String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.NetworkingModule
 * JD-Core Version:    0.6.2
 */