package com.viber.voip.bot.a;

import android.view.View;
import com.viber.voip.bot.item.KeyboardItem;

public abstract class c<I extends KeyboardItem>
{
  private String a;
  public final View c;
  public I d;
  public int e;
  public long f;

  public c(View paramView)
  {
    this.c = paramView;
  }

  public void a()
  {
  }

  public void a(I paramI, int paramInt, long paramLong, com.viber.voip.messages.adapters.c paramc)
  {
    this.d = paramI;
    this.e = paramInt;
    this.f = paramLong;
    this.a = null;
  }

  protected String c()
  {
    return "";
  }

  public String f()
  {
    if (this.a == null)
      this.a = (c() + String.valueOf(this.f) + "_" + String.valueOf(this.e));
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.c
 * JD-Core Version:    0.6.2
 */