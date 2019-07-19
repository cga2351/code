package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
public abstract interface MraidWebViewDebugListener
{
  public abstract boolean onConsoleMessage(ConsoleMessage paramConsoleMessage);

  public abstract boolean onJsAlert(String paramString, JsResult paramJsResult);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidWebViewDebugListener
 * JD-Core Version:    0.6.2
 */