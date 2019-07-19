package com.viber.voip;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.d.b;
import com.viber.voip.model.a;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.f;
import com.viber.voip.model.j;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;

public abstract class BaseAddFriendActivity extends ViberFragmentActivity
  implements m.c
{
  private Handler a;
  private volatile boolean b;
  private b c;
  private final Runnable d = new a(this, null);

  private void a(boolean paramBoolean, int paramInt, String paramString, g paramg)
  {
    switch (paramInt)
    {
    case 2:
    case 3:
    case 4:
    default:
    case 0:
    case 1:
    case 5:
    case 6:
    case 7:
    }
    do
    {
      this.a.removeCallbacks(this.d);
      d();
      if (this.c != null)
        this.c.a(paramInt, paramString);
      return;
      a(paramBoolean, paramg);
      return;
    }
    while (!paramBoolean);
    a(paramBoolean, paramg);
  }

  private void a(final boolean paramBoolean, final g paramg)
  {
    if (this.b)
      return;
    this.a.removeCallbacks(this.d);
    this.a.post(new Runnable()
    {
      public void run()
      {
        BaseAddFriendActivity.this.d();
        if (BaseAddFriendActivity.a(BaseAddFriendActivity.this) != null)
          BaseAddFriendActivity.a(BaseAddFriendActivity.this).a(new BaseAddFriendActivity.ContactDetails(paramg), paramBoolean);
      }
    });
  }

  protected void a(String paramString1, String paramString2, boolean paramBoolean, b paramb)
  {
    this.c = paramb;
    this.b = false;
    if (paramBoolean)
      c();
    this.a.postDelayed(this.d, 10000L);
    dr.a local1 = new dr.a()
    {
      public void onCheckStatus(final boolean paramAnonymousBoolean, final int paramAnonymousInt, final ParticipantSelector.Participant paramAnonymousParticipant, final g paramAnonymousg)
      {
        if ((!TextUtils.isEmpty(paramAnonymousParticipant.getMemberId())) && (!TextUtils.isEmpty(paramAnonymousParticipant.getNumber())) && (1 == paramAnonymousInt))
        {
          dr.a(ParticipantSelector.Participant.createUnknown(paramAnonymousParticipant.getNumber()), this);
          return;
        }
        if (BaseAddFriendActivity.b(BaseAddFriendActivity.this))
        {
          BaseAddFriendActivity.c(BaseAddFriendActivity.this).post(new Runnable()
          {
            public void run()
            {
              BaseAddFriendActivity.this.d();
            }
          });
          return;
        }
        BaseAddFriendActivity.c(BaseAddFriendActivity.this).post(new Runnable()
        {
          public void run()
          {
            BaseAddFriendActivity.a(BaseAddFriendActivity.this, paramAnonymousBoolean, paramAnonymousInt, paramAnonymousParticipant.getNumber(), paramAnonymousg);
          }
        });
      }
    };
    dr.a(new ParticipantSelector.Participant(paramString1, paramString2, null, null, false), local1);
  }

  protected final void c()
  {
    ad.c().a(this).a(this);
  }

  protected final void d()
  {
    z.b(getSupportFragmentManager(), DialogCode.D_PROGRESS_OVERLAY);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = av.a(av.e.a);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D_PROGRESS_OVERLAY)) && (-1000 == paramInt))
      this.d.run();
  }

  public static class ContactDetails
    implements Parcelable
  {
    public static final Parcelable.Creator<ContactDetails> CREATOR = new Parcelable.Creator()
    {
      public BaseAddFriendActivity.ContactDetails a(Parcel paramAnonymousParcel)
      {
        return new BaseAddFriendActivity.ContactDetails(paramAnonymousParcel);
      }

      public BaseAddFriendActivity.ContactDetails[] a(int paramAnonymousInt)
      {
        return new BaseAddFriendActivity.ContactDetails[paramAnonymousInt];
      }
    };
    private final long mContactId;
    private final String mDisplayName;
    private final boolean mIsViber;
    private final boolean mIsViberPhoto;
    private final String mLookupKey;
    private final Uri mLookupUri;
    private final String mMemberId;
    private final long mNativeId;
    private final String mPhoneNumber;
    private final Uri mPhotoUri;

    ContactDetails(Parcel paramParcel)
    {
      this.mNativeId = paramParcel.readLong();
      this.mContactId = paramParcel.readLong();
      this.mDisplayName = paramParcel.readString();
      this.mLookupKey = paramParcel.readString();
      boolean bool2;
      if (paramParcel.readInt() != 0)
      {
        bool2 = bool1;
        this.mIsViberPhoto = bool2;
        ClassLoader localClassLoader = ContactDetails.class.getClassLoader();
        this.mPhotoUri = ((Uri)paramParcel.readParcelable(localClassLoader));
        this.mLookupUri = ((Uri)paramParcel.readParcelable(localClassLoader));
        this.mMemberId = paramParcel.readString();
        this.mPhoneNumber = paramParcel.readString();
        if (paramParcel.readInt() == 0)
          break label119;
      }
      while (true)
      {
        this.mIsViber = bool1;
        return;
        bool2 = false;
        break;
        label119: bool1 = false;
      }
    }

    ContactDetails(a parama)
    {
      this.mNativeId = parama.j();
      this.mContactId = parama.getId();
      this.mDisplayName = parama.k();
      this.mLookupKey = parama.q();
      this.mLookupUri = ContactsContract.Contacts.getLookupUri(this.mNativeId, this.mLookupKey);
      this.mPhotoUri = parama.o();
      String str1;
      String str2;
      if (parama.p())
      {
        str1 = parama.n().c();
        this.mPhoneNumber = str1;
        if (!parama.p())
          break label179;
        str2 = parama.n().a();
        label116: this.mMemberId = str2;
        if ((this.mPhotoUri == null) || (!this.mPhotoUri.equals(parama.g())))
          break label184;
      }
      label179: label184: for (boolean bool = true; ; bool = false)
      {
        this.mIsViberPhoto = bool;
        this.mIsViber = parama.p();
        return;
        str1 = parama.w().b();
        break;
        str2 = null;
        break label116;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public long getContactId()
    {
      return this.mContactId;
    }

    public String getDisplayName()
    {
      return this.mDisplayName;
    }

    public String getLookupKey()
    {
      return this.mLookupKey;
    }

    public Uri getLookupUri()
    {
      return this.mLookupUri;
    }

    public String getMemberId()
    {
      return this.mMemberId;
    }

    public long getNativeId()
    {
      return this.mNativeId;
    }

    public String getPhoneNumber()
    {
      return this.mPhoneNumber;
    }

    public Uri getPhotoUri()
    {
      return this.mPhotoUri;
    }

    public boolean isLocalContact()
    {
      return this.mNativeId > 0L;
    }

    public boolean isViber()
    {
      return this.mIsViber;
    }

    public boolean isViberPhoto()
    {
      return this.mIsViberPhoto;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ContactDetails [displayName=").append(this.mDisplayName).append(", lookupUri=").append(this.mLookupUri).append(", photoUri=").append(this.mPhotoUri).append(", isViberPhoto=").append(this.mIsViberPhoto).append(", memberId=").append(this.mMemberId).append(", phoneNumber=").append(this.mPhoneNumber).append("]");
      return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeLong(this.mNativeId);
      paramParcel.writeLong(this.mContactId);
      paramParcel.writeString(this.mDisplayName);
      paramParcel.writeString(this.mLookupKey);
      int j;
      if (this.mIsViberPhoto)
      {
        j = i;
        paramParcel.writeInt(j);
        paramParcel.writeParcelable(this.mPhotoUri, paramInt);
        paramParcel.writeParcelable(this.mLookupUri, paramInt);
        paramParcel.writeString(this.mMemberId);
        paramParcel.writeString(this.mPhoneNumber);
        if (!this.mIsViber)
          break label103;
      }
      while (true)
      {
        paramParcel.writeInt(i);
        return;
        j = 0;
        break;
        label103: i = 0;
      }
    }
  }

  private static class a extends b<BaseAddFriendActivity>
  {
    private a(BaseAddFriendActivity paramBaseAddFriendActivity)
    {
      super();
    }

    public void a(BaseAddFriendActivity paramBaseAddFriendActivity)
    {
      BaseAddFriendActivity.a(paramBaseAddFriendActivity, true);
      if (BaseAddFriendActivity.a(paramBaseAddFriendActivity) != null)
        BaseAddFriendActivity.a(paramBaseAddFriendActivity).b();
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);

    public abstract void a(BaseAddFriendActivity.ContactDetails paramContactDetails, boolean paramBoolean);

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.BaseAddFriendActivity
 * JD-Core Version:    0.6.2
 */