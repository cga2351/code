package com.viber.jni.cdr.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.CdrConst.ShareMediaTypes;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.ObjectId;
import java.util.Iterator;
import java.util.List;

public class PublicAccountImpression
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccountImpression> CREATOR = new Parcelable.Creator()
  {
    public PublicAccountImpression createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PublicAccountImpression(paramAnonymousParcel);
    }

    public PublicAccountImpression[] newArray(int paramAnonymousInt)
    {
      return new PublicAccountImpression[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  public final boolean isGifMessage;
  public final int messageMediaType;
  public final long messageSequence;
  public final int messageStickerNumber;
  public final long messageToken;
  public final String messageUrl;
  public final String publicAccountCountryCode;
  public final String publicAccountId;
  public final int publicAccountUserRole;
  public final long publicChatSessionToken;

  public PublicAccountImpression(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, int paramInt3, long paramLong2, long paramLong3)
  {
    this.publicChatSessionToken = paramLong1;
    this.publicAccountId = paramString1;
    this.publicAccountCountryCode = paramString2;
    this.publicAccountUserRole = paramInt1;
    this.messageMediaType = paramInt2;
    this.messageUrl = paramString3;
    this.isGifMessage = paramBoolean;
    this.messageStickerNumber = paramInt3;
    this.messageToken = paramLong2;
    this.messageSequence = paramLong3;
  }

  protected PublicAccountImpression(Parcel paramParcel)
  {
    this.publicChatSessionToken = paramParcel.readLong();
    this.publicAccountId = paramParcel.readString();
    this.publicAccountCountryCode = paramParcel.readString();
    this.publicAccountUserRole = paramParcel.readInt();
    this.messageMediaType = paramParcel.readInt();
    this.messageUrl = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.isGifMessage = bool;
      this.messageStickerNumber = paramParcel.readInt();
      this.messageToken = paramParcel.readLong();
      this.messageSequence = paramParcel.readLong();
      return;
    }
  }

  public static PublicAccountImpression create(long paramLong, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, aa paramaa)
  {
    int i = getPublicAccountInteractionMediaType(paramaa);
    int j = getStickerNumber(i, paramaa);
    int k = getPublicAccountUserRole(paramPublicGroupConversationItemLoaderEntity.getConversationType(), paramPublicGroupConversationItemLoaderEntity.getGroupRole(), paramPublicGroupConversationItemLoaderEntity.hasPublicAccountSubscription());
    String str = getUrl(paramaa);
    if ((paramaa.aH()) || (paramaa.aM()));
    for (boolean bool = true; ; bool = false)
      return new PublicAccountImpression(paramLong, paramPublicGroupConversationItemLoaderEntity.getPublicAccountId(), paramPublicGroupConversationItemLoaderEntity.getCountryCode(), k, i, str, bool, j, paramaa.y(), paramaa.x());
  }

  protected static int getPublicAccountInteractionMediaType(aa paramaa)
  {
    int i = CdrConst.ShareMediaTypes.fromMediaType(paramaa.q());
    if (i == 4)
    {
      Sticker localSticker = paramaa.bn();
      if ((localSticker != null) && (localSticker.isAnimated()))
        i = 6;
    }
    return i;
  }

  protected static int getPublicAccountUserRole(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 3;
    switch (paramInt2)
    {
    default:
    case 2:
    case 1:
    case 4:
    case 3:
    }
    do
    {
      i = 6;
      do
      {
        return i;
        return 1;
        return 2;
        if (paramInt1 != 2)
          break;
      }
      while (!paramBoolean);
      return 5;
    }
    while (paramInt1 != i);
    if (paramBoolean)
      return 4;
    return 6;
  }

  protected static int getStickerNumber(int paramInt, aa paramaa)
  {
    if ((paramInt == 4) || (paramInt == 6))
    {
      ObjectId localObjectId = paramaa.r();
      if ((localObjectId != null) && (localObjectId != ObjectId.EMPTY))
        return localObjectId.toStickerId();
    }
    return -1;
  }

  protected static String getUrl(aa paramaa)
  {
    boolean bool = paramaa.aL();
    Object localObject1 = null;
    if (!bool);
    FormattedMessage localFormattedMessage;
    do
    {
      return localObject1;
      localFormattedMessage = paramaa.L();
      localObject1 = null;
    }
    while (localFormattedMessage == null);
    Iterator localIterator = localFormattedMessage.getMessage().iterator();
    label35: BaseMessage localBaseMessage;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localBaseMessage = (BaseMessage)localIterator.next();
      if (localBaseMessage.getType() == MessageType.TEXT)
      {
        Action localAction = localBaseMessage.getAction();
        if ((localAction == null) || (localAction.getType() != ActionType.OPEN_URL))
          break label142;
        localObject2 = ((OpenUrlAction)localAction).getUrl();
      }
    }
    while (true)
      if (!da.a((CharSequence)localObject2))
      {
        return localObject2;
        if (localBaseMessage.getType() == MessageType.GIF)
          localObject2 = ((GifMessage)localBaseMessage).getGifUrl();
      }
      else
      {
        localObject1 = localObject2;
        break label35;
        break;
        label142: localObject2 = localObject1;
      }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "PublicAccountImpression{publicChatSessionToken=" + this.publicChatSessionToken + ", publicAccountId='" + this.publicAccountId + '\'' + ", publicAccountCountryCode='" + this.publicAccountCountryCode + '\'' + ", publicAccountUserRole=" + this.publicAccountUserRole + ", messageMediaType=" + this.messageMediaType + ", messageUrl='" + this.messageUrl + '\'' + ", isGifMessage=" + this.isGifMessage + ", messageStickerNumber=" + this.messageStickerNumber + ", messageToken=" + this.messageToken + ", messageSequence=" + this.messageSequence + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.publicChatSessionToken);
    paramParcel.writeString(this.publicAccountId);
    paramParcel.writeString(this.publicAccountCountryCode);
    paramParcel.writeInt(this.publicAccountUserRole);
    paramParcel.writeInt(this.messageMediaType);
    paramParcel.writeString(this.messageUrl);
    if (this.isGifMessage);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.messageStickerNumber);
      paramParcel.writeLong(this.messageToken);
      paramParcel.writeLong(this.messageSequence);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.entity.PublicAccountImpression
 * JD-Core Version:    0.6.2
 */