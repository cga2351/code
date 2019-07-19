package com.appnexus.opensdk;

import android.content.Context;
import android.os.Handler;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MediatedNativeAdController
{
  UTAdRequester a;
  WeakReference<Context> b;
  CSMSDKAdResponse c;
  boolean d = false;
  boolean e = false;
  ResultCode f;
  private boolean g = false;
  private final Handler h = new a(this);
  private long i = -1L;
  private long j = -1L;

  private MediatedNativeAdController(CSMSDKAdResponse paramCSMSDKAdResponse, UTAdRequester paramUTAdRequester)
  {
    if (paramCSMSDKAdResponse == null)
    {
      Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_no_ads));
      this.f = ResultCode.UNABLE_TO_FILL;
    }
    while (true)
    {
      if (this.f != null)
        onAdFailed(this.f);
      return;
      Clog.d(Clog.mediationLogTag, Clog.getString(R.string.instantiating_class, paramCSMSDKAdResponse.getClassName()));
      this.a = paramUTAdRequester;
      this.c = paramCSMSDKAdResponse;
      this.b = new WeakReference(paramUTAdRequester.getRequestParams().getContext());
      a();
      c();
      try
      {
        str = (String)Settings.getSettings().externalMediationClasses.get(paramCSMSDKAdResponse.getClassName());
        if (StringUtil.isEmpty(str))
        {
          localClass = Class.forName(paramCSMSDKAdResponse.getClassName());
          MediatedNativeAd localMediatedNativeAd = (MediatedNativeAd)localClass.newInstance();
          if (paramUTAdRequester.getRequestParams() == null)
            break label254;
          localMediatedNativeAd.requestNativeAd(paramUTAdRequester.getRequestParams().getContext(), paramCSMSDKAdResponse.getParam(), paramCSMSDKAdResponse.getId(), this, paramUTAdRequester.getRequestParams().getTargetingParameters());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
        {
          String str;
          a(localClassNotFoundException, paramCSMSDKAdResponse.getClassName());
          break;
          Class localClass = Class.forName(str);
        }
        this.f = ResultCode.INVALID_REQUEST;
      }
      catch (ClassCastException localClassCastException)
      {
        a(localClassCastException, paramCSMSDKAdResponse.getClassName());
      }
      catch (LinkageError localLinkageError)
      {
        a(localLinkageError, paramCSMSDKAdResponse.getClassName());
      }
      catch (InstantiationException localInstantiationException)
      {
        a(localInstantiationException, paramCSMSDKAdResponse.getClassName());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        a(localIllegalAccessException, paramCSMSDKAdResponse.getClassName());
      }
      catch (Exception localException)
      {
        Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_request_exception), localException);
        this.f = ResultCode.INTERNAL_ERROR;
      }
      catch (Error localError)
      {
        label254: Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_request_error), localError);
        this.f = ResultCode.INTERNAL_ERROR;
      }
    }
  }

  private long a(UTAdRequester paramUTAdRequester)
  {
    if ((paramUTAdRequester != null) && (this.j > 0L))
      return paramUTAdRequester.getLatency(this.j);
    return -1L;
  }

  private void a(String paramString, ResultCode paramResultCode)
  {
    UTAdRequester localUTAdRequester = this.a;
    if ((paramString == null) || (StringUtil.isEmpty(paramString)))
    {
      Clog.w(Clog.mediationLogTag, Clog.getString(R.string.fire_responseurl_null));
      return;
    }
    new ResponseUrl.Builder(paramString, paramResultCode).latency(f()).totalLatency(a(localUTAdRequester)).build().execute();
  }

  private void a(Throwable paramThrowable, String paramString)
  {
    Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediation_instantiation_failure, paramThrowable.getClass().getSimpleName()));
    if (!StringUtil.isEmpty(paramString))
    {
      Clog.w(Clog.mediationLogTag, String.format("Adding %s to invalid networks list", new Object[] { paramString }));
      Settings.getSettings().addInvalidNetwork(MediaType.NATIVE, paramString);
    }
    this.f = ResultCode.MEDIATED_SDK_UNAVAILABLE;
  }

  public static MediatedNativeAdController create(CSMSDKAdResponse paramCSMSDKAdResponse, UTAdRequester paramUTAdRequester)
  {
    return new MediatedNativeAdController(paramCSMSDKAdResponse, paramUTAdRequester);
  }

  private long f()
  {
    if ((this.i > 0L) && (this.j > 0L))
      return this.j - this.i;
    return -1L;
  }

  void a()
  {
    if ((this.d) || (this.e))
      return;
    this.h.sendEmptyMessageDelayed(0, 15000L);
  }

  void a(final String paramString)
  {
    new HTTPGet()
    {
      protected String a()
      {
        return paramString;
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()))
          Clog.d(Clog.baseLogTag, "Mediated Native Impression Tracked successfully");
      }
    }
    .execute(new Void[0]);
  }

  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  void b()
  {
    this.h.removeMessages(0);
  }

  protected void c()
  {
    this.i = System.currentTimeMillis();
  }

  protected void d()
  {
    this.j = System.currentTimeMillis();
  }

  void e()
  {
    ArrayList localArrayList = this.c.getImpressionURLs();
    if (localArrayList != null)
    {
      try
      {
        Context localContext = (Context)this.b.get();
        if ((localContext != null) && (!SharedNetworkManager.getInstance(localContext).isConnected(localContext)) && (localArrayList.size() > 0))
        {
          SharedNetworkManager localSharedNetworkManager = SharedNetworkManager.getInstance(localContext);
          Iterator localIterator2 = localArrayList.iterator();
          while (localIterator2.hasNext())
            localSharedNetworkManager.a((String)localIterator2.next(), localContext);
        }
      }
      finally
      {
      }
      if (localArrayList.size() > 0)
      {
        Iterator localIterator1 = localArrayList.iterator();
        while (localIterator1.hasNext())
          a((String)localIterator1.next());
      }
      this.c.setImpressionURLs(null);
    }
  }

  public void onAdFailed(ResultCode paramResultCode)
  {
    if ((this.d) || (this.e));
    UTAdRequester localUTAdRequester;
    do
    {
      return;
      d();
      b();
      a(this.c.getResponseUrl(), paramResultCode);
      this.e = true;
      localUTAdRequester = this.a;
    }
    while (localUTAdRequester == null);
    localUTAdRequester.continueWaterfall(paramResultCode);
  }

  public void onAdImpression()
  {
    e();
  }

  public void onAdLoaded(final NativeAdResponse paramNativeAdResponse)
  {
    if ((this.d) || (this.e))
      return;
    d();
    b();
    this.d = true;
    a(this.c.getResponseUrl(), ResultCode.SUCCESS);
    UTAdRequester localUTAdRequester = this.a;
    if (localUTAdRequester != null)
    {
      localUTAdRequester.onReceiveAd(new AdResponse()
      {
        public void destroy()
        {
          paramNativeAdResponse.destroy();
        }

        public i getDisplayable()
        {
          return null;
        }

        public MediaType getMediaType()
        {
          return MediaType.NATIVE;
        }

        public NativeAdResponse getNativeAdResponse()
        {
          return paramNativeAdResponse;
        }

        public BaseAdResponse getResponseData()
        {
          return MediatedNativeAdController.this.c;
        }

        public boolean isMediated()
        {
          return true;
        }
      });
      return;
    }
    Clog.d(Clog.mediationLogTag, "Request was cancelled, destroy mediated ad response");
    paramNativeAdResponse.destroy();
  }

  static class a extends Handler
  {
    WeakReference<MediatedNativeAdController> a;

    public a(MediatedNativeAdController paramMediatedNativeAdController)
    {
      this.a = new WeakReference(paramMediatedNativeAdController);
    }

    // ERROR //
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/appnexus/opensdk/MediatedNativeAdController$a:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 27	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 29	com/appnexus/opensdk/MediatedNativeAdController
      //   10: astore_2
      //   11: aload_2
      //   12: ifnull +10 -> 22
      //   15: aload_2
      //   16: getfield 33	com/appnexus/opensdk/MediatedNativeAdController:e	Z
      //   19: ifeq +4 -> 23
      //   22: return
      //   23: getstatic 39	com/appnexus/opensdk/utils/Clog:mediationLogTag	Ljava/lang/String;
      //   26: getstatic 45	com/appnexus/opensdk/R$string:mediation_timeout	I
      //   29: invokestatic 49	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
      //   32: invokestatic 53	com/appnexus/opensdk/utils/Clog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   35: aload_2
      //   36: getstatic 59	com/appnexus/opensdk/ResultCode:INTERNAL_ERROR	Lcom/appnexus/opensdk/ResultCode;
      //   39: invokevirtual 63	com/appnexus/opensdk/MediatedNativeAdController:onAdFailed	(Lcom/appnexus/opensdk/ResultCode;)V
      //   42: aload_2
      //   43: aconst_null
      //   44: putfield 67	com/appnexus/opensdk/MediatedNativeAdController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   47: return
      //   48: astore 4
      //   50: aload_2
      //   51: aconst_null
      //   52: putfield 67	com/appnexus/opensdk/MediatedNativeAdController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   55: return
      //   56: astore_3
      //   57: aload_2
      //   58: aconst_null
      //   59: putfield 67	com/appnexus/opensdk/MediatedNativeAdController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   62: aload_3
      //   63: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   35	42	48	java/lang/IllegalArgumentException
      //   35	42	56	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MediatedNativeAdController
 * JD-Core Version:    0.6.2
 */