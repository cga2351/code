package com.viber.voip.messages.adapters.a.b;

import android.text.TextUtils;
import android.widget.TextView;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.ce;
import com.viber.voip.util.dg;
import com.viber.voip.util.dr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ab<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final TextView a;

  public ab(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  private CharSequence a(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
  {
    CharSequence localCharSequence = paramConversationLoaderEntity.getSpannableTitleText();
    if (localCharSequence != null)
      return localCharSequence;
    Object localObject = paramConversationLoaderEntity.getGroupName();
    String str = paramConversationLoaderEntity.getParticipantName();
    boolean bool = paramConversationLoaderEntity.isGroupBehavior();
    if ((paramConversationLoaderEntity.isVlnConversation()) && (parama.c() != a.a.a))
      localObject = dg.a(str, paramConversationLoaderEntity.getToNumber());
    while (true)
    {
      paramConversationLoaderEntity.setSpannableTitleText((CharSequence)localObject);
      return localObject;
      if (bool)
      {
        if (TextUtils.isEmpty((CharSequence)localObject))
          if (paramConversationLoaderEntity.isBroadcastListType())
            localObject = parama.u();
          else
            localObject = parama.t();
      }
      else
        localObject = str;
    }
  }

  private void a(com.viber.voip.messages.adapters.a.c.a parama)
  {
    String str1 = parama.p();
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = str1.trim();
      boolean bool = ce.l.matcher(str2).matches();
      String str3 = null;
      if (bool)
        str3 = dr.a(ViberApplication.getInstance(), str2, null);
      if ((!dg.a(this.a, str2, 20)) && (str3 != null))
        dg.a(this.a, str3, 20);
    }
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    this.a.setText(a(localConversationLoaderEntity, parama));
    a(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.ab
 * JD-Core Version:    0.6.2
 */