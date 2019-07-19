package com.viber.voip.messages.conversation.ui.b;

import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class u
  implements v
{
  private static final Logger a = ViberEnv.getLogger();
  private Intent b;
  private int c;
  private long d;
  private ConversationData e;
  private final List<v> f = new ArrayList();

  public void G_()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).G_();
  }

  public void a(aa paramaa)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramaa);
  }

  public void a(ConversationData paramConversationData)
  {
    this.d = paramConversationData.conversationId;
    this.e = paramConversationData;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramConversationData);
  }

  public void a(v paramv)
  {
    this.f.add(paramv);
  }

  public void a(t.c paramc, t.b.a parama)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((v)localIterator.next()).a(paramBoolean);
  }

  public boolean a(Intent paramIntent, long paramLong1, long paramLong2, int paramInt)
  {
    if ((paramLong1 != -1L) && (paramLong2 != paramLong1))
    {
      if (this.d == paramLong1)
      {
        this.b = paramIntent;
        this.c = paramInt;
      }
      return false;
    }
    return true;
  }

  public void b(v paramv)
  {
    this.f.remove(paramv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.u
 * JD-Core Version:    0.6.2
 */