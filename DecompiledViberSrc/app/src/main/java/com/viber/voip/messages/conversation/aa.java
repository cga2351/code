package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import android.text.Spannable;
import com.viber.dexshared.Logger;
import com.viber.liblinkparser.LinkParser;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.Sender;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.l;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.aj.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.g;
import com.viber.voip.q.k;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.ae;
import com.viber.voip.util.av;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dk;
import com.viber.voip.util.dx;
import com.viber.voip.util.n;
import com.viber.voip.util.upload.ObjectId;
import org.json.JSONException;

public class aa
  implements g
{
  public static final String[] a = { "messages._id", "messages.user_id", "messages.msg_date", "messages.unread", "messages.status", "messages.send_type", "messages.body", "messages.opened", "messages.description", "messages.location_lat", "messages.location_lng", "messages.event_count", "messages.extra_uri", "messages.extra_mime", "messages.extra_duration", "messages.extra_status", "messages.token", "messages.order_key", "messages.seq", "messages.conversation_type", "messages.extra_upload_id", "messages.extra_download_id", "messages.extra_bucket_name", "messages.conversation_id", "messages.flag", "messages.extra_flags", "messages.group_id", "messages.message_global_id", "messages.msg_info", "messages.likes_count", "messages.spans", "messages.scroll_pos", "messages.quoted_message_data", "messages.deleted", "participants_info._id", "participants_info.contact_name", "participants_info.viber_name", "participants_info.number", "participants_info.contact_id", "participants_info.participant_info_flags", "stickers.column_span", "stickers.row_span", "stickers.package_id", "stickers.flags", "remote_banners.tag", "remote_banners.end_time", "remote_banners.flags", "participants.group_role", "participants.active" };
  private static final Logger b = ViberEnv.getLogger();
  private int A;
  private String B;
  private String C;
  private Spannable D;
  private boolean E;
  private int F;
  private int G;
  private boolean H;
  private boolean I;
  private MsgInfo J;
  private long K;
  private String L;
  private String M;
  private String N;
  private long O;
  private int P;
  private String Q;
  private String R;
  private long S;
  private String T;
  private String U;
  private transient FormattedMessage V;
  private Sticker W;
  private String X;
  private QuotedMessageData Y;
  private ConferenceInfo Z;
  private boolean aA;
  private boolean aB;
  private boolean aC;
  private boolean aD;
  private boolean aE;
  private boolean aF;
  private boolean aG;
  private boolean aH;
  private boolean aI;
  private boolean aJ;
  private boolean aK;
  private boolean aL;
  private boolean aM;
  private boolean aN;
  private Uri aO;
  private boolean aP;
  private boolean aQ;
  private boolean aR;
  private boolean aS;
  private boolean aT;
  private String aa;
  private long ab;
  private int ac;
  private transient boolean ad;
  private transient boolean ae;
  private transient boolean af;
  private transient boolean ag;
  private transient String ah;
  private transient String ai;
  private transient int aj;
  private transient String ak;
  private transient String al;
  private transient String am;
  private transient String an;
  private transient com.viber.voip.bot.item.c ao;
  private transient int ap = -1;
  private transient PttUtils.AudioBarsInfo aq;
  private transient boolean ar;
  private transient Uri as;
  private transient int at;
  private boolean au;
  private boolean av;
  private boolean aw;
  private boolean ax;
  private boolean ay;
  private boolean az;
  private long c;
  private long d;
  private String e;
  private long f;
  private int g;
  private int h;
  private String i;
  private int j;
  private String k;
  private int l;
  private int m;
  private int n;
  private int o;
  private String p;
  private int q;
  private long r;
  private int s;
  private ObjectId t = ObjectId.EMPTY;
  private int u;
  private long v;
  private int w;
  private int x;
  private long y;
  private int z;

  public aa(Cursor paramCursor)
  {
    com.viber.common.d.i.a();
    a(this, paramCursor);
  }

  public aa(MessageEntity paramMessageEntity)
  {
    a(this, paramMessageEntity);
  }

  private String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("MessageLoaderEntity [id=").append(this.c).append(", messageGlobalId=").append(this.z).append(", conversationId=").append(this.d).append(", memberId=").append(this.e).append(", date=").append(this.f).append(", status=").append(this.g).append(", type=").append(this.h).append(", body=").append(da.a(this.i, this.q)).append(", opened=").append(this.j).append(", description=").append(this.k).append(", lat=").append(this.l).append(", lng=").append(this.m).append(", count=").append(this.n).append(", unread=").append(this.o).append(", isSecure=").append(Y()).append(", uri=").append(this.p).append(", mimeType=").append(this.q).append(" - ").append(l.c(this.q)).append(", duration=").append(this.r).append(", extraStatus=").append(this.s).append(", objectId=").append(this.t).append(", stickerId=").append(this.t.toStickerId()).append(", conversationType=").append(this.u).append(", token=").append(this.v).append(", seq=").append(this.w).append(", flag=").append(this.x).append(", extraFlags=").append(this.y).append(", participantInfoId=").append(this.K).append(", participantContactName=").append(this.L).append(", participantViberName=").append(this.M).append(", participantNumber=").append(this.N).append(", participantContactId=").append(this.O).append(", participantFlags=").append(this.P).append(", downloadId=").append(this.Q).append(", extraBuket=").append(this.R).append(", formatedDate=").append(this.T).append(", formatedTime=").append(this.U).append(", spans=").append(this.C).append(", rawMessageInfo=");
    String str1;
    StringBuilder localStringBuilder2;
    if (paramBoolean)
    {
      str1 = this.B;
      localStringBuilder2 = localStringBuilder1.append(str1).append(", scrollPosition=").append(this.F).append(", clickerEndTime=").append(this.ab).append(", clickerImageUrl=").append(this.aa).append(", clickerFlags=").append(this.ac).append(", rawQuotedMessageData=");
      if (!paramBoolean)
        break label655;
    }
    label655: for (String str2 = this.X; ; str2 = "***")
    {
      return str2 + ", group role=" + this.G + ", participant banned=" + this.H + "]";
      str1 = "***";
      break;
    }
  }

  private static void a(aa paramaa)
  {
    int i1 = paramaa.q;
    boolean bool1;
    boolean bool2;
    label27: boolean bool3;
    label41: boolean bool4;
    label54: boolean bool5;
    label116: boolean bool6;
    label132: boolean bool7;
    label148: boolean bool8;
    label162: boolean bool9;
    label177: boolean bool10;
    label193: boolean bool11;
    label208: boolean bool12;
    label237: boolean bool13;
    label352: boolean bool14;
    label368: boolean bool15;
    label389: boolean bool16;
    label410: boolean bool17;
    label424: boolean bool18;
    label438: boolean bool19;
    label466: boolean bool20;
    label482: boolean bool21;
    label501: boolean bool22;
    label541: boolean bool23;
    label557: boolean bool24;
    if (8 == i1)
    {
      bool1 = true;
      paramaa.aE = bool1;
      if (1007 != i1)
        break label674;
      bool2 = true;
      paramaa.ax = bool2;
      if (9 != i1)
        break label679;
      bool3 = true;
      paramaa.aF = bool3;
      if (i1 != 0)
        break label685;
      bool4 = true;
      paramaa.ad = bool4;
      paramaa.aL = av.c(paramaa.y, 32);
      if ((1000 != i1) && ((paramaa.ax) || (!paramaa.aL) || (!Pin.a.DELETE.equals(paramaa.bx().getPin().getAction()))))
        break label691;
      bool5 = true;
      paramaa.ae = bool5;
      if (1008 != i1)
        break label697;
      bool6 = true;
      paramaa.af = bool6;
      if (1002 != i1)
        break label703;
      bool7 = true;
      paramaa.ag = bool7;
      if (2 != i1)
        break label709;
      bool8 = true;
      paramaa.av = bool8;
      if (14 != i1)
        break label715;
      bool9 = true;
      paramaa.aw = bool9;
      if (1010 != i1)
        break label721;
      bool10 = true;
      paramaa.aN = bool10;
      if (10 != i1)
        break label727;
      bool11 = true;
      paramaa.ay = bool11;
      if ((7 != i1) && (!paramaa.aF) && (!paramaa.aE))
        break label733;
      bool12 = true;
      paramaa.aC = bool12;
      if ((paramaa.ad) && (paramaa.i != null))
      {
        aj localaj = aj.b();
        if (paramaa.i.length() <= localaj.d())
        {
          aj.a locala = localaj.a(paramaa.i);
          if (locala == null)
            locala = localaj.b(paramaa.i);
          if ((locala != null) && (!paramaa.an()))
          {
            paramaa.ar = true;
            paramaa.at = locala.a();
            paramaa.as = dx.d(locala.c());
          }
        }
      }
      if (1003 != i1)
        break label739;
      bool13 = true;
      paramaa.aH = bool13;
      if (1004 != i1)
        break label745;
      bool14 = true;
      paramaa.aI = bool14;
      if ((1 != i1) && (!paramaa.aH))
        break label751;
      bool15 = true;
      paramaa.aD = bool15;
      if ((3 != i1) && (!paramaa.aI))
        break label757;
      bool16 = true;
      paramaa.aB = bool16;
      if (5 != i1)
        break label763;
      bool17 = true;
      paramaa.aA = bool17;
      if (4 != i1)
        break label769;
      bool18 = true;
      paramaa.az = bool18;
      paramaa.aG = av.c(paramaa.y, 4);
      if (1005 != i1)
        break label775;
      bool19 = true;
      paramaa.aJ = bool19;
      if (1006 != i1)
        break label781;
      bool20 = true;
      paramaa.aK = bool20;
      if (com.viber.voip.flatbuffers.b.c.a(paramaa.X))
        break label787;
      bool21 = true;
      paramaa.aP = bool21;
      if ((paramaa.az()) || (paramaa.aA()))
      {
        if ((paramaa.o() != null) || (dk.a(paramaa.h())))
          break label793;
        bool22 = true;
        paramaa.aQ = bool22;
      }
      if (1009 != i1)
        break label799;
      bool23 = true;
      paramaa.aM = bool23;
      if ((!paramaa.aM) && (!paramaa.av))
        break label805;
      bool24 = true;
      label580: paramaa.aS = bool24;
      if ((!paramaa.aN) && (!paramaa.aw))
        break label811;
    }
    label674: label679: label811: for (boolean bool25 = true; ; bool25 = false)
    {
      paramaa.aT = bool25;
      boolean bool26;
      if ((!paramaa.aD) && (!paramaa.aB) && (!paramaa.av) && (!paramaa.aA))
      {
        boolean bool27 = paramaa.aM;
        bool26 = false;
        if (!bool27);
      }
      else
      {
        bool26 = true;
      }
      paramaa.au = bool26;
      paramaa.aR = paramaa.bR();
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label27;
      bool3 = false;
      break label41;
      label685: bool4 = false;
      break label54;
      label691: bool5 = false;
      break label116;
      label697: bool6 = false;
      break label132;
      label703: bool7 = false;
      break label148;
      label709: bool8 = false;
      break label162;
      label715: bool9 = false;
      break label177;
      label721: bool10 = false;
      break label193;
      label727: bool11 = false;
      break label208;
      label733: bool12 = false;
      break label237;
      label739: bool13 = false;
      break label352;
      label745: bool14 = false;
      break label368;
      label751: bool15 = false;
      break label389;
      label757: bool16 = false;
      break label410;
      label763: bool17 = false;
      break label424;
      bool18 = false;
      break label438;
      bool19 = false;
      break label466;
      bool20 = false;
      break label482;
      bool21 = false;
      break label501;
      bool22 = false;
      break label541;
      bool23 = false;
      break label557;
      bool24 = false;
      break label580;
    }
  }

  private static void a(aa paramaa, Cursor paramCursor)
  {
    int i1 = 1;
    paramaa.c = paramCursor.getLong(0);
    paramaa.e = paramCursor.getString(i1);
    paramaa.f = paramCursor.getLong(2);
    paramaa.o = paramCursor.getInt(3);
    paramaa.g = paramCursor.getInt(4);
    paramaa.h = paramCursor.getInt(5);
    paramaa.i = paramCursor.getString(6);
    paramaa.j = paramCursor.getInt(7);
    paramaa.k = paramCursor.getString(8);
    paramaa.l = paramCursor.getInt(9);
    paramaa.m = paramCursor.getInt(10);
    paramaa.n = paramCursor.getInt(11);
    paramaa.p = paramCursor.getString(12);
    paramaa.q = paramCursor.getInt(13);
    paramaa.t = ObjectId.fromLong(paramCursor.getLong(20));
    paramaa.r = k.b(paramCursor.getLong(14));
    paramaa.s = paramCursor.getInt(15);
    paramaa.w = paramCursor.getInt(18);
    paramaa.v = paramCursor.getLong(16);
    paramaa.u = paramCursor.getInt(19);
    paramaa.z = paramCursor.getInt(27);
    paramaa.A = paramCursor.getInt(29);
    if (paramCursor.getInt(33) == i1);
    while (true)
    {
      paramaa.I = i1;
      paramaa.K = paramCursor.getLong(34);
      paramaa.L = paramCursor.getString(35);
      paramaa.M = paramCursor.getString(36);
      paramaa.N = paramCursor.getString(37);
      paramaa.O = paramCursor.getLong(38);
      paramaa.P = paramCursor.getInt(39);
      paramaa.Q = paramCursor.getString(21);
      paramaa.R = paramCursor.getString(22);
      paramaa.d = paramCursor.getLong(23);
      paramaa.x = paramCursor.getInt(24);
      paramaa.y = paramCursor.getLong(25);
      paramaa.S = paramCursor.getLong(26);
      paramaa.B = paramCursor.getString(28);
      paramaa.C = paramCursor.getString(30);
      paramaa.F = paramCursor.getInt(31);
      paramaa.X = paramCursor.getString(32);
      paramaa.V = b(paramaa);
      a(paramaa);
      if (paramaa.ax())
      {
        paramaa.W = b(paramaa, paramCursor);
        paramaa.aa = paramCursor.getString(44);
        paramaa.ab = paramCursor.getLong(45);
        paramaa.ac = paramCursor.getInt(46);
      }
      paramaa.G = paramCursor.getInt(47);
      paramaa.H = cd.h(paramCursor.getInt(48));
      return;
      i1 = 0;
    }
  }

  public static void a(aa paramaa, MessageEntity paramMessageEntity)
  {
    paramaa.c = paramMessageEntity.getId();
    paramaa.e = paramMessageEntity.getMemberId();
    paramaa.f = paramMessageEntity.getDate();
    paramaa.g = paramMessageEntity.getStatus();
    paramaa.h = paramMessageEntity.getType();
    paramaa.i = paramMessageEntity.getBody();
    paramaa.j = paramMessageEntity.getOpened();
    paramaa.k = paramMessageEntity.getDescription();
    paramaa.l = paramMessageEntity.getLat();
    paramaa.m = paramMessageEntity.getLat();
    paramaa.n = paramMessageEntity.getCount();
    paramaa.p = paramMessageEntity.getMediaUri();
    paramaa.q = paramMessageEntity.getMimeType();
    paramaa.t = paramMessageEntity.getObjectId();
    paramaa.r = paramMessageEntity.getDuration();
    paramaa.s = paramMessageEntity.getExtraStatus();
    paramaa.w = paramMessageEntity.getMessageSeq();
    paramaa.v = paramMessageEntity.getMessageToken();
    paramaa.u = paramMessageEntity.getConversationType();
    paramaa.z = paramMessageEntity.getMessageGlobalId();
    paramaa.A = paramMessageEntity.getLikesCount();
    paramaa.I = paramMessageEntity.isDeleted();
    paramaa.K = 0L;
    paramaa.L = "";
    paramaa.M = "";
    paramaa.N = "";
    paramaa.O = 0L;
    paramaa.x = 0;
    paramaa.Q = paramMessageEntity.getDownloadId();
    paramaa.R = paramMessageEntity.getBucket();
    paramaa.d = paramMessageEntity.getConversationId();
    paramaa.x = paramMessageEntity.getFlag();
    paramaa.y = paramMessageEntity.getExtraFlags();
    paramaa.S = paramMessageEntity.getGroupId();
    paramaa.B = paramMessageEntity.getRawMessageInfo();
    paramaa.C = paramMessageEntity.getSpans();
    paramaa.F = paramMessageEntity.getScrollPosition();
    paramaa.X = paramMessageEntity.getRawQuotedMessageData();
    paramaa.V = b(paramaa);
    if (4 == paramaa.q);
    for (Sticker localSticker = com.viber.voip.stickers.i.a().u(paramaa.t.toStickerId()); ; localSticker = null)
    {
      paramaa.W = localSticker;
      a(paramaa);
      return;
    }
  }

  private static FormattedMessage b(aa paramaa)
  {
    if ((7 == paramaa.q) || (9 == paramaa.q));
    try
    {
      FormattedMessage localFormattedMessage1 = new FormattedMessage(paramaa.i);
      return localFormattedMessage1;
      if (8 != paramaa.q);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        if (da.a(paramaa.i))
          return new FormattedMessage(FormattedUrlMessage.createUrlMessage(paramaa.bx(), false));
        FormattedMessage localFormattedMessage2 = new FormattedMessage(paramaa.i);
        return localFormattedMessage2;
        localJSONException1 = localJSONException1;
      }
      catch (JSONException localJSONException2)
      {
      }
    }
    return null;
  }

  private static Sticker b(aa paramaa, Cursor paramCursor)
  {
    int i1 = paramCursor.getInt(40);
    int i2 = paramCursor.getInt(41);
    Sticker localSticker = new Sticker(paramaa.t.toStickerId(), 0, 0, i1, i2, paramCursor.getInt(42), paramCursor.getInt(43));
    boolean bool = false;
    if (i1 > 0)
    {
      bool = false;
      if (i2 > 0)
        bool = true;
    }
    localSticker.setIsInDatabase(bool);
    return localSticker;
  }

  private String bP()
  {
    String str;
    if (!aL())
      str = null;
    MsgInfo localMsgInfo;
    do
    {
      return str;
      localMsgInfo = bx();
      str = localMsgInfo.getThumbnailContentType();
    }
    while (!da.a(str));
    return localMsgInfo.getContentType();
  }

  private String bQ()
  {
    if (!aL())
      return null;
    return bx().getContentType();
  }

  private boolean bR()
  {
    if (!aq());
    while ((ag()) || (O()) || (S()) || (aD()) || (an()) || ((!this.aD) && (!this.aB) && (!this.aA) && ((!aY()) || (as()) || (at())) && (!aL()) && (!aG()) && (!aH()) && (!aK()) && (!aF()) && (!bb()) && (!aI()) && (!this.az) && ((!this.aC) || (L() == null) || (!L().canDoAction(ActionType.FORWARD)) || (w()))))
      return false;
    return true;
  }

  public int A()
  {
    return this.u;
  }

  public String B()
  {
    return this.Q;
  }

  public String C()
  {
    if (W())
    {
      MsgInfo localMsgInfo = bx();
      if (localMsgInfo != null)
        return localMsgInfo.getUrl();
      return null;
    }
    return this.Q;
  }

  public String D()
  {
    return this.R;
  }

  public int E()
  {
    return this.x;
  }

  public int F()
  {
    return this.z;
  }

  public String G()
  {
    if (this.T == null)
      this.T = com.viber.voip.messages.i.a().a(this.f);
    return this.T;
  }

  public String H()
  {
    if (this.U == null)
      this.U = com.viber.voip.messages.i.a().b(this.f);
    return this.U;
  }

  public String I()
  {
    return this.aa;
  }

  public long J()
  {
    return this.ab;
  }

  public int K()
  {
    return this.ac;
  }

  public FormattedMessage L()
  {
    return this.V;
  }

  public int M()
  {
    return this.F;
  }

  public String N()
  {
    return this.C;
  }

  public boolean O()
  {
    return (0x1 & E()) != 0;
  }

  public boolean P()
  {
    return (0x400000 & this.x) != 0;
  }

  public boolean Q()
  {
    return this.u == 0;
  }

  public boolean R()
  {
    return (this.u == 0) && ((0x20000 & this.x) != 0);
  }

  public boolean S()
  {
    return av.c(this.y, 8);
  }

  public boolean T()
  {
    return av.c(this.y, 16);
  }

  public boolean U()
  {
    return av.c(this.y, 20);
  }

  public boolean V()
  {
    return (this.u == 0) && (U());
  }

  public boolean W()
  {
    return (ao()) && (U());
  }

  public boolean X()
  {
    return av.c(this.y, 17);
  }

  public boolean Y()
  {
    return (0x1000 & E()) != 0;
  }

  public boolean Z()
  {
    return this.aG;
  }

  public long a()
  {
    return this.c;
  }

  public Spannable a(ai paramai, b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (!paramBoolean2));
    for (boolean bool = true; (this.D != null) && (this.E == bool); bool = false)
      return this.D;
    this.E = bool;
    if (aY());
    for (String str = this.i; ; str = this.k)
    {
      this.D = da.a(str, paramai, paramb, this.C, bool, false, true, true, aj.b, this.u, paramInt);
      return this.D;
    }
  }

  public void a(int paramInt)
  {
    this.ap = paramInt;
  }

  public void a(com.viber.voip.bot.item.c paramc)
  {
    this.ao = paramc;
  }

  public boolean a(int[] paramArrayOfInt)
  {
    return n.a(f(), paramArrayOfInt);
  }

  public boolean aA()
  {
    return this.aB;
  }

  public boolean aB()
  {
    return this.aH;
  }

  public boolean aC()
  {
    return this.aI;
  }

  public boolean aD()
  {
    return (aB()) || (aC());
  }

  public boolean aE()
  {
    return this.aC;
  }

  public boolean aF()
  {
    return this.aF;
  }

  public boolean aG()
  {
    return this.ay;
  }

  public boolean aH()
  {
    return this.aJ;
  }

  public boolean aI()
  {
    return this.aM;
  }

  public boolean aJ()
  {
    return this.aS;
  }

  public boolean aK()
  {
    return this.aT;
  }

  public boolean aL()
  {
    return this.aE;
  }

  public boolean aM()
  {
    return bg.a.d(bP());
  }

  public boolean aN()
  {
    String str = bQ();
    return (bg.a.d(str)) || (bg.a.a(str)) || (bg.a.c(str)) || (bg.a.b(str));
  }

  public boolean aO()
  {
    return aP();
  }

  public boolean aP()
  {
    int i1 = 1;
    if (!aL())
      return false;
    MsgInfo localMsgInfo = bx();
    if ((localMsgInfo.getUrlType() == MsgInfo.a.VIDEO) && (LinkParser.isEmbeddedMedia(localMsgInfo.getUrl(), i1)));
    while (true)
    {
      return i1;
      int i2 = 0;
    }
  }

  public boolean aQ()
  {
    return (!ag()) && (aO());
  }

  public boolean aR()
  {
    return this.u != 0;
  }

  public boolean aS()
  {
    return (aT()) || (aV());
  }

  public boolean aT()
  {
    return m.a(this.u);
  }

  public boolean aU()
  {
    return this.u == 4;
  }

  public boolean aV()
  {
    return this.u == 5;
  }

  @Deprecated
  public boolean aW()
  {
    return this.aw;
  }

  public boolean aX()
  {
    return this.au;
  }

  public boolean aY()
  {
    return this.ad;
  }

  public boolean aZ()
  {
    return this.aK;
  }

  public boolean aa()
  {
    return (0x400 & this.x) != 0;
  }

  public boolean ab()
  {
    return av.c(this.y, 12);
  }

  public boolean ac()
  {
    return (aR()) && (!aU()) && (!aD());
  }

  public boolean ad()
  {
    return av.c(this.y, 19);
  }

  public boolean ae()
  {
    return !av.c(this.y, 15);
  }

  public boolean af()
  {
    return av.c(this.y, 23);
  }

  public boolean ag()
  {
    return av.c(this.y, 27);
  }

  public boolean ah()
  {
    return av.c(this.y, 28);
  }

  public boolean ai()
  {
    return this.ab > System.currentTimeMillis();
  }

  public boolean aj()
  {
    return this.ar;
  }

  public boolean ak()
  {
    return av.c(this.y, 31);
  }

  public boolean al()
  {
    return av.c(this.y, 5);
  }

  public boolean am()
  {
    return av.c(this.y, 37);
  }

  public boolean an()
  {
    return av.c(this.y, 38);
  }

  public boolean ao()
  {
    return this.h == 0;
  }

  public boolean ap()
  {
    return this.h == 1;
  }

  public boolean aq()
  {
    return (this.g == 1) || (this.g == 2);
  }

  public boolean ar()
  {
    return this.g == -1;
  }

  public boolean as()
  {
    return this.ae;
  }

  public boolean at()
  {
    return this.af;
  }

  public int au()
  {
    return this.ap;
  }

  public boolean av()
  {
    return this.ag;
  }

  public boolean aw()
  {
    return ("missed_call".equals(this.i)) || ("missed_call_group".equals(this.i)) || ("missed_call_video".equals(this.i));
  }

  public boolean ax()
  {
    return this.az;
  }

  public boolean ay()
  {
    return this.aA;
  }

  public boolean az()
  {
    return this.aD;
  }

  public long b()
  {
    return this.d;
  }

  public boolean b(int paramInt)
  {
    if ((!aq()) || (ag()) || (O()) || (!aR()) || (aU()) || (aD()) || (as()) || (at()) || ((aE()) && (L().isInviteFromPublicAccount())));
    while ((!cd.g(paramInt, this.u)) || ((!this.aD) && (!this.aB) && (!this.aA) && (!aY()) && (!aL()) && (!aG()) && (!aH()) && (!aZ()) && (!aF()) && (!this.az) && ((!this.aC) || (L() == null))))
      return false;
    return true;
  }

  public boolean b(int[] paramArrayOfInt)
  {
    return n.a(z(), paramArrayOfInt);
  }

  public boolean bA()
  {
    return (aD()) && (1 == this.j);
  }

  public com.viber.voip.bot.item.c bB()
  {
    return this.ao;
  }

  public QuotedMessageData bC()
  {
    if (this.Y == null)
      this.Y = ((QuotedMessageData)e.b().a().a(this.X));
    return this.Y;
  }

  public boolean bD()
  {
    return this.aP;
  }

  public boolean bE()
  {
    return this.aQ;
  }

  public String bF()
  {
    return a(true);
  }

  public int bG()
  {
    return this.G;
  }

  public boolean bH()
  {
    return this.H;
  }

  public int bI()
  {
    return this.at;
  }

  public Uri bJ()
  {
    return this.as;
  }

  public boolean bK()
  {
    return (1002 == this.q) && (("missed_call_group".equals(this.i)) || ("incoming_call_group".equals(this.i)) || ("answ_another_dev_group".equals(this.i)));
  }

  public boolean bL()
  {
    return !com.viber.voip.flatbuffers.b.c.a(this.k);
  }

  public ConferenceInfo bM()
  {
    if (this.Z == null)
      this.Z = ((ConferenceInfo)e.c().a().a(this.k));
    return this.Z;
  }

  public boolean bN()
  {
    return bx().getCommunityScreenshot() != null;
  }

  public boolean bO()
  {
    return bx().getGroupReferralInfo() != null;
  }

  public boolean ba()
  {
    return this.aL;
  }

  public boolean bb()
  {
    return (this.aK) && (!V()) && ((aS()) || (ap()) || (v() > 0L)) && (bx().getPublicAccountMsgInfo().getRichMediaSignature() != null);
  }

  public boolean bc()
  {
    return (this.ax) || (this.I) || (ba());
  }

  public boolean bd()
  {
    return 1 == this.j;
  }

  public boolean be()
  {
    return (ap()) || ((ao()) && (1 == this.j));
  }

  public boolean bf()
  {
    return "has_description".equals(this.R);
  }

  public boolean bg()
  {
    return (av()) || (bf()) || (aw());
  }

  public boolean bh()
  {
    if (ag());
    while (((!aY()) || (as()) || (at())) && (!aL()) && ((7 != this.q) || (L() == null) || (!L().canDoAction(ActionType.COPY))))
      return false;
    return true;
  }

  public boolean bi()
  {
    return this.aR;
  }

  public boolean bj()
  {
    if ((!aq()) || (ag()) || (O()) || (V()) || (aD()) || ((aE()) && (L() != null) && (L().isInviteFromPublicAccount())) || ((aU()) && (as()) && (at())) || (this.aL));
    while ((!this.aD) && (!this.aB) && (!this.aA) && (!aY()) && (!aL()) && (!aG()) && (!aH()) && (!aZ()) && (!aF()) && (!this.az) && ((!this.aC) || (L() == null)))
      return false;
    return true;
  }

  public boolean bk()
  {
    if ((aY()) && (!aL()))
      if (!a(new int[] { 6, 4, 5, 7 }))
        if (!b(new int[] { 0, 10 }))
          break label68;
    label68: return ax();
  }

  public boolean bl()
  {
    return ((this.u == 1) || ((aU()) && (this.c > 0L))) && (!as()) && (!at());
  }

  public int bm()
  {
    return this.o;
  }

  public Sticker bn()
  {
    return this.W;
  }

  public Uri bo()
  {
    try
    {
      if (!da.a(this.i))
        if (this.aO == null)
          this.aO = Uri.parse(this.i);
      for (Uri localUri = this.aO; ; localUri = null)
        return localUri;
    }
    finally
    {
    }
  }

  public String bp()
  {
    if (this.ah == null)
      this.ah = dg.a(this, 0);
    return this.ah;
  }

  public String bq()
  {
    if (!W())
      return null;
    if (this.ak == null)
    {
      Sender localSender = bx().getPublicAccountMsgInfo().getSender();
      if (localSender != null)
        this.ak = localSender.getName();
      if (this.ak == null)
        this.ak = "";
    }
    return this.ak;
  }

  public String br()
  {
    if (!W())
      return null;
    if (this.al == null)
      this.al = da.f(bq());
    return this.al;
  }

  public String bs()
  {
    if (!W())
      return null;
    if (this.am == null)
    {
      Sender localSender = bx().getPublicAccountMsgInfo().getSender();
      if (localSender != null)
        this.am = localSender.getAvatar();
      if (this.am == null)
        this.am = "";
    }
    return this.am;
  }

  public boolean bt()
  {
    return m.b(bx());
  }

  public String bu()
  {
    return m.a(bx());
  }

  public String bv()
  {
    PublicAccountInfo localPublicAccountInfo;
    if (bx() != null)
    {
      localPublicAccountInfo = bx().getPublicAccountMsgInfo().getPublicAccountInfo();
      if (localPublicAccountInfo != null);
    }
    else
    {
      return null;
    }
    return localPublicAccountInfo.getPaId();
  }

  public String bw()
  {
    return this.B;
  }

  public MsgInfo bx()
  {
    if (this.J == null)
      if ((!da.a(this.B)) && (!"{}".equals(this.B)) && (((!this.ax) && (!this.I)) || (this.aL)))
        break label67;
    label67: for (this.J = new MsgInfo(); ; this.J = ((MsgInfo)e.a().a().a(this.B)))
      return this.J;
  }

  public PttUtils.AudioBarsInfo by()
  {
    if (!aJ());
    AudioPttInfo localAudioPttInfo;
    do
    {
      return null;
      if (this.aq != null)
        break;
      localAudioPttInfo = bx().getAudioPttInfo();
    }
    while (localAudioPttInfo == null);
    this.aq = PttUtils.unpackVolumeBarsFromBase64(localAudioPttInfo.getSoundBarsInfo());
    return this.aq;
  }

  public FileInfo bz()
  {
    return bx().getFileInfo();
  }

  public long c()
  {
    return this.S;
  }

  public String c(int paramInt)
  {
    return dg.a(this, paramInt);
  }

  public String d()
  {
    return this.e;
  }

  public String d(int paramInt)
  {
    if ((this.ai == null) || (this.aj != paramInt))
    {
      this.ai = da.f(c(paramInt));
      this.aj = paramInt;
    }
    return this.ai;
  }

  public long e()
  {
    return this.f;
  }

  public int f()
  {
    return this.g;
  }

  public int g()
  {
    return this.h;
  }

  public String getContactName()
  {
    return this.L;
  }

  public String getNumber()
  {
    return this.N;
  }

  public String getViberName()
  {
    return this.M;
  }

  public String h()
  {
    return this.i;
  }

  public String i()
  {
    return this.k;
  }

  public boolean isOwner()
  {
    return ap();
  }

  public int j()
  {
    return this.l;
  }

  public int k()
  {
    return this.m;
  }

  public boolean l()
  {
    return (this.l != 0) && (this.m != 0);
  }

  public int m()
  {
    return this.n;
  }

  public int n()
  {
    if ((ab()) && (this.A == 0))
      return 1;
    return this.A;
  }

  public String o()
  {
    return this.p;
  }

  public String p()
  {
    return dx.a(this.p, this.c);
  }

  public int q()
  {
    return this.q;
  }

  public ObjectId r()
  {
    return this.t;
  }

  public long s()
  {
    return this.r;
  }

  public String t()
  {
    if (this.an == null)
      this.an = ('(' + ae.g(this.r) + ')');
    return this.an;
  }

  public String toString()
  {
    return a(true);
  }

  public long u()
  {
    return this.K;
  }

  public long v()
  {
    return this.O;
  }

  public boolean w()
  {
    return (ao()) && (cd.a(this.O, this.P));
  }

  public int x()
  {
    return this.w;
  }

  public long y()
  {
    return this.v;
  }

  public int z()
  {
    return this.s;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.aa
 * JD-Core Version:    0.6.2
 */