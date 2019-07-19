package com.viber.voip.storage.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.d.f;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;

public class ConversationWithMediaSizesEntity extends RegularConversationLoaderEntity
{
  public static final Parcelable.Creator<ConversationWithMediaSizesEntity> CREATOR = new Parcelable.Creator()
  {
    public ConversationWithMediaSizesEntity a(Parcel paramAnonymousParcel)
    {
      return new ConversationWithMediaSizesEntity(paramAnonymousParcel);
    }

    public ConversationWithMediaSizesEntity[] a(int paramAnonymousInt)
    {
      return new ConversationWithMediaSizesEntity[paramAnonymousInt];
    }
  };
  private static final int MEDIA_SIZES_INDX;
  public static final String[] PROJECTIONS = new String[1 + RegularConversationLoaderEntity.PROJECTIONS.length];
  private ConversationMediaSize mMediaSize;

  static
  {
    MEDIA_SIZES_INDX = RegularConversationLoaderEntity.PROJECTIONS.length;
    System.arraycopy(RegularConversationLoaderEntity.PROJECTIONS, 0, PROJECTIONS, 0, RegularConversationLoaderEntity.PROJECTIONS.length);
    PROJECTIONS[MEDIA_SIZES_INDX] = "ifnull(conversation_auxiliary.media_size, \"\")";
  }

  public ConversationWithMediaSizesEntity(Cursor paramCursor, f paramf)
  {
    super(paramCursor);
    init(paramCursor, paramf);
  }

  public ConversationWithMediaSizesEntity(Cursor paramCursor, f paramf, boolean paramBoolean)
  {
    super(paramCursor, paramBoolean);
    init(paramCursor, paramf);
  }

  public ConversationWithMediaSizesEntity(Parcel paramParcel)
  {
    super(paramParcel);
    this.mMediaSize = ((ConversationMediaSize)paramParcel.readParcelable(ConversationMediaSize.class.getClassLoader()));
  }

  public ConversationWithMediaSizesEntity(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity, ConversationMediaSize paramConversationMediaSize)
  {
    super(paramConversationWithMediaSizesEntity);
    this.mMediaSize = paramConversationMediaSize;
  }

  private void init(Cursor paramCursor, f paramf)
  {
    this.mMediaSize = ConversationMediaSize.createFromJson(paramf, paramCursor.getString(MEDIA_SIZES_INDX));
  }

  public int describeContents()
  {
    return 0;
  }

  public ConversationMediaSize getMediaSize()
  {
    return this.mMediaSize;
  }

  public long getSummaryMediaSizeBytes()
  {
    return Math.max(0L, this.mMediaSize.getSummarySizeBytes());
  }

  public boolean hasCalculatedSummaryMediaSize()
  {
    return this.mMediaSize.hasSummarySize();
  }

  public String toString()
  {
    return super.toString() + ", ConversationWithMediaSizesEntity={mMediaSize=" + this.mMediaSize + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mMediaSize, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.model.ConversationWithMediaSizesEntity
 * JD-Core Version:    0.6.2
 */