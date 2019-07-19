package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.graphics.Paint;
import android.support.v4.text.BidiFormatter;
import android.text.Annotation;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.d.a;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.m;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.style.UserMentionSpan;
import com.viber.voip.util.links.f;
import java.io.ByteArrayOutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class da
{
  public static final Pattern a = Pattern.compile("[a-zA-Z]");
  private static final Logger b = ViberEnv.getLogger();
  private static final Pattern c = Pattern.compile("　");
  private static final Pattern d = Pattern.compile("\\s+");
  private static final Pattern e = Pattern.compile("\\([a-zA-Z0-9\\Q!\"#$%&'*+,-./:;<=>?@[\\]^_`{|}~\\E]+\\)");
  private static final char[] f = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final byte[] g = { 33, 35, 36, 38, 43, 45, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 124, 126 };

  public static int a(TextView paramTextView, String paramString)
  {
    return (int)paramTextView.getPaint().measureText(paramString);
  }

  public static int a(ac paramac, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if ((paramPublicGroupConversationItemLoaderEntity.isNotJoinedCommunity()) && (!a(paramPublicGroupConversationItemLoaderEntity.getExtraInfo())))
    {
      PublicAccount.ExtraInfo localExtraInfo = PublicAccount.ExtraInfo.fromExtraInfoJson(paramPublicGroupConversationItemLoaderEntity.getExtraInfo());
      if (localExtraInfo != null);
      for (Integer localInteger = localExtraInfo.getParticipantsCount(); localInteger != null; localInteger = null)
        return localInteger.intValue();
    }
    int i = paramPublicGroupConversationItemLoaderEntity.getWatchersCount();
    if ((cd.f(paramPublicGroupConversationItemLoaderEntity.getGroupRole())) && (!paramPublicGroupConversationItemLoaderEntity.isDisabledConversation()))
      i--;
    return i + paramac.getCount();
  }

  public static Annotation a(Spanned paramSpanned, String paramString1, String paramString2)
  {
    for (Annotation localAnnotation : (Annotation[])paramSpanned.getSpans(0, paramSpanned.length(), Annotation.class))
      if ((localAnnotation.getKey().equals(paramString1)) && (localAnnotation.getValue().equals(paramString2)))
        return localAnnotation;
    return null;
  }

  @Deprecated
  private static SpannableString a(ai paramai, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    SpannableString localSpannableString;
    if (a(paramCharSequence))
      localSpannableString = SpannableString.valueOf("");
    while (true)
    {
      return localSpannableString;
      localSpannableString = SpannableString.valueOf(paramCharSequence);
      if (!a(localSpannableString))
      {
        if (paramBoolean1)
        {
          if (!paramBoolean2)
            break label64;
          f.c().a(localSpannableString);
        }
        while (paramBoolean3)
        {
          paramai.a(localSpannableString, paramInt);
          return localSpannableString;
          label64: f.b().a(localSpannableString);
        }
      }
    }
  }

  // ERROR //
  public static SpannableString a(ai paramai, CharSequence paramCharSequence, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 223	android/text/SpannableString:valueOf	(Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    //   4: astore 6
    //   6: aload_2
    //   7: ifnull +8 -> 15
    //   10: aload_2
    //   11: arraylength
    //   12: ifne +6 -> 18
    //   15: aload 6
    //   17: areturn
    //   18: new 243	java/io/ObjectInputStream
    //   21: dup
    //   22: new 245	java/io/ByteArrayInputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 249	java/io/ByteArrayInputStream:<init>	([B)V
    //   30: invokespecial 252	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore 7
    //   35: aconst_null
    //   36: astore 8
    //   38: aload 7
    //   40: invokevirtual 255	java/io/ObjectInputStream:available	()I
    //   43: ifle +292 -> 335
    //   46: aload 7
    //   48: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   51: tableswitch	default:+336 -> 387, 1:+25->76, 2:+84->135, 3:+138->189
    //   77: iconst_4
    //   78: invokevirtual 261	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   81: astore 22
    //   83: aload 7
    //   85: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   88: istore 23
    //   90: aload 7
    //   92: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   95: istore 24
    //   97: aload 7
    //   99: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   102: istore 25
    //   104: iload_3
    //   105: ifeq +282 -> 387
    //   108: aload 6
    //   110: new 263	com/viber/voip/ui/style/InternalURLSpan
    //   113: dup
    //   114: aload 22
    //   116: invokespecial 266	com/viber/voip/ui/style/InternalURLSpan:<init>	(Ljava/lang/String;)V
    //   119: iload 23
    //   121: iload 24
    //   123: iload 25
    //   125: invokevirtual 270	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   128: aload 8
    //   130: astore 18
    //   132: goto +259 -> 391
    //   135: aload 7
    //   137: invokevirtual 261	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   140: astore 19
    //   142: aload 7
    //   144: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   147: istore 20
    //   149: aload 7
    //   151: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   154: istore 21
    //   156: iload 4
    //   158: ifeq +229 -> 387
    //   161: aload_0
    //   162: aload 6
    //   164: iload 5
    //   166: invokestatic 275	com/viber/voip/messages/ui/aj:b	()Lcom/viber/voip/messages/ui/aj;
    //   169: aload 19
    //   171: invokevirtual 278	com/viber/voip/messages/ui/aj:a	(Ljava/lang/String;)Lcom/viber/voip/messages/ui/aj$a;
    //   174: iload 20
    //   176: iload 21
    //   178: iconst_0
    //   179: invokevirtual 281	com/viber/voip/messages/ui/ai:a	(Landroid/text/Spannable;ILcom/viber/voip/messages/ui/aj$a;IIZ)V
    //   182: aload 8
    //   184: astore 18
    //   186: goto +205 -> 391
    //   189: aload 7
    //   191: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   194: istore 12
    //   196: aload 7
    //   198: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   201: istore 13
    //   203: aload 7
    //   205: invokevirtual 258	java/io/ObjectInputStream:readInt	()I
    //   208: newarray byte
    //   210: astore 14
    //   212: aload 7
    //   214: aload 14
    //   216: invokevirtual 285	java/io/ObjectInputStream:read	([B)I
    //   219: pop
    //   220: iload 12
    //   222: iconst_1
    //   223: if_icmpgt +164 -> 387
    //   226: invokestatic 291	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   229: astore 16
    //   231: aload 16
    //   233: aload 14
    //   235: iconst_0
    //   236: aload 14
    //   238: arraylength
    //   239: invokevirtual 295	android/os/Parcel:unmarshall	([BII)V
    //   242: aload 16
    //   244: iconst_0
    //   245: invokevirtual 299	android/os/Parcel:setDataPosition	(I)V
    //   248: aconst_null
    //   249: astore 17
    //   251: iload 12
    //   253: iconst_1
    //   254: if_icmpne +18 -> 272
    //   257: getstatic 305	com/viber/voip/flatbuffers/model/TextMetaInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   260: aload 16
    //   262: invokeinterface 311 2 0
    //   267: checkcast 301	com/viber/voip/flatbuffers/model/TextMetaInfo
    //   270: astore 17
    //   272: aload 17
    //   274: ifnull +106 -> 380
    //   277: aload 8
    //   279: ifnonnull +94 -> 373
    //   282: new 313	com/viber/voip/ui/style/e
    //   285: dup
    //   286: invokespecial 315	com/viber/voip/ui/style/e:<init>	()V
    //   289: astore 18
    //   291: aload 18
    //   293: aload 6
    //   295: aload 17
    //   297: invokevirtual 318	com/viber/voip/flatbuffers/model/TextMetaInfo:getStartPosition	()I
    //   300: aload 17
    //   302: invokevirtual 321	com/viber/voip/flatbuffers/model/TextMetaInfo:getEndPosition	()I
    //   305: aload 17
    //   307: iload 13
    //   309: invokeinterface 326 6 0
    //   314: aload 16
    //   316: invokevirtual 329	android/os/Parcel:recycle	()V
    //   319: goto +72 -> 391
    //   322: astore 10
    //   324: aload 7
    //   326: astore 11
    //   328: aload 11
    //   330: invokestatic 334	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   333: aconst_null
    //   334: areturn
    //   335: aload 7
    //   337: invokestatic 334	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   340: aload 6
    //   342: areturn
    //   343: astore 27
    //   345: aconst_null
    //   346: astore 7
    //   348: aload 27
    //   350: astore 9
    //   352: aload 7
    //   354: invokestatic 334	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   357: aload 9
    //   359: athrow
    //   360: astore 9
    //   362: goto -10 -> 352
    //   365: astore 26
    //   367: aconst_null
    //   368: astore 11
    //   370: goto -42 -> 328
    //   373: aload 8
    //   375: astore 18
    //   377: goto -86 -> 291
    //   380: aload 8
    //   382: astore 18
    //   384: goto -70 -> 314
    //   387: aload 8
    //   389: astore 18
    //   391: aload 18
    //   393: astore 8
    //   395: goto -357 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   38	76	322	java/lang/Exception
    //   76	104	322	java/lang/Exception
    //   108	128	322	java/lang/Exception
    //   135	156	322	java/lang/Exception
    //   161	182	322	java/lang/Exception
    //   189	220	322	java/lang/Exception
    //   226	248	322	java/lang/Exception
    //   257	272	322	java/lang/Exception
    //   282	291	322	java/lang/Exception
    //   291	314	322	java/lang/Exception
    //   314	319	322	java/lang/Exception
    //   18	35	343	finally
    //   38	76	360	finally
    //   76	104	360	finally
    //   108	128	360	finally
    //   135	156	360	finally
    //   161	182	360	finally
    //   189	220	360	finally
    //   226	248	360	finally
    //   257	272	360	finally
    //   282	291	360	finally
    //   291	314	360	finally
    //   314	319	360	finally
    //   18	35	365	java/lang/Exception
  }

  public static SpannableString a(CharSequence paramCharSequence, ai paramai, b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    SpannableString localSpannableString;
    if (paramCharSequence != null)
    {
      localObject = paramCharSequence;
      if (!a(paramString))
        break label40;
      localSpannableString = a(paramai, (CharSequence)localObject, paramBoolean1, paramBoolean2, paramBoolean3, paramInt1);
    }
    label40: 
    do
    {
      return localSpannableString;
      localObject = "";
      break;
      if ("no_sp".equals(paramString))
        return SpannableString.valueOf((CharSequence)localObject);
      localSpannableString = a(paramai, (CharSequence)localObject, Base64.decode(paramString, 19), paramBoolean1, paramBoolean3, paramInt1);
      if ((localSpannableString != null) && (!n.a(localSpannableString.getSpans(0, localSpannableString.length(), UserMentionSpan.class))))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
        b(localSpannableStringBuilder, paramb, paramInt2, paramInt3);
        localSpannableString = SpannableString.valueOf(localSpannableStringBuilder);
      }
      if ((!paramBoolean4) && (localSpannableString != null))
        a(localSpannableString, UserMentionSpan.class);
    }
    while (localSpannableString != null);
    return SpannableString.valueOf("");
  }

  public static CharacterStyle a()
  {
    if (a.g())
      return new TypefaceSpan("sans-serif-medium");
    return new StyleSpan(1);
  }

  public static CharSequence a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString3 != null)
      localStringBuilder.append(paramString3).append(" - ");
    localStringBuilder.append(paramString1).append(' ').append('‎').append("(+").append(paramString2).append(")").append(' ').append('‎');
    return e(localStringBuilder.toString());
  }

  public static CharSequence a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1;
    if (paramString2 != null)
    {
      str1 = paramString2;
      if (!paramBoolean)
        break label40;
      str1 = b().getString(R.string.reply_notification_body, new Object[] { paramString1, str1 });
    }
    label40: String str2;
    do
    {
      return str1;
      str1 = "";
      break;
      str2 = j(paramString1);
    }
    while (a(str2));
    return str2 + " " + str1;
  }

  public static CharSequence a(List<String> paramList, String paramString)
  {
    if (paramList.size() < 4);
    StringBuilder localStringBuilder;
    for (int i = paramList.size(); ; i = 4)
    {
      localStringBuilder = new StringBuilder();
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append((String)paramList.get(j));
        if (j != i - 1)
          localStringBuilder.append(", ");
      }
    }
    if (paramList.size() > 4)
    {
      Resources localResources = b();
      int k = R.string.message_notification_more_joined;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.toString(-4 + paramList.size());
      localStringBuilder.append(localResources.getString(k, arrayOfObject));
    }
    return f(localStringBuilder.toString(), paramString);
  }

  public static String a(Context paramContext, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    String str = paramContext.getPackageName();
    int i = paramContext.getResources().getIdentifier(paramString, "plurals", str);
    if (paramArrayOfObject.length > 0)
      return paramContext.getResources().getQuantityString(i, paramInt, paramArrayOfObject);
    return paramContext.getResources().getQuantityString(i, paramInt);
  }

  public static String a(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    String str = paramContext.getPackageName();
    int i = paramContext.getResources().getIdentifier(paramString, "string", str);
    if (paramArrayOfObject.length > 0)
      return paramContext.getString(i, paramArrayOfObject);
    return paramContext.getString(i);
  }

  public static String a(ac paramac)
  {
    if (paramac != null)
    {
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      boolean bool = a.b();
      StringBuilder localStringBuilder = new StringBuilder(128);
      CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(new char[100]);
      int i = 0;
      int j = 0;
      if (i < paramac.getCount())
      {
        if (!paramac.a(i, localCharArrayBuffer));
        while (localCharArrayBuffer.sizeCopied == 0)
        {
          i++;
          break;
        }
        if (localStringBuilder.length() > 100)
          localStringBuilder.append(" ...");
      }
      else
      {
        return localStringBuilder.toString();
      }
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      int k = 0;
      label116: char c1;
      label149: String str;
      if (k < localCharArrayBuffer.sizeCopied)
      {
        c1 = localCharArrayBuffer.data[k];
        if ((k <= 2) || (c1 != ' '));
      }
      else
      {
        if (!bool)
          break label223;
        if (j > localStringBuilder.length())
          break label238;
        str = localStringBuilder.toString().substring(j, localStringBuilder.length());
        label177: if (!localBidiFormatter.isRtl(str))
          break label245;
        localStringBuilder.insert(j, "‏");
      }
      while (true)
      {
        j = 2 + localStringBuilder.length();
        break;
        if (k > 14)
        {
          localStringBuilder.append("...");
          break label149;
          label223: break;
        }
        localStringBuilder.append(c1);
        k++;
        break label116;
        label238: str = "";
        break label177;
        label245: localStringBuilder.insert(j, "‎");
      }
    }
    return "";
  }

  public static String a(aj paramaj, String paramString)
  {
    if (a(paramString))
      return paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = e.matcher(paramString);
    int i = paramString.length();
    int j = 0;
    label117: 
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null);
      for (String str2 = paramaj.c(str1.toLowerCase(Locale.US)); ; str2 = null)
      {
        if (str2 == null)
          break label117;
        int k = localMatcher.start();
        if (k > j)
          localStringBuilder.append(paramString.substring(j, k));
        localStringBuilder.append(str2);
        j = localMatcher.end();
        break;
      }
    }
    if (j < i)
      localStringBuilder.append(paramString.substring(j, i));
    return localStringBuilder.toString();
  }

  public static String a(Object paramObject)
  {
    if (paramObject == null)
      return "";
    return paramObject.toString();
  }

  public static String a(String paramString)
  {
    if ("USD".equals(paramString))
      return "$";
    return "€";
  }

  @SuppressLint({"SwitchIntDef"})
  public static String a(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default:
      paramString = b(paramString);
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 9:
    case 10:
    case 14:
    case 1000:
    case 1003:
    case 1004:
    case 1005:
    case 1010:
    }
    return paramString;
  }

  public static String a(String paramString, boolean paramBoolean)
  {
    if (a.c())
      if ((paramBoolean) || ((paramString.startsWith("+")) && (ce.l.matcher(paramString).matches())))
        paramString = '⁨' + paramString + '⁩';
    while (!paramBoolean)
    {
      return paramString;
      return c.a(paramString);
    }
    return paramString + '\000';
  }

  private static void a(Context paramContext, final SpannableStringBuilder paramSpannableStringBuilder, final URLSpan paramURLSpan, final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    final int i = paramSpannableStringBuilder.getSpanStart(paramURLSpan);
    final int j = paramSpannableStringBuilder.getSpanEnd(paramURLSpan);
    int k = paramSpannableStringBuilder.getSpanFlags(paramURLSpan);
    paramSpannableStringBuilder.setSpan(new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = this.a;
        String str1 = paramURLSpan.getURL();
        if ((paramString == null) && (paramBoolean1));
        for (String str2 = paramSpannableStringBuilder.subSequence(i, j).toString(); ; str2 = paramString)
        {
          GenericWebViewActivity.a(localContext, str1, str2, paramBoolean2);
          return;
        }
      }
    }
    , i, j, k);
    paramSpannableStringBuilder.removeSpan(paramURLSpan);
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)paramContext.getSystemService("clipboard");
    try
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramString1));
      if (!a(paramString2))
        Toast.makeText(paramContext, paramString2, 0).show();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public static void a(Editable paramEditable)
  {
    String str1 = paramEditable.toString();
    String str2 = l(str1);
    int i = str1.indexOf(str2);
    int j = i + str2.length();
    if (j < paramEditable.length())
      paramEditable.delete(j, paramEditable.length());
    if (i > 0)
      paramEditable.delete(0, i);
  }

  public static void a(Editable paramEditable, b paramb, int paramInt1, int paramInt2)
  {
    a(paramEditable, paramb, paramInt1, paramInt2, true);
  }

  private static void a(Editable paramEditable, b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    UserMentionSpan[] arrayOfUserMentionSpan = (UserMentionSpan[])paramEditable.getSpans(0, paramEditable.length(), UserMentionSpan.class);
    if (!n.a(arrayOfUserMentionSpan))
    {
      int i = arrayOfUserMentionSpan.length;
      int j = 0;
      if (j < i)
      {
        UserMentionSpan localUserMentionSpan = arrayOfUserMentionSpan[j];
        int k = paramEditable.getSpanStart(localUserMentionSpan);
        int m = paramEditable.getSpanEnd(localUserMentionSpan);
        m localm = paramb.c(localUserMentionSpan.getMetaInfo().getMemberId(), cd.j(paramInt1));
        if (k + 1 < m);
        for (String str1 = paramEditable.subSequence(k + 1, m).toString(); ; str1 = "")
        {
          String str2 = dg.a(localm, paramInt1, paramInt2, paramBoolean, str1);
          if (!paramBoolean)
            str2 = a(str2, false);
          paramEditable.replace(k + 1, m, str2);
          if (k + 1 == m)
          {
            int n = paramEditable.getSpanFlags(localUserMentionSpan);
            paramEditable.removeSpan(localUserMentionSpan);
            paramEditable.setSpan(localUserMentionSpan, k, 1 + (k + str2.length()), n);
          }
          j++;
          break;
        }
      }
    }
  }

  private static void a(SpannableString paramSpannableString, Class<?> paramClass)
  {
    int i = 0;
    Object[] arrayOfObject = paramSpannableString.getSpans(0, paramSpannableString.length(), paramClass);
    if (!n.a(arrayOfObject))
    {
      int j = arrayOfObject.length;
      while (i < j)
      {
        paramSpannableString.removeSpan(arrayOfObject[i]);
        i++;
      }
    }
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString, CharSequence paramCharSequence)
  {
    int i = paramSpannableStringBuilder.toString().indexOf(paramString);
    if (i != -1)
      paramSpannableStringBuilder.replace(i, i + paramString.length(), paramCharSequence);
  }

  public static void a(TextView paramTextView)
  {
    Layout localLayout = paramTextView.getLayout();
    if (localLayout != null)
    {
      int i = paramTextView.getWidth();
      float f1 = 0.0F;
      for (int j = 0; j < localLayout.getLineCount(); j++)
      {
        float f2 = localLayout.getLineWidth(j);
        if (f2 > f1)
          f1 = f2;
      }
      int k = (int)f1;
      if (i < k)
        paramTextView.setWidth(k);
    }
  }

  public static void a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramTextView, paramString1, paramString2, false, paramBoolean);
  }

  public static void a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Spanned localSpanned = Html.fromHtml(paramString1);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpanned);
    for (URLSpan localURLSpan : (URLSpan[])localSpannableStringBuilder.getSpans(0, localSpanned.length(), URLSpan.class))
      a(paramTextView.getContext(), localSpannableStringBuilder, localURLSpan, paramString2, paramBoolean1, paramBoolean2);
    paramTextView.setText(localSpannableStringBuilder);
  }

  public static void a(TextView paramTextView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramTextView, paramString, null, paramBoolean1, paramBoolean2);
  }

  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if (!a(paramString))
      paramStringBuilder.append(paramString);
  }

  private static void a(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < paramInt2)
    {
      int j = paramCharSequence.charAt(i);
      if (j == 60)
        paramStringBuilder.append("&lt;");
      while (true)
      {
        i++;
        break;
        if (j == 62)
        {
          paramStringBuilder.append("&gt;");
        }
        else if (j == 38)
        {
          paramStringBuilder.append("&amp;");
        }
        else if ((j >= 55296) && (j <= 57343))
        {
          if ((j < 56320) && (i + 1 < paramInt2))
          {
            int k = paramCharSequence.charAt(i + 1);
            if ((k >= 56320) && (k <= 57343))
            {
              i++;
              int m = 0x10000 | j - 55296 << 10 | k - 56320;
              paramStringBuilder.append("&#").append(m).append(";");
            }
          }
        }
        else if ((j > 126) || (j < 32))
        {
          paramStringBuilder.append("&#").append(j).append(";");
        }
        else if (j == 32)
        {
          while ((i + 1 < paramInt2) && (paramCharSequence.charAt(i + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            i++;
          }
          paramStringBuilder.append(' ');
        }
        else
        {
          paramStringBuilder.append(j);
        }
      }
    }
  }

  public static boolean a(char paramChar)
  {
    boolean bool1 = true;
    if (a.c())
    {
      boolean bool2;
      if (paramChar != '⁨')
      {
        bool2 = false;
        if (paramChar != '⁩');
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramChar == 0);
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public static boolean a(int paramInt)
  {
    return (paramInt <= 32) || (Character.isWhitespace(paramInt));
  }

  public static boolean a(CharSequence paramCharSequence)
  {
    return TextUtils.isEmpty(paramCharSequence);
  }

  public static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    boolean bool1;
    if ((a(paramCharSequence)) || (i <= 0))
    {
      bool1 = true;
      return bool1;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label59;
      boolean bool2 = Character.isWhitespace(paramCharSequence.charAt(paramInt1 + j));
      bool1 = false;
      if (!bool2)
        break;
    }
    label59: return true;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == paramString2)
      bool = true;
    do
    {
      do
      {
        return bool;
        if (paramString1 != null)
          break;
        bool = false;
      }
      while (paramString2 != null);
      if (paramString1 == null)
        break;
      bool = false;
    }
    while (paramString2 == null);
    return paramString1.equals(paramString2);
  }

  private static Resources b()
  {
    return ViberApplication.getLocalizedResources();
  }

  public static String b(int paramInt)
  {
    double d1 = paramInt;
    if (paramInt < 0)
      return "";
    a locala;
    if (paramInt < 1000.0D)
      locala = a.a;
    while (true)
    {
      return locala.a().format(d1);
      if (paramInt < 10000.0D)
      {
        locala = a.b;
        d1 /= 1000.0D;
      }
      else if (paramInt < 1000000.0D)
      {
        locala = a.c;
        d1 /= 1000.0D;
      }
      else if (paramInt < 10000000.0D)
      {
        locala = a.d;
        d1 /= 1000000.0D;
      }
      else
      {
        locala = a.e;
        d1 /= 1000000.0D;
      }
    }
  }

  public static String b(ac paramac, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    int i = a(paramac, paramPublicGroupConversationItemLoaderEntity);
    Resources localResources = b();
    if (i > 1)
    {
      String str = new DecimalFormat("#,###,###").format(i);
      return localResources.getString(R.string.group2_conversation_subtitle_n_member, new Object[] { str });
    }
    return localResources.getString(R.string.group2_conversation_subtitle_1_member);
  }

  public static String b(String paramString)
  {
    return "";
  }

  public static String b(String paramString, int paramInt)
  {
    int i = paramString.indexOf(' ', 2);
    if ((paramInt != -1) && ((i > paramInt) || ((i == -1) && (paramString.length() > paramInt))))
      paramString = paramString.substring(0, paramInt);
    while ((i == -1) || ((paramInt != -1) && (i > paramInt)))
      return paramString;
    return paramString.substring(0, i);
  }

  public static String b(String paramString1, String paramString2)
  {
    return ca.a(paramString1, paramString2);
  }

  public static void b(Editable paramEditable, b paramb, int paramInt1, int paramInt2)
  {
    a(paramEditable, paramb, paramInt1, paramInt2, false);
  }

  public static boolean b(CharSequence paramCharSequence)
  {
    boolean bool1;
    if (!a(paramCharSequence))
    {
      boolean bool2 = a(paramCharSequence, 0, paramCharSequence.length());
      bool1 = false;
      if (!bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  public static SpannableStringBuilder c(String paramString1, String paramString2)
  {
    String str = c.a(b(), R.string.public_group_pending_admin_message, new Object[] { paramString1, paramString2 });
    int i = str.indexOf(paramString1);
    int j = str.indexOf(paramString2);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), i, i + paramString1.length(), 17);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), j, j + paramString2.length(), 17);
    return localSpannableStringBuilder;
  }

  public static String c(int paramInt)
  {
    String str = new DecimalFormat("#,###,###").format(paramInt);
    return b().getString(R.string.public_groups_followers_label, new Object[] { str });
  }

  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return paramString;
    int i = paramString.length();
    int j = 0;
    label20: int k;
    if (j < i)
      if (!a(paramString.charAt(j)))
        k = i;
    while (true)
    {
      if ((j >= k) || (!a(paramString.charAt(k - 1))))
      {
        if ((j <= 0) && (k >= i))
          break;
        return paramString.substring(j, k);
        j++;
        break label20;
      }
      k--;
      continue;
      k = i;
    }
  }

  public static String c(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt >= paramString.length()))
      return paramString;
    return paramString.substring(0, paramInt) + "…";
  }

  // ERROR //
  public static byte[] c(CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 190
    //   4: ifeq +365 -> 369
    //   7: aload_0
    //   8: checkcast 190	android/text/Spanned
    //   11: astore_1
    //   12: aload_1
    //   13: iconst_0
    //   14: aload_0
    //   15: invokeinterface 731 1 0
    //   20: ldc 4
    //   22: invokeinterface 199 4 0
    //   27: astore_2
    //   28: aload_2
    //   29: arraylength
    //   30: ifne +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: new 865	java/io/ByteArrayOutputStream
    //   38: dup
    //   39: bipush 64
    //   41: invokespecial 866	java/io/ByteArrayOutputStream:<init>	(I)V
    //   44: astore_3
    //   45: new 868	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 871	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   53: astore 4
    //   55: aload_2
    //   56: arraylength
    //   57: istore 8
    //   59: iconst_0
    //   60: istore 9
    //   62: iload 9
    //   64: iload 8
    //   66: if_icmpge +273 -> 339
    //   69: aload_2
    //   70: iload 9
    //   72: aaload
    //   73: astore 10
    //   75: aload 10
    //   77: instanceof 263
    //   80: ifeq +64 -> 144
    //   83: aload 4
    //   85: iconst_1
    //   86: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   89: aload 4
    //   91: aload 10
    //   93: checkcast 263	com/viber/voip/ui/style/InternalURLSpan
    //   96: invokevirtual 877	com/viber/voip/ui/style/InternalURLSpan:getURL	()Ljava/lang/String;
    //   99: invokevirtual 880	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   102: aload 4
    //   104: aload_1
    //   105: aload 10
    //   107: invokeinterface 881 2 0
    //   112: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   115: aload 4
    //   117: aload_1
    //   118: aload 10
    //   120: invokeinterface 882 2 0
    //   125: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   128: aload 4
    //   130: aload_1
    //   131: aload 10
    //   133: invokeinterface 883 2 0
    //   138: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   141: goto +246 -> 387
    //   144: aload 10
    //   146: instanceof 885
    //   149: ifeq +75 -> 224
    //   152: aload 4
    //   154: iconst_2
    //   155: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   158: aload 4
    //   160: aload 10
    //   162: checkcast 885	android/text/style/ImageSpan
    //   165: invokevirtual 888	android/text/style/ImageSpan:getSource	()Ljava/lang/String;
    //   168: invokevirtual 880	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   171: aload 4
    //   173: aload_1
    //   174: aload 10
    //   176: invokeinterface 881 2 0
    //   181: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   184: aload 4
    //   186: aload_1
    //   187: aload 10
    //   189: invokeinterface 882 2 0
    //   194: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   197: goto +190 -> 387
    //   200: astore 6
    //   202: aload 4
    //   204: astore 7
    //   206: iconst_2
    //   207: anewarray 890	java/io/Closeable
    //   210: dup
    //   211: iconst_0
    //   212: aload_3
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload 7
    //   218: aastore
    //   219: invokestatic 893	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   222: aconst_null
    //   223: areturn
    //   224: aload 10
    //   226: instanceof 895
    //   229: ifeq +158 -> 387
    //   232: aload 4
    //   234: iconst_3
    //   235: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   238: aload 10
    //   240: checkcast 895	com/viber/voip/ui/style/c
    //   243: invokeinterface 896 1 0
    //   248: astore 11
    //   250: aload 4
    //   252: iconst_1
    //   253: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   256: aload 4
    //   258: aload_1
    //   259: aload 10
    //   261: invokeinterface 883 2 0
    //   266: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   269: invokestatic 291	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   272: astore 12
    //   274: aload 11
    //   276: aload 12
    //   278: iconst_0
    //   279: invokevirtual 900	com/viber/voip/flatbuffers/model/TextMetaInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   282: aload 12
    //   284: iconst_0
    //   285: invokevirtual 299	android/os/Parcel:setDataPosition	(I)V
    //   288: aload 12
    //   290: invokevirtual 904	android/os/Parcel:marshall	()[B
    //   293: astore 13
    //   295: aload 12
    //   297: invokevirtual 329	android/os/Parcel:recycle	()V
    //   300: aload 4
    //   302: aload 13
    //   304: arraylength
    //   305: invokevirtual 874	java/io/ObjectOutputStream:writeInt	(I)V
    //   308: aload 4
    //   310: aload 13
    //   312: invokevirtual 907	java/io/ObjectOutputStream:write	([B)V
    //   315: goto +72 -> 387
    //   318: astore 5
    //   320: iconst_2
    //   321: anewarray 890	java/io/Closeable
    //   324: dup
    //   325: iconst_0
    //   326: aload_3
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: aload 4
    //   332: aastore
    //   333: invokestatic 893	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   336: aload 5
    //   338: athrow
    //   339: aload 4
    //   341: invokevirtual 910	java/io/ObjectOutputStream:flush	()V
    //   344: aload_3
    //   345: invokevirtual 913	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   348: astore 14
    //   350: iconst_2
    //   351: anewarray 890	java/io/Closeable
    //   354: dup
    //   355: iconst_0
    //   356: aload_3
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload 4
    //   362: aastore
    //   363: invokestatic 893	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   366: aload 14
    //   368: areturn
    //   369: aconst_null
    //   370: areturn
    //   371: astore 5
    //   373: aconst_null
    //   374: astore 4
    //   376: goto -56 -> 320
    //   379: astore 15
    //   381: aconst_null
    //   382: astore 7
    //   384: goto -178 -> 206
    //   387: iinc 9 1
    //   390: goto -328 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   55	59	200	java/lang/Exception
    //   69	141	200	java/lang/Exception
    //   144	197	200	java/lang/Exception
    //   224	315	200	java/lang/Exception
    //   339	350	200	java/lang/Exception
    //   55	59	318	finally
    //   69	141	318	finally
    //   144	197	318	finally
    //   224	315	318	finally
    //   339	350	318	finally
    //   45	55	371	finally
    //   45	55	379	java/lang/Exception
  }

  public static CharSequence d(String paramString1, String paramString2)
  {
    if (a(paramString2))
      return paramString1;
    return paramString1 + " - \"" + paramString2 + "\"";
  }

  public static String d(CharSequence paramCharSequence)
  {
    String str;
    if (a(paramCharSequence))
      str = "";
    do
    {
      return str;
      str = paramCharSequence.toString();
    }
    while (!str.contains("</"));
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramCharSequence, 0, paramCharSequence.length());
    return localStringBuilder.toString();
  }

  public static String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return paramString;
    int i = paramString.length();
    for (int j = i; ; j--)
      if ((j >= 0) || (!a(paramString.charAt(j - 1))))
      {
        if (j >= i)
          break;
        return paramString.substring(0, j);
      }
  }

  public static String d(String paramString, int paramInt)
  {
    if ((!a(paramString)) && (paramString.length() > paramInt))
    {
      if (Character.isHighSurrogate(paramString.charAt(paramInt - 1)))
        paramInt--;
      if (paramInt <= 0)
        break label46;
    }
    label46: for (String str = paramString.substring(0, paramInt); ; str = "")
    {
      paramString = str;
      return paramString;
    }
  }

  private static CharSequence e(CharSequence paramCharSequence)
  {
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    for (int i = 0; i < localSpannableString.length(); i++)
    {
      int j = localSpannableString.charAt(i);
      if ((j == 8206) || (j == 8206))
        localSpannableString.setSpan(new ForegroundColorSpan(0), i, i + 1, 18);
    }
    return localSpannableString;
  }

  public static String e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return paramString;
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = 0;
    int k = 0;
    if (j < i)
    {
      char c1 = paramString.charAt(j);
      if ((c1 > ' ') && (!Character.isWhitespace(c1)))
      {
        if ((localStringBuilder.length() > 0) && (k != 0))
          localStringBuilder.append(' ');
        localStringBuilder.append(c1);
      }
      for (k = 0; ; k = 1)
      {
        j++;
        break;
      }
    }
    return localStringBuilder.toString();
  }

  public static String e(String paramString1, String paramString2)
  {
    if (paramString1 != null)
      if (paramString2 == null)
        break label36;
    while (true)
    {
      return b().getString(R.string.message_notification_user_in_group, new Object[] { paramString1, paramString2 });
      paramString1 = "";
      break;
      label36: paramString2 = "";
    }
  }

  public static CharSequence f(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(b().getString(R.string.message_notification_group_joined));
    a(localSpannableStringBuilder, "${user}", paramString1);
    a(localSpannableStringBuilder, "${group}", paramString2);
    return localSpannableStringBuilder.toString();
  }

  public static String f(String paramString)
  {
    String str1 = "";
    if (!a(paramString))
    {
      String[] arrayOfString = d.split(c.matcher(paramString).replaceAll(" "), 0);
      int i = arrayOfString.length;
      if (i > 0)
      {
        String str3 = arrayOfString[0];
        if ((a(str3)) || (!m(String.valueOf(str3.charAt(0)))))
          break label145;
        str1 = String.valueOf(arrayOfString[0].charAt(0));
      }
      if (i > 1)
      {
        String str2 = arrayOfString[(-1 + arrayOfString.length)];
        if ((!a(str2)) && (m(String.valueOf(str2.charAt(0)))))
          str1 = str1 + String.valueOf(str2.charAt(0));
      }
    }
    return str1.toUpperCase();
    label145: return "";
  }

  public static CharSequence g(String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(b().getString(R.string.message_notification_pgroup_manu_joined));
    a(localSpannableStringBuilder, "${count}", paramString1);
    a(localSpannableStringBuilder, "${group}", paramString2);
    return localSpannableStringBuilder.toString();
  }

  public static String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!a(paramString))
    {
      String[] arrayOfString = d.split(c.matcher(paramString).replaceAll(" "), 0);
      int i = arrayOfString.length;
      if (i < 3);
      while (true)
      {
        for (int j = 0; j < i; j++)
          if ((!a(arrayOfString[j])) && (m(String.valueOf(arrayOfString[j].charAt(0)))))
            localStringBuilder.append(arrayOfString[j].charAt(0));
        i = 3;
      }
    }
    return localStringBuilder.toString().toUpperCase();
  }

  public static String h(String paramString)
  {
    return (String)ca.a(paramString, "");
  }

  public static String i(String paramString)
    throws IllegalArgumentException
  {
    if (paramString == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = paramString.getBytes();
    int i = 0;
    if (i < arrayOfByte.length)
    {
      int j = arrayOfByte[i];
      if (j == 61)
      {
        int k = i + 1;
        int m;
        int n;
        try
        {
          m = Character.digit((char)arrayOfByte[k], 16);
          i = k + 1;
          n = Character.digit((char)arrayOfByte[i], 16);
          if ((m < 0) || (n < 0))
            throw new IllegalArgumentException("Invalid quoted-printable encoded character");
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw new IllegalArgumentException("Invalid quoted-printable encoded character");
        }
        int i1 = (char)(n + (m << 4));
        localByteArrayOutputStream.write(i1);
      }
      while (true)
      {
        i++;
        break;
        localByteArrayOutputStream.write(j);
      }
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }

  public static String j(String paramString)
  {
    if (paramString != null)
      return paramString + ":";
    return "";
  }

  public static CharSequence k(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return b().getString(R.string.chat_joined_notification, new Object[] { paramString });
  }

  public static String l(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; (j < i) && (Character.isWhitespace(paramString.charAt(j))); j++);
    while ((j < i) && (Character.isWhitespace(paramString.charAt(i - 1))))
      i--;
    if ((j > 0) || (i < paramString.length()))
      paramString = paramString.substring(j, i);
    return paramString;
  }

  private static boolean m(String paramString)
  {
    return a.matcher(paramString).matches();
  }

  static enum a
  {
    private DecimalFormat f;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }

    private a(String paramString)
    {
      this.f = new DecimalFormat(paramString);
      this.f.setRoundingMode(RoundingMode.FLOOR);
    }

    public DecimalFormat a()
    {
      return this.f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.da
 * JD-Core Version:    0.6.2
 */