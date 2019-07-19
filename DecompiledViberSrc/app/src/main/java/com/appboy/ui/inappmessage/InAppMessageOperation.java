package com.appboy.ui.inappmessage;

public enum InAppMessageOperation
{
  static
  {
    DISPLAY_LATER = new InAppMessageOperation("DISPLAY_LATER", 1);
    DISCARD = new InAppMessageOperation("DISCARD", 2);
    InAppMessageOperation[] arrayOfInAppMessageOperation = new InAppMessageOperation[3];
    arrayOfInAppMessageOperation[0] = DISPLAY_NOW;
    arrayOfInAppMessageOperation[1] = DISPLAY_LATER;
    arrayOfInAppMessageOperation[2] = DISCARD;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageOperation
 * JD-Core Version:    0.6.2
 */