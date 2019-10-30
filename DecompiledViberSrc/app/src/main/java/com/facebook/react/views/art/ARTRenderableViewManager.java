package com.facebook.react.views.art;

import android.view.View;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

public class ARTRenderableViewManager extends ViewManager<View, ReactShadowNode>
{
  public static final String CLASS_GROUP = "ARTGroup";
  public static final String CLASS_SHAPE = "ARTShape";
  public static final String CLASS_TEXT = "ARTText";
  private final String mClassName;

  ARTRenderableViewManager(String paramString)
  {
    this.mClassName = paramString;
  }

  public static ARTRenderableViewManager createARTGroupViewManager()
  {
    return new ARTGroupViewManager();
  }

  public static ARTRenderableViewManager createARTShapeViewManager()
  {
    return new ARTShapeViewManager();
  }

  public static ARTRenderableViewManager createARTTextViewManager()
  {
    return new ARTTextViewManager();
  }

  public ReactShadowNode createShadowNodeInstance()
  {
    if ("ARTGroup".equals(this.mClassName))
      return new ARTGroupShadowNode();
    if ("ARTShape".equals(this.mClassName))
      return new ARTShapeShadowNode();
    if ("ARTText".equals(this.mClassName))
      return new ARTTextShadowNode();
    throw new IllegalStateException("Unexpected type " + this.mClassName);
  }

  protected View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("ARTShape does not map into a native view");
  }

  public String getName()
  {
    return this.mClassName;
  }

  public Class<? extends ReactShadowNode> getShadowNodeClass()
  {
    if ("ARTGroup".equals(this.mClassName))
      return ARTGroupShadowNode.class;
    if ("ARTShape".equals(this.mClassName))
      return ARTShapeShadowNode.class;
    if ("ARTText".equals(this.mClassName))
      return ARTTextShadowNode.class;
    throw new IllegalStateException("Unexpected type " + this.mClassName);
  }

  public void updateExtraData(View paramView, Object paramObject)
  {
    throw new IllegalStateException("ARTShape does not map into a native view");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTRenderableViewManager
 * JD-Core Version:    0.6.2
 */