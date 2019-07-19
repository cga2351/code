package com.viber.voip.util.b;

import android.content.Context;
import android.text.TextUtils;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static final long a = TimeUnit.HOURS.toSeconds(48L);
  public static final long b = TimeUnit.HOURS.toSeconds(24L);
  private static final com.viber.common.a.e c = ViberEnv.getLogger();

  public static a a(Context paramContext)
  {
    int i = d.r.o.d();
    List localList = b();
    if (!a(i, localList))
      return new a(null, false);
    d.r.o.a(i + 1);
    if (!a(i + 1, localList));
    for (boolean bool = true; ; bool = false)
    {
      b localb = (b)localList.get(i);
      if (localb.b == null)
        break;
      MessageEntity localMessageEntity = com.viber.voip.messages.e.a(paramContext, localb.a, localb.b, R.string.user_engagement_free_sticker_pack_fm_text, R.string.user_engagement_free_sticker_pack_fm_button_caption);
      if (localMessageEntity == null)
        break;
      return new a(localMessageEntity, bool);
    }
    return new a(null, bool);
  }

  public static boolean a()
  {
    return a(d.r.o.d(), b());
  }

  private static boolean a(int paramInt, List<b> paramList)
  {
    return paramInt < paramList.size();
  }

  private static List<b> b()
  {
    while (true)
    {
      try
      {
        String str = d.p.r.d();
        if (!TextUtils.isEmpty(str))
        {
          localJSONArray = new JSONArray(str);
          ArrayList localArrayList;
          if (localJSONArray != null)
          {
            int i = localJSONArray.length();
            localArrayList = new ArrayList(i);
            int j = 0;
            if (j < i)
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(j);
              localArrayList.add(new b(localJSONObject.getInt("id"), localJSONObject.getString("hiPromo")));
              j++;
              continue;
            }
          }
          else
          {
            localArrayList = new ArrayList(0);
          }
          return localArrayList;
        }
      }
      catch (JSONException localJSONException)
      {
        return new ArrayList(0);
      }
      JSONArray localJSONArray = null;
    }
  }

  public static class a
  {
    private MessageEntity a;
    private boolean b;

    a(MessageEntity paramMessageEntity, boolean paramBoolean)
    {
      this.a = paramMessageEntity;
      this.b = paramBoolean;
    }

    public MessageEntity a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.b.c
 * JD-Core Version:    0.6.2
 */