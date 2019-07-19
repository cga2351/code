package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.j;
import com.viber.voip.notif.h.d;
import com.viber.voip.util.ca;
import com.viber.voip.util.dg;
import dagger.a;

public class c
  implements g
{
  private final Context a;
  private final d b;
  private final a<b> c;

  c(Context paramContext, d paramd, a<b> parama)
  {
    this.a = paramContext;
    this.b = paramd;
    this.c = parama;
  }

  private String a(int paramInt, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
      paramArrayOfString[i] = ca.a(paramArrayOfString[i], "");
    return com.viber.common.d.c.a(this.a, paramInt, (Object[])paramArrayOfString);
  }

  private String a(String paramString1, String paramString2)
  {
    return com.viber.common.d.c.a(paramString1) + ": " + com.viber.common.d.c.a(paramString2);
  }

  public e a(boolean paramBoolean)
  {
    String str2;
    if (this.b.f() > 1)
    {
      int k = R.string.message_notification_smart_messages_group;
      String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = this.b.d();
      str2 = a(k, arrayOfString3);
    }
    while (true)
    {
      return new e(this.b.d(), str2, str2, null, paramBoolean);
      if (this.b.r() > this.b.q())
      {
        str2 = a(((b)this.c.get()).a(this.b.i(), 5, this.b.k(), this.b.j()), j.a(this.a, this.b.g(), this.b.h()));
      }
      else
      {
        String str1 = ((b)this.c.get()).a(this.b.p(), 5, this.b.k());
        if (!paramBoolean)
        {
          str2 = a(str1, j.a(this.a, this.b.o(), ""));
        }
        else if (this.b.x())
        {
          int j = R.string.message_notification_vote_text_with_question;
          String[] arrayOfString2 = new String[2];
          arrayOfString2[0] = str1;
          arrayOfString2[1] = this.b.m();
          str2 = a(j, arrayOfString2).trim();
        }
        else
        {
          if (this.b.w())
          {
            if (this.b.n().getPin().getAction() == Pin.a.DELETE);
            for (int i = R.string.chat_list_unpinned_preview; ; i = R.string.pinned_notification_text)
            {
              String[] arrayOfString1 = new String[2];
              arrayOfString1[0] = str1;
              arrayOfString1[1] = dg.a(this.b.n().getPin());
              str2 = a(i, arrayOfString1).trim();
              break;
            }
          }
          str2 = a(str1, j.a(this.a, this.b.o(), this.b.m()));
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.c
 * JD-Core Version:    0.6.2
 */