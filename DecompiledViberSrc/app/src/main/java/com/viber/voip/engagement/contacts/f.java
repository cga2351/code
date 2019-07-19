package com.viber.voip.engagement.contacts;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.data.GifsMediaViewData.GifItem;
import com.viber.voip.engagement.data.StickersMediaViewData.StickerItem;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.h;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.ObjectId;

class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final ai b;
  private final com.viber.common.b.b c;

  public f(ai paramai, com.viber.common.b.b paramb)
  {
    this.b = paramai;
    this.c = paramb;
  }

  private h a(long paramLong)
  {
    return new com.viber.voip.messages.controller.c.b(0L, paramLong, null, 1, 0);
  }

  private h a(String paramString)
  {
    return new com.viber.voip.messages.controller.c.b(0L, paramString, 0, 0);
  }

  private void a(h paramh, GifsMediaViewData.GifItem paramGifItem, String paramString)
  {
    String str = paramGifItem.getUrl().toString();
    a(paramh.a(str, str, paramGifItem.getWidth(), paramGifItem.getHeight(), 0));
    a(paramh, paramString);
  }

  private void a(h paramh, StickersMediaViewData.StickerItem paramStickerItem, String paramString)
  {
    a(paramh.a(4, ObjectId.fromLong(paramStickerItem.getId()), 0));
    a(paramh, paramString);
  }

  private void a(h paramh, String paramString)
  {
    if (da.a(paramString))
      return;
    MessageEntity localMessageEntity = paramh.a(1006, null, "", paramString, 0);
    localMessageEntity.addExtraFlag(25);
    this.b.a(localMessageEntity, null);
  }

  private void a(MessageEntity paramMessageEntity)
  {
    this.b.a(paramMessageEntity, null);
    this.c.a(true);
  }

  private h b(long paramLong)
  {
    return new com.viber.voip.messages.controller.c.b(paramLong, 0L, null, 4, 0);
  }

  public void a(long paramLong, GifsMediaViewData.GifItem paramGifItem, String paramString)
  {
    if ((paramGifItem == null) || (paramGifItem.getUrl() == null))
      return;
    a(a(paramLong), paramGifItem, paramString);
  }

  public void a(long paramLong, StickersMediaViewData.StickerItem paramStickerItem, String paramString)
  {
    if (paramStickerItem == null)
      return;
    a(a(paramLong), paramStickerItem, paramString);
  }

  public void a(String paramString1, boolean paramBoolean, GifsMediaViewData.GifItem paramGifItem, String paramString2)
  {
    if ((paramGifItem == null) || (paramGifItem.getUrl() == null))
      return;
    a(a(paramString1), paramGifItem, paramString2);
  }

  public void a(String paramString1, boolean paramBoolean, StickersMediaViewData.StickerItem paramStickerItem, String paramString2)
  {
    if (paramStickerItem == null)
      return;
    a(a(paramString1), paramStickerItem, paramString2);
  }

  public void b(long paramLong, GifsMediaViewData.GifItem paramGifItem, String paramString)
  {
    if ((paramGifItem == null) || (paramGifItem.getUrl() == null))
      return;
    a(b(paramLong), paramGifItem, paramString);
  }

  public void b(long paramLong, StickersMediaViewData.StickerItem paramStickerItem, String paramString)
  {
    if (paramStickerItem == null)
      return;
    a(b(paramLong), paramStickerItem, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.f
 * JD-Core Version:    0.6.2
 */