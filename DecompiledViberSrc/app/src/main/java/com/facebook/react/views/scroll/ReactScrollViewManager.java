package com.facebook.react.views.scroll;

import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTScrollView")
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView>
  implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactScrollView>
{
  public static final String REACT_CLASS = "RCTScrollView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  @Nullable
  private FpsListener mFpsListener = null;

  public ReactScrollViewManager()
  {
    this(null);
  }

  public ReactScrollViewManager(@Nullable FpsListener paramFpsListener)
  {
    this.mFpsListener = paramFpsListener;
  }

  public static Map<String, Object> createExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll")).put(ScrollEventType.getJSEventName(ScrollEventType.BEGIN_DRAG), MapBuilder.of("registrationName", "onScrollBeginDrag")).put(ScrollEventType.getJSEventName(ScrollEventType.END_DRAG), MapBuilder.of("registrationName", "onScrollEndDrag")).put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_BEGIN), MapBuilder.of("registrationName", "onMomentumScrollBegin")).put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_END), MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
  }

  public ReactScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactScrollView(paramThemedReactContext, this.mFpsListener);
  }

  public void flashScrollIndicators(ReactScrollView paramReactScrollView)
  {
    paramReactScrollView.flashScrollIndicators();
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return ReactScrollViewCommandHelper.getCommandsMap();
  }

  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return createExportedCustomDirectEventTypeConstants();
  }

  public String getName()
  {
    return "RCTScrollView";
  }

  public void receiveCommand(ReactScrollView paramReactScrollView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    ReactScrollViewCommandHelper.receiveCommand(this, paramReactScrollView, paramInt, paramReadableArray);
  }

  public void scrollTo(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    if (paramScrollToCommandData.mAnimated)
    {
      paramReactScrollView.smoothScrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
      return;
    }
    paramReactScrollView.scrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }

  public void scrollToEnd(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData paramScrollToEndCommandData)
  {
    int i = paramReactScrollView.getChildAt(0).getHeight() + paramReactScrollView.getPaddingBottom();
    if (paramScrollToEndCommandData.mAnimated)
    {
      paramReactScrollView.smoothScrollTo(paramReactScrollView.getScrollX(), i);
      return;
    }
    paramReactScrollView.scrollTo(paramReactScrollView.getScrollX(), i);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactScrollView paramReactScrollView, int paramInt, Integer paramInteger)
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
      paramReactScrollView.setBorderColor(SPACING_TYPES[paramInt], f2, f1);
      return;
      f2 = 0xFFFFFF & paramInteger.intValue();
      break;
      label43: f1 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactScrollView paramReactScrollView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactScrollView.setBorderRadius(paramFloat);
      return;
    }
    paramReactScrollView.setBorderRadius(paramFloat, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactScrollView paramReactScrollView, @Nullable String paramString)
  {
    paramReactScrollView.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactScrollView paramReactScrollView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactScrollView.setBorderWidth(SPACING_TYPES[paramInt], paramFloat);
  }

  @ReactProp(customType="Color", defaultInt=0, name="endFillColor")
  public void setBottomFillColor(ReactScrollView paramReactScrollView, int paramInt)
  {
    paramReactScrollView.setEndFillColor(paramInt);
  }

  @ReactProp(name="decelerationRate")
  public void setDecelerationRate(ReactScrollView paramReactScrollView, float paramFloat)
  {
    paramReactScrollView.setDecelerationRate(paramFloat);
  }

  @ReactProp(name="nestedScrollEnabled")
  public void setNestedScrollEnabled(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    ViewCompat.setNestedScrollingEnabled(paramReactScrollView, paramBoolean);
  }

  @ReactProp(name="overScrollMode")
  public void setOverScrollMode(ReactScrollView paramReactScrollView, String paramString)
  {
    paramReactScrollView.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(paramString));
  }

  @ReactProp(name="overflow")
  public void setOverflow(ReactScrollView paramReactScrollView, @Nullable String paramString)
  {
    paramReactScrollView.setOverflow(paramString);
  }

  @ReactProp(name="pagingEnabled")
  public void setPagingEnabled(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setPagingEnabled(paramBoolean);
  }

  @ReactProp(name="persistentScrollbar")
  public void setPersistentScrollbar(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactScrollView.setScrollbarFadingEnabled(bool);
      return;
    }
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setRemoveClippedSubviews(paramBoolean);
  }

  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setScrollEnabled(paramBoolean);
  }

  @ReactProp(name="scrollPerfTag")
  public void setScrollPerfTag(ReactScrollView paramReactScrollView, @Nullable String paramString)
  {
    paramReactScrollView.setScrollPerfTag(paramString);
  }

  @ReactProp(name="sendMomentumEvents")
  public void setSendMomentumEvents(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setSendMomentumEvents(paramBoolean);
  }

  @ReactProp(name="showsVerticalScrollIndicator")
  public void setShowsVerticalScrollIndicator(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setVerticalScrollBarEnabled(paramBoolean);
  }

  @ReactProp(name="snapToEnd")
  public void setSnapToEnd(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setSnapToEnd(paramBoolean);
  }

  @ReactProp(name="snapToInterval")
  public void setSnapToInterval(ReactScrollView paramReactScrollView, float paramFloat)
  {
    paramReactScrollView.setSnapInterval((int)(paramFloat * DisplayMetricsHolder.getScreenDisplayMetrics().density));
  }

  @ReactProp(name="snapToOffsets")
  public void setSnapToOffsets(ReactScrollView paramReactScrollView, @Nullable ReadableArray paramReadableArray)
  {
    DisplayMetrics localDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramReadableArray.size(); i++)
      localArrayList.add(Integer.valueOf((int)(paramReadableArray.getDouble(i) * localDisplayMetrics.density)));
    paramReactScrollView.setSnapOffsets(localArrayList);
  }

  @ReactProp(name="snapToStart")
  public void setSnapToStart(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setSnapToStart(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollViewManager
 * JD-Core Version:    0.6.2
 */