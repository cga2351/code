package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTView")
public class ReactViewManager extends ViewGroupManager<ReactViewGroup>
{
  private static final int CMD_HOTSPOT_UPDATE = 1;
  private static final int CMD_SET_PRESSED = 2;

  @VisibleForTesting
  public static final String REACT_CLASS = "RCTView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3, 4, 5 };

  public void addView(ReactViewGroup paramReactViewGroup, View paramView, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      paramReactViewGroup.addViewWithSubviewClippingEnabled(paramView, paramInt);
      return;
    }
    paramReactViewGroup.addView(paramView, paramInt);
  }

  public ReactViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactViewGroup(paramThemedReactContext);
  }

  public View getChildAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
      return paramReactViewGroup.getChildAtWithSubviewClippingEnabled(paramInt);
    return paramReactViewGroup.getChildAt(paramInt);
  }

  public int getChildCount(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
      return paramReactViewGroup.getAllChildrenCount();
    return paramReactViewGroup.getChildCount();
  }

  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
  }

  public String getName()
  {
    return "RCTView";
  }

  public void receiveCommand(ReactViewGroup paramReactViewGroup, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
    case 1:
      do
      {
        return;
        if ((paramReadableArray == null) || (paramReadableArray.size() != 2))
          throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
      }
      while (Build.VERSION.SDK_INT < 21);
      paramReactViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0)), PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1)));
      return;
    case 2:
    }
    if ((paramReadableArray == null) || (paramReadableArray.size() != 1))
      throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
    paramReactViewGroup.setPressed(paramReadableArray.getBoolean(0));
  }

  public void removeAllViews(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      paramReactViewGroup.removeAllViewsWithSubviewClippingEnabled();
      return;
    }
    paramReactViewGroup.removeAllViews();
  }

  public void removeViewAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      View localView = getChildAt(paramReactViewGroup, paramInt);
      if (localView.getParent() != null)
        paramReactViewGroup.removeView(localView);
      paramReactViewGroup.removeViewWithSubviewClippingEnabled(localView);
      return;
    }
    paramReactViewGroup.removeViewAt(paramInt);
  }

  @ReactProp(name="accessible")
  public void setAccessible(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setFocusable(paramBoolean);
  }

  @ReactProp(name="backfaceVisibility")
  public void setBackfaceVisibility(ReactViewGroup paramReactViewGroup, String paramString)
  {
    paramReactViewGroup.setBackfaceVisibility(paramString);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
  public void setBorderColor(ReactViewGroup paramReactViewGroup, int paramInt, Integer paramInteger)
  {
    float f1 = (0.0F / 0.0F);
    float f2;
    if (paramInteger == null)
    {
      f2 = f1;
      if (paramInteger != null)
        break label43;
    }
    while (true)
    {
      paramReactViewGroup.setBorderColor(SPACING_TYPES[paramInt], f2, f1);
      return;
      f2 = 0xFFFFFF & paramInteger.intValue();
      break;
      label43: f1 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
  public void setBorderRadius(ReactViewGroup paramReactViewGroup, int paramInt, float paramFloat)
  {
    if ((!YogaConstants.isUndefined(paramFloat)) && (paramFloat < 0.0F))
      paramFloat = (0.0F / 0.0F);
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactViewGroup.setBorderRadius(paramFloat);
      return;
    }
    paramReactViewGroup.setBorderRadius(paramFloat, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    paramReactViewGroup.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
  public void setBorderWidth(ReactViewGroup paramReactViewGroup, int paramInt, float paramFloat)
  {
    if ((!YogaConstants.isUndefined(paramFloat)) && (paramFloat < 0.0F))
      paramFloat = (0.0F / 0.0F);
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactViewGroup.setBorderWidth(SPACING_TYPES[paramInt], paramFloat);
  }

  @ReactProp(name="collapsable")
  public void setCollapsable(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
  }

  @ReactProp(name="hitSlop")
  public void setHitSlop(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
    {
      paramReactViewGroup.setHitSlopRect(null);
      return;
    }
    int i;
    int j;
    if (paramReadableMap.hasKey("left"))
    {
      i = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("left"));
      if (!paramReadableMap.hasKey("top"))
        break label148;
      j = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("top"));
      label63: if (!paramReadableMap.hasKey("right"))
        break label154;
    }
    label148: label154: for (int k = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("right")); ; k = 0)
    {
      boolean bool = paramReadableMap.hasKey("bottom");
      int m = 0;
      if (bool)
        m = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("bottom"));
      paramReactViewGroup.setHitSlopRect(new Rect(i, j, k, m));
      return;
      i = 0;
      break;
      j = 0;
      break label63;
    }
  }

  @ReactProp(name="nativeBackgroundAndroid")
  public void setNativeBackground(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    for (Drawable localDrawable = null; ; localDrawable = ReactDrawableHelper.createDrawableFromJSDescription(paramReactViewGroup.getContext(), paramReadableMap))
    {
      paramReactViewGroup.setTranslucentBackgroundDrawable(localDrawable);
      return;
    }
  }

  @ReactProp(name="nativeForegroundAndroid")
  @TargetApi(23)
  public void setNativeForeground(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    for (Drawable localDrawable = null; ; localDrawable = ReactDrawableHelper.createDrawableFromJSDescription(paramReactViewGroup.getContext(), paramReadableMap))
    {
      paramReactViewGroup.setForeground(localDrawable);
      return;
    }
  }

  @ReactProp(name="needsOffscreenAlphaCompositing")
  public void setNeedsOffscreenAlphaCompositing(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setNeedsOffscreenAlphaCompositing(paramBoolean);
  }

  public void setOpacity(ReactViewGroup paramReactViewGroup, float paramFloat)
  {
    paramReactViewGroup.setOpacityIfPossible(paramFloat);
  }

  @ReactProp(name="overflow")
  public void setOverflow(ReactViewGroup paramReactViewGroup, String paramString)
  {
    paramReactViewGroup.setOverflow(paramString);
  }

  @ReactProp(name="pointerEvents")
  public void setPointerEvents(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    if (paramString == null)
    {
      paramReactViewGroup.setPointerEvents(PointerEvents.AUTO);
      return;
    }
    paramReactViewGroup.setPointerEvents(PointerEvents.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setRemoveClippedSubviews(paramBoolean);
  }

  @ReactProp(name="hasTVPreferredFocus")
  public void setTVPreferredFocus(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactViewGroup.setFocusable(true);
      paramReactViewGroup.setFocusableInTouchMode(true);
      paramReactViewGroup.requestFocus();
    }
  }

  public void setTransform(ReactViewGroup paramReactViewGroup, ReadableArray paramReadableArray)
  {
    super.setTransform(paramReactViewGroup, paramReadableArray);
    paramReactViewGroup.setBackfaceVisibilityDependantOpacity();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewManager
 * JD-Core Version:    0.6.2
 */