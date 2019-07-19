package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ReactPropertyHolder
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule
{
  protected void addEventEmitters(@Nonnull ThemedReactContext paramThemedReactContext, @Nonnull T paramT)
  {
  }

  public C createShadowNodeInstance()
  {
    throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
  }

  @Nonnull
  public C createShadowNodeInstance(@Nonnull ReactApplicationContext paramReactApplicationContext)
  {
    return createShadowNodeInstance();
  }

  @Nonnull
  public final T createView(@Nonnull ThemedReactContext paramThemedReactContext, JSResponderHandler paramJSResponderHandler)
  {
    View localView = createViewInstance(paramThemedReactContext);
    addEventEmitters(paramThemedReactContext, localView);
    if ((localView instanceof ReactInterceptingViewGroup))
      ((ReactInterceptingViewGroup)localView).setOnInterceptTouchEventListener(paramJSResponderHandler);
    return localView;
  }

  @Nonnull
  protected abstract T createViewInstance(@Nonnull ThemedReactContext paramThemedReactContext);

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return null;
  }

  @Nonnull
  public abstract String getName();

  public Map<String, String> getNativeProps()
  {
    return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
  }

  public abstract Class<? extends C> getShadowNodeClass();

  public long measure(ReactContext paramReactContext, ReadableNativeMap paramReadableNativeMap1, ReadableNativeMap paramReadableNativeMap2, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    return 0L;
  }

  protected void onAfterUpdateTransaction(@Nonnull T paramT)
  {
  }

  public void onDropViewInstance(@Nonnull T paramT)
  {
  }

  public void receiveCommand(@Nonnull T paramT, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
  }

  public abstract void updateExtraData(@Nonnull T paramT, Object paramObject);

  @Nullable
  public Object updateLocalData(@Nonnull T paramT, ReactStylesDiffMap paramReactStylesDiffMap1, ReactStylesDiffMap paramReactStylesDiffMap2)
  {
    return null;
  }

  public final void updateProperties(@Nonnull T paramT, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ViewManagerPropertyUpdater.updateProps(this, paramT, paramReactStylesDiffMap);
    onAfterUpdateTransaction(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManager
 * JD-Core Version:    0.6.2
 */