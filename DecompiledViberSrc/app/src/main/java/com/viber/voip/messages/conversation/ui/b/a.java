package com.viber.voip.messages.conversation.ui.b;

import android.view.View;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.messages.ui.expanel.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ExpandablePanelLayout.c
{
  private final List<ExpandablePanelLayout.c> a = new ArrayList();
  private final List<com.viber.voip.messages.conversation.ui.view.a> b = new ArrayList();

  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).b();
  }

  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((ExpandablePanelLayout.c)localIterator.next()).a(paramInt);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((ExpandablePanelLayout.c)localIterator.next()).a(paramInt1, paramInt2, paramView);
  }

  public void a(BotReplyConfig paramBotReplyConfig, d paramd)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).a(paramBotReplyConfig, paramd);
  }

  public void a(com.viber.voip.messages.conversation.ui.view.a parama)
  {
    this.b.add(parama);
  }

  public void a(ExpandablePanelLayout.c paramc)
  {
    this.a.add(paramc);
  }

  public void a(String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).a(paramString1, paramInt, paramString2);
  }

  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).a(paramString1, paramString2, paramInt, paramString3);
  }

  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).d();
  }

  public void b(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).b(paramInt);
  }

  public void b(com.viber.voip.messages.conversation.ui.view.a parama)
  {
    this.b.remove(parama);
  }

  public void b(ExpandablePanelLayout.c paramc)
  {
    this.a.remove(paramc);
  }

  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).e();
  }

  public void c(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).c(paramInt);
  }

  public void d()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((com.viber.voip.messages.conversation.ui.view.a)localIterator.next()).f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.a
 * JD-Core Version:    0.6.2
 */