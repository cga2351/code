package com.viber.voip.banner.d;

import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupsFragment;
import com.viber.voip.messages.conversation.publicaccount.TabletPublicGroupConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.ui.bn;
import com.viber.voip.phone.viber.endcall.EndCallFragment;
import dagger.a;
import java.util.HashMap;

public enum b
{
  private static HashMap<Class<?>, b> h;
  private static a<HashMap<Class<?>, b>> i = new com.viber.voip.g.b.b()
  {
    protected HashMap<Class<?>, b> a()
    {
      HashMap localHashMap = new HashMap(8, 1.0F);
      localHashMap.put(ContactsFragment.class, b.a);
      localHashMap.put(PublicGroupsFragment.class, b.d);
      localHashMap.put(bn.class, b.b);
      localHashMap.put(TabletPublicGroupConversationFragment.class, b.f);
      localHashMap.put(ConversationFragment.class, b.e);
      localHashMap.put(EndCallFragment.class, b.g);
      return localHashMap;
    }
  };
  private final String j;

  static
  {
    b[] arrayOfb = new b[7];
    arrayOfb[0] = a;
    arrayOfb[1] = b;
    arrayOfb[2] = c;
    arrayOfb[3] = d;
    arrayOfb[4] = e;
    arrayOfb[5] = f;
    arrayOfb[6] = g;
    k = arrayOfb;
    h = new HashMap(8, 1.0F);
    h.put(ContactsFragment.class, a);
    h.put(PublicGroupsFragment.class, d);
    h.put(bn.class, b);
    h.put(PublicGroupConversationFragment.class, f);
    h.put(ConversationFragment.class, e);
    h.put(EndCallFragment.class, g);
  }

  private b(String paramString)
  {
    this.j = paramString;
  }

  public static b a(Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean)
      return (b)((HashMap)i.get()).get(paramObject.getClass());
    return (b)h.get(paramObject.getClass());
  }

  public static b a(String paramString)
  {
    for (b localb : values())
      if (localb.a().equalsIgnoreCase(paramString))
        return localb;
    return b;
  }

  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
      i.get();
  }

  public String a()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.b
 * JD-Core Version:    0.6.2
 */