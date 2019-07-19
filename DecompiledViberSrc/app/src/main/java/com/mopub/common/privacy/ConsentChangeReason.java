package com.mopub.common.privacy;

public enum ConsentChangeReason
{
  private final String a;

  static
  {
    GRANTED_BY_NOT_WHITELISTED_PUB = new ConsentChangeReason("GRANTED_BY_NOT_WHITELISTED_PUB", 2, "Consent was explicitly granted by a publisher who is not whitelisted");
    DENIED_BY_USER = new ConsentChangeReason("DENIED_BY_USER", 3, "Consent was explicitly denied by the user");
    DENIED_BY_PUB = new ConsentChangeReason("DENIED_BY_PUB", 4, "Consent was explicitly denied by the publisher");
    DENIED_BY_DNT_ON = new ConsentChangeReason("DENIED_BY_DNT_ON", 5, "Limit ad tracking was enabled and consent implicitly denied by the user");
    DNT_OFF = new ConsentChangeReason("DNT_OFF", 6, "Limit ad tracking was disabled");
    REACQUIRE_BECAUSE_DNT_OFF = new ConsentChangeReason("REACQUIRE_BECAUSE_DNT_OFF", 7, "Consent needs to be reacquired because the user disabled limit ad tracking");
    REACQUIRE_BECAUSE_PRIVACY_POLICY = new ConsentChangeReason("REACQUIRE_BECAUSE_PRIVACY_POLICY", 8, "Consent needs to be reacquired because the privacy policy has changed");
    REACUIRE_BECAUSE_VENDOR_LIST = new ConsentChangeReason("REACUIRE_BECAUSE_VENDOR_LIST", 9, "Consent needs to be reacquired because the vendor list has changed");
    REAQUIRE_BECAUSE_IAB_VENDOR_LIST = new ConsentChangeReason("REAQUIRE_BECAUSE_IAB_VENDOR_LIST", 10, "Consent needs to be reacquired because the IAB vendor list has changed");
    REVOKED_BY_SERVER = new ConsentChangeReason("REVOKED_BY_SERVER", 11, "Consent was revoked by the server");
    REACQUIRE_BY_SERVER = new ConsentChangeReason("REACQUIRE_BY_SERVER", 12, "Server requires that consent needs to be reacquired");
    IFA_CHANGED = new ConsentChangeReason("IFA_CHANGED", 13, "Consent needs to be reacquired because the IFA has changed");
    ConsentChangeReason[] arrayOfConsentChangeReason = new ConsentChangeReason[14];
    arrayOfConsentChangeReason[0] = GRANTED_BY_USER;
    arrayOfConsentChangeReason[1] = GRANTED_BY_WHITELISTED_PUB;
    arrayOfConsentChangeReason[2] = GRANTED_BY_NOT_WHITELISTED_PUB;
    arrayOfConsentChangeReason[3] = DENIED_BY_USER;
    arrayOfConsentChangeReason[4] = DENIED_BY_PUB;
    arrayOfConsentChangeReason[5] = DENIED_BY_DNT_ON;
    arrayOfConsentChangeReason[6] = DNT_OFF;
    arrayOfConsentChangeReason[7] = REACQUIRE_BECAUSE_DNT_OFF;
    arrayOfConsentChangeReason[8] = REACQUIRE_BECAUSE_PRIVACY_POLICY;
    arrayOfConsentChangeReason[9] = REACUIRE_BECAUSE_VENDOR_LIST;
    arrayOfConsentChangeReason[10] = REAQUIRE_BECAUSE_IAB_VENDOR_LIST;
    arrayOfConsentChangeReason[11] = REVOKED_BY_SERVER;
    arrayOfConsentChangeReason[12] = REACQUIRE_BY_SERVER;
    arrayOfConsentChangeReason[13] = IFA_CHANGED;
  }

  private ConsentChangeReason(String paramString)
  {
    this.a = paramString;
  }

  public String getReason()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentChangeReason
 * JD-Core Version:    0.6.2
 */