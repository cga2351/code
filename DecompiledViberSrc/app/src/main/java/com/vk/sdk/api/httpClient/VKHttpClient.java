package com.vk.sdk.api.httpClient;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.util.VKUtil;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

public class VKHttpClient
{
  private static final ExecutorService mBackgroundExecutor = Executors.newFixedThreadPool(3);
  private static final ExecutorService mResponseService = Executors.newSingleThreadExecutor();

  public static void cancelHttpOperation(VKHttpOperation paramVKHttpOperation)
  {
    mBackgroundExecutor.execute(new Runnable()
    {
      public void run()
      {
        this.val$operation.getUriRequest().abort();
      }
    });
  }

  public static VKHTTPRequest docUploadRequest(String paramString, File paramFile)
  {
    VKHTTPRequest localVKHTTPRequest = new VKHTTPRequest(paramString);
    localVKHTTPRequest.entity = new VKMultipartEntity(new File[] { paramFile }, "doc");
    return localVKHTTPRequest;
  }

  public static void enqueueOperation(VKAbstractOperation paramVKAbstractOperation)
  {
    mBackgroundExecutor.execute(new Runnable()
    {
      public void run()
      {
        this.val$operation.start(VKHttpClient.mResponseService);
      }
    });
  }

  public static VKHttpResponse execute(VKHTTPRequest paramVKHTTPRequest)
    throws IOException
  {
    VKHttpResponse localVKHttpResponse = new VKHttpResponse(paramVKHTTPRequest.createConnection(), null);
    if (paramVKHTTPRequest.isAborted)
      return null;
    return localVKHttpResponse;
  }

  public static VKHTTPRequest fileUploadRequest(String paramString, File[] paramArrayOfFile)
  {
    VKHTTPRequest localVKHTTPRequest = new VKHTTPRequest(paramString);
    localVKHTTPRequest.entity = new VKMultipartEntity(paramArrayOfFile);
    return localVKHTTPRequest;
  }

  private static Map<String, String> getDefaultHeaders()
  {
    return new HashMap()
    {
      private static final long serialVersionUID = 200199014417610665L;
    };
  }

  public static VKHTTPRequest requestWithVkRequest(VKRequest paramVKRequest)
  {
    VKAccessToken localVKAccessToken = VKAccessToken.currentToken();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    if ((paramVKRequest.secure) || ((localVKAccessToken != null) && (localVKAccessToken.httpsRequired)));
    for (String str = "s"; ; str = "")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = paramVKRequest.methodName;
      VKHTTPRequest localVKHTTPRequest = new VKHTTPRequest(String.format(localLocale, "http%s://api.vk.com/method/%s", arrayOfObject));
      localVKHTTPRequest.headers = getDefaultHeaders();
      localVKHTTPRequest.setVkParameters(paramVKRequest.getPreparedParameters());
      return localVKHTTPRequest;
    }
  }

  public static class VKHTTPRequest
  {
    public HttpURLConnection connection;
    public VKMultipartEntity entity = null;
    public Map<String, String> headers = null;
    public boolean isAborted = false;
    public URL methodUrl = null;
    public List<Pair<String, String>> parameters = null;
    public int timeout = 20000;

    public VKHTTPRequest(String paramString)
    {
      if (paramString != null);
      try
      {
        this.methodUrl = new URL(paramString);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
      }
    }

    public void abort()
    {
      if (this.connection != null)
        this.connection.disconnect();
      this.isAborted = true;
    }

    HttpURLConnection createConnection()
      throws IOException
    {
      this.connection = ((HttpURLConnection)this.methodUrl.openConnection());
      this.connection.setReadTimeout(this.timeout);
      this.connection.setConnectTimeout(5000 + this.timeout);
      this.connection.setRequestMethod("POST");
      this.connection.setUseCaches(false);
      this.connection.setDoInput(true);
      this.connection.setDoOutput(true);
      try
      {
        Context localContext = VKUIHelper.getApplicationContext();
        if (localContext != null)
        {
          PackageManager localPackageManager = localContext.getPackageManager();
          if (localPackageManager != null)
          {
            PackageInfo localPackageInfo = localPackageManager.getPackageInfo(localContext.getPackageName(), 0);
            HttpURLConnection localHttpURLConnection = this.connection;
            Locale localLocale = Locale.US;
            Object[] arrayOfObject = new Object[7];
            arrayOfObject[0] = VKUtil.getApplicationName(localContext);
            arrayOfObject[1] = localPackageInfo.versionName;
            arrayOfObject[2] = Build.MODEL;
            arrayOfObject[3] = Integer.valueOf(Build.VERSION.SDK_INT);
            arrayOfObject[4] = Float.valueOf(localContext.getResources().getDisplayMetrics().density);
            arrayOfObject[5] = "1.6.5";
            arrayOfObject[6] = localPackageInfo.packageName;
            localHttpURLConnection.setRequestProperty("User-Agent", String.format(localLocale, "%s/%s (%s; Android %d; Scale/%.2f; VK SDK %s; %s)", arrayOfObject));
          }
        }
        label211: this.connection.setRequestProperty("Connection", "Keep-Alive");
        if (this.headers != null)
        {
          Iterator localIterator = this.headers.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            this.connection.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        if (this.entity != null)
        {
          this.connection.addRequestProperty("Content-length", this.entity.getContentLength() + "");
          Pair localPair = this.entity.getContentType();
          this.connection.addRequestProperty((String)localPair.first, (String)localPair.second);
        }
        OutputStream localOutputStream = this.connection.getOutputStream();
        writeParams(localOutputStream);
        localOutputStream.close();
        this.connection.connect();
        return this.connection;
      }
      catch (Exception localException)
      {
        break label211;
      }
    }

    public String getQuery()
      throws UnsupportedEncodingException
    {
      if (this.parameters == null)
        return null;
      ArrayList localArrayList = new ArrayList(this.parameters.size());
      Iterator localIterator = this.parameters.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = URLEncoder.encode((String)localPair.first, "UTF-8");
        arrayOfObject[1] = URLEncoder.encode((String)localPair.second, "UTF-8");
        localArrayList.add(String.format("%s=%s", arrayOfObject));
      }
      return TextUtils.join("&", localArrayList);
    }

    void setVkParameters(VKParameters paramVKParameters)
    {
      ArrayList localArrayList = new ArrayList(paramVKParameters.size());
      Iterator localIterator = paramVKParameters.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject1 = localEntry.getValue();
        if ((localObject1 instanceof VKAttachments))
        {
          localArrayList.add(new Pair(localEntry.getKey(), ((VKAttachments)localObject1).toAttachmentsString()));
        }
        else if ((localObject1 instanceof Collection))
        {
          Collection localCollection = (Collection)localObject1;
          localArrayList.add(new Pair(localEntry.getKey(), TextUtils.join(",", localCollection)));
        }
        else
        {
          Object localObject2 = localEntry.getKey();
          if (localObject1 == null);
          for (Object localObject3 = null; ; localObject3 = String.valueOf(localObject1))
          {
            localArrayList.add(new Pair(localObject2, localObject3));
            break;
          }
        }
      }
      this.parameters = localArrayList;
    }

    void writeParams(OutputStream paramOutputStream)
      throws IOException
    {
      if (this.entity != null)
        this.entity.writeTo(paramOutputStream);
      String str;
      do
      {
        return;
        str = getQuery();
      }
      while ((str == null) || (str.length() <= 0));
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream, "UTF-8"));
      localBufferedWriter.write(str);
      localBufferedWriter.flush();
      localBufferedWriter.close();
    }
  }

  public static abstract interface VKHttpProgressCallback
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }

  public static class VKHttpResponse
  {
    public final long contentLength;
    public final byte[] responseBytes;
    public Map<String, String> responseHeaders = null;
    public final int statusCode;

    public VKHttpResponse(HttpURLConnection paramHttpURLConnection, VKHttpClient.VKHttpProgressCallback paramVKHttpProgressCallback)
      throws IOException
    {
      this.statusCode = paramHttpURLConnection.getResponseCode();
      this.contentLength = paramHttpURLConnection.getContentLength();
      if (paramHttpURLConnection.getHeaderFields() != null)
      {
        this.responseHeaders = new HashMap();
        Iterator localIterator = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          this.responseHeaders.put(localEntry.getKey(), TextUtils.join(",", (Iterable)localEntry.getValue()));
        }
      }
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      if (this.responseHeaders != null)
      {
        String str = (String)this.responseHeaders.get("Content-Encoding");
        if ((str == null) || (!str.equalsIgnoreCase("gzip")));
      }
      for (Object localObject = new GZIPInputStream(localInputStream); ; localObject = localInputStream)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        if (this.contentLength <= l)
          paramVKHttpProgressCallback = null;
        while (true)
        {
          int i = ((InputStream)localObject).read(arrayOfByte);
          if (i == -1)
            break;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
          l += i;
          if (paramVKHttpProgressCallback != null)
            paramVKHttpProgressCallback.onProgress(l, this.contentLength);
        }
        ((InputStream)localObject).close();
        localByteArrayOutputStream.flush();
        this.responseBytes = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKHttpClient
 * JD-Core Version:    0.6.2
 */