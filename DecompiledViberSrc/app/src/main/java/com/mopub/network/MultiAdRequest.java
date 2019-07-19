package com.mopub.network;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;

public class MultiAdRequest extends MoPubRequest<MultiAdResponse>
{
  final AdFormat a;
  final String b;
  private final Context c;
  private int d = 0;
  public final Listener mListener;

  MultiAdRequest(String paramString1, AdFormat paramAdFormat, String paramString2, Context paramContext, Listener paramListener)
  {
    super(paramContext, a(paramString1), paramListener);
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramAdFormat);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramListener);
    this.b = paramString2;
    this.mListener = paramListener;
    this.a = paramAdFormat;
    this.c = paramContext.getApplicationContext();
    setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
    setShouldCache(false);
    PersonalInfoManager localPersonalInfoManager = MoPub.getPersonalInformationManager();
    if (localPersonalInfoManager != null)
      localPersonalInfoManager.requestSync(false);
  }

  private static String a(String paramString)
  {
    if ((MoPub.getPersonalInformationManager() == null) || (!MoPub.isSdkInitialized()))
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Make sure to call MoPub#initializeSdk before loading an ad." });
      paramString = "";
    }
    return paramString;
  }

  protected Response<MultiAdResponse> a(NetworkResponse paramNetworkResponse)
  {
    try
    {
      MultiAdResponse localMultiAdResponse = new MultiAdResponse(this.c, paramNetworkResponse, this.a, this.b);
      return Response.success(localMultiAdResponse, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    catch (Exception localException)
    {
      if ((localException instanceof MoPubNetworkError))
        return Response.error((MoPubNetworkError)localException);
      return Response.error(new MoPubNetworkError(localException, MoPubNetworkError.Reason.UNSPECIFIED));
    }
  }

  protected void a(MultiAdResponse paramMultiAdResponse)
  {
    if (!isCanceled())
      this.mListener.onSuccessResponse(paramMultiAdResponse);
  }

  public void cancel()
  {
    super.cancel();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof MultiAdRequest))
        return false;
      MultiAdRequest localMultiAdRequest = (MultiAdRequest)paramObject;
      int i;
      if (this.b != null)
        if (localMultiAdRequest.b == null)
          i = 1;
      while ((i != 0) || (this.a != localMultiAdRequest.a) || (getUrl().compareTo(localMultiAdRequest.getUrl()) != 0))
      {
        return false;
        i = this.b.compareTo(localMultiAdRequest.b);
        continue;
        if (localMultiAdRequest.b != null)
          i = -1;
        else
          i = 0;
      }
    }
  }

  public int hashCode()
  {
    if (this.d == 0)
      if (this.b != null)
        break label49;
    label49: for (int i = 29; ; i = this.b.hashCode())
    {
      this.d = (31 * (i * 31 + this.a.hashCode()) + getOriginalUrl().hashCode());
      return this.d;
    }
  }

  public static abstract interface Listener extends Response.ErrorListener
  {
    public abstract void onSuccessResponse(MultiAdResponse paramMultiAdResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MultiAdRequest
 * JD-Core Version:    0.6.2
 */