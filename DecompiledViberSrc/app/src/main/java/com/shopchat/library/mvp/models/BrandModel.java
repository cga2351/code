package com.shopchat.library.mvp.models;

import com.google.d.a.c;
import java.util.List;

public class BrandModel
{

  @c(a="backgroundColor")
  private ColorModel backgroundColor;
  BrandType brandType = BrandType.NORMAL;
  List<Category> categories;

  @c(a="display_order")
  int displayOrder;
  Highlight highlight;
  String id;

  @c(a="is_visible")
  boolean isVisible;
  String logo;
  String name;

  public ColorModel getBackgroundColor()
  {
    return this.backgroundColor;
  }

  public BrandType getBrandType()
  {
    return this.brandType;
  }

  public List<Category> getCategories()
  {
    return this.categories;
  }

  public int getDisplayOrder()
  {
    return this.displayOrder;
  }

  public Highlight getHighlight()
  {
    return this.highlight;
  }

  public String getId()
  {
    return this.id;
  }

  public String getLogo()
  {
    return this.logo;
  }

  public String getName()
  {
    return this.name;
  }

  public boolean isVisible()
  {
    return this.isVisible;
  }

  public void setBrandType(BrandType paramBrandType)
  {
    this.brandType = paramBrandType;
  }

  public void setCategories(List<Category> paramList)
  {
    this.categories = paramList;
  }

  public static enum BrandType
  {
    static
    {
      BrandType[] arrayOfBrandType = new BrandType[1];
      arrayOfBrandType[0] = NORMAL;
    }
  }

  public class Category
  {
    String brandName;
    String id;
    List<BrandModel.Link> links;
    String name;
    boolean selected = false;

    public Category()
    {
    }

    public String getBrandName()
    {
      return this.brandName;
    }

    public String getFirstLinkHref()
    {
      if ((this.links != null) && (!this.links.isEmpty()))
        return ((BrandModel.Link)this.links.get(0)).getHref();
      return null;
    }

    public String getId()
    {
      return this.id;
    }

    public List<BrandModel.Link> getLinks()
    {
      return this.links;
    }

    public String getName()
    {
      return this.name;
    }

    public boolean isSelected()
    {
      return this.selected;
    }

    public void setBrandName(String paramString)
    {
      this.brandName = paramString;
    }

    public void setSelected(boolean paramBoolean)
    {
      this.selected = paramBoolean;
    }
  }

  public class Highlight
  {
    ColorModel color;
    String message;
    boolean visible;

    public Highlight()
    {
    }

    public ColorModel getColor()
    {
      return this.color;
    }

    public String getMessage()
    {
      return this.message;
    }

    public boolean isVisible()
    {
      return this.visible;
    }

    public void setColor(ColorModel paramColorModel)
    {
      this.color = paramColorModel;
    }

    public void setMessage(String paramString)
    {
      this.message = paramString;
    }

    public void setVisible(boolean paramBoolean)
    {
      this.visible = paramBoolean;
    }
  }

  public class Link
  {
    String href;
    String rel;

    public Link()
    {
    }

    public String getHref()
    {
      return this.href;
    }

    public String getRel()
    {
      return this.rel;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.models.BrandModel
 * JD-Core Version:    0.6.2
 */