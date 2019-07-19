package com.viber.voip.messages.conversation.community.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.viber.common.dialogs.a.a;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.conversation.community.b.b.a;
import com.viber.voip.messages.conversation.community.b.b.a.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements e
{
  private Context a;
  private List<GroupController.GroupMember> b;
  private com.viber.voip.messages.conversation.community.b.b c;
  private e.a d;

  public b(Context paramContext, List<GroupController.GroupMember> paramList, e.a parama)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = parama;
    this.c = new com.viber.voip.messages.conversation.community.b.b();
  }

  public void a(Map<String, Integer> paramMap)
  {
    Set localSet = this.c.a(this.b, paramMap.keySet());
    Map localMap1 = this.c.a(localSet);
    b.a locala1 = new b.a(localMap1, new b.a.a()
    {
      public boolean a(Map.Entry<String, Integer> paramAnonymousEntry)
      {
        return ((Integer)paramAnonymousEntry.getValue()).equals(Integer.valueOf(2));
      }
    });
    b.a locala2 = new b.a(localMap1, new b.a.a()
    {
      public boolean a(Map.Entry<String, Integer> paramAnonymousEntry)
      {
        Integer localInteger = (Integer)paramAnonymousEntry.getValue();
        return (!localInteger.equals(Integer.valueOf(2))) && (!localInteger.equals(Integer.valueOf(7)));
      }
    });
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      locala1.a(localEntry);
      locala2.a(localEntry);
    }
    Map localMap2 = locala1.a();
    Map localMap3 = locala2.a();
    a.a locala;
    if (!localMap2.isEmpty())
      locala = c.a(this.b.size(), localMap2, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (b.a(b.this) != null)
            b.a(b.this).a(1);
        }
      });
    while (true)
    {
      if (locala != null)
        locala.a(this.a);
      return;
      boolean bool = localMap3.isEmpty();
      locala = null;
      if (!bool)
        locala = c.a(localMap3, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (b.a(b.this) != null)
              b.a(b.this).a(2);
          }
        });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.a.b
 * JD-Core Version:    0.6.2
 */