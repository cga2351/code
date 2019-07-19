package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.viber.voip.backgrounds.m;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import java.util.Locale;

public class ay extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
{
  private final c a;
  private com.viber.voip.messages.conversation.adapter.d.aa b;
  private TextView c;
  private com.viber.voip.messages.conversation.adapter.a.a d;
  private String e;
  private String f;
  private CharSequence g;
  private CharSequence h;

  public ay(TextView paramTextView, c paramc, com.viber.voip.messages.conversation.adapter.d.aa paramaa)
  {
    this.c = paramTextView;
    this.a = paramc;
    this.b = paramaa;
  }

  private CharSequence a(String paramString)
  {
    if (paramString.equals(this.f))
      return this.h;
    this.h = c(paramString);
    this.f = paramString;
    return this.h;
  }

  private void a(i parami)
  {
    com.viber.voip.messages.conversation.aa localaa = this.d.c();
    String str1 = localaa.bv();
    if ((localaa.bt()) || (TextUtils.isEmpty(str1)))
    {
      dj.c(this.c, 8);
      return;
    }
    String str2 = localaa.bu();
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.a(str1);
    if (localChatExtensionLoaderEntity != null);
    for (String str3 = localChatExtensionLoaderEntity.getHeaderText(); ; str3 = null)
    {
      if ((TextUtils.isEmpty(str2)) && (localaa.V()))
        str2 = localaa.getViberName();
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))
        break;
      dj.c(this.c, 8);
      return;
    }
    if ((this.d.h()) && (localaa.V()))
    {
      dj.c(this.c, 8);
      return;
    }
    if (localaa.O())
    {
      dj.c(this.c, 8);
      return;
    }
    dj.c(this.c, 0);
    if (!TextUtils.isEmpty(str3))
    {
      localCharSequence = a(str3);
      if ((localCharSequence.length() <= 25) || (TextUtils.isEmpty(str2)));
    }
    for (CharSequence localCharSequence = b(str2); ; localCharSequence = b(str2))
    {
      this.c.setText(localCharSequence);
      this.c.setTextColor(parami.l());
      this.c.setLinkTextColor(parami.l());
      this.c.setMovementMethod(LinkMovementMethod.getInstance());
      if (!m.a(this.c.getContext(), parami.l()))
        break;
      this.c.setShadowLayer(1.0F, 0.0F, 1.0F, parami.s());
      return;
    }
    this.c.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }

  private CharSequence b(String paramString)
  {
    if (paramString.equals(this.e))
      return this.g;
    this.g = c(String.format(Locale.US, "<lnk>%s</lnk>", new Object[] { paramString }));
    this.e = paramString;
    return this.g;
  }

  private CharSequence c(String paramString)
  {
    com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.a locala = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.a(new az(this));
    return Html.fromHtml(String.format(Locale.US, "<update_handler>%s</update_handler>", new Object[] { paramString }), null, locala);
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    super.a(parama, parami);
    this.d = parama;
    a(parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ay
 * JD-Core Version:    0.6.2
 */