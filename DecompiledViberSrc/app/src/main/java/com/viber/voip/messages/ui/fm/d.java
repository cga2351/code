package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.a.c.a.g;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.conversation.adapter.z;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d
{
  private static final Logger a = ViberEnv.getLogger("FORMATTED");
  private final z<MessageType> b;
  private final g c;
  private final List<i<View>> d = new ArrayList();
  private final FormattedMessage e;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.i f;

  public d(b paramb, FormattedMessage paramFormattedMessage, g paramg, z<MessageType> paramz, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, f paramf, c paramc)
  {
    this.c = paramg;
    this.b = paramz;
    this.e = paramFormattedMessage;
    this.f = parami;
    List localList = paramFormattedMessage.getMessage();
    ArrayList localArrayList = new ArrayList();
    com.viber.voip.messages.ui.fm.a.a locala = new com.viber.voip.messages.ui.fm.a.a();
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      i locali = locala.a(paramb, paramContext, (BaseMessage)localList.get(j), parami, parama, paramf, paramc);
      if (locali != null)
        localArrayList.add(locali);
    }
    Collections.addAll(this.d, localArrayList.toArray((i[])new i[localArrayList.size()]));
  }

  private View a(MessageType paramMessageType, i<View> parami)
  {
    View localView = this.b.a(paramMessageType);
    if (localView == null)
      localView = parami.i();
    return localView;
  }

  public void a()
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((i)this.d.get(j)).a();
  }

  public void a(ViewGroup paramViewGroup)
  {
    List localList = this.d;
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      i locali = (i)localList.get(j);
      BaseMessage localBaseMessage = locali.h();
      View localView = a(localBaseMessage.getType(), locali);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localBaseMessage.getWidthPx(this.f.i()), localBaseMessage.getHeightPx());
      localLayoutParams.bottomMargin = locali.f();
      localLayoutParams.leftMargin = locali.b();
      localLayoutParams.rightMargin = locali.c();
      localLayoutParams.topMargin = locali.e();
      localLayoutParams.gravity = localBaseMessage.getGravity(this.f.i());
      if (j <= i - 2)
      {
        int k = ((i)localList.get(j + 1)).e();
        if (k < 0)
        {
          int m = -k;
          if (m < 0)
            m = 0;
          localLayoutParams.bottomMargin = m;
        }
      }
      paramViewGroup.addView(localView, localLayoutParams);
      locali.a(localView);
    }
    paramViewGroup.getParent().requestLayout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.d
 * JD-Core Version:    0.6.2
 */