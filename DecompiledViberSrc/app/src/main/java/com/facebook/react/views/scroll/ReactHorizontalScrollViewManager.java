package com.facebook.react.views.scroll;

import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
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
import javax.annotation.Nullable;

@ReactModule(name="AndroidHorizontalScrollView")
public class ReactHorizontalScrollViewManager extends ViewGroupManager<ReactHorizontalScrollView>
  implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactHorizontalScrollView>
{
  public static final String REACT_CLASS = "AndroidHorizontalScrollView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  @Nullable
  private FpsListener mFpsListener = null;

  public ReactHorizontalScrollViewManager()
  {
    this(null);
  }

  public ReactHorizontalScrollViewManager(@Nullable FpsListener paramFpsListener)
  {
    this.mFpsListener = paramFpsListener;
  }

  public ReactHorizontalScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactHorizontalScrollView(paramThemedReactContext, this.mFpsListener);
  }

  public void flashScrollIndicators(ReactHorizontalScrollView paramReactHorizontalScrollView)
  {
    paramReactHorizontalScrollView.flashScrollIndicators();
  }

  public String getName()
  {
    return "AndroidHorizontalScrollView";
  }

  public void receiveCommand(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    ReactScrollViewCommandHelper.receiveCommand(this, paramReactHorizontalScrollView, paramInt, paramReadableArray);
  }

  public void scrollTo(ReactHorizontalScrollView paramReactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    if (paramScrollToCommandData.mAnimated)
    {
      paramReactHorizontalScrollView.smoothScrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
      return;
    }
    paramReactHorizontalScrollView.scrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }

  public void scrollToEnd(ReactHorizontalScrollView paramReactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData paramScrollToEndCommandData)
  {
    int i = paramReactHorizontalScrollView.getChildAt(0).getWidth() + paramReactHorizontalScrollView.getPaddingRight();
    if (paramScrollToEndCommandData.mAnimated)
    {
      paramReactHorizontalScrollView.smoothScrollTo(i, paramReactHorizontalScrollView.getScrollY());
      return;
    }
    paramReactHorizontalScrollView.scrollTo(i, paramReactHorizontalScrollView.getScrollY());
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt, Integer paramInteger)
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
      paramReactHorizontalScrollView.setBorderColor(SPACING_TYPES[paramInt], f2, f1);
      return;
      f2 = 0xFFFFFF & paramInteger.intValue();
      break;
      label43: f1 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactHorizontalScrollView.setBorderRadius(paramFloat);
      return;
    }
    paramReactHorizontalScrollView.setBorderRadius(paramFloat, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactHorizontalScrollView paramReactHorizontalScrollView, @Nullable String paramString)
  {
    paramReactHorizontalScrollView.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactHorizontalScrollView.setBorderWidth(SPACING_TYPES[paramInt], paramFloat);
  }

  @ReactProp(customType="Color", defaultInt=0, name="endFillColor")
  public void setBottomFillColor(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt)
  {
    paramReactHorizontalScrollView.setEndFillColor(paramInt);
  }

  @ReactProp(name="decelerationRate")
  public void setDecelerationRate(ReactHorizontalScrollView paramReactHorizontalScrollView, float paramFloat)
  {
    paramReactHorizontalScrollView.setDecelerationRate(paramFloat);
  }

  @ReactProp(name="nestedScrollEnabled")
  public void setNestedScrollEnabled(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    ViewCompat.setNestedScrollingEnabled(paramReactHorizontalScrollView, paramBoolean);
  }

  @ReactProp(name="overScrollMode")
  public void setOverScrollMode(ReactHorizontalScrollView paramReactHorizontalScrollView, String paramString)
  {
    paramReactHorizontalScrollView.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(paramString));
  }

  @ReactProp(name="overflow")
  public void setOverflow(ReactHorizontalScrollView paramReactHorizontalScrollView, @Nullable String paramString)
  {
    paramReactHorizontalScrollView.setOverflow(paramString);
  }

  @ReactProp(name="pagingEnabled")
  public void setPagingEnabled(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setPagingEnabled(paramBoolean);
  }

  @ReactProp(name="persistentScrollbar")
  public void setPersistentScrollbar(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactHorizontalScrollView.setScrollbarFadingEnabled(bool);
      return;
    }
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setRemoveClippedSubviews(paramBoolean);
  }

  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setScrollEnabled(paramBoolean);
  }

  @ReactProp(name="scrollPerfTag")
  public void setScrollPerfTag(ReactHorizontalScrollView paramReactHorizontalScrollView, String paramString)
  {
    paramReactHorizontalScrollView.setScrollPerfTag(paramString);
  }

  @ReactProp(name="sendMomentumEvents")
  public void setSendMomentumEvents(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setSendMomentumEvents(paramBoolean);
  }

  @ReactProp(name="showsHorizontalScrollIndicator")
  public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setHorizontalScrollBarEnabled(paramBoolean);
  }

  @ReactProp(name="snapToEnd")
  public void setSnapToEnd(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setSnapToEnd(paramBoolean);
  }

  @ReactProp(name="snapToInterval")
  public void setSnapToInterval(ReactHorizontalScrollView paramReactHorizontalScrollView, float paramFloat)
  {
    paramReactHorizontalScrollView.setSnapInterval((int)(paramFloat * DisplayMetricsHolder.getScreenDisplayMetrics().density));
  }

  @ReactProp(name="snapToOffsets")
  public void setSnapToOffsets(ReactHorizontalScrollView paramReactHorizontalScrollView, @Nullable ReadableArray paramReadableArray)
  {
    DisplayMetrics localDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramReadableArray.size(); i++)
      localArrayList.add(Integer.valueOf((int)(paramReadableArray.getDouble(i) * localDisplayMetrics.density)));
    paramReactHorizontalScrollView.setSnapOffsets(localArrayList);
  }

  @ReactProp(name="snapToStart")
  public void setSnapToStart(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setSnapToStart(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollViewManager
 * JD-Core Version:    0.6.2
 */