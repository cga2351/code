package com.yandex.mobile.ads.impl;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

final class do extends WebChromeClient
{
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramConsoleMessage.message();
    arrayOfObject[1] = Integer.valueOf(paramConsoleMessage.lineNumber());
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.do
 * JD-Core Version:    0.6.2
 */