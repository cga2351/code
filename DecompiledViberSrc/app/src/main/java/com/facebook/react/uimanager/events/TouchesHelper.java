package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class TouchesHelper
{
  public static final String CHANGED_TOUCHES_KEY = "changedTouches";
  private static final String LOCATION_X_KEY = "locationX";
  private static final String LOCATION_Y_KEY = "locationY";
  private static final String PAGE_X_KEY = "pageX";
  private static final String PAGE_Y_KEY = "pageY";
  private static final String POINTER_IDENTIFIER_KEY = "identifier";
  public static final String TARGET_KEY = "target";
  private static final String TIMESTAMP_KEY = "timestamp";
  public static final String TOP_TOUCH_CANCEL_KEY = "topTouchCancel";
  public static final String TOP_TOUCH_END_KEY = "topTouchEnd";
  public static final String TOUCHES_KEY = "touches";

  private static WritableArray createsPointersArray(int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray = Arguments.createArray();
    MotionEvent localMotionEvent = paramTouchEvent.getMotionEvent();
    float f1 = localMotionEvent.getX() - paramTouchEvent.getViewX();
    float f2 = localMotionEvent.getY() - paramTouchEvent.getViewY();
    for (int i = 0; i < localMotionEvent.getPointerCount(); i++)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("pageX", PixelUtil.toDIPFromPixel(localMotionEvent.getX(i)));
      localWritableMap.putDouble("pageY", PixelUtil.toDIPFromPixel(localMotionEvent.getY(i)));
      float f3 = localMotionEvent.getX(i) - f1;
      float f4 = localMotionEvent.getY(i) - f2;
      localWritableMap.putDouble("locationX", PixelUtil.toDIPFromPixel(f3));
      localWritableMap.putDouble("locationY", PixelUtil.toDIPFromPixel(f4));
      localWritableMap.putInt("target", paramInt);
      localWritableMap.putDouble("timestamp", paramTouchEvent.getTimestampMs());
      localWritableMap.putDouble("identifier", localMotionEvent.getPointerId(i));
      localWritableArray.pushMap(localWritableMap);
    }
    return localWritableArray;
  }

  public static void sendTouchEvent(RCTEventEmitter paramRCTEventEmitter, TouchEventType paramTouchEventType, int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray1 = createsPointersArray(paramInt, paramTouchEvent);
    MotionEvent localMotionEvent = paramTouchEvent.getMotionEvent();
    WritableArray localWritableArray2 = Arguments.createArray();
    int i;
    if ((paramTouchEventType == TouchEventType.MOVE) || (paramTouchEventType == TouchEventType.CANCEL))
      i = 0;
    while (i < localMotionEvent.getPointerCount())
    {
      localWritableArray2.pushInt(i);
      i++;
      continue;
      if ((paramTouchEventType != TouchEventType.START) && (paramTouchEventType != TouchEventType.END))
        break label101;
      localWritableArray2.pushInt(localMotionEvent.getActionIndex());
    }
    paramRCTEventEmitter.receiveTouches(TouchEventType.getJSEventName(paramTouchEventType), localWritableArray1, localWritableArray2);
    return;
    label101: throw new RuntimeException("Unknown touch type: " + paramTouchEventType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.TouchesHelper
 * JD-Core Version:    0.6.2
 */