package com.viber.voip.invitelinks.linkscreen;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public abstract class BaseShareLinkPresenter<V extends ScreenView>
  implements g.a
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected InviteLinkData b;
  protected ScreenView.Error c;
  protected final g d;
  protected final i e;
  protected V f;
  protected final a g;
  protected final EventBus h;
  protected final cj i;
  private final List<a> j = new LinkedList();

  public BaseShareLinkPresenter(InviteLinkData paramInviteLinkData, g paramg, i parami, a parama, EventBus paramEventBus, cj paramcj)
  {
    this.b = paramInviteLinkData;
    this.d = paramg;
    this.e = parami;
    this.g = parama;
    this.h = paramEventBus;
    this.i = paramcj;
  }

  private void m()
  {
    a(new c(this));
  }

  public Parcelable a(boolean paramBoolean)
  {
    if (paramBoolean)
      return new SaveState(this.b, this.c);
    if (this.c != null)
      return new SaveState(null, this.c);
    return null;
  }

  public void a()
  {
    this.d.d();
    this.f = ((ScreenView)cl.c(getClass()));
  }

  protected abstract void a(int paramInt);

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SaveState))
    {
      SaveState localSaveState = (SaveState)paramParcelable;
      if (localSaveState.data != null)
        this.b = localSaveState.data;
      this.c = localSaveState.error;
    }
  }

  protected final void a(a parama)
  {
    synchronized (this.j)
    {
      this.j.add(parama);
      this.d.a();
      return;
    }
  }

  protected void a(BaseShareLinkPresenter<V>.b paramBaseShareLinkPresenter)
  {
    paramBaseShareLinkPresenter.a();
  }

  @SuppressLint({"SwitchIntDef"})
  public void a(ScreenView.Error paramError)
  {
    switch (paramError.operation)
    {
    default:
      return;
    case 0:
      a(paramError.status);
      return;
    case 1:
      b(paramError.status);
      return;
    case 2:
    }
    c(paramError.status);
  }

  public void a(V paramV)
  {
    this.f = paramV;
  }

  protected boolean a(long paramLong)
  {
    return paramLong != this.b.groupId;
  }

  public void b()
  {
    if (!this.h.isRegistered(this))
      this.h.register(this);
  }

  protected abstract void b(int paramInt);

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      h();
  }

  public void c()
  {
    this.h.unregister(this);
    this.d.c();
    synchronized (this.j)
    {
      this.j.clear();
      return;
    }
  }

  protected abstract void c(int paramInt);

  protected abstract ScreenView.Error d();

  public void e()
  {
    if (this.c != null)
      return;
    this.d.a(this);
    if (da.a(this.b.shareUrl))
    {
      f();
      return;
    }
    this.f.a(this.b.shareUrl);
  }

  protected abstract void f();

  public void g()
  {
    this.f.b();
  }

  protected abstract void h();

  public void i()
  {
    this.e.a();
  }

  public void j()
  {
    this.g.a(this.b.shareUrl);
  }

  public void k()
  {
    if (this.b.sendCommunityInvite)
    {
      m();
      return;
    }
    a(new b(this));
  }

  public void l()
  {
    a(new d(this));
  }

  public void onConversationDeleted()
  {
    ScreenView.Error localError = d();
    this.c = localError;
    this.f.a(localError);
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      if (localIterator.hasNext())
        ((a)localIterator.next()).a(paramConversationItemLoaderEntity);
    }
    this.j.clear();
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public BaseShareLinkPresenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new BaseShareLinkPresenter.SaveState(paramAnonymousParcel);
      }

      public BaseShareLinkPresenter.SaveState[] a(int paramAnonymousInt)
      {
        return new BaseShareLinkPresenter.SaveState[paramAnonymousInt];
      }
    };
    public final InviteLinkData data;
    public final ScreenView.Error error;

    protected SaveState(Parcel paramParcel)
    {
      this.data = ((InviteLinkData)paramParcel.readParcelable(InviteLinkData.class.getClassLoader()));
      this.error = ((ScreenView.Error)paramParcel.readParcelable(ScreenView.Error.class.getClassLoader()));
    }

    public SaveState(InviteLinkData paramInviteLinkData, ScreenView.Error paramError)
    {
      this.data = paramInviteLinkData;
      this.error = paramError;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.data, paramInt);
      paramParcel.writeParcelable(this.error, paramInt);
    }
  }

  protected static abstract interface a
  {
    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity);
  }

  protected abstract class b
  {
    protected b()
    {
    }

    protected final void a()
    {
      if (b())
        return;
      BaseShareLinkPresenter.this.f.a(false);
      if (c())
      {
        BaseShareLinkPresenter.this.b = new InviteLinkData(BaseShareLinkPresenter.this.b, d());
        BaseShareLinkPresenter.this.c = null;
        BaseShareLinkPresenter.this.f.a(BaseShareLinkPresenter.this.b.shareUrl);
        return;
      }
      ScreenView.Error localError1 = e();
      BaseShareLinkPresenter localBaseShareLinkPresenter = BaseShareLinkPresenter.this;
      boolean bool = a(localError1);
      ScreenView.Error localError2 = null;
      if (bool)
        localError2 = localError1;
      localBaseShareLinkPresenter.c = localError2;
      if (b(localError1))
      {
        BaseShareLinkPresenter.this.f.c(localError1);
        return;
      }
      BaseShareLinkPresenter.this.f.a(localError1);
    }

    protected abstract boolean a(ScreenView.Error paramError);

    protected abstract boolean b();

    protected boolean b(ScreenView.Error paramError)
    {
      return BaseShareLinkPresenter.this.i.a() == -1;
    }

    protected abstract boolean c();

    protected abstract String d();

    protected abstract ScreenView.Error e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.BaseShareLinkPresenter
 * JD-Core Version:    0.6.2
 */