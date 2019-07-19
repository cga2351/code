package com.facebook.react.uimanager;

import android.widget.ImageView.ScaleType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.HashMap;
import java.util.Map;

class UIManagerModuleConstants
{
  public static final String ACTION_DISMISSED = "dismissed";
  public static final String ACTION_ITEM_SELECTED = "itemSelected";

  static Map getBubblingEventTypeConstants()
  {
    return MapBuilder.builder().put("topChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onChange", "captured", "onChangeCapture"))).put("topSelect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.getJSEventName(TouchEventType.START), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.getJSEventName(TouchEventType.MOVE), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.getJSEventName(TouchEventType.END), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).put(TouchEventType.getJSEventName(TouchEventType.CANCEL), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).build();
  }

  public static Map<String, Object> getConstants()
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("UIView", MapBuilder.of("ContentMode", MapBuilder.of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
    localHashMap.put("StyleConstants", MapBuilder.of("PointerEventsValues", MapBuilder.of("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
    localHashMap.put("PopupMenu", MapBuilder.of("dismissed", "dismissed", "itemSelected", "itemSelected"));
    localHashMap.put("AccessibilityEventTypes", MapBuilder.of("typeWindowStateChanged", Integer.valueOf(32), "typeViewFocused", Integer.valueOf(8), "typeViewClicked", Integer.valueOf(1)));
    return localHashMap;
  }

  static Map getDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topContentSizeChange", MapBuilder.of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.of("registrationName", "onLayout")).put("topLoadingError", MapBuilder.of("registrationName", "onLoadingError")).put("topLoadingFinish", MapBuilder.of("registrationName", "onLoadingFinish")).put("topLoadingStart", MapBuilder.of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.of("registrationName", "onSelectionChange")).put("topMessage", MapBuilder.of("registrationName", "onMessage")).put("topScrollBeginDrag", MapBuilder.of("registrationName", "onScrollBeginDrag")).put("topScrollEndDrag", MapBuilder.of("registrationName", "onScrollEndDrag")).put("topScroll", MapBuilder.of("registrationName", "onScroll")).put("topMomentumScrollBegin", MapBuilder.of("registrationName", "onMomentumScrollBegin")).put("topMomentumScrollEnd", MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIManagerModuleConstants
 * JD-Core Version:    0.6.2
 */