package com.viber.voip.vln;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.ViewManager;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.react.c;
import com.viber.voip.util.bx;
import com.viber.voip.vln.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class h
  implements ReactPackage, com.viber.voip.react.b, c, com.viber.voip.react.g<com.viber.voip.react.b>
{
  private static final Logger a = ViberEnv.getLogger();
  private ReactApplicationContext b;
  private final bx c;
  private final com.viber.voip.analytics.g d;
  private final String e;
  private final String f;
  private Set<com.viber.voip.react.b> g = new LinkedHashSet();

  h(bx parambx, com.viber.voip.analytics.g paramg, String paramString1, String paramString2)
  {
    this.c = parambx;
    this.d = paramg;
    this.e = paramString1;
    this.f = paramString2;
  }

  public void a()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.react.b)localIterator.next()).a();
  }

  public void a(com.viber.voip.react.b paramb)
  {
    this.g.add(paramb);
  }

  public void a(String paramString, WritableMap paramWritableMap)
  {
    if (this.b != null)
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.b.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
  }

  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.react.b)localIterator.next()).a(paramString1, paramString2);
  }

  public void b()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.react.b)localIterator.next()).b();
  }

  public void b(com.viber.voip.react.b paramb)
  {
    this.g.remove(paramb);
  }

  public String c()
  {
    com.viber.voip.react.b localb = null;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      localb = (com.viber.voip.react.b)localIterator.next();
    if (localb != null)
      return localb.c();
    return "";
  }

  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    this.b = paramReactApplicationContext;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ApplicationModule(paramReactApplicationContext, this.e, this.c, this));
    localArrayList.add(new AuthModule(paramReactApplicationContext, this.e, this.f));
    localArrayList.add(new SubscriptionsModule(paramReactApplicationContext));
    localArrayList.add(new AnalyticsModule(paramReactApplicationContext, this, new com.viber.voip.vln.a.b(this.d), new d(this.d)));
    return localArrayList;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.h
 * JD-Core Version:    0.6.2
 */