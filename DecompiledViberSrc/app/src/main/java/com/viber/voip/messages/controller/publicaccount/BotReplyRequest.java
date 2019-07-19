package com.viber.voip.messages.controller.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;

public class BotReplyRequest
  implements Parcelable
{
  public static final Parcelable.Creator<BotReplyRequest> CREATOR = new Parcelable.Creator()
  {
    public BotReplyRequest a(Parcel paramAnonymousParcel)
    {
      return new BotReplyRequest(paramAnonymousParcel);
    }

    public BotReplyRequest[] a(int paramAnonymousInt)
    {
      return new BotReplyRequest[paramAnonymousInt];
    }
  };
  public final int botReplyActionSource;
  public final boolean canAddToRecentsOnTap;
  public final long conversationId;
  public final int conversationType;
  public final long groupId;
  public final boolean isHiddenChat;
  public final boolean isPublicAccount;
  public final boolean isSystemConversation;
  public final String memberId;
  public final Pair<ReplyButton.a, ReplyButton.b> overriddenReplyType;
  public final String publicAccountId;
  public final ReplyButton replyButton;
  public final BotReplyConfig replyRelatedConfig;
  public final boolean skipActionHandling;
  public final boolean unableSendMessages;

  protected BotReplyRequest(Parcel paramParcel)
  {
    this.publicAccountId = paramParcel.readString();
    this.replyRelatedConfig = ((BotReplyConfig)paramParcel.readParcelable(BotReplyConfig.class.getClassLoader()));
    this.replyButton = ((ReplyButton)paramParcel.readParcelable(ReplyButton.class.getClassLoader()));
    boolean bool2;
    boolean bool3;
    label94: boolean bool4;
    label110: boolean bool5;
    label126: boolean bool6;
    label158: String str1;
    String str2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.canAddToRecentsOnTap = bool2;
      this.groupId = paramParcel.readLong();
      this.conversationId = paramParcel.readLong();
      this.conversationType = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label209;
      bool3 = bool1;
      this.isPublicAccount = bool3;
      if (paramParcel.readByte() == 0)
        break label215;
      bool4 = bool1;
      this.isSystemConversation = bool4;
      if (paramParcel.readByte() == 0)
        break label221;
      bool5 = bool1;
      this.unableSendMessages = bool5;
      this.memberId = paramParcel.readString();
      this.botReplyActionSource = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label227;
      bool6 = bool1;
      this.skipActionHandling = bool6;
      str1 = paramParcel.readString();
      str2 = paramParcel.readString();
      if ((str1 != null) || (str2 != null))
        break label233;
      this.overriddenReplyType = null;
      label191: if (paramParcel.readByte() == 0)
        break label257;
    }
    while (true)
    {
      this.isHiddenChat = bool1;
      return;
      bool2 = false;
      break;
      label209: bool3 = false;
      break label94;
      label215: bool4 = false;
      break label110;
      label221: bool5 = false;
      break label126;
      label227: bool6 = false;
      break label158;
      label233: this.overriddenReplyType = new Pair(ReplyButton.a.fromName(str1), ReplyButton.b.fromName(str2));
      break label191;
      label257: bool1 = false;
    }
  }

  public BotReplyRequest(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4, int paramInt2)
  {
    this(paramString1, paramBotReplyConfig, paramReplyButton, false, paramLong1, paramLong2, paramInt1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramInt2, false, paramBoolean4, null);
  }

  protected BotReplyRequest(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2, boolean paramBoolean5, boolean paramBoolean6, Pair<ReplyButton.a, ReplyButton.b> paramPair)
  {
    this.publicAccountId = paramString1;
    this.replyRelatedConfig = paramBotReplyConfig;
    this.replyButton = paramReplyButton;
    this.canAddToRecentsOnTap = paramBoolean1;
    this.groupId = paramLong1;
    this.conversationId = paramLong2;
    this.conversationType = paramInt1;
    this.isPublicAccount = paramBoolean2;
    this.isSystemConversation = paramBoolean3;
    this.unableSendMessages = paramBoolean4;
    this.memberId = paramString2;
    this.botReplyActionSource = paramInt2;
    this.skipActionHandling = paramBoolean5;
    this.overriddenReplyType = paramPair;
    this.isHiddenChat = paramBoolean6;
  }

  public BotReplyRequest(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, int paramInt2)
  {
    this(paramString1, paramBotReplyConfig, paramReplyButton, paramBoolean1, paramLong1, paramLong2, paramInt1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramInt2, false, paramBoolean5, null);
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "BotReplyRequest{publicAccountId='" + this.publicAccountId + '\'' + ", replyRelatedConfig=" + this.replyRelatedConfig + ", replyButton=" + this.replyButton + ", canAddToRecentsOnTap=" + this.canAddToRecentsOnTap + ", groupId=" + this.groupId + ", conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", isPublicAccount=" + this.isPublicAccount + ", isSystemConversation=" + this.isSystemConversation + ", unableSendMessages=" + this.unableSendMessages + ", memberId='" + this.memberId + '\'' + ", botReplyActionSource=" + this.botReplyActionSource + ", skipActionHandling=" + this.skipActionHandling + ", overriddenReplyType=" + this.overriddenReplyType + ", isHiddenChat=" + this.isHiddenChat + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeString(this.publicAccountId);
    paramParcel.writeParcelable(this.replyRelatedConfig, paramInt);
    paramParcel.writeParcelable(this.replyButton, paramInt);
    byte b2;
    byte b3;
    label78: byte b4;
    label94: byte b5;
    label110: byte b6;
    if (this.canAddToRecentsOnTap)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      paramParcel.writeLong(this.groupId);
      paramParcel.writeLong(this.conversationId);
      paramParcel.writeInt(this.conversationType);
      if (!this.isPublicAccount)
        break label185;
      b3 = b1;
      paramParcel.writeByte(b3);
      if (!this.isSystemConversation)
        break label191;
      b4 = b1;
      paramParcel.writeByte(b4);
      if (!this.unableSendMessages)
        break label197;
      b5 = b1;
      paramParcel.writeByte(b5);
      paramParcel.writeString(this.memberId);
      paramParcel.writeInt(this.botReplyActionSource);
      if (!this.skipActionHandling)
        break label203;
      b6 = b1;
      label142: paramParcel.writeByte((byte)b6);
      if (this.overriddenReplyType != null)
        break label209;
      paramParcel.writeString(null);
      paramParcel.writeString(null);
      label166: if (!this.isHiddenChat)
        break label246;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label185: b3 = 0;
      break label78;
      label191: b4 = 0;
      break label94;
      label197: b5 = 0;
      break label110;
      label203: b6 = 0;
      break label142;
      label209: paramParcel.writeString(((ReplyButton.a)this.overriddenReplyType.first).getTypeName());
      paramParcel.writeString(((ReplyButton.b)this.overriddenReplyType.second).getTypeName());
      break label166;
      label246: b1 = 0;
    }
  }

  public static class a
  {
    private String a;
    private BotReplyConfig b;
    private ReplyButton c;
    private boolean d;
    private long e;
    private long f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private String k;
    private int l;
    private boolean m;
    private boolean n;
    private Pair<ReplyButton.a, ReplyButton.b> o;

    public static a a(BotReplyRequest paramBotReplyRequest)
    {
      a locala = new a();
      locala.a = paramBotReplyRequest.publicAccountId;
      locala.b = paramBotReplyRequest.replyRelatedConfig;
      locala.c = paramBotReplyRequest.replyButton;
      locala.d = paramBotReplyRequest.canAddToRecentsOnTap;
      locala.e = paramBotReplyRequest.groupId;
      locala.f = paramBotReplyRequest.conversationId;
      locala.g = paramBotReplyRequest.conversationType;
      locala.h = paramBotReplyRequest.isPublicAccount;
      locala.i = paramBotReplyRequest.isSystemConversation;
      locala.j = paramBotReplyRequest.unableSendMessages;
      locala.k = paramBotReplyRequest.memberId;
      locala.l = paramBotReplyRequest.botReplyActionSource;
      locala.m = paramBotReplyRequest.skipActionHandling;
      locala.o = paramBotReplyRequest.overriddenReplyType;
      locala.n = paramBotReplyRequest.isHiddenChat;
      return locala;
    }

    public a a(long paramLong)
    {
      this.f = paramLong;
      return this;
    }

    public a a(ReplyButton.a parama, ReplyButton.b paramb)
    {
      this.o = new Pair(parama, paramb);
      return this;
    }

    public a a(String paramString)
    {
      this.k = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }

    public BotReplyRequest a()
    {
      return new BotReplyRequest(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    public a b(long paramLong)
    {
      this.e = paramLong;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.BotReplyRequest
 * JD-Core Version:    0.6.2
 */