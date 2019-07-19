package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;
import java.util.List;

public class RecommendedProductClicked
{
  public final List<ProductModel> items;
  public final int position;

  public RecommendedProductClicked(List<ProductModel> paramList, int paramInt)
  {
    this.items = paramList;
    this.position = paramInt;
  }

  public List<ProductModel> getFullList()
  {
    return this.items;
  }

  public int getPosition()
  {
    return this.position;
  }

  public ProductModel getProductModel()
  {
    return (ProductModel)this.items.get(this.position);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.RecommendedProductClicked
 * JD-Core Version:    0.6.2
 */