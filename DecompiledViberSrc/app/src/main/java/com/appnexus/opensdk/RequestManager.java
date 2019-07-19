package com.appnexus.opensdk;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.appnexus.opensdk.ut.UTAdRequest;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.UTAdResponse;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.Settings;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

public abstract class RequestManager
  implements UTAdRequester
{
  UTAdRequest a;
  String b;
  private LinkedList<BaseAdResponse> c;
  private long d;
  private ArrayList<String> e = new ArrayList();

  protected void a()
  {
    if (this.e.isEmpty())
      return;
    StringBuilder localStringBuilder = new StringBuilder("Mediated Classes: \n");
    for (int i = this.e.size(); i > 0; i--)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = this.e.get(i - 1);
      localStringBuilder.append(String.format("%d: %s\n", arrayOfObject));
    }
    Clog.i(Clog.mediationLogTag, localStringBuilder.toString());
    this.e.clear();
  }

  protected void a(final String paramString1, final String paramString2)
  {
    if ((paramString1 == null) || (paramString1 == ""))
      return;
    new HTTPGet()
    {
      protected String a()
      {
        return paramString1;
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()));
        try
        {
          Clog.i(Clog.baseLogTag, paramString2.concat(Clog.getString(R.string.fire_tracker_succesfully_message)));
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
    .execute(new Void[0]);
  }

  protected void a(LinkedList<BaseAdResponse> paramLinkedList)
  {
    this.c = paramLinkedList;
  }

  protected BaseAdResponse b()
  {
    if ((this.c != null) && (this.c.getFirst() != null))
    {
      if ((((BaseAdResponse)this.c.getFirst()).getContentSource() != null) && (((BaseAdResponse)this.c.getFirst()).getContentSource().equalsIgnoreCase("csm")))
      {
        CSMSDKAdResponse localCSMSDKAdResponse = (CSMSDKAdResponse)this.c.getFirst();
        this.e.add(localCSMSDKAdResponse.getClassName());
      }
      return (BaseAdResponse)this.c.removeFirst();
    }
    return null;
  }

  public abstract void cancel();

  public abstract void continueWaterfall(ResultCode paramResultCode);

  public void execute()
  {
    this.a = new UTAdRequest(this);
    markLatencyStart();
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      this.a.execute(new Void[0]);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Clog.e(Clog.baseLogTag, "Concurrent Thread Exception while firing new ad request: " + localRejectedExecutionException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      Clog.e(Clog.baseLogTag, "Exception while firing new ad request: " + localException.getMessage());
    }
  }

  public abstract void failed(ResultCode paramResultCode);

  public LinkedList<BaseAdResponse> getAdList()
  {
    return this.c;
  }

  public long getLatency(long paramLong)
  {
    return System.currentTimeMillis() - this.d;
  }

  public abstract UTRequestParameters getRequestParams();

  public boolean isHttpsEnabled()
  {
    Settings.getSettings();
    return Settings.isHttpsEnabled();
  }

  public void markLatencyStart()
  {
    this.d = System.currentTimeMillis();
  }

  public abstract void onReceiveAd(AdResponse paramAdResponse);

  public void onReceiveUTResponse(UTAdResponse paramUTAdResponse)
  {
    if (paramUTAdResponse != null)
      this.b = paramUTAdResponse.getNoAdUrl();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.RequestManager
 * JD-Core Version:    0.6.2
 */