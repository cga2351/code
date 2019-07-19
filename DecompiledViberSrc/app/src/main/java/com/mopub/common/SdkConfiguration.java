package com.mopub.common;

import com.mopub.common.logging.MoPubLog.LogLevel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SdkConfiguration
{
  private final String a;
  private final Set<String> b;
  private final MediationSettings[] c;
  private final Map<String, Map<String, String>> d;
  private final Map<String, Map<String, String>> e;
  private final MoPubLog.LogLevel f;
  private final boolean g;

  private SdkConfiguration(String paramString, Set<String> paramSet, MediationSettings[] paramArrayOfMediationSettings, MoPubLog.LogLevel paramLogLevel, Map<String, Map<String, String>> paramMap1, Map<String, Map<String, String>> paramMap2, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramSet);
    Preconditions.checkNotNull(paramMap1);
    Preconditions.checkNotNull(paramMap2);
    this.a = paramString;
    this.b = paramSet;
    this.c = paramArrayOfMediationSettings;
    this.f = paramLogLevel;
    this.d = paramMap1;
    this.e = paramMap2;
    this.g = paramBoolean;
  }

  MoPubLog.LogLevel a()
  {
    return this.f;
  }

  public String getAdUnitId()
  {
    return this.a;
  }

  public Set<String> getAdapterConfigurationClasses()
  {
    return Collections.unmodifiableSet(this.b);
  }

  public boolean getLegitimateInterestAllowed()
  {
    return this.g;
  }

  public Map<String, Map<String, String>> getMediatedNetworkConfigurations()
  {
    return Collections.unmodifiableMap(this.d);
  }

  public MediationSettings[] getMediationSettings()
  {
    return (MediationSettings[])Arrays.copyOf(this.c, this.c.length);
  }

  public Map<String, Map<String, String>> getMoPubRequestOptions()
  {
    return Collections.unmodifiableMap(this.e);
  }

  public static class Builder
  {
    private String a;
    private final Set<String> b;
    private MediationSettings[] c;
    private MoPubLog.LogLevel d = MoPubLog.LogLevel.NONE;
    private final Map<String, Map<String, String>> e;
    private final Map<String, Map<String, String>> f;
    private boolean g;

    public Builder(String paramString)
    {
      this.a = paramString;
      this.b = DefaultAdapterClasses.getClassNamesSet();
      this.c = new MediationSettings[0];
      this.e = new HashMap();
      this.f = new HashMap();
      this.g = false;
    }

    public SdkConfiguration build()
    {
      return new SdkConfiguration(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
    }

    public Builder withAdditionalNetwork(String paramString)
    {
      Preconditions.checkNotNull(paramString);
      this.b.add(paramString);
      return this;
    }

    public Builder withLegitimateInterestAllowed(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }

    public Builder withLogLevel(MoPubLog.LogLevel paramLogLevel)
    {
      Preconditions.checkNotNull(paramLogLevel);
      this.d = paramLogLevel;
      return this;
    }

    public Builder withMediatedNetworkConfiguration(String paramString, Map<String, String> paramMap)
    {
      Preconditions.checkNotNull(paramString);
      Preconditions.checkNotNull(paramMap);
      this.e.put(paramString, paramMap);
      return this;
    }

    public Builder withMediationSettings(MediationSettings[] paramArrayOfMediationSettings)
    {
      Preconditions.checkNotNull(paramArrayOfMediationSettings);
      this.c = paramArrayOfMediationSettings;
      return this;
    }

    public Builder withMoPubRequestOptions(String paramString, Map<String, String> paramMap)
    {
      Preconditions.checkNotNull(paramString);
      Preconditions.checkNotNull(paramMap);
      this.f.put(paramString, paramMap);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.SdkConfiguration
 * JD-Core Version:    0.6.2
 */