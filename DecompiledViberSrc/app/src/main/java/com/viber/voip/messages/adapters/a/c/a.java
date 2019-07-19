package com.viber.voip.messages.adapters.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ui.ck;
import com.viber.voip.messages.i;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.registration.af;
import com.viber.voip.ui.ac;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class a extends com.viber.voip.ui.g.a.a
{
  private com.viber.voip.messages.conversation.adapter.a.c.a.d A;
  private i B;
  private b C = new b(this);
  private b D = new c(this);
  private b E = new d(this);
  private final MessagesFragmentModeManager a;
  private final SparseArray<Drawable> b;
  private ac c;
  private final String d;
  private final String e;
  private final boolean f;
  private final String g;
  private final String h;
  private String i;
  private String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final boolean o;
  private final boolean p;
  private boolean q;
  private Map<String, ck> r = new HashMap();
  private LongSparseArray<Collection<ck>> s = new LongSparseArray();
  private a t = a.a;
  private com.viber.voip.messages.controller.manager.k u;
  private af w;
  private com.viber.voip.messages.d.b x;
  private Drawable y;
  private final com.viber.voip.messages.adapters.a.c.a.a z;

  public a(Context paramContext, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext);
    Resources localResources = this.v.getResources();
    this.b = new SparseArray();
    this.a = paramMessagesFragmentModeManager;
    this.f = paramBoolean2;
    this.d = localResources.getString(R.string.thread_no_messages_text);
    this.e = localResources.getString(R.string.facebook_media_type_text);
    this.g = localResources.getString(R.string.you);
    this.h = localResources.getString(R.string.conversation_me);
    this.k = localResources.getString(R.string.default_group_name);
    this.l = localResources.getString(R.string.broadcast_list);
    this.m = localResources.getString(R.string.push_notification_user_engagement_without_offer);
    this.n = localResources.getString(R.string.push_notification_user_engagement_without_offer_v1);
    this.o = paramBoolean1;
    this.p = paramBoolean3;
    this.z = new com.viber.voip.messages.adapters.a.c.a.a(paramContext);
    this.A = new com.viber.voip.messages.conversation.adapter.a.c.a.d(paramContext);
    this.B = i.a();
  }

  private com.viber.voip.messages.controller.manager.k G()
  {
    if (this.u == null)
      this.u = ViberApplication.getInstance().getMessagesManager().a();
    return this.u;
  }

  private Drawable a(int paramInt1, int paramInt2, b paramb)
  {
    Drawable localDrawable = (Drawable)this.b.get(paramInt1 + paramInt2);
    if (localDrawable == null)
    {
      localDrawable = ContextCompat.getDrawable(this.v, paramInt1);
      if (localDrawable != null)
      {
        if (paramb != null)
          paramb.a(localDrawable);
        this.b.put(paramInt1 + paramInt2, localDrawable);
      }
    }
    return localDrawable;
  }

  public com.viber.voip.messages.adapters.a.c.a.a A()
  {
    return this.z;
  }

  public String B()
  {
    return this.m;
  }

  public String C()
  {
    return this.n;
  }

  public Drawable D()
  {
    return a(R.drawable.ic_message_balloon_item_sent_status_white, 0, this.E);
  }

  public Drawable E()
  {
    return a(R.drawable.ic_message_balloon_item_delivered_status_white, 0, this.E);
  }

  public Drawable F()
  {
    if (this.y == null)
    {
      this.y = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_delivered_status_white);
      int i1 = ContextCompat.getColor(this.v, R.color.medium_slate_blue);
      df.a(this.y, i1, true);
    }
    return this.y;
  }

  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (((paramBoolean2) && (paramBoolean1)) || (paramBoolean3))
      return dc.d(this.v, R.attr.unreadBadgeCommunityColor);
    return dc.d(this.v, R.attr.unreadBadgeColor);
  }

  public Drawable a(int paramInt)
  {
    return a(paramInt, 0, null);
  }

  public Drawable a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, new e(this, paramInt2));
  }

  public af a()
  {
    if (this.w == null)
      this.w = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return this.w;
  }

  public String a(long paramLong, int paramInt1, int paramInt2)
  {
    Collection localCollection = (Collection)this.s.get(paramLong);
    if ((localCollection != null) && (!localCollection.isEmpty()))
      return b().a(this.v.getResources(), localCollection, paramInt1, paramInt2, 1);
    return "";
  }

  public String a(String paramString)
  {
    return this.v.getString(R.string.user_engagement_new_preview_text, new Object[] { paramString });
  }

  public String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
      i1 = 1;
    while (true)
    {
      String str = paramString + i1;
      ck localck = (ck)this.r.get(str);
      if (localck != null)
      {
        return b().a(this.v.getResources(), localck, paramInt, 0, 1);
        if (paramBoolean2)
          i1 = 2;
      }
      else
      {
        return "";
        i1 = 0;
      }
    }
  }

  public void a(long paramLong, Collection<ck> paramCollection)
  {
    if (paramCollection.isEmpty())
    {
      this.s.remove(paramLong);
      return;
    }
    this.s.put(paramLong, paramCollection);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    ViberApplication.getInstance().getMessagesManager().c().d(paramLong, paramBoolean);
  }

  public void a(a parama)
  {
    this.t = parama;
  }

  public void a(ac paramac)
  {
    this.c = paramac;
  }

  public void a(String paramString, int paramInt, ck paramck, boolean paramBoolean)
  {
    String str = paramString + paramInt;
    if (paramBoolean)
    {
      this.r.put(str, paramck);
      return;
    }
    this.r.remove(str);
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public boolean a(long paramLong)
  {
    return G().c(paramLong);
  }

  public Drawable b(boolean paramBoolean)
  {
    if (paramBoolean)
      return a(R.drawable.hidden_chat_overlay);
    return null;
  }

  public com.viber.voip.messages.d.b b()
  {
    if (this.x == null)
      this.x = com.viber.voip.messages.d.c.c();
    return this.x;
  }

  public String b(String paramString)
  {
    return this.v.getString(R.string.user_engagement_back_preview_text, new Object[] { paramString });
  }

  public a c()
  {
    return this.t;
  }

  public void d()
  {
    this.r.clear();
    this.s.clear();
  }

  public String e()
  {
    return this.d;
  }

  public String f()
  {
    return this.e;
  }

  public Drawable g()
  {
    return a(R.drawable.icon_viber_contact);
  }

  public Drawable h()
  {
    return a(R.drawable.ic_rakuten_system);
  }

  public Drawable i()
  {
    return a(R.drawable.ic_chat_list_verified_account);
  }

  public Drawable j()
  {
    return a(R.drawable.ic_muted, 0, this.C);
  }

  public Drawable k()
  {
    return a(R.drawable.ic_snoozed, 0, this.C);
  }

  public Drawable l()
  {
    return a(R.drawable.ic_muted_verified, 0, this.D);
  }

  public Drawable m()
  {
    return dc.g(this.v, R.attr.unreadBadgeBackground);
  }

  public Drawable n()
  {
    return dc.g(this.v, R.attr.conversationsListItemBadgeAsteriskBackground);
  }

  public Drawable o()
  {
    return dc.g(this.v, R.attr.listItemActivatedBackground);
  }

  public String p()
  {
    if ((this.c != null) && (this.c.e()) && ((w()) || (a.a != this.t)))
      return this.c.a();
    return "";
  }

  public boolean q()
  {
    return (this.a != null) && (this.a.l());
  }

  public String r()
  {
    if (this.i == null)
      this.i = com.viber.common.d.c.a(this.g);
    return this.i;
  }

  public String s()
  {
    if (this.j == null)
      this.j = com.viber.common.d.c.a(this.h);
    return this.j;
  }

  public String t()
  {
    return this.k;
  }

  public String u()
  {
    return this.l;
  }

  public i v()
  {
    return this.B;
  }

  public boolean w()
  {
    return this.o;
  }

  public boolean x()
  {
    return this.p;
  }

  public boolean y()
  {
    return this.f;
  }

  public boolean z()
  {
    return this.q;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  private static abstract interface b
  {
    public abstract void a(Drawable paramDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.c.a
 * JD-Core Version:    0.6.2
 */