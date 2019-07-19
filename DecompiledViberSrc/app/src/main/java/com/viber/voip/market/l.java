package com.viber.voip.market;

import com.viber.voip.billing.ProductCategory;
import com.viber.voip.billing.ProductId;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.i.a;
import com.viber.voip.util.upload.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
  implements i
{
  private com.viber.voip.stickers.i a;
  private MarketApi b;

  public l(MarketApi paramMarketApi)
  {
    this.b = paramMarketApi;
    this.a = com.viber.voip.stickers.i.a();
  }

  private MarketApi.k a(ProductId paramProductId, a parama)
  {
    int i = paramProductId.getPackageId();
    if (this.a.i(i))
      return MarketApi.k.d;
    if (this.a.j(i))
    {
      this.a.n(i);
      return MarketApi.k.c;
    }
    if ((parama != null) && (!parama.h()))
      return MarketApi.k.e;
    return MarketApi.k.b;
  }

  public List<MarketApi.UserProduct> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.t().iterator();
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      ProductId localProductId = ProductId.fromStickerPackageId(locala.e());
      MarketApi.k localk = a(localProductId, locala);
      Object localObject;
      switch (1.a[localk.ordinal()])
      {
      default:
        localObject = null;
      case 1:
      case 2:
      case 3:
      }
      while (localObject != null)
      {
        localArrayList.add(localObject);
        break;
        if (locala.c())
        {
          localObject = new MarketApi.UserProduct(localProductId, localk);
        }
        else
        {
          localObject = new MarketApi.UserProduct(localProductId, localk, "hidden");
          continue;
          localObject = new MarketApi.UserProduct(localProductId, localk);
        }
      }
    }
    return localArrayList;
  }

  public void a(ProductId paramProductId, String paramString)
  {
    int i = paramProductId.getPackageId();
    if ((!this.a.k(i)) && (!this.a.j(i)) && (!this.a.i(i)) && (o.b(true)) && (o.a(true)))
      this.a.a(i, paramString, i.a.b);
  }

  public boolean a(ProductId paramProductId)
  {
    return paramProductId.getCategory() == ProductCategory.STICKER_PACKAGE;
  }

  public void b(ProductId paramProductId)
  {
    this.a.o(paramProductId.getPackageId());
  }

  public MarketApi.k c(ProductId paramProductId)
  {
    int i = paramProductId.getPackageId();
    return a(paramProductId, this.a.g(i));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.l
 * JD-Core Version:    0.6.2
 */