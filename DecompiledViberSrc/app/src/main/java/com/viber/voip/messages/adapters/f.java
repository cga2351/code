package com.viber.voip.messages.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.stickers.ui.c;

public class f extends a.a<BotKeyboardItem, com.viber.voip.bot.a.a>
{
  protected int g = 0;
  protected com.viber.voip.bot.item.a h;

  public f(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.ui.a parama, ViewGroup paramViewGroup, int paramInt1, com.viber.voip.bot.item.a parama1, int paramInt2)
  {
    super(paramLayoutInflater, parama, paramViewGroup, paramInt1);
    this.h = parama1;
    this.g = paramInt2;
  }

  protected void a(com.viber.voip.stickers.ui.d paramd, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2 - 1);
    for (boolean bool = true; ; bool = false)
    {
      paramd.a(true, bool);
      return;
    }
  }

  protected com.viber.voip.bot.a.a b(ViewGroup paramViewGroup)
  {
    c localc = new c(paramViewGroup.getContext());
    localc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    switch (this.g)
    {
    default:
      return new com.viber.voip.bot.a.a(localc, this.h);
    case 3:
      return new com.viber.voip.bot.a.f(localc, this.h);
    case 2:
    }
    return new com.viber.voip.bot.a.d(localc, this.h);
  }

  protected com.viber.voip.bot.a.a[] b(int paramInt)
  {
    return new com.viber.voip.bot.a.a[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.f
 * JD-Core Version:    0.6.2
 */