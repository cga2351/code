package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.api.scheme.action.OpenChatExtensionAction.Description;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.camrecorder.preview.DoodleDataContainer;
import com.viber.voip.camrecorder.preview.MediaPreviewActivity;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.i.c.h;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest.a;
import com.viber.voip.messages.controller.publicaccount.SendRichMessageRequest;
import com.viber.voip.messages.controller.publicaccount.SendRichMessageRequest.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.view.b.u;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.k;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.MessageComposerView.c;
import com.viber.voip.messages.ui.ab.a;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.messages.ui.t;
import com.viber.voip.messages.ui.w;
import com.viber.voip.q.h;
import com.viber.voip.registration.af;
import com.viber.voip.sound.AudioStreamManager;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.m;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.x;
import com.viber.voip.util.at;
import com.viber.voip.util.at.a;
import com.viber.voip.util.at.b;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public class aq
{
  private static final Logger l = ViberEnv.getLogger();
  private com.viber.common.permission.c A;
  private bu B;
  private w C;
  private t D;
  private ConversationItemLoaderEntity E;
  private WinkDescription F;
  private boolean G;
  private com.viber.common.ui.c H;
  private boolean I;
  private d J;
  private final com.viber.voip.messages.conversation.ui.b.b K;
  private final z L;
  private final com.viber.voip.messages.conversation.ui.b.a M;
  private final com.viber.voip.messages.extensions.c N;
  private final UserManager O;
  private ScreenshotConversationData P;
  private e Q;
  private f R;
  private c S;
  private boolean T;
  private final ViewTreeObserver.OnPreDrawListener U;
  private final h V;
  private final AudioStreamManager W;
  private com.viber.common.permission.b X;
  public final View a;
  protected ConversationFragment.a b;
  public final ConversationAlertView c;
  public final MessageComposerView d;
  public final ConversationListView e;
  public final ConversationFragment f;
  public final SwipeRefreshLayout g;
  public final j h;
  public final a i;
  public ExpandablePanelLayout j;
  private InputFilter[] k;
  private long[] m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private Bundle r;
  private ComposeDataContainer s;
  private List<Uri> t;
  private String u;
  private String v;
  private Uri w;
  private boolean x;
  private int y;
  private final View z;

  public aq(ConversationFragment paramConversationFragment, MessageComposerView paramMessageComposerView, a parama, j paramj, View paramView1, Bundle paramBundle, t paramt, boolean paramBoolean, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, com.viber.voip.messages.conversation.ui.b.b paramb, final com.viber.voip.messages.ui.d paramd, w paramw, z paramz, com.viber.voip.messages.conversation.ui.b.a parama1, View paramView2, com.viber.voip.messages.extensions.c paramc, UserManager paramUserManager)
  {
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new InputFilter()
    {
      public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousCharSequence.length() < 1)
          return paramAnonymousSpanned.subSequence(paramAnonymousInt3, paramAnonymousInt4);
        return "";
      }
    };
    this.k = arrayOfInputFilter;
    this.U = new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        if (aq.a(aq.this) != null)
          aq.a(aq.this).c();
        return true;
      }
    };
    this.V = new h()
    {
      public void a(String paramAnonymousString, int paramAnonymousInt)
      {
        aq.b(aq.this).setKeepScreenOn(false);
        aq.c(aq.this).restoreStream();
      }

      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        aq.b(aq.this).setKeepScreenOn(true);
        aq.c(aq.this).changeStream(3);
      }

      public void b(String paramAnonymousString, long paramAnonymousLong)
      {
        aq.b(aq.this).setKeepScreenOn(false);
        aq.c(aq.this).restoreStream();
      }

      public void c(String paramAnonymousString, long paramAnonymousLong)
      {
        aq.b(aq.this).setKeepScreenOn(true);
        aq.c(aq.this).changeStream(3);
      }
    };
    this.a = paramView2;
    this.d = paramMessageComposerView;
    this.L = paramz;
    this.M = parama1;
    this.C = paramw;
    this.D = paramt;
    this.N = paramc;
    this.O = paramUserManager;
    com.viber.common.d.i.a();
    this.K = paramb;
    this.f = paramConversationFragment;
    this.G = paramBoolean;
    this.h = paramj;
    this.i = parama;
    FragmentActivity localFragmentActivity1 = this.f.getActivity();
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(133);
    this.X = new com.viber.voip.permissions.f(localFragmentActivity1, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof Bundle))
          aq.a(aq.this, aq.this.f.getActivity().getIntent(), (Bundle)paramAnonymousObject);
      }
    };
    this.A = com.viber.common.permission.c.a(paramConversationFragment.getActivity());
    this.W = new com.viber.voip.q.c(paramConversationFragment.getActivity());
    boolean bool;
    int i1;
    label236: ScreenshotConversationData localScreenshotConversationData;
    if ((paramBundle == null) || (paramBundle.getBoolean("need_description")))
    {
      bool = true;
      this.x = bool;
      if (paramBundle == null)
        break label486;
      i1 = paramBundle.getInt("media_type");
      this.y = i1;
      if (paramBundle == null)
        break label492;
      localScreenshotConversationData = (ScreenshotConversationData)paramBundle.getParcelable("extra_community_screenshot_data");
      label259: this.P = localScreenshotConversationData;
      if (paramBundle == null)
        break label498;
    }
    label486: label492: label498: for (WinkDescription localWinkDescription = (WinkDescription)paramBundle.getParcelable("com.viber.voip.wink.WINK_DESCRIPTION"); ; localWinkDescription = null)
    {
      this.F = localWinkDescription;
      this.z = paramView1;
      ViewStub localViewStub = (ViewStub)paramView1.findViewById(R.id.video_ptt_record_stub);
      this.d.setVideoPttRecordStub(localViewStub);
      this.g = paramSwipeRefreshLayout;
      this.g.setProgressBackgroundColorSchemeResource(dc.a(this.g.getContext(), R.attr.swipeToRefreshBackground));
      SwipeRefreshLayout localSwipeRefreshLayout = this.g;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = dc.a(this.g.getContext(), R.attr.swipeToRefreshArrowColor);
      localSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
      this.g.setOnRefreshListener(this.f);
      this.e = ((ConversationListView)paramView1.findViewById(R.id.conversation_list));
      this.B = new bu(paramConversationFragment);
      this.c = paramConversationAlertView;
      this.j = ((ExpandablePanelLayout)paramView1.findViewById(R.id.conversation_menu));
      final FragmentActivity localFragmentActivity2 = paramConversationFragment.getActivity();
      this.d.setHost(new MessageComposerView.c()
      {
        private InputFilter[] d;
        private int e = 2;

        public void a()
        {
          if (!aq.d(aq.this).b())
            aq.d(aq.this).a();
        }

        public void a(int paramAnonymousInt)
        {
          if (localFragmentActivity2 == null);
          while (this.e == paramAnonymousInt)
            return;
          this.e = paramAnonymousInt;
          aq.e(aq.this).a(paramAnonymousInt);
          MessageEditText localMessageEditText = aq.this.d.getMessageEdit();
          switch (paramAnonymousInt)
          {
          default:
            return;
          case 1:
            this.d = localMessageEditText.getFilters();
            localMessageEditText.setFilters(aq.f(aq.this));
            com.viber.voip.n.a.a(localFragmentActivity2);
            return;
          case 2:
          }
          localMessageEditText.setFilters(this.d);
          aq.g(aq.this).a();
          com.viber.voip.n.a.b(localFragmentActivity2);
        }

        public void a(List<ab.a> paramAnonymousList)
        {
          paramd.a(paramAnonymousList);
        }

        public void a(boolean paramAnonymousBoolean)
        {
          aq.this.e.a(false);
        }

        public void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          boolean bool = true;
          if (paramAnonymousBoolean1)
          {
            AppCompatActivity localAppCompatActivity2 = (AppCompatActivity)aq.this.f.getActivity();
            if (!paramAnonymousBoolean2);
            while (true)
            {
              dj.b(localAppCompatActivity2, bool);
              return;
              bool = false;
            }
          }
          AppCompatActivity localAppCompatActivity1 = (AppCompatActivity)aq.this.f.getActivity();
          if (!paramAnonymousBoolean2);
          while (true)
          {
            dj.a(localAppCompatActivity1, bool);
            return;
            bool = false;
          }
        }

        public void b()
        {
          aq.h(aq.this).c();
        }

        public void b(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
            aq.h(aq.this).b();
        }

        public int c()
        {
          return aq.d(aq.this).c().size();
        }

        public void d()
        {
          aq.h(aq.this).a();
        }

        public boolean e()
        {
          return aq.i(aq.this).g();
        }

        public int f()
        {
          return aq.this.e.getHeight();
        }

        public int g()
        {
          return ((AppCompatActivity)aq.this.f.getActivity()).getSupportActionBar().e();
        }

        public boolean h()
        {
          return ((AppCompatActivity)aq.this.f.getActivity()).getSupportActionBar().h();
        }

        public LoaderManager i()
        {
          return aq.this.f.getLoaderManager();
        }
      });
      ViberApplication.getInstance().getMessagesManager().m().a(this.V);
      return;
      bool = false;
      break;
      i1 = 0;
      break label236;
      localScreenshotConversationData = null;
      break label259;
    }
  }

  private void a(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("show_ivm_promotion"))
      return;
    this.I = paramIntent.getBooleanExtra("show_ivm_promotion", false);
    paramIntent.removeExtra("show_ivm_promotion");
  }

  private void a(Intent paramIntent, Uri paramUri, String paramString)
  {
    if ((this.y == 1) && (!dk.a(paramUri)) && (!dk.b(paramUri)))
    {
      String str = com.viber.voip.util.e.e.a(this.w);
      if (TextUtils.isEmpty(str))
        return;
      paramUri = Uri.parse(str);
      if (paramUri.getScheme() == null)
        paramUri = paramUri.buildUpon().scheme("file").build();
    }
    ArrayList localArrayList = new ArrayList();
    SendMediaDataContainer localSendMediaDataContainer = new SendMediaDataContainer();
    localSendMediaDataContainer.fileUri = paramUri;
    localSendMediaDataContainer.type = this.y;
    localSendMediaDataContainer.description = paramString;
    if (this.F != null)
    {
      localSendMediaDataContainer.winkDescription = this.F;
      this.F = null;
    }
    ScreenshotConversationData localScreenshotConversationData = (ScreenshotConversationData)paramIntent.getParcelableExtra("extra_community_screenshot_data");
    if (localScreenshotConversationData == null)
      localScreenshotConversationData = this.P;
    localSendMediaDataContainer.screenshotConversationData = localScreenshotConversationData;
    if (localSendMediaDataContainer.screenshotConversationData != null)
    {
      MediaInfo localMediaInfo = new MediaInfo();
      localMediaInfo.setMediaType(MediaInfo.a.IMAGE);
      int i1 = Math.min(localSendMediaDataContainer.screenshotConversationData.getWidth(), localSendMediaDataContainer.screenshotConversationData.getHeight());
      localMediaInfo.setHeight(i1);
      localMediaInfo.setWidth(i1);
      localSendMediaDataContainer.mediaInfo = localMediaInfo;
    }
    localArrayList.add(localSendMediaDataContainer);
    paramIntent.removeExtra("need_description");
    av.a(av.e.a).post(new as(this, localArrayList));
  }

  private void a(final Intent paramIntent, Bundle paramBundle)
  {
    if ((this.F != null) && (!this.t.isEmpty()))
    {
      final Uri localUri = (Uri)this.t.get(0);
      av.a(av.e.f).post(new Runnable()
      {
        public void run()
        {
          aq.a(aq.this, paramIntent, localUri, null);
        }
      });
    }
    while (true)
    {
      this.t = null;
      return;
      if (paramIntent.getBooleanExtra("external_share", false))
        paramBundle = com.viber.voip.analytics.story.n.a(paramBundle, "External Share");
      this.d.a(this.v, null, paramBundle);
      this.v = null;
      b(this.t, paramBundle);
    }
  }

  private void a(OpenChatExtensionAction.Description paramDescription, String paramString)
  {
    if (TextUtils.isEmpty(paramDescription.publicAccountId))
    {
      ViberActionRunner.m.a(this.f, this.E, this.G, paramString);
      return;
    }
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.N.a(paramDescription.publicAccountId);
    ViberActionRunner.m.a(this.f, this.E, localChatExtensionLoaderEntity, paramDescription.searchQuery, paramDescription.silentQuery, this.G, paramString);
  }

  private void a(final List<Uri> paramList, final g paramg)
  {
    if (paramg == null)
      return;
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      if ("video".equals(at.g(localUri)))
        localArrayList1.add(localUri);
    }
    final ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1.size() > 0)
    {
      at.a(this.f.getActivity(), localArrayList1, false, new at.b()
      {
        public void a(Map<String, Boolean> paramAnonymousMap)
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Uri localUri = (Uri)localIterator.next();
            if ((paramAnonymousMap.containsKey(localUri.getPath())) && (((Boolean)paramAnonymousMap.get(localUri.getPath())).booleanValue()))
            {
              localArrayList2.add(localUri);
              localIterator.remove();
            }
          }
          paramg.a(localArrayList2);
        }
      });
      return;
    }
    paramg.a(localArrayList2);
  }

  private void b(OpenChatExtensionAction.Description paramDescription, String paramString)
  {
    if ((!paramDescription.silentQuery) && (!TextUtils.isEmpty(paramDescription.searchQuery)))
      this.L.a(paramDescription.searchQuery);
    if (1 == paramDescription.interfaceType)
    {
      locala = this.M;
      if (paramDescription.cdrOpenTrigger != 0)
      {
        i1 = paramDescription.cdrOpenTrigger;
        locala.c(i1);
        this.d.a(paramDescription);
      }
    }
    while (paramDescription.interfaceType != 0)
      while (true)
      {
        com.viber.voip.messages.conversation.ui.b.a locala;
        return;
        int i1 = 8;
      }
    this.d.a(paramDescription);
  }

  private void b(u paramu)
  {
    if (!this.T);
    do
    {
      return;
      this.T = false;
    }
    while (paramu == null);
    paramu.a(this.E.getId(), this.E.getGroupId(), this.O.getRegistrationValues().l(), this.E.getConversationType(), this.E.getNativeChatType());
  }

  private void b(final List<Uri> paramList, final Bundle paramBundle)
  {
    final LinkedList localLinkedList = new LinkedList();
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    if (paramList == null);
    for (final int i1 = 0; ; i1 = paramList.size())
    {
      a(paramList, new g()
      {
        public void a(List<Uri> paramAnonymousList)
        {
          Iterator localIterator = paramList.iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            Uri localUri3 = (Uri)localIterator.next();
            String str1 = at.g(localUri3);
            String str2 = at.f(localUri3)[0];
            int j;
            if (("image".equals(str1)) || (com.viber.voip.messages.m.e(str2)))
            {
              if (com.viber.voip.messages.m.e(str2))
                i = 1;
              localArrayList2.add(GalleryItem.from(localUri3, str2));
              j = i;
            }
            while (true)
            {
              i = j;
              break;
              File localFile = at.a(ViberApplication.getApplication(), localUri3);
              if ((localFile == null) || (com.viber.voip.util.e.j.a(localUri3)) || (!at.i(localFile)) || (!at.b(localFile.length()).equals(at.a.a)))
              {
                if (localFile != null)
                {
                  localLinkedList.add(localFile);
                  j = i;
                }
              }
              else
              {
                localArrayList1.add(localUri3);
                j = i;
              }
            }
          }
          boolean bool2;
          Bundle localBundle;
          if ((localArrayList2.size() == 1) && (i1 == 1) && (i == 0))
          {
            Uri localUri2 = ((GalleryItem)localArrayList2.get(0)).getItemUri();
            if (aq.j(aq.this) != null)
            {
              bool2 = aq.j(aq.this).canSendTimeBomb();
              if (paramBundle != null)
                break label395;
              localBundle = new Bundle();
              label266: if (!TextUtils.isEmpty(aq.l(aq.this)))
                localBundle.putString("share_text", aq.l(aq.this));
              MediaPreviewActivity.a(aq.this.f, aq.this.f.ah().r(), localUri2.getPath(), localUri2, false, bool2, 10, localBundle);
            }
          }
          while (true)
          {
            if (localLinkedList.size() > 0)
              aq.this.a(localLinkedList, paramBundle);
            return;
            if (aq.this.f.P() == null)
            {
              bool2 = false;
              break;
            }
            bool2 = aq.this.f.P().canSendTimeBomb;
            break;
            label395: localBundle = new Bundle(paramBundle);
            break label266;
            if (localArrayList2.size() == i1)
            {
              FragmentActivity localFragmentActivity = aq.this.f.getActivity();
              ConversationData localConversationData = aq.this.f.P();
              aq.this.f.startActivity(ViberActionRunner.x.a(localFragmentActivity, localConversationData, localArrayList2, paramBundle));
            }
            else
            {
              if ((paramAnonymousList.size() == 1) && (i1 == 1))
              {
                Uri localUri1 = (Uri)paramAnonymousList.get(0);
                boolean bool1;
                if (aq.j(aq.this) != null)
                  bool1 = aq.j(aq.this).canSendTimeBomb();
                while (true)
                {
                  MediaPreviewActivity.a(aq.this.f, aq.this.f.ah().r(), localUri1.getPath(), localUri1, true, bool1, 9, paramBundle);
                  break;
                  if (aq.this.f.P() == null)
                    bool1 = false;
                  else
                    bool1 = aq.this.f.P().canSendTimeBomb;
                }
              }
              aq.this.d.a(localArrayList1, paramAnonymousList, localArrayList2, paramBundle);
            }
          }
        }
      });
      return;
    }
  }

  private boolean b(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.getBoolean("forward", false))
    {
      this.m = localBundle.getLongArray("default_message_forward_array");
      this.n = localBundle.getBoolean("is_forward_only_locations", false);
      this.p = localBundle.getInt("forward_locations_lat", 0);
      this.q = localBundle.getInt("forward_locations_lng", 0);
      paramIntent.removeExtra("forward");
      paramIntent.removeExtra("default_message_forward_array");
      paramIntent.removeExtra("forward_locations_lat");
      paramIntent.removeExtra("forward_locations_lng");
    }
    for (boolean bool1 = true; ; bool1 = false)
    {
      if (paramIntent.getParcelableExtra("compose_data_extra") != null)
      {
        this.s = ((ComposeDataContainer)paramIntent.getParcelableExtra("compose_data_extra"));
        paramIntent.removeExtra("compose_data_extra");
      }
      for (boolean bool2 = true; ; bool2 = bool1)
      {
        if (!this.o)
        {
          this.t = paramIntent.getParcelableArrayListExtra("share_files_uri");
          this.u = paramIntent.getStringExtra("share_uri");
          this.x = paramIntent.getBooleanExtra("need_description", true);
          this.v = paramIntent.getStringExtra("share_text");
          this.y = paramIntent.getIntExtra("media_type", 0);
          this.P = ((ScreenshotConversationData)paramIntent.getParcelableExtra("extra_community_screenshot_data"));
          this.r = paramIntent.getBundleExtra("options");
          this.F = ((WinkDescription)paramIntent.getParcelableExtra("com.viber.voip.wink.WINK_DESCRIPTION"));
          paramIntent.removeExtra("com.viber.voip.wink.WINK_DESCRIPTION");
          paramIntent.removeExtra("share_files_uri");
          paramIntent.removeExtra("share_uri");
          paramIntent.removeExtra("need_description");
          paramIntent.removeExtra("share_text");
          paramIntent.removeExtra("options");
          if ((this.t != null) || (this.u != null) || (this.v != null))
            this.o = true;
        }
        if ((this.t != null) || (this.u != null) || (this.v != null))
          bool2 = true;
        return bool2;
      }
    }
  }

  private void c(Intent paramIntent)
  {
    e(paramIntent);
    f(paramIntent);
    g(paramIntent);
    d(paramIntent);
  }

  private void c(List<SendMediaDataContainer> paramList, Bundle paramBundle)
  {
    this.d.a(paramList, paramBundle);
    this.M.d();
  }

  private void d(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("send_rich_message"))
      return;
    this.S = new c((SendRichMessageRequest)paramIntent.getParcelableExtra("send_rich_message"), null);
    paramIntent.removeExtra("send_rich_message");
  }

  private void e(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("forward _draft"))
      return;
    this.R = new f(paramIntent.getStringExtra("forward _draft"));
  }

  private void f(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("open_chat_extension"));
    OpenChatExtensionAction.Description localDescription;
    do
    {
      return;
      localDescription = (OpenChatExtensionAction.Description)paramIntent.getParcelableExtra("open_chat_extension");
    }
    while (localDescription == null);
    this.J = new d(localDescription, "Url Scheme");
    paramIntent.removeExtra("open_chat_extension");
  }

  private void g()
  {
    if (this.b == null);
    TextView localTextView;
    do
    {
      return;
      localTextView = this.b.n();
    }
    while ((localTextView == null) || (this.E == null));
    dj.a(localTextView, this.E);
  }

  private void g(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("open_share_and_shop_product_id"));
    String str1;
    do
    {
      return;
      str1 = paramIntent.getStringExtra("open_share_and_shop_product_id");
    }
    while (str1 == null);
    if (this.E.isConversation1on1());
    for (String str2 = this.E.getParticipantMemberId(); ; str2 = "")
    {
      this.Q = new e(new OpenShopChatPanelData(str2, this.E.getGroupId(), str1));
      paramIntent.removeExtra("open_share_and_shop_product_id");
      return;
    }
  }

  private void h()
  {
    if (!this.I)
      return;
    this.I = false;
    this.d.h();
  }

  private void h(Intent paramIntent)
  {
    if (!paramIntent.hasExtra("create_poll"))
      return;
    this.T = paramIntent.getBooleanExtra("create_poll", false);
    paramIntent.removeExtra("create_poll");
  }

  private void i()
  {
    if (this.J == null);
    OpenChatExtensionAction.Description localDescription;
    String str;
    do
    {
      return;
      localDescription = d.a(this.J);
      str = d.b(this.J);
      this.J = null;
    }
    while (!com.viber.voip.messages.d.a.a(this.E, this.N));
    if (c.h.f.e())
    {
      a(localDescription, str);
      return;
    }
    b(localDescription, str);
  }

  private void j()
  {
    if (this.Q == null)
      return;
    OpenShopChatPanelData localOpenShopChatPanelData = this.Q.a;
    this.Q = null;
    this.d.a(localOpenShopChatPanelData);
  }

  private void k()
  {
    if (this.S == null)
      return;
    SendRichMessageRequest localSendRichMessageRequest1 = this.S.a;
    this.S = null;
    BotReplyRequest localBotReplyRequest = BotReplyRequest.a.a(localSendRichMessageRequest1.getBotReplyRequest()).a(this.E.getId()).a(this.E.getParticipantMemberId()).b(this.E.getGroupId()).a(true).a(ReplyButton.a.OPEN_URL, ReplyButton.b.MESSAGE).a();
    SendRichMessageRequest localSendRichMessageRequest2 = SendRichMessageRequest.a.a(localSendRichMessageRequest1).a(localBotReplyRequest).a();
    ViberApplication.getInstance().getMessagesManager().h().b(localSendRichMessageRequest2);
  }

  public void a()
  {
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0)
      this.w = null;
  }

  public void a(Intent paramIntent, u paramu)
  {
    if ((0x100000 & paramIntent.getFlags()) != 0);
    do
    {
      Bundle localBundle1;
      do
      {
        return;
        this.K.a();
        c(paramIntent);
        h(paramIntent);
        a(paramIntent);
        localBundle1 = (Bundle)paramIntent.getParcelableExtra("options");
        if (!b(paramIntent))
          break;
      }
      while ((localBundle1 == null) || (TextUtils.isEmpty(localBundle1.getString("share_entry_point_extra_key"))));
      g.a().c().g().c(localBundle1.getString("share_entry_point_extra_key"));
      return;
      if (paramIntent.getExtras().containsKey("multiply_send"))
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("multiply_send");
        DoodleDataContainer localDoodleDataContainer = (DoodleDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_doodle_data");
        if ((localDoodleDataContainer != null) && (localDoodleDataContainer.doodleSize > 0L));
        for (boolean bool = true; ; bool = false)
        {
          Bundle localBundle2 = com.viber.voip.analytics.story.n.a(localBundle1, bool);
          paramIntent.removeExtra("multiply_send");
          c(localArrayList, localBundle2);
          return;
        }
      }
    }
    while (paramu == null);
    paramu.a(paramIntent);
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putParcelable("share_uri", this.w);
    paramBundle.putBoolean("need_description", this.x);
    paramBundle.putInt("media_type", this.y);
    paramBundle.putParcelable("extra_community_screenshot_data", this.P);
    paramBundle.putParcelable("com.viber.voip.wink.WINK_DESCRIPTION", this.F);
    this.C.a(paramBundle);
  }

  public void a(View paramView)
  {
    if (paramView == null)
      return;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((aq.j(aq.this) == null) || (aq.this.f == null) || (!aq.this.f.isVisible()));
        while (aq.j(aq.this).isSystemConversation())
          return;
        if (aq.j(aq.this).isOneToOneWithPublicAccount())
        {
          aq.this.c(paramAnonymousView);
          return;
        }
        if (aq.j(aq.this).isVlnConversation())
        {
          ViberActionRunner.o.a(aq.this.f.getContext(), aq.j(aq.this).getConversationType(), aq.j(aq.this).getGroupRole(), aq.j(aq.this).getParticipantInfoId(), 3);
          return;
        }
        aq.this.f.a(aq.j(aq.this), "Chat Header");
      }
    });
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.E = paramConversationItemLoaderEntity;
    if (paramConversationItemLoaderEntity != null)
    {
      g();
      this.d.a(paramConversationItemLoaderEntity, this.G, paramBoolean);
      if (paramBoolean)
        g.a().c().g().a(1, this.E, false);
      return;
    }
    this.d.f();
  }

  void a(ConversationFragment.a parama)
  {
    this.b = parama;
  }

  void a(u paramu)
  {
    if (this.f.getActivity() == null)
      return;
    if ((this.m != null) && (this.m.length > 0))
    {
      this.d.a(this.m, this.r, null);
      this.m = null;
    }
    final Intent localIntent = this.f.getActivity().getIntent();
    if ((this.n) && (this.p != 0) && (this.q != 0))
    {
      this.d.a(this.p, this.q, null);
      this.n = false;
      this.p = 0;
      this.q = 0;
    }
    if (this.t != null)
    {
      if (!this.A.a(com.viber.voip.permissions.n.m))
        this.A.a(this.f.getActivity(), 133, com.viber.voip.permissions.n.m, null);
      while (true)
      {
        this.o = false;
        if (((this.E != null) && (!this.E.isHiddenConversation())) || ((this.f != null) && (this.f.ah().g().u())))
          f();
        i();
        j();
        k();
        b(paramu);
        h();
        this.r = null;
        return;
        a(localIntent, null);
      }
    }
    if (this.u != null)
    {
      this.w = Uri.parse(this.u);
      final String str;
      if (this.x)
      {
        str = this.v;
        if (str == null)
        {
          b(Collections.singletonList(this.w), null);
          label284: this.v = null;
        }
      }
      while (true)
      {
        this.u = null;
        break;
        av.a(av.e.f).post(new Runnable()
        {
          public void run()
          {
            aq.a(aq.this, localIntent, aq.k(aq.this), str);
          }
        });
        break label284;
        final Uri localUri = this.w;
        av.a(av.e.f).post(new Runnable()
        {
          public void run()
          {
            aq.a(aq.this, localIntent, localUri, null);
          }
        });
      }
    }
    if (this.v != null)
      if (!localIntent.getBooleanExtra("external_share", false))
        break label429;
    label429: for (Bundle localBundle = com.viber.voip.analytics.story.n.a(null, "External Share"); ; localBundle = null)
    {
      this.d.a(this.v, null, localBundle);
      this.v = null;
      break;
      if (this.s == null)
        break;
      this.d.a(this.s, this.B, null);
      this.s = null;
      break;
    }
  }

  public void a(List<File> paramList, Bundle paramBundle)
  {
    File localFile = (File)paramList.get(0);
    String str = localFile.getName();
    at.a locala = at.b(localFile.length());
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_conversation_data", (Serializable)paramList);
    localBundle.putParcelable("options", paramBundle);
    if (!at.i(localFile))
    {
      com.viber.voip.ui.dialogs.o.k().b(-1, new Object[] { str }).a(this.f).a(localBundle).c(this.f);
      return;
    }
    if (locala.equals(at.a.c))
    {
      h.a locala2 = com.viber.voip.ui.dialogs.o.h();
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = str;
      arrayOfObject2[1] = Integer.valueOf(200);
      locala2.b(-1, arrayOfObject2).a(this.f).a(localBundle).c(this.f);
      return;
    }
    if (locala.equals(at.a.b))
    {
      l.a locala1 = com.viber.voip.ui.dialogs.o.g();
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str;
      arrayOfObject1[1] = Integer.valueOf(50);
      locala1.b(-1, arrayOfObject1).a(this.f).a(localBundle).c(this.f);
      return;
    }
    com.viber.voip.ui.dialogs.o.k().b(-1, new Object[] { str }).a(this.f).a(localBundle).c(this.f);
  }

  public void b()
  {
    ViberApplication.getInstance().getRingtonePlayer().stopStickerPromo();
    ViberApplication.getInstance().getMessagesManager().m().a();
    this.d.l();
  }

  public void b(View paramView)
  {
    if (paramView == null)
      return;
    paramView.setOnClickListener(new ar(this));
  }

  public void c()
  {
    this.d.o();
    this.e.j();
    if (this.H != null)
    {
      this.H.b();
      this.z.getViewTreeObserver().removeOnPreDrawListener(this.U);
      this.H = null;
    }
    ViberApplication.getInstance().getMessagesManager().m().b(this.V);
  }

  public void c(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(this.f.getActivity(), paramView);
    localPopupMenu.getMenuInflater().inflate(R.menu.context_menu_pa_conversation_action_sheet, localPopupMenu.getMenu());
    localPopupMenu.getMenu().findItem(R.id.public_account_show_pa_info).setVisible(com.viber.voip.publicaccount.d.e.d());
    localPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        FragmentActivity localFragmentActivity = aq.this.f.getActivity();
        Intent localIntent = ViberActionRunner.aq.a(aq.j(aq.this).getPublicAccountGroupUri());
        int i = paramAnonymousMenuItem.getItemId();
        if (i == R.id.public_account_show_info)
          ViberActionRunner.aq.a(localFragmentActivity, aq.j(aq.this).getParticipantMemberId(), aq.j(aq.this).getConversationType(), localIntent);
        while (true)
        {
          return true;
          if (i == R.id.public_account_show_pa_info)
            localFragmentActivity.startActivity(localIntent);
        }
      }
    });
    localPopupMenu.show();
  }

  void d()
  {
    this.d.m();
    this.A.a(this.X);
  }

  void e()
  {
    this.d.n();
    this.A.b(this.X);
  }

  public void f()
  {
    if (this.R == null)
      return;
    String str = this.R.a;
    this.R = null;
    this.L.a(str);
  }

  public static abstract interface a
  {
    public abstract void M();
  }

  public static abstract interface b
  {
    public abstract boolean I();
  }

  private static class c
  {
    public final SendRichMessageRequest a;

    private c(SendRichMessageRequest paramSendRichMessageRequest)
    {
      this.a = paramSendRichMessageRequest;
    }
  }

  private static class d
  {
    private OpenChatExtensionAction.Description a;
    private String b;

    d(OpenChatExtensionAction.Description paramDescription, String paramString)
    {
      this.a = paramDescription;
      this.b = paramString;
    }
  }

  private static class e
  {
    public final OpenShopChatPanelData a;

    e(OpenShopChatPanelData paramOpenShopChatPanelData)
    {
      this.a = paramOpenShopChatPanelData;
    }
  }

  private static class f
  {
    public final String a;

    f(String paramString)
    {
      this.a = paramString;
    }
  }

  private static abstract interface g
  {
    public abstract void a(List<Uri> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.aq
 * JD-Core Version:    0.6.2
 */