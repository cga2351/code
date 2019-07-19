package com.facebook.react.views.switchview;

import android.view.View.MeasureSpec;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch>
{
  private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      ((UIManagerModule)((ReactContext)paramAnonymousCompoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSwitchEvent(paramAnonymousCompoundButton.getId(), paramAnonymousBoolean));
    }
  };
  public static final String REACT_CLASS = "AndroidSwitch";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactSwitch paramReactSwitch)
  {
    paramReactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ReactSwitchShadowNode(null);
  }

  protected ReactSwitch createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    ReactSwitch localReactSwitch = new ReactSwitch(paramThemedReactContext);
    localReactSwitch.setShowText(false);
    return localReactSwitch;
  }

  public String getName()
  {
    return "AndroidSwitch";
  }

  public Class getShadowNodeClass()
  {
    return ReactSwitchShadowNode.class;
  }

  @ReactProp(defaultBoolean=false, name="disabled")
  public void setDisabled(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactSwitch.setEnabled(bool);
      return;
    }
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    paramReactSwitch.setEnabled(paramBoolean);
  }

  @ReactProp(name="on")
  public void setOn(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    setValue(paramReactSwitch, paramBoolean);
  }

  @ReactProp(customType="Color", name="thumbColor")
  public void setThumbColor(ReactSwitch paramReactSwitch, @Nullable Integer paramInteger)
  {
    paramReactSwitch.setThumbColor(paramInteger);
  }

  @ReactProp(customType="Color", name="thumbTintColor")
  public void setThumbTintColor(ReactSwitch paramReactSwitch, @Nullable Integer paramInteger)
  {
    setThumbColor(paramReactSwitch, paramInteger);
  }

  @ReactProp(customType="Color", name="trackColorForFalse")
  public void setTrackColorForFalse(ReactSwitch paramReactSwitch, @Nullable Integer paramInteger)
  {
    paramReactSwitch.setTrackColorForFalse(paramInteger);
  }

  @ReactProp(customType="Color", name="trackColorForTrue")
  public void setTrackColorForTrue(ReactSwitch paramReactSwitch, @Nullable Integer paramInteger)
  {
    paramReactSwitch.setTrackColorForTrue(paramInteger);
  }

  @ReactProp(customType="Color", name="trackTintColor")
  public void setTrackTintColor(ReactSwitch paramReactSwitch, @Nullable Integer paramInteger)
  {
    paramReactSwitch.setTrackColor(paramInteger);
  }

  @ReactProp(name="value")
  public void setValue(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    paramReactSwitch.setOnCheckedChangeListener(null);
    paramReactSwitch.setOn(paramBoolean);
    paramReactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  static class ReactSwitchShadowNode extends LayoutShadowNode
    implements YogaMeasureFunction
  {
    private int mHeight;
    private boolean mMeasured;
    private int mWidth;

    private ReactSwitchShadowNode()
    {
      initMeasureFunction();
    }

    private void initMeasureFunction()
    {
      setMeasureFunction(this);
    }

    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      if (!this.mMeasured)
      {
        ReactSwitch localReactSwitch = new ReactSwitch(getThemedContext());
        localReactSwitch.setShowText(false);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        localReactSwitch.measure(i, i);
        this.mWidth = localReactSwitch.getMeasuredWidth();
        this.mHeight = localReactSwitch.getMeasuredHeight();
        this.mMeasured = true;
      }
      return YogaMeasureOutput.make(this.mWidth, this.mHeight);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.switchview.ReactSwitchManager
 * JD-Core Version:    0.6.2
 */