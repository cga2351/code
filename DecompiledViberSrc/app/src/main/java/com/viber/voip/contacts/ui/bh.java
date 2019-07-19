package com.viber.voip.contacts.ui;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.like.LikeController;
import com.viber.jni.like.LikeControllerDelegate.PublicGroupLikes;
import com.viber.jni.like.PublicGroupLikesListener;
import com.viber.jni.publicgroup.PgAction;
import com.viber.provider.d.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.adapters.l;
import com.viber.voip.messages.adapters.n;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.adapters.r;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv.i;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.conversation.e;
import com.viber.voip.messages.conversation.w;
import com.viber.voip.messages.conversation.x;
import com.viber.voip.messages.d.c;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.ui.aq;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bh extends aq
  implements m.c, LikeControllerDelegate.PublicGroupLikes, d.a, bv.i
{
  private static final Logger f = ViberEnv.getLogger();
  private int A;
  private long B;
  private final Comparator<p> C = bi.a;
  private bv.l D = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousLong2 == bh.a(bh.this))
      {
        if (bh.b(bh.this) == null)
          break label33;
        bh.b(bh.this).l();
      }
      label33: 
      while (bh.this.d)
        return;
      bh.this.a(bh.c(bh.this), bh.d(bh.this), bh.e(bh.this), bh.a(bh.this), bh.f(bh.this), bh.g(bh.this));
    }

    public void a(long paramAnonymousLong, Set paramAnonymousSet)
    {
      by.a(this, paramAnonymousLong, paramAnonymousSet);
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousMessageEntity, paramAnonymousBoolean);
    }

    public void a(Set paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousSet, paramAnonymousBoolean);
    }

    public void a(Set paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      by.a(this, paramAnonymousSet, paramAnonymousBoolean1, paramAnonymousBoolean2);
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  private com.viber.voip.ui.a.a E = new com.viber.voip.ui.a.a()
  {
    public void a(int paramAnonymousInt, View paramAnonymousView)
    {
      FragmentActivity localFragmentActivity = bh.this.getActivity();
      p localp = bh.h(bh.this).a(paramAnonymousInt);
      if ((localFragmentActivity == null) || (localp == null))
        return;
      if (localp.c() == 0)
      {
        ViberActionRunner.bt.d(localFragmentActivity);
        return;
      }
      ViberActionRunner.o.a(localFragmentActivity, bh.e(bh.this), bh.i(bh.this), localp.d(), localp.f());
    }
  };
  protected TextView a;
  protected TextView b;
  protected int c;
  protected boolean d;
  protected int e;
  private x g;
  private com.viber.voip.messages.conversation.d h;
  private l i;
  private View j;
  private View k;
  private RecyclerView l;
  private TextView m;
  private long n;
  private long o;
  private long p;
  private String q;
  private long r;
  private ProgressBar s;
  private int t = 1;
  private boolean u;
  private int v;
  private int w = 0;
  private int x;
  private List<p> y = new ArrayList();
  private Engine z;

  private void a(Set<String> paramSet, boolean paramBoolean)
  {
    int i1;
    if (this.y.size() > 0)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.l.setVisibility(0);
      if (((p)this.y.get(0)).c() == 0)
      {
        i1 = 1 + e();
        if ((this.u) && (paramSet != null) && (paramSet.contains(this.q)))
          i1++;
        p localp = a(paramBoolean, i1);
        this.y.add(0, localp);
        this.i.a(this.y);
        this.i.notifyDataSetChanged();
      }
    }
    while (true)
    {
      this.s.setVisibility(8);
      return;
      i1 = e();
      break;
      boolean bool1 = com.viber.voip.messages.m.e(this.t);
      dj.b(this.k, bool1);
      View localView = this.j;
      if (!bool1);
      for (boolean bool2 = true; ; bool2 = false)
      {
        dj.b(localView, bool2);
        this.l.setVisibility(8);
        if (!com.viber.voip.messages.m.a(this.t))
          break label220;
        c();
        break;
      }
      label220: if (com.viber.voip.messages.m.b(this.t))
        d();
      else
        a(paramBoolean);
    }
  }

  private boolean a()
  {
    return this.B > 0L;
  }

  private void b()
  {
    this.A = this.z.getPhoneController().generateSequence();
    this.z.getLikeController().handleGetPublicGroupLikes(this.A, this.p, this.x, this.x);
  }

  private void b(long paramLong)
  {
    this.h = new com.viber.voip.messages.conversation.d(getContext(), ViberApplication.getInstance().getMessagesManager().b(), getLoaderManager(), this, paramLong);
    this.h.p();
    this.h.i();
  }

  private void c()
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i1 = Math.max(this.v - this.e, 0);
    boolean bool;
    TextView localTextView;
    int i2;
    Object[] arrayOfObject1;
    if (i1 > 0)
    {
      bool = true;
      this.m.setEnabled(bool);
      localTextView = this.m;
      if (!bool)
        break label111;
      i2 = R.string.liked_by;
      arrayOfObject1 = new Object[1];
      int i3 = R.plurals.view_public_followers_likes_header;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = da.b(i1);
      arrayOfObject1[0] = localResources.getQuantityString(i3, i1, arrayOfObject2);
    }
    label111: for (String str = localResources.getString(i2, arrayOfObject1); ; str = localResources.getString(R.string.have_no_likes))
    {
      localTextView.setText(str);
      return;
      bool = false;
      break;
    }
  }

  private void d()
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i1 = Math.max(this.v - this.e, 0);
    boolean bool;
    TextView localTextView;
    int i2;
    Object[] arrayOfObject1;
    if (i1 > 0)
    {
      bool = true;
      this.m.setEnabled(bool);
      localTextView = this.m;
      if (!bool)
        break label111;
      i2 = R.string.liked_by;
      arrayOfObject1 = new Object[1];
      int i3 = R.plurals.view_community_followers_likes_header;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = da.b(i1);
      arrayOfObject1[0] = localResources.getQuantityString(i3, i1, arrayOfObject2);
    }
    label111: for (String str = localResources.getString(i2, arrayOfObject1); ; str = localResources.getString(R.string.have_no_likes))
    {
      localTextView.setText(str);
      return;
      bool = false;
      break;
    }
  }

  private int e()
  {
    if (a())
      return this.c;
    if (this.u)
      return -2 + this.c;
    return -1 + this.c;
  }

  protected p a(boolean paramBoolean, int paramInt)
  {
    if (com.viber.voip.messages.m.a(this.t))
    {
      int i2 = Math.max(this.v - this.e, 0);
      return new r(R.plurals.view_public_likes_header, i2, this.e);
    }
    if (com.viber.voip.messages.m.b(this.t))
    {
      int i1 = Math.max(this.v - this.e, 0);
      return new com.viber.voip.messages.adapters.m(R.plurals.view_community_likes_header, i1, this.e);
    }
    if (paramBoolean)
      return new n(R.string.message_info_seen_by_title, this.y.size(), Math.max(this.y.size(), paramInt));
    return new com.viber.voip.messages.adapters.o(R.plurals.view_likes_header, this.y.size());
  }

  public void a(int paramInt1, int paramInt2, long paramLong, List<w> paramList, Set<String> paramSet)
  {
    if (paramLong != this.n)
      return;
    switch (paramInt2)
    {
    default:
      this.d = true;
      com.viber.voip.messages.controller.manager.o.a().b(this);
      a(paramLong);
      return;
    case 0:
    }
    this.y.clear();
    this.y.addAll(paramList);
    Collections.sort(this.y, this.C);
    if (paramSet != null);
    for (int i1 = paramSet.size(); ; i1 = 0)
    {
      this.e = i1;
      if (com.viber.voip.messages.m.e(this.t))
        break;
      a(paramSet, true);
      return;
    }
    b();
  }

  protected void a(long paramLong)
  {
    this.g = new x(getActivity(), getLoaderManager(), this, paramLong, com.viber.voip.h.a.b());
    this.g.p();
    this.g.i();
  }

  protected void a(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, String paramString)
  {
    ViberApplication.getInstance().getMessagesManager().d().a(paramLong1, paramLong2, paramInt, paramLong3, paramLong4, paramString);
  }

  protected void a(boolean paramBoolean)
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    TextView localTextView1 = this.b;
    String str1;
    TextView localTextView2;
    String str3;
    Object[] arrayOfObject;
    if (paramBoolean)
    {
      str1 = localResources.getString(R.string.message_info_no_seen_title);
      localTextView1.setText(str1);
      localTextView2 = this.a;
      if (!paramBoolean)
        break label104;
      str3 = localResources.getString(R.string.message_info_seen_by_title);
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.toString(0);
      arrayOfObject[1] = Integer.toString(e());
    }
    label104: for (String str2 = String.format(str3, arrayOfObject); ; str2 = localResources.getString(R.string.view_likes_empty_header))
    {
      localTextView2.setText(str2);
      return;
      str1 = localResources.getString(R.string.message_likes_no_seen_text);
      break;
    }
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Bundle localBundle = getArguments();
    this.B = localBundle.getLong("extra_broadcast_msg_id");
    if (a())
    {
      this.c = 0;
      this.i = new l(getActivity(), com.viber.voip.messages.m.e(this.t), this.t, this.w, this.E, c.c(), getLayoutInflater());
      this.l.setAdapter(this.i);
      this.z = ViberApplication.getInstance().getEngine(false);
      if (!a())
        break label237;
      b(this.B);
    }
    label237: 
    while (!cj.a(this, true))
    {
      return;
      this.p = localBundle.getLong("group_id", 0L);
      this.o = localBundle.getLong("message_time", 0L);
      this.n = localBundle.getLong("message_token", 0L);
      this.c = localBundle.getInt("extra_participant_counts", 0);
      this.t = localBundle.getInt("extra_conversation_type", 1);
      this.u = localBundle.getBoolean("extra_is_incoming", true);
      this.q = localBundle.getString("extra_sender_member_id", "");
      this.x = localBundle.getInt("extra_message_global_id", 0);
      this.w = localBundle.getInt("extra_group_role", 0);
      this.r = localBundle.getLong("extra_conversation_id", 0L);
      break;
    }
    a(this.r, this.p, this.t, this.n, this.o, this.q);
    com.viber.voip.messages.controller.manager.o.a().a(this.D);
    com.viber.voip.messages.controller.manager.o.a().a(this);
    this.z.getDelegatesManager().getPublicGroupLikesListener().registerDelegate(this, av.e.a.a());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.activity_message_info, paramViewGroup, false);
    this.j = localView.findViewById(R.id.empty_layout);
    this.k = localView.findViewById(R.id.public_empty_layout);
    this.a = ((TextView)localView.findViewById(R.id.info_summary));
    this.l = ((RecyclerView)localView.findViewById(R.id.msg_info_list));
    this.b = ((TextView)localView.findViewById(R.id.empty_text_message));
    this.m = ((TextView)localView.findViewById(R.id.heart_text_message));
    this.s = ((ProgressBar)localView.findViewById(R.id.progress_indicator));
    return localView;
  }

  public void onDestroy()
  {
    com.viber.voip.messages.controller.manager.o.a().b(this);
    com.viber.voip.messages.controller.manager.o.a().b(this.D);
    if (!a())
      this.z.getDelegatesManager().getPublicGroupLikesListener().removeDelegate(this);
    if (this.h != null)
      this.h.q();
    super.onDestroy();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    getActivity().finish();
  }

  public void onGetPublicGroupLikes(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Map<Integer, PgAction> paramMap, int paramInt3)
  {
    if (this.A != paramInt1)
      return;
    this.v = 0;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() == this.x)
        this.v = ((PgAction)localEntry.getValue()).getLikeCount();
    }
    a(null, false);
  }

  public void onLikePublicGroupMessage(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, int paramInt3)
  {
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    int i1 = 0;
    if (getActivity() == null);
    do
    {
      return;
      this.y.clear();
      if (this.g == paramd)
      {
        for (int i2 = 0; i2 < paramd.getCount(); i2++)
          this.y.add(this.g.e(i2));
        this.e = this.y.size();
        if (!com.viber.voip.messages.m.e(this.t))
        {
          a(null, false);
          return;
        }
        b();
        return;
      }
    }
    while ((this.h != paramd) || (this.h == null));
    this.c = paramd.getCount();
    while (i1 < this.c)
    {
      e locale = this.h.e(i1);
      if (locale.a())
        this.y.add(locale);
      i1++;
    }
    a(null, true);
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onSyncMessageLike(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.bh
 * JD-Core Version:    0.6.2
 */