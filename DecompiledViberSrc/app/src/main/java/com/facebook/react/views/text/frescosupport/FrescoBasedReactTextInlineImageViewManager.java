package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import javax.annotation.Nullable;

@ReactModule(name="RCTTextInlineImage")
public class FrescoBasedReactTextInlineImageViewManager extends ViewManager<View, FrescoBasedReactTextInlineImageShadowNode>
{
  public static final String REACT_CLASS = "RCTTextInlineImage";

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;

  public FrescoBasedReactTextInlineImageViewManager()
  {
    this(null, null);
  }

  public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }

  public FrescoBasedReactTextInlineImageShadowNode createShadowNodeInstance()
  {
    if (this.mDraweeControllerBuilder != null);
    for (Object localObject = this.mDraweeControllerBuilder; ; localObject = Fresco.newDraweeControllerBuilder())
      return new FrescoBasedReactTextInlineImageShadowNode((AbstractDraweeControllerBuilder)localObject, this.mCallerContext);
  }

  public View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
  }

  public String getName()
  {
    return "RCTTextInlineImage";
  }

  public Class<FrescoBasedReactTextInlineImageShadowNode> getShadowNodeClass()
  {
    return FrescoBasedReactTextInlineImageShadowNode.class;
  }

  public void updateExtraData(View paramView, Object paramObject)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager
 * JD-Core Version:    0.6.2
 */