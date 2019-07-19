package com.viber.voip.messages.conversation.ui;

import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.publicaccount.d.e;

public class br
  implements Runnable
{
  private final ConversationItemLoaderEntity a;
  private aa b;
  private final ReplyButton c;
  private final int d;
  private final int e;

  public br(ConversationItemLoaderEntity paramConversationItemLoaderEntity, aa paramaa, int paramInt1, int paramInt2, ReplyButton paramReplyButton)
  {
    this.a = paramConversationItemLoaderEntity;
    this.b = paramaa;
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = paramReplyButton;
  }

  public void run()
  {
    int i = 2;
    int j;
    String str1;
    if (this.a.isOneToOneWithPublicAccount())
    {
      j = 4;
      str1 = this.a.getPublicAccountId();
      if (!this.a.isOneToOneWithPublicAccount())
        break label165;
    }
    ReplyButton.a locala;
    int m;
    int k;
    label165: for (String str2 = str1; ; str2 = this.b.bv())
    {
      locala = this.c.getActionType();
      if (locala != ReplyButton.a.OPEN_URL)
        break label177;
      m = 0;
      k = i;
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportClickOnRichMessage(j, str1, this.b.y(), k, m, this.e, 1 + this.d, str2);
      return;
      if (this.a.isPublicGroupType())
      {
        str1 = String.valueOf(this.a.getPublicAccountGroupId());
        j = 3;
        break;
      }
      if (this.a.isGroupType())
      {
        str1 = String.valueOf(this.a.getGroupId());
        j = i;
        break;
      }
      str1 = this.a.getParticipantMemberId();
      j = 1;
      break;
    }
    label177: ReplyButton.b localb;
    if (e.a(locala))
    {
      localb = this.c.getReplyType();
      if (localb != ReplyButton.b.MESSAGE);
    }
    while (true)
    {
      m = i;
      k = 3;
      break;
      if (localb == ReplyButton.b.QUERY)
      {
        i = 1;
        continue;
        k = 1;
        m = 0;
        break;
      }
      i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.br
 * JD-Core Version:    0.6.2
 */