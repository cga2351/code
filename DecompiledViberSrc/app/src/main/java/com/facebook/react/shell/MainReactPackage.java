package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.LazyReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.location.LocationModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.toolbar.ReactToolbarManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import com.facebook.react.views.webview.ReactWebViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;

public class MainReactPackage extends LazyReactPackage
{
  private MainPackageConfig mConfig;

  public MainReactPackage()
  {
  }

  public MainReactPackage(MainPackageConfig paramMainPackageConfig)
  {
    this.mConfig = paramMainPackageConfig;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ARTRenderableViewManager.createARTGroupViewManager());
    localArrayList.add(ARTRenderableViewManager.createARTShapeViewManager());
    localArrayList.add(ARTRenderableViewManager.createARTTextViewManager());
    localArrayList.add(new ReactCheckBoxManager());
    localArrayList.add(new ReactDialogPickerManager());
    localArrayList.add(new ReactDrawerLayoutManager());
    localArrayList.add(new ReactDropdownPickerManager());
    localArrayList.add(new ReactHorizontalScrollViewManager());
    localArrayList.add(new ReactHorizontalScrollContainerViewManager());
    localArrayList.add(new ReactProgressBarViewManager());
    localArrayList.add(new ReactScrollViewManager());
    localArrayList.add(new ReactSliderManager());
    localArrayList.add(new ReactSwitchManager());
    localArrayList.add(new ReactToolbarManager());
    localArrayList.add(new ReactWebViewManager());
    localArrayList.add(new SwipeRefreshLayoutManager());
    localArrayList.add(new ARTSurfaceViewManager());
    localArrayList.add(new FrescoBasedReactTextInlineImageViewManager());
    localArrayList.add(new ReactImageManager());
    localArrayList.add(new ReactModalHostManager());
    localArrayList.add(new ReactRawTextManager());
    localArrayList.add(new ReactTextInputManager());
    localArrayList.add(new ReactTextViewManager());
    localArrayList.add(new ReactViewManager());
    localArrayList.add(new ReactViewPagerManager());
    localArrayList.add(new ReactVirtualTextViewManager());
    return localArrayList;
  }

  public List<ModuleSpec> getNativeModules(final ReactApplicationContext paramReactApplicationContext)
  {
    ModuleSpec[] arrayOfModuleSpec = new ModuleSpec[26];
    arrayOfModuleSpec[0] = ModuleSpec.nativeModuleSpec(AccessibilityInfoModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new AccessibilityInfoModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[1] = ModuleSpec.nativeModuleSpec(AppStateModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new AppStateModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[2] = ModuleSpec.nativeModuleSpec(BlobModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new BlobModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[3] = ModuleSpec.nativeModuleSpec(FileReaderModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new FileReaderModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[4] = ModuleSpec.nativeModuleSpec(AsyncStorageModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new AsyncStorageModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[5] = ModuleSpec.nativeModuleSpec(CameraRollManager.class, new Provider()
    {
      public NativeModule get()
      {
        return new CameraRollManager(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[6] = ModuleSpec.nativeModuleSpec(ClipboardModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ClipboardModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[7] = ModuleSpec.nativeModuleSpec(DatePickerDialogModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new DatePickerDialogModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[8] = ModuleSpec.nativeModuleSpec(DialogModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new DialogModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[9] = ModuleSpec.nativeModuleSpec(FrescoModule.class, new Provider()
    {
      public NativeModule get()
      {
        ReactApplicationContext localReactApplicationContext = paramReactApplicationContext;
        if (MainReactPackage.this.mConfig != null);
        for (ImagePipelineConfig localImagePipelineConfig = MainReactPackage.this.mConfig.getFrescoConfig(); ; localImagePipelineConfig = null)
          return new FrescoModule(localReactApplicationContext, true, localImagePipelineConfig);
      }
    });
    arrayOfModuleSpec[10] = ModuleSpec.nativeModuleSpec(I18nManagerModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new I18nManagerModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[11] = ModuleSpec.nativeModuleSpec(ImageEditingManager.class, new Provider()
    {
      public NativeModule get()
      {
        return new ImageEditingManager(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[12] = ModuleSpec.nativeModuleSpec(ImageLoaderModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ImageLoaderModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[13] = ModuleSpec.nativeModuleSpec(ImageStoreManager.class, new Provider()
    {
      public NativeModule get()
      {
        return new ImageStoreManager(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[14] = ModuleSpec.nativeModuleSpec(IntentModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new IntentModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[15] = ModuleSpec.nativeModuleSpec(LocationModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new LocationModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[16] = ModuleSpec.nativeModuleSpec(NativeAnimatedModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new NativeAnimatedModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[17] = ModuleSpec.nativeModuleSpec(NetworkingModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new NetworkingModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[18] = ModuleSpec.nativeModuleSpec(NetInfoModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new NetInfoModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[19] = ModuleSpec.nativeModuleSpec(PermissionsModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new PermissionsModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[20] = ModuleSpec.nativeModuleSpec(ShareModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ShareModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[21] = ModuleSpec.nativeModuleSpec(StatusBarModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new StatusBarModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[22] = ModuleSpec.nativeModuleSpec(TimePickerDialogModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new TimePickerDialogModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[23] = ModuleSpec.nativeModuleSpec(ToastModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ToastModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[24] = ModuleSpec.nativeModuleSpec(VibrationModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new VibrationModule(paramReactApplicationContext);
      }
    });
    arrayOfModuleSpec[25] = ModuleSpec.nativeModuleSpec(WebSocketModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new WebSocketModule(paramReactApplicationContext);
      }
    });
    return Arrays.asList(arrayOfModuleSpec);
  }

  public ReactModuleInfoProvider getReactModuleInfoProvider()
  {
    return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.shell.MainReactPackage
 * JD-Core Version:    0.6.2
 */