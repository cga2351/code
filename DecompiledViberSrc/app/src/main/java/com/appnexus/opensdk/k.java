package com.appnexus.opensdk;

import android.content.Context;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;

class k extends HTTPGet
{
  private String a;
  private v b;
  private boolean c = false;
  private Context d;
  private a e;

  private k(String paramString, v paramv, Context paramContext)
  {
    this.a = paramString;
    this.b = paramv;
    this.e = new a();
    this.d = paramContext;
  }

  static k a(String paramString, v paramv, Context paramContext)
  {
    if (paramv == null)
      return null;
    k localk = new k(paramString, paramv, paramContext);
    paramv.a(localk.e);
    return localk;
  }

  private void b()
  {
    try
    {
      SharedNetworkManager localSharedNetworkManager;
      if (!this.c)
      {
        localSharedNetworkManager = SharedNetworkManager.getInstance(this.d);
        if (!localSharedNetworkManager.isConnected(this.d))
          break label62;
        execute(new Void[0]);
        this.b.b(this.e);
        this.e = null;
      }
      while (true)
      {
        this.c = true;
        return;
        label62: localSharedNetworkManager.a(this.a, this.d);
      }
    }
    finally
    {
    }
  }

  protected String a()
  {
    return this.a;
  }

  protected void a(HTTPResponse paramHTTPResponse)
  {
    Clog.d(Clog.nativeLogTag, "Impression tracked.");
  }

  class a
    implements v.a
  {
    long a = 0L;

    a()
    {
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean);
      for (this.a = (250L + this.a); ; this.a = 0L)
      {
        if (this.a >= 1000L)
          k.a(k.this);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.k
 * JD-Core Version:    0.6.2
 */