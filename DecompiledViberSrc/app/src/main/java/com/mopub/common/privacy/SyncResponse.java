package com.mopub.common.privacy;

import com.mopub.common.Preconditions;

public class SyncResponse
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;

  private SyncResponse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString5);
    Preconditions.checkNotNull(paramString7);
    Preconditions.checkNotNull(paramString8);
    Preconditions.checkNotNull(paramString9);
    Preconditions.checkNotNull(paramString10);
    Preconditions.checkNotNull(paramString12);
    if (!"0".equals(paramString1));
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      this.b = "1".equals(paramString2);
      this.c = "1".equals(paramString3);
      this.d = "1".equals(paramString4);
      this.e = "1".equals(paramString5);
      this.f = "1".equals(paramString6);
      this.g = paramString7;
      this.h = paramString8;
      this.i = paramString9;
      this.j = paramString10;
      this.k = paramString11;
      this.l = paramString12;
      this.m = paramString13;
      this.n = paramString14;
      this.o = paramString15;
      return;
    }
  }

  String a()
  {
    return this.n;
  }

  public String getCallAgainAfterSecs()
  {
    return this.m;
  }

  public String getConsentChangeReason()
  {
    return this.o;
  }

  public String getCurrentPrivacyPolicyLink()
  {
    return this.j;
  }

  public String getCurrentPrivacyPolicyVersion()
  {
    return this.i;
  }

  public String getCurrentVendorListIabFormat()
  {
    return this.k;
  }

  public String getCurrentVendorListIabHash()
  {
    return this.l;
  }

  public String getCurrentVendorListLink()
  {
    return this.h;
  }

  public String getCurrentVendorListVersion()
  {
    return this.g;
  }

  public boolean isForceExplicitNo()
  {
    return this.b;
  }

  public boolean isForceGdprApplies()
  {
    return this.f;
  }

  public boolean isGdprRegion()
  {
    return this.a;
  }

  public boolean isInvalidateConsent()
  {
    return this.c;
  }

  public boolean isReacquireConsent()
  {
    return this.d;
  }

  public boolean isWhitelisted()
  {
    return this.e;
  }

  public static class Builder
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    public SyncResponse build()
    {
      return new SyncResponse(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, null);
    }

    public Builder setCallAgainAfterSecs(String paramString)
    {
      this.m = paramString;
      return this;
    }

    public Builder setConsentChangeReason(String paramString)
    {
      this.o = paramString;
      return this;
    }

    public Builder setCurrentPrivacyPolicyLink(String paramString)
    {
      this.j = paramString;
      return this;
    }

    public Builder setCurrentPrivacyPolicyVersion(String paramString)
    {
      this.i = paramString;
      return this;
    }

    public Builder setCurrentVendorListIabFormat(String paramString)
    {
      this.k = paramString;
      return this;
    }

    public Builder setCurrentVendorListIabHash(String paramString)
    {
      this.l = paramString;
      return this;
    }

    public Builder setCurrentVendorListLink(String paramString)
    {
      this.h = paramString;
      return this;
    }

    public Builder setCurrentVendorListVersion(String paramString)
    {
      this.g = paramString;
      return this;
    }

    public Builder setExtras(String paramString)
    {
      this.n = paramString;
      return this;
    }

    public Builder setForceExplicitNo(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public Builder setForceGdprApplies(String paramString)
    {
      this.f = paramString;
      return this;
    }

    public Builder setInvalidateConsent(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public Builder setIsGdprRegion(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public Builder setIsWhitelisted(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public Builder setReacquireConsent(String paramString)
    {
      this.d = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.SyncResponse
 * JD-Core Version:    0.6.2
 */