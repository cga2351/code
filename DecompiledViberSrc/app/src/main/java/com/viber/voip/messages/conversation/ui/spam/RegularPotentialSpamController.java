package com.viber.voip.messages.conversation.ui.spam;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.model.entity.m;

public class RegularPotentialSpamController
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final ab b;
  private final Handler c;
  private final Handler d;
  private final Runnable e = new Runnable()
  {
    public void run()
    {
      RegularPotentialSpamController.a(RegularPotentialSpamController.this);
    }
  };
  private final a.a f;
  private final LongSparseArray<Boolean> g = new LongSparseArray();
  private long h = -1L;
  private boolean i = true;
  private boolean j = true;

  public RegularPotentialSpamController(ab paramab, Handler paramHandler1, Handler paramHandler2, a.a parama)
  {
    this.b = paramab;
    this.c = paramHandler1;
    this.d = paramHandler2;
    this.f = parama;
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    boolean bool2 = e();
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    boolean bool3;
    a.a locala;
    if ((paramBoolean1) || (paramBoolean2))
    {
      bool3 = bool1;
      if (bool3 != bool2)
      {
        locala = this.f;
        if (bool2)
          break label62;
      }
    }
    while (true)
    {
      locala.a(bool1);
      return;
      bool3 = false;
      break;
      label62: bool1 = false;
    }
  }

  private boolean a(m paramm)
  {
    return (paramm != null) && (paramm.i() > 0L);
  }

  private void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, m paramm)
  {
    if (paramConversationItemLoaderEntity.getGroupRole() == 2)
    {
      a(true, this.j);
      return;
    }
    if (a(paramm))
    {
      a(true, this.j);
      return;
    }
    this.i = false;
    a();
  }

  private boolean b(long paramLong)
  {
    return ((Boolean)this.g.get(paramLong, Boolean.FALSE)).booleanValue();
  }

  private boolean b(aa paramaa)
  {
    FormattedMessage localFormattedMessage;
    if (paramaa.aE())
      localFormattedMessage = paramaa.L();
    return (localFormattedMessage != null) && (localFormattedMessage.isInviteFromPublicAccount());
  }

  private void d()
  {
    this.g.clear();
  }

  private boolean e()
  {
    return (this.i) || (this.j);
  }

  private void f()
  {
    final boolean bool = this.b.V(this.h);
    this.d.post(new Runnable()
    {
      public void run()
      {
        RegularPotentialSpamController.a(RegularPotentialSpamController.this, RegularPotentialSpamController.b(RegularPotentialSpamController.this), bool);
      }
    });
  }

  public void a()
  {
    if ((this.h != -1L) && (!this.i))
    {
      this.c.removeCallbacks(this.e);
      this.c.post(this.e);
    }
  }

  public void a(long paramLong)
  {
    this.g.put(paramLong, Boolean.TRUE);
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SaveState))
    {
      long[] arrayOfLong = ((SaveState)paramParcelable).getTemporaryDisplayableMessageIds();
      int k = arrayOfLong.length;
      for (int m = 0; m < k; m++)
        a(arrayOfLong[m]);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, m paramm)
  {
    boolean bool1 = true;
    if (this.h == paramConversationItemLoaderEntity.getId())
    {
      boolean bool3;
      boolean bool4;
      if (paramConversationItemLoaderEntity.isGroupBehavior())
      {
        boolean bool2 = this.i;
        if (paramConversationItemLoaderEntity.getGroupRole() != 2)
          break label76;
        bool3 = bool1;
        if (bool2 == bool3)
          break label82;
        bool4 = bool1;
        label48: if (this.i == a(paramm))
          break label88;
      }
      while (true)
      {
        if ((bool4) || (bool1))
          b(paramConversationItemLoaderEntity, paramm);
        return;
        label76: bool3 = false;
        break;
        label82: bool4 = false;
        break label48;
        label88: bool1 = false;
      }
    }
    if (this.h != -1L)
      d();
    this.h = paramConversationItemLoaderEntity.getId();
    this.i = bool1;
    this.j = bool1;
    if (paramConversationItemLoaderEntity.isSystemConversation())
    {
      a(bool1, this.j);
      return;
    }
    if (paramConversationItemLoaderEntity.isGroupBehavior())
    {
      b(paramConversationItemLoaderEntity, paramm);
      return;
    }
    if (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())
    {
      a(bool1, this.j);
      return;
    }
    a(false, false);
  }

  public boolean a(aa paramaa)
  {
    return (!b(paramaa.a())) && (!e()) && (paramaa.ao()) && (!paramaa.O()) && (!paramaa.aa()) && (!paramaa.W()) && (paramaa.w()) && (b(paramaa));
  }

  public void b()
  {
    this.c.removeCallbacks(this.e);
  }

  public Parcelable c()
  {
    if (this.g.size() > 0)
      return new SaveState(this.g);
    return null;
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public RegularPotentialSpamController.SaveState a(Parcel paramAnonymousParcel)
      {
        return new RegularPotentialSpamController.SaveState(paramAnonymousParcel);
      }

      public RegularPotentialSpamController.SaveState[] a(int paramAnonymousInt)
      {
        return new RegularPotentialSpamController.SaveState[paramAnonymousInt];
      }
    };
    private final long[] mTemporaryDisplayableMessageIds;

    protected SaveState(Parcel paramParcel)
    {
      this.mTemporaryDisplayableMessageIds = paramParcel.createLongArray();
    }

    public SaveState(LongSparseArray<Boolean> paramLongSparseArray)
    {
      this.mTemporaryDisplayableMessageIds = new long[paramLongSparseArray.size()];
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        this.mTemporaryDisplayableMessageIds[i] = paramLongSparseArray.keyAt(i);
        i++;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public long[] getTemporaryDisplayableMessageIds()
    {
      return this.mTemporaryDisplayableMessageIds;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLongArray(this.mTemporaryDisplayableMessageIds);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.RegularPotentialSpamController
 * JD-Core Version:    0.6.2
 */