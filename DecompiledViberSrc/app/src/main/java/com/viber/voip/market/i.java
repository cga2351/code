package com.viber.voip.market;

import com.viber.voip.billing.ProductId;
import java.util.List;

public abstract interface i
{
  public abstract List<MarketApi.UserProduct> a();

  public abstract void a(ProductId paramProductId, String paramString);

  public abstract boolean a(ProductId paramProductId);

  public abstract void b(ProductId paramProductId);

  public abstract MarketApi.k c(ProductId paramProductId);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.i
 * JD-Core Version:    0.6.2
 */