package com.viber.jni.cdr;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineBackend;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.LocationInfo;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.news.NewsSession;
import com.viber.voip.news.ViberNewsProviderSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class CdrDecorator
  implements ICdrController, ConnectionDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  private CdrController mCdrController;
  private Vector<Runnable> mCdrList = new Vector();
  private volatile boolean mConnected = false;
  private Engine mEngine;

  public CdrDecorator(Engine paramEngine, EngineBackend paramEngineBackend)
  {
    this.mEngine = paramEngine;
    this.mCdrController = new CdrController(paramEngineBackend);
    this.mEngine.getDelegatesManager().getConnectionListener().registerDelegate(new ConnectionDelegate[] { this });
  }

  private void connect()
  {
    if (this.mCdrList.size() == 0);
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList(this.mCdrList);
      this.mCdrList.clear();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
  }

  private void reportCdr(Runnable paramRunnable)
  {
    if (this.mConnected)
    {
      paramRunnable.run();
      return;
    }
    this.mCdrList.add(paramRunnable);
  }

  public boolean handleChatsScreenScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    reportCdr(new CdrDecorator..Lambda.4(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
    return true;
  }

  public boolean handleClientTrackingReport(final int paramInt, final String paramString1, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleClientTrackingReport(paramInt, paramString1, paramString2);
      }
    });
    return true;
  }

  public boolean handleCommunityView(final long paramLong, String paramString, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleCommunityView(paramLong, paramInt, this.val$role);
      }
    });
    return true;
  }

  public boolean handleReportAdRequestSent(final String paramString1, final int paramInt1, final long paramLong, int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString2, final String paramString3, final int paramInt6)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAdRequestSent(paramString1, paramInt1, paramLong, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramInt6, this.val$mediationType);
      }
    });
    return true;
  }

  public boolean handleReportAdsAfterCallAction(final long paramLong1, int paramInt1, final long paramLong2, final int paramInt2, int paramInt3, final String paramString1, final String paramString2, final int paramInt4, final int paramInt5, final int paramInt6, final int paramInt7, final int paramInt8, final String paramString3, final String paramString4, final String paramString5)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAdsAfterCallAction(paramLong1, paramLong2, paramInt2, paramString1, paramString2, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString3, paramString4, paramString5, this.val$adUnitId, this.val$adsSdkVersion);
      }
    });
    return true;
  }

  public boolean handleReportAdsAfterCallDisplay(final long paramLong1, int paramInt1, final long paramLong2, final int paramInt2, String paramString1, final String paramString2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString3, final String paramString4, final String paramString5)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAdsAfterCallDisplay(paramLong1, paramLong2, paramInt2, paramString2, paramInt3, paramInt4, paramInt5, paramString3, paramString4, paramString5, this.val$adUnitId, this.val$adsSdkVersion);
      }
    });
    return true;
  }

  public boolean handleReportAdsClick(final long paramLong, int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2, final int paramInt4, final int paramInt5, final String paramString3, final String paramString4, final String paramString5, final int paramInt6)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAdsClick(paramLong, paramString1, paramInt2, paramInt3, paramString2, paramInt4, paramInt5, paramString3, paramString4, paramString5, paramInt6, this.val$adsLocation);
      }
    });
    return true;
  }

  public boolean handleReportAdsDisplay(final long paramLong, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString3, final String paramString4, final String paramString5, final int paramInt6)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAdsDisplay(paramLong, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, paramInt5, paramString3, paramString4, paramString5, paramInt6, this.val$adsLocation);
      }
    });
    return true;
  }

  public boolean handleReportAnimatedGif(final String paramString1, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAnimatedGif(paramString1, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportAppsApprovalPage(final int paramInt1, final String paramString, final int paramInt2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportAppsApprovalPage(paramInt1, paramString, paramInt2);
      }
    });
    return true;
  }

  public boolean handleReportBackup(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportBackup(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      }
    });
    return true;
  }

  public boolean handleReportBlockedNumberStatistics(final long paramLong1, long paramLong2, final long paramLong3, String paramString1, final String paramString2, boolean paramBoolean, final String paramString3, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportBlockedNumberStatistics(paramLong1, paramLong3, paramString2, paramString3, paramInt, this.val$spam, this.val$fullUrl, this.val$mediaType);
      }
    });
    return true;
  }

  public boolean handleReportBroadcastSendMessage(final long paramLong1, long paramLong2, final long paramLong3, long paramLong4)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportBroadcastSendMessage(paramLong1, paramLong3, this.val$numberOfRecipients, this.val$sequence);
      }
    });
    return true;
  }

  public boolean handleReportClickOnRichMessage(final int paramInt1, final String paramString1, final long paramLong, int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportClickOnRichMessage(paramInt1, paramString1, paramLong, paramInt3, paramInt4, paramInt5, paramString2, this.val$publicAccountId);
      }
    });
    return true;
  }

  public boolean handleReportDiscoverScreenSession(final long paramLong, int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportDiscoverScreenSession(paramLong, this.val$sessionTime);
      }
    });
    return true;
  }

  public boolean handleReportFacebookStatistics(final String paramString1, final String paramString2, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportFacebookStatistics(paramString1, paramString2, paramInt);
      }
    });
    return true;
  }

  public boolean handleReportFavorites(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportFavorites(paramInt1, paramInt2, paramInt3);
      }
    });
    return true;
  }

  public boolean handleReportGameInvitationClicked(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportGameInvitationClicked(paramInt1, paramInt2, paramInt3, paramString);
      }
    });
    return true;
  }

  public boolean handleReportGameInvitationDisplayed(final int paramInt1, final int paramInt2, final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportGameInvitationDisplayed(paramInt1, paramInt2, paramString);
      }
    });
    return true;
  }

  public boolean handleReportGameRedirect(final int paramInt1, final String paramString, final int paramInt2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportGameRedirect(paramInt1, paramString, paramInt2);
      }
    });
    return true;
  }

  public boolean handleReportInstantKeyboardOpen(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportInstantKeyboardOpen(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportMakeMobileCall(final int paramInt1, final int paramInt2, final long paramLong)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportMakeMobileCall(paramInt1, paramInt2, paramLong);
      }
    });
    return true;
  }

  public boolean handleReportMediaScreenSend(final int paramInt1, final String paramString, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportMediaScreenSend(paramInt1, paramString, paramInt2, paramInt3, paramInt4);
      }
    });
    return true;
  }

  public boolean handleReportPA1On1MessageBotReplied(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final LocationInfo paramLocationInfo, final String paramString5, final String paramString6, final long paramLong, int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPA1On1MessageBotReplied(paramString1, paramString2, paramString3, paramString4, paramLocationInfo, paramString5, paramString6, paramLong, this.val$difference);
      }
    });
    return true;
  }

  public boolean handleReportPACreationStartAndLeaveProcess(final long paramLong1, long paramLong2, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPACreationStartAndLeaveProcess(paramLong1, paramInt, this.val$pageLeft);
      }
    });
    return true;
  }

  public boolean handleReportPACreationStartAndLeaveProcess(final long paramLong1, long paramLong2, final int paramInt1, boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final LocationInfo paramLocationInfo, final String paramString6, final String paramString7, final String paramString8, final boolean paramBoolean2, final int paramInt2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPACreationStartAndLeaveProcess(paramLong1, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramLocationInfo, paramString6, paramString7, paramString8, paramBoolean2, paramInt2, this.val$ageRestricted, this.val$chatSolution);
      }
    });
    return true;
  }

  public boolean handleReportPAEntering1On1Chat(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final LocationInfo paramLocationInfo, final long paramLong)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPAEntering1On1Chat(paramString1, paramString2, paramString3, paramString4, paramLocationInfo, paramLong);
      }
    });
    return true;
  }

  public boolean handleReportPAImpressions(final String paramString1, final String paramString2, final long paramLong1, int paramInt1, final String paramString3, final boolean paramBoolean, final int paramInt2, final long paramLong2, final long paramLong3, int paramInt3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPAImpressions(paramString1, paramString2, paramLong1, paramString3, paramBoolean, paramInt2, paramLong2, paramLong3, this.val$messageSequence, this.val$userRole);
      }
    });
    return true;
  }

  public boolean handleReportPAInfoScreenDisplay(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final LocationInfo paramLocationInfo, final long paramLong, int paramInt1, final int paramInt2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPAInfoScreenDisplay(paramString1, paramString2, paramString3, paramString4, paramLocationInfo, paramLong, paramInt2, this.val$userRole);
      }
    });
    return true;
  }

  public boolean handleReportPAInteractions(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final LocationInfo paramLocationInfo, final long paramLong1, int paramInt1, final String paramString5, final String paramString6, final boolean paramBoolean, final int paramInt2, final long paramLong2, final long paramLong3, int paramInt3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPAInteractions(paramString1, paramString2, paramString3, paramString4, paramLocationInfo, paramLong1, paramString5, paramString6, paramBoolean, paramInt2, paramLong2, paramLong3, this.val$messageSequence, this.val$userRole);
      }
    });
    return true;
  }

  public boolean handleReportPATappingOnWebSite(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final LocationInfo paramLocationInfo, final long paramLong, String paramString5, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPATappingOnWebSite(paramString1, paramString2, paramString3, paramString4, paramLocationInfo, paramLong, paramInt, this.val$linkedServiceType);
      }
    });
    return true;
  }

  public boolean handleReportPinToTop(final int paramInt1, final int paramInt2, final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPinToTop(paramInt1, paramInt2, paramString);
      }
    });
    return true;
  }

  public boolean handleReportPurchaseStatusStatistics(final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportPurchaseStatusStatistics(paramString1, paramInt, paramString2, paramString3);
      }
    });
    return true;
  }

  public boolean handleReportScreenAdClick(final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportScreenAdClick(paramString);
      }
    });
    return true;
  }

  public boolean handleReportScreenAdDisplay(final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportScreenAdDisplay(paramString);
      }
    });
    return true;
  }

  public boolean handleReportScreenDisplay(final int paramInt1, final int paramInt2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportScreenDisplay(paramInt1, paramInt2);
      }
    });
    return true;
  }

  public boolean handleReportShareFromStickerProductPage(final String paramString1, final int paramInt, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportShareFromStickerProductPage(paramString1, paramInt, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportShareInvitationNativeMenu(final String paramString, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportShareInvitationNativeMenu(paramString, paramInt);
      }
    });
    return true;
  }

  public boolean handleReportShareNativeMenu(final int paramInt1, final String paramString, final int paramInt2, final int paramInt3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportShareNativeMenu(paramInt1, paramString, paramInt2, paramInt3);
      }
    });
    return true;
  }

  public boolean handleReportShiftKeyMessageSent(final String paramString1, final int paramInt, final String paramString2, final String paramString3, final String paramString4)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportShiftKeyMessageSent(paramString1, paramInt, paramString2, paramString3, paramString4);
      }
    });
    return true;
  }

  public boolean handleReportShiftKeySearch(final String paramString1, final int paramInt1, final String paramString2, final int paramInt2, final String paramString3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportShiftKeySearch(paramString1, paramInt1, paramString2, paramInt2, paramString3);
      }
    });
    return true;
  }

  public boolean handleReportStickerClickerClick(final long paramLong, int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3, final String paramString3, final String paramString4, final String paramString5)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportStickerClickerClick(paramLong, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5, this.val$adsSdkVersion);
      }
    });
    return true;
  }

  public boolean handleReportStickerClickerDisplay(final long paramLong, String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final int paramInt3, final String paramString3, final String paramString4, final String paramString5)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportStickerClickerDisplay(paramLong, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5, this.val$adsSdkVersion);
      }
    });
    return true;
  }

  public boolean handleReportStickerMarketEntry(final long paramLong1, int paramInt1, final int paramInt2, final long paramLong2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportStickerMarketEntry(paramLong1, paramInt2, paramLong2, this.val$clickTimeStamp);
      }
    });
    return true;
  }

  public boolean handleReportStickerMenuExposures(final long paramLong, String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportStickerMenuExposures(paramLong, this.val$packId);
      }
    });
    return true;
  }

  public boolean handleReportStickerPacksInStrickerMenu(final String paramString1, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportStickerPacksInStrickerMenu(paramString1, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportTermsAndPrivacyPolicy()
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportTermsAndPrivacyPolicy();
      }
    });
    return true;
  }

  public boolean handleReportUiDisplayedDuringCall(final long paramLong1, long paramLong2, final long paramLong3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportUiDisplayedDuringCall(paramLong1, paramLong3, this.val$uiDisplayStartInSec);
      }
    });
    return true;
  }

  public boolean handleReportVOSendCreditScreen(final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVOSendCreditScreen(paramInt);
      }
    });
    return true;
  }

  public boolean handleReportVOSendInviteScreen(final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVOSendInviteScreen(paramInt);
      }
    });
    return true;
  }

  public boolean handleReportVersionChecksumChanged(final String paramString)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVersionChecksumChanged(paramString);
      }
    });
    return true;
  }

  public boolean handleReportViberNewsSessionAndUrls(int paramInt, NewsSession paramNewsSession)
  {
    reportCdr(new CdrDecorator..Lambda.2(this, paramInt, paramNewsSession));
    return true;
  }

  public boolean handleReportVideoAdClick(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    reportCdr(new CdrDecorator..Lambda.1(this, paramLong, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5));
    return true;
  }

  public boolean handleReportVideoAdDisplay(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    reportCdr(new CdrDecorator..Lambda.0(this, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5));
    return true;
  }

  public boolean handleReportVoBannerClick(final String paramString1, final String paramString2, final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVoBannerClick(paramString1, paramString2, paramInt);
      }
    });
    return true;
  }

  public boolean handleReportVoBannerDisplayed(final String paramString1, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVoBannerDisplayed(paramString1, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportVoBuy(final String paramString1, final int paramInt1, final int paramInt2, final int paramInt3, final String paramString2, final String paramString3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVoBuy(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3);
      }
    });
    return true;
  }

  public boolean handleReportVoDisplay(final int paramInt)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVoDisplay(paramInt);
      }
    });
    return true;
  }

  public boolean handleReportVoiceMessage(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportVoiceMessage(paramInt1, paramInt2, paramInt3);
      }
    });
    return true;
  }

  public boolean handleReportWalletEntryFrom(final String paramString1, final int paramInt, final String paramString2)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportWalletEntryFrom(paramString1, paramInt, paramString2);
      }
    });
    return true;
  }

  public boolean handleReportWalletOptIn(final String paramString, final long paramLong)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportWalletOptIn(paramString, paramLong);
      }
    });
    return true;
  }

  public boolean handleReportWeb(final String paramString1, final String paramString2, final long paramLong)
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportWeb(paramString1, paramString2, paramLong);
      }
    });
    return true;
  }

  public boolean handleReportWesternUnionStatistics()
  {
    reportCdr(new Runnable()
    {
      public void run()
      {
        CdrDecorator.this.mCdrController.handleReportWesternUnionStatistics();
      }
    });
    return true;
  }

  public boolean handleViberNewsProviderChanges(ViberNewsProviderSpec paramViberNewsProviderSpec)
  {
    reportCdr(new CdrDecorator..Lambda.3(this, paramViberNewsProviderSpec));
    return true;
  }

  public void onConnect()
  {
  }

  public void onConnectionStateChange(int paramInt)
  {
    if (paramInt == 3)
    {
      connect();
      this.mConnected = true;
      return;
    }
    this.mConnected = false;
  }

  public void setAdvertisingId(String paramString)
  {
    this.mCdrController.setAdvertisingId(paramString);
  }

  public void setCommunityViewSource(int paramInt)
  {
    this.mCdrController.setCommunityViewSource(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.CdrDecorator
 * JD-Core Version:    0.6.2
 */