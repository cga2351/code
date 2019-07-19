package com.viber.voip.group.participants.settings;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArraySet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.invitelinks.linkscreen.g.a;
import com.viber.voip.messages.controller.GroupController.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;
import com.viber.voip.util.cl;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParticipantsSettingsPresenter
  implements d.a, k, g.a
{
  private static final Logger a = ViberEnv.getLogger("ParticipantsSettingsPresenter");
  private static final j b = (j)cl.b(j.class);
  private final long c;
  private final long d;
  private final d e;
  private final h f;
  private j g = b;
  private Map<String, OverrideParticipantPermissions> h = new HashMap();
  private OverridePermissions i;
  private final PublicAccount.GlobalPermissions j;
  private final com.viber.voip.invitelinks.linkscreen.g k;
  private final com.viber.voip.analytics.g l;
  private String m;
  private int n;
  private int o;
  private GroupController.a p = new GroupController.a()
  {
    public void a(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ParticipantsSettingsPresenter.a(ParticipantsSettingsPresenter.this, paramAnonymousInt1);
      ParticipantsSettingsPresenter.b(ParticipantsSettingsPresenter.this, paramAnonymousInt2);
    }
  };
  private ArraySet<Long> q = new ArraySet();
  private ArraySet<Long> r = new ArraySet();

  public ParticipantsSettingsPresenter(long paramLong1, long paramLong2, d paramd, h paramh, com.viber.voip.invitelinks.linkscreen.g paramg, com.viber.voip.analytics.g paramg1)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramd;
    this.f = paramh;
    this.k = paramg;
    this.l = paramg1;
    this.e.a(this);
    this.k.a(this);
    this.j = new PublicAccount.GlobalPermissions();
  }

  private OverrideParticipantPermissions a(ae paramae)
  {
    String str = paramae.h();
    OverrideParticipantPermissions localOverrideParticipantPermissions = (OverrideParticipantPermissions)this.h.get(str);
    if (localOverrideParticipantPermissions == null)
      localOverrideParticipantPermissions = OverrideParticipantPermissions.from(paramae);
    return localOverrideParticipantPermissions;
  }

  private void a(SavedState paramSavedState)
  {
    String str = paramSavedState.getSearchQuery();
    this.g.a(str);
    this.h = paramSavedState.getParticipantPermissionSettingsOverrides();
    this.o = paramSavedState.getMutedCount();
    this.i = paramSavedState.getGlobalPermissions();
  }

  private void a(ae paramae, OverrideParticipantPermissions paramOverrideParticipantPermissions)
  {
    String str = paramae.h();
    if (!paramOverrideParticipantPermissions.isEqual(paramae))
    {
      this.h.put(str, paramOverrideParticipantPermissions);
      return;
    }
    this.h.remove(str);
  }

  private void c(boolean paramBoolean)
  {
    if (this.i == null)
      this.i = new OverridePermissions();
    this.i.setCanWriteToCommunity(paramBoolean);
  }

  private void e()
  {
    this.q.clear();
    this.r.clear();
    Iterator localIterator = this.h.values().iterator();
    while (localIterator.hasNext())
    {
      OverrideParticipantPermissions localOverrideParticipantPermissions = (OverrideParticipantPermissions)localIterator.next();
      if (localOverrideParticipantPermissions.canWrite())
        this.r.add(Long.valueOf(localOverrideParticipantPermissions.getParticipantId()));
      else
        this.q.add(Long.valueOf(localOverrideParticipantPermissions.getParticipantId()));
    }
    this.f.a(this.c, this.r, this.q, this.p);
  }

  private void f()
  {
    this.g.a(this.h, this.i);
  }

  public void a()
  {
    e();
    this.e.a(this.c);
    this.k.a();
  }

  public void a(j paramj, Parcelable paramParcelable)
  {
    this.g = paramj;
    this.g.a(this);
    this.g.a(this.e, this.j);
    SavedState localSavedState = (SavedState)paramParcelable;
    if (localSavedState != null)
      a(localSavedState);
  }

  public void a(ae paramae, boolean paramBoolean)
  {
    OverrideParticipantPermissions localOverrideParticipantPermissions = a(paramae);
    localOverrideParticipantPermissions.setCanWriteToCommunity(paramBoolean);
    a(paramae, localOverrideParticipantPermissions);
    e();
  }

  public void a(String paramString)
  {
    this.m = paramString;
    this.e.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }

  public void b()
  {
    this.g = b;
    this.e.a();
    this.e.b();
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      e();
    f();
  }

  public Parcelable c()
  {
    return new SavedState(this.m, this.h, this.i, this.o);
  }

  public void d()
  {
    if ((this.i != null) && (!this.i.isEqual(this.j)))
      this.f.a(this.d, this.i);
    this.f.a(this.d, this.h);
    this.h.clear();
  }

  public void onConversationDeleted()
  {
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity;
    if ((paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
    {
      localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
      if (localPublicGroupConversationItemLoaderEntity.isCommunityBlocked())
        this.g.a();
    }
    else
    {
      return;
    }
    this.j.setRawPrivileges(localPublicGroupConversationItemLoaderEntity.getCommunityPrivileges());
    f();
  }

  public static class OverrideParticipantPermissions extends ParticipantsSettingsPresenter.OverridePermissions
    implements Parcelable, b
  {
    public static final Parcelable.Creator<OverrideParticipantPermissions> CREATOR = new Parcelable.Creator()
    {
      public ParticipantsSettingsPresenter.OverrideParticipantPermissions a(Parcel paramAnonymousParcel)
      {
        return new ParticipantsSettingsPresenter.OverrideParticipantPermissions(paramAnonymousParcel, null);
      }

      public ParticipantsSettingsPresenter.OverrideParticipantPermissions[] a(int paramAnonymousInt)
      {
        return new ParticipantsSettingsPresenter.OverrideParticipantPermissions[paramAnonymousInt];
      }
    };
    private boolean mCanWrite;
    private final String mMemberId;
    private long mParticipantId;

    private OverrideParticipantPermissions(Parcel paramParcel)
    {
      super(null);
      this.mMemberId = paramParcel.readString();
      this.mParticipantId = paramParcel.readLong();
    }

    private OverrideParticipantPermissions(ae paramae)
    {
      this.mMemberId = paramae.h();
      this.mCanWrite = paramae.canWrite();
      this.mParticipantId = paramae.i();
    }

    public static OverrideParticipantPermissions from(ae paramae)
    {
      return new OverrideParticipantPermissions(paramae);
    }

    public String getMemberId()
    {
      return this.mMemberId;
    }

    public long getParticipantId()
    {
      return this.mParticipantId;
    }

    public String toString()
    {
      return "ParticipantPermissions{mMemberId='" + this.mMemberId + '\'' + ", mCanWrite=" + this.mCanWrite + ", mParticipantId=" + this.mParticipantId + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.mCanWrite);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeLong(this.mParticipantId);
        return;
      }
    }
  }

  public static class OverridePermissions
    implements Parcelable, b
  {
    public static final Parcelable.Creator<OverridePermissions> CREATOR = new Parcelable.Creator()
    {
      public ParticipantsSettingsPresenter.OverridePermissions a(Parcel paramAnonymousParcel)
      {
        return new ParticipantsSettingsPresenter.OverridePermissions(paramAnonymousParcel, null);
      }

      public ParticipantsSettingsPresenter.OverridePermissions[] a(int paramAnonymousInt)
      {
        return new ParticipantsSettingsPresenter.OverridePermissions[paramAnonymousInt];
      }
    };
    private boolean mCanWrite;

    public OverridePermissions()
    {
    }

    private OverridePermissions(Parcel paramParcel)
    {
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.mCanWrite = bool;
        return;
      }
    }

    public boolean canWrite()
    {
      return this.mCanWrite;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean isEqual(b paramb)
    {
      return (paramb != null) && (canWrite() == paramb.canWrite());
    }

    public void setCanWriteToCommunity(boolean paramBoolean)
    {
      this.mCanWrite = paramBoolean;
    }

    public String toString()
    {
      return "OverridePermissions{mCanWrite=" + this.mCanWrite + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.mCanWrite);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        return;
      }
    }
  }

  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ParticipantsSettingsPresenter.SavedState a(Parcel paramAnonymousParcel)
      {
        return new ParticipantsSettingsPresenter.SavedState(paramAnonymousParcel);
      }

      public ParticipantsSettingsPresenter.SavedState[] a(int paramAnonymousInt)
      {
        return new ParticipantsSettingsPresenter.SavedState[paramAnonymousInt];
      }
    };
    private final ParticipantsSettingsPresenter.OverridePermissions mGlobalPermissions;
    private final int mMutedCount;
    private final Map<String, ParticipantsSettingsPresenter.OverrideParticipantPermissions> mParticipantPermissionSettingsOverrides;
    private final String mSearchQuery;

    protected SavedState(Parcel paramParcel)
    {
      this.mSearchQuery = paramParcel.readString();
      this.mMutedCount = paramParcel.readInt();
      this.mGlobalPermissions = ((ParticipantsSettingsPresenter.OverridePermissions)paramParcel.readParcelable(ParticipantsSettingsPresenter.OverridePermissions.class.getClassLoader()));
      ParticipantsSettingsPresenter.OverrideParticipantPermissions[] arrayOfOverrideParticipantPermissions = (ParticipantsSettingsPresenter.OverrideParticipantPermissions[])paramParcel.readArray(ParticipantsSettingsPresenter.OverrideParticipantPermissions.class.getClassLoader());
      this.mParticipantPermissionSettingsOverrides = new HashMap();
      for (int i = 0; i < arrayOfOverrideParticipantPermissions.length; i++)
      {
        ParticipantsSettingsPresenter.OverrideParticipantPermissions localOverrideParticipantPermissions = arrayOfOverrideParticipantPermissions[i];
        this.mParticipantPermissionSettingsOverrides.put(localOverrideParticipantPermissions.getMemberId(), localOverrideParticipantPermissions);
      }
    }

    public SavedState(String paramString, Map<String, ParticipantsSettingsPresenter.OverrideParticipantPermissions> paramMap, ParticipantsSettingsPresenter.OverridePermissions paramOverridePermissions, int paramInt)
    {
      this.mSearchQuery = paramString;
      this.mParticipantPermissionSettingsOverrides = paramMap;
      this.mGlobalPermissions = paramOverridePermissions;
      this.mMutedCount = paramInt;
    }

    public int describeContents()
    {
      return 0;
    }

    public ParticipantsSettingsPresenter.OverridePermissions getGlobalPermissions()
    {
      return this.mGlobalPermissions;
    }

    public int getMutedCount()
    {
      return this.mMutedCount;
    }

    public Map<String, ParticipantsSettingsPresenter.OverrideParticipantPermissions> getParticipantPermissionSettingsOverrides()
    {
      return this.mParticipantPermissionSettingsOverrides;
    }

    public String getSearchQuery()
    {
      return this.mSearchQuery;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mSearchQuery);
      paramParcel.writeInt(this.mMutedCount);
      paramParcel.writeParcelable(this.mGlobalPermissions, paramInt);
      paramParcel.writeArray((ParticipantsSettingsPresenter.OverrideParticipantPermissions[])this.mParticipantPermissionSettingsOverrides.values().toArray(new ParticipantsSettingsPresenter.OverrideParticipantPermissions[this.mParticipantPermissionSettingsOverrides.size()]));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.ParticipantsSettingsPresenter
 * JD-Core Version:    0.6.2
 */