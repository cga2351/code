package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name="I18nManager")
public class I18nManagerModule extends ContextBaseJavaModule
{
  public static final String NAME = "I18nManager";
  private final I18nUtil sharedI18nUtilInstance = I18nUtil.getInstance();

  public I18nManagerModule(Context paramContext)
  {
    super(paramContext);
  }

  @ReactMethod
  public void allowRTL(boolean paramBoolean)
  {
    this.sharedI18nUtilInstance.allowRTL(getContext(), paramBoolean);
  }

  @ReactMethod
  public void forceRTL(boolean paramBoolean)
  {
    this.sharedI18nUtilInstance.forceRTL(getContext(), paramBoolean);
  }

  public Map<String, Object> getConstants()
  {
    Context localContext = getContext();
    Locale localLocale = localContext.getResources().getConfiguration().locale;
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("isRTL", Boolean.valueOf(this.sharedI18nUtilInstance.isRTL(localContext)));
    localHashMap.put("doLeftAndRightSwapInRTL", Boolean.valueOf(this.sharedI18nUtilInstance.doLeftAndRightSwapInRTL(localContext)));
    localHashMap.put("localeIdentifier", localLocale.toString());
    return localHashMap;
  }

  public String getName()
  {
    return "I18nManager";
  }

  @ReactMethod
  public void swapLeftAndRightInRTL(boolean paramBoolean)
  {
    this.sharedI18nUtilInstance.swapLeftAndRightInRTL(getContext(), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.i18nmanager.I18nManagerModule
 * JD-Core Version:    0.6.2
 */