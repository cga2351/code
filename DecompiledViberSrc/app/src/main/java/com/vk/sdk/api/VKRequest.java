package com.vk.sdk.api;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKObject;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.VKServiceActivity.VKServiceType;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKHttpClient.VKHTTPRequest;
import com.vk.sdk.api.httpClient.VKHttpClient.VKHttpResponse;
import com.vk.sdk.api.httpClient.VKHttpOperation;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener;
import com.vk.sdk.api.httpClient.VKModelOperation;
import com.vk.sdk.api.model.VKApiModel;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VKRequest extends VKObject
{
  public int attempts;
  public final Context context = VKUIHelper.getApplicationContext();
  private int mAttemptsUsed;
  private VKAbstractOperation mLoadingOperation;
  private Looper mLooper;
  private final VKParameters mMethodParameters;
  private Class<? extends VKApiModel> mModelClass;
  private VKParser mModelParser;
  private ArrayList<VKRequest> mPostRequestsQueue;
  private String mPreferredLang;
  private VKParameters mPreparedParameters;
  private boolean mUseLooperForCallListener = true;
  public final String methodName;
  public boolean parseModel;
  public VKRequestListener requestListener;
  public WeakReference<VKResponse> response;
  public boolean secure;
  public boolean shouldInterruptUI;
  public boolean useSystemLanguage;

  public VKRequest(String paramString)
  {
    this(paramString, null);
  }

  public VKRequest(String paramString, VKParameters paramVKParameters)
  {
    this(paramString, paramVKParameters, null);
  }

  @Deprecated
  public VKRequest(String paramString, VKParameters paramVKParameters, HttpMethod paramHttpMethod, Class<? extends VKApiModel> paramClass)
  {
    this(paramString, paramVKParameters, paramClass);
  }

  public VKRequest(String paramString, VKParameters paramVKParameters, Class<? extends VKApiModel> paramClass)
  {
    this.methodName = paramString;
    if (paramVKParameters == null)
      paramVKParameters = new VKParameters();
    this.mMethodParameters = new VKParameters(paramVKParameters);
    this.mAttemptsUsed = 0;
    this.secure = true;
    this.attempts = 1;
    this.mPreferredLang = "en";
    this.useSystemLanguage = true;
    this.shouldInterruptUI = true;
    setModelClass(paramClass);
  }

  private void addPostRequest(VKRequest paramVKRequest)
  {
    if (this.mPostRequestsQueue == null)
      this.mPostRequestsQueue = new ArrayList();
    this.mPostRequestsQueue.add(paramVKRequest);
  }

  private String generateSig(VKAccessToken paramVKAccessToken)
  {
    String str1 = VKStringJoiner.joinParams(this.mPreparedParameters);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.methodName;
    arrayOfObject[1] = str1;
    String str2 = String.format(localLocale, "/method/%s?%s", arrayOfObject);
    return VKUtil.md5(str2 + paramVKAccessToken.secret);
  }

  private VKJsonOperation.VKJSONOperationCompleteListener getHttpListener()
  {
    return new VKJsonOperation.VKJSONOperationCompleteListener()
    {
      public void onComplete(VKJsonOperation paramAnonymousVKJsonOperation, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousJSONObject.has("error"))
          try
          {
            VKError localVKError = new VKError(paramAnonymousJSONObject.getJSONObject("error"));
            if (VKRequest.this.processCommonError(localVKError))
              return;
            VKRequest.this.provideError(localVKError);
            return;
          }
          catch (JSONException localJSONException)
          {
            return;
          }
        VKRequest localVKRequest = VKRequest.this;
        if ((VKRequest.this.mLoadingOperation instanceof VKModelOperation));
        for (Object localObject = ((VKModelOperation)VKRequest.this.mLoadingOperation).parsedModel; ; localObject = null)
        {
          localVKRequest.provideResponse(paramAnonymousJSONObject, localObject);
          return;
        }
      }

      public void onError(VKJsonOperation paramAnonymousVKJsonOperation, VKError paramAnonymousVKError)
      {
        if ((paramAnonymousVKError.errorCode != -102) && (paramAnonymousVKError.errorCode != -101) && (paramAnonymousVKJsonOperation != null) && (paramAnonymousVKJsonOperation.response != null) && (paramAnonymousVKJsonOperation.response.statusCode == 200))
        {
          VKRequest.this.provideResponse(paramAnonymousVKJsonOperation.getResponseJson(), null);
          return;
        }
        if ((VKRequest.this.attempts == 0) || (VKRequest.access$404(VKRequest.this) < VKRequest.this.attempts))
        {
          if (VKRequest.this.requestListener != null)
            VKRequest.this.requestListener.attemptFailed(VKRequest.this, VKRequest.this.mAttemptsUsed, VKRequest.this.attempts);
          VKRequest.this.runOnLooper(new Runnable()
          {
            public void run()
            {
              VKRequest.this.start();
            }
          }
          , 300);
          return;
        }
        VKRequest.this.provideError(paramAnonymousVKError);
      }
    };
  }

  private String getLang()
  {
    String str = this.mPreferredLang;
    Resources localResources = Resources.getSystem();
    if ((this.useSystemLanguage) && (localResources != null))
    {
      str = localResources.getConfiguration().locale.getLanguage();
      if (str.equals("uk"))
        str = "ua";
      if (!Arrays.asList(new String[] { "ru", "en", "ua", "es", "fi", "de", "it" }).contains(str))
        str = this.mPreferredLang;
    }
    return str;
  }

  public static VKRequest getRegisteredRequest(long paramLong)
  {
    return (VKRequest)getRegisteredObject(paramLong);
  }

  private boolean processCommonError(VKError paramVKError)
  {
    if (paramVKError.errorCode == -101)
    {
      VKError localVKError = paramVKError.apiError;
      VKSdk.notifySdkAboutApiError(localVKError);
      if (localVKError.errorCode == 16)
      {
        VKAccessToken localVKAccessToken = VKAccessToken.currentToken();
        if (localVKAccessToken != null)
        {
          localVKAccessToken.httpsRequired = true;
          localVKAccessToken.save();
        }
        repeat();
        return true;
      }
      if (this.shouldInterruptUI)
      {
        localVKError.request = this;
        if (paramVKError.apiError.errorCode == 14)
        {
          this.mLoadingOperation = null;
          VKServiceActivity.interruptWithError(this.context, localVKError, VKServiceActivity.VKServiceType.Captcha);
          return true;
        }
        if (localVKError.errorCode == 17)
        {
          VKServiceActivity.interruptWithError(this.context, localVKError, VKServiceActivity.VKServiceType.Validation);
          return true;
        }
      }
    }
    return false;
  }

  private void provideError(final VKError paramVKError)
  {
    paramVKError.request = this;
    final boolean bool = this.mUseLooperForCallListener;
    if ((!bool) && (this.requestListener != null))
      this.requestListener.onError(paramVKError);
    runOnLooper(new Runnable()
    {
      public void run()
      {
        if ((bool) && (VKRequest.this.requestListener != null))
          VKRequest.this.requestListener.onError(paramVKError);
        if ((VKRequest.this.mPostRequestsQueue != null) && (VKRequest.this.mPostRequestsQueue.size() > 0))
        {
          Iterator localIterator = VKRequest.this.mPostRequestsQueue.iterator();
          while (localIterator.hasNext())
          {
            VKRequest localVKRequest = (VKRequest)localIterator.next();
            if (localVKRequest.requestListener != null)
              localVKRequest.requestListener.onError(paramVKError);
          }
        }
      }
    });
  }

  private void provideResponse(JSONObject paramJSONObject, Object paramObject)
  {
    final VKResponse localVKResponse = new VKResponse();
    localVKResponse.request = this;
    localVKResponse.json = paramJSONObject;
    localVKResponse.parsedModel = paramObject;
    this.response = new WeakReference(localVKResponse);
    if ((this.mLoadingOperation instanceof VKHttpOperation))
      localVKResponse.responseString = ((VKHttpOperation)this.mLoadingOperation).getResponseString();
    final boolean bool = this.mUseLooperForCallListener;
    runOnLooper(new Runnable()
    {
      public void run()
      {
        if ((VKRequest.this.mPostRequestsQueue != null) && (VKRequest.this.mPostRequestsQueue.size() > 0))
        {
          Iterator localIterator = VKRequest.this.mPostRequestsQueue.iterator();
          while (localIterator.hasNext())
            ((VKRequest)localIterator.next()).start();
        }
        if ((bool) && (VKRequest.this.requestListener != null))
          VKRequest.this.requestListener.onComplete(localVKResponse);
      }
    });
    if ((!bool) && (this.requestListener != null))
      this.requestListener.onComplete(localVKResponse);
  }

  private void runOnLooper(Runnable paramRunnable)
  {
    runOnLooper(paramRunnable, 0);
  }

  private void runOnLooper(Runnable paramRunnable, int paramInt)
  {
    if (this.mLooper == null)
      this.mLooper = Looper.getMainLooper();
    if (paramInt > 0)
    {
      new Handler(this.mLooper).postDelayed(paramRunnable, paramInt);
      return;
    }
    new Handler(this.mLooper).post(paramRunnable);
  }

  private void runOnMainLooper(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  public void addExtraParameter(String paramString, Object paramObject)
  {
    this.mMethodParameters.put(paramString, paramObject);
  }

  public void addExtraParameters(VKParameters paramVKParameters)
  {
    this.mMethodParameters.putAll(paramVKParameters);
  }

  public void cancel()
  {
    if (this.mLoadingOperation != null)
    {
      this.mLoadingOperation.cancel();
      return;
    }
    provideError(new VKError(-102));
  }

  public void executeAfterRequest(VKRequest paramVKRequest, VKRequestListener paramVKRequestListener)
  {
    this.requestListener = paramVKRequestListener;
    paramVKRequest.addPostRequest(this);
  }

  public void executeSyncWithListener(VKRequestListener paramVKRequestListener)
  {
    VKSyncRequestUtil.executeSyncWithListener(this, paramVKRequestListener);
  }

  public void executeWithListener(VKRequestListener paramVKRequestListener)
  {
    this.requestListener = paramVKRequestListener;
    start();
  }

  public VKParameters getMethodParameters()
  {
    return this.mMethodParameters;
  }

  VKAbstractOperation getOperation()
  {
    if (this.parseModel)
    {
      if (this.mModelClass == null)
        break label84;
      this.mLoadingOperation = new VKModelOperation(getPreparedRequest(), this.mModelClass);
    }
    while (true)
    {
      if (this.mLoadingOperation == null)
        this.mLoadingOperation = new VKJsonOperation(getPreparedRequest());
      if ((this.mLoadingOperation instanceof VKHttpOperation))
        ((VKHttpOperation)this.mLoadingOperation).setHttpOperationListener(getHttpListener());
      return this.mLoadingOperation;
      label84: if (this.mModelParser != null)
        this.mLoadingOperation = new VKModelOperation(getPreparedRequest(), this.mModelParser);
    }
  }

  public VKParameters getPreparedParameters()
  {
    if (this.mPreparedParameters == null)
    {
      this.mPreparedParameters = new VKParameters(this.mMethodParameters);
      VKAccessToken localVKAccessToken = VKAccessToken.currentToken();
      if (localVKAccessToken != null)
      {
        this.mPreparedParameters.put("access_token", localVKAccessToken.accessToken);
        if (localVKAccessToken.httpsRequired)
          this.secure = true;
      }
      this.mPreparedParameters.put("v", VKSdk.getApiVersion());
      this.mPreparedParameters.put("lang", getLang());
      if (this.secure)
        this.mPreparedParameters.put("https", "1");
      if ((localVKAccessToken != null) && (localVKAccessToken.secret != null))
      {
        String str = generateSig(localVKAccessToken);
        this.mPreparedParameters.put("sig", str);
      }
    }
    return this.mPreparedParameters;
  }

  public VKHttpClient.VKHTTPRequest getPreparedRequest()
  {
    VKHttpClient.VKHTTPRequest localVKHTTPRequest = VKHttpClient.requestWithVkRequest(this);
    if (localVKHTTPRequest == null)
    {
      provideError(new VKError(-103));
      localVKHTTPRequest = null;
    }
    return localVKHTTPRequest;
  }

  public void repeat()
  {
    this.mAttemptsUsed = 0;
    this.mPreparedParameters = null;
    this.mLoadingOperation = null;
    start();
  }

  public void setModelClass(Class<? extends VKApiModel> paramClass)
  {
    this.mModelClass = paramClass;
    if (this.mModelClass != null)
      this.parseModel = true;
  }

  public void setPreferredLang(String paramString)
  {
    this.useSystemLanguage = false;
    this.mPreferredLang = paramString;
  }

  public void setRequestListener(VKRequestListener paramVKRequestListener)
  {
    this.requestListener = paramVKRequestListener;
  }

  public void setResponseParser(VKParser paramVKParser)
  {
    this.mModelParser = paramVKParser;
    if (this.mModelParser != null)
      this.parseModel = true;
  }

  public void setUseLooperForCallListener(boolean paramBoolean)
  {
    this.mUseLooperForCallListener = paramBoolean;
  }

  public void start()
  {
    VKAbstractOperation localVKAbstractOperation = getOperation();
    this.mLoadingOperation = localVKAbstractOperation;
    if (localVKAbstractOperation == null)
      return;
    if (this.mLooper == null)
      this.mLooper = Looper.myLooper();
    VKHttpClient.enqueueOperation(this.mLoadingOperation);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("{").append(this.methodName).append(" ");
    VKParameters localVKParameters = getMethodParameters();
    Iterator localIterator = localVKParameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append("=").append(localVKParameters.get(str)).append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  @Deprecated
  public static enum HttpMethod
  {
    static
    {
      HttpMethod[] arrayOfHttpMethod = new HttpMethod[2];
      arrayOfHttpMethod[0] = GET;
      arrayOfHttpMethod[1] = POST;
    }
  }

  public static enum VKProgressType
  {
    static
    {
      VKProgressType[] arrayOfVKProgressType = new VKProgressType[2];
      arrayOfVKProgressType[0] = Download;
      arrayOfVKProgressType[1] = Upload;
    }
  }

  public static abstract class VKRequestListener
  {
    public void attemptFailed(VKRequest paramVKRequest, int paramInt1, int paramInt2)
    {
    }

    public void onComplete(VKResponse paramVKResponse)
    {
    }

    public void onError(VKError paramVKError)
    {
    }

    public void onProgress(VKRequest.VKProgressType paramVKProgressType, long paramLong1, long paramLong2)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKRequest
 * JD-Core Version:    0.6.2
 */