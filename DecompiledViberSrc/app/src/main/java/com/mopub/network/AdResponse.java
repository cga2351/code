package com.mopub.network;

import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse
  implements Serializable
{
  private final String A;
  private final MoPub.BrowserAgent B;
  private final Map<String, String> C;
  private final long D;
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final Integer i;
  private final boolean j;
  private final ImpressionData k;
  private final String l;
  private final List<String> m;
  private final String n;
  private final String o;
  private final List<String> p;
  private final List<String> q;
  private final List<String> r;
  private final String s;
  private final Integer t;
  private final Integer u;
  private final Integer v;
  private final Integer w;
  private final String x;
  private final String y;
  private final JSONObject z;

  private AdResponse(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
    this.f = Builder.f(paramBuilder);
    this.g = Builder.g(paramBuilder);
    this.h = Builder.h(paramBuilder);
    this.i = Builder.i(paramBuilder);
    this.j = Builder.j(paramBuilder);
    this.k = Builder.k(paramBuilder);
    this.l = Builder.l(paramBuilder);
    this.m = Builder.m(paramBuilder);
    this.n = Builder.n(paramBuilder);
    this.o = Builder.o(paramBuilder);
    this.p = Builder.p(paramBuilder);
    this.q = Builder.q(paramBuilder);
    this.r = Builder.r(paramBuilder);
    this.s = Builder.s(paramBuilder);
    this.t = Builder.t(paramBuilder);
    this.u = Builder.u(paramBuilder);
    this.v = Builder.v(paramBuilder);
    this.w = Builder.w(paramBuilder);
    this.x = Builder.x(paramBuilder);
    this.y = Builder.y(paramBuilder);
    this.z = Builder.z(paramBuilder);
    this.A = Builder.A(paramBuilder);
    this.B = Builder.B(paramBuilder);
    this.C = Builder.C(paramBuilder);
    this.D = DateAndTime.now().getTime();
  }

  public Integer getAdTimeoutMillis(int paramInt)
  {
    if ((this.v == null) || (this.v.intValue() < 1000))
      return Integer.valueOf(paramInt);
    return this.v;
  }

  public String getAdType()
  {
    return this.a;
  }

  public String getAdUnitId()
  {
    return this.b;
  }

  public List<String> getAfterLoadFailUrls()
  {
    return this.r;
  }

  public List<String> getAfterLoadSuccessUrls()
  {
    return this.q;
  }

  public List<String> getAfterLoadUrls()
  {
    return this.p;
  }

  public String getBeforeLoadUrl()
  {
    return this.o;
  }

  public MoPub.BrowserAgent getBrowserAgent()
  {
    return this.B;
  }

  public String getClickTrackingUrl()
  {
    return this.l;
  }

  public String getCustomEventClassName()
  {
    return this.A;
  }

  public String getDspCreativeId()
  {
    return this.x;
  }

  @Deprecated
  public String getFailoverUrl()
  {
    return this.n;
  }

  public String getFullAdType()
  {
    return this.c;
  }

  public Integer getHeight()
  {
    return this.u;
  }

  public ImpressionData getImpressionData()
  {
    return this.k;
  }

  public List<String> getImpressionTrackingUrls()
  {
    return this.m;
  }

  public JSONObject getJsonBody()
  {
    return this.z;
  }

  public String getNetworkType()
  {
    return this.d;
  }

  public Integer getRefreshTimeMillis()
  {
    return this.w;
  }

  public String getRequestId()
  {
    return this.s;
  }

  public String getRewardedCurrencies()
  {
    return this.g;
  }

  public Integer getRewardedDuration()
  {
    return this.i;
  }

  public String getRewardedVideoCompletionUrl()
  {
    return this.h;
  }

  public String getRewardedVideoCurrencyAmount()
  {
    return this.f;
  }

  public String getRewardedVideoCurrencyName()
  {
    return this.e;
  }

  public Map<String, String> getServerExtras()
  {
    return new TreeMap(this.C);
  }

  public String getStringBody()
  {
    return this.y;
  }

  public long getTimestamp()
  {
    return this.D;
  }

  public Integer getWidth()
  {
    return this.t;
  }

  public boolean hasJson()
  {
    return this.z != null;
  }

  public boolean shouldRewardOnClick()
  {
    return this.j;
  }

  public Builder toBuilder()
  {
    return new Builder().setAdType(this.a).setNetworkType(this.d).setRewardedVideoCurrencyName(this.e).setRewardedVideoCurrencyAmount(this.f).setRewardedCurrencies(this.g).setRewardedVideoCompletionUrl(this.h).setRewardedDuration(this.i).setShouldRewardOnClick(this.j).setImpressionData(this.k).setClickTrackingUrl(this.l).setImpressionTrackingUrls(this.m).setFailoverUrl(this.n).setBeforeLoadUrl(this.o).setAfterLoadUrls(this.p).setAfterLoadSuccessUrls(this.q).setAfterLoadFailUrls(this.r).setDimensions(this.t, this.u).setAdTimeoutDelayMilliseconds(this.v).setRefreshTimeMilliseconds(this.w).setDspCreativeId(this.x).setResponseBody(this.y).setJsonBody(this.z).setCustomEventClassName(this.A).setBrowserAgent(this.B).setServerExtras(this.C);
  }

  public static class Builder
  {
    private String A;
    private MoPub.BrowserAgent B;
    private Map<String, String> C = new TreeMap();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Integer i;
    private boolean j;
    private ImpressionData k;
    private String l;
    private List<String> m = new ArrayList();
    private String n;
    private String o;
    private List<String> p = new ArrayList();
    private List<String> q = new ArrayList();
    private List<String> r = new ArrayList();
    private String s;
    private Integer t;
    private Integer u;
    private Integer v;
    private Integer w;
    private String x;
    private String y;
    private JSONObject z;

    public AdResponse build()
    {
      return new AdResponse(this, null);
    }

    public Builder setAdTimeoutDelayMilliseconds(Integer paramInteger)
    {
      this.v = paramInteger;
      return this;
    }

    public Builder setAdType(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public Builder setAdUnitId(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public Builder setAfterLoadFailUrls(List<String> paramList)
    {
      Preconditions.checkNotNull(paramList);
      this.r = paramList;
      return this;
    }

    public Builder setAfterLoadSuccessUrls(List<String> paramList)
    {
      Preconditions.checkNotNull(paramList);
      this.q = paramList;
      return this;
    }

    public Builder setAfterLoadUrls(List<String> paramList)
    {
      Preconditions.checkNotNull(paramList);
      this.p = paramList;
      return this;
    }

    public Builder setBeforeLoadUrl(String paramString)
    {
      this.o = paramString;
      return this;
    }

    public Builder setBrowserAgent(MoPub.BrowserAgent paramBrowserAgent)
    {
      this.B = paramBrowserAgent;
      return this;
    }

    public Builder setClickTrackingUrl(String paramString)
    {
      this.l = paramString;
      return this;
    }

    public Builder setCustomEventClassName(String paramString)
    {
      this.A = paramString;
      return this;
    }

    public Builder setDimensions(Integer paramInteger1, Integer paramInteger2)
    {
      this.t = paramInteger1;
      this.u = paramInteger2;
      return this;
    }

    public Builder setDspCreativeId(String paramString)
    {
      this.x = paramString;
      return this;
    }

    public Builder setFailoverUrl(String paramString)
    {
      this.n = paramString;
      return this;
    }

    public Builder setFullAdType(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public Builder setImpressionData(ImpressionData paramImpressionData)
    {
      this.k = paramImpressionData;
      return this;
    }

    public Builder setImpressionTrackingUrls(List<String> paramList)
    {
      Preconditions.checkNotNull(paramList);
      this.m = paramList;
      return this;
    }

    public Builder setJsonBody(JSONObject paramJSONObject)
    {
      this.z = paramJSONObject;
      return this;
    }

    public Builder setNetworkType(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public Builder setRefreshTimeMilliseconds(Integer paramInteger)
    {
      this.w = paramInteger;
      return this;
    }

    public Builder setRequestId(String paramString)
    {
      this.s = paramString;
      return this;
    }

    public Builder setResponseBody(String paramString)
    {
      this.y = paramString;
      return this;
    }

    public Builder setRewardedCurrencies(String paramString)
    {
      this.g = paramString;
      return this;
    }

    public Builder setRewardedDuration(Integer paramInteger)
    {
      this.i = paramInteger;
      return this;
    }

    public Builder setRewardedVideoCompletionUrl(String paramString)
    {
      this.h = paramString;
      return this;
    }

    public Builder setRewardedVideoCurrencyAmount(String paramString)
    {
      this.f = paramString;
      return this;
    }

    public Builder setRewardedVideoCurrencyName(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public Builder setServerExtras(Map<String, String> paramMap)
    {
      if (paramMap == null)
      {
        this.C = new TreeMap();
        return this;
      }
      this.C = new TreeMap(paramMap);
      return this;
    }

    public Builder setShouldRewardOnClick(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.AdResponse
 * JD-Core Version:    0.6.2
 */