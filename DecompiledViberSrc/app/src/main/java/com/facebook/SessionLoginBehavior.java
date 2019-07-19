package com.facebook;

public enum SessionLoginBehavior
{
  private final boolean allowsKatanaAuth;
  private final boolean allowsWebViewAuth;

  static
  {
    SSO_ONLY = new SessionLoginBehavior("SSO_ONLY", 1, true, false);
    SUPPRESS_SSO = new SessionLoginBehavior("SUPPRESS_SSO", 2, false, true);
    SessionLoginBehavior[] arrayOfSessionLoginBehavior = new SessionLoginBehavior[3];
    arrayOfSessionLoginBehavior[0] = SSO_WITH_FALLBACK;
    arrayOfSessionLoginBehavior[1] = SSO_ONLY;
    arrayOfSessionLoginBehavior[2] = SUPPRESS_SSO;
  }

  private SessionLoginBehavior(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.allowsKatanaAuth = paramBoolean1;
    this.allowsWebViewAuth = paramBoolean2;
  }

  boolean allowsKatanaAuth()
  {
    return this.allowsKatanaAuth;
  }

  boolean allowsWebViewAuth()
  {
    return this.allowsWebViewAuth;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.SessionLoginBehavior
 * JD-Core Version:    0.6.2
 */