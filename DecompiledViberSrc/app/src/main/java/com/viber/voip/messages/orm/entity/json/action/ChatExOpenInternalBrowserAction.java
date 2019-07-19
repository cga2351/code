package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.util.ViberActionRunner.m;
import com.viber.voip.util.da;

public class ChatExOpenInternalBrowserAction extends Action
{
  public static final Parcelable.Creator<ChatExOpenInternalBrowserAction> CREATOR = new Parcelable.Creator()
  {
    public ChatExOpenInternalBrowserAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ChatExOpenInternalBrowserAction(paramAnonymousParcel);
    }

    public ChatExOpenInternalBrowserAction[] newArray(int paramAnonymousInt)
    {
      return new ChatExOpenInternalBrowserAction[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private final BotReplyRequest mBotReplyRequest;
  private final InternalBrowser mBrowserConfig;
  private final long mConversationId;
  private final int mConversationType;
  private final String mUrl;

  public ChatExOpenInternalBrowserAction(long paramLong, int paramInt, String paramString, InternalBrowser paramInternalBrowser, BotReplyRequest paramBotReplyRequest)
  {
    this.mUrl = paramString;
    this.mConversationId = paramLong;
    this.mConversationType = paramInt;
    this.mBrowserConfig = paramInternalBrowser;
    this.mBotReplyRequest = paramBotReplyRequest;
  }

  ChatExOpenInternalBrowserAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mUrl = paramParcel.readString();
    this.mConversationId = paramParcel.readLong();
    this.mConversationType = paramParcel.readInt();
    this.mBrowserConfig = ((InternalBrowser)paramParcel.readParcelable(InternalBrowser.class.getClassLoader()));
    this.mBotReplyRequest = ((BotReplyRequest)paramParcel.readParcelable(BotReplyRequest.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    if (da.a(this.mUrl))
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
    do
    {
      return;
      ViberActionRunner.m.a(paramContext, Uri.parse(this.mUrl), this.mConversationId, this.mConversationType, this.mBrowserConfig, this.mBotReplyRequest, -1);
    }
    while (paramExecuteListener == null);
    paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
  }

  public ActionType getType()
  {
    return ActionType.OPEN_URL;
  }

  public String toString()
  {
    return "ChatExOpenInternalBrowserAction{mUrl='" + this.mUrl + '\'' + ", mConversationId=" + this.mConversationId + ", mConversationType=" + this.mConversationType + ", mBrowserConfig=" + this.mBrowserConfig + ", mBotReplyRequest=" + this.mBotReplyRequest + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mUrl);
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeInt(this.mConversationType);
    paramParcel.writeParcelable(this.mBrowserConfig, paramInt);
    paramParcel.writeParcelable(this.mBotReplyRequest, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ChatExOpenInternalBrowserAction
 * JD-Core Version:    0.6.2
 */