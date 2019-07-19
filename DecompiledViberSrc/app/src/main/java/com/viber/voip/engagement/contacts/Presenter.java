package com.viber.voip.engagement.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArraySet;
import android.view.ContextMenu;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.engagement.c.a;
import com.viber.voip.engagement.d.m;
import com.viber.voip.engagement.d.n;
import com.viber.voip.engagement.d.n.a;
import com.viber.voip.engagement.data.d;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.model.j;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Presenter
{
  private static final Logger a = ViberEnv.getLogger("EngagementContactsPresenter");
  private static final k b = (k)cl.b(k.class);
  private final boolean c;
  private final int d;
  private final Member e;
  private final a f;
  private final n g;
  private final cj h;
  private final com.viber.voip.engagement.carousel.h i;
  private final f j;
  private final com.viber.voip.engagement.c k;
  private k l = b;
  private String m = "";
  private int n;
  private final Set<SendButtonReceiverId> o = new ArraySet();
  private final a.a p = new a.a()
  {
    public void a()
    {
      Presenter.a(Presenter.this).c();
    }

    public void a(boolean paramAnonymousBoolean)
    {
      Presenter.a(Presenter.this).b();
      if (!da.a(Presenter.b(Presenter.this)))
      {
        if (paramAnonymousBoolean)
          Presenter.a(Presenter.this).a(Presenter.b(Presenter.this));
      }
      else
        return;
      Presenter.a(Presenter.this).f();
    }
  };
  private final n.a q = new n.a()
  {
    public void a(List<com.viber.voip.model.a> paramAnonymousList)
    {
      Presenter.a(Presenter.this).a(paramAnonymousList);
    }
  };
  private final cj.b r = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      k localk = Presenter.a(Presenter.this);
      if (paramAnonymousInt1 != -1);
      for (boolean bool = true; ; bool = false)
      {
        localk.a(bool);
        return;
      }
    }
  };
  private final c.a s = new h(this);

  public Presenter(boolean paramBoolean, int paramInt, Member paramMember, a parama, n paramn, cj paramcj, com.viber.voip.engagement.carousel.h paramh, f paramf, com.viber.voip.engagement.c paramc)
  {
    this.c = paramBoolean;
    this.d = paramInt;
    this.e = paramMember;
    this.f = parama;
    this.g = paramn;
    this.h = paramcj;
    this.i = paramh;
    this.j = paramf;
    this.k = paramc;
    this.f.a(this.p);
    if (e())
      this.k.a(this.s);
  }

  private void a(SendButtonReceiverId paramSendButtonReceiverId)
  {
    this.o.add(paramSendButtonReceiverId);
    this.l.a(paramSendButtonReceiverId);
  }

  private boolean a(d paramd, String paramString, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramd.a())
    {
    default:
      return false;
    case 0:
      if (paramBoolean1)
      {
        this.j.b(paramLong2, paramd.c(), paramd.d());
        return true;
      }
      if (!da.a(paramString))
      {
        this.j.a(paramString, paramBoolean2, paramd.c(), paramd.d());
        return true;
      }
      if (paramLong1 > 0L)
      {
        this.j.a(paramLong1, paramd.c(), paramd.d());
        return true;
      }
      break;
    case 1:
      if (paramBoolean1)
      {
        this.j.b(paramLong2, paramd.b(), paramd.d());
        return true;
      }
      if (!da.a(paramString))
      {
        this.j.a(paramString, paramBoolean2, paramd.b(), paramd.d());
        return true;
      }
      if (paramLong1 > 0L)
      {
        this.j.a(paramLong1, paramd.b(), paramd.d());
        return true;
      }
      break;
    }
    return false;
  }

  private boolean e()
  {
    return (this.k != null) && ((this.d == 0) || (this.d == 1));
  }

  public Parcelable a()
  {
    return new SaveState(this.o, this.m, this.n);
  }

  public void a(ContextMenu paramContextMenu, com.viber.voip.model.c paramc)
  {
    if (this.c)
    {
      String str = ((j)paramc.s().iterator().next()).a();
      m localm = this.g.a(str);
      if (localm != null)
        this.l.a(paramContextMenu, localm.getId() + " / " + localm.n().c(), localm.a(), localm.b());
    }
  }

  public void a(SendButtonReceiverId paramSendButtonReceiverId, ParticipantSelector.Participant paramParticipant, boolean paramBoolean)
  {
    if (this.o.contains(paramSendButtonReceiverId));
    ConversationLoaderEntity localConversationLoaderEntity;
    do
    {
      do
      {
        d locald;
        do
        {
          return;
          if (this.e.getId().equals(paramParticipant.getMemberId()))
          {
            this.l.d();
            return;
          }
          locald = this.i.a();
        }
        while ((locald == null) || (!a(locald, paramParticipant.getMemberId(), 0L, 0L, false, paramBoolean)));
        a(paramSendButtonReceiverId);
      }
      while (!e());
      localConversationLoaderEntity = this.k.a(paramParticipant.getMemberId());
    }
    while (localConversationLoaderEntity == null);
    a(SendButtonReceiverId.createFromConversationId(localConversationLoaderEntity.getId()));
  }

  public void a(k paramk, Parcelable paramParcelable)
  {
    SendButtonReceiverId[] arrayOfSendButtonReceiverId;
    String str;
    if ((paramParcelable instanceof SaveState))
    {
      SaveState localSaveState = (SaveState)paramParcelable;
      arrayOfSendButtonReceiverId = localSaveState.getSendUnavailableForContactIds();
      this.o.addAll(Arrays.asList(arrayOfSendButtonReceiverId));
      str = localSaveState.getSearchQuery();
      this.n = localSaveState.getSentItemsCount();
    }
    while (true)
    {
      this.l = paramk;
      paramk.a(this.f.a(), arrayOfSendButtonReceiverId, this.f.b());
      this.h.a(this.r);
      if (!da.a(str))
        a(str);
      return;
      arrayOfSendButtonReceiverId = new SendButtonReceiverId[0];
      str = this.m;
    }
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    d locald = this.i.a();
    String str;
    if (locald != null)
    {
      if (!paramConversationLoaderEntity.isGroupBehavior())
        break label102;
      str = null;
      if (!paramConversationLoaderEntity.isGroupBehavior())
        break label110;
    }
    label102: label110: for (long l1 = paramConversationLoaderEntity.getGroupId(); ; l1 = 0L)
    {
      boolean bool = paramConversationLoaderEntity.isBroadcastListType();
      long l2 = paramConversationLoaderEntity.getId();
      if (a(locald, str, l1, l2, bool, false))
      {
        this.n = (1 + this.n);
        a(SendButtonReceiverId.createFromConversationId(l2));
        if (!paramConversationLoaderEntity.isGroupBehavior())
          a(SendButtonReceiverId.createFromContactId(paramConversationLoaderEntity.getContactId()));
      }
      return;
      str = paramConversationLoaderEntity.getParticipantMemberId();
      break;
    }
  }

  public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
  {
    SendButtonReceiverId localSendButtonReceiverId = SendButtonReceiverId.createFromContactId(paramc.getId());
    if (this.o.contains(localSendButtonReceiverId))
      return;
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramc.s().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      localLinkedList.add(new ParticipantSelector.Participant(localj.a(), localj.c(), localj.e(), paramc.o(), true));
    }
    if (localLinkedList.size() == 1)
    {
      a(localSendButtonReceiverId, (ParticipantSelector.Participant)localLinkedList.get(0), paramBoolean);
      return;
    }
    this.l.a(localSendButtonReceiverId, localLinkedList, paramBoolean);
  }

  public void a(String paramString)
  {
    boolean bool1 = true;
    boolean bool2;
    k localk;
    if (da.a(this.m) != da.a(paramString))
    {
      bool2 = bool1;
      this.m = paramString;
      if (bool2)
      {
        localk = this.l;
        if (da.a(paramString))
          break label62;
      }
    }
    while (true)
    {
      localk.b(bool1);
      this.f.a(paramString);
      return;
      bool2 = false;
      break;
      label62: bool1 = false;
    }
  }

  public void b()
  {
    this.l.a();
    this.f.c();
    switch (this.d)
    {
    case -1:
    default:
    case 0:
    case 1:
      do
        return;
      while (this.k == null);
      this.k.a();
      return;
    case 2:
    }
    this.g.a(this.q);
  }

  public void c()
  {
    this.f.d();
    if (e())
      this.k.b();
  }

  public void d()
  {
    this.h.b(this.r);
    this.l = b;
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public Presenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new Presenter.SaveState(paramAnonymousParcel);
      }

      public Presenter.SaveState[] a(int paramAnonymousInt)
      {
        return new Presenter.SaveState[paramAnonymousInt];
      }
    };
    private final String mSearchQuery;
    private final SendButtonReceiverId[] mSendUnavailableForContactIds;
    private final int mSentItemsCount;

    protected SaveState(Parcel paramParcel)
    {
      this.mSendUnavailableForContactIds = ((SendButtonReceiverId[])paramParcel.createTypedArray(SendButtonReceiverId.CREATOR));
      this.mSearchQuery = paramParcel.readString();
      this.mSentItemsCount = paramParcel.readInt();
    }

    public SaveState(Set<SendButtonReceiverId> paramSet, String paramString, int paramInt)
    {
      this.mSendUnavailableForContactIds = new SendButtonReceiverId[paramSet.size()];
      this.mSentItemsCount = paramInt;
      Iterator localIterator = paramSet.iterator();
      for (int i = 0; localIterator.hasNext(); i++)
      {
        SendButtonReceiverId localSendButtonReceiverId = (SendButtonReceiverId)localIterator.next();
        this.mSendUnavailableForContactIds[i] = localSendButtonReceiverId;
      }
      this.mSearchQuery = paramString;
    }

    public int describeContents()
    {
      return 0;
    }

    public String getSearchQuery()
    {
      return this.mSearchQuery;
    }

    public SendButtonReceiverId[] getSendUnavailableForContactIds()
    {
      return this.mSendUnavailableForContactIds;
    }

    public int getSentItemsCount()
    {
      return this.mSentItemsCount;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeTypedArray(this.mSendUnavailableForContactIds, paramInt);
      paramParcel.writeString(this.mSearchQuery);
      paramParcel.writeInt(this.mSentItemsCount);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.Presenter
 * JD-Core Version:    0.6.2
 */