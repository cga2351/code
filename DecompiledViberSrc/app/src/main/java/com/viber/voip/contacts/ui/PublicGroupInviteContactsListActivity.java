package com.viber.voip.contacts.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.messenger.MessageSenderListener;
import com.viber.jni.messenger.MessengerDelegate.MessagesSender;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.InviteSend;
import com.viber.jni.publicgroup.PublicGroupInviteSendListener;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.c.b;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.ViberActionRunner.PublicAccountInviteData;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.dw;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class PublicGroupInviteContactsListActivity extends MultiTabsParticipantSelectorActivity
  implements m.c, MessengerDelegate.MessagesSender, PublicGroupControllerDelegate.InviteSend
{
  private static final Logger e = ViberEnv.getLogger();

  @Inject
  com.viber.voip.messages.k d;
  private Engine f;
  private int g;
  private Set<ParticipantSelector.Participant> h;
  private ProgressDialog i;
  private ViberActionRunner.PublicAccountInviteData j;

  private void b(boolean paramBoolean)
  {
    this.i.cancel();
    if (paramBoolean)
    {
      r.b().a(this).a(this);
      return;
    }
    h.a locala = com.viber.voip.ui.dialogs.k.n();
    int k = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getString(R.string.dialog_339_reason_invite);
    locala.b(k, arrayOfObject).a(this).a(this);
  }

  private int c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return R.string.conversation_info_invite_btn_text;
    case 3:
      return R.string.pg_share_title;
    case 2:
      return R.string.pa_invite_to_follow_title;
    case 1:
    }
    return R.string.pg_share_title;
  }

  protected Fragment a(int paramInt)
  {
    Fragment localFragment = super.a(paramInt);
    if ((paramInt == 0) || (paramInt == 2))
    {
      localFragment.getArguments().putBoolean("show_secret_chats_extra", false);
      localFragment.getArguments().putBoolean("show_public_groups_extra", false);
      if (paramInt == 0)
        localFragment.getArguments().putBoolean("hide_anonymous_extra", true);
    }
    return localFragment;
  }

  public void a(Set<ParticipantSelector.Participant> paramSet)
  {
    if (cj.a(true))
    {
      this.i = ProgressDialog.show(this, null, getString(R.string.inviting), true, true);
      this.h = paramSet;
      this.g = this.f.getPhoneController().generateSequence();
      String[] arrayOfString = new String[paramSet.size()];
      Iterator localIterator = paramSet.iterator();
      int m;
      for (int k = 0; localIterator.hasNext(); k = m)
      {
        ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
        m = k + 1;
        arrayOfString[k] = localParticipant.getMemberId();
      }
      this.d.h().a(this.g, 0, 0L, arrayOfString, 0L, this.j);
    }
  }

  protected boolean b()
  {
    return true;
  }

  protected Fragment c()
  {
    return new ba();
  }

  protected void c(Intent paramIntent)
  {
    ConversationData localConversationData = (ConversationData)paramIntent.getParcelableExtra("extra_conversation_data");
    if (com.viber.voip.messages.m.b(localConversationData.conversationType))
    {
      str = dw.b(this, this.j.getGroupUri());
      localMessageEntity = new b(localConversationData.conversationId, localConversationData.groupId, localConversationData.memberId, localConversationData.conversationType, 0).a(0, str, 0, null, 0);
      this.d.c().a(localMessageEntity, null);
      r.b().a(this).a(this);
    }
    while (!cj.a(true))
    {
      String str;
      MessageEntity localMessageEntity;
      return;
    }
    this.i = ProgressDialog.show(this, null, getString(R.string.inviting), true, true);
    this.g = this.f.getPhoneController().generateSequence();
    this.h = Collections.singleton(new ParticipantSelector.Participant(localConversationData.memberId, null, localConversationData.viberName, null, true));
    d locald = this.d.h();
    int k = this.g;
    int m = localConversationData.conversationType;
    long l = localConversationData.groupId;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localConversationData.memberId;
    locald.a(k, m, l, arrayOfString, localConversationData.conversationId, this.j);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = ViberApplication.getInstance().getEngine(true);
    this.j = ((ViberActionRunner.PublicAccountInviteData)getIntent().getParcelableExtra("pa_invite_data"));
    if (this.j == null)
    {
      finish();
      return;
    }
    getSupportActionBar().b(c(this.j.getInvitedTo()));
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D339)) && (paramInt == -1))
      finish();
    while (!paramm.a(DialogCode.D1003b))
      return;
    finish();
  }

  public boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return false;
  }

  public void onPause()
  {
    super.onPause();
    this.f.getDelegatesManager().getPublicGroupInviteSendListener().removeDelegate(this);
    this.f.getDelegatesManager().getMessageSenderListener().removeDelegate(this);
    if (isFinishing())
      dj.c(getCurrentFocus());
  }

  public void onResume()
  {
    super.onResume();
    this.f.getDelegatesManager().getPublicGroupInviteSendListener().registerDelegate(this, av.e.a.a());
    this.f.getDelegatesManager().getMessageSenderListener().registerDelegate(this, av.e.a.a());
  }

  public void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    int k = 1;
    if (paramInt1 != this.g)
      return;
    if (k == paramInt2);
    while (true)
    {
      b(k);
      return;
      k = 0;
    }
  }

  public void onSendPublicGroupInviteReply(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap)
  {
    if (paramInt1 != this.g)
      return;
    if (paramInt2 == 0);
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.PublicGroupInviteContactsListActivity
 * JD-Core Version:    0.6.2
 */