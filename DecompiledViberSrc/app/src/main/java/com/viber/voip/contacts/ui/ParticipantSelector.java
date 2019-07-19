package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.common.dialogs.y;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.a;
import com.viber.voip.messages.a.c.f;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.community.CreateCommunityActivity;
import com.viber.voip.model.j;
import com.viber.voip.registration.af;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bm;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cn;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.f;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.util.cd;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dr.a;
import com.viber.voip.util.u;
import com.viber.voip.util.x;
import com.viber.voip.util.x.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ParticipantSelector extends bv.t
{
  private static final Logger h = ViberEnv.getLogger();
  private Set<Participant> A = new HashSet();
  private volatile boolean B;
  private Participant C;
  private final String D;
  private final com.viber.voip.analytics.story.e.c E;
  protected FragmentActivity a;
  protected final s.a b;
  protected Map<Participant, a> c = new HashMap();
  protected Map<Participant, a> d = new HashMap();
  protected Map<Participant, a> e = new HashMap();
  protected boolean f;
  protected c g;
  private final boolean i;
  private final int j;
  private int k;
  private final f l;
  private final GroupController m;
  private final OnlineUserActivityHelper n;
  private final bv o;
  private final EventBus p;
  private final ab q;
  private final ak r;
  private final com.viber.voip.messages.controller.a s;
  private e t;
  private final af u;
  private final Handler v;
  private final Handler w;
  private final Handler x;
  private int y;
  private Map<Participant, a> z = new HashMap();

  public ParticipantSelector(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, e parame, af paramaf, s.a parama, bv parambv, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, com.viber.voip.messages.controller.a parama1, ab paramab, ak paramak, int paramInt, String paramString, com.viber.voip.analytics.story.e.c paramc)
  {
    this(paramFragmentActivity, paramHandler1, paramHandler2, paramHandler3, parame, paramaf, parama, parambv, paramEventBus, paramOnlineUserActivityHelper, paramGroupController, parama1, paramab, paramak, paramInt, true, paramString, paramc, f.a);
  }

  public ParticipantSelector(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, e parame, af paramaf, s.a parama, bv parambv, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, com.viber.voip.messages.controller.a parama1, ab paramab, ak paramak, int paramInt, boolean paramBoolean, String paramString, com.viber.voip.analytics.story.e.c paramc, f paramf)
  {
    this(paramFragmentActivity, paramHandler1, paramHandler2, paramHandler3, parame, paramaf, parama, parambv, paramEventBus, paramOnlineUserActivityHelper, paramGroupController, parama1, paramab, paramak, paramInt, paramBoolean, false, paramString, paramc, paramf);
  }

  public ParticipantSelector(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, e parame, af paramaf, s.a parama, bv parambv, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, com.viber.voip.messages.controller.a parama1, ab paramab, ak paramak, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, com.viber.voip.analytics.story.e.c paramc, f paramf)
  {
    this.a = paramFragmentActivity;
    this.v = paramHandler1;
    this.w = paramHandler2;
    this.x = paramHandler3;
    this.t = parame;
    this.b = parama;
    this.u = paramaf;
    this.i = paramBoolean2;
    this.j = a(paramInt, paramBoolean1);
    this.k = this.j;
    this.n = paramOnlineUserActivityHelper;
    this.m = paramGroupController;
    this.s = parama1;
    this.q = paramab;
    this.r = paramak;
    this.o = parambv;
    this.o.a(this);
    this.p = paramEventBus;
    this.p.register(this);
    this.D = paramString;
    this.E = paramc;
    this.l = paramf;
  }

  public ParticipantSelector(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, e parame, af paramaf, s.a parama, bv parambv, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, com.viber.voip.messages.controller.a parama1, ab paramab, ak paramak, String paramString, com.viber.voip.analytics.story.e.c paramc)
  {
    this(paramFragmentActivity, paramHandler1, paramHandler2, paramHandler3, parame, paramaf, parama, parambv, paramEventBus, paramOnlineUserActivityHelper, paramGroupController, parama1, paramab, paramak, -1, paramString, paramc);
  }

  private int a(int paramInt)
  {
    if (b())
    {
      int i1 = this.j - paramInt;
      if ((this.l == f.b) || (this.l == f.d))
        i1 = Math.min(i1, 50);
      return i1;
    }
    return -1;
  }

  static int a(int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramInt != i1)
      if (!paramBoolean)
        break label19;
    label19: for (int i2 = 1; ; i2 = 0)
    {
      i1 = paramInt - i2;
      return i1;
    }
  }

  private String a(f paramf)
  {
    return "add_participants_dialog";
  }

  private static Map<GroupController.GroupMember, a> a(Map<Participant, a> paramMap, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a locala = (a)localEntry.getValue();
      if ((!paramBoolean) || (!locala.c))
      {
        Participant localParticipant = (Participant)localEntry.getKey();
        localHashMap.put(new GroupController.GroupMember(localParticipant.getMemberId(), "", localParticipant.getNumber(), localParticipant.mDisplayName, null, null, 0), locala);
      }
    }
    return localHashMap;
  }

  private Set<Participant> a(Map<Participant, a> paramMap, b paramb)
  {
    if (paramb == null)
      return new HashSet(paramMap.keySet());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Participant localParticipant = (Participant)localIterator.next();
      if (paramb.isParticipantValid(localParticipant, (a)paramMap.get(localParticipant)))
        localArrayList.add(localParticipant);
    }
    return new HashSet(localArrayList);
  }

  private void a(int paramInt, Participant paramParticipant)
  {
    if ((this.a == null) || (this.a.isFinishing()))
      return;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      String str = this.a.getString(R.string.secret_chat_update_message);
      l.a locala = ad.a(paramParticipant.getMemberId(), paramParticipant.getNumber(), str, this.b);
      int i1 = R.string.dialog_c44_message;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramParticipant.getDisplayName();
      locala.b(i1, arrayOfObject).a(false).a(this.a);
      return;
    case 2:
      com.viber.voip.ui.dialogs.f.b().a(this.a);
      return;
    case 1:
    }
    a(paramParticipant.getMemberId(), paramParticipant.getNumber(), paramParticipant.getDisplayName());
  }

  private void a(final Activity paramActivity, final String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener)
  {
    l.a locala = com.viber.voip.ui.dialogs.d.c(paramString2);
    if (paramOnClickListener == null);
    for (boolean bool = true; ; bool = false)
    {
      locala.b(bool).a(new m.a()
      {
        public void onDialogAction(com.viber.common.dialogs.m paramAnonymousm, int paramAnonymousInt)
        {
          if (paramAnonymousInt == -1)
          {
            locala = com.viber.voip.ui.dialogs.d.n().a(false);
            localOnClickListener = paramOnClickListener;
            bool = false;
            if (localOnClickListener == null)
              bool = true;
            locala.b(bool).a(new m.a()
            {
              public void onDialogAction(com.viber.common.dialogs.m paramAnonymous2m, int paramAnonymous2Int)
              {
                if (paramAnonymous2Int == -1)
                  ParticipantSelector.b(ParticipantSelector.this, ParticipantSelector.6.this.b);
                while ((paramAnonymous2Int != -2) || (ParticipantSelector.6.this.a == null))
                  return;
                ParticipantSelector.6.this.a.onClick(paramAnonymous2m.getDialog(), -1);
              }
            }).a(paramActivity);
          }
          while ((paramAnonymousInt != -2) || (paramOnClickListener == null))
          {
            com.viber.common.dialogs.a.a locala;
            DialogInterface.OnClickListener localOnClickListener;
            boolean bool;
            return;
          }
          paramOnClickListener.onClick(paramAnonymousm.getDialog(), -1);
        }
      }).a(paramActivity);
      return;
    }
  }

  private void a(Activity paramActivity, Map<String, Integer> paramMap, Map<String, String> paramMap1, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    HashMap localHashMap5 = new HashMap();
    if (paramBoolean)
    {
      Iterator localIterator2 = paramMap.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        switch (((Integer)localEntry2.getValue()).intValue())
        {
        default:
          localHashMap3.put(localEntry2.getKey(), paramMap1.get(localEntry2.getKey()));
          break;
        case 2:
          localHashMap2.put(localEntry2.getKey(), paramMap1.get(localEntry2.getKey()));
          break;
        case 7:
          localHashMap4.put(localEntry2.getKey(), paramMap1.get(localEntry2.getKey()));
        }
      }
    }
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      switch (((Integer)localEntry1.getValue()).intValue())
      {
      case 5:
      case 6:
      case 7:
      case 9:
      case 11:
      case 12:
      default:
      case 3:
      case 4:
      case 13:
      case 10:
      case 8:
      }
      do
      {
        localHashMap3.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
        break;
        localHashMap1.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
        break;
        localHashMap2.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
        break;
        localHashMap5.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
        break;
        localHashMap4.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
        break;
      }
      while (this.l != f.c);
      localHashMap4.put(localEntry1.getKey(), paramMap1.get(localEntry1.getKey()));
    }
    a(paramActivity, a(new ar(this, paramMap)), localHashMap1, localHashMap2, localHashMap3, localHashMap4, localHashMap5, paramOnClickListener);
  }

  private void a(Activity paramActivity, Map<String, Integer> paramMap, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (!paramBoolean) && (this.l == f.b))
    {
      a(paramMap, paramOnClickListener);
      return;
    }
    b(paramActivity, paramMap, paramBoolean, paramOnClickListener);
  }

  private void a(Participant paramParticipant, boolean paramBoolean)
  {
    if (this.z.containsKey(paramParticipant))
      this.e.put(paramParticipant, new a(paramParticipant, null).a(true).c(paramBoolean).b(paramBoolean));
    while (true)
    {
      if (paramBoolean)
        this.z.put(paramParticipant, new a());
      if (this.t != null)
        this.t.onParticipantSelected(true, paramParticipant);
      return;
      this.c.put(paramParticipant, new a(paramParticipant, null).a(true).c(paramBoolean).b(paramBoolean));
    }
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.l == f.c);
    for (boolean bool = true; ; bool = false)
    {
      Intent localIntent = com.viber.voip.messages.m.a(paramString1, paramString2, paramString3, bool, false, false, false);
      this.b.a(localIntent);
      return;
    }
  }

  private void a(final Map<String, Integer> paramMap)
  {
    a(this.a, paramMap, false, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((paramMap != null) && (paramMap.size() < ParticipantSelector.this.c.size()))
        {
          Intent localIntent = ParticipantSelector.this.a.getIntent();
          localIntent.putParcelableArrayListExtra("added_participants", new ArrayList(ParticipantSelector.this.f()));
          ParticipantSelector.this.a.setResult(-1, localIntent);
        }
        ParticipantSelector.this.a.finish();
      }
    });
  }

  private void a(final Map<String, Integer> paramMap, final DialogInterface.OnClickListener paramOnClickListener)
  {
    GroupController.GroupMember[] arrayOfGroupMember = b(c(true));
    new com.viber.voip.messages.conversation.community.a.a(this.a, Arrays.asList(arrayOfGroupMember), paramOnClickListener, new com.viber.voip.messages.conversation.community.a.d()
    {
      public void a()
      {
        ParticipantSelector.a(ParticipantSelector.this, ParticipantSelector.this.a, paramMap, false, paramOnClickListener);
      }
    }).a(paramMap);
  }

  private static Participant b(Participant paramParticipant, Participant[] paramArrayOfParticipant)
  {
    int i1 = paramArrayOfParticipant.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      Participant localParticipant = paramArrayOfParticipant[i2];
      if (localParticipant.equals(paramParticipant))
        return localParticipant;
    }
    return null;
  }

  private void b(final long paramLong, Map<String, Integer> paramMap)
  {
    d("loading_dialog");
    a(this.a, paramMap, true, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ParticipantSelector.this.b.a(com.viber.voip.messages.m.a(paramLong, false));
      }
    });
  }

  private void b(Activity paramActivity, Map<String, Integer> paramMap, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Set localSet = a(new b()
      {
        public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
        {
          return this.a.contains(paramAnonymousParticipant.getMemberId());
        }
      });
      HashMap localHashMap = new HashMap();
      Iterator localIterator = localSet.iterator();
      if (localIterator.hasNext())
      {
        Participant localParticipant = (Participant)localIterator.next();
        String str1 = localParticipant.getDisplayName();
        String str2 = localParticipant.getMemberId();
        if (TextUtils.isEmpty(str1));
        for (String str3 = localParticipant.getNumber(); ; str3 = str1)
        {
          localHashMap.put(str2, str3);
          break;
        }
      }
      a(paramActivity, paramMap, localHashMap, paramBoolean, paramOnClickListener);
      return;
    }
    a(paramActivity, paramBoolean, paramOnClickListener);
  }

  private void b(String paramString)
  {
    c("loading_dialog");
    this.x.post(new av(this, paramString));
  }

  private void b(Map<Participant, com.viber.voip.model.entity.l> paramMap, boolean paramBoolean, int paramInt)
  {
    t().clear();
    this.d.clear();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((com.viber.voip.model.entity.l)localEntry.getValue()).d() == 0)
        if ((cd.c(paramInt)) && (cd.a(((com.viber.voip.model.entity.l)localEntry.getValue()).e())))
        {
          this.z.put(localEntry.getKey(), new a());
        }
        else
        {
          Map localMap = this.c;
          Object localObject = localEntry.getKey();
          a locala = new a().a(true);
          if (!paramBoolean);
          for (boolean bool = true; ; bool = false)
          {
            localMap.put(localObject, locala.b(bool).c(true));
            this.d.put(localEntry.getKey(), new a());
            break;
          }
        }
    }
  }

  private void b(Set<Participant> paramSet)
  {
    if (!u.a(paramSet))
    {
      this.k -= paramSet.size();
      if (this.k < 0)
        this.k = 0;
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
        a((Participant)localIterator.next(), true);
    }
  }

  private GroupController.GroupMember[] b(Map<GroupController.GroupMember, a> paramMap)
  {
    Set localSet = paramMap.keySet();
    return (GroupController.GroupMember[])localSet.toArray(new GroupController.GroupMember[localSet.size()]);
  }

  private Map<GroupController.GroupMember, a> c(boolean paramBoolean)
  {
    return a(this.c, paramBoolean);
  }

  private void c(long paramLong, Map<String, Integer> paramMap)
  {
    if (paramMap != null);
    for (int i1 = this.c.size() - paramMap.size(); ; i1 = this.c.size())
    {
      this.E.a(String.valueOf(paramLong), this.D, i1 + 1);
      return;
    }
  }

  private void c(String paramString)
  {
    int i1;
    if (paramString.equals("loading_dialog"))
      i1 = R.string.loading;
    while (true)
    {
      if (i1 != -1)
        ad.a(i1).a(this.a);
      return;
      if (paramString.equals("add_participants_dialog"))
        i1 = R.string.dialog_add_participants;
      else if (paramString.equals("check_number_dialog"))
        i1 = R.string.dialog_check_number;
      else
        i1 = -1;
    }
  }

  private void d(String paramString)
  {
    if ((this.a != null) && (!this.a.isFinishing()))
      z.b(this.a.getSupportFragmentManager(), DialogCode.D_PROGRESS);
  }

  private boolean e(Participant paramParticipant)
  {
    String str1 = paramParticipant.getMemberId();
    if (str1.equals(this.u.l()))
    {
      n();
      return false;
    }
    if (this.A.contains(paramParticipant))
    {
      if (!p())
        return false;
      String str2 = paramParticipant.getDisplayName();
      if (TextUtils.isEmpty(str2))
        str2 = paramParticipant.getNumberOrUnknown(this.a.getApplicationContext());
      a(this.a, str1, str2, null);
      return false;
    }
    b(paramParticipant);
    return true;
  }

  private void f(final Participant paramParticipant)
  {
    this.w.post(new Runnable()
    {
      public void run()
      {
        final int i = ParticipantSelector.b(ParticipantSelector.this, paramParticipant);
        ParticipantSelector.b(ParticipantSelector.this).post(new Runnable()
        {
          public void run()
          {
            ParticipantSelector.a(ParticipantSelector.this, "loading_dialog");
            ParticipantSelector.a(ParticipantSelector.this, i, ParticipantSelector.4.this.a);
          }
        });
      }
    });
  }

  private int g(Participant paramParticipant)
  {
    boolean[] arrayOfBoolean = com.viber.voip.messages.m.a(paramParticipant.getMemberId(), 4L);
    int i2;
    if (arrayOfBoolean[1] != 0)
      i2 = 2;
    int i1;
    do
    {
      return i2;
      i1 = arrayOfBoolean[0];
      i2 = 0;
    }
    while (i1 == 0);
    return 1;
  }

  private void o()
  {
    if (this.g != null)
      this.g.a();
  }

  private boolean p()
  {
    return (this.a != null) && (!this.a.isFinishing());
  }

  private long q()
  {
    if (this.t != null)
      return this.t.getConversationId();
    return -1L;
  }

  private long r()
  {
    if (this.t != null)
      return this.t.getGroupId();
    return -1L;
  }

  private void s()
  {
    Set localSet = f();
    String[] arrayOfString = new String[localSet.size()];
    Iterator localIterator = localSet.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1++)
      arrayOfString[i1] = ((Participant)localIterator.next()).getMemberId();
    this.n.obtainInfo(arrayOfString, m(), null);
  }

  private Map<Participant, a> t()
  {
    HashMap localHashMap = new HashMap(this.c);
    localHashMap.putAll(this.e);
    return localHashMap;
  }

  public int a(final boolean paramBoolean)
  {
    return a(t(), new b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return (paramBoolean) && ((paramBoolean) || (!paramAnonymousa.b));
      }
    }).size();
  }

  public Set<Participant> a(b paramb)
  {
    return a(t(), paramb);
  }

  public void a()
  {
    this.o.b(this);
    this.p.unregister(this);
    this.a = null;
    this.t = null;
  }

  public void a(long paramLong)
  {
    a(paramLong, "");
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    a(paramLong, "", null, paramInt, paramBoolean);
  }

  public void a(long paramLong, String paramString)
  {
    if (paramLong > 0L);
    GroupController.GroupMember[] arrayOfGroupMember;
    for (boolean bool = true; ; bool = false)
    {
      arrayOfGroupMember = b(c(bool));
      if (!bool)
        break;
      s();
      this.m.a(paramLong, arrayOfGroupMember);
      this.a.finish();
      return;
    }
    this.B = true;
    this.y = m();
    c("loading_dialog");
    this.m.a(this.y, paramString, arrayOfGroupMember);
  }

  public void a(long paramLong, String paramString, Uri paramUri, int paramInt, boolean paramBoolean)
  {
    a(this.c, paramLong, paramString, paramUri, paramInt, paramBoolean);
  }

  protected void a(Activity paramActivity, Set<Participant> paramSet, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (!paramMap5.isEmpty())
      if (paramMap5.size() == 1)
      {
        Map.Entry localEntry = (Map.Entry)paramMap5.entrySet().iterator().next();
        this.v.post(new as(this, paramSet));
        a(paramActivity, (String)localEntry.getKey(), (String)localEntry.getValue(), paramOnClickListener);
      }
    ViberDialogHandlers.cn localcn2;
    int i1;
    int i2;
    do
    {
      do
      {
        return;
        if (paramSet.size() == 0)
        {
          com.viber.voip.ui.dialogs.d.o().b(false).a(new ViberDialogHandlers.f(q(), r(), paramOnClickListener)).a(paramActivity);
          return;
        }
        LinkedList localLinkedList3 = new LinkedList(paramMap5.values());
        String str8 = (String)localLinkedList3.removeLast();
        com.viber.voip.ui.dialogs.d.a(TextUtils.join(", ", localLinkedList3), str8).b(false).a(new ViberDialogHandlers.f(q(), r(), paramOnClickListener)).a(paramActivity);
        return;
        if (!paramMap2.isEmpty())
        {
          ViberDialogHandlers.bm localbm = new ViberDialogHandlers.bm();
          localbm.a = paramOnClickListener;
          localbm.b = new LinkedList(paramMap3.values());
          if (paramMap2.size() > 1)
          {
            LinkedList localLinkedList1 = new LinkedList(paramMap2.values());
            String str1 = (String)localLinkedList1.removeLast();
            String str2 = TextUtils.join(", ", localLinkedList1);
            com.viber.voip.ui.dialogs.e.a().b(-1, new Object[] { str2, str1 }).a(localbm).a(paramActivity);
            return;
          }
          h.a locala1 = com.viber.voip.ui.dialogs.e.b();
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramMap2.values().iterator().next();
          locala1.b(-1, arrayOfObject1).a(localbm).a(paramActivity);
          return;
        }
        if (!paramMap3.isEmpty())
        {
          ViberDialogHandlers.cn localcn1 = new ViberDialogHandlers.cn();
          localcn1.a = paramOnClickListener;
          if (paramMap3.size() > 1)
          {
            LinkedList localLinkedList2 = new LinkedList(paramMap3.values());
            String str3 = (String)localLinkedList2.removeLast();
            String str4 = TextUtils.join(", ", localLinkedList2);
            com.viber.voip.ui.dialogs.l.c().b(R.string.dialog_513_message_many, new Object[] { str4, str3 }).a(localcn1).a(paramActivity);
            return;
          }
          h.a locala2 = com.viber.voip.ui.dialogs.l.c();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramMap3.values().iterator().next();
          locala2.b(-1, arrayOfObject2).a(localcn1).a(paramActivity);
          return;
        }
      }
      while (paramMap4.isEmpty());
      Set localSet = c(true).keySet();
      GroupController.GroupMember[] arrayOfGroupMember = (GroupController.GroupMember[])localSet.toArray(new GroupController.GroupMember[localSet.size()]);
      localcn2 = new ViberDialogHandlers.cn();
      localcn2.a = paramOnClickListener;
      i1 = paramMap4.size();
      i2 = arrayOfGroupMember.length;
      if ((i1 == 1) && (i2 > 0))
      {
        String str7 = (String)paramMap4.values().iterator().next();
        ad.o().b(R.string.dialog_c40_message, new Object[] { str7 }).a(localcn2).a(paramActivity);
        return;
      }
      if ((i1 > 0) && (i2 == 0))
      {
        ad.q().a(paramActivity);
        return;
      }
      if ((i1 > 0) && (i2 == 1))
      {
        String str6 = arrayOfGroupMember[0].mClientName;
        ad.r().b(R.string.dialog_c43_message, new Object[] { str6 }).a(localcn2).a(paramActivity);
        return;
      }
    }
    while ((i1 <= 1) || (i2 <= 0));
    String str5 = TextUtils.join(", ", new LinkedList(paramMap4.values()));
    ad.p().b(R.string.dialog_c41_message, new Object[] { str5 }).a(localcn2).a(paramActivity);
  }

  protected void a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
      paramOnClickListener.onClick(null, -1);
  }

  public void a(c paramc)
  {
    this.g = paramc;
  }

  // ERROR //
  public void a(String paramString, final View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: new 803	com/viber/voip/contacts/ui/au
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 804	com/viber/voip/contacts/ui/au:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 348	com/viber/voip/contacts/ui/ParticipantSelector:a	(Lcom/viber/voip/contacts/ui/ParticipantSelector$b;)Ljava/util/Set;
    //   16: invokeinterface 515 1 0
    //   21: ifle +49 -> 70
    //   24: aload_0
    //   25: getfield 101	com/viber/voip/contacts/ui/ParticipantSelector:a	Landroid/support/v4/app/FragmentActivity;
    //   28: invokestatic 809	c/b/a/a/j:a	(Landroid/content/Context;)Lc/b/a/a/j;
    //   31: astore 5
    //   33: aload 5
    //   35: aload 5
    //   37: aload_1
    //   38: aconst_null
    //   39: invokevirtual 812	c/b/a/a/j:a	(Ljava/lang/CharSequence;Ljava/lang/String;)Lc/b/a/a/l$a;
    //   42: invokevirtual 815	c/b/a/a/j:b	(Lc/b/a/a/l$a;)Z
    //   45: istore 10
    //   47: iload 10
    //   49: istore 7
    //   51: iload 7
    //   53: ifne +22 -> 75
    //   56: invokestatic 818	com/viber/voip/ui/dialogs/a:a	()Lcom/viber/common/dialogs/h$a;
    //   59: aload_0
    //   60: getfield 101	com/viber/voip/contacts/ui/ParticipantSelector:a	Landroid/support/v4/app/FragmentActivity;
    //   63: invokevirtual 308	com/viber/common/dialogs/h$a:a	(Landroid/support/v4/app/FragmentActivity;)Lcom/viber/common/dialogs/m;
    //   66: pop
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -48 -> 24
    //   75: aload_1
    //   76: invokestatic 821	com/viber/voip/contacts/ui/ParticipantSelector$Participant:createUnknown	(Ljava/lang/String;)Lcom/viber/voip/contacts/ui/ParticipantSelector$Participant;
    //   79: astore 8
    //   81: iload_3
    //   82: ifeq +23 -> 105
    //   85: aload_0
    //   86: getfield 109	com/viber/voip/contacts/ui/ParticipantSelector:t	Lcom/viber/voip/contacts/ui/ParticipantSelector$e;
    //   89: aload_1
    //   90: invokeinterface 824 2 0
    //   95: goto -28 -> 67
    //   98: astore 4
    //   100: aload_0
    //   101: monitorexit
    //   102: aload 4
    //   104: athrow
    //   105: aload_0
    //   106: getfield 826	com/viber/voip/contacts/ui/ParticipantSelector:f	Z
    //   109: ifeq +18 -> 127
    //   112: aload_0
    //   113: getfield 109	com/viber/voip/contacts/ui/ParticipantSelector:t	Lcom/viber/voip/contacts/ui/ParticipantSelector$e;
    //   116: iconst_1
    //   117: aload 8
    //   119: invokeinterface 381 3 0
    //   124: goto -57 -> 67
    //   127: aload_2
    //   128: iconst_0
    //   129: invokevirtual 832	android/view/View:setEnabled	(Z)V
    //   132: aload_0
    //   133: ldc_w 546
    //   136: invokespecial 478	com/viber/voip/contacts/ui/ParticipantSelector:c	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: new 834	com/viber/voip/contacts/ui/ParticipantSelector$5
    //   143: dup
    //   144: aload_0
    //   145: aload 8
    //   147: aload_2
    //   148: invokespecial 837	com/viber/voip/contacts/ui/ParticipantSelector$5:<init>	(Lcom/viber/voip/contacts/ui/ParticipantSelector;Lcom/viber/voip/contacts/ui/ParticipantSelector$Participant;Landroid/view/View;)V
    //   151: invokestatic 842	com/viber/voip/util/dr:a	(Ljava/lang/String;Lcom/viber/voip/util/dr$a;)V
    //   154: goto -87 -> 67
    //   157: astore 6
    //   159: iconst_0
    //   160: istore 7
    //   162: goto -111 -> 51
    //
    // Exception table:
    //   from	to	target	type
    //   4	24	98	finally
    //   24	33	98	finally
    //   33	47	98	finally
    //   56	67	98	finally
    //   75	81	98	finally
    //   85	95	98	finally
    //   105	124	98	finally
    //   127	154	98	finally
    //   33	47	157	c/b/a/a/i
  }

  public void a(Map<Participant, a> paramMap, long paramLong, String paramString, Uri paramUri, int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    GroupController.GroupMember[] arrayOfGroupMember;
    Participant localParticipant;
    if (paramLong > 0L)
    {
      int i2 = i1;
      arrayOfGroupMember = b(a(paramMap, i2));
      if (i2 != 0)
        break label333;
      if ((arrayOfGroupMember.length != i1) || (paramBoolean))
        break label190;
      localParticipant = (Participant)this.c.keySet().iterator().next();
      com.viber.voip.analytics.g.a().c().g().a(localParticipant.getMemberId(), "Create Chat Icon", 2);
      if (this.l != f.c)
        break label170;
      if (this.q.a(localParticipant.getMemberId(), localParticipant.getNumber(), i1) == null)
        break label148;
      a(localParticipant.getMemberId(), localParticipant.getNumber(), localParticipant.getDisplayName());
    }
    label148: label170: label190: label250: 
    do
    {
      do
      {
        do
        {
          return;
          int i3 = 0;
          break;
        }
        while (!cj.a(i1));
        c("loading_dialog");
        f(localParticipant);
        return;
        a(localParticipant.getMemberId(), localParticipant.getNumber(), localParticipant.getDisplayName());
        return;
        if (!paramBoolean)
          break label250;
      }
      while (this.b == null);
      Intent localIntent = new Intent(this.a, CreateCommunityActivity.class);
      localIntent.putExtra("members_extra", arrayOfGroupMember);
      this.b.b(localIntent);
      this.a.overridePendingTransition(0, 0);
      return;
    }
    while ((arrayOfGroupMember.length <= i1) || (!cj.a(i1)));
    this.B = i1;
    this.y = m();
    c("loading_dialog");
    GroupController localGroupController = this.m;
    int i4 = this.y;
    if (this.l == f.c);
    boolean bool;
    while (true)
    {
      localGroupController.a(i4, i1, paramString, paramUri, arrayOfGroupMember);
      return;
      bool = false;
    }
    label333: this.B = bool;
    c(a(this.l));
    this.y = m();
    if (this.l == f.d)
    {
      this.s.a(paramLong, arrayOfGroupMember);
      return;
    }
    this.m.a(this.y, paramLong, arrayOfGroupMember, paramInt);
  }

  public void a(Map<Participant, com.viber.voip.model.entity.l> paramMap, boolean paramBoolean, int paramInt)
  {
    this.A.clear();
    Iterator localIterator = paramMap.entrySet().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i2 = ((com.viber.voip.model.entity.l)localEntry.getValue()).d();
      if (i2 == 0);
      for (int i3 = i1 + 1; ; i3 = i1)
      {
        i1 = i3;
        break;
        if (cd.h(i2))
          this.A.add(localEntry.getKey());
      }
    }
    this.k = a(i1);
    if ((b()) && (this.k < 0))
      this.k = 0;
    b(paramMap, paramBoolean, paramInt);
  }

  public void a(final boolean paramBoolean, final Participant[] paramArrayOfParticipant)
  {
    int i1 = 0;
    if ((paramBoolean) && (b()) && (a(false) >= this.k))
      o();
    while (true)
    {
      return;
      if ((paramArrayOfParticipant.length <= 1) || (paramBoolean))
        break;
      int i2 = paramArrayOfParticipant.length;
      while (i1 < i2)
      {
        c(paramArrayOfParticipant[i1]);
        i1++;
      }
    }
    FragmentActivity localFragmentActivity = this.a;
    List localList = Arrays.asList(paramArrayOfParticipant);
    Set localSet1 = t().keySet();
    if (!c());
    for (Set localSet2 = i(); ; localSet2 = null)
    {
      x.a(localFragmentActivity, localList, localSet1, localSet2, x.a.b, new d()
      {
        public void a(ParticipantSelector.Participant paramAnonymousParticipant)
        {
          ParticipantSelector.this.c(ParticipantSelector.a(paramAnonymousParticipant, paramArrayOfParticipant));
        }

        public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
        {
          if (((paramBoolean) && (!ParticipantSelector.this.a(paramAnonymousParticipant))) || (paramAnonymousBoolean))
          {
            ParticipantSelector.a(ParticipantSelector.this, ParticipantSelector.a(paramAnonymousParticipant, paramArrayOfParticipant));
            return;
          }
          ParticipantSelector.this.c(ParticipantSelector.a(paramAnonymousParticipant, paramArrayOfParticipant));
        }
      });
      return;
    }
  }

  public boolean a(Participant paramParticipant)
  {
    return t().containsKey(paramParticipant);
  }

  public Set<Participant> b(boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = t().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((paramBoolean) || (!((a)localEntry.getValue()).b)) && (((a)localEntry.getValue()).a))
        localHashSet.add(localEntry.getKey());
    }
    return localHashSet;
  }

  public void b(Participant paramParticipant)
  {
    a(paramParticipant, false);
  }

  public boolean b()
  {
    return this.j != -1;
  }

  public void c(Participant paramParticipant)
  {
    d(paramParticipant);
    if (this.t != null)
      this.t.onParticipantSelected(false, paramParticipant);
  }

  protected boolean c()
  {
    return false;
  }

  public void d(Participant paramParticipant)
  {
    this.c.remove(paramParticipant);
    this.e.remove(paramParticipant);
  }

  public boolean d()
  {
    boolean bool1 = b();
    boolean bool2 = false;
    if (bool1)
    {
      int i1 = a(false);
      int i2 = this.k;
      bool2 = false;
      if (i1 == i2)
        bool2 = true;
    }
    return bool2;
  }

  public void e()
  {
    o();
  }

  public Set<Participant> f()
  {
    return a(this.c, new b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return !ParticipantSelector.this.d.containsKey(paramAnonymousParticipant);
      }
    });
  }

  public Set<Participant> g()
  {
    return a(this.e, new b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return !ParticipantSelector.this.d.containsKey(paramAnonymousParticipant);
      }
    });
  }

  public Set<Participant> h()
  {
    return a(this.d, new b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return !ParticipantSelector.this.c.containsKey(paramAnonymousParticipant);
      }
    });
  }

  public Set<Participant> i()
  {
    return a(this.c, new b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return paramAnonymousa.b;
      }
    });
  }

  public int j()
  {
    return this.j;
  }

  public int k()
  {
    return this.k;
  }

  public boolean l()
  {
    return this.B;
  }

  protected int m()
  {
    return (int)(System.currentTimeMillis() / 1000L);
  }

  public void n()
  {
    com.viber.voip.ui.dialogs.l.d().b(false).d();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onBanReply(c.a parama)
  {
    if ((this.y != parama.a) || (!p()))
      return;
    d("loading_dialog");
    switch (parama.c)
    {
    default:
    case 0:
    case 4:
    case 1:
    case 2:
    case 3:
    case 5:
    }
    while (true)
    {
      this.C = null;
      return;
      if (this.C != null)
      {
        this.A.remove(this.C);
        continue;
        k.z().a(this.a);
        continue;
        k.n().a(this.a);
      }
    }
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onBroadcastListCreated(com.viber.voip.messages.a.a.a parama)
  {
    if ((this.y != parama.a) || (this.a.isFinishing()));
    do
    {
      return;
      this.B = false;
      d("loading_dialog");
    }
    while (this.b == null);
    this.b.a(com.viber.voip.messages.m.a(parama.b, 4, false, false, false, false));
  }

  public void onGroupCreateError(int paramInt1, int paramInt2, Map<String, Integer> paramMap)
  {
    if (this.a.isFinishing())
      return;
    this.B = false;
    d("loading_dialog");
    if ((1 == paramInt2) && (!this.c.isEmpty()))
    {
      final HashSet localHashSet = new HashSet();
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Participant localParticipant = (Participant)((Map.Entry)localIterator.next()).getKey();
        if ((paramMap == null) || (!paramMap.containsKey(localParticipant.getMemberId())))
          localHashSet.add(localParticipant);
      }
      a(this.a, paramMap, true, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if ((ParticipantSelector.a(ParticipantSelector.this) != ParticipantSelector.f.c) && (ParticipantSelector.a(ParticipantSelector.this) != ParticipantSelector.f.b))
          {
            ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localHashSet.iterator().next();
            ParticipantSelector.a(ParticipantSelector.this, localParticipant.getMemberId(), localParticipant.getNumber(), localParticipant.getDisplayName());
          }
        }
      });
      return;
    }
    h.a locala = k.n();
    int i1 = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a.getString(R.string.dialog_339_reason_create_group);
    locala.b(i1, arrayOfObject).a(this.a);
  }

  public void onGroupCreated(int paramInt, long paramLong1, long paramLong2, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if ((this.y != paramInt) || (this.a.isFinishing()))
      return;
    this.B = false;
    c(paramLong1, paramMap);
    this.v.post(new at(this, paramLong1, paramMap));
  }

  public void onMembersAddedToGroup(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap)
  {
    this.B = false;
    if (this.y != paramInt1);
    do
    {
      return;
      d("add_participants_dialog");
      switch (paramInt2)
      {
      case 1:
      case 2:
      case 4:
      default:
        k.z().a(this.a);
        return;
      case 0:
        a(paramMap);
        s();
        return;
      case 5:
      case 6:
      case 3:
      }
    }
    while (!cj.a(true));
    k.n().a(this.a);
    return;
    com.viber.voip.ui.dialogs.l.a().a(this.a);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onMembersInvitationLinkReceived(c.f paramf)
  {
    this.B = false;
    if (p())
    {
      if (paramf.a == 0)
        this.a.finish();
    }
    else
      return;
    d("add_participants_dialog");
    h.a locala = k.n();
    int i1 = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a.getString(R.string.dialog_339_reason_invite);
    locala.b(i1, arrayOfObject).b(this.a);
  }

  public static final class Participant
    implements Parcelable, Cloneable
  {
    public static final Parcelable.Creator<Participant> CREATOR = new Parcelable.Creator()
    {
      public ParticipantSelector.Participant a(Parcel paramAnonymousParcel)
      {
        return new ParticipantSelector.Participant(paramAnonymousParcel, null);
      }

      public ParticipantSelector.Participant[] a(int paramAnonymousInt)
      {
        return new ParticipantSelector.Participant[paramAnonymousInt];
      }
    };
    private final String mDisplayName;
    private String mInitialDisplayName;
    private final boolean mLocal;
    private final String mMemberId;
    private final String mNumber;
    private final Uri mPhotoUri;

    private Participant(Parcel paramParcel)
    {
      this.mMemberId = paramParcel.readString();
      this.mNumber = paramParcel.readString();
      this.mDisplayName = paramParcel.readString();
      this.mPhotoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      if (paramParcel.readByte() == 1);
      for (boolean bool = true; ; bool = false)
      {
        this.mLocal = bool;
        return;
      }
    }

    public Participant(String paramString1, String paramString2, String paramString3, Uri paramUri, boolean paramBoolean)
    {
      this.mMemberId = paramString1;
      this.mNumber = paramString2;
      this.mDisplayName = paramString3;
      this.mPhotoUri = paramUri;
      this.mLocal = paramBoolean;
    }

    public Participant(String paramString, boolean paramBoolean)
    {
      this(paramString, null, null, null, paramBoolean);
    }

    public static Participant create(String paramString)
    {
      return new Participant(paramString, null, null, null, false);
    }

    public static Participant create(String paramString1, String paramString2)
    {
      return new Participant(paramString1, paramString2, null, null, false);
    }

    public static Participant createUnknown(String paramString)
    {
      return new Participant(null, paramString, null, null, false);
    }

    public static Participant from(Member paramMember)
    {
      return new Participant(paramMember.getId(), paramMember.getPhoneNumber(), paramMember.getViberName(), paramMember.getPhotoUri(), true);
    }

    public static Participant from(ae paramae)
    {
      return new Participant(paramae.h(), paramae.getNumber(), paramae.f(), paramae.j(), true);
    }

    public static Participant from(com.viber.voip.model.entity.m paramm)
    {
      return new Participant(paramm.a(), paramm.getNumber(), paramm.o(), paramm.p(), true);
    }

    public static Participant from(com.viber.voip.model.f paramf, com.viber.voip.model.c paramc)
    {
      String str;
      if (paramc != null)
      {
        str = paramc.k();
        if (paramc == null)
          break label45;
      }
      label45: for (Uri localUri = paramc.o(); ; localUri = null)
      {
        return new Participant(null, paramf.b(), str, localUri, true);
        str = null;
        break;
      }
    }

    public static Participant from(j paramj, com.viber.voip.model.c paramc)
    {
      if (paramc != null);
      for (String str = paramc.k(); ; str = null)
      {
        Uri localUri = null;
        if (paramc != null)
          localUri = paramc.o();
        return new Participant(paramj.a(), paramj.c(), str, localUri, true);
      }
    }

    public Object clone()
    {
      try
      {
        Object localObject = super.clone();
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
      }
      return null;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Participant localParticipant;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localParticipant = (Participant)paramObject;
        if ((this.mMemberId != null) && (localParticipant.mMemberId != null))
          return this.mMemberId.equals(localParticipant.mMemberId);
        if ((this.mMemberId != null) || (localParticipant.mMemberId != null))
          break label101;
        if (this.mNumber == null)
          break;
      }
      while (this.mNumber.equals(localParticipant.mNumber));
      while (localParticipant.mNumber != null)
        return false;
      return true;
      label101: return false;
    }

    public String getDisplayName()
    {
      return this.mDisplayName;
    }

    public String getDisplayNameNotNull(Context paramContext)
    {
      if (TextUtils.isEmpty(this.mDisplayName))
        return paramContext.getString(R.string.unknown);
      return this.mDisplayName;
    }

    public String getInitialDisplayName()
    {
      if (this.mInitialDisplayName == null)
        this.mInitialDisplayName = da.f(getDisplayName());
      return this.mInitialDisplayName;
    }

    public String getMemberId()
    {
      return this.mMemberId;
    }

    public String getNumber()
    {
      return this.mNumber;
    }

    public String getNumberOrUnknown(Context paramContext)
    {
      if ((TextUtils.isEmpty(this.mNumber)) || (cg.c(this.mNumber)))
        return paramContext.getString(R.string.unknown);
      return this.mNumber;
    }

    public Uri getPhotoUri()
    {
      return this.mPhotoUri;
    }

    public int hashCode()
    {
      if (this.mMemberId != null)
        return this.mMemberId.hashCode();
      if (this.mNumber != null)
        return this.mNumber.hashCode();
      return 0;
    }

    public boolean isLocal()
    {
      return this.mLocal;
    }

    public boolean isViber()
    {
      return (!TextUtils.isEmpty(this.mMemberId)) && (!getMemberId().equals(getNumber()));
    }

    public String toString()
    {
      return "Participant{mLocal=" + this.mLocal + ", mPhotoUri=" + this.mPhotoUri + ", mDisplayName='" + this.mDisplayName + '\'' + ", mNumber='" + this.mNumber + '\'' + ", mMemberId='" + this.mMemberId + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mMemberId);
      paramParcel.writeString(this.mNumber);
      paramParcel.writeString(this.mDisplayName);
      paramParcel.writeParcelable(this.mPhotoUri, 0);
      boolean bool = this.mLocal;
      int i = 0;
      if (bool)
        i = 1;
      paramParcel.writeByte((byte)i);
    }
  }

  public static class a
  {
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    private ParticipantSelector.Participant d;

    protected a()
    {
    }

    private a(ParticipantSelector.Participant paramParticipant)
    {
      this.d = paramParticipant;
    }

    public a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
  }

  public static abstract interface b
  {
    public abstract boolean isParticipantValid(ParticipantSelector.Participant paramParticipant, ParticipantSelector.a parama);
  }

  public static abstract interface c
  {
    public abstract void a();
  }

  public static abstract interface d
  {
    public abstract void a(ParticipantSelector.Participant paramParticipant);

    public abstract void a(boolean paramBoolean, ParticipantSelector.Participant paramParticipant);
  }

  public static abstract interface e
  {
    public abstract long getConversationId();

    public abstract long getGroupId();

    public abstract void onParticipantAlreadyAdded(String paramString);

    public abstract void onParticipantSelected(boolean paramBoolean, ParticipantSelector.Participant paramParticipant);
  }

  public static enum f
  {
    static
    {
      f[] arrayOff = new f[4];
      arrayOff[0] = a;
      arrayOff[1] = b;
      arrayOff[2] = c;
      arrayOff[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ParticipantSelector
 * JD-Core Version:    0.6.2
 */