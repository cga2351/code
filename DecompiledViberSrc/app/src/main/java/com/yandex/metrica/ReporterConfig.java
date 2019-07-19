package com.yandex.metrica;

import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import com.yandex.metrica.impl.ob.py;

public class ReporterConfig
{
  public final String apiKey;
  public final Boolean logs;
  public final Integer sessionTimeout;
  public final Boolean statisticsSending;

  ReporterConfig(Builder paramBuilder)
  {
    this.apiKey = Builder.a(paramBuilder);
    this.sessionTimeout = Builder.b(paramBuilder);
    this.logs = Builder.c(paramBuilder);
    this.statisticsSending = Builder.d(paramBuilder);
  }

  ReporterConfig(ReporterConfig paramReporterConfig)
  {
    this.apiKey = paramReporterConfig.apiKey;
    this.sessionTimeout = paramReporterConfig.sessionTimeout;
    this.logs = paramReporterConfig.logs;
    this.statisticsSending = paramReporterConfig.statisticsSending;
  }

  public static Builder newConfigBuilder(String paramString)
  {
    return new Builder(paramString);
  }

  public static class Builder
  {
    private static final px<String> a = new pt(new py());
    private final String b;
    private Integer c;
    private Boolean d;
    private Boolean e;

    Builder(String paramString)
    {
      a.a(paramString);
      this.b = paramString;
    }

    public ReporterConfig build()
    {
      return new ReporterConfig(this);
    }

    public Builder withLogs()
    {
      this.d = Boolean.TRUE;
      return this;
    }

    public Builder withSessionTimeout(int paramInt)
    {
      this.c = Integer.valueOf(paramInt);
      return this;
    }

    public Builder withStatisticsSending(boolean paramBoolean)
    {
      this.e = Boolean.valueOf(paramBoolean);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.ReporterConfig
 * JD-Core Version:    0.6.2
 */