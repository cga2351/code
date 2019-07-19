package com.shopchat.library.events;

import com.shopchat.library.mvp.models.BrandModel.Category;

public class CategoryClickedEvent
{
  public final BrandModel.Category category;
  public final int position;

  public CategoryClickedEvent(BrandModel.Category paramCategory, int paramInt)
  {
    this.category = paramCategory;
    this.position = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.CategoryClickedEvent
 * JD-Core Version:    0.6.2
 */