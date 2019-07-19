package com.viber.voip.messages.extensions.model;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.voip.util.av;

public class ChatExtensionLoaderEntity
  implements Parcelable
{
  public static final Parcelable.Creator<ChatExtensionLoaderEntity> CREATOR = new Parcelable.Creator()
  {
    public ChatExtensionLoaderEntity a(Parcel paramAnonymousParcel)
    {
      return new ChatExtensionLoaderEntity(paramAnonymousParcel);
    }

    public ChatExtensionLoaderEntity[] a(int paramAnonymousInt)
    {
      return new ChatExtensionLoaderEntity[paramAnonymousInt];
    }
  };
  private static final int INDX_CHATEX_FLAGS_KEY = 12;
  private static final int INDX_CHATEX_ICON = 3;
  private static final int INDX_CHATEX_ICON_OLD = 4;
  public static final int INDX_CHATEX_ID = 0;
  private static final int INDX_CHATEX_NAME = 2;
  private static final int INDX_CHATEX_URI = 5;
  private static final int INDX_FEATURED = 10;
  private static final int INDX_FLAGS = 8;
  private static final int INDX_HEADER_TEXT = 6;
  private static final int INDX_LAST_USE_TIME = 9;
  private static final int INDX_ORDER_KEY = 11;
  private static final int INDX_PUBLIC_ACCOUNT_ID = 1;
  private static final int INDX_SEARCH_HINT = 7;
  public static final String[] PROJECTIONS = { "chat_extensions._id", "chat_extensions.public_account_id", "chat_extensions.name", "chat_extensions.icon", "chat_extensions.icon_old", "chat_extensions.uri", "chat_extensions.header_text", "chat_extensions.search_hint", "chat_extensions.flags", "chat_extensions.last_use_time", "chat_extensions.featured_index", "chat_extensions.order_key", "chat_extensions.chat_extension_flags" };
  private int mChatExtensionFlags;
  private int mFeaturedIndex;
  private int mFlags;
  private String mHeaderText;
  private Uri mIcon;
  private Uri mIconOld;
  private long mId;
  private long mLastUseTime;
  private String mName;
  private int mOrderKey;
  private String mPublicAccountId;
  private String mSearchHint;
  private String mUri;

  public ChatExtensionLoaderEntity(Cursor paramCursor)
  {
    this.mId = paramCursor.getLong(0);
    this.mPublicAccountId = paramCursor.getString(1);
    this.mName = paramCursor.getString(2);
    this.mUri = paramCursor.getString(5);
    this.mSearchHint = paramCursor.getString(7);
    String str1 = paramCursor.getString(3);
    if (!TextUtils.isEmpty(str1));
    for (Uri localUri1 = Uri.parse(str1); ; localUri1 = null)
    {
      this.mIcon = localUri1;
      String str2 = paramCursor.getString(4);
      boolean bool = TextUtils.isEmpty(str2);
      Uri localUri2 = null;
      if (!bool)
        localUri2 = Uri.parse(str2);
      this.mIconOld = localUri2;
      this.mHeaderText = paramCursor.getString(6);
      this.mFlags = paramCursor.getInt(8);
      this.mLastUseTime = paramCursor.getLong(9);
      this.mFeaturedIndex = paramCursor.getInt(10);
      this.mOrderKey = paramCursor.getInt(11);
      this.mChatExtensionFlags = paramCursor.getInt(12);
      return;
    }
  }

  ChatExtensionLoaderEntity(Parcel paramParcel)
  {
    this.mId = paramParcel.readLong();
    this.mPublicAccountId = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mUri = paramParcel.readString();
    this.mSearchHint = paramParcel.readString();
    this.mIcon = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mIconOld = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mHeaderText = paramParcel.readString();
    this.mFlags = paramParcel.readInt();
    this.mLastUseTime = paramParcel.readLong();
    this.mFeaturedIndex = paramParcel.readInt();
    this.mOrderKey = paramParcel.readInt();
    this.mChatExtensionFlags = paramParcel.readInt();
  }

  public boolean canAddToRecentsOnTap()
  {
    return av.d(this.mChatExtensionFlags, 4);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getChatExtensionFlags()
  {
    return this.mChatExtensionFlags;
  }

  public int getFeaturedIndex()
  {
    return this.mFeaturedIndex;
  }

  public int getFlags()
  {
    return this.mFlags;
  }

  public String getHeaderText()
  {
    return this.mHeaderText;
  }

  public Uri getIcon()
  {
    return this.mIcon;
  }

  public Uri getIconOld()
  {
    return this.mIconOld;
  }

  public long getId()
  {
    return this.mId;
  }

  public long getLastUseTime()
  {
    return this.mLastUseTime;
  }

  public String getName()
  {
    return this.mName;
  }

  public int getOrderKey()
  {
    return this.mOrderKey;
  }

  public String getPublicAccountId()
  {
    return this.mPublicAccountId;
  }

  public String getSearchHint()
  {
    return this.mSearchHint;
  }

  public String getUri()
  {
    return this.mUri;
  }

  public boolean isFeatured()
  {
    return this.mFeaturedIndex != 2147483647;
  }

  public boolean isInputSupported()
  {
    return !av.d(this.mChatExtensionFlags, 2);
  }

  public boolean isSearchSupported()
  {
    return !av.d(this.mChatExtensionFlags, 1);
  }

  public String toString()
  {
    return "ChatExtensionLoaderEntity{mId=" + this.mId + ", mPublicAccountId='" + this.mPublicAccountId + '\'' + ", mName='" + this.mName + '\'' + ", mUri='" + this.mUri + '\'' + ", mSearchHint='" + this.mSearchHint + '\'' + ", mIcon='" + this.mIcon + '\'' + ", mIconOld='" + this.mIconOld + '\'' + ", mHeaderText='" + this.mHeaderText + '\'' + ", mFlags=" + this.mFlags + ", mChatExtensionFlags=" + this.mChatExtensionFlags + ", mLastUseTime=" + this.mLastUseTime + ", mFeaturedIndex=" + this.mFeaturedIndex + ", mOrderKey=" + this.mOrderKey + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mId);
    paramParcel.writeString(this.mPublicAccountId);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mUri);
    paramParcel.writeString(this.mSearchHint);
    paramParcel.writeParcelable(this.mIcon, paramInt);
    paramParcel.writeParcelable(this.mIconOld, paramInt);
    paramParcel.writeString(this.mHeaderText);
    paramParcel.writeInt(this.mFlags);
    paramParcel.writeLong(this.mLastUseTime);
    paramParcel.writeInt(this.mFeaturedIndex);
    paramParcel.writeInt(this.mOrderKey);
    paramParcel.writeInt(this.mChatExtensionFlags);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity
 * JD-Core Version:    0.6.2
 */