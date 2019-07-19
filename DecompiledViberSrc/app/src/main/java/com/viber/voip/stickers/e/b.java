package com.viber.voip.stickers.e;

import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;

public abstract interface b
{
  public abstract void onStickerDeployed(Sticker paramSticker);

  public abstract void onStickerPackageDeployed(a parama);

  public abstract void onStickerPackageDownloadError(boolean paramBoolean, a parama);

  public abstract void onStickerPackageDownloadScheduled(a parama);

  public abstract void onStickerPackageDownloadStarted(a parama);

  public abstract void onStickerPackageDownloading(a parama, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.e.b
 * JD-Core Version:    0.6.2
 */