package com.facebook.react.uimanager;

import android.view.View;

public abstract class SimpleViewManager<T extends View> extends BaseViewManager<T, LayoutShadowNode>
{
  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }

  public Class<LayoutShadowNode> getShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }

  public void updateExtraData(T paramT, Object paramObject)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.SimpleViewManager
 * JD-Core Version:    0.6.2
 */