package com.viber.voip.block;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.j;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ay;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.cd;
import com.viber.voip.widget.c.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class g
{
  private static Set<Member> a = new HashSet();

  public static Set<Member> a(com.viber.voip.model.c paramc)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramc.s().iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      Member localMember2 = Member.from(localj);
      if (a(localMember2))
        localHashMap.put(localj.c(), localMember2);
    }
    Iterator localIterator2 = paramc.t().iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      if (!localHashMap.containsKey(str))
      {
        Member localMember1 = Member.fromVln(str);
        if (a(localMember1))
          localHashMap.put(str, localMember1);
      }
    }
    return new HashSet(localHashMap.values());
  }

  public static void a(Activity paramActivity, Set<Member> paramSet, String paramString, boolean paramBoolean, Runnable paramRunnable)
  {
    a(paramActivity.getWindow().getDecorView(), paramSet, paramString, paramBoolean, paramRunnable);
  }

  public static void a(Activity paramActivity, Set<Member> paramSet, String paramString, boolean paramBoolean1, Runnable paramRunnable, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramActivity.getWindow().getDecorView(), paramSet, paramString, paramBoolean1, paramRunnable, paramBoolean2, paramBoolean3);
  }

  public static void a(Context paramContext, com.viber.voip.model.c paramc, a parama)
  {
    Set localSet = a(paramc);
    if (!localSet.isEmpty())
      a(paramContext, localSet, paramc.k(), parama);
    while (parama == null)
      return;
    parama.a(localSet);
  }

  private static void a(Context paramContext, Set<Member> paramSet, String paramString, a parama)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = paramContext.getString(R.string.unknown);
    ViberDialogHandlers.ay localay = new ViberDialogHandlers.ay();
    localay.a = parama;
    localay.b = paramSet;
    t.a(com.viber.common.d.c.a(paramContext, R.string.dialog_424_title, new Object[] { paramString }), paramContext.getString(R.string.dialog_424_message, new Object[] { paramString, paramString })).a(localay).a(paramContext);
  }

  public static void a(View paramView, String paramString, Set<Member> paramSet, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, paramString, paramSet, false, paramRunnable, paramBoolean1, false, paramBoolean2);
  }

  public static void a(View paramView, String paramString, Set<Member> paramSet, boolean paramBoolean1, Runnable paramRunnable, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramView, paramString, paramSet, paramBoolean1, paramRunnable, paramBoolean2, true, paramBoolean3);
  }

  private static void a(View paramView, String paramString, final Set<Member> paramSet, final boolean paramBoolean1, final Runnable paramRunnable, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = 1;
    if ((paramSet == null) || (paramSet.size() == 0))
      throw new IllegalArgumentException();
    Member localMember = (Member)paramSet.iterator().next();
    boolean bool = cd.c(localMember.getPhoneNumber());
    int j;
    label89: String str;
    int k;
    if (!TextUtils.isEmpty(paramString))
      if ((paramSet.size() > i) || (bool))
      {
        Context localContext1 = paramView.getContext();
        if (!paramBoolean3)
          break label240;
        j = R.string.is_now_blocked;
        Object[] arrayOfObject1 = new Object[i];
        arrayOfObject1[0] = paramString;
        str = com.viber.common.d.c.a(localContext1, j, arrayOfObject1);
        if (!paramBoolean3)
          break label248;
        k = R.string.unblock;
        label122: if (!paramBoolean4)
          break label256;
      }
    while (true)
    {
      b localb = new b(-1, k, 4000L, i);
      com.viber.voip.widget.c.a.a(paramView, str, new com.viber.voip.widget.c.a.a()
      {
        public void a(Parcelable paramAnonymousParcelable)
        {
          if (this.a)
            g.b(paramSet);
          while (true)
          {
            if (paramRunnable != null)
              paramRunnable.run();
            return;
            g.a(paramSet, paramBoolean1);
          }
        }
      }
      , localb);
      return;
      Context localContext2 = paramView.getContext();
      int m = R.string.block_contacts_number;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[i] = localMember.getPhoneNumber();
      paramString = localContext2.getString(m, arrayOfObject2);
      break;
      if (bool)
      {
        paramString = paramView.getContext().getString(R.string.unknown);
        break;
      }
      paramString = localMember.getPhoneNumber();
      break;
      label240: j = R.string.is_now_unblocked;
      break label89;
      label248: k = R.string.reblock;
      break label122;
      label256: i = 0;
    }
  }

  public static void a(View paramView, Set<Member> paramSet, String paramString, boolean paramBoolean, Runnable paramRunnable)
  {
    a(paramView, paramString, paramSet, paramRunnable, false, paramBoolean);
    c(paramSet);
  }

  public static void a(View paramView, Set<Member> paramSet, String paramString, boolean paramBoolean1, Runnable paramRunnable, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramView, paramString, paramSet, paramBoolean1, paramRunnable, paramBoolean2, paramBoolean3);
    a(paramSet, paramBoolean1);
  }

  public static void a(Set<Member> paramSet)
  {
    a = paramSet;
  }

  public static void a(Set<Member> paramSet, boolean paramBoolean)
  {
    c().a(paramSet, paramBoolean);
  }

  public static boolean a(Context paramContext, Member paramMember, a parama)
  {
    Set localSet = Collections.singleton(paramMember);
    if (a(paramMember))
    {
      String str;
      if (!TextUtils.isEmpty(paramMember.getViberName()))
        str = paramMember.getViberName();
      while (true)
      {
        a(paramContext, localSet, str, parama);
        return true;
        if (!cd.c(paramMember.getPhoneNumber()))
          str = paramMember.getPhoneNumber();
        else
          str = paramContext.getString(R.string.unknown);
      }
    }
    if (parama != null)
      parama.a(localSet);
    return false;
  }

  public static boolean a(Member paramMember)
  {
    if (a.contains(paramMember));
    Member localMember;
    do
    {
      return true;
      localMember = cd.a(paramMember);
    }
    while ((localMember != null) && (a.contains(localMember)));
    return false;
  }

  public static boolean a(Member paramMember, boolean paramBoolean)
  {
    boolean bool = a(paramMember);
    if ((bool) && (paramBoolean))
    {
      if (!cd.a(paramMember.getId()))
        bool = true;
    }
    else
      return bool;
    return false;
  }

  public static Member[] a()
  {
    return (Member[])a.toArray(new Member[a.size()]);
  }

  public static void b()
  {
    a.clear();
  }

  private static com.viber.voip.contacts.c.a.a c()
  {
    return ViberApplication.getInstance().getContactManager().f();
  }

  private static void c(Set<Member> paramSet)
  {
    c().a(paramSet);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(Set<Member> paramSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.g
 * JD-Core Version:    0.6.2
 */