package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class GoogleSignInStatusCodes extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
  public static final int SIGN_IN_FAILED = 12500;

  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 12500:
      return "A non-recoverable sign in failure occurred";
    case 12501:
      return "Sign in action cancelled";
    case 12502:
    }
    return "Sign-in in progress";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
 * JD-Core Version:    0.6.2
 */