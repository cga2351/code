package com.viber.jni.cdr;

import com.viber.jni.LocationInfo;
import com.viber.voip.news.NewsSession;
import com.viber.voip.news.ViberNewsProviderSpec;

public abstract interface ICdrController
{
  public abstract boolean handleChatsScreenScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);

  public abstract boolean handleClientTrackingReport(int paramInt, String paramString1, String paramString2);

  public abstract boolean handleCommunityView(long paramLong, String paramString, int paramInt);

  public abstract boolean handleReportAdRequestSent(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, int paramInt6);

  public abstract boolean handleReportAdsAfterCallAction(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportAdsAfterCallDisplay(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportAdsClick(long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6);

  public abstract boolean handleReportAdsDisplay(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6);

  public abstract boolean handleReportAnimatedGif(String paramString1, String paramString2);

  public abstract boolean handleReportAppsApprovalPage(int paramInt1, String paramString, int paramInt2);

  public abstract boolean handleReportBackup(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);

  public abstract boolean handleReportBlockedNumberStatistics(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt);

  public abstract boolean handleReportBroadcastSendMessage(long paramLong1, long paramLong2, long paramLong3, long paramLong4);

  public abstract boolean handleReportClickOnRichMessage(int paramInt1, String paramString1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2);

  public abstract boolean handleReportDiscoverScreenSession(long paramLong, int paramInt);

  public abstract boolean handleReportFacebookStatistics(String paramString1, String paramString2, int paramInt);

  public abstract boolean handleReportFavorites(int paramInt1, int paramInt2, int paramInt3);

  public abstract boolean handleReportGameInvitationClicked(int paramInt1, int paramInt2, int paramInt3, String paramString);

  public abstract boolean handleReportGameInvitationDisplayed(int paramInt1, int paramInt2, String paramString);

  public abstract boolean handleReportGameRedirect(int paramInt1, String paramString, int paramInt2);

  public abstract boolean handleReportInstantKeyboardOpen(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);

  public abstract boolean handleReportMakeMobileCall(int paramInt1, int paramInt2, long paramLong);

  public abstract boolean handleReportMediaScreenSend(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4);

  public abstract boolean handleReportPA1On1MessageBotReplied(String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, String paramString5, String paramString6, long paramLong, int paramInt);

  public abstract boolean handleReportPACreationStartAndLeaveProcess(long paramLong1, long paramLong2, int paramInt);

  public abstract boolean handleReportPACreationStartAndLeaveProcess(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, LocationInfo paramLocationInfo, String paramString6, String paramString7, String paramString8, boolean paramBoolean2, int paramInt2);

  public abstract boolean handleReportPAEntering1On1Chat(String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, long paramLong);

  public abstract boolean handleReportPAImpressions(String paramString1, String paramString2, long paramLong1, int paramInt1, String paramString3, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, int paramInt3);

  public abstract boolean handleReportPAInfoScreenDisplay(String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, long paramLong, int paramInt1, int paramInt2);

  public abstract boolean handleReportPAInteractions(String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, long paramLong1, int paramInt1, String paramString5, String paramString6, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, int paramInt3);

  public abstract boolean handleReportPATappingOnWebSite(String paramString1, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, long paramLong, String paramString5, int paramInt);

  public abstract boolean handleReportPinToTop(int paramInt1, int paramInt2, String paramString);

  public abstract boolean handleReportPurchaseStatusStatistics(String paramString1, int paramInt, String paramString2, String paramString3);

  public abstract boolean handleReportScreenAdClick(String paramString);

  public abstract boolean handleReportScreenAdDisplay(String paramString);

  public abstract boolean handleReportScreenDisplay(int paramInt1, int paramInt2);

  public abstract boolean handleReportShareFromStickerProductPage(String paramString1, int paramInt, String paramString2);

  public abstract boolean handleReportShareInvitationNativeMenu(String paramString, int paramInt);

  public abstract boolean handleReportShareNativeMenu(int paramInt1, String paramString, int paramInt2, int paramInt3);

  public abstract boolean handleReportShiftKeyMessageSent(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4);

  public abstract boolean handleReportShiftKeySearch(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3);

  public abstract boolean handleReportStickerClickerClick(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportStickerClickerDisplay(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportStickerMarketEntry(long paramLong1, int paramInt1, int paramInt2, long paramLong2);

  public abstract boolean handleReportStickerMenuExposures(long paramLong, String paramString);

  public abstract boolean handleReportStickerPacksInStrickerMenu(String paramString1, String paramString2);

  public abstract boolean handleReportTermsAndPrivacyPolicy();

  public abstract boolean handleReportUiDisplayedDuringCall(long paramLong1, long paramLong2, long paramLong3);

  public abstract boolean handleReportVOSendCreditScreen(int paramInt);

  public abstract boolean handleReportVOSendInviteScreen(int paramInt);

  public abstract boolean handleReportVersionChecksumChanged(String paramString);

  public abstract boolean handleReportViberNewsSessionAndUrls(int paramInt, NewsSession paramNewsSession);

  public abstract boolean handleReportVideoAdClick(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportVideoAdDisplay(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5);

  public abstract boolean handleReportVoBannerClick(String paramString1, String paramString2, int paramInt);

  public abstract boolean handleReportVoBannerDisplayed(String paramString1, String paramString2);

  public abstract boolean handleReportVoBuy(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3);

  public abstract boolean handleReportVoDisplay(int paramInt);

  public abstract boolean handleReportVoiceMessage(int paramInt1, int paramInt2, int paramInt3);

  public abstract boolean handleReportWalletEntryFrom(String paramString1, int paramInt, String paramString2);

  public abstract boolean handleReportWalletOptIn(String paramString, long paramLong);

  public abstract boolean handleReportWeb(String paramString1, String paramString2, long paramLong);

  public abstract boolean handleReportWesternUnionStatistics();

  public abstract boolean handleViberNewsProviderChanges(ViberNewsProviderSpec paramViberNewsProviderSpec);

  public abstract void setAdvertisingId(String paramString);

  public abstract void setCommunityViewSource(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.ICdrController
 * JD-Core Version:    0.6.2
 */