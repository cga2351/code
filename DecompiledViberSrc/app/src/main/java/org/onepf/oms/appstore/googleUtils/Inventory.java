package org.onepf.oms.appstore.googleUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory
{
  private final Map<String, Purchase> mPurchaseMap = new ConcurrentHashMap();
  private final Map<String, SkuDetails> mSkuMap = new ConcurrentHashMap();

  public void addInventory(Inventory paramInventory)
  {
    if (paramInventory == null)
      return;
    this.mSkuMap.putAll(paramInventory.getSkuMap());
    this.mPurchaseMap.putAll(paramInventory.getPurchaseMap());
  }

  public void addPurchase(Purchase paramPurchase)
  {
    this.mPurchaseMap.put(paramPurchase.getSku(), paramPurchase);
  }

  public void addSkuDetails(SkuDetails paramSkuDetails)
  {
    this.mSkuMap.put(paramSkuDetails.getSku(), paramSkuDetails);
  }

  public void erasePurchase(String paramString)
  {
    if (this.mPurchaseMap.containsKey(paramString))
      this.mPurchaseMap.remove(paramString);
  }

  public List<String> getAllOwnedSkus()
  {
    return new ArrayList(this.mPurchaseMap.keySet());
  }

  public List<String> getAllOwnedSkus(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPurchaseMap.values().iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      if (localPurchase.getItemType().equals(paramString))
        localArrayList.add(localPurchase.getSku());
    }
    return localArrayList;
  }

  public List<Purchase> getAllPurchases()
  {
    return new ArrayList(this.mPurchaseMap.values());
  }

  public Purchase getPurchase(String paramString)
  {
    return (Purchase)this.mPurchaseMap.get(paramString);
  }

  public Map<String, Purchase> getPurchaseMap()
  {
    return Collections.unmodifiableMap(this.mPurchaseMap);
  }

  public SkuDetails getSkuDetails(String paramString)
  {
    return (SkuDetails)this.mSkuMap.get(paramString);
  }

  public Map<String, SkuDetails> getSkuMap()
  {
    return Collections.unmodifiableMap(this.mSkuMap);
  }

  public boolean hasDetails(String paramString)
  {
    return this.mSkuMap.containsKey(paramString);
  }

  public boolean hasPurchase(String paramString)
  {
    return this.mPurchaseMap.containsKey(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.Inventory
 * JD-Core Version:    0.6.2
 */