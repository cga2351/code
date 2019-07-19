package com.viber.voip.messages.controller.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.google.d.f;
import com.google.d.l;
import com.google.d.o;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.FavoritesMetadata;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;
import dagger.a;
import java.util.concurrent.atomic.AtomicLong;

public abstract interface BotFavoriteLinksCommunicator
{
  public static class SaveLinkActionMessage
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveLinkActionMessage> CREATOR = new Parcelable.Creator()
    {
      public BotFavoriteLinksCommunicator.SaveLinkActionMessage a(Parcel paramAnonymousParcel)
      {
        return new BotFavoriteLinksCommunicator.SaveLinkActionMessage(paramAnonymousParcel);
      }

      public BotFavoriteLinksCommunicator.SaveLinkActionMessage[] a(int paramAnonymousInt)
      {
        return new BotFavoriteLinksCommunicator.SaveLinkActionMessage[paramAnonymousInt];
      }
    };
    private static final String FORCE = "force";
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    private static final String RICH_MEDIA = "richMedia";
    private transient String mAnalyticsChatType;
    private transient String mAnalyticsOrigin;

    @c(a="domain")
    private String mDomainUrl;

    @c(a="force")
    private boolean mForce;
    private transient long mId;
    private transient boolean mIsFromTooltip;
    private transient boolean mIsIntermediateMetadata;
    private transient boolean mIsSilent;
    private transient String mMediaToken;

    @c(a="type")
    private String mMetadataType;
    private transient String mPublicAccountId;
    private transient BotReplyConfig mRichMedia;
    private transient int mSource;

    @c(a="height")
    private Integer mThumbnailHeight;

    @c(a="thumbnail")
    private String mThumbnailUrl;

    @c(a="width")
    private Integer mThumbnailWidth;

    @c(a="title")
    private String mTitle;

    @c(a="url")
    private String mUrl;

    public SaveLinkActionMessage()
    {
    }

    protected SaveLinkActionMessage(Parcel paramParcel)
    {
      this.mMetadataType = paramParcel.readString();
      this.mUrl = paramParcel.readString();
      this.mTitle = paramParcel.readString();
      this.mThumbnailUrl = paramParcel.readString();
      this.mDomainUrl = paramParcel.readString();
      boolean bool2;
      boolean bool3;
      label86: Integer localInteger1;
      label110: boolean bool4;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.mForce = bool2;
        this.mPublicAccountId = paramParcel.readString();
        this.mSource = paramParcel.readInt();
        if (paramParcel.readByte() == 0)
          break label209;
        bool3 = bool1;
        this.mIsFromTooltip = bool3;
        int i = paramParcel.readInt();
        if (i <= 0)
          break label215;
        localInteger1 = Integer.valueOf(i);
        this.mThumbnailWidth = localInteger1;
        int j = paramParcel.readInt();
        Integer localInteger2 = null;
        if (j > 0)
          localInteger2 = Integer.valueOf(j);
        this.mThumbnailHeight = localInteger2;
        if (paramParcel.readByte() == 0)
          break label221;
        bool4 = bool1;
        label153: this.mIsIntermediateMetadata = bool4;
        if (paramParcel.readByte() == 0)
          break label227;
      }
      while (true)
      {
        this.mIsSilent = bool1;
        this.mMediaToken = paramParcel.readString();
        this.mAnalyticsOrigin = paramParcel.readString();
        this.mAnalyticsChatType = paramParcel.readString();
        this.mId = paramParcel.readLong();
        return;
        bool2 = false;
        break;
        label209: bool3 = false;
        break label86;
        label215: localInteger1 = null;
        break label110;
        label221: bool4 = false;
        break label153;
        label227: bool1 = false;
      }
    }

    public static a builder()
    {
      return new a(null);
    }

    public a buildUpon()
    {
      return new a(this, null);
    }

    public int describeContents()
    {
      return 0;
    }

    public String getAnalyticsChatType()
    {
      return this.mAnalyticsChatType;
    }

    public String getAnalyticsOrigin()
    {
      return this.mAnalyticsOrigin;
    }

    public String getDomainUrl()
    {
      return this.mDomainUrl;
    }

    public long getId()
    {
      return this.mId;
    }

    public String getMediaToken()
    {
      return this.mMediaToken;
    }

    public String getPublicAccountId()
    {
      return this.mPublicAccountId;
    }

    public int getSource()
    {
      return this.mSource;
    }

    public String getThumbnailUrl()
    {
      return this.mThumbnailUrl;
    }

    public String getTitle()
    {
      return this.mTitle;
    }

    public String getUrl()
    {
      return this.mUrl;
    }

    public boolean hasEnoughMetadata()
    {
      if (this.mRichMedia == null)
        if ((!this.mIsIntermediateMetadata) || ((!da.a(this.mTitle)) && (!da.a(this.mThumbnailUrl))))
          break label42;
      label42: for (int i = 1; i == 0; i = 0)
        return true;
      return false;
    }

    public boolean isFromTooltip()
    {
      return this.mIsFromTooltip;
    }

    public boolean isSilent()
    {
      return this.mIsSilent;
    }

    public boolean isValid()
    {
      boolean bool = true;
      if (da.a(this.mPublicAccountId))
        bool = false;
      do
      {
        do
        {
          return bool;
          if (this.mRichMedia != null)
            break;
        }
        while ((!da.a(this.mMetadataType)) && (!da.a(this.mUrl)));
        return false;
      }
      while (this.mRichMedia.getFavoritesMetadata().getMetadata() != null);
      return false;
    }

    public String toJson(a<f> parama)
    {
      if (this.mRichMedia == null)
        return ((f)parama.get()).b(this);
      o localo1 = ((l)((f)parama.get()).a(this.mRichMedia.getFavoritesMetadata().getMetadata(), l.class)).k();
      o localo2 = ((f)parama.get()).a(this.mRichMedia).k();
      localo2.a("FavoritesMetadata");
      localo1.a("richMedia", localo2);
      localo1.a("force", Boolean.valueOf(this.mForce));
      return ((f)parama.get()).a(localo1);
    }

    public String toString()
    {
      return "SaveLinkActionMessage{mMetadataType='" + this.mMetadataType + '\'' + ", mUrl='" + this.mUrl + '\'' + ", mTitle='" + this.mTitle + '\'' + ", mThumbnailUrl='" + this.mThumbnailUrl + '\'' + ", mDomainUrl='" + this.mDomainUrl + '\'' + ", mForce=" + this.mForce + ", mThumbnailWidth=" + this.mThumbnailWidth + ", mThumbnailHeight=" + this.mThumbnailHeight + ", mPublicAccountId='" + this.mPublicAccountId + '\'' + ", mSource=" + this.mSource + ", mIsFromTooltip=" + this.mIsFromTooltip + ", mAnalyticsOrigin='" + this.mAnalyticsOrigin + '\'' + ", mAnalyticsChatType='" + this.mAnalyticsChatType + '\'' + ", mIsIntermediateMetadata=" + this.mIsIntermediateMetadata + ", mIsSilent=" + this.mIsSilent + ", mMediaToken='" + this.mMediaToken + '\'' + ", mId=" + this.mId + ", mRichMedia=" + this.mRichMedia + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = -1;
      byte b1 = 1;
      paramParcel.writeString(this.mMetadataType);
      paramParcel.writeString(this.mUrl);
      paramParcel.writeString(this.mTitle);
      paramParcel.writeString(this.mThumbnailUrl);
      paramParcel.writeString(this.mDomainUrl);
      byte b2;
      byte b3;
      label89: int j;
      label112: byte b4;
      if (this.mForce)
      {
        b2 = b1;
        paramParcel.writeByte(b2);
        paramParcel.writeString(this.mPublicAccountId);
        paramParcel.writeInt(this.mSource);
        if (!this.mIsFromTooltip)
          break label207;
        b3 = b1;
        paramParcel.writeByte((byte)b3);
        if (this.mThumbnailWidth == null)
          break label213;
        j = this.mThumbnailWidth.intValue();
        paramParcel.writeInt(j);
        if (this.mThumbnailHeight != null)
          i = this.mThumbnailHeight.intValue();
        paramParcel.writeInt(i);
        if (!this.mIsIntermediateMetadata)
          break label219;
        b4 = b1;
        label149: paramParcel.writeByte(b4);
        if (!this.mIsSilent)
          break label225;
      }
      while (true)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeString(this.mMediaToken);
        paramParcel.writeString(this.mAnalyticsOrigin);
        paramParcel.writeString(this.mAnalyticsChatType);
        paramParcel.writeLong(this.mId);
        return;
        b2 = 0;
        break;
        label207: b3 = 0;
        break label89;
        label213: j = i;
        break label112;
        label219: b4 = 0;
        break label149;
        label225: b1 = 0;
      }
    }

    public static final class a
    {
      private BotFavoriteLinksCommunicator.SaveLinkActionMessage a = new BotFavoriteLinksCommunicator.SaveLinkActionMessage();

      private a()
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$002(this.a, -1L);
        a(false);
        g("link");
        a(0);
        b(false);
        c(false);
        d(false);
        h("");
        f("");
      }

      private a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
      {
        this();
        a(paramSaveLinkActionMessage.mId);
        a(paramSaveLinkActionMessage.mUrl);
        g(paramSaveLinkActionMessage.mMetadataType);
        b(paramSaveLinkActionMessage.mTitle);
        c(paramSaveLinkActionMessage.mThumbnailUrl);
        d(paramSaveLinkActionMessage.mDomainUrl);
        a(paramSaveLinkActionMessage.mForce);
        e(paramSaveLinkActionMessage.mPublicAccountId);
        a(paramSaveLinkActionMessage.mSource);
        b(paramSaveLinkActionMessage.mIsFromTooltip);
        c(paramSaveLinkActionMessage.mIsIntermediateMetadata);
        d(paramSaveLinkActionMessage.mIsSilent);
        h(paramSaveLinkActionMessage.mAnalyticsOrigin);
        f(paramSaveLinkActionMessage.mMediaToken);
        if ((paramSaveLinkActionMessage.mThumbnailWidth != null) && (paramSaveLinkActionMessage.mThumbnailHeight != null))
          a(paramSaveLinkActionMessage.mThumbnailWidth.intValue(), paramSaveLinkActionMessage.mThumbnailHeight.intValue());
      }

      public a a(int paramInt)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$802(this.a, paramInt);
        return this;
      }

      public a a(int paramInt1, int paramInt2)
      {
        if ((paramInt1 > 0) && (paramInt2 > 0))
        {
          BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1402(this.a, Integer.valueOf(paramInt1));
          BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1502(this.a, Integer.valueOf(paramInt2));
        }
        return this;
      }

      a a(long paramLong)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$002(this.a, paramLong);
        return this;
      }

      public a a(BotReplyConfig paramBotReplyConfig)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1602(this.a, paramBotReplyConfig);
        return this;
      }

      public a a(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$102(this.a, paramString);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$602(this.a, paramBoolean);
        return this;
      }

      public BotFavoriteLinksCommunicator.SaveLinkActionMessage a()
      {
        if (this.a.mId < 0L)
          BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$002(this.a, BotFavoriteLinksCommunicator.SaveLinkActionMessage.ID_GENERATOR.incrementAndGet());
        BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = this.a;
        this.a = new BotFavoriteLinksCommunicator.SaveLinkActionMessage();
        return localSaveLinkActionMessage;
      }

      public a b(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$302(this.a, paramString);
        return this;
      }

      public a b(boolean paramBoolean)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$902(this.a, paramBoolean);
        return this;
      }

      public BotFavoriteLinksCommunicator.SaveLinkActionMessage b()
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$502(this.a, dl.o(this.a.mUrl));
        return a();
      }

      public a c(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$402(this.a, paramString);
        return this;
      }

      public a c(boolean paramBoolean)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1002(this.a, paramBoolean);
        return this;
      }

      public a d(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$502(this.a, paramString);
        return this;
      }

      public a d(boolean paramBoolean)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1102(this.a, paramBoolean);
        return this;
      }

      public a e(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$702(this.a, paramString);
        return this;
      }

      public a f(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1302(this.a, paramString);
        return this;
      }

      public a g(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$202(this.a, paramString);
        return this;
      }

      public a h(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1202(this.a, paramString);
        return this;
      }

      public a i(String paramString)
      {
        BotFavoriteLinksCommunicator.SaveLinkActionMessage.access$1702(this.a, paramString);
        return this;
      }
    }
  }

  public static class a
  {

    @c(a="status")
    private String a;

    public String a()
    {
      return this.a;
    }

    public String toString()
    {
      return "SaveLinkActionMessageReply{mStatus='" + this.a + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator
 * JD-Core Version:    0.6.2
 */