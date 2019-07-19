package com.appnexus.opensdk;

import android.net.Uri;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.StringUtil;

public final class ResponseUrl
{
  private final String a;
  private final ResultCode b;
  private final long c;
  private final long d;

  private ResponseUrl(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
  }

  public void execute()
  {
    if ((this.a == null) || (StringUtil.isEmpty(this.a)))
    {
      Clog.w(Clog.mediationLogTag, Clog.getString(R.string.fire_responseurl_null));
      return;
    }
    new HTTPGet()
    {
      protected HTTPResponse a(Void[] paramAnonymousArrayOfVoid)
      {
        return super.a(paramAnonymousArrayOfVoid);
      }

      protected String a()
      {
        StringBuilder localStringBuilder = new StringBuilder(ResponseUrl.a(ResponseUrl.this));
        localStringBuilder.append("&reason=").append(ResponseUrl.b(ResponseUrl.this).ordinal());
        if (ResponseUrl.c(ResponseUrl.this) > 0L)
          localStringBuilder.append("&latency=").append(Uri.encode(String.valueOf(ResponseUrl.c(ResponseUrl.this))));
        if (ResponseUrl.d(ResponseUrl.this) > 0L)
          localStringBuilder.append("&total_latency=").append(Uri.encode(String.valueOf(ResponseUrl.d(ResponseUrl.this))));
        return localStringBuilder.toString();
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()))
          Clog.i(Clog.mediationLogTag, "ResponseURL Fired Successfully");
      }
    }
    .execute(new Void[0]);
  }

  public static class Builder
  {
    private final String a;
    private final ResultCode b;
    private long c;
    private long d;

    public Builder(String paramString, ResultCode paramResultCode)
    {
      this.a = paramString;
      this.b = paramResultCode;
    }

    public ResponseUrl build()
    {
      return new ResponseUrl(this, null);
    }

    public Builder latency(long paramLong)
    {
      this.c = paramLong;
      return this;
    }

    public Builder totalLatency(long paramLong)
    {
      this.d = paramLong;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ResponseUrl
 * JD-Core Version:    0.6.2
 */