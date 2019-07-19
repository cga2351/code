package com.viber.voip.backgrounds.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.p;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.i;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.extras.image.a;
import com.viber.voip.messages.extras.image.a.a;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.dv;
import javax.inject.Inject;

public class CommunitySelectBackgroundPresenter
  implements a.a
{
  private static final Logger a = ViberEnv.getLogger();
  private c b = (c)cl.b(c.class);
  private final Context c;
  private final ai d;
  private final GroupController e;
  private final a f;
  private final PhoneController g;
  private final bv h;
  private final com.viber.voip.analytics.story.e.c i;
  private final Handler j;
  private com.viber.voip.model.entity.h k;
  private ai.i l;
  private Uri m;
  private volatile int n = -1;
  private int o;
  private String p;
  private bv.t q = new bv.t()
  {
    public void onPublicGroupInfoChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      CommunitySelectBackgroundPresenter.a(CommunitySelectBackgroundPresenter.this).post(new h(this, paramAnonymousInt1, paramAnonymousInt2));
    }
  };

  @Inject
  public CommunitySelectBackgroundPresenter(Context paramContext, ai paramai, GroupController paramGroupController, a parama, PhoneController paramPhoneController, bv parambv, Handler paramHandler, com.viber.voip.analytics.story.e.c paramc)
  {
    this.c = paramContext;
    this.d = paramai;
    this.e = paramGroupController;
    this.f = parama;
    this.g = paramPhoneController;
    this.h = parambv;
    this.j = paramHandler;
    this.i = paramc;
  }

  private void a(int paramInt, PublicAccount paramPublicAccount, PublicAccount.Background paramBackground)
  {
    if (paramPublicAccount == null)
    {
      this.j.post(new f(this));
      return;
    }
    if (paramPublicAccount.isCommunityBlocked())
    {
      this.j.post(new g(this));
      return;
    }
    paramPublicAccount.setBackground(paramBackground);
    this.e.a(paramInt, 4, paramPublicAccount);
  }

  private void a(Uri paramUri, String paramString, boolean paramBoolean)
  {
    this.p = paramString;
    if (paramBoolean)
      this.b.b();
    this.m = paramUri;
    this.f.a(this);
    this.f.a(3, this.c, new Uri[] { paramUri }, "image", dv.h, 1000, -1);
  }

  private void a(ai.i parami)
  {
    com.viber.voip.model.entity.h localh = this.k;
    if (localh != null)
    {
      this.l = null;
      this.d.a(localh, parami);
      return;
    }
    this.l = parami;
  }

  private void a(boolean paramBoolean, ai.i parami)
  {
    if (cj.a(true))
    {
      if (paramBoolean)
        this.b.b();
      a(parami);
      return;
    }
    this.n = -1;
  }

  private void f()
  {
    if (this.k != null)
      this.i.a(ae.b(), this.k, this.p);
  }

  public void a()
  {
    this.b = ((c)cl.b(c.class));
    this.h.b(this.q);
    this.f.b(this);
  }

  public void a(int paramInt)
  {
    this.o = paramInt;
    this.p = "Gallery";
    this.n = this.g.generateSequence();
    a(true, new d(this, paramInt));
  }

  public void a(int paramInt1, SendMediaDataContainer paramSendMediaDataContainer, int paramInt2, int paramInt3)
  {
  }

  public void a(int paramInt, SendMediaDataContainer[] paramArrayOfSendMediaDataContainer)
  {
    if (paramArrayOfSendMediaDataContainer != null);
    for (SendMediaDataContainer localSendMediaDataContainer = paramArrayOfSendMediaDataContainer[0]; ; localSendMediaDataContainer = null)
    {
      if ((paramInt == 3) && (localSendMediaDataContainer != null))
      {
        this.n = this.g.generateSequence();
        this.m = null;
        this.f.b(this);
        if (dv.a(localSendMediaDataContainer.fileUri, dv.g, this.c))
          at.d(this.c, localSendMediaDataContainer.fileUri);
        a(false, new e(this, localSendMediaDataContainer));
      }
      return;
    }
  }

  public void a(Uri paramUri, String paramString)
  {
    this.b.b(paramUri, paramString);
  }

  public void a(p paramp)
  {
    this.b.a(paramp.a);
  }

  public void a(c paramc, Parcelable paramParcelable)
  {
    this.b = paramc;
    if ((paramParcelable instanceof SaveState))
    {
      SaveState localSaveState = (SaveState)paramParcelable;
      this.n = localSaveState.applyBackgroundSequence;
      this.m = localSaveState.customNonProcessedUri;
      this.o = localSaveState.pendingBackgroundId;
      this.p = localSaveState.imageChangeType;
      this.h.a(this.q);
      if (this.m != null)
      {
        if (this.p == null)
          this.p = "Gallery";
        a(this.m, this.p, false);
      }
      while ((this.n == -1) || (this.e.d(this.n)))
        return;
      this.b.c();
      return;
    }
    this.h.a(this.q);
  }

  public void a(com.viber.voip.model.entity.h paramh)
  {
    this.k = paramh;
    if (this.l != null)
      a(this.l);
  }

  public Parcelable b()
  {
    return new SaveState(this.n, this.m, this.o, this.p);
  }

  public void b(Uri paramUri, String paramString)
  {
    a(paramUri, paramString, true);
  }

  public void c()
  {
    this.b.c();
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public CommunitySelectBackgroundPresenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new CommunitySelectBackgroundPresenter.SaveState(paramAnonymousParcel);
      }

      public CommunitySelectBackgroundPresenter.SaveState[] a(int paramAnonymousInt)
      {
        return new CommunitySelectBackgroundPresenter.SaveState[paramAnonymousInt];
      }
    };
    final int applyBackgroundSequence;
    final Uri customNonProcessedUri;
    final String imageChangeType;
    final int pendingBackgroundId;

    public SaveState(int paramInt1, Uri paramUri, int paramInt2, String paramString)
    {
      this.applyBackgroundSequence = paramInt1;
      this.customNonProcessedUri = paramUri;
      this.pendingBackgroundId = paramInt2;
      this.imageChangeType = paramString;
    }

    protected SaveState(Parcel paramParcel)
    {
      this.applyBackgroundSequence = paramParcel.readInt();
      this.customNonProcessedUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.pendingBackgroundId = paramParcel.readInt();
      this.imageChangeType = paramParcel.readString();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.applyBackgroundSequence);
      paramParcel.writeParcelable(this.customNonProcessedUri, paramInt);
      paramParcel.writeInt(this.pendingBackgroundId);
      paramParcel.writeString(this.imageChangeType);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.ui.CommunitySelectBackgroundPresenter
 * JD-Core Version:    0.6.2
 */