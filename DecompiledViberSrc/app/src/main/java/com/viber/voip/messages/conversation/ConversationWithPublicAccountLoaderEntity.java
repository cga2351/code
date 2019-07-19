package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.av;

public class ConversationWithPublicAccountLoaderEntity extends ConversationLoaderEntity
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationWithPublicAccountLoaderEntity> CREATOR = new Parcelable.Creator()
  {
    public ConversationWithPublicAccountLoaderEntity a(Parcel paramAnonymousParcel)
    {
      return new ConversationWithPublicAccountLoaderEntity(paramAnonymousParcel);
    }

    public ConversationWithPublicAccountLoaderEntity[] a(int paramAnonymousInt)
    {
      return new ConversationWithPublicAccountLoaderEntity[paramAnonymousInt];
    }
  };
  public static final String[] PROJECTIONS = new String[2 + ConversationLoaderEntity.PROJECTIONS.length];
  public static final int PUBLIC_GROUP_EXTRA_FLAG_INDX = ConversationLoaderEntity.PROJECTIONS.length;
  public static final int PUBLIC_GROUP_URI_INDX = 1 + PUBLIC_GROUP_EXTRA_FLAG_INDX;
  private int extraFlags;
  private String groupUri;
  private long[] participantInfos;

  static
  {
    PROJECTIONS[PUBLIC_GROUP_EXTRA_FLAG_INDX] = "pg_extra_flags";
    PROJECTIONS[PUBLIC_GROUP_URI_INDX] = "group_uri";
    System.arraycopy(ConversationLoaderEntity.PROJECTIONS, 0, PROJECTIONS, 0, ConversationLoaderEntity.PROJECTIONS.length);
  }

  public ConversationWithPublicAccountLoaderEntity(Cursor paramCursor)
  {
    super(paramCursor);
    init(this, paramCursor);
  }

  public ConversationWithPublicAccountLoaderEntity(Parcel paramParcel)
  {
    super(paramParcel);
    this.extraFlags = paramParcel.readInt();
    this.groupUri = paramParcel.readString();
  }

  public int getBroadcastListParticipantsCount()
  {
    return 0;
  }

  public int getExtraFlags()
  {
    return this.extraFlags;
  }

  public String getGroupUri()
  {
    return this.groupUri;
  }

  public long[] getParticipantInfos()
  {
    return this.participantInfos;
  }

  public int getUnreadEventsCount()
  {
    return getUnreadMessagesCount();
  }

  public boolean hasPublicChat()
  {
    return !av.d(this.publicGroupsFlags, 16384);
  }

  public void init(ConversationWithPublicAccountLoaderEntity paramConversationWithPublicAccountLoaderEntity, Cursor paramCursor)
  {
    paramConversationWithPublicAccountLoaderEntity.extraFlags = paramCursor.getInt(PUBLIC_GROUP_EXTRA_FLAG_INDX);
    paramConversationWithPublicAccountLoaderEntity.groupUri = paramCursor.getString(PUBLIC_GROUP_URI_INDX);
    this.participantInfos = new long[1];
    this.participantInfos[0] = paramCursor.getLong(14);
  }

  public boolean isFavouriteConversation()
  {
    return false;
  }

  public boolean isSnoozedConversation()
  {
    return false;
  }

  public boolean isSystemConversation()
  {
    return false;
  }

  public String toString()
  {
    return super.toString() + "; ConversationWithPublicAccountLoaderEntity{groupUri=" + this.groupUri + ", extraFlags=" + this.extraFlags + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.extraFlags);
    paramParcel.writeString(this.groupUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity
 * JD-Core Version:    0.6.2
 */