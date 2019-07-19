package com.viber.voip.g;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.squareup.leakcanary.RefWatcher;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.ConversationsScreenScrollCdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.secure.TrustPeerController;
import com.viber.jni.viberout.ViberOutBalanceListener;
import com.viber.service.ViberPhoneService;
import com.viber.voip.AboutActivity;
import com.viber.voip.AddFriendPreviewActivity;
import com.viber.voip.HomeActivity;
import com.viber.voip.TabletHomeActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberConnectActivity;
import com.viber.voip.backgrounds.ui.BackgroundGalleryActivity;
import com.viber.voip.backgrounds.ui.CommunitySelectBackgroundActivity;
import com.viber.voip.backgrounds.ui.CommunitySelectBackgroundPresenter;
import com.viber.voip.backgrounds.ui.SelectBackgroundForVibeActivity;
import com.viber.voip.bg;
import com.viber.voip.calls.ui.GroupCallDetailsFragment;
import com.viber.voip.calls.ui.RecentCallsActivity;
import com.viber.voip.calls.ui.RecentCallsFragment;
import com.viber.voip.camrecorder.CustomCamTakeVideoActivity;
import com.viber.voip.contacts.ui.ConferenceContactsComposeListActivity;
import com.viber.voip.contacts.ui.ContactDetailsActivity;
import com.viber.voip.contacts.ui.ContactDetailsDialogActivity;
import com.viber.voip.contacts.ui.ContactDetailsFragment;
import com.viber.voip.contacts.ui.ContactsCompose1to1ListActivity;
import com.viber.voip.contacts.ui.ContactsComposeCombinedActivity;
import com.viber.voip.contacts.ui.ContactsComposeListActivity;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.contacts.ui.PublicGroupInviteContactsListActivity;
import com.viber.voip.contacts.ui.list.ParticipantsListActivity;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.g.a.a.ai.a;
import com.viber.voip.g.a.a.ai.a.a;
import com.viber.voip.g.a.a.as.a;
import com.viber.voip.g.a.a.as.a.a;
import com.viber.voip.g.a.a.at.a;
import com.viber.voip.g.a.a.at.a.a;
import com.viber.voip.g.a.a.bk.a;
import com.viber.voip.g.a.a.bk.a.a;
import com.viber.voip.g.a.a.bm.a;
import com.viber.voip.g.a.a.bm.a.a;
import com.viber.voip.g.a.a.bs.a;
import com.viber.voip.g.a.a.bs.a.a;
import com.viber.voip.g.a.a.bv.a;
import com.viber.voip.g.a.a.bv.a.a;
import com.viber.voip.g.a.a.bw.a;
import com.viber.voip.g.a.a.bw.a.a;
import com.viber.voip.g.a.a.by.a;
import com.viber.voip.g.a.a.by.a.a;
import com.viber.voip.g.a.a.bz.a;
import com.viber.voip.g.a.a.bz.a.a;
import com.viber.voip.g.a.a.ca.a;
import com.viber.voip.g.a.a.ca.a.a;
import com.viber.voip.g.a.a.cb.a;
import com.viber.voip.g.a.a.cb.a.a;
import com.viber.voip.g.a.a.cc.a;
import com.viber.voip.g.a.a.cc.a.a;
import com.viber.voip.g.a.a.cd.a;
import com.viber.voip.g.a.a.cd.a.a;
import com.viber.voip.g.a.a.ce.a;
import com.viber.voip.g.a.a.ce.a.a;
import com.viber.voip.g.a.a.cf.a;
import com.viber.voip.g.a.a.cf.a.a;
import com.viber.voip.g.a.a.cg.a;
import com.viber.voip.g.a.a.cg.a.a;
import com.viber.voip.g.a.a.ch.a;
import com.viber.voip.g.a.a.ch.a.a;
import com.viber.voip.g.a.a.ci.a;
import com.viber.voip.g.a.a.ci.a.a;
import com.viber.voip.g.a.a.cj.a;
import com.viber.voip.g.a.a.cj.a.a;
import com.viber.voip.g.a.a.cl;
import com.viber.voip.g.a.a.v.a;
import com.viber.voip.g.a.a.v.a.a;
import com.viber.voip.g.a.a.x.a;
import com.viber.voip.g.a.a.x.a.a;
import com.viber.voip.g.a.a.y.a;
import com.viber.voip.g.a.a.y.a.a;
import com.viber.voip.g.a.a.z.a;
import com.viber.voip.g.a.a.z.a.a;
import com.viber.voip.g.a.am;
import com.viber.voip.g.a.ao;
import com.viber.voip.g.a.as;
import com.viber.voip.g.a.au;
import com.viber.voip.g.a.bb;
import com.viber.voip.g.a.bc;
import com.viber.voip.g.a.be;
import com.viber.voip.g.a.bh;
import com.viber.voip.g.a.bi;
import com.viber.voip.g.a.bl;
import com.viber.voip.g.a.bo;
import com.viber.voip.g.a.bp;
import com.viber.voip.g.a.bx;
import com.viber.voip.g.a.bz;
import com.viber.voip.g.a.cb;
import com.viber.voip.g.a.cc;
import com.viber.voip.g.a.cd;
import com.viber.voip.g.a.ce;
import com.viber.voip.g.a.cf;
import com.viber.voip.g.a.cg;
import com.viber.voip.g.a.ci;
import com.viber.voip.g.a.ck;
import com.viber.voip.g.a.co;
import com.viber.voip.g.a.cq.a;
import com.viber.voip.g.a.cq.a.a;
import com.viber.voip.g.a.cr.a;
import com.viber.voip.g.a.cr.a.a;
import com.viber.voip.g.a.cs;
import com.viber.voip.g.a.cu;
import com.viber.voip.g.a.cv;
import com.viber.voip.g.a.cw;
import com.viber.voip.g.a.cx;
import com.viber.voip.g.a.cy;
import com.viber.voip.g.a.da;
import com.viber.voip.g.a.dc;
import com.viber.voip.g.a.de;
import com.viber.voip.g.a.dg;
import com.viber.voip.g.a.dh;
import com.viber.voip.g.a.di;
import com.viber.voip.g.a.dk;
import com.viber.voip.g.a.dl;
import com.viber.voip.g.a.dm;
import com.viber.voip.g.a.dn;
import com.viber.voip.g.a.do;
import com.viber.voip.g.a.dp;
import com.viber.voip.g.a.dq;
import com.viber.voip.g.a.dr;
import com.viber.voip.g.a.ds;
import com.viber.voip.g.a.dt;
import com.viber.voip.g.a.du;
import com.viber.voip.g.a.dv;
import com.viber.voip.g.a.dw;
import com.viber.voip.g.a.dx;
import com.viber.voip.g.a.dy;
import com.viber.voip.g.a.dz;
import com.viber.voip.g.a.ea;
import com.viber.voip.g.a.eb;
import com.viber.voip.g.a.ed;
import com.viber.voip.g.a.ee;
import com.viber.voip.g.a.ef;
import com.viber.voip.g.a.eg;
import com.viber.voip.g.a.eh;
import com.viber.voip.g.a.ej.a;
import com.viber.voip.g.a.ej.a.a;
import com.viber.voip.g.a.ek.a;
import com.viber.voip.g.a.ek.a.a;
import com.viber.voip.g.a.el;
import com.viber.voip.g.a.en;
import com.viber.voip.g.a.eo;
import com.viber.voip.g.a.ep;
import com.viber.voip.g.a.er;
import com.viber.voip.g.a.es;
import com.viber.voip.g.a.eu;
import com.viber.voip.g.a.ew;
import com.viber.voip.g.a.ey;
import com.viber.voip.g.a.fa;
import com.viber.voip.g.a.fc;
import com.viber.voip.g.a.fe;
import com.viber.voip.g.a.ff;
import com.viber.voip.g.a.fh;
import com.viber.voip.g.a.fj;
import com.viber.voip.g.a.fk;
import com.viber.voip.g.a.fl;
import com.viber.voip.g.a.fm.a;
import com.viber.voip.g.a.fm.a.a;
import com.viber.voip.g.a.fo;
import com.viber.voip.g.a.fp;
import com.viber.voip.g.a.fr;
import com.viber.voip.g.a.fs;
import com.viber.voip.g.a.ft;
import com.viber.voip.g.a.fu;
import com.viber.voip.g.a.fw;
import com.viber.voip.g.a.fx;
import com.viber.voip.g.a.fy;
import com.viber.voip.g.a.fz;
import com.viber.voip.g.a.gb;
import com.viber.voip.g.a.gc;
import com.viber.voip.g.a.ge;
import com.viber.voip.g.a.gf;
import com.viber.voip.g.a.gg;
import com.viber.voip.g.a.gh;
import com.viber.voip.g.a.gi;
import com.viber.voip.g.a.gj;
import com.viber.voip.g.a.gk;
import com.viber.voip.g.a.gl;
import com.viber.voip.g.a.gm;
import com.viber.voip.g.a.gn;
import com.viber.voip.g.a.gp;
import com.viber.voip.g.a.gq;
import com.viber.voip.g.a.gr;
import com.viber.voip.g.a.gs;
import com.viber.voip.g.a.gt;
import com.viber.voip.g.a.gu;
import com.viber.voip.g.a.gw;
import com.viber.voip.g.a.gx;
import com.viber.voip.g.a.gy;
import com.viber.voip.g.a.gz;
import com.viber.voip.g.a.ha;
import com.viber.voip.g.a.hb;
import com.viber.voip.g.a.hc;
import com.viber.voip.g.a.he;
import com.viber.voip.g.a.hf;
import com.viber.voip.g.a.hh;
import com.viber.voip.g.a.hj;
import com.viber.voip.gallery.selection.AddMoreGallery;
import com.viber.voip.gallery.selection.SelectionGallery;
import com.viber.voip.group.participants.ban.BannedParticipantsListPresenter;
import com.viber.voip.market.VOPurchaseDialogActivity;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.conversation.chatinfo.presentation.ChatInfoActivity;
import com.viber.voip.messages.conversation.chatinfo.presentation.ChatInfoGroupFragment;
import com.viber.voip.messages.conversation.commongroups.CommonGroupsActivity;
import com.viber.voip.messages.conversation.commongroups.CommonGroupsPresenter;
import com.viber.voip.messages.conversation.community.CommunityConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicChatsActivity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupsFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupsLeftMenuFragment;
import com.viber.voip.messages.conversation.publicaccount.TabletPublicGroupConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.ShareScreenshotActivity;
import com.viber.voip.messages.conversation.ui.aw;
import com.viber.voip.messages.conversation.ui.vote.ForwardCreatePollActivity;
import com.viber.voip.messages.conversation.ui.vote.VoteActivity;
import com.viber.voip.messages.conversation.ui.vote.VotePresenter;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserActivity;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserPartialSizeActivity;
import com.viber.voip.messages.extensions.activity.ChatExtensionPanelActivity;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsPresenter;
import com.viber.voip.messages.translation.SelectLanguageActivity;
import com.viber.voip.messages.translation.SelectUiLanguageActivity;
import com.viber.voip.messages.ui.BusinessInboxMessagesLeftMenuFragment;
import com.viber.voip.messages.ui.ConversationActivity;
import com.viber.voip.messages.ui.ConversationGalleryActivity;
import com.viber.voip.messages.ui.MessagesLeftMenuFragment;
import com.viber.voip.messages.ui.PublicAccountConversationActivity;
import com.viber.voip.messages.ui.SmsInboxMessagesLeftMenuFragment;
import com.viber.voip.messages.ui.bj;
import com.viber.voip.messages.ui.bk;
import com.viber.voip.messages.ui.bu;
import com.viber.voip.messages.ui.forward.ForwardActivity;
import com.viber.voip.messages.ui.forward.ForwardPresenter;
import com.viber.voip.messages.ui.forward.sharelink.ShareLinkActivity;
import com.viber.voip.messages.ui.media.LocationMessageActivityV2;
import com.viber.voip.messages.ui.media.ViewMediaActivity;
import com.viber.voip.messages.ui.media.WinkViewMediaActivity;
import com.viber.voip.messages.ui.media.player.FullScreenVideoPlayerActivity;
import com.viber.voip.messages.ui.media.simple.ViewMediaSimpleActivity;
import com.viber.voip.messages.ui.popup.PopupMessageActivity;
import com.viber.voip.news.HomeTabNewsBrowserFragment;
import com.viber.voip.news.ViberNewsArticleBrowserActivity;
import com.viber.voip.news.ViberNewsWebActivity;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.PhoneFragmentActivity_MembersInjector;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.conf.ConferenceParticipantsSelectFragment;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.phone.viber.InCallFragment_MembersInjector;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository_Factory;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper_Factory;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository_Factory;
import com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper;
import com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper_Factory;
import com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper_Factory;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper_Factory;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceHoldStateResolver_Factory;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceMicStateResolver_Factory;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceSpeakerStateResolver_Factory;
import com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallMvpView_Factory;
import com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallPresenter_Factory;
import com.viber.voip.phone.viber.endcall.EndCallFragment;
import com.viber.voip.phone.viber.endcall.EndCallFragment_MembersInjector;
import com.viber.voip.phone.viber.incall.GenericInCallMvpViewImpl_Factory;
import com.viber.voip.phone.viber.incall.GenericInCallPresenter_Factory;
import com.viber.voip.phone.viber.incoming.IncomingCallFragment;
import com.viber.voip.phone.viber.incoming.IncomingCallFragment_MembersInjector;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountEditActivity;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountEditFragment;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoActivity;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoFragment;
import com.viber.voip.publicaccount.ui.screen.info.tablet.PublicAccountInfoTabletActivity;
import com.viber.voip.publicaccount.ui.screen.info.tablet.PublicAccountInfoTabletFragment;
import com.viber.voip.qrcode.ScannerActivity;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.react.ViberReactActivity;
import com.viber.voip.registration.RegistrationActivity;
import com.viber.voip.registration.changephonenumber.ChangePhoneNumberActivity;
import com.viber.voip.sdk.SdkActivity;
import com.viber.voip.services.inbox.screen.BusinessInboxActivity;
import com.viber.voip.settings.ui.GeneralPreferenceFragment;
import com.viber.voip.settings.ui.ManageStorageActivity;
import com.viber.voip.settings.ui.SettingsHeadersActivity;
import com.viber.voip.settings.ui.SettingsTabletActivity;
import com.viber.voip.settings.ui.ag;
import com.viber.voip.storage.conversation.ManageConversationStorageActivity;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.editinfo.EditInfoFragment;
import com.viber.voip.user.editinfo.EditInfoFragment_MembersInjector;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.user.editinfo.UserInfoRepository_Factory;
import com.viber.voip.user.more.MoreActivity;
import com.viber.voip.user.more.MoreActivity_MembersInjector;
import com.viber.voip.user.more.MoreDialogActivity;
import com.viber.voip.user.more.MoreFragment;
import com.viber.voip.user.more.MoreFragment_MembersInjector;
import com.viber.voip.util.cj;
import com.viber.voip.viberout.ui.CreditCardCheckoutWebActivity;
import com.viber.voip.viberout.ui.products.ViberOutProductsActivity;
import com.viber.voip.viberout.ui.products.ViberOutProductsPresenter;
import com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter;
import com.viber.voip.viberout.ui.products.countryplans.ViberOutCountryPlansActivity;
import com.viber.voip.viberout.ui.products.countryplans.ViberOutCountryPlansInfoPresenter;
import com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter;
import com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter;
import com.viber.voip.vln.VlnActivity;
import com.viber.voip.vln.ui.SmsInboxActivity;
import com.viber.voip.workers.EmailCollectionWorker;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class b
  implements a
{
  private Provider<com.viber.voip.messages.ui.aj> A;
  private Provider<com.viber.voip.messages.ui.ai> B;
  private com.viber.voip.g.a.bm C;
  private com.viber.voip.g.a.bn D;
  private Provider<com.viber.voip.notif.f> E;
  private Provider<com.google.d.f> F;
  private Provider<com.viber.voip.messages.extensions.i> G;
  private Provider<com.viber.voip.messages.extensions.c> H;
  private Provider<com.viber.voip.messages.extensions.d.a> I;
  private gy J;
  private Provider<com.viber.voip.messages.extensions.d.b> K;
  private com.viber.voip.g.a.ab L;
  private com.viber.voip.g.a.ad M;
  private com.viber.voip.g.a.u N;
  private cg O;
  private com.viber.voip.g.a.ba P;
  private ConferenceParticipantMapper_Factory Q;
  private cc R;
  private com.viber.voip.g.a.aj S;
  private ep T;
  private Provider<com.viber.voip.messages.controller.bn> U;
  private dc V;
  private fw W;
  private com.viber.voip.g.a.v X;
  private ee Y;
  private com.viber.voip.g.a.b Z;
  private ViberApplication a;
  private com.viber.voip.g.a.ai aA;
  private Provider<RefWatcher> aB;
  private Provider<y.a.a> aC;
  private Provider<com.viber.voip.g.a.a.bb.a.a> aD;
  private Provider<com.viber.voip.g.a.a.a.a.a> aE;
  private Provider<cd.a.a> aF;
  private Provider<com.viber.voip.g.a.a.aj.a.a> aG;
  private Provider<com.viber.voip.g.a.a.k.a.a> aH;
  private Provider<com.viber.voip.g.a.a.ao.a.a> aI;
  private Provider<com.viber.voip.g.a.a.m.a.a> aJ;
  private Provider<com.viber.voip.g.a.a.bj.a.a> aK;
  private Provider<com.viber.voip.g.a.a.b.a.a> aL;
  private Provider<com.viber.voip.g.a.a.ba.a.a> aM;
  private Provider<com.viber.voip.g.a.a.q.a.a> aN;
  private Provider<bk.a.a> aO;
  private Provider<bz.a.a> aP;
  private Provider<com.viber.voip.g.a.a.ab.a.a> aQ;
  private Provider<com.viber.voip.g.a.a.bo.a.a> aR;
  private Provider<com.viber.voip.g.a.a.bp.a.a> aS;
  private Provider<com.viber.voip.g.a.a.h.a.a> aT;
  private Provider<com.viber.voip.g.a.a.bt.a.a> aU;
  private Provider<cg.a.a> aV;
  private Provider<cj.a.a> aW;
  private Provider<ci.a.a> aX;
  private Provider<bv.a.a> aY;
  private Provider<com.viber.voip.g.a.a.s.a.a> aZ;
  private ce aa;
  private cl ab;
  private en ac;
  private Provider<com.viber.voip.util.e.e> ad;
  private dr ae;
  private Provider<com.viber.voip.flatbuffers.b.a<ConferenceInfo>> af;
  private ConferenceCallMapper_Factory ag;
  private com.viber.voip.g.a.bt ah;
  private Provider<ConferenceCallsDatabaseHelper> ai;
  private Provider<com.viber.voip.flatbuffers.b.b<ConferenceInfo>> aj;
  private Provider<ConferenceParticipantsRepository> ak;
  private gr al;
  private Provider<ConferenceCallsRepository> am;
  private fr an;
  private fs ao;
  private Provider<com.viber.voip.messages.controller.manager.l> ap;
  private gz aq;
  private com.viber.voip.g.a.bd ar;
  private Provider<com.viber.voip.analytics.story.b.a.h> as;
  private com.viber.voip.analytics.story.b.a.g at;
  private com.viber.voip.g.a.y au;
  private Provider<com.viber.voip.ui.j.av> av;
  private bo aw;
  private Provider<com.viber.voip.j.a.a.c> ax;
  private gc ay;
  private gb az;
  private Provider<ViberApplication> b;
  private Provider<com.viber.voip.g.a.a.bx.a.a> bA;
  private Provider<by.a.a> bB;
  private Provider<com.viber.voip.g.a.a.o.a.a> bC;
  private Provider<com.viber.voip.g.a.a.bq.a.a> bD;
  private Provider<com.viber.voip.g.a.a.ac.a.a> bE;
  private Provider<com.viber.voip.g.a.a.az.a.a> bF;
  private Provider<bw.a.a> bG;
  private Provider<com.viber.voip.g.a.a.aa.a.a> bH;
  private Provider<com.viber.voip.g.a.a.bn.a.a> bI;
  private Provider<com.viber.voip.g.a.a.c.a.a> bJ;
  private Provider<com.viber.voip.g.a.a.ad.a.a> bK;
  private Provider<cc.a.a> bL;
  private Provider<cf.a.a> bM;
  private Provider<cq.a.a> bN;
  private Provider<cr.a.a> bO;
  private Provider<ek.a.a> bP;
  private Provider<ej.a.a> bQ;
  private Provider<bs.a.a> bR;
  private Provider<com.viber.voip.g.a.a.i.a.a> bS;
  private Provider<com.viber.voip.g.a.a.af.a.a> bT;
  private Provider<com.viber.voip.g.a.a.f.a.a> bU;
  private Provider<com.viber.voip.g.a.a.an.a.a> bV;
  private Provider<com.viber.voip.g.a.a.am.a.a> bW;
  private Provider<com.viber.voip.g.a.a.ah.a.a> bX;
  private Provider<z.a.a> bY;
  private Provider<com.viber.voip.g.a.a.p.a.a> bZ;
  private Provider<com.viber.voip.g.a.a.t.a.a> ba;
  private Provider<com.viber.voip.g.a.a.aw.a.a> bb;
  private Provider<com.viber.voip.g.a.a.ax.a.a> bc;
  private Provider<com.viber.voip.g.a.a.br.a.a> bd;
  private Provider<com.viber.voip.g.a.a.j.a.a> be;
  private Provider<com.viber.voip.g.a.a.bl.a.a> bf;
  private Provider<bm.a.a> bg;
  private Provider<com.viber.voip.g.a.a.bi.a.a> bh;
  private Provider<com.viber.voip.g.a.a.bg.a.a> bi;
  private Provider<com.viber.voip.g.a.a.e.a.a> bj;
  private Provider<cb.a.a> bk;
  private Provider<com.viber.voip.g.a.a.r.a.a> bl;
  private Provider<com.viber.voip.g.a.a.l.a.a> bm;
  private Provider<com.viber.voip.g.a.a.u.a.a> bn;
  private Provider<v.a.a> bo;
  private Provider<com.viber.voip.g.a.a.w.a.a> bp;
  private Provider<ai.a.a> bq;
  private Provider<ce.a.a> br;
  private Provider<com.viber.voip.g.a.a.bh.a.a> bs;
  private Provider<com.viber.voip.g.a.a.ay.a.a> bt;
  private Provider<com.viber.voip.g.a.a.bc.a.a> bu;
  private Provider<com.viber.voip.g.a.a.n.a.a> bv;
  private Provider<com.viber.voip.g.a.a.bd.a.a> bw;
  private Provider<com.viber.voip.g.a.a.be.a.a> bx;
  private Provider<at.a.a> by;
  private Provider<com.viber.voip.g.a.a.aq.a.a> bz;
  private com.viber.voip.g.a.ah c;
  private dm cA;
  private Provider<com.viber.voip.api.a.a.a> cB;
  private Provider<com.viber.voip.report.a.b> cC;
  private dq cD;
  private dy cE;
  private eh cF;
  private hb cG;
  private be cH;
  private Provider<com.viber.voip.messages.extensions.a> cI;
  private Provider<com.viber.voip.ads.b.a.a.m> cJ;
  private Provider<com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>> cK;
  private com.viber.voip.g.a.n cL;
  private com.viber.voip.g.a.q cM;
  private com.viber.voip.g.a.o cN;
  private Provider<com.viber.voip.ads.b.c.b.f> cO;
  private Provider<com.viber.voip.util.e.f> cP;
  private Provider<com.viber.voip.util.e.f> cQ;
  private Provider<com.viber.voip.ads.b.c.a.b> cR;
  private com.viber.voip.g.a.w cS;
  private bx cT;
  private com.viber.voip.g.a.bf cU;
  private com.viber.voip.g.a.ak cV;
  private Provider<com.viber.voip.viberout.a.l> cW;
  private da cX;
  private com.viber.voip.g.a.af cY;
  private Provider<com.viber.voip.ads.b.c.b.f> cZ;
  private Provider<com.viber.voip.g.a.a.bf.a.a> ca;
  private Provider<com.viber.voip.g.a.a.bu.a.a> cb;
  private Provider<com.viber.voip.g.a.a.ak.a.a> cc;
  private Provider<com.viber.voip.g.a.a.g.a.a> cd;
  private Provider<com.viber.voip.g.a.a.al.a.a> ce;
  private Provider<com.viber.voip.g.a.a.av.a.a> cf;
  private Provider<com.viber.voip.g.a.a.ap.a.a> cg;
  private Provider<com.viber.voip.g.a.a.d.a.a> ch;
  private Provider<com.viber.voip.g.a.a.ae.a.a> ci;
  private Provider<com.viber.voip.g.a.a.ag.a.a> cj;
  private Provider<com.viber.voip.g.a.a.au.a.a> ck;
  private Provider<com.viber.voip.g.a.a.ar.a.a> cl;
  private Provider<as.a.a> cm;
  private Provider<x.a.a> cn;
  private Provider<ch.a.a> co;
  private Provider<ca.a.a> cp;
  private cf cq;
  private cb cr;
  private fo cs;
  private com.viber.voip.g.a.x ct;
  private Provider<com.viber.voip.api.a.b.a> cu;
  private Provider<com.viber.voip.news.q> cv;
  private Provider<com.viber.voip.messages.ui.media.player.d.e> cw;
  private com.viber.voip.g.a.t cx;
  private Provider<com.viber.voip.util.e.g> cy;
  private dp cz;
  private Provider<com.viber.voip.messages.extras.c.a> d;
  private dn da;
  private Provider<com.viber.voip.ads.b.c.b.f> db;
  private bc dc;
  private Provider<com.viber.voip.util.i.a> dd;
  private com.viber.voip.g.a.z de;
  private ds df;
  private am dg;
  private Provider<com.viber.voip.ads.a.b> dh;
  private bp di;
  private Provider<com.viber.voip.engagement.a> dj;
  private Provider<com.viber.voip.r.a> dk;
  private dl dl;
  private do dm;
  private Provider<ConversationsScreenScrollCdrController> dn;
  private Provider<com.viber.voip.ads.b.c.b.f> jdField_do;
  private bb dp;
  private gj dq;
  private com.viber.voip.invitelinks.ac dr;
  private dh ds;
  private di dt;
  private Provider<com.viber.voip.storage.a.i> du;
  private cd e;
  private Provider<com.viber.voip.backup.h> f;
  private Provider<com.viber.voip.backup.c> g;
  private Provider<EventBus> h;
  private com.viber.voip.g.a.ac i;
  private com.viber.voip.g.a.aa j;
  private Provider<com.viber.voip.react.d> k;
  private Provider<Map<String, com.viber.voip.react.d>> l;
  private Provider<ReactContextManager> m;
  private hc n;
  private Provider<com.viber.voip.vln.e> o;
  private Provider<com.viber.voip.l.a> p;
  private bz q;
  private Provider<com.viber.voip.app.b> r;
  private Provider<com.viber.common.permission.c> s;
  private Provider<com.viber.voip.bf> t;
  private Provider<com.viber.voip.gdpr.a.a> u;
  private Provider<com.viber.voip.messages.controller.manager.ab> v;
  private Provider<al> w;
  private Provider<com.viber.voip.messages.controller.manager.ak> x;
  private Provider<com.viber.voip.util.i.c> y;
  private Provider<com.viber.voip.messages.extensions.f> z;

  private b(o paramo)
  {
    a(paramo);
    b(paramo);
    c(paramo);
  }

  private OnlineUserActivityHelper A()
  {
    return gw.a(m());
  }

  private com.viber.voip.analytics.story.d.c B()
  {
    return com.viber.voip.g.a.x.a(com.viber.voip.g.a.s.c());
  }

  private com.viber.voip.analytics.story.g.a C()
  {
    return com.viber.voip.g.a.ac.a(com.viber.voip.g.a.s.c());
  }

  private com.viber.voip.analytics.story.b.c D()
  {
    return com.viber.voip.g.a.u.a(com.viber.voip.g.a.s.c());
  }

  private com.viber.voip.analytics.story.a.a E()
  {
    return com.viber.voip.g.a.t.a(com.viber.voip.g.a.s.c());
  }

  private com.viber.voip.messages.controller.manager.c F()
  {
    return dk.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.messages.controller.ai G()
  {
    return dq.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.invitelinks.d H()
  {
    return dn.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.messages.extras.a.e I()
  {
    return fo.a(this.a);
  }

  private com.viber.voip.analytics.story.c.c J()
  {
    return com.viber.voip.g.a.w.a(com.viber.voip.g.a.s.c());
  }

  private Resources K()
  {
    return com.viber.voip.g.a.ak.a(l());
  }

  private cj L()
  {
    return eh.a(l());
  }

  private com.viber.voip.analytics.story.m.e M()
  {
    return com.viber.voip.g.a.af.a(com.viber.voip.g.a.s.c());
  }

  private EngineDelegatesManager N()
  {
    return cc.a(m());
  }

  private ViberOutBalanceListener O()
  {
    return da.a(N());
  }

  private TrustPeerController P()
  {
    return fh.a(m());
  }

  private com.viber.voip.analytics.story.i.c Q()
  {
    return com.viber.voip.g.a.ae.a(com.viber.voip.g.a.s.c());
  }

  private Map<String, com.viber.voip.react.d> R()
  {
    return Collections.singletonMap("ReactVLN", this.k.get());
  }

  private Im2Exchanger S()
  {
    return ce.a(m());
  }

  private com.viber.voip.messages.controller.a T()
  {
    return dm.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.messages.controller.manager.ah U()
  {
    return dw.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.ui.f.c V()
  {
    return cs.a(this.a, (com.viber.voip.news.q)this.cv.get());
  }

  private com.viber.voip.messages.controller.publicaccount.d W()
  {
    return dy.a((com.viber.voip.messages.k)this.ap.get());
  }

  private ConferenceParticipantMapper X()
  {
    return new ConferenceParticipantMapper((com.viber.voip.util.i.e)this.y.get());
  }

  private com.viber.voip.stickers.f Y()
  {
    return fy.a(fz.c());
  }

  private com.viber.voip.stickers.a.a Z()
  {
    return fw.a(fz.c());
  }

  private void a(o paramo)
  {
    this.b = dagger.a.e.a(o.a(paramo));
    this.c = com.viber.voip.g.a.ah.a(this.b);
    this.d = dagger.a.c.a(fp.a(this.c, com.viber.voip.g.a.s.b()));
    this.e = cd.a(this.b);
    this.f = dagger.a.c.a(com.viber.voip.g.a.aq.a(this.c, com.viber.voip.g.a.ap.b(), ao.b(), gg.b(), this.e));
    this.g = dagger.a.c.a(com.viber.voip.g.a.an.a(this.c, this.e, com.viber.voip.g.a.ap.b()));
    this.h = dagger.a.c.a(ci.b());
    this.i = com.viber.voip.g.a.ac.a(com.viber.voip.g.a.s.b());
    this.j = com.viber.voip.g.a.aa.a(this.c);
    this.k = dagger.a.c.a(hf.a(this.j, gn.b(), this.h, com.viber.voip.g.a.s.b()));
    this.l = dagger.a.g.a(1).a("ReactVLN", this.k).a();
    this.m = dagger.a.c.a(fa.a(this.l, gn.b()));
    this.n = hc.a(this.e);
    this.o = dagger.a.c.a(he.a(this.b, this.m, this.n));
    this.p = dagger.a.c.a(de.a(this.c, this.e, this.h, this.i, this.o));
    this.q = bz.a(gg.b(), gn.b(), fz.b(), ck.b());
    this.r = dagger.a.c.a(com.viber.voip.app.d.a(this.c, this.h));
    this.s = dagger.a.c.a(eu.a(this.c));
    this.t = dagger.a.c.a(bg.a(this.c));
    this.u = dagger.a.c.a(com.viber.voip.gdpr.a.b.a(this.c));
    this.v = dagger.a.c.a(dv.b());
    this.w = dagger.a.c.a(es.b());
    this.x = dagger.a.c.a(er.b());
    this.y = dagger.a.c.a(com.viber.voip.util.i.d.b());
    this.z = dagger.a.c.a(com.viber.voip.messages.extensions.g.a(this.y));
    this.A = dagger.a.c.a(cv.b());
    this.B = dagger.a.c.a(cu.a(this.c));
    this.C = com.viber.voip.g.a.bm.a(this.b);
    this.D = com.viber.voip.g.a.bn.a(this.C);
    this.E = dagger.a.c.a(eo.a(this.c, this.b));
    this.F = dagger.a.c.a(fl.b());
    this.G = dagger.a.c.a(bi.b());
    this.H = dagger.a.c.a(com.viber.voip.messages.extensions.e.a(ed.b(), this.z, this.G, du.b()));
    this.I = dagger.a.c.a(bh.a(this.y));
    this.J = gy.a(this.n);
    this.K = dagger.a.c.a(com.viber.voip.messages.extensions.d.c.a(this.c, this.b, this.H, this.I, this.z, this.J));
    this.L = com.viber.voip.g.a.ab.a(com.viber.voip.g.a.s.b());
    this.M = com.viber.voip.g.a.ad.a(com.viber.voip.g.a.s.b());
    this.N = com.viber.voip.g.a.u.a(com.viber.voip.g.a.s.b());
    this.O = cg.a(this.e);
    this.P = com.viber.voip.g.a.ba.a(this.e);
    this.Q = ConferenceParticipantMapper_Factory.create(this.y);
    this.R = cc.a(this.e);
    this.S = com.viber.voip.g.a.aj.a(this.c);
    this.T = ep.a(this.c);
    this.U = dagger.a.c.a(com.viber.voip.messages.controller.br.a(this.c, this.S, this.v, this.T, this.r));
    this.V = dc.a(this.b);
    this.W = fw.a(fz.b());
    this.X = com.viber.voip.g.a.v.a(this.e);
    this.Y = ee.a(this.b);
    this.Z = com.viber.voip.g.a.b.a(this.b);
    this.aa = ce.a(this.e);
    this.ab = cl.a(this.b);
    this.ac = en.a(this.T);
    this.ad = dagger.a.c.a(cw.a(this.c));
    this.ae = dr.a(this.c);
    this.af = dagger.a.c.a(fj.b());
    this.ag = ConferenceCallMapper_Factory.create(this.af);
    this.ah = com.viber.voip.g.a.bt.a(this.c);
    this.ai = dagger.a.c.a(ConferenceCallsDatabaseHelper_Factory.create(this.ah, this.ag));
    this.aj = dagger.a.c.a(fk.b());
    this.ak = new dagger.a.b();
    this.al = gr.a(this.c);
    this.am = dagger.a.c.a(ConferenceCallsRepository_Factory.create(this.P, this.R, this.ag, this.ai, gn.b(), gg.b(), this.aj, this.V, com.viber.voip.g.a.br.b(), this.ae, this.ak, this.al, this.J, this.y));
    this.an = fr.a(this.c);
    this.ao = fs.a(this.c);
    this.ap = dagger.a.c.a(com.viber.voip.messages.controller.manager.n.a(this.c, gn.b(), gk.b(), gi.b(), gh.b(), gl.b(), gg.b(), ge.b(), this.e, this.R, this.r, this.h, this.v, this.n, this.J, du.b(), this.U, this.V, this.w, this.x, dx.b(), com.viber.voip.g.a.s.b(), this.H, this.W, this.B, this.P, ed.b(), this.O, this.X, this.Y, this.Z, this.aa, this.s, this.ab, this.ac, this.C, this.z, this.ad, this.ae, com.viber.voip.g.a.bs.b(), this.am, this.F, this.an, this.ao));
    this.aq = gz.a(this.ap);
    this.ar = com.viber.voip.g.a.bd.a(this.R);
    dagger.a.b localb = (dagger.a.b)this.ak;
    this.ak = dagger.a.c.a(ConferenceParticipantsRepository_Factory.create(this.J, this.P, gn.b(), gh.b(), this.Q, this.aq, this.ar));
    localb.a(this.ak);
    this.as = dagger.a.c.a(com.viber.voip.analytics.story.b.a.k.a(this.N, this.O, this.J, this.ak, this.P, gm.b()));
    this.at = com.viber.voip.analytics.story.b.a.g.a(this.N, this.O, this.J, this.ak, gm.b(), com.viber.voip.g.a.bs.b());
    this.au = com.viber.voip.g.a.y.a(com.viber.voip.g.a.s.b());
    this.av = dagger.a.c.a(gt.b());
    this.aw = bo.a(this.C);
    this.ax = dagger.a.c.a(fu.a(o.b(paramo), this.c, hj.b(), this.Z, this.s, this.X, this.F, this.aw));
    this.ay = gc.a(this.ap);
    this.az = gb.a(this.ay);
    this.aA = com.viber.voip.g.a.ai.a(this.b);
    this.aB = dagger.a.c.a(com.viber.voip.g.a.bv.a(this.aA));
    this.aC = new Provider()
    {
      public y.a.a a()
      {
        return new b.ax(b.this, null);
      }
    };
    this.aD = new Provider()
    {
      public com.viber.voip.g.a.a.bb.a.a a()
      {
        return new b.dl(b.this, null);
      }
    };
    this.aE = new Provider()
    {
      public com.viber.voip.g.a.a.a.a.a a()
      {
        return new b.a(b.this, null);
      }
    };
    this.aF = new Provider()
    {
      public cd.a.a a()
      {
        return new b.fv(b.this, null);
      }
    };
    this.aG = new Provider()
    {
      public com.viber.voip.g.a.a.aj.a.a a()
      {
        return new b.bt(b.this, null);
      }
    };
    this.aH = new Provider()
    {
      public com.viber.voip.g.a.a.k.a.a a()
      {
        return new b.v(b.this, null);
      }
    };
    this.aI = new Provider()
    {
      public com.viber.voip.g.a.a.ao.a.a a()
      {
        return new b.cj(b.this, null);
      }
    };
    this.aJ = new Provider()
    {
      public com.viber.voip.g.a.a.m.a.a a()
      {
        return new b.z(b.this, null);
      }
    };
    this.aK = new Provider()
    {
      public com.viber.voip.g.a.a.bj.a.a a()
      {
        return new b.ed(b.this, null);
      }
    };
    this.aL = new Provider()
    {
      public com.viber.voip.g.a.a.b.a.a a()
      {
        return new b.c(b.this, null);
      }
    };
    this.aM = new Provider()
    {
      public com.viber.voip.g.a.a.ba.a.a a()
      {
        return new b.dj(b.this, null);
      }
    };
    this.aN = new Provider()
    {
      public com.viber.voip.g.a.a.q.a.a a()
      {
        return new b.ah(b.this, null);
      }
    };
    this.aO = new Provider()
    {
      public bk.a.a a()
      {
        return new b.ef(b.this, null);
      }
    };
    this.aP = new Provider()
    {
      public bz.a.a a()
      {
        return new b.fn(b.this, null);
      }
    };
    this.aQ = new Provider()
    {
      public com.viber.voip.g.a.a.ab.a.a a()
      {
        return new b.fl(b.this, null);
      }
    };
    this.aR = new Provider()
    {
      public com.viber.voip.g.a.a.bo.a.a a()
      {
        return new b.en(b.this, null);
      }
    };
    this.aS = new Provider()
    {
      public com.viber.voip.g.a.a.bp.a.a a()
      {
        return new b.ep(b.this, null);
      }
    };
    this.aT = new Provider()
    {
      public com.viber.voip.g.a.a.h.a.a a()
      {
        return new b.p(b.this, null);
      }
    };
    this.aU = new Provider()
    {
      public com.viber.voip.g.a.a.bt.a.a a()
      {
        return new b.ex(b.this, null);
      }
    };
    this.aV = new Provider()
    {
      public cg.a.a a()
      {
        return new b.bp(b.this, null);
      }
    };
  }

  private com.viber.voip.q.i aa()
  {
    return ea.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.u.d ab()
  {
    return dz.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.analytics.story.f.d ac()
  {
    return com.viber.voip.g.a.ab.a(com.viber.voip.g.a.s.c());
  }

  private UserData ad()
  {
    return ha.a(n());
  }

  private com.viber.voip.calls.d ae()
  {
    return com.viber.voip.g.a.bf.a(this.a);
  }

  private com.viber.voip.messages.controller.bs af()
  {
    return dr.a(l());
  }

  private com.viber.voip.util.cn ag()
  {
    return gr.a(l());
  }

  private com.viber.voip.notif.g ah()
  {
    return ep.a(l());
  }

  private com.viber.voip.notif.e.m ai()
  {
    return en.a(ah());
  }

  private com.viber.voip.storage.repository.u aj()
  {
    return di.a(com.viber.voip.g.a.br.c(), dagger.a.c.b(du.b()), (com.google.d.f)this.F.get());
  }

  private ViberApplication b(ViberApplication paramViberApplication)
  {
    com.viber.voip.bd.a(paramViberApplication, dagger.a.c.b(this.d));
    com.viber.voip.bd.b(paramViberApplication, dagger.a.c.b(this.f));
    com.viber.voip.bd.c(paramViberApplication, dagger.a.c.b(this.g));
    com.viber.voip.bd.d(paramViberApplication, dagger.a.c.b(this.p));
    com.viber.voip.bd.e(paramViberApplication, dagger.a.c.b(this.q));
    com.viber.voip.bd.a(paramViberApplication, (EventBus)this.h.get());
    com.viber.voip.bd.a(paramViberApplication, (com.viber.voip.app.b)this.r.get());
    com.viber.voip.bd.f(paramViberApplication, dagger.a.c.b(this.s));
    com.viber.voip.bd.g(paramViberApplication, dagger.a.c.b(com.viber.voip.g.a.p.b()));
    com.viber.voip.bd.a(paramViberApplication, (com.viber.voip.bf)this.t.get());
    com.viber.voip.bd.a(paramViberApplication, (com.viber.voip.gdpr.a.a)this.u.get());
    com.viber.voip.bd.h(paramViberApplication, dagger.a.c.b(gs.b()));
    com.viber.voip.bd.i(paramViberApplication, dagger.a.c.b(dx.b()));
    com.viber.voip.bd.j(paramViberApplication, dagger.a.c.b(this.v));
    com.viber.voip.bd.k(paramViberApplication, dagger.a.c.b(this.w));
    com.viber.voip.bd.l(paramViberApplication, dagger.a.c.b(this.x));
    com.viber.voip.bd.m(paramViberApplication, dagger.a.c.b(this.z));
    com.viber.voip.bd.n(paramViberApplication, dagger.a.c.b(this.A));
    com.viber.voip.bd.o(paramViberApplication, dagger.a.c.b(this.B));
    com.viber.voip.bd.p(paramViberApplication, dagger.a.c.b(this.D));
    com.viber.voip.bd.q(paramViberApplication, dagger.a.c.b(this.E));
    com.viber.voip.bd.r(paramViberApplication, dagger.a.c.b(this.F));
    com.viber.voip.bd.a(paramViberApplication, (com.viber.voip.messages.extensions.c)this.H.get());
    com.viber.voip.bd.s(paramViberApplication, dagger.a.c.b(this.K));
    com.viber.voip.bd.t(paramViberApplication, dagger.a.c.b(this.L));
    com.viber.voip.bd.u(paramViberApplication, dagger.a.c.b(this.i));
    com.viber.voip.bd.v(paramViberApplication, dagger.a.c.b(this.M));
    com.viber.voip.bd.w(paramViberApplication, dagger.a.c.b(this.as));
    com.viber.voip.bd.x(paramViberApplication, dagger.a.c.b(this.at));
    com.viber.voip.bd.y(paramViberApplication, dagger.a.c.b(this.au));
    com.viber.voip.bd.z(paramViberApplication, dagger.a.c.b(this.av));
    com.viber.voip.bd.A(paramViberApplication, dagger.a.c.b(this.ax));
    com.viber.voip.bd.B(paramViberApplication, dagger.a.c.b(this.ad));
    com.viber.voip.bd.C(paramViberApplication, dagger.a.c.b(this.ap));
    com.viber.voip.bd.D(paramViberApplication, dagger.a.c.b(this.U));
    com.viber.voip.bd.E(paramViberApplication, dagger.a.c.b(this.az));
    com.viber.voip.bd.F(paramViberApplication, dagger.a.c.b(this.am));
    com.viber.voip.bd.G(paramViberApplication, dagger.a.c.b(this.ak));
    com.viber.voip.bd.H(paramViberApplication, dagger.a.c.b(this.ao));
    com.viber.voip.bd.I(paramViberApplication, dagger.a.c.b(this.an));
    com.viber.voip.bd.J(paramViberApplication, dagger.a.c.b(this.aB));
    com.viber.voip.bd.a(paramViberApplication, g());
    com.viber.voip.bd.b(paramViberApplication, i());
    com.viber.voip.bd.c(paramViberApplication, k());
    return paramViberApplication;
  }

  private SdkActivity b(SdkActivity paramSdkActivity)
  {
    com.viber.voip.sdk.d.a(paramSdkActivity, (com.viber.voip.app.b)this.r.get());
    com.viber.voip.sdk.d.a(paramSdkActivity, (com.viber.common.permission.c)this.s.get());
    com.viber.voip.sdk.d.a(paramSdkActivity, p());
    com.viber.voip.sdk.d.a(paramSdkActivity, bl.b());
    com.viber.voip.sdk.d.a(paramSdkActivity, q());
    com.viber.voip.sdk.d.a(paramSdkActivity, dagger.a.c.b(this.cr));
    com.viber.voip.sdk.d.b(paramSdkActivity, dagger.a.c.b(this.cs));
    com.viber.voip.sdk.d.c(paramSdkActivity, dagger.a.c.b(this.d));
    com.viber.voip.sdk.d.d(paramSdkActivity, dagger.a.c.b(dx.b()));
    com.viber.voip.sdk.d.e(paramSdkActivity, dagger.a.c.b(this.ct));
    com.viber.voip.sdk.d.f(paramSdkActivity, dagger.a.c.b(this.N));
    return paramSdkActivity;
  }

  private EmailCollectionWorker b(EmailCollectionWorker paramEmailCollectionWorker)
  {
    com.viber.voip.workers.a.a(paramEmailCollectionWorker, (com.viber.voip.j.a.a.c)this.ax.get());
    return paramEmailCollectionWorker;
  }

  private void b(o paramo)
  {
    this.aW = new Provider()
    {
      public cj.a.a a()
      {
        return new b.dx(b.this, null);
      }
    };
    this.aX = new Provider()
    {
      public ci.a.a a()
      {
        return new b.dt(b.this, null);
      }
    };
    this.aY = new Provider()
    {
      public bv.a.a a()
      {
        return new b.fd(b.this, null);
      }
    };
    this.aZ = new Provider()
    {
      public com.viber.voip.g.a.a.s.a.a a()
      {
        return new b.al(b.this, null);
      }
    };
    this.ba = new Provider()
    {
      public com.viber.voip.g.a.a.t.a.a a()
      {
        return new b.an(b.this, null);
      }
    };
    this.bb = new Provider()
    {
      public com.viber.voip.g.a.a.aw.a.a a()
      {
        return new b.cz(b.this, null);
      }
    };
    this.bc = new Provider()
    {
      public com.viber.voip.g.a.a.ax.a.a a()
      {
        return new b.db(b.this, null);
      }
    };
    this.bd = new Provider()
    {
      public com.viber.voip.g.a.a.br.a.a a()
      {
        return new b.et(b.this, null);
      }
    };
    this.be = new Provider()
    {
      public com.viber.voip.g.a.a.j.a.a a()
      {
        return new b.t(b.this, null);
      }
    };
    this.bf = new Provider()
    {
      public com.viber.voip.g.a.a.bl.a.a a()
      {
        return new b.eh(b.this, null);
      }
    };
    this.bg = new Provider()
    {
      public bm.a.a a()
      {
        return new b.ej(b.this, null);
      }
    };
    this.bh = new Provider()
    {
      public com.viber.voip.g.a.a.bi.a.a a()
      {
        return new b.eb(b.this, null);
      }
    };
    this.bi = new Provider()
    {
      public com.viber.voip.g.a.a.bg.a.a a()
      {
        return new b.fx(b.this, null);
      }
    };
    this.bj = new Provider()
    {
      public com.viber.voip.g.a.a.e.a.a a()
      {
        return new b.i(b.this, null);
      }
    };
    this.bk = new Provider()
    {
      public cb.a.a a()
      {
        return new b.fr(b.this, null);
      }
    };
    this.bl = new Provider()
    {
      public com.viber.voip.g.a.a.r.a.a a()
      {
        return new b.aj(b.this, null);
      }
    };
    this.bm = new Provider()
    {
      public com.viber.voip.g.a.a.l.a.a a()
      {
        return new b.x(b.this, null);
      }
    };
    this.bn = new Provider()
    {
      public com.viber.voip.g.a.a.u.a.a a()
      {
        return new b.ap(b.this, null);
      }
    };
    this.bo = new Provider()
    {
      public v.a.a a()
      {
        return new b.ar(b.this, null);
      }
    };
    this.bp = new Provider()
    {
      public com.viber.voip.g.a.a.w.a.a a()
      {
        return new b.at(b.this, null);
      }
    };
    this.bq = new Provider()
    {
      public ai.a.a a()
      {
        return new b.br(b.this, null);
      }
    };
    this.br = new Provider()
    {
      public ce.a.a a()
      {
        return new b.fz(b.this, null);
      }
    };
    this.bs = new Provider()
    {
      public com.viber.voip.g.a.a.bh.a.a a()
      {
        return new b.dz(b.this, null);
      }
    };
    this.bt = new Provider()
    {
      public com.viber.voip.g.a.a.ay.a.a a()
      {
        return new b.df(b.this, null);
      }
    };
    this.bu = new Provider()
    {
      public com.viber.voip.g.a.a.bc.a.a a()
      {
        return new b.dn(b.this, null);
      }
    };
    this.bv = new Provider()
    {
      public com.viber.voip.g.a.a.n.a.a a()
      {
        return new b.ab(b.this, null);
      }
    };
    this.bw = new Provider()
    {
      public com.viber.voip.g.a.a.bd.a.a a()
      {
        return new b.dp(b.this, null);
      }
    };
    this.bx = new Provider()
    {
      public com.viber.voip.g.a.a.be.a.a a()
      {
        return new b.dr(b.this, null);
      }
    };
    this.by = new Provider()
    {
      public at.a.a a()
      {
        return new b.ct(b.this, null);
      }
    };
    this.bz = new Provider()
    {
      public com.viber.voip.g.a.a.aq.a.a a()
      {
        return new b.cn(b.this, null);
      }
    };
    this.bA = new Provider()
    {
      public com.viber.voip.g.a.a.bx.a.a a()
      {
        return new b.fj(b.this, null);
      }
    };
    this.bB = new Provider()
    {
      public by.a.a a()
      {
        return new b.fh(b.this, null);
      }
    };
    this.bC = new Provider()
    {
      public com.viber.voip.g.a.a.o.a.a a()
      {
        return new b.ad(b.this, null);
      }
    };
    this.bD = new Provider()
    {
      public com.viber.voip.g.a.a.bq.a.a a()
      {
        return new b.er(b.this, null);
      }
    };
    this.bE = new Provider()
    {
      public com.viber.voip.g.a.a.ac.a.a a()
      {
        return new b.bd(b.this, null);
      }
    };
    this.bF = new Provider()
    {
      public com.viber.voip.g.a.a.az.a.a a()
      {
        return new b.dh(b.this, null);
      }
    };
    this.bG = new Provider()
    {
      public bw.a.a a()
      {
        return new b.ff(b.this, null);
      }
    };
    this.bH = new Provider()
    {
      public com.viber.voip.g.a.a.aa.a.a a()
      {
        return new b.bb(b.this, null);
      }
    };
    this.bI = new Provider()
    {
      public com.viber.voip.g.a.a.bn.a.a a()
      {
        return new b.el(b.this, null);
      }
    };
    this.bJ = new Provider()
    {
      public com.viber.voip.g.a.a.c.a.a a()
      {
        return new b.e(b.this, null);
      }
    };
    this.bK = new Provider()
    {
      public com.viber.voip.g.a.a.ad.a.a a()
      {
        return new b.bf(b.this, null);
      }
    };
    this.bL = new Provider()
    {
      public cc.a.a a()
      {
        return new b.ft(b.this, null);
      }
    };
    this.bM = new Provider()
    {
      public cf.a.a a()
      {
        return new b.gb(b.this, null);
      }
    };
    this.bN = new Provider()
    {
      public cq.a.a a()
      {
        return new b.bz(b.this, null);
      }
    };
    this.bO = new Provider()
    {
      public cr.a.a a()
      {
        return new b.ez(b.this, null);
      }
    };
    this.bP = new Provider()
    {
      public ek.a.a a()
      {
        return new b.dd(b.this, null);
      }
    };
    this.bQ = new Provider()
    {
      public ej.a.a a()
      {
        return new b.cb(b.this, null);
      }
    };
    this.bR = new Provider()
    {
      public bs.a.a a()
      {
        return new b.ev(b.this, null);
      }
    };
    this.bS = new Provider()
    {
      public com.viber.voip.g.a.a.i.a.a a()
      {
        return new b.r(b.this, null);
      }
    };
    this.bT = new Provider()
    {
      public com.viber.voip.g.a.a.af.a.a a()
      {
        return new b.bj(b.this, null);
      }
    };
    this.bU = new Provider()
    {
      public com.viber.voip.g.a.a.f.a.a a()
      {
        return new b.k(b.this, null);
      }
    };
    this.bV = new Provider()
    {
      public com.viber.voip.g.a.a.an.a.a a()
      {
        return new b.cf(b.this, null);
      }
    };
    this.bW = new Provider()
    {
      public com.viber.voip.g.a.a.am.a.a a()
      {
        return new b.cd(b.this, null);
      }
    };
    this.bX = new Provider()
    {
      public com.viber.voip.g.a.a.ah.a.a a()
      {
        return new b.bn(b.this, null);
      }
    };
    this.bY = new Provider()
    {
      public z.a.a a()
      {
        return new b.az(b.this, null);
      }
    };
    this.bZ = new Provider()
    {
      public com.viber.voip.g.a.a.p.a.a a()
      {
        return new b.af(b.this, null);
      }
    };
    this.ca = new Provider()
    {
      public com.viber.voip.g.a.a.bf.a.a a()
      {
        return new b.dv(b.this, null);
      }
    };
    this.cb = new Provider()
    {
      public com.viber.voip.g.a.a.bu.a.a a()
      {
        return new b.fb(b.this, null);
      }
    };
    this.cc = new Provider()
    {
      public com.viber.voip.g.a.a.ak.a.a a()
      {
        return new b.bv(b.this, null);
      }
    };
    this.cd = new Provider()
    {
      public com.viber.voip.g.a.a.g.a.a a()
      {
        return new b.m(b.this, null);
      }
    };
    this.ce = new Provider()
    {
      public com.viber.voip.g.a.a.al.a.a a()
      {
        return new b.bx(b.this, null);
      }
    };
    this.cf = new Provider()
    {
      public com.viber.voip.g.a.a.av.a.a a()
      {
        return new b.cx(b.this, null);
      }
    };
    this.cg = new Provider()
    {
      public com.viber.voip.g.a.a.ap.a.a a()
      {
        return new b.cl(b.this, null);
      }
    };
    this.ch = new Provider()
    {
      public com.viber.voip.g.a.a.d.a.a a()
      {
        return new b.g(b.this, null);
      }
    };
    this.ci = new Provider()
    {
      public com.viber.voip.g.a.a.ae.a.a a()
      {
        return new b.bh(b.this, null);
      }
    };
    this.cj = new Provider()
    {
      public com.viber.voip.g.a.a.ag.a.a a()
      {
        return new b.bl(b.this, null);
      }
    };
    this.ck = new Provider()
    {
      public com.viber.voip.g.a.a.au.a.a a()
      {
        return new b.cv(b.this, null);
      }
    };
    this.cl = new Provider()
    {
      public com.viber.voip.g.a.a.ar.a.a a()
      {
        return new b.cp(b.this, null);
      }
    };
    this.cm = new Provider()
    {
      public as.a.a a()
      {
        return new b.cr(b.this, null);
      }
    };
    this.cn = new Provider()
    {
      public x.a.a a()
      {
        return new b.av(b.this, null);
      }
    };
    this.co = new Provider()
    {
      public ch.a.a a()
      {
        return new b.ch(b.this, null);
      }
    };
    this.cp = new Provider()
    {
      public ca.a.a a()
      {
        return new b.fp(b.this, null);
      }
    };
    this.a = o.a(paramo);
    this.cq = cf.a(this.b);
    this.cr = cb.a(this.cq);
    this.cs = fo.a(this.b);
    this.ct = com.viber.voip.g.a.x.a(com.viber.voip.g.a.s.b());
    this.cu = dagger.a.c.a(ff.a(ef.b(), ed.b()));
    this.cv = dagger.a.c.a(el.a(this.c, com.viber.voip.g.a.s.b(), this.r, gs.b(), this.X));
    this.cw = dagger.a.c.a(gq.a(this.b));
    this.cx = com.viber.voip.g.a.t.a(com.viber.voip.g.a.s.b());
    this.cy = dagger.a.c.a(cx.a(this.c));
    this.cz = dp.a(this.ap);
    this.cA = dm.a(this.ap);
    this.cB = dagger.a.c.a(fe.a(ef.b(), ed.b()));
    this.cC = dagger.a.c.a(fc.a(this.cB));
    this.cD = dq.a(this.ap);
    this.cE = dy.a(this.ap);
    this.cF = eh.a(this.c);
    this.cG = hb.a(this.ap);
    this.cH = be.a(this.R);
    this.cI = dagger.a.c.a(com.viber.voip.messages.extensions.b.b());
    this.cJ = dagger.a.c.a(com.viber.voip.g.a.g.a(this.Y));
    this.cK = dagger.a.c.a(com.viber.voip.g.a.h.a(this.cJ));
    this.cL = com.viber.voip.g.a.n.a(this.cK);
    this.cM = com.viber.voip.g.a.q.a(this.c, gi.b());
    this.cN = com.viber.voip.g.a.o.a(this.c, this.O, this.X, gi.b());
    this.cO = dagger.a.c.a(com.viber.voip.g.a.l.a(this.cL, gn.b(), gg.b(), this.s, this.b, this.O, this.X, this.y, this.i, this.cF, this.cM, this.cN, this.c));
    this.cP = dagger.a.c.a(com.viber.voip.g.a.d.b());
    this.cQ = dagger.a.c.a(com.viber.voip.g.a.f.b());
  }

  private void c(o paramo)
  {
    this.cR = dagger.a.c.a(com.viber.voip.g.a.i.a(this.ad, this.cP, this.cQ));
    this.cS = com.viber.voip.g.a.w.a(com.viber.voip.g.a.s.b());
    this.cT = bx.a(this.b);
    this.cU = com.viber.voip.g.a.bf.a(this.b);
    this.cV = com.viber.voip.g.a.ak.a(this.c);
    this.cW = dagger.a.c.a(com.viber.voip.viberout.a.m.b());
    this.cX = da.a(this.R);
    this.cY = com.viber.voip.g.a.af.a(com.viber.voip.g.a.s.b());
    this.cZ = dagger.a.c.a(com.viber.voip.g.a.j.a(this.cL, gn.b(), gg.b(), this.s, this.b, this.O, this.X, this.y, this.i, this.cF, this.cM, this.cN, this.c));
    this.da = dn.a(this.ap);
    this.db = dagger.a.c.a(com.viber.voip.g.a.k.a(this.cL, gn.b(), gg.b(), this.s, this.b, this.O, this.X, this.y, this.i, this.cF, this.cM, this.cN, this.c));
    this.dc = bc.a(this.cq);
    this.dd = dagger.a.c.a(com.viber.voip.util.i.b.b());
    this.de = com.viber.voip.g.a.z.a(com.viber.voip.g.a.s.b());
    this.df = ds.a(this.ap);
    this.dg = am.a(this.c, com.viber.voip.g.a.ap.b(), this.cF);
    this.dh = dagger.a.c.a(com.viber.voip.g.a.e.a(this.cq, this.y, this.aa, this.O, gg.b(), this.J, this.F));
    this.di = bp.a(this.c);
    this.dj = dagger.a.c.a(com.viber.voip.g.a.cn.a(this.h, this.di, this.aw, this.P, gg.b()));
    this.dk = dagger.a.c.a(co.a(gg.b(), this.V, this.dj));
    this.dl = dl.a(this.ap);
    this.dm = do.a(this.ap);
    this.dn = dagger.a.c.a(eb.a(gn.b(), gi.b(), com.viber.voip.g.a.br.b(), this.X, this.V));
    this.jdField_do = dagger.a.c.a(com.viber.voip.g.a.m.a(this.cL, gn.b(), gg.b(), this.s, this.b, this.O, this.X, this.y, this.i, this.cF, this.cM, this.cN, this.c));
    this.dp = bb.a(this.R);
    this.dq = gj.a(gn.b(), gk.b());
    this.dr = com.viber.voip.invitelinks.ac.a(this.v, this.O, this.cz, dt.b(), this.dq);
    this.ds = dh.a(this.ah, this.c, this.v);
    this.dt = di.a(com.viber.voip.g.a.br.b(), du.b(), this.F);
    this.du = dagger.a.c.a(dg.a(this.ds, this.dt, this.i, this.T, gg.b(), gn.b()));
  }

  public static a.a e()
  {
    return new o(null);
  }

  private Map<Class<? extends Activity>, Provider<dagger.android.b.b<? extends Activity>>> f()
  {
    return dagger.a.f.a(65).a(ConversationActivity.class, this.aC).a(PublicAccountConversationActivity.class, this.aD).a(AboutActivity.class, this.aE).a(ViewMediaSimpleActivity.class, this.aF).a(FullScreenVideoPlayerActivity.class, this.aG).a(ChatExInternalBrowserActivity.class, this.aH).a(LocationMessageActivityV2.class, this.aI).a(ChatExtensionPanelActivity.class, this.aJ).a(ScannerActivity.class, this.aK).a(AddFriendPreviewActivity.class, this.aL).a(PopupMessageActivity.class, this.aM).a(CommunitySelectBackgroundActivity.class, this.aN).a(SelectBackgroundForVibeActivity.class, this.aO).a(ViberOutProductsActivity.class, this.aP).a(ViberOutCountryPlansActivity.class, this.aQ).a(SettingsHeadersActivity.class, this.aR).a(SettingsTabletActivity.class, this.aS).a(BusinessInboxActivity.class, this.aT).a(SmsInboxActivity.class, this.aU).a(ForwardActivity.class, this.aV).a(PublicGroupInviteContactsListActivity.class, this.aW).a(PublicChatsActivity.class, this.aX).a(VOPurchaseDialogActivity.class, this.aY).a(ContactDetailsActivity.class, this.aZ).a(ContactDetailsDialogActivity.class, this.ba).a(MoreActivity.class, this.bb).a(MoreDialogActivity.class, this.bc).a(ShareScreenshotActivity.class, this.bd).a(ChangePhoneNumberActivity.class, this.be).a(SelectLanguageActivity.class, this.bf).a(SelectUiLanguageActivity.class, this.bg).a(RegistrationActivity.class, this.bh).a(VlnActivity.class, this.bi).a(BackgroundGalleryActivity.class, this.bj).a(ViberReactActivity.class, this.bk).a(ConferenceContactsComposeListActivity.class, this.bl).a(ChatExInternalBrowserPartialSizeActivity.class, this.bm).a(ContactsCompose1to1ListActivity.class, this.bn).a(ContactsComposeCombinedActivity.class, this.bo).a(ContactsComposeListActivity.class, this.bp).a(ForwardCreatePollActivity.class, this.bq).a(VoteActivity.class, this.br).a(RecentCallsActivity.class, this.bs).a(ParticipantsListActivity.class, this.bt).a(PublicAccountEditActivity.class, this.bu).a(ChatInfoActivity.class, this.bv).a(PublicAccountInfoActivity.class, this.bw).a(PublicAccountInfoTabletActivity.class, this.bx).a(ManageStorageActivity.class, this.by).a(ManageConversationStorageActivity.class, this.bz).a(ViberNewsWebActivity.class, this.bA).a(ViberNewsArticleBrowserActivity.class, this.bB).a(CommonGroupsActivity.class, this.bC).a(ShareLinkActivity.class, this.bD).a(CreditCardCheckoutWebActivity.class, this.bE).a(PhoneFragmentActivity.class, this.bF).a(ViberConnectActivity.class, this.bG).a(ConversationGalleryActivity.class, this.bH).a(SelectionGallery.class, this.bI).a(AddMoreGallery.class, this.bJ).a(CustomCamTakeVideoActivity.class, this.bK).a(ViewMediaActivity.class, this.bL).a(WinkViewMediaActivity.class, this.bM).a(HomeActivity.class, this.bN).a(TabletHomeActivity.class, this.bO).a();
  }

  private dagger.android.c<Activity> g()
  {
    return dagger.android.d.a(f());
  }

  private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> h()
  {
    return dagger.a.f.a(26).a(com.viber.voip.news.e.class, this.bP).a(HomeTabNewsBrowserFragment.class, this.bQ).a(com.viber.voip.messages.shopchat.b.class, this.bR).a(com.viber.voip.settings.ui.c.class, this.bS).a(com.viber.voip.settings.ui.i.class, this.bT).a(com.viber.voip.group.participants.ban.e.class, this.bU).a(IncomingCallFragment.class, this.bV).a(InCallFragment.class, this.bW).a(EndCallFragment.class, this.bX).a(ConversationFragment.class, this.bY).a(CommunityConversationFragment.class, this.bZ).a(PublicGroupConversationFragment.class, this.ca).a(TabletPublicGroupConversationFragment.class, this.cb).a(GroupCallDetailsFragment.class, this.cc).a(com.viber.voip.block.d.class, this.cd).a(com.viber.voip.contacts.ui.list.l.class, this.ce).a(bk.class, this.cf).a(com.viber.voip.gdpr.ui.iabconsent.g.class, this.cg).a(com.viber.voip.gdpr.ui.iabconsent.a.class, this.ch).a(com.viber.voip.settings.ui.d.class, this.ci).a(EditInfoFragment.class, this.cj).a(com.viber.voip.storage.manage.d.class, this.ck).a(com.viber.voip.storage.conversation.a.class, this.cl).a(com.viber.voip.storage.overall.a.class, this.cm).a(ContactsFragment.class, this.cn).a(com.viber.voip.contacts.ui.ap.class, this.co).a();
  }

  private dagger.android.c<Fragment> i()
  {
    return dagger.android.d.a(h());
  }

  private Map<Class<? extends Service>, Provider<dagger.android.b.b<? extends Service>>> j()
  {
    return Collections.singletonMap(ViberPhoneService.class, this.cp);
  }

  private dagger.android.c<Service> k()
  {
    return dagger.android.d.a(j());
  }

  private Context l()
  {
    return com.viber.voip.g.a.ah.a(this.a);
  }

  private Engine m()
  {
    return cd.a(this.a);
  }

  private UserManager n()
  {
    return hc.a(m());
  }

  private ProfileNotification o()
  {
    return gx.a(n());
  }

  private com.viber.voip.w p()
  {
    return gp.a(l(), gn.c(), gs.c(), dagger.a.c.b(this.E), o(), (com.viber.voip.app.b)this.r.get());
  }

  private com.viber.voip.block.k q()
  {
    return com.viber.voip.g.a.ay.a(com.viber.voip.g.a.ax.b());
  }

  private PhoneController r()
  {
    return cg.a(m());
  }

  private GroupController s()
  {
    return dp.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.util.az t()
  {
    return gj.a(gn.c(), gk.c());
  }

  private com.viber.voip.messages.controller.manager.k u()
  {
    return ds.a((com.viber.voip.messages.k)this.ap.get());
  }

  private com.viber.voip.contacts.c.d.g v()
  {
    return com.viber.voip.g.a.bm.a(this.a);
  }

  private com.viber.voip.contacts.c.d.m w()
  {
    return com.viber.voip.g.a.bn.a(v());
  }

  private com.viber.voip.analytics.story.e.c x()
  {
    return com.viber.voip.g.a.y.a(com.viber.voip.g.a.s.c());
  }

  private com.viber.voip.registration.af y()
  {
    return gy.a(n());
  }

  private CallHandler z()
  {
    return com.viber.voip.g.a.ba.a(m());
  }

  public com.viber.voip.api.a.b.a a()
  {
    return (com.viber.voip.api.a.b.a)this.cu.get();
  }

  public void a(ViberApplication paramViberApplication)
  {
    b(paramViberApplication);
  }

  public void a(SdkActivity paramSdkActivity)
  {
    b(paramSdkActivity);
  }

  public void a(EmailCollectionWorker paramEmailCollectionWorker)
  {
    b(paramEmailCollectionWorker);
  }

  public com.viber.voip.invitelinks.q b()
  {
    return new com.viber.voip.invitelinks.q((com.viber.voip.messages.controller.manager.ab)this.v.get(), r(), s(), dt.c(), t());
  }

  public com.viber.voip.news.q c()
  {
    return (com.viber.voip.news.q)this.cv.get();
  }

  public ICdrController d()
  {
    return com.viber.voip.g.a.v.a(m());
  }

  private final class a extends com.viber.voip.g.a.a.a.a.a
  {
    private AboutActivity b;

    private a()
    {
    }

    public com.viber.voip.g.a.a.a.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(AboutActivity.class.getCanonicalName() + " must be set");
      return new b.b(b.this, this, null);
    }

    public void a(AboutActivity paramAboutActivity)
    {
      this.b = ((AboutActivity)dagger.a.h.a(paramAboutActivity));
    }
  }

  private final class aa
    implements com.viber.voip.g.a.a.m.a
  {
    private Provider<com.viber.voip.g.a.a.a.g.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.f.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.e.a.a> d;

    private aa(b.z arg2)
    {
      b.z localz;
      a(localz);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.extensions.b.i.class, this.b).a(com.viber.voip.messages.extensions.b.d.class, this.c).a(com.viber.voip.messages.extensions.b.b.class, this.d).a();
    }

    private void a(b.z paramz)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.g.a.a a()
        {
          return new b.aa.e(b.aa.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.f.a.a a()
        {
          return new b.aa.c(b.aa.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.e.a.a a()
        {
          return new b.aa.a(b.aa.this, null);
        }
      };
    }

    private ChatExtensionPanelActivity b(ChatExtensionPanelActivity paramChatExtensionPanelActivity)
    {
      com.viber.voip.messages.extensions.activity.h.a(paramChatExtensionPanelActivity, b());
      return paramChatExtensionPanelActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ChatExtensionPanelActivity paramChatExtensionPanelActivity)
    {
      b(paramChatExtensionPanelActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.e.a.a
    {
      private com.viber.voip.messages.extensions.b.b b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.e.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.b.class.getCanonicalName() + " must be set");
        return new b.aa.b(b.aa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        this.b = ((com.viber.voip.messages.extensions.b.b)dagger.a.h.a(paramb));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.e.a
    {
      private Provider<com.viber.voip.messages.extensions.b.b> b;
      private Provider<ChatExtensionDetailsPresenter> c;

      private b(b.aa.a arg2)
      {
        b.aa.a locala;
        a(locala);
      }

      private void a(b.aa.a parama)
      {
        this.b = dagger.a.e.a(b.aa.a.a(parama));
        this.c = dagger.a.c.a(com.viber.voip.g.a.a.b.b.a(this.b, b.ao(b.this), b.at(b.this), b.K(b.this), b.af(b.this), b.I(b.this), du.b(), b.ax(b.this)));
      }

      private com.viber.voip.messages.extensions.b.b b(com.viber.voip.messages.extensions.b.b paramb)
      {
        com.viber.voip.messages.extensions.b.c.a(paramb, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.c.a(paramb, (ChatExtensionDetailsPresenter)this.c.get());
        return paramb;
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        b(paramb);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.f.a.a
    {
      private com.viber.voip.messages.extensions.b.d b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.f.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.d.class.getCanonicalName() + " must be set");
        return new b.aa.d(b.aa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        this.b = ((com.viber.voip.messages.extensions.b.d)dagger.a.h.a(paramd));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.f.a
    {
      private d(b.aa.c arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.d b(com.viber.voip.messages.extensions.b.d paramd)
      {
        com.viber.voip.messages.extensions.b.h.a(paramd, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.b.f)b.av(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        return paramd;
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        b(paramd);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.g.a.a
    {
      private com.viber.voip.messages.extensions.b.i b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.g.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.i.class.getCanonicalName() + " must be set");
        return new b.aa.f(b.aa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        this.b = ((com.viber.voip.messages.extensions.b.i)dagger.a.h.a(parami));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.g.a
    {
      private f(b.aa.e arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.i b(com.viber.voip.messages.extensions.b.i parami)
      {
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.a)b.at(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, gn.c());
        com.viber.voip.messages.extensions.b.l.a(parami, b.au(b.this));
        return parami;
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        b(parami);
      }
    }
  }

  private final class ab extends com.viber.voip.g.a.a.n.a.a
  {
    private ChatInfoActivity b;

    private ab()
    {
    }

    public com.viber.voip.g.a.a.n.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ChatInfoActivity.class.getCanonicalName() + " must be set");
      return new b.ac(b.this, this, null);
    }

    public void a(ChatInfoActivity paramChatInfoActivity)
    {
      this.b = ((ChatInfoActivity)dagger.a.h.a(paramChatInfoActivity));
    }
  }

  private final class ac
    implements com.viber.voip.g.a.a.n.a
  {
    private Provider<com.viber.voip.g.a.a.a.i.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.h.a.a> c;

    private ac(b.ab arg2)
    {
      b.ab localab;
      a(localab);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(ChatInfoGroupFragment.class, this.b).a(com.viber.voip.messages.conversation.chatinfo.presentation.o.class, this.c).a();
    }

    private void a(b.ab paramab)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.i.a.a a()
        {
          return new b.ac.c(b.ac.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.h.a.a a()
        {
          return new b.ac.a(b.ac.this, null);
        }
      };
    }

    private ChatInfoActivity b(ChatInfoActivity paramChatInfoActivity)
    {
      com.viber.voip.messages.conversation.chatinfo.presentation.a.a(paramChatInfoActivity, b());
      com.viber.voip.messages.conversation.chatinfo.presentation.a.a(paramChatInfoActivity, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.messages.conversation.chatinfo.presentation.a.a(paramChatInfoActivity, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.messages.conversation.chatinfo.presentation.a.b(paramChatInfoActivity, dagger.a.c.b(b.bd(b.this)));
      return paramChatInfoActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    private com.viber.voip.messages.conversation.chatinfo.a.h<com.viber.voip.messages.conversation.chatinfo.d.d> c()
    {
      return com.viber.voip.g.a.a.b.d.a(dagger.a.c.b(b.A(b.this)));
    }

    private com.viber.voip.messages.conversation.chatinfo.b.a d()
    {
      return com.viber.voip.g.a.a.b.e.a(c());
    }

    public void a(ChatInfoActivity paramChatInfoActivity)
    {
      b(paramChatInfoActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.h.a.a
    {
      private com.viber.voip.messages.conversation.chatinfo.presentation.o b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.h.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.chatinfo.presentation.o.class.getCanonicalName() + " must be set");
        return new b.ac.b(b.ac.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        this.b = ((com.viber.voip.messages.conversation.chatinfo.presentation.o)dagger.a.h.a(paramo));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.h.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private b(b.ac.a arg2)
      {
        b.ac.a locala;
        a(locala);
      }

      private void a(b.ac.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private com.viber.voip.messages.conversation.chatinfo.presentation.o b(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramo, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramo, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.ac.a(b.ac.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramo, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramo, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, b.this.d());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, bl.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, b.X(b.this));
        return paramo;
      }

      public void a(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        b(paramo);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.i.a.a
    {
      private ChatInfoGroupFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.i.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ChatInfoGroupFragment.class.getCanonicalName() + " must be set");
        return new b.ac.d(b.ac.this, this, null);
      }

      public void a(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        this.b = ((ChatInfoGroupFragment)dagger.a.h.a(paramChatInfoGroupFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.i.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;
      private Provider<com.viber.voip.report.community.a> c;

      private d(b.ac.c arg2)
      {
        b.ac.c localc;
        a(localc);
      }

      private com.viber.voip.report.a.a.a a()
      {
        return new com.viber.voip.report.a.a.a((com.viber.voip.messages.controller.manager.ab)b.F(b.this).get(), b.G(b.this), dagger.a.c.b(b.H(b.this)), gf.b(), gn.c());
      }

      private void a(b.ac.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
        this.c = dagger.a.c.a(com.viber.voip.report.community.b.b());
      }

      private ChatInfoGroupFragment b(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramChatInfoGroupFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramChatInfoGroupFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.ac.a(b.ac.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramChatInfoGroupFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramChatInfoGroupFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, b.this.d());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, bl.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, b.X(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, b.Y(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, a());
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, (com.viber.voip.report.community.a)this.c.get());
        return paramChatInfoGroupFragment;
      }

      public void a(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        b(paramChatInfoGroupFragment);
      }
    }
  }

  private final class ad extends com.viber.voip.g.a.a.o.a.a
  {
    private CommonGroupsActivity b;

    private ad()
    {
    }

    public com.viber.voip.g.a.a.o.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(CommonGroupsActivity.class.getCanonicalName() + " must be set");
      return new b.ae(b.this, this, null);
    }

    public void a(CommonGroupsActivity paramCommonGroupsActivity)
    {
      this.b = ((CommonGroupsActivity)dagger.a.h.a(paramCommonGroupsActivity));
    }
  }

  private final class ae
    implements com.viber.voip.g.a.a.o.a
  {
    private Provider<com.viber.voip.g.a.a.a.j.a.a> b;

    private ae(b.ad arg2)
    {
      b.ad localad;
      a(localad);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.conversation.commongroups.c.class, this.b).a();
    }

    private void a(b.ad paramad)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.j.a.a a()
        {
          return new b.ae.a(b.ae.this, null);
        }
      };
    }

    private CommonGroupsActivity b(CommonGroupsActivity paramCommonGroupsActivity)
    {
      com.viber.voip.messages.conversation.commongroups.a.a(paramCommonGroupsActivity, b());
      com.viber.voip.messages.conversation.commongroups.a.a(paramCommonGroupsActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramCommonGroupsActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(CommonGroupsActivity paramCommonGroupsActivity)
    {
      b(paramCommonGroupsActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.j.a.a
    {
      private com.viber.voip.messages.conversation.commongroups.c b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.j.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.commongroups.c.class.getCanonicalName() + " must be set");
        return new b.ae.b(b.ae.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.commongroups.c paramc)
      {
        this.b = ((com.viber.voip.messages.conversation.commongroups.c)dagger.a.h.a(paramc));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.j.a
    {
      private Provider<com.viber.voip.messages.conversation.commongroups.c> b;
      private Provider<com.viber.voip.messages.conversation.commongroups.i> c;
      private Provider<CommonGroupsPresenter> d;

      private b(b.ae.a arg2)
      {
        b.ae.a locala;
        a(locala);
      }

      private void a(b.ae.a parama)
      {
        this.b = dagger.a.e.a(b.ae.a.a(parama));
        this.c = dagger.a.c.a(com.viber.voip.g.a.a.b.g.a(this.b, dt.b()));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.h.a(this.c));
      }

      private com.viber.voip.messages.conversation.commongroups.c b(com.viber.voip.messages.conversation.commongroups.c paramc)
      {
        com.viber.voip.messages.conversation.commongroups.d.a(paramc, (com.viber.voip.messages.conversation.commongroups.i)this.c.get());
        com.viber.voip.messages.conversation.commongroups.d.a(paramc, (CommonGroupsPresenter)this.d.get());
        com.viber.voip.messages.conversation.commongroups.d.a(paramc, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.commongroups.d.a(paramc, dagger.a.c.b(dx.b()));
        return paramc;
      }

      public void a(com.viber.voip.messages.conversation.commongroups.c paramc)
      {
        b(paramc);
      }
    }
  }

  private final class af extends com.viber.voip.g.a.a.p.a.a
  {
    private CommunityConversationFragment b;

    private af()
    {
    }

    public com.viber.voip.g.a.a.p.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(CommunityConversationFragment.class.getCanonicalName() + " must be set");
      return new b.ag(b.this, this, null);
    }

    public void a(CommunityConversationFragment paramCommunityConversationFragment)
    {
      this.b = ((CommunityConversationFragment)dagger.a.h.a(paramCommunityConversationFragment));
    }
  }

  private final class ag
    implements com.viber.voip.g.a.a.p.a
  {
    private Provider<com.viber.voip.messages.conversation.community.b.a> b;
    private Provider<com.viber.voip.report.community.a> c;
    private Provider<com.viber.voip.messages.conversation.ui.b.q> d;

    private ag(b.af arg2)
    {
      b.af localaf;
      a(localaf);
    }

    private com.viber.voip.report.a.a.a a()
    {
      return new com.viber.voip.report.a.a.a((com.viber.voip.messages.controller.manager.ab)b.F(b.this).get(), b.G(b.this), dagger.a.c.b(b.H(b.this)), gf.b(), gn.c());
    }

    private void a(b.af paramaf)
    {
      this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.j.a(b.ab(b.this), b.ae(b.this)));
      this.c = dagger.a.c.a(com.viber.voip.report.community.b.b());
      this.d = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
    }

    private CommunityConversationFragment b(CommunityConversationFragment paramCommunityConversationFragment)
    {
      aw.a(paramCommunityConversationFragment, fx.b());
      aw.a(paramCommunityConversationFragment, b.bM(b.this));
      aw.a(paramCommunityConversationFragment, b.bN(b.this));
      aw.a(paramCommunityConversationFragment, fz.c());
      aw.a(paramCommunityConversationFragment, ck.c());
      aw.a(paramCommunityConversationFragment, b.bO(b.this));
      aw.a(paramCommunityConversationFragment, b.bP(b.this));
      aw.a(paramCommunityConversationFragment, com.viber.voip.g.a.s.c());
      aw.a(paramCommunityConversationFragment, b.X(b.this));
      aw.a(paramCommunityConversationFragment, b.P(b.this));
      aw.a(paramCommunityConversationFragment, b.ak(b.this));
      aw.a(paramCommunityConversationFragment, b.aj(b.this));
      aw.a(paramCommunityConversationFragment, b.bQ(b.this));
      aw.a(paramCommunityConversationFragment, b.bR(b.this));
      aw.a(paramCommunityConversationFragment, dx.c());
      aw.a(paramCommunityConversationFragment, b.N(b.this));
      aw.a(paramCommunityConversationFragment, b.aq(b.this));
      aw.a(paramCommunityConversationFragment, b.ar(b.this));
      aw.a(paramCommunityConversationFragment, (com.viber.voip.app.b)b.I(b.this).get());
      aw.a(paramCommunityConversationFragment, b.L(b.this));
      aw.a(paramCommunityConversationFragment, b.U(b.this));
      aw.a(paramCommunityConversationFragment, b.bg(b.this));
      aw.a(paramCommunityConversationFragment, b.this.d());
      aw.a(paramCommunityConversationFragment, dagger.a.c.b(b.J(b.this)));
      aw.b(paramCommunityConversationFragment, dagger.a.c.b(b.af(b.this)));
      aw.a(paramCommunityConversationFragment, com.viber.voip.g.a.p.c());
      aw.a(paramCommunityConversationFragment, du.c());
      aw.a(paramCommunityConversationFragment, (com.viber.common.permission.c)b.K(b.this).get());
      aw.a(paramCommunityConversationFragment, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      aw.c(paramCommunityConversationFragment, dagger.a.c.b(b.O(b.this)));
      aw.a(paramCommunityConversationFragment, b.an(b.this));
      aw.d(paramCommunityConversationFragment, dagger.a.c.b(b.T(b.this)));
      aw.a(paramCommunityConversationFragment, (com.viber.voip.messages.extensions.i)b.bS(b.this).get());
      aw.e(paramCommunityConversationFragment, dagger.a.c.b(b.aW(b.this)));
      aw.a(paramCommunityConversationFragment, (EventBus)b.M(b.this).get());
      aw.a(paramCommunityConversationFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
      aw.f(paramCommunityConversationFragment, dagger.a.c.b(b.bT(b.this)));
      aw.g(paramCommunityConversationFragment, dagger.a.c.b(b.al(b.this)));
      aw.h(paramCommunityConversationFragment, dagger.a.c.b(b.A(b.this)));
      aw.a(paramCommunityConversationFragment, b.V(b.this));
      aw.i(paramCommunityConversationFragment, dagger.a.c.b(b.ai(b.this)));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramCommunityConversationFragment, b.aq(b.this));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramCommunityConversationFragment, b.aj(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.aq(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.G(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.aB(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.aj(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, (com.viber.voip.messages.conversation.community.b.a)this.b.get());
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, a());
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, (com.viber.voip.report.community.a)this.c.get());
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, (com.viber.voip.messages.conversation.ui.b.q)this.d.get());
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.ar(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.messages.conversation.community.b.b(paramCommunityConversationFragment, dagger.a.c.b(b.S(b.this)));
      com.viber.voip.messages.conversation.community.b.c(paramCommunityConversationFragment, dagger.a.c.b(dt.b()));
      com.viber.voip.messages.conversation.community.b.d(paramCommunityConversationFragment, dagger.a.c.b(b.O(b.this)));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.N(b.this));
      com.viber.voip.messages.conversation.community.b.a(paramCommunityConversationFragment, b.bg(b.this));
      return paramCommunityConversationFragment;
    }

    public void a(CommunityConversationFragment paramCommunityConversationFragment)
    {
      b(paramCommunityConversationFragment);
    }
  }

  private final class ah extends com.viber.voip.g.a.a.q.a.a
  {
    private CommunitySelectBackgroundActivity b;

    private ah()
    {
    }

    public com.viber.voip.g.a.a.q.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(CommunitySelectBackgroundActivity.class.getCanonicalName() + " must be set");
      return new b.ai(b.this, this, null);
    }

    public void a(CommunitySelectBackgroundActivity paramCommunitySelectBackgroundActivity)
    {
      this.b = ((CommunitySelectBackgroundActivity)dagger.a.h.a(paramCommunitySelectBackgroundActivity));
    }
  }

  private final class ai
    implements com.viber.voip.g.a.a.q.a
  {
    private ai(b.ah arg2)
    {
    }

    private CommunitySelectBackgroundPresenter a()
    {
      return new CommunitySelectBackgroundPresenter(b.Z(b.this), b.aq(b.this), b.ay(b.this), cy.b(), b.U(b.this), dt.c(), gn.c(), b.P(b.this));
    }

    private CommunitySelectBackgroundActivity b(CommunitySelectBackgroundActivity paramCommunitySelectBackgroundActivity)
    {
      com.viber.voip.backgrounds.ui.a.a(paramCommunitySelectBackgroundActivity, com.viber.voip.g.a.s.c());
      com.viber.voip.backgrounds.ui.b.a(paramCommunitySelectBackgroundActivity, a());
      return paramCommunitySelectBackgroundActivity;
    }

    public void a(CommunitySelectBackgroundActivity paramCommunitySelectBackgroundActivity)
    {
      b(paramCommunitySelectBackgroundActivity);
    }
  }

  private final class aj extends com.viber.voip.g.a.a.r.a.a
  {
    private ConferenceContactsComposeListActivity b;

    private aj()
    {
    }

    public com.viber.voip.g.a.a.r.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ConferenceContactsComposeListActivity.class.getCanonicalName() + " must be set");
      return new b.ak(b.this, this, null);
    }

    public void a(ConferenceContactsComposeListActivity paramConferenceContactsComposeListActivity)
    {
      this.b = ((ConferenceContactsComposeListActivity)dagger.a.h.a(paramConferenceContactsComposeListActivity));
    }
  }

  private final class ak
    implements com.viber.voip.g.a.a.r.a
  {
    private Provider<com.viber.voip.g.a.a.a.q.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.m.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.p.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.o.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.n.a.a> f;

    private ak(b.aj arg2)
    {
      b.aj localaj;
      a(localaj);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.ay.class, this.b).a(com.viber.voip.block.n.class, this.c).a(com.viber.voip.viberout.ui.c.class, this.d).a(com.viber.voip.contacts.ui.s.class, this.e).a(ConferenceParticipantsSelectFragment.class, this.f).a();
    }

    private void a(b.aj paramaj)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.q.a.a a()
        {
          return new b.ak.i(b.ak.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.m.a.a a()
        {
          return new b.ak.a(b.ak.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.p.a.a a()
        {
          return new b.ak.g(b.ak.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.o.a.a a()
        {
          return new b.ak.c(b.ak.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.n.a.a a()
        {
          return new b.ak.e(b.ak.this, null);
        }
      };
    }

    private ConferenceContactsComposeListActivity b(ConferenceContactsComposeListActivity paramConferenceContactsComposeListActivity)
    {
      com.viber.voip.contacts.ui.w.a(paramConferenceContactsComposeListActivity, b());
      com.viber.voip.contacts.ui.w.a(paramConferenceContactsComposeListActivity, dagger.a.c.b(b.bd(b.this)));
      com.viber.voip.contacts.ui.c.a(paramConferenceContactsComposeListActivity, b.V(b.this));
      return paramConferenceContactsComposeListActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ConferenceContactsComposeListActivity paramConferenceContactsComposeListActivity)
    {
      b(paramConferenceContactsComposeListActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.m.a.a
    {
      private com.viber.voip.block.n b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.m.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.block.n.class.getCanonicalName() + " must be set");
        return new b.ak.b(b.ak.this, this, null);
      }

      public void a(com.viber.voip.block.n paramn)
      {
        this.b = ((com.viber.voip.block.n)dagger.a.h.a(paramn));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.m.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.block.n> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private b(b.ak.a arg2)
      {
        b.ak.a locala;
        a(locala);
      }

      private void a(b.ak.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.ak.a.a(parama));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.block.n b(com.viber.voip.block.n paramn)
      {
        com.viber.voip.contacts.ui.v.a(paramn, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramn, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramn, dagger.a.c.b(this.e));
        return paramn;
      }

      public void a(com.viber.voip.block.n paramn)
      {
        b(paramn);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.o.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.o.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.ak.d(b.ak.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.o.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.ak.c arg2)
      {
        b.ak.c localc;
        a(localc);
      }

      private void a(b.ak.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.ak.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.n.a.a
    {
      private ConferenceParticipantsSelectFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.n.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ConferenceParticipantsSelectFragment.class.getCanonicalName() + " must be set");
        return new b.ak.f(b.ak.this, this, null);
      }

      public void a(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        this.b = ((ConferenceParticipantsSelectFragment)dagger.a.h.a(paramConferenceParticipantsSelectFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.n.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<ConferenceParticipantsSelectFragment> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private f(b.ak.e arg2)
      {
        b.ak.e locale;
        a(locale);
      }

      private void a(b.ak.e parame)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.ak.e.a(parame));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private ConferenceParticipantsSelectFragment b(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        com.viber.voip.contacts.ui.v.a(paramConferenceParticipantsSelectFragment, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.e));
        return paramConferenceParticipantsSelectFragment;
      }

      public void a(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        b(paramConferenceParticipantsSelectFragment);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.p.a.a
    {
      private com.viber.voip.viberout.ui.c b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.p.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.viberout.ui.c.class.getCanonicalName() + " must be set");
        return new b.ak.h(b.ak.this, this, null);
      }

      public void a(com.viber.voip.viberout.ui.c paramc)
      {
        this.b = ((com.viber.voip.viberout.ui.c)dagger.a.h.a(paramc));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.p.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.viberout.ui.c> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private h(b.ak.g arg2)
      {
        b.ak.g localg;
        a(localg);
      }

      private void a(b.ak.g paramg)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.ak.g.a(paramg));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.viberout.ui.c b(com.viber.voip.viberout.ui.c paramc)
      {
        com.viber.voip.contacts.ui.v.a(paramc, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramc, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramc, dagger.a.c.b(this.e));
        return paramc;
      }

      public void a(com.viber.voip.viberout.ui.c paramc)
      {
        b(paramc);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.q.a.a
    {
      private com.viber.voip.contacts.ui.ay b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.q.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.ay.class.getCanonicalName() + " must be set");
        return new b.ak.j(b.ak.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.ay paramay)
      {
        this.b = ((com.viber.voip.contacts.ui.ay)dagger.a.h.a(paramay));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.q.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.ay> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private j(b.ak.i arg2)
      {
        b.ak.i locali;
        a(locali);
      }

      private void a(b.ak.i parami)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.ak.i.a(parami));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.ay b(com.viber.voip.contacts.ui.ay paramay)
      {
        com.viber.voip.contacts.ui.v.a(paramay, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramay, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramay, dagger.a.c.b(this.e));
        return paramay;
      }

      public void a(com.viber.voip.contacts.ui.ay paramay)
      {
        b(paramay);
      }
    }
  }

  private final class al extends com.viber.voip.g.a.a.s.a.a
  {
    private ContactDetailsActivity b;

    private al()
    {
    }

    public com.viber.voip.g.a.a.s.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactDetailsActivity.class.getCanonicalName() + " must be set");
      return new b.am(b.this, this, null);
    }

    public void a(ContactDetailsActivity paramContactDetailsActivity)
    {
      this.b = ((ContactDetailsActivity)dagger.a.h.a(paramContactDetailsActivity));
    }
  }

  private final class am
    implements com.viber.voip.g.a.a.s.a
  {
    private Provider<com.viber.voip.g.a.bj.a.a> b;

    private am(b.al arg2)
    {
      b.al localal;
      a(localal);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(ContactDetailsFragment.class, this.b).a();
    }

    private void a(b.al paramal)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.bj.a.a a()
        {
          return new b.am.a(b.am.this, null);
        }
      };
    }

    private ContactDetailsActivity b(ContactDetailsActivity paramContactDetailsActivity)
    {
      com.viber.voip.contacts.ui.d.a(paramContactDetailsActivity, b());
      com.viber.voip.contacts.ui.d.a(paramContactDetailsActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramContactDetailsActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ContactDetailsActivity paramContactDetailsActivity)
    {
      b(paramContactDetailsActivity);
    }

    private final class a extends com.viber.voip.g.a.bj.a.a
    {
      private ContactDetailsFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.bj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ContactDetailsFragment.class.getCanonicalName() + " must be set");
        return new b.am.b(b.am.this, this, null);
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        this.b = ((ContactDetailsFragment)dagger.a.h.a(paramContactDetailsFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.bj.a
    {
      private b(b.am.a arg2)
      {
      }

      private ContactDetailsFragment b(ContactDetailsFragment paramContactDetailsFragment)
      {
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aQ(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.V(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, dagger.a.c.b(b.aR(b.this)));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.U(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.W(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aS(b.this));
        return paramContactDetailsFragment;
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        b(paramContactDetailsFragment);
      }
    }
  }

  private final class an extends com.viber.voip.g.a.a.t.a.a
  {
    private ContactDetailsDialogActivity b;

    private an()
    {
    }

    public com.viber.voip.g.a.a.t.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactDetailsDialogActivity.class.getCanonicalName() + " must be set");
      return new b.ao(b.this, this, null);
    }

    public void a(ContactDetailsDialogActivity paramContactDetailsDialogActivity)
    {
      this.b = ((ContactDetailsDialogActivity)dagger.a.h.a(paramContactDetailsDialogActivity));
    }
  }

  private final class ao
    implements com.viber.voip.g.a.a.t.a
  {
    private Provider<com.viber.voip.g.a.bj.a.a> b;

    private ao(b.an arg2)
    {
      b.an localan;
      a(localan);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(ContactDetailsFragment.class, this.b).a();
    }

    private void a(b.an paraman)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.bj.a.a a()
        {
          return new b.ao.a(b.ao.this, null);
        }
      };
    }

    private ContactDetailsDialogActivity b(ContactDetailsDialogActivity paramContactDetailsDialogActivity)
    {
      com.viber.voip.contacts.ui.d.a(paramContactDetailsDialogActivity, b());
      com.viber.voip.contacts.ui.d.a(paramContactDetailsDialogActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramContactDetailsDialogActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ContactDetailsDialogActivity paramContactDetailsDialogActivity)
    {
      b(paramContactDetailsDialogActivity);
    }

    private final class a extends com.viber.voip.g.a.bj.a.a
    {
      private ContactDetailsFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.bj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ContactDetailsFragment.class.getCanonicalName() + " must be set");
        return new b.ao.b(b.ao.this, this, null);
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        this.b = ((ContactDetailsFragment)dagger.a.h.a(paramContactDetailsFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.bj.a
    {
      private b(b.ao.a arg2)
      {
      }

      private ContactDetailsFragment b(ContactDetailsFragment paramContactDetailsFragment)
      {
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aQ(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.V(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, dagger.a.c.b(b.aR(b.this)));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.U(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.W(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aS(b.this));
        return paramContactDetailsFragment;
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        b(paramContactDetailsFragment);
      }
    }
  }

  private final class ap extends com.viber.voip.g.a.a.u.a.a
  {
    private ContactsCompose1to1ListActivity b;

    private ap()
    {
    }

    public com.viber.voip.g.a.a.u.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactsCompose1to1ListActivity.class.getCanonicalName() + " must be set");
      return new b.aq(b.this, this, null);
    }

    public void a(ContactsCompose1to1ListActivity paramContactsCompose1to1ListActivity)
    {
      this.b = ((ContactsCompose1to1ListActivity)dagger.a.h.a(paramContactsCompose1to1ListActivity));
    }
  }

  private final class aq
    implements com.viber.voip.g.a.a.u.a
  {
    private Provider<com.viber.voip.g.a.a.a.k.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.l.a.a> c;

    private aq(b.ap arg2)
    {
      b.ap localap;
      a(localap);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.o.class, this.b).a(com.viber.voip.contacts.ui.s.class, this.c).a();
    }

    private void a(b.ap paramap)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.k.a.a a()
        {
          return new b.aq.a(b.aq.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.l.a.a a()
        {
          return new b.aq.c(b.aq.this, null);
        }
      };
    }

    private ContactsCompose1to1ListActivity b(ContactsCompose1to1ListActivity paramContactsCompose1to1ListActivity)
    {
      com.viber.voip.contacts.ui.q.a(paramContactsCompose1to1ListActivity, b());
      com.viber.voip.contacts.ui.q.a(paramContactsCompose1to1ListActivity, dagger.a.c.b(b.bd(b.this)));
      return paramContactsCompose1to1ListActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ContactsCompose1to1ListActivity paramContactsCompose1to1ListActivity)
    {
      b(paramContactsCompose1to1ListActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.k.a.a
    {
      private com.viber.voip.contacts.ui.o b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.k.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.o.class.getCanonicalName() + " must be set");
        return new b.aq.b(b.aq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        this.b = ((com.viber.voip.contacts.ui.o)dagger.a.h.a(paramo));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.k.a
    {
      private b(b.aq.a arg2)
      {
      }

      private com.viber.voip.contacts.ui.o b(com.viber.voip.contacts.ui.o paramo)
      {
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        com.viber.voip.contacts.ui.p.a(paramo, b.P(b.this));
        return paramo;
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        b(paramo);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.l.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.l.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.aq.d(b.aq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.l.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.aq.c arg2)
      {
        b.aq.c localc;
        a(localc);
      }

      private void a(b.aq.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.aq.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }
  }

  private final class ar extends v.a.a
  {
    private ContactsComposeCombinedActivity b;

    private ar()
    {
    }

    public v.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactsComposeCombinedActivity.class.getCanonicalName() + " must be set");
      return new b.as(b.this, this, null);
    }

    public void a(ContactsComposeCombinedActivity paramContactsComposeCombinedActivity)
    {
      this.b = ((ContactsComposeCombinedActivity)dagger.a.h.a(paramContactsComposeCombinedActivity));
    }
  }

  private final class as
    implements v.a
  {
    private Provider<com.viber.voip.g.a.a.a.k.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.l.a.a> c;

    private as(b.ar arg2)
    {
      b.ar localar;
      a(localar);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.o.class, this.b).a(com.viber.voip.contacts.ui.s.class, this.c).a();
    }

    private void a(b.ar paramar)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.k.a.a a()
        {
          return new b.as.a(b.as.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.l.a.a a()
        {
          return new b.as.c(b.as.this, null);
        }
      };
    }

    private ContactsComposeCombinedActivity b(ContactsComposeCombinedActivity paramContactsComposeCombinedActivity)
    {
      com.viber.voip.contacts.ui.r.a(paramContactsComposeCombinedActivity, b());
      return paramContactsComposeCombinedActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ContactsComposeCombinedActivity paramContactsComposeCombinedActivity)
    {
      b(paramContactsComposeCombinedActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.k.a.a
    {
      private com.viber.voip.contacts.ui.o b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.k.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.o.class.getCanonicalName() + " must be set");
        return new b.as.b(b.as.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        this.b = ((com.viber.voip.contacts.ui.o)dagger.a.h.a(paramo));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.k.a
    {
      private b(b.as.a arg2)
      {
      }

      private com.viber.voip.contacts.ui.o b(com.viber.voip.contacts.ui.o paramo)
      {
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        com.viber.voip.contacts.ui.p.a(paramo, b.P(b.this));
        return paramo;
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        b(paramo);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.l.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.l.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.as.d(b.as.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.l.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.as.c arg2)
      {
        b.as.c localc;
        a(localc);
      }

      private void a(b.as.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.as.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }
  }

  private final class at extends com.viber.voip.g.a.a.w.a.a
  {
    private ContactsComposeListActivity b;

    private at()
    {
    }

    public com.viber.voip.g.a.a.w.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactsComposeListActivity.class.getCanonicalName() + " must be set");
      return new b.au(b.this, this, null);
    }

    public void a(ContactsComposeListActivity paramContactsComposeListActivity)
    {
      this.b = ((ContactsComposeListActivity)dagger.a.h.a(paramContactsComposeListActivity));
    }
  }

  private final class au
    implements com.viber.voip.g.a.a.w.a
  {
    private Provider<com.viber.voip.g.a.a.a.q.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.m.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.p.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.o.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.n.a.a> f;

    private au(b.at arg2)
    {
      b.at localat;
      a(localat);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.ay.class, this.b).a(com.viber.voip.block.n.class, this.c).a(com.viber.voip.viberout.ui.c.class, this.d).a(com.viber.voip.contacts.ui.s.class, this.e).a(ConferenceParticipantsSelectFragment.class, this.f).a();
    }

    private void a(b.at paramat)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.q.a.a a()
        {
          return new b.au.i(b.au.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.m.a.a a()
        {
          return new b.au.a(b.au.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.p.a.a a()
        {
          return new b.au.g(b.au.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.o.a.a a()
        {
          return new b.au.c(b.au.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.n.a.a a()
        {
          return new b.au.e(b.au.this, null);
        }
      };
    }

    private ContactsComposeListActivity b(ContactsComposeListActivity paramContactsComposeListActivity)
    {
      com.viber.voip.contacts.ui.w.a(paramContactsComposeListActivity, b());
      com.viber.voip.contacts.ui.w.a(paramContactsComposeListActivity, dagger.a.c.b(b.bd(b.this)));
      return paramContactsComposeListActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ContactsComposeListActivity paramContactsComposeListActivity)
    {
      b(paramContactsComposeListActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.m.a.a
    {
      private com.viber.voip.block.n b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.m.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.block.n.class.getCanonicalName() + " must be set");
        return new b.au.b(b.au.this, this, null);
      }

      public void a(com.viber.voip.block.n paramn)
      {
        this.b = ((com.viber.voip.block.n)dagger.a.h.a(paramn));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.m.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.block.n> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private b(b.au.a arg2)
      {
        b.au.a locala;
        a(locala);
      }

      private void a(b.au.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.au.a.a(parama));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.block.n b(com.viber.voip.block.n paramn)
      {
        com.viber.voip.contacts.ui.v.a(paramn, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramn, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramn, dagger.a.c.b(this.e));
        return paramn;
      }

      public void a(com.viber.voip.block.n paramn)
      {
        b(paramn);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.o.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.o.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.au.d(b.au.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.o.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.au.c arg2)
      {
        b.au.c localc;
        a(localc);
      }

      private void a(b.au.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.au.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.n.a.a
    {
      private ConferenceParticipantsSelectFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.n.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ConferenceParticipantsSelectFragment.class.getCanonicalName() + " must be set");
        return new b.au.f(b.au.this, this, null);
      }

      public void a(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        this.b = ((ConferenceParticipantsSelectFragment)dagger.a.h.a(paramConferenceParticipantsSelectFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.n.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<ConferenceParticipantsSelectFragment> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private f(b.au.e arg2)
      {
        b.au.e locale;
        a(locale);
      }

      private void a(b.au.e parame)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.au.e.a(parame));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private ConferenceParticipantsSelectFragment b(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        com.viber.voip.contacts.ui.v.a(paramConferenceParticipantsSelectFragment, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.e));
        return paramConferenceParticipantsSelectFragment;
      }

      public void a(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
      {
        b(paramConferenceParticipantsSelectFragment);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.p.a.a
    {
      private com.viber.voip.viberout.ui.c b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.p.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.viberout.ui.c.class.getCanonicalName() + " must be set");
        return new b.au.h(b.au.this, this, null);
      }

      public void a(com.viber.voip.viberout.ui.c paramc)
      {
        this.b = ((com.viber.voip.viberout.ui.c)dagger.a.h.a(paramc));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.p.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.viberout.ui.c> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private h(b.au.g arg2)
      {
        b.au.g localg;
        a(localg);
      }

      private void a(b.au.g paramg)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.au.g.a(paramg));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.viberout.ui.c b(com.viber.voip.viberout.ui.c paramc)
      {
        com.viber.voip.contacts.ui.v.a(paramc, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramc, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramc, dagger.a.c.b(this.e));
        return paramc;
      }

      public void a(com.viber.voip.viberout.ui.c paramc)
      {
        b(paramc);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.q.a.a
    {
      private com.viber.voip.contacts.ui.ay b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.q.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.ay.class.getCanonicalName() + " must be set");
        return new b.au.j(b.au.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.ay paramay)
      {
        this.b = ((com.viber.voip.contacts.ui.ay)dagger.a.h.a(paramay));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.q.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.ay> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private j(b.au.i arg2)
      {
        b.au.i locali;
        a(locali);
      }

      private void a(b.au.i parami)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.au.i.a(parami));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.ay b(com.viber.voip.contacts.ui.ay paramay)
      {
        com.viber.voip.contacts.ui.v.a(paramay, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramay, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramay, dagger.a.c.b(this.e));
        return paramay;
      }

      public void a(com.viber.voip.contacts.ui.ay paramay)
      {
        b(paramay);
      }
    }
  }

  private final class av extends x.a.a
  {
    private ContactsFragment b;

    private av()
    {
    }

    public x.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ContactsFragment.class.getCanonicalName() + " must be set");
      return new b.aw(b.this, this, null);
    }

    public void a(ContactsFragment paramContactsFragment)
    {
      this.b = ((ContactsFragment)dagger.a.h.a(paramContactsFragment));
    }
  }

  private final class aw
    implements x.a
  {
    private aw(b.av arg2)
    {
    }

    private ContactsFragment b(ContactsFragment paramContactsFragment)
    {
      com.viber.voip.contacts.ui.ai.a(paramContactsFragment, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
      com.viber.voip.contacts.ui.ai.a(paramContactsFragment, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
      return paramContactsFragment;
    }

    public void a(ContactsFragment paramContactsFragment)
    {
      b(paramContactsFragment);
    }
  }

  private final class ax extends y.a.a
  {
    private ConversationActivity b;

    private ax()
    {
    }

    public y.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ConversationActivity.class.getCanonicalName() + " must be set");
      return new b.ay(b.this, this, null);
    }

    public void a(ConversationActivity paramConversationActivity)
    {
      this.b = ((ConversationActivity)dagger.a.h.a(paramConversationActivity));
    }
  }

  private final class ay
    implements y.a
  {
    private Provider<com.viber.voip.g.a.a.a.i.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.h.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.s.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.r.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.t.a.a> f;

    private ay(b.ax arg2)
    {
      b.ax localax;
      a(localax);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(ChatInfoGroupFragment.class, this.b).a(com.viber.voip.messages.conversation.chatinfo.presentation.o.class, this.c).a(MessagesLeftMenuFragment.class, this.d).a(BusinessInboxMessagesLeftMenuFragment.class, this.e).a(SmsInboxMessagesLeftMenuFragment.class, this.f).a();
    }

    private void a(b.ax paramax)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.i.a.a a()
        {
          return new b.ay.e(b.ay.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.h.a.a a()
        {
          return new b.ay.c(b.ay.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.s.a.a a()
        {
          return new b.ay.g(b.ay.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.r.a.a a()
        {
          return new b.ay.a(b.ay.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.t.a.a a()
        {
          return new b.ay.i(b.ay.this, null);
        }
      };
    }

    private ConversationActivity b(ConversationActivity paramConversationActivity)
    {
      com.viber.voip.messages.ui.s.a(paramConversationActivity, gn.c());
      com.viber.voip.messages.ui.s.a(paramConversationActivity, b.B(b.this));
      com.viber.voip.messages.ui.s.a(paramConversationActivity, (com.viber.voip.messages.ui.media.player.d.e)b.C(b.this).get());
      com.viber.voip.messages.ui.s.a(paramConversationActivity, b());
      com.viber.voip.messages.ui.s.a(paramConversationActivity, b.this.d());
      com.viber.voip.messages.ui.s.a(paramConversationActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.ui.s.b(paramConversationActivity, dagger.a.c.b(b.E(b.this)));
      return paramConversationActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    private com.viber.voip.messages.conversation.chatinfo.a.h<com.viber.voip.messages.conversation.chatinfo.d.d> c()
    {
      return com.viber.voip.g.a.a.b.d.a(dagger.a.c.b(b.A(b.this)));
    }

    private com.viber.voip.messages.conversation.chatinfo.b.a d()
    {
      return com.viber.voip.g.a.a.b.e.a(c());
    }

    public void a(ConversationActivity paramConversationActivity)
    {
      b(paramConversationActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.r.a.a
    {
      private BusinessInboxMessagesLeftMenuFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.r.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(BusinessInboxMessagesLeftMenuFragment.class.getCanonicalName() + " must be set");
        return new b.ay.b(b.ay.this, this, null);
      }

      public void a(BusinessInboxMessagesLeftMenuFragment paramBusinessInboxMessagesLeftMenuFragment)
      {
        this.b = ((BusinessInboxMessagesLeftMenuFragment)dagger.a.h.a(paramBusinessInboxMessagesLeftMenuFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.r.a
    {
      private b(b.ay.a arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private BusinessInboxMessagesLeftMenuFragment b(BusinessInboxMessagesLeftMenuFragment paramBusinessInboxMessagesLeftMenuFragment)
      {
        com.viber.voip.messages.ui.i.a(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.af(b.this)));
        bu.a(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ac(b.this)));
        bu.b(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.A(b.this)));
        bu.c(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ag(b.this)));
        bu.d(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ah(b.this)));
        bu.e(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ai(b.this)));
        bu.a(paramBusinessInboxMessagesLeftMenuFragment, b.this.d());
        bu.a(paramBusinessInboxMessagesLeftMenuFragment, b.aj(b.this));
        bu.a(paramBusinessInboxMessagesLeftMenuFragment, b.ak(b.this));
        bu.f(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.O(b.this)));
        bu.a(paramBusinessInboxMessagesLeftMenuFragment, b());
        bu.h(paramBusinessInboxMessagesLeftMenuFragment, dagger.a.c.b(b.al(b.this)));
        return paramBusinessInboxMessagesLeftMenuFragment;
      }

      public void a(BusinessInboxMessagesLeftMenuFragment paramBusinessInboxMessagesLeftMenuFragment)
      {
        b(paramBusinessInboxMessagesLeftMenuFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.h.a.a
    {
      private com.viber.voip.messages.conversation.chatinfo.presentation.o b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.h.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.chatinfo.presentation.o.class.getCanonicalName() + " must be set");
        return new b.ay.d(b.ay.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        this.b = ((com.viber.voip.messages.conversation.chatinfo.presentation.o)dagger.a.h.a(paramo));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.h.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private d(b.ay.c arg2)
      {
        b.ay.c localc;
        a(localc);
      }

      private void a(b.ay.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private com.viber.voip.messages.conversation.chatinfo.presentation.o b(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramo, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramo, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.ay.a(b.ay.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramo, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramo, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramo, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, b.this.d());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, bl.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramo, b.X(b.this));
        return paramo;
      }

      public void a(com.viber.voip.messages.conversation.chatinfo.presentation.o paramo)
      {
        b(paramo);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.i.a.a
    {
      private ChatInfoGroupFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.i.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ChatInfoGroupFragment.class.getCanonicalName() + " must be set");
        return new b.ay.f(b.ay.this, this, null);
      }

      public void a(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        this.b = ((ChatInfoGroupFragment)dagger.a.h.a(paramChatInfoGroupFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.i.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;
      private Provider<com.viber.voip.report.community.a> c;

      private f(b.ay.e arg2)
      {
        b.ay.e locale;
        a(locale);
      }

      private com.viber.voip.report.a.a.a a()
      {
        return new com.viber.voip.report.a.a.a((com.viber.voip.messages.controller.manager.ab)b.F(b.this).get(), b.G(b.this), dagger.a.c.b(b.H(b.this)), gf.b(), gn.c());
      }

      private void a(b.ay.e parame)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
        this.c = dagger.a.c.a(com.viber.voip.report.community.b.b());
      }

      private ChatInfoGroupFragment b(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramChatInfoGroupFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramChatInfoGroupFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.ay.a(b.ay.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramChatInfoGroupFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramChatInfoGroupFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramChatInfoGroupFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, b.this.d());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, bl.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.t.a(paramChatInfoGroupFragment, b.X(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, b.Y(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, a());
        com.viber.voip.messages.conversation.chatinfo.presentation.v.a(paramChatInfoGroupFragment, (com.viber.voip.report.community.a)this.c.get());
        return paramChatInfoGroupFragment;
      }

      public void a(ChatInfoGroupFragment paramChatInfoGroupFragment)
      {
        b(paramChatInfoGroupFragment);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.s.a.a
    {
      private MessagesLeftMenuFragment b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.s.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(MessagesLeftMenuFragment.class.getCanonicalName() + " must be set");
        return new b.ay.h(b.ay.this, this, null);
      }

      public void a(MessagesLeftMenuFragment paramMessagesLeftMenuFragment)
      {
        this.b = ((MessagesLeftMenuFragment)dagger.a.h.a(paramMessagesLeftMenuFragment));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.s.a
    {
      private com.viber.voip.messages.conversation.a.e b;
      private com.viber.voip.messages.conversation.a.g c;
      private com.viber.voip.g.a.a.b.t d;

      private h(b.ay.g arg2)
      {
        b.ay.g localg;
        a(localg);
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private void a(b.ay.g paramg)
      {
        this.b = com.viber.voip.messages.conversation.a.e.a(b.ab(b.this), gn.b(), b.I(b.this), b.ac(b.this), b.ad(b.this));
        this.c = com.viber.voip.messages.conversation.a.g.a(b.A(b.this));
        this.d = com.viber.voip.g.a.a.b.t.a(com.viber.voip.messages.conversation.a.n.b(), this.b, this.c, com.viber.voip.messages.conversation.a.l.b());
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private MessagesLeftMenuFragment b(MessagesLeftMenuFragment paramMessagesLeftMenuFragment)
      {
        com.viber.voip.messages.ui.i.a(paramMessagesLeftMenuFragment, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramMessagesLeftMenuFragment, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramMessagesLeftMenuFragment, dagger.a.c.b(b.af(b.this)));
        bu.a(paramMessagesLeftMenuFragment, dagger.a.c.b(b.ac(b.this)));
        bu.b(paramMessagesLeftMenuFragment, dagger.a.c.b(b.A(b.this)));
        bu.c(paramMessagesLeftMenuFragment, dagger.a.c.b(b.ag(b.this)));
        bu.d(paramMessagesLeftMenuFragment, dagger.a.c.b(b.ah(b.this)));
        bu.e(paramMessagesLeftMenuFragment, dagger.a.c.b(b.ai(b.this)));
        bu.a(paramMessagesLeftMenuFragment, b.this.d());
        bu.a(paramMessagesLeftMenuFragment, b.aj(b.this));
        bu.a(paramMessagesLeftMenuFragment, b.ak(b.this));
        bu.f(paramMessagesLeftMenuFragment, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paramMessagesLeftMenuFragment, dagger.a.c.b(b.O(b.this)));
        bu.a(paramMessagesLeftMenuFragment, b());
        bu.h(paramMessagesLeftMenuFragment, dagger.a.c.b(b.al(b.this)));
        com.viber.voip.messages.ui.bv.a(paramMessagesLeftMenuFragment, dagger.a.c.b(this.d));
        return paramMessagesLeftMenuFragment;
      }

      public void a(MessagesLeftMenuFragment paramMessagesLeftMenuFragment)
      {
        b(paramMessagesLeftMenuFragment);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.t.a.a
    {
      private SmsInboxMessagesLeftMenuFragment b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.t.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(SmsInboxMessagesLeftMenuFragment.class.getCanonicalName() + " must be set");
        return new b.ay.j(b.ay.this, this, null);
      }

      public void a(SmsInboxMessagesLeftMenuFragment paramSmsInboxMessagesLeftMenuFragment)
      {
        this.b = ((SmsInboxMessagesLeftMenuFragment)dagger.a.h.a(paramSmsInboxMessagesLeftMenuFragment));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.t.a
    {
      private j(b.ay.i arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private SmsInboxMessagesLeftMenuFragment b(SmsInboxMessagesLeftMenuFragment paramSmsInboxMessagesLeftMenuFragment)
      {
        com.viber.voip.messages.ui.i.a(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.af(b.this)));
        bu.a(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ac(b.this)));
        bu.b(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.A(b.this)));
        bu.c(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ag(b.this)));
        bu.d(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ah(b.this)));
        bu.e(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.ai(b.this)));
        bu.a(paramSmsInboxMessagesLeftMenuFragment, b.this.d());
        bu.a(paramSmsInboxMessagesLeftMenuFragment, b.aj(b.this));
        bu.a(paramSmsInboxMessagesLeftMenuFragment, b.ak(b.this));
        bu.f(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.O(b.this)));
        bu.a(paramSmsInboxMessagesLeftMenuFragment, b());
        bu.h(paramSmsInboxMessagesLeftMenuFragment, dagger.a.c.b(b.al(b.this)));
        return paramSmsInboxMessagesLeftMenuFragment;
      }

      public void a(SmsInboxMessagesLeftMenuFragment paramSmsInboxMessagesLeftMenuFragment)
      {
        b(paramSmsInboxMessagesLeftMenuFragment);
      }
    }
  }

  private final class az extends z.a.a
  {
    private ConversationFragment b;

    private az()
    {
    }

    public z.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ConversationFragment.class.getCanonicalName() + " must be set");
      return new b.ba(b.this, this, null);
    }

    public void a(ConversationFragment paramConversationFragment)
    {
      this.b = ((ConversationFragment)dagger.a.h.a(paramConversationFragment));
    }
  }

  private final class b
    implements com.viber.voip.g.a.a.a.a
  {
    private b(b.a arg2)
    {
    }

    private AboutActivity b(AboutActivity paramAboutActivity)
    {
      com.viber.voip.a.a(paramAboutActivity, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.a.a(paramAboutActivity, b.an(b.this));
      com.viber.voip.a.a(paramAboutActivity, eg.b());
      return paramAboutActivity;
    }

    public void a(AboutActivity paramAboutActivity)
    {
      b(paramAboutActivity);
    }
  }

  private final class ba
    implements z.a
  {
    private ba(b.az arg2)
    {
    }

    private ConversationFragment b(ConversationFragment paramConversationFragment)
    {
      aw.a(paramConversationFragment, fx.b());
      aw.a(paramConversationFragment, b.bM(b.this));
      aw.a(paramConversationFragment, b.bN(b.this));
      aw.a(paramConversationFragment, fz.c());
      aw.a(paramConversationFragment, ck.c());
      aw.a(paramConversationFragment, b.bO(b.this));
      aw.a(paramConversationFragment, b.bP(b.this));
      aw.a(paramConversationFragment, com.viber.voip.g.a.s.c());
      aw.a(paramConversationFragment, b.X(b.this));
      aw.a(paramConversationFragment, b.P(b.this));
      aw.a(paramConversationFragment, b.ak(b.this));
      aw.a(paramConversationFragment, b.aj(b.this));
      aw.a(paramConversationFragment, b.bQ(b.this));
      aw.a(paramConversationFragment, b.bR(b.this));
      aw.a(paramConversationFragment, dx.c());
      aw.a(paramConversationFragment, b.N(b.this));
      aw.a(paramConversationFragment, b.aq(b.this));
      aw.a(paramConversationFragment, b.ar(b.this));
      aw.a(paramConversationFragment, (com.viber.voip.app.b)b.I(b.this).get());
      aw.a(paramConversationFragment, b.L(b.this));
      aw.a(paramConversationFragment, b.U(b.this));
      aw.a(paramConversationFragment, b.bg(b.this));
      aw.a(paramConversationFragment, b.this.d());
      aw.a(paramConversationFragment, dagger.a.c.b(b.J(b.this)));
      aw.b(paramConversationFragment, dagger.a.c.b(b.af(b.this)));
      aw.a(paramConversationFragment, com.viber.voip.g.a.p.c());
      aw.a(paramConversationFragment, du.c());
      aw.a(paramConversationFragment, (com.viber.common.permission.c)b.K(b.this).get());
      aw.a(paramConversationFragment, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      aw.c(paramConversationFragment, dagger.a.c.b(b.O(b.this)));
      aw.a(paramConversationFragment, b.an(b.this));
      aw.d(paramConversationFragment, dagger.a.c.b(b.T(b.this)));
      aw.a(paramConversationFragment, (com.viber.voip.messages.extensions.i)b.bS(b.this).get());
      aw.e(paramConversationFragment, dagger.a.c.b(b.aW(b.this)));
      aw.a(paramConversationFragment, (EventBus)b.M(b.this).get());
      aw.a(paramConversationFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
      aw.f(paramConversationFragment, dagger.a.c.b(b.bT(b.this)));
      aw.g(paramConversationFragment, dagger.a.c.b(b.al(b.this)));
      aw.h(paramConversationFragment, dagger.a.c.b(b.A(b.this)));
      aw.a(paramConversationFragment, b.V(b.this));
      aw.i(paramConversationFragment, dagger.a.c.b(b.ai(b.this)));
      return paramConversationFragment;
    }

    public void a(ConversationFragment paramConversationFragment)
    {
      b(paramConversationFragment);
    }
  }

  private final class bb extends com.viber.voip.g.a.a.aa.a.a
  {
    private ConversationGalleryActivity b;

    private bb()
    {
    }

    public com.viber.voip.g.a.a.aa.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ConversationGalleryActivity.class.getCanonicalName() + " must be set");
      return new b.bc(b.this, this, null);
    }

    public void a(ConversationGalleryActivity paramConversationGalleryActivity)
    {
      this.b = ((ConversationGalleryActivity)dagger.a.h.a(paramConversationGalleryActivity));
    }
  }

  private final class bc
    implements com.viber.voip.g.a.a.aa.a
  {
    private Provider<com.viber.voip.g.a.a.a.u.a.a> b;

    private bc(b.bb arg2)
    {
      b.bb localbb;
      a(localbb);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.conversation.ui.ax.class, this.b).a();
    }

    private void a(b.bb parambb)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.u.a.a a()
        {
          return new b.bc.a(b.bc.this, null);
        }
      };
    }

    private ConversationGalleryActivity b(ConversationGalleryActivity paramConversationGalleryActivity)
    {
      com.viber.voip.messages.ui.v.a(paramConversationGalleryActivity, b());
      return paramConversationGalleryActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ConversationGalleryActivity paramConversationGalleryActivity)
    {
      b(paramConversationGalleryActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.u.a.a
    {
      private com.viber.voip.messages.conversation.ui.ax b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.u.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.ui.ax.class.getCanonicalName() + " must be set");
        return new b.bc.b(b.bc.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.ui.ax paramax)
      {
        this.b = ((com.viber.voip.messages.conversation.ui.ax)dagger.a.h.a(paramax));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.u.a
    {
      private b(b.bc.a arg2)
      {
      }

      private com.viber.voip.messages.conversation.ui.ax b(com.viber.voip.messages.conversation.ui.ax paramax)
      {
        com.viber.voip.messages.conversation.ui.ay.a(paramax, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.ui.ay.a(paramax, (com.viber.common.permission.c)b.K(b.this).get());
        return paramax;
      }

      public void a(com.viber.voip.messages.conversation.ui.ax paramax)
      {
        b(paramax);
      }
    }
  }

  private final class bd extends com.viber.voip.g.a.a.ac.a.a
  {
    private CreditCardCheckoutWebActivity b;

    private bd()
    {
    }

    public com.viber.voip.g.a.a.ac.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(CreditCardCheckoutWebActivity.class.getCanonicalName() + " must be set");
      return new b.be(b.this, this, null);
    }

    public void a(CreditCardCheckoutWebActivity paramCreditCardCheckoutWebActivity)
    {
      this.b = ((CreditCardCheckoutWebActivity)dagger.a.h.a(paramCreditCardCheckoutWebActivity));
    }
  }

  private final class be
    implements com.viber.voip.g.a.a.ac.a
  {
    private be(b.bd arg2)
    {
    }

    private CreditCardCheckoutWebActivity b(CreditCardCheckoutWebActivity paramCreditCardCheckoutWebActivity)
    {
      com.viber.voip.viberout.ui.b.a(paramCreditCardCheckoutWebActivity, b.aC(b.this));
      return paramCreditCardCheckoutWebActivity;
    }

    public void a(CreditCardCheckoutWebActivity paramCreditCardCheckoutWebActivity)
    {
      b(paramCreditCardCheckoutWebActivity);
    }
  }

  private final class bf extends com.viber.voip.g.a.a.ad.a.a
  {
    private CustomCamTakeVideoActivity b;

    private bf()
    {
    }

    public com.viber.voip.g.a.a.ad.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(CustomCamTakeVideoActivity.class.getCanonicalName() + " must be set");
      return new b.bg(b.this, this, null);
    }

    public void a(CustomCamTakeVideoActivity paramCustomCamTakeVideoActivity)
    {
      this.b = ((CustomCamTakeVideoActivity)dagger.a.h.a(paramCustomCamTakeVideoActivity));
    }
  }

  private final class bg
    implements com.viber.voip.g.a.a.ad.a
  {
    private bg(b.bf arg2)
    {
    }

    private CustomCamTakeVideoActivity b(CustomCamTakeVideoActivity paramCustomCamTakeVideoActivity)
    {
      com.viber.voip.camrecorder.a.a(paramCustomCamTakeVideoActivity, (com.viber.voip.util.e.g)b.R(b.this).get());
      com.viber.voip.camrecorder.a.a(paramCustomCamTakeVideoActivity, (com.viber.common.permission.c)b.K(b.this).get());
      return paramCustomCamTakeVideoActivity;
    }

    public void a(CustomCamTakeVideoActivity paramCustomCamTakeVideoActivity)
    {
      b(paramCustomCamTakeVideoActivity);
    }
  }

  private final class bh extends com.viber.voip.g.a.a.ae.a.a
  {
    private com.viber.voip.settings.ui.d b;

    private bh()
    {
    }

    public com.viber.voip.g.a.a.ae.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.settings.ui.d.class.getCanonicalName() + " must be set");
      return new b.bi(b.this, this, null);
    }

    public void a(com.viber.voip.settings.ui.d paramd)
    {
      this.b = ((com.viber.voip.settings.ui.d)dagger.a.h.a(paramd));
    }
  }

  private final class bi
    implements com.viber.voip.g.a.a.ae.a
  {
    private bi(b.bh arg2)
    {
    }

    private com.viber.voip.settings.ui.d b(com.viber.voip.settings.ui.d paramd)
    {
      com.viber.voip.settings.ui.e.a(paramd, (com.viber.voip.vln.e)b.aT(b.this).get());
      com.viber.voip.settings.ui.e.a(paramd, b.an(b.this));
      com.viber.voip.settings.ui.e.a(paramd, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.settings.ui.e.a(paramd, dagger.a.c.b(b.bd(b.this)));
      com.viber.voip.settings.ui.e.b(paramd, dagger.a.c.b(com.viber.voip.g.a.s.b()));
      com.viber.voip.settings.ui.e.c(paramd, dagger.a.c.b(b.bZ(b.this)));
      com.viber.voip.settings.ui.e.a(paramd, b.ca(b.this));
      return paramd;
    }

    public void a(com.viber.voip.settings.ui.d paramd)
    {
      b(paramd);
    }
  }

  private final class bj extends com.viber.voip.g.a.a.af.a.a
  {
    private com.viber.voip.settings.ui.i b;

    private bj()
    {
    }

    public com.viber.voip.g.a.a.af.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.settings.ui.i.class.getCanonicalName() + " must be set");
      return new b.bk(b.this, this, null);
    }

    public void a(com.viber.voip.settings.ui.i parami)
    {
      this.b = ((com.viber.voip.settings.ui.i)dagger.a.h.a(parami));
    }
  }

  private final class bk
    implements com.viber.voip.g.a.a.af.a
  {
    private bk(b.bj arg2)
    {
    }

    private com.viber.voip.settings.ui.i b(com.viber.voip.settings.ui.i parami)
    {
      com.viber.voip.settings.ui.j.a(parami, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.settings.ui.j.a(parami, dagger.a.c.b(b.bd(b.this)));
      com.viber.voip.settings.ui.j.b(parami, dagger.a.c.b(b.am(b.this)));
      com.viber.voip.settings.ui.j.a(parami, b.this.d());
      return parami;
    }

    public void a(com.viber.voip.settings.ui.i parami)
    {
      b(parami);
    }
  }

  private final class bl extends com.viber.voip.g.a.a.ag.a.a
  {
    private EditInfoFragment b;

    private bl()
    {
    }

    public com.viber.voip.g.a.a.ag.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(EditInfoFragment.class.getCanonicalName() + " must be set");
      return new b.bm(b.this, this, null);
    }

    public void a(EditInfoFragment paramEditInfoFragment)
    {
      this.b = ((EditInfoFragment)dagger.a.h.a(paramEditInfoFragment));
    }
  }

  private final class bm
    implements com.viber.voip.g.a.a.ag.a
  {
    private bm(b.bl arg2)
    {
    }

    private EditInfoFragment b(EditInfoFragment paramEditInfoFragment)
    {
      EditInfoFragment_MembersInjector.injectMImageFetcher(paramEditInfoFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
      EditInfoFragment_MembersInjector.injectMPermissionManager(paramEditInfoFragment, (com.viber.common.permission.c)b.K(b.this).get());
      EditInfoFragment_MembersInjector.injectMDeviceConfiguration(paramEditInfoFragment, (com.viber.voip.app.b)b.I(b.this).get());
      return paramEditInfoFragment;
    }

    public void a(EditInfoFragment paramEditInfoFragment)
    {
      b(paramEditInfoFragment);
    }
  }

  private final class bn extends com.viber.voip.g.a.a.ah.a.a
  {
    private EndCallFragment b;

    private bn()
    {
    }

    public com.viber.voip.g.a.a.ah.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(EndCallFragment.class.getCanonicalName() + " must be set");
      return new b.bo(b.this, this, null);
    }

    public void a(EndCallFragment paramEndCallFragment)
    {
      this.b = ((EndCallFragment)dagger.a.h.a(paramEndCallFragment));
    }
  }

  private final class bo
    implements com.viber.voip.g.a.a.ah.a
  {
    private ConferenceGroupCreationHelper_Factory b;

    private bo(b.bn arg2)
    {
      b.bn localbn;
      a(localbn);
    }

    private void a(b.bn parambn)
    {
      this.b = ConferenceGroupCreationHelper_Factory.create(b.bG(b.this), b.S(b.this), b.aF(b.this), dt.b());
    }

    private EndCallFragment b(EndCallFragment paramEndCallFragment)
    {
      EndCallFragment_MembersInjector.injectMConferenceGroupCreationHelper(paramEndCallFragment, dagger.a.c.b(this.b));
      EndCallFragment_MembersInjector.injectMAnalyticsManager(paramEndCallFragment, com.viber.voip.g.a.s.c());
      EndCallFragment_MembersInjector.injectMParticipantMapper(paramEndCallFragment, b.bL(b.this));
      EndCallFragment_MembersInjector.injectMUserStartsCallEventCollector(paramEndCallFragment, dagger.a.c.b(b.O(b.this)));
      return paramEndCallFragment;
    }

    public void a(EndCallFragment paramEndCallFragment)
    {
      b(paramEndCallFragment);
    }
  }

  private final class bp extends cg.a.a
  {
    private ForwardActivity b;

    private bp()
    {
    }

    public cg.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ForwardActivity.class.getCanonicalName() + " must be set");
      return new b.bq(b.this, this, null);
    }

    public void a(ForwardActivity paramForwardActivity)
    {
      this.b = ((ForwardActivity)dagger.a.h.a(paramForwardActivity));
    }
  }

  private final class bq
    implements cg.a
  {
    private Provider<com.viber.voip.g.a.a.a.am.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.al.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ak.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.an.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.aj.a.a> f;
    private Provider<ForwardActivity> g;
    private com.viber.voip.invitelinks.h h;
    private Provider<ForwardPresenter> i;

    private bq(b.bp arg2)
    {
      b.bp localbp;
      a(localbp);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.an.class, this.b).a(bj.class, this.c).a(com.viber.voip.contacts.ui.s.class, this.d).a(com.viber.voip.contacts.ui.ba.class, this.e).a(com.viber.voip.contacts.ui.o.class, this.f).a();
    }

    private void a(b.bp parambp)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.am.a.a a()
        {
          return new b.bq.e(b.bq.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.al.a.a a()
        {
          return new b.bq.g(b.bq.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ak.a.a a()
        {
          return new b.bq.c(b.bq.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.an.a.a a()
        {
          return new b.bq.i(b.bq.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.aj.a.a a()
        {
          return new b.bq.a(b.bq.this, null);
        }
      };
      this.g = dagger.a.e.a(b.bp.a(parambp));
      this.h = com.viber.voip.invitelinks.h.a(b.aO(b.this), b.ag(b.this));
      this.i = dagger.a.c.a(com.viber.voip.g.a.a.a.z.a(this.g, this.h));
    }

    private ForwardActivity b(ForwardActivity paramForwardActivity)
    {
      com.viber.voip.contacts.ui.aq.a(paramForwardActivity, b());
      com.viber.voip.messages.ui.forward.b.a(paramForwardActivity, (ForwardPresenter)this.i.get());
      return paramForwardActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ForwardActivity paramForwardActivity)
    {
      b(paramForwardActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.aj.a.a
    {
      private com.viber.voip.contacts.ui.o b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.aj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.o.class.getCanonicalName() + " must be set");
        return new b.bq.b(b.bq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        this.b = ((com.viber.voip.contacts.ui.o)dagger.a.h.a(paramo));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.aj.a
    {
      private b(b.bq.a arg2)
      {
      }

      private com.viber.voip.contacts.ui.o b(com.viber.voip.contacts.ui.o paramo)
      {
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        com.viber.voip.contacts.ui.p.a(paramo, b.P(b.this));
        return paramo;
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        b(paramo);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ak.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ak.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.bq.d(b.bq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ak.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.bq.c arg2)
      {
        b.bq.c localc;
        a(localc);
      }

      private void a(b.bq.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.bq.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.am.a.a
    {
      private com.viber.voip.contacts.ui.an b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.am.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.an.class.getCanonicalName() + " must be set");
        return new b.bq.f(b.bq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        this.b = ((com.viber.voip.contacts.ui.an)dagger.a.h.a(paraman));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.am.a
    {
      private f(b.bq.e arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.contacts.ui.an b(com.viber.voip.contacts.ui.an paraman)
      {
        com.viber.voip.messages.ui.i.a(paraman, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paraman, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paraman, dagger.a.c.b(b.af(b.this)));
        bu.a(paraman, dagger.a.c.b(b.ac(b.this)));
        bu.b(paraman, dagger.a.c.b(b.A(b.this)));
        bu.c(paraman, dagger.a.c.b(b.ag(b.this)));
        bu.d(paraman, dagger.a.c.b(b.ah(b.this)));
        bu.e(paraman, dagger.a.c.b(b.ai(b.this)));
        bu.a(paraman, b.this.d());
        bu.a(paraman, b.aj(b.this));
        bu.a(paraman, b.ak(b.this));
        bu.f(paraman, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paraman, dagger.a.c.b(b.O(b.this)));
        bu.a(paraman, b());
        bu.h(paraman, dagger.a.c.b(b.al(b.this)));
        return paraman;
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        b(paraman);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.al.a.a
    {
      private bj b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.al.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(bj.class.getCanonicalName() + " must be set");
        return new b.bq.h(b.bq.this, this, null);
      }

      public void a(bj parambj)
      {
        this.b = ((bj)dagger.a.h.a(parambj));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.al.a
    {
      private h(b.bq.g arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private bj b(bj parambj)
      {
        com.viber.voip.messages.ui.i.a(parambj, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parambj, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parambj, dagger.a.c.b(b.af(b.this)));
        bu.a(parambj, dagger.a.c.b(b.ac(b.this)));
        bu.b(parambj, dagger.a.c.b(b.A(b.this)));
        bu.c(parambj, dagger.a.c.b(b.ag(b.this)));
        bu.d(parambj, dagger.a.c.b(b.ah(b.this)));
        bu.e(parambj, dagger.a.c.b(b.ai(b.this)));
        bu.a(parambj, b.this.d());
        bu.a(parambj, b.aj(b.this));
        bu.a(parambj, b.ak(b.this));
        bu.f(parambj, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(parambj, dagger.a.c.b(b.O(b.this)));
        bu.a(parambj, b());
        bu.h(parambj, dagger.a.c.b(b.al(b.this)));
        return parambj;
      }

      public void a(bj parambj)
      {
        b(parambj);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.an.a.a
    {
      private com.viber.voip.contacts.ui.ba b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.an.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.ba.class.getCanonicalName() + " must be set");
        return new b.bq.j(b.bq.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.ba paramba)
      {
        this.b = ((com.viber.voip.contacts.ui.ba)dagger.a.h.a(paramba));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.an.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.ba> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private j(b.bq.i arg2)
      {
        b.bq.i locali;
        a(locali);
      }

      private void a(b.bq.i parami)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.bq.i.a(parami));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.ba b(com.viber.voip.contacts.ui.ba paramba)
      {
        com.viber.voip.contacts.ui.v.a(paramba, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramba, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramba, dagger.a.c.b(this.e));
        return paramba;
      }

      public void a(com.viber.voip.contacts.ui.ba paramba)
      {
        b(paramba);
      }
    }
  }

  private final class br extends ai.a.a
  {
    private ForwardCreatePollActivity b;

    private br()
    {
    }

    public ai.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ForwardCreatePollActivity.class.getCanonicalName() + " must be set");
      return new b.bs(b.this, this, null);
    }

    public void a(ForwardCreatePollActivity paramForwardCreatePollActivity)
    {
      this.b = ((ForwardCreatePollActivity)dagger.a.h.a(paramForwardCreatePollActivity));
    }
  }

  private final class bs
    implements ai.a
  {
    private Provider<com.viber.voip.g.a.a.a.aa.a.a> b;

    private bs(b.br arg2)
    {
      b.br localbr;
      a(localbr);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.an.class, this.b).a();
    }

    private void a(b.br parambr)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.aa.a.a a()
        {
          return new b.bs.a(b.bs.this, null);
        }
      };
    }

    private ForwardCreatePollActivity b(ForwardCreatePollActivity paramForwardCreatePollActivity)
    {
      com.viber.voip.messages.conversation.ui.vote.a.a(paramForwardCreatePollActivity, b());
      return paramForwardCreatePollActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ForwardCreatePollActivity paramForwardCreatePollActivity)
    {
      b(paramForwardCreatePollActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.aa.a.a
    {
      private com.viber.voip.contacts.ui.an b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.aa.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.an.class.getCanonicalName() + " must be set");
        return new b.bs.b(b.bs.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        this.b = ((com.viber.voip.contacts.ui.an)dagger.a.h.a(paraman));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.aa.a
    {
      private b(b.bs.a arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.contacts.ui.an b(com.viber.voip.contacts.ui.an paraman)
      {
        com.viber.voip.messages.ui.i.a(paraman, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paraman, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paraman, dagger.a.c.b(b.af(b.this)));
        bu.a(paraman, dagger.a.c.b(b.ac(b.this)));
        bu.b(paraman, dagger.a.c.b(b.A(b.this)));
        bu.c(paraman, dagger.a.c.b(b.ag(b.this)));
        bu.d(paraman, dagger.a.c.b(b.ah(b.this)));
        bu.e(paraman, dagger.a.c.b(b.ai(b.this)));
        bu.a(paraman, b.this.d());
        bu.a(paraman, b.aj(b.this));
        bu.a(paraman, b.ak(b.this));
        bu.f(paraman, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paraman, dagger.a.c.b(b.O(b.this)));
        bu.a(paraman, b());
        bu.h(paraman, dagger.a.c.b(b.al(b.this)));
        return paraman;
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        b(paraman);
      }
    }
  }

  private final class bt extends com.viber.voip.g.a.a.aj.a.a
  {
    private FullScreenVideoPlayerActivity b;

    private bt()
    {
    }

    public com.viber.voip.g.a.a.aj.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(FullScreenVideoPlayerActivity.class.getCanonicalName() + " must be set");
      return new b.bu(b.this, this, null);
    }

    public void a(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity)
    {
      this.b = ((FullScreenVideoPlayerActivity)dagger.a.h.a(paramFullScreenVideoPlayerActivity));
    }
  }

  private final class bu
    implements com.viber.voip.g.a.a.aj.a
  {
    private bu(b.bt arg2)
    {
    }

    private FullScreenVideoPlayerActivity b(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity)
    {
      com.viber.voip.messages.ui.media.player.e.a(paramFullScreenVideoPlayerActivity, dagger.a.c.b(b.ao(b.this)));
      com.viber.voip.messages.ui.media.player.e.b(paramFullScreenVideoPlayerActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.ui.media.player.e.a(paramFullScreenVideoPlayerActivity, gm.c());
      return paramFullScreenVideoPlayerActivity;
    }

    public void a(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity)
    {
      b(paramFullScreenVideoPlayerActivity);
    }
  }

  private final class bv extends com.viber.voip.g.a.a.ak.a.a
  {
    private GroupCallDetailsFragment b;

    private bv()
    {
    }

    public com.viber.voip.g.a.a.ak.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(GroupCallDetailsFragment.class.getCanonicalName() + " must be set");
      return new b.bw(b.this, this, null);
    }

    public void a(GroupCallDetailsFragment paramGroupCallDetailsFragment)
    {
      this.b = ((GroupCallDetailsFragment)dagger.a.h.a(paramGroupCallDetailsFragment));
    }
  }

  private final class bw
    implements com.viber.voip.g.a.a.ak.a
  {
    private bw(b.bv arg2)
    {
    }

    private GroupCallDetailsFragment b(GroupCallDetailsFragment paramGroupCallDetailsFragment)
    {
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.V(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.aB(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.L(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.bU(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, gn.c());
      com.viber.voip.calls.ui.c.b(paramGroupCallDetailsFragment, gk.c());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, com.viber.voip.g.a.s.c());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.an(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.bV(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, b.bW(b.this));
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, dx.c());
      com.viber.voip.calls.ui.c.a(paramGroupCallDetailsFragment, dagger.a.c.b(b.O(b.this)));
      com.viber.voip.calls.ui.c.b(paramGroupCallDetailsFragment, dagger.a.c.b(b.bX(b.this)));
      return paramGroupCallDetailsFragment;
    }

    public void a(GroupCallDetailsFragment paramGroupCallDetailsFragment)
    {
      b(paramGroupCallDetailsFragment);
    }
  }

  private final class bx extends com.viber.voip.g.a.a.al.a.a
  {
    private com.viber.voip.contacts.ui.list.l b;

    private bx()
    {
    }

    public com.viber.voip.g.a.a.al.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.contacts.ui.list.l.class.getCanonicalName() + " must be set");
      return new b.by(b.this, this, null);
    }

    public void a(com.viber.voip.contacts.ui.list.l paraml)
    {
      this.b = ((com.viber.voip.contacts.ui.list.l)dagger.a.h.a(paraml));
    }
  }

  private final class by
    implements com.viber.voip.g.a.a.al.a
  {
    private by(b.bx arg2)
    {
    }

    private com.viber.voip.contacts.ui.list.l b(com.viber.voip.contacts.ui.list.l paraml)
    {
      com.viber.voip.contacts.ui.list.m.a(paraml, gn.c());
      com.viber.voip.contacts.ui.list.m.b(paraml, gk.c());
      com.viber.voip.contacts.ui.list.m.a(paraml, b.V(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.U(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.W(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.aB(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.L(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, (com.viber.voip.util.e.e)b.Q(b.this).get());
      com.viber.voip.contacts.ui.list.m.a(paraml, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.contacts.ui.list.m.a(paraml, b.an(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.bV(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.bW(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, b.bL(b.this));
      com.viber.voip.contacts.ui.list.m.a(paraml, dx.c());
      com.viber.voip.contacts.ui.list.m.a(paraml, dagger.a.c.b(b.O(b.this)));
      com.viber.voip.contacts.ui.list.m.b(paraml, dagger.a.c.b(b.bX(b.this)));
      return paraml;
    }

    public void a(com.viber.voip.contacts.ui.list.l paraml)
    {
      b(paraml);
    }
  }

  private final class bz extends cq.a.a
  {
    private HomeActivity b;

    private bz()
    {
    }

    public cq.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(HomeActivity.class.getCanonicalName() + " must be set");
      return new b.ca(b.this, this, null);
    }

    public void a(HomeActivity paramHomeActivity)
    {
      this.b = ((HomeActivity)dagger.a.h.a(paramHomeActivity));
    }
  }

  private final class c extends com.viber.voip.g.a.a.b.a.a
  {
    private AddFriendPreviewActivity b;

    private c()
    {
    }

    public com.viber.voip.g.a.a.b.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(AddFriendPreviewActivity.class.getCanonicalName() + " must be set");
      return new b.d(b.this, this, null);
    }

    public void a(AddFriendPreviewActivity paramAddFriendPreviewActivity)
    {
      this.b = ((AddFriendPreviewActivity)dagger.a.h.a(paramAddFriendPreviewActivity));
    }
  }

  private final class ca
    implements cq.a
  {
    private Provider<com.viber.voip.g.a.a.a.ag.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ae.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.af.a.a> d;

    private ca(b.bz arg2)
    {
      b.bz localbz;
      a(localbz);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.ui.bn.class, this.b).a(MoreFragment.class, this.c).a(RecentCallsFragment.class, this.d).a();
    }

    private void a(b.bz parambz)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ag.a.a a()
        {
          return new b.ca.e(b.ca.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ae.a.a a()
        {
          return new b.ca.a(b.ca.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.af.a.a a()
        {
          return new b.ca.c(b.ca.this, null);
        }
      };
    }

    private HomeActivity b(HomeActivity paramHomeActivity)
    {
      com.viber.voip.v.a(paramHomeActivity, b.aY(b.this));
      com.viber.voip.v.a(paramHomeActivity, com.viber.voip.g.a.p.c());
      com.viber.voip.v.a(paramHomeActivity, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.v.a(paramHomeActivity, b());
      com.viber.voip.v.a(paramHomeActivity, (EventBus)b.M(b.this).get());
      com.viber.voip.v.a(paramHomeActivity, (com.viber.voip.bf)b.bk(b.this).get());
      com.viber.voip.v.a(paramHomeActivity, bl.b());
      com.viber.voip.v.a(paramHomeActivity, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.v.a(paramHomeActivity, b.bl(b.this));
      com.viber.voip.v.a(paramHomeActivity, ey.b());
      com.viber.voip.v.a(paramHomeActivity, dagger.a.c.b(b.bm(b.this)));
      com.viber.voip.v.b(paramHomeActivity, dagger.a.c.b(com.viber.voip.g.a.s.b()));
      com.viber.voip.v.c(paramHomeActivity, dagger.a.c.b(b.bn(b.this)));
      com.viber.voip.v.d(paramHomeActivity, dagger.a.c.b(b.bo(b.this)));
      com.viber.voip.v.e(paramHomeActivity, dagger.a.c.b(b.bp(b.this)));
      com.viber.voip.v.f(paramHomeActivity, dagger.a.c.b(b.bq(b.this)));
      com.viber.voip.v.g(paramHomeActivity, dagger.a.c.b(b.br(b.this)));
      com.viber.voip.v.h(paramHomeActivity, dagger.a.c.b(dx.b()));
      com.viber.voip.v.i(paramHomeActivity, dagger.a.c.b(fz.b()));
      com.viber.voip.v.j(paramHomeActivity, dagger.a.c.b(b.bs(b.this)));
      com.viber.voip.v.k(paramHomeActivity, dagger.a.c.b(b.bt(b.this)));
      com.viber.voip.v.l(paramHomeActivity, dagger.a.c.b(b.bu(b.this)));
      com.viber.voip.v.m(paramHomeActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.v.n(paramHomeActivity, dagger.a.c.b(b.be(b.this)));
      com.viber.voip.v.o(paramHomeActivity, dagger.a.c.b(b.am(b.this)));
      com.viber.voip.v.p(paramHomeActivity, dagger.a.c.b(b.O(b.this)));
      com.viber.voip.v.q(paramHomeActivity, dagger.a.c.b(b.aT(b.this)));
      com.viber.voip.v.r(paramHomeActivity, dagger.a.c.b(b.bv(b.this)));
      com.viber.voip.v.s(paramHomeActivity, dagger.a.c.b(b.aZ(b.this)));
      com.viber.voip.v.t(paramHomeActivity, dagger.a.c.b(b.bc(b.this)));
      com.viber.voip.v.a(paramHomeActivity, b.bw(b.this));
      return paramHomeActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(HomeActivity paramHomeActivity)
    {
      b(paramHomeActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ae.a.a
    {
      private MoreFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ae.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(MoreFragment.class.getCanonicalName() + " must be set");
        return new b.ca.b(b.ca.this, this, null);
      }

      public void a(MoreFragment paramMoreFragment)
      {
        this.b = ((MoreFragment)dagger.a.h.a(paramMoreFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ae.a
    {
      private b(b.ca.a arg2)
      {
      }

      private UserInfoRepository a()
      {
        return new UserInfoRepository(b.an(b.this), dagger.a.c.b(b.aU(b.this)));
      }

      private MoreFragment b(MoreFragment paramMoreFragment)
      {
        MoreFragment_MembersInjector.injectMDeviceConfiguration(paramMoreFragment, (com.viber.voip.app.b)b.I(b.this).get());
        MoreFragment_MembersInjector.injectMUserManager(paramMoreFragment, b.an(b.this));
        MoreFragment_MembersInjector.injectMProfileNotification(paramMoreFragment, b.aV(b.this));
        MoreFragment_MembersInjector.injectMRakutenController(paramMoreFragment, ey.b());
        MoreFragment_MembersInjector.injectMPublicAccountAccessibilityController(paramMoreFragment, ew.b());
        MoreFragment_MembersInjector.injectMCdrController(paramMoreFragment, b.this.d());
        MoreFragment_MembersInjector.injectMBadgesManager(paramMoreFragment, gs.c());
        MoreFragment_MembersInjector.injectMNotificationManagerWrapper(paramMoreFragment, dagger.a.c.b(b.aW(b.this)));
        MoreFragment_MembersInjector.injectMPermissionManager(paramMoreFragment, dagger.a.c.b(b.K(b.this)));
        MoreFragment_MembersInjector.injectMVlnReactContextManager(paramMoreFragment, dagger.a.c.b(b.aT(b.this)));
        MoreFragment_MembersInjector.injectMAnalyticsManager(paramMoreFragment, com.viber.voip.g.a.s.c());
        MoreFragment_MembersInjector.injectMOtherEventsTracker(paramMoreFragment, b.Y(b.this));
        MoreFragment_MembersInjector.injectMProfileTracker(paramMoreFragment, b.aX(b.this));
        MoreFragment_MembersInjector.injectMUserInfoRepository(paramMoreFragment, a());
        MoreFragment_MembersInjector.injectMImageFetcher(paramMoreFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        MoreFragment_MembersInjector.injectMStickerController(paramMoreFragment, fz.c());
        MoreFragment_MembersInjector.injectMBadgesUpdater(paramMoreFragment, b.aY(b.this));
        MoreFragment_MembersInjector.injectMViberNewsManager(paramMoreFragment, dagger.a.c.b(b.aZ(b.this)));
        return paramMoreFragment;
      }

      public void a(MoreFragment paramMoreFragment)
      {
        b(paramMoreFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.af.a.a
    {
      private RecentCallsFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.af.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(RecentCallsFragment.class.getCanonicalName() + " must be set");
        return new b.ca.d(b.ca.this, this, null);
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        this.b = ((RecentCallsFragment)dagger.a.h.a(paramRecentCallsFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.af.a
    {
      private d(b.ca.c arg2)
      {
      }

      private RecentCallsFragment b(RecentCallsFragment paramRecentCallsFragment)
      {
        com.viber.voip.calls.ui.s.a(paramRecentCallsFragment, dagger.a.c.b(b.be(b.this)));
        com.viber.voip.calls.ui.s.b(paramRecentCallsFragment, dagger.a.c.b(b.O(b.this)));
        return paramRecentCallsFragment;
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        b(paramRecentCallsFragment);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ag.a.a
    {
      private com.viber.voip.messages.ui.bn b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ag.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.ui.bn.class.getCanonicalName() + " must be set");
        return new b.ca.f(b.ca.this, this, null);
      }

      public void a(com.viber.voip.messages.ui.bn parambn)
      {
        this.b = ((com.viber.voip.messages.ui.bn)dagger.a.h.a(parambn));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ag.a
    {
      private com.viber.voip.messages.conversation.a.e b;
      private com.viber.voip.messages.conversation.a.g c;
      private com.viber.voip.g.a.a.b.q d;

      private f(b.ca.e arg2)
      {
        b.ca.e locale;
        a(locale);
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private void a(b.ca.e parame)
      {
        this.b = com.viber.voip.messages.conversation.a.e.a(b.ab(b.this), gn.b(), b.I(b.this), b.ac(b.this), b.ad(b.this));
        this.c = com.viber.voip.messages.conversation.a.g.a(b.A(b.this));
        this.d = com.viber.voip.g.a.a.b.q.a(com.viber.voip.messages.conversation.a.n.b(), this.b, this.c, com.viber.voip.messages.conversation.a.l.b());
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private com.viber.voip.messages.ui.bn b(com.viber.voip.messages.ui.bn parambn)
      {
        com.viber.voip.messages.ui.i.a(parambn, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parambn, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parambn, dagger.a.c.b(b.af(b.this)));
        bu.a(parambn, dagger.a.c.b(b.ac(b.this)));
        bu.b(parambn, dagger.a.c.b(b.A(b.this)));
        bu.c(parambn, dagger.a.c.b(b.ag(b.this)));
        bu.d(parambn, dagger.a.c.b(b.ah(b.this)));
        bu.e(parambn, dagger.a.c.b(b.ai(b.this)));
        bu.a(parambn, b.this.d());
        bu.a(parambn, b.aj(b.this));
        bu.a(parambn, b.ak(b.this));
        bu.f(parambn, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(parambn, dagger.a.c.b(b.O(b.this)));
        bu.a(parambn, b());
        bu.h(parambn, dagger.a.c.b(b.al(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, dagger.a.c.b(b.bx(b.this)));
        com.viber.voip.messages.ui.bt.b(parambn, dagger.a.c.b(b.by(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, c());
        com.viber.voip.messages.ui.bt.c(parambn, dagger.a.c.b(this.d));
        com.viber.voip.messages.ui.bt.d(parambn, dagger.a.c.b(b.D(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, (ConversationsScreenScrollCdrController)b.bz(b.this).get());
        com.viber.voip.messages.ui.bt.a(parambn, (com.viber.voip.ads.b.c.b.f)b.bA(b.this).get());
        com.viber.voip.messages.ui.bt.a(parambn, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        return parambn;
      }

      private com.viber.voip.vln.d c()
      {
        return com.viber.voip.g.a.a.b.r.a(b.Z(b.this));
      }

      public void a(com.viber.voip.messages.ui.bn parambn)
      {
        b(parambn);
      }
    }
  }

  private final class cb extends ej.a.a
  {
    private HomeTabNewsBrowserFragment b;

    private cb()
    {
    }

    public ej.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(HomeTabNewsBrowserFragment.class.getCanonicalName() + " must be set");
      return new b.cc(b.this, this, null);
    }

    public void a(HomeTabNewsBrowserFragment paramHomeTabNewsBrowserFragment)
    {
      this.b = ((HomeTabNewsBrowserFragment)dagger.a.h.a(paramHomeTabNewsBrowserFragment));
    }
  }

  private final class cc
    implements ej.a
  {
    private cc(b.cb arg2)
    {
    }

    private HomeTabNewsBrowserFragment b(HomeTabNewsBrowserFragment paramHomeTabNewsBrowserFragment)
    {
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, (com.viber.voip.news.q)b.aZ(b.this).get());
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, gs.c());
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, b.aB(b.this));
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, (com.viber.voip.util.i.a)b.bh(b.this).get());
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, dagger.a.c.b(b.bc(b.this)));
      com.viber.voip.news.j.b(paramHomeTabNewsBrowserFragment, dagger.a.c.b(b.am(b.this)));
      com.viber.voip.news.j.a(paramHomeTabNewsBrowserFragment, gn.c());
      return paramHomeTabNewsBrowserFragment;
    }

    public void a(HomeTabNewsBrowserFragment paramHomeTabNewsBrowserFragment)
    {
      b(paramHomeTabNewsBrowserFragment);
    }
  }

  private final class cd extends com.viber.voip.g.a.a.am.a.a
  {
    private InCallFragment b;

    private cd()
    {
    }

    public com.viber.voip.g.a.a.am.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(InCallFragment.class.getCanonicalName() + " must be set");
      return new b.ce(b.this, this, null);
    }

    public void a(InCallFragment paramInCallFragment)
    {
      this.b = ((InCallFragment)dagger.a.h.a(paramInCallFragment));
    }
  }

  private final class ce
    implements com.viber.voip.g.a.a.am.a
  {
    private Provider<InCallFragment> b;
    private UserInfoRepository_Factory c;
    private ConferenceSpeakerStateResolver_Factory d;
    private ConferenceMicStateResolver_Factory e;
    private ConferenceHoldStateResolver_Factory f;
    private ConferenceGroupCreationHelper_Factory g;
    private ConferenceInCallPresenter_Factory h;
    private ConferenceInCallMvpView_Factory i;
    private GenericInCallPresenter_Factory j;
    private GenericInCallMvpViewImpl_Factory k;

    private ce(b.cd arg2)
    {
      b.cd localcd;
      a(localcd);
    }

    private void a(b.cd paramcd)
    {
      this.b = dagger.a.e.a(b.cd.a(paramcd));
      this.c = UserInfoRepository_Factory.create(b.bD(b.this), b.aU(b.this));
      this.d = ConferenceSpeakerStateResolver_Factory.create(b.ac(b.this), b.bE(b.this), b.aG(b.this));
      this.e = ConferenceMicStateResolver_Factory.create(b.ac(b.this), b.aR(b.this), b.ad(b.this), b.bF(b.this), gn.b());
      this.f = ConferenceHoldStateResolver_Factory.create(b.ac(b.this), b.aR(b.this), b.ad(b.this), b.bF(b.this), gn.b());
      this.g = ConferenceGroupCreationHelper_Factory.create(b.bG(b.this), b.S(b.this), b.aF(b.this), dt.b());
      this.h = ConferenceInCallPresenter_Factory.create(this.c, b.aH(b.this), b.ac(b.this), this.d, this.e, this.f, b.bH(b.this), b.A(b.this), b.bG(b.this), b.bI(b.this), this.g, b.bJ(b.this), b.ag(b.this), b.be(b.this), b.ah(b.this), gn.b(), gh.b(), gk.b(), b.bK(b.this), b.bh(b.this));
      this.i = ConferenceInCallMvpView_Factory.create(this.b, b.Q(b.this), this.h, b.be(b.this));
      this.j = GenericInCallPresenter_Factory.create(gk.b(), b.bJ(b.this), b.bD(b.this), b.ac(b.this), b.ag(b.this), b.ah(b.this), b.bG(b.this), dx.b(), b.bI(b.this), b.O(b.this));
      this.k = GenericInCallMvpViewImpl_Factory.create(this.b, b.Q(b.this), b.K(b.this), b.I(b.this), this.j);
    }

    private InCallFragment b(InCallFragment paramInCallFragment)
    {
      InCallFragment_MembersInjector.injectMConferenceInCallView(paramInCallFragment, dagger.a.c.b(this.i));
      InCallFragment_MembersInjector.injectMGenericInCallMvpView(paramInCallFragment, dagger.a.c.b(this.k));
      InCallFragment_MembersInjector.injectMCallsTracker(paramInCallFragment, dagger.a.c.b(b.be(b.this)));
      return paramInCallFragment;
    }

    public void a(InCallFragment paramInCallFragment)
    {
      b(paramInCallFragment);
    }
  }

  private final class cf extends com.viber.voip.g.a.a.an.a.a
  {
    private IncomingCallFragment b;

    private cf()
    {
    }

    public com.viber.voip.g.a.a.an.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(IncomingCallFragment.class.getCanonicalName() + " must be set");
      return new b.cg(b.this, this, null);
    }

    public void a(IncomingCallFragment paramIncomingCallFragment)
    {
      this.b = ((IncomingCallFragment)dagger.a.h.a(paramIncomingCallFragment));
    }
  }

  private final class cg
    implements com.viber.voip.g.a.a.an.a
  {
    private com.viber.voip.analytics.story.b.a.b b;

    private cg(b.cf arg2)
    {
      b.cf localcf;
      a(localcf);
    }

    private void a(b.cf paramcf)
    {
      this.b = com.viber.voip.analytics.story.b.a.b.a(b.be(b.this), b.aF(b.this), b.aH(b.this));
    }

    private IncomingCallFragment b(IncomingCallFragment paramIncomingCallFragment)
    {
      IncomingCallFragment_MembersInjector.injectMCallsTracker(paramIncomingCallFragment, dagger.a.c.b(b.be(b.this)));
      IncomingCallFragment_MembersInjector.injectMActOnIncomingCallEventCollector(paramIncomingCallFragment, dagger.a.c.b(this.b));
      IncomingCallFragment_MembersInjector.injectMPermissionManager(paramIncomingCallFragment, (com.viber.common.permission.c)b.K(b.this).get());
      return paramIncomingCallFragment;
    }

    public void a(IncomingCallFragment paramIncomingCallFragment)
    {
      b(paramIncomingCallFragment);
    }
  }

  private final class ch extends ch.a.a
  {
    private com.viber.voip.contacts.ui.ap b;

    private ch()
    {
    }

    public ch.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.contacts.ui.ap.class.getCanonicalName() + " must be set");
      return new b.ci(b.this, this, null);
    }

    public void a(com.viber.voip.contacts.ui.ap paramap)
    {
      this.b = ((com.viber.voip.contacts.ui.ap)dagger.a.h.a(paramap));
    }
  }

  private final class ci
    implements ch.a
  {
    private ci(b.ch arg2)
    {
    }

    private com.viber.voip.contacts.ui.ap b(com.viber.voip.contacts.ui.ap paramap)
    {
      com.viber.voip.contacts.ui.ai.a(paramap, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
      com.viber.voip.contacts.ui.ai.a(paramap, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
      return paramap;
    }

    public void a(com.viber.voip.contacts.ui.ap paramap)
    {
      b(paramap);
    }
  }

  private final class cj extends com.viber.voip.g.a.a.ao.a.a
  {
    private LocationMessageActivityV2 b;

    private cj()
    {
    }

    public com.viber.voip.g.a.a.ao.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(LocationMessageActivityV2.class.getCanonicalName() + " must be set");
      return new b.ck(b.this, this, null);
    }

    public void a(LocationMessageActivityV2 paramLocationMessageActivityV2)
    {
      this.b = ((LocationMessageActivityV2)dagger.a.h.a(paramLocationMessageActivityV2));
    }
  }

  private final class ck
    implements com.viber.voip.g.a.a.ao.a
  {
    private ck(b.cj arg2)
    {
    }

    private LocationMessageActivityV2 b(LocationMessageActivityV2 paramLocationMessageActivityV2)
    {
      com.viber.voip.messages.ui.media.c.a(paramLocationMessageActivityV2, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      return paramLocationMessageActivityV2;
    }

    public void a(LocationMessageActivityV2 paramLocationMessageActivityV2)
    {
      b(paramLocationMessageActivityV2);
    }
  }

  private final class cl extends com.viber.voip.g.a.a.ap.a.a
  {
    private com.viber.voip.gdpr.ui.iabconsent.g b;

    private cl()
    {
    }

    public com.viber.voip.g.a.a.ap.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.gdpr.ui.iabconsent.g.class.getCanonicalName() + " must be set");
      return new b.cm(b.this, this, null);
    }

    public void a(com.viber.voip.gdpr.ui.iabconsent.g paramg)
    {
      this.b = ((com.viber.voip.gdpr.ui.iabconsent.g)dagger.a.h.a(paramg));
    }
  }

  private final class cm
    implements com.viber.voip.g.a.a.ap.a
  {
    private cm(b.cl arg2)
    {
    }

    private com.viber.voip.gdpr.ui.iabconsent.g b(com.viber.voip.gdpr.ui.iabconsent.g paramg)
    {
      com.viber.voip.gdpr.ui.iabconsent.h.a(paramg, (com.viber.voip.gdpr.a.a)b.bY(b.this).get());
      return paramg;
    }

    public void a(com.viber.voip.gdpr.ui.iabconsent.g paramg)
    {
      b(paramg);
    }
  }

  private final class cn extends com.viber.voip.g.a.a.aq.a.a
  {
    private ManageConversationStorageActivity b;

    private cn()
    {
    }

    public com.viber.voip.g.a.a.aq.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ManageConversationStorageActivity.class.getCanonicalName() + " must be set");
      return new b.co(b.this, this, null);
    }

    public void a(ManageConversationStorageActivity paramManageConversationStorageActivity)
    {
      this.b = ((ManageConversationStorageActivity)dagger.a.h.a(paramManageConversationStorageActivity));
    }
  }

  private final class co
    implements com.viber.voip.g.a.a.aq.a
  {
    private co(b.cn arg2)
    {
    }

    private ManageConversationStorageActivity b(ManageConversationStorageActivity paramManageConversationStorageActivity)
    {
      com.viber.voip.settings.ui.t.a(paramManageConversationStorageActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramManageConversationStorageActivity;
    }

    public void a(ManageConversationStorageActivity paramManageConversationStorageActivity)
    {
      b(paramManageConversationStorageActivity);
    }
  }

  private final class cp extends com.viber.voip.g.a.a.ar.a.a
  {
    private com.viber.voip.storage.conversation.a b;

    private cp()
    {
    }

    public com.viber.voip.g.a.a.ar.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.storage.conversation.a.class.getCanonicalName() + " must be set");
      return new b.cq(b.this, this, null);
    }

    public void a(com.viber.voip.storage.conversation.a parama)
    {
      this.b = ((com.viber.voip.storage.conversation.a)dagger.a.h.a(parama));
    }
  }

  private final class cq
    implements com.viber.voip.g.a.a.ar.a
  {
    private Provider<com.viber.voip.storage.repository.r> b;

    private cq(b.cp arg2)
    {
      b.cp localcp;
      a(localcp);
    }

    private void a(b.cp paramcp)
    {
      this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.o.a(b.cb(b.this), b.ab(b.this)));
    }

    private com.viber.voip.storage.conversation.a b(com.viber.voip.storage.conversation.a parama)
    {
      com.viber.voip.storage.conversation.b.a(parama, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.storage.conversation.b.a(parama, (com.google.d.f)b.cd(b.this).get());
      com.viber.voip.storage.conversation.b.a(parama, (com.viber.voip.storage.repository.r)this.b.get());
      com.viber.voip.storage.conversation.b.a(parama, b.ce(b.this));
      com.viber.voip.storage.conversation.b.a(parama, gn.c());
      com.viber.voip.storage.conversation.b.b(parama, gg.c());
      com.viber.voip.storage.conversation.b.a(parama, (com.viber.voip.util.e.e)b.Q(b.this).get());
      com.viber.voip.storage.conversation.b.a(parama, (com.viber.voip.storage.a.i)b.cf(b.this).get());
      return parama;
    }

    public void a(com.viber.voip.storage.conversation.a parama)
    {
      b(parama);
    }
  }

  private final class cr extends as.a.a
  {
    private com.viber.voip.storage.overall.a b;

    private cr()
    {
    }

    public as.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.storage.overall.a.class.getCanonicalName() + " must be set");
      return new b.cs(b.this, this, null);
    }

    public void a(com.viber.voip.storage.overall.a parama)
    {
      this.b = ((com.viber.voip.storage.overall.a)dagger.a.h.a(parama));
    }
  }

  private final class cs
    implements as.a
  {
    private Provider<com.viber.voip.storage.repository.r> b;

    private cs(b.cr arg2)
    {
      b.cr localcr;
      a(localcr);
    }

    private void a(b.cr paramcr)
    {
      this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.o.a(b.cb(b.this), b.ab(b.this)));
    }

    private com.viber.voip.storage.overall.a b(com.viber.voip.storage.overall.a parama)
    {
      com.viber.voip.storage.overall.b.a(parama, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.storage.overall.b.a(parama, (com.google.d.f)b.cd(b.this).get());
      com.viber.voip.storage.overall.b.a(parama, (com.viber.voip.storage.repository.r)this.b.get());
      com.viber.voip.storage.overall.b.a(parama, b.ce(b.this));
      com.viber.voip.storage.overall.b.a(parama, gn.c());
      com.viber.voip.storage.overall.b.b(parama, gg.c());
      com.viber.voip.storage.overall.b.a(parama, (com.viber.voip.storage.a.i)b.cf(b.this).get());
      com.viber.voip.storage.overall.b.a(parama, b.Y(b.this));
      return parama;
    }

    public void a(com.viber.voip.storage.overall.a parama)
    {
      b(parama);
    }
  }

  private final class ct extends at.a.a
  {
    private ManageStorageActivity b;

    private ct()
    {
    }

    public at.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ManageStorageActivity.class.getCanonicalName() + " must be set");
      return new b.cu(b.this, this, null);
    }

    public void a(ManageStorageActivity paramManageStorageActivity)
    {
      this.b = ((ManageStorageActivity)dagger.a.h.a(paramManageStorageActivity));
    }
  }

  private final class cu
    implements at.a
  {
    private cu(b.ct arg2)
    {
    }

    private ManageStorageActivity b(ManageStorageActivity paramManageStorageActivity)
    {
      com.viber.voip.settings.ui.t.a(paramManageStorageActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramManageStorageActivity;
    }

    public void a(ManageStorageActivity paramManageStorageActivity)
    {
      b(paramManageStorageActivity);
    }
  }

  private final class cv extends com.viber.voip.g.a.a.au.a.a
  {
    private com.viber.voip.storage.manage.d b;

    private cv()
    {
    }

    public com.viber.voip.g.a.a.au.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.storage.manage.d.class.getCanonicalName() + " must be set");
      return new b.cw(b.this, this, null);
    }

    public void a(com.viber.voip.storage.manage.d paramd)
    {
      this.b = ((com.viber.voip.storage.manage.d)dagger.a.h.a(paramd));
    }
  }

  private final class cw
    implements com.viber.voip.g.a.a.au.a
  {
    private Provider<com.viber.voip.storage.repository.r> b;

    private cw(b.cv arg2)
    {
      b.cv localcv;
      a(localcv);
    }

    private void a(b.cv paramcv)
    {
      this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.o.a(b.cb(b.this), b.ab(b.this)));
    }

    private com.viber.voip.storage.manage.d b(com.viber.voip.storage.manage.d paramd)
    {
      com.viber.voip.storage.manage.e.a(paramd, b.cc(b.this));
      com.viber.voip.storage.manage.e.a(paramd, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.storage.manage.e.a(paramd, (com.google.d.f)b.cd(b.this).get());
      com.viber.voip.storage.manage.e.a(paramd, (com.viber.voip.storage.repository.r)this.b.get());
      com.viber.voip.storage.manage.e.a(paramd, b.ce(b.this));
      com.viber.voip.storage.manage.e.a(paramd, gn.c());
      com.viber.voip.storage.manage.e.b(paramd, gg.c());
      return paramd;
    }

    public void a(com.viber.voip.storage.manage.d paramd)
    {
      b(paramd);
    }
  }

  private final class cx extends com.viber.voip.g.a.a.av.a.a
  {
    private bk b;

    private cx()
    {
    }

    public com.viber.voip.g.a.a.av.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(bk.class.getCanonicalName() + " must be set");
      return new b.cy(b.this, this, null);
    }

    public void a(bk parambk)
    {
      this.b = ((bk)dagger.a.h.a(parambk));
    }
  }

  private final class cy
    implements com.viber.voip.g.a.a.av.a
  {
    private cy(b.cx arg2)
    {
    }

    private com.viber.voip.messages.j a()
    {
      return new com.viber.voip.messages.j(b.Z(b.this));
    }

    private com.viber.voip.messages.adapters.a.e b()
    {
      return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
    }

    private bk b(bk parambk)
    {
      com.viber.voip.messages.ui.i.a(parambk, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.messages.ui.i.b(parambk, dagger.a.c.b(b.ae(b.this)));
      com.viber.voip.messages.ui.i.c(parambk, dagger.a.c.b(b.af(b.this)));
      bu.a(parambk, dagger.a.c.b(b.ac(b.this)));
      bu.b(parambk, dagger.a.c.b(b.A(b.this)));
      bu.c(parambk, dagger.a.c.b(b.ag(b.this)));
      bu.d(parambk, dagger.a.c.b(b.ah(b.this)));
      bu.e(parambk, dagger.a.c.b(b.ai(b.this)));
      bu.a(parambk, b.this.d());
      bu.a(parambk, b.aj(b.this));
      bu.a(parambk, b.ak(b.this));
      bu.f(parambk, dagger.a.c.b(com.viber.voip.g.a.s.b()));
      bu.g(parambk, dagger.a.c.b(b.O(b.this)));
      bu.a(parambk, b());
      bu.h(parambk, dagger.a.c.b(b.al(b.this)));
      return parambk;
    }

    public void a(bk parambk)
    {
      b(parambk);
    }
  }

  private final class cz extends com.viber.voip.g.a.a.aw.a.a
  {
    private MoreActivity b;

    private cz()
    {
    }

    public com.viber.voip.g.a.a.aw.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(MoreActivity.class.getCanonicalName() + " must be set");
      return new b.da(b.this, this, null);
    }

    public void a(MoreActivity paramMoreActivity)
    {
      this.b = ((MoreActivity)dagger.a.h.a(paramMoreActivity));
    }
  }

  private final class d
    implements com.viber.voip.g.a.a.b.a
  {
    private d(b.c arg2)
    {
    }

    private AddFriendPreviewActivity b(AddFriendPreviewActivity paramAddFriendPreviewActivity)
    {
      com.viber.voip.k.a(paramAddFriendPreviewActivity, com.viber.voip.g.a.s.c());
      com.viber.voip.k.a(paramAddFriendPreviewActivity, b.X(b.this));
      return paramAddFriendPreviewActivity;
    }

    public void a(AddFriendPreviewActivity paramAddFriendPreviewActivity)
    {
      b(paramAddFriendPreviewActivity);
    }
  }

  private final class da
    implements com.viber.voip.g.a.a.aw.a
  {
    private Provider<com.viber.voip.g.a.a.a.ah.a.a> b;

    private da(b.cz arg2)
    {
      b.cz localcz;
      a(localcz);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(MoreFragment.class, this.b).a();
    }

    private void a(b.cz paramcz)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ah.a.a a()
        {
          return new b.da.a(b.da.this, null);
        }
      };
    }

    private MoreActivity b(MoreActivity paramMoreActivity)
    {
      MoreActivity_MembersInjector.injectMVlnReactContextManager(paramMoreActivity, dagger.a.c.b(b.aT(b.this)));
      MoreActivity_MembersInjector.injectMFragmentInjector(paramMoreActivity, b());
      return paramMoreActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(MoreActivity paramMoreActivity)
    {
      b(paramMoreActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ah.a.a
    {
      private MoreFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ah.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(MoreFragment.class.getCanonicalName() + " must be set");
        return new b.da.b(b.da.this, this, null);
      }

      public void a(MoreFragment paramMoreFragment)
      {
        this.b = ((MoreFragment)dagger.a.h.a(paramMoreFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ah.a
    {
      private b(b.da.a arg2)
      {
      }

      private UserInfoRepository a()
      {
        return new UserInfoRepository(b.an(b.this), dagger.a.c.b(b.aU(b.this)));
      }

      private MoreFragment b(MoreFragment paramMoreFragment)
      {
        MoreFragment_MembersInjector.injectMDeviceConfiguration(paramMoreFragment, (com.viber.voip.app.b)b.I(b.this).get());
        MoreFragment_MembersInjector.injectMUserManager(paramMoreFragment, b.an(b.this));
        MoreFragment_MembersInjector.injectMProfileNotification(paramMoreFragment, b.aV(b.this));
        MoreFragment_MembersInjector.injectMRakutenController(paramMoreFragment, ey.b());
        MoreFragment_MembersInjector.injectMPublicAccountAccessibilityController(paramMoreFragment, ew.b());
        MoreFragment_MembersInjector.injectMCdrController(paramMoreFragment, b.this.d());
        MoreFragment_MembersInjector.injectMBadgesManager(paramMoreFragment, gs.c());
        MoreFragment_MembersInjector.injectMNotificationManagerWrapper(paramMoreFragment, dagger.a.c.b(b.aW(b.this)));
        MoreFragment_MembersInjector.injectMPermissionManager(paramMoreFragment, dagger.a.c.b(b.K(b.this)));
        MoreFragment_MembersInjector.injectMVlnReactContextManager(paramMoreFragment, dagger.a.c.b(b.aT(b.this)));
        MoreFragment_MembersInjector.injectMAnalyticsManager(paramMoreFragment, com.viber.voip.g.a.s.c());
        MoreFragment_MembersInjector.injectMOtherEventsTracker(paramMoreFragment, b.Y(b.this));
        MoreFragment_MembersInjector.injectMProfileTracker(paramMoreFragment, b.aX(b.this));
        MoreFragment_MembersInjector.injectMUserInfoRepository(paramMoreFragment, a());
        MoreFragment_MembersInjector.injectMImageFetcher(paramMoreFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        MoreFragment_MembersInjector.injectMStickerController(paramMoreFragment, fz.c());
        MoreFragment_MembersInjector.injectMBadgesUpdater(paramMoreFragment, b.aY(b.this));
        MoreFragment_MembersInjector.injectMViberNewsManager(paramMoreFragment, dagger.a.c.b(b.aZ(b.this)));
        return paramMoreFragment;
      }

      public void a(MoreFragment paramMoreFragment)
      {
        b(paramMoreFragment);
      }
    }
  }

  private final class db extends com.viber.voip.g.a.a.ax.a.a
  {
    private MoreDialogActivity b;

    private db()
    {
    }

    public com.viber.voip.g.a.a.ax.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(MoreDialogActivity.class.getCanonicalName() + " must be set");
      return new b.dc(b.this, this, null);
    }

    public void a(MoreDialogActivity paramMoreDialogActivity)
    {
      this.b = ((MoreDialogActivity)dagger.a.h.a(paramMoreDialogActivity));
    }
  }

  private final class dc
    implements com.viber.voip.g.a.a.ax.a
  {
    private Provider<com.viber.voip.g.a.a.a.ah.a.a> b;

    private dc(b.db arg2)
    {
      b.db localdb;
      a(localdb);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(MoreFragment.class, this.b).a();
    }

    private void a(b.db paramdb)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ah.a.a a()
        {
          return new b.dc.a(b.dc.this, null);
        }
      };
    }

    private MoreDialogActivity b(MoreDialogActivity paramMoreDialogActivity)
    {
      MoreActivity_MembersInjector.injectMVlnReactContextManager(paramMoreDialogActivity, dagger.a.c.b(b.aT(b.this)));
      MoreActivity_MembersInjector.injectMFragmentInjector(paramMoreDialogActivity, b());
      return paramMoreDialogActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(MoreDialogActivity paramMoreDialogActivity)
    {
      b(paramMoreDialogActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ah.a.a
    {
      private MoreFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ah.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(MoreFragment.class.getCanonicalName() + " must be set");
        return new b.dc.b(b.dc.this, this, null);
      }

      public void a(MoreFragment paramMoreFragment)
      {
        this.b = ((MoreFragment)dagger.a.h.a(paramMoreFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ah.a
    {
      private b(b.dc.a arg2)
      {
      }

      private UserInfoRepository a()
      {
        return new UserInfoRepository(b.an(b.this), dagger.a.c.b(b.aU(b.this)));
      }

      private MoreFragment b(MoreFragment paramMoreFragment)
      {
        MoreFragment_MembersInjector.injectMDeviceConfiguration(paramMoreFragment, (com.viber.voip.app.b)b.I(b.this).get());
        MoreFragment_MembersInjector.injectMUserManager(paramMoreFragment, b.an(b.this));
        MoreFragment_MembersInjector.injectMProfileNotification(paramMoreFragment, b.aV(b.this));
        MoreFragment_MembersInjector.injectMRakutenController(paramMoreFragment, ey.b());
        MoreFragment_MembersInjector.injectMPublicAccountAccessibilityController(paramMoreFragment, ew.b());
        MoreFragment_MembersInjector.injectMCdrController(paramMoreFragment, b.this.d());
        MoreFragment_MembersInjector.injectMBadgesManager(paramMoreFragment, gs.c());
        MoreFragment_MembersInjector.injectMNotificationManagerWrapper(paramMoreFragment, dagger.a.c.b(b.aW(b.this)));
        MoreFragment_MembersInjector.injectMPermissionManager(paramMoreFragment, dagger.a.c.b(b.K(b.this)));
        MoreFragment_MembersInjector.injectMVlnReactContextManager(paramMoreFragment, dagger.a.c.b(b.aT(b.this)));
        MoreFragment_MembersInjector.injectMAnalyticsManager(paramMoreFragment, com.viber.voip.g.a.s.c());
        MoreFragment_MembersInjector.injectMOtherEventsTracker(paramMoreFragment, b.Y(b.this));
        MoreFragment_MembersInjector.injectMProfileTracker(paramMoreFragment, b.aX(b.this));
        MoreFragment_MembersInjector.injectMUserInfoRepository(paramMoreFragment, a());
        MoreFragment_MembersInjector.injectMImageFetcher(paramMoreFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        MoreFragment_MembersInjector.injectMStickerController(paramMoreFragment, fz.c());
        MoreFragment_MembersInjector.injectMBadgesUpdater(paramMoreFragment, b.aY(b.this));
        MoreFragment_MembersInjector.injectMViberNewsManager(paramMoreFragment, dagger.a.c.b(b.aZ(b.this)));
        return paramMoreFragment;
      }

      public void a(MoreFragment paramMoreFragment)
      {
        b(paramMoreFragment);
      }
    }
  }

  private final class dd extends ek.a.a
  {
    private com.viber.voip.news.e b;

    private dd()
    {
    }

    public ek.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.news.e.class.getCanonicalName() + " must be set");
      return new b.de(b.this, this, null);
    }

    public void a(com.viber.voip.news.e parame)
    {
      this.b = ((com.viber.voip.news.e)dagger.a.h.a(parame));
    }
  }

  private final class de
    implements ek.a
  {
    private de(b.dd arg2)
    {
    }

    private com.viber.voip.news.e b(com.viber.voip.news.e parame)
    {
      com.viber.voip.news.j.a(parame, (com.viber.voip.news.q)b.aZ(b.this).get());
      com.viber.voip.news.j.a(parame, gs.c());
      com.viber.voip.news.j.a(parame, b.aB(b.this));
      com.viber.voip.news.j.a(parame, (com.viber.voip.util.i.a)b.bh(b.this).get());
      com.viber.voip.news.j.a(parame, dagger.a.c.b(b.bc(b.this)));
      com.viber.voip.news.j.b(parame, dagger.a.c.b(b.am(b.this)));
      com.viber.voip.news.j.a(parame, gn.c());
      return parame;
    }

    public void a(com.viber.voip.news.e parame)
    {
      b(parame);
    }
  }

  private final class df extends com.viber.voip.g.a.a.ay.a.a
  {
    private ParticipantsListActivity b;

    private df()
    {
    }

    public com.viber.voip.g.a.a.ay.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ParticipantsListActivity.class.getCanonicalName() + " must be set");
      return new b.dg(b.this, this, null);
    }

    public void a(ParticipantsListActivity paramParticipantsListActivity)
    {
      this.b = ((ParticipantsListActivity)dagger.a.h.a(paramParticipantsListActivity));
    }
  }

  private final class dg
    implements com.viber.voip.g.a.a.ay.a
  {
    private Provider<com.viber.voip.g.a.a.a.ao.a.a> b;

    private dg(b.df arg2)
    {
      b.df localdf;
      a(localdf);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.list.ae.class, this.b).a();
    }

    private void a(b.df paramdf)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ao.a.a a()
        {
          return new b.dg.a(b.dg.this, null);
        }
      };
    }

    private ParticipantsListActivity b(ParticipantsListActivity paramParticipantsListActivity)
    {
      com.viber.voip.contacts.ui.list.aa.a(paramParticipantsListActivity, b());
      return paramParticipantsListActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ParticipantsListActivity paramParticipantsListActivity)
    {
      b(paramParticipantsListActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ao.a.a
    {
      private com.viber.voip.contacts.ui.list.ae b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ao.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.list.ae.class.getCanonicalName() + " must be set");
        return new b.dg.b(b.dg.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.list.ae paramae)
      {
        this.b = ((com.viber.voip.contacts.ui.list.ae)dagger.a.h.a(paramae));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ao.a
    {
      private b(b.dg.a arg2)
      {
      }

      private com.viber.voip.contacts.ui.list.ae b(com.viber.voip.contacts.ui.list.ae paramae)
      {
        com.viber.voip.contacts.ui.list.af.a(paramae, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.contacts.ui.list.af.a(paramae, b.P(b.this));
        com.viber.voip.contacts.ui.list.af.a(paramae, b.ar(b.this));
        com.viber.voip.contacts.ui.list.af.a(paramae, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.contacts.ui.list.af.b(paramae, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.contacts.ui.list.af.c(paramae, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.contacts.ui.list.af.a(paramae, b.U(b.this));
        com.viber.voip.contacts.ui.list.af.a(paramae, b.bf(b.this));
        com.viber.voip.contacts.ui.list.af.d(paramae, dagger.a.c.b(dt.b()));
        com.viber.voip.contacts.ui.list.af.a(paramae, b.N(b.this));
        com.viber.voip.contacts.ui.list.af.e(paramae, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.contacts.ui.list.af.a(paramae, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.contacts.ui.list.af.a(paramae, b.bg(b.this));
        return paramae;
      }

      public void a(com.viber.voip.contacts.ui.list.ae paramae)
      {
        b(paramae);
      }
    }
  }

  private final class dh extends com.viber.voip.g.a.a.az.a.a
  {
    private PhoneFragmentActivity b;

    private dh()
    {
    }

    public com.viber.voip.g.a.a.az.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PhoneFragmentActivity.class.getCanonicalName() + " must be set");
      return new b.di(b.this, this, null);
    }

    public void a(PhoneFragmentActivity paramPhoneFragmentActivity)
    {
      this.b = ((PhoneFragmentActivity)dagger.a.h.a(paramPhoneFragmentActivity));
    }
  }

  private final class di
    implements com.viber.voip.g.a.a.az.a
  {
    private di(b.dh arg2)
    {
    }

    private PhoneFragmentActivity b(PhoneFragmentActivity paramPhoneFragmentActivity)
    {
      PhoneFragmentActivity_MembersInjector.injectMPermissionManager(paramPhoneFragmentActivity, (com.viber.common.permission.c)b.K(b.this).get());
      PhoneFragmentActivity_MembersInjector.injectMUserStartsCallEventCollector(paramPhoneFragmentActivity, dagger.a.c.b(b.O(b.this)));
      PhoneFragmentActivity_MembersInjector.injectMCallHandler(paramPhoneFragmentActivity, dagger.a.c.b(b.ac(b.this)));
      PhoneFragmentActivity_MembersInjector.injectMDialerController(paramPhoneFragmentActivity, dagger.a.c.b(b.aR(b.this)));
      return paramPhoneFragmentActivity;
    }

    public void a(PhoneFragmentActivity paramPhoneFragmentActivity)
    {
      b(paramPhoneFragmentActivity);
    }
  }

  private final class dj extends com.viber.voip.g.a.a.ba.a.a
  {
    private PopupMessageActivity b;

    private dj()
    {
    }

    public com.viber.voip.g.a.a.ba.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PopupMessageActivity.class.getCanonicalName() + " must be set");
      return new b.dk(b.this, this, null);
    }

    public void a(PopupMessageActivity paramPopupMessageActivity)
    {
      this.b = ((PopupMessageActivity)dagger.a.h.a(paramPopupMessageActivity));
    }
  }

  private final class dk
    implements com.viber.voip.g.a.a.ba.a
  {
    private dk(b.dj arg2)
    {
    }

    private PopupMessageActivity b(PopupMessageActivity paramPopupMessageActivity)
    {
      com.viber.voip.messages.ui.popup.c.a(paramPopupMessageActivity, b.an(b.this));
      com.viber.voip.messages.ui.popup.c.a(paramPopupMessageActivity, b.aq(b.this));
      return paramPopupMessageActivity;
    }

    public void a(PopupMessageActivity paramPopupMessageActivity)
    {
      b(paramPopupMessageActivity);
    }
  }

  private final class dl extends com.viber.voip.g.a.a.bb.a.a
  {
    private PublicAccountConversationActivity b;

    private dl()
    {
    }

    public com.viber.voip.g.a.a.bb.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicAccountConversationActivity.class.getCanonicalName() + " must be set");
      return new b.dm(b.this, this, null);
    }

    public void a(PublicAccountConversationActivity paramPublicAccountConversationActivity)
    {
      this.b = ((PublicAccountConversationActivity)dagger.a.h.a(paramPublicAccountConversationActivity));
    }
  }

  private final class dm
    implements com.viber.voip.g.a.a.bb.a
  {
    private Provider<com.viber.voip.g.a.a.a.aw.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.au.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.av.a.a> d;

    private dm(b.dl arg2)
    {
      b.dl localdl;
      a(localdl);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(PublicGroupsLeftMenuFragment.class, this.b).a(PublicAccountInfoFragment.class, this.c).a(PublicAccountInfoTabletFragment.class, this.d).a();
    }

    private void a(b.dl paramdl)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.aw.a.a a()
        {
          return new b.dm.e(b.dm.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.au.a.a a()
        {
          return new b.dm.a(b.dm.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.av.a.a a()
        {
          return new b.dm.c(b.dm.this, null);
        }
      };
    }

    private PublicAccountConversationActivity b(PublicAccountConversationActivity paramPublicAccountConversationActivity)
    {
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, gn.c());
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, b.B(b.this));
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, (com.viber.voip.messages.ui.media.player.d.e)b.C(b.this).get());
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, b());
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, b.this.d());
      com.viber.voip.messages.ui.s.a(paramPublicAccountConversationActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.ui.s.b(paramPublicAccountConversationActivity, dagger.a.c.b(b.E(b.this)));
      return paramPublicAccountConversationActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicAccountConversationActivity paramPublicAccountConversationActivity)
    {
      b(paramPublicAccountConversationActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.au.a.a
    {
      private PublicAccountInfoFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.au.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoFragment.class.getCanonicalName() + " must be set");
        return new b.dm.b(b.dm.this, this, null);
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        this.b = ((PublicAccountInfoFragment)dagger.a.h.a(paramPublicAccountInfoFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.au.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private b(b.dm.a arg2)
      {
        b.dm.a locala;
        a(locala);
      }

      private void a(b.dm.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoFragment b(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.a.a.at.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoFragment;
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        b(paramPublicAccountInfoFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.av.a.a
    {
      private PublicAccountInfoTabletFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.av.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoTabletFragment.class.getCanonicalName() + " must be set");
        return new b.dm.d(b.dm.this, this, null);
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        this.b = ((PublicAccountInfoTabletFragment)dagger.a.h.a(paramPublicAccountInfoTabletFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.av.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private d(b.dm.c arg2)
      {
        b.dm.c localc;
        a(localc);
      }

      private void a(b.dm.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoTabletFragment b(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.a.a.at.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoTabletFragment;
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        b(paramPublicAccountInfoTabletFragment);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.aw.a.a
    {
      private PublicGroupsLeftMenuFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.aw.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicGroupsLeftMenuFragment.class.getCanonicalName() + " must be set");
        return new b.dm.f(b.dm.this, this, null);
      }

      public void a(PublicGroupsLeftMenuFragment paramPublicGroupsLeftMenuFragment)
      {
        this.b = ((PublicGroupsLeftMenuFragment)dagger.a.h.a(paramPublicGroupsLeftMenuFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.aw.a
    {
      private f(b.dm.e arg2)
      {
      }

      private PublicGroupsLeftMenuFragment b(PublicGroupsLeftMenuFragment paramPublicGroupsLeftMenuFragment)
      {
        com.viber.voip.messages.ui.i.a(paramPublicGroupsLeftMenuFragment, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramPublicGroupsLeftMenuFragment, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramPublicGroupsLeftMenuFragment, dagger.a.c.b(b.af(b.this)));
        com.viber.voip.messages.conversation.publicaccount.r.a(paramPublicGroupsLeftMenuFragment, dagger.a.c.b(b.am(b.this)));
        return paramPublicGroupsLeftMenuFragment;
      }

      public void a(PublicGroupsLeftMenuFragment paramPublicGroupsLeftMenuFragment)
      {
        b(paramPublicGroupsLeftMenuFragment);
      }
    }
  }

  private final class dn extends com.viber.voip.g.a.a.bc.a.a
  {
    private PublicAccountEditActivity b;

    private dn()
    {
    }

    public com.viber.voip.g.a.a.bc.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicAccountEditActivity.class.getCanonicalName() + " must be set");
      return new b.do(b.this, this, null);
    }

    public void a(PublicAccountEditActivity paramPublicAccountEditActivity)
    {
      this.b = ((PublicAccountEditActivity)dagger.a.h.a(paramPublicAccountEditActivity));
    }
  }

  private final class do
    implements com.viber.voip.g.a.a.bc.a
  {
    private Provider<com.viber.voip.g.a.a.a.ax.a.a> b;

    private do(b.dn arg2)
    {
      b.dn localdn;
      a(localdn);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(PublicAccountEditFragment.class, this.b).a();
    }

    private void a(b.dn paramdn)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ax.a.a a()
        {
          return new b.do.a(b.do.this, null);
        }
      };
    }

    private PublicAccountEditActivity b(PublicAccountEditActivity paramPublicAccountEditActivity)
    {
      com.viber.voip.publicaccount.ui.screen.info.c.a(paramPublicAccountEditActivity, b());
      return paramPublicAccountEditActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicAccountEditActivity paramPublicAccountEditActivity)
    {
      b(paramPublicAccountEditActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ax.a.a
    {
      private PublicAccountEditFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ax.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountEditFragment.class.getCanonicalName() + " must be set");
        return new b.do.b(b.do.this, this, null);
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        this.b = ((PublicAccountEditFragment)dagger.a.h.a(paramPublicAccountEditFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ax.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private b(b.do.a arg2)
      {
        b.do.a locala;
        a(locala);
      }

      private void a(b.do.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountEditFragment b(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountEditFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountEditFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.a.b.v.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountEditFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountEditFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountEditFragment;
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        b(paramPublicAccountEditFragment);
      }
    }
  }

  private final class dp extends com.viber.voip.g.a.a.bd.a.a
  {
    private PublicAccountInfoActivity b;

    private dp()
    {
    }

    public com.viber.voip.g.a.a.bd.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicAccountInfoActivity.class.getCanonicalName() + " must be set");
      return new b.dq(b.this, this, null);
    }

    public void a(PublicAccountInfoActivity paramPublicAccountInfoActivity)
    {
      this.b = ((PublicAccountInfoActivity)dagger.a.h.a(paramPublicAccountInfoActivity));
    }
  }

  private final class dq
    implements com.viber.voip.g.a.a.bd.a
  {
    private Provider<com.viber.voip.g.a.a.a.aq.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ar.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ap.a.a> d;

    private dq(b.dp arg2)
    {
      b.dp localdp;
      a(localdp);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(PublicAccountInfoFragment.class, this.b).a(PublicAccountInfoTabletFragment.class, this.c).a(PublicAccountEditFragment.class, this.d).a();
    }

    private void a(b.dp paramdp)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.aq.a.a a()
        {
          return new b.dq.a(b.dq.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ar.a.a a()
        {
          return new b.dq.e(b.dq.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ap.a.a a()
        {
          return new b.dq.c(b.dq.this, null);
        }
      };
    }

    private PublicAccountInfoActivity b(PublicAccountInfoActivity paramPublicAccountInfoActivity)
    {
      com.viber.voip.publicaccount.ui.screen.info.f.a(paramPublicAccountInfoActivity, b());
      return paramPublicAccountInfoActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicAccountInfoActivity paramPublicAccountInfoActivity)
    {
      b(paramPublicAccountInfoActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.aq.a.a
    {
      private PublicAccountInfoFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.aq.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoFragment.class.getCanonicalName() + " must be set");
        return new b.dq.b(b.dq.this, this, null);
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        this.b = ((PublicAccountInfoFragment)dagger.a.h.a(paramPublicAccountInfoFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.aq.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private b(b.dq.a arg2)
      {
        b.dq.a locala;
        a(locala);
      }

      private void a(b.dq.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoFragment b(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoFragment;
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        b(paramPublicAccountInfoFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ap.a.a
    {
      private PublicAccountEditFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ap.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountEditFragment.class.getCanonicalName() + " must be set");
        return new b.dq.d(b.dq.this, this, null);
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        this.b = ((PublicAccountEditFragment)dagger.a.h.a(paramPublicAccountEditFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ap.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private d(b.dq.c arg2)
      {
        b.dq.c localc;
        a(localc);
      }

      private void a(b.dq.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountEditFragment b(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountEditFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountEditFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountEditFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountEditFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountEditFragment;
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        b(paramPublicAccountEditFragment);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ar.a.a
    {
      private PublicAccountInfoTabletFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ar.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoTabletFragment.class.getCanonicalName() + " must be set");
        return new b.dq.f(b.dq.this, this, null);
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        this.b = ((PublicAccountInfoTabletFragment)dagger.a.h.a(paramPublicAccountInfoTabletFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ar.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private f(b.dq.e arg2)
      {
        b.dq.e locale;
        a(locale);
      }

      private void a(b.dq.e parame)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoTabletFragment b(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoTabletFragment;
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        b(paramPublicAccountInfoTabletFragment);
      }
    }
  }

  private final class dr extends com.viber.voip.g.a.a.be.a.a
  {
    private PublicAccountInfoTabletActivity b;

    private dr()
    {
    }

    public com.viber.voip.g.a.a.be.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicAccountInfoTabletActivity.class.getCanonicalName() + " must be set");
      return new b.ds(b.this, this, null);
    }

    public void a(PublicAccountInfoTabletActivity paramPublicAccountInfoTabletActivity)
    {
      this.b = ((PublicAccountInfoTabletActivity)dagger.a.h.a(paramPublicAccountInfoTabletActivity));
    }
  }

  private final class ds
    implements com.viber.voip.g.a.a.be.a
  {
    private Provider<com.viber.voip.g.a.a.a.aq.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ar.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ap.a.a> d;

    private ds(b.dr arg2)
    {
      b.dr localdr;
      a(localdr);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(PublicAccountInfoFragment.class, this.b).a(PublicAccountInfoTabletFragment.class, this.c).a(PublicAccountEditFragment.class, this.d).a();
    }

    private void a(b.dr paramdr)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.aq.a.a a()
        {
          return new b.ds.a(b.ds.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ar.a.a a()
        {
          return new b.ds.e(b.ds.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ap.a.a a()
        {
          return new b.ds.c(b.ds.this, null);
        }
      };
    }

    private PublicAccountInfoTabletActivity b(PublicAccountInfoTabletActivity paramPublicAccountInfoTabletActivity)
    {
      com.viber.voip.publicaccount.ui.screen.info.f.a(paramPublicAccountInfoTabletActivity, b());
      return paramPublicAccountInfoTabletActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicAccountInfoTabletActivity paramPublicAccountInfoTabletActivity)
    {
      b(paramPublicAccountInfoTabletActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.aq.a.a
    {
      private PublicAccountInfoFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.aq.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoFragment.class.getCanonicalName() + " must be set");
        return new b.ds.b(b.ds.this, this, null);
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        this.b = ((PublicAccountInfoFragment)dagger.a.h.a(paramPublicAccountInfoFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.aq.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private b(b.ds.a arg2)
      {
        b.ds.a locala;
        a(locala);
      }

      private void a(b.ds.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoFragment b(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoFragment;
      }

      public void a(PublicAccountInfoFragment paramPublicAccountInfoFragment)
      {
        b(paramPublicAccountInfoFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ap.a.a
    {
      private PublicAccountEditFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ap.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountEditFragment.class.getCanonicalName() + " must be set");
        return new b.ds.d(b.ds.this, this, null);
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        this.b = ((PublicAccountEditFragment)dagger.a.h.a(paramPublicAccountEditFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ap.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private d(b.ds.c arg2)
      {
        b.ds.c localc;
        a(localc);
      }

      private void a(b.ds.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountEditFragment b(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountEditFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountEditFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountEditFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountEditFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountEditFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountEditFragment;
      }

      public void a(PublicAccountEditFragment paramPublicAccountEditFragment)
      {
        b(paramPublicAccountEditFragment);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ar.a.a
    {
      private PublicAccountInfoTabletFragment b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ar.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicAccountInfoTabletFragment.class.getCanonicalName() + " must be set");
        return new b.ds.f(b.ds.this, this, null);
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        this.b = ((PublicAccountInfoTabletFragment)dagger.a.h.a(paramPublicAccountInfoTabletFragment));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ar.a
    {
      private Provider<com.viber.voip.messages.conversation.ui.b.q> b;

      private f(b.ds.e arg2)
      {
        b.ds.e locale;
        a(locale);
      }

      private void a(b.ds.e parame)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.b.r.b());
      }

      private PublicAccountInfoTabletFragment b(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.k)b.J(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.common.permission.c)b.K(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.L(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, gn.c());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.N(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.b(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.c(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.O(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, com.viber.voip.g.a.a.b.x.b());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.P(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.messages.conversation.chatinfo.presentation.m.d(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.S(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.e(paramPublicAccountInfoTabletFragment, dagger.a.c.b(b.T(b.this)));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.G(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.U(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.V(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, b.W(b.this));
        com.viber.voip.messages.conversation.chatinfo.presentation.m.a(paramPublicAccountInfoTabletFragment, (com.viber.voip.messages.conversation.ui.b.q)this.b.get());
        return paramPublicAccountInfoTabletFragment;
      }

      public void a(PublicAccountInfoTabletFragment paramPublicAccountInfoTabletFragment)
      {
        b(paramPublicAccountInfoTabletFragment);
      }
    }
  }

  private final class dt extends ci.a.a
  {
    private PublicChatsActivity b;

    private dt()
    {
    }

    public ci.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicChatsActivity.class.getCanonicalName() + " must be set");
      return new b.du(b.this, this, null);
    }

    public void a(PublicChatsActivity paramPublicChatsActivity)
    {
      this.b = ((PublicChatsActivity)dagger.a.h.a(paramPublicChatsActivity));
    }
  }

  private final class du
    implements ci.a
  {
    private Provider<com.viber.voip.g.a.a.a.bb.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.bc.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ba.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.az.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.ay.a.a> f;

    private du(b.dt arg2)
    {
      b.dt localdt;
      a(localdt);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.conversation.publicaccount.d.class, this.b).a(PublicGroupsFragment.class, this.c).a(com.viber.voip.messages.extensions.b.i.class, this.d).a(com.viber.voip.messages.extensions.b.d.class, this.e).a(com.viber.voip.messages.extensions.b.b.class, this.f).a();
    }

    private void a(b.dt paramdt)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bb.a.a a()
        {
          return new b.du.a(b.du.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.bc.a.a a()
        {
          return new b.du.i(b.du.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ba.a.a a()
        {
          return new b.du.g(b.du.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.az.a.a a()
        {
          return new b.du.e(b.du.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.ay.a.a a()
        {
          return new b.du.c(b.du.this, null);
        }
      };
    }

    private PublicChatsActivity b(PublicChatsActivity paramPublicChatsActivity)
    {
      com.viber.voip.messages.conversation.publicaccount.i.a(paramPublicChatsActivity, com.viber.voip.g.a.s.c());
      com.viber.voip.messages.conversation.publicaccount.i.a(paramPublicChatsActivity, b.P(b.this));
      com.viber.voip.messages.conversation.publicaccount.i.a(paramPublicChatsActivity, b.B(b.this));
      com.viber.voip.messages.conversation.publicaccount.i.a(paramPublicChatsActivity, b());
      return paramPublicChatsActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicChatsActivity paramPublicChatsActivity)
    {
      b(paramPublicChatsActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bb.a.a
    {
      private com.viber.voip.messages.conversation.publicaccount.d b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bb.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.publicaccount.d.class.getCanonicalName() + " must be set");
        return new b.du.b(b.du.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.publicaccount.d paramd)
      {
        this.b = ((com.viber.voip.messages.conversation.publicaccount.d)dagger.a.h.a(paramd));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bb.a
    {
      private b(b.du.a arg2)
      {
      }

      private com.viber.voip.messages.conversation.publicaccount.d b(com.viber.voip.messages.conversation.publicaccount.d paramd)
      {
        com.viber.voip.messages.ui.i.a(paramd, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramd, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramd, dagger.a.c.b(b.af(b.this)));
        com.viber.voip.messages.conversation.publicaccount.r.a(paramd, dagger.a.c.b(b.am(b.this)));
        return paramd;
      }

      public void a(com.viber.voip.messages.conversation.publicaccount.d paramd)
      {
        b(paramd);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ay.a.a
    {
      private com.viber.voip.messages.extensions.b.b b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ay.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.b.class.getCanonicalName() + " must be set");
        return new b.du.d(b.du.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        this.b = ((com.viber.voip.messages.extensions.b.b)dagger.a.h.a(paramb));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ay.a
    {
      private Provider<com.viber.voip.messages.extensions.b.b> b;
      private Provider<ChatExtensionDetailsPresenter> c;

      private d(b.du.c arg2)
      {
        b.du.c localc;
        a(localc);
      }

      private void a(b.du.c paramc)
      {
        this.b = dagger.a.e.a(b.du.c.a(paramc));
        this.c = dagger.a.c.a(com.viber.voip.g.a.a.b.b.a(this.b, b.ao(b.this), b.at(b.this), b.K(b.this), b.af(b.this), b.I(b.this), du.b(), b.ax(b.this)));
      }

      private com.viber.voip.messages.extensions.b.b b(com.viber.voip.messages.extensions.b.b paramb)
      {
        com.viber.voip.messages.extensions.b.c.a(paramb, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.c.a(paramb, (ChatExtensionDetailsPresenter)this.c.get());
        return paramb;
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        b(paramb);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.az.a.a
    {
      private com.viber.voip.messages.extensions.b.d b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.az.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.d.class.getCanonicalName() + " must be set");
        return new b.du.f(b.du.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        this.b = ((com.viber.voip.messages.extensions.b.d)dagger.a.h.a(paramd));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.az.a
    {
      private f(b.du.e arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.d b(com.viber.voip.messages.extensions.b.d paramd)
      {
        com.viber.voip.messages.extensions.b.h.a(paramd, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.b.f)b.av(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        return paramd;
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        b(paramd);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.ba.a.a
    {
      private com.viber.voip.messages.extensions.b.i b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.ba.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.i.class.getCanonicalName() + " must be set");
        return new b.du.h(b.du.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        this.b = ((com.viber.voip.messages.extensions.b.i)dagger.a.h.a(parami));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.ba.a
    {
      private h(b.du.g arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.i b(com.viber.voip.messages.extensions.b.i parami)
      {
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.a)b.at(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, gn.c());
        com.viber.voip.messages.extensions.b.l.a(parami, b.au(b.this));
        return parami;
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        b(parami);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.bc.a.a
    {
      private PublicGroupsFragment b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.bc.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(PublicGroupsFragment.class.getCanonicalName() + " must be set");
        return new b.du.j(b.du.this, this, null);
      }

      public void a(PublicGroupsFragment paramPublicGroupsFragment)
      {
        this.b = ((PublicGroupsFragment)dagger.a.h.a(paramPublicGroupsFragment));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.bc.a
    {
      private j(b.du.i arg2)
      {
      }

      private PublicGroupsFragment b(PublicGroupsFragment paramPublicGroupsFragment)
      {
        com.viber.voip.messages.ui.i.a(paramPublicGroupsFragment, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paramPublicGroupsFragment, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paramPublicGroupsFragment, dagger.a.c.b(b.af(b.this)));
        com.viber.voip.messages.conversation.publicaccount.r.a(paramPublicGroupsFragment, dagger.a.c.b(b.am(b.this)));
        return paramPublicGroupsFragment;
      }

      public void a(PublicGroupsFragment paramPublicGroupsFragment)
      {
        b(paramPublicGroupsFragment);
      }
    }
  }

  private final class dv extends com.viber.voip.g.a.a.bf.a.a
  {
    private PublicGroupConversationFragment b;

    private dv()
    {
    }

    public com.viber.voip.g.a.a.bf.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicGroupConversationFragment.class.getCanonicalName() + " must be set");
      return new b.dw(b.this, this, null);
    }

    public void a(PublicGroupConversationFragment paramPublicGroupConversationFragment)
    {
      this.b = ((PublicGroupConversationFragment)dagger.a.h.a(paramPublicGroupConversationFragment));
    }
  }

  private final class dw
    implements com.viber.voip.g.a.a.bf.a
  {
    private dw(b.dv arg2)
    {
    }

    private PublicGroupConversationFragment b(PublicGroupConversationFragment paramPublicGroupConversationFragment)
    {
      aw.a(paramPublicGroupConversationFragment, fx.b());
      aw.a(paramPublicGroupConversationFragment, b.bM(b.this));
      aw.a(paramPublicGroupConversationFragment, b.bN(b.this));
      aw.a(paramPublicGroupConversationFragment, fz.c());
      aw.a(paramPublicGroupConversationFragment, ck.c());
      aw.a(paramPublicGroupConversationFragment, b.bO(b.this));
      aw.a(paramPublicGroupConversationFragment, b.bP(b.this));
      aw.a(paramPublicGroupConversationFragment, com.viber.voip.g.a.s.c());
      aw.a(paramPublicGroupConversationFragment, b.X(b.this));
      aw.a(paramPublicGroupConversationFragment, b.P(b.this));
      aw.a(paramPublicGroupConversationFragment, b.ak(b.this));
      aw.a(paramPublicGroupConversationFragment, b.aj(b.this));
      aw.a(paramPublicGroupConversationFragment, b.bQ(b.this));
      aw.a(paramPublicGroupConversationFragment, b.bR(b.this));
      aw.a(paramPublicGroupConversationFragment, dx.c());
      aw.a(paramPublicGroupConversationFragment, b.N(b.this));
      aw.a(paramPublicGroupConversationFragment, b.aq(b.this));
      aw.a(paramPublicGroupConversationFragment, b.ar(b.this));
      aw.a(paramPublicGroupConversationFragment, (com.viber.voip.app.b)b.I(b.this).get());
      aw.a(paramPublicGroupConversationFragment, b.L(b.this));
      aw.a(paramPublicGroupConversationFragment, b.U(b.this));
      aw.a(paramPublicGroupConversationFragment, b.bg(b.this));
      aw.a(paramPublicGroupConversationFragment, b.this.d());
      aw.a(paramPublicGroupConversationFragment, dagger.a.c.b(b.J(b.this)));
      aw.b(paramPublicGroupConversationFragment, dagger.a.c.b(b.af(b.this)));
      aw.a(paramPublicGroupConversationFragment, com.viber.voip.g.a.p.c());
      aw.a(paramPublicGroupConversationFragment, du.c());
      aw.a(paramPublicGroupConversationFragment, (com.viber.common.permission.c)b.K(b.this).get());
      aw.a(paramPublicGroupConversationFragment, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      aw.c(paramPublicGroupConversationFragment, dagger.a.c.b(b.O(b.this)));
      aw.a(paramPublicGroupConversationFragment, b.an(b.this));
      aw.d(paramPublicGroupConversationFragment, dagger.a.c.b(b.T(b.this)));
      aw.a(paramPublicGroupConversationFragment, (com.viber.voip.messages.extensions.i)b.bS(b.this).get());
      aw.e(paramPublicGroupConversationFragment, dagger.a.c.b(b.aW(b.this)));
      aw.a(paramPublicGroupConversationFragment, (EventBus)b.M(b.this).get());
      aw.a(paramPublicGroupConversationFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
      aw.f(paramPublicGroupConversationFragment, dagger.a.c.b(b.bT(b.this)));
      aw.g(paramPublicGroupConversationFragment, dagger.a.c.b(b.al(b.this)));
      aw.h(paramPublicGroupConversationFragment, dagger.a.c.b(b.A(b.this)));
      aw.a(paramPublicGroupConversationFragment, b.V(b.this));
      aw.i(paramPublicGroupConversationFragment, dagger.a.c.b(b.ai(b.this)));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramPublicGroupConversationFragment, b.aq(b.this));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramPublicGroupConversationFragment, b.aj(b.this));
      return paramPublicGroupConversationFragment;
    }

    public void a(PublicGroupConversationFragment paramPublicGroupConversationFragment)
    {
      b(paramPublicGroupConversationFragment);
    }
  }

  private final class dx extends cj.a.a
  {
    private PublicGroupInviteContactsListActivity b;

    private dx()
    {
    }

    public cj.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(PublicGroupInviteContactsListActivity.class.getCanonicalName() + " must be set");
      return new b.dy(b.this, this, null);
    }

    public void a(PublicGroupInviteContactsListActivity paramPublicGroupInviteContactsListActivity)
    {
      this.b = ((PublicGroupInviteContactsListActivity)dagger.a.h.a(paramPublicGroupInviteContactsListActivity));
    }
  }

  private final class dy
    implements cj.a
  {
    private Provider<com.viber.voip.g.a.a.a.am.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.al.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ak.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.an.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.aj.a.a> f;

    private dy(b.dx arg2)
    {
      b.dx localdx;
      a(localdx);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(31).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.contacts.ui.an.class, this.b).a(bj.class, this.c).a(com.viber.voip.contacts.ui.s.class, this.d).a(com.viber.voip.contacts.ui.ba.class, this.e).a(com.viber.voip.contacts.ui.o.class, this.f).a();
    }

    private void a(b.dx paramdx)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.am.a.a a()
        {
          return new b.dy.e(b.dy.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.al.a.a a()
        {
          return new b.dy.g(b.dy.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ak.a.a a()
        {
          return new b.dy.c(b.dy.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.an.a.a a()
        {
          return new b.dy.i(b.dy.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.aj.a.a a()
        {
          return new b.dy.a(b.dy.this, null);
        }
      };
    }

    private PublicGroupInviteContactsListActivity b(PublicGroupInviteContactsListActivity paramPublicGroupInviteContactsListActivity)
    {
      com.viber.voip.contacts.ui.aq.a(paramPublicGroupInviteContactsListActivity, b());
      com.viber.voip.contacts.ui.az.a(paramPublicGroupInviteContactsListActivity, (com.viber.voip.messages.k)b.J(b.this).get());
      return paramPublicGroupInviteContactsListActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(PublicGroupInviteContactsListActivity paramPublicGroupInviteContactsListActivity)
    {
      b(paramPublicGroupInviteContactsListActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.aj.a.a
    {
      private com.viber.voip.contacts.ui.o b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.aj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.o.class.getCanonicalName() + " must be set");
        return new b.dy.b(b.dy.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        this.b = ((com.viber.voip.contacts.ui.o)dagger.a.h.a(paramo));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.aj.a
    {
      private b(b.dy.a arg2)
      {
      }

      private com.viber.voip.contacts.ui.o b(com.viber.voip.contacts.ui.o paramo)
      {
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.b.f)b.aP(b.this).get());
        com.viber.voip.contacts.ui.ai.a(paramo, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        com.viber.voip.contacts.ui.p.a(paramo, b.P(b.this));
        return paramo;
      }

      public void a(com.viber.voip.contacts.ui.o paramo)
      {
        b(paramo);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ak.a.a
    {
      private com.viber.voip.contacts.ui.s b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ak.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.s.class.getCanonicalName() + " must be set");
        return new b.dy.d(b.dy.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        this.b = ((com.viber.voip.contacts.ui.s)dagger.a.h.a(params));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ak.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.s> c;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> d;

      private d(b.dy.c arg2)
      {
        b.dy.c localc;
        a(localc);
      }

      private void a(b.dy.c paramc)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.dy.c.a(paramc));
        this.d = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.c, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.s b(com.viber.voip.contacts.ui.s params)
      {
        com.viber.voip.contacts.ui.v.a(params, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(params, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(params, dagger.a.c.b(this.d));
        return params;
      }

      public void a(com.viber.voip.contacts.ui.s params)
      {
        b(params);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.am.a.a
    {
      private com.viber.voip.contacts.ui.an b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.am.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.an.class.getCanonicalName() + " must be set");
        return new b.dy.f(b.dy.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        this.b = ((com.viber.voip.contacts.ui.an)dagger.a.h.a(paraman));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.am.a
    {
      private f(b.dy.e arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.contacts.ui.an b(com.viber.voip.contacts.ui.an paraman)
      {
        com.viber.voip.messages.ui.i.a(paraman, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(paraman, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(paraman, dagger.a.c.b(b.af(b.this)));
        bu.a(paraman, dagger.a.c.b(b.ac(b.this)));
        bu.b(paraman, dagger.a.c.b(b.A(b.this)));
        bu.c(paraman, dagger.a.c.b(b.ag(b.this)));
        bu.d(paraman, dagger.a.c.b(b.ah(b.this)));
        bu.e(paraman, dagger.a.c.b(b.ai(b.this)));
        bu.a(paraman, b.this.d());
        bu.a(paraman, b.aj(b.this));
        bu.a(paraman, b.ak(b.this));
        bu.f(paraman, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(paraman, dagger.a.c.b(b.O(b.this)));
        bu.a(paraman, b());
        bu.h(paraman, dagger.a.c.b(b.al(b.this)));
        return paraman;
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      public void a(com.viber.voip.contacts.ui.an paraman)
      {
        b(paraman);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.al.a.a
    {
      private bj b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.al.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(bj.class.getCanonicalName() + " must be set");
        return new b.dy.h(b.dy.this, this, null);
      }

      public void a(bj parambj)
      {
        this.b = ((bj)dagger.a.h.a(parambj));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.al.a
    {
      private h(b.dy.g arg2)
      {
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private bj b(bj parambj)
      {
        com.viber.voip.messages.ui.i.a(parambj, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parambj, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parambj, dagger.a.c.b(b.af(b.this)));
        bu.a(parambj, dagger.a.c.b(b.ac(b.this)));
        bu.b(parambj, dagger.a.c.b(b.A(b.this)));
        bu.c(parambj, dagger.a.c.b(b.ag(b.this)));
        bu.d(parambj, dagger.a.c.b(b.ah(b.this)));
        bu.e(parambj, dagger.a.c.b(b.ai(b.this)));
        bu.a(parambj, b.this.d());
        bu.a(parambj, b.aj(b.this));
        bu.a(parambj, b.ak(b.this));
        bu.f(parambj, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(parambj, dagger.a.c.b(b.O(b.this)));
        bu.a(parambj, b());
        bu.h(parambj, dagger.a.c.b(b.al(b.this)));
        return parambj;
      }

      public void a(bj parambj)
      {
        b(parambj);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.an.a.a
    {
      private com.viber.voip.contacts.ui.ba b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.an.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.contacts.ui.ba.class.getCanonicalName() + " must be set");
        return new b.dy.j(b.dy.this, this, null);
      }

      public void a(com.viber.voip.contacts.ui.ba paramba)
      {
        this.b = ((com.viber.voip.contacts.ui.ba)dagger.a.h.a(paramba));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.an.a
    {
      private Provider<com.viber.voip.invitelinks.f> b;
      private Provider<com.viber.voip.contacts.ui.ba> c;
      private Provider<com.viber.voip.contacts.ui.s> d;
      private Provider<com.viber.voip.invitelinks.linkscreen.f> e;

      private j(b.dy.i arg2)
      {
        b.dy.i locali;
        a(locali);
      }

      private void a(b.dy.i parami)
      {
        this.b = dagger.a.c.a(com.viber.voip.g.a.a.b.l.a(b.aO(b.this), b.ag(b.this)));
        this.c = dagger.a.e.a(b.dy.i.a(parami));
        this.d = dagger.a.c.a(this.c);
        this.e = dagger.a.c.a(com.viber.voip.g.a.a.b.m.a(this.d, com.viber.voip.g.a.s.b()));
      }

      private com.viber.voip.contacts.ui.ba b(com.viber.voip.contacts.ui.ba paramba)
      {
        com.viber.voip.contacts.ui.v.a(paramba, b.P(b.this));
        com.viber.voip.contacts.ui.v.a(paramba, dagger.a.c.b(this.b));
        com.viber.voip.contacts.ui.v.b(paramba, dagger.a.c.b(this.e));
        return paramba;
      }

      public void a(com.viber.voip.contacts.ui.ba paramba)
      {
        b(paramba);
      }
    }
  }

  private final class dz extends com.viber.voip.g.a.a.bh.a.a
  {
    private RecentCallsActivity b;

    private dz()
    {
    }

    public com.viber.voip.g.a.a.bh.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(RecentCallsActivity.class.getCanonicalName() + " must be set");
      return new b.ea(b.this, this, null);
    }

    public void a(RecentCallsActivity paramRecentCallsActivity)
    {
      this.b = ((RecentCallsActivity)dagger.a.h.a(paramRecentCallsActivity));
    }
  }

  private final class e extends com.viber.voip.g.a.a.c.a.a
  {
    private AddMoreGallery b;

    private e()
    {
    }

    public com.viber.voip.g.a.a.c.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(AddMoreGallery.class.getCanonicalName() + " must be set");
      return new b.f(b.this, this, null);
    }

    public void a(AddMoreGallery paramAddMoreGallery)
    {
      this.b = ((AddMoreGallery)dagger.a.h.a(paramAddMoreGallery));
    }
  }

  private final class ea
    implements com.viber.voip.g.a.a.bh.a
  {
    private Provider<com.viber.voip.g.a.a.a.bd.a.a> b;

    private ea(b.dz arg2)
    {
      b.dz localdz;
      a(localdz);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(RecentCallsFragment.class, this.b).a();
    }

    private void a(b.dz paramdz)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bd.a.a a()
        {
          return new b.ea.a(b.ea.this, null);
        }
      };
    }

    private RecentCallsActivity b(RecentCallsActivity paramRecentCallsActivity)
    {
      com.viber.voip.calls.ui.n.a(paramRecentCallsActivity, b());
      return paramRecentCallsActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(RecentCallsActivity paramRecentCallsActivity)
    {
      b(paramRecentCallsActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bd.a.a
    {
      private RecentCallsFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bd.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(RecentCallsFragment.class.getCanonicalName() + " must be set");
        return new b.ea.b(b.ea.this, this, null);
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        this.b = ((RecentCallsFragment)dagger.a.h.a(paramRecentCallsFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bd.a
    {
      private b(b.ea.a arg2)
      {
      }

      private RecentCallsFragment b(RecentCallsFragment paramRecentCallsFragment)
      {
        com.viber.voip.calls.ui.s.a(paramRecentCallsFragment, dagger.a.c.b(b.be(b.this)));
        com.viber.voip.calls.ui.s.b(paramRecentCallsFragment, dagger.a.c.b(b.O(b.this)));
        return paramRecentCallsFragment;
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        b(paramRecentCallsFragment);
      }
    }
  }

  private final class eb extends com.viber.voip.g.a.a.bi.a.a
  {
    private RegistrationActivity b;

    private eb()
    {
    }

    public com.viber.voip.g.a.a.bi.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(RegistrationActivity.class.getCanonicalName() + " must be set");
      return new b.ec(b.this, this, null);
    }

    public void a(RegistrationActivity paramRegistrationActivity)
    {
      this.b = ((RegistrationActivity)dagger.a.h.a(paramRegistrationActivity));
    }
  }

  private final class ec
    implements com.viber.voip.g.a.a.bi.a
  {
    private Provider<com.viber.voip.g.a.a.a.be.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.bf.a.a> c;

    private ec(b.eb arg2)
    {
      b.eb localeb;
      a(localeb);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.registration.d.class, this.b).a(com.viber.voip.registration.t.class, this.c).a();
    }

    private void a(b.eb parameb)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.be.a.a a()
        {
          return new b.ec.a(b.ec.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.bf.a.a a()
        {
          return new b.ec.c(b.ec.this, null);
        }
      };
    }

    private RegistrationActivity b(RegistrationActivity paramRegistrationActivity)
    {
      com.viber.voip.registration.aa.a(paramRegistrationActivity, dagger.a.c.b(b.ba(b.this)));
      com.viber.voip.registration.aa.a(paramRegistrationActivity, b());
      return paramRegistrationActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(RegistrationActivity paramRegistrationActivity)
    {
      b(paramRegistrationActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.be.a.a
    {
      private com.viber.voip.registration.d b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.be.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.registration.d.class.getCanonicalName() + " must be set");
        return new b.ec.b(b.ec.this, this, null);
      }

      public void a(com.viber.voip.registration.d paramd)
      {
        this.b = ((com.viber.voip.registration.d)dagger.a.h.a(paramd));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.be.a
    {
      private b(b.ec.a arg2)
      {
      }

      private com.viber.voip.registration.d b(com.viber.voip.registration.d paramd)
      {
        com.viber.voip.registration.i.a(paramd, b.G(b.this));
        com.viber.voip.registration.i.a(paramd, dagger.a.c.b(b.ba(b.this)));
        return paramd;
      }

      public void a(com.viber.voip.registration.d paramd)
      {
        b(paramd);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.bf.a.a
    {
      private com.viber.voip.registration.t b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.bf.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.registration.t.class.getCanonicalName() + " must be set");
        return new b.ec.d(b.ec.this, this, null);
      }

      public void a(com.viber.voip.registration.t paramt)
      {
        this.b = ((com.viber.voip.registration.t)dagger.a.h.a(paramt));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.bf.a
    {
      private d(b.ec.c arg2)
      {
      }

      private com.viber.voip.registration.t b(com.viber.voip.registration.t paramt)
      {
        com.viber.voip.registration.i.a(paramt, b.G(b.this));
        com.viber.voip.registration.i.a(paramt, dagger.a.c.b(b.ba(b.this)));
        return paramt;
      }

      public void a(com.viber.voip.registration.t paramt)
      {
        b(paramt);
      }
    }
  }

  private final class ed extends com.viber.voip.g.a.a.bj.a.a
  {
    private ScannerActivity b;

    private ed()
    {
    }

    public com.viber.voip.g.a.a.bj.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ScannerActivity.class.getCanonicalName() + " must be set");
      return new b.ee(b.this, this, null);
    }

    public void a(ScannerActivity paramScannerActivity)
    {
      this.b = ((ScannerActivity)dagger.a.h.a(paramScannerActivity));
    }
  }

  private final class ee
    implements com.viber.voip.g.a.a.bj.a
  {
    private ee(b.ed arg2)
    {
    }

    public void a(ScannerActivity paramScannerActivity)
    {
    }
  }

  private final class ef extends bk.a.a
  {
    private SelectBackgroundForVibeActivity b;

    private ef()
    {
    }

    public bk.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SelectBackgroundForVibeActivity.class.getCanonicalName() + " must be set");
      return new b.eg(b.this, this, null);
    }

    public void a(SelectBackgroundForVibeActivity paramSelectBackgroundForVibeActivity)
    {
      this.b = ((SelectBackgroundForVibeActivity)dagger.a.h.a(paramSelectBackgroundForVibeActivity));
    }
  }

  private final class eg
    implements bk.a
  {
    private eg(b.ef arg2)
    {
    }

    private SelectBackgroundForVibeActivity b(SelectBackgroundForVibeActivity paramSelectBackgroundForVibeActivity)
    {
      com.viber.voip.backgrounds.ui.a.a(paramSelectBackgroundForVibeActivity, com.viber.voip.g.a.s.c());
      return paramSelectBackgroundForVibeActivity;
    }

    public void a(SelectBackgroundForVibeActivity paramSelectBackgroundForVibeActivity)
    {
      b(paramSelectBackgroundForVibeActivity);
    }
  }

  private final class eh extends com.viber.voip.g.a.a.bl.a.a
  {
    private SelectLanguageActivity b;

    private eh()
    {
    }

    public com.viber.voip.g.a.a.bl.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SelectLanguageActivity.class.getCanonicalName() + " must be set");
      return new b.ei(b.this, this, null);
    }

    public void a(SelectLanguageActivity paramSelectLanguageActivity)
    {
      this.b = ((SelectLanguageActivity)dagger.a.h.a(paramSelectLanguageActivity));
    }
  }

  private final class ei
    implements com.viber.voip.g.a.a.bl.a
  {
    private Provider<com.viber.voip.g.a.a.a.bg.a.a> b;

    private ei(b.eh arg2)
    {
      b.eh localeh;
      a(localeh);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.translation.c.class, this.b).a();
    }

    private void a(b.eh parameh)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bg.a.a a()
        {
          return new b.ei.a(b.ei.this, null);
        }
      };
    }

    private SelectLanguageActivity b(SelectLanguageActivity paramSelectLanguageActivity)
    {
      com.viber.voip.messages.translation.b.a(paramSelectLanguageActivity, b());
      return paramSelectLanguageActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SelectLanguageActivity paramSelectLanguageActivity)
    {
      b(paramSelectLanguageActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bg.a.a
    {
      private com.viber.voip.messages.translation.c b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bg.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.translation.c.class.getCanonicalName() + " must be set");
        return new b.ei.b(b.ei.this, this, null);
      }

      public void a(com.viber.voip.messages.translation.c paramc)
      {
        this.b = ((com.viber.voip.messages.translation.c)dagger.a.h.a(paramc));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bg.a
    {
      private b(b.ei.a arg2)
      {
      }

      private com.viber.voip.messages.translation.c b(com.viber.voip.messages.translation.c paramc)
      {
        com.viber.voip.messages.translation.d.a(paramc, com.viber.voip.g.a.s.c());
        return paramc;
      }

      public void a(com.viber.voip.messages.translation.c paramc)
      {
        b(paramc);
      }
    }
  }

  private final class ej extends bm.a.a
  {
    private SelectUiLanguageActivity b;

    private ej()
    {
    }

    public bm.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SelectUiLanguageActivity.class.getCanonicalName() + " must be set");
      return new b.ek(b.this, this, null);
    }

    public void a(SelectUiLanguageActivity paramSelectUiLanguageActivity)
    {
      this.b = ((SelectUiLanguageActivity)dagger.a.h.a(paramSelectUiLanguageActivity));
    }
  }

  private final class ek
    implements bm.a
  {
    private Provider<com.viber.voip.g.a.a.a.bh.a.a> b;

    private ek(b.ej arg2)
    {
      b.ej localej;
      a(localej);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.translation.f.class, this.b).a();
    }

    private void a(b.ej paramej)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bh.a.a a()
        {
          return new b.ek.a(b.ek.this, null);
        }
      };
    }

    private SelectUiLanguageActivity b(SelectUiLanguageActivity paramSelectUiLanguageActivity)
    {
      com.viber.voip.messages.translation.e.a(paramSelectUiLanguageActivity, b());
      return paramSelectUiLanguageActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SelectUiLanguageActivity paramSelectUiLanguageActivity)
    {
      b(paramSelectUiLanguageActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bh.a.a
    {
      private com.viber.voip.messages.translation.f b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bh.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.translation.f.class.getCanonicalName() + " must be set");
        return new b.ek.b(b.ek.this, this, null);
      }

      public void a(com.viber.voip.messages.translation.f paramf)
      {
        this.b = ((com.viber.voip.messages.translation.f)dagger.a.h.a(paramf));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bh.a
    {
      private b(b.ek.a arg2)
      {
      }

      private com.viber.voip.messages.translation.f b(com.viber.voip.messages.translation.f paramf)
      {
        com.viber.voip.messages.translation.h.a(paramf, com.viber.voip.g.a.s.c());
        return paramf;
      }

      public void a(com.viber.voip.messages.translation.f paramf)
      {
        b(paramf);
      }
    }
  }

  private final class el extends com.viber.voip.g.a.a.bn.a.a
  {
    private SelectionGallery b;

    private el()
    {
    }

    public com.viber.voip.g.a.a.bn.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SelectionGallery.class.getCanonicalName() + " must be set");
      return new b.em(b.this, this, null);
    }

    public void a(SelectionGallery paramSelectionGallery)
    {
      this.b = ((SelectionGallery)dagger.a.h.a(paramSelectionGallery));
    }
  }

  private final class em
    implements com.viber.voip.g.a.a.bn.a
  {
    private Provider<com.viber.voip.g.a.a.a.ad.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ab.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ac.a.a> d;

    private em(b.el arg2)
    {
      b.el localel;
      a(localel);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.gallery.selection.t.class, this.b).a(com.viber.voip.gallery.selection.c.class, this.c).a(com.viber.voip.gallery.selection.h.class, this.d).a();
    }

    private void a(b.el paramel)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ad.a.a a()
        {
          return new b.em.e(b.em.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ab.a.a a()
        {
          return new b.em.a(b.em.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ac.a.a a()
        {
          return new b.em.c(b.em.this, null);
        }
      };
    }

    private SelectionGallery b(SelectionGallery paramSelectionGallery)
    {
      com.viber.voip.gallery.selection.z.a(paramSelectionGallery, b());
      com.viber.voip.gallery.selection.z.a(paramSelectionGallery, gi.c());
      com.viber.voip.gallery.selection.z.a(paramSelectionGallery, (com.viber.voip.util.e.g)b.R(b.this).get());
      com.viber.voip.gallery.selection.z.a(paramSelectionGallery, (com.viber.common.permission.c)b.K(b.this).get());
      return paramSelectionGallery;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SelectionGallery paramSelectionGallery)
    {
      b(paramSelectionGallery);
    }

    private final class a extends com.viber.voip.g.a.a.a.ab.a.a
    {
      private com.viber.voip.gallery.selection.c b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ab.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.c.class.getCanonicalName() + " must be set");
        return new b.em.b(b.em.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.c paramc)
      {
        this.b = ((com.viber.voip.gallery.selection.c)dagger.a.h.a(paramc));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ab.a
    {
      private b(b.em.a arg2)
      {
      }

      private com.viber.voip.gallery.selection.c b(com.viber.voip.gallery.selection.c paramc)
      {
        com.viber.voip.gallery.selection.d.a(paramc, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.gallery.selection.d.a(paramc, (com.viber.common.permission.c)b.K(b.this).get());
        return paramc;
      }

      public void a(com.viber.voip.gallery.selection.c paramc)
      {
        b(paramc);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ac.a.a
    {
      private com.viber.voip.gallery.selection.h b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ac.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.h.class.getCanonicalName() + " must be set");
        return new b.em.d(b.em.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.h paramh)
      {
        this.b = ((com.viber.voip.gallery.selection.h)dagger.a.h.a(paramh));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ac.a
    {
      private d(b.em.c arg2)
      {
      }

      private com.viber.voip.gallery.selection.h b(com.viber.voip.gallery.selection.h paramh)
      {
        com.viber.voip.gallery.selection.j.a(paramh, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.gallery.selection.j.a(paramh, (com.viber.common.permission.c)b.K(b.this).get());
        return paramh;
      }

      public void a(com.viber.voip.gallery.selection.h paramh)
      {
        b(paramh);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ad.a.a
    {
      private com.viber.voip.gallery.selection.t b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ad.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.t.class.getCanonicalName() + " must be set");
        return new b.em.f(b.em.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.t paramt)
      {
        this.b = ((com.viber.voip.gallery.selection.t)dagger.a.h.a(paramt));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ad.a
    {
      private f(b.em.e arg2)
      {
      }

      public void a(com.viber.voip.gallery.selection.t paramt)
      {
      }
    }
  }

  private final class en extends com.viber.voip.g.a.a.bo.a.a
  {
    private SettingsHeadersActivity b;

    private en()
    {
    }

    public com.viber.voip.g.a.a.bo.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SettingsHeadersActivity.class.getCanonicalName() + " must be set");
      return new b.eo(b.this, this, null);
    }

    public void a(SettingsHeadersActivity paramSettingsHeadersActivity)
    {
      this.b = ((SettingsHeadersActivity)dagger.a.h.a(paramSettingsHeadersActivity));
    }
  }

  private final class eo
    implements com.viber.voip.g.a.a.bo.a
  {
    private Provider<com.viber.voip.g.a.a.a.bj.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.bi.a.a> c;

    private eo(b.en arg2)
    {
      b.en localen;
      a(localen);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.settings.ui.y.class, this.b).a(GeneralPreferenceFragment.class, this.c).a();
    }

    private void a(b.en paramen)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bj.a.a a()
        {
          return new b.eo.c(b.eo.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.bi.a.a a()
        {
          return new b.eo.a(b.eo.this, null);
        }
      };
    }

    private SettingsHeadersActivity b(SettingsHeadersActivity paramSettingsHeadersActivity)
    {
      ag.a(paramSettingsHeadersActivity, b());
      ag.a(paramSettingsHeadersActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramSettingsHeadersActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SettingsHeadersActivity paramSettingsHeadersActivity)
    {
      b(paramSettingsHeadersActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bi.a.a
    {
      private GeneralPreferenceFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bi.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(GeneralPreferenceFragment.class.getCanonicalName() + " must be set");
        return new b.eo.b(b.eo.this, this, null);
      }

      public void a(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        this.b = ((GeneralPreferenceFragment)dagger.a.h.a(paramGeneralPreferenceFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bi.a
    {
      private b(b.eo.a arg2)
      {
      }

      private GeneralPreferenceFragment b(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        com.viber.voip.settings.ui.p.a(paramGeneralPreferenceFragment, (EventBus)b.M(b.this).get());
        return paramGeneralPreferenceFragment;
      }

      public void a(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        b(paramGeneralPreferenceFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.bj.a.a
    {
      private com.viber.voip.settings.ui.y b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.bj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.settings.ui.y.class.getCanonicalName() + " must be set");
        return new b.eo.d(b.eo.this, this, null);
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        this.b = ((com.viber.voip.settings.ui.y)dagger.a.h.a(paramy));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.bj.a
    {
      private d(b.eo.c arg2)
      {
      }

      private com.viber.voip.settings.ui.y b(com.viber.voip.settings.ui.y paramy)
      {
        com.viber.voip.settings.ui.ab.a(paramy, gg.c());
        com.viber.voip.settings.ui.ab.a(paramy, com.viber.voip.g.a.s.c());
        com.viber.voip.settings.ui.ab.a(paramy, b.this.d());
        return paramy;
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        b(paramy);
      }
    }
  }

  private final class ep extends com.viber.voip.g.a.a.bp.a.a
  {
    private SettingsTabletActivity b;

    private ep()
    {
    }

    public com.viber.voip.g.a.a.bp.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SettingsTabletActivity.class.getCanonicalName() + " must be set");
      return new b.eq(b.this, this, null);
    }

    public void a(SettingsTabletActivity paramSettingsTabletActivity)
    {
      this.b = ((SettingsTabletActivity)dagger.a.h.a(paramSettingsTabletActivity));
    }
  }

  private final class eq
    implements com.viber.voip.g.a.a.bp.a
  {
    private Provider<com.viber.voip.g.a.a.a.bj.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.bi.a.a> c;

    private eq(b.ep arg2)
    {
      b.ep localep;
      a(localep);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.settings.ui.y.class, this.b).a(GeneralPreferenceFragment.class, this.c).a();
    }

    private void a(b.ep paramep)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bj.a.a a()
        {
          return new b.eq.c(b.eq.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.bi.a.a a()
        {
          return new b.eq.a(b.eq.this, null);
        }
      };
    }

    private SettingsTabletActivity b(SettingsTabletActivity paramSettingsTabletActivity)
    {
      ag.a(paramSettingsTabletActivity, b());
      ag.a(paramSettingsTabletActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramSettingsTabletActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SettingsTabletActivity paramSettingsTabletActivity)
    {
      b(paramSettingsTabletActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bi.a.a
    {
      private GeneralPreferenceFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bi.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(GeneralPreferenceFragment.class.getCanonicalName() + " must be set");
        return new b.eq.b(b.eq.this, this, null);
      }

      public void a(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        this.b = ((GeneralPreferenceFragment)dagger.a.h.a(paramGeneralPreferenceFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bi.a
    {
      private b(b.eq.a arg2)
      {
      }

      private GeneralPreferenceFragment b(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        com.viber.voip.settings.ui.p.a(paramGeneralPreferenceFragment, (EventBus)b.M(b.this).get());
        return paramGeneralPreferenceFragment;
      }

      public void a(GeneralPreferenceFragment paramGeneralPreferenceFragment)
      {
        b(paramGeneralPreferenceFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.bj.a.a
    {
      private com.viber.voip.settings.ui.y b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.bj.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.settings.ui.y.class.getCanonicalName() + " must be set");
        return new b.eq.d(b.eq.this, this, null);
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        this.b = ((com.viber.voip.settings.ui.y)dagger.a.h.a(paramy));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.bj.a
    {
      private d(b.eq.c arg2)
      {
      }

      private com.viber.voip.settings.ui.y b(com.viber.voip.settings.ui.y paramy)
      {
        com.viber.voip.settings.ui.ab.a(paramy, gg.c());
        com.viber.voip.settings.ui.ab.a(paramy, com.viber.voip.g.a.s.c());
        com.viber.voip.settings.ui.ab.a(paramy, b.this.d());
        return paramy;
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        b(paramy);
      }
    }
  }

  private final class er extends com.viber.voip.g.a.a.bq.a.a
  {
    private ShareLinkActivity b;

    private er()
    {
    }

    public com.viber.voip.g.a.a.bq.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ShareLinkActivity.class.getCanonicalName() + " must be set");
      return new b.es(b.this, this, null);
    }

    public void a(ShareLinkActivity paramShareLinkActivity)
    {
      this.b = ((ShareLinkActivity)dagger.a.h.a(paramShareLinkActivity));
    }
  }

  private final class es
    implements com.viber.voip.g.a.a.bq.a
  {
    private Provider<com.viber.voip.g.a.a.a.bl.a.a> b;
    private com.viber.voip.messages.conversation.a.e c;
    private com.viber.voip.messages.conversation.a.g d;
    private com.viber.voip.g.a.a.a.bm e;

    private es(b.er arg2)
    {
      b.er localer;
      a(localer);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.ui.forward.sharelink.b.class, this.b).a();
    }

    private void a(b.er paramer)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bl.a.a a()
        {
          return new b.es.a(b.es.this, null);
        }
      };
      this.c = com.viber.voip.messages.conversation.a.e.a(b.ab(b.this), gn.b(), b.I(b.this), b.ac(b.this), b.ad(b.this));
      this.d = com.viber.voip.messages.conversation.a.g.a(b.A(b.this));
      this.e = com.viber.voip.g.a.a.a.bm.a(com.viber.voip.messages.conversation.a.n.b(), this.c, this.d, com.viber.voip.messages.conversation.a.l.b());
    }

    private ShareLinkActivity b(ShareLinkActivity paramShareLinkActivity)
    {
      com.viber.voip.messages.ui.forward.sharelink.e.a(paramShareLinkActivity, b());
      return paramShareLinkActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ShareLinkActivity paramShareLinkActivity)
    {
      b(paramShareLinkActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bl.a.a
    {
      private com.viber.voip.messages.ui.forward.sharelink.b b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bl.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.ui.forward.sharelink.b.class.getCanonicalName() + " must be set");
        return new b.es.b(b.es.this, this, null);
      }

      public void a(com.viber.voip.messages.ui.forward.sharelink.b paramb)
      {
        this.b = ((com.viber.voip.messages.ui.forward.sharelink.b)dagger.a.h.a(paramb));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bl.a
    {
      private b(b.es.a arg2)
      {
      }

      private com.viber.voip.messages.ui.forward.sharelink.b b(com.viber.voip.messages.ui.forward.sharelink.b paramb)
      {
        com.viber.voip.messages.ui.forward.sharelink.c.a(paramb, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.ui.forward.sharelink.c.a(paramb, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.forward.sharelink.c.b(paramb, dagger.a.c.b(b.es.a(b.es.this)));
        com.viber.voip.messages.ui.forward.sharelink.c.c(paramb, dagger.a.c.b(b.A(b.this)));
        com.viber.voip.messages.ui.forward.sharelink.c.a(paramb, b.bi(b.this));
        com.viber.voip.messages.ui.forward.sharelink.c.a(paramb, (com.viber.voip.app.b)b.I(b.this).get());
        return paramb;
      }

      public void a(com.viber.voip.messages.ui.forward.sharelink.b paramb)
      {
        b(paramb);
      }
    }
  }

  private final class et extends com.viber.voip.g.a.a.br.a.a
  {
    private ShareScreenshotActivity b;

    private et()
    {
    }

    public com.viber.voip.g.a.a.br.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ShareScreenshotActivity.class.getCanonicalName() + " must be set");
      return new b.eu(b.this, this, null);
    }

    public void a(ShareScreenshotActivity paramShareScreenshotActivity)
    {
      this.b = ((ShareScreenshotActivity)dagger.a.h.a(paramShareScreenshotActivity));
    }
  }

  private final class eu
    implements com.viber.voip.g.a.a.br.a
  {
    private eu(b.et arg2)
    {
    }

    private ShareScreenshotActivity b(ShareScreenshotActivity paramShareScreenshotActivity)
    {
      com.viber.voip.messages.conversation.ui.bw.a(paramShareScreenshotActivity, (com.viber.voip.messages.k)b.J(b.this).get());
      com.viber.voip.messages.conversation.ui.bw.a(paramShareScreenshotActivity, b.an(b.this));
      com.viber.voip.messages.conversation.ui.bw.a(paramShareScreenshotActivity, gg.c());
      com.viber.voip.messages.conversation.ui.bw.a(paramShareScreenshotActivity, b.Y(b.this));
      com.viber.voip.messages.conversation.ui.bw.a(paramShareScreenshotActivity, (EventBus)b.M(b.this).get());
      return paramShareScreenshotActivity;
    }

    public void a(ShareScreenshotActivity paramShareScreenshotActivity)
    {
      b(paramShareScreenshotActivity);
    }
  }

  private final class ev extends bs.a.a
  {
    private com.viber.voip.messages.shopchat.b b;

    private ev()
    {
    }

    public bs.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.messages.shopchat.b.class.getCanonicalName() + " must be set");
      return new b.ew(b.this, this, null);
    }

    public void a(com.viber.voip.messages.shopchat.b paramb)
    {
      this.b = ((com.viber.voip.messages.shopchat.b)dagger.a.h.a(paramb));
    }
  }

  private final class ew
    implements bs.a
  {
    private ew(b.ev arg2)
    {
    }

    private com.viber.voip.messages.shopchat.b b(com.viber.voip.messages.shopchat.b paramb)
    {
      com.viber.voip.messages.shopchat.e.a(paramb, b.bB(b.this));
      com.viber.voip.messages.shopchat.e.a(paramb, b.G(b.this));
      return paramb;
    }

    public void a(com.viber.voip.messages.shopchat.b paramb)
    {
      b(paramb);
    }
  }

  private final class ex extends com.viber.voip.g.a.a.bt.a.a
  {
    private SmsInboxActivity b;

    private ex()
    {
    }

    public com.viber.voip.g.a.a.bt.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(SmsInboxActivity.class.getCanonicalName() + " must be set");
      return new b.ey(b.this, this, null);
    }

    public void a(SmsInboxActivity paramSmsInboxActivity)
    {
      this.b = ((SmsInboxActivity)dagger.a.h.a(paramSmsInboxActivity));
    }
  }

  private final class ey
    implements com.viber.voip.g.a.a.bt.a
  {
    private Provider<fm.a.a> b;

    private ey(b.ex arg2)
    {
      b.ex localex;
      a(localex);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.vln.ui.a.class, this.b).a();
    }

    private void a(b.ex paramex)
    {
      this.b = new Provider()
      {
        public fm.a.a a()
        {
          return new b.ey.a(b.ey.this, null);
        }
      };
    }

    private SmsInboxActivity b(SmsInboxActivity paramSmsInboxActivity)
    {
      com.viber.voip.ui.e.a(paramSmsInboxActivity, b());
      return paramSmsInboxActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(SmsInboxActivity paramSmsInboxActivity)
    {
      b(paramSmsInboxActivity);
    }

    private final class a extends fm.a.a
    {
      private com.viber.voip.vln.ui.a b;

      private a()
      {
      }

      public fm.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.vln.ui.a.class.getCanonicalName() + " must be set");
        return new b.ey.b(b.ey.this, this, null);
      }

      public void a(com.viber.voip.vln.ui.a parama)
      {
        this.b = ((com.viber.voip.vln.ui.a)dagger.a.h.a(parama));
      }
    }

    private final class b
      implements fm.a
    {
      private b(b.ey.a arg2)
      {
      }

      private com.viber.voip.vln.ui.a b(com.viber.voip.vln.ui.a parama)
      {
        com.viber.voip.messages.ui.i.a(parama, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parama, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parama, dagger.a.c.b(b.af(b.this)));
        com.viber.voip.vln.ui.b.a(parama, dx.c());
        com.viber.voip.vln.ui.b.a(parama, fz.c());
        return parama;
      }

      public void a(com.viber.voip.vln.ui.a parama)
      {
        b(parama);
      }
    }
  }

  private final class ez extends cr.a.a
  {
    private TabletHomeActivity b;

    private ez()
    {
    }

    public cr.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(TabletHomeActivity.class.getCanonicalName() + " must be set");
      return new b.fa(b.this, this, null);
    }

    public void a(TabletHomeActivity paramTabletHomeActivity)
    {
      this.b = ((TabletHomeActivity)dagger.a.h.a(paramTabletHomeActivity));
    }
  }

  private final class f
    implements com.viber.voip.g.a.a.c.a
  {
    private Provider<com.viber.voip.g.a.a.a.ad.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ab.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.ac.a.a> d;

    private f(b.e arg2)
    {
      b.e locale;
      a(locale);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.gallery.selection.t.class, this.b).a(com.viber.voip.gallery.selection.c.class, this.c).a(com.viber.voip.gallery.selection.h.class, this.d).a();
    }

    private void a(b.e parame)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ad.a.a a()
        {
          return new b.f.e(b.f.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ab.a.a a()
        {
          return new b.f.a(b.f.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.ac.a.a a()
        {
          return new b.f.c(b.f.this, null);
        }
      };
    }

    private AddMoreGallery b(AddMoreGallery paramAddMoreGallery)
    {
      com.viber.voip.gallery.selection.z.a(paramAddMoreGallery, b());
      com.viber.voip.gallery.selection.z.a(paramAddMoreGallery, gi.c());
      com.viber.voip.gallery.selection.z.a(paramAddMoreGallery, (com.viber.voip.util.e.g)b.R(b.this).get());
      com.viber.voip.gallery.selection.z.a(paramAddMoreGallery, (com.viber.common.permission.c)b.K(b.this).get());
      return paramAddMoreGallery;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(AddMoreGallery paramAddMoreGallery)
    {
      b(paramAddMoreGallery);
    }

    private final class a extends com.viber.voip.g.a.a.a.ab.a.a
    {
      private com.viber.voip.gallery.selection.c b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ab.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.c.class.getCanonicalName() + " must be set");
        return new b.f.b(b.f.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.c paramc)
      {
        this.b = ((com.viber.voip.gallery.selection.c)dagger.a.h.a(paramc));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ab.a
    {
      private b(b.f.a arg2)
      {
      }

      private com.viber.voip.gallery.selection.c b(com.viber.voip.gallery.selection.c paramc)
      {
        com.viber.voip.gallery.selection.d.a(paramc, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.gallery.selection.d.a(paramc, (com.viber.common.permission.c)b.K(b.this).get());
        return paramc;
      }

      public void a(com.viber.voip.gallery.selection.c paramc)
      {
        b(paramc);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.ac.a.a
    {
      private com.viber.voip.gallery.selection.h b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.ac.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.h.class.getCanonicalName() + " must be set");
        return new b.f.d(b.f.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.h paramh)
      {
        this.b = ((com.viber.voip.gallery.selection.h)dagger.a.h.a(paramh));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.ac.a
    {
      private d(b.f.c arg2)
      {
      }

      private com.viber.voip.gallery.selection.h b(com.viber.voip.gallery.selection.h paramh)
      {
        com.viber.voip.gallery.selection.j.a(paramh, (com.viber.voip.util.e.g)b.R(b.this).get());
        com.viber.voip.gallery.selection.j.a(paramh, (com.viber.common.permission.c)b.K(b.this).get());
        return paramh;
      }

      public void a(com.viber.voip.gallery.selection.h paramh)
      {
        b(paramh);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ad.a.a
    {
      private com.viber.voip.gallery.selection.t b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ad.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.gallery.selection.t.class.getCanonicalName() + " must be set");
        return new b.f.f(b.f.this, this, null);
      }

      public void a(com.viber.voip.gallery.selection.t paramt)
      {
        this.b = ((com.viber.voip.gallery.selection.t)dagger.a.h.a(paramt));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ad.a
    {
      private f(b.f.e arg2)
      {
      }

      public void a(com.viber.voip.gallery.selection.t paramt)
      {
      }
    }
  }

  private final class fa
    implements cr.a
  {
    private Provider<com.viber.voip.g.a.a.a.ag.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.ae.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.af.a.a> d;
    private Provider<com.viber.voip.g.a.a.a.br.a.a> e;
    private Provider<com.viber.voip.g.a.a.a.bn.a.a> f;
    private Provider<com.viber.voip.g.a.a.a.bq.a.a> g;
    private Provider<com.viber.voip.g.a.a.a.bp.a.a> h;
    private Provider<com.viber.voip.g.a.a.a.bo.a.a> i;

    private fa(b.ez arg2)
    {
      b.ez localez;
      a(localez);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(34).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.ui.bn.class, this.b).a(MoreFragment.class, this.c).a(RecentCallsFragment.class, this.d).a(com.viber.voip.settings.ui.y.class, this.e).a(ContactDetailsFragment.class, this.f).a(com.viber.voip.messages.extensions.b.i.class, this.g).a(com.viber.voip.messages.extensions.b.d.class, this.h).a(com.viber.voip.messages.extensions.b.b.class, this.i).a();
    }

    private void a(b.ez paramez)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.ag.a.a a()
        {
          return new b.fa.e(b.fa.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.ae.a.a a()
        {
          return new b.fa.a(b.fa.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.af.a.a a()
        {
          return new b.fa.c(b.fa.this, null);
        }
      };
      this.e = new Provider()
      {
        public com.viber.voip.g.a.a.a.br.a.a a()
        {
          return new b.fa.o(b.fa.this, null);
        }
      };
      this.f = new Provider()
      {
        public com.viber.voip.g.a.a.a.bn.a.a a()
        {
          return new b.fa.m(b.fa.this, null);
        }
      };
      this.g = new Provider()
      {
        public com.viber.voip.g.a.a.a.bq.a.a a()
        {
          return new b.fa.k(b.fa.this, null);
        }
      };
      this.h = new Provider()
      {
        public com.viber.voip.g.a.a.a.bp.a.a a()
        {
          return new b.fa.i(b.fa.this, null);
        }
      };
      this.i = new Provider()
      {
        public com.viber.voip.g.a.a.a.bo.a.a a()
        {
          return new b.fa.g(b.fa.this, null);
        }
      };
    }

    private TabletHomeActivity b(TabletHomeActivity paramTabletHomeActivity)
    {
      com.viber.voip.v.a(paramTabletHomeActivity, b.aY(b.this));
      com.viber.voip.v.a(paramTabletHomeActivity, com.viber.voip.g.a.p.c());
      com.viber.voip.v.a(paramTabletHomeActivity, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.v.a(paramTabletHomeActivity, b());
      com.viber.voip.v.a(paramTabletHomeActivity, (EventBus)b.M(b.this).get());
      com.viber.voip.v.a(paramTabletHomeActivity, (com.viber.voip.bf)b.bk(b.this).get());
      com.viber.voip.v.a(paramTabletHomeActivity, bl.b());
      com.viber.voip.v.a(paramTabletHomeActivity, (com.viber.voip.app.b)b.I(b.this).get());
      com.viber.voip.v.a(paramTabletHomeActivity, b.bl(b.this));
      com.viber.voip.v.a(paramTabletHomeActivity, ey.b());
      com.viber.voip.v.a(paramTabletHomeActivity, dagger.a.c.b(b.bm(b.this)));
      com.viber.voip.v.b(paramTabletHomeActivity, dagger.a.c.b(com.viber.voip.g.a.s.b()));
      com.viber.voip.v.c(paramTabletHomeActivity, dagger.a.c.b(b.bn(b.this)));
      com.viber.voip.v.d(paramTabletHomeActivity, dagger.a.c.b(b.bo(b.this)));
      com.viber.voip.v.e(paramTabletHomeActivity, dagger.a.c.b(b.bp(b.this)));
      com.viber.voip.v.f(paramTabletHomeActivity, dagger.a.c.b(b.bq(b.this)));
      com.viber.voip.v.g(paramTabletHomeActivity, dagger.a.c.b(b.br(b.this)));
      com.viber.voip.v.h(paramTabletHomeActivity, dagger.a.c.b(dx.b()));
      com.viber.voip.v.i(paramTabletHomeActivity, dagger.a.c.b(fz.b()));
      com.viber.voip.v.j(paramTabletHomeActivity, dagger.a.c.b(b.bs(b.this)));
      com.viber.voip.v.k(paramTabletHomeActivity, dagger.a.c.b(b.bt(b.this)));
      com.viber.voip.v.l(paramTabletHomeActivity, dagger.a.c.b(b.bu(b.this)));
      com.viber.voip.v.m(paramTabletHomeActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.v.n(paramTabletHomeActivity, dagger.a.c.b(b.be(b.this)));
      com.viber.voip.v.o(paramTabletHomeActivity, dagger.a.c.b(b.am(b.this)));
      com.viber.voip.v.p(paramTabletHomeActivity, dagger.a.c.b(b.O(b.this)));
      com.viber.voip.v.q(paramTabletHomeActivity, dagger.a.c.b(b.aT(b.this)));
      com.viber.voip.v.r(paramTabletHomeActivity, dagger.a.c.b(b.bv(b.this)));
      com.viber.voip.v.s(paramTabletHomeActivity, dagger.a.c.b(b.aZ(b.this)));
      com.viber.voip.v.t(paramTabletHomeActivity, dagger.a.c.b(b.bc(b.this)));
      com.viber.voip.v.a(paramTabletHomeActivity, b.bw(b.this));
      com.viber.voip.at.a(paramTabletHomeActivity, b.aq(b.this));
      com.viber.voip.at.a(paramTabletHomeActivity, b.an(b.this));
      com.viber.voip.at.a(paramTabletHomeActivity, gu.b());
      com.viber.voip.at.a(paramTabletHomeActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.at.a(paramTabletHomeActivity, b.G(b.this));
      return paramTabletHomeActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(TabletHomeActivity paramTabletHomeActivity)
    {
      b(paramTabletHomeActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.ae.a.a
    {
      private MoreFragment b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.ae.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(MoreFragment.class.getCanonicalName() + " must be set");
        return new b.fa.b(b.fa.this, this, null);
      }

      public void a(MoreFragment paramMoreFragment)
      {
        this.b = ((MoreFragment)dagger.a.h.a(paramMoreFragment));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.ae.a
    {
      private b(b.fa.a arg2)
      {
      }

      private UserInfoRepository a()
      {
        return new UserInfoRepository(b.an(b.this), dagger.a.c.b(b.aU(b.this)));
      }

      private MoreFragment b(MoreFragment paramMoreFragment)
      {
        MoreFragment_MembersInjector.injectMDeviceConfiguration(paramMoreFragment, (com.viber.voip.app.b)b.I(b.this).get());
        MoreFragment_MembersInjector.injectMUserManager(paramMoreFragment, b.an(b.this));
        MoreFragment_MembersInjector.injectMProfileNotification(paramMoreFragment, b.aV(b.this));
        MoreFragment_MembersInjector.injectMRakutenController(paramMoreFragment, ey.b());
        MoreFragment_MembersInjector.injectMPublicAccountAccessibilityController(paramMoreFragment, ew.b());
        MoreFragment_MembersInjector.injectMCdrController(paramMoreFragment, b.this.d());
        MoreFragment_MembersInjector.injectMBadgesManager(paramMoreFragment, gs.c());
        MoreFragment_MembersInjector.injectMNotificationManagerWrapper(paramMoreFragment, dagger.a.c.b(b.aW(b.this)));
        MoreFragment_MembersInjector.injectMPermissionManager(paramMoreFragment, dagger.a.c.b(b.K(b.this)));
        MoreFragment_MembersInjector.injectMVlnReactContextManager(paramMoreFragment, dagger.a.c.b(b.aT(b.this)));
        MoreFragment_MembersInjector.injectMAnalyticsManager(paramMoreFragment, com.viber.voip.g.a.s.c());
        MoreFragment_MembersInjector.injectMOtherEventsTracker(paramMoreFragment, b.Y(b.this));
        MoreFragment_MembersInjector.injectMProfileTracker(paramMoreFragment, b.aX(b.this));
        MoreFragment_MembersInjector.injectMUserInfoRepository(paramMoreFragment, a());
        MoreFragment_MembersInjector.injectMImageFetcher(paramMoreFragment, (com.viber.voip.util.e.e)b.Q(b.this).get());
        MoreFragment_MembersInjector.injectMStickerController(paramMoreFragment, fz.c());
        MoreFragment_MembersInjector.injectMBadgesUpdater(paramMoreFragment, b.aY(b.this));
        MoreFragment_MembersInjector.injectMViberNewsManager(paramMoreFragment, dagger.a.c.b(b.aZ(b.this)));
        return paramMoreFragment;
      }

      public void a(MoreFragment paramMoreFragment)
      {
        b(paramMoreFragment);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.af.a.a
    {
      private RecentCallsFragment b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.af.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(RecentCallsFragment.class.getCanonicalName() + " must be set");
        return new b.fa.d(b.fa.this, this, null);
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        this.b = ((RecentCallsFragment)dagger.a.h.a(paramRecentCallsFragment));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.af.a
    {
      private d(b.fa.c arg2)
      {
      }

      private RecentCallsFragment b(RecentCallsFragment paramRecentCallsFragment)
      {
        com.viber.voip.calls.ui.s.a(paramRecentCallsFragment, dagger.a.c.b(b.be(b.this)));
        com.viber.voip.calls.ui.s.b(paramRecentCallsFragment, dagger.a.c.b(b.O(b.this)));
        return paramRecentCallsFragment;
      }

      public void a(RecentCallsFragment paramRecentCallsFragment)
      {
        b(paramRecentCallsFragment);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.ag.a.a
    {
      private com.viber.voip.messages.ui.bn b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.ag.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.ui.bn.class.getCanonicalName() + " must be set");
        return new b.fa.f(b.fa.this, this, null);
      }

      public void a(com.viber.voip.messages.ui.bn parambn)
      {
        this.b = ((com.viber.voip.messages.ui.bn)dagger.a.h.a(parambn));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.ag.a
    {
      private com.viber.voip.messages.conversation.a.e b;
      private com.viber.voip.messages.conversation.a.g c;
      private com.viber.voip.g.a.a.b.q d;

      private f(b.fa.e arg2)
      {
        b.fa.e locale;
        a(locale);
      }

      private com.viber.voip.messages.j a()
      {
        return new com.viber.voip.messages.j(b.Z(b.this));
      }

      private void a(b.fa.e parame)
      {
        this.b = com.viber.voip.messages.conversation.a.e.a(b.ab(b.this), gn.b(), b.I(b.this), b.ac(b.this), b.ad(b.this));
        this.c = com.viber.voip.messages.conversation.a.g.a(b.A(b.this));
        this.d = com.viber.voip.g.a.a.b.q.a(com.viber.voip.messages.conversation.a.n.b(), this.b, this.c, com.viber.voip.messages.conversation.a.l.b());
      }

      private com.viber.voip.messages.adapters.a.e b()
      {
        return new com.viber.voip.messages.adapters.a.e((com.viber.voip.util.e.e)b.Q(b.this).get(), a(), (com.viber.voip.messages.ui.ai)b.aa(b.this).get(), dx.c());
      }

      private com.viber.voip.messages.ui.bn b(com.viber.voip.messages.ui.bn parambn)
      {
        com.viber.voip.messages.ui.i.a(parambn, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parambn, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parambn, dagger.a.c.b(b.af(b.this)));
        bu.a(parambn, dagger.a.c.b(b.ac(b.this)));
        bu.b(parambn, dagger.a.c.b(b.A(b.this)));
        bu.c(parambn, dagger.a.c.b(b.ag(b.this)));
        bu.d(parambn, dagger.a.c.b(b.ah(b.this)));
        bu.e(parambn, dagger.a.c.b(b.ai(b.this)));
        bu.a(parambn, b.this.d());
        bu.a(parambn, b.aj(b.this));
        bu.a(parambn, b.ak(b.this));
        bu.f(parambn, dagger.a.c.b(com.viber.voip.g.a.s.b()));
        bu.g(parambn, dagger.a.c.b(b.O(b.this)));
        bu.a(parambn, b());
        bu.h(parambn, dagger.a.c.b(b.al(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, dagger.a.c.b(b.bx(b.this)));
        com.viber.voip.messages.ui.bt.b(parambn, dagger.a.c.b(b.by(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, c());
        com.viber.voip.messages.ui.bt.c(parambn, dagger.a.c.b(this.d));
        com.viber.voip.messages.ui.bt.d(parambn, dagger.a.c.b(b.D(b.this)));
        com.viber.voip.messages.ui.bt.a(parambn, (ConversationsScreenScrollCdrController)b.bz(b.this).get());
        com.viber.voip.messages.ui.bt.a(parambn, (com.viber.voip.ads.b.c.b.f)b.bA(b.this).get());
        com.viber.voip.messages.ui.bt.a(parambn, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        return parambn;
      }

      private com.viber.voip.vln.d c()
      {
        return com.viber.voip.g.a.a.b.r.a(b.Z(b.this));
      }

      public void a(com.viber.voip.messages.ui.bn parambn)
      {
        b(parambn);
      }
    }

    private final class g extends com.viber.voip.g.a.a.a.bo.a.a
    {
      private com.viber.voip.messages.extensions.b.b b;

      private g()
      {
      }

      public com.viber.voip.g.a.a.a.bo.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.b.class.getCanonicalName() + " must be set");
        return new b.fa.h(b.fa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        this.b = ((com.viber.voip.messages.extensions.b.b)dagger.a.h.a(paramb));
      }
    }

    private final class h
      implements com.viber.voip.g.a.a.a.bo.a
    {
      private Provider<com.viber.voip.messages.extensions.b.b> b;
      private Provider<ChatExtensionDetailsPresenter> c;

      private h(b.fa.g arg2)
      {
        b.fa.g localg;
        a(localg);
      }

      private void a(b.fa.g paramg)
      {
        this.b = dagger.a.e.a(b.fa.g.a(paramg));
        this.c = dagger.a.c.a(com.viber.voip.g.a.a.b.b.a(this.b, b.ao(b.this), b.at(b.this), b.K(b.this), b.af(b.this), b.I(b.this), du.b(), b.ax(b.this)));
      }

      private com.viber.voip.messages.extensions.b.b b(com.viber.voip.messages.extensions.b.b paramb)
      {
        com.viber.voip.messages.extensions.b.c.a(paramb, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.c.a(paramb, (ChatExtensionDetailsPresenter)this.c.get());
        return paramb;
      }

      public void a(com.viber.voip.messages.extensions.b.b paramb)
      {
        b(paramb);
      }
    }

    private final class i extends com.viber.voip.g.a.a.a.bp.a.a
    {
      private com.viber.voip.messages.extensions.b.d b;

      private i()
      {
      }

      public com.viber.voip.g.a.a.a.bp.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.d.class.getCanonicalName() + " must be set");
        return new b.fa.j(b.fa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        this.b = ((com.viber.voip.messages.extensions.b.d)dagger.a.h.a(paramd));
      }
    }

    private final class j
      implements com.viber.voip.g.a.a.a.bp.a
    {
      private j(b.fa.i arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.d b(com.viber.voip.messages.extensions.b.d paramd)
      {
        com.viber.voip.messages.extensions.b.h.a(paramd, dagger.a.c.b(dt.b()));
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.b.f)b.av(b.this).get());
        com.viber.voip.messages.extensions.b.h.a(paramd, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        return paramd;
      }

      public void a(com.viber.voip.messages.extensions.b.d paramd)
      {
        b(paramd);
      }
    }

    private final class k extends com.viber.voip.g.a.a.a.bq.a.a
    {
      private com.viber.voip.messages.extensions.b.i b;

      private k()
      {
      }

      public com.viber.voip.g.a.a.a.bq.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.extensions.b.i.class.getCanonicalName() + " must be set");
        return new b.fa.l(b.fa.this, this, null);
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        this.b = ((com.viber.voip.messages.extensions.b.i)dagger.a.h.a(parami));
      }
    }

    private final class l
      implements com.viber.voip.g.a.a.a.bq.a
    {
      private l(b.fa.k arg2)
      {
      }

      private com.viber.voip.messages.extensions.b.i b(com.viber.voip.messages.extensions.b.i parami)
      {
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (com.viber.voip.messages.extensions.a)b.at(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, (EventBus)b.M(b.this).get());
        com.viber.voip.messages.extensions.b.l.a(parami, gn.c());
        com.viber.voip.messages.extensions.b.l.a(parami, b.au(b.this));
        return parami;
      }

      public void a(com.viber.voip.messages.extensions.b.i parami)
      {
        b(parami);
      }
    }

    private final class m extends com.viber.voip.g.a.a.a.bn.a.a
    {
      private ContactDetailsFragment b;

      private m()
      {
      }

      public com.viber.voip.g.a.a.a.bn.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(ContactDetailsFragment.class.getCanonicalName() + " must be set");
        return new b.fa.n(b.fa.this, this, null);
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        this.b = ((ContactDetailsFragment)dagger.a.h.a(paramContactDetailsFragment));
      }
    }

    private final class n
      implements com.viber.voip.g.a.a.a.bn.a
    {
      private n(b.fa.m arg2)
      {
      }

      private ContactDetailsFragment b(ContactDetailsFragment paramContactDetailsFragment)
      {
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, com.viber.voip.g.a.s.c());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, (com.viber.voip.app.b)b.I(b.this).get());
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aQ(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.V(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, dagger.a.c.b(b.aR(b.this)));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.U(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.W(b.this));
        com.viber.voip.contacts.ui.k.a(paramContactDetailsFragment, b.aS(b.this));
        return paramContactDetailsFragment;
      }

      public void a(ContactDetailsFragment paramContactDetailsFragment)
      {
        b(paramContactDetailsFragment);
      }
    }

    private final class o extends com.viber.voip.g.a.a.a.br.a.a
    {
      private com.viber.voip.settings.ui.y b;

      private o()
      {
      }

      public com.viber.voip.g.a.a.a.br.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.settings.ui.y.class.getCanonicalName() + " must be set");
        return new b.fa.p(b.fa.this, this, null);
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        this.b = ((com.viber.voip.settings.ui.y)dagger.a.h.a(paramy));
      }
    }

    private final class p
      implements com.viber.voip.g.a.a.a.br.a
    {
      private p(b.fa.o arg2)
      {
      }

      private com.viber.voip.settings.ui.y b(com.viber.voip.settings.ui.y paramy)
      {
        com.viber.voip.settings.ui.ab.a(paramy, gg.c());
        com.viber.voip.settings.ui.ab.a(paramy, com.viber.voip.g.a.s.c());
        com.viber.voip.settings.ui.ab.a(paramy, b.this.d());
        return paramy;
      }

      public void a(com.viber.voip.settings.ui.y paramy)
      {
        b(paramy);
      }
    }
  }

  private final class fb extends com.viber.voip.g.a.a.bu.a.a
  {
    private TabletPublicGroupConversationFragment b;

    private fb()
    {
    }

    public com.viber.voip.g.a.a.bu.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(TabletPublicGroupConversationFragment.class.getCanonicalName() + " must be set");
      return new b.fc(b.this, this, null);
    }

    public void a(TabletPublicGroupConversationFragment paramTabletPublicGroupConversationFragment)
    {
      this.b = ((TabletPublicGroupConversationFragment)dagger.a.h.a(paramTabletPublicGroupConversationFragment));
    }
  }

  private final class fc
    implements com.viber.voip.g.a.a.bu.a
  {
    private fc(b.fb arg2)
    {
    }

    private TabletPublicGroupConversationFragment b(TabletPublicGroupConversationFragment paramTabletPublicGroupConversationFragment)
    {
      aw.a(paramTabletPublicGroupConversationFragment, fx.b());
      aw.a(paramTabletPublicGroupConversationFragment, b.bM(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.bN(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, fz.c());
      aw.a(paramTabletPublicGroupConversationFragment, ck.c());
      aw.a(paramTabletPublicGroupConversationFragment, b.bO(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.bP(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, com.viber.voip.g.a.s.c());
      aw.a(paramTabletPublicGroupConversationFragment, b.X(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.P(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.ak(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.aj(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.bQ(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.bR(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, dx.c());
      aw.a(paramTabletPublicGroupConversationFragment, b.N(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.aq(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.ar(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, (com.viber.voip.app.b)b.I(b.this).get());
      aw.a(paramTabletPublicGroupConversationFragment, b.L(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.U(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.bg(b.this));
      aw.a(paramTabletPublicGroupConversationFragment, b.this.d());
      aw.a(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.J(b.this)));
      aw.b(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.af(b.this)));
      aw.a(paramTabletPublicGroupConversationFragment, com.viber.voip.g.a.p.c());
      aw.a(paramTabletPublicGroupConversationFragment, du.c());
      aw.a(paramTabletPublicGroupConversationFragment, (com.viber.common.permission.c)b.K(b.this).get());
      aw.a(paramTabletPublicGroupConversationFragment, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      aw.c(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.O(b.this)));
      aw.a(paramTabletPublicGroupConversationFragment, b.an(b.this));
      aw.d(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.T(b.this)));
      aw.a(paramTabletPublicGroupConversationFragment, (com.viber.voip.messages.extensions.i)b.bS(b.this).get());
      aw.e(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.aW(b.this)));
      aw.a(paramTabletPublicGroupConversationFragment, (EventBus)b.M(b.this).get());
      aw.a(paramTabletPublicGroupConversationFragment, (com.viber.voip.util.e.g)b.R(b.this).get());
      aw.f(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.bT(b.this)));
      aw.g(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.al(b.this)));
      aw.h(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.A(b.this)));
      aw.a(paramTabletPublicGroupConversationFragment, b.V(b.this));
      aw.i(paramTabletPublicGroupConversationFragment, dagger.a.c.b(b.ai(b.this)));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramTabletPublicGroupConversationFragment, b.aq(b.this));
      com.viber.voip.messages.conversation.publicaccount.m.a(paramTabletPublicGroupConversationFragment, b.aj(b.this));
      return paramTabletPublicGroupConversationFragment;
    }

    public void a(TabletPublicGroupConversationFragment paramTabletPublicGroupConversationFragment)
    {
      b(paramTabletPublicGroupConversationFragment);
    }
  }

  private final class fd extends bv.a.a
  {
    private VOPurchaseDialogActivity b;

    private fd()
    {
    }

    public bv.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(VOPurchaseDialogActivity.class.getCanonicalName() + " must be set");
      return new b.fe(b.this, this, null);
    }

    public void a(VOPurchaseDialogActivity paramVOPurchaseDialogActivity)
    {
      this.b = ((VOPurchaseDialogActivity)dagger.a.h.a(paramVOPurchaseDialogActivity));
    }
  }

  private final class fe
    implements bv.a
  {
    private fe(b.fd arg2)
    {
    }

    private VOPurchaseDialogActivity b(VOPurchaseDialogActivity paramVOPurchaseDialogActivity)
    {
      com.viber.voip.market.m.a(paramVOPurchaseDialogActivity, dagger.a.c.b(b.aL(b.this)));
      return paramVOPurchaseDialogActivity;
    }

    public void a(VOPurchaseDialogActivity paramVOPurchaseDialogActivity)
    {
      b(paramVOPurchaseDialogActivity);
    }
  }

  private final class ff extends bw.a.a
  {
    private ViberConnectActivity b;

    private ff()
    {
    }

    public bw.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberConnectActivity.class.getCanonicalName() + " must be set");
      return new b.fg(b.this, this, null);
    }

    public void a(ViberConnectActivity paramViberConnectActivity)
    {
      this.b = ((ViberConnectActivity)dagger.a.h.a(paramViberConnectActivity));
    }
  }

  private final class fg
    implements bw.a
  {
    private fg(b.ff arg2)
    {
    }

    public void a(ViberConnectActivity paramViberConnectActivity)
    {
    }
  }

  private final class fh extends by.a.a
  {
    private ViberNewsArticleBrowserActivity b;

    private fh()
    {
    }

    public by.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberNewsArticleBrowserActivity.class.getCanonicalName() + " must be set");
      return new b.fi(b.this, this, null);
    }

    public void a(ViberNewsArticleBrowserActivity paramViberNewsArticleBrowserActivity)
    {
      this.b = ((ViberNewsArticleBrowserActivity)dagger.a.h.a(paramViberNewsArticleBrowserActivity));
    }
  }

  private final class fi
    implements by.a
  {
    private fi(b.fh arg2)
    {
    }

    private ViberNewsArticleBrowserActivity b(ViberNewsArticleBrowserActivity paramViberNewsArticleBrowserActivity)
    {
      com.viber.voip.messages.extensions.activity.g.a(paramViberNewsArticleBrowserActivity, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      com.viber.voip.messages.extensions.activity.g.a(paramViberNewsArticleBrowserActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.extensions.activity.g.a(paramViberNewsArticleBrowserActivity, gm.c());
      com.viber.voip.news.p.a(paramViberNewsArticleBrowserActivity, (com.viber.voip.util.i.a)b.bh(b.this).get());
      com.viber.voip.news.p.a(paramViberNewsArticleBrowserActivity, dagger.a.c.b(b.bc(b.this)));
      com.viber.voip.news.p.b(paramViberNewsArticleBrowserActivity, dagger.a.c.b(b.am(b.this)));
      return paramViberNewsArticleBrowserActivity;
    }

    public void a(ViberNewsArticleBrowserActivity paramViberNewsArticleBrowserActivity)
    {
      b(paramViberNewsArticleBrowserActivity);
    }
  }

  private final class fj extends com.viber.voip.g.a.a.bx.a.a
  {
    private ViberNewsWebActivity b;

    private fj()
    {
    }

    public com.viber.voip.g.a.a.bx.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberNewsWebActivity.class.getCanonicalName() + " must be set");
      return new b.fk(b.this, this, null);
    }

    public void a(ViberNewsWebActivity paramViberNewsWebActivity)
    {
      this.b = ((ViberNewsWebActivity)dagger.a.h.a(paramViberNewsWebActivity));
    }
  }

  private final class fk
    implements com.viber.voip.g.a.a.bx.a
  {
    private fk(b.fj arg2)
    {
    }

    public void a(ViberNewsWebActivity paramViberNewsWebActivity)
    {
    }
  }

  private final class fl extends com.viber.voip.g.a.a.ab.a.a
  {
    private ViberOutCountryPlansActivity b;

    private fl()
    {
    }

    public com.viber.voip.g.a.a.ab.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberOutCountryPlansActivity.class.getCanonicalName() + " must be set");
      return new b.fm(b.this, this, null);
    }

    public void a(ViberOutCountryPlansActivity paramViberOutCountryPlansActivity)
    {
      this.b = ((ViberOutCountryPlansActivity)dagger.a.h.a(paramViberOutCountryPlansActivity));
    }
  }

  private final class fm
    implements com.viber.voip.g.a.a.ab.a
  {
    private Provider<com.viber.voip.g.a.a.a.w.a.a> b;
    private com.viber.voip.viberout.a.d c;
    private com.viber.voip.g.a.a.a.x d;
    private Provider<com.viber.voip.viberout.a.t> e;
    private com.viber.voip.util.ad f;
    private com.viber.voip.viberout.ui.products.b g;
    private com.viber.voip.viberout.ui.products.model.e h;
    private Provider<com.viber.voip.viberout.a.n> i;
    private Provider<ViberOutCountrySearchPresenter> j;

    private fm(b.fl arg2)
    {
      b.fl localfl;
      a(localfl);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.viberout.ui.products.countryplans.c.class, this.b).a();
    }

    private void a(b.fl paramfl)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.w.a.a a()
        {
          return new b.fm.a(b.fm.this, null);
        }
      };
      this.c = com.viber.voip.viberout.a.d.a(b.aD(b.this), b.aE(b.this), b.aF(b.this));
      this.d = com.viber.voip.g.a.a.a.x.a(b.aG(b.this), b.aH(b.this), this.c);
      this.e = dagger.a.c.a(com.viber.voip.viberout.a.y.a(gg.b(), gn.b(), b.aI(b.this), b.aH(b.this), hh.b(), this.d, b.aJ(b.this)));
      this.f = com.viber.voip.util.ad.a(b.aJ(b.this));
      this.g = com.viber.voip.viberout.ui.products.b.a(this.f);
      this.h = com.viber.voip.viberout.ui.products.model.e.a(b.aJ(b.this), this.g);
      this.i = dagger.a.c.a(com.viber.voip.viberout.a.o.a(this.e, this.h));
      this.j = dagger.a.c.a(com.viber.voip.viberout.ui.products.search.country.m.a(this.i, gn.b()));
    }

    private ViberOutCountryPlansActivity b(ViberOutCountryPlansActivity paramViberOutCountryPlansActivity)
    {
      com.viber.voip.viberout.ui.products.countryplans.b.a(paramViberOutCountryPlansActivity, b());
      com.viber.voip.viberout.ui.products.countryplans.b.a(paramViberOutCountryPlansActivity, (ViberOutCountrySearchPresenter)this.j.get());
      return paramViberOutCountryPlansActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    private com.viber.voip.util.ac c()
    {
      return new com.viber.voip.util.ac(b.az(b.this));
    }

    private com.viber.voip.viberout.ui.products.a d()
    {
      return new com.viber.voip.viberout.ui.products.a(c());
    }

    private com.viber.voip.viberout.ui.products.model.a e()
    {
      return new com.viber.voip.viberout.ui.products.model.a(b.az(b.this), d());
    }

    public void a(ViberOutCountryPlansActivity paramViberOutCountryPlansActivity)
    {
      b(paramViberOutCountryPlansActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.w.a.a
    {
      private com.viber.voip.viberout.ui.products.countryplans.c b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.w.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.viberout.ui.products.countryplans.c.class.getCanonicalName() + " must be set");
        return new b.fm.b(b.fm.this, this, null);
      }

      public void a(com.viber.voip.viberout.ui.products.countryplans.c paramc)
      {
        this.b = ((com.viber.voip.viberout.ui.products.countryplans.c)dagger.a.h.a(paramc));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.w.a
    {
      private b(b.fm.a arg2)
      {
      }

      private com.viber.voip.viberout.a.i a()
      {
        return new com.viber.voip.viberout.a.i((com.viber.voip.viberout.a.t)b.fm.a(b.fm.this).get(), b.fm.b(b.fm.this), (com.viber.voip.viberout.a.l)b.aA(b.this).get());
      }

      private com.viber.voip.viberout.a.e b()
      {
        return new com.viber.voip.viberout.a.e(b.aM(b.this), gn.c());
      }

      private com.viber.voip.viberout.ui.products.countryplans.c b(com.viber.voip.viberout.ui.products.countryplans.c paramc)
      {
        com.viber.voip.viberout.ui.products.countryplans.d.a(paramc, com.viber.voip.g.a.s.c());
        com.viber.voip.viberout.ui.products.countryplans.d.a(paramc, c());
        return paramc;
      }

      private ViberOutCountryPlansInfoPresenter c()
      {
        return new ViberOutCountryPlansInfoPresenter(a(), b(), b.aC(b.this));
      }

      public void a(com.viber.voip.viberout.ui.products.countryplans.c paramc)
      {
        b(paramc);
      }
    }
  }

  private final class fn extends bz.a.a
  {
    private ViberOutProductsActivity b;

    private fn()
    {
    }

    public bz.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberOutProductsActivity.class.getCanonicalName() + " must be set");
      return new b.fo(b.this, this, null);
    }

    public void a(ViberOutProductsActivity paramViberOutProductsActivity)
    {
      this.b = ((ViberOutProductsActivity)dagger.a.h.a(paramViberOutProductsActivity));
    }
  }

  private final class fo
    implements bz.a
  {
    private Provider<com.viber.voip.g.a.a.a.bu.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.bt.a.a> c;
    private com.viber.voip.viberout.a.d d;
    private com.viber.voip.g.a.a.a.bv e;
    private Provider<com.viber.voip.viberout.a.t> f;
    private Provider<com.viber.voip.viberout.a.r> g;
    private com.viber.voip.util.ad h;
    private com.viber.voip.viberout.ui.products.b i;
    private com.viber.voip.viberout.ui.products.account.d j;
    private Provider<com.viber.voip.viberout.a.g> k;
    private com.viber.voip.viberout.ui.products.model.e l;
    private Provider<com.viber.voip.viberout.a.n> m;
    private Provider<ViberOutCountrySearchPresenter> n;
    private com.viber.voip.viberout.a.q o;
    private com.viber.voip.viberout.a.k p;

    private fo(b.fn arg2)
    {
      b.fn localfn;
      a(localfn);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(28).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.viberout.ui.products.plans.i.class, this.b).a(com.viber.voip.viberout.ui.products.credits.d.class, this.c).a();
    }

    private void a(b.fn paramfn)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bu.a.a a()
        {
          return new b.fo.c(b.fo.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.bt.a.a a()
        {
          return new b.fo.a(b.fo.this, null);
        }
      };
      this.d = com.viber.voip.viberout.a.d.a(b.aD(b.this), b.aE(b.this), b.aF(b.this));
      this.e = com.viber.voip.g.a.a.a.bv.a(b.aG(b.this), b.aH(b.this), this.d);
      this.f = dagger.a.c.a(com.viber.voip.viberout.a.y.a(gg.b(), gn.b(), b.aI(b.this), b.aH(b.this), hh.b(), this.e, b.aJ(b.this)));
      this.g = dagger.a.c.a(com.viber.voip.viberout.a.s.a(this.f));
      this.h = com.viber.voip.util.ad.a(b.aJ(b.this));
      this.i = com.viber.voip.viberout.ui.products.b.a(this.h);
      this.j = com.viber.voip.viberout.ui.products.account.d.a(b.aJ(b.this), this.i);
      this.k = dagger.a.c.a(com.viber.voip.viberout.a.h.a(this.f, this.j));
      this.l = com.viber.voip.viberout.ui.products.model.e.a(b.aJ(b.this), this.i);
      this.m = dagger.a.c.a(com.viber.voip.viberout.a.o.a(this.f, this.l));
      this.n = dagger.a.c.a(com.viber.voip.viberout.ui.products.search.country.m.a(this.m, gn.b()));
      this.o = com.viber.voip.viberout.a.q.a(this.g, this.l);
      this.p = com.viber.voip.viberout.a.k.a(this.g, this.l, b.aA(b.this));
    }

    private ViberOutProductsActivity b(ViberOutProductsActivity paramViberOutProductsActivity)
    {
      com.viber.voip.viberout.ui.products.f.a(paramViberOutProductsActivity, b());
      com.viber.voip.viberout.ui.products.f.a(paramViberOutProductsActivity, h());
      com.viber.voip.viberout.ui.products.f.a(paramViberOutProductsActivity, (ViberOutCountrySearchPresenter)this.n.get());
      com.viber.voip.viberout.ui.products.f.a(paramViberOutProductsActivity, com.viber.voip.g.a.s.c());
      com.viber.voip.viberout.ui.products.f.a(paramViberOutProductsActivity, (com.viber.voip.app.b)b.I(b.this).get());
      return paramViberOutProductsActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    private com.viber.voip.util.ac c()
    {
      return new com.viber.voip.util.ac(b.az(b.this));
    }

    private com.viber.voip.viberout.ui.products.a d()
    {
      return new com.viber.voip.viberout.ui.products.a(c());
    }

    private com.viber.voip.viberout.ui.products.model.a e()
    {
      return new com.viber.voip.viberout.ui.products.model.a(b.az(b.this), d());
    }

    private com.viber.voip.viberout.a.p f()
    {
      return new com.viber.voip.viberout.a.p((com.viber.voip.viberout.a.r)this.g.get(), e());
    }

    private com.viber.voip.viberout.a.j g()
    {
      return new com.viber.voip.viberout.a.j((com.viber.voip.viberout.a.r)this.g.get(), e(), (com.viber.voip.viberout.a.l)b.aA(b.this).get());
    }

    private ViberOutProductsPresenter h()
    {
      return com.viber.voip.g.a.a.a.bw.a(f(), g(), (com.viber.voip.viberout.a.g)this.k.get(), b.aB(b.this), (com.viber.voip.viberout.a.l)b.aA(b.this).get(), b.this.d(), b.aC(b.this));
    }

    public void a(ViberOutProductsActivity paramViberOutProductsActivity)
    {
      b(paramViberOutProductsActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bt.a.a
    {
      private com.viber.voip.viberout.ui.products.credits.d b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bt.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.viberout.ui.products.credits.d.class.getCanonicalName() + " must be set");
        return new b.fo.b(b.fo.this, this, null);
      }

      public void a(com.viber.voip.viberout.ui.products.credits.d paramd)
      {
        this.b = ((com.viber.voip.viberout.ui.products.credits.d)dagger.a.h.a(paramd));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bt.a
    {
      private Provider b;
      private com.viber.voip.viberout.a.f c;
      private Provider<ViberOutAccountPresenter> d;

      private b(b.fo.a arg2)
      {
        b.fo.a locala;
        a(locala);
      }

      private void a(b.fo.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.viberout.ui.products.credits.h.a(b.fo.c(b.fo.this), b.fo.b(b.fo.this), b.aL(b.this)));
        this.c = com.viber.voip.viberout.a.f.a(b.aK(b.this), gn.b());
        this.d = dagger.a.c.a(com.viber.voip.viberout.ui.products.account.g.a(b.fo.b(b.fo.this), this.c, b.aL(b.this)));
      }

      private com.viber.voip.viberout.ui.products.credits.d b(com.viber.voip.viberout.ui.products.credits.d paramd)
      {
        com.viber.voip.viberout.ui.products.credits.e.a(paramd, this.b.get());
        com.viber.voip.viberout.ui.products.credits.e.a(paramd, (ViberOutAccountPresenter)this.d.get());
        com.viber.voip.viberout.ui.products.credits.e.a(paramd, com.viber.voip.g.a.s.c());
        com.viber.voip.viberout.ui.products.credits.e.a(paramd, new ViberOutCouponPresenter());
        return paramd;
      }

      public void a(com.viber.voip.viberout.ui.products.credits.d paramd)
      {
        b(paramd);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.bu.a.a
    {
      private com.viber.voip.viberout.ui.products.plans.i b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.bu.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.viberout.ui.products.plans.i.class.getCanonicalName() + " must be set");
        return new b.fo.d(b.fo.this, this, null);
      }

      public void a(com.viber.voip.viberout.ui.products.plans.i parami)
      {
        this.b = ((com.viber.voip.viberout.ui.products.plans.i)dagger.a.h.a(parami));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.bu.a
    {
      private com.viber.voip.viberout.a.f b;
      private Provider c;
      private Provider<ViberOutAccountPresenter> d;

      private d(b.fo.c arg2)
      {
        b.fo.c localc;
        a(localc);
      }

      private void a(b.fo.c paramc)
      {
        this.b = com.viber.voip.viberout.a.f.a(b.aK(b.this), gn.b());
        this.c = dagger.a.c.a(com.viber.voip.viberout.ui.products.plans.m.a(b.fo.a(b.fo.this), this.b, b.fo.b(b.fo.this), com.viber.voip.g.a.s.b()));
        this.d = dagger.a.c.a(com.viber.voip.viberout.ui.products.account.g.a(b.fo.b(b.fo.this), this.b, b.aL(b.this)));
      }

      private com.viber.voip.viberout.ui.products.plans.i b(com.viber.voip.viberout.ui.products.plans.i parami)
      {
        com.viber.voip.viberout.ui.products.plans.j.a(parami, this.c.get());
        com.viber.voip.viberout.ui.products.plans.j.a(parami, (ViberOutAccountPresenter)this.d.get());
        com.viber.voip.viberout.ui.products.plans.j.a(parami, com.viber.voip.g.a.s.c());
        com.viber.voip.viberout.ui.products.plans.j.a(parami, new ViberOutCouponPresenter());
        return parami;
      }

      public void a(com.viber.voip.viberout.ui.products.plans.i parami)
      {
        b(parami);
      }
    }
  }

  private final class fp extends ca.a.a
  {
    private ViberPhoneService b;

    private fp()
    {
    }

    public ca.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberPhoneService.class.getCanonicalName() + " must be set");
      return new b.fq(b.this, this, null);
    }

    public void a(ViberPhoneService paramViberPhoneService)
    {
      this.b = ((ViberPhoneService)dagger.a.h.a(paramViberPhoneService));
    }
  }

  private final class fq
    implements ca.a
  {
    private fq(b.fp arg2)
    {
    }

    private ViberPhoneService b(ViberPhoneService paramViberPhoneService)
    {
      com.viber.service.f.a(paramViberPhoneService, dagger.a.c.b(b.ac(b.this)));
      com.viber.service.f.b(paramViberPhoneService, dagger.a.c.b(b.aR(b.this)));
      return paramViberPhoneService;
    }

    public void a(ViberPhoneService paramViberPhoneService)
    {
      b(paramViberPhoneService);
    }
  }

  private final class fr extends cb.a.a
  {
    private ViberReactActivity b;

    private fr()
    {
    }

    public cb.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViberReactActivity.class.getCanonicalName() + " must be set");
      return new b.fs(b.this, this, null);
    }

    public void a(ViberReactActivity paramViberReactActivity)
    {
      this.b = ((ViberReactActivity)dagger.a.h.a(paramViberReactActivity));
    }
  }

  private final class fs
    implements cb.a
  {
    private fs(b.fr arg2)
    {
    }

    private ViberReactActivity b(ViberReactActivity paramViberReactActivity)
    {
      com.viber.voip.react.h.a(paramViberReactActivity, b.bb(b.this));
      return paramViberReactActivity;
    }

    public void a(ViberReactActivity paramViberReactActivity)
    {
      b(paramViberReactActivity);
    }
  }

  private final class ft extends cc.a.a
  {
    private ViewMediaActivity b;

    private ft()
    {
    }

    public cc.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViewMediaActivity.class.getCanonicalName() + " must be set");
      return new b.fu(b.this, this, null);
    }

    public void a(ViewMediaActivity paramViewMediaActivity)
    {
      this.b = ((ViewMediaActivity)dagger.a.h.a(paramViewMediaActivity));
    }
  }

  private final class fu
    implements cc.a
  {
    private fu(b.ft arg2)
    {
    }

    private ViewMediaActivity b(ViewMediaActivity paramViewMediaActivity)
    {
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, b.L(b.this));
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, dx.c());
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, b.aq(b.this));
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, b.ar(b.this));
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, b.as(b.this));
      com.viber.voip.messages.ui.media.j.a(paramViewMediaActivity, b.bj(b.this));
      return paramViewMediaActivity;
    }

    public void a(ViewMediaActivity paramViewMediaActivity)
    {
      b(paramViewMediaActivity);
    }
  }

  private final class fv extends cd.a.a
  {
    private ViewMediaSimpleActivity b;

    private fv()
    {
    }

    public cd.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ViewMediaSimpleActivity.class.getCanonicalName() + " must be set");
      return new b.fw(b.this, this, null);
    }

    public void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity)
    {
      this.b = ((ViewMediaSimpleActivity)dagger.a.h.a(paramViewMediaSimpleActivity));
    }
  }

  private final class fw
    implements cd.a
  {
    private fw(b.fv arg2)
    {
    }

    private ViewMediaSimpleActivity b(ViewMediaSimpleActivity paramViewMediaSimpleActivity)
    {
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, b.ap(b.this));
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, b.aq(b.this));
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, b.ar(b.this));
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, b.as(b.this));
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.ui.media.simple.d.a(paramViewMediaSimpleActivity, gm.c());
      return paramViewMediaSimpleActivity;
    }

    public void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity)
    {
      b(paramViewMediaSimpleActivity);
    }
  }

  private final class fx extends com.viber.voip.g.a.a.bg.a.a
  {
    private VlnActivity b;

    private fx()
    {
    }

    public com.viber.voip.g.a.a.bg.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(VlnActivity.class.getCanonicalName() + " must be set");
      return new b.fy(b.this, this, null);
    }

    public void a(VlnActivity paramVlnActivity)
    {
      this.b = ((VlnActivity)dagger.a.h.a(paramVlnActivity));
    }
  }

  private final class fy
    implements com.viber.voip.g.a.a.bg.a
  {
    private fy(b.fx arg2)
    {
    }

    private VlnActivity b(VlnActivity paramVlnActivity)
    {
      com.viber.voip.react.h.a(paramVlnActivity, b.bb(b.this));
      com.viber.voip.vln.c.a(paramVlnActivity, b.bb(b.this));
      com.viber.voip.vln.c.a(paramVlnActivity, dagger.a.c.b(b.bc(b.this)));
      return paramVlnActivity;
    }

    public void a(VlnActivity paramVlnActivity)
    {
      b(paramVlnActivity);
    }
  }

  private final class fz extends ce.a.a
  {
    private VoteActivity b;

    private fz()
    {
    }

    public ce.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(VoteActivity.class.getCanonicalName() + " must be set");
      return new b.ga(b.this, this, null);
    }

    public void a(VoteActivity paramVoteActivity)
    {
      this.b = ((VoteActivity)dagger.a.h.a(paramVoteActivity));
    }
  }

  private final class g extends com.viber.voip.g.a.a.d.a.a
  {
    private com.viber.voip.gdpr.ui.iabconsent.a b;

    private g()
    {
    }

    public com.viber.voip.g.a.a.d.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.gdpr.ui.iabconsent.a.class.getCanonicalName() + " must be set");
      return new b.h(b.this, this, null);
    }

    public void a(com.viber.voip.gdpr.ui.iabconsent.a parama)
    {
      this.b = ((com.viber.voip.gdpr.ui.iabconsent.a)dagger.a.h.a(parama));
    }
  }

  private final class ga
    implements ce.a
  {
    private Provider<com.viber.voip.g.a.a.a.bx.a.a> b;

    private ga(b.fz arg2)
    {
      b.fz localfz;
      a(localfz);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.messages.conversation.ui.vote.d.class, this.b).a();
    }

    private void a(b.fz paramfz)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.bx.a.a a()
        {
          return new b.ga.a(b.ga.this, null);
        }
      };
    }

    private VoteActivity b(VoteActivity paramVoteActivity)
    {
      com.viber.voip.messages.conversation.ui.vote.c.a(paramVoteActivity, b());
      return paramVoteActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(VoteActivity paramVoteActivity)
    {
      b(paramVoteActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.bx.a.a
    {
      private com.viber.voip.messages.conversation.ui.vote.d b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.bx.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.messages.conversation.ui.vote.d.class.getCanonicalName() + " must be set");
        return new b.ga.b(b.ga.this, this, null);
      }

      public void a(com.viber.voip.messages.conversation.ui.vote.d paramd)
      {
        this.b = ((com.viber.voip.messages.conversation.ui.vote.d)dagger.a.h.a(paramd));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.bx.a
    {
      private Provider<VotePresenter> b;

      private b(b.ga.a arg2)
      {
        b.ga.a locala;
        a(locala);
      }

      private void a(b.ga.a parama)
      {
        this.b = dagger.a.c.a(com.viber.voip.messages.conversation.ui.vote.r.a(b.J(b.this), b.D(b.this)));
      }

      private com.viber.voip.messages.conversation.ui.vote.d b(com.viber.voip.messages.conversation.ui.vote.d paramd)
      {
        com.viber.voip.messages.conversation.ui.vote.e.a(paramd, (VotePresenter)this.b.get());
        return paramd;
      }

      public void a(com.viber.voip.messages.conversation.ui.vote.d paramd)
      {
        b(paramd);
      }
    }
  }

  private final class gb extends cf.a.a
  {
    private WinkViewMediaActivity b;

    private gb()
    {
    }

    public cf.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(WinkViewMediaActivity.class.getCanonicalName() + " must be set");
      return new b.gc(b.this, this, null);
    }

    public void a(WinkViewMediaActivity paramWinkViewMediaActivity)
    {
      this.b = ((WinkViewMediaActivity)dagger.a.h.a(paramWinkViewMediaActivity));
    }
  }

  private final class gc
    implements cf.a
  {
    private gc(b.gb arg2)
    {
    }

    private WinkViewMediaActivity b(WinkViewMediaActivity paramWinkViewMediaActivity)
    {
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, b.L(b.this));
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, dx.c());
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, (com.viber.common.permission.c)b.K(b.this).get());
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, b.aq(b.this));
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, b.ar(b.this));
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, dagger.a.c.b(b.J(b.this)));
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, b.as(b.this));
      com.viber.voip.messages.ui.media.j.a(paramWinkViewMediaActivity, b.bj(b.this));
      return paramWinkViewMediaActivity;
    }

    public void a(WinkViewMediaActivity paramWinkViewMediaActivity)
    {
      b(paramWinkViewMediaActivity);
    }
  }

  private final class h
    implements com.viber.voip.g.a.a.d.a
  {
    private h(b.g arg2)
    {
    }

    private com.viber.voip.gdpr.ui.iabconsent.a b(com.viber.voip.gdpr.ui.iabconsent.a parama)
    {
      com.viber.voip.gdpr.ui.iabconsent.b.a(parama, (com.viber.voip.gdpr.a.a)b.bY(b.this).get());
      return parama;
    }

    public void a(com.viber.voip.gdpr.ui.iabconsent.a parama)
    {
      b(parama);
    }
  }

  private final class i extends com.viber.voip.g.a.a.e.a.a
  {
    private BackgroundGalleryActivity b;

    private i()
    {
    }

    public com.viber.voip.g.a.a.e.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(BackgroundGalleryActivity.class.getCanonicalName() + " must be set");
      return new b.j(b.this, this, null);
    }

    public void a(BackgroundGalleryActivity paramBackgroundGalleryActivity)
    {
      this.b = ((BackgroundGalleryActivity)dagger.a.h.a(paramBackgroundGalleryActivity));
    }
  }

  private final class j
    implements com.viber.voip.g.a.a.e.a
  {
    private j(b.i arg2)
    {
    }

    private BackgroundGalleryActivity b(BackgroundGalleryActivity paramBackgroundGalleryActivity)
    {
      com.viber.voip.backgrounds.ui.a.a(paramBackgroundGalleryActivity, com.viber.voip.g.a.s.c());
      return paramBackgroundGalleryActivity;
    }

    public void a(BackgroundGalleryActivity paramBackgroundGalleryActivity)
    {
      b(paramBackgroundGalleryActivity);
    }
  }

  private final class k extends com.viber.voip.g.a.a.f.a.a
  {
    private com.viber.voip.group.participants.ban.e b;

    private k()
    {
    }

    public com.viber.voip.g.a.a.f.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.group.participants.ban.e.class.getCanonicalName() + " must be set");
      return new b.l(b.this, this, null);
    }

    public void a(com.viber.voip.group.participants.ban.e parame)
    {
      this.b = ((com.viber.voip.group.participants.ban.e)dagger.a.h.a(parame));
    }
  }

  private final class l
    implements com.viber.voip.g.a.a.f.a
  {
    private Provider<com.viber.voip.group.participants.ban.e> b;
    private Provider<com.viber.voip.group.participants.settings.d> c;
    private Provider<com.viber.voip.invitelinks.linkscreen.g> d;
    private Provider<com.viber.voip.group.participants.ban.h> e;
    private Provider<BannedParticipantsListPresenter> f;

    private l(b.k arg2)
    {
      b.k localk;
      a(localk);
    }

    private void a(b.k paramk)
    {
      this.b = dagger.a.e.a(b.k.a(paramk));
      this.c = dagger.a.c.a(au.a(this.b, b.J(b.this), b.M(b.this)));
      this.d = dagger.a.c.a(com.viber.voip.g.a.at.a(this.b, b.J(b.this)));
      this.e = dagger.a.c.a(as.a(this.c, b.aU(b.this)));
      this.f = dagger.a.c.a(com.viber.voip.g.a.av.a(this.b, b.T(b.this), gn.b(), b.bC(b.this), b.aF(b.this), this.d, this.c, this.e));
    }

    private com.viber.voip.group.participants.ban.e b(com.viber.voip.group.participants.ban.e parame)
    {
      com.viber.voip.group.participants.ban.f.a(parame, (com.viber.voip.group.participants.settings.d)this.c.get());
      com.viber.voip.group.participants.ban.f.a(parame, (BannedParticipantsListPresenter)this.f.get());
      return parame;
    }

    public void a(com.viber.voip.group.participants.ban.e parame)
    {
      b(parame);
    }
  }

  private final class m extends com.viber.voip.g.a.a.g.a.a
  {
    private com.viber.voip.block.d b;

    private m()
    {
    }

    public com.viber.voip.g.a.a.g.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.block.d.class.getCanonicalName() + " must be set");
      return new b.n(b.this, this, null);
    }

    public void a(com.viber.voip.block.d paramd)
    {
      this.b = ((com.viber.voip.block.d)dagger.a.h.a(paramd));
    }
  }

  private final class n
    implements com.viber.voip.g.a.a.g.a
  {
    private n(b.m arg2)
    {
    }

    private com.viber.voip.block.d b(com.viber.voip.block.d paramd)
    {
      com.viber.voip.block.f.a(paramd, b.X(b.this));
      com.viber.voip.block.f.a(paramd, b.ak(b.this));
      return paramd;
    }

    public void a(com.viber.voip.block.d paramd)
    {
      b(paramd);
    }
  }

  private static final class o
    implements a.a
  {
    private ft a;
    private ViberApplication b;

    public a a()
    {
      if (this.a == null)
        this.a = new ft();
      if (this.b == null)
        throw new IllegalStateException(ViberApplication.class.getCanonicalName() + " must be set");
      return new b(this, null);
    }

    public o b(ViberApplication paramViberApplication)
    {
      this.b = ((ViberApplication)dagger.a.h.a(paramViberApplication));
      return this;
    }
  }

  private final class p extends com.viber.voip.g.a.a.h.a.a
  {
    private BusinessInboxActivity b;

    private p()
    {
    }

    public com.viber.voip.g.a.a.h.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(BusinessInboxActivity.class.getCanonicalName() + " must be set");
      return new b.q(b.this, this, null);
    }

    public void a(BusinessInboxActivity paramBusinessInboxActivity)
    {
      this.b = ((BusinessInboxActivity)dagger.a.h.a(paramBusinessInboxActivity));
    }
  }

  private final class q
    implements com.viber.voip.g.a.a.h.a
  {
    private Provider<com.viber.voip.g.a.a.a.a.a.a> b;

    private q(b.p arg2)
    {
      b.p localp;
      a(localp);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(27).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.services.inbox.screen.a.class, this.b).a();
    }

    private void a(b.p paramp)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.a.a.a a()
        {
          return new b.q.a(b.q.this, null);
        }
      };
    }

    private BusinessInboxActivity b(BusinessInboxActivity paramBusinessInboxActivity)
    {
      com.viber.voip.ui.e.a(paramBusinessInboxActivity, b());
      return paramBusinessInboxActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(BusinessInboxActivity paramBusinessInboxActivity)
    {
      b(paramBusinessInboxActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.a.a.a
    {
      private com.viber.voip.services.inbox.screen.a b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.a.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.services.inbox.screen.a.class.getCanonicalName() + " must be set");
        return new b.q.b(b.q.this, this, null);
      }

      public void a(com.viber.voip.services.inbox.screen.a parama)
      {
        this.b = ((com.viber.voip.services.inbox.screen.a)dagger.a.h.a(parama));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.a.a
    {
      private b(b.q.a arg2)
      {
      }

      private com.viber.voip.services.inbox.screen.a b(com.viber.voip.services.inbox.screen.a parama)
      {
        com.viber.voip.messages.ui.i.a(parama, dagger.a.c.b(b.J(b.this)));
        com.viber.voip.messages.ui.i.b(parama, dagger.a.c.b(b.ae(b.this)));
        com.viber.voip.messages.ui.i.c(parama, dagger.a.c.b(b.af(b.this)));
        com.viber.voip.services.inbox.screen.b.a(parama, dx.c());
        com.viber.voip.services.inbox.screen.b.a(parama, fz.c());
        com.viber.voip.services.inbox.screen.b.a(parama, b.L(b.this));
        com.viber.voip.services.inbox.screen.b.a(parama, b.this.d());
        com.viber.voip.services.inbox.screen.b.a(parama, (com.viber.voip.ads.b.c.b.f)b.aN(b.this).get());
        com.viber.voip.services.inbox.screen.b.a(parama, (com.viber.voip.util.e.e)b.Q(b.this).get());
        com.viber.voip.services.inbox.screen.b.a(parama, (com.viber.voip.ads.b.c.a.b)b.aw(b.this).get());
        com.viber.voip.services.inbox.screen.b.a(parama, b.P(b.this));
        com.viber.voip.services.inbox.screen.b.a(parama, b.ak(b.this));
        return parama;
      }

      public void a(com.viber.voip.services.inbox.screen.a parama)
      {
        b(parama);
      }
    }
  }

  private final class r extends com.viber.voip.g.a.a.i.a.a
  {
    private com.viber.voip.settings.ui.c b;

    private r()
    {
    }

    public com.viber.voip.g.a.a.i.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(com.viber.voip.settings.ui.c.class.getCanonicalName() + " must be set");
      return new b.s(b.this, this, null);
    }

    public void a(com.viber.voip.settings.ui.c paramc)
    {
      this.b = ((com.viber.voip.settings.ui.c)dagger.a.h.a(paramc));
    }
  }

  private final class s
    implements com.viber.voip.g.a.a.i.a
  {
    private s(b.r arg2)
    {
    }

    public void a(com.viber.voip.settings.ui.c paramc)
    {
    }
  }

  private final class t extends com.viber.voip.g.a.a.j.a.a
  {
    private ChangePhoneNumberActivity b;

    private t()
    {
    }

    public com.viber.voip.g.a.a.j.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ChangePhoneNumberActivity.class.getCanonicalName() + " must be set");
      return new b.u(b.this, this, null);
    }

    public void a(ChangePhoneNumberActivity paramChangePhoneNumberActivity)
    {
      this.b = ((ChangePhoneNumberActivity)dagger.a.h.a(paramChangePhoneNumberActivity));
    }
  }

  private final class u
    implements com.viber.voip.g.a.a.j.a
  {
    private Provider<com.viber.voip.g.a.a.a.c.a.a> b;
    private Provider<com.viber.voip.g.a.a.a.d.a.a> c;
    private Provider<com.viber.voip.g.a.a.a.b.a.a> d;

    private u(b.t arg2)
    {
      b.t localt;
      a(localt);
    }

    private Map<Class<? extends Fragment>, Provider<dagger.android.b.b<? extends Fragment>>> a()
    {
      return dagger.a.f.a(29).a(com.viber.voip.news.e.class, b.z(b.this)).a(HomeTabNewsBrowserFragment.class, b.y(b.this)).a(com.viber.voip.messages.shopchat.b.class, b.x(b.this)).a(com.viber.voip.settings.ui.c.class, b.w(b.this)).a(com.viber.voip.settings.ui.i.class, b.v(b.this)).a(com.viber.voip.group.participants.ban.e.class, b.u(b.this)).a(IncomingCallFragment.class, b.t(b.this)).a(InCallFragment.class, b.s(b.this)).a(EndCallFragment.class, b.r(b.this)).a(ConversationFragment.class, b.q(b.this)).a(CommunityConversationFragment.class, b.p(b.this)).a(PublicGroupConversationFragment.class, b.o(b.this)).a(TabletPublicGroupConversationFragment.class, b.n(b.this)).a(GroupCallDetailsFragment.class, b.m(b.this)).a(com.viber.voip.block.d.class, b.l(b.this)).a(com.viber.voip.contacts.ui.list.l.class, b.k(b.this)).a(bk.class, b.j(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.g.class, b.i(b.this)).a(com.viber.voip.gdpr.ui.iabconsent.a.class, b.h(b.this)).a(com.viber.voip.settings.ui.d.class, b.g(b.this)).a(EditInfoFragment.class, b.f(b.this)).a(com.viber.voip.storage.manage.d.class, b.e(b.this)).a(com.viber.voip.storage.conversation.a.class, b.d(b.this)).a(com.viber.voip.storage.overall.a.class, b.c(b.this)).a(ContactsFragment.class, b.b(b.this)).a(com.viber.voip.contacts.ui.ap.class, b.a(b.this)).a(com.viber.voip.registration.changephonenumber.f.class, this.b).a(com.viber.voip.registration.changephonenumber.j.class, this.c).a(com.viber.voip.registration.changephonenumber.b.class, this.d).a();
    }

    private void a(b.t paramt)
    {
      this.b = new Provider()
      {
        public com.viber.voip.g.a.a.a.c.a.a a()
        {
          return new b.u.c(b.u.this, null);
        }
      };
      this.c = new Provider()
      {
        public com.viber.voip.g.a.a.a.d.a.a a()
        {
          return new b.u.e(b.u.this, null);
        }
      };
      this.d = new Provider()
      {
        public com.viber.voip.g.a.a.a.b.a.a a()
        {
          return new b.u.a(b.u.this, null);
        }
      };
    }

    private ChangePhoneNumberActivity b(ChangePhoneNumberActivity paramChangePhoneNumberActivity)
    {
      com.viber.voip.registration.changephonenumber.c.a(paramChangePhoneNumberActivity, b());
      com.viber.voip.registration.changephonenumber.c.a(paramChangePhoneNumberActivity, dagger.a.c.b(b.ba(b.this)));
      com.viber.voip.registration.changephonenumber.c.b(paramChangePhoneNumberActivity, dagger.a.c.b(b.am(b.this)));
      return paramChangePhoneNumberActivity;
    }

    private dagger.android.c<Fragment> b()
    {
      return dagger.android.d.a(a());
    }

    public void a(ChangePhoneNumberActivity paramChangePhoneNumberActivity)
    {
      b(paramChangePhoneNumberActivity);
    }

    private final class a extends com.viber.voip.g.a.a.a.b.a.a
    {
      private com.viber.voip.registration.changephonenumber.b b;

      private a()
      {
      }

      public com.viber.voip.g.a.a.a.b.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.registration.changephonenumber.b.class.getCanonicalName() + " must be set");
        return new b.u.b(b.u.this, this, null);
      }

      public void a(com.viber.voip.registration.changephonenumber.b paramb)
      {
        this.b = ((com.viber.voip.registration.changephonenumber.b)dagger.a.h.a(paramb));
      }
    }

    private final class b
      implements com.viber.voip.g.a.a.a.b.a
    {
      private b(b.u.a arg2)
      {
      }

      private com.viber.voip.registration.changephonenumber.b b(com.viber.voip.registration.changephonenumber.b paramb)
      {
        com.viber.voip.registration.i.a(paramb, b.G(b.this));
        com.viber.voip.registration.i.a(paramb, dagger.a.c.b(b.ba(b.this)));
        return paramb;
      }

      public void a(com.viber.voip.registration.changephonenumber.b paramb)
      {
        b(paramb);
      }
    }

    private final class c extends com.viber.voip.g.a.a.a.c.a.a
    {
      private com.viber.voip.registration.changephonenumber.f b;

      private c()
      {
      }

      public com.viber.voip.g.a.a.a.c.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.registration.changephonenumber.f.class.getCanonicalName() + " must be set");
        return new b.u.d(b.u.this, this, null);
      }

      public void a(com.viber.voip.registration.changephonenumber.f paramf)
      {
        this.b = ((com.viber.voip.registration.changephonenumber.f)dagger.a.h.a(paramf));
      }
    }

    private final class d
      implements com.viber.voip.g.a.a.a.c.a
    {
      private d(b.u.c arg2)
      {
      }

      private com.viber.voip.registration.changephonenumber.f b(com.viber.voip.registration.changephonenumber.f paramf)
      {
        com.viber.voip.registration.changephonenumber.g.a(paramf, dagger.a.c.b(b.am(b.this)));
        return paramf;
      }

      public void a(com.viber.voip.registration.changephonenumber.f paramf)
      {
        b(paramf);
      }
    }

    private final class e extends com.viber.voip.g.a.a.a.d.a.a
    {
      private com.viber.voip.registration.changephonenumber.j b;

      private e()
      {
      }

      public com.viber.voip.g.a.a.a.d.a a()
      {
        if (this.b == null)
          throw new IllegalStateException(com.viber.voip.registration.changephonenumber.j.class.getCanonicalName() + " must be set");
        return new b.u.f(b.u.this, this, null);
      }

      public void a(com.viber.voip.registration.changephonenumber.j paramj)
      {
        this.b = ((com.viber.voip.registration.changephonenumber.j)dagger.a.h.a(paramj));
      }
    }

    private final class f
      implements com.viber.voip.g.a.a.a.d.a
    {
      private f(b.u.e arg2)
      {
      }

      private com.viber.voip.registration.changephonenumber.j b(com.viber.voip.registration.changephonenumber.j paramj)
      {
        com.viber.voip.registration.i.a(paramj, b.G(b.this));
        com.viber.voip.registration.i.a(paramj, dagger.a.c.b(b.ba(b.this)));
        return paramj;
      }

      public void a(com.viber.voip.registration.changephonenumber.j paramj)
      {
        b(paramj);
      }
    }
  }

  private final class v extends com.viber.voip.g.a.a.k.a.a
  {
    private ChatExInternalBrowserActivity b;

    private v()
    {
    }

    public com.viber.voip.g.a.a.k.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ChatExInternalBrowserActivity.class.getCanonicalName() + " must be set");
      return new b.w(b.this, this, null);
    }

    public void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity)
    {
      this.b = ((ChatExInternalBrowserActivity)dagger.a.h.a(paramChatExInternalBrowserActivity));
    }
  }

  private final class w
    implements com.viber.voip.g.a.a.k.a
  {
    private w(b.v arg2)
    {
    }

    private ChatExInternalBrowserActivity b(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity)
    {
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserActivity, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserActivity, gm.c());
      return paramChatExInternalBrowserActivity;
    }

    public void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity)
    {
      b(paramChatExInternalBrowserActivity);
    }
  }

  private final class x extends com.viber.voip.g.a.a.l.a.a
  {
    private ChatExInternalBrowserPartialSizeActivity b;

    private x()
    {
    }

    public com.viber.voip.g.a.a.l.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ChatExInternalBrowserPartialSizeActivity.class.getCanonicalName() + " must be set");
      return new b.y(b.this, this, null);
    }

    public void a(ChatExInternalBrowserPartialSizeActivity paramChatExInternalBrowserPartialSizeActivity)
    {
      this.b = ((ChatExInternalBrowserPartialSizeActivity)dagger.a.h.a(paramChatExInternalBrowserPartialSizeActivity));
    }
  }

  private final class y
    implements com.viber.voip.g.a.a.l.a
  {
    private y(b.x arg2)
    {
    }

    private ChatExInternalBrowserPartialSizeActivity b(ChatExInternalBrowserPartialSizeActivity paramChatExInternalBrowserPartialSizeActivity)
    {
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserPartialSizeActivity, (com.viber.voip.messages.extensions.c)b.ao(b.this).get());
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserPartialSizeActivity, dagger.a.c.b(b.D(b.this)));
      com.viber.voip.messages.extensions.activity.g.a(paramChatExInternalBrowserPartialSizeActivity, gm.c());
      return paramChatExInternalBrowserPartialSizeActivity;
    }

    public void a(ChatExInternalBrowserPartialSizeActivity paramChatExInternalBrowserPartialSizeActivity)
    {
      b(paramChatExInternalBrowserPartialSizeActivity);
    }
  }

  private final class z extends com.viber.voip.g.a.a.m.a.a
  {
    private ChatExtensionPanelActivity b;

    private z()
    {
    }

    public com.viber.voip.g.a.a.m.a a()
    {
      if (this.b == null)
        throw new IllegalStateException(ChatExtensionPanelActivity.class.getCanonicalName() + " must be set");
      return new b.aa(b.this, this, null);
    }

    public void a(ChatExtensionPanelActivity paramChatExtensionPanelActivity)
    {
      this.b = ((ChatExtensionPanelActivity)dagger.a.h.a(paramChatExtensionPanelActivity));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.b
 * JD-Core Version:    0.6.2
 */