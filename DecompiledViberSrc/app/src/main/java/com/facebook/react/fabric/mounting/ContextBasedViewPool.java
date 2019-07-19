package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.WeakHashMap;

public final class ContextBasedViewPool
{
  private final WeakHashMap<ThemedReactContext, ViewPool> mContextViewPoolHashMap = new WeakHashMap();
  private final ViewManagerRegistry mViewManagerRegistry;

  ContextBasedViewPool(ViewManagerRegistry paramViewManagerRegistry)
  {
    this.mViewManagerRegistry = paramViewManagerRegistry;
  }

  private ViewPool getViewPool(ThemedReactContext paramThemedReactContext)
  {
    ViewPool localViewPool = (ViewPool)this.mContextViewPoolHashMap.get(paramThemedReactContext);
    if (localViewPool == null)
    {
      localViewPool = new ViewPool(this.mViewManagerRegistry);
      this.mContextViewPoolHashMap.put(paramThemedReactContext, localViewPool);
    }
    return localViewPool;
  }

  void createView(ThemedReactContext paramThemedReactContext, String paramString)
  {
    UiThreadUtil.assertOnUiThread();
    getViewPool(paramThemedReactContext).createView(paramString, paramThemedReactContext);
  }

  View getOrCreateView(String paramString, ThemedReactContext paramThemedReactContext)
  {
    UiThreadUtil.assertOnUiThread();
    return getViewPool(paramThemedReactContext).getOrCreateView(paramString, paramThemedReactContext);
  }

  void returnToPool(ThemedReactContext paramThemedReactContext, String paramString, View paramView)
  {
    UiThreadUtil.assertOnUiThread();
    getViewPool(paramThemedReactContext).returnToPool(paramString, paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.ContextBasedViewPool
 * JD-Core Version:    0.6.2
 */