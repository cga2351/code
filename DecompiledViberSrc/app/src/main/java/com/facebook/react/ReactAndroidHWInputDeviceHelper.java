package com.facebook.react;

import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import java.util.Map;

public class ReactAndroidHWInputDeviceHelper
{
  private static final Map<Integer, String> KEY_EVENTS_ACTIONS = MapBuilder.builder().put(Integer.valueOf(23), "select").put(Integer.valueOf(66), "select").put(Integer.valueOf(62), "select").put(Integer.valueOf(85), "playPause").put(Integer.valueOf(89), "rewind").put(Integer.valueOf(90), "fastForward").put(Integer.valueOf(19), "up").put(Integer.valueOf(22), "right").put(Integer.valueOf(20), "down").put(Integer.valueOf(21), "left").build();
  private int mLastFocusedViewId = -1;
  private final ReactRootView mReactRootView;

  ReactAndroidHWInputDeviceHelper(ReactRootView paramReactRootView)
  {
    this.mReactRootView = paramReactRootView;
  }

  private void dispatchEvent(String paramString, int paramInt)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putString("eventType", paramString);
    if (paramInt != -1)
      localWritableNativeMap.putInt("tag", paramInt);
    this.mReactRootView.sendEvent("onHWKeyEvent", localWritableNativeMap);
  }

  public void clearFocus()
  {
    if (this.mLastFocusedViewId != -1)
      dispatchEvent("blur", this.mLastFocusedViewId);
    this.mLastFocusedViewId = -1;
  }

  public void handleKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if ((paramKeyEvent.getAction() == 1) && (KEY_EVENTS_ACTIONS.containsKey(Integer.valueOf(i))))
      dispatchEvent((String)KEY_EVENTS_ACTIONS.get(Integer.valueOf(i)), this.mLastFocusedViewId);
  }

  public void onFocusChanged(View paramView)
  {
    if (this.mLastFocusedViewId == paramView.getId())
      return;
    if (this.mLastFocusedViewId != -1)
      dispatchEvent("blur", this.mLastFocusedViewId);
    this.mLastFocusedViewId = paramView.getId();
    dispatchEvent("focus", paramView.getId());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactAndroidHWInputDeviceHelper
 * JD-Core Version:    0.6.2
 */