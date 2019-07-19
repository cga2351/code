package com.mopub.common.privacy;

public abstract interface ConsentData
{
  public abstract String getConsentedPrivacyPolicyVersion();

  public abstract String getConsentedVendorListIabFormat();

  public abstract String getConsentedVendorListVersion();

  public abstract String getCurrentPrivacyPolicyLink();

  public abstract String getCurrentPrivacyPolicyLink(String paramString);

  public abstract String getCurrentPrivacyPolicyVersion();

  public abstract String getCurrentVendorListIabFormat();

  public abstract String getCurrentVendorListLink();

  public abstract String getCurrentVendorListLink(String paramString);

  public abstract String getCurrentVendorListVersion();

  public abstract boolean isForceGdprApplies();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentData
 * JD-Core Version:    0.6.2
 */