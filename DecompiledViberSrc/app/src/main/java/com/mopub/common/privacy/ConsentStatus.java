package com.mopub.common.privacy;

public enum ConsentStatus
{
  private final String a;

  static
  {
    EXPLICIT_NO = new ConsentStatus("EXPLICIT_NO", 1, "explicit_no");
    UNKNOWN = new ConsentStatus("UNKNOWN", 2, "unknown");
    POTENTIAL_WHITELIST = new ConsentStatus("POTENTIAL_WHITELIST", 3, "potential_whitelist");
    DNT = new ConsentStatus("DNT", 4, "dnt");
    ConsentStatus[] arrayOfConsentStatus = new ConsentStatus[5];
    arrayOfConsentStatus[0] = EXPLICIT_YES;
    arrayOfConsentStatus[1] = EXPLICIT_NO;
    arrayOfConsentStatus[2] = UNKNOWN;
    arrayOfConsentStatus[3] = POTENTIAL_WHITELIST;
    arrayOfConsentStatus[4] = DNT;
  }

  private ConsentStatus(String paramString)
  {
    this.a = paramString;
  }

  public static ConsentStatus fromString(String paramString)
  {
    ConsentStatus localConsentStatus;
    if (paramString == null)
    {
      localConsentStatus = UNKNOWN;
      return localConsentStatus;
    }
    ConsentStatus[] arrayOfConsentStatus = values();
    int i = arrayOfConsentStatus.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label49;
      localConsentStatus = arrayOfConsentStatus[j];
      if (paramString.equals(localConsentStatus.name()))
        break;
    }
    label49: return UNKNOWN;
  }

  public String getValue()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentStatus
 * JD-Core Version:    0.6.2
 */