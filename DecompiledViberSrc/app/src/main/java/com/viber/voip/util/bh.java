package com.viber.voip.util;

import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class bh
{
  public static boolean a(Intent paramIntent1, Intent paramIntent2)
  {
    if (paramIntent1 == paramIntent2)
      return true;
    if ((paramIntent1 == null) || (paramIntent2 == null))
      return false;
    if (!paramIntent1.filterEquals(paramIntent2))
      return false;
    Bundle localBundle1 = paramIntent1.getExtras();
    Bundle localBundle2 = paramIntent2.getExtras();
    if ((localBundle1 == null) && (localBundle2 == null))
      return true;
    if ((localBundle1 == null) || (localBundle2 == null))
      return false;
    if (localBundle1.size() != localBundle2.size())
      return false;
    Iterator localIterator = localBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!localBundle2.containsKey(str))
        return false;
      Object localObject1 = localBundle1.get(str);
      Object localObject2 = localBundle2.get(str);
      if ((localObject1 != null) && (!localObject1.equals(localObject2)))
        return false;
      if ((localObject1 == null) && (localObject2 != null))
        return false;
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bh
 * JD-Core Version:    0.6.2
 */