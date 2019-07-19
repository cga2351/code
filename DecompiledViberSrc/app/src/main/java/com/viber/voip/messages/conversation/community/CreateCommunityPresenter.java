package com.viber.voip.messages.conversation.community;

import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.h;
import com.viber.voip.permissions.n;
import com.viber.voip.util.cl;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

class CreateCommunityPresenter
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private long c;
  private Uri d = null;
  private Handler e;
  private com.viber.common.permission.c f;
  private GroupController.GroupMember[] g;
  private bv h;
  private GroupController i;
  private f j;
  private a k;
  private com.viber.voip.messages.conversation.community.a.e l;
  private final ai m;
  private final EventBus n;
  private boolean o;
  private g p;
  private final com.viber.voip.analytics.story.e.c q;
  private dagger.a<ab> r;
  private bv.t s = new bv.t()
  {
    public void onPublicGroupCreateError(final int paramAnonymousInt1, int paramAnonymousInt2)
    {
      CreateCommunityPresenter.c(CreateCommunityPresenter.this).post(new Runnable()
      {
        public void run()
        {
          if (paramAnonymousInt1 == CreateCommunityPresenter.a(CreateCommunityPresenter.this))
          {
            CreateCommunityPresenter.a(CreateCommunityPresenter.this, false);
            CreateCommunityPresenter.b(CreateCommunityPresenter.this).c();
            CreateCommunityPresenter.b(CreateCommunityPresenter.this).b();
          }
        }
      });
    }

    public void onPublicGroupCreated(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString1, Map<String, Integer> paramAnonymousMap, String paramAnonymousString2, String paramAnonymousString3)
    {
      h localh = ((ab)CreateCommunityPresenter.d(CreateCommunityPresenter.this).get()).f(paramAnonymousLong1);
      if (localh != null)
        CreateCommunityPresenter.c(CreateCommunityPresenter.this).post(new e(this, paramAnonymousInt, paramAnonymousLong1, paramAnonymousString3, paramAnonymousLong2, paramAnonymousMap, localh));
    }
  };

  public CreateCommunityPresenter(Handler paramHandler, GroupController.GroupMember[] paramArrayOfGroupMember, bv parambv, GroupController paramGroupController, f paramf, com.viber.voip.messages.conversation.community.a.e parame, com.viber.common.permission.c paramc, g paramg, com.viber.voip.analytics.story.e.c paramc1, ai paramai, EventBus paramEventBus, dagger.a<ab> parama)
  {
    this.e = paramHandler;
    this.g = paramArrayOfGroupMember;
    this.h = parambv;
    this.i = paramGroupController;
    this.j = paramf;
    this.l = parame;
    this.f = paramc;
    this.p = paramg;
    this.q = paramc1;
    this.m = paramai;
    this.n = paramEventBus;
    this.r = parama;
  }

  public void a()
  {
    this.k = ((a)cl.b(a.class));
    this.h.b(this.s);
  }

  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    do
      return;
    while (this.c <= 0L);
    this.j.a(this.c);
  }

  public void a(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      return;
    case 9:
      this.d = this.j.a(100);
      return;
    case 127:
    }
    this.j.b(101);
  }

  public void a(Uri paramUri)
  {
    this.d = paramUri;
  }

  public void a(CreateCommunityActivity.a parama, Parcelable paramParcelable)
  {
    this.k = parama;
    this.h.a(this.s);
    SaveState localSaveState = (SaveState)paramParcelable;
    if (localSaveState != null)
    {
      this.d = localSaveState.mUri;
      this.k.a(this.d);
      this.k.a(localSaveState.mName);
      this.k.b(localSaveState.mAbout);
    }
  }

  public void a(String paramString1, String paramString2)
  {
    SaveState localSaveState = new SaveState(paramString1, paramString2, this.d);
    this.j.a(localSaveState);
  }

  public Parcelable b()
  {
    return new SaveState("", "", this.d);
  }

  public void b(String paramString1, String paramString2)
  {
    if (!this.o)
    {
      this.o = true;
      this.k.a();
      this.b = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
      this.i.a(this.b, paramString1, this.g, paramString2, this.d);
    }
  }

  public void c()
  {
    if (this.f.a(n.c))
    {
      this.d = this.j.a(100);
      return;
    }
    this.k.a(9, n.c);
  }

  public void d()
  {
    if (this.f.a(n.m))
    {
      this.j.b(101);
      return;
    }
    this.k.a(127, n.m);
  }

  public Uri e()
  {
    return this.d;
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public CreateCommunityPresenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new CreateCommunityPresenter.SaveState(paramAnonymousParcel);
      }

      public CreateCommunityPresenter.SaveState[] a(int paramAnonymousInt)
      {
        return new CreateCommunityPresenter.SaveState[paramAnonymousInt];
      }
    };
    private String mAbout;
    private String mName;
    private Uri mUri;

    protected SaveState(Parcel paramParcel)
    {
      this.mName = paramParcel.readString();
      this.mAbout = paramParcel.readString();
      this.mUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    }

    public SaveState(String paramString1, String paramString2, Uri paramUri)
    {
      this.mName = paramString1;
      this.mAbout = paramString2;
      this.mUri = paramUri;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mName);
      paramParcel.writeString(this.mAbout);
      paramParcel.writeParcelable(this.mUri, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.CreateCommunityPresenter
 * JD-Core Version:    0.6.2
 */