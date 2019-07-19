package com.facebook.react.uimanager;

public enum PointerEvents
{
  static
  {
    BOX_NONE = new PointerEvents("BOX_NONE", 1);
    BOX_ONLY = new PointerEvents("BOX_ONLY", 2);
    AUTO = new PointerEvents("AUTO", 3);
    PointerEvents[] arrayOfPointerEvents = new PointerEvents[4];
    arrayOfPointerEvents[0] = NONE;
    arrayOfPointerEvents[1] = BOX_NONE;
    arrayOfPointerEvents[2] = BOX_ONLY;
    arrayOfPointerEvents[3] = AUTO;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.PointerEvents
 * JD-Core Version:    0.6.2
 */