package com.mopub.common.privacy;

public enum PrivacyKey
{
  private final String a;

  static
  {
    FORCE_GDPR_APPLIES = new PrivacyKey("FORCE_GDPR_APPLIES", 2, "force_gdpr_applies");
    FORCE_EXPLICIT_NO = new PrivacyKey("FORCE_EXPLICIT_NO", 3, "force_explicit_no");
    INVALIDATE_CONSENT = new PrivacyKey("INVALIDATE_CONSENT", 4, "invalidate_consent");
    REACQUIRE_CONSENT = new PrivacyKey("REACQUIRE_CONSENT", 5, "reacquire_consent");
    EXTRAS = new PrivacyKey("EXTRAS", 6, "extras");
    CURRENT_VENDOR_LIST_VERSION = new PrivacyKey("CURRENT_VENDOR_LIST_VERSION", 7, "current_vendor_list_version");
    CURRENT_VENDOR_LIST_LINK = new PrivacyKey("CURRENT_VENDOR_LIST_LINK", 8, "current_vendor_list_link");
    CURRENT_PRIVACY_POLICY_VERSION = new PrivacyKey("CURRENT_PRIVACY_POLICY_VERSION", 9, "current_privacy_policy_version");
    CURRENT_PRIVACY_POLICY_LINK = new PrivacyKey("CURRENT_PRIVACY_POLICY_LINK", 10, "current_privacy_policy_link");
    CURRENT_VENDOR_LIST_IAB_FORMAT = new PrivacyKey("CURRENT_VENDOR_LIST_IAB_FORMAT", 11, "current_vendor_list_iab_format");
    CURRENT_VENDOR_LIST_IAB_HASH = new PrivacyKey("CURRENT_VENDOR_LIST_IAB_HASH", 12, "current_vendor_list_iab_hash");
    CALL_AGAIN_AFTER_SECS = new PrivacyKey("CALL_AGAIN_AFTER_SECS", 13, "call_again_after_secs");
    CONSENT_CHANGE_REASON = new PrivacyKey("CONSENT_CHANGE_REASON", 14, "consent_change_reason");
    PrivacyKey[] arrayOfPrivacyKey = new PrivacyKey[15];
    arrayOfPrivacyKey[0] = IS_GDPR_REGION;
    arrayOfPrivacyKey[1] = IS_WHITELISTED;
    arrayOfPrivacyKey[2] = FORCE_GDPR_APPLIES;
    arrayOfPrivacyKey[3] = FORCE_EXPLICIT_NO;
    arrayOfPrivacyKey[4] = INVALIDATE_CONSENT;
    arrayOfPrivacyKey[5] = REACQUIRE_CONSENT;
    arrayOfPrivacyKey[6] = EXTRAS;
    arrayOfPrivacyKey[7] = CURRENT_VENDOR_LIST_VERSION;
    arrayOfPrivacyKey[8] = CURRENT_VENDOR_LIST_LINK;
    arrayOfPrivacyKey[9] = CURRENT_PRIVACY_POLICY_VERSION;
    arrayOfPrivacyKey[10] = CURRENT_PRIVACY_POLICY_LINK;
    arrayOfPrivacyKey[11] = CURRENT_VENDOR_LIST_IAB_FORMAT;
    arrayOfPrivacyKey[12] = CURRENT_VENDOR_LIST_IAB_HASH;
    arrayOfPrivacyKey[13] = CALL_AGAIN_AFTER_SECS;
    arrayOfPrivacyKey[14] = CONSENT_CHANGE_REASON;
  }

  private PrivacyKey(String paramString)
  {
    this.a = paramString;
  }

  public String getKey()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.PrivacyKey
 * JD-Core Version:    0.6.2
 */