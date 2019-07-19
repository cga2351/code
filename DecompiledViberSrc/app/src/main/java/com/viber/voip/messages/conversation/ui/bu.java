package com.viber.voip.messages.conversation.ui;

import android.app.Application;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.c.c;
import com.viber.voip.util.bj;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bu
{
  public static String a;
  public static String b;
  private static final Logger c = ViberEnv.getLogger();
  private final Fragment d;

  public bu(Fragment paramFragment)
  {
    this.d = paramFragment;
  }

  public static ComposeDataContainer a(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      ComposeDataContainer localComposeDataContainer = a(new JSONObject(paramString));
      return localComposeDataContainer;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static ComposeDataContainer a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    String str1 = da.h(paramJSONObject.optString("Name"));
    String str2 = da.h(paramJSONObject.optString("SortName"));
    String str3 = da.h(paramJSONObject.optString("PhoneNumber"));
    String str4 = da.h(paramJSONObject.optString("ViberNumber"));
    String str5 = da.h(paramJSONObject.optString("DownloadId"));
    if (!da.a(str5));
    for (Uri localUri = dx.a(str5); ; localUri = null)
    {
      if (localUri == null)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("pa_message_data");
        String str6 = null;
        if (localJSONObject != null)
          str6 = localJSONObject.optString("media");
        if (!da.a(str6))
          localUri = Uri.parse(str6);
      }
      return new ComposeDataContainer(str1, str2, str3, str4, localUri, str5);
    }
  }

  private static Object a(JSONArray paramJSONArray, String paramString1, int paramInt, String paramString2, ComposeDataContainer paramComposeDataContainer)
    throws JSONException
  {
    paramJSONArray.getJSONObject(paramInt).put("Action", new JSONObject(paramString1));
    paramJSONArray.getJSONObject(paramInt).getJSONObject("Action").getJSONObject("parameters").put("contact_name", paramComposeDataContainer.contactName);
    paramJSONArray.getJSONObject(paramInt).getJSONObject("Action").getJSONObject("parameters").put("sort_name", paramComposeDataContainer.contactPhoneticName);
    paramJSONArray.getJSONObject(paramInt).getJSONObject("Action").getJSONObject("parameters").put("contact_number", paramComposeDataContainer.selectedNumber);
    paramJSONArray.getJSONObject(paramInt).getJSONObject("Action").getJSONObject("parameters").put("already_added_action", paramString2);
    return paramJSONArray.get(3);
  }

  public static String a(String paramString1, ComposeDataContainer paramComposeDataContainer, String paramString2, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(paramString1);
        JSONArray localJSONArray2 = a();
        if (!da.a(paramString2))
        {
          localUri = dx.a(paramString2);
          String str1 = ActionType.ADD_CONTACT.getAction();
          String str2 = String.format(Locale.US, b(), new Object[] { str1 });
          String str3;
          if (da.a(paramComposeDataContainer.viberNumber))
          {
            str3 = paramComposeDataContainer.selectedNumber;
            localJSONArray2.getJSONObject(0).put("Invisible", false);
            localJSONArray2.getJSONObject(0).put("ImageUrl", localUri.toString());
            localJSONArray2.getJSONObject(0).put("Action", new JSONObject(str2));
            localJSONArray2.getJSONObject(0).getJSONObject("Action").getJSONObject("parameters").put("contact_name", paramComposeDataContainer.contactName);
            localJSONArray2.getJSONObject(0).getJSONObject("Action").getJSONObject("parameters").put("sort_name", paramComposeDataContainer.contactPhoneticName);
            localJSONArray2.getJSONObject(0).getJSONObject("Action").getJSONObject("parameters").put("contact_number", str3);
            JSONObject localJSONObject = localJSONArray2.getJSONObject(0).getJSONObject("Action").getJSONObject("parameters");
            if (!paramBoolean)
            {
              localObject = ActionType.OPEN_CONVERSATION.getAction();
              localJSONObject.put("already_added_action", localObject);
              localJSONArray1.put(0, localJSONArray2.get(0));
              return localJSONArray1.toString();
            }
          }
          else
          {
            str3 = paramComposeDataContainer.viberNumber;
            continue;
          }
          String str4 = ActionType.ADD_CONTACT.getAction();
          Object localObject = str4;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
      Uri localUri = null;
    }
  }

  private static JSONArray a()
    throws IOException, JSONException
  {
    if (a == null)
      a = bj.a(ViberApplication.getApplication().getAssets().open("contact_sharing/share_contact_message_template.json"));
    return new JSONArray(a);
  }

  public static String[] a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (da.a(paramString))
      return new String[] { "[]", "{}" };
    try
    {
      String[] arrayOfString = a(new JSONObject(paramString), paramBoolean1, paramBoolean2);
      return arrayOfString;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String[] a(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramJSONObject == null)
      return null;
    ComposeDataContainer localComposeDataContainer = a(paramJSONObject);
    Resources localResources = ViberApplication.getApplication().getResources();
    String str1 = localResources.getString(R.string.share_contact_save_button_caption);
    String str2 = localResources.getString(R.string.invite_to_viber);
    String str3;
    if (paramBoolean2)
      str3 = localResources.getString(R.string.message_notification_share_contact_text_content_in_group);
    while (true)
    {
      String str4;
      label69: String str5;
      String str6;
      label91: String str7;
      label103: int i;
      if (da.a(localComposeDataContainer.contactName))
      {
        str4 = localComposeDataContainer.selectedNumber;
        str5 = localComposeDataContainer.selectedNumber;
        if (localComposeDataContainer.photoUri == null)
          break label556;
        str6 = localComposeDataContainer.photoUri.toString();
        if (paramBoolean1)
          break label562;
        str7 = ActionType.OPEN_CONVERSATION.getAction();
        if (da.a(localComposeDataContainer.viberNumber))
          break label573;
        i = 1;
      }
      try
      {
        localJSONArray1 = new JSONArray();
        localJSONArray2 = a();
        Locale localLocale1 = Locale.US;
        String str8 = b();
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = ActionType.ADD_CONTACT.getAction();
        str9 = String.format(localLocale1, str8, arrayOfObject1);
        String str10 = String.format(Locale.US, b(), new Object[] { "" });
        if (localComposeDataContainer.photoUri != null)
        {
          localJSONArray2.getJSONObject(0).put("Invisible", false);
          localJSONArray2.getJSONObject(0).put("ImageUrl", str6);
          if ((i == 0) && (ao.f()))
          {
            a(localJSONArray2, str10, 0, "", localComposeDataContainer);
            localJSONArray1.put(localJSONArray2.get(0));
          }
        }
        else
        {
          localJSONArray2.getJSONObject(1).put("Text", str4);
          if ((i != 0) || (!ao.f()))
            break label604;
          a(localJSONArray2, str10, 1, "", localComposeDataContainer);
          localJSONArray1.put(localJSONArray2.get(1));
          localJSONArray1.put(localJSONArray2.getJSONObject(2).put("Text", str5));
          if ((!paramBoolean1) || (ViberApplication.isTablet(null)))
            break label619;
          if (i == 0)
          {
            Locale localLocale2 = Locale.US;
            String str11 = b();
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = ActionType.INVITE_CONTACT.getAction();
            String str12 = String.format(localLocale2, str11, arrayOfObject2);
            localJSONArray2.getJSONObject(3).put("Invisible", false);
            localJSONArray2.getJSONObject(3).put("Caption", str2);
            a(localJSONArray2, str12, 3, ActionType.OPEN_CONVERSATION.getAction(), localComposeDataContainer);
            localJSONArray1.put(localJSONArray2.get(3));
          }
          localJSONArray2.getJSONObject(4).put("PreviewText", str4 + "\n" + str5);
          localJSONArray2.getJSONObject(4).put("PushText", str3);
          localJSONArray1.put(localJSONArray2.getJSONObject(4));
          String[] arrayOfString = new String[2];
          arrayOfString[0] = localJSONArray1.toString();
          arrayOfString[1] = paramJSONObject.toString();
          return arrayOfString;
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          localIOException.printStackTrace();
          return null;
          str3 = localResources.getString(R.string.message_notification_share_contact_text_content);
          break;
          str4 = localComposeDataContainer.contactName;
          break label69;
          str6 = null;
          break label91;
          str7 = ActionType.ADD_CONTACT.getAction();
          break label103;
          i = 0;
          continue;
          a(localJSONArray2, str9, 0, str7, localComposeDataContainer);
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          JSONArray localJSONArray1;
          JSONArray localJSONArray2;
          String str9;
          label556: label562: label573: localJSONException.printStackTrace();
          continue;
          label604: a(localJSONArray2, str9, 1, str7, localComposeDataContainer);
          continue;
          label619: if ((!paramBoolean1) && (!ao.f()))
          {
            localJSONArray2.getJSONObject(3).put("Invisible", false);
            localJSONArray2.getJSONObject(3).put("Caption", str1);
            a(localJSONArray2, str9, 3, ActionType.ADD_CONTACT.getAction(), localComposeDataContainer);
            localJSONArray1.put(localJSONArray2.get(3));
          }
        }
      }
    }
  }

  private static String b()
    throws IOException, JSONException
  {
    if (b == null)
      b = bj.a(ViberApplication.getApplication().getAssets().open("contact_sharing/view_action.json"));
    return b;
  }

  public JSONObject a(ComposeDataContainer paramComposeDataContainer, String paramString)
  {
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localJSONObject.put("Name", paramComposeDataContainer.contactName);
        localJSONObject.put("PhoneNumber", paramComposeDataContainer.selectedNumber);
        if (paramComposeDataContainer.viberNumber != null)
        {
          str1 = paramComposeDataContainer.viberNumber;
          localJSONObject.put("ViberNumber", str1);
          if (paramComposeDataContainer.contactPhoneticName == null)
            break label132;
          str2 = paramComposeDataContainer.contactPhoneticName;
          localJSONObject.put("SortName", str2);
          if ((paramComposeDataContainer.photoId != null) && (dx.b(paramComposeDataContainer.photoUri)))
          {
            str3 = paramComposeDataContainer.photoId;
            localJSONObject.put("DownloadId", str3);
            return localJSONObject;
          }
          String str3 = "";
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
      String str1 = "";
      continue;
      label132: String str2 = "";
    }
  }

  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.viber.voip.action.ACTION_CONTACT_LIST_SELECTABLE2_1TO1");
    localIntent.putExtra("title", this.d.getString(R.string.select_contact));
    localIntent.putExtra("return_result", true);
    localIntent.putExtra("all_filter", true);
    localIntent.putExtra("extra_ignore_blocked_users", true);
    localIntent.putExtra("extra_hide_root_number", true);
    localIntent.putExtra("extra_allow_select_self_number", true);
    if (paramBoolean)
      localIntent = c.a(localIntent);
    this.d.startActivityForResult(localIntent, 911);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bu
 * JD-Core Version:    0.6.2
 */