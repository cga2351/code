package com.viber.voip.billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IabInventory
{
  Map<IabProductId, ProductDetails> mProductDetailsMap = new HashMap();
  Map<IabProductId, Purchase> mPurchaseMap = new HashMap();

  void addProductDetails(ProductDetails paramProductDetails)
  {
    this.mProductDetailsMap.put(paramProductDetails.getProductId(), paramProductDetails);
  }

  void addPurchase(Purchase paramPurchase)
  {
    this.mPurchaseMap.put(paramPurchase.getProductId(), paramPurchase);
  }

  public void erasePurchase(IabProductId paramIabProductId)
  {
    if (this.mPurchaseMap.containsKey(paramIabProductId))
      this.mPurchaseMap.remove(paramIabProductId);
  }

  public List<IabProductId> getAllOwnedProductIds()
  {
    return new ArrayList(this.mPurchaseMap.keySet());
  }

  public List<IabProductId> getAllOwnedProductIds(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPurchaseMap.values().iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      if (localPurchase.getItemType().equals(paramString))
        localArrayList.add(localPurchase.getProductId());
    }
    return localArrayList;
  }

  public List<ProductDetails> getAllProductDetails()
  {
    return new ArrayList(this.mProductDetailsMap.values());
  }

  public List<IabProductId> getAllProductIDs()
  {
    return new ArrayList(this.mProductDetailsMap.keySet());
  }

  public List<Purchase> getAllPurchases()
  {
    return new ArrayList(this.mPurchaseMap.values());
  }

  public ProductDetails getProductDetails(IabProductId paramIabProductId)
  {
    return (ProductDetails)this.mProductDetailsMap.get(paramIabProductId);
  }

  public Purchase getPurchase(IabProductId paramIabProductId)
  {
    return (Purchase)this.mPurchaseMap.get(paramIabProductId);
  }

  public boolean hasProductDetails(IabProductId paramIabProductId)
  {
    return this.mProductDetailsMap.containsKey(paramIabProductId);
  }

  public boolean hasPurchase(IabProductId paramIabProductId)
  {
    return this.mPurchaseMap.containsKey(paramIabProductId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.IabInventory
 * JD-Core Version:    0.6.2
 */