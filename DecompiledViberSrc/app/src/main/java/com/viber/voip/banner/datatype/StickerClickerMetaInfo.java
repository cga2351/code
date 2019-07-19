package com.viber.voip.banner.datatype;

import com.google.d.a.c;

public final class StickerClickerMetaInfo
{

  @c(a="ads")
  private StickerClickerMetaInfoItem[] mItems;

  public StickerClickerMetaInfoItem getItem(int paramInt)
  {
    if ((this.mItems == null) || (paramInt >= this.mItems.length))
      return null;
    return this.mItems[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.StickerClickerMetaInfo
 * JD-Core Version:    0.6.2
 */