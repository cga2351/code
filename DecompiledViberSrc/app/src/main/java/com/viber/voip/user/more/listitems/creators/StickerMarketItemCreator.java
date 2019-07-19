package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.user.more.listitems.providers.StickerPackagesCountProvider;
import com.viber.voip.user.more.listitems.providers.StickerPackagesTextProvider;

public class StickerMarketItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final StickerPackagesCountProvider mStickerPackagesCountProvider;
  private final StickerPackagesTextProvider mStickerPackagesTextProvider;

  public StickerMarketItemCreator(Context paramContext, StickerPackagesCountProvider paramStickerPackagesCountProvider, StickerPackagesTextProvider paramStickerPackagesTextProvider)
  {
    this.mContext = paramContext;
    this.mStickerPackagesCountProvider = paramStickerPackagesCountProvider;
    this.mStickerPackagesTextProvider = paramStickerPackagesTextProvider;
  }

  public a create()
  {
    return new a.b(this.mContext, R.id.market).a(R.string.more_sticker_market).b(this.mStickerPackagesTextProvider).c(R.drawable.more_sticker_market_icon).c(this.mStickerPackagesCountProvider).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.StickerMarketItemCreator
 * JD-Core Version:    0.6.2
 */