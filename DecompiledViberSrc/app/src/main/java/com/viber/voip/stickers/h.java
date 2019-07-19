package com.viber.voip.stickers;

import android.content.Context;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.schedule.d.c;
import com.viber.voip.settings.d.ax;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  implements d.c
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;

  h(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  private void a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null)
      d.ax.q.a(TextUtils.join(",", paramArrayList));
  }

  private ArrayList<Integer> b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get("clickers");
      JSONArray localJSONArray = (JSONArray)new r()
      {
        public JSONArray a(JSONObject paramAnonymousJSONObject, String paramAnonymousString)
          throws JSONException
        {
          return paramAnonymousJSONObject.getJSONArray(paramAnonymousString);
        }
      }
      .a(this.b, localJSONObject1);
      if (localJSONArray != null)
        for (int i = 0; i < localJSONArray.length(); i++)
        {
          JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
          if (localJSONObject2.has("id"))
            localArrayList.add(Integer.valueOf(localJSONObject2.getInt("id")));
        }
    }
    catch (ClassCastException localClassCastException)
    {
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
    }
    return localArrayList;
  }

  public void a(JSONObject paramJSONObject)
  {
    a(b(paramJSONObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.h
 * JD-Core Version:    0.6.2
 */