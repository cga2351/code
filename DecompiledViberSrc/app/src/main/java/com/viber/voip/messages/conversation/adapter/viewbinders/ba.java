package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.ImageView;
import com.viber.voip.messages.controller.ca;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.r;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.StickerClickerConstraintHelper;
import com.viber.voip.ui.b.d;

public class ba extends am
{
  private final StickerClickerConstraintHelper c;

  public ba(ImageView paramImageView, StickerClickerConstraintHelper paramStickerClickerConstraintHelper, d paramd, ca paramca, r paramr)
  {
    super(paramImageView, paramd, paramca, paramr);
    this.c = paramStickerClickerConstraintHelper;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (this.b);
    this.c.setTag(localaa.bn());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ba
 * JD-Core Version:    0.6.2
 */