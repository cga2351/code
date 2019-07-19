package com.viber.voip.b.a.a.a;

import android.graphics.Bitmap;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.cu;

public class c
  implements d
{
  private cu<Bitmap> a = new cu(64);
  private final String b;

  public c(String paramString)
  {
    this.b = paramString;
  }

  public Bitmap a(Sticker paramSticker)
  {
    return (Bitmap)this.a.get(paramSticker.id);
  }

  public Bitmap a(Sticker paramSticker, Bitmap paramBitmap)
  {
    this.a.put(paramSticker.id, paramBitmap);
    return paramBitmap;
  }

  public Bitmap b(Sticker paramSticker)
  {
    this.a.remove(paramSticker.id);
    return null;
  }

  public void evictAll()
  {
    this.a.clear();
  }

  public int size()
  {
    return this.a.size();
  }

  public void trimToSize(int paramInt)
  {
    this.a.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.a.c
 * JD-Core Version:    0.6.2
 */