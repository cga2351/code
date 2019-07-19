package com.viber.voip.stickers;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.util.upload.o;
import java.io.FileNotFoundException;
import java.io.IOException;

public class q
{
  private static final Logger a = ViberEnv.getLogger();
  private i b;

  public q(i parami)
  {
    this.b = parami;
  }

  public void a(Sticker paramSticker)
  {
    int i = paramSticker.packageId;
    if (i == 0);
    for (a locala = null; locala != null; locala = this.b.g(i))
    {
      this.b.b(locala);
      return;
    }
    this.b.b(paramSticker.id, i, true);
  }

  public void a(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, w paramw, IOException paramIOException)
  {
    if (((paramIOException instanceof FileNotFoundException)) && ("mounted".equals(o.e())))
    {
      paramSticker.checkStatus();
      if (!paramSticker.isReady())
        a(paramSticker);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.q
 * JD-Core Version:    0.6.2
 */