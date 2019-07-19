package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor a;

  public ExecutorDelivery(final Handler paramHandler)
  {
    this.a = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }

  public ExecutorDelivery(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }

  public void postError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.addMarker("post-error");
    Response localResponse = Response.error(paramVolleyError);
    this.a.execute(new a(paramRequest, localResponse, null));
  }

  public void postResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }

  public void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.markDelivered();
    paramRequest.addMarker("post-response");
    this.a.execute(new a(paramRequest, paramResponse, paramRunnable));
  }

  private static class a
    implements Runnable
  {
    private final Request a;
    private final Response b;
    private final Runnable c;

    public a(Request paramRequest, Response paramResponse, Runnable paramRunnable)
    {
      this.a = paramRequest;
      this.b = paramResponse;
      this.c = paramRunnable;
    }

    public void run()
    {
      if (this.a.isCanceled())
        this.a.b("canceled-at-delivery");
      label97: label107: 
      while (true)
      {
        return;
        if (this.b.isSuccess())
        {
          this.a.deliverResponse(this.b.result);
          if (!this.b.intermediate)
            break label97;
          this.a.addMarker("intermediate-response");
        }
        while (true)
        {
          if (this.c == null)
            break label107;
          this.c.run();
          return;
          this.a.deliverError(this.b.error);
          break;
          this.a.b("done");
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.ExecutorDelivery
 * JD-Core Version:    0.6.2
 */