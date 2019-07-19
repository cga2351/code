package com.viber.jni.cdr.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.jni.LocationInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.util.da;

public class PublicAccountInteraction extends PublicAccountImpression
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccountInteraction> CREATOR = new Parcelable.Creator()
  {
    public PublicAccountInteraction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PublicAccountInteraction(paramAnonymousParcel);
    }

    public PublicAccountInteraction[] newArray(int paramAnonymousInt)
    {
      return new PublicAccountInteraction[paramAnonymousInt];
    }
  };
  public final String publicAccountCategory;
  public final LocationInfo publicAccountLocationInfo;
  public final String publicAccountSubcategory;

  public PublicAccountInteraction(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, int paramInt1, int paramInt2, String paramString5, boolean paramBoolean, int paramInt3, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramString1, paramString4, paramInt1, paramInt2, paramString5, paramBoolean, paramInt3, paramLong2, paramLong3);
    this.publicAccountCategory = paramString2;
    this.publicAccountSubcategory = paramString3;
    this.publicAccountLocationInfo = paramLocationInfo;
  }

  protected PublicAccountInteraction(Parcel paramParcel)
  {
    super(paramParcel);
    this.publicAccountCategory = paramParcel.readString();
    this.publicAccountSubcategory = paramParcel.readString();
    this.publicAccountLocationInfo = ((LocationInfo)paramParcel.readParcelable(LocationInfo.class.getClassLoader()));
  }

  public static PublicAccountInteraction create(long paramLong, String paramString, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, aa paramaa)
  {
    int i = getPublicAccountInteractionMediaType(paramaa);
    int j = getStickerNumber(i, paramaa);
    int k = getPublicAccountUserRole(paramPublicGroupConversationItemLoaderEntity.getConversationType(), paramPublicGroupConversationItemLoaderEntity.getGroupRole(), paramPublicGroupConversationItemLoaderEntity.hasPublicAccountSubscription());
    String str;
    if (da.a(paramString))
    {
      str = getUrl(paramaa);
      if ((!paramaa.aH()) && (!paramaa.aM()))
        break label122;
    }
    label122: for (boolean bool = true; ; bool = false)
    {
      return new PublicAccountInteraction(paramLong, paramPublicGroupConversationItemLoaderEntity.getPublicAccountId(), paramPublicGroupConversationItemLoaderEntity.getCategoryId(), paramPublicGroupConversationItemLoaderEntity.getSubcategoryId(), paramPublicGroupConversationItemLoaderEntity.getCountryCode(), paramPublicGroupConversationItemLoaderEntity.getLocation(), k, i, str, bool, j, paramaa.y(), paramaa.x());
      str = paramString;
      break;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.publicAccountCategory);
    paramParcel.writeString(this.publicAccountSubcategory);
    paramParcel.writeParcelable(this.publicAccountLocationInfo, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.entity.PublicAccountInteraction
 * JD-Core Version:    0.6.2
 */