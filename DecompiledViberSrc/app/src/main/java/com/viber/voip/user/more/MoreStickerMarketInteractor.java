package com.viber.voip.user.more;

import com.viber.voip.stickers.i;
import com.viber.voip.util.dd;
import java.util.List;

class MoreStickerMarketInteractor
  implements com.viber.voip.stickers.e.a
{
  private final MoreStickerMarketEventsListener mMoreStickerMarketEventsListener;
  private final MoreStickerMarketSubTextState mMoreStickerMarketSubTextState;
  private final i mStickerController;

  MoreStickerMarketInteractor(i parami, MoreStickerMarketEventsListener paramMoreStickerMarketEventsListener, MoreStickerMarketSubTextState paramMoreStickerMarketSubTextState)
  {
    this.mStickerController = parami;
    this.mMoreStickerMarketEventsListener = paramMoreStickerMarketEventsListener;
    this.mMoreStickerMarketSubTextState = paramMoreStickerMarketSubTextState;
  }

  String getStatePrefKey()
  {
    return this.mMoreStickerMarketSubTextState.getPrefKey();
  }

  public void onStickerPackageChanged(List<com.viber.voip.stickers.entity.a> paramList1, List<com.viber.voip.stickers.entity.a> paramList2)
  {
    dd.a(new MoreStickerMarketInteractor..Lambda.0(this, paramList2));
  }

  void register(MoreStickerMarketEventsListener.NewStickerPackageCountChangedListener paramNewStickerPackageCountChangedListener)
  {
    this.mMoreStickerMarketEventsListener.register(paramNewStickerPackageCountChangedListener);
    this.mStickerController.a(this);
    if (this.mStickerController.h().size() > 0)
      this.mMoreStickerMarketSubTextState.onStickerPackagesChanged(this.mStickerController.i());
  }

  void setMoreScreenOpened()
  {
    this.mMoreStickerMarketSubTextState.onMoreTabOpened();
  }

  void setMoreStickerMarketOpened()
  {
    this.mMoreStickerMarketSubTextState.onMarketOpened();
  }

  void unregister()
  {
    this.mMoreStickerMarketEventsListener.unregister();
    this.mStickerController.b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreStickerMarketInteractor
 * JD-Core Version:    0.6.2
 */