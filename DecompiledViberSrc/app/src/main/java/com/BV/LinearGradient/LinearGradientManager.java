package com.BV.LinearGradient;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class LinearGradientManager extends SimpleViewManager<b>
{
  public static final String PROP_BORDER_RADII = "borderRadii";
  public static final String PROP_COLORS = "colors";
  public static final String PROP_END_POS = "endPoint";
  public static final String PROP_LOCATIONS = "locations";
  public static final String PROP_START_POS = "startPoint";
  public static final String REACT_CLASS = "BVLinearGradient";

  protected b createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new b(paramThemedReactContext);
  }

  public String getName()
  {
    return "BVLinearGradient";
  }

  @ReactProp(name="borderRadii")
  public void setBorderRadii(b paramb, ReadableArray paramReadableArray)
  {
    paramb.setBorderRadii(paramReadableArray);
  }

  @ReactProp(name="colors")
  public void setColors(b paramb, ReadableArray paramReadableArray)
  {
    paramb.setColors(paramReadableArray);
  }

  @ReactProp(name="endPoint")
  public void setEndPosition(b paramb, ReadableArray paramReadableArray)
  {
    paramb.setEndPosition(paramReadableArray);
  }

  @ReactProp(name="locations")
  public void setLocations(b paramb, ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
      paramb.setLocations(paramReadableArray);
  }

  @ReactProp(name="startPoint")
  public void setStartPosition(b paramb, ReadableArray paramReadableArray)
  {
    paramb.setStartPosition(paramReadableArray);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.BV.LinearGradient.LinearGradientManager
 * JD-Core Version:    0.6.2
 */