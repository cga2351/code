package com.viber.voip.notif.b.f.b;

import android.content.Context;
import android.text.SpannableString;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import dagger.a;
import java.util.Iterator;
import java.util.List;

class n
  implements h
{
  private final x a;
  private final a<ai> b;
  private final a<b> c;

  n(x paramx, a<ai> parama, a<b> parama1)
  {
    this.a = paramx;
    this.b = parama;
    this.c = parama1;
  }

  private String a(BaseMessage paramBaseMessage)
  {
    if ((paramBaseMessage instanceof TextMessage))
    {
      TextMessage localTextMessage = (TextMessage)paramBaseMessage;
      String str = localTextMessage.getSpans();
      if ((localTextMessage.shouldConsiderMentions()) && (!da.a(str)) && (!"no_sp".equals(str)))
        return str;
    }
    return null;
  }

  public String a(Context paramContext, final m paramm)
  {
    return this.a.a(paramContext, paramm, new x.b()
    {
      public String a(String paramAnonymousString)
      {
        com.viber.voip.model.entity.h localh = paramm.e();
        FormattedMessage localFormattedMessage = paramm.c().loadFormattedMessage();
        String str1 = null;
        String str2;
        if (localFormattedMessage != null)
        {
          List localList = localFormattedMessage.getMessage();
          if (!u.a(localList))
          {
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              BaseMessage localBaseMessage = (BaseMessage)localIterator.next();
              str1 = n.a(n.this, localBaseMessage);
              if (str1 != null)
                str2 = str1;
            }
          }
        }
        while (true)
        {
          if (str2 != null)
          {
            ai localai = (ai)n.a(n.this).get();
            b localb = (b)n.b(n.this).get();
            int i = aj.b;
            int j = localh.j();
            int k = localh.p();
            paramAnonymousString = da.a(paramAnonymousString, localai, localb, str2, false, false, false, false, i, j, k).toString();
          }
          return paramAnonymousString;
          str2 = str1;
          continue;
          str2 = null;
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.n
 * JD-Core Version:    0.6.2
 */