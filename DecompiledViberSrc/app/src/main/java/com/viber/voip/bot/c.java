package com.viber.voip.bot;

import android.graphics.Rect;
import android.net.Uri;
import android.text.Html;
import com.viber.dexshared.Logger;
import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.ServiceMetadata;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BotKeyboardSendData;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BrowserData;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.MediaPlayer;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.d;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.e;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.h;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.ChatExOpenInternalBrowserAction;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.orm.entity.json.action.ViewGifAction;
import com.viber.voip.messages.orm.entity.json.action.ViewMultipleMediaAction;
import com.viber.voip.messages.orm.entity.json.action.ViewPhotoAction;
import com.viber.voip.messages.orm.entity.json.action.ViewRichPlayableMediaAction;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.ap;
import com.viber.voip.util.as;
import com.viber.voip.util.aw;
import com.viber.voip.util.bg;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final ReplyButton b;
  private final String c;
  private final long d;
  private final int e;
  private final String f;
  private final String g;
  private final long h;
  private final int i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private final MsgInfo n;
  private final boolean o;
  private final String p;
  private final int q;
  private a r;
  private final com.viber.voip.messages.extensions.c s;
  private BotReplyConfig t;

  public c(long paramLong1, int paramInt1, String paramString1, com.viber.voip.messages.extensions.c paramc, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, String paramString2, long paramLong2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, MsgInfo paramMsgInfo, int paramInt2, boolean paramBoolean3)
  {
    this.s = paramc;
    this.t = paramBotReplyConfig;
    this.b = paramReplyButton;
    this.q = paramInt2;
    this.c = paramString1;
    this.f = paramString2;
    this.h = paramLong2;
    this.d = paramLong1;
    this.e = paramInt1;
    this.n = paramMsgInfo;
    this.p = com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
    this.l = paramBoolean1;
    this.g = paramString3;
    this.m = paramBoolean2;
    int i1;
    Boolean localBoolean;
    boolean bool2;
    if (this.l)
    {
      i1 = 0;
      this.i = i1;
      localBoolean = paramReplyButton.isSilent();
      if (localBoolean != null)
        break label201;
      if ((this.l) || (paramReplyButton.getReplyType() != ReplyButton.b.QUERY))
        break label195;
      bool2 = true;
      label148: this.j = bool2;
      label154: if ((!paramBoolean2) && ((this.l) || (!this.j)))
        break label213;
    }
    label195: label201: label213: for (boolean bool1 = true; ; bool1 = false)
    {
      this.k = bool1;
      this.o = paramBoolean3;
      return;
      i1 = 4;
      break;
      bool2 = false;
      break label148;
      this.j = localBoolean.booleanValue();
      break label154;
    }
  }

  private void a(Uri paramUri, ReplyButton.c paramc, h paramh)
  {
    String str1 = paramUri.toString();
    String str2 = MsgInfo.a.IMAGE.getTypeName();
    StringBuilder localStringBuilder = new StringBuilder().append(str2).append("/");
    if (paramc == ReplyButton.c.GIF);
    for (String str3 = as.b.a(); ; str3 = as.a.a())
    {
      String str4 = str3;
      String str5 = paramUri.getLastPathSegment();
      MessageEntity localMessageEntity = paramh.a(8, str1, 0, this.p, 0);
      LinkParser.Preview localPreview = new LinkParser.Preview(str5, str2, str1, str1, str4, 1, "", "", "", "");
      MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
      com.viber.voip.util.links.b.a(localMsgInfo, str1, str1, localPreview);
      if (paramc == ReplyButton.c.GIF)
      {
        File localFile = dv.u.b(ViberApplication.getApplication(), str1, false);
        if (localFile != null)
        {
          Rect localRect = aw.a(Uri.fromFile(localFile));
          localMsgInfo.setThumbnailHeight(localRect.height());
          localMsgInfo.setThumbnailWidth(localRect.width());
        }
      }
      ViberApplication.getInstance().getDownloadValve().f(str1);
      m.a(localMessageEntity, localMsgInfo);
      this.r.a(localMessageEntity);
      return;
    }
  }

  private void a(h paramh)
  {
    String str = this.b.getText();
    if (!da.a(str))
      a(paramh, 0, Html.fromHtml(str).toString());
    Uri localUri;
    do
    {
      return;
      if (this.b.getImageUri() != null)
      {
        a(this.b.getImageUri(), this.b.getBgMediaType(), paramh);
        return;
      }
      if (this.b.getBgMedia() != null)
      {
        a(this.b.getBgMedia(), this.b.getBgMediaType(), paramh);
        return;
      }
      localUri = j.a(this.b.getBgColor().intValue());
    }
    while (localUri == null);
    a(paramh, 1, localUri.toString());
  }

  private void a(h paramh, int paramInt, String paramString)
  {
    if (paramInt == 0);
    for (MessageEntity localMessageEntity = paramh.a(0, paramString, 0, this.p, 0); ; localMessageEntity = paramh.a(paramInt, paramString, "", this.p, 0))
    {
      this.r.a(localMessageEntity);
      return;
    }
  }

  private void a(MessageEntity paramMessageEntity)
  {
    MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
    PublicAccountReplyData localPublicAccountReplyData = new PublicAccountReplyData();
    localPublicAccountReplyData.setButton(this.b);
    localMsgInfo.setPublicAccountReplyData(localPublicAccountReplyData);
    Boolean localBoolean = this.b.isSilent();
    ServiceMetadata localServiceMetadata = localMsgInfo.getServiceMetadata();
    if ((localBoolean != null) && (localBoolean.booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      localServiceMetadata.setSilent(bool);
      paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
      return;
    }
  }

  private a b()
  {
    this.r = new a();
    ReplyButton.a locala = this.b.getActionType();
    this.r.a(locala);
    if (locala == ReplyButton.a.NONE)
      return this.r;
    com.viber.voip.messages.controller.c.b localb;
    if (!this.k)
    {
      localb = new com.viber.voip.messages.controller.c.b(this.d, this.h, this.c, this.e, 0);
      if (!com.viber.voip.publicaccount.d.e.a(locala))
        break label252;
      a(localb);
    }
    while (true)
    {
      if (locala == ReplyButton.a.OPEN_URL)
      {
        Action localAction = f();
        if (localAction != null)
          this.r.a(localAction);
      }
      MessageEntity localMessageEntity = this.r.a();
      if (localMessageEntity != null)
      {
        if (this.l)
        {
          a(localMessageEntity);
          localMessageEntity.setBucket(this.b.getActionBody());
          localMessageEntity.addExtraFlag(21);
        }
        if (this.j)
          localMessageEntity.addExtraFlag(22);
      }
      this.r.a(this.b.getReplyType());
      this.r.a(this.j);
      this.r.b(this.b.getActionBody());
      this.r.c(this.f);
      this.r.a(this.h);
      this.r.a(this.g);
      this.r.a(this.i);
      return this.r;
      label252: switch (1.a[locala.ordinal()])
      {
      default:
        break;
      case 1:
        b(localb);
      }
    }
  }

  private void b(h paramh)
  {
    String str = this.b.getActionBody();
    if (this.b.getOpenUrlType().equals(ReplyButton.e.INTERNAL))
    {
      InternalBrowser localInternalBrowser = this.b.getInternalBrowserSection();
      if ((localInternalBrowser != null) && (localInternalBrowser.getActionButton() == InternalBrowser.a.SEND_TO_BOT) && (this.n != null) && (this.n.getBotKeyboardSendData() != null) && (this.n.getBotKeyboardSendData().getBrowserData() != null))
        str = this.n.getBotKeyboardSendData().getBrowserData().getUrl();
    }
    if (str == null)
      str = "message";
    a(paramh, 0, str);
  }

  private ViewRichPlayableMediaAction c()
  {
    MediaPlayer localMediaPlayer = this.b.getMediaPlayer();
    String str1 = bg.b(this.b.getActionBody());
    String str2;
    String str7;
    if (localMediaPlayer != null)
    {
      str2 = localMediaPlayer.getThumbnailURL();
      if (!da.a(str2))
        break label282;
      Uri localUri = this.b.getBgMedia();
      if (localUri == null)
        break label245;
      str7 = localUri.toString();
    }
    label56: for (String str3 = str7; ; str3 = str2)
    {
      BotReplyRequest localBotReplyRequest = null;
      if (localMediaPlayer != null)
      {
        boolean bool4 = da.a(localMediaPlayer.getActionReplyData());
        localBotReplyRequest = null;
        if (!bool4)
          localBotReplyRequest = new BotReplyRequest(this.g, this.t, this.b, this.h, this.d, this.e, this.l, this.m, false, this.f, this.o, this.q);
      }
      long l1 = this.d;
      boolean bool1;
      String str4;
      String str5;
      boolean bool2;
      if (ReplyButton.d.AUDIO != this.b.getOpenUrlMediaType())
      {
        bool1 = true;
        if (localMediaPlayer == null)
          break label258;
        str4 = localMediaPlayer.getTitle();
        if (localMediaPlayer == null)
          break label264;
        str5 = localMediaPlayer.getSubtitle();
        if ((localMediaPlayer == null) || (!localMediaPlayer.isLoop()))
          break label270;
        bool2 = true;
        label194: if (localMediaPlayer == null)
          break label276;
      }
      for (String str6 = localMediaPlayer.getActionReplyData(); ; str6 = null)
      {
        boolean bool3 = this.s.f();
        return new ViewRichPlayableMediaAction(localBotReplyRequest, str1, str3, l1, bool1, str4, str5, bool2, str6, bool3);
        str2 = null;
        break;
        label245: str7 = "";
        break label56;
        bool1 = false;
        break label160;
        str4 = null;
        break label170;
        str5 = null;
        break label180;
        bool2 = false;
        break label194;
      }
    }
  }

  private Action d()
  {
    String str = bg.b(this.b.getActionBody());
    if (this.b.getOpenUrlType().equals(ReplyButton.e.INTERNAL))
    {
      InternalBrowser localInternalBrowser = this.b.getInternalBrowserSection();
      BotReplyRequest localBotReplyRequest = null;
      if (localInternalBrowser != null)
      {
        InternalBrowser.a locala1 = localInternalBrowser.getActionButton();
        InternalBrowser.a locala2 = InternalBrowser.a.SEND_TO_BOT;
        localBotReplyRequest = null;
        if (locala1 == locala2)
          localBotReplyRequest = new BotReplyRequest(this.g, this.t, this.b, this.h, this.d, this.e, this.l, this.m, false, this.f, this.o, this.q);
      }
      return new ChatExOpenInternalBrowserAction(this.d, this.e, str, localInternalBrowser, localBotReplyRequest);
    }
    return new OpenUrlAction(str);
  }

  private Action e()
  {
    int i1 = -1;
    ArrayList localArrayList = new ArrayList();
    ReplyButton[] arrayOfReplyButton;
    if (this.t != null)
      arrayOfReplyButton = this.t.getButtons();
    ReplyButton localReplyButton;
    while (true)
    {
      int i2 = arrayOfReplyButton.length;
      for (int i3 = 0; ; i3++)
      {
        if (i3 >= i2)
          break label204;
        localReplyButton = arrayOfReplyButton[i3];
        if (ReplyButton.a.OPEN_URL == localReplyButton.getActionType())
          break;
      }
      arrayOfReplyButton = new ReplyButton[1];
      arrayOfReplyButton[0] = this.b;
    }
    String str = bg.b(localReplyButton.getActionBody());
    int i4;
    switch (1.b[localReplyButton.getOpenUrlMediaType().ordinal()])
    {
    default:
      i4 = 0;
    case 1:
    case 2:
    }
    while ((i4 != 0) && (this.b.equals(localReplyButton)))
    {
      i1 = -1 + localArrayList.size();
      break;
      localArrayList.add(new ViewPhotoAction(str, this.d));
      i4 = 1;
      continue;
      localArrayList.add(new ViewGifAction(str, this.d));
      i4 = 1;
    }
    label204: if (localArrayList.size() == 0)
      return null;
    if (1 == localArrayList.size())
      return (Action)localArrayList.get(0);
    return new ViewMultipleMediaAction(this.d, i1, localArrayList);
  }

  private Action f()
  {
    if ((ReplyButton.d.VIDEO == this.b.getOpenUrlMediaType()) || (ReplyButton.d.AUDIO == this.b.getOpenUrlMediaType()))
      return c();
    if (ReplyButton.d.NOT_MEDIA == this.b.getOpenUrlMediaType())
      return d();
    return e();
  }

  public a a()
  {
    if (this.r == null)
      return b();
    return this.r;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.c
 * JD-Core Version:    0.6.2
 */