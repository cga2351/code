package com.viber.voip.messages;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.messages.controller.c.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.bj;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private static String b;
  private static String c;

  public static MessageEntity a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    String str = b(paramContext, paramInt1, paramString, paramInt2, paramInt3);
    if (str != null)
    {
      MessageEntity localMessageEntity = new a("Viber", 0L, System.currentTimeMillis(), 3145729, 0, null, 1, 0).a(7, str, 0, null, 0);
      localMessageEntity.addExtraFlag(26);
      return localMessageEntity;
    }
    return null;
  }

  private static String a(AssetManager paramAssetManager)
    throws IOException
  {
    try
    {
      if (b == null)
        b = bj.a(paramAssetManager.open("engagement/free_sticker_pack_template.json"));
      String str = b;
      return str;
    }
    finally
    {
    }
  }

  private static String b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(a(paramContext.getAssets()));
      JSONObject localJSONObject1 = localJSONArray.getJSONObject(0);
      localJSONObject1.put("ImageUrl", ap.c().H + paramString);
      int i = paramContext.getResources().getDimensionPixelSize(R.dimen.user_engagement_fm_image_size);
      localJSONObject1.put("DisplayWidth", i);
      localJSONObject1.put("DisplayHeight", i);
      String str1 = paramContext.getString(paramInt2);
      localJSONArray.getJSONObject(1).put("Text", str1);
      Locale localLocale = Locale.US;
      String str2 = b(paramContext.getAssets());
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      JSONObject localJSONObject2 = new JSONObject(String.format(localLocale, str2, arrayOfObject));
      JSONObject localJSONObject3 = localJSONArray.getJSONObject(2);
      localJSONObject3.put("Caption", paramContext.getString(paramInt3));
      localJSONObject3.put("Action", localJSONObject2);
      JSONObject localJSONObject4 = localJSONArray.getJSONObject(3);
      localJSONObject4.put("PreviewText", str1);
      localJSONObject4.put("PushText", str1);
      String str3 = localJSONArray.toString();
      return str3;
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
      label226: break label226;
    }
  }

  private static String b(AssetManager paramAssetManager)
    throws IOException
  {
    try
    {
      if (c == null)
        c = bj.a(paramAssetManager.open("engagement/free_sticker_pack_open_action.json"));
      String str = c;
      return str;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.e
 * JD-Core Version:    0.6.2
 */