package com.facebook.react.views.checkbox;

import android.content.Context;
import android.support.v7.widget.TintContextWrapper;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;

public class ReactCheckBoxManager extends SimpleViewManager<ReactCheckBox>
{
  private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener()
  {
    private ReactContext getReactContext(CompoundButton paramAnonymousCompoundButton)
    {
      Context localContext = paramAnonymousCompoundButton.getContext();
      if ((localContext instanceof TintContextWrapper))
        return (ReactContext)((TintContextWrapper)localContext).getBaseContext();
      return (ReactContext)paramAnonymousCompoundButton.getContext();
    }

    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      ((UIManagerModule)getReactContext(paramAnonymousCompoundButton).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactCheckBoxEvent(paramAnonymousCompoundButton.getId(), paramAnonymousBoolean));
    }
  };
  private static final String REACT_CLASS = "AndroidCheckBox";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactCheckBox paramReactCheckBox)
  {
    paramReactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  protected ReactCheckBox createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactCheckBox(paramThemedReactContext);
  }

  public String getName()
  {
    return "AndroidCheckBox";
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactCheckBox paramReactCheckBox, boolean paramBoolean)
  {
    paramReactCheckBox.setEnabled(paramBoolean);
  }

  @ReactProp(name="on")
  public void setOn(ReactCheckBox paramReactCheckBox, boolean paramBoolean)
  {
    paramReactCheckBox.setOnCheckedChangeListener(null);
    paramReactCheckBox.setOn(paramBoolean);
    paramReactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.checkbox.ReactCheckBoxManager
 * JD-Core Version:    0.6.2
 */