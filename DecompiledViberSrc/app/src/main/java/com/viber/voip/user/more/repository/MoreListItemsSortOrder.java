package com.viber.voip.user.more.repository;

import com.viber.voip.settings.a.a;
import java.util.Comparator;

public class MoreListItemsSortOrder
{
  private Comparator<a> mComparator;
  private final String mMoreScreenProductsOrder;

  public MoreListItemsSortOrder(String paramString)
  {
    this.mMoreScreenProductsOrder = paramString;
  }

  private Comparator<a> createOriginalOrder()
  {
    return MoreListItemsSortOrder..Lambda.0.$instance;
  }

  private Comparator<a> createVariant2Order()
  {
    return MoreListItemsSortOrder..Lambda.1.$instance;
  }

  private Comparator<a> createVariant3Order()
  {
    return MoreListItemsSortOrder..Lambda.2.$instance;
  }

  Comparator<a> getComparator()
  {
    String str;
    int i;
    if (this.mComparator == null)
    {
      str = this.mMoreScreenProductsOrder;
      i = -1;
      switch (str.hashCode())
      {
      default:
        switch (i)
        {
        default:
          this.mComparator = createOriginalOrder();
        case 0:
        case 1:
        }
        break;
      case -1184930707:
      case -1184930706:
      }
    }
    while (true)
    {
      return this.mComparator;
      if (!str.equals("Variant2"))
        break;
      i = 0;
      break;
      if (!str.equals("Variant3"))
        break;
      i = 1;
      break;
      this.mComparator = createVariant2Order();
      continue;
      this.mComparator = createVariant3Order();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.repository.MoreListItemsSortOrder
 * JD-Core Version:    0.6.2
 */