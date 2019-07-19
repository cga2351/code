package com.viber.voip.ui.doodle.objects.a;

import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.doodle.objects.StickerBitmapObject;
import com.viber.voip.ui.doodle.objects.StickerSvgObject;
import com.viber.voip.ui.doodle.objects.b.d;

public class c
  implements b<StickerBitmapObject, d>
{
  public StickerBitmapObject a(d paramd)
  {
    if (paramd.e().isSvg())
      return new StickerSvgObject(paramd);
    return new StickerBitmapObject(paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.a.c
 * JD-Core Version:    0.6.2
 */