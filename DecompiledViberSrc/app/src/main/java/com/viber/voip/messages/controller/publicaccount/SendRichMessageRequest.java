package com.viber.voip.messages.controller.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendRichMessageRequest
  implements Parcelable
{
  public static final Parcelable.Creator<SendRichMessageRequest> CREATOR = new Parcelable.Creator()
  {
    public SendRichMessageRequest a(Parcel paramAnonymousParcel)
    {
      return new SendRichMessageRequest(paramAnonymousParcel);
    }

    public SendRichMessageRequest[] a(int paramAnonymousInt)
    {
      return new SendRichMessageRequest[paramAnonymousInt];
    }
  };
  private final String actionReplyData;
  private final BotReplyRequest botReplyRequest;
  private final boolean isOriginalUrl;
  private final String title;
  private final String url;

  protected SendRichMessageRequest(Parcel paramParcel)
  {
    this.botReplyRequest = ((BotReplyRequest)paramParcel.readParcelable(BotReplyRequest.class.getClassLoader()));
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.actionReplyData = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.isOriginalUrl = bool;
      return;
    }
  }

  public SendRichMessageRequest(BotReplyRequest paramBotReplyRequest, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.botReplyRequest = paramBotReplyRequest;
    this.url = paramString1;
    this.title = paramString2;
    this.actionReplyData = paramString3;
    this.isOriginalUrl = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getActionReplyData()
  {
    return this.actionReplyData;
  }

  public BotReplyRequest getBotReplyRequest()
  {
    return this.botReplyRequest;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getUrl()
  {
    return this.url;
  }

  public boolean isOriginalUrl()
  {
    return this.isOriginalUrl;
  }

  public String toString()
  {
    return "SendRichMessageRequest{url='" + this.url + '\'' + ", title='" + this.title + '\'' + ", actionReplyData='" + this.actionReplyData + '\'' + ", isOriginalUrl=" + this.isOriginalUrl + ", botReplyRequest=" + this.botReplyRequest + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.botReplyRequest, paramInt);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.actionReplyData);
    if (this.isOriginalUrl);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }

  public static class a
  {
    private BotReplyRequest a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public static a a(SendRichMessageRequest paramSendRichMessageRequest)
    {
      a locala = new a();
      locala.a = paramSendRichMessageRequest.getBotReplyRequest();
      locala.b = paramSendRichMessageRequest.getUrl();
      locala.c = paramSendRichMessageRequest.getTitle();
      locala.d = paramSendRichMessageRequest.getActionReplyData();
      locala.e = paramSendRichMessageRequest.isOriginalUrl();
      return locala;
    }

    public a a(BotReplyRequest paramBotReplyRequest)
    {
      this.a = paramBotReplyRequest;
      return this;
    }

    public SendRichMessageRequest a()
    {
      return new SendRichMessageRequest(this.a, this.b, this.c, this.d, this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.SendRichMessageRequest
 * JD-Core Version:    0.6.2
 */