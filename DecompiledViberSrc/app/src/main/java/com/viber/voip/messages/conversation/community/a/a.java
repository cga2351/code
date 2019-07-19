package com.viber.voip.messages.conversation.community.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.viber.common.dialogs.a.a;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.conversation.community.b.b;
import com.viber.voip.messages.conversation.community.b.b.a;
import com.viber.voip.messages.conversation.community.b.b.a.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  implements e
{
  private Context a;
  private List<GroupController.GroupMember> b;
  private DialogInterface.OnClickListener c;
  private e.a d;
  private b e;

  public a(Context paramContext, List<GroupController.GroupMember> paramList, DialogInterface.OnClickListener paramOnClickListener, e.a parama)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramOnClickListener;
    this.d = parama;
    this.e = new b();
  }

  public void a(Map<String, Integer> paramMap)
  {
    Set localSet = this.e.a(this.b, paramMap.keySet());
    b.a locala = new b.a(this.e.a(localSet), new b.a.a()
    {
      public boolean a(Map.Entry<String, Integer> paramAnonymousEntry)
      {
        return ((Integer)paramAnonymousEntry.getValue()).equals(Integer.valueOf(4));
      }
    });
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
      locala.a((Map.Entry)localIterator.next());
    Map localMap = locala.a();
    boolean bool = localMap.isEmpty();
    a.a locala1 = null;
    if (!bool)
      locala1 = c.b(this.b.size(), localMap, this.c);
    if (locala1 != null)
      locala1.a(this.a);
    while (this.d == null)
      return;
    this.d.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.a.a
 * JD-Core Version:    0.6.2
 */