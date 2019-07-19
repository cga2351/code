package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.MoPubErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AdapterConfigurationManager
  implements a
{
  private volatile Map<String, AdapterConfiguration> a;
  private SdkInitializationListener b;

  AdapterConfigurationManager(SdkInitializationListener paramSdkInitializationListener)
  {
    this.b = paramSdkInitializationListener;
  }

  private JSONObject b(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    Map localMap = this.a;
    if ((localMap == null) || (localMap.isEmpty()))
    {
      localObject1 = null;
      return localObject1;
    }
    Iterator localIterator = localMap.values().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      AdapterConfiguration localAdapterConfiguration = (AdapterConfiguration)localIterator.next();
      try
      {
        String str = localAdapterConfiguration.getBiddingToken(paramContext);
        if (TextUtils.isEmpty(str))
          continue;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        if (localObject1 == null)
          localObject1 = new JSONObject();
        ((JSONObject)localObject1).put(localAdapterConfiguration.getMoPubNetworkName(), localJSONObject);
        localObject2 = localObject1;
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.ERROR;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = ("JSON parsing failed for MoPub network name: " + localAdapterConfiguration.getMoPubNetworkName());
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
          Object localObject2 = localObject1;
        }
      }
    }
  }

  String a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    JSONObject localJSONObject = b(paramContext);
    if (localJSONObject == null)
      return null;
    return localJSONObject.toString();
  }

  public List<String> getAdapterConfigurationInfo()
  {
    Map localMap = this.a;
    if ((localMap == null) || (localMap.isEmpty()))
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      String str = (String)localEntry.getKey();
      localStringBuilder.append(str.substring(1 + str.lastIndexOf(".")));
      localStringBuilder.append(": Adapter version ");
      localStringBuilder.append(((AdapterConfiguration)localEntry.getValue()).getAdapterVersion());
      localStringBuilder.append(", SDK version ");
      localStringBuilder.append(((AdapterConfiguration)localEntry.getValue()).getNetworkSdkVersion());
      localArrayList.add(localStringBuilder.toString());
    }
    return localArrayList;
  }

  public List<String> getAdvancedBidderNames()
  {
    Map localMap = this.a;
    if ((localMap == null) || (localMap.isEmpty()))
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.values().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((AdapterConfiguration)localIterator.next()).getMoPubNetworkName());
    return localArrayList;
  }

  public void initialize(Context paramContext, Set<String> paramSet, Map<String, Map<String, String>> paramMap1, Map<String, Map<String, String>> paramMap2)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramSet);
    Preconditions.checkNotNull(paramMap1);
    Preconditions.checkNotNull(paramMap2);
    AsyncTasks.safeExecuteOnExecutor(new a(paramContext.getApplicationContext(), paramSet, paramMap1, paramMap2, this), new Void[0]);
  }

  public void onAdapterConfigurationsInitialized(Map<String, AdapterConfiguration> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    this.a = paramMap;
    SdkInitializationListener localSdkInitializationListener = this.b;
    if (localSdkInitializationListener != null)
    {
      localSdkInitializationListener.onInitializationFinished();
      this.b = null;
    }
  }

  public void onNetworkInitializationFinished(Class<? extends AdapterConfiguration> paramClass, MoPubErrorCode paramMoPubErrorCode)
  {
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramMoPubErrorCode);
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = (paramClass + " initialized with error code " + paramMoPubErrorCode);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
  }

  private static class a extends AsyncTask<Void, Void, Map<String, AdapterConfiguration>>
  {
    private final WeakReference<Context> a;
    private final Set<String> b;
    private final Map<String, Map<String, String>> c;
    private final Map<String, Map<String, String>> d;
    private final a e;

    a(Context paramContext, Set<String> paramSet, Map<String, Map<String, String>> paramMap1, Map<String, Map<String, String>> paramMap2, a parama)
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramSet);
      Preconditions.checkNotNull(paramMap1);
      Preconditions.checkNotNull(paramMap2);
      Preconditions.checkNotNull(parama);
      this.a = new WeakReference(paramContext);
      this.b = paramSet;
      this.c = paramMap1;
      this.d = paramMap2;
      this.e = parama;
    }

    protected Map<String, AdapterConfiguration> a(Void[] paramArrayOfVoid)
    {
      HashMap localHashMap1 = new HashMap();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdapterConfiguration localAdapterConfiguration;
        Context localContext;
        try
        {
          localAdapterConfiguration = (AdapterConfiguration)Reflection.instantiateClassWithEmptyConstructor(str, AdapterConfiguration.class);
          localContext = (Context)this.a.get();
          if (localContext != null)
            break label165;
          MoPubLog.SdkLogEvent localSdkLogEvent3 = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = ("Context null. Unable to initialize adapter configuration " + str);
          MoPubLog.log(localSdkLogEvent3, arrayOfObject4);
        }
        catch (Exception localException)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = ("Unable to find class " + str);
          arrayOfObject1[1] = localException;
          MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
        }
        continue;
        label165: Map localMap1 = (Map)this.c.get(str);
        HashMap localHashMap2 = new HashMap(localAdapterConfiguration.getCachedInitializationParameters(localContext));
        if (localMap1 != null)
        {
          localHashMap2.putAll(localMap1);
          localAdapterConfiguration.setCachedInitializationParameters(localContext, localHashMap2);
        }
        Map localMap2 = (Map)this.d.get(str);
        if (localMap2 != null)
          localAdapterConfiguration.setMoPubRequestOptions(localMap2);
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        Locale localLocale = Locale.US;
        Object[] arrayOfObject3 = new Object[4];
        arrayOfObject3[0] = str;
        arrayOfObject3[1] = localAdapterConfiguration.getAdapterVersion();
        arrayOfObject3[2] = localAdapterConfiguration.getNetworkSdkVersion();
        arrayOfObject3[3] = localHashMap2;
        arrayOfObject2[0] = String.format(localLocale, "Initializing %s version %s with network sdk version %s and with params %s", arrayOfObject3);
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
        localAdapterConfiguration.initializeNetwork(localContext, localHashMap2, this.e);
        localHashMap1.put(str, localAdapterConfiguration);
      }
      return localHashMap1;
    }

    protected void a(Map<String, AdapterConfiguration> paramMap)
    {
      this.e.onAdapterConfigurationsInitialized(paramMap);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.AdapterConfigurationManager
 * JD-Core Version:    0.6.2
 */