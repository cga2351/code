package com.viber.voip.market;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.publicaccount.entity.PublicAccount;
import org.json.JSONException;
import org.json.JSONObject;

public class MarketPublicGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MarketPublicGroupInfo> CREATOR = new Parcelable.Creator()
  {
    public MarketPublicGroupInfo a(Parcel paramAnonymousParcel)
    {
      return new MarketPublicGroupInfo(paramAnonymousParcel);
    }

    public MarketPublicGroupInfo[] a(int paramAnonymousInt)
    {
      return new MarketPublicGroupInfo[paramAnonymousInt];
    }
  };
  public final long groupId;
  public String groupName;
  public final String groupUri;
  public String invitationNumber;
  public long invitationToken;
  public final int lastMessageId;
  public final int revision;

  public MarketPublicGroupInfo(Parcel paramParcel)
  {
    this.groupId = paramParcel.readLong();
    this.lastMessageId = paramParcel.readInt();
    this.revision = paramParcel.readInt();
    this.groupUri = paramParcel.readString();
  }

  public MarketPublicGroupInfo(PublicGroupConversationData paramPublicGroupConversationData)
  {
    this.groupId = paramPublicGroupConversationData.groupId;
    this.groupName = paramPublicGroupConversationData.groupName;
    this.invitationToken = paramPublicGroupConversationData.invitationToken;
    this.invitationNumber = paramPublicGroupConversationData.invitationNumber;
    this.lastMessageId = 0;
    String str;
    if (paramPublicGroupConversationData.publicGroupInfo != null)
    {
      str = paramPublicGroupConversationData.publicGroupInfo.getGroupUri();
      this.groupUri = str;
      if (paramPublicGroupConversationData.publicGroupInfo == null)
        break label87;
    }
    label87: for (int i = paramPublicGroupConversationData.publicGroupInfo.getRevision(); ; i = 0)
    {
      this.revision = i;
      return;
      str = null;
      break;
    }
  }

  public MarketPublicGroupInfo(String paramString1, String paramString2)
    throws JSONException
  {
    this.groupId = Long.parseLong(paramString1, 10);
    JSONObject localJSONObject = new JSONObject(paramString2);
    this.lastMessageId = Integer.parseInt(localJSONObject.getString("last_message_id"), 10);
    this.revision = localJSONObject.getInt("revision");
    if (localJSONObject.has("uri"));
    for (String str = localJSONObject.getString("uri"); ; str = null)
    {
      this.groupUri = str;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "MarketPublicGroupInfo [groupId=" + this.groupId + ", lastMessageId=" + this.lastMessageId + ", revision=" + this.revision + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.groupId);
    paramParcel.writeInt(this.lastMessageId);
    paramParcel.writeInt(this.revision);
    paramParcel.writeString(this.groupUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.MarketPublicGroupInfo
 * JD-Core Version:    0.6.2
 */