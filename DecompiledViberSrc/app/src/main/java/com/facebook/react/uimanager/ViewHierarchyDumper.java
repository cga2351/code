package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchyDumper
{
  public static JSONObject toJSON(View paramView)
    throws JSONException
  {
    UiThreadUtil.assertOnUiThread();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", paramView.getClass().getName());
    localJSONObject.put("i", System.identityHashCode(paramView));
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof String)))
      localJSONObject.put("t", localObject);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (localViewGroup.getChildCount() > 0)
      {
        JSONArray localJSONArray = new JSONArray();
        for (int i = 0; i < localViewGroup.getChildCount(); i++)
          localJSONArray.put(i, toJSON(localViewGroup.getChildAt(i)));
        localJSONObject.put("c", localJSONArray);
      }
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewHierarchyDumper
 * JD-Core Version:    0.6.2
 */