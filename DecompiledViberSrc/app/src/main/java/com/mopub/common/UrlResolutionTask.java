package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

@VisibleForTesting
public class UrlResolutionTask extends AsyncTask<String, Void, String>
{
  private final a a;

  UrlResolutionTask(a parama)
  {
    this.a = parama;
  }

  @VisibleForTesting
  static String a(String paramString, HttpURLConnection paramHttpURLConnection)
    throws IOException, URISyntaxException
  {
    URI localURI = new URI(paramString);
    int i = paramHttpURLConnection.getResponseCode();
    String str1 = paramHttpURLConnection.getHeaderField("location");
    Object localObject = null;
    if (i >= 300)
    {
      localObject = null;
      if (i >= 400);
    }
    try
    {
      String str2 = localURI.resolve(str1).toString();
      localObject = str2;
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ("Invalid URL redirection. baseUrl=" + paramString + "\n redirectUrl=" + str1);
      MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      throw new URISyntaxException(str1, "Unable to parse invalid URL");
    }
    catch (NullPointerException localNullPointerException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ("Invalid URL redirection. baseUrl=" + paramString + "\n redirectUrl=" + str1);
      MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
      throw localNullPointerException;
    }
  }

  // ERROR //
  private String b(String paramString)
    throws IOException, URISyntaxException
  {
    // Byte code:
    //   0: new 83	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_2
    //   12: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 31	java/net/HttpURLConnection
    //   18: astore 7
    //   20: aload 7
    //   22: iconst_0
    //   23: invokevirtual 92	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   26: aload_1
    //   27: aload 7
    //   29: invokestatic 94	com/mopub/common/UrlResolutionTask:a	(Ljava/lang/String;Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   32: astore 9
    //   34: aload 7
    //   36: ifnull +25 -> 61
    //   39: aload 7
    //   41: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   44: astore 10
    //   46: aload 10
    //   48: ifnull +8 -> 56
    //   51: aload 10
    //   53: invokevirtual 103	java/io/InputStream:close	()V
    //   56: aload 7
    //   58: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   61: aload 9
    //   63: areturn
    //   64: astore 11
    //   66: getstatic 55	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   69: iconst_1
    //   70: anewarray 57	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc 108
    //   77: aastore
    //   78: invokestatic 75	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   81: goto -25 -> 56
    //   84: astore 4
    //   86: aload_3
    //   87: ifnull +23 -> 110
    //   90: aload_3
    //   91: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +8 -> 106
    //   101: aload 5
    //   103: invokevirtual 103	java/io/InputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   110: aload 4
    //   112: athrow
    //   113: astore 6
    //   115: getstatic 55	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   118: iconst_1
    //   119: anewarray 57	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: ldc 108
    //   126: aastore
    //   127: invokestatic 75	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   130: goto -24 -> 106
    //   133: astore 8
    //   135: aload 7
    //   137: astore_3
    //   138: aload 8
    //   140: astore 4
    //   142: goto -56 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   51	56	64	java/io/IOException
    //   11	20	84	finally
    //   101	106	113	java/io/IOException
    //   20	34	133	finally
  }

  public static void getResolvedUrl(String paramString, a parama)
  {
    UrlResolutionTask localUrlResolutionTask = new UrlResolutionTask(parama);
    try
    {
      AsyncTasks.safeExecuteOnExecutor(localUrlResolutionTask, new String[] { paramString });
      return;
    }
    catch (Exception localException)
    {
      parama.onFailure("Failed to resolve url", localException);
    }
  }

  protected String a(String[] paramArrayOfString)
  {
    Object localObject1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      localObject1 = null;
    Object localObject2;
    while (true)
    {
      return localObject1;
      try
      {
        String str1 = paramArrayOfString[0];
        int i = 0;
        localObject1 = str1;
        localObject2 = null;
        while (true)
        {
          if ((localObject1 == null) || (i >= 10))
            break label94;
          if ((!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse((String)localObject1))) || (UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(Uri.parse((String)localObject1))))
            break;
          String str2 = b((String)localObject1);
          i++;
          localObject2 = localObject1;
          localObject1 = str2;
        }
      }
      catch (IOException localIOException)
      {
        return null;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        return null;
      }
      catch (NullPointerException localNullPointerException)
      {
        return null;
      }
    }
    label94: return localObject2;
  }

  protected void a(String paramString)
  {
    super.onPostExecute(paramString);
    if ((isCancelled()) || (paramString == null))
    {
      onCancelled();
      return;
    }
    this.a.onSuccess(paramString);
  }

  protected void onCancelled()
  {
    super.onCancelled();
    this.a.onFailure("Task for resolving url was cancelled", null);
  }

  static abstract interface a
  {
    public abstract void onFailure(String paramString, Throwable paramThrowable);

    public abstract void onSuccess(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.UrlResolutionTask
 * JD-Core Version:    0.6.2
 */