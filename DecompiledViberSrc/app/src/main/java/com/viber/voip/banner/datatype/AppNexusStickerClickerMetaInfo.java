package com.viber.voip.banner.datatype;

import android.text.TextUtils;
import com.google.d.a.c;

public final class AppNexusStickerClickerMetaInfo
{

  @c(a="click_trackers")
  private String[] clickUrls;

  @c(a="impression_trackers")
  private String[] impressionUrls;

  @c(a="click_url")
  private String mClickerUrl;

  @c(a="main_media")
  private MainMedia[] mMainMedia;

  public StickerClickerMetaInfoItem getItem()
  {
    StickerClickerMetaInfoItem localStickerClickerMetaInfoItem = new StickerClickerMetaInfoItem();
    if ((this.mMainMedia != null) && (!TextUtils.isEmpty(this.mMainMedia[0].mClickerImageUrl)))
      localStickerClickerMetaInfoItem.setClickerImageUrl(this.mMainMedia[0].mClickerImageUrl);
    localStickerClickerMetaInfoItem.setClickerUrl(this.mClickerUrl);
    localStickerClickerMetaInfoItem.setImpressionUrls(this.impressionUrls);
    localStickerClickerMetaInfoItem.setClickUrls(this.clickUrls);
    localStickerClickerMetaInfoItem.setAdType("story");
    localStickerClickerMetaInfoItem.setTtl(Long.valueOf(120L));
    localStickerClickerMetaInfoItem.setId("");
    localStickerClickerMetaInfoItem.setUuid("");
    return localStickerClickerMetaInfoItem;
  }

  private static final class MainMedia
  {

    @c(a="url")
    private String mClickerImageUrl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.AppNexusStickerClickerMetaInfo
 * JD-Core Version:    0.6.2
 */