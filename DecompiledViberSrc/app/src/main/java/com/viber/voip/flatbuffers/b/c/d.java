package com.viber.voip.flatbuffers.b.c;

import com.google.d.g;
import com.google.d.p;
import com.viber.voip.flatbuffers.c.aa;
import com.viber.voip.flatbuffers.c.ab;
import com.viber.voip.flatbuffers.c.c;
import com.viber.voip.flatbuffers.c.e;
import com.viber.voip.flatbuffers.c.i;
import com.viber.voip.flatbuffers.c.l;
import com.viber.voip.flatbuffers.c.m;
import com.viber.voip.flatbuffers.c.n;
import com.viber.voip.flatbuffers.c.o;
import com.viber.voip.flatbuffers.c.q;
import com.viber.voip.flatbuffers.c.v;
import com.viber.voip.flatbuffers.c.w;
import com.viber.voip.flatbuffers.c.x;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.b;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.FavoritesMetadata;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements com.viber.voip.flatbuffers.b.a<MsgInfo>, com.viber.voip.flatbuffers.b.b<MsgInfo>
{
  private com.google.d.f a;

  private com.google.d.f a()
  {
    if (this.a == null)
      this.a = b();
    return this.a;
  }

  private void a(BotReplyConfig paramBotReplyConfig, boolean paramBoolean)
  {
    if (paramBotReplyConfig == null);
    int n;
    label37: 
    do
    {
      return;
      if (paramBotReplyConfig.getButtonsGroupColumns() <= 0)
      {
        if (paramBoolean);
        paramBotReplyConfig.setButtonsGroupColumns(6);
      }
      if (paramBotReplyConfig.getButtonsGroupRows() <= 0)
      {
        if (!paramBoolean)
          break;
        n = 7;
        paramBotReplyConfig.setButtonsGroupRows(n);
      }
    }
    while (paramBotReplyConfig.getButtons() == null);
    int i;
    if (paramBoolean)
      i = paramBotReplyConfig.getButtonsGroupRows();
    for (int j = paramBotReplyConfig.getButtonsGroupColumns(); ; j = paramBotReplyConfig.getButtonsGroupColumns())
    {
      for (ReplyButton localReplyButton : paramBotReplyConfig.getButtons())
      {
        if (localReplyButton.getRows() <= 0)
          localReplyButton.setRows(i);
        if (localReplyButton.getColumns() <= 0)
          localReplyButton.setColumns(j);
      }
      break;
      n = 2;
      break label37;
      i = 1;
    }
  }

  private static com.google.d.f b()
  {
    g localg = new g();
    localg.a(MsgInfo.a.class, new m());
    localg.a(MediaInfo.a.class, new l());
    localg.a(FileInfo.a.class, new com.viber.voip.flatbuffers.c.f());
    localg.a(FileInfo.b.class, new ab());
    localg.a(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a.class, new i());
    localg.a(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.class, new aa());
    localg.a(ReplyButton.a.class, new o());
    localg.a(ReplyButton.b.class, new c());
    localg.a(ReplyButton.c.class, new q());
    localg.a(ReplyButton.g.class, new v());
    localg.a(UnsignedInt.class, new w());
    localg.a(UnsignedLong.class, new x());
    localg.a(Pin.a.class, new n());
    localg.a(FavoritesMetadata.class, new e());
    return localg.a();
  }

  public String a(MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null)
      return "{}";
    try
    {
      String str = b().b(paramMsgInfo);
      return str;
    }
    catch (p localp)
    {
    }
    return "{}";
  }

  public JSONObject b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  // ERROR //
  public MsgInfo c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +12 -> 16
    //   7: ldc 149
    //   9: aload_1
    //   10: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +13 -> 26
    //   16: new 142	com/viber/voip/flatbuffers/model/msginfo/MsgInfo
    //   19: dup
    //   20: invokespecial 177	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: invokespecial 178	com/viber/voip/flatbuffers/b/c/d:a	()Lcom/google/d/f;
    //   30: aload_1
    //   31: ldc 142
    //   33: invokevirtual 181	com/google/d/f:a	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: checkcast 142	com/viber/voip/flatbuffers/model/msginfo/MsgInfo
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +34 -> 75
    //   44: aload_2
    //   45: invokevirtual 185	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getPublicAccountMsgInfo	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo;
    //   48: ifnull +27 -> 75
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 185	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getPublicAccountMsgInfo	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo;
    //   56: invokevirtual 191	com/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo:getRichMedia	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/bot/BotReplyConfig;
    //   59: iconst_1
    //   60: invokespecial 193	com/viber/voip/flatbuffers/b/c/d:a	(Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/bot/BotReplyConfig;Z)V
    //   63: aload_0
    //   64: aload_2
    //   65: invokevirtual 185	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getPublicAccountMsgInfo	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo;
    //   68: invokevirtual 196	com/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo:getKeyboard	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/bot/BotReplyConfig;
    //   71: iconst_0
    //   72: invokespecial 193	com/viber/voip/flatbuffers/b/c/d:a	(Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/bot/BotReplyConfig;Z)V
    //   75: aload_2
    //   76: ifnonnull -52 -> 24
    //   79: ldc 198
    //   81: new 200	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   88: ldc 203
    //   90: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: new 142	com/viber/voip/flatbuffers/model/msginfo/MsgInfo
    //   107: dup
    //   108: invokespecial 177	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:<init>	()V
    //   111: areturn
    //   112: astore 5
    //   114: aconst_null
    //   115: astore_2
    //   116: goto -41 -> 75
    //   119: astore 7
    //   121: goto -46 -> 75
    //   124: astore_3
    //   125: aconst_null
    //   126: astore_2
    //   127: goto -52 -> 75
    //   130: astore 6
    //   132: goto -57 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   26	40	112	com/google/d/p
    //   44	75	119	com/google/d/p
    //   26	40	124	java/lang/NumberFormatException
    //   44	75	130	java/lang/NumberFormatException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.c.d
 * JD-Core Version:    0.6.2
 */