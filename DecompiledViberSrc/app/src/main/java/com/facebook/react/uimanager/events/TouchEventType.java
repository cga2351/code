package com.facebook.react.uimanager.events;

public enum TouchEventType
{
  static
  {
    END = new TouchEventType("END", 1);
    MOVE = new TouchEventType("MOVE", 2);
    CANCEL = new TouchEventType("CANCEL", 3);
    TouchEventType[] arrayOfTouchEventType = new TouchEventType[4];
    arrayOfTouchEventType[0] = START;
    arrayOfTouchEventType[1] = END;
    arrayOfTouchEventType[2] = MOVE;
    arrayOfTouchEventType[3] = CANCEL;
  }

  public static String getJSEventName(TouchEventType paramTouchEventType)
  {
    switch (1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[paramTouchEventType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected type " + paramTouchEventType);
    case 1:
      return "topTouchStart";
    case 2:
      return "topTouchEnd";
    case 3:
      return "topTouchMove";
    case 4:
    }
    return "topTouchCancel";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.TouchEventType
 * JD-Core Version:    0.6.2
 */