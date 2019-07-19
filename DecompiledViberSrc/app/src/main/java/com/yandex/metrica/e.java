package com.yandex.metrica;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class e extends ReporterConfig
{
  public final Integer a;
  public final Integer b;
  public final Map<String, String> c;

  private e(ReporterConfig paramReporterConfig)
  {
    super(paramReporterConfig);
    this.a = null;
    this.b = null;
    this.c = null;
  }

  e(a parama)
  {
    super(parama.a);
    this.b = parama.b;
    this.a = parama.c;
    if (parama.d == null);
    for (Map localMap = null; ; localMap = Collections.unmodifiableMap(parama.d))
    {
      this.c = localMap;
      return;
    }
  }

  public static a a(String paramString)
  {
    return new a(paramString);
  }

  public static e a(ReporterConfig paramReporterConfig)
  {
    return new e(paramReporterConfig);
  }

  public static class a
  {
    ReporterConfig.Builder a;
    Integer b;
    Integer c;
    LinkedHashMap<String, String> d = new LinkedHashMap();

    public a(String paramString)
    {
      this.a = ReporterConfig.newConfigBuilder(paramString);
    }

    public a a(int paramInt)
    {
      this.b = Integer.valueOf(paramInt);
      return this;
    }

    public e a()
    {
      return new e(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.e
 * JD-Core Version:    0.6.2
 */