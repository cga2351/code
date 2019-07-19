package com.viber.voip.b.a.a.a;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a.b;
import com.viber.voip.stickers.entity.Sticker;

public class a
  implements d
{
  private static final Logger b = ViberEnv.getLogger();
  b<String> a;
  private final String c;

  public a(com.viber.voip.b.a parama)
  {
    this(parama.toString(), parama.m, parama.n);
  }

  public a(String paramString, float paramFloat1, float paramFloat2)
  {
    this.a = new com.viber.voip.b.a.a.a(paramString, paramFloat1, paramFloat2);
    this.c = paramString;
  }

  public Bitmap a(Sticker paramSticker)
  {
    return this.a.a(paramSticker.getThumbPath());
  }

  public Bitmap a(Sticker paramSticker, Bitmap paramBitmap)
  {
    if ((paramSticker.getThumbPath() == null) || (paramBitmap == null))
      return paramBitmap;
    this.a.a(paramSticker.getThumbPath(), paramBitmap);
    return paramBitmap;
  }

  public Bitmap b(Sticker paramSticker)
  {
    return this.a.b(paramSticker.getThumbPath());
  }

  public void evictAll()
  {
    this.a.evictAll();
  }

  public int size()
  {
    return this.a.size();
  }

  public void trimToSize(int paramInt)
  {
    this.a.trimToSize(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.a.a
 * JD-Core Version:    0.6.2
 */