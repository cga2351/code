package com.viber.voip.messages.ui;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.adapters.a.a;
import com.viber.voip.messages.adapters.a.c;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.c;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.h;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.v;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.av;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PublicGroupsFragmentModeManager extends MessagesFragmentModeManager
{
  public PublicGroupsFragmentModeManager(MessagesFragmentModeManager.a parama, MessagesFragmentModeManager.c paramc, MessagesFragmentModeManager.MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, MessagesFragmentModeManager.d paramd, boolean paramBoolean)
  {
    super(parama, paramc, paramMessagesFragmentModeManagerData, paramd, paramBoolean);
  }

  private void a(Activity paramActivity)
  {
    this.d = null;
    ViberDialogHandlers.h localh = new ViberDialogHandlers.h();
    localh.a = this.c;
    localh.b = f();
    r.f().a(false).a(localh).a(paramActivity);
  }

  private void b(Activity paramActivity)
  {
    this.d = null;
    ViberDialogHandlers.v localv = new ViberDialogHandlers.v();
    localv.a = this.c;
    localv.b = f();
    r.r().a(false).a(localv).a(paramActivity);
  }

  public MessagesFragmentModeManager.MessagesFragmentModeManagerData a()
  {
    return new PublicGroupsFragmentModeManagerData(this);
  }

  public MessagesFragmentModeManager.b a(a parama)
  {
    c localc = (c)parama;
    boolean bool1 = parama.a() instanceof ConversationWithPublicAccountLoaderEntity;
    boolean bool2 = false;
    if (bool1)
      bool2 = av.c(((ConversationWithPublicAccountLoaderEntity)parama.a()).getExtraFlags(), 0);
    return new a(parama.a().isGroupBehavior(), parama.a().isMuteConversation(), parama.g(), localc.i(), parama.a().getGroupRole(), parama.a().getGroupName(), parama.a().getGroupId(), parama.a().getConversationType(), parama.a().getFlags(), parama.a().getAppId(), parama.a().getWatchersCount(), bool2);
  }

  protected void a(final Activity paramActivity, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4, boolean paramBoolean5, final boolean paramBoolean6)
  {
    LinkedHashMap localLinkedHashMap = f();
    HashSet localHashSet = new HashSet(localLinkedHashMap.values().size());
    Iterator localIterator = localLinkedHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      MessagesFragmentModeManager.b localb2 = (MessagesFragmentModeManager.b)localIterator.next();
      if ((!localb2.c) && (!localb2.e))
        localHashSet.add(Long.valueOf(a.a((a)localb2)));
    }
    if (localHashSet.size() == 1)
    {
      MessagesFragmentModeManager.b localb1 = (MessagesFragmentModeManager.b)localLinkedHashMap.get(localHashSet.iterator().next());
      if (((localb1 instanceof a)) && (((a)localb1).m))
      {
        super.a(paramActivity, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, false, paramBoolean6);
        return;
      }
      final int i = localb1.f;
      ViberApplication.getInstance().getMessagesManager().c().a(localHashSet, new ai.c()
      {
        public void a(Map<Long, Integer> paramAnonymousMap)
        {
          if (!paramActivity.isFinishing())
          {
            if (((Integer)paramAnonymousMap.values().iterator().next()).intValue() == 1)
              PublicGroupsFragmentModeManager.a(PublicGroupsFragmentModeManager.this, paramActivity);
          }
          else
            return;
          if (i == 5)
          {
            PublicGroupsFragmentModeManager.a(PublicGroupsFragmentModeManager.this, paramActivity, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, false, paramBoolean6);
            return;
          }
          PublicGroupsFragmentModeManager.b(PublicGroupsFragmentModeManager.this, paramActivity);
        }
      });
      return;
    }
    super.a(paramActivity, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, false, paramBoolean6);
  }

  public static class PublicGroupsFragmentModeManagerData extends MessagesFragmentModeManager.MessagesFragmentModeManagerData
    implements Parcelable
  {
    public static final Parcelable.Creator<PublicGroupsFragmentModeManagerData> CREATOR = new Parcelable.Creator()
    {
      public PublicGroupsFragmentModeManager.PublicGroupsFragmentModeManagerData a(Parcel paramAnonymousParcel)
      {
        return new PublicGroupsFragmentModeManager.PublicGroupsFragmentModeManagerData(paramAnonymousParcel, null);
      }

      public PublicGroupsFragmentModeManager.PublicGroupsFragmentModeManagerData[] a(int paramAnonymousInt)
      {
        return new PublicGroupsFragmentModeManager.PublicGroupsFragmentModeManagerData[paramAnonymousInt];
      }
    };

    private PublicGroupsFragmentModeManagerData(Parcel paramParcel)
    {
      this.savedMode = paramParcel.readInt();
      this.savedQuery = paramParcel.readString();
      int i = paramParcel.readInt();
      int j = 0;
      if (j < i)
      {
        Map localMap = this.savedSelection;
        Long localLong = Long.valueOf(paramParcel.readLong());
        boolean bool2;
        label58: boolean bool3;
        label69: boolean bool4;
        label80: long l1;
        int k;
        String str;
        long l2;
        int m;
        long l3;
        int n;
        int i1;
        if (paramParcel.readByte() == 1)
        {
          bool2 = true;
          if (paramParcel.readByte() != 1)
            break label192;
          bool3 = true;
          if (paramParcel.readByte() != 1)
            break label198;
          bool4 = true;
          l1 = paramParcel.readLong();
          k = paramParcel.readInt();
          str = paramParcel.readString();
          l2 = paramParcel.readLong();
          m = paramParcel.readInt();
          l3 = paramParcel.readLong();
          n = paramParcel.readInt();
          i1 = paramParcel.readInt();
          if (paramParcel.readByte() != 1)
            break label204;
        }
        label192: label198: label204: for (boolean bool5 = true; ; bool5 = false)
        {
          localMap.put(localLong, new PublicGroupsFragmentModeManager.a(bool2, bool3, bool4, l1, k, str, l2, m, l3, n, i1, bool5));
          j++;
          break;
          bool2 = false;
          break label58;
          bool3 = false;
          break label69;
          bool4 = false;
          break label80;
        }
      }
      if (paramParcel.readByte() == 1);
      for (boolean bool1 = true; ; bool1 = false)
      {
        this.doShowDeleteDialog = bool1;
        return;
      }
    }

    protected PublicGroupsFragmentModeManagerData(PublicGroupsFragmentModeManager paramPublicGroupsFragmentModeManager)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.savedMode);
      paramParcel.writeString(this.savedQuery);
      paramParcel.writeInt(this.savedSelection.size());
      Iterator localIterator = this.savedSelection.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeLong(((Long)localEntry.getKey()).longValue());
        PublicGroupsFragmentModeManager.a locala = (PublicGroupsFragmentModeManager.a)localEntry.getValue();
        int j;
        label109: int k;
        label127: int m;
        if (locala.a)
        {
          j = i;
          paramParcel.writeByte((byte)j);
          if (!locala.b)
            break label251;
          k = i;
          paramParcel.writeByte((byte)k);
          if (!locala.c)
            break label257;
          m = i;
          label145: paramParcel.writeByte((byte)m);
          paramParcel.writeLong(PublicGroupsFragmentModeManager.a.a(locala));
          paramParcel.writeInt(locala.g);
          paramParcel.writeString(locala.k);
          paramParcel.writeLong(locala.l);
          paramParcel.writeInt(locala.f);
          paramParcel.writeLong(locala.h);
          paramParcel.writeInt(locala.i);
          paramParcel.writeInt(locala.j);
          if (!locala.m)
            break label263;
        }
        label257: label263: for (int n = i; ; n = 0)
        {
          paramParcel.writeByte((byte)n);
          break;
          j = 0;
          break label109;
          label251: k = 0;
          break label127;
          m = 0;
          break label145;
        }
      }
      if (this.doShowDeleteDialog);
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        i = 0;
      }
    }
  }

  public static class a extends MessagesFragmentModeManager.b
  {
    public String k;
    public long l;
    public boolean m;
    private long n;

    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4, boolean paramBoolean4)
    {
      super(paramBoolean2, paramBoolean3, paramInt2, paramInt1, paramLong3, paramInt3, paramInt4);
      this.n = paramLong1;
      this.k = paramString;
      this.l = paramLong2;
      this.m = paramBoolean4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.PublicGroupsFragmentModeManager
 * JD-Core Version:    0.6.2
 */