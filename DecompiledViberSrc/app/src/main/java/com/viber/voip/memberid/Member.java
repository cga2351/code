package com.viber.voip.memberid;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.GroupUserInfo;
import com.viber.jni.im2.CGetUserDetailsV2;
import com.viber.jni.im2.CMoreUserInfo;
import com.viber.jni.im2.ChatUserInfo;
import com.viber.jni.im2.Group2UserInfo;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.x.a.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.j;
import com.viber.voip.util.cd;
import com.viber.voip.util.dx;
import java.io.Serializable;
import java.util.Map;

public class Member
  implements Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<Member> CREATOR = new Parcelable.Creator()
  {
    public Member a(Parcel paramAnonymousParcel)
    {
      return new Member(paramAnonymousParcel, null);
    }

    public Member[] a(int paramAnonymousInt)
    {
      return new Member[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private String mEncryptedMemberId;
  private String mEncryptedPhoneNumber;
  private String mMemberId;
  private String mPhoneNumber;
  private transient Uri mPhotoUri;
  private String mViberId;
  private String mViberName;

  private Member(Parcel paramParcel)
  {
    this.mMemberId = paramParcel.readString();
    this.mPhoneNumber = paramParcel.readString();
    this.mPhotoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mViberName = paramParcel.readString();
    this.mViberId = paramParcel.readString();
    this.mEncryptedPhoneNumber = paramParcel.readString();
    this.mEncryptedMemberId = paramParcel.readString();
  }

  public Member(String paramString)
  {
    this.mMemberId = paramString;
  }

  public Member(String paramString1, String paramString2)
  {
    this(paramString1);
    this.mPhoneNumber = paramString2;
  }

  public Member(String paramString1, String paramString2, Uri paramUri, String paramString3, String paramString4)
  {
    this(paramString1);
    this.mPhoneNumber = paramString2;
    this.mPhotoUri = paramUri;
    this.mViberName = paramString3;
    this.mViberId = paramString4;
  }

  public Member(String paramString1, String paramString2, Uri paramUri, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramUri, paramString3, paramString4);
    this.mEncryptedPhoneNumber = paramString5;
  }

  public Member(String paramString1, String paramString2, Uri paramUri, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramUri, paramString3, paramString4, paramString5);
    this.mEncryptedMemberId = paramString6;
  }

  public static Member from(GroupUserInfo paramGroupUserInfo, int paramInt1, int paramInt2)
  {
    String str3;
    String str4;
    switch (paramInt2)
    {
    default:
      str3 = paramGroupUserInfo.memberId;
      boolean bool = d.c();
      str4 = null;
      if (!bool)
        break;
    case 3:
    }
    while (true)
    {
      return new Member(str3, str4, dx.a(paramGroupUserInfo.downloadID), paramGroupUserInfo.clientName, paramGroupUserInfo.viberId);
      String str2;
      String str1;
      if (com.viber.voip.messages.m.b(paramInt1))
      {
        str2 = paramGroupUserInfo.memberId;
        str1 = null;
      }
      while (true)
      {
        return new Member(paramGroupUserInfo.memberId, null, dx.a(paramGroupUserInfo.downloadID), paramGroupUserInfo.clientName, paramGroupUserInfo.viberId, str1, str2);
        str1 = paramGroupUserInfo.memberId;
        str2 = null;
      }
      str4 = paramGroupUserInfo.memberId;
    }
  }

  public static Member from(CGetUserDetailsV2 paramCGetUserDetailsV2)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    label38: String str1;
    if (cd.c(paramCGetUserDetailsV2.mid))
    {
      String str4 = paramCGetUserDetailsV2.mid;
      localObject3 = str4;
      localObject1 = null;
      localObject2 = str4;
      if (d.c())
      {
        localObject4 = paramCGetUserDetailsV2.mid;
        return new Member((String)localObject4, (String)localObject2, dx.a(paramCGetUserDetailsV2.downloadID), paramCGetUserDetailsV2.name, paramCGetUserDetailsV2.vid, (String)localObject1, (String)localObject3);
      }
    }
    else
    {
      str1 = paramCGetUserDetailsV2.phoneNumber;
      if (!paramCGetUserDetailsV2.moreInfo.data.containsKey(Integer.valueOf(1)))
        break label182;
    }
    label182: for (String str2 = (String)paramCGetUserDetailsV2.moreInfo.data.get(Integer.valueOf(1)); ; str2 = null)
    {
      if (paramCGetUserDetailsV2.moreInfo.data.containsKey(Integer.valueOf(2)))
      {
        String str3 = (String)paramCGetUserDetailsV2.moreInfo.data.get(Integer.valueOf(2));
        localObject2 = str1;
        localObject3 = str3;
        localObject1 = str2;
        break;
        localObject4 = localObject2;
        break label38;
      }
      localObject1 = str2;
      localObject2 = str1;
      localObject3 = null;
      break;
    }
  }

  public static Member from(ChatUserInfo paramChatUserInfo, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    if (com.viber.voip.messages.m.b(paramInt))
    {
      str2 = paramChatUserInfo.encryptedPhoneNumber;
      str1 = null;
      str3 = paramChatUserInfo.mid;
      if (!d.c())
        break label71;
    }
    label71: for (String str4 = paramChatUserInfo.phoneNumber; ; str4 = paramChatUserInfo.mid)
    {
      return new Member(str3, str4, dx.a(paramChatUserInfo.downloadID), paramChatUserInfo.clientName, paramChatUserInfo.vid, str1, str2);
      str1 = paramChatUserInfo.encryptedPhoneNumber;
      str2 = null;
      break;
    }
  }

  public static Member from(Group2UserInfo paramGroup2UserInfo, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new Member(paramGroup2UserInfo.mid, paramGroup2UserInfo.realPhoneNumber, dx.a(paramGroup2UserInfo.downloadID), paramGroup2UserInfo.clientName, null, null, paramGroup2UserInfo.encryptedPhoneNumber);
    case 3:
    }
    return new Member(paramGroup2UserInfo.mid, null, dx.a(paramGroup2UserInfo.downloadID), paramGroup2UserInfo.clientName, null, null, paramGroup2UserInfo.encryptedPhoneNumber);
  }

  public static Member from(ParticipantSelector.Participant paramParticipant)
  {
    if (TextUtils.isEmpty(paramParticipant.getMemberId()))
      throw new IllegalArgumentException("Member can be created only from viber participant");
    return new Member(paramParticipant.getMemberId(), paramParticipant.getNumber(), paramParticipant.getPhotoUri(), paramParticipant.getDisplayName(), null);
  }

  public static Member from(GroupController.GroupMember paramGroupMember)
  {
    String str1 = paramGroupMember.mMID;
    if (d.c());
    for (String str2 = paramGroupMember.mPhoneNumber; ; str2 = paramGroupMember.mMID)
      return new Member(str1, str2, dx.a(paramGroupMember.mDownloadID), paramGroupMember.mClientName, paramGroupMember.mVID, paramGroupMember.mEncryptedPhoneNumber);
  }

  public static Member from(x.a.a parama)
  {
    return new Member(parama.b(), null, null, parama.a(), null, null, parama.b());
  }

  public static Member from(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (!paramConversationItemLoaderEntity.isConversation1on1())
      throw new IllegalArgumentException("Member cannot be created from group conversation");
    return new Member(paramConversationItemLoaderEntity.getParticipantMemberId(), paramConversationItemLoaderEntity.getNumber(), c.c().a(paramConversationItemLoaderEntity.getParticipantMemberId(), 1), paramConversationItemLoaderEntity.getParticipantName(), null);
  }

  public static Member from(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (!paramConversationLoaderEntity.isConversation1on1())
      throw new IllegalArgumentException("Member cannot be created from group conversation");
    b localb = c.c();
    return new Member(paramConversationLoaderEntity.getParticipantMemberId(), paramConversationLoaderEntity.getNumber(), localb.a(paramConversationLoaderEntity.getParticipantMemberId(), 1), paramConversationLoaderEntity.getParticipantName(), null);
  }

  public static Member from(ae paramae)
  {
    return new Member(paramae.h(), paramae.getNumber(), c.c().a(paramae.h(), paramae.e()), paramae.f(), null, paramae.o(), paramae.p());
  }

  public static Member from(com.viber.voip.model.entity.m paramm)
  {
    return new Member(paramm.a(), paramm.getNumber(), paramm.p(), paramm.o(), paramm.c(), paramm.d(), paramm.b());
  }

  public static Member from(j paramj)
  {
    return new Member(paramj.a(), paramj.c(), dx.a(paramj.d()), paramj.e(), paramj.f(), null, paramj.b());
  }

  public static Member fromVln(String paramString)
  {
    return new Member(paramString, paramString);
  }

  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Member localMember;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMember = (Member)paramObject;
    }
    while ((this.mMemberId != null) && (this.mMemberId.equals(localMember.mMemberId)));
    return false;
  }

  public String getEncryptedMemberId()
  {
    return this.mEncryptedMemberId;
  }

  public String getEncryptedPhoneNumber()
  {
    return this.mEncryptedPhoneNumber;
  }

  public String getId()
  {
    return this.mMemberId;
  }

  public String getPhoneNumber()
  {
    return this.mPhoneNumber;
  }

  public Uri getPhotoUri()
  {
    return this.mPhotoUri;
  }

  public String getViberId()
  {
    return this.mViberId;
  }

  public String getViberName()
  {
    return this.mViberName;
  }

  public int hashCode()
  {
    return this.mMemberId.hashCode();
  }

  public String toString()
  {
    return "Member{mMemberId='" + this.mMemberId + '\'' + ", mPhoneNumber='" + this.mPhoneNumber + '\'' + ", mPhotoUri=" + this.mPhotoUri + '\'' + ", mViberName=" + this.mViberName + '\'' + ", mViberId='" + this.mViberId + '\'' + ", mEncryptedPhoneNumber='" + this.mEncryptedPhoneNumber + '\'' + ", mEncryptedMemberId='" + this.mEncryptedMemberId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMemberId);
    paramParcel.writeString(this.mPhoneNumber);
    paramParcel.writeParcelable(this.mPhotoUri, 0);
    paramParcel.writeString(this.mViberName);
    paramParcel.writeString(this.mViberId);
    paramParcel.writeString(this.mEncryptedPhoneNumber);
    paramParcel.writeString(this.mEncryptedMemberId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.memberid.Member
 * JD-Core Version:    0.6.2
 */