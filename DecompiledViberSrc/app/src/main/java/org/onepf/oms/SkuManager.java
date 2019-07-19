package org.onepf.oms;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.onepf.oms.appstore.NokiaStore;
import org.onepf.oms.appstore.SamsungApps;

public class SkuManager
{
  private static final Logger L = ViberEnv.getLogger();
  private final Map<String, Map<String, String>> sku2storeSkuMappings = new ConcurrentHashMap();
  private final Map<String, Map<String, String>> storeSku2skuMappings = new ConcurrentHashMap();

  private static void checkSkuMappingParams(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      throw SkuMappingException.newInstance(2);
    if (TextUtils.isEmpty(paramString2))
      throw SkuMappingException.newInstance(3);
    if ("com.samsung.apps".equals(paramString1))
      SamsungApps.checkSku(paramString2);
    if ("com.nokia.nstore".equals(paramString1))
      NokiaStore.checkSku(paramString2);
  }

  private static void checkSkuMappingParams(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
      throw SkuMappingException.newInstance(1);
    checkSkuMappingParams(paramString2, paramString3);
  }

  public static SkuManager getInstance()
  {
    return InstanceHolder.SKU_MANAGER;
  }

  public List<String> getAllStoreSkus(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw SkuMappingException.newInstance(2);
    Map localMap = (Map)this.sku2storeSkuMappings.get(paramString);
    if (localMap == null)
      return null;
    return Collections.unmodifiableList(new ArrayList(localMap.values()));
  }

  public String getSku(String paramString1, String paramString2)
  {
    checkSkuMappingParams(paramString1, paramString2);
    Map localMap = (Map)this.storeSku2skuMappings.get(paramString1);
    if ((localMap != null) && (localMap.containsKey(paramString2)))
      return (String)localMap.get(paramString2);
    return paramString2;
  }

  public String getStoreSku(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      throw SkuMappingException.newInstance(2);
    if (TextUtils.isEmpty(paramString2))
      throw SkuMappingException.newInstance(1);
    Map localMap = (Map)this.sku2storeSkuMappings.get(paramString1);
    if ((localMap != null) && (localMap.containsKey(paramString2)))
      return (String)localMap.get(paramString2);
    return paramString2;
  }

  public SkuManager mapSku(String paramString1, String paramString2, String paramString3)
  {
    checkSkuMappingParams(paramString1, paramString2, paramString3);
    Map localMap = (Map)this.sku2storeSkuMappings.get(paramString2);
    HashMap localHashMap;
    if (localMap == null)
    {
      localHashMap = new HashMap();
      this.sku2storeSkuMappings.put(paramString2, localHashMap);
    }
    for (Object localObject1 = localHashMap; ; localObject1 = localMap)
    {
      Object localObject2 = (Map)this.storeSku2skuMappings.get(paramString2);
      if (localObject2 == null)
      {
        localObject2 = new HashMap();
        this.storeSku2skuMappings.put(paramString2, localObject2);
      }
      while (((Map)localObject2).get(paramString3) == null)
      {
        ((Map)localObject1).put(paramString1, paramString3);
        ((Map)localObject2).put(paramString3, paramString1);
        return this;
        if (!localMap.containsKey(paramString1))
          break;
        throw new SkuMappingException("Already specified SKU. sku: " + paramString1 + " -> storeSku: " + (String)localMap.get(paramString1));
      }
      throw new SkuMappingException("Ambiguous SKU mapping. You try to map sku: " + paramString1 + " -> storeSku: " + paramString3 + ", that is already mapped to sku: " + (String)((Map)localObject2).get(paramString3));
    }
  }

  public SkuManager mapSku(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null)
      throw new SkuMappingException("Store skus map can't be null.");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      mapSku(paramString, (String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return this;
  }

  private static final class InstanceHolder
  {
    static final SkuManager SKU_MANAGER = new SkuManager(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.SkuManager
 * JD-Core Version:    0.6.2
 */