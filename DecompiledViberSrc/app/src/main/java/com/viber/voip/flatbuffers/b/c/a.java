package com.viber.voip.flatbuffers.b.c;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.voip.flatbuffers.a.b.aa;
import com.viber.voip.flatbuffers.a.b.ab;
import com.viber.voip.flatbuffers.a.b.ac;
import com.viber.voip.flatbuffers.a.b.ad;
import com.viber.voip.flatbuffers.a.b.ae;
import com.viber.voip.flatbuffers.a.b.af;
import com.viber.voip.flatbuffers.a.b.ag;
import com.viber.voip.flatbuffers.a.b.ah;
import com.viber.voip.flatbuffers.a.b.c;
import com.viber.voip.flatbuffers.a.b.e;
import com.viber.voip.flatbuffers.a.b.f;
import com.viber.voip.flatbuffers.a.b.g;
import com.viber.voip.flatbuffers.a.b.h;
import com.viber.voip.flatbuffers.a.b.i;
import com.viber.voip.flatbuffers.a.b.j;
import com.viber.voip.flatbuffers.a.b.k;
import com.viber.voip.flatbuffers.a.b.l;
import com.viber.voip.flatbuffers.a.b.m;
import com.viber.voip.flatbuffers.a.b.n;
import com.viber.voip.flatbuffers.a.b.o;
import com.viber.voip.flatbuffers.a.b.p;
import com.viber.voip.flatbuffers.a.b.q;
import com.viber.voip.flatbuffers.a.b.r;
import com.viber.voip.flatbuffers.a.b.s;
import com.viber.voip.flatbuffers.a.b.t;
import com.viber.voip.flatbuffers.a.b.u;
import com.viber.voip.flatbuffers.a.b.v;
import com.viber.voip.flatbuffers.a.b.w;
import com.viber.voip.flatbuffers.a.b.x;
import com.viber.voip.flatbuffers.a.b.y;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo;
import com.viber.voip.flatbuffers.model.msginfo.CommunityScreenshot;
import com.viber.voip.flatbuffers.model.msginfo.Edit;
import com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.b;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.msginfo.ServiceMetadata;
import com.viber.voip.flatbuffers.model.msginfo.TechInfo;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BotKeyboardSendData;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BrowserData;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.PickerLocation;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.ContactInfoSection;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.LocationInfoSection;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.Sender;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.ThumbnailInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Frame;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Map;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.MediaPlayer;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.d;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.e;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.f;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;

public class a
{
  private static String a = "MsgInfoFlatConverter";

  private static TextMetaInfo a(ag paramag)
  {
    if (paramag == null)
      return null;
    TextMetaInfo localTextMetaInfo = new TextMetaInfo();
    localTextMetaInfo.setStartPosition(paramag.b());
    localTextMetaInfo.setEndPosition(paramag.c());
    localTextMetaInfo.setType(TextMetaInfo.a.fromValue(paramag.d()));
    localTextMetaInfo.setMemberId(paramag.e());
    return localTextMetaInfo;
  }

  private static AudioPttInfo a(com.viber.voip.flatbuffers.a.b.a parama)
  {
    if (parama == null)
      return null;
    AudioPttInfo localAudioPttInfo = new AudioPttInfo();
    localAudioPttInfo.setSoundBarsInfo(parama.b());
    localAudioPttInfo.setDuration(parama.c());
    return localAudioPttInfo;
  }

  public static CommunityScreenshot a(e parame)
  {
    if (parame == null)
      return null;
    CommunityScreenshot localCommunityScreenshot = new CommunityScreenshot();
    localCommunityScreenshot.setCommunnityName(parame.b());
    localCommunityScreenshot.setCommunityShareLink(parame.c());
    return localCommunityScreenshot;
  }

  public static Edit a(g paramg)
  {
    if (paramg == null)
      return null;
    Edit localEdit = new Edit();
    localEdit.setToken(paramg.b());
    localEdit.setEditedWithToken(paramg.c());
    return localEdit;
  }

  public static ExtendedInfo a(h paramh)
  {
    if (paramh == null)
      return null;
    ExtendedInfo localExtendedInfo = new ExtendedInfo();
    localExtendedInfo.setLng(paramh.d());
    localExtendedInfo.setLat(paramh.c());
    localExtendedInfo.setDownloadId(paramh.b());
    localExtendedInfo.setEncriptionParams(paramh.f());
    localExtendedInfo.setFileExt(paramh.e());
    localExtendedInfo.setDescription(paramh.g());
    return localExtendedInfo;
  }

  public static FileInfo a(i parami)
  {
    if (parami == null)
      return null;
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.setFileName(parami.b());
    localFileInfo.setFileExt(parami.c());
    localFileInfo.setFileSize(parami.d());
    localFileInfo.setOriginalSize(parami.e());
    localFileInfo.setFileHash(parami.f());
    localFileInfo.setContentType(FileInfo.a.fromName(parami.g()));
    localFileInfo.setDuration(()parami.i());
    localFileInfo.setLifeSpan(parami.j());
    localFileInfo.setWinkType(FileInfo.b.fromName(parami.h()));
    localFileInfo.setMediaInfo(a(parami.k()));
    return localFileInfo;
  }

  private static GroupReferralInfo a(k paramk)
  {
    if (paramk == null)
      return null;
    GroupReferralInfo localGroupReferralInfo = new GroupReferralInfo();
    localGroupReferralInfo.setGroupId(paramk.b());
    localGroupReferralInfo.setGroupName(paramk.e());
    localGroupReferralInfo.setInviteLink(paramk.f());
    localGroupReferralInfo.setMessageId(paramk.c());
    localGroupReferralInfo.setMessageToken(paramk.d());
    return localGroupReferralInfo;
  }

  public static InviteCommunityInfo a(m paramm)
  {
    if (paramm == null)
      return null;
    InviteCommunityInfo localInviteCommunityInfo = new InviteCommunityInfo();
    localInviteCommunityInfo.setHasPersonalLink(paramm.b());
    localInviteCommunityInfo.setCommunityName(paramm.c());
    localInviteCommunityInfo.setCommunityDescription(paramm.d());
    localInviteCommunityInfo.setIconId(paramm.e());
    localInviteCommunityInfo.setInviteLink(paramm.f());
    localInviteCommunityInfo.setGroupId(paramm.g());
    localInviteCommunityInfo.setParticipantsCount(paramm.h());
    return localInviteCommunityInfo;
  }

  private static IvmInfo a(n paramn)
  {
    if (paramn == null)
      return null;
    IvmInfo localIvmInfo = new IvmInfo();
    localIvmInfo.setShape(IvmInfo.a.fromName(paramn.b()));
    return localIvmInfo;
  }

  public static MediaInfo a(q paramq)
  {
    if (paramq == null)
      return null;
    MediaInfo localMediaInfo = new MediaInfo();
    localMediaInfo.setMediaType(MediaInfo.a.fromName(paramq.b()));
    localMediaInfo.setWidth(paramq.c());
    localMediaInfo.setHeight(paramq.d());
    return localMediaInfo;
  }

  private static MediaMetadata a(r paramr)
  {
    if (paramr == null)
      return null;
    return new MediaMetadata.a().a(paramr.b()).a();
  }

  public static MsgInfo a(t paramt)
  {
    if (paramt == null)
      return null;
    MsgInfo localMsgInfo = new MsgInfo();
    localMsgInfo.setTitle(paramt.b());
    localMsgInfo.setUrl(paramt.d());
    localMsgInfo.setUrlType(MsgInfo.a.fromName(paramt.c()));
    localMsgInfo.setText(paramt.e());
    localMsgInfo.setContentType(paramt.f());
    localMsgInfo.setContentLength(paramt.g());
    localMsgInfo.setThumbnailUrl(paramt.h());
    localMsgInfo.setThumbnailWidth(paramt.i());
    localMsgInfo.setThumbnailHeight(paramt.j());
    localMsgInfo.setThumbnailContentType(paramt.k());
    localMsgInfo.setThumbnailInfo(a(paramt.l()));
    localMsgInfo.setName(paramt.m());
    localMsgInfo.setSortName(paramt.n());
    localMsgInfo.setPhoneNumber(paramt.o());
    localMsgInfo.setViberNumber(paramt.p());
    localMsgInfo.setDownloadId(paramt.q());
    localMsgInfo.setFileInfo(a(paramt.r()));
    localMsgInfo.setServiceMetadata(a(paramt.s()));
    localMsgInfo.setPublicAccountMsgInfo(a(paramt.t()));
    localMsgInfo.setPublicAccountReplyData(a(paramt.u()));
    localMsgInfo.setBotKeyboardSendData(a(paramt.w()));
    localMsgInfo.setPin(a(paramt.v()));
    localMsgInfo.setQuote(a(paramt.x()));
    localMsgInfo.setPttVersion(paramt.y());
    localMsgInfo.setAudioPttInfo(a(paramt.z()));
    localMsgInfo.setIvmInfo(a(paramt.A()));
    localMsgInfo.setTechInfo(a(paramt.C()));
    localMsgInfo.setCommunityScreenshot(a(paramt.D()));
    localMsgInfo.setMediaMetadata(a(paramt.E()));
    localMsgInfo.setEdit(a(paramt.F()));
    localMsgInfo.setPoll(a(paramt.G()));
    localMsgInfo.setInviteCommunityInfo(a(paramt.H()));
    localMsgInfo.setGroupReferralInfo(a(paramt.I()));
    a(localMsgInfo, paramt);
    return localMsgInfo;
  }

  public static Pin a(v paramv)
  {
    if (paramv == null)
      return null;
    Pin localPin = new Pin();
    localPin.setText(paramv.b());
    localPin.setToken(paramv.c());
    localPin.setAction(Pin.a.fromName(paramv.d()));
    localPin.setNumber(paramv.e());
    localPin.setSeqInPG(paramv.f());
    localPin.setFlags(paramv.h());
    localPin.setMediaType(paramv.g());
    localPin.setExtendedInfo(a(paramv.i()));
    a(localPin, paramv);
    return localPin;
  }

  private static Poll a(w paramw)
  {
    int i = 0;
    if (paramw == null)
      return null;
    Poll localPoll = new Poll();
    localPoll.setParentSeq(paramw.d());
    localPoll.setParentToken(paramw.c());
    localPoll.setType(paramw.b());
    localPoll.setMultiple(paramw.f());
    localPoll.setGroupId(paramw.i());
    localPoll.setSenderId(paramw.h());
    long[] arrayOfLong = new long[paramw.e()];
    for (int j = 0; j < paramw.e(); j++)
      arrayOfLong[j] = paramw.f(j);
    localPoll.setTokens(arrayOfLong);
    PollUiOptions[] arrayOfPollUiOptions = new PollUiOptions[paramw.g()];
    while (i < paramw.g())
    {
      arrayOfPollUiOptions[i] = a(paramw.g(i));
      i++;
    }
    localPoll.setOptions(arrayOfPollUiOptions);
    return localPoll;
  }

  private static PollUiOptions a(x paramx)
  {
    if (paramx == null)
      return null;
    PollUiOptions localPollUiOptions = new PollUiOptions();
    localPollUiOptions.setSeq(paramx.b());
    localPollUiOptions.setLiked(paramx.f());
    localPollUiOptions.setName(paramx.c());
    localPollUiOptions.setLikesCount(paramx.e());
    localPollUiOptions.setToken(paramx.d());
    localPollUiOptions.setMessageId(paramx.g());
    return localPollUiOptions;
  }

  public static Quote a(ab paramab)
  {
    if (paramab == null)
      return null;
    Quote localQuote = new Quote();
    localQuote.setToken(paramab.b());
    localQuote.setText(paramab.e());
    localQuote.setMemberId(paramab.d());
    localQuote.setMessageId(paramab.f());
    localQuote.setMediaType(paramab.c());
    localQuote.setReplySource(paramab.h());
    a(localQuote, paramab);
    return localQuote;
  }

  public static ServiceMetadata a(ae paramae)
  {
    if (paramae == null)
      return null;
    ServiceMetadata localServiceMetadata = new ServiceMetadata();
    localServiceMetadata.setTrackingData(paramae.b());
    localServiceMetadata.setSilent(paramae.c());
    return localServiceMetadata;
  }

  private static TechInfo a(af paramaf)
  {
    if (paramaf == null)
      return null;
    TechInfo localTechInfo = new TechInfo();
    localTechInfo.setSeq(paramaf.b());
    return localTechInfo;
  }

  private static BotKeyboardSendData a(com.viber.voip.flatbuffers.a.b.b paramb)
  {
    if (paramb == null)
      return null;
    BotKeyboardSendData localBotKeyboardSendData = new BotKeyboardSendData();
    localBotKeyboardSendData.setPhone(paramb.c());
    localBotKeyboardSendData.setLocation(a(paramb.b()));
    localBotKeyboardSendData.setBrowserData(a(paramb.d()));
    return localBotKeyboardSendData;
  }

  private static BrowserData a(com.viber.voip.flatbuffers.a.b.d paramd)
  {
    if (paramd == null)
      return null;
    BrowserData localBrowserData = new BrowserData();
    localBrowserData.setUrl(paramd.b());
    localBrowserData.setTitle(paramd.c());
    localBrowserData.setActionReplyData(paramd.d());
    localBrowserData.setOriginalUrl(paramd.e());
    return localBrowserData;
  }

  private static PickerLocation a(u paramu)
  {
    if (paramu == null)
      return null;
    PickerLocation localPickerLocation = new PickerLocation();
    localPickerLocation.setLat(paramu.b());
    localPickerLocation.setLon(paramu.c());
    localPickerLocation.setAddress(paramu.d());
    return localPickerLocation;
  }

  public static ContactInfoSection a(f paramf)
  {
    if (paramf == null)
      return null;
    ContactInfoSection localContactInfoSection = new ContactInfoSection();
    localContactInfoSection.setName(paramf.b());
    localContactInfoSection.setPhoneNumber(paramf.c());
    return localContactInfoSection;
  }

  public static LocationInfoSection a(o paramo)
  {
    if (paramo == null)
      return null;
    LocationInfoSection localLocationInfoSection = new LocationInfoSection();
    localLocationInfoSection.setLat(Double.valueOf(paramo.b()));
    localLocationInfoSection.setLon(Double.valueOf(paramo.c()));
    return localLocationInfoSection;
  }

  public static PublicAccountInfo a(y paramy)
  {
    if (paramy == null)
      return null;
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.setPaId(paramy.b());
    localPublicAccountInfo.setPaName(paramy.c());
    localPublicAccountInfo.setUri(paramy.d());
    localPublicAccountInfo.setIgnorePaInfo(paramy.e());
    return localPublicAccountInfo;
  }

  public static PublicAccountMsgInfo a(com.viber.voip.flatbuffers.a.b.z paramz)
  {
    if (paramz == null)
      return null;
    PublicAccountMsgInfo localPublicAccountMsgInfo = new PublicAccountMsgInfo();
    localPublicAccountMsgInfo.setType(paramz.e());
    localPublicAccountMsgInfo.setText(paramz.f());
    localPublicAccountMsgInfo.setTrackingData(paramz.g());
    localPublicAccountMsgInfo.setMedia(paramz.h());
    localPublicAccountMsgInfo.setSize(paramz.i());
    localPublicAccountMsgInfo.setThumbnailUrl(paramz.j());
    localPublicAccountMsgInfo.setDuration(paramz.k());
    localPublicAccountMsgInfo.setStickerId(paramz.l());
    localPublicAccountMsgInfo.setFileName(paramz.m());
    localPublicAccountMsgInfo.setSize(paramz.i());
    localPublicAccountMsgInfo.setSender(a(paramz.c()));
    localPublicAccountMsgInfo.setLocation(a(paramz.d()));
    localPublicAccountMsgInfo.setContact(a(paramz.n()));
    localPublicAccountMsgInfo.setKeyboard(a(paramz.b(), false));
    localPublicAccountMsgInfo.setRichMedia(a(paramz.p(), true));
    localPublicAccountMsgInfo.setMinApiVersion(paramz.o());
    localPublicAccountMsgInfo.setPublicAccountInfo(a(paramz.q()));
    localPublicAccountMsgInfo.setRichMediaSignature(paramz.r());
    localPublicAccountMsgInfo.setChatBackground(paramz.s());
    localPublicAccountMsgInfo.setSound(paramz.t());
    return localPublicAccountMsgInfo;
  }

  public static Sender a(ad paramad)
  {
    if (paramad == null)
      return null;
    Sender localSender = new Sender();
    localSender.setName(paramad.b());
    localSender.setAvatar(paramad.c());
    return localSender;
  }

  public static ThumbnailInfo a(ah paramah)
  {
    if (paramah == null)
      return null;
    ThumbnailInfo localThumbnailInfo = new ThumbnailInfo();
    localThumbnailInfo.setThumbnailEP(paramah.b());
    return localThumbnailInfo;
  }

  public static BotReplyConfig a(c paramc, boolean paramBoolean)
  {
    if (paramc == null)
      return null;
    BotReplyConfig localBotReplyConfig = new BotReplyConfig();
    localBotReplyConfig.setKeyboardDate(paramc.e());
    localBotReplyConfig.setButtonsGroupColumns(paramc.g());
    localBotReplyConfig.setButtonsGroupRows(paramc.h());
    if (localBotReplyConfig.getButtonsGroupColumns() <= 0)
    {
      if (paramBoolean);
      localBotReplyConfig.setButtonsGroupColumns(6);
    }
    int m;
    if (localBotReplyConfig.getButtonsGroupRows() <= 0)
    {
      if (!paramBoolean)
        break label216;
      m = 7;
    }
    while (true)
    {
      localBotReplyConfig.setButtonsGroupRows(m);
      localBotReplyConfig.setDefaultHeight(paramc.b());
      localBotReplyConfig.setCustomDefaultHeightPercent(paramc.c());
      localBotReplyConfig.setHeightScalePercent(paramc.i());
      if (paramc.d() != null);
      try
      {
        localBotReplyConfig.setBgColor(Integer.valueOf(Color.parseColor(paramc.d())));
        label121: int i = paramc.f();
        if (i > 0)
        {
          ReplyButton[] arrayOfReplyButton = new ReplyButton[i];
          int j = 0;
          label139: if (j < i)
          {
            ReplyButton localReplyButton = a(paramc.f(j));
            arrayOfReplyButton[j] = localReplyButton;
            if (localReplyButton != null)
            {
              if (localReplyButton.getColumns() <= 0)
                localReplyButton.setColumns(localBotReplyConfig.getButtonsGroupColumns());
              if (localReplyButton.getRows() <= 0)
                if (!paramBoolean)
                  break label222;
            }
            label216: label222: for (int k = localBotReplyConfig.getButtonsGroupRows(); ; k = 1)
            {
              localReplyButton.setRows(k);
              j++;
              break label139;
              m = 2;
              break;
            }
          }
          localBotReplyConfig.setButtons(arrayOfReplyButton);
        }
        localBotReplyConfig.setInputFieldState(BotReplyConfig.a.fromName(paramc.j()));
        return localBotReplyConfig;
      }
      catch (Exception localException)
      {
        break label121;
      }
    }
  }

  private static Frame a(j paramj)
  {
    if (paramj == null)
      return null;
    Frame localFrame = new Frame();
    localFrame.setBorderWidth(Integer.valueOf(paramj.b()));
    String str = paramj.c();
    if (!TextUtils.isEmpty(str));
    while (true)
    {
      try
      {
        localFrame.setBorderColor(Integer.valueOf(Color.parseColor(str)));
        localFrame.setCornerRadius(paramj.d());
        return localFrame;
      }
      catch (Exception localException)
      {
        localFrame.setBorderColor(Frame.DEFAULT_BORDER_COLOR);
        continue;
      }
      localFrame.setBorderColor(Frame.DEFAULT_BORDER_COLOR);
    }
  }

  private static InternalBrowser a(l paraml)
  {
    if (paraml == null)
      return null;
    InternalBrowser localInternalBrowser = new InternalBrowser();
    localInternalBrowser.setActionButton(InternalBrowser.a.of(paraml.b()));
    localInternalBrowser.setActionPredefinedUrl(paraml.c());
    localInternalBrowser.setTitleType(InternalBrowser.c.of(paraml.d()));
    localInternalBrowser.setCustomTitle(paraml.e());
    localInternalBrowser.setOpenMode(InternalBrowser.b.of(paraml.f()));
    localInternalBrowser.setActionReplyData(paraml.g());
    return localInternalBrowser;
  }

  private static Map a(p paramp)
  {
    if (paramp == null)
      return null;
    Map localMap = new Map();
    localMap.setLatitude(Double.valueOf(paramp.b()));
    localMap.setLongitude(Double.valueOf(paramp.c()));
    return localMap;
  }

  private static MediaPlayer a(s params)
  {
    if (params == null)
      return null;
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setTitle(params.b());
    localMediaPlayer.setSubtitle(params.c());
    localMediaPlayer.setThumbnailURL(params.d());
    localMediaPlayer.setLoop(params.e());
    localMediaPlayer.setActionReplyData(params.f());
    return localMediaPlayer;
  }

  public static PublicAccountReplyData a(aa paramaa)
  {
    if (paramaa == null)
      return null;
    PublicAccountReplyData localPublicAccountReplyData = new PublicAccountReplyData();
    localPublicAccountReplyData.setButton(a(paramaa.b()));
    return localPublicAccountReplyData;
  }

  public static ReplyButton a(ac paramac)
  {
    if (paramac == null)
      return null;
    ReplyButton localReplyButton = new ReplyButton();
    localReplyButton.setColumns(paramac.b());
    localReplyButton.setRows(paramac.c());
    String str1 = paramac.d();
    if (!TextUtils.isEmpty(str1));
    int[] arrayOfInt;
    while (true)
    {
      try
      {
        localReplyButton.setBgColor(Integer.valueOf(Color.parseColor(str1)));
        String str2 = paramac.e();
        if (!TextUtils.isEmpty(str2))
          localReplyButton.setBgMedia(com.viber.voip.flatbuffers.c.z.c(str2));
        localReplyButton.setBgMediaType(ReplyButton.c.fromName(paramac.f()));
        localReplyButton.setBgMediaScaleType(ReplyButton.f.fromName(paramac.g()));
        localReplyButton.setBgLoop(Boolean.valueOf(paramac.h()));
        localReplyButton.setActionType(ReplyButton.a.fromName(paramac.i()));
        localReplyButton.setActionBody(paramac.j());
        String str3 = paramac.l();
        if (!TextUtils.isEmpty(str3))
          localReplyButton.setOpenUrlMediaType(ReplyButton.d.fromName(str3));
        String str4 = paramac.k();
        if (!TextUtils.isEmpty(str4))
          localReplyButton.setOpenUrlType(ReplyButton.e.fromName(str4));
        localReplyButton.setTextBgGradientColor(paramac.w());
        String str5 = paramac.m();
        if (!TextUtils.isEmpty(str5))
          localReplyButton.setImageUri(Uri.parse(str5));
        localReplyButton.setImageScaleType(ReplyButton.f.fromName(paramac.n()));
        localReplyButton.setTextVerticalAlign(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.fromName(paramac.o()));
        localReplyButton.setTextHorizontalAlign(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a.fromName(paramac.p()));
        localReplyButton.setText(com.viber.voip.flatbuffers.c.d.a(paramac.q()));
        localReplyButton.setTextSize(ReplyButton.g.fromName(paramac.r()));
        localReplyButton.setTextShouldFit(paramac.s());
        i = paramac.t();
        if (i < 0)
          break label432;
        localReplyButton.setTextOpacity(i);
        int j = paramac.u();
        if (j >= 0)
        {
          if (j != 0)
            break label439;
          localBoolean = Boolean.FALSE;
          localReplyButton.setSilent(localBoolean);
        }
        localReplyButton.setReplyType(ReplyButton.b.fromName(paramac.v()));
        localReplyButton.setInternalBrowserSection(a(paramac.x()));
        localReplyButton.setMediaPlayer(a(paramac.y()));
        localReplyButton.setFrame(a(paramac.A()));
        localReplyButton.setMap(a(paramac.B()));
        int k = paramac.z();
        if (k <= 0)
          break label453;
        arrayOfInt = new int[k];
        int m = 0;
        if (m >= k)
          break;
        arrayOfInt[m] = paramac.f(m);
        m++;
        continue;
      }
      catch (Exception localException)
      {
        localReplyButton.setBgColor(Integer.valueOf(-1));
        continue;
      }
      localReplyButton.setBgColor(Integer.valueOf(-1));
      continue;
      label432: int i = 100;
      continue;
      label439: Boolean localBoolean = Boolean.TRUE;
    }
    localReplyButton.setTextPaddings(arrayOfInt);
    label453: return localReplyButton;
  }

  private static void a(MsgInfo paramMsgInfo, t paramt)
  {
    int i = paramt.B();
    if (i > 0)
    {
      TextMetaInfo[] arrayOfTextMetaInfo = new TextMetaInfo[i];
      for (int j = 0; j < i; j++)
        arrayOfTextMetaInfo[j] = a(paramt.f(j));
      paramMsgInfo.setTextMetaInfo(arrayOfTextMetaInfo);
    }
  }

  private static void a(Pin paramPin, v paramv)
  {
    int i = paramv.j();
    if (i > 0)
    {
      TextMetaInfo[] arrayOfTextMetaInfo = new TextMetaInfo[i];
      for (int j = 0; j < i; j++)
        arrayOfTextMetaInfo[j] = a(paramv.f(j));
      paramPin.setTextMetaInfo(arrayOfTextMetaInfo);
    }
  }

  private static void a(Quote paramQuote, ab paramab)
  {
    int i = paramab.g();
    if (i > 0)
    {
      TextMetaInfo[] arrayOfTextMetaInfo = new TextMetaInfo[i];
      for (int j = 0; j < i; j++)
        arrayOfTextMetaInfo[j] = a(paramab.f(j));
      paramQuote.setTextMetaInfo(arrayOfTextMetaInfo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.c.a
 * JD-Core Version:    0.6.2
 */