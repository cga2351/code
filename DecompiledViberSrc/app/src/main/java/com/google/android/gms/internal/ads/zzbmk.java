package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbmk
  implements zzaln<zzbmo>
{
  private final zztw zzffo;
  private final Context zzlj;
  private final PowerManager zzyt;

  public zzbmk(Context paramContext, zztw paramzztw)
  {
    this.zzlj = paramContext;
    this.zzffo = paramzztw;
    this.zzyt = ((PowerManager)paramContext.getSystemService("power"));
  }

  public final JSONObject zza(zzbmo paramzzbmo)
    throws JSONException
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    if (paramzzbmo.zzfgd == null);
    JSONObject localJSONObject2;
    for (Object localObject = new JSONObject(); ; localObject = localJSONObject2)
    {
      localJSONArray1.put(localObject);
      localJSONObject1.put("units", localJSONArray1);
      return localJSONObject1;
      zzub localzzub = paramzzbmo.zzfgd;
      if (this.zzffo.zzmh() == null)
        throw new JSONException("Active view Info cannot be null.");
      boolean bool1 = localzzub.zzbtq;
      localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = localJSONObject2.put("afmaVersion", this.zzffo.zzmg()).put("activeViewJSON", this.zzffo.zzmh()).put("timestamp", paramzzbmo.timestamp).put("adFormat", this.zzffo.zzmf()).put("hashCode", this.zzffo.zzmi());
      JSONObject localJSONObject4 = localJSONObject3.put("isMraid", false).put("isStopped", false).put("isPaused", paramzzbmo.zzfga).put("isNative", this.zzffo.zzmj());
      if (Build.VERSION.SDK_INT >= 20);
      JSONArray localJSONArray2;
      for (boolean bool2 = this.zzyt.isInteractive(); ; bool2 = this.zzyt.isScreenOn())
      {
        localJSONObject4.put("isScreenOn", bool2).put("appMuted", zzk.zzll().zzpr()).put("appVolume", zzk.zzll().zzpq()).put("deviceVolume", zzayb.zzba(this.zzlj.getApplicationContext()));
        Rect localRect1 = new Rect();
        Display localDisplay = ((WindowManager)this.zzlj.getSystemService("window")).getDefaultDisplay();
        localRect1.right = localDisplay.getWidth();
        localRect1.bottom = localDisplay.getHeight();
        DisplayMetrics localDisplayMetrics = this.zzlj.getResources().getDisplayMetrics();
        localJSONObject2.put("windowVisibility", localzzub.zzza).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", localzzub.zzbtr.top).put("bottom", localzzub.zzbtr.bottom).put("left", localzzub.zzbtr.left).put("right", localzzub.zzbtr.right)).put("adBox", new JSONObject().put("top", localzzub.zzbts.top).put("bottom", localzzub.zzbts.bottom).put("left", localzzub.zzbts.left).put("right", localzzub.zzbts.right)).put("globalVisibleBox", new JSONObject().put("top", localzzub.zzbtt.top).put("bottom", localzzub.zzbtt.bottom).put("left", localzzub.zzbtt.left).put("right", localzzub.zzbtt.right)).put("globalVisibleBoxVisible", localzzub.zzbtu).put("localVisibleBox", new JSONObject().put("top", localzzub.zzbtv.top).put("bottom", localzzub.zzbtv.bottom).put("left", localzzub.zzbtv.left).put("right", localzzub.zzbtv.right)).put("localVisibleBoxVisible", localzzub.zzbtw).put("hitBox", new JSONObject().put("top", localzzub.zzbtx.top).put("bottom", localzzub.zzbtx.bottom).put("left", localzzub.zzbtx.left).put("right", localzzub.zzbtx.right)).put("screenDensity", localDisplayMetrics.density);
        localJSONObject2.put("isVisible", paramzzbmo.zzbtl);
        zzaci localzzaci = zzact.zzcqm;
        if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
          break label857;
        localJSONArray2 = new JSONArray();
        if (localzzub.zzbtz == null)
          break;
        Iterator localIterator = localzzub.zzbtz.iterator();
        while (localIterator.hasNext())
        {
          Rect localRect2 = (Rect)localIterator.next();
          localJSONArray2.put(new JSONObject().put("top", localRect2.top).put("bottom", localRect2.bottom).put("left", localRect2.left).put("right", localRect2.right));
        }
      }
      localJSONObject2.put("scrollableContainerBoxes", localJSONArray2);
      label857: if (!TextUtils.isEmpty(paramzzbmo.zzfgc))
        localJSONObject2.put("doneReasonCode", "u");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmk
 * JD-Core Version:    0.6.2
 */