package com.viber.voip.bot.a;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.dimen;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import com.viber.voip.messages.adapters.c;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;

public class b extends c
{
  private final int b;
  private final float c;
  private final float d;
  private final float e;
  private final f f;
  private final f g;
  private final f h;
  private e i;

  public b(Context paramContext)
  {
    super(paramContext);
    this.i = e.a(paramContext);
    f localf = f.a().f().a(Integer.valueOf(0)).a(3460301).a("BotKeyboard").c();
    this.f = localf.f().a(f.b.e).c();
    this.g = localf.f().a(f.b.f).c();
    this.h = localf.f().a(f.b.g).c();
    this.b = this.a.getDimensionPixelSize(R.dimen.bot_keyboard_text_padding);
    this.c = this.a.getDimension(R.dimen.bot_keyboard_button_text_size_large);
    this.d = this.a.getDimension(R.dimen.bot_keyboard_button_text_size_regular);
    this.e = this.a.getDimension(R.dimen.bot_keyboard_button_text_size_small);
  }

  public float a(ReplyButton.g paramg)
  {
    if (paramg != null)
    {
      switch (1.a[paramg.ordinal()])
      {
      default:
        return this.d;
      case 1:
        return this.c;
      case 2:
        return this.d;
      case 3:
      }
      return this.e;
    }
    return this.d;
  }

  public e a()
  {
    return this.i;
  }

  public f a(ReplyButton paramReplyButton)
  {
    int j = Math.max(paramReplyButton.getColumns(), paramReplyButton.getRows());
    if (j <= 1)
      return this.f;
    if (j <= 3)
      return this.g;
    return this.h;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.b
 * JD-Core Version:    0.6.2
 */