package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.json.action.Action;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormattedMessage
  implements Parcelable
{
  public static final Parcelable.Creator<FormattedMessage> CREATOR = new Parcelable.Creator()
  {
    public FormattedMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FormattedMessage(paramAnonymousParcel);
    }

    public FormattedMessage[] newArray(int paramAnonymousInt)
    {
      return new FormattedMessage[paramAnonymousInt];
    }
  };
  public static final String KEY_MESSAGE_TYPE = "Type";
  private static final Logger L = ViberEnv.getLogger();
  private static final long WARN_TIME_THRESHOLD_MS = 10L;
  private MessageCommand mCommand;
  private boolean mHasFirstMedia;
  private boolean mHasLastMedia;
  private MessageInfo mInfo;
  private JSONArray mJsonArray;
  private String mJsonString;
  private final LongSparseArray<MediaMessage> mMediaMessages = new LongSparseArray();
  private final List<BaseMessage> mMessage = new ArrayList();
  private final LongSparseArray<TextMessage> mTextMessages = new LongSparseArray();

  FormattedMessage(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    ClassLoader localClassLoader = FormattedMessage.class.getClassLoader();
    for (int j = 0; j < i; j++)
      this.mMessage.add((BaseMessage)paramParcel.readParcelable(localClassLoader));
    this.mInfo = ((MessageInfo)paramParcel.readParcelable(localClassLoader));
    this.mCommand = ((MessageCommand)paramParcel.readParcelable(localClassLoader));
    this.mJsonString = paramParcel.readString();
    try
    {
      this.mJsonArray = new JSONArray(this.mJsonString);
      if (paramParcel.readInt() != 0)
      {
        bool2 = bool1;
        this.mHasFirstMedia = bool2;
        if (paramParcel.readInt() == 0)
          break label179;
        this.mHasLastMedia = bool1;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        this.mJsonString = null;
        continue;
        boolean bool2 = false;
        continue;
        label179: bool1 = false;
      }
    }
  }

  public FormattedMessage(String paramString)
    throws JSONException
  {
    if (paramString == null)
      paramString = "";
    init(new JSONArray(paramString));
    this.mJsonString = paramString;
  }

  public FormattedMessage(JSONArray paramJSONArray)
    throws JSONException
  {
    init(paramJSONArray);
  }

  private JSONArray getJsonData()
  {
    return this.mJsonArray;
  }

  private String getJsonString()
  {
    if ((this.mJsonString == null) && (this.mJsonArray != null))
      this.mJsonString = this.mJsonArray.toString();
    return this.mJsonString;
  }

  private String getTextForIndex(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      return paramString;
    if ((paramInt >= 0) && (paramInt < this.mMessage.size()))
    {
      if ((this.mMessage.get(paramInt) instanceof TextMessage))
        return ((TextMessage)this.mMessage.get(paramInt)).getText();
      return "";
    }
    return "";
  }

  private void init(JSONArray paramJSONArray)
    throws JSONException
  {
    this.mJsonArray = paramJSONArray;
    int i = paramJSONArray.length();
    int j = 0;
    if (j < i)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
      String str2 = localJSONObject.getString("Type");
      if (TextUtils.isEmpty(str2));
      while (true)
      {
        j++;
        break;
        MessageType localMessageType = MessageType.toEnum(str2);
        if (localMessageType != null)
          switch (2.$SwitchMap$com$viber$voip$messages$orm$entity$json$MessageType[localMessageType.ordinal()])
          {
          default:
            break;
          case 1:
            TextMessage localTextMessage = new TextMessage(j, localJSONObject);
            this.mTextMessages.append(this.mMessage.size(), localTextMessage);
            this.mMessage.add(new TextMessage(j, localJSONObject));
            break;
          case 2:
            ImageMessage localImageMessage = new ImageMessage(j, localJSONObject);
            this.mMediaMessages.append(this.mMessage.size(), localImageMessage);
            this.mMessage.add(localImageMessage);
            break;
          case 3:
            VideoMessage localVideoMessage = new VideoMessage(j, localJSONObject);
            this.mMediaMessages.append(this.mMessage.size(), localVideoMessage);
            this.mMessage.add(localVideoMessage);
            break;
          case 4:
            GifMessage localGifMessage = new GifMessage(j, localJSONObject);
            this.mMediaMessages.append(this.mMessage.size(), localGifMessage);
            this.mMessage.add(localGifMessage);
            break;
          case 5:
            this.mMessage.add(new ButtonMessage(j, localJSONObject));
            break;
          case 6:
            this.mMessage.add(new StickerMessage(j, localJSONObject));
            break;
          case 7:
            this.mMessage.add(new SeparatorMessage(j, localJSONObject));
            break;
          case 8:
            this.mInfo = new MessageInfo(localJSONObject);
            break;
          case 9:
            this.mCommand = new MessageCommand(localJSONObject);
          }
      }
    }
    if (this.mInfo != null)
    {
      String str1 = this.mInfo.getCdrAction();
      for (int k = 0; k < this.mMessage.size(); k++)
        ((BaseMessage)this.mMessage.get(k)).setCdrAction(str1);
    }
    if (!this.mMessage.isEmpty())
    {
      this.mHasFirstMedia = isMediaType(((BaseMessage)this.mMessage.get(0)).getType());
      this.mHasLastMedia = isMediaType(((BaseMessage)this.mMessage.get(-1 + this.mMessage.size())).getType());
    }
  }

  private boolean isMediaType(MessageType paramMessageType)
  {
    return (paramMessageType == MessageType.IMAGE) || (paramMessageType == MessageType.GIF) || (paramMessageType == MessageType.VIDEO);
  }

  public boolean canDoAction(ActionType paramActionType)
  {
    return (this.mCommand != null) && (this.mCommand.canDoAction(paramActionType));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FormattedMessage localFormattedMessage;
    do
    {
      return true;
      if (!(paramObject instanceof FormattedMessage))
        return false;
      localFormattedMessage = (FormattedMessage)paramObject;
      String str = getJsonString();
      if (str != null)
        return str.equals(localFormattedMessage.getJsonString());
    }
    while (localFormattedMessage.getJsonString() == null);
    return false;
  }

  public <T extends Action> T getAction(ActionType paramActionType)
  {
    if (this.mCommand != null)
      return this.mCommand.getAction(paramActionType);
    return null;
  }

  public MessageCommand getCommand()
  {
    return this.mCommand;
  }

  public MessageInfo getInfo()
  {
    return this.mInfo;
  }

  public LongSparseArray<MediaMessage> getMediaMessages()
  {
    return this.mMediaMessages;
  }

  public List<BaseMessage> getMessage()
  {
    return this.mMessage;
  }

  public String getPreviewText()
  {
    if (this.mInfo != null)
      return getTextForIndex(this.mInfo.getPreviewTextIndex(), this.mInfo.getPreviewText());
    return "";
  }

  public String getPushText()
  {
    if (this.mInfo != null)
      return getTextForIndex(this.mInfo.getPushTextIndex(), this.mInfo.getPushText());
    return "";
  }

  public LongSparseArray<TextMessage> getTextMessages()
  {
    return this.mTextMessages;
  }

  public boolean hasFirstMedia()
  {
    return this.mHasFirstMedia;
  }

  public boolean hasLastMedia()
  {
    return this.mHasLastMedia;
  }

  public boolean hasMedia()
  {
    return this.mMediaMessages.size() > 0;
  }

  public boolean hasText()
  {
    return this.mTextMessages.size() > 0;
  }

  public int hashCode()
  {
    String str = getJsonString();
    if (str != null)
      return 31 * str.hashCode();
    return 0;
  }

  public boolean isInviteFromPublicAccount()
  {
    return (this.mInfo != null) && ("paInvite".equals(this.mInfo.getFmType()));
  }

  public final MutableFormattedMessageWrapper mutate()
  {
    return new MutableFormattedMessageWrapper(this, null);
  }

  public String toString()
  {
    return "FormattedMessage [message=" + this.mMessage + ", info=" + this.mInfo + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mMessage.size());
    int j = this.mMessage.size();
    for (int k = 0; k < j; k++)
      paramParcel.writeParcelable((BaseMessage)this.mMessage.get(k), paramInt);
    paramParcel.writeParcelable(this.mInfo, paramInt);
    paramParcel.writeParcelable(this.mCommand, paramInt);
    paramParcel.writeString(getJsonString());
    int m;
    if (this.mHasFirstMedia)
    {
      m = i;
      paramParcel.writeInt(m);
      if (!this.mHasLastMedia)
        break label122;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      m = 0;
      break;
      label122: i = 0;
    }
  }

  public static final class MutableFormattedMessageWrapper
  {
    private final FormattedMessage mFormattedMessage;

    private MutableFormattedMessageWrapper(FormattedMessage paramFormattedMessage)
    {
      this.mFormattedMessage = paramFormattedMessage;
    }

    public JSONArray getJsonData()
    {
      return this.mFormattedMessage.getJsonData();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.FormattedMessage
 * JD-Core Version:    0.6.2
 */