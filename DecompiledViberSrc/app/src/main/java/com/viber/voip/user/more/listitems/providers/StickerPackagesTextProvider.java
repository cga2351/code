package com.viber.voip.user.more.listitems.providers;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a.d;
import com.viber.voip.user.more.MoreStickerMarketSubTextState;

public class StickerPackagesTextProvider
  implements a.d
{
  private final Context mContext;
  private final MoreStickerMarketSubTextState mMoreStickerMarketSubTextState;

  public StickerPackagesTextProvider(Context paramContext, MoreStickerMarketSubTextState paramMoreStickerMarketSubTextState)
  {
    this.mContext = paramContext;
    this.mMoreStickerMarketSubTextState = paramMoreStickerMarketSubTextState;
  }

  public CharSequence getText()
  {
    switch (this.mMoreStickerMarketSubTextState.getState())
    {
    default:
      return null;
    case 1:
      return this.mContext.getString(R.string.more_sticker_market_add_fun_text);
    case 2:
    }
    return this.mContext.getString(R.string.more_sticker_market_checkout_new_stickers_text);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.providers.StickerPackagesTextProvider
 * JD-Core Version:    0.6.2
 */