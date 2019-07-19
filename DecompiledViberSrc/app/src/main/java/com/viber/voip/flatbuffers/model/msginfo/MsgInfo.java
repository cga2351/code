package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.a;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BotKeyboardSendData;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.ThumbnailInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import java.util.Arrays;

public class MsgInfo
  implements Parcelable, a
{
  public static final Parcelable.Creator<MsgInfo> CREATOR = new Parcelable.Creator()
  {
    public MsgInfo a(Parcel paramAnonymousParcel)
    {
      return new MsgInfo(paramAnonymousParcel);
    }

    public MsgInfo[] a(int paramAnonymousInt)
    {
      return new MsgInfo[paramAnonymousInt];
    }
  };
  public static final String GROUP_REFERRAL_INFO_KEY = "groupReferralInfo";
  public static final String MSG_TEXT_KEY = "Text";
  public static final String PUBLIC_ACCOUNT_MSG_KEY = "pa_message_data";

  @c(a="audio_ptt")
  private AudioPttInfo mAudioPttInfo;

  @c(a="keyboard")
  private BotKeyboardSendData mBotKeyboardSendData;

  @c(a="CommunityScreenshot")
  private CommunityScreenshot mCommunityScreenshot;

  @c(a="ContentLength")
  private UnsignedLong mContentLength;

  @c(a="ContentType")
  private String mContentType;

  @c(a="DownloadId")
  private String mDownloadId;

  @c(a="edit")
  private Edit mEdit;

  @c(a="fileInfo")
  private FileInfo mFileInfo;

  @c(a="groupReferralInfo")
  private GroupReferralInfo mGroupReferralInfo;

  @c(a="inviteCommunityInfo")
  private InviteCommunityInfo mInviteCommunityInfo;

  @c(a="ivmInfo")
  private IvmInfo mIvmInfo;

  @c(a="MediaMetadata")
  private MediaMetadata mMediaMetadata;

  @c(a="Name")
  private String mName;

  @c(a="PhoneNumber")
  private String mPhoneNumber;

  @c(a="pin")
  private Pin mPin;

  @c(a="poll")
  private Poll mPoll;

  @c(a="pttVersion")
  private int mPttVersion;

  @c(a="pa_message_data")
  private PublicAccountMsgInfo mPublicAccountMsgInfo;

  @c(a="pa_reply_data")
  private PublicAccountReplyData mPublicAccountReplyData;

  @c(a="quote")
  private Quote mQuote;

  @c(a="ServiceMetadata")
  private ServiceMetadata mServiceMetadata;

  @c(a="SortName")
  private String mSortName;

  @c(a="tech_info")
  private TechInfo mTechInfo;

  @c(a="Text")
  private String mText;

  @c(a="textMetaInfo")
  private TextMetaInfo[] mTextMetaInfo;

  @c(a="ThumbnailContentType")
  private String mThumbnailContentType;

  @c(a="ThumbnailHeight")
  private UnsignedInt mThumbnailHeight;

  @c(a="ThumbnailInfo")
  private ThumbnailInfo mThumbnailInfo;

  @c(a="ThumbnailURL")
  private String mThumbnailUrl;

  @c(a="ThumbnailWidth")
  private UnsignedInt mThumbnailWidth;

  @c(a="Title")
  private String mTitle;

  @c(a="URL")
  private String mUrl;

  @c(a="Type")
  private a mUrlType;

  @c(a="ViberNumber")
  private String mViberNumber;

  public MsgInfo()
  {
  }

  MsgInfo(Parcel paramParcel)
  {
    this.mTitle = paramParcel.readString();
    this.mUrlType = a.values()[paramParcel.readInt()];
    this.mUrl = paramParcel.readString();
    this.mText = paramParcel.readString();
    this.mContentType = paramParcel.readString();
    this.mThumbnailUrl = paramParcel.readString();
    this.mThumbnailContentType = paramParcel.readString();
    this.mThumbnailInfo = ((ThumbnailInfo)paramParcel.readParcelable(ThumbnailInfo.class.getClassLoader()));
    this.mName = paramParcel.readString();
    this.mSortName = paramParcel.readString();
    this.mViberNumber = paramParcel.readString();
    this.mDownloadId = paramParcel.readString();
    this.mContentLength = ((UnsignedLong)paramParcel.readParcelable(UnsignedLong.class.getClassLoader()));
    this.mThumbnailWidth = ((UnsignedInt)paramParcel.readParcelable(UnsignedInt.class.getClassLoader()));
    this.mThumbnailHeight = ((UnsignedInt)paramParcel.readParcelable(UnsignedInt.class.getClassLoader()));
    this.mFileInfo = ((FileInfo)paramParcel.readParcelable(FileInfo.class.getClassLoader()));
    this.mServiceMetadata = ((ServiceMetadata)paramParcel.readParcelable(ServiceMetadata.class.getClassLoader()));
    this.mPublicAccountMsgInfo = ((PublicAccountMsgInfo)paramParcel.readParcelable(PublicAccountMsgInfo.class.getClassLoader()));
    this.mPublicAccountReplyData = ((PublicAccountReplyData)paramParcel.readParcelable(PublicAccountReplyData.class.getClassLoader()));
    this.mPin = ((Pin)paramParcel.readParcelable(Pin.class.getClassLoader()));
    this.mQuote = ((Quote)paramParcel.readParcelable(Quote.class.getClassLoader()));
    this.mPhoneNumber = paramParcel.readString();
    this.mBotKeyboardSendData = ((BotKeyboardSendData)paramParcel.readParcelable(BotKeyboardSendData.class.getClassLoader()));
    this.mPttVersion = paramParcel.readInt();
    this.mAudioPttInfo = ((AudioPttInfo)paramParcel.readParcelable(AudioPttInfo.class.getClassLoader()));
    this.mIvmInfo = ((IvmInfo)paramParcel.readParcelable(IvmInfo.class.getClassLoader()));
    this.mTextMetaInfo = ((TextMetaInfo[])paramParcel.createTypedArray(TextMetaInfo.CREATOR));
    this.mTechInfo = ((TechInfo)paramParcel.readParcelable(TechInfo.class.getClassLoader()));
    this.mCommunityScreenshot = ((CommunityScreenshot)paramParcel.readParcelable(CommunityScreenshot.class.getClassLoader()));
    this.mMediaMetadata = ((MediaMetadata)paramParcel.readParcelable(MediaMetadata.class.getClassLoader()));
    this.mEdit = ((Edit)paramParcel.readParcelable(Edit.class.getClassLoader()));
    this.mPoll = ((Poll)paramParcel.readParcelable(Poll.class.getClassLoader()));
    this.mInviteCommunityInfo = ((InviteCommunityInfo)paramParcel.readParcelable(InviteCommunityInfo.class.getClassLoader()));
    this.mGroupReferralInfo = ((GroupReferralInfo)paramParcel.readParcelable(GroupReferralInfo.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public AudioPttInfo getAudioPttInfo()
  {
    return this.mAudioPttInfo;
  }

  public BotKeyboardSendData getBotKeyboardSendData()
  {
    return this.mBotKeyboardSendData;
  }

  public CommunityScreenshot getCommunityScreenshot()
  {
    return this.mCommunityScreenshot;
  }

  public long getContentLength()
  {
    if (this.mContentLength != null)
      return this.mContentLength.get();
    return 0L;
  }

  public String getContentType()
  {
    return this.mContentType;
  }

  public String getDownloadId()
  {
    return this.mDownloadId;
  }

  public Edit getEdit()
  {
    return this.mEdit;
  }

  public FileInfo getFileInfo()
  {
    if (this.mFileInfo == null)
      this.mFileInfo = new FileInfo();
    return this.mFileInfo;
  }

  public GroupReferralInfo getGroupReferralInfo()
  {
    return this.mGroupReferralInfo;
  }

  public InviteCommunityInfo getInviteCommunityInfo()
  {
    return this.mInviteCommunityInfo;
  }

  public IvmInfo getIvmInfo()
  {
    return this.mIvmInfo;
  }

  public MediaMetadata getMediaMetadata()
  {
    if (this.mMediaMetadata == null)
      return new MediaMetadata.a().a();
    return this.mMediaMetadata;
  }

  public String getName()
  {
    return this.mName;
  }

  public String getPhoneNumber()
  {
    return this.mPhoneNumber;
  }

  public Pin getPin()
  {
    return this.mPin;
  }

  public Poll getPoll()
  {
    return this.mPoll;
  }

  public int getPttVersion()
  {
    return this.mPttVersion;
  }

  public String getPublicAccountInfoName()
  {
    PublicAccountInfo localPublicAccountInfo;
    if (this.mPublicAccountMsgInfo != null)
    {
      localPublicAccountInfo = this.mPublicAccountMsgInfo.getPublicAccountInfo();
      if (localPublicAccountInfo != null);
    }
    else
    {
      return null;
    }
    return localPublicAccountInfo.getPaName();
  }

  public PublicAccountMsgInfo getPublicAccountMsgInfo()
  {
    if (this.mPublicAccountMsgInfo == null)
      this.mPublicAccountMsgInfo = new PublicAccountMsgInfo();
    return this.mPublicAccountMsgInfo;
  }

  public PublicAccountReplyData getPublicAccountReplyData()
  {
    return this.mPublicAccountReplyData;
  }

  public Quote getQuote()
  {
    return this.mQuote;
  }

  public ServiceMetadata getServiceMetadata()
  {
    if (this.mServiceMetadata == null)
      this.mServiceMetadata = new ServiceMetadata();
    return this.mServiceMetadata;
  }

  public String getSortName()
  {
    return this.mSortName;
  }

  public TechInfo getTechInfo()
  {
    return this.mTechInfo;
  }

  public String getText()
  {
    return this.mText;
  }

  public TextMetaInfo[] getTextMetaInfo()
  {
    return this.mTextMetaInfo;
  }

  public String getThumbnailContentType()
  {
    return this.mThumbnailContentType;
  }

  public String getThumbnailEP()
  {
    if (this.mThumbnailInfo != null)
      return this.mThumbnailInfo.getThumbnailEP();
    return null;
  }

  public int getThumbnailHeight()
  {
    if (this.mThumbnailHeight != null)
      return this.mThumbnailHeight.get();
    return 0;
  }

  public ThumbnailInfo getThumbnailInfo()
  {
    return this.mThumbnailInfo;
  }

  public String getThumbnailUrl()
  {
    return this.mThumbnailUrl;
  }

  public int getThumbnailWidth()
  {
    if (this.mThumbnailWidth != null)
      return this.mThumbnailWidth.get();
    return 0;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getUrl()
  {
    return this.mUrl;
  }

  public a getUrlType()
  {
    if (this.mUrlType == null)
      return a.DEFAULT;
    return this.mUrlType;
  }

  public String getViberNumber()
  {
    return this.mViberNumber;
  }

  public void setAudioPttInfo(AudioPttInfo paramAudioPttInfo)
  {
    this.mAudioPttInfo = paramAudioPttInfo;
  }

  public void setBotKeyboardSendData(BotKeyboardSendData paramBotKeyboardSendData)
  {
    this.mBotKeyboardSendData = paramBotKeyboardSendData;
  }

  public void setCommunityScreenshot(CommunityScreenshot paramCommunityScreenshot)
  {
    this.mCommunityScreenshot = paramCommunityScreenshot;
  }

  public void setContentLength(long paramLong)
  {
    this.mContentLength = new UnsignedLong(paramLong);
  }

  public void setContentType(String paramString)
  {
    this.mContentType = paramString;
  }

  public void setDownloadId(String paramString)
  {
    this.mDownloadId = paramString;
  }

  public void setEdit(Edit paramEdit)
  {
    this.mEdit = paramEdit;
  }

  public void setFileInfo(FileInfo paramFileInfo)
  {
    this.mFileInfo = paramFileInfo;
  }

  public void setGroupReferralInfo(GroupReferralInfo paramGroupReferralInfo)
  {
    this.mGroupReferralInfo = paramGroupReferralInfo;
  }

  public void setInviteCommunityInfo(InviteCommunityInfo paramInviteCommunityInfo)
  {
    this.mInviteCommunityInfo = paramInviteCommunityInfo;
  }

  public void setIvmInfo(IvmInfo paramIvmInfo)
  {
    this.mIvmInfo = paramIvmInfo;
  }

  public void setMediaMetadata(MediaMetadata paramMediaMetadata)
  {
    if (paramMediaMetadata == null)
      paramMediaMetadata = null;
    while (true)
    {
      this.mMediaMetadata = paramMediaMetadata;
      return;
      if (paramMediaMetadata.isEmpty())
        paramMediaMetadata = null;
    }
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void setPhoneNumber(String paramString)
  {
    this.mPhoneNumber = paramString;
  }

  public void setPin(Pin paramPin)
  {
    this.mPin = paramPin;
  }

  public void setPoll(Poll paramPoll)
  {
    this.mPoll = paramPoll;
  }

  public void setPttVersion(int paramInt)
  {
    this.mPttVersion = paramInt;
  }

  public void setPublicAccountMsgInfo(PublicAccountMsgInfo paramPublicAccountMsgInfo)
  {
    this.mPublicAccountMsgInfo = paramPublicAccountMsgInfo;
  }

  public void setPublicAccountReplyData(PublicAccountReplyData paramPublicAccountReplyData)
  {
    this.mPublicAccountReplyData = paramPublicAccountReplyData;
  }

  public void setQuote(Quote paramQuote)
  {
    this.mQuote = paramQuote;
  }

  public void setServiceMetadata(ServiceMetadata paramServiceMetadata)
  {
    this.mServiceMetadata = paramServiceMetadata;
  }

  public void setSortName(String paramString)
  {
    this.mSortName = paramString;
  }

  public void setTechInfo(TechInfo paramTechInfo)
  {
    this.mTechInfo = paramTechInfo;
  }

  public void setText(String paramString)
  {
    this.mText = paramString;
  }

  public void setTextMetaInfo(TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    this.mTextMetaInfo = paramArrayOfTextMetaInfo;
  }

  public void setThumbnailContentType(String paramString)
  {
    this.mThumbnailContentType = paramString;
  }

  public void setThumbnailEP(String paramString)
  {
    if (this.mThumbnailInfo == null)
      this.mThumbnailInfo = new ThumbnailInfo();
    this.mThumbnailInfo.setThumbnailEP(paramString);
  }

  public void setThumbnailHeight(int paramInt)
  {
    this.mThumbnailHeight = new UnsignedInt(paramInt);
  }

  public void setThumbnailInfo(ThumbnailInfo paramThumbnailInfo)
  {
    this.mThumbnailInfo = paramThumbnailInfo;
  }

  public void setThumbnailUrl(String paramString)
  {
    this.mThumbnailUrl = paramString;
  }

  public void setThumbnailWidth(int paramInt)
  {
    this.mThumbnailWidth = new UnsignedInt(paramInt);
  }

  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }

  public void setUrlType(a parama)
  {
    this.mUrlType = parama;
  }

  public void setViberNumber(String paramString)
  {
    this.mViberNumber = paramString;
  }

  public String toString()
  {
    return "MsgInfo{mTitle='" + this.mTitle + '\'' + ", mUrlType=" + this.mUrlType + ", mUrl='" + this.mUrl + '\'' + ", mText='" + this.mText + '\'' + ", mContentType='" + this.mContentType + '\'' + ", mContentLength=" + this.mContentLength + ", mThumbnailUrl='" + this.mThumbnailUrl + '\'' + ", mThumbnailWidth=" + this.mThumbnailWidth + ", mThumbnailHeight=" + this.mThumbnailHeight + ", mThumbnailContentType='" + this.mThumbnailContentType + '\'' + ", mThumbnailInfo='" + this.mThumbnailInfo + '\'' + ", mFileInfo=" + this.mFileInfo + ", mServiceMetadata=" + this.mServiceMetadata + ", mName=" + this.mName + ", mSortName=" + this.mSortName + ", mViberNumber=" + this.mViberNumber + ", mDownloadId=" + this.mDownloadId + ", mPublicAccountMsgInfo=" + this.mPublicAccountMsgInfo + ", mPublicAccountReplyData=" + this.mPublicAccountReplyData + ", mBotKeyboardSendData=" + this.mBotKeyboardSendData + ", mPin=" + this.mPin + ", mQuote=" + this.mQuote + ", mPttVersion=" + this.mPttVersion + ", mAudioPttInfo=" + this.mAudioPttInfo + ", mIvmInfo=" + this.mIvmInfo + ", mTextMetaInfo=" + Arrays.toString(this.mTextMetaInfo) + ", mTechInfo=" + this.mTechInfo + ", mCommunityScreenshot=" + this.mCommunityScreenshot + ", mMediaMetadata=" + this.mMediaMetadata + ", mEdit=" + this.mEdit + ", mPoll=" + this.mPoll + ", mInviteCommunityInfo=" + this.mInviteCommunityInfo + ", mGroupReferralInfo=" + this.mGroupReferralInfo + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(getUrlType().ordinal());
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mText);
    paramParcel.writeString(this.mContentType);
    paramParcel.writeString(this.mThumbnailUrl);
    paramParcel.writeString(this.mThumbnailContentType);
    paramParcel.writeParcelable(this.mThumbnailInfo, paramInt);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mSortName);
    paramParcel.writeString(this.mViberNumber);
    paramParcel.writeString(this.mDownloadId);
    paramParcel.writeParcelable(this.mContentLength, paramInt);
    paramParcel.writeParcelable(this.mThumbnailWidth, paramInt);
    paramParcel.writeParcelable(this.mThumbnailHeight, paramInt);
    paramParcel.writeParcelable(this.mFileInfo, paramInt);
    paramParcel.writeParcelable(this.mServiceMetadata, paramInt);
    paramParcel.writeParcelable(this.mPublicAccountMsgInfo, paramInt);
    paramParcel.writeParcelable(this.mPublicAccountReplyData, paramInt);
    paramParcel.writeParcelable(this.mPin, paramInt);
    paramParcel.writeParcelable(this.mQuote, paramInt);
    paramParcel.writeString(this.mPhoneNumber);
    paramParcel.writeParcelable(this.mBotKeyboardSendData, paramInt);
    paramParcel.writeInt(this.mPttVersion);
    paramParcel.writeParcelable(this.mAudioPttInfo, paramInt);
    paramParcel.writeParcelable(this.mIvmInfo, paramInt);
    paramParcel.writeTypedArray(this.mTextMetaInfo, paramInt);
    paramParcel.writeParcelable(this.mTechInfo, paramInt);
    paramParcel.writeParcelable(this.mCommunityScreenshot, paramInt);
    paramParcel.writeParcelable(this.mMediaMetadata, paramInt);
    paramParcel.writeParcelable(this.mEdit, paramInt);
    paramParcel.writeParcelable(this.mPoll, paramInt);
    paramParcel.writeParcelable(this.mInviteCommunityInfo, paramInt);
    paramParcel.writeParcelable(this.mGroupReferralInfo, paramInt);
  }

  public static enum a
  {
    final String mTypeName;

    static
    {
      AUDIO = new a("AUDIO", 1, "audio");
      IMAGE = new a("IMAGE", 2, "image");
      DEFAULT = new a("DEFAULT", 3, "default");
      a[] arrayOfa = new a[4];
      arrayOfa[0] = VIDEO;
      arrayOfa[1] = AUDIO;
      arrayOfa[2] = IMAGE;
      arrayOfa[3] = DEFAULT;
    }

    private a(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static a fromName(String paramString)
    {
      for (a locala : values())
        if (locala.mTypeName.equalsIgnoreCase(paramString))
          return locala;
      return DEFAULT;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.MsgInfo
 * JD-Core Version:    0.6.2
 */