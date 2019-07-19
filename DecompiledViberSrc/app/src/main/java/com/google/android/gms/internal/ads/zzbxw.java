package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbxw
  implements zzbza
{
  private final Clock zzbsb;
  private final zzbaj zzbtd;
  private final zzdh zzekq;
  private final zzdad zzffd;
  private final zzbzb zzfgy;
  private final zzcxl zzfif;
  private final zzcxu zzfjp;
  private final JSONObject zzfmo;
  private final zzcci zzfmp;
  private final zzbys zzfmq;
  private final zzbrs zzfmr;
  private final zzbrh zzfms;
  private final zzbmm zzfmt;
  private final zzbzp zzfmu;
  private final zzbuz zzfmv;
  private boolean zzfmw = false;
  private boolean zzfmx;
  private boolean zzfmy = false;
  private boolean zzfmz = false;
  private Point zzfna = new Point();
  private Point zzfnb = new Point();
  private long zzfnc = 0L;
  private long zzfnd = 0L;
  private zzaae zzfne;
  private final Context zzlj;

  public zzbxw(Context paramContext, zzbzb paramzzbzb, JSONObject paramJSONObject, zzcci paramzzcci, zzbys paramzzbys, zzdh paramzzdh, zzbrs paramzzbrs, zzbrh paramzzbrh, zzcxl paramzzcxl, zzbaj paramzzbaj, zzcxu paramzzcxu, zzbmm paramzzbmm, zzbzp paramzzbzp, Clock paramClock, zzbuz paramzzbuz, zzdad paramzzdad)
  {
    this.zzlj = paramContext;
    this.zzfgy = paramzzbzb;
    this.zzfmo = paramJSONObject;
    this.zzfmp = paramzzcci;
    this.zzfmq = paramzzbys;
    this.zzekq = paramzzdh;
    this.zzfmr = paramzzbrs;
    this.zzfms = paramzzbrh;
    this.zzfif = paramzzcxl;
    this.zzbtd = paramzzbaj;
    this.zzfjp = paramzzcxu;
    this.zzfmt = paramzzbmm;
    this.zzfmu = paramzzbzp;
    this.zzbsb = paramClock;
    this.zzfmv = paramzzbuz;
    this.zzffd = paramzzdad;
  }

  private final JSONObject zza(Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, View paramView)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((paramMap1 == null) || (paramView == null))
      return localJSONObject1;
    int[] arrayOfInt1 = zzw(paramView);
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)((WeakReference)localEntry.getValue()).get();
      if (localView != null)
      {
        int[] arrayOfInt2 = zzw(localView);
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        while (true)
        {
          try
          {
            localJSONObject3.put("width", zzdm(localView.getMeasuredWidth()));
            localJSONObject3.put("height", zzdm(localView.getMeasuredHeight()));
            localJSONObject3.put("x", zzdm(arrayOfInt2[0] - arrayOfInt1[0]));
            localJSONObject3.put("y", zzdm(arrayOfInt2[1] - arrayOfInt1[1]));
            localJSONObject3.put("relative_to", "ad_view");
            localJSONObject2.put("frame", localJSONObject3);
            Rect localRect = new Rect();
            if (!localView.getLocalVisibleRect(localRect))
              break label369;
            localJSONObject4 = zzb(localRect);
            localJSONObject2.put("visible_bounds", localJSONObject4);
            if ((localView instanceof TextView))
            {
              TextView localTextView = (TextView)localView;
              localJSONObject2.put("text_color", localTextView.getCurrentTextColor());
              localJSONObject2.put("font_size", localTextView.getTextSize());
              localJSONObject2.put("text", localTextView.getText());
            }
            if ((paramMap2 == null) || (!paramMap2.containsKey(localEntry.getKey())) || (!localView.isClickable()))
              break label451;
            bool = true;
            localJSONObject2.put("is_clickable", bool);
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            zzaxa.zzep("Unable to get asset views information");
          }
          break;
          label369: JSONObject localJSONObject4 = new JSONObject();
          localJSONObject4.put("width", 0);
          localJSONObject4.put("height", 0);
          localJSONObject4.put("x", zzdm(arrayOfInt2[0] - arrayOfInt1[0]));
          localJSONObject4.put("y", zzdm(arrayOfInt2[1] - arrayOfInt1[1]));
          localJSONObject4.put("relative_to", "ad_view");
          continue;
          label451: boolean bool = false;
        }
      }
    }
    return localJSONObject1;
  }

  private final void zza(View paramView, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, String paramString, JSONObject paramJSONObject5, JSONObject paramJSONObject6, boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.checkMainThread("performClick must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("ad", this.zzfmo);
      localJSONObject1.put("asset_view_signal", paramJSONObject2);
      localJSONObject1.put("ad_view_signal", paramJSONObject1);
      localJSONObject1.put("click_signal", paramJSONObject5);
      localJSONObject1.put("scroll_view_signal", paramJSONObject3);
      localJSONObject1.put("lock_screen_signal", paramJSONObject4);
      boolean bool1;
      JSONObject localJSONObject2;
      boolean bool2;
      label194: boolean bool3;
      if (this.zzfgy.zzfo(this.zzfmq.getCustomTemplateId()) != null)
      {
        bool1 = true;
        localJSONObject1.put("has_custom_click_handler", bool1);
        localJSONObject1.put("provided_signals", paramJSONObject6);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("asset_id", paramString);
        localJSONObject2.put("template", this.zzfmq.zzahv());
        localJSONObject2.put("view_aware_api_used", paramBoolean1);
        if ((this.zzfjp.zzdgu == null) || (!this.zzfjp.zzdgu.zzbqh))
          break label479;
        bool2 = true;
        localJSONObject2.put("custom_mute_requested", bool2);
        if ((this.zzfmq.getMuteThisAdReasons().isEmpty()) || (this.zzfmq.zzahx() == null))
          break label485;
        bool3 = true;
        label233: localJSONObject2.put("custom_mute_enabled", bool3);
        if ((this.zzfmu.zzaiz() != null) && (this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false)))
          localJSONObject2.put("custom_one_point_five_click_eligible", true);
        localJSONObject2.put("timestamp", this.zzbsb.currentTimeMillis());
        if ((this.zzfmz) && (zzahj()))
          localJSONObject2.put("custom_click_gesture_eligible", true);
        if (paramBoolean2)
          localJSONObject2.put("is_custom_click_gesture", true);
        if (this.zzfgy.zzfo(this.zzfmq.getCustomTemplateId()) == null)
          break label491;
      }
      label479: label485: label491: for (boolean bool4 = true; ; bool4 = false)
      {
        localJSONObject2.put("has_custom_click_handler", bool4);
        localJSONObject2.put("click_signals", zzv(paramView));
        localJSONObject1.put("click", localJSONObject2);
        JSONObject localJSONObject3 = new JSONObject();
        long l = this.zzbsb.currentTimeMillis();
        localJSONObject3.put("time_from_last_touch_down", l - this.zzfnc);
        localJSONObject3.put("time_from_last_touch", l - this.zzfnd);
        localJSONObject1.put("touch_signal", localJSONObject3);
        zzbap.zza(this.zzfmp.zzc("google.afma.nativeAds.handleClick", localJSONObject1), "Error during performing handleClick");
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label194;
        bool3 = false;
        break label233;
      }
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Unable to create click JSON.", localJSONException);
    }
  }

  private final boolean zza(JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, JSONObject paramJSONObject5)
  {
    Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", this.zzfmo);
      localJSONObject.put("asset_view_signal", paramJSONObject2);
      localJSONObject.put("ad_view_signal", paramJSONObject1);
      localJSONObject.put("scroll_view_signal", paramJSONObject3);
      localJSONObject.put("lock_screen_signal", paramJSONObject4);
      localJSONObject.put("provided_signals", paramJSONObject5);
      this.zzfmp.zza("/logScionEvent", new zzbxy(this, null));
      this.zzfmp.zza("/nativeImpression", new zzbxz(this, null));
      zzbap.zza(this.zzfmp.zzc("google.afma.nativeAds.handleImpression", localJSONObject), "Error during performing handleImpression");
      if ((!this.zzfmw) && (this.zzfif.zzgkj != null))
        this.zzfmw |= zzk.zzlq().zzb(this.zzlj, this.zzbtd.zzbsy, this.zzfif.zzgkj.toString(), this.zzfjp.zzglb);
      return true;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Unable to create impression JSON.", localJSONException);
    }
    return false;
  }

  private final boolean zzahj()
  {
    return this.zzfmo.optBoolean("allow_custom_click_gesture", false);
  }

  private final JSONObject zzahn()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", zzdm(this.zzfna.x));
      localJSONObject.put("y", zzdm(this.zzfna.y));
      localJSONObject.put("start_x", zzdm(this.zzfnb.x));
      localJSONObject.put("start_y", zzdm(this.zzfnb.y));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occurred while putting signals into JSON object.", localJSONException);
    }
    return null;
  }

  private final String zzb(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    if ((paramMap != null) && (paramView != null))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramView.equals((View)((WeakReference)localEntry.getValue()).get()))
          return (String)localEntry.getKey();
      }
    }
    switch (this.zzfmq.zzahv())
    {
    case 4:
    case 5:
    default:
      return null;
    case 2:
      return "2099";
    case 1:
      return "1099";
    case 3:
      return null;
    case 6:
    }
    return "3099";
  }

  private final JSONObject zzb(Rect paramRect)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("width", zzdm(paramRect.right - paramRect.left));
    localJSONObject.put("height", zzdm(paramRect.bottom - paramRect.top));
    localJSONObject.put("x", zzdm(paramRect.left));
    localJSONObject.put("y", zzdm(paramRect.top));
    localJSONObject.put("relative_to", "self");
    return localJSONObject;
  }

  private final int zzdm(int paramInt)
  {
    return zzyr.zzpa().zzb(this.zzlj, paramInt);
  }

  private final boolean zzfh(String paramString)
  {
    JSONObject localJSONObject = this.zzfmo.optJSONObject("allow_pub_event_reporting");
    boolean bool1 = false;
    if (localJSONObject != null)
    {
      boolean bool2 = localJSONObject.optBoolean(paramString, false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  // ERROR //
  private final JSONObject zzfj(String paramString)
  {
    // Byte code:
    //   0: new 113	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 114	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 499
    //   12: aload_0
    //   13: invokespecial 501	com/google/android/gms/internal/ads/zzbxw:zzahn	()Lorg/json/JSONObject;
    //   16: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   19: pop
    //   20: aload_2
    //   21: ldc_w 282
    //   24: aload_1
    //   25: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   28: pop
    //   29: aload_2
    //   30: areturn
    //   31: astore 6
    //   33: aconst_null
    //   34: astore_2
    //   35: aload 6
    //   37: astore_3
    //   38: ldc_w 503
    //   41: aload_3
    //   42: invokestatic 383	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: aload_2
    //   46: areturn
    //   47: astore_3
    //   48: goto -10 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	31	java/lang/Exception
    //   8	29	47	java/lang/Exception
  }

  // ERROR //
  private final JSONObject zzs(View paramView)
  {
    // Byte code:
    //   0: new 113	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 114	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: aload_1
    //   15: invokestatic 118	com/google/android/gms/internal/ads/zzbxw:zzw	(Landroid/view/View;)[I
    //   18: astore 17
    //   20: new 113	org/json/JSONObject
    //   23: dup
    //   24: invokespecial 114	org/json/JSONObject:<init>	()V
    //   27: astore 18
    //   29: aload 18
    //   31: ldc 154
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 158	android/view/View:getMeasuredWidth	()I
    //   38: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   41: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 18
    //   47: ldc 168
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 171	android/view/View:getMeasuredHeight	()I
    //   54: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   57: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 18
    //   63: ldc 173
    //   65: aload_0
    //   66: aload 17
    //   68: iconst_0
    //   69: iaload
    //   70: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   73: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 18
    //   79: ldc 175
    //   81: aload_0
    //   82: aload 17
    //   84: iconst_1
    //   85: iaload
    //   86: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   89: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   92: pop
    //   93: aload 18
    //   95: ldc 177
    //   97: ldc_w 515
    //   100: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_2
    //   105: ldc 184
    //   107: aload 18
    //   109: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 186	android/graphics/Rect
    //   116: dup
    //   117: invokespecial 187	android/graphics/Rect:<init>	()V
    //   120: astore 25
    //   122: aload_1
    //   123: aload 25
    //   125: invokevirtual 518	android/view/View:getGlobalVisibleRect	(Landroid/graphics/Rect;)Z
    //   128: ifeq +135 -> 263
    //   131: aload_0
    //   132: aload 25
    //   134: invokespecial 195	com/google/android/gms/internal/ads/zzbxw:zzb	(Landroid/graphics/Rect;)Lorg/json/JSONObject;
    //   137: astore 26
    //   139: aload_2
    //   140: ldc 197
    //   142: aload 26
    //   144: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: getstatic 524	com/google/android/gms/internal/ads/zzact:zzcww	Lcom/google/android/gms/internal/ads/zzaci;
    //   151: astore 4
    //   153: invokestatic 528	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   156: aload 4
    //   158: invokevirtual 534	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   161: checkcast 536	java/lang/Boolean
    //   164: invokevirtual 539	java/lang/Boolean:booleanValue	()Z
    //   167: ifeq +94 -> 261
    //   170: ldc_w 541
    //   173: astore 5
    //   175: aload_1
    //   176: invokevirtual 545	android/view/View:getParent	()Landroid/view/ViewParent;
    //   179: astore 6
    //   181: aload 6
    //   183: ifnull +36 -> 219
    //   186: aload 6
    //   188: invokevirtual 549	java/lang/Object:getClass	()Ljava/lang/Class;
    //   191: ldc_w 551
    //   194: iconst_0
    //   195: anewarray 553	java/lang/Class
    //   198: invokevirtual 557	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   201: aload 6
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokevirtual 563	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 236	java/lang/String
    //   213: astore 16
    //   215: aload 16
    //   217: astore 5
    //   219: iconst_m1
    //   220: istore 7
    //   222: aload 5
    //   224: invokevirtual 566	java/lang/String:hashCode	()I
    //   227: lookupswitch	default:+234->461, -2066603854:+158->385, 2019754500:+175->402
    //   253: ldc_w 568
    //   256: iconst_0
    //   257: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   260: pop
    //   261: aload_2
    //   262: areturn
    //   263: new 113	org/json/JSONObject
    //   266: dup
    //   267: invokespecial 114	org/json/JSONObject:<init>	()V
    //   270: astore 26
    //   272: aload 26
    //   274: ldc 154
    //   276: iconst_0
    //   277: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload 26
    //   283: ldc 168
    //   285: iconst_0
    //   286: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 26
    //   292: ldc 173
    //   294: aload_0
    //   295: aload 17
    //   297: iconst_0
    //   298: iaload
    //   299: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   302: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 26
    //   308: ldc 175
    //   310: aload_0
    //   311: aload 17
    //   313: iconst_1
    //   314: iaload
    //   315: invokespecial 162	com/google/android/gms/internal/ads/zzbxw:zzdm	(I)I
    //   318: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   321: pop
    //   322: aload 26
    //   324: ldc 177
    //   326: ldc_w 515
    //   329: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   332: pop
    //   333: goto -194 -> 139
    //   336: astore_3
    //   337: ldc_w 570
    //   340: invokestatic 244	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   343: goto -195 -> 148
    //   346: astore 15
    //   348: ldc_w 572
    //   351: aload 15
    //   353: invokestatic 383	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: goto -137 -> 219
    //   359: astore 14
    //   361: ldc_w 572
    //   364: aload 14
    //   366: invokestatic 383	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   369: goto -150 -> 219
    //   372: astore 13
    //   374: ldc_w 572
    //   377: aload 13
    //   379: invokestatic 383	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: goto -163 -> 219
    //   385: aload 5
    //   387: ldc_w 574
    //   390: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   393: ifeq +68 -> 461
    //   396: iconst_0
    //   397: istore 7
    //   399: goto +62 -> 461
    //   402: aload 5
    //   404: ldc_w 577
    //   407: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   410: ifeq +51 -> 461
    //   413: iconst_1
    //   414: istore 7
    //   416: goto +45 -> 461
    //   419: aload_2
    //   420: ldc_w 568
    //   423: iconst_1
    //   424: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   427: pop
    //   428: goto -167 -> 261
    //   431: astore 8
    //   433: ldc_w 579
    //   436: aload 8
    //   438: invokestatic 383	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: goto -180 -> 261
    //   444: aload_2
    //   445: ldc_w 568
    //   448: iconst_2
    //   449: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   452: pop
    //   453: goto -192 -> 261
    //   456: astore 12
    //   458: goto -239 -> 219
    //   461: iload 7
    //   463: tableswitch	default:+-211 -> 252, 0:+-44->419, 1:+-19->444
    //
    // Exception table:
    //   from	to	target	type
    //   14	139	336	java/lang/Exception
    //   139	148	336	java/lang/Exception
    //   263	333	336	java/lang/Exception
    //   186	215	346	java/lang/SecurityException
    //   186	215	359	java/lang/IllegalAccessException
    //   186	215	372	java/lang/reflect/InvocationTargetException
    //   222	252	431	org/json/JSONException
    //   252	261	431	org/json/JSONException
    //   385	396	431	org/json/JSONException
    //   402	413	431	org/json/JSONException
    //   419	428	431	org/json/JSONException
    //   444	453	431	org/json/JSONException
    //   186	215	456	java/lang/NoSuchMethodException
  }

  private static JSONObject zzt(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramView == null)
      return localJSONObject;
    while (true)
    {
      try
      {
        zzk.zzlg();
        if (zzaxj.zzp(paramView) != -1)
        {
          bool = true;
          localJSONObject.put("contained_in_scroll_view", bool);
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        return localJSONObject;
      }
      boolean bool = false;
    }
  }

  private final JSONObject zzu(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramView == null)
      return localJSONObject;
    try
    {
      zzk.zzlg();
      localJSONObject.put("can_show_on_lock_screen", zzaxj.zzo(paramView));
      zzk.zzlg();
      localJSONObject.put("is_keyguard_locked", zzaxj.zzat(this.zzlj));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzep("Unable to get lock screen information");
    }
    return localJSONObject;
  }

  private final String zzv(View paramView)
  {
    try
    {
      JSONObject localJSONObject = this.zzfmo.optJSONObject("tracking_urls_and_actions");
      if (localJSONObject == null)
        localJSONObject = new JSONObject();
      String str1 = localJSONObject.optString("click_string");
      String str2 = this.zzekq.zzcg().zza(this.zzlj, str1, paramView);
      return str2;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Exception obtaining click signals", localException);
    }
    return null;
  }

  private static int[] zzw(View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramView != null)
      paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt;
  }

  public final void cancelUnconfirmedClick()
  {
    if (!this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false))
      return;
    this.zzfmu.cancelUnconfirmedClick();
  }

  public final void destroy()
  {
    this.zzfmp.destroy();
  }

  public final void setClickConfirmingView(View paramView)
  {
    if (!this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false))
      zzaxa.zzep("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
    zzbzp localzzbzp;
    do
    {
      return;
      localzzbzp = this.zzfmu;
    }
    while (paramView == null);
    paramView.setOnClickListener(localzzbzp);
    paramView.setClickable(true);
    localzzbzp.zzfqe = new WeakReference(paramView);
  }

  public final void zza(View paramView1, MotionEvent paramMotionEvent, View paramView2)
  {
    int[] arrayOfInt = zzw(paramView2);
    this.zzfna = new Point((int)paramMotionEvent.getRawX() - arrayOfInt[0], (int)paramMotionEvent.getRawY() - arrayOfInt[1]);
    long l = this.zzbsb.currentTimeMillis();
    this.zzfnd = l;
    if (paramMotionEvent.getAction() == 0)
    {
      this.zzfnc = l;
      this.zzfnb = this.zzfna;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.setLocation(this.zzfna.x, this.zzfna.y);
    this.zzekq.zza(localMotionEvent);
    localMotionEvent.recycle();
  }

  public final void zza(View paramView1, View paramView2, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = zza(paramMap1, paramMap2, paramView2);
    JSONObject localJSONObject2 = zzs(paramView2);
    JSONObject localJSONObject3 = zzt(paramView2);
    JSONObject localJSONObject4 = zzu(paramView2);
    String str = zzb(paramView1, paramMap1);
    zza(paramView1, localJSONObject2, localJSONObject1, localJSONObject3, localJSONObject4, str, zzfj(str), null, paramBoolean, false);
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    this.zzfna = new Point();
    this.zzfnb = new Point();
    this.zzfmv.zzr(paramView);
    this.zzfmx = false;
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2)
  {
    JSONObject localJSONObject = zza(paramMap1, paramMap2, paramView);
    zza(zzs(paramView), localJSONObject, zzt(paramView), zzu(paramView), null);
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    this.zzfna = new Point();
    this.zzfnb = new Point();
    if (!this.zzfmx)
    {
      this.zzfmv.zzq(paramView);
      this.zzfmx = true;
    }
    paramView.setOnTouchListener(paramOnTouchListener);
    paramView.setClickable(true);
    paramView.setOnClickListener(paramOnClickListener);
    this.zzfmt.zzq(this);
    if (paramMap1 != null)
    {
      Iterator localIterator2 = paramMap1.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        View localView2 = (View)((WeakReference)((Map.Entry)localIterator2.next()).getValue()).get();
        if (localView2 != null)
        {
          localView2.setOnTouchListener(paramOnTouchListener);
          localView2.setClickable(true);
          localView2.setOnClickListener(paramOnClickListener);
        }
      }
    }
    if (paramMap2 != null)
    {
      Iterator localIterator1 = paramMap2.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        View localView1 = (View)((WeakReference)((Map.Entry)localIterator1.next()).getValue()).get();
        if (localView1 != null)
        {
          localView1.setOnTouchListener(paramOnTouchListener);
          localView1.setClickable(false);
        }
      }
    }
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    if (!this.zzfmz)
    {
      zzaxa.zzdp("Custom click reporting failed. enableCustomClickGesture is not set.");
      return;
    }
    if (!zzahj())
    {
      zzaxa.zzdp("Custom click reporting failed. Ad unit id not whitelisted.");
      return;
    }
    JSONObject localJSONObject1 = zza(paramMap1, paramMap2, paramView);
    JSONObject localJSONObject2 = zzs(paramView);
    JSONObject localJSONObject3 = zzt(paramView);
    JSONObject localJSONObject4 = zzu(paramView);
    String str = zzb(null, paramMap1);
    zza(paramView, localJSONObject2, localJSONObject1, localJSONObject3, localJSONObject4, str, zzfj(str), null, paramBoolean, true);
  }

  public final void zza(zzaae paramzzaae)
  {
    this.zzfne = paramzzaae;
  }

  public final void zza(zzaai paramzzaai)
  {
    try
    {
      if (this.zzfmy)
        return;
      if ((paramzzaai == null) && (this.zzfmq.zzahx() != null))
      {
        this.zzfmy = true;
        this.zzffd.zzed(this.zzfmq.zzahx().zzpt());
        zzahl();
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zze("#007 Could not call remote method.", localRemoteException);
      return;
    }
    this.zzfmy = true;
    this.zzffd.zzed(paramzzaai.zzpt());
    zzahl();
  }

  public final void zza(zzagc paramzzagc)
  {
    if (!this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false))
    {
      zzaxa.zzep("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
      return;
    }
    this.zzfmu.zza(paramzzagc);
  }

  public final void zzahk()
  {
    zza(null, null, null, null, null);
  }

  public final void zzahl()
  {
    try
    {
      if (this.zzfne != null)
        this.zzfne.onAdMuted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zzahm()
  {
    Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", this.zzfmo);
      zzbap.zza(this.zzfmp.zzc("google.afma.nativeAds.handleDownloadedImpression", localJSONObject), "Error during performing handleDownloadedImpression");
      return;
    }
    catch (JSONException localJSONException)
    {
      zzbae.zzc("", localJSONException);
    }
  }

  public final void zzf(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      zzaxa.zzdp("Click data is null. No click is reported.");
      return;
    }
    if (!zzfh("click_reporting"))
    {
      zzaxa.zzen("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
      return;
    }
    Bundle localBundle = paramBundle.getBundle("click_signal");
    if (localBundle != null);
    for (String str = localBundle.getString("asset_id"); ; str = null)
    {
      zza(null, null, null, null, null, str, null, zzk.zzlg().zza(paramBundle, null), false, false);
      return;
    }
  }

  public final void zzfi(String paramString)
  {
    zza(null, null, null, null, null, paramString, null, null, false, false);
  }

  public final void zzg(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      zzaxa.zzdp("Touch event data is null. No touch event is reported.");
      return;
    }
    if (!zzfh("touch_reporting"))
    {
      zzaxa.zzen("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
      return;
    }
    int i = (int)paramBundle.getFloat("x");
    int j = (int)paramBundle.getFloat("y");
    int k = paramBundle.getInt("duration_ms");
    this.zzekq.zzcg().zza(i, j, k);
  }

  public final boolean zzh(Bundle paramBundle)
  {
    if (!zzfh("impression_reporting"))
    {
      zzaxa.zzen("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
      return false;
    }
    return zza(null, null, null, null, zzk.zzlg().zza(paramBundle, null));
  }

  public final void zzro()
  {
    this.zzfmz = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbxw
 * JD-Core Version:    0.6.2
 */