package com.viber.voip.bot.a;

import android.net.Uri;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import com.viber.voip.stickers.ui.c;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;

public class f extends a
{
  public f(c paramc, com.viber.voip.bot.item.a parama)
  {
    super(paramc, parama);
  }

  protected Uri a(Uri paramUri)
  {
    return dx.a(paramUri);
  }

  protected int c(ReplyButton paramReplyButton)
  {
    if (paramReplyButton.getTextSize() == ReplyButton.g.LARGE)
      return 1;
    return 2;
  }

  protected dv e()
  {
    return dv.F;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.f
 * JD-Core Version:    0.6.2
 */