package com.viber.voip.messages.extensions.ui.details;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;

public class ChatExtensionDetailsData
  implements Parcelable
{
  public static final Parcelable.Creator<ChatExtensionDetailsData> CREATOR = new Parcelable.Creator()
  {
    public ChatExtensionDetailsData a(Parcel paramAnonymousParcel)
    {
      return new ChatExtensionDetailsData(paramAnonymousParcel);
    }

    public ChatExtensionDetailsData[] a(int paramAnonymousInt)
    {
      return new ChatExtensionDetailsData[paramAnonymousInt];
    }
  };
  final ChatExtensionLoaderEntity chatExtension;
  final ConversationItemLoaderEntity conversation;
  final String entryPoint;
  final boolean resetCache;
  final String searchQuery;
  final boolean silentQuery;

  ChatExtensionDetailsData(Parcel paramParcel)
  {
    this.searchQuery = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.silentQuery = bool2;
      if (paramParcel.readByte() == 0)
        break label86;
    }
    while (true)
    {
      this.resetCache = bool1;
      this.entryPoint = paramParcel.readString();
      this.chatExtension = ((ChatExtensionLoaderEntity)paramParcel.readParcelable(ChatExtensionLoaderEntity.class.getClassLoader()));
      this.conversation = ((ConversationItemLoaderEntity)paramParcel.readParcelable(ConversationItemLoaderEntity.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label86: bool1 = false;
    }
  }

  public ChatExtensionDetailsData(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString2)
  {
    this.chatExtension = paramChatExtensionLoaderEntity;
    this.searchQuery = paramString1;
    this.silentQuery = paramBoolean1;
    this.resetCache = paramBoolean2;
    this.conversation = paramConversationItemLoaderEntity;
    this.entryPoint = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.searchQuery);
    int j;
    if (this.silentQuery)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.resetCache)
        break label73;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.entryPoint);
      paramParcel.writeParcelable(this.chatExtension, paramInt);
      paramParcel.writeParcelable(this.conversation, paramInt);
      return;
      j = 0;
      break;
      label73: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsData
 * JD-Core Version:    0.6.2
 */