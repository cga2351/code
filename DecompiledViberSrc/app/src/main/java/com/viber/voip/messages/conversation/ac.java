package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.g;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import com.viber.voip.util.cd;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ac extends d
{
  private static final Logger l = ViberEnv.getLogger();
  private final dagger.a<k> m;
  private long n;
  private int o = -1;
  private int p = -1;
  private final int q;
  private final String r;
  private Handler s;
  private boolean t = true;
  private EventBus u;
  private final bv.n v = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(ac.a(ac.this))))
        ac.this.l();
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
      ac.this.l();
    }

    public void onNewInfo(List<com.viber.voip.model.entity.m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(com.viber.voip.model.entity.m paramAnonymousm)
    {
    }
  };
  private final Runnable w = new ad(this);

  public ac(int paramInt1, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Set<Integer> paramSet, int paramInt2, LoaderManager paramLoaderManager, dagger.a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramInt1, c.g.a, paramContext, paramLoaderManager, parama1, 0);
    this.m = parama;
    this.s = av.a(av.e.a);
    a(ae.a);
    this.q = paramInt2;
    String str1;
    if (paramBoolean1)
    {
      str1 = "participants.conversation_id=? AND participants.active=0";
      if (paramSet != null)
        str1 = str1 + " AND participants.group_role IN (" + com.viber.voip.s.a.d(paramSet) + ")";
      switch (this.q)
      {
      default:
        label160: this.r = str1;
        a(this.r);
        if (!paramBoolean2)
          break;
      case 3:
      case 2:
      case 1:
      }
    }
    for (String str2 = "CASE participants.group_role WHEN 2 THEN 0 ELSE 1 END, participant_type ASC, display_name ASC, number ASC"; ; str2 = "participant_type ASC, display_name ASC, number ASC")
    {
      d(str2);
      this.u = paramEventBus;
      return;
      str1 = "participants.conversation_id=? AND participants.active=0 AND participant_type<>0";
      break;
      str1 = "participants.conversation_id=? AND participants.active=2";
      break label160;
      String str3 = "participants.conversation_id=? AND (participants.active=0 OR (participants.group_role=3 AND participant_type=2))" + " AND participant_type<>0";
      str1 = str3 + " AND (participants_info.participant_type=0 OR (participants_info.viber_name IS NOT NULL AND participants_info.viber_name <> '') OR ((? NOT IN ('2','3','5') OR ? <> '3') AND participants_info.contact_name IS NOT NULL AND participants_info.contact_name <> '') OR (participants_info.number IS NOT NULL AND participants_info.number <> '' AND participants_info.number <> 'unknown_number' AND participants_info.participant_info_flags & 2 = 0 AND ? NOT IN ('2','3','5'))) AND (? NOT IN ('2','3','5') OR (participants_info.encrypted_number IS NOT NULL AND participants_info.encrypted_number <> '' AND ? IN ('2','3')) OR (participants_info.encrypted_member_id IS NOT NULL AND participants_info.encrypted_member_id <> '' AND ? = '5'))";
      break label160;
      str1 = str1 + " AND (participants_info.participant_type=0 OR (participants_info.viber_name IS NOT NULL AND participants_info.viber_name <> '') OR ((? NOT IN ('2','3','5') OR ? <> '3') AND participants_info.contact_name IS NOT NULL AND participants_info.contact_name <> '') OR (participants_info.number IS NOT NULL AND participants_info.number <> '' AND participants_info.number <> 'unknown_number' AND participants_info.participant_info_flags & 2 = 0 AND ? NOT IN ('2','3','5')))";
      break label160;
    }
  }

  public ac(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, LoaderManager paramLoaderManager, dagger.a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramLoaderManager, parama, parama1, paramEventBus);
  }

  public ac(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Set<Integer> paramSet, LoaderManager paramLoaderManager, dagger.a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    this(8, paramContext, paramBoolean1, paramBoolean2, paramSet, 0, paramLoaderManager, parama, parama1, paramEventBus);
  }

  private static String f(String paramString)
  {
    return "%" + paramString + "%";
  }

  private void t()
  {
    String str;
    if (this.t)
      str = this.r;
    while (true)
    {
      a(str);
      return;
      if ((this.q == 2) && (com.viber.voip.messages.m.e(this.o)) && (!cd.c(this.p)))
        str = this.r + " AND " + "((participants_info.contact_id > 0 AND participants_info.number LIKE ?) OR participants_info.display_name LIKE ? OR participants_info.contact_name LIKE ?)";
      else
        str = this.r + " AND " + "(participants_info.number LIKE ? OR participants_info.display_name LIKE ? OR participants_info.contact_name LIKE ?)";
    }
  }

  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.n = paramLong;
    this.o = paramInt1;
    this.p = paramInt2;
    switch (this.q)
    {
    default:
      return;
    case 0:
    case 3:
      b(paramLong);
      return;
    case 1:
      String[] arrayOfString2 = new String[4];
      arrayOfString2[0] = String.valueOf(this.n);
      arrayOfString2[1] = String.valueOf(this.o);
      arrayOfString2[2] = String.valueOf(this.p);
      arrayOfString2[3] = String.valueOf(this.o);
      b(arrayOfString2);
      return;
    case 2:
    }
    String str = String.valueOf(this.o);
    String[] arrayOfString1 = new String[7];
    arrayOfString1[0] = String.valueOf(this.n);
    arrayOfString1[1] = str;
    arrayOfString1[2] = String.valueOf(this.p);
    arrayOfString1[3] = str;
    arrayOfString1[4] = str;
    arrayOfString1[5] = str;
    arrayOfString1[6] = str;
    b(arrayOfString1);
  }

  public void a(String paramString1, String paramString2)
  {
    if (!d())
      return;
    boolean bool = TextUtils.isEmpty(paramString1);
    if (bool != this.t)
    {
      this.t = bool;
      t();
    }
    if (this.t)
      a(this.n, this.o, this.p);
    while (true)
    {
      this.s.removeCallbacks(this.w);
      this.s.postDelayed(this.w, 200L);
      return;
      String str1 = f(paramString1);
      if (TextUtils.isEmpty(paramString2));
      for (String str2 = str1; ; str2 = f(paramString2))
        switch (this.q)
        {
        default:
          break;
        case 0:
        case 3:
          String[] arrayOfString3 = new String[4];
          arrayOfString3[0] = String.valueOf(this.n);
          arrayOfString3[1] = str2;
          arrayOfString3[2] = str1;
          arrayOfString3[3] = str1;
          b(arrayOfString3);
          break;
        case 1:
        case 2:
        }
      String[] arrayOfString2 = new String[7];
      arrayOfString2[0] = String.valueOf(this.n);
      arrayOfString2[1] = String.valueOf(this.o);
      arrayOfString2[2] = String.valueOf(this.p);
      arrayOfString2[3] = String.valueOf(this.o);
      arrayOfString2[4] = str2;
      arrayOfString2[5] = str1;
      arrayOfString2[6] = str1;
      b(arrayOfString2);
      continue;
      String str3 = String.valueOf(this.o);
      String[] arrayOfString1 = new String[10];
      arrayOfString1[0] = String.valueOf(this.n);
      arrayOfString1[1] = str3;
      arrayOfString1[2] = String.valueOf(this.p);
      arrayOfString1[3] = str3;
      arrayOfString1[4] = str3;
      arrayOfString1[5] = str3;
      arrayOfString1[6] = str3;
      arrayOfString1[7] = str2;
      arrayOfString1[8] = str1;
      arrayOfString1[9] = str1;
      b(arrayOfString1);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "CASE viber_name WHEN '' THEN 1 ELSE 0 END, participant_type ASC, display_name ASC, number ASC"; ; str = "CASE participants.group_role WHEN 2 THEN 0 ELSE 1 END, participant_type ASC, display_name ASC, number ASC")
    {
      d(str);
      return;
    }
  }

  public boolean a(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    if (b_(paramInt))
      if (this.f.getInt(5) != 0)
        break label29;
    label29: for (int i = 1; i != 0; i = 0)
      return false;
    this.f.copyStringToBuffer(7, paramCharArrayBuffer);
    if (paramCharArrayBuffer.sizeCopied == 0)
      this.f.copyStringToBuffer(10, paramCharArrayBuffer);
    return true;
  }

  public boolean a(long paramLong)
  {
    return (this.n == paramLong) && (super.d());
  }

  public void b(long paramLong)
  {
    this.n = paramLong;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this.n);
    b(arrayOfString);
  }

  public ae e(int paramInt)
  {
    if (b_(paramInt))
      return new ae(this.f);
    return null;
  }

  public String f(int paramInt)
  {
    if (b_(paramInt))
    {
      if (this.f.getInt(5) == 0);
      for (int i = 1; i == 0; i = 0)
        return this.f.getString(9);
    }
    return null;
  }

  public boolean g(int paramInt)
  {
    if (b_(paramInt))
      return 2 == this.f.getInt(1);
    return false;
  }

  @Subscribe
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    l();
  }

  public void p()
  {
    super.p();
    if (!this.u.isRegistered(this))
      this.u.register(this);
    ((k)this.m.get()).b().a(this.v);
  }

  public void q()
  {
    super.q();
    this.u.unregister(this);
    ((k)this.m.get()).b().b(this.v);
  }

  public void r()
  {
    d("participant_type ASC, CASE participants.group_role WHEN 2 THEN 0 ELSE 1 END, display_name ASC, number ASC");
  }

  public long s()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ac
 * JD-Core Version:    0.6.2
 */