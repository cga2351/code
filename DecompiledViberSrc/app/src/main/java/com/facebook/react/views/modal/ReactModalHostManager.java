package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Map;

@ReactModule(name="RCTModalHostView")
public class ReactModalHostManager extends ViewGroupManager<ReactModalHostView>
{
  public static final String REACT_CLASS = "RCTModalHostView";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, final ReactModalHostView paramReactModalHostView)
  {
    final EventDispatcher localEventDispatcher = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    paramReactModalHostView.setOnRequestCloseListener(new ReactModalHostView.OnRequestCloseListener()
    {
      public void onRequestClose(DialogInterface paramAnonymousDialogInterface)
      {
        localEventDispatcher.dispatchEvent(new RequestCloseEvent(paramReactModalHostView.getId()));
      }
    });
    paramReactModalHostView.setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        localEventDispatcher.dispatchEvent(new ShowEvent(paramReactModalHostView.getId()));
      }
    });
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ModalHostShadowNode();
  }

  protected ReactModalHostView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactModalHostView(paramThemedReactContext);
  }

  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topRequestClose", MapBuilder.of("registrationName", "onRequestClose")).put("topShow", MapBuilder.of("registrationName", "onShow")).build();
  }

  public String getName()
  {
    return "RCTModalHostView";
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return ModalHostShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ReactModalHostView paramReactModalHostView)
  {
    super.onAfterUpdateTransaction(paramReactModalHostView);
    paramReactModalHostView.showOrUpdate();
  }

  public void onDropViewInstance(ReactModalHostView paramReactModalHostView)
  {
    super.onDropViewInstance(paramReactModalHostView);
    paramReactModalHostView.onDropInstance();
  }

  @ReactProp(name="animationType")
  public void setAnimationType(ReactModalHostView paramReactModalHostView, String paramString)
  {
    paramReactModalHostView.setAnimationType(paramString);
  }

  @ReactProp(name="hardwareAccelerated")
  public void setHardwareAccelerated(ReactModalHostView paramReactModalHostView, boolean paramBoolean)
  {
    paramReactModalHostView.setHardwareAccelerated(paramBoolean);
  }

  @ReactProp(name="transparent")
  public void setTransparent(ReactModalHostView paramReactModalHostView, boolean paramBoolean)
  {
    paramReactModalHostView.setTransparent(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ReactModalHostManager
 * JD-Core Version:    0.6.2
 */