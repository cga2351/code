package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.StickerMessage;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.w;

public class n extends a<ImageView>
{
  private final StickerMessage g;

  public n(StickerMessage paramStickerMessage, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, b paramb)
  {
    super(paramStickerMessage, paramContext, parama, parami, paramb);
    this.g = paramStickerMessage;
  }

  public void a(ImageView paramImageView)
  {
    if (this.g.getAction() != null)
      paramImageView.setOnClickListener(this.b);
    com.viber.voip.stickers.i locali = com.viber.voip.stickers.i.a();
    com.viber.voip.stickers.f localf = locali.e();
    Sticker localSticker = locali.c(this.g.getStickerId(), true);
    com.viber.voip.stickers.ui.f localf1 = new com.viber.voip.stickers.ui.f(localf, paramImageView);
    localf1.a(localSticker);
    localf1.a(false, true, w.b);
  }

  public ImageView d()
  {
    return new ImageView(this.a);
  }

  public int e()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_media_padding);
  }

  public int f()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_media_padding);
  }

  public StickerMessage g()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.n
 * JD-Core Version:    0.6.2
 */