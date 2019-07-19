package com.viber.voip.messages.adapters;

import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.bot.item.b;
import com.viber.voip.bot.item.c;
import com.viber.voip.bot.item.d;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e
{
  private final int a;
  private float b;

  public e(BotReplyConfig paramBotReplyConfig)
  {
    this.a = paramBotReplyConfig.getButtonsGroupColumns();
    ReplyButton[] arrayOfReplyButton = paramBotReplyConfig.getButtons();
    if (arrayOfReplyButton == null)
      return;
    ArrayList localArrayList = new ArrayList(arrayOfReplyButton.length);
    int i = arrayOfReplyButton.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(new BotKeyboardItem(arrayOfReplyButton[j]));
    new d(paramBotReplyConfig.getButtonsGroupRows(), paramBotReplyConfig.getButtonsGroupColumns()).a(localArrayList);
    this.b = a(new c(localArrayList, paramBotReplyConfig.getButtonsGroupColumns(), true, true), true);
  }

  private float a(c<BotKeyboardItem> paramc, boolean paramBoolean)
  {
    d.a locala = new d.a(false, paramBoolean);
    int i = this.a;
    if (!locala.f())
      i *= 2;
    locala.a(i);
    if (paramBoolean);
    for (List localList = Arrays.asList(paramc.a()); ; localList = Arrays.asList(paramc.b()))
      return a(localList, locala);
  }

  public static float a(List<b<BotKeyboardItem>> paramList, d.a parama)
  {
    int i = paramList.size();
    int j = 0;
    float f1 = 0.0F;
    if (j < i)
    {
      b localb = (b)paramList.get(j);
      if (j == i - 1);
      for (boolean bool = true; ; bool = false)
      {
        float f2 = f1 + parama.a(localb, bool);
        j++;
        f1 = f2;
        break;
      }
    }
    return f1;
  }

  public float a()
  {
    return this.b;
  }

  public float b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.e
 * JD-Core Version:    0.6.2
 */