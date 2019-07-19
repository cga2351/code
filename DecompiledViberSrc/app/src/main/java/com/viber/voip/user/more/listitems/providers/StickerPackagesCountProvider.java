package com.viber.voip.user.more.listitems.providers;

import com.viber.voip.schedule.o;
import com.viber.voip.settings.a.a.d;

public class StickerPackagesCountProvider
  implements a.d
{
  private final o mStickerPackagesCountManager;

  public StickerPackagesCountProvider(o paramo)
  {
    this.mStickerPackagesCountManager = paramo;
  }

  public CharSequence getText()
  {
    int i = this.mStickerPackagesCountManager.h();
    if (i == 0)
      return null;
    return String.valueOf(i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.providers.StickerPackagesCountProvider
 * JD-Core Version:    0.6.2
 */