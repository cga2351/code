package com.google.android.gms.auth.api.accounttransfer;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AuthenticatorTransferCompletionStatus
{
  public static final int COMPLETED_FAILURE = 2;
  public static final int COMPLETED_SUCCESS = 1;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus
 * JD-Core Version:    0.6.2
 */