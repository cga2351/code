package com.appnexus.opensdk;

public enum ANClickThroughAction
{
  static
  {
    OPEN_SDK_BROWSER = new ANClickThroughAction("OPEN_SDK_BROWSER", 1);
    OPEN_DEVICE_BROWSER = new ANClickThroughAction("OPEN_DEVICE_BROWSER", 2);
    ANClickThroughAction[] arrayOfANClickThroughAction = new ANClickThroughAction[3];
    arrayOfANClickThroughAction[0] = RETURN_URL;
    arrayOfANClickThroughAction[1] = OPEN_SDK_BROWSER;
    arrayOfANClickThroughAction[2] = OPEN_DEVICE_BROWSER;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ANClickThroughAction
 * JD-Core Version:    0.6.2
 */