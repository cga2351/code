package com.facebook;

public enum SessionDefaultAudience
{
  private final String nativeProtocolAudience;

  static
  {
    FRIENDS = new SessionDefaultAudience("FRIENDS", 2, "friends");
    EVERYONE = new SessionDefaultAudience("EVERYONE", 3, "everyone");
    SessionDefaultAudience[] arrayOfSessionDefaultAudience = new SessionDefaultAudience[4];
    arrayOfSessionDefaultAudience[0] = NONE;
    arrayOfSessionDefaultAudience[1] = ONLY_ME;
    arrayOfSessionDefaultAudience[2] = FRIENDS;
    arrayOfSessionDefaultAudience[3] = EVERYONE;
  }

  private SessionDefaultAudience(String paramString)
  {
    this.nativeProtocolAudience = paramString;
  }

  public String getNativeProtocolAudience()
  {
    return this.nativeProtocolAudience;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.SessionDefaultAudience
 * JD-Core Version:    0.6.2
 */