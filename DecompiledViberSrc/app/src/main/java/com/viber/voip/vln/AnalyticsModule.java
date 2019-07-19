package com.viber.voip.vln;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.viber.voip.react.b;
import com.viber.voip.vln.a.a;
import com.viber.voip.vln.a.c;

public class AnalyticsModule extends ReactContextBaseJavaModule
{
  private static final String MODULE_NAME = "Analytics";
  private final a mBrazeDelegate;
  private final c mMixpanelDelegate;
  private final b mReactCallback;

  public AnalyticsModule(ReactApplicationContext paramReactApplicationContext, b paramb, a parama, c paramc)
  {
    super(paramReactApplicationContext);
    this.mReactCallback = paramb;
    this.mBrazeDelegate = parama;
    this.mMixpanelDelegate = paramc;
  }

  @ReactMethod
  public void addToArrayCustomUserAttribute(String paramString1, String paramString2, Promise paramPromise)
  {
    this.mBrazeDelegate.b(paramString1, paramString2, paramPromise);
  }

  @ReactMethod
  public void appendPeopleProperties(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.c(paramReadableMap, paramPromise);
  }

  public String getName()
  {
    return "Analytics";
  }

  @ReactMethod
  public void incrementPeopleProperty(String paramString, Integer paramInteger, Promise paramPromise)
  {
    this.mMixpanelDelegate.a(paramString, paramInteger, paramPromise);
  }

  @ReactMethod
  public void logCustomEvent(String paramString, ReadableMap paramReadableMap1, ReadableMap paramReadableMap2, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString, paramReadableMap1, paramReadableMap2, paramPromise);
  }

  @ReactMethod
  public void registerSuperProperties(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.f(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void registerSuperPropertiesOnce(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.g(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void removePeopleProperties(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.d(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void sendCDR(String paramString1, String paramString2)
  {
    this.mReactCallback.a(paramString1, paramString2);
  }

  @ReactMethod
  public void setArrayCustomUserAttribute(String paramString, ReadableArray paramReadableArray, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString, paramReadableArray, paramPromise);
  }

  @ReactMethod
  public void setBoolCustomUserAttribute(String paramString, Boolean paramBoolean, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString, paramBoolean, paramPromise);
  }

  @ReactMethod
  public void setDoubleCustomUserAttribute(String paramString, Double paramDouble, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString, paramDouble, paramPromise);
  }

  @ReactMethod
  public void setIntCustomUserAttribute(String paramString, Integer paramInteger, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString, paramInteger, paramPromise);
  }

  @ReactMethod
  public void setPeopleProperties(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.a(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void setPeoplePropertiesOnce(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.b(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void setStringCustomUserAttribute(String paramString1, String paramString2, Promise paramPromise)
  {
    this.mBrazeDelegate.a(paramString1, paramString2, paramPromise);
  }

  @ReactMethod
  public void timeEvent(String paramString, Promise paramPromise)
  {
    this.mMixpanelDelegate.a(paramString, paramPromise);
  }

  @ReactMethod
  public void track(String paramString, ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.a(paramString, paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void unionPeopleProperties(ReadableMap paramReadableMap, Promise paramPromise)
  {
    this.mMixpanelDelegate.e(paramReadableMap, paramPromise);
  }

  @ReactMethod
  public void unregisterSuperProperty(String paramString, Promise paramPromise)
  {
    this.mMixpanelDelegate.b(paramString, paramPromise);
  }

  @ReactMethod
  public void unsetPeopleProperties(ReadableArray paramReadableArray, Promise paramPromise)
  {
    this.mMixpanelDelegate.a(paramReadableArray, paramPromise);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.AnalyticsModule
 * JD-Core Version:    0.6.2
 */