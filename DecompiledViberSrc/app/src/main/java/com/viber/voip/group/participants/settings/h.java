package com.viber.voip.group.participants.settings;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.GroupController.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
{
  private static final Logger a = ViberEnv.getLogger();
  private final GroupController b;

  public h(GroupController paramGroupController)
  {
    this.b = paramGroupController;
  }

  private void a(long paramLong, String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length != 0)
      this.b.a(paramLong, paramArrayOfString, paramInt);
  }

  public void a(long paramLong, b paramb)
  {
    this.b.a(paramLong, paramb);
  }

  public void a(long paramLong, Map<String, ? extends b> paramMap)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).canWrite())
        localArrayList2.add(localEntry.getKey());
      else
        localArrayList1.add(localEntry.getKey());
    }
    String[] arrayOfString1 = (String[])localArrayList1.toArray(new String[localArrayList1.size()]);
    String[] arrayOfString2 = (String[])localArrayList2.toArray(new String[localArrayList2.size()]);
    a(paramLong, arrayOfString1, 4);
    a(paramLong, arrayOfString2, 1);
  }

  public void a(long paramLong, Set<Long> paramSet1, Set<Long> paramSet2, GroupController.a parama)
  {
    this.b.a(paramLong, paramSet1, paramSet2, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.h
 * JD-Core Version:    0.6.2
 */