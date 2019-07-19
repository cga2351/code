package com.viber.voip.messages.adapters;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.bot.item.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d extends a<BotKeyboardItem>
{
  private static final Logger f = ViberEnv.getLogger();
  protected int e = 0;
  private com.viber.voip.bot.item.c<BotKeyboardItem> g;
  private com.viber.voip.bot.item.a h;
  private b i;
  private Context j;
  private int k;

  public d(Context paramContext, c paramc, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramc, paramLayoutInflater);
    this.j = paramContext;
  }

  private void a(b<BotKeyboardItem>[] paramArrayOfb)
  {
    this.a = Arrays.asList(paramArrayOfb);
    int m = paramArrayOfb.length;
    int n = 0;
    int i1 = 0;
    int i2;
    if (n < m)
    {
      i2 = paramArrayOfb[n].a().size();
      if (i2 <= i1)
        break label58;
    }
    while (true)
    {
      n++;
      i1 = i2;
      break;
      b(i1);
      return;
      label58: i2 = i1;
    }
  }

  protected int a()
  {
    return this.k;
  }

  protected a.a a(ViewGroup paramViewGroup)
  {
    return new f(this.b, this.c, paramViewGroup, this.d, this.h, this.e);
  }

  protected com.viber.voip.stickers.ui.a a(Context paramContext)
  {
    if (this.i == null)
      this.i = new b(paramContext);
    return this.i;
  }

  public void a(com.viber.voip.bot.item.a parama)
  {
    this.h = parama;
  }

  public void a(BotReplyConfig paramBotReplyConfig)
  {
    ReplyButton[] arrayOfReplyButton = paramBotReplyConfig.getButtons();
    if (arrayOfReplyButton == null)
      return;
    this.k = (2 * paramBotReplyConfig.getButtonsGroupColumns());
    ArrayList localArrayList = new ArrayList(arrayOfReplyButton.length);
    int m = arrayOfReplyButton.length;
    for (int n = 0; n < m; n++)
      localArrayList.add(new BotKeyboardItem(arrayOfReplyButton[n]));
    int i1 = paramBotReplyConfig.getButtonsGroupRows();
    int i2 = paramBotReplyConfig.getButtonsGroupColumns();
    if (!this.c.f());
    for (int i3 = i2 * 2; ; i3 = i2)
    {
      ((a)this.c).a(i3);
      new com.viber.voip.bot.item.d(i1, i2).a(localArrayList);
      this.g = new com.viber.voip.bot.item.c(localArrayList, i2, false, false);
      if (this.c.b());
      for (b[] arrayOfb = this.g.a(); ; arrayOfb = this.g.b())
      {
        a(arrayOfb);
        notifyDataSetChanged();
        return;
      }
    }
  }

  public final void c(int paramInt)
  {
    this.e = paramInt;
    this.c = a(this.j);
  }

  public boolean d(int paramInt)
  {
    boolean bool = this.c.b(paramInt);
    if (bool)
      notifyDataSetChanged();
    return bool;
  }

  public static class a extends com.viber.voip.stickers.ui.a<BotKeyboardItem>
  {
    private int a;

    public a(Context paramContext)
    {
    }

    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramBoolean2);
    }

    protected com.viber.voip.stickers.ui.a.a a()
    {
      com.viber.voip.stickers.ui.a.a locala = new com.viber.voip.stickers.ui.a.a();
      int i = c();
      int j = Math.max(0, Math.min(ViberApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.bot_keyboard_button_max_gap_size), (int)((i - this.a) / (1.0F + this.a))));
      locala.d((i - j * (1 + this.a)) / (0.0F + this.a));
      locala.a(j);
      return locala;
    }

    public void a(int paramInt)
    {
      this.a = paramInt;
      e();
    }
  }

  public static class b extends d.a
  {
    public b(Context paramContext)
    {
      super();
    }

    public boolean b()
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.d
 * JD-Core Version:    0.6.2
 */