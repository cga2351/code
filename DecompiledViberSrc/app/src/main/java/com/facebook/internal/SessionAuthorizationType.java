package com.facebook.internal;

public enum SessionAuthorizationType
{
  static
  {
    PUBLISH = new SessionAuthorizationType("PUBLISH", 1);
    SessionAuthorizationType[] arrayOfSessionAuthorizationType = new SessionAuthorizationType[2];
    arrayOfSessionAuthorizationType[0] = READ;
    arrayOfSessionAuthorizationType[1] = PUBLISH;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.internal.SessionAuthorizationType
 * JD-Core Version:    0.6.2
 */