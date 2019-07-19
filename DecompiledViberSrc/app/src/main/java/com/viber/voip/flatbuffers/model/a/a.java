package com.viber.voip.flatbuffers.model.a;

import com.google.d.a.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a
  implements com.viber.voip.flatbuffers.model.a
{

  @c(a="General")
  private f a;

  @c(a="Media")
  private g b;

  @c(a="PublicAccount")
  private i c;

  @c(a="Ads")
  private a d;

  @c(a="ChatExt")
  private b e;

  @c(a="VO")
  private j f;

  @c(a="PA")
  private h g;

  @c(a="Day1Eng")
  private e h;

  @c(a="G2")
  private c i;

  private static <T> List<T> b(T[] paramArrayOfT)
  {
    if (paramArrayOfT != null)
      return Arrays.asList(paramArrayOfT);
    return Collections.emptyList();
  }

  private static boolean b(Boolean paramBoolean)
  {
    if (paramBoolean != null)
      return paramBoolean.booleanValue();
    return false;
  }

  public f a()
  {
    return this.a;
  }

  public g b()
  {
    return this.b;
  }

  public i c()
  {
    return this.c;
  }

  public a d()
  {
    return this.d;
  }

  public b e()
  {
    return this.e;
  }

  public j f()
  {
    return this.f;
  }

  public h g()
  {
    return this.g;
  }

  public e h()
  {
    return this.h;
  }

  public c i()
  {
    return this.i;
  }

  public String toString()
  {
    return "RemoteConfig{mGeneralGroup=" + this.a + ", mMediaGroup=" + this.b + ", mPublicAccount=" + this.c + ", mAds=" + this.d + ", mChatExtensions=" + this.e + ", mVo=" + this.f + ", mPa=" + this.g + ", mEngagement=" + this.h + ", mCommunity=" + this.i + '}';
  }

  public static class a
  {

    @c(a="AdsPositionInPAScreen")
    private int a;

    @c(a="StickerClicker")
    private boolean b;

    @c(a="Google")
    private boolean c;

    @c(a="MeasureUIDisplayed")
    private boolean d;

    @c(a="Timeout")
    private boolean e;

    @c(a="GoogleTimeOut")
    private boolean f;

    @c(a="GdprConsent")
    private boolean g;

    @c(a="ChatlistTest")
    private boolean h;

    public int a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.c;
    }

    public boolean c()
    {
      return this.b;
    }

    public boolean d()
    {
      return this.d;
    }

    public boolean e()
    {
      return this.e;
    }

    public boolean f()
    {
      return this.f;
    }

    public boolean g()
    {
      return this.g;
    }

    public boolean h()
    {
      return this.h;
    }

    public String toString()
    {
      return "Ads{mAdsPositionsInPaScreen=" + this.a + ", mStickerClickerEnabled=" + this.b + ", mGoogleAds=" + this.c + ", mMeasureUIDisplayed=" + this.d + ", mTimeoutCallAdd=" + this.e + ", mGoogleTimeOutCallAd=" + this.f + ", mGdprConsent=" + this.g + ", mChatListTest=" + this.h + '}';
    }
  }

  public static class b
  {

    @c(a="GifBtn")
    private boolean a;

    @c(a="URIs")
    private String[] b;

    @c(a="FavoritesCE")
    private String c;

    public boolean a()
    {
      return a.a(Boolean.valueOf(this.a));
    }

    public List<String> b()
    {
      return a.a(this.b);
    }

    public String c()
    {
      return this.c;
    }

    public String toString()
    {
      return "ChatExtensions{mIsGifButtonEnabled=" + this.a + ", mEnabledURIs=" + Arrays.toString(this.b) + ", mFavoriteLinksBotUri='" + this.c + '\'' + '}';
    }
  }

  public static class c
  {

    @c(a="Enable")
    private boolean a;

    @c(a="DelAllFrmUsr")
    private boolean b;

    @c(a="Verified")
    private boolean c;

    @c(a="M2M")
    private boolean d;

    public boolean a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public boolean c()
    {
      return this.c;
    }

    public boolean d()
    {
      return this.d;
    }

    public String toString()
    {
      return "Community{mIsEnabled=" + this.a + ", mEnableDeleteAllFromUser=" + this.b + ", mVerified=" + this.c + ", mMessagingBetweenMembersEnabled=" + this.d + '}';
    }
  }

  public static class d
  {

    @c(a="Enabled")
    private boolean a;

    @c(a="MaxMembers")
    private int b;

    public boolean a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }

    public String toString()
    {
      return "Conference{mIsEnabled=" + this.a + ", mMaxMembers=" + this.b + '}';
    }
  }

  public static class e
  {

    @c(a="Settings")
    private a a;

    public a a()
    {
      return this.a;
    }

    public String toString()
    {
      return "Engagement{mSettings=" + this.a + '}';
    }

    public static class a
    {

      @c(a="Stickers")
      private boolean a;

      @c(a="Suggested")
      private boolean b;

      public boolean a()
      {
        return this.a;
      }

      public boolean b()
      {
        return this.b;
      }

      public String toString()
      {
        return "Settings{mStickers=" + this.a + ", mSuggested=" + this.b + '}';
      }
    }
  }

  public static class f
  {

    @c(a="AdsAfterCall")
    private Boolean a;

    @c(a="ShiftKeyDisabledServices")
    private String[] b;

    @c(a="ZeroRateCarrier")
    private Boolean c;

    @c(a="MixPanel")
    private Boolean d;

    @c(a="AppBoyFullNew")
    private Boolean e;

    @c(a="PublicAccount")
    private a.i f;

    @c(a="OnBoardDayOne")
    private Boolean g;

    @c(a="ChangePN2")
    private Boolean h;

    @c(a="RestoreMessageFromOtherDevice")
    private Boolean i;

    @c(a="RestoreBackup")
    private Boolean j;

    @c(a="GPins")
    private Boolean k;

    @c(a="ViberId")
    private Boolean l;

    @c(a="WebFlags")
    private Integer m;

    @c(a="GdprEraseLimitDays")
    private Integer n;

    @c(a="GdprMain")
    private Boolean o;

    @c(a="GdprGlobal")
    private Boolean p;

    @c(a="TermsAndPrivacyPolicy")
    private Boolean q;

    @c(a="Apptimize")
    private Boolean r;

    @c(a="Conference")
    private a.d s;

    @c(a="ViberLocalNumber")
    private Boolean t;

    public boolean a()
    {
      return a.a(this.i);
    }

    public boolean b()
    {
      return a.a(this.j);
    }

    public boolean c()
    {
      return a.a(this.l);
    }

    public boolean d()
    {
      return a.a(this.a);
    }

    public List<String> e()
    {
      return a.a(this.b);
    }

    public boolean f()
    {
      return a.a(this.c);
    }

    public boolean g()
    {
      return a.a(this.d);
    }

    public boolean h()
    {
      return a.a(this.e);
    }

    public boolean i()
    {
      return a.a(this.g);
    }

    public boolean j()
    {
      return a.a(this.h);
    }

    public boolean k()
    {
      return a.a(this.k);
    }

    public Integer l()
    {
      return this.m;
    }

    public Integer m()
    {
      return this.n;
    }

    public boolean n()
    {
      return a.a(this.o);
    }

    public boolean o()
    {
      return a.a(this.p);
    }

    public Boolean p()
    {
      return this.q;
    }

    public a.d q()
    {
      return this.s;
    }

    public boolean r()
    {
      return a.a(this.t);
    }

    public String toString()
    {
      return "General{mAdsAfterCallEnabled=" + this.a + ", mDisabledKeyboardExtensions=" + Arrays.toString(this.b) + ", mZeroRateCarrier=" + this.c + ", mMixPanel=" + this.d + ", mAppBoy=" + this.e + ", mPublicAccount=" + this.f + ", mUserEngagement=" + this.g + ", mChangePhoneNumberEnabled=" + this.h + ", mRestoreMessageFromOtherDeviceEnabled=" + this.i + ", mSyncHistoryToDesktopEnabled=" + this.j + ", mGroupPinsEnabled=" + this.k + ", mIsViberIdEnabled=" + this.l + ", mWebFlags=" + this.m + ", mGdprEraseLimitDays=" + this.n + ", mGdprMain=" + this.o + ", mGdprGlobal=" + this.p + ", mTermsAndPrivacyPolicy=" + this.q + ", mApptimize=" + this.r + ", mConference=" + this.s + ", mIsViberLocalNumberEnabled=" + this.t + '}';
    }
  }

  public static class g
  {

    @c(a="Upload")
    private String a;

    @c(a="Download")
    private String b;

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }

    public String toString()
    {
      return "Media{mUploadUrl='" + this.a + '\'' + ", mDownloadUrl='" + this.b + '\'' + '}';
    }
  }

  public static class h
  {

    @c(a="ShopChat")
    private String a;

    public String a()
    {
      return this.a;
    }

    public String toString()
    {
      return "Pa{mShopChat=" + this.a + '}';
    }
  }

  public static class i
  {

    @c(a="ShopAndShare")
    private String a;

    public String a()
    {
      return this.a;
    }

    public String toString()
    {
      return "PublicAccount{mShopAndShare='" + this.a + '\'' + '}';
    }
  }

  public static class j
  {

    @c(a="FreeCall")
    private boolean a;

    public boolean a()
    {
      return this.a;
    }

    public String toString()
    {
      return "Vo{mFreeCall=" + this.a + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.a.a
 * JD-Core Version:    0.6.2
 */