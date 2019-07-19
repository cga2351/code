package com.viber.voip.messages;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.viber.dexshared.Logger;
import com.viber.jni.GroupUserChanged;
import com.viber.voip.R.drawable;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ae;
import com.viber.voip.util.av;
import com.viber.voip.util.bp;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dx;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.json.JSONException;

public class j
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Pattern c = Pattern.compile("0#");
  private static final Pattern d = Pattern.compile("##");
  private String b;
  private final Context e;
  private final af f;
  private final b g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  private final String p;
  private final String q;
  private final String r;
  private final String s;

  @Inject
  public j(Context paramContext)
  {
    this.e = bp.c(paramContext);
    this.f = UserManager.from(paramContext).getRegistrationValues();
    this.g = com.viber.voip.messages.d.c.c();
    this.b = this.e.getString(R.string.conversation_you);
    this.h = this.e.getString(R.string.facebook_media_type_text);
    this.i = this.e.getString(R.string.snippet_type_deleted);
    this.j = this.e.getString(R.string.message_type_photo);
    this.k = this.e.getString(R.string.message_type_video);
    this.l = this.e.getString(R.string.message_type_voice);
    this.m = this.e.getString(R.string.message_type_video_ptt);
    this.n = this.e.getString(R.string.message_type_location);
    this.o = this.e.getString(R.string.message_type_sticker);
    this.p = this.e.getString(R.string.message_type_notification);
    this.q = this.e.getString(R.string.message_type_share_contact_message);
    this.r = this.e.getString(R.string.message_type_file);
    this.s = this.e.getString(R.string.message_type_gif);
  }

  private a a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    String str1 = j(paramArrayOfString[1]);
    String str2 = paramArrayOfString[2];
    com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(str1, cd.j(paramInt1));
    String str3;
    if ((localm != null) && (localm.i() > 0L))
      str3 = localm.a(paramInt1, paramInt2);
    while (true)
    {
      Context localContext = this.e;
      int i1 = R.string.change_phone_number_conversation_system_msg;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = da.d(str3);
      arrayOfObject[1] = str2;
      return new a(com.viber.common.d.c.a(localContext, i1, arrayOfObject), false);
      str3 = a(str1, paramInt1, paramInt2);
      if (paramArrayOfString.length > 3)
      {
        String str4 = j(paramArrayOfString[3]);
        if ((!TextUtils.isEmpty(str4)) && (!str4.equals(str3)))
          str3 = str3 + "(" + str4 + ")";
      }
    }
  }

  public static String a(int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "timebomb";
    arrayOfObject[1] = Integer.valueOf(paramInt);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String a(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      if (TextUtils.isEmpty(paramString))
        paramString = paramContext.getResources().getString(R.string.facebook_media_type_text);
      break;
    case 1:
    case 3:
    case 2:
    case 1009:
    case 14:
    case 1010:
    case 5:
    case 4:
    case 1000:
    case 9:
    case 10:
    case 1005:
    case 8:
    }
    while (true)
    {
      return paramString;
      return paramContext.getResources().getString(R.string.message_type_photo);
      return paramContext.getResources().getString(R.string.message_type_video);
      return paramContext.getResources().getString(R.string.message_type_voice);
      return paramContext.getResources().getString(R.string.message_type_video_ptt);
      return paramContext.getResources().getString(R.string.message_type_location);
      return paramContext.getResources().getString(R.string.message_type_sticker);
      return paramContext.getResources().getString(R.string.message_type_notification);
      return paramContext.getResources().getString(R.string.message_type_share_contact_message);
      return paramContext.getResources().getString(R.string.message_type_file);
      return paramContext.getResources().getString(R.string.message_type_gif);
      try
      {
        localFormattedMessage = new FormattedMessage(paramString);
        if (localFormattedMessage == null)
          continue;
        str1 = localFormattedMessage.getPreviewText();
        Iterator localIterator = localFormattedMessage.getMessage().iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (!((BaseMessage)localIterator.next()).getType().equals(MessageType.GIF));
        str2 = paramContext.getResources().getString(R.string.message_type_gif);
        return str2;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          String str1;
          FormattedMessage localFormattedMessage = null;
          continue;
          String str2 = str1;
        }
      }
    }
  }

  public static String a(Context paramContext, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      if (localStringBuilder.length() > 0)
      {
        if (-1 + paramArrayOfString.length != i1)
          break label67;
        localStringBuilder.append(' ').append(paramContext.getString(R.string.vibe_many_joined_and)).append(' ');
      }
      while (true)
      {
        localStringBuilder.append(paramArrayOfString[i1]);
        i1++;
        break;
        label67: localStringBuilder.append(", ");
      }
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "many_add";
    arrayOfObject[1] = i(localStringBuilder.toString());
    arrayOfObject[2] = Integer.valueOf(paramArrayOfString.length);
    return String.format("%s/%s/%s", arrayOfObject);
  }

  public static String a(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "screenshot";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  private String a(String paramString, int paramInt1, int paramInt2)
  {
    if (m.a(this.f, paramString))
      return this.b;
    return this.g.a(paramString, paramInt1, paramInt2);
  }

  public static String a(String paramString1, int paramInt, String paramString2)
  {
    int i1;
    int i2;
    label17: int i3;
    label26: String str;
    if ((paramInt & 0x4) != 0)
    {
      i1 = 1;
      if ((paramInt & 0x2) == 0)
        break label100;
      i2 = 1;
      if ((paramInt & 0x1) == 0)
        break label106;
      i3 = 1;
      if ((i1 == 0) || (i2 == 0) || (i3 == 0))
        break label112;
      str = ViberApplication.getApplication().getString(R.string.message_notification_group_bg_icon_name_changed_text);
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = "many_group_attrs_changed";
      arrayOfObject[1] = i(paramString1);
      arrayOfObject[2] = str;
      arrayOfObject[3] = i(paramString2);
      return String.format("%s/%s/%s/%s", arrayOfObject);
      i1 = 0;
      break;
      label100: i2 = 0;
      break label17;
      label106: i3 = 0;
      break label26;
      label112: if ((i1 != 0) && (i2 != 0))
        str = ViberApplication.getApplication().getString(R.string.message_notification_group_bg_icon_changed_text);
      else if ((i1 != 0) && (i3 != 0))
        str = ViberApplication.getApplication().getString(R.string.message_notification_group_bg_name_changed_text);
      else if ((i2 != 0) && (i3 != 0))
        str = ViberApplication.getApplication().getString(R.string.message_notification_group_icon_name_changed_text);
      else
        str = "";
    }
  }

  public static String a(String paramString, Uri paramUri)
  {
    if (paramUri != null)
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = "group_icon_changed_with_icon";
      arrayOfObject2[1] = i(paramString);
      arrayOfObject2[2] = i(paramUri.toString());
      return String.format("%s/%s/%s", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = "group_icon_removed";
    arrayOfObject1[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject1);
  }

  public static String a(String paramString, GroupUserChanged paramGroupUserChanged)
  {
    if (cd.c(paramGroupUserChanged.getRole()))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = "added_as_admin";
      arrayOfObject2[1] = i(paramString);
      return String.format("%s/%s", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = "removed_as_admin";
    arrayOfObject1[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject1);
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "group_rename";
    arrayOfObject[1] = i(paramString1);
    arrayOfObject[2] = i(paramString2);
    arrayOfObject[3] = i(paramString3);
    return String.format("%s/%s/%s/%s", arrayOfObject);
  }

  public static String a(String paramString, String[] paramArrayOfString)
  {
    int i1 = 0;
    String[] arrayOfString = new String[2 + paramArrayOfString.length];
    arrayOfString[0] = "removed";
    int i2 = 2;
    arrayOfString[1] = i(paramString);
    int i3 = paramArrayOfString.length;
    while (i1 < i3)
    {
      String str = paramArrayOfString[i1];
      int i4 = i2 + 1;
      arrayOfString[i2] = i(str);
      i1++;
      i2 = i4;
    }
    return TextUtils.join("/", arrayOfString);
  }

  public static String a(String[] paramArrayOfString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "many_add_members";
    arrayOfObject[1] = i(TextUtils.join(",", paramArrayOfString));
    arrayOfObject[2] = Integer.valueOf(paramArrayOfString.length);
    return String.format("%s/%s/%s", arrayOfObject);
  }

  public static String b(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "add";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String b(String paramString, Uri paramUri)
  {
    if (paramUri != null)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = "group_icon_changed";
      arrayOfObject2[1] = i(paramString);
      return String.format("%s/%s", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = "group_icon_removed";
    arrayOfObject1[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject1);
  }

  public static String b(String paramString1, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "phone_number_changed";
    arrayOfObject[1] = i(paramString1);
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = i(paramString3);
    return String.format("%s/%s/%s/%s", arrayOfObject);
  }

  public static String b(String[] paramArrayOfString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "many_add_br";
    arrayOfObject[1] = i(TextUtils.join(",", paramArrayOfString));
    arrayOfObject[2] = Integer.valueOf(paramArrayOfString.length);
    return String.format("%s/%s/%s", arrayOfObject);
  }

  public static String c(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "add_br";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String d(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "removed_br";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String e(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "add_by_link";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String f(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "broadcast_list_created";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String g(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "group_background_changed";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String h(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "message_deleted";
    arrayOfObject[1] = i(paramString);
    return String.format("%s/%s", arrayOfObject);
  }

  public static String i(String paramString)
  {
    if (paramString != null)
      paramString = paramString.replaceAll("#", "##").replaceAll("/", "0#");
    return paramString;
  }

  public static String j(String paramString)
  {
    return d.matcher(c.matcher(paramString).replaceAll("/")).replaceAll("#");
  }

  public a a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 != null)
    {
      boolean bool1 = m.e(paramInt1);
      boolean bool2 = m.b(paramInt1);
      String[] arrayOfString1 = paramString1.split("/");
      boolean bool3 = paramString2.equals(this.b);
      if (arrayOfString1.length > 1)
      {
        String str1 = arrayOfString1[0];
        if (str1.equals("add"))
        {
          if (!m.a(this.f, j(arrayOfString1[1])))
          {
            if (bool2)
              return new a(new SpannableString(com.viber.common.d.c.a(this.e, R.string.message_notification_added_as_admin, new Object[] { paramString2 })), true);
            Context localContext22 = this.e;
            int i30 = R.plurals.plural_notification_msg_join_pattern;
            Object[] arrayOfObject22 = new Object[1];
            arrayOfObject22[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext22, i30, 1, arrayOfObject22), true);
          }
          if (bool2)
            return new a(com.viber.common.d.c.a(this.e, R.string.notification_you_added_as_admin, new Object[0]), true);
          if (bool1);
          Context localContext21;
          int i29;
          Object[] arrayOfObject21;
          for (String str14 = this.e.getString(R.string.notification_msg_you_joined_pattern); ; str14 = com.viber.common.d.c.a(localContext21, i29, arrayOfObject21))
          {
            return new a(str14, true);
            localContext21 = this.e;
            i29 = R.string.notification_msg_single_joined_group_pattern;
            arrayOfObject21 = new Object[1];
            arrayOfObject21[0] = da.d(paramString2);
          }
        }
        if (str1.equals("add_by_link"))
        {
          String str13 = com.viber.common.d.c.a(this.e, R.string.chat_joined_notification, new Object[] { paramString2 });
          SpannableString localSpannableString2 = new SpannableString(str13);
          int i28 = str13.indexOf(paramString2);
          localSpannableString2.setSpan(new StyleSpan(1), i28, i28 + paramString2.length(), 17);
          return new a(localSpannableString2, true, false, null);
        }
        if (str1.equals("many_add"))
        {
          String str12 = j(arrayOfString1[1]).replaceAll("Unknown", this.e.getString(R.string.unknown));
          Context localContext20 = this.e;
          int i27 = R.plurals.plural_notification_msg_join_pattern;
          Object[] arrayOfObject20 = new Object[1];
          arrayOfObject20[0] = da.d(str12);
          return new a(com.viber.common.d.c.a(localContext20, i27, 2, arrayOfObject20), false);
        }
        if ((str1.equals("many_add_members")) || (str1.equals("many_add_br")))
        {
          String[] arrayOfString2 = j(arrayOfString1[1]).split(",");
          StringBuilder localStringBuilder = new StringBuilder();
          int i1 = 0;
          if (i1 < arrayOfString2.length)
          {
            if (localStringBuilder.length() > 0)
            {
              if (-1 + arrayOfString2.length != i1)
                break label564;
              localStringBuilder.append(" ");
              localStringBuilder.append(this.e.getString(R.string.vibe_many_joined_and));
              localStringBuilder.append(" ");
            }
            while (true)
            {
              localStringBuilder.append(com.viber.common.d.c.a(a(arrayOfString2[i1], paramInt1, paramInt2)));
              i1++;
              break;
              label564: localStringBuilder.append(", ");
            }
          }
          if (str1.equals("many_add_br"))
          {
            Context localContext2 = this.e;
            int i3 = R.string.notification_msg_broadcast_list_added_recipients;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = da.d(localStringBuilder);
            return new a(com.viber.common.d.c.a(localContext2, i3, arrayOfObject2), false);
          }
          Context localContext1 = this.e;
          int i2 = R.plurals.plural_notification_msg_join_pattern;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = da.d(localStringBuilder);
          return new a(com.viber.common.d.c.a(localContext1, i2, 2, arrayOfObject1), false);
        }
        if (str1.equals("leave"))
        {
          if (arrayOfString1.length == 2)
          {
            Context localContext19 = this.e;
            int i26 = R.string.notification_msg_leave_pattern;
            Object[] arrayOfObject19 = new Object[1];
            arrayOfObject19[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext19, i26, arrayOfObject19), true);
          }
        }
        else
        {
          if (str1.equals("group_rename"))
          {
            String str9 = j(arrayOfString1[1]);
            if ((arrayOfString1.length > 3) && (arrayOfString1[3] != null));
            for (String str10 = j(arrayOfString1[3]); (str9 != null) && (str9.equals(this.f.l())); str10 = this.e.getString(R.string.default_group_name))
            {
              Context localContext18 = this.e;
              int i25 = R.string.notification_msg_you_rename_group_pattern;
              Object[] arrayOfObject18 = new Object[1];
              arrayOfObject18[0] = da.d(str10);
              return new a(localContext18.getString(i25, arrayOfObject18), true);
            }
            String str11 = com.viber.common.d.c.a(this.e, R.string.notification_msg_rename_group_pattern, new Object[] { paramString2, str10 });
            SpannableString localSpannableString1 = new SpannableString(str11);
            int i23 = str11.indexOf(paramString2);
            localSpannableString1.setSpan(new StyleSpan(1), i23, i23 + paramString2.length(), 0);
            int i24 = str11.lastIndexOf(str10);
            if (i24 > 0)
              localSpannableString1.setSpan(new StyleSpan(1), i24 - 1, str11.length(), 0);
            return new a(localSpannableString1, true, false, null);
          }
          if (str1.equals("leaved_group"))
            return new a(this.e.getString(R.string.notification_msg_group_leaved), true);
          if (str1.equals("removed"))
          {
            String[] arrayOfString3 = new String[-2 + arrayOfString1.length];
            System.arraycopy(arrayOfString1, 2, arrayOfString3, 0, arrayOfString3.length);
            for (int i19 = 0; i19 < arrayOfString3.length; i19++)
              arrayOfString3[i19] = a(j(arrayOfString3[i19]), paramInt1, paramInt2);
            if (bool3)
            {
              Context localContext17 = this.e;
              int i22 = R.string.notification_msg_group_you_removed_member;
              Object[] arrayOfObject17 = new Object[1];
              arrayOfObject17[0] = da.d(TextUtils.join(", ", arrayOfString3));
              return new a(com.viber.common.d.c.a(localContext17, i22, arrayOfObject17), true);
            }
            if ((arrayOfString3.length == 1) && (arrayOfString3[0].equals(this.b)))
            {
              Context localContext16 = this.e;
              int i21 = R.string.notification_msg_group_member_removed_you;
              Object[] arrayOfObject16 = new Object[1];
              arrayOfObject16[0] = da.d(paramString2);
              return new a(com.viber.common.d.c.a(localContext16, i21, arrayOfObject16), true);
            }
            Context localContext15 = this.e;
            int i20 = R.string.notification_msg_group_removed_member;
            Object[] arrayOfObject15 = new Object[2];
            arrayOfObject15[0] = da.d(paramString2);
            arrayOfObject15[1] = da.d(TextUtils.join(", ", arrayOfString3));
            return new a(com.viber.common.d.c.a(localContext15, i20, arrayOfObject15), true);
          }
          if (str1.equals("group_icon_changed"))
          {
            if (bool3)
              return new a(com.viber.common.d.c.a(this.e, R.string.notification_msg_group_icon_you_change_pattern, new Object[0]), true);
            Context localContext14 = this.e;
            int i18 = R.string.notification_msg_group_icon_change_pattern;
            Object[] arrayOfObject14 = new Object[1];
            arrayOfObject14[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext14, i18, arrayOfObject14), true);
          }
          if (str1.equals("group_icon_changed_with_icon"))
          {
            String str8;
            if (arrayOfString1.length == 3)
            {
              str8 = j(arrayOfString1[2]);
              boolean bool4 = TextUtils.isEmpty(str8);
              localUri = null;
              if (!bool4)
                if (str8.indexOf("/") >= 0)
                  break label1439;
            }
            label1439: for (Uri localUri = dx.h(str8); ; localUri = Uri.parse(str8))
            {
              if (!bool3)
                break label1449;
              return new a(com.viber.common.d.c.a(this.e, R.string.notification_msg_group_icon_you_change_pattern, new Object[0]), true, true, localUri);
              str8 = null;
              break;
            }
            label1449: Context localContext13 = this.e;
            int i17 = R.string.notification_msg_group_icon_change_pattern;
            Object[] arrayOfObject13 = new Object[1];
            arrayOfObject13[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext13, i17, arrayOfObject13), true, true, localUri);
          }
          if (str1.equals("group_icon_removed"))
          {
            if (bool3)
              return new a(this.e.getString(R.string.notification_msg_group_icon_you_remove_pattern), true);
            Context localContext12 = this.e;
            int i16 = R.string.notification_msg_group_icon_remove_pattern;
            Object[] arrayOfObject12 = new Object[1];
            arrayOfObject12[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext12, i16, arrayOfObject12), true);
          }
          if (str1.equals("group_background_changed"))
          {
            Context localContext11 = this.e;
            int i15 = R.string.notification_msg_group_background_change_pattern;
            Object[] arrayOfObject11 = new Object[1];
            arrayOfObject11[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext11, i15, arrayOfObject11), true);
          }
          if (str1.equals("many_group_attrs_changed"))
            return new a(String.format(arrayOfString1[2], new Object[] { paramString2 }), true);
          if (str1.equals("added_as_admin"))
          {
            if (bool2);
            for (int i14 = R.string.notification_you_added_as_superadmin; ; i14 = R.string.notification_you_added_as_admin)
              return new a(com.viber.common.d.c.a(this.e, i14, new Object[0]), true);
          }
          if (str1.equals("removed_as_admin"))
          {
            if (bool2);
            for (int i13 = R.string.notification_you_removed_as_superadmin; ; i13 = R.string.notification_you_removed_as_admin)
              return new a(com.viber.common.d.c.a(this.e, i13, new Object[0]), true);
          }
          if (str1.equals("message_deleted"))
          {
            if (bool3)
              return new a(this.e.getString(R.string.message_notification_message_deleted_you), true);
            Context localContext10 = this.e;
            int i12 = R.string.message_notification_message_deleted;
            Object[] arrayOfObject10 = new Object[1];
            arrayOfObject10[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext10, i12, arrayOfObject10), true);
          }
          if (str1.equals("user_identity_changed"))
          {
            Context localContext9 = this.e;
            int i11 = R.string.message_notification_user_identity_changed;
            Object[] arrayOfObject9 = new Object[1];
            arrayOfObject9[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext9, i11, arrayOfObject9), true);
          }
          if (str1.equals("timebomb"))
          {
            int i9 = Integer.valueOf(arrayOfString1[1]).intValue();
            if (i9 == 0);
            for (String str7 = this.e.getString(R.string.timebomb_off); bool3; str7 = ae.a(this.e, i9))
              return new a(this.e.getString(R.string.secret_chat_timebomb_changed_by_you, new Object[] { str7 }), false);
            Context localContext8 = this.e;
            int i10 = R.string.secret_chat_timebomb_changed;
            Object[] arrayOfObject8 = new Object[2];
            arrayOfObject8[0] = da.d(paramString2);
            arrayOfObject8[1] = str7;
            return new a(com.viber.common.d.c.a(localContext8, i10, arrayOfObject8), false);
          }
          if (str1.equals("screenshot"))
          {
            if (bool3)
            {
              Context localContext7 = this.e;
              int i8 = R.string.secret_chat_screenshot_notification;
              Object[] arrayOfObject7 = new Object[1];
              arrayOfObject7[0] = this.b;
              return new a(localContext7.getString(i8, arrayOfObject7), false);
            }
            Context localContext6 = this.e;
            int i7 = R.string.secret_chat_screenshot_notification;
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = da.d(paramString2);
            return new a(com.viber.common.d.c.a(localContext6, i7, arrayOfObject6), false);
          }
          if (str1.equals("phone_number_changed"))
            return a(arrayOfString1, paramInt1, paramInt2);
          if (str1.equals("broadcast_list_created"))
            return new a(this.e.getString(R.string.broadcast_list_created), false);
          if (str1.equals("add_br"))
          {
            Context localContext5 = this.e;
            int i6 = R.string.notification_msg_broadcast_list_added_recipients;
            Object[] arrayOfObject5 = new Object[1];
            if (bool3);
            for (String str6 = da.d(a(arrayOfString1[1], paramInt1, paramInt2)); ; str6 = da.d(paramString2))
            {
              arrayOfObject5[0] = str6;
              return new a(com.viber.common.d.c.a(localContext5, i6, arrayOfObject5), true);
            }
          }
          if (str1.equals("removed_br"))
          {
            Context localContext4 = this.e;
            int i5 = R.string.notification_msg_broadcast_list_removed_recipients;
            Object[] arrayOfObject4 = new Object[1];
            if (bool3);
            for (String str5 = da.d(a(arrayOfString1[1], paramInt1, paramInt2)); ; str5 = da.d(paramString2))
            {
              arrayOfObject4[0] = str5;
              return new a(com.viber.common.d.c.a(localContext4, i5, arrayOfObject4), true);
            }
          }
          if (str1.equals("group_security_changed"))
          {
            String str3 = j(arrayOfString1[1]);
            String str4 = j(arrayOfString1[2]);
            if (this.f.l().equals(str4))
              paramString2 = this.b;
            return new a(com.viber.common.d.c.a(this.e, R.string.debug_group_security_changed_message, new Object[] { paramString2, str4, str3 }), true);
          }
          if (str1.equals("add_watcher"))
          {
            if (bool1);
            Context localContext3;
            int i4;
            Object[] arrayOfObject3;
            for (String str2 = this.e.getString(R.string.notification_msg_you_joined_pattern); ; str2 = com.viber.common.d.c.a(localContext3, i4, arrayOfObject3))
            {
              return new a(str2, true);
              localContext3 = this.e;
              i4 = R.string.notification_msg_single_joined_group_pattern;
              arrayOfObject3 = new Object[1];
              arrayOfObject3[0] = da.d(paramString2);
            }
          }
        }
      }
    }
    return new a(this.e.getString(R.string.message_type_notification), false);
  }

  public b a(int paramInt1, long paramLong, String paramString1, String paramString2, ConversationLoaderEntity paramConversationLoaderEntity, ai paramai, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      return new b(new SpannableString(this.h), 0);
    int i1 = 0;
    String str;
    switch (paramInt1)
    {
    default:
    case 0:
    case 1:
    case 3:
    case 2:
    case 1009:
    case 14:
    case 1010:
    case 5:
    case 4:
    case 1000:
    case 1002:
      while (true)
      {
        return new b(new SpannableString(paramString1), i1);
        if (av.c(paramLong, 38))
        {
          paramString1 = this.e.getString(R.string.snippet_type_poll);
          i1 = R.drawable.ic_chat_list_poll_inset;
        }
        else if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = "";
          i1 = 0;
        }
        else
        {
          b localb = this.g;
          int i3 = aj.c;
          int i4 = paramConversationLoaderEntity.getConversationType();
          int i5 = paramConversationLoaderEntity.getGroupRole();
          return new b(da.a(paramString1, paramai, localb, paramString2, false, false, true, false, i3, i4, i5), 0);
          paramString1 = this.j;
          i1 = R.drawable.ic_chat_list_photo_inset;
          continue;
          paramString1 = this.k;
          i1 = R.drawable.ic_chat_list_video_inset;
          continue;
          paramString1 = this.l;
          i1 = R.drawable.ic_chat_list_voice_inset;
          continue;
          paramString1 = this.m;
          i1 = R.drawable.ic_chat_list_video_inset;
          continue;
          paramString1 = this.n;
          i1 = 0;
          continue;
          paramString1 = this.o;
          i1 = R.drawable.ic_chat_list_sticker_inset;
          continue;
          paramString1 = this.p;
          i1 = 0;
          continue;
          i1 = dg.e(paramString1);
          paramString1 = dg.a(paramString1, paramInt2);
          if (paramInt2 > 1)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = paramString1;
            arrayOfObject[1] = Integer.valueOf(paramInt2);
            paramString1 = String.format("%s (%d)", arrayOfObject);
          }
        }
      }
    case 7:
      FormattedMessage localFormattedMessage2 = paramConversationLoaderEntity.getFormattedMessage();
      if (localFormattedMessage2 != null)
        paramString1 = localFormattedMessage2.getPreviewText();
      while (true)
      {
        boolean bool2 = TextUtils.isEmpty(paramString1);
        i1 = 0;
        if (!bool2)
          break;
        paramString1 = this.h;
        i1 = 0;
        break;
        if (TextUtils.isEmpty(paramString1))
          paramString1 = "";
      }
    case 8:
      FormattedMessage localFormattedMessage1 = paramConversationLoaderEntity.getFormattedMessage();
      if (localFormattedMessage1 != null)
      {
        str = localFormattedMessage1.getPreviewText();
        Iterator localIterator = localFormattedMessage1.getMessage().iterator();
        while (localIterator.hasNext())
          if (((BaseMessage)localIterator.next()).getType().equals(MessageType.GIF))
            str = this.s;
      }
      break;
    case 9:
    case 10:
    case 1005:
    case 1003:
    case 1004:
    case 1006:
    case 1008:
    }
    for (int i2 = R.drawable.ic_chat_list_photo_inset; ; i2 = 0)
    {
      i1 = i2;
      paramString1 = str;
      break;
      boolean bool1 = TextUtils.isEmpty(paramString1);
      i1 = 0;
      if (!bool1)
        break;
      paramString1 = "";
      i1 = 0;
      break;
      paramString1 = this.q;
      i1 = R.drawable.ic_chat_list_contact_inset;
      break;
      paramString1 = this.r;
      i1 = R.drawable.ic_chat_list_file_inset;
      break;
      paramString1 = this.s;
      i1 = R.drawable.ic_chat_list_photo_inset;
      break;
      paramString1 = this.h;
      i1 = 0;
      break;
      paramString1 = m.a(this.e, paramConversationLoaderEntity.isPublicAccount(), m.a(paramConversationLoaderEntity.getParsedMsgInfo()));
      i1 = R.drawable.ic_chat_list_rich_inset;
      break;
      paramString1 = this.i;
      i1 = R.drawable.ic_chat_list_deleted_inset;
      break;
    }
  }

  public String k(String paramString)
  {
    if (paramString != null)
      return paramString.split("/")[0];
    return null;
  }

  public static class a
  {
    public final Spanned a;
    public final boolean b;
    public final boolean c;
    public final Uri d;

    public a(Spannable paramSpannable, boolean paramBoolean)
    {
      this(paramSpannable, paramBoolean, false, null);
    }

    public a(Spannable paramSpannable, boolean paramBoolean1, boolean paramBoolean2, Uri paramUri)
    {
      this.a = paramSpannable;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramUri;
    }

    public a(String paramString, boolean paramBoolean)
    {
      this(paramString, paramBoolean, false, null);
    }

    public a(String paramString, boolean paramBoolean1, boolean paramBoolean2, Uri paramUri)
    {
      this.a = Html.fromHtml(paramString);
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramUri;
    }
  }

  public static class b
  {
    public final Spanned a;
    public final int b;

    public b(Spanned paramSpanned, int paramInt)
    {
      this.a = paramSpanned;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.j
 * JD-Core Version:    0.6.2
 */