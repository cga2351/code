package com.viber.voip.bot.a;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.d;
import com.viber.voip.messages.ui.cd.a;
import pl.droidsonroids.gif.b;

public class d extends a
  implements y.d
{
  private final cd.a g = new cd.a()
  {
    public void a(View paramAnonymousView)
    {
      y.a().b(d.this);
    }
  };

  public d(com.viber.voip.stickers.ui.c paramc, com.viber.voip.bot.item.a parama)
  {
    super(paramc, parama);
    paramc.setPositioningListener(this.g);
  }

  private void a(boolean paramBoolean)
  {
    String str;
    if (this.d != null)
    {
      ReplyButton localReplyButton = ((BotKeyboardItem)this.d).replyButton;
      if (a(localReplyButton))
      {
        str = b(localReplyButton);
        if (!paramBoolean)
          break label51;
        y.a().a(str, this.a.getDrawable());
      }
    }
    return;
    label51: y.a().b(str, this.a.getDrawable());
  }

  public void O_()
  {
    a(true);
  }

  public void a(BotKeyboardItem paramBotKeyboardItem, int paramInt, long paramLong, com.viber.voip.messages.adapters.c paramc)
  {
    super.a(paramBotKeyboardItem, paramInt, paramLong, paramc);
    y.a().a(this);
  }

  protected a.a b()
  {
    return new a(this.a);
  }

  protected int c(ReplyButton paramReplyButton)
  {
    if (paramReplyButton.getTextSize() == ReplyButton.g.LARGE)
      return 1;
    return 2;
  }

  protected String c()
  {
    return "RM_";
  }

  public void g()
  {
    a(false);
  }

  private static class a extends a.a
  {
    public a(ImageView paramImageView)
    {
      super();
    }

    public void a(b paramb, String paramString, Uri paramUri)
    {
      super.a(paramb, paramString, paramUri);
      if (!this.c)
        y.a().a(paramb, paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.d
 * JD-Core Version:    0.6.2
 */