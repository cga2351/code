package com.viber.voip.messages.orm.entity.json;

import android.app.Application;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.settings.d.af;
import com.viber.voip.util.aw;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.bj;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.b;
import com.viber.voip.util.links.f;
import java.io.IOException;
import java.net.IDN;
import java.net.URL;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormattedUrlMessage
{
  public static final String EMPTY_JSON_ARRAY = "[]";
  public static final long IMAGE_SIZE_LIMIT_BYTES_OVER_MOBILE = 512000L;
  public static final long IMAGE_SIZE_LIMIT_BYTES_OVER_WI_FI = 2097152L;
  public static final String[] JSON_BUBBLE_DATA_KEY = { "Text", "ImageUrl", "ThumbnailUrl", "GifUrl", "Text", "Text" };
  private static final Logger L = ViberEnv.getLogger();
  public static int NUMBER_OF_BUBBLE_ITEMS = 0;
  public static long THUMB_SIZE_FORCE_PUT_TO_JSON = 0L;
  public static final String URL_MESSAGE_JSON_ASSET_FILE = "url_message/formatted_url_message.json";
  public static String URL_MESSAGE_TEMPLATE;
  public static String URL_MESSAGE_VIEW_ACTION_TEMPLATE;
  public static final String VIEW_ACTION_JSON_ASSET_FILE = "url_message/view_action.json";
  private static final long WARN_TIME_THRESHOLD_MS = 10L;

  public static String createUrlMessage(MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    try
    {
      String str = createUrlMessageOverJson(paramMsgInfo, paramBoolean);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "[]";
  }

  public static String createUrlMessage(String paramString, boolean paramBoolean)
  {
    try
    {
      String str = createUrlMessageOverJson((MsgInfo)e.a().a().a(paramString), paramBoolean);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "[]";
  }

  private static String createUrlMessageOverJson(MsgInfo paramMsgInfo, boolean paramBoolean)
    throws JSONException, IOException
  {
    if (paramMsgInfo == null)
      return null;
    String str1 = paramMsgInfo.getContentType();
    String str2;
    com.viber.voip.util.links.d locald;
    String str3;
    JSONArray localJSONArray;
    String str5;
    String str6;
    int i;
    int j;
    label156: int k;
    label167: int m;
    label232: int n;
    label250: int i1;
    label273: String str7;
    label282: String str8;
    label308: String str9;
    String str10;
    Locale localLocale2;
    Object[] arrayOfObject2;
    if (paramMsgInfo.getThumbnailContentType() != null)
    {
      str2 = paramMsgInfo.getThumbnailContentType();
      boolean bool1 = bg.a.d(str2);
      locald = f.c(paramMsgInfo.getUrl());
      str3 = paramMsgInfo.getText();
      String str4 = makeCleanedBodyText(locald, str3);
      localJSONArray = urlMessageTemplate();
      localJSONArray.getJSONObject(0).put(JSON_BUBBLE_DATA_KEY[0], str4);
      str5 = getThumbnail(paramMsgInfo, bool1);
      str6 = paramMsgInfo.getUrlType().toString();
      int[] arrayOfInt = determineThumbnailDimensionsIfNeeded(str5, paramMsgInfo.getThumbnailWidth(), paramMsgInfo.getThumbnailHeight(), bool1, paramBoolean);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      if (!bool1)
        break label459;
      if ((i <= 0) && (j <= 0))
        str5 = "";
      setFormattedDataGifSize(localJSONArray, i, j, paramMsgInfo.getContentLength(), str5);
      if (da.a(str5))
        break label495;
      k = 1;
      if ((da.a(str4)) && (k == 0))
        localJSONArray.getJSONObject(0).put(JSON_BUBBLE_DATA_KEY[0], str3);
      boolean bool2 = bg.a.d(str1);
      boolean bool3 = bg.a.a(str1);
      if (da.a(localJSONArray.getJSONObject(0).optString(JSON_BUBBLE_DATA_KEY[0])))
        break label501;
      m = 1;
      if ((k == 0) || ((!bool2) && (!bool3)))
        break label507;
      n = 1;
      if (((m != 0) || (n == 0)) && (!bool3) && (!bool2))
        break label513;
      i1 = 1;
      if (i1 == 0)
        break label519;
      str7 = "";
      localJSONArray.getJSONObject(4).put(JSON_BUBBLE_DATA_KEY[4], str7);
      if (i1 == 0)
        break label528;
      str8 = "";
      localJSONArray.getJSONObject(5).put(JSON_BUBBLE_DATA_KEY[5], str8);
      str9 = urlMessageViewActionTemplate();
      Locale localLocale1 = Locale.US;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = formViewAction(str1).getAction();
      str10 = String.format(localLocale1, str9, arrayOfObject1);
      if (k == 0)
        break label710;
      localLocale2 = Locale.US;
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ActionType.OPEN_URL.getAction();
    }
    label513: label519: label528: label710: for (String str11 = String.format(localLocale2, str9, arrayOfObject2); ; str11 = str10)
    {
      int i2 = 0;
      while (true)
        if (i2 < NUMBER_OF_BUBBLE_ITEMS)
        {
          JSONObject localJSONObject3 = localJSONArray.getJSONObject(i2);
          MessageType localMessageType = MessageType.toEnum(localJSONObject3.getString("Type"));
          if (MessageType.GIF == localMessageType)
          {
            localJSONObject3.remove("Action");
            i2++;
            continue;
            str2 = str1;
            break;
            label459: if (!ServerMsgInfoMediaType.isPlayable(str6))
            {
              setFormattedDataImageSize(localJSONArray, i, j, str5);
              break label156;
            }
            setFormattedDataVideoSize(localJSONArray, i, j, str5);
            break label156;
            label495: k = 0;
            break label167;
            label501: m = 0;
            break label232;
            label507: n = 0;
            break label250;
            i1 = 0;
            break label273;
            str7 = paramMsgInfo.getTitle();
            break label282;
            str8 = shortenUrl(locald);
            break label308;
          }
          if (MessageType.TEXT == localMessageType);
          for (String str12 = str11; ; str12 = str10)
          {
            localJSONObject3.put("Action", new JSONObject(str12));
            localJSONObject3.getJSONObject("Action").getJSONObject("parameters").put("url", locald.a);
            break;
          }
        }
      for (int i3 = 0; i3 < NUMBER_OF_BUBBLE_ITEMS; i3++)
        if (da.a(localJSONArray.getJSONObject(i3).optString(JSON_BUBBLE_DATA_KEY[i3])))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("Type", "");
          localJSONArray.put(i3, localJSONObject2);
        }
      JSONObject localJSONObject1 = localJSONArray.getJSONObject(6);
      localJSONObject1.put("PushText", str3);
      localJSONObject1.put("PreviewText", locald.b);
      return localJSONArray.toString();
    }
  }

  private static int[] determineThumbnailDimensionsIfNeeded(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    int[] arrayOfInt = { paramInt1, paramInt2 };
    if ((paramInt1 <= 0) && (paramInt2 <= 0) && (paramBoolean2) && (cj.b(ViberApplication.getApplication())) && (!dd.a()))
    {
      if (paramBoolean1)
      {
        Rect localRect = aw.a(Uri.parse(paramString));
        arrayOfInt[0] = localRect.width();
        arrayOfInt[1] = localRect.height();
      }
    }
    else
      return arrayOfInt;
    BitmapFactory.Options localOptions = j.b(paramString).a;
    if (localOptions != null);
    for (int j = localOptions.outWidth; ; j = i)
    {
      arrayOfInt[0] = j;
      if (localOptions != null)
        i = localOptions.outHeight;
      arrayOfInt[1] = i;
      return arrayOfInt;
    }
  }

  private static ActionType formViewAction(String paramString)
  {
    ActionType localActionType = ActionType.OPEN_URL;
    if (bg.a.d(paramString));
    do
    {
      return localActionType;
      if (bg.a.c(paramString))
        return ActionType.VIEW_VIDEO;
      if (bg.a.b(paramString))
        return ActionType.VIEW_VIDEO;
    }
    while (!bg.a.a(paramString));
    return ActionType.VIEW_PHOTO;
  }

  private static String getThumbnail(MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    String str = paramMsgInfo.getThumbnailUrl();
    long l = paramMsgInfo.getContentLength();
    if ((l != THUMB_SIZE_FORCE_PUT_TO_JSON) && (!paramBoolean))
    {
      PreRestrictionsChecker localPreRestrictionsChecker = PreRestrictionsCheckers.ALLOW_IMAGE_BY_SIZE;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l);
      if (!localPreRestrictionsChecker.check(arrayOfObject))
        str = "";
    }
    if (str != null)
      return str;
    return "";
  }

  private static String makeCleanedBodyText(com.viber.voip.util.links.d paramd, String paramString)
  {
    if (!da.a(paramString))
    {
      if ((!paramString.equals(paramd.b)) && (!paramString.equals(paramd.a)))
        break label34;
      paramString = "";
    }
    label34: com.viber.voip.util.links.d locald;
    do
    {
      return paramString;
      locald = f.d().a(paramString);
    }
    while ((locald == null) || ((!paramString.equals(locald.b)) && (!paramString.equals(locald.a))));
    return "";
  }

  private static void setFormattedDataGifSize(JSONArray paramJSONArray, int paramInt1, int paramInt2, long paramLong, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONArray.getJSONObject(3);
    localJSONObject.put("ThumbnailWidth", paramInt1);
    localJSONObject.put("ThumbnailHeight", paramInt2);
    localJSONObject.put("ThumbnailSizeInBytes", paramLong);
    localJSONObject.put(JSON_BUBBLE_DATA_KEY[3], paramString);
  }

  private static void setFormattedDataImageSize(JSONArray paramJSONArray, int paramInt1, int paramInt2, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONArray.getJSONObject(1);
    if (paramInt1 > 0)
    {
      localJSONObject.put("DisplayWidth", paramInt1);
      if (paramInt2 <= 0)
        break label55;
    }
    while (true)
    {
      localJSONObject.put("DisplayHeight", paramInt2);
      localJSONObject.put(JSON_BUBBLE_DATA_KEY[1], paramString);
      return;
      paramInt1 = c.a;
      break;
      label55: paramInt2 = c.a;
    }
  }

  private static void setFormattedDataVideoSize(JSONArray paramJSONArray, int paramInt1, int paramInt2, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONArray.getJSONObject(2);
    if (paramInt1 > 0)
    {
      localJSONObject.put("ThumbnailWidth", paramInt1);
      if (paramInt2 <= 0)
        break label55;
    }
    while (true)
    {
      localJSONObject.put("ThumbnailHeight", paramInt2);
      localJSONObject.put(JSON_BUBBLE_DATA_KEY[2], paramString);
      return;
      paramInt1 = c.a;
      break;
      label55: paramInt2 = Math.round(0.5625F * c.a);
    }
  }

  private static String shortenUrl(com.viber.voip.util.links.d paramd)
  {
    String str1 = paramd.b;
    try
    {
      String str3 = IDN.toUnicode(new URL(paramd.a).getHost());
      str2 = str3;
      if ((str2 != null) && (str2.toLowerCase(Locale.US).startsWith("www.")))
        str2 = str2.substring(4);
      return str2;
    }
    catch (Exception localException)
    {
      String str2;
      do
        str2 = paramd.b;
      while ((str2 == null) || (!str2.toLowerCase(Locale.US).startsWith("www.")));
      return str2.substring(4);
    }
    finally
    {
      if ((str1 != null) && (str1.toLowerCase(Locale.US).startsWith("www.")))
        str1.substring(4);
    }
  }

  public static String updateFormattedMediaDimensions(MsgInfo paramMsgInfo, String paramString, int paramInt1, int paramInt2)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray(paramString);
    String str1 = paramMsgInfo.getContentType();
    if (paramMsgInfo.getThumbnailContentType() != null)
      str1 = paramMsgInfo.getThumbnailContentType();
    boolean bool = bg.a.d(str1);
    String str2 = getThumbnail(paramMsgInfo, bool);
    String str3 = paramMsgInfo.getUrlType().toString();
    if (bool)
      setFormattedDataGifSize(localJSONArray, paramInt1, paramInt2, paramMsgInfo.getContentLength(), str2);
    while (true)
    {
      return localJSONArray.toString();
      if (!ServerMsgInfoMediaType.isPlayable(str3))
        setFormattedDataImageSize(localJSONArray, paramInt1, paramInt2, str2);
      else
        setFormattedDataVideoSize(localJSONArray, paramInt1, paramInt2, str2);
    }
  }

  private static JSONArray urlMessageTemplate()
    throws IOException, JSONException
  {
    if (URL_MESSAGE_TEMPLATE == null)
      URL_MESSAGE_TEMPLATE = bj.a(ViberApplication.getApplication().getAssets().open("url_message/formatted_url_message.json"));
    return new JSONArray(URL_MESSAGE_TEMPLATE);
  }

  private static String urlMessageViewActionTemplate()
    throws IOException, JSONException
  {
    if (URL_MESSAGE_VIEW_ACTION_TEMPLATE == null)
      URL_MESSAGE_VIEW_ACTION_TEMPLATE = bj.a(ViberApplication.getApplication().getAssets().open("url_message/view_action.json"));
    return URL_MESSAGE_VIEW_ACTION_TEMPLATE;
  }

  public static class JsonItemPosition
  {
    public static final int DESCRIPTION = 0;
    public static final int DOMAIN = 5;
    public static final int GIF_URL = 3;
    public static final int INFO = 6;
    public static final int THUMBNAIL = 1;
    public static final int TITLE = 4;
    public static final int VIDEO_THUMBNAIL = 2;
  }

  public static abstract interface PreRestrictionsChecker
  {
    public abstract boolean check(Object[] paramArrayOfObject);
  }

  public static class PreRestrictionsCheckers
  {
    public static final FormattedUrlMessage.PreRestrictionsChecker ALLOW_IMAGE_BY_SIZE = new FormattedUrlMessage.PreRestrictionsChecker()
    {
      public boolean check(Object[] paramAnonymousArrayOfObject)
      {
        int i = 1;
        boolean bool1 = cj.e(ViberApplication.getApplication());
        boolean bool2 = d.af.c.d();
        if ((bool1) && (bool2));
        while ((paramAnonymousArrayOfObject.length < i) || (!(paramAnonymousArrayOfObject[0] instanceof Long)))
          return false;
        long l = ((Long)paramAnonymousArrayOfObject[0]).longValue();
        if (!bool1)
        {
          if ((l > 0L) && (l <= 2097152L));
          int m;
          for (int k = i; ; m = 0)
            return k;
        }
        if ((l > 0L) && (l <= 512000L));
        while (true)
        {
          return i;
          int j = 0;
        }
      }
    };
  }

  public static class ServerMsgInfoMediaType
  {
    public static final String AUDIO = "audio";
    public static final String DEFAULT = "default";
    public static final String IMAGE = "image";
    public static final String VIDEO = "video";

    public static boolean isAudio(String paramString)
    {
      return "audio".equalsIgnoreCase(paramString);
    }

    public static boolean isDefault(String paramString)
    {
      return ("default".equalsIgnoreCase(paramString)) || (da.a(paramString));
    }

    public static boolean isImage(String paramString)
    {
      return "image".equalsIgnoreCase(paramString);
    }

    public static boolean isPlayable(String paramString)
    {
      return isVideo(paramString) | isAudio(paramString);
    }

    public static boolean isVideo(String paramString)
    {
      return "video".equalsIgnoreCase(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.FormattedUrlMessage
 * JD-Core Version:    0.6.2
 */