package com.appnexus.opensdk;

import android.os.Handler;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.adresponse.SSMHTMLAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.StringUtil;
import java.lang.ref.WeakReference;

public class MediatedSSMAdViewController
{
  protected SSMHTMLAdResponse a;
  protected c b;
  protected AdView c;
  boolean d = false;
  boolean e = false;
  private WeakReference<UTAdRequester> f;
  private final Handler g = new a(this);
  private long h = -1L;
  private long i = -1L;

  private MediatedSSMAdViewController(AdView paramAdView, UTAdRequester paramUTAdRequester, SSMHTMLAdResponse paramSSMHTMLAdResponse)
  {
    this.f = new WeakReference(paramUTAdRequester);
    this.a = paramSSMHTMLAdResponse;
    this.b = paramAdView.getAdDispatcher();
    this.c = paramAdView;
    if ((this.a == null) || (!"banner".equalsIgnoreCase(this.a.getAdType())))
    {
      Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_no_ads));
      onAdFailed(ResultCode.UNABLE_TO_FILL);
      return;
    }
    a();
    c();
    e();
  }

  private long a(UTAdRequester paramUTAdRequester)
  {
    if ((paramUTAdRequester != null) && (this.i > 0L))
      return paramUTAdRequester.getLatency(this.i);
    return -1L;
  }

  static MediatedSSMAdViewController a(AdView paramAdView, UTAdRequester paramUTAdRequester, SSMHTMLAdResponse paramSSMHTMLAdResponse)
  {
    MediatedSSMAdViewController localMediatedSSMAdViewController = new MediatedSSMAdViewController(paramAdView, paramUTAdRequester, paramSSMHTMLAdResponse);
    if (localMediatedSSMAdViewController.d)
      localMediatedSSMAdViewController = null;
    return localMediatedSSMAdViewController;
  }

  private void a(SSMHTMLAdResponse paramSSMHTMLAdResponse, ResultCode paramResultCode)
  {
    if ((paramSSMHTMLAdResponse == null) || (paramSSMHTMLAdResponse.getResponseURL() == null) || (StringUtil.isEmpty(paramSSMHTMLAdResponse.getResponseURL())))
    {
      Clog.w(Clog.mediationLogTag, Clog.getString(R.string.fire_responseurl_null));
      return;
    }
    new ResponseUrl.Builder(paramSSMHTMLAdResponse.getResponseURL(), paramResultCode).latency(g()).totalLatency(a((UTAdRequester)this.f.get())).build().execute();
  }

  private void e()
  {
    new HTTPGet()
    {
      protected HTTPResponse a(Void[] paramAnonymousArrayOfVoid)
      {
        return super.a(paramAnonymousArrayOfVoid);
      }

      protected String a()
      {
        return MediatedSSMAdViewController.this.a.getAdUrl();
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        MediatedSSMAdViewController.this.d();
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()))
        {
          MediatedSSMAdViewController.this.a.setAdContent(paramAnonymousHTTPResponse.getResponseBody());
          if (!StringUtil.isEmpty(MediatedSSMAdViewController.this.a.getAdContent()))
          {
            MediatedSSMAdViewController.a(MediatedSSMAdViewController.this);
            return;
          }
          MediatedSSMAdViewController.this.onAdFailed(ResultCode.UNABLE_TO_FILL);
          return;
        }
        MediatedSSMAdViewController.this.onAdFailed(ResultCode.UNABLE_TO_FILL);
      }
    }
    .execute(new Void[0]);
  }

  private void f()
  {
    if ((this.e) || (this.d));
    UTAdRequester localUTAdRequester;
    do
    {
      return;
      b();
      this.e = true;
      a(this.a, ResultCode.SUCCESS);
      localUTAdRequester = (UTAdRequester)this.f.get();
    }
    while (localUTAdRequester == null);
    new f(this.c, localUTAdRequester).a(this.a);
  }

  private long g()
  {
    if ((this.h > 0L) && (this.i > 0L))
      return this.i - this.h;
    return -1L;
  }

  void a()
  {
    if ((this.e) || (this.d))
      return;
    this.g.sendEmptyMessageDelayed(0, 15000L);
  }

  void b()
  {
    this.g.removeMessages(0);
  }

  protected void c()
  {
    this.h = System.currentTimeMillis();
  }

  protected void d()
  {
    this.i = System.currentTimeMillis();
  }

  public void onAdFailed(ResultCode paramResultCode)
  {
    if ((this.e) || (this.d));
    UTAdRequester localUTAdRequester;
    do
    {
      return;
      d();
      b();
      this.d = true;
      a(this.a, paramResultCode);
      localUTAdRequester = (UTAdRequester)this.f.get();
    }
    while (localUTAdRequester == null);
    localUTAdRequester.continueWaterfall(paramResultCode);
  }

  static class a extends Handler
  {
    WeakReference<MediatedSSMAdViewController> a;

    public a(MediatedSSMAdViewController paramMediatedSSMAdViewController)
    {
      this.a = new WeakReference(paramMediatedSSMAdViewController);
    }

    // ERROR //
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/appnexus/opensdk/MediatedSSMAdViewController$a:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 27	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 29	com/appnexus/opensdk/MediatedSSMAdViewController
      //   10: astore_2
      //   11: aload_2
      //   12: ifnull +10 -> 22
      //   15: aload_2
      //   16: getfield 33	com/appnexus/opensdk/MediatedSSMAdViewController:d	Z
      //   19: ifeq +4 -> 23
      //   22: return
      //   23: getstatic 39	com/appnexus/opensdk/utils/Clog:mediationLogTag	Ljava/lang/String;
      //   26: getstatic 45	com/appnexus/opensdk/R$string:mediation_timeout	I
      //   29: invokestatic 49	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
      //   32: invokestatic 53	com/appnexus/opensdk/utils/Clog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   35: aload_2
      //   36: getstatic 59	com/appnexus/opensdk/ResultCode:INTERNAL_ERROR	Lcom/appnexus/opensdk/ResultCode;
      //   39: invokevirtual 63	com/appnexus/opensdk/MediatedSSMAdViewController:onAdFailed	(Lcom/appnexus/opensdk/ResultCode;)V
      //   42: aload_2
      //   43: aconst_null
      //   44: putfield 67	com/appnexus/opensdk/MediatedSSMAdViewController:b	Lcom/appnexus/opensdk/c;
      //   47: return
      //   48: astore 4
      //   50: aload_2
      //   51: aconst_null
      //   52: putfield 67	com/appnexus/opensdk/MediatedSSMAdViewController:b	Lcom/appnexus/opensdk/c;
      //   55: return
      //   56: astore_3
      //   57: aload_2
      //   58: aconst_null
      //   59: putfield 67	com/appnexus/opensdk/MediatedSSMAdViewController:b	Lcom/appnexus/opensdk/c;
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
 * Qualified Name:     com.appnexus.opensdk.MediatedSSMAdViewController
 * JD-Core Version:    0.6.2
 */