package com.shopchat.library;

import com.shopchat.library.events.CategoryScroll;
import com.shopchat.library.events.ProductListScroll;
import com.shopchat.library.events.SwipeDirection;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.Category;
import com.shopchat.library.mvp.models.BrandModel.Highlight;
import com.shopchat.library.mvp.models.ColorModel;
import com.shopchat.library.mvp.models.ProductModel;
import com.shopchat.library.util.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  private com.shopchat.library.a.a a;

  private HashMap<String, String> a(ProductModel paramProductModel)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Product Brand Name", paramProductModel.getBrand().getName());
    localHashMap.put("Product ID", paramProductModel.getProductId());
    localHashMap.put("Product Image Url", paramProductModel.getImageUrlShort());
    localHashMap.put("Product Name", paramProductModel.getTitle());
    localHashMap.put("Product On Sale", String.valueOf(paramProductModel.isSale()));
    localHashMap.put("Product Price", String.valueOf(paramProductModel.getPrice()));
    localHashMap.put("Product Share Text", paramProductModel.getShareMsg());
    localHashMap.put("Product Short Url", paramProductModel.getImageUrlShort());
    localHashMap.put("Product Url", paramProductModel.getUrl());
    return localHashMap;
  }

  private HashMap<String, String> c(ProductModel paramProductModel, int paramInt)
  {
    HashMap localHashMap = a(paramProductModel);
    localHashMap.put("Product List Position", String.valueOf(paramInt));
    return localHashMap;
  }

  private HashMap<String, String> c(ProductModel paramProductModel, boolean paramBoolean)
  {
    HashMap localHashMap = a(paramProductModel);
    if (paramBoolean);
    BrandModel.Category localCategory;
    do
    {
      localHashMap.put("Category Name", "Recommended");
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return localHashMap;
        localIterator = paramProductModel.getBrand().getCategories().iterator();
      }
      localCategory = (BrandModel.Category)localIterator.next();
    }
    while (!localCategory.isSelected());
    localHashMap.put("Category Name", localCategory.getName());
    return localHashMap;
  }

  public void a()
  {
    a(e.o.a(), Collections.EMPTY_MAP);
  }

  public void a(com.shopchat.library.a.a parama)
  {
    this.a = parama;
  }

  public void a(CategoryScroll paramCategoryScroll)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("Category Brand Name", paramCategoryScroll.getBrandName());
    a(e.f.a(), localHashMap);
  }

  public void a(ProductListScroll paramProductListScroll)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Brand Name", paramProductListScroll.getBrandName());
    localHashMap.put("Category Name", paramProductListScroll.getCategoryName());
    a(e.d.a(), localHashMap);
  }

  public void a(BrandModel.Category paramCategory, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("Category Brand Name", paramCategory.getBrandName());
    localHashMap.put("Category Name", paramCategory.getName());
    localHashMap.put("Category Url", paramCategory.getFirstLinkHref());
    localHashMap.put("Category List Position", String.valueOf(paramInt));
    a(e.e.a(), localHashMap);
  }

  public void a(BrandModel paramBrandModel, int paramInt)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("Brand Name", paramBrandModel.getName());
    localHashMap.put("Position In List", paramInt + "");
    if (paramBrandModel.getHighlight().isVisible())
    {
      localHashMap.put("Highlight Shown", "true");
      localHashMap.put("Highlight Message", paramBrandModel.getHighlight().getMessage());
      localHashMap.put("Highlight Color", paramBrandModel.getHighlight().getColor().toString());
    }
    while (true)
    {
      a(e.a.a(), localHashMap);
      return;
      localHashMap.put("Highlight Shown", "false");
    }
  }

  public void a(ProductModel paramProductModel, int paramInt)
  {
    HashMap localHashMap = c(paramProductModel, paramInt);
    a(e.n.a(), localHashMap);
  }

  public void a(ProductModel paramProductModel, int paramInt, SwipeDirection paramSwipeDirection)
  {
    HashMap localHashMap = a(paramProductModel);
    localHashMap.put("Swiped List", "Brand Product List");
    switch (1.a[paramSwipeDirection.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      localHashMap.put("Product List Position", String.valueOf(paramInt));
      a(e.m.a(), localHashMap);
      return;
      localHashMap.put("Swipe Direction", "Next");
      continue;
      localHashMap.put("Swipe Direction", "Previous");
    }
  }

  public void a(ProductModel paramProductModel, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = c(paramProductModel, paramInt);
    if (paramBoolean)
      localHashMap.put("Category Name", "Recommended");
    while (true)
    {
      a(e.q.a(), localHashMap);
      return;
      Iterator localIterator = paramProductModel.getBrand().getCategories().iterator();
      if (localIterator.hasNext())
      {
        BrandModel.Category localCategory = (BrandModel.Category)localIterator.next();
        if (!localCategory.isSelected())
          break;
        localHashMap.put("Category Name", localCategory.getName());
      }
    }
  }

  public void a(ProductModel paramProductModel, boolean paramBoolean)
  {
    HashMap localHashMap = c(paramProductModel, paramBoolean);
    a(e.l.a(), localHashMap);
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    if (this.a != null)
      this.a.a(paramString, paramMap);
  }

  public void b()
  {
    a(e.b.a(), Collections.EMPTY_MAP);
  }

  public void b(ProductModel paramProductModel, int paramInt)
  {
    HashMap localHashMap = c(paramProductModel, paramInt);
    a(e.c.a(), localHashMap);
  }

  public void b(ProductModel paramProductModel, int paramInt, SwipeDirection paramSwipeDirection)
  {
    HashMap localHashMap = a(paramProductModel);
    localHashMap.put("Swiped List", "Recommended Product List");
    switch (1.a[paramSwipeDirection.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      localHashMap.put("Product List Position", paramInt + "");
      a(e.m.a(), localHashMap);
      return;
      localHashMap.put("Swipe Direction", "Next");
      continue;
      localHashMap.put("Swipe Direction", "Previous");
    }
  }

  public void b(ProductModel paramProductModel, boolean paramBoolean)
  {
    HashMap localHashMap = c(paramProductModel, paramBoolean);
    a(e.k.a(), localHashMap);
  }

  public void c()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Back From", "Brand Details");
    localHashMap.put("Back To", "Recommended Product Details");
    a(e.p.a(), localHashMap);
  }

  public void d()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Back From", "Brand Details");
    localHashMap.put("Back To", "Product Details");
    a(e.p.a(), localHashMap);
  }

  public void e()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Back From", "Product Details");
    localHashMap.put("Back To", "Brand Details");
    a(e.p.a(), localHashMap);
  }

  public void f()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Back From", "Recommended Product Details");
    localHashMap.put("Back To", "Brand List");
    a(e.p.a(), localHashMap);
  }

  public void g()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Back From", "Brand Details");
    localHashMap.put("Back To", "Brand List");
    a(e.p.a(), localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.a
 * JD-Core Version:    0.6.2
 */