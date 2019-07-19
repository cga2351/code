package com.viber.voip.messages.conversation.ui.edit.group;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.ca;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;

class AddGroupDetailsPresenterImpl
  implements AddGroupDetailsPresenter, a.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final cj b;
  private final b c;
  private final a d;
  private c e;
  private AddGroupDetailsPresenter.AddDetailsGoNextAction f;
  private final UpdateDetailsState g = new UpdateDetailsState();
  private AddDetailsSaveState h;
  private ConversationItemLoaderEntity i;
  private Uri j;
  private String k;
  private int l;

  public AddGroupDetailsPresenterImpl(b paramb, a parama, cj paramcj)
  {
    this.c = paramb;
    this.d = parama;
    this.d.a(this);
    this.b = paramcj;
  }

  private void a(AddDetailsSaveState paramAddDetailsSaveState)
  {
    UpdateDetailsState localUpdateDetailsState = paramAddDetailsSaveState.updateDetailsState;
    this.g.mergeFromRestore(localUpdateDetailsState);
    if (this.g.getNameStatus() == 4)
    {
      String str = paramAddDetailsSaveState.tempGroupName;
      if ((str == null) || (!str.equals(this.i.getGroupName())))
        break label85;
      this.g.setNameStatus(0);
    }
    while (true)
    {
      if (this.g.getIconStatus() == 4)
      {
        if (this.i.getIconUri() == null)
          break;
        this.g.setIconStatus(0);
      }
      return;
      label85: this.g.setNameStatus(1);
    }
    this.g.setIconStatus(1);
  }

  private void a(boolean paramBoolean)
  {
    switch (this.g.getStatus())
    {
    case 3:
    case 4:
    default:
    case 1:
    case 0:
    case 2:
    }
    do
    {
      return;
      q();
      return;
      p();
      return;
    }
    while (!paramBoolean);
    this.e.a(paramBoolean);
  }

  private int b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int m;
    if (paramConversationItemLoaderEntity.getIconUri() != null)
    {
      m = paramConversationItemLoaderEntity.getIconUri().hashCode();
      if (paramConversationItemLoaderEntity.getGroupName() == null)
        break label50;
    }
    label50: for (int n = paramConversationItemLoaderEntity.getGroupName().hashCode(); ; n = 0)
    {
      return ca.a(new int[] { m, n });
      m = 0;
      break;
    }
  }

  private void c(long paramLong)
  {
    this.e.a(true);
    this.d.b(paramLong);
  }

  private void k()
  {
    m();
    o();
    this.d.c(this.i.getId());
  }

  private boolean l()
  {
    return (this.i != null) && (!da.a(this.k)) && (!this.k.equals(this.i.getGroupName()));
  }

  private boolean m()
  {
    if (l())
    {
      this.d.a(this.i.getGroupId(), this.k);
      return true;
    }
    return false;
  }

  private boolean n()
  {
    return (this.i != null) && (this.j != null) && (!this.j.equals(this.i.getIconUri()));
  }

  private boolean o()
  {
    if (n())
    {
      this.d.a(this.i.getGroupId(), this.j);
      return true;
    }
    return false;
  }

  private void p()
  {
    if (this.i != null)
    {
      this.g.reset();
      this.c.a(this.f, this.i);
    }
  }

  private void q()
  {
    this.g.reset();
    this.e.a(false);
    this.e.c();
  }

  private void r()
  {
    c localc = this.e;
    if ((l()) || (n()));
    for (boolean bool = true; ; bool = false)
    {
      localc.b(bool);
      return;
    }
  }

  private boolean s()
  {
    return this.b.a() == -1;
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    this.g.setNameStatus(paramInt);
    a(false);
  }

  public void a(long paramLong)
  {
    if (paramLong == this.i.getId())
      this.c.a();
  }

  public void a(Uri paramUri)
  {
    this.e.a(paramUri);
    this.j = paramUri;
    r();
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AddDetailsSaveState))
    {
      this.h = ((AddDetailsSaveState)paramParcelable);
      a(this.h.goToNextAction);
      c(this.h.conversationId);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int m = b(paramConversationItemLoaderEntity);
    this.i = paramConversationItemLoaderEntity;
    this.e.a(false);
    if (this.h != null)
      if ((this.j == null) && (this.h.tempIconUri != null))
      {
        this.j = this.h.tempIconUri;
        if (da.a(this.h.tempGroupName))
          break label158;
        this.k = this.h.tempGroupName;
        label80: this.e.a(this.k);
        this.e.a(this.j);
        a(this.h);
        a(true);
        this.h = null;
      }
    while (true)
    {
      this.l = m;
      r();
      return;
      if (this.i.getIconUri() == null)
        break;
      a(this.i.getIconUri());
      break;
      label158: if (da.a(this.i.getGroupName()))
        break label80;
      a(this.i.getGroupName());
      break label80;
      if (m != this.l)
      {
        a(this.i.getIconUri());
        a(this.i.getGroupName());
        this.e.a(this.i.getGroupName());
      }
    }
  }

  public void a(AddGroupDetailsPresenter.AddDetailsGoNextAction paramAddDetailsGoNextAction)
  {
    this.f = paramAddDetailsGoNextAction;
  }

  public void a(c paramc)
  {
    this.e = paramc;
  }

  public void a(String paramString)
  {
    String str = paramString.trim();
    if (!str.equals(this.k))
    {
      this.k = str;
      r();
    }
  }

  public void b()
  {
    if (s())
    {
      this.e.b();
      return;
    }
    this.e.a(true);
    k();
  }

  public void b(int paramInt)
  {
    this.g.setIconStatus(paramInt);
    a(false);
  }

  public void b(long paramLong)
  {
    c(paramLong);
  }

  public void c()
  {
    this.c.a(this.f, this.i);
  }

  public void d()
  {
    this.e.a();
  }

  public void e()
  {
    this.d.d();
  }

  public void f()
  {
    this.d.e();
  }

  public void g()
  {
    this.d.a();
  }

  public void h()
  {
    this.d.b();
  }

  public void i()
  {
    this.d.c();
  }

  public Parcelable j()
  {
    if (this.i != null)
    {
      Uri localUri1 = this.j;
      Uri localUri2 = null;
      if (localUri1 != null)
      {
        boolean bool = this.j.equals(this.i.getIconUri());
        localUri2 = null;
        if (!bool)
          localUri2 = this.j;
      }
      if ((!da.a(this.k)) && (!this.k.equals(this.i.getGroupName())));
      for (String str = this.k; ; str = "")
        return new AddDetailsSaveState(localUri2, str, this.i.getId(), this.g, this.f);
    }
    return null;
  }

  private static class AddDetailsSaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<AddDetailsSaveState> CREATOR = new Parcelable.Creator()
    {
      public AddGroupDetailsPresenterImpl.AddDetailsSaveState a(Parcel paramAnonymousParcel)
      {
        return new AddGroupDetailsPresenterImpl.AddDetailsSaveState(paramAnonymousParcel);
      }

      public AddGroupDetailsPresenterImpl.AddDetailsSaveState[] a(int paramAnonymousInt)
      {
        return new AddGroupDetailsPresenterImpl.AddDetailsSaveState[paramAnonymousInt];
      }
    };
    final long conversationId;
    final AddGroupDetailsPresenter.AddDetailsGoNextAction goToNextAction;
    final String tempGroupName;
    final Uri tempIconUri;
    final AddGroupDetailsPresenterImpl.UpdateDetailsState updateDetailsState;

    AddDetailsSaveState(Uri paramUri, String paramString, long paramLong, AddGroupDetailsPresenterImpl.UpdateDetailsState paramUpdateDetailsState, AddGroupDetailsPresenter.AddDetailsGoNextAction paramAddDetailsGoNextAction)
    {
      this.tempIconUri = paramUri;
      this.tempGroupName = paramString;
      this.conversationId = paramLong;
      this.updateDetailsState = paramUpdateDetailsState;
      this.goToNextAction = paramAddDetailsGoNextAction;
    }

    AddDetailsSaveState(Parcel paramParcel)
    {
      this.tempIconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.tempGroupName = paramParcel.readString();
      this.conversationId = paramParcel.readLong();
      this.goToNextAction = ((AddGroupDetailsPresenter.AddDetailsGoNextAction)paramParcel.readParcelable(AddGroupDetailsPresenter.AddDetailsGoNextAction.class.getClassLoader()));
      this.updateDetailsState = ((AddGroupDetailsPresenterImpl.UpdateDetailsState)paramParcel.readParcelable(AddGroupDetailsPresenterImpl.UpdateDetailsState.class.getClassLoader()));
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "AddDetailsSaveState{tempIconUri=" + this.tempIconUri + ", tempGroupName='" + this.tempGroupName + '\'' + ", updateDetailsState=" + this.updateDetailsState + ", conversationId=" + this.conversationId + ", goToNextAction=" + this.goToNextAction + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.tempIconUri, paramInt);
      paramParcel.writeString(this.tempGroupName);
      paramParcel.writeLong(this.conversationId);
      paramParcel.writeParcelable(this.goToNextAction, paramInt);
      paramParcel.writeParcelable(this.updateDetailsState, paramInt);
    }
  }

  private static class UpdateDetailsState
    implements Parcelable
  {
    public static final Parcelable.Creator<UpdateDetailsState> CREATOR = new Parcelable.Creator()
    {
      public AddGroupDetailsPresenterImpl.UpdateDetailsState a(Parcel paramAnonymousParcel)
      {
        return new AddGroupDetailsPresenterImpl.UpdateDetailsState(paramAnonymousParcel);
      }

      public AddGroupDetailsPresenterImpl.UpdateDetailsState[] a(int paramAnonymousInt)
      {
        return new AddGroupDetailsPresenterImpl.UpdateDetailsState[paramAnonymousInt];
      }
    };
    private volatile int mIconStatus = 3;
    private volatile int mNameStatus = 3;

    UpdateDetailsState()
    {
    }

    UpdateDetailsState(Parcel paramParcel)
    {
      this.mNameStatus = paramParcel.readInt();
      this.mIconStatus = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    int getIconStatus()
    {
      return this.mIconStatus;
    }

    int getNameStatus()
    {
      return this.mNameStatus;
    }

    public int getStatus()
    {
      if ((this.mNameStatus == 3) && (this.mIconStatus == 3))
        return 3;
      if ((this.mNameStatus == 1) || (this.mIconStatus == 1))
        return 1;
      if (((this.mNameStatus == 0) || (this.mNameStatus == 3)) && ((this.mIconStatus == 0) || (this.mIconStatus == 3)))
        return 0;
      if ((this.mNameStatus == 4) || (this.mIconStatus == 4))
        return 4;
      return 2;
    }

    void mergeFromRestore(UpdateDetailsState paramUpdateDetailsState)
    {
      int i = paramUpdateDetailsState.getIconStatus();
      int j = paramUpdateDetailsState.getNameStatus();
      if ((i == 1) || (i == 0))
        this.mIconStatus = i;
      if ((j == 1) || (j == 0))
        this.mNameStatus = j;
    }

    void reset()
    {
      this.mIconStatus = 3;
      this.mNameStatus = 3;
    }

    void setIconStatus(int paramInt)
    {
      this.mIconStatus = paramInt;
    }

    void setNameStatus(int paramInt)
    {
      this.mNameStatus = paramInt;
    }

    public String toString()
    {
      return "UpdateDetailsState{mNameStatus=" + this.mNameStatus + ", mIconStatus=" + this.mIconStatus + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mNameStatus);
      paramParcel.writeInt(this.mIconStatus);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsPresenterImpl
 * JD-Core Version:    0.6.2
 */