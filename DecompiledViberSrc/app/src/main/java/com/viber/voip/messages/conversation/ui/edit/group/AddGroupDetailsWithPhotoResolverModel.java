package com.viber.voip.messages.conversation.ui.edit.group;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.util.Pair;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.l;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.util.ay;
import com.viber.voip.util.ay.a;
import com.viber.voip.util.e.j;

class AddGroupDetailsWithPhotoResolverModel
  implements d.a, l.a, a, e
{
  private static final Logger c = ViberEnv.getLogger();
  c a;
  b b;
  private a.a d;
  private bv e;
  private PhoneController f;
  private GroupController g;
  private l h;
  private Uri i;
  private int j;
  private int k;
  private Fragment l;
  private bv.t m = new bv.t()
  {
    public void onGroupIconChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
    {
      int i = 1;
      if (AddGroupDetailsWithPhotoResolverModel.c(AddGroupDetailsWithPhotoResolverModel.this) == paramAnonymousInt1)
      {
        a.a locala = AddGroupDetailsWithPhotoResolverModel.b(AddGroupDetailsWithPhotoResolverModel.this);
        if (paramAnonymousInt2 == i)
          i = 0;
        locala.b(i);
        AddGroupDetailsWithPhotoResolverModel.b(AddGroupDetailsWithPhotoResolverModel.this, 0);
      }
    }

    public void onGroupRenamed(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
    {
      int i = 1;
      if (AddGroupDetailsWithPhotoResolverModel.a(AddGroupDetailsWithPhotoResolverModel.this) == paramAnonymousInt1)
      {
        a.a locala = AddGroupDetailsWithPhotoResolverModel.b(AddGroupDetailsWithPhotoResolverModel.this);
        if (paramAnonymousInt2 == i)
          i = 0;
        locala.a(i);
        AddGroupDetailsWithPhotoResolverModel.a(AddGroupDetailsWithPhotoResolverModel.this, 0);
      }
    }
  };

  AddGroupDetailsWithPhotoResolverModel(Fragment paramFragment, LoaderManager paramLoaderManager, dagger.a<k> parama, bv parambv, GroupController paramGroupController, PhoneController paramPhoneController)
  {
    this.l = paramFragment;
    this.e = parambv;
    this.g = paramGroupController;
    this.h = new l(this.l.getContext(), paramLoaderManager, parama, this, this);
    this.f = paramPhoneController;
    this.a = c.a(this.l.getActivity());
    Fragment localFragment = this.l;
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(13);
    arrayOfPair[1] = m.a(129);
    this.b = new com.viber.voip.permissions.e(localFragment, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 13:
          AddGroupDetailsWithPhotoResolverModel.a(AddGroupDetailsWithPhotoResolverModel.this, ay.a(AddGroupDetailsWithPhotoResolverModel.d(AddGroupDetailsWithPhotoResolverModel.this), 100));
          return;
        case 129:
        }
        ay.b(AddGroupDetailsWithPhotoResolverModel.d(AddGroupDetailsWithPhotoResolverModel.this), 101);
      }
    };
  }

  private void a(Intent paramIntent, Uri paramUri)
  {
    ay.a locala = ay.a(this.l.getContext(), paramIntent, paramUri);
    Intent localIntent = ay.a(this.l.getActivity(), locala, 720, 720);
    if (localIntent != null)
      this.l.startActivityForResult(localIntent, 102);
  }

  public void a()
  {
    this.a.a(this.b);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int n;
    if (paramInt2 == -1)
      n = 1;
    while (n != 0)
      switch (paramInt1)
      {
      default:
        return;
        n = 0;
        break;
      case 100:
        a(paramIntent, this.i);
        this.i = null;
        return;
      case 101:
        j.a(this.l.getContext(), paramIntent.getData(), "image");
        a(paramIntent, this.i);
        return;
      case 102:
        Uri localUri = Uri.parse(paramIntent.getAction());
        this.d.a(localUri);
        return;
      }
    this.d.a();
  }

  public void a(long paramLong, Uri paramUri)
  {
    this.k = this.f.generateSequence();
    this.d.b(2);
    this.g.a(this.k, paramLong, paramUri);
  }

  public void a(long paramLong, String paramString)
  {
    this.j = this.f.generateSequence();
    this.d.a(2);
    this.g.a(this.j, paramLong, paramString);
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof ModelSaveState))
    {
      ModelSaveState localModelSaveState = (ModelSaveState)paramParcelable;
      this.i = localModelSaveState.tempIconUri;
      this.k = localModelSaveState.updateGroupIconOperationSeq;
      this.j = localModelSaveState.updateGroupNameOperationSeq;
      if (this.k > 0)
      {
        if (!this.g.b(this.k))
          break label103;
        this.d.b(2);
      }
    }
    while (true)
    {
      if (this.j > 0)
      {
        if (!this.g.b(this.j))
          break;
        this.d.a(2);
      }
      return;
      label103: this.d.b(4);
      this.k = 0;
    }
    this.d.a(4);
    this.j = 0;
  }

  public void a(a.a parama)
  {
    this.d = parama;
  }

  public void b()
  {
    this.a.b(this.b);
  }

  public void b(long paramLong)
  {
    this.e.a(this.m);
    this.h.a(paramLong);
    this.h.i();
    this.h.p();
  }

  public void c()
  {
    if (this.e != null)
    {
      this.e.b(this.m);
      this.e = null;
      this.h.q();
      this.h.j();
    }
  }

  public void c(long paramLong)
  {
    this.h.q();
  }

  public void c_(long paramLong)
  {
    this.d.a(paramLong);
  }

  public void d()
  {
    if (this.a.a(n.c))
    {
      this.i = ay.a(this.l, 100);
      return;
    }
    this.a.a(this.l.getActivity(), 13, n.c);
  }

  public void e()
  {
    if (this.a.a(n.m))
    {
      ay.b(this.l, 101);
      return;
    }
    this.a.a(this.l, 129, n.m);
  }

  public Parcelable f()
  {
    if ((this.i != null) || (this.k > 0) || (this.j > 0))
      return new ModelSaveState(this.i, this.k, this.j);
    return null;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.h.e(0);
    if (localConversationItemLoaderEntity != null)
      this.d.a(localConversationItemLoaderEntity);
  }

  public void onLoaderReset(d paramd)
  {
  }

  private static class ModelSaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<ModelSaveState> CREATOR = new Parcelable.Creator()
    {
      public AddGroupDetailsWithPhotoResolverModel.ModelSaveState a(Parcel paramAnonymousParcel)
      {
        return new AddGroupDetailsWithPhotoResolverModel.ModelSaveState(paramAnonymousParcel);
      }

      public AddGroupDetailsWithPhotoResolverModel.ModelSaveState[] a(int paramAnonymousInt)
      {
        return new AddGroupDetailsWithPhotoResolverModel.ModelSaveState[paramAnonymousInt];
      }
    };
    final Uri tempIconUri;
    final int updateGroupIconOperationSeq;
    final int updateGroupNameOperationSeq;

    ModelSaveState(Uri paramUri, int paramInt1, int paramInt2)
    {
      this.tempIconUri = paramUri;
      this.updateGroupIconOperationSeq = paramInt1;
      this.updateGroupNameOperationSeq = paramInt2;
    }

    ModelSaveState(Parcel paramParcel)
    {
      this.tempIconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.updateGroupIconOperationSeq = paramParcel.readInt();
      this.updateGroupNameOperationSeq = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "ModelSaveState{tempIconUri=" + this.tempIconUri + ", updateGroupIconOperationSeq=" + this.updateGroupIconOperationSeq + ", updateGroupNameOperationSeq=" + this.updateGroupNameOperationSeq + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.tempIconUri, paramInt);
      paramParcel.writeInt(this.updateGroupIconOperationSeq);
      paramParcel.writeInt(this.updateGroupNameOperationSeq);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsWithPhotoResolverModel
 * JD-Core Version:    0.6.2
 */