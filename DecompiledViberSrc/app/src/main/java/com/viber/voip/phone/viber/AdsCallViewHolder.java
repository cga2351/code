package com.viber.voip.phone.viber;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.constraint.ConstraintLayout.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.appnexus.opensdk.utils.Settings;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.CdrConst.AdsAfterCallTypeCall.Converter;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.c;
import com.viber.voip.ads.d.a;
import com.viber.voip.ads.d.j;
import com.viber.voip.ads.d.q;
import com.viber.voip.ads.o;
import com.viber.voip.banner.d.g;
import com.viber.voip.banner.view.AdsAfterCallRemoteBannerLayout;
import com.viber.voip.banner.view.a.b;
import com.viber.voip.banner.view.f.a;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.phone.CallFragmentManager.CallFragmentManagerCallback;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.d.b;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;

public class AdsCallViewHolder extends CallViewHolder
  implements View.OnClickListener, f.a, d.b
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int MIN_HEIGHT_DELTA = 5;
  private static final int MIN_ROOT_HEIGHT_DELTA = 100;
  private AdTimer mAdCountDown;
  private ViewGroup mAdFooterSection;
  private ViewGroup mAdHeaderSection;
  private final o mAdmobActionListener = new o()
  {
    public void onAdClicked(com.viber.voip.ads.d.i paramAnonymousi)
    {
      if (((paramAnonymousi instanceof com.viber.voip.ads.e)) || ((paramAnonymousi instanceof com.viber.voip.ads.p)))
        AdsCallViewHolder.this.trackAdsAfterCallCdr(false, 1, AdsCallViewHolder.this.mAfterCallAd);
    }

    public void onAdClosed(com.viber.voip.ads.d.i paramAnonymousi)
    {
    }
  };
  private ViewGroup mAdsAfterCallRoot;
  private final com.viber.voip.banner.a.a.d mAdsCallController;
  private FrameLayout mAdsContent;
  private final com.viber.voip.ads.d.i mAdsProvider;
  private j mAfterCallAd;
  private int mBannerLeftRightMargin;
  private final CallFragmentManager.CallFragmentManagerCallback mCallFragmentManagerCallback;
  private CallInfo mCallInfo;
  private View mCloseBtn;
  private com.viber.voip.util.e.e mImageFetcher;
  private boolean mIsHiddenToShowHelp;
  private boolean mIsShowingAdFinished;
  private ImageView mPromotedByTagIconView;
  private TextView mPromotedByTagTextView;
  private com.viber.voip.util.e.f mProviderIconConfig;
  private b mRemoteAdsCallInflater;
  private TextView mReportAdMobSmallAdTextView;
  private TextView mReportAdTextView;
  private boolean mShouldTrackDisplayOfAdsAfterCall = true;
  private boolean mShouldTrackUserInteractionWithAdsAfterCall = true;

  public AdsCallViewHolder(CallFragment paramCallFragment, CallFragmentManager.CallFragmentManagerCallback paramCallFragmentManagerCallback, com.viber.voip.banner.a.a.d paramd, View paramView)
  {
    super(paramCallFragment);
    this.mCallFragmentManagerCallback = paramCallFragmentManagerCallback;
    this.mAdsCallController = paramd;
    this.mAdsProvider = this.mAdsCallController.j();
    this.mCloseBtn = paramView;
  }

  private void adjustForBanner(Context paramContext, int paramInt, String paramString)
  {
    if ((dj.a(paramContext)) && (((paramInt == 3) && (paramString.equals("Banner"))) || (paramInt == 2)))
    {
      this.mAdsContent.setBackground(null);
      this.mAdsContent.setPadding(0, 0, 0, 0);
      this.mAdsAfterCallRoot.setPadding(0, 0, 0, 0);
      ConstraintLayout.a locala1 = (ConstraintLayout.a)this.mAdHeaderSection.getLayoutParams();
      locala1.leftMargin = this.mBannerLeftRightMargin;
      locala1.rightMargin = this.mBannerLeftRightMargin;
      ConstraintLayout.a locala2 = (ConstraintLayout.a)this.mAdFooterSection.getLayoutParams();
      locala2.leftMargin = this.mBannerLeftRightMargin;
      locala2.rightMargin = this.mBannerLeftRightMargin;
    }
  }

  private void checkFitAd(View paramView, int paramInt, String paramString)
  {
    TextView localTextView;
    ImageView localImageView;
    if ((paramInt == 1) || ((paramInt == 3) && (!paramString.equals("Banner"))))
    {
      localTextView = (TextView)paramView.findViewById(R.id.after_call_ad_text);
      localImageView = (ImageView)paramView.findViewById(R.id.after_call_ad_image);
      if ((localTextView != null) && (localImageView != null))
      {
        if ((localImageView.getDrawable() != null) || (this.mRemoteAdsCallInflater == null))
          break label114;
        this.mRemoteAdsCallInflater.a(new AdsCallViewHolder..Lambda.0(this, paramView, localTextView, localImageView));
        if (localImageView.getDrawable() != null)
        {
          this.mRemoteAdsCallInflater.a(null);
          fitTextLabel(paramView, localTextView, localImageView);
        }
      }
    }
    return;
    label114: fitTextLabel(paramView, localTextView, localImageView);
  }

  private void createTimer(long paramLong)
  {
    if (this.mAdCountDown == null)
      this.mAdCountDown = new AdTimer(paramLong);
    startAdTimer();
  }

  private void drawDebugState(DebugReportState paramDebugReportState)
  {
  }

  private void finishEndCall(int paramInt)
  {
    this.mIsShowingAdFinished = true;
    trackAdsAfterCallCdr(false, paramInt, this.mAfterCallAd);
    onHideInternally();
    this.mCallFragmentManagerCallback.endCall();
  }

  private void fitTextLabel(View paramView, TextView paramTextView, ImageView paramImageView)
  {
    dj.a(paramView, new AdsCallViewHolder..Lambda.1(this, paramView, paramTextView, paramImageView));
  }

  private int getCdrLocationByAdType(int paramInt)
  {
    if (paramInt == 2)
      return 15;
    return 17;
  }

  private static int getRequiredTextHeight(TextView paramTextView)
  {
    int i = paramTextView.getMaxLines();
    int j = paramTextView.getLineCount();
    if ((i > 0) && (j > i));
    while (true)
    {
      Rect localRect = new Rect();
      String str = paramTextView.getText().toString();
      paramTextView.getPaint().getTextBounds(str, 0, str.length(), localRect);
      return i * (1 + paramTextView.getLineHeight());
      i = j;
    }
  }

  private String getUniqueAdProviderIdForReport()
  {
    String str = "";
    if ((this.mAdsProvider instanceof com.viber.voip.ads.i))
      str = ((com.viber.voip.ads.p)this.mAdsProvider).f();
    do
    {
      return str;
      if ((this.mAfterCallAd instanceof a))
      {
        switch (this.mAdsCallController.e())
        {
        default:
          return str;
        case 1:
          return "/65656263/test/post-call-300X250";
        case 2:
        }
        return "/65656263/test/Time_Out_300x250";
      }
    }
    while (!(this.mAfterCallAd instanceof com.viber.voip.ads.d.p));
    return ((com.viber.voip.ads.p)this.mAdsProvider).f();
  }

  private void onHideInternally()
  {
    stopAdTimer();
  }

  private void onRemoteBannerAction(j paramj)
  {
    this.mIsShowingAdFinished = true;
    new OpenUrlAction(paramj.m()).execute(this.mAdsContent.getContext(), null);
    reportClickUrl();
    trackAdsAfterCallCdr(false, 1, paramj);
  }

  private void onRemoteBannerDisplayed(j paramj, CallInfo paramCallInfo)
  {
    if (this.mIsShowingAdFinished)
      return;
    this.mAfterCallAd = paramj;
    this.mCallInfo = paramCallInfo;
    long l = this.mAfterCallAd.g();
    if (this.mPromotedByTagTextView != null)
      this.mPromotedByTagTextView.setText(this.mAfterCallAd.h());
    if (this.mReportAdTextView != null)
      this.mReportAdTextView.setOnClickListener(this);
    this.mAdsAfterCallRoot.setOnClickListener(this);
    resolveImpressionUrlsSpecificWorld(this.mAfterCallAd);
    drawDebugState(DebugReportState.IMPRESSION);
    reportImpressionUrl();
    createTimer(l);
    com.viber.voip.util.d.c(this);
    this.mAdsProvider.a(this.mAdmobActionListener);
    trackAdsAfterCallCdr(true, 0, this.mAfterCallAd);
  }

  private void reportAdUrls(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
      this.mAdsCallController.a(paramArrayOfString);
  }

  private void reportClickUrl()
  {
    if (this.mAfterCallAd != null)
      reportAdUrls(this.mAfterCallAd.l());
  }

  private void reportImpressionUrl()
  {
    if (this.mAfterCallAd != null)
      reportAdUrls(this.mAfterCallAd.k());
  }

  private void reportViewUrl()
  {
    if (this.mAfterCallAd != null)
      reportAdUrls(this.mAfterCallAd.j());
  }

  private void resolveImpressionUrlsSpecificWorld(j paramj)
  {
    if (this.mPromotedByTagIconView == null)
      return;
    if (paramj.i())
    {
      String str = paramj.u();
      this.mPromotedByTagIconView.setOnClickListener(this);
      if (!TextUtils.isEmpty(str))
        this.mPromotedByTagIconView.setTag(new AdAfterCallClickTag(paramj, new OpenUrlAction(str)));
      Uri localUri = Uri.parse(paramj.t());
      this.mImageFetcher.a(localUri, this.mPromotedByTagIconView, this.mProviderIconConfig);
      dj.b(this.mPromotedByTagIconView, true);
      return;
    }
    dj.b(this.mPromotedByTagIconView, false);
    this.mPromotedByTagIconView.setTag(null);
    this.mPromotedByTagIconView.setOnClickListener(null);
  }

  private void startAdTimer()
  {
    if (this.mAdCountDown == null);
    while (!this.mCallFragmentManagerCallback.isReadyToShowAd())
      return;
    this.mAdCountDown.start();
  }

  private void stopAdTimer()
  {
    if (this.mAdCountDown == null)
      return;
    this.mAdCountDown.stop();
  }

  private void trackAdsAfterCallCdr(boolean paramBoolean, int paramInt, j paramj)
  {
    if (paramj == null);
    do
    {
      do
        return;
      while (this.mCallInfo == null);
      if (paramBoolean)
        break;
    }
    while (!this.mShouldTrackUserInteractionWithAdsAfterCall);
    this.mShouldTrackUserInteractionWithAdsAfterCall = false;
    label28: Engine localEngine = ViberApplication.getInstance().getEngine(false);
    long l1 = localEngine.getPhoneController().generateSequence();
    long l2 = this.mCallInfo.getInCallState().getCallToken();
    int i = CdrConst.AdsAfterCallTypeCall.Converter.fromCallInfo(this.mCallInfo);
    int j = getCdrLocationByAdType(this.mCallInfo.getAdsType());
    String str1 = paramj.d();
    String str2 = paramj.e();
    int k;
    label125: int m;
    label138: String str3;
    String str4;
    if (((this.mAdsProvider instanceof com.viber.voip.ads.i)) && ((paramj instanceof a)))
    {
      k = CdrConst.AdTypes.fromAdType("Story");
      if (!(this.mAdsProvider instanceof com.viber.voip.ads.i))
        break label237;
      m = 3;
      str3 = paramj.s();
      str4 = "";
      if (!(paramj instanceof com.viber.voip.ads.d.p))
        break label248;
      str4 = ((com.viber.voip.ads.d.p)paramj).a();
    }
    while (true)
    {
      if (!paramBoolean)
        break label273;
      localEngine.getCdrController().handleReportAdsAfterCallDisplay(l1, i, l2, j, str1, str2, k, 0, m, str3, getUniqueAdProviderIdForReport(), str4);
      return;
      if (!this.mShouldTrackDisplayOfAdsAfterCall)
        break;
      this.mShouldTrackDisplayOfAdsAfterCall = false;
      break label28;
      k = CdrConst.AdTypes.fromAdType(paramj.f());
      break label125;
      label237: m = paramj.v();
      break label138;
      label248: if ((this.mAdsProvider instanceof com.viber.voip.ads.i))
      {
        Settings.getSettings().getClass();
        str4 = "4.11.2";
      }
    }
    label273: ICdrController localICdrController = localEngine.getCdrController();
    String str5 = getUniqueAdProviderIdForReport();
    localICdrController.handleReportAdsAfterCallAction(l1, i, l2, paramInt, j, str1, str2, k, 0, 0, -1, m, str3, str5, str4);
  }

  private void updateUiAccordingToLeftTime(long paramLong1, long paramLong2)
  {
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.mCloseBtn;
    if ((!dj.a(arrayOfView)) && (paramLong2 > paramLong1) && (paramLong2 - paramLong1 >= 1000L))
    {
      dj.b(this.mCloseBtn, true);
      this.mCloseBtn.setOnClickListener(this);
      reportViewUrl();
      drawDebugState(DebugReportState.VIEW);
    }
  }

  public void onAppStopped()
  {
    com.viber.voip.util.i.c(this);
  }

  public void onBackground()
  {
    this.mAdsAfterCallRoot.post(new AdsCallViewHolder..Lambda.2(this));
  }

  public boolean onBannerAction(long paramLong, String paramString, int paramInt, com.viber.voip.banner.view.f paramf)
  {
    if ((paramf instanceof AdsAfterCallRemoteBannerLayout))
    {
      AdsAfterCallRemoteBannerLayout localAdsAfterCallRemoteBannerLayout = (AdsAfterCallRemoteBannerLayout)paramf;
      g localg = localAdsAfterCallRemoteBannerLayout.getRemotePromoType();
      if (g.d == localg)
        onRemoteBannerAction(localAdsAfterCallRemoteBannerLayout.getAd());
    }
    return true;
  }

  public void onBannerCloseAction(long paramLong, com.viber.voip.banner.view.f paramf)
  {
  }

  @SuppressLint({"WrongConstant"})
  public void onClick(View paramView)
  {
    if (this.mPromotedByTagIconView == paramView)
      if (paramView.getTag() != null)
        ((AdAfterCallClickTag)paramView.getTag()).mAction.execute(paramView.getContext(), null);
    do
    {
      return;
      if ((this.mCloseBtn == paramView) || (paramView == this.mAdsAfterCallRoot))
      {
        finishEndCall(2);
        return;
      }
    }
    while ((this.mReportAdTextView != paramView) || (this.mAfterCallAd == null));
    String str1 = "";
    String str2;
    if ((this.mAfterCallAd instanceof q))
    {
      str2 = "ViberAdServer";
      str1 = this.mAfterCallAd.s();
    }
    while (true)
    {
      int i = -1;
      if ((this.mAfterCallAd instanceof q))
        i = this.mAdsCallController.f();
      new OpenUrlAction(dx.a(paramView.getContext(), this.mAfterCallAd.k(), this.mAfterCallAd.d(), str2, str1, getUniqueAdProviderIdForReport(), i).toString()).execute(paramView.getContext(), null);
      return;
      str2 = this.mAfterCallAd.s();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mImageFetcher = com.viber.voip.util.e.e.a(paramViewGroup.getContext());
    this.mProviderIconConfig = com.viber.voip.util.e.f.a();
    if (paramBundle != null)
    {
      this.mShouldTrackDisplayOfAdsAfterCall = false;
      this.mShouldTrackUserInteractionWithAdsAfterCall = false;
      this.mIsHiddenToShowHelp = paramBundle.getBoolean("is_hidden_to_show_help");
      this.mIsShowingAdFinished = paramBundle.getBoolean("is_showing_ad_finished");
      if (!this.mIsHiddenToShowHelp)
        this.mIsShowingAdFinished = true;
      if (this.mIsShowingAdFinished)
        return null;
      AdTimerSaveData localAdTimerSaveData = (AdTimerSaveData)paramBundle.getParcelable("ad_timer_data");
      if (localAdTimerSaveData != null)
        this.mAdCountDown = new AdTimer(localAdTimerSaveData);
    }
    ViewStub localViewStub = (ViewStub)paramViewGroup.findViewById(R.id.ads_after_call_stub);
    if (localViewStub != null)
    {
      this.mAdsAfterCallRoot = ((ViewGroup)localViewStub.inflate());
      this.mAdsContent = ((FrameLayout)this.mAdsAfterCallRoot.findViewById(R.id.remote_banner_container_wrapper_overlay));
      this.mAdHeaderSection = ((ViewGroup)this.mAdsAfterCallRoot.findViewById(R.id.ad_header_section));
      this.mAdFooterSection = ((ViewGroup)this.mAdsAfterCallRoot.findViewById(R.id.ad_footer_section));
      this.mPromotedByTagTextView = ((TextView)this.mAdsAfterCallRoot.findViewById(R.id.promoted_by_tag));
      this.mPromotedByTagIconView = ((ImageView)this.mAdsAfterCallRoot.findViewById(R.id.promoted_by_tag_icon));
      this.mReportAdTextView = ((TextView)this.mAdsAfterCallRoot.findViewById(R.id.report_ad));
      this.mReportAdMobSmallAdTextView = ((TextView)this.mAdsAfterCallRoot.findViewById(R.id.report_ad_admob_small));
    }
    while (true)
    {
      this.mBannerLeftRightMargin = paramViewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.ads_header_margin_left_small);
      return this.mAdsAfterCallRoot;
      L.a(new IllegalStateException("Unable to find 'ads after call' ViewStub"), "layout id = " + paramViewGroup.getId());
    }
  }

  public void onDestroy()
  {
    trackAdsAfterCallCdr(false, 0, this.mAfterCallAd);
    this.mCallInfo = null;
    this.mAfterCallAd = null;
    com.viber.voip.util.d.d(this);
    this.mAdsProvider.d();
  }

  public void onForeground()
  {
    com.viber.voip.util.i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    com.viber.voip.util.i.a(this, paramBoolean);
  }

  public void onHide()
  {
    onHideInternally();
  }

  public void onShow()
  {
    if (this.mIsShowingAdFinished)
    {
      this.mCallFragmentManagerCallback.endCall();
      return;
    }
    this.mIsHiddenToShowHelp = false;
    startAdTimer();
  }

  public void saveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("is_hidden_to_show_help", this.mIsHiddenToShowHelp);
    paramBundle.putBoolean("is_showing_ad_finished", this.mIsShowingAdFinished);
    if (this.mAdCountDown != null)
      paramBundle.putParcelable("ad_timer_data", this.mAdCountDown.createSaveData());
  }

  public void showAd(final Context paramContext, final CallInfo paramCallInfo)
  {
    final j localj = this.mAdsProvider.e();
    if ((localj == null) || (this.mPromotedByTagTextView == null))
      return;
    this.mRemoteAdsCallInflater = b.a(paramContext);
    AdsAfterCallRemoteBannerLayout localAdsAfterCallRemoteBannerLayout = new AdsAfterCallRemoteBannerLayout(paramContext);
    this.mRemoteAdsCallInflater.a(localj, new com.viber.voip.banner.view.a.c.a()
    {
      public void onRemoteBannerError(long paramAnonymousLong, com.viber.voip.banner.view.f paramAnonymousf, int paramAnonymousInt)
      {
      }

      public void onRemoteBannerReady(long paramAnonymousLong, final com.viber.voip.banner.view.f paramAnonymousf)
      {
        AdsCallViewHolder.this.mAdsProvider.a(paramContext, paramAnonymousf, new c()
        {
          public void onAdLoaded(View paramAnonymous2View)
          {
            int i = AdsCallViewHolder.2.this.val$callInfo.getAdsType();
            int j = AdsCallViewHolder.2.this.val$callInfo.getAdProviderType();
            if ((j == 2) || (j == 3))
            {
              AdsCallViewHolder.this.mPromotedByTagTextView.setPadding(AdsCallViewHolder.this.mPromotedByTagTextView.getPaddingLeft(), 0, AdsCallViewHolder.this.mPromotedByTagTextView.getPaddingRight(), AdsCallViewHolder.this.mPromotedByTagTextView.getPaddingBottom());
              if ((i == 2) || ((i == 1) && (j == 2)) || ((i == 1) && (j == 3)))
              {
                dj.b(AdsCallViewHolder.this.mReportAdTextView, false);
                dj.b(AdsCallViewHolder.this.mReportAdMobSmallAdTextView, true);
                AdsCallViewHolder.access$302(AdsCallViewHolder.this, AdsCallViewHolder.this.mReportAdMobSmallAdTextView);
              }
            }
            while (paramAnonymous2View == null)
            {
              dj.b(AdsCallViewHolder.this.mAdsContent, false);
              return;
              if (j == 1)
                paramAnonymousf.setActionListener(AdsCallViewHolder.this);
            }
            AdsCallViewHolder.this.checkFitAd(paramAnonymous2View, j, AdsCallViewHolder.2.this.val$afterCallAd.f());
            AdsCallViewHolder.this.adjustForBanner(AdsCallViewHolder.2.this.val$context, j, AdsCallViewHolder.2.this.val$afterCallAd.f());
            AdsCallViewHolder.this.mAdsContent.addView(paramAnonymous2View, new ViewGroup.LayoutParams(-1, -2));
            AdsCallViewHolder.this.onRemoteBannerDisplayed(AdsCallViewHolder.2.this.val$afterCallAd, AdsCallViewHolder.2.this.val$callInfo);
          }

          public void onFailure(com.viber.voip.ads.c.a paramAnonymous2a)
          {
          }
        });
      }
    }
    , localAdsAfterCallRemoteBannerLayout, paramCallInfo.getAdsType());
  }

  public void trackAdsAfterCallButtonsClick(int paramInt)
  {
    trackAdsAfterCallCdr(false, paramInt, this.mAfterCallAd);
  }

  private static class AdAfterCallClickTag
  {
    final Action mAction;
    final j mAd;

    AdAfterCallClickTag(j paramj, Action paramAction)
    {
      this.mAd = paramj;
      this.mAction = paramAction;
    }
  }

  private final class AdTimer
  {
    private static final long NO_TIME_LEFT;
    private CountDownTimer mCountDownTimer;
    private final long mInitialDurationMillis;
    private boolean mIsCountDownTimerWorking;
    private long mRemainDurationMillis;

    AdTimer(long arg2)
    {
      Object localObject;
      if (localObject != l)
        l = 100L + 1000L * localObject;
      this.mInitialDurationMillis = l;
      this.mRemainDurationMillis = this.mInitialDurationMillis;
    }

    AdTimer(AdsCallViewHolder.AdTimerSaveData arg2)
    {
      Object localObject;
      this.mInitialDurationMillis = localObject.mInitialDurationMillis;
      this.mRemainDurationMillis = localObject.mRemainDurationMillis;
    }

    private CountDownTimer createTimer(long paramLong)
    {
      return new CountDownTimer(paramLong, 1000L)
      {
        public void onFinish()
        {
          AdsCallViewHolder.AdTimer.this.onTimerFinished();
        }

        public void onTick(long paramAnonymousLong)
        {
          AdsCallViewHolder.AdTimer.this.onTimerTick(paramAnonymousLong, this.val$durationMillis);
        }
      };
    }

    private long normalizeRemainTime(long paramLong)
    {
      if (paramLong != 0L)
      {
        if (paramLong > 1000L)
          return paramLong;
        return 1000L;
      }
      return 0L;
    }

    private void onTimerFinished()
    {
      this.mIsCountDownTimerWorking = false;
      this.mRemainDurationMillis = 0L;
      AdsCallViewHolder.this.finishEndCall(0);
    }

    private void onTimerTick(long paramLong1, long paramLong2)
    {
      this.mRemainDurationMillis = paramLong1;
      AdsCallViewHolder.this.updateUiAccordingToLeftTime(paramLong1, paramLong2);
    }

    AdsCallViewHolder.AdTimerSaveData createSaveData()
    {
      long l1 = 0L;
      long l2 = this.mInitialDurationMillis;
      if (this.mRemainDurationMillis != l1)
        l1 = normalizeRemainTime(this.mRemainDurationMillis);
      return new AdsCallViewHolder.AdTimerSaveData(l2, l1);
    }

    public void start()
    {
      try
      {
        if (!this.mIsCountDownTimerWorking)
        {
          this.mIsCountDownTimerWorking = true;
          this.mCountDownTimer = createTimer(this.mRemainDurationMillis);
          this.mCountDownTimer.start();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void stop()
    {
      try
      {
        if (this.mIsCountDownTimerWorking)
        {
          this.mIsCountDownTimerWorking = false;
          if (this.mCountDownTimer != null)
          {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer = null;
            this.mRemainDurationMillis = normalizeRemainTime(this.mRemainDurationMillis);
          }
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  private static final class AdTimerSaveData
    implements Parcelable
  {
    public static final Parcelable.Creator<AdTimerSaveData> CREATOR = new Parcelable.Creator()
    {
      public AdsCallViewHolder.AdTimerSaveData createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AdsCallViewHolder.AdTimerSaveData(paramAnonymousParcel);
      }

      public AdsCallViewHolder.AdTimerSaveData[] newArray(int paramAnonymousInt)
      {
        return new AdsCallViewHolder.AdTimerSaveData[paramAnonymousInt];
      }
    };
    final long mInitialDurationMillis;
    final long mRemainDurationMillis;

    AdTimerSaveData(long paramLong1, long paramLong2)
    {
      this.mInitialDurationMillis = paramLong1;
      this.mRemainDurationMillis = paramLong2;
    }

    AdTimerSaveData(Parcel paramParcel)
    {
      this.mInitialDurationMillis = paramParcel.readLong();
      this.mRemainDurationMillis = paramParcel.readLong();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.mInitialDurationMillis);
      paramParcel.writeLong(this.mRemainDurationMillis);
    }
  }

  private static enum DebugReportState
  {
    static
    {
      DebugReportState[] arrayOfDebugReportState = new DebugReportState[2];
      arrayOfDebugReportState[0] = IMPRESSION;
      arrayOfDebugReportState[1] = VIEW;
    }
  }

  private static abstract interface SavedStateKey
  {
    public static final String AD_TIMER_DATA = "ad_timer_data";
    public static final String IS_HIDDEN_TO_SHOW_HELP = "is_hidden_to_show_help";
    public static final String IS_SHOWING_AD_FINISHED = "is_showing_ad_finished";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.AdsCallViewHolder
 * JD-Core Version:    0.6.2
 */