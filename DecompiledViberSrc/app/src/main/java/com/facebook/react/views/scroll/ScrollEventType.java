package com.facebook.react.views.scroll;

public enum ScrollEventType
{
  static
  {
    MOMENTUM_BEGIN = new ScrollEventType("MOMENTUM_BEGIN", 3);
    MOMENTUM_END = new ScrollEventType("MOMENTUM_END", 4);
    ScrollEventType[] arrayOfScrollEventType = new ScrollEventType[5];
    arrayOfScrollEventType[0] = BEGIN_DRAG;
    arrayOfScrollEventType[1] = END_DRAG;
    arrayOfScrollEventType[2] = SCROLL;
    arrayOfScrollEventType[3] = MOMENTUM_BEGIN;
    arrayOfScrollEventType[4] = MOMENTUM_END;
  }

  public static String getJSEventName(ScrollEventType paramScrollEventType)
  {
    switch (1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType[paramScrollEventType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported ScrollEventType: " + paramScrollEventType);
    case 1:
      return "topScrollBeginDrag";
    case 2:
      return "topScrollEndDrag";
    case 3:
      return "topScroll";
    case 4:
      return "topMomentumScrollBegin";
    case 5:
    }
    return "topMomentumScrollEnd";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ScrollEventType
 * JD-Core Version:    0.6.2
 */