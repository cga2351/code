package com.viber.voip.bot.item;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static final Logger c = ViberEnv.getLogger();
  int a;
  int b;
  private boolean[][] d;
  private int e;

  public d(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    int[] arrayOfInt = { this.b, this.a };
    this.d = ((boolean[][])Array.newInstance(Boolean.TYPE, arrayOfInt));
    this.e = 0;
  }

  private void a()
  {
    for (int i = 0; i < this.b; i++)
      for (int j = 0; j < this.a; j++)
        this.d[i][j] = 0;
  }

  private void a(KeyboardItem paramKeyboardItem)
  {
    for (int i = 0; i < this.a; i++)
      label137: for (int j = 0; j < this.b; j++)
        if ((this.d[j][i] == 0) && (j + paramKeyboardItem.colSpan <= this.b) && (i + paramKeyboardItem.rowSpan <= this.a))
        {
          int k = 1;
          for (int m = i; ; m++)
          {
            if (m < i + paramKeyboardItem.rowSpan);
            for (int n = j; ; n++)
              if (n < j + paramKeyboardItem.colSpan)
              {
                if (this.d[n][m] != 0)
                  k = 0;
              }
              else
              {
                if (k != 0)
                  break;
                if (k == 0)
                  break label137;
                paramKeyboardItem.genericColPos = j;
                paramKeyboardItem.genericRowPos = i;
                return;
              }
          }
        }
    a();
  }

  private void b(KeyboardItem paramKeyboardItem)
  {
    int i = paramKeyboardItem.genericColPos;
    int j = paramKeyboardItem.genericColPos + paramKeyboardItem.colSpan;
    for (int k = i; k < j; k++)
    {
      int m = paramKeyboardItem.genericRowPos;
      int n = paramKeyboardItem.genericRowPos + paramKeyboardItem.rowSpan;
      while (m < n)
      {
        this.d[k][m] = 1;
        m++;
      }
    }
  }

  public void a(List<? extends KeyboardItem> paramList)
  {
    a();
    this.e = 0;
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (true)
    {
      KeyboardItem localKeyboardItem;
      if (localIterator.hasNext())
      {
        localKeyboardItem = (KeyboardItem)localIterator.next();
        a(localKeyboardItem);
      }
      try
      {
        b(localKeyboardItem);
        label50: if (localKeyboardItem.genericColPos == 0)
        {
          this.e = (i + this.e);
          i = 0;
        }
        i = Math.max(i, localKeyboardItem.rowSpan);
        continue;
        this.e = (i + this.e);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        break label50;
      }
    }
  }

  public boolean a(BotReplyConfig paramBotReplyConfig)
  {
    try
    {
      ReplyButton[] arrayOfReplyButton = paramBotReplyConfig.getButtons();
      ArrayList localArrayList = new ArrayList();
      int i = arrayOfReplyButton.length;
      for (int j = 0; j < i; j++)
        localArrayList.add(new BotKeyboardItem(arrayOfReplyButton[j]));
      a(localArrayList);
      int k = this.e;
      boolean bool = false;
      if (k > 0)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.item.d
 * JD-Core Version:    0.6.2
 */