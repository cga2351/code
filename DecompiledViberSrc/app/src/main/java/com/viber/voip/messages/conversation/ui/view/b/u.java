package com.viber.voip.messages.conversation.ui.view.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.n;
import com.viber.voip.block.g;
import com.viber.voip.block.g.a;
import com.viber.voip.camrecorder.preview.DoodleActivity;
import com.viber.voip.camrecorder.preview.DoodleDataContainer;
import com.viber.voip.camrecorder.preview.MediaPreviewActivity;
import com.viber.voip.camrecorder.preview.d.b;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.i.c.h;
import com.viber.voip.i.f;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.bu;
import com.viber.voip.messages.conversation.ui.presenter.SendMessagePresenter;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.MessageComposerView.k;
import com.viber.voip.messages.ui.d.d;
import com.viber.voip.messages.ui.d.e;
import com.viber.voip.messages.ui.d.f;
import com.viber.voip.messages.ui.d.g;
import com.viber.voip.messages.ui.d.i;
import com.viber.voip.messages.ui.d.k;
import com.viber.voip.messages.ui.d.l;
import com.viber.voip.messages.ui.d.m;
import com.viber.voip.messages.ui.d.n;
import com.viber.voip.messages.ui.d.o;
import com.viber.voip.messages.ui.d.p;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.messages.ui.w;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.ui.c.c;
import com.viber.voip.util.ParcelableUtils;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.bp;
import com.viber.voip.util.ViberActionRunner.m;
import com.viber.voip.util.ViberActionRunner.x;
import com.viber.voip.util.am;
import com.viber.voip.util.dj;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class u<P extends SendMessagePresenter> extends a<P>
  implements com.viber.voip.messages.conversation.ui.view.o
{
  private static final Logger a = ViberEnv.getLogger();
  private Window b;
  private int g;
  private com.viber.voip.messages.conversation.adapter.d h;
  private MessageComposerView i;
  private ExpandablePanelLayout j;
  private bu k;
  private final com.viber.voip.messages.ui.d l;
  private final w m;
  private com.viber.voip.camrecorder.preview.d n;
  private Handler o;
  private final Object p = new Object();

  public u(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, com.viber.voip.messages.ui.d paramd, w paramw, com.viber.voip.messages.conversation.adapter.d paramd1, Handler paramHandler)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.b = paramActivity.getWindow();
    this.g = am.a(paramActivity);
    this.l = paramd;
    this.m = paramw;
    this.h = paramd1;
    this.o = paramHandler;
    l();
    j();
  }

  private SendMediaDataContainer a(int paramInt, Intent paramIntent)
  {
    long l1 = paramIntent.getExtras().getLong("com.viber.voip.custom_cam_media_preview_conversation_id", -1L);
    if (((SendMessagePresenter)this.mPresenter).a(paramIntent, l1, paramInt))
      return (SendMediaDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_media_data");
    return null;
  }

  private void a(long paramLong, SendMediaDataContainer paramSendMediaDataContainer, Bundle paramBundle)
  {
    SendMediaDataContainer localSendMediaDataContainer = new SendMediaDataContainer(this.c, paramSendMediaDataContainer);
    localSendMediaDataContainer.croppedImage = paramSendMediaDataContainer.fileUri;
    localSendMediaDataContainer.useConversionIfRequire = false;
    this.i.a(paramLong, Collections.singletonList(localSendMediaDataContainer), paramBundle);
  }

  private Bundle b(int paramInt, Intent paramIntent)
  {
    return (Bundle)paramIntent.getParcelableExtra("options");
  }

  private void b(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("seq_extra", 0L);
    String str1 = paramIntent.getStringExtra("save_file_to_dir_path");
    String str2 = paramIntent.getStringExtra("extra_file_name");
    ((SendMessagePresenter)this.mPresenter).a(l1, str1, str2);
  }

  private void c(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      BotReplyRequest localBotReplyRequest = (BotReplyRequest)paramIntent.getParcelableExtra("extra_bot_reply_pending_request");
      double d1 = paramIntent.getIntExtra("extra_location_lat", 0) / 1000000.0D;
      double d2 = paramIntent.getIntExtra("extra_location_lon", 0) / 1000000.0D;
      String str = paramIntent.getStringExtra("extra_location_text");
      ((SendMessagePresenter)this.mPresenter).a(localBotReplyRequest, d1, d2, str);
    }
  }

  private void d(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i1 = 10 * paramIntent.getIntExtra("extra_location_lat", 0);
      int i2 = 10 * paramIntent.getIntExtra("extra_location_lon", 0);
      String str = paramIntent.getStringExtra("extra_location_text");
      this.i.a(i1, i2, str, null);
    }
  }

  private void e(boolean paramBoolean)
  {
    if (this.h != null)
      this.h.a(paramBoolean);
  }

  private void j()
  {
    this.k = new bu(this.d);
    this.i.setSendMessageActions((MessageComposerView.k)this.mPresenter);
    this.l.a((d.k)this.mPresenter);
    this.l.a((d.g)this.mPresenter);
    this.l.a((d.f)this.mPresenter);
    this.l.a((d.i)this.mPresenter);
    this.l.a((d.e)this.mPresenter);
    this.l.a((d.n)this.mPresenter);
    this.l.a((d.l)this.mPresenter);
    this.l.a((d.m)this.mPresenter);
    this.l.a((d.o)this.mPresenter);
    this.l.a((d.d)this.mPresenter);
    this.l.a((com.viber.voip.messages.ui.d.c)this.mPresenter);
    this.l.a((d.p)this.mPresenter);
    this.m.a(this.i);
    this.m.a((d.g)this.mPresenter);
  }

  private void k()
  {
    if (this.h != null)
      this.h.notifyDataSetChanged();
  }

  private void l()
  {
    this.i = ((MessageComposerView)this.mRootView.findViewById(R.id.message_composer));
    this.j = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
  }

  public void a()
  {
    this.e.o_();
    e(false);
    k();
  }

  public void a(int paramInt, aa paramaa)
  {
    if (paramInt == R.id.menu_edit)
      ((SendMessagePresenter)this.mPresenter).b(paramaa);
  }

  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle(2);
    n.a(localBundle, "Keyboard");
    n.a(localBundle, ((SendMessagePresenter)this.mPresenter).p());
    Intent localIntent = ViberActionRunner.bp.a(this.c, paramLong1, paramLong2, paramString, paramInt1, paramInt2, localBundle);
    this.d.startActivityForResult(localIntent, 106);
    this.j.c();
  }

  @SuppressLint({"MissingPermission"})
  public void a(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("open_camera", false);
    paramIntent.removeExtra("open_camera");
    ((SendMessagePresenter)this.mPresenter).d(bool);
  }

  public void a(Intent paramIntent, Uri paramUri, ConversationData paramConversationData, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramIntent != null);
    for (String str = paramIntent.getType(); ; str = null)
    {
      Uri localUri = com.viber.voip.util.upload.o.a(paramUri, paramUri);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(GalleryItem.from(localUri, str));
      Intent localIntent1 = ViberActionRunner.x.a(this.c, paramConversationData, localArrayList, paramBundle);
      Intent localIntent2 = m.a(paramConversationData, false);
      localIntent2.addFlags(67108864);
      localIntent2.putExtra("open_camera", paramBoolean);
      localIntent1.putExtra("open_on_canceled_action", localIntent2);
      this.c.startActivity(localIntent1);
      return;
    }
  }

  public void a(Uri paramUri)
  {
    boolean bool = ViberActionRunner.a(this.d, paramUri, 1);
    ((SendMessagePresenter)this.mPresenter).e(bool);
  }

  public void a(Uri paramUri, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    MediaPreviewActivity.a(this.d, this.d.ah().r(), paramUri.getPath(), paramUri, true, paramBoolean, paramInt, paramBundle);
  }

  public void a(Member paramMember, g.a parama)
  {
    g.a(this.c, paramMember, parama);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ViberActionRunner.af.a(this.c, paramConversationItemLoaderEntity);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2)
  {
    if (!c.h.f.e())
      this.j.a(R.id.options_menu_open_old_chat_extensions, true);
    while (paramConversationItemLoaderEntity == null)
      return;
    this.j.c();
    dj.d(this.c);
    ViberActionRunner.m.a(this.d, paramConversationItemLoaderEntity, paramChatExtensionLoaderEntity, paramString2, false, this.f, paramString1);
  }

  public void a(ConversationData paramConversationData)
  {
    ViberActionRunner.x.a(this.c, paramConversationData, ((SendMessagePresenter)this.mPresenter).b("Full Screen Gallery"));
  }

  public void a(ConversationData paramConversationData, ArrayList<GalleryItem> paramArrayList, Bundle paramBundle)
  {
    if (this.n == null)
      this.n = g();
    this.n.a(paramConversationData, paramArrayList, paramBundle);
  }

  public void a(List<SendMediaDataContainer> paramList, Bundle paramBundle)
  {
    this.i.a(paramList, paramBundle);
  }

  public void a(boolean paramBoolean)
  {
    Intent localIntent = ViberActionRunner.a(this.c, 2, false);
    if (localIntent == null)
    {
      ViberApplication.getInstance().showToast(this.c.getString(R.string.toast_maps_lib_missing));
      return;
    }
    localIntent.putExtra("fromConversation", true);
    if (paramBoolean)
      localIntent = c.a(localIntent);
    this.d.startActivityForResult(localIntent, 101);
  }

  public void a(boolean paramBoolean, long paramLong)
  {
    Bundle localBundle = n.a(null, "Doodle Screen");
    DoodleActivity.a(this.d, paramLong, "", null, 2, paramBoolean, localBundle);
  }

  public void a(boolean paramBoolean, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2)
  {
    a(paramConversationItemLoaderEntity, paramString1, paramChatExtensionLoaderEntity, paramString2);
    if (paramBoolean)
      this.i.t();
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    ((SendMessagePresenter)this.mPresenter).a(paramArrayOfMessageEntity, paramBundle);
  }

  public void b()
  {
    ViberActionRunner.a(this.d, null);
  }

  public void b(List<SendMediaDataContainer> paramList, Bundle paramBundle)
  {
    this.i.a(paramList, paramBundle);
    if (this.j.b(R.id.options_menu_open_gallery))
      this.j.c();
  }

  public void b(boolean paramBoolean)
  {
    this.k.a(paramBoolean);
  }

  public void c()
  {
    ViberApplication.getInstance().showToast(R.string.custom_cam_unable_to_use_camera);
  }

  public void c(boolean paramBoolean)
  {
    ViberActionRunner.a(this.d, paramBoolean);
  }

  public void d()
  {
    if (!this.m.b())
    {
      Context localContext = this.d.getContext();
      if (localContext != null)
      {
        List localList = this.m.c();
        ArrayList localArrayList = new ArrayList(localList.size());
        int i1 = localList.size();
        for (int i2 = 0; i2 < i1; i2++)
          localArrayList.add(new SendMediaDataContainer(localContext, (GalleryItem)localList.get(i2)));
        this.i.a(localArrayList, ((SendMessagePresenter)this.mPresenter).b("Keyboard"));
        this.m.a();
      }
    }
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
      this.l.g();
  }

  public void e()
  {
    this.j.a(R.id.options_menu_open_gallery, true);
  }

  public void f()
  {
    this.o.removeCallbacksAndMessages(this.p);
    Snackbar localSnackbar = com.viber.voip.ui.i.a.a(this.mRootView);
    localSnackbar.show();
    Handler localHandler = this.o;
    localSnackbar.getClass();
    localHandler.postAtTime(v.a(localSnackbar), this.p, 5000L + SystemClock.uptimeMillis());
  }

  public com.viber.voip.camrecorder.preview.d g()
  {
    return new com.viber.voip.camrecorder.preview.d(new d.b(this.d))
    {
      protected int a()
      {
        return 10;
      }

      protected int b()
      {
        return 9;
      }

      protected int c()
      {
        return 104;
      }
    };
  }

  public void i()
  {
    if (this.f)
      this.d.getChildFragmentManager().popBackStack();
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default:
      case 1000:
      case 1001:
      case 102:
      case 103:
      case 1:
      case 105:
      case 101:
      case 2:
      case 9:
      case 10:
        SendMediaDataContainer localSendMediaDataContainer1;
        do
        {
          SendMediaDataContainer localSendMediaDataContainer2;
          long l1;
          do
          {
            do
            {
              do
              {
                Bundle localBundle5;
                do
                {
                  do
                  {
                    do
                      return true;
                    while (paramIntent == null);
                    Bundle localBundle6 = (Bundle)paramIntent.getParcelableExtra("data");
                    MessageEntity[] arrayOfMessageEntity = (MessageEntity[])ParcelableUtils.a(localBundle6.getParcelable("pending_messages"));
                    Bundle localBundle7 = (Bundle)localBundle6.getParcelable("options");
                    this.d.b(arrayOfMessageEntity, localBundle7);
                    return true;
                  }
                  while (paramIntent == null);
                  localBundle5 = (Bundle)paramIntent.getParcelableExtra("data");
                }
                while ((localBundle5 == null) || (this.d == null));
                this.d.b(localBundle5);
                return true;
              }
              while (paramIntent == null);
              ae localae = new ae(paramIntent);
              ((SendMessagePresenter)this.mPresenter).a(localae);
              return true;
            }
            while (paramIntent == null);
            localSendMediaDataContainer2 = a(paramInt1, paramIntent);
            l1 = paramIntent.getLongExtra("com.viber.voip.custom_cam_media_preview_conversation_id", -1L);
          }
          while (localSendMediaDataContainer2 == null);
          Bundle localBundle3 = b(paramInt1, paramIntent);
          DoodleDataContainer localDoodleDataContainer2 = (DoodleDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_doodle_data");
          if ((localDoodleDataContainer2 != null) && (localDoodleDataContainer2.doodleSize > 0L));
          Bundle localBundle4;
          for (boolean bool3 = true; ; bool3 = false)
          {
            localBundle4 = n.a(localBundle3, bool3);
            if (!localBundle4.getBoolean("com.viber.voip.media_from_recent_gallery", false))
              break;
            b(Collections.singletonList(localSendMediaDataContainer2), localBundle4);
            return true;
          }
          a(l1, localSendMediaDataContainer2, localBundle4);
          return true;
          ((SendMessagePresenter)this.mPresenter).a(paramIntent);
          return true;
          c(paramIntent);
          return true;
          d(paramIntent);
          return true;
          localSendMediaDataContainer1 = a(paramInt1, paramIntent);
        }
        while (localSendMediaDataContainer1 == null);
        Bundle localBundle1 = b(paramInt1, paramIntent);
        DoodleDataContainer localDoodleDataContainer1 = (DoodleDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_doodle_data");
        boolean bool1 = false;
        if (localDoodleDataContainer1 != null)
        {
          boolean bool2 = localDoodleDataContainer1.doodleSize < 0L;
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
        Bundle localBundle2 = n.a(localBundle1, bool1);
        b(Collections.singletonList(localSendMediaDataContainer1), localBundle2);
        return true;
      case 104:
        ArrayList localArrayList3 = paramIntent.getParcelableArrayListExtra("image_list");
        this.m.a(localArrayList3);
        return true;
      case 911:
        ComposeDataContainer localComposeDataContainer = (ComposeDataContainer)paramIntent.getParcelableExtra("compose_data_extra");
        this.i.a(localComposeDataContainer, this.k, ((SendMessagePresenter)this.mPresenter).b(null));
        return true;
      case 11:
        ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("send_file_path");
        ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          File localFile = new File((String)localIterator.next());
          if (localFile.exists())
            localArrayList2.add(Uri.fromFile(localFile));
        }
        this.i.a(localArrayList2, Collections.emptyList(), Collections.emptyList(), null);
        return true;
      case 12:
        b(paramIntent);
        return true;
      case 106:
        ((SendMessagePresenter)this.mPresenter).t();
        this.e.o_();
        return true;
      case 107:
      }
      this.b.setSoftInputMode(this.g);
      return true;
    }
    if (paramInt2 == 0)
      ((SendMessagePresenter)this.mPresenter).u();
    return false;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.l.e();
    this.m.f();
    this.o.removeCallbacksAndMessages(this.p);
  }

  public void onPause()
  {
    this.b.setSoftInputMode(48);
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.b.setSoftInputMode(this.g);
  }

  public void onStart()
  {
    super.onStart();
    this.l.c();
    this.m.d();
  }

  public void onStop()
  {
    super.onStop();
    this.l.d();
    this.m.e();
    this.b.setSoftInputMode(this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.u
 * JD-Core Version:    0.6.2
 */