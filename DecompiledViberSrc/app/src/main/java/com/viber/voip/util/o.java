package com.viber.voip.util;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.viber.common.d.e;
import com.viber.common.d.e.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.registration.af;
import com.viber.voip.s.a;
import com.viber.voip.user.UserManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o extends AsyncTask<Void, Void, Void>
{
  private static final Logger a = ViberEnv.getLogger();
  private static final SimpleDateFormat b = new SimpleDateFormat("dd/MM/yyyy,hh:mm:ss aa");
  private static final SimpleDateFormat c = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
  private static String d;
  private String[] e = { "msg_date", "send_type", "body", "extra_mime", "user_id" };
  private String f = "SELECT " + a.a("messages", this.e) + " FROM " + "messages" + " WHERE " + "conversation_id" + "=? ORDER BY " + "token" + " ASC";
  private Context g;
  private int h;
  private ProgressDialog i;
  private List<String> j;
  private boolean k = true;
  private ab l;
  private ak m;
  private final String n;
  private final String o;
  private final String p;
  private final String q;
  private final String r;
  private final String s;
  private final String t;
  private final String u;
  private Map<String, Integer> v = new HashMap();

  public o(Context paramContext)
  {
    this.g = paramContext;
    this.j = Collections.synchronizedList(new ArrayList());
    d = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + this.g.getString(R.string.backup_zip_file_name) + ".zip";
    this.k = ae.a;
    this.l = ab.b();
    this.m = ak.a();
    this.n = this.g.getString(R.string.backup_photo_text);
    this.o = this.g.getString(R.string.backup_video_text);
    this.p = this.g.getString(R.string.message_type_sticker);
    this.q = this.g.getString(R.string.backup_sound_message);
    this.r = this.g.getString(R.string.backup_location_text);
    this.s = this.g.getString(R.string.backup_your_message_name);
    this.t = UserManager.from(this.g).getRegistrationValues().h();
    this.u = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
  }

  private String a(h paramh)
  {
    String str1 = this.g.getString(R.string.unknown);
    if (paramh.b())
      if (TextUtils.isEmpty(paramh.o()))
        str1 = ViberApplication.getApplication().getString(R.string.default_group_name);
    String str2;
    while (true)
    {
      str2 = at.l(str1);
      str2.trim();
      if (!this.v.containsKey(str2))
        break;
      int i1 = ((Integer)this.v.get(str2)).intValue();
      Map localMap = this.v;
      int i2 = i1 + 1;
      localMap.put(str2, Integer.valueOf(i2));
      return str2 + "(" + i2 + ")";
      str1 = paramh.o();
      continue;
      m localm = c.c().b(paramh.V());
      if (localm != null)
        str1 = localm.a(paramh.j(), paramh.p());
    }
    this.v.put(str2, Integer.valueOf(0));
    return str2;
  }

  private void a(Uri paramUri)
  {
    Uri localUri = ViberActionRunner.a(paramUri, this.g);
    if (localUri == null)
      return;
    new e.a().c(this.g.getString(R.string.backup_email_subject)).a(this.g.getString(R.string.backup_email_text)).a(this.g, localUri, "com.viber.voip.provider.file").a().a(this.g, "application/x-compressed", this.g.getString(R.string.pref_email_msg_history_title));
  }

  // ERROR //
  private void a(h paramh, a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 367	com/viber/voip/model/entity/h:getId	()J
    //   4: lstore_3
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 369	com/viber/voip/util/o:a	(Lcom/viber/voip/model/entity/h;)Ljava/lang/String;
    //   10: astore 5
    //   12: new 84	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: getfield 230	com/viber/voip/util/o:u	Ljava/lang/String;
    //   23: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 149
    //   28: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 5
    //   33: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 371
    //   39: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 6
    //   47: new 120	java/util/HashMap
    //   50: dup
    //   51: invokespecial 121	java/util/HashMap:<init>	()V
    //   54: astore 7
    //   56: new 373	android/util/LongSparseArray
    //   59: dup
    //   60: invokespecial 374	android/util/LongSparseArray:<init>	()V
    //   63: astore 8
    //   65: aload_0
    //   66: getfield 175	com/viber/voip/util/o:l	Lcom/viber/voip/messages/controller/manager/ab;
    //   69: pop
    //   70: invokestatic 377	com/viber/voip/messages/controller/manager/ab:f	()Lcom/viber/provider/b;
    //   73: astore 16
    //   75: aload_0
    //   76: getfield 116	com/viber/voip/util/o:f	Ljava/lang/String;
    //   79: astore 17
    //   81: iconst_1
    //   82: anewarray 70	java/lang/String
    //   85: astore 18
    //   87: aload 18
    //   89: iconst_0
    //   90: lload_3
    //   91: invokestatic 380	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   94: aastore
    //   95: aload 16
    //   97: ldc_w 381
    //   100: aload 17
    //   102: aload 18
    //   104: invokeinterface 386 4 0
    //   109: astore 19
    //   111: aload 19
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +13 -> 130
    //   120: aload 12
    //   122: invokeinterface 391 1 0
    //   127: ifne +16 -> 143
    //   130: aload_2
    //   131: aconst_null
    //   132: invokeinterface 395 2 0
    //   137: aload 12
    //   139: invokestatic 400	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   142: return
    //   143: invokestatic 303	com/viber/voip/messages/d/c:c	()Lcom/viber/voip/messages/d/b;
    //   146: astore 21
    //   148: new 402	java/util/Date
    //   151: dup
    //   152: invokespecial 403	java/util/Date:<init>	()V
    //   155: astore 22
    //   157: new 84	java/lang/StringBuilder
    //   160: dup
    //   161: bipush 80
    //   163: aload 12
    //   165: invokeinterface 406 1 0
    //   170: imul
    //   171: invokespecial 409	java/lang/StringBuilder:<init>	(I)V
    //   174: astore 23
    //   176: aload 22
    //   178: aload 12
    //   180: iconst_0
    //   181: invokeinterface 413 2 0
    //   186: invokevirtual 417	java/util/Date:setTime	(J)V
    //   189: aload 8
    //   191: aload 22
    //   193: invokevirtual 420	java/util/Date:getTime	()J
    //   196: invokevirtual 423	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   199: checkcast 70	java/lang/String
    //   202: astore 24
    //   204: aload 24
    //   206: ifnonnull +32 -> 238
    //   209: aload_0
    //   210: getfield 118	com/viber/voip/util/o:k	Z
    //   213: ifeq +257 -> 470
    //   216: getstatic 65	com/viber/voip/util/o:c	Ljava/text/SimpleDateFormat;
    //   219: aload 22
    //   221: invokevirtual 427	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   224: astore 24
    //   226: aload 8
    //   228: aload 22
    //   230: invokevirtual 420	java/util/Date:getTime	()J
    //   233: aload 24
    //   235: invokevirtual 430	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   238: aload 24
    //   240: astore 25
    //   242: aload 12
    //   244: iconst_1
    //   245: invokeinterface 434 2 0
    //   250: istore 26
    //   252: aload 12
    //   254: iconst_3
    //   255: invokeinterface 434 2 0
    //   260: istore 27
    //   262: aload 12
    //   264: iconst_2
    //   265: invokeinterface 435 2 0
    //   270: astore 28
    //   272: iload 26
    //   274: ifne +209 -> 483
    //   277: aload 12
    //   279: iconst_4
    //   280: invokeinterface 435 2 0
    //   285: astore 29
    //   287: aload 21
    //   289: aload 29
    //   291: aload_1
    //   292: invokevirtual 314	com/viber/voip/model/entity/h:j	()I
    //   295: invokestatic 439	com/viber/voip/util/cd:j	(I)I
    //   298: invokeinterface 442 3 0
    //   303: astore 30
    //   305: aload 7
    //   307: aload 29
    //   309: invokeinterface 277 2 0
    //   314: checkcast 70	java/lang/String
    //   317: astore 31
    //   319: aload 31
    //   321: ifnonnull +220 -> 541
    //   324: aload_0
    //   325: getfield 125	com/viber/voip/util/o:g	Landroid/content/Context;
    //   328: aload 30
    //   330: ldc_w 443
    //   333: invokestatic 448	com/viber/voip/util/x:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   336: astore 31
    //   338: aload 7
    //   340: aload 29
    //   342: aload 31
    //   344: invokeinterface 291 3 0
    //   349: pop
    //   350: goto +191 -> 541
    //   353: aload 23
    //   355: aload 25
    //   357: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 23
    //   363: bipush 44
    //   365: invokevirtual 451	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 23
    //   371: aload 33
    //   373: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 23
    //   379: bipush 44
    //   381: invokevirtual 451	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 23
    //   387: aload 34
    //   389: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 23
    //   395: bipush 44
    //   397: invokevirtual 451	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_0
    //   402: aload 23
    //   404: iload 27
    //   406: aload 28
    //   408: invokespecial 454	com/viber/voip/util/o:a	(Ljava/lang/StringBuilder;ILjava/lang/String;)V
    //   411: aload 23
    //   413: ldc_w 456
    //   416: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 12
    //   422: invokeinterface 459 1 0
    //   427: ifne -251 -> 176
    //   430: aload 6
    //   432: aload 23
    //   434: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 464	com/viber/voip/util/bj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_2
    //   441: aload 6
    //   443: invokeinterface 395 2 0
    //   448: goto -311 -> 137
    //   451: astore 20
    //   453: aload 12
    //   455: astore 10
    //   457: aload_2
    //   458: aconst_null
    //   459: invokeinterface 395 2 0
    //   464: aload 10
    //   466: invokestatic 400	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   469: return
    //   470: getstatic 61	com/viber/voip/util/o:b	Ljava/text/SimpleDateFormat;
    //   473: aload 22
    //   475: invokevirtual 427	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   478: astore 24
    //   480: goto -254 -> 226
    //   483: aload_0
    //   484: getfield 212	com/viber/voip/util/o:s	Ljava/lang/String;
    //   487: astore 33
    //   489: aload_0
    //   490: getfield 228	com/viber/voip/util/o:t	Ljava/lang/String;
    //   493: astore 34
    //   495: goto -142 -> 353
    //   498: astore 14
    //   500: aconst_null
    //   501: astore 12
    //   503: aload 14
    //   505: astore 13
    //   507: aload 12
    //   509: invokestatic 400	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   512: aload 13
    //   514: athrow
    //   515: astore 13
    //   517: goto -10 -> 507
    //   520: astore 11
    //   522: aload 10
    //   524: astore 12
    //   526: aload 11
    //   528: astore 13
    //   530: goto -23 -> 507
    //   533: astore 9
    //   535: aconst_null
    //   536: astore 10
    //   538: goto -81 -> 457
    //   541: aload 31
    //   543: astore 33
    //   545: aload 30
    //   547: astore 34
    //   549: goto -196 -> 353
    //
    // Exception table:
    //   from	to	target	type
    //   120	130	451	java/io/IOException
    //   130	137	451	java/io/IOException
    //   143	176	451	java/io/IOException
    //   176	204	451	java/io/IOException
    //   209	226	451	java/io/IOException
    //   226	238	451	java/io/IOException
    //   242	272	451	java/io/IOException
    //   277	319	451	java/io/IOException
    //   324	350	451	java/io/IOException
    //   353	448	451	java/io/IOException
    //   470	480	451	java/io/IOException
    //   483	495	451	java/io/IOException
    //   65	111	498	finally
    //   120	130	515	finally
    //   130	137	515	finally
    //   143	176	515	finally
    //   176	204	515	finally
    //   209	226	515	finally
    //   226	238	515	finally
    //   242	272	515	finally
    //   277	319	515	finally
    //   324	350	515	finally
    //   353	448	515	finally
    //   470	480	515	finally
    //   483	495	515	finally
    //   457	464	520	finally
    //   65	111	533	java/io/IOException
  }

  private void a(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      paramStringBuilder.append(this.n);
      return;
    }
    if (paramInt == 3)
    {
      paramStringBuilder.append(this.o);
      return;
    }
    if (paramInt == 4)
    {
      paramStringBuilder.append(this.p);
      return;
    }
    if ((paramInt == 2) || (paramInt == 1009))
    {
      paramStringBuilder.append(this.q);
      return;
    }
    if (paramInt == 5)
    {
      paramStringBuilder.append(this.r);
      return;
    }
    paramStringBuilder.append(paramString);
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    a local1;
    List localList;
    if (com.viber.voip.util.upload.o.b())
    {
      local1 = new a()
      {
        public void a(String paramAnonymousString)
        {
          if (paramAnonymousString != null);
          try
          {
            o.a(o.this).add(paramAnonymousString);
            while (true)
            {
              if (o.c(o.this) - o.a(o.this).size() <= 0)
              {
                if (o.a(o.this).size() != 0)
                {
                  String[] arrayOfString = (String[])o.a(o.this).toArray(new String[o.c(o.this)]);
                  Uri localUri = bj.a(arrayOfString, o.a());
                  bj.a(arrayOfString);
                  o.a(o.this, localUri);
                }
                o.d(o.this).cancel();
              }
              return;
              o.b(o.this);
            }
          }
          finally
          {
          }
        }
      };
      localList = this.l.e("conversations.flags & 32768=0", null);
      if (localList.isEmpty())
        local1.a(null);
    }
    else
    {
      return null;
    }
    this.h = localList.size();
    System.currentTimeMillis();
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
      a((h)localList.get(i2), local1);
    System.currentTimeMillis();
    return null;
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
    if (com.viber.voip.util.upload.o.b())
    {
      this.i = ProgressDialog.show(this.g, null, this.g.getString(R.string.creating_bakup_dialog_text));
      return;
    }
    Toast.makeText(this.g, this.g.getString(R.string.msg_options_need_sd_card), 0).show();
  }

  private static abstract interface a
  {
    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.o
 * JD-Core Version:    0.6.2
 */