package com.yandex.metrica;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PreloadInfo
{
  private String a;
  private Map<String, String> b;

  private PreloadInfo(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Collections.unmodifiableMap(Builder.b(paramBuilder));
  }

  public static Builder newBuilder(String paramString)
  {
    return new Builder(paramString, (byte)0);
  }

  public Map<String, String> getAdditionalParams()
  {
    return this.b;
  }

  public String getTrackingId()
  {
    return this.a;
  }

  public static class Builder
  {
    private String a;
    private Map<String, String> b;

    private Builder(String paramString)
    {
      this.a = paramString;
      this.b = new HashMap();
    }

    public PreloadInfo build()
    {
      return new PreloadInfo(this, (byte)0);
    }

    public Builder setAdditionalParams(String paramString1, String paramString2)
    {
      if ((paramString1 != null) && (paramString2 != null))
        this.b.put(paramString1, paramString2);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.PreloadInfo
 * JD-Core Version:    0.6.2
 */