package com.facebook.react.devsupport;

import android.util.Log;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import f.c;
import f.e;
import f.l;
import f.s;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader
{
  private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
  private static final String TAG = "BundleDownloader";
  private BundleDeltaClient mBundleDeltaClient;
  private final OkHttpClient mClient;

  @Nullable
  private Call mDownloadBundleFromURLCall;

  public BundleDownloader(OkHttpClient paramOkHttpClient)
  {
    this.mClient = paramOkHttpClient;
  }

  private String formatBundleUrl(String paramString, BundleDeltaClient.ClientType paramClientType)
  {
    if ((BundleDeltaClient.isDeltaUrl(paramString)) && (this.mBundleDeltaClient != null) && (this.mBundleDeltaClient.canHandle(paramClientType)))
      paramString = this.mBundleDeltaClient.extendUrlForDelta(paramString);
    return paramString;
  }

  private BundleDeltaClient getBundleDeltaClient(BundleDeltaClient.ClientType paramClientType)
  {
    if ((this.mBundleDeltaClient == null) || (!this.mBundleDeltaClient.canHandle(paramClientType)))
      this.mBundleDeltaClient = BundleDeltaClient.create(paramClientType);
    return this.mBundleDeltaClient;
  }

  private static void populateBundleInfo(String paramString, Headers paramHeaders, BundleDeltaClient.ClientType paramClientType, BundleInfo paramBundleInfo)
  {
    String str1;
    if (paramClientType == BundleDeltaClient.ClientType.NONE)
      str1 = null;
    while (true)
    {
      BundleInfo.access$302(paramBundleInfo, str1);
      BundleInfo.access$402(paramBundleInfo, paramString);
      String str2 = paramHeaders.get("X-Metro-Files-Changed-Count");
      if (str2 != null);
      try
      {
        BundleInfo.access$502(paramBundleInfo, Integer.parseInt(str2));
        return;
        str1 = paramClientType.name();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        BundleInfo.access$502(paramBundleInfo, -2);
      }
    }
  }

  private void processBundleResult(String paramString, int paramInt, Headers paramHeaders, e parame, File paramFile, BundleInfo paramBundleInfo, BundleDeltaClient.ClientType paramClientType, DevBundleDownloadListener paramDevBundleDownloadListener)
    throws IOException
  {
    if (paramInt != 200)
    {
      String str = parame.r();
      DebugServerException localDebugServerException = DebugServerException.parse(str);
      if (localDebugServerException != null)
      {
        paramDevBundleDownloadListener.onFailure(localDebugServerException);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The development server returned response error code: ").append(paramInt).append("\n\n").append("URL: ").append(paramString).append("\n\n").append("Body:\n").append(str);
      paramDevBundleDownloadListener.onFailure(new DebugServerException(localStringBuilder.toString()));
      return;
    }
    if (paramBundleInfo != null)
      populateBundleInfo(paramString, paramHeaders, paramClientType, paramBundleInfo);
    File localFile = new File(paramFile.getPath() + ".tmp");
    Pair localPair;
    boolean bool;
    if (BundleDeltaClient.isDeltaUrl(paramString))
    {
      BundleDeltaClient localBundleDeltaClient = getBundleDeltaClient(paramClientType);
      Assertions.assertNotNull(localBundleDeltaClient);
      localPair = localBundleDeltaClient.processDelta(paramHeaders, parame, localFile);
      bool = ((Boolean)localPair.first).booleanValue();
    }
    for (NativeDeltaClient localNativeDeltaClient = (NativeDeltaClient)localPair.second; (bool) && (!localFile.renameTo(paramFile)); localNativeDeltaClient = null)
    {
      throw new IOException("Couldn't rename " + localFile + " to " + paramFile);
      this.mBundleDeltaClient = null;
      bool = storePlainJSInFile(parame, localFile);
    }
    paramDevBundleDownloadListener.onSuccess(localNativeDeltaClient);
  }

  private void processMultipartResponse(final String paramString1, final Response paramResponse, String paramString2, final File paramFile, @Nullable final BundleInfo paramBundleInfo, final BundleDeltaClient.ClientType paramClientType, final DevBundleDownloadListener paramDevBundleDownloadListener)
    throws IOException
  {
    if (!new MultipartStreamReader(paramResponse.body().source(), paramString2).readAllParts(new MultipartStreamReader.ChunkListener()
    {
      public void onChunkComplete(Map<String, String> paramAnonymousMap, c paramAnonymousc, boolean paramAnonymousBoolean)
        throws IOException
      {
        if (paramAnonymousBoolean)
        {
          i = paramResponse.code();
          if (paramAnonymousMap.containsKey("X-Http-Status"))
            i = Integer.parseInt((String)paramAnonymousMap.get("X-Http-Status"));
          BundleDownloader.this.processBundleResult(paramString1, i, Headers.of(paramAnonymousMap), paramAnonymousc, paramFile, paramBundleInfo, paramClientType, paramDevBundleDownloadListener);
        }
        while ((!paramAnonymousMap.containsKey("Content-Type")) || (!((String)paramAnonymousMap.get("Content-Type")).equals("application/json")))
        {
          int i;
          return;
        }
        while (true)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousc.r());
            if (!localJSONObject.has("status"))
              break label240;
            str = localJSONObject.getString("status");
            if (!localJSONObject.has("done"))
              break label234;
            localInteger1 = Integer.valueOf(localJSONObject.getInt("done"));
            if (localJSONObject.has("total"))
            {
              localInteger2 = Integer.valueOf(localJSONObject.getInt("total"));
              paramDevBundleDownloadListener.onProgress(str, localInteger1, localInteger2);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            FLog.e("ReactNative", "Error parsing progress JSON. " + localJSONException.toString());
            return;
          }
          Integer localInteger2 = null;
          continue;
          label234: Integer localInteger1 = null;
          continue;
          label240: String str = null;
        }
      }

      public void onChunkProgress(Map<String, String> paramAnonymousMap, long paramAnonymousLong1, long paramAnonymousLong2)
        throws IOException
      {
        if ("application/javascript".equals(paramAnonymousMap.get("Content-Type")))
          paramDevBundleDownloadListener.onProgress("Downloading JavaScript bundle", Integer.valueOf((int)(paramAnonymousLong1 / 1024L)), Integer.valueOf((int)(paramAnonymousLong2 / 1024L)));
      }
    }))
      paramDevBundleDownloadListener.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + paramResponse.code() + "\n\nURL: " + paramString1.toString() + "\n\n"));
  }

  private static boolean storePlainJSInFile(e parame, File paramFile)
    throws IOException
  {
    s locals = null;
    try
    {
      locals = l.b(paramFile);
      parame.a(locals);
      return true;
    }
    finally
    {
      if (locals != null)
        locals.close();
    }
  }

  public void downloadBundleFromURL(DevBundleDownloadListener paramDevBundleDownloadListener, File paramFile, String paramString, @Nullable BundleInfo paramBundleInfo, BundleDeltaClient.ClientType paramClientType)
  {
    downloadBundleFromURL(paramDevBundleDownloadListener, paramFile, paramString, paramBundleInfo, paramClientType, new Request.Builder());
  }

  public void downloadBundleFromURL(final DevBundleDownloadListener paramDevBundleDownloadListener, final File paramFile, String paramString, @Nullable final BundleInfo paramBundleInfo, final BundleDeltaClient.ClientType paramClientType, Request.Builder paramBuilder)
  {
    Request localRequest = paramBuilder.url(formatBundleUrl(paramString, paramClientType)).build();
    this.mDownloadBundleFromURLCall = ((Call)Assertions.assertNotNull(this.mClient.newCall(localRequest)));
    this.mDownloadBundleFromURLCall.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        if ((BundleDownloader.this.mDownloadBundleFromURLCall == null) || (BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()))
        {
          BundleDownloader.access$002(BundleDownloader.this, null);
          return;
        }
        BundleDownloader.access$002(BundleDownloader.this, null);
        paramDevBundleDownloadListener.onFailure(DebugServerException.makeGeneric("Could not connect to development server.", "URL: " + paramAnonymousCall.request().url().toString(), paramAnonymousIOException));
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if ((BundleDownloader.this.mDownloadBundleFromURLCall == null) || (BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()))
          BundleDownloader.access$002(BundleDownloader.this, null);
        while (true)
        {
          return;
          BundleDownloader.access$002(BundleDownloader.this, null);
          String str1 = paramAnonymousResponse.request().url().toString();
          String str2 = paramAnonymousResponse.header("content-type");
          Matcher localMatcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(str2);
          try
          {
            if (localMatcher.find())
              BundleDownloader.this.processMultipartResponse(str1, paramAnonymousResponse, localMatcher.group(1), paramFile, paramBundleInfo, paramClientType, paramDevBundleDownloadListener);
            while (paramAnonymousResponse != null)
            {
              if (0 == 0)
                break label215;
              try
              {
                paramAnonymousResponse.close();
                return;
              }
              catch (Throwable localThrowable4)
              {
                null.addSuppressed(localThrowable4);
                return;
              }
              BundleDownloader.this.processBundleResult(str1, paramAnonymousResponse.code(), paramAnonymousResponse.headers(), l.a(paramAnonymousResponse.body().source()), paramFile, paramBundleInfo, paramClientType, paramDevBundleDownloadListener);
            }
          }
          catch (Throwable localThrowable3)
          {
            Object localObject1;
            try
            {
              throw localThrowable3;
            }
            finally
            {
              localThrowable1 = localThrowable3;
            }
            if ((paramAnonymousResponse == null) || (localThrowable1 != null));
            while (true)
            {
              try
              {
                paramAnonymousResponse.close();
                throw localObject1;
                label215: paramAnonymousResponse.close();
                return;
              }
              catch (Throwable localThrowable2)
              {
                localThrowable1.addSuppressed(localThrowable2);
                continue;
              }
              paramAnonymousResponse.close();
            }
          }
          finally
          {
            while (true)
              Throwable localThrowable1 = null;
          }
        }
      }
    });
  }

  public static class BundleInfo
  {

    @Nullable
    private String mDeltaClientName;
    private int mFilesChangedCount;

    @Nullable
    private String mUrl;

    @Nullable
    public static BundleInfo fromJSONString(String paramString)
    {
      if (paramString == null)
        return null;
      BundleInfo localBundleInfo = new BundleInfo();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localBundleInfo.mDeltaClientName = localJSONObject.getString("deltaClient");
        localBundleInfo.mUrl = localJSONObject.getString("url");
        localBundleInfo.mFilesChangedCount = localJSONObject.getInt("filesChangedCount");
        return localBundleInfo;
      }
      catch (JSONException localJSONException)
      {
        Log.e("BundleDownloader", "Invalid bundle info: ", localJSONException);
      }
      return null;
    }

    @Nullable
    public String getDeltaClient()
    {
      return this.mDeltaClientName;
    }

    public int getFilesChangedCount()
    {
      return this.mFilesChangedCount;
    }

    public String getUrl()
    {
      if (this.mUrl != null)
        return this.mUrl;
      return "unknown";
    }

    @Nullable
    public String toJSONString()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("deltaClient", this.mDeltaClientName);
        localJSONObject.put("url", this.mUrl);
        localJSONObject.put("filesChangedCount", this.mFilesChangedCount);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        Log.e("BundleDownloader", "Can't serialize bundle info: ", localJSONException);
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.BundleDownloader
 * JD-Core Version:    0.6.2
 */