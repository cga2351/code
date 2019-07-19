package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.cd;
import java.io.Serializable;
import java.util.Queue;

public class e
{
  public static h.a a()
  {
    return (h.a)((h.a)((h.a)((h.a)h.j().a(DialogCode.D711)).d(R.string.dialog_711_title)).f(R.string.dialog_711_message)).i(R.string.dialog_button_ok).a(false);
  }

  public static k.a a(MessageEntity paramMessageEntity)
  {
    ViberDialogHandlers.s locals = new ViberDialogHandlers.s(new a(paramMessageEntity));
    String str = c.c().c(paramMessageEntity.getMemberId(), cd.j(paramMessageEntity.getConversationType())).o();
    return (k.a)((k.a)((k.a)((k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D1601)).d(R.string.dialog_1601_title)).f(R.string.dialog_1601_message)).b(-1, new Object[] { str })).e(R.layout.dialog_content_three_buttons_2_1)).c(R.id.button3, R.string.dialog_button_send_upgrade_link)).d(R.id.button2, R.string.dialog_button_save_to_gallery).e(R.id.button1, R.string.dialog_button_cancel)).a(locals)).a(false);
  }

  public static l.a a(String paramString1, String paramString2, String paramString3)
  {
    ViberDialogHandlers.bl localbl = new ViberDialogHandlers.bl();
    localbl.a = paramString1;
    localbl.b = paramString2;
    localbl.c = paramString3;
    return (l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D701a)).f(R.string.dialog_701a_message)).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel).a(localbl);
  }

  public static l.a a(Queue<a> paramQueue)
  {
    a locala = (a)paramQueue.peek();
    ViberDialogHandlers.bp localbp = new ViberDialogHandlers.bp(paramQueue);
    String str = c.c().c(locala.a, cd.j(locala.h)).o();
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D728)).d(R.string.dialog_728_title)).f(R.string.dialog_728_message)).b(-1, new Object[] { str })).i(R.string.dialog_button_send_upgrade_link)).a(localbp)).a(false);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)((h.a)h.j().a(DialogCode.D711b)).d(R.string.dialog_711_title)).f(R.string.dialog_711b_message)).i(R.string.dialog_button_ok).a(false);
  }

  public static h.a c()
  {
    return (h.a)((h.a)((h.a)((h.a)h.j().d(R.string.dialog_725_title)).f(R.string.dialog_725_message)).i(R.string.dialog_button_update_now).b(false)).a(DialogCode.D725);
  }

  public static l.a d()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_726_title)).f(R.string.dialog_726_message)).i(R.string.dialog_button_update_now)).m(R.string.dialog_button_later).b(false)).a(DialogCode.D726);
  }

  public static class a
    implements Serializable
  {
    final String a;
    final long b;
    final long c;
    final String d;
    final int e;
    final boolean f;
    final int g;
    final int h;

    public a(MessageEntity paramMessageEntity)
    {
      this.a = paramMessageEntity.getMemberId();
      this.b = paramMessageEntity.getConversationId();
      this.c = paramMessageEntity.getId();
      this.d = paramMessageEntity.getMediaUri();
      this.e = paramMessageEntity.getMimeType();
      this.f = paramMessageEntity.isForwardedMessage();
      this.g = paramMessageEntity.getNativeChatType();
      this.h = paramMessageEntity.getConversationType();
    }
  }

  public static class b
    implements Serializable
  {
    public final long a;
    public final String b;
    public int c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final boolean g;
    public final boolean h;
    public final long i;
    public final String j;
    public final long k;
    public final long l;
    public final String m;
    public final int n;
    public final String o;

    public b(aa paramaa)
    {
      this.c = paramaa.q();
      this.a = paramaa.a();
      this.b = paramaa.C();
      this.d = paramaa.ao();
      this.e = paramaa.O();
      this.f = paramaa.v();
      this.g = paramaa.aS();
      this.i = paramaa.bz().getFileSize();
      this.h = paramaa.U();
      this.j = paramaa.h();
      this.k = paramaa.c();
      this.m = paramaa.d();
      this.l = paramaa.y();
      this.n = paramaa.bG();
      this.o = paramaa.bp();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.e
 * JD-Core Version:    0.6.2
 */