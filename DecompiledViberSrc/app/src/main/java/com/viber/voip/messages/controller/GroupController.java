package com.viber.voip.messages.controller;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.upload.ObjectId;
import java.util.Set;

public abstract interface GroupController
{
  public abstract void a(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2);

  public abstract void a(int paramInt1, int paramInt2, PublicAccount paramPublicAccount);

  public abstract void a(int paramInt, long paramLong);

  public abstract void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean);

  public abstract void a(int paramInt, long paramLong, Uri paramUri);

  public abstract void a(int paramInt, long paramLong, String paramString);

  public abstract void a(int paramInt1, long paramLong, String paramString, int paramInt2, int paramInt3, int paramInt4);

  public abstract void a(int paramInt1, long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, int paramInt2);

  public abstract void a(int paramInt1, long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, boolean paramBoolean, int paramInt2);

  public abstract void a(int paramInt, long paramLong1, String paramString1, String paramString2, Uri paramUri, long paramLong2, String paramString3, boolean paramBoolean, ae paramae);

  public abstract void a(int paramInt, long paramLong1, String paramString1, String paramString2, Uri paramUri, String paramString3, long paramLong2, String paramString4, boolean paramBoolean, ae paramae);

  public abstract void a(int paramInt, long paramLong, GroupMember[] paramArrayOfGroupMember);

  public abstract void a(int paramInt1, long paramLong, GroupMember[] paramArrayOfGroupMember, int paramInt2);

  public abstract void a(int paramInt, PublicAccount paramPublicAccount, String[] paramArrayOfString);

  public abstract void a(int paramInt, String paramString, GroupMember[] paramArrayOfGroupMember);

  public abstract void a(int paramInt, String paramString1, GroupMember[] paramArrayOfGroupMember, String paramString2, Uri paramUri);

  public abstract void a(int paramInt, boolean paramBoolean, String paramString, Uri paramUri, GroupMember[] paramArrayOfGroupMember);

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, int paramInt);

  public abstract void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);

  public abstract void a(long paramLong1, int paramInt, long paramLong2);

  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);

  public abstract void a(long paramLong, int paramInt, boolean paramBoolean);

  public abstract void a(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, String paramString);

  public abstract void a(long paramLong, b paramb);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(long paramLong, Set<Long> paramSet1, Set<Long> paramSet2, a parama);

  public abstract void a(long paramLong, GroupMember[] paramArrayOfGroupMember);

  public abstract void a(long paramLong, String[] paramArrayOfString);

  public abstract void a(long paramLong, String[] paramArrayOfString, int paramInt);

  public abstract boolean a(int paramInt);

  public abstract void b(long paramLong);

  public abstract void b(long paramLong, int paramInt, String paramString1, String paramString2);

  public abstract void b(long paramLong, String paramString);

  public abstract boolean b(int paramInt);

  public abstract void c(int paramInt);

  public abstract boolean d(int paramInt);

  public static class GroupBaseDescription
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public GroupController.GroupBaseDescription a(Parcel paramAnonymousParcel)
      {
        return new GroupController.GroupBaseDescription(paramAnonymousParcel);
      }

      public GroupController.GroupBaseDescription[] a(int paramAnonymousInt)
      {
        return new GroupController.GroupBaseDescription[paramAnonymousInt];
      }
    };
    public ObjectId iconId = ObjectId.EMPTY;
    public int modificationType;
    public String name;

    public GroupBaseDescription()
    {
    }

    public GroupBaseDescription(Parcel paramParcel)
    {
      this.iconId = ((ObjectId)paramParcel.readParcelable(ObjectId.class.getClassLoader()));
      this.name = paramParcel.readString();
      this.modificationType = paramParcel.readInt();
    }

    public static GroupBaseDescription fromIcon(ObjectId paramObjectId)
    {
      GroupBaseDescription localGroupBaseDescription = new GroupBaseDescription();
      localGroupBaseDescription.iconId = paramObjectId;
      localGroupBaseDescription.name = "";
      localGroupBaseDescription.modificationType = 1;
      return localGroupBaseDescription;
    }

    public static GroupBaseDescription fromName(String paramString)
    {
      GroupBaseDescription localGroupBaseDescription = new GroupBaseDescription();
      localGroupBaseDescription.iconId = ObjectId.EMPTY;
      localGroupBaseDescription.name = paramString;
      localGroupBaseDescription.modificationType = 2;
      return localGroupBaseDescription;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean isIconModified()
    {
      return (0x1 & this.modificationType) > 0;
    }

    public boolean isNameModified()
    {
      return (0x2 & this.modificationType) > 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.iconId, 0);
      paramParcel.writeString(this.name);
      paramParcel.writeInt(this.modificationType);
    }
  }

  public static class GroupMember
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public GroupController.GroupMember a(Parcel paramAnonymousParcel)
      {
        return new GroupController.GroupMember(paramAnonymousParcel);
      }

      public GroupController.GroupMember[] a(int paramAnonymousInt)
      {
        return new GroupController.GroupMember[paramAnonymousInt];
      }
    };
    public int activeStatus;
    public String mClientName;
    public String mDownloadID;
    public String mEncryptedPhoneNumber;
    public int mGroupRole;
    public String mMID;
    public String mPhoneNumber;
    public String mVID;

    public GroupMember(Parcel paramParcel)
    {
      this.mMID = paramParcel.readString();
      this.mVID = paramParcel.readString();
      this.mPhoneNumber = paramParcel.readString();
      this.mClientName = paramParcel.readString();
      this.mDownloadID = paramParcel.readString();
      this.mEncryptedPhoneNumber = paramParcel.readString();
      this.mGroupRole = paramParcel.readInt();
      this.activeStatus = paramParcel.readInt();
    }

    public GroupMember(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
    {
      this.mMID = paramString1;
      this.mVID = paramString2;
      this.mPhoneNumber = paramString3;
      this.mClientName = paramString4;
      this.mDownloadID = paramString5;
      this.mEncryptedPhoneNumber = paramString6;
      this.mGroupRole = paramInt;
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "GroupMember{mPhoneNumber='" + this.mPhoneNumber + '\'' + ", mMID='" + this.mMID + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mMID);
      paramParcel.writeString(this.mVID);
      paramParcel.writeString(this.mPhoneNumber);
      paramParcel.writeString(this.mClientName);
      paramParcel.writeString(this.mDownloadID);
      paramParcel.writeString(this.mEncryptedPhoneNumber);
      paramParcel.writeInt(this.mGroupRole);
      paramParcel.writeInt(this.activeStatus);
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.GroupController
 * JD-Core Version:    0.6.2
 */