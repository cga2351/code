package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState>
{
  public static final int HTTP_DEFAULT_TIMEOUT = 30000;
  public static final int HTTP_PERMANENT_REDIRECT = 308;
  public static final int HTTP_TEMPORARY_REDIRECT = 307;
  private static final int MAX_REDIRECTS = 5;
  private static final int NUM_NETWORK_THREADS = 3;
  private final ExecutorService mExecutorService;
  private int mHttpConnectionTimeout;

  public HttpUrlConnectionNetworkFetcher()
  {
    this(Executors.newFixedThreadPool(3));
  }

  public HttpUrlConnectionNetworkFetcher(int paramInt)
  {
    this(Executors.newFixedThreadPool(3));
    this.mHttpConnectionTimeout = paramInt;
  }

  @VisibleForTesting
  HttpUrlConnectionNetworkFetcher(ExecutorService paramExecutorService)
  {
    this.mExecutorService = paramExecutorService;
  }

  private HttpURLConnection downloadFrom(Uri paramUri, int paramInt)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = openConnectionTo(paramUri);
    localHttpURLConnection.setConnectTimeout(this.mHttpConnectionTimeout);
    int i = localHttpURLConnection.getResponseCode();
    if (isHttpSuccess(i))
      return localHttpURLConnection;
    if (isHttpRedirect(i))
    {
      String str1 = localHttpURLConnection.getHeaderField("Location");
      localHttpURLConnection.disconnect();
      if (str1 == null);
      for (Uri localUri = null; ; localUri = Uri.parse(str1))
      {
        String str2 = paramUri.getScheme();
        if ((paramInt <= 0) || (localUri == null) || (localUri.getScheme().equals(str2)))
          break;
        return downloadFrom(localUri, paramInt - 1);
      }
      Object[] arrayOfObject3;
      if (paramInt == 0)
      {
        arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = paramUri.toString();
      }
      Object[] arrayOfObject2;
      for (String str3 = error("URL %s follows too many redirects", arrayOfObject3); ; str3 = error("URL %s returned %d without a valid redirect", arrayOfObject2))
      {
        throw new IOException(str3);
        arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramUri.toString();
        arrayOfObject2[1] = Integer.valueOf(i);
      }
    }
    localHttpURLConnection.disconnect();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramUri.toString();
    arrayOfObject1[1] = Integer.valueOf(i);
    throw new IOException(String.format("Image URL %s returned HTTP code %d", arrayOfObject1));
  }

  private static String error(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.getDefault(), paramString, paramArrayOfObject);
  }

  private static boolean isHttpRedirect(int paramInt)
  {
    switch (paramInt)
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 300:
    case 301:
    case 302:
    case 303:
    case 307:
    case 308:
    }
    return true;
  }

  private static boolean isHttpSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }

  @VisibleForTesting
  static HttpURLConnection openConnectionTo(Uri paramUri)
    throws IOException
  {
    return (HttpURLConnection)UriUtil.uriToUrl(paramUri).openConnection();
  }

  public FetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new FetchState(paramConsumer, paramProducerContext);
  }

  public void fetch(final FetchState paramFetchState, final NetworkFetcher.Callback paramCallback)
  {
    final Future localFuture = this.mExecutorService.submit(new Runnable()
    {
      public void run()
      {
        HttpUrlConnectionNetworkFetcher.this.fetchSync(paramFetchState, paramCallback);
      }
    });
    paramFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (localFuture.cancel(false))
          paramCallback.onCancellation();
      }
    });
  }

  // ERROR //
  @VisibleForTesting
  void fetchSync(FetchState paramFetchState, NetworkFetcher.Callback paramCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 177	com/facebook/imagepipeline/producers/FetchState:getUri	()Landroid/net/Uri;
    //   7: iconst_5
    //   8: invokespecial 85	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher:downloadFrom	(Landroid/net/Uri;I)Ljava/net/HttpURLConnection;
    //   11: astore 9
    //   13: aload 9
    //   15: astore 5
    //   17: aconst_null
    //   18: astore_3
    //   19: aload 5
    //   21: ifnull +17 -> 38
    //   24: aload 5
    //   26: invokevirtual 181	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   29: astore_3
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_m1
    //   33: invokeinterface 187 3 0
    //   38: aload_3
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: invokevirtual 192	java/io/InputStream:close	()V
    //   46: aload 5
    //   48: ifnull +8 -> 56
    //   51: aload 5
    //   53: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   56: return
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 5
    //   62: aload_2
    //   63: aload 7
    //   65: invokeinterface 196 2 0
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 192	java/io/InputStream:close	()V
    //   78: aload 5
    //   80: ifnull -24 -> 56
    //   83: aload 5
    //   85: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   88: return
    //   89: astore 4
    //   91: aconst_null
    //   92: astore 5
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 192	java/io/InputStream:close	()V
    //   102: aload 5
    //   104: ifnull +8 -> 112
    //   107: aload 5
    //   109: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   112: aload 4
    //   114: athrow
    //   115: astore 10
    //   117: goto -71 -> 46
    //   120: astore 8
    //   122: goto -44 -> 78
    //   125: astore 6
    //   127: goto -25 -> 102
    //   130: astore 4
    //   132: goto -38 -> 94
    //   135: astore 7
    //   137: goto -75 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	57	java/io/IOException
    //   2	13	89	finally
    //   42	46	115	java/io/IOException
    //   74	78	120	java/io/IOException
    //   98	102	125	java/io/IOException
    //   24	38	130	finally
    //   62	70	130	finally
    //   24	38	135	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher
 * JD-Core Version:    0.6.2
 */