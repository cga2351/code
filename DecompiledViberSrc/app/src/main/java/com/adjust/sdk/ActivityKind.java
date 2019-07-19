package com.adjust.sdk;

public enum ActivityKind
{
  static
  {
    SESSION = new ActivityKind("SESSION", 1);
    EVENT = new ActivityKind("EVENT", 2);
    CLICK = new ActivityKind("CLICK", 3);
    ATTRIBUTION = new ActivityKind("ATTRIBUTION", 4);
    REVENUE = new ActivityKind("REVENUE", 5);
    REATTRIBUTION = new ActivityKind("REATTRIBUTION", 6);
    INFO = new ActivityKind("INFO", 7);
    GDPR = new ActivityKind("GDPR", 8);
    ActivityKind[] arrayOfActivityKind = new ActivityKind[9];
    arrayOfActivityKind[0] = UNKNOWN;
    arrayOfActivityKind[1] = SESSION;
    arrayOfActivityKind[2] = EVENT;
    arrayOfActivityKind[3] = CLICK;
    arrayOfActivityKind[4] = ATTRIBUTION;
    arrayOfActivityKind[5] = REVENUE;
    arrayOfActivityKind[6] = REATTRIBUTION;
    arrayOfActivityKind[7] = INFO;
    arrayOfActivityKind[8] = GDPR;
  }

  public static ActivityKind fromString(String paramString)
  {
    if ("session".equals(paramString))
      return SESSION;
    if ("event".equals(paramString))
      return EVENT;
    if ("click".equals(paramString))
      return CLICK;
    if ("attribution".equals(paramString))
      return ATTRIBUTION;
    if ("info".equals(paramString))
      return INFO;
    if ("gdpr".equals(paramString))
      return GDPR;
    return UNKNOWN;
  }

  public String toString()
  {
    switch (1.a[ordinal()])
    {
    default:
      return "unknown";
    case 1:
      return "session";
    case 2:
      return "event";
    case 3:
      return "click";
    case 4:
      return "attribution";
    case 5:
      return "info";
    case 6:
    }
    return "gdpr";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityKind
 * JD-Core Version:    0.6.2
 */