package com.viber.voip.messages.conversation.community.b;

import android.text.TextUtils;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  public Map<String, String> a(Set<GroupController.GroupMember> paramSet)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      GroupController.GroupMember localGroupMember = (GroupController.GroupMember)localIterator.next();
      String str1 = localGroupMember.mClientName;
      String str2 = localGroupMember.mMID;
      if (TextUtils.isEmpty(str1));
      for (String str3 = localGroupMember.mPhoneNumber; ; str3 = str1)
      {
        localHashMap.put(str2, str3);
        break;
      }
    }
    return localHashMap;
  }

  public Set<GroupController.GroupMember> a(List<GroupController.GroupMember> paramList, Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GroupController.GroupMember localGroupMember = (GroupController.GroupMember)localIterator.next();
      if (paramSet.contains(localGroupMember.mMID))
        localHashSet.add(localGroupMember);
    }
    return localHashSet;
  }

  public static class a
  {
    private a a;
    private Map<String, String> b = new HashMap();
    private Map<String, String> c;

    public a(Map<String, String> paramMap, a parama)
    {
      this.c = paramMap;
      this.a = parama;
    }

    public Map<String, String> a()
    {
      return this.b;
    }

    public void a(Map.Entry<String, Integer> paramEntry)
    {
      if (this.a.a(paramEntry))
        this.b.put(paramEntry.getKey(), this.c.get(paramEntry.getKey()));
    }

    public static abstract interface a
    {
      public abstract boolean a(Map.Entry<String, Integer> paramEntry);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.b.b
 * JD-Core Version:    0.6.2
 */