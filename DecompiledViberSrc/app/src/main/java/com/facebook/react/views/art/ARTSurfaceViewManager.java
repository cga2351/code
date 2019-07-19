package com.facebook.react.views.art;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@ReactModule(name="ARTSurfaceView")
public class ARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, ARTSurfaceViewShadowNode>
{
  private static final YogaMeasureFunction MEASURE_FUNCTION = new YogaMeasureFunction()
  {
    public long measure(YogaNode paramAnonymousYogaNode, float paramAnonymousFloat1, YogaMeasureMode paramAnonymousYogaMeasureMode1, float paramAnonymousFloat2, YogaMeasureMode paramAnonymousYogaMeasureMode2)
    {
      throw new IllegalStateException("SurfaceView should have explicit width and height set");
    }
  };
  public static final String REACT_CLASS = "ARTSurfaceView";

  public ARTSurfaceViewShadowNode createShadowNodeInstance()
  {
    ARTSurfaceViewShadowNode localARTSurfaceViewShadowNode = new ARTSurfaceViewShadowNode();
    localARTSurfaceViewShadowNode.setMeasureFunction(MEASURE_FUNCTION);
    return localARTSurfaceViewShadowNode;
  }

  protected ARTSurfaceView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ARTSurfaceView(paramThemedReactContext);
  }

  public String getName()
  {
    return "ARTSurfaceView";
  }

  public Class<ARTSurfaceViewShadowNode> getShadowNodeClass()
  {
    return ARTSurfaceViewShadowNode.class;
  }

  public void setBackgroundColor(ARTSurfaceView paramARTSurfaceView, int paramInt)
  {
  }

  public void updateExtraData(ARTSurfaceView paramARTSurfaceView, Object paramObject)
  {
    paramARTSurfaceView.setSurfaceTextureListener((ARTSurfaceViewShadowNode)paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTSurfaceViewManager
 * JD-Core Version:    0.6.2
 */