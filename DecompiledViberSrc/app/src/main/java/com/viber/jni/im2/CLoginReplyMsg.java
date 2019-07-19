package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CLoginReplyMsg
{
  public final String clientConfiguration;
  public final String encryptedMemberID;
  public final String encryptedPhoneNumber;
  public final Integer extFlags;
  public final Integer flags;
  public final Boolean hasDesktop;
  public final int loginStatus;
  public final CMediaUrlFormatters mediaUrlFormatters;
  public final String memberId;
  public final String newNumber;
  public final String pGEncryptedPhoneNumber;
  public final Integer recommendedVersion;
  public final String spammerBlockStatus;
  public final Integer suggestUpgradeState;
  public final Integer vOGroup;
  public final Integer viberIdVersion;
  public final Boolean vlnSubscription;

  public CLoginReplyMsg(int paramInt)
  {
    this.loginStatus = paramInt;
    this.vOGroup = null;
    this.flags = null;
    this.newNumber = null;
    this.encryptedPhoneNumber = null;
    this.mediaUrlFormatters = null;
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = null;
    this.newNumber = null;
    this.encryptedPhoneNumber = null;
    this.mediaUrlFormatters = null;
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = null;
    this.encryptedPhoneNumber = null;
    this.mediaUrlFormatters = null;
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString);
    this.encryptedPhoneNumber = null;
    this.mediaUrlFormatters = null;
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = null;
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = null;
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = null;
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = null;
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = null;
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = null;
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = null;
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = null;
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = Im2Utils.checkStringValue(paramString6);
    this.hasDesktop = null;
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = Im2Utils.checkStringValue(paramString6);
    this.hasDesktop = Boolean.valueOf(paramBoolean);
    this.viberIdVersion = null;
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt7)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = Im2Utils.checkStringValue(paramString6);
    this.hasDesktop = Boolean.valueOf(paramBoolean);
    this.viberIdVersion = Integer.valueOf(paramInt7);
    this.encryptedMemberID = null;
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt7, String paramString7)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = Im2Utils.checkStringValue(paramString6);
    this.hasDesktop = Boolean.valueOf(paramBoolean);
    this.viberIdVersion = Integer.valueOf(paramInt7);
    this.encryptedMemberID = Im2Utils.checkStringValue(paramString7);
    this.vlnSubscription = null;
    init();
  }

  public CLoginReplyMsg(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, CMediaUrlFormatters paramCMediaUrlFormatters, String paramString3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, int paramInt7, String paramString7, boolean paramBoolean2)
  {
    this.loginStatus = paramInt1;
    this.vOGroup = Integer.valueOf(paramInt2);
    this.flags = Integer.valueOf(paramInt3);
    this.newNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.mediaUrlFormatters = ((CMediaUrlFormatters)Im2Utils.checkStructValue(paramCMediaUrlFormatters));
    this.pGEncryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.extFlags = Integer.valueOf(paramInt4);
    this.suggestUpgradeState = Integer.valueOf(paramInt5);
    this.recommendedVersion = Integer.valueOf(paramInt6);
    this.memberId = Im2Utils.checkStringValue(paramString4);
    this.clientConfiguration = Im2Utils.checkStringValue(paramString5);
    this.spammerBlockStatus = Im2Utils.checkStringValue(paramString6);
    this.hasDesktop = Boolean.valueOf(paramBoolean1);
    this.viberIdVersion = Integer.valueOf(paramInt7);
    this.encryptedMemberID = Im2Utils.checkStringValue(paramString7);
    this.vlnSubscription = Boolean.valueOf(paramBoolean2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CLoginReplyMsg{loginStatus=" + this.loginStatus + ", vOGroup=" + this.vOGroup + ", flags=" + this.flags + ", newNumber='" + this.newNumber + '\'' + ", encryptedPhoneNumber='" + this.encryptedPhoneNumber + '\'' + ", mediaUrlFormatters=" + this.mediaUrlFormatters + ", pGEncryptedPhoneNumber='" + this.pGEncryptedPhoneNumber + '\'' + ", extFlags=" + this.extFlags + ", suggestUpgradeState=" + this.suggestUpgradeState + ", recommendedVersion=" + this.recommendedVersion + ", memberId='" + this.memberId + '\'' + ", clientConfiguration='" + this.clientConfiguration + '\'' + ", spammerBlockStatus='" + this.spammerBlockStatus + '\'' + ", hasDesktop=" + this.hasDesktop + ", viberIdVersion=" + this.viberIdVersion + ", encryptedMemberID='" + this.encryptedMemberID + '\'' + ", vlnSubscription=" + this.vlnSubscription + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EExtFlags
  {
    public static final int FL_DEFAULT_TAB_FEED = 67108864;
    public static final int FL_DISABLE_E2E_SECURITY = 4096;
    public static final int FL_ENABLE_ADS_AFTER_CALL = 134217728;
    public static final int FL_ENABLE_BWS_1 = 8192;
    public static final int FL_ENABLE_FEED_GENERIC = 16777216;
    public static final int FL_ENABLE_FEED_PERSONAL = 33554432;
    public static final int FL_ENABLE_GSM_CALL = 4194304;
    public static final int FL_ENABLE_H264 = 1024;
    public static final int FL_ENABLE_MEDIA_AB_TESTING = 536870912;
    public static final int FL_ENABLE_NEW_INPUT_DESIGN = 268435456;
    public static final int FL_ENABLE_ULPFEC = 65536;
    public static final int FL_ENABLE_VIDEO_NACK = 262144;
    public static final int FL_ENABLE_VOPUS_INBAND_FEC = 32768;
    public static final int FL_ENABLE_VO_REFERRAL_PROGRAM = 8388608;
    public static final int FL_ENABLE_WALLET = 16384;
    public static final int FL_ENABLE_ZFEC = 131072;
    public static final int FL_MIGRATE_TO_MID = 2097152;
    public static final int FL_MIX_PANEL_ON = 512;
    public static final int FL_PUBLIC_CHAT_FULL_BLOCK = 1048576;
    public static final int FL_REPORT_SPAM = 2048;
    public static final int FL_REQUEST_ID_KEY = 256;
    public static final int FL_SENDING_VOIP_PUSH = 524288;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFlags
  {
    public static final int FL_ANIMATED_MESSAGE = 1;
    public static final int FL_APPS_API = 2;
    public static final int FL_MUST_SECURE = 64;
    public static final int FL_MUST_UPGRADE = 32;
    public static final int FL_OPEN_MARKET = 16;
    public static final int FL_PUBLIC_CHAT_FULL = 8;
    public static final int FL_PUBLIC_CHAT_USE_ONLY = 4;
    public static final int FL_SEND_LOCATION = 128;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ELoginReplyType
  {
    public static final int LOGIN_INVALID_VERSION = 4;
    public static final int LOGIN_OK = 0;
    public static final int LOGIN_REJECTED = 5;
    public static final int LOGIN_SERVER_BUSY = 2;
    public static final int LOGIN_TOO_MANY_CLIENTS = 1;
    public static final int LOGIN_USER_NOT_REGISTERED = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EViberOutGroup
  {
    public static final int VO_DISABLED = 0;
    public static final int VO_ENABLED = 1;
    public static final int VO_TRIAL = 3;
    public static final int VO_TRIAL_CALL = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCLoginReplyMsg(CLoginReplyMsg paramCLoginReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CLoginReplyMsg
 * JD-Core Version:    0.6.2
 */