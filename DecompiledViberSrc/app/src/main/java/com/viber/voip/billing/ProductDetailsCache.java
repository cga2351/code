package com.viber.voip.billing;

import android.os.SystemClock;
import java.util.HashMap;

public class ProductDetailsCache
{
  private static final long ENTRY_LIFE_TIME = 3600000L;
  private HashMap<IabProductId, a> mCache = new HashMap();

  private long getTime()
  {
    return SystemClock.elapsedRealtime();
  }

  public boolean contains(IabProductId paramIabProductId)
  {
    try
    {
      boolean bool = this.mCache.containsKey(paramIabProductId);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ProductDetails get(IabProductId paramIabProductId)
  {
    try
    {
      a locala = (a)this.mCache.get(paramIabProductId);
      if (locala != null)
      {
        if (getTime() - locala.b <= 3600000L)
          break label51;
        this.mCache.remove(paramIabProductId);
      }
      label51: for (ProductDetails localProductDetails = null; ; localProductDetails = locala.a)
        return localProductDetails;
    }
    finally
    {
    }
  }

  public void put(ProductDetails paramProductDetails)
  {
    try
    {
      a locala = new a(paramProductDetails, getTime());
      this.mCache.put(paramProductDetails.getProductId(), locala);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private class a
  {
    ProductDetails a;
    long b;

    a(ProductDetails paramLong, long arg3)
    {
      this.a = paramLong;
      Object localObject;
      this.b = localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ProductDetailsCache
 * JD-Core Version:    0.6.2
 */