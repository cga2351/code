package com.appnexus.opensdk;

import android.os.Handler;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public abstract class MediatedAdViewController
{
  protected MediaType a;
  protected p b;
  protected CSMSDKAdResponse c;
  protected c d;
  protected q e = new q(this);
  boolean f = false;
  boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  private WeakReference<UTAdRequester> j;
  private final Handler k = new a(this);
  private long l = -1L;
  private long m = -1L;

  MediatedAdViewController(UTAdRequester paramUTAdRequester, CSMSDKAdResponse paramCSMSDKAdResponse, c paramc, MediaType paramMediaType)
  {
    this.j = new WeakReference(paramUTAdRequester);
    this.c = paramCSMSDKAdResponse;
    this.d = paramc;
    this.a = paramMediaType;
    ResultCode localResultCode;
    if (paramCSMSDKAdResponse == null)
    {
      Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_no_ads));
      localResultCode = ResultCode.UNABLE_TO_FILL;
    }
    while (true)
    {
      if (localResultCode != null)
        onAdFailed(localResultCode);
      return;
      boolean bool = i();
      localResultCode = null;
      if (!bool)
        localResultCode = ResultCode.MEDIATED_SDK_UNAVAILABLE;
    }
  }

  private long a(UTAdRequester paramUTAdRequester)
  {
    if ((paramUTAdRequester != null) && (this.m > 0L))
      return paramUTAdRequester.getLatency(this.m);
    return -1L;
  }

  private void a(String paramString, ResultCode paramResultCode)
  {
    if ((paramString == null) || (StringUtil.isEmpty(paramString)))
    {
      Clog.w(Clog.mediationLogTag, Clog.getString(R.string.fire_responseurl_null));
      return;
    }
    new ResponseUrl.Builder(paramString, paramResultCode).latency(j()).totalLatency(a((UTAdRequester)this.j.get())).build().execute();
  }

  private void a(Throwable paramThrowable, String paramString)
  {
    Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediation_instantiation_failure, paramThrowable.getClass().getSimpleName()));
    if (!StringUtil.isEmpty(paramString))
    {
      Clog.w(Clog.mediationLogTag, String.format("Adding %s to invalid networks list", new Object[] { paramString }));
      Settings.getSettings().addInvalidNetwork(this.a, paramString);
    }
  }

  private boolean i()
  {
    Clog.d(Clog.mediationLogTag, Clog.getString(R.string.instantiating_class, this.c.getClassName()));
    try
    {
      String str1 = this.c.getClassName();
      String str2 = (String)Settings.getSettings().externalMediationClasses.get(str1);
      if (StringUtil.isEmpty(str2))
        this.b = ((p)Class.forName(str1).newInstance());
      else
        this.b = ((p)Class.forName(str2).getConstructor(new Class[] { String.class }).newInstance(new Object[] { str1 }));
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      a(localClassNotFoundException, this.c.getClassName());
      return false;
    }
    catch (LinkageError localLinkageError)
    {
      while (true)
        a(localLinkageError, this.c.getClassName());
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
        a(localInstantiationException, this.c.getClassName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        a(localIllegalAccessException, this.c.getClassName());
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        a(localClassCastException, this.c.getClassName());
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        a(localNoSuchMethodException, this.c.getClassName());
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        a(localInvocationTargetException, this.c.getClassName());
    }
    return true;
  }

  private long j()
  {
    if ((this.l > 0L) && (this.m > 0L))
      return this.m - this.l;
    return -1L;
  }

  protected TargetingParameters a()
  {
    UTAdRequester localUTAdRequester = (UTAdRequester)this.j.get();
    if ((localUTAdRequester != null) && (localUTAdRequester.getRequestParams() != null));
    for (TargetingParameters localTargetingParameters = localUTAdRequester.getRequestParams().getTargetingParameters(); ; localTargetingParameters = null)
    {
      if (localTargetingParameters == null)
        localTargetingParameters = new TargetingParameters();
      return localTargetingParameters;
    }
  }

  protected void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (paramBoolean)
      b();
  }

  boolean a(Class paramClass)
  {
    if (this.f)
      return false;
    if ((this.b == null) || (paramClass == null) || (!paramClass.isInstance(this.b)))
    {
      String str1 = Clog.mediationLogTag;
      int n = R.string.instance_exception;
      if (paramClass != null);
      for (String str2 = paramClass.getCanonicalName(); ; str2 = "null")
      {
        Clog.e(str1, Clog.getString(n, str2));
        onAdFailed(ResultCode.MEDIATED_SDK_UNAVAILABLE);
        return false;
      }
    }
    return true;
  }

  protected void b()
  {
    if (this.b != null)
      this.b.destroy();
    this.h = true;
    this.b = null;
    Clog.d(Clog.mediationLogTag, Clog.getString(R.string.mediation_finish));
  }

  abstract boolean c();

  abstract void d();

  void e()
  {
    if ((this.g) || (this.f))
      return;
    this.k.sendEmptyMessageDelayed(0, 15000L);
  }

  void f()
  {
    this.k.removeMessages(0);
  }

  protected void g()
  {
    this.l = System.currentTimeMillis();
  }

  protected void h()
  {
    this.m = System.currentTimeMillis();
  }

  public void onAdClicked()
  {
    if ((this.f) || (this.h));
    while (this.d == null)
      return;
    this.d.c();
  }

  public void onAdCollapsed()
  {
    if ((this.f) || (this.h));
    while (this.d == null)
      return;
    this.d.b();
  }

  public void onAdExpanded()
  {
    if ((this.f) || (this.h));
    while (this.d == null)
      return;
    this.d.a();
  }

  public void onAdFailed(ResultCode paramResultCode)
  {
    if ((this.g) || (this.f) || (this.h));
    UTAdRequester localUTAdRequester;
    do
    {
      return;
      h();
      f();
      if ((this.c != null) && (this.c.getResponseUrl() != null))
        a(this.c.getResponseUrl(), paramResultCode);
      this.f = true;
      b();
      localUTAdRequester = (UTAdRequester)this.j.get();
    }
    while (localUTAdRequester == null);
    localUTAdRequester.continueWaterfall(paramResultCode);
  }

  public void onAdLoaded()
  {
    if ((this.g) || (this.f) || (this.h))
      return;
    h();
    f();
    this.g = true;
    a(this.c.getResponseUrl(), ResultCode.SUCCESS);
    UTAdRequester localUTAdRequester = (UTAdRequester)this.j.get();
    if (localUTAdRequester != null)
    {
      localUTAdRequester.onReceiveAd(new AdResponse()
      {
        public void destroy()
        {
          MediatedAdViewController.this.e.destroy();
        }

        public i getDisplayable()
        {
          return MediatedAdViewController.this.e;
        }

        public MediaType getMediaType()
        {
          return MediatedAdViewController.this.a;
        }

        public NativeAdResponse getNativeAdResponse()
        {
          return null;
        }

        public BaseAdResponse getResponseData()
        {
          return MediatedAdViewController.this.c;
        }

        public boolean isMediated()
        {
          return true;
        }
      });
      return;
    }
    this.e.destroy();
  }

  public abstract void onDestroy();

  public abstract void onPause();

  public abstract void onResume();

  static class a extends Handler
  {
    WeakReference<MediatedAdViewController> a;

    public a(MediatedAdViewController paramMediatedAdViewController)
    {
      this.a = new WeakReference(paramMediatedAdViewController);
    }

    // ERROR //
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/appnexus/opensdk/MediatedAdViewController$a:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 27	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 29	com/appnexus/opensdk/MediatedAdViewController
      //   10: astore_2
      //   11: aload_2
      //   12: ifnull +10 -> 22
      //   15: aload_2
      //   16: getfield 33	com/appnexus/opensdk/MediatedAdViewController:f	Z
      //   19: ifeq +4 -> 23
      //   22: return
      //   23: getstatic 39	com/appnexus/opensdk/utils/Clog:mediationLogTag	Ljava/lang/String;
      //   26: getstatic 45	com/appnexus/opensdk/R$string:mediation_timeout	I
      //   29: invokestatic 49	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
      //   32: invokestatic 53	com/appnexus/opensdk/utils/Clog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   35: aload_2
      //   36: getstatic 59	com/appnexus/opensdk/ResultCode:INTERNAL_ERROR	Lcom/appnexus/opensdk/ResultCode;
      //   39: invokevirtual 63	com/appnexus/opensdk/MediatedAdViewController:onAdFailed	(Lcom/appnexus/opensdk/ResultCode;)V
      //   42: aload_2
      //   43: aconst_null
      //   44: putfield 67	com/appnexus/opensdk/MediatedAdViewController:d	Lcom/appnexus/opensdk/c;
      //   47: aload_2
      //   48: aconst_null
      //   49: putfield 71	com/appnexus/opensdk/MediatedAdViewController:b	Lcom/appnexus/opensdk/p;
      //   52: aload_2
      //   53: aconst_null
      //   54: putfield 75	com/appnexus/opensdk/MediatedAdViewController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   57: return
      //   58: astore 4
      //   60: aload_2
      //   61: aconst_null
      //   62: putfield 67	com/appnexus/opensdk/MediatedAdViewController:d	Lcom/appnexus/opensdk/c;
      //   65: aload_2
      //   66: aconst_null
      //   67: putfield 71	com/appnexus/opensdk/MediatedAdViewController:b	Lcom/appnexus/opensdk/p;
      //   70: aload_2
      //   71: aconst_null
      //   72: putfield 75	com/appnexus/opensdk/MediatedAdViewController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   75: return
      //   76: astore_3
      //   77: aload_2
      //   78: aconst_null
      //   79: putfield 67	com/appnexus/opensdk/MediatedAdViewController:d	Lcom/appnexus/opensdk/c;
      //   82: aload_2
      //   83: aconst_null
      //   84: putfield 71	com/appnexus/opensdk/MediatedAdViewController:b	Lcom/appnexus/opensdk/p;
      //   87: aload_2
      //   88: aconst_null
      //   89: putfield 75	com/appnexus/opensdk/MediatedAdViewController:c	Lcom/appnexus/opensdk/ut/adresponse/CSMSDKAdResponse;
      //   92: aload_3
      //   93: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   35	42	58	java/lang/IllegalArgumentException
      //   35	42	76	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MediatedAdViewController
 * JD-Core Version:    0.6.2
 */