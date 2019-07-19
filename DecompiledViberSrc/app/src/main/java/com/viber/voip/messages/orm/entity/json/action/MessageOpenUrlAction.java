package com.viber.voip.messages.orm.entity.json.action;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.util.links.MessageOpenUrlSpec;
import com.viber.voip.util.links.SimpleOpenUrlSpec;

public class MessageOpenUrlAction extends OpenUrlAction
{
  public static final Parcelable.Creator<MessageOpenUrlAction> CREATOR = new Parcelable.Creator()
  {
    public MessageOpenUrlAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MessageOpenUrlAction(paramAnonymousParcel);
    }

    public MessageOpenUrlAction[] newArray(int paramAnonymousInt)
    {
      return new MessageOpenUrlAction[paramAnonymousInt];
    }
  };
  private long mConversationId;
  private int mConversationType;
  private boolean mIsSecret;

  MessageOpenUrlAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mConversationId = paramParcel.readLong();
    this.mConversationType = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsSecret = bool;
      return;
    }
  }

  private MessageOpenUrlAction(MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    super(paramMessageOpenUrlAction);
    this.mConversationId = paramMessageOpenUrlAction.mConversationId;
    this.mConversationType = paramMessageOpenUrlAction.mConversationType;
    this.mIsSecret = paramMessageOpenUrlAction.mIsSecret;
  }

  private MessageOpenUrlAction(OpenUrlAction paramOpenUrlAction)
  {
    super(paramOpenUrlAction);
  }

  public MessageOpenUrlAction(String paramString)
  {
    super(paramString);
  }

  public static MessageOpenUrlAction from(MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    return new MessageOpenUrlAction(paramMessageOpenUrlAction);
  }

  public static MessageOpenUrlAction from(OpenUrlAction paramOpenUrlAction)
  {
    return new MessageOpenUrlAction(paramOpenUrlAction);
  }

  protected SimpleOpenUrlSpec createUrlSpec()
  {
    return new MessageOpenUrlSpec(this.mUrl, this.mConversationId, this.mConversationType, this.mIsSecret, this.mExternal, true);
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public int getConversationType()
  {
    return this.mConversationType;
  }

  public void setConversationId(long paramLong)
  {
    this.mConversationId = paramLong;
    invalidateUrlSpec();
  }

  public void setConversationType(int paramInt)
  {
    this.mConversationType = paramInt;
    invalidateUrlSpec();
  }

  public void setIsSecret(boolean paramBoolean)
  {
    this.mIsSecret = paramBoolean;
    invalidateUrlSpec();
  }

  public String toString()
  {
    return "MessageOpenUrlAction{mConversationId=" + this.mConversationId + "mConversationType=" + this.mConversationType + ", mIsSecret=" + this.mIsSecret + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeInt(this.mConversationType);
    if (this.mIsSecret);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction
 * JD-Core Version:    0.6.2
 */