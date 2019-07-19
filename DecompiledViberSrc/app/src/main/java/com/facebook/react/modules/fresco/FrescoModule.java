package com.facebook.react.modules.fresco;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.util.HashSet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@ReactModule(name="FrescoModule", needsEagerInit=true)
public class FrescoModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener, ModuleDataCleaner.Cleanable
{
  public static final String NAME = "FrescoModule";
  private static boolean sHasBeenInitialized = false;
  private final boolean mClearOnDestroy;
  private ImagePipelineConfig mConfig;

  public FrescoModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, true, null);
  }

  public FrescoModule(ReactApplicationContext paramReactApplicationContext, boolean paramBoolean)
  {
    this(paramReactApplicationContext, paramBoolean, null);
  }

  public FrescoModule(ReactApplicationContext paramReactApplicationContext, boolean paramBoolean, ImagePipelineConfig paramImagePipelineConfig)
  {
    super(paramReactApplicationContext);
    this.mClearOnDestroy = paramBoolean;
    this.mConfig = paramImagePipelineConfig;
  }

  private static ImagePipelineConfig getDefaultConfig(ReactContext paramReactContext)
  {
    return getDefaultConfigBuilder(paramReactContext).build();
  }

  public static ImagePipelineConfig.Builder getDefaultConfigBuilder(ReactContext paramReactContext)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(new SystraceRequestListener());
    OkHttpClient localOkHttpClient = OkHttpClientProvider.createClient();
    ((CookieJarContainer)localOkHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(paramReactContext)));
    return OkHttpImagePipelineConfigFactory.newBuilder(paramReactContext.getApplicationContext(), localOkHttpClient).setNetworkFetcher(new ReactOkHttpNetworkFetcher(localOkHttpClient)).setDownsampleEnabled(false).setRequestListeners(localHashSet);
  }

  public static boolean hasBeenInitialized()
  {
    return sHasBeenInitialized;
  }

  public void clearSensitiveData()
  {
    Fresco.getImagePipeline().clearCaches();
  }

  public String getName()
  {
    return "FrescoModule";
  }

  public void initialize()
  {
    super.initialize();
    getReactApplicationContext().addLifecycleEventListener(this);
    if (!hasBeenInitialized())
    {
      if (this.mConfig == null)
        this.mConfig = getDefaultConfig(getReactApplicationContext());
      Fresco.initialize(getReactApplicationContext().getApplicationContext(), this.mConfig);
      sHasBeenInitialized = true;
    }
    while (true)
    {
      this.mConfig = null;
      return;
      if (this.mConfig != null)
        FLog.w("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
    }
  }

  public void onHostDestroy()
  {
    if ((hasBeenInitialized()) && (this.mClearOnDestroy))
      Fresco.getImagePipeline().clearMemoryCaches();
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.FrescoModule
 * JD-Core Version:    0.6.2
 */