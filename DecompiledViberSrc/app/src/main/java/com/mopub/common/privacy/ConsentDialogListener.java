package com.mopub.common.privacy;

import com.mopub.mobileads.MoPubErrorCode;

public abstract interface ConsentDialogListener
{
  public abstract void onConsentDialogLoadFailed(MoPubErrorCode paramMoPubErrorCode);

  public abstract void onConsentDialogLoaded();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentDialogListener
 * JD-Core Version:    0.6.2
 */