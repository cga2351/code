package com.viber.voip.publicaccount.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.google.d.a.c;
import com.google.d.f;
import com.google.d.m;
import com.google.d.u;
import com.viber.dexshared.Logger;
import com.viber.jni.LocationInfo;
import com.viber.jni.PublicAccountAttributes;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.PublicGroupInfo;
import com.viber.jni.im2.CMoreUserInfo;
import com.viber.jni.im2.Location;
import com.viber.jni.im2.RecoveredPublicAccountInfo;
import com.viber.jni.im2.RecoveredPublicAccountMoreInfo;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.util.av;
import com.viber.voip.util.ca;
import com.viber.voip.util.dg;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.ObjectId;
import java.util.Arrays;
import java.util.Map;

public class PublicAccount
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccount> CREATOR = new Parcelable.Creator()
  {
    public PublicAccount a(Parcel paramAnonymousParcel)
    {
      return new PublicAccount(paramAnonymousParcel);
    }

    public PublicAccount[] a(int paramAnonymousInt)
    {
      return new PublicAccount[paramAnonymousInt];
    }
  };
  private String mAddressString;
  private String mAuthToken;
  private Background mBackground;
  private String mChatBackground;
  private long mConversationId;
  private String mCountryCode;
  private CrmItem mCrm;
  private boolean mDisplayInvitationLink;
  private String mEmail;
  private int mExtraFlags;
  private ExtraInfo mExtraInfo;
  private String mExtraInfoJson;
  private int mFlags;
  private GlobalPermissions mGlobalPermissions;
  private long mGroupID;
  private int mGroupRole;
  private String mGroupUri;
  private Uri mIcon;
  private ObjectId mIconObjectId;
  private boolean mIsMute;
  private boolean mIsSmartNotificationsOn;
  private int mLastMessageId;
  private LocationInfo mLocation;
  private int mMediaCount;
  private MyCommunitySettings mMySettings;
  private String mMySettingsJson;
  private String mName;
  private String mPublicAccountId;
  private int mPublicGroupType;
  private int mRevision;
  private CategoryItem mSelectedCategory;
  private CategoryItem mSelectedSubcategory;
  private int mSubscribersCount;
  private boolean mSubscriptionExists;
  private String mTagLines;
  private String[] mTags;
  private int mWatchersCount;
  private boolean mWebhookExists;
  private String mWebsite;

  public PublicAccount()
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
  }

  public PublicAccount(long paramLong, PublicAccountAttributes paramPublicAccountAttributes)
  {
    this.mRevision = i;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mGroupID = paramLong;
    CategoryItem[] arrayOfCategoryItem = com.viber.voip.publicaccount.d.e.a(paramPublicAccountAttributes.getCategoryId(), paramPublicAccountAttributes.getSubCategoryId());
    if (arrayOfCategoryItem != null)
    {
      this.mSelectedCategory = arrayOfCategoryItem[0];
      this.mSelectedSubcategory = arrayOfCategoryItem[i];
    }
    if (paramPublicAccountAttributes.getWebHookExists() > 0);
    while (true)
    {
      this.mWebhookExists = i;
      this.mWebsite = paramPublicAccountAttributes.getWebsite();
      this.mEmail = paramPublicAccountAttributes.getEmail();
      this.mSubscriptionExists = paramPublicAccountAttributes.hasSubscription();
      this.mAuthToken = paramPublicAccountAttributes.getAuthenticationToken();
      String str = dg.a(paramPublicAccountAttributes);
      if (!TextUtils.isEmpty(str))
        this.mCrm = new CrmItem(str);
      this.mExtraInfo = ExtraInfo.fromJniJokerButtons(paramPublicAccountAttributes.getJokerButtons(), getExtraInfo());
      return;
      i = 0;
    }
  }

  protected PublicAccount(Parcel paramParcel)
  {
    this.mRevision = i;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mConversationId = paramParcel.readLong();
    this.mPublicAccountId = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mSelectedCategory = ((CategoryItem)paramParcel.readParcelable(CategoryItem.class.getClassLoader()));
    this.mSelectedSubcategory = ((CategoryItem)paramParcel.readParcelable(CategoryItem.class.getClassLoader()));
    this.mIcon = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mTagLines = paramParcel.readString();
    this.mLocation = ((LocationInfo)paramParcel.readParcelable(LocationInfo.class.getClassLoader()));
    this.mAddressString = paramParcel.readString();
    this.mWebsite = paramParcel.readString();
    this.mEmail = paramParcel.readString();
    boolean bool1;
    boolean bool2;
    label179: boolean bool3;
    label323: boolean bool4;
    if (paramParcel.readByte() != 0)
    {
      bool1 = i;
      this.mIsSmartNotificationsOn = bool1;
      if (paramParcel.readByte() == 0)
        break label443;
      bool2 = i;
      this.mIsMute = bool2;
      this.mPublicGroupType = paramParcel.readInt();
      this.mGroupID = paramParcel.readLong();
      this.mRevision = paramParcel.readInt();
      this.mGroupUri = paramParcel.readString();
      this.mBackground = ((Background)paramParcel.readParcelable(Background.class.getClassLoader()));
      this.mCountryCode = paramParcel.readString();
      this.mGroupRole = paramParcel.readInt();
      this.mTags = paramParcel.createStringArray();
      this.mLastMessageId = paramParcel.readInt();
      this.mFlags = paramParcel.readInt();
      this.mExtraFlags = paramParcel.readInt();
      this.mWatchersCount = paramParcel.readInt();
      this.mMediaCount = paramParcel.readInt();
      this.mSubscribersCount = paramParcel.readInt();
      this.mAuthToken = paramParcel.readString();
      if (paramParcel.readByte() == 0)
        break label449;
      bool3 = i;
      this.mWebhookExists = bool3;
      if (paramParcel.readByte() == 0)
        break label455;
      bool4 = i;
      label339: this.mSubscriptionExists = bool4;
      this.mCrm = ((CrmItem)paramParcel.readParcelable(CrmItem.class.getClassLoader()));
      this.mExtraInfo = ((ExtraInfo)paramParcel.readParcelable(ExtraInfo.class.getClassLoader()));
      this.mExtraInfoJson = paramParcel.readString();
      this.mGlobalPermissions = ((GlobalPermissions)paramParcel.readParcelable(GlobalPermissions.class.getClassLoader()));
      if (paramParcel.readByte() == 0)
        break label461;
    }
    while (true)
    {
      this.mDisplayInvitationLink = i;
      this.mMySettings = ((MyCommunitySettings)paramParcel.readParcelable(MyCommunitySettings.class.getClassLoader()));
      this.mMySettingsJson = paramParcel.readString();
      return;
      bool1 = false;
      break;
      label443: bool2 = false;
      break label179;
      label449: bool3 = false;
      break label323;
      label455: bool4 = false;
      break label339;
      label461: i = 0;
    }
  }

  public PublicAccount(PublicAccountInfo paramPublicAccountInfo)
  {
    this.mRevision = i;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mName = paramPublicAccountInfo.getGroupName();
    this.mIcon = dx.g(paramPublicAccountInfo.getIconDownloadID());
    this.mGroupID = paramPublicAccountInfo.getPublicChatId();
    this.mPublicAccountId = paramPublicAccountInfo.getPublicAccountID();
    this.mGroupUri = paramPublicAccountInfo.getGroupUri();
    CategoryItem[] arrayOfCategoryItem = com.viber.voip.publicaccount.d.e.a(paramPublicAccountInfo.getCategory(), paramPublicAccountInfo.getSubCategory());
    if (arrayOfCategoryItem != null)
    {
      this.mSelectedCategory = arrayOfCategoryItem[0];
      this.mSelectedSubcategory = arrayOfCategoryItem[i];
    }
    this.mTagLines = paramPublicAccountInfo.getTagLine();
    this.mLocation = paramPublicAccountInfo.getLocation();
    this.mWebsite = paramPublicAccountInfo.getWebSite();
    this.mEmail = paramPublicAccountInfo.getEmail();
    this.mIsSmartNotificationsOn = i;
    this.mIsMute = false;
    this.mPublicGroupType = 2;
    this.mRevision = paramPublicAccountInfo.getRevision();
    this.mBackground = new Background(paramPublicAccountInfo.getBackgroundDownloadID(), null);
    this.mCountryCode = paramPublicAccountInfo.getCountry();
    this.mGroupRole = paramPublicAccountInfo.getUserRole();
    this.mTags = paramPublicAccountInfo.getTags();
    this.mLastMessageId = paramPublicAccountInfo.getLastMsgSeqID();
    this.mFlags = paramPublicAccountInfo.getGroupFlags();
    if (i == paramPublicAccountInfo.getDisplayInvitationLink());
    while (true)
    {
      this.mDisplayInvitationLink = i;
      this.mWatchersCount = paramPublicAccountInfo.getWatchersCount();
      this.mSubscribersCount = paramPublicAccountInfo.getSubscribersCount();
      this.mAuthToken = paramPublicAccountInfo.getAuthToken();
      this.mWebhookExists = paramPublicAccountInfo.isWebhookExists();
      String str = dg.a(paramPublicAccountInfo);
      if (!TextUtils.isEmpty(str))
        this.mCrm = new CrmItem(str);
      this.mExtraInfo = ExtraInfo.fromJniJokerButtons(paramPublicAccountInfo.getJokerButtons(), getExtraInfo());
      this.mGlobalPermissions = new GlobalPermissions(paramPublicAccountInfo.getCommunityPrivileges());
      this.mChatBackground = paramPublicAccountInfo.getChatBackground();
      return;
      i = 0;
    }
  }

  public PublicAccount(PublicAccountInfo paramPublicAccountInfo, boolean paramBoolean, String paramString1, String paramString2)
  {
    this(paramPublicAccountInfo);
    this.mSubscriptionExists = paramBoolean;
    this.mMySettingsJson = paramString1;
    if (this.mExtraInfo == null)
      this.mExtraInfo = ExtraInfo.fromExtraInfoJson(paramString2);
  }

  public PublicAccount(PublicGroupInfo paramPublicGroupInfo)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mName = paramPublicGroupInfo.groupName;
    this.mIcon = dx.g(paramPublicGroupInfo.iconId);
    this.mGroupID = paramPublicGroupInfo.groupID;
    this.mGroupUri = paramPublicGroupInfo.groupUri;
    this.mTagLines = paramPublicGroupInfo.tagLine;
    this.mLocation = paramPublicGroupInfo.location;
    this.mRevision = paramPublicGroupInfo.revision;
    this.mBackground = new Background(paramPublicGroupInfo.backgroundId, null);
    this.mCountryCode = paramPublicGroupInfo.countryCode;
    this.mGroupRole = 3;
    this.mTags = paramPublicGroupInfo.tags;
    this.mLastMessageId = paramPublicGroupInfo.lastMessageId;
    this.mFlags = paramPublicGroupInfo.flags;
    this.mWatchersCount = paramPublicGroupInfo.watchersCount;
  }

  public PublicAccount(RecoveredPublicAccountInfo paramRecoveredPublicAccountInfo, RecoveredPublicAccountMoreInfo paramRecoveredPublicAccountMoreInfo)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mName = paramRecoveredPublicAccountInfo.groupName;
    this.mIcon = dx.g(paramRecoveredPublicAccountInfo.iconDownloadID);
    this.mGroupID = paramRecoveredPublicAccountInfo.publicChatId;
    this.mPublicAccountId = paramRecoveredPublicAccountInfo.publicAccountID;
    this.mGroupUri = paramRecoveredPublicAccountInfo.groupUri;
    CategoryItem[] arrayOfCategoryItem = com.viber.voip.publicaccount.d.e.a(paramRecoveredPublicAccountInfo.category, paramRecoveredPublicAccountInfo.subCategory);
    if (arrayOfCategoryItem != null)
    {
      this.mSelectedCategory = arrayOfCategoryItem[0];
      this.mSelectedSubcategory = arrayOfCategoryItem[1];
    }
    this.mTagLines = paramRecoveredPublicAccountInfo.tagLine;
    this.mLocation = paramRecoveredPublicAccountInfo.location.toLegacyLocation();
    this.mWebsite = paramRecoveredPublicAccountInfo.website;
    this.mEmail = paramRecoveredPublicAccountInfo.email;
    this.mIsSmartNotificationsOn = true;
    this.mIsMute = false;
    this.mPublicGroupType = 2;
    this.mRevision = paramRecoveredPublicAccountInfo.revision;
    this.mBackground = new Background(paramRecoveredPublicAccountInfo.backgroundDownloadID, null);
    this.mCountryCode = paramRecoveredPublicAccountInfo.country;
    this.mGroupRole = paramRecoveredPublicAccountInfo.userRole;
    this.mTags = paramRecoveredPublicAccountInfo.tags;
    this.mLastMessageId = paramRecoveredPublicAccountInfo.lastMsgSeqID;
    this.mFlags = paramRecoveredPublicAccountInfo.groupFlags;
    this.mWatchersCount = paramRecoveredPublicAccountInfo.watchersCount;
    this.mSubscribersCount = paramRecoveredPublicAccountInfo.subscribersCount;
    this.mAuthToken = paramRecoveredPublicAccountInfo.authToken;
    this.mWebhookExists = paramRecoveredPublicAccountInfo.webhookExists;
    String str1 = dg.a(paramRecoveredPublicAccountInfo);
    if (!TextUtils.isEmpty(str1))
      this.mCrm = new CrmItem(str1);
    this.mExtraInfo = ExtraInfo.fromIm2JokerButtons(paramRecoveredPublicAccountInfo.jokerButtons);
    String str2 = null;
    if (paramRecoveredPublicAccountMoreInfo != null)
      str2 = (String)paramRecoveredPublicAccountMoreInfo.moreInfo.data.get(Integer.valueOf(6));
    this.mChatBackground = str2;
  }

  public PublicAccount(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mConversationId = paramConversationItemLoaderEntity.getId();
    this.mGroupID = paramConversationItemLoaderEntity.getPublicAccountGroupId();
    this.mGroupUri = paramConversationItemLoaderEntity.getPublicAccountGroupUri();
    this.mName = paramConversationItemLoaderEntity.getGroupName();
    this.mIcon = paramConversationItemLoaderEntity.getIconUri();
    this.mGroupRole = paramConversationItemLoaderEntity.getGroupRole();
    this.mTagLines = paramConversationItemLoaderEntity.getPublicAccountTagsLine();
    this.mPublicAccountId = paramConversationItemLoaderEntity.getParticipantMemberId();
    this.mWebhookExists = paramConversationItemLoaderEntity.isWebhookExist();
    this.mSubscriptionExists = paramConversationItemLoaderEntity.hasPublicAccountSubscription();
    this.mFlags = paramConversationItemLoaderEntity.getPublicAccountGroupFlags();
  }

  public PublicAccount(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mConversationId = paramPublicGroupConversationItemLoaderEntity.getId();
    this.mName = paramPublicGroupConversationItemLoaderEntity.getGroupName();
    this.mIcon = paramPublicGroupConversationItemLoaderEntity.getIconUri();
    this.mGroupID = paramPublicGroupConversationItemLoaderEntity.getGroupId();
    this.mPublicAccountId = paramPublicGroupConversationItemLoaderEntity.getPublicAccountId();
    this.mGroupUri = paramPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri();
    this.mSelectedCategory = new CategoryItem(paramPublicGroupConversationItemLoaderEntity.getCategoryId(), paramPublicGroupConversationItemLoaderEntity.getCategoryName());
    this.mSelectedSubcategory = new CategoryItem(paramPublicGroupConversationItemLoaderEntity.getSubcategoryId(), paramPublicGroupConversationItemLoaderEntity.getSubcategoryName());
    this.mTagLines = paramPublicGroupConversationItemLoaderEntity.getPublicAccountTagsLine();
    int i = paramPublicGroupConversationItemLoaderEntity.getLocationLat();
    LocationInfo localLocationInfo = null;
    if (i != 0)
    {
      int j = paramPublicGroupConversationItemLoaderEntity.getLocationLng();
      localLocationInfo = null;
      if (j != 0)
        localLocationInfo = new LocationInfo(paramPublicGroupConversationItemLoaderEntity.getLocationLat(), paramPublicGroupConversationItemLoaderEntity.getLocationLng());
    }
    this.mLocation = localLocationInfo;
    this.mAddressString = paramPublicGroupConversationItemLoaderEntity.getAddressString();
    this.mWebsite = paramPublicGroupConversationItemLoaderEntity.getWebsite();
    this.mEmail = paramPublicGroupConversationItemLoaderEntity.getEmail();
    this.mIsSmartNotificationsOn = paramPublicGroupConversationItemLoaderEntity.isSmartNotificationOn();
    this.mIsMute = paramPublicGroupConversationItemLoaderEntity.isMuteConversation();
    this.mPublicGroupType = paramPublicGroupConversationItemLoaderEntity.getConversationType();
    this.mRevision = paramPublicGroupConversationItemLoaderEntity.getRevision();
    this.mBackground = new Background(paramPublicGroupConversationItemLoaderEntity.getBackgroundId(), paramPublicGroupConversationItemLoaderEntity.getBackgroundPortrait());
    this.mCountryCode = paramPublicGroupConversationItemLoaderEntity.getCountryCode();
    this.mGroupRole = paramPublicGroupConversationItemLoaderEntity.getGroupRole();
    this.mTags = paramPublicGroupConversationItemLoaderEntity.getTagsArray();
    this.mLastMessageId = paramPublicGroupConversationItemLoaderEntity.getLastServerMsgId();
    this.mFlags = paramPublicGroupConversationItemLoaderEntity.getPublicGroupFlags();
    this.mExtraFlags = paramPublicGroupConversationItemLoaderEntity.getPublicGroupExtraFlags();
    this.mWatchersCount = paramPublicGroupConversationItemLoaderEntity.getWatchersCount();
    this.mMediaCount = 0;
    this.mSubscribersCount = paramPublicGroupConversationItemLoaderEntity.getSubscribersCount();
    this.mAuthToken = paramPublicGroupConversationItemLoaderEntity.getPublicAccountAuthToken();
    this.mWebhookExists = paramPublicGroupConversationItemLoaderEntity.isWebhookExist();
    this.mSubscriptionExists = paramPublicGroupConversationItemLoaderEntity.hasPublicAccountSubscription();
    String str = dg.a(paramPublicGroupConversationItemLoaderEntity);
    if (!TextUtils.isEmpty(str))
      this.mCrm = new CrmItem(str);
    this.mExtraInfoJson = paramPublicGroupConversationItemLoaderEntity.getExtraInfo();
    this.mGlobalPermissions = new GlobalPermissions(paramPublicGroupConversationItemLoaderEntity.getCommunityPrivileges());
    this.mDisplayInvitationLink = paramPublicGroupConversationItemLoaderEntity.isDisplayInvitationLinkToAll();
    this.mMySettingsJson = paramPublicGroupConversationItemLoaderEntity.getMySettingsJson();
  }

  public PublicAccount(h paramh, r paramr)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mName = paramh.o();
    this.mIcon = paramh.q();
    this.mGroupID = paramr.a();
    this.mPublicAccountId = paramr.b();
    this.mGroupUri = paramr.d();
    CategoryItem[] arrayOfCategoryItem = com.viber.voip.publicaccount.d.e.a(paramr.P(), paramr.Q());
    if (arrayOfCategoryItem != null)
    {
      this.mSelectedCategory = arrayOfCategoryItem[0];
      this.mSelectedSubcategory = arrayOfCategoryItem[1];
    }
    this.mTagLines = paramr.u();
    int i = paramr.h();
    LocationInfo localLocationInfo = null;
    if (i != 0)
    {
      int j = paramr.i();
      localLocationInfo = null;
      if (j != 0)
        localLocationInfo = new LocationInfo(paramr.h(), paramr.i());
    }
    this.mLocation = localLocationInfo;
    this.mAddressString = paramr.w();
    this.mWebsite = paramr.M();
    this.mEmail = paramr.N();
    this.mRevision = paramr.e();
    this.mBackground = new Background(paramr.f(), paramh.t());
    this.mCountryCode = paramr.g();
    this.mGroupRole = paramh.p();
    this.mTags = paramr.t();
    this.mLastMessageId = paramr.n();
    this.mFlags = paramr.x();
    this.mExtraFlags = paramr.A();
    this.mWatchersCount = paramr.j();
    this.mSubscribersCount = paramr.O();
    this.mAuthToken = paramr.o();
    this.mWebhookExists = paramr.c();
    this.mSubscriptionExists = paramr.r();
    String str = dg.a(paramr);
    if (!TextUtils.isEmpty(str))
      this.mCrm = new CrmItem(str);
    this.mExtraInfoJson = paramr.R();
    this.mGlobalPermissions = new GlobalPermissions(paramr.T());
    this.mDisplayInvitationLink = paramr.C();
    this.mChatBackground = paramr.U();
    this.mMySettingsJson = paramr.W();
  }

  public PublicAccount(r paramr, h paramh)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mGroupID = paramr.a();
    this.mPublicAccountId = paramr.b();
    this.mGroupUri = paramr.d();
    CategoryItem[] arrayOfCategoryItem = com.viber.voip.publicaccount.d.e.a(paramr.P(), paramr.Q());
    if (arrayOfCategoryItem != null)
    {
      this.mSelectedCategory = arrayOfCategoryItem[0];
      this.mSelectedSubcategory = arrayOfCategoryItem[1];
    }
    this.mTagLines = paramr.u();
    if ((paramr.h() != 0) && (paramr.i() != 0));
    for (LocationInfo localLocationInfo = new LocationInfo(paramr.h(), paramr.i()); ; localLocationInfo = null)
    {
      this.mLocation = localLocationInfo;
      this.mAddressString = paramr.w();
      this.mWebsite = paramr.M();
      this.mEmail = paramr.N();
      this.mRevision = paramr.e();
      this.mBackground = new Background(paramr.f(), null);
      this.mCountryCode = paramr.g();
      this.mTags = paramr.t();
      this.mLastMessageId = paramr.n();
      this.mFlags = paramr.x();
      this.mExtraFlags = paramr.A();
      this.mWatchersCount = paramr.j();
      this.mSubscribersCount = paramr.O();
      this.mAuthToken = paramr.o();
      this.mWebhookExists = paramr.c();
      this.mSubscriptionExists = paramr.r();
      this.mDisplayInvitationLink = paramr.C();
      this.mChatBackground = paramr.U();
      String str = dg.a(paramr);
      if (!TextUtils.isEmpty(str))
        this.mCrm = new CrmItem(str);
      this.mExtraInfoJson = paramr.R();
      this.mGlobalPermissions = new GlobalPermissions(paramr.T());
      this.mMySettingsJson = paramr.W();
      this.mGroupRole = paramh.p();
      this.mName = paramh.o();
      this.mIcon = paramh.q();
      this.mConversationId = paramh.getId();
      this.mIsSmartNotificationsOn = paramh.ac();
      this.mIsMute = paramh.y();
      this.mPublicGroupType = paramh.j();
      return;
    }
  }

  public PublicAccount(PublicAccount paramPublicAccount)
  {
    this.mRevision = 1;
    this.mBackground = new Background(null, null);
    this.mGlobalPermissions = new GlobalPermissions();
    this.mConversationId = paramPublicAccount.mConversationId;
    this.mPublicAccountId = paramPublicAccount.mPublicAccountId;
    this.mName = paramPublicAccount.mName;
    CategoryItem localCategoryItem1;
    CategoryItem localCategoryItem2;
    if (paramPublicAccount.mSelectedCategory != null)
    {
      localCategoryItem1 = new CategoryItem(paramPublicAccount.mSelectedCategory);
      this.mSelectedCategory = localCategoryItem1;
      if (paramPublicAccount.mSelectedSubcategory == null)
        break label428;
      localCategoryItem2 = new CategoryItem(paramPublicAccount.mSelectedSubcategory);
      label100: this.mSelectedSubcategory = localCategoryItem2;
      Uri localUri1 = paramPublicAccount.mIcon;
      Uri localUri2 = null;
      if (localUri1 != null)
        localUri2 = Uri.parse(paramPublicAccount.mIcon.toString());
      this.mIcon = localUri2;
      this.mTagLines = paramPublicAccount.mTagLines;
      this.mLocation = paramPublicAccount.mLocation;
      this.mAddressString = paramPublicAccount.mAddressString;
      this.mWebsite = paramPublicAccount.mWebsite;
      this.mEmail = paramPublicAccount.mEmail;
      this.mIsSmartNotificationsOn = paramPublicAccount.mIsSmartNotificationsOn;
      this.mIsMute = paramPublicAccount.mIsMute;
      this.mPublicGroupType = paramPublicAccount.mPublicGroupType;
      this.mGroupID = paramPublicAccount.mGroupID;
      this.mRevision = paramPublicAccount.mRevision;
      this.mGroupUri = paramPublicAccount.mGroupUri;
      this.mBackground = new Background(paramPublicAccount.mBackground);
      this.mCountryCode = paramPublicAccount.mCountryCode;
      this.mGroupRole = paramPublicAccount.mGroupRole;
      if (paramPublicAccount.mTags == null)
        break label433;
    }
    label428: label433: for (String[] arrayOfString = (String[])Arrays.copyOf(paramPublicAccount.mTags, paramPublicAccount.mTags.length); ; arrayOfString = new String[0])
    {
      this.mTags = arrayOfString;
      this.mLastMessageId = paramPublicAccount.mLastMessageId;
      this.mFlags = paramPublicAccount.mFlags;
      this.mExtraFlags = paramPublicAccount.mExtraFlags;
      this.mWatchersCount = paramPublicAccount.mWatchersCount;
      this.mMediaCount = paramPublicAccount.mMediaCount;
      this.mSubscribersCount = paramPublicAccount.mSubscribersCount;
      this.mAuthToken = paramPublicAccount.mAuthToken;
      this.mWebhookExists = paramPublicAccount.mWebhookExists;
      this.mSubscriptionExists = paramPublicAccount.mSubscriptionExists;
      this.mCrm = paramPublicAccount.mCrm;
      this.mExtraInfoJson = paramPublicAccount.mExtraInfoJson;
      this.mExtraInfo = paramPublicAccount.mExtraInfo;
      this.mGlobalPermissions = paramPublicAccount.mGlobalPermissions;
      this.mDisplayInvitationLink = paramPublicAccount.mDisplayInvitationLink;
      this.mChatBackground = paramPublicAccount.mChatBackground;
      this.mMySettingsJson = paramPublicAccount.mMySettingsJson;
      this.mMySettings = paramPublicAccount.mMySettings;
      return;
      localCategoryItem1 = null;
      break;
      localCategoryItem2 = null;
      break label100;
    }
  }

  private Pair<Boolean, Integer> diff(PublicAccount paramPublicAccount, int paramInt)
  {
    if (this.mIsSmartNotificationsOn != paramPublicAccount.mIsSmartNotificationsOn)
      if (1 == paramInt)
        return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
    for (boolean bool = true; ; bool = false)
    {
      if (this.mIsMute != paramPublicAccount.mIsMute)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mPublicGroupType != paramPublicAccount.mPublicGroupType)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mGroupID != paramPublicAccount.mGroupID)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mRevision != paramPublicAccount.mRevision)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mGroupRole != paramPublicAccount.mGroupRole)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mLastMessageId != paramPublicAccount.mLastMessageId)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      if (this.mConversationId != paramPublicAccount.mConversationId)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(0));
        bool = true;
      }
      int i = this.mFlags;
      int j = paramPublicAccount.mFlags;
      int k = 0;
      if (i != j)
      {
        k = av.e(0, 128);
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mExtraFlags != paramPublicAccount.mExtraFlags)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mWatchersCount != paramPublicAccount.mWatchersCount)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mMediaCount != paramPublicAccount.mMediaCount)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mSubscribersCount != paramPublicAccount.mSubscribersCount)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mWebhookExists != paramPublicAccount.mWebhookExists)
      {
        k = av.e(k, 1024);
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mSubscriptionExists != paramPublicAccount.mSubscriptionExists)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mDisplayInvitationLink != paramPublicAccount.mDisplayInvitationLink)
      {
        if (1 == paramInt)
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        bool = true;
      }
      if (this.mPublicAccountId != null)
      {
        if (this.mPublicAccountId.equals(paramPublicAccount.mPublicAccountId));
      }
      else
        while (paramPublicAccount.mPublicAccountId != null)
        {
          if (1 != paramInt)
            break;
          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
        }
      while (true)
      {
        if (this.mName != null)
        {
          if (this.mName.equals(paramPublicAccount.mName));
        }
        else
          while (paramPublicAccount.mName != null)
          {
            k = av.e(k, 1);
            if (1 != paramInt)
              break;
            return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
          }
        while (true)
        {
          if (this.mSelectedCategory != null)
          {
            if (this.mSelectedCategory.equals(paramPublicAccount.mSelectedCategory));
          }
          else
            while (paramPublicAccount.mSelectedCategory != null)
            {
              k = av.e(k, 512);
              if (1 != paramInt)
                break;
              return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
            }
          while (true)
          {
            if (this.mSelectedSubcategory != null)
            {
              if (this.mSelectedSubcategory.equals(paramPublicAccount.mSelectedSubcategory));
            }
            else
              while (paramPublicAccount.mSelectedSubcategory != null)
              {
                k = av.e(k, 512);
                if (1 != paramInt)
                  break;
                return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
              }
            while (true)
            {
              if (this.mIcon != null)
              {
                if (this.mIcon.equals(paramPublicAccount.mIcon));
              }
              else
                while (paramPublicAccount.mIcon != null)
                {
                  k = av.e(k, 2);
                  if (1 != paramInt)
                    break;
                  return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                }
              while (true)
              {
                if (this.mTagLines != null)
                {
                  if (this.mTagLines.equals(paramPublicAccount.mTagLines));
                }
                else
                  while (paramPublicAccount.mTagLines != null)
                  {
                    k = av.e(k, 8);
                    if (1 != paramInt)
                      break;
                    return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                  }
                while (true)
                {
                  if (this.mLocation != null)
                  {
                    if (this.mLocation.equals(paramPublicAccount.mLocation));
                  }
                  else
                    while (paramPublicAccount.mLocation != null)
                    {
                      k = av.e(k, 32);
                      if (1 != paramInt)
                        break;
                      return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                    }
                  while (true)
                  {
                    if (this.mWebsite != null)
                    {
                      if (this.mWebsite.equals(paramPublicAccount.mWebsite));
                    }
                    else
                      while (paramPublicAccount.mWebsite != null)
                      {
                        k = av.e(k, 4096);
                        if (1 != paramInt)
                          break;
                        return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                      }
                    while (true)
                    {
                      if (this.mEmail != null)
                      {
                        if (this.mEmail.equals(paramPublicAccount.mEmail));
                      }
                      else
                        while (paramPublicAccount.mEmail != null)
                        {
                          k = av.e(k, 8192);
                          if (1 != paramInt)
                            break;
                          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                        }
                      while (true)
                      {
                        if (this.mGroupUri != null)
                        {
                          if (this.mGroupUri.equals(paramPublicAccount.mGroupUri));
                        }
                        else
                          while (paramPublicAccount.mGroupUri != null)
                          {
                            if (1 != paramInt)
                              break;
                            return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                          }
                        while (true)
                        {
                          if (this.mAddressString != null)
                          {
                            if (this.mAddressString.equals(paramPublicAccount.mAddressString));
                          }
                          else
                            while (paramPublicAccount.mAddressString != null)
                            {
                              if (1 != paramInt)
                                break;
                              return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                            }
                          while (true)
                          {
                            if (!this.mBackground.equals(paramPublicAccount.mBackground))
                            {
                              k = av.e(k, 4);
                              if (1 == paramInt)
                                return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                              bool = true;
                            }
                            if (this.mCountryCode != null)
                            {
                              if (this.mCountryCode.equals(paramPublicAccount.mCountryCode));
                            }
                            else
                              while (paramPublicAccount.mCountryCode != null)
                              {
                                k = av.e(k, 64);
                                if (1 != paramInt)
                                  break;
                                return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                              }
                            while (true)
                            {
                              if (!Arrays.equals(this.mTags, paramPublicAccount.mTags))
                              {
                                k = av.e(k, 16);
                                if (1 == paramInt)
                                  return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                bool = true;
                              }
                              if (this.mAuthToken != null)
                              {
                                if (this.mAuthToken.equals(paramPublicAccount.mAuthToken));
                              }
                              else
                                while (paramPublicAccount.mAuthToken != null)
                                {
                                  k = av.e(k, 32768);
                                  if (1 != paramInt)
                                    break;
                                  return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                }
                              while (true)
                              {
                                if (this.mCrm != null)
                                {
                                  if (this.mCrm.equals(paramPublicAccount.mCrm));
                                }
                                else
                                  while (paramPublicAccount.mCrm != null)
                                  {
                                    k = av.e(k, 2048);
                                    if (1 != paramInt)
                                      break;
                                    return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                  }
                                while (true)
                                {
                                  if (this.mExtraInfoJson != null)
                                  {
                                    if (this.mExtraInfoJson.equals(paramPublicAccount.mExtraInfoJson));
                                  }
                                  else
                                    while (paramPublicAccount.mExtraInfoJson != null)
                                    {
                                      k = av.e(k, 16384);
                                      if (1 != paramInt)
                                        break;
                                      return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                    }
                                  while (true)
                                  {
                                    if ((this.mExtraInfoJson == null) && (paramPublicAccount.mExtraInfoJson == null) && ((this.mExtraInfo != null) || (paramPublicAccount.mExtraInfo != null)))
                                    {
                                      ExtraInfo localExtraInfo = this.mExtraInfo;
                                      if (localExtraInfo != null)
                                      {
                                        if (localExtraInfo.equals(paramPublicAccount.mExtraInfo));
                                      }
                                      else
                                        while (paramPublicAccount.mExtraInfo != null)
                                        {
                                          k = av.e(k, 16384);
                                          if (1 != paramInt)
                                            break;
                                          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                        }
                                    }
                                    while (true)
                                    {
                                      if (!this.mGlobalPermissions.equals(paramPublicAccount.mGlobalPermissions))
                                      {
                                        if (1 == paramInt)
                                          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                        bool = true;
                                      }
                                      if (this.mMySettingsJson != null)
                                      {
                                        if (this.mMySettingsJson.equals(paramPublicAccount.mMySettingsJson));
                                      }
                                      else
                                        while (paramPublicAccount.mMySettingsJson != null)
                                        {
                                          if (1 != paramInt)
                                            break;
                                          return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                        }
                                      while (true)
                                      {
                                        if ((this.mMySettingsJson == null) && (paramPublicAccount.mMySettingsJson == null) && ((this.mMySettings != null) || (paramPublicAccount.mMySettings != null)) && ((this.mMySettings == null) || (!this.mMySettings.equals(paramPublicAccount.mMySettings))))
                                        {
                                          if (1 == paramInt)
                                            return Pair.create(Boolean.valueOf(true), Integer.valueOf(k));
                                          bool = true;
                                        }
                                        return Pair.create(Boolean.valueOf(bool), Integer.valueOf(k));
                                        bool = true;
                                      }
                                      bool = true;
                                    }
                                    bool = true;
                                  }
                                  bool = true;
                                }
                                bool = true;
                              }
                              bool = true;
                            }
                            bool = true;
                          }
                          bool = true;
                        }
                        bool = true;
                      }
                      bool = true;
                    }
                    bool = true;
                  }
                  bool = true;
                }
                bool = true;
              }
              bool = true;
            }
            bool = true;
          }
          bool = true;
        }
        bool = true;
      }
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public int diffBetweenAttributesChangedFlags(PublicAccount paramPublicAccount)
  {
    return ((Integer)diff(paramPublicAccount, 0).second).intValue();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    if (!((Boolean)diff((PublicAccount)paramObject, 1).first).booleanValue());
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equalsBetweenAttributesChangedFlags(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    if (((Integer)diff((PublicAccount)paramObject, 0).second).intValue() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String getAdressString()
  {
    return this.mAddressString;
  }

  public String getAuthToken()
  {
    return this.mAuthToken;
  }

  public Background getBackground()
  {
    return this.mBackground;
  }

  public String getCategoryId()
  {
    if (this.mSelectedCategory != null)
      return this.mSelectedCategory.mId;
    return "";
  }

  public String getCategoryName()
  {
    if (this.mSelectedCategory != null)
      return this.mSelectedCategory.mName;
    return "";
  }

  public String getChatBackground()
  {
    return this.mChatBackground;
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public String getCountryCode()
  {
    return this.mCountryCode;
  }

  public CrmItem getCrm()
  {
    return this.mCrm;
  }

  public String getEmail()
  {
    return this.mEmail;
  }

  public int getExtraFlags()
  {
    return this.mExtraFlags;
  }

  public ExtraInfo getExtraInfo()
  {
    if ((this.mExtraInfo == null) && (!TextUtils.isEmpty(this.mExtraInfoJson)))
      this.mExtraInfo = ExtraInfo.fromExtraInfoJson(this.mExtraInfoJson);
    return this.mExtraInfo;
  }

  public String getExtraInfoJson()
  {
    if ((TextUtils.isEmpty(this.mExtraInfoJson)) && (this.mExtraInfo != null))
      this.mExtraInfoJson = this.mExtraInfo.toJson();
    return this.mExtraInfoJson;
  }

  public int getFlags()
  {
    return this.mFlags;
  }

  public GlobalPermissions getGlobalPermissions()
  {
    return this.mGlobalPermissions;
  }

  public long getGroupID()
  {
    return this.mGroupID;
  }

  public int getGroupRole()
  {
    return this.mGroupRole;
  }

  public String getGroupUri()
  {
    return this.mGroupUri;
  }

  public Uri getIcon()
  {
    return this.mIcon;
  }

  public ObjectId getIconObjectId()
  {
    return this.mIconObjectId;
  }

  public int getLastMessageId()
  {
    return this.mLastMessageId;
  }

  public LocationInfo getLocation()
  {
    return this.mLocation;
  }

  public int getMediaCount()
  {
    return this.mMediaCount;
  }

  public MyCommunitySettings getMySettings()
  {
    if ((this.mMySettings == null) && (!TextUtils.isEmpty(this.mMySettingsJson)))
      this.mMySettings = ((MyCommunitySettings)com.viber.voip.flatbuffers.b.e.e().a().a(this.mMySettingsJson));
    return this.mMySettings;
  }

  public String getMySettingsJson()
  {
    if ((TextUtils.isEmpty(this.mMySettingsJson)) && (this.mMySettings != null))
      this.mMySettingsJson = com.viber.voip.flatbuffers.b.e.e().b().a(this.mMySettings);
    return this.mMySettingsJson;
  }

  public String getName()
  {
    return this.mName;
  }

  public String getPublicAccountId()
  {
    return this.mPublicAccountId;
  }

  public int getPublicGroupType()
  {
    if (hasPublicChat())
      return this.mPublicGroupType;
    return -1;
  }

  public int getRevision()
  {
    return this.mRevision;
  }

  public String getSubCategoryId()
  {
    if (this.mSelectedSubcategory != null)
      return this.mSelectedSubcategory.mId;
    return "";
  }

  public String getSubcategoryName()
  {
    if (this.mSelectedSubcategory != null)
      return this.mSelectedSubcategory.mName;
    return "";
  }

  public int getSubscribersCount()
  {
    return this.mSubscribersCount;
  }

  public String getTagLines()
  {
    return this.mTagLines;
  }

  public String[] getTags()
  {
    return this.mTags;
  }

  public int getWatchersCount()
  {
    return this.mWatchersCount;
  }

  public String getWebsite()
  {
    return this.mWebsite;
  }

  public boolean hasPublicChat()
  {
    return !av.d(getFlags(), 16384);
  }

  public boolean hasSubscription()
  {
    return this.mSubscriptionExists;
  }

  public boolean isAgeRestricted()
  {
    return av.d(this.mFlags, 32);
  }

  public boolean isCommunityBlocked()
  {
    return av.d(this.mFlags, 134217728);
  }

  public boolean isDisplayInvitationLink()
  {
    return this.mDisplayInvitationLink;
  }

  public boolean isMute()
  {
    return this.mIsMute;
  }

  public boolean isNotShareable()
  {
    return av.d(this.mFlags, 1048576);
  }

  public boolean isPendingRole()
  {
    return av.c(this.mExtraFlags, 0);
  }

  public boolean isPublished()
  {
    return !av.d(this.mFlags, 4);
  }

  public boolean isSmartNotificationsOn()
  {
    return this.mIsSmartNotificationsOn;
  }

  public boolean isVerified()
  {
    return av.d(this.mFlags, 1);
  }

  public boolean isWebhookExists()
  {
    return this.mWebhookExists;
  }

  public void setAdressString(String paramString)
  {
    this.mAddressString = paramString;
  }

  public void setAgeRestricted(boolean paramBoolean)
  {
    this.mFlags = av.b(this.mFlags, 32, paramBoolean);
  }

  public void setAuthToken(String paramString)
  {
    this.mAuthToken = paramString;
  }

  public void setBackground(Background paramBackground)
  {
    this.mBackground = paramBackground;
  }

  public void setChatBackground(String paramString)
  {
    this.mChatBackground = paramString;
  }

  public void setConversationId(long paramLong)
  {
    this.mConversationId = paramLong;
  }

  public void setCountryCode(String paramString)
  {
    this.mCountryCode = paramString;
  }

  public void setCrm(CrmItem paramCrmItem)
  {
    this.mCrm = paramCrmItem;
  }

  public void setDisplayInvitationLink(boolean paramBoolean)
  {
    this.mDisplayInvitationLink = paramBoolean;
  }

  public void setEmail(String paramString)
  {
    this.mEmail = paramString;
  }

  public void setExtraFlags(int paramInt)
  {
    this.mExtraFlags = paramInt;
  }

  public void setExtraInfo(ExtraInfo paramExtraInfo)
  {
    this.mExtraInfo = paramExtraInfo;
  }

  public void setFlags(int paramInt)
  {
    this.mFlags = paramInt;
  }

  public void setGlobalPermissions(long paramLong)
  {
    this.mGlobalPermissions = new GlobalPermissions(paramLong);
  }

  public void setGroupID(long paramLong)
  {
    this.mGroupID = paramLong;
  }

  public void setGroupRole(int paramInt)
  {
    this.mGroupRole = paramInt;
  }

  public void setGroupUri(String paramString)
  {
    this.mGroupUri = paramString;
  }

  public void setIcon(Uri paramUri)
  {
    this.mIcon = paramUri;
  }

  public void setIconObjectId(ObjectId paramObjectId)
  {
    this.mIconObjectId = paramObjectId;
  }

  public void setIsPublished(boolean paramBoolean)
  {
    int i = this.mFlags;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.mFlags = av.b(i, 4, bool);
      return;
    }
  }

  public void setLastMessageId(int paramInt)
  {
    this.mLastMessageId = paramInt;
  }

  public void setLocation(LocationInfo paramLocationInfo)
  {
    this.mLocation = paramLocationInfo;
  }

  public void setMediaCount(int paramInt)
  {
    this.mMediaCount = paramInt;
  }

  public void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void setPublicAccountId(String paramString)
  {
    this.mPublicAccountId = paramString;
  }

  public void setPublicGroupType(int paramInt)
  {
    this.mPublicGroupType = paramInt;
  }

  public void setRevision(int paramInt)
  {
    this.mRevision = paramInt;
  }

  public void setSelectedCategory(String paramString1, String paramString2)
  {
    if (paramString1 != null)
      if (paramString2 == null)
        break label29;
    while (true)
    {
      this.mSelectedCategory = new CategoryItem(paramString1, paramString2);
      return;
      paramString1 = "";
      break;
      label29: paramString2 = "";
    }
  }

  public void setSelectedSubcategory(String paramString1, String paramString2)
  {
    if (paramString1 != null)
      if (paramString2 == null)
        break label29;
    while (true)
    {
      this.mSelectedSubcategory = new CategoryItem(paramString1, paramString2);
      return;
      paramString1 = "";
      break;
      label29: paramString2 = "";
    }
  }

  public void setSmartNotificationsOn(boolean paramBoolean)
  {
    this.mIsSmartNotificationsOn = paramBoolean;
  }

  public void setSubscribersCount(int paramInt)
  {
    this.mSubscribersCount = paramInt;
  }

  public void setSubscriptionExists(boolean paramBoolean)
  {
    this.mSubscriptionExists = paramBoolean;
  }

  public void setTagLines(String paramString)
  {
    this.mTagLines = paramString;
  }

  public void setTags(String[] paramArrayOfString)
  {
    this.mTags = paramArrayOfString;
  }

  public void setWatchersCount(int paramInt)
  {
    this.mWatchersCount = paramInt;
  }

  public void setWebhookExists(boolean paramBoolean)
  {
    this.mWebhookExists = paramBoolean;
  }

  public void setWebsite(String paramString)
  {
    this.mWebsite = paramString;
  }

  public boolean shouldShowNotPublishedPublicAccountBanner()
  {
    return (av.d(this.mFlags, 4)) && (2 == getGroupRole());
  }

  public String toString()
  {
    return "PublicAccount{mConversationId='" + this.mConversationId + '\'' + "mPublicAccountId='" + this.mPublicAccountId + '\'' + ", mName='" + this.mName + '\'' + ", mCategory='" + this.mSelectedCategory + '\'' + ", mSubCategory='" + this.mSelectedSubcategory + '\'' + ", mIcon=" + this.mIcon + ", mTagLines='" + this.mTagLines + '\'' + ", mLocation=" + this.mLocation + ", mLocationAdress" + this.mAddressString + '\'' + ", mWebsite='" + this.mWebsite + '\'' + ", mEmail='" + this.mEmail + '\'' + ", mIsSmartNotificationsOn=" + this.mIsSmartNotificationsOn + ", mIsMute=" + this.mIsMute + ", mPublicGroupType=" + this.mPublicGroupType + ", mGroupID=" + this.mGroupID + ", mRevision=" + this.mRevision + ", mGroupUri='" + this.mGroupUri + '\'' + ", mBackground='" + this.mBackground + '\'' + ", mCountryCode='" + this.mCountryCode + '\'' + ", mGroupRole=" + this.mGroupRole + ", mTags=" + Arrays.toString(this.mTags) + ", mLastMessageId=" + this.mLastMessageId + ", mFlags=" + this.mFlags + ", mExtraFlags=" + this.mExtraFlags + ", mWatchersCount=" + this.mWatchersCount + ", mMediaCount=" + this.mMediaCount + ", mSubscribersCount=" + this.mSubscribersCount + ", mAuthToken='" + this.mAuthToken + '\'' + ", mWebhookExists=" + this.mWebhookExists + ", mSubscriptionStatus=" + this.mSubscriptionExists + ", mCrm=" + this.mCrm + ", mExtraInfoJson=" + this.mExtraInfoJson + ", mExtraInfo=" + this.mExtraInfo + ", mDisplayInvitationLink=" + this.mDisplayInvitationLink + ", mMySettingsJson=" + this.mMySettingsJson + ", mMySettings=" + this.mMySettings + '}';
  }

  public void updateYourChatSolutionData(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.mAuthToken = paramPublicGroupConversationItemLoaderEntity.getPublicAccountAuthToken();
    if (!TextUtils.isEmpty(paramPublicGroupConversationItemLoaderEntity.getCrm()));
    for (CrmItem localCrmItem = new CrmItem(paramPublicGroupConversationItemLoaderEntity.getCrm()); ; localCrmItem = null)
    {
      this.mCrm = localCrmItem;
      return;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeString(this.mPublicAccountId);
    paramParcel.writeString(this.mName);
    paramParcel.writeParcelable(this.mSelectedCategory, paramInt);
    paramParcel.writeParcelable(this.mSelectedSubcategory, paramInt);
    paramParcel.writeParcelable(this.mIcon, paramInt);
    paramParcel.writeString(this.mTagLines);
    paramParcel.writeParcelable(this.mLocation, paramInt);
    paramParcel.writeString(this.mAddressString);
    paramParcel.writeString(this.mWebsite);
    paramParcel.writeString(this.mEmail);
    byte b2;
    byte b3;
    label120: byte b4;
    label257: byte b5;
    if (this.mIsSmartNotificationsOn)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIsMute)
        break label350;
      b3 = b1;
      paramParcel.writeByte(b3);
      paramParcel.writeInt(this.mPublicGroupType);
      paramParcel.writeLong(this.mGroupID);
      paramParcel.writeInt(this.mRevision);
      paramParcel.writeString(this.mGroupUri);
      paramParcel.writeParcelable(this.mBackground, paramInt);
      paramParcel.writeString(this.mCountryCode);
      paramParcel.writeInt(this.mGroupRole);
      paramParcel.writeStringArray(this.mTags);
      paramParcel.writeInt(this.mLastMessageId);
      paramParcel.writeInt(this.mFlags);
      paramParcel.writeInt(this.mExtraFlags);
      paramParcel.writeInt(this.mWatchersCount);
      paramParcel.writeInt(this.mMediaCount);
      paramParcel.writeInt(this.mSubscribersCount);
      paramParcel.writeString(this.mAuthToken);
      if (!this.mWebhookExists)
        break label356;
      b4 = b1;
      paramParcel.writeByte(b4);
      if (!this.mSubscriptionExists)
        break label362;
      b5 = b1;
      label273: paramParcel.writeByte(b5);
      paramParcel.writeParcelable(this.mCrm, paramInt);
      paramParcel.writeParcelable(this.mExtraInfo, paramInt);
      paramParcel.writeString(this.mExtraInfoJson);
      paramParcel.writeParcelable(this.mGlobalPermissions, paramInt);
      if (!this.mDisplayInvitationLink)
        break label368;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.mMySettings, paramInt);
      paramParcel.writeString(this.mMySettingsJson);
      return;
      b2 = 0;
      break;
      label350: b3 = 0;
      break label120;
      label356: b4 = 0;
      break label257;
      label362: b5 = 0;
      break label273;
      label368: b1 = 0;
    }
  }

  public static class Background
    implements Parcelable
  {
    public static final Parcelable.Creator<Background> CREATOR = new Parcelable.Creator()
    {
      public PublicAccount.Background a(Parcel paramAnonymousParcel)
      {
        return new PublicAccount.Background(paramAnonymousParcel);
      }

      public PublicAccount.Background[] a(int paramAnonymousInt)
      {
        return new PublicAccount.Background[paramAnonymousInt];
      }
    };
    private String mId;
    private ObjectId mObjectId;
    private String mUri;

    protected Background(Parcel paramParcel)
    {
      this.mId = paramParcel.readString();
      this.mUri = paramParcel.readString();
    }

    public Background(Background paramBackground)
    {
      this.mId = paramBackground.mId;
      this.mUri = paramBackground.mUri;
    }

    public Background(String paramString1, String paramString2)
    {
      this.mId = paramString1;
      this.mUri = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Background localBackground;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localBackground = (Background)paramObject;
        if (this.mId != null)
        {
          if (this.mId.equals(localBackground.mId));
        }
        else
          while (localBackground.mId != null)
            return false;
        if (this.mUri != null)
          return this.mUri.equals(localBackground.mUri);
      }
      while (localBackground.mUri == null);
      return false;
    }

    public String getId()
    {
      return this.mId;
    }

    public ObjectId getObjectId()
    {
      return this.mObjectId;
    }

    public String getUri()
    {
      return this.mUri;
    }

    public int hashCode()
    {
      if (this.mId != null);
      for (int i = this.mId.hashCode(); ; i = 0)
      {
        int j = i * 31;
        String str = this.mUri;
        int k = 0;
        if (str != null)
          k = this.mUri.hashCode();
        return j + k;
      }
    }

    public boolean isChosen()
    {
      return (!TextUtils.isEmpty(this.mId)) && (!TextUtils.isEmpty(this.mUri));
    }

    public boolean needToDownloadFromServer()
    {
      return (!TextUtils.isEmpty(this.mId)) && (TextUtils.isEmpty(this.mUri));
    }

    public boolean needUploadToServer()
    {
      return (TextUtils.isEmpty(this.mId)) && (!TextUtils.isEmpty(this.mUri));
    }

    public void setObjectId(ObjectId paramObjectId)
    {
      this.mObjectId = paramObjectId;
    }

    public String toString()
    {
      return "Background{mId='" + this.mId + '\'' + ", mUri='" + this.mUri + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mId);
      paramParcel.writeString(this.mUri);
    }
  }

  public static class CategoryItem
    implements Parcelable
  {
    public static final Parcelable.Creator<CategoryItem> CREATOR = new Parcelable.Creator()
    {
      public PublicAccount.CategoryItem a(Parcel paramAnonymousParcel)
      {
        return new PublicAccount.CategoryItem(paramAnonymousParcel);
      }

      public PublicAccount.CategoryItem[] a(int paramAnonymousInt)
      {
        return new PublicAccount.CategoryItem[paramAnonymousInt];
      }
    };
    private String mId;
    private String mName;

    protected CategoryItem(Parcel paramParcel)
    {
      this.mId = paramParcel.readString();
      this.mName = paramParcel.readString();
    }

    public CategoryItem(CategoryItem paramCategoryItem)
    {
      this.mId = paramCategoryItem.mId;
      this.mName = paramCategoryItem.mName;
    }

    public CategoryItem(String paramString1, String paramString2)
    {
      this.mId = paramString1;
      this.mName = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      CategoryItem localCategoryItem;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localCategoryItem = (CategoryItem)paramObject;
        if (this.mId != null)
        {
          if (this.mId.equals(localCategoryItem.mId));
        }
        else
          while (localCategoryItem.mId != null)
            return false;
        if (this.mName != null)
          return this.mName.equals(localCategoryItem.mName);
      }
      while (localCategoryItem.mName == null);
      return false;
    }

    public String getId()
    {
      return this.mId;
    }

    public String getName()
    {
      return this.mName;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mId);
      paramParcel.writeString(this.mName);
    }
  }

  public static final class ExtraInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ExtraInfo> CREATOR = new Parcelable.Creator()
    {
      public PublicAccount.ExtraInfo a(Parcel paramAnonymousParcel)
      {
        return new PublicAccount.ExtraInfo(paramAnonymousParcel);
      }

      public PublicAccount.ExtraInfo[] a(int paramAnonymousInt)
      {
        return new PublicAccount.ExtraInfo[paramAnonymousInt];
      }
    };
    private static final Logger L = ViberEnv.getLogger();
    public static final int MAX_JOKER_BUTTONS_COUNT = 4;

    @c(a="invitationLink")
    private String mInvitationLink;

    @c(a="invitationToken")
    private long mInvitationToken;

    @c(a="joker_buttons")
    private JokerButton[] mJokerButtons;

    @c(a="participantsCount")
    private Integer mParticipantsCount;

    public ExtraInfo()
    {
    }

    ExtraInfo(Parcel paramParcel)
    {
      this.mJokerButtons = ((JokerButton[])paramParcel.createTypedArray(JokerButton.CREATOR));
      this.mInvitationLink = paramParcel.readString();
      this.mParticipantsCount = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }

    public static ExtraInfo fromExtraInfoJson(String paramString)
    {
      try
      {
        ExtraInfo localExtraInfo = (ExtraInfo)new f().a(paramString, ExtraInfo.class);
        return localExtraInfo;
      }
      catch (u localu)
      {
      }
      return null;
    }

    static ExtraInfo fromIm2JokerButtons(com.viber.jni.im2.JokerButton[] paramArrayOfJokerButton)
    {
      Object localObject = null;
      if (paramArrayOfJokerButton != null)
      {
        int i = paramArrayOfJokerButton.length;
        localObject = null;
        if (i > 0)
        {
          ExtraInfo localExtraInfo = new ExtraInfo();
          JokerButton[] arrayOfJokerButton = new JokerButton[paramArrayOfJokerButton.length];
          for (int j = 0; j < paramArrayOfJokerButton.length; j++)
            arrayOfJokerButton[j] = new JokerButton(paramArrayOfJokerButton[j].toLegacyJokerButton());
          localExtraInfo.setJokerButtons(arrayOfJokerButton);
          localObject = localExtraInfo;
        }
      }
      return localObject;
    }

    static ExtraInfo fromJniJokerButtons(com.viber.jni.JokerButton[] paramArrayOfJokerButton, ExtraInfo paramExtraInfo)
    {
      if ((paramArrayOfJokerButton != null) && (paramArrayOfJokerButton.length > 0))
      {
        if (paramExtraInfo == null)
          paramExtraInfo = new ExtraInfo();
        JokerButton[] arrayOfJokerButton = new JokerButton[paramArrayOfJokerButton.length];
        for (int i = 0; i < paramArrayOfJokerButton.length; i++)
          arrayOfJokerButton[i] = new JokerButton(paramArrayOfJokerButton[i]);
        paramExtraInfo.setJokerButtons(arrayOfJokerButton);
      }
      return paramExtraInfo;
    }

    private void setJokerButtons(JokerButton[] paramArrayOfJokerButton)
    {
      this.mJokerButtons = paramArrayOfJokerButton;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      ExtraInfo localExtraInfo;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localExtraInfo = (ExtraInfo)paramObject;
        if (!Arrays.equals(this.mJokerButtons, localExtraInfo.mJokerButtons))
          return false;
        if (!TextUtils.equals(this.mInvitationLink, localExtraInfo.mInvitationLink))
          return false;
      }
      while (ca.b(this.mParticipantsCount, localExtraInfo.mParticipantsCount));
      return false;
    }

    public String getInvitationLink()
    {
      return this.mInvitationLink;
    }

    public long getInvitationToken()
    {
      return this.mInvitationToken;
    }

    public JokerButton[] getJokerButtons()
    {
      return this.mJokerButtons;
    }

    public Integer getParticipantsCount()
    {
      return this.mParticipantsCount;
    }

    public int hashCode()
    {
      int i = 31 * Arrays.hashCode(this.mJokerButtons);
      if (this.mInvitationLink != null);
      for (int j = this.mInvitationLink.hashCode(); ; j = 0)
      {
        int k = 31 * (j + i);
        Integer localInteger = this.mParticipantsCount;
        int m = 0;
        if (localInteger != null)
          m = this.mParticipantsCount.intValue();
        return k + m;
      }
    }

    public void setInvitationLink(String paramString)
    {
      this.mInvitationLink = paramString;
    }

    public void setInvitationToken(long paramLong)
    {
      this.mInvitationToken = paramLong;
    }

    public void setParticipantsCount(Integer paramInteger)
    {
      this.mParticipantsCount = paramInteger;
    }

    public String toJson()
    {
      return new f().b(this);
    }

    public String toString()
    {
      return "ExtraInfo{mInvitationLink='" + this.mInvitationLink + '\'' + ", mInvitationToken=" + this.mInvitationToken + ", mParticipantsCount=" + this.mParticipantsCount + ", mJokerButtons=" + Arrays.toString(this.mJokerButtons) + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeTypedArray(this.mJokerButtons, paramInt);
      paramParcel.writeString(this.mInvitationLink);
      paramParcel.writeValue(this.mParticipantsCount);
    }

    public static class JokerButton
      implements Parcelable
    {
      public static final Parcelable.Creator<JokerButton> CREATOR = new Parcelable.Creator()
      {
        public PublicAccount.ExtraInfo.JokerButton a(Parcel paramAnonymousParcel)
        {
          return new PublicAccount.ExtraInfo.JokerButton(paramAnonymousParcel);
        }

        public PublicAccount.ExtraInfo.JokerButton[] a(int paramAnonymousInt)
        {
          return new PublicAccount.ExtraInfo.JokerButton[paramAnonymousInt];
        }
      };

      @c(a="action")
      private Action mAction;

      @c(a="button_text")
      private String mButtonText;

      @c(a="icon_url")
      private String mIconUrl;

      JokerButton()
      {
      }

      JokerButton(Parcel paramParcel)
      {
        this.mIconUrl = paramParcel.readString();
        this.mAction = ((Action)paramParcel.readParcelable(Action.class.getClassLoader()));
        this.mButtonText = paramParcel.readString();
      }

      JokerButton(com.viber.jni.JokerButton paramJokerButton)
      {
        this.mIconUrl = paramJokerButton.getIconUrl();
        this.mButtonText = paramJokerButton.getButtonTxt();
        String str = paramJokerButton.getAction();
        if (!TextUtils.isEmpty(str));
        try
        {
          this.mAction = ((Action)new f().a(str, Action.class));
          return;
        }
        catch (m localm)
        {
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
        catch (u localu)
        {
        }
      }

      public int describeContents()
      {
        return 0;
      }

      public boolean equals(Object paramObject)
      {
        boolean bool1 = true;
        boolean bool2;
        if (this == paramObject)
          bool2 = bool1;
        JokerButton localJokerButton;
        boolean bool3;
        do
        {
          boolean bool4;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool2;
                bool2 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool2 = false;
            }
            while (localClass1 != localClass2);
            localJokerButton = (JokerButton)paramObject;
            if (this.mIconUrl == null)
              break;
            bool4 = this.mIconUrl.equals(localJokerButton.mIconUrl);
            bool2 = false;
          }
          while (!bool4);
          if (this.mAction == null)
            break label132;
          bool3 = this.mAction.equals(localJokerButton.mAction);
          bool2 = false;
        }
        while (!bool3);
        label100: if (this.mButtonText != null)
          bool1 = this.mButtonText.equals(localJokerButton.mButtonText);
        while (true)
        {
          return bool1;
          if (localJokerButton.mIconUrl == null)
            break;
          return false;
          label132: if (localJokerButton.mAction == null)
            break label100;
          return false;
          if (localJokerButton.mButtonText != null)
            bool1 = false;
        }
      }

      public Action getAction()
      {
        return this.mAction;
      }

      public String getButtonText()
      {
        return this.mButtonText;
      }

      public String getIconUrl()
      {
        return this.mIconUrl;
      }

      public int hashCode()
      {
        int i;
        int j;
        if (this.mIconUrl != null)
        {
          i = this.mIconUrl.hashCode();
          j = i * 31;
          if (this.mAction == null)
            break label77;
        }
        label77: for (int k = this.mAction.hashCode(); ; k = 0)
        {
          int m = 31 * (k + j);
          String str = this.mButtonText;
          int n = 0;
          if (str != null)
            n = this.mButtonText.hashCode();
          return m + n;
          i = 0;
          break;
        }
      }

      public String toString()
      {
        return "JokerButton{mIconUrl='" + this.mIconUrl + '\'' + ", mAction=" + this.mAction + ", mButtonText='" + this.mButtonText + '\'' + '}';
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.mIconUrl);
        paramParcel.writeParcelable(this.mAction, paramInt);
        paramParcel.writeString(this.mButtonText);
      }

      public static class Action
        implements Parcelable
      {
        public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator()
        {
          public PublicAccount.ExtraInfo.JokerButton.Action a(Parcel paramAnonymousParcel)
          {
            return new PublicAccount.ExtraInfo.JokerButton.Action(paramAnonymousParcel);
          }

          public PublicAccount.ExtraInfo.JokerButton.Action[] a(int paramAnonymousInt)
          {
            return new PublicAccount.ExtraInfo.JokerButton.Action[paramAnonymousInt];
          }
        };
        private static final String TYPE_APP = "app";
        private static final String TYPE_WEB = "web";

        @c(a="bundle_id")
        private String mBundleId;

        @c(a="package_name")
        private String mPackageName;

        @c(a="type")
        private String mType;

        @c(a="url_scheme")
        private String mUrl;

        Action()
        {
        }

        protected Action(Parcel paramParcel)
        {
          this.mType = paramParcel.readString();
          this.mBundleId = paramParcel.readString();
          this.mPackageName = paramParcel.readString();
          this.mUrl = paramParcel.readString();
        }

        public int describeContents()
        {
          return 0;
        }

        public boolean equals(Object paramObject)
        {
          boolean bool1 = true;
          boolean bool2;
          if (this == paramObject)
            bool2 = bool1;
          Action localAction;
          label100: boolean bool3;
          do
          {
            boolean bool4;
            do
            {
              boolean bool5;
              do
              {
                Class localClass1;
                Class localClass2;
                do
                {
                  do
                  {
                    return bool2;
                    bool2 = false;
                  }
                  while (paramObject == null);
                  localClass1 = getClass();
                  localClass2 = paramObject.getClass();
                  bool2 = false;
                }
                while (localClass1 != localClass2);
                localAction = (Action)paramObject;
                if (this.mType == null)
                  break;
                bool5 = this.mType.equals(localAction.mType);
                bool2 = false;
              }
              while (!bool5);
              if (this.mBundleId == null)
                break label160;
              bool4 = this.mBundleId.equals(localAction.mBundleId);
              bool2 = false;
            }
            while (!bool4);
            if (this.mPackageName == null)
              break label170;
            bool3 = this.mPackageName.equals(localAction.mPackageName);
            bool2 = false;
          }
          while (!bool3);
          label128: if (this.mUrl != null)
            bool1 = this.mUrl.equals(localAction.mUrl);
          while (true)
          {
            return bool1;
            if (localAction.mType == null)
              break;
            return false;
            label160: if (localAction.mBundleId == null)
              break label100;
            return false;
            label170: if (localAction.mPackageName == null)
              break label128;
            return false;
            if (localAction.mUrl != null)
              bool1 = false;
          }
        }

        public String getPackageName()
        {
          return this.mPackageName;
        }

        public String getUrl()
        {
          return this.mUrl;
        }

        public int hashCode()
        {
          int i;
          int k;
          label35: int m;
          if (this.mType != null)
          {
            i = this.mType.hashCode();
            int j = i * 31;
            if (this.mBundleId == null)
              break label103;
            k = this.mBundleId.hashCode();
            m = 31 * (k + j);
            if (this.mPackageName == null)
              break label108;
          }
          label103: label108: for (int n = this.mPackageName.hashCode(); ; n = 0)
          {
            int i1 = 31 * (n + m);
            String str = this.mUrl;
            int i2 = 0;
            if (str != null)
              i2 = this.mUrl.hashCode();
            return i1 + i2;
            i = 0;
            break;
            k = 0;
            break label35;
          }
        }

        public boolean isAppType()
        {
          return "app".equals(this.mType);
        }

        public boolean isWebType()
        {
          return "web".equals(this.mType);
        }

        public String toString()
        {
          return "Action{mType='" + this.mType + '\'' + ", mBundleId='" + this.mBundleId + '\'' + ", mPackageName='" + this.mPackageName + '\'' + ", mUrl='" + this.mUrl + '\'' + '}';
        }

        public void writeToParcel(Parcel paramParcel, int paramInt)
        {
          paramParcel.writeString(this.mType);
          paramParcel.writeString(this.mBundleId);
          paramParcel.writeString(this.mPackageName);
          paramParcel.writeString(this.mUrl);
        }
      }
    }
  }

  public static final class GlobalPermissions
    implements Parcelable, com.viber.voip.group.participants.settings.b
  {
    public static final Parcelable.Creator<GlobalPermissions> CREATOR = new Parcelable.Creator()
    {
      public PublicAccount.GlobalPermissions a(Parcel paramAnonymousParcel)
      {
        return new PublicAccount.GlobalPermissions(paramAnonymousParcel);
      }

      public PublicAccount.GlobalPermissions[] a(int paramAnonymousInt)
      {
        return new PublicAccount.GlobalPermissions[paramAnonymousInt];
      }
    };
    private long mGlobalPrivileges;

    public GlobalPermissions()
    {
      this(9223372036854775807L);
    }

    public GlobalPermissions(long paramLong)
    {
      this.mGlobalPrivileges = paramLong;
    }

    protected GlobalPermissions(Parcel paramParcel)
    {
      this.mGlobalPrivileges = paramParcel.readLong();
    }

    public static boolean canWrite(long paramLong)
    {
      return av.a(paramLong, 9223372036854775807L);
    }

    public boolean canWrite()
    {
      return canWrite(this.mGlobalPrivileges);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      GlobalPermissions localGlobalPermissions;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localGlobalPermissions = (GlobalPermissions)paramObject;
      }
      while (this.mGlobalPrivileges == localGlobalPermissions.mGlobalPrivileges);
      return false;
    }

    public long getRawPrivileges()
    {
      return this.mGlobalPrivileges;
    }

    public int hashCode()
    {
      return (int)(this.mGlobalPrivileges ^ this.mGlobalPrivileges >>> 32);
    }

    public void setRawPrivileges(long paramLong)
    {
      this.mGlobalPrivileges = paramLong;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.mGlobalPrivileges);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.entity.PublicAccount
 * JD-Core Version:    0.6.2
 */