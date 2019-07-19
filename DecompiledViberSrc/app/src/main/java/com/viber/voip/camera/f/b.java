package com.viber.voip.camera.f;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.viber.voip.camera.R.array;
import com.viber.voip.camera.R.string;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.activity.ViberCcamActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b extends LinearLayout
{
  private static final String a = com.viber.voip.camera.e.a.a(b.class);
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private Map<String, View> g = new Hashtable();

  public b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 28	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: iconst_m1
    //   7: putfield 30	com/viber/voip/camera/f/b:b	I
    //   10: aload_0
    //   11: iconst_m1
    //   12: putfield 32	com/viber/voip/camera/f/b:c	I
    //   15: aload_0
    //   16: iconst_m1
    //   17: putfield 34	com/viber/voip/camera/f/b:d	I
    //   20: aload_0
    //   21: iconst_m1
    //   22: putfield 36	com/viber/voip/camera/f/b:e	I
    //   25: aload_0
    //   26: iconst_m1
    //   27: putfield 38	com/viber/voip/camera/f/b:f	I
    //   30: aload_0
    //   31: new 40	java/util/Hashtable
    //   34: dup
    //   35: invokespecial 42	java/util/Hashtable:<init>	()V
    //   38: putfield 44	com/viber/voip/camera/f/b:g	Ljava/util/Map;
    //   41: aload_0
    //   42: iconst_1
    //   43: invokevirtual 48	com/viber/voip/camera/f/b:setOrientation	(I)V
    //   46: aload_0
    //   47: invokevirtual 52	com/viber/voip/camera/f/b:getContext	()Landroid/content/Context;
    //   50: checkcast 54	com/viber/voip/camera/activity/ViberCcamActivity
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 58	com/viber/voip/camera/activity/ViberCcamActivity:s	()Lcom/viber/voip/camera/c/b;
    //   58: astore_3
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 64	com/viber/voip/camera/c/b:S	()Ljava/util/List;
    //   64: getstatic 69	com/viber/voip/camera/R$array:flash_icons	I
    //   67: getstatic 72	com/viber/voip/camera/R$array:flash_values	I
    //   70: aload_0
    //   71: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   74: getstatic 81	com/viber/voip/camera/R$string:flash_mode	I
    //   77: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   80: aload_3
    //   81: invokevirtual 91	com/viber/voip/camera/c/b:j	()Ljava/lang/String;
    //   84: ldc 93
    //   86: new 95	com/viber/voip/camera/f/b$1
    //   89: dup
    //   90: aload_0
    //   91: aload_3
    //   92: aload_2
    //   93: invokespecial 98	com/viber/voip/camera/f/b$1:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/c/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   96: invokespecial 101	com/viber/voip/camera/f/b:a	(Ljava/util/List;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/camera/f/b$b;)V
    //   99: aload_3
    //   100: invokevirtual 105	com/viber/voip/camera/c/b:Y	()Z
    //   103: ifeq +11 -> 114
    //   106: aload_3
    //   107: invokevirtual 108	com/viber/voip/camera/c/b:ab	()Z
    //   110: ifeq +4 -> 114
    //   113: return
    //   114: aload_0
    //   115: aload_3
    //   116: invokevirtual 111	com/viber/voip/camera/c/b:T	()Ljava/util/List;
    //   119: getstatic 114	com/viber/voip/camera/R$array:focus_mode_icons	I
    //   122: getstatic 117	com/viber/voip/camera/R$array:focus_mode_values	I
    //   125: aload_0
    //   126: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   129: getstatic 120	com/viber/voip/camera/R$string:focus_mode	I
    //   132: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 123	com/viber/voip/camera/c/b:k	()Ljava/lang/String;
    //   139: ldc 125
    //   141: new 127	com/viber/voip/camera/f/b$7
    //   144: dup
    //   145: aload_0
    //   146: aload_3
    //   147: aload_2
    //   148: invokespecial 128	com/viber/voip/camera/f/b$7:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/c/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   151: invokespecial 101	com/viber/voip/camera/f/b:a	(Ljava/util/List;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/camera/f/b$b;)V
    //   154: aload_3
    //   155: invokevirtual 131	com/viber/voip/camera/c/b:x	()Ljava/util/List;
    //   158: astore 4
    //   160: aload_2
    //   161: invokestatic 136	com/viber/voip/camera/d/a:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   164: astore 5
    //   166: aload_0
    //   167: aload 4
    //   169: iconst_m1
    //   170: iconst_m1
    //   171: ldc 138
    //   173: aload 5
    //   175: invokestatic 141	com/viber/voip/camera/d/a:i	()Ljava/lang/String;
    //   178: ldc 143
    //   180: invokeinterface 148 3 0
    //   185: ldc 150
    //   187: new 152	com/viber/voip/camera/f/b$8
    //   190: dup
    //   191: aload_0
    //   192: aload_2
    //   193: invokespecial 155	com/viber/voip/camera/f/b$8:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   196: invokespecial 101	com/viber/voip/camera/f/b:a	(Ljava/util/List;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/camera/f/b$b;)V
    //   199: aload_3
    //   200: invokevirtual 159	com/viber/voip/camera/c/b:ac	()Lcom/viber/voip/camera/a/a;
    //   203: ifnull +93 -> 296
    //   206: aload_0
    //   207: aload_3
    //   208: invokevirtual 162	com/viber/voip/camera/c/b:v	()Ljava/util/List;
    //   211: aload_0
    //   212: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   215: getstatic 165	com/viber/voip/camera/R$string:white_balance	I
    //   218: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   221: invokestatic 168	com/viber/voip/camera/d/a:h	()Ljava/lang/String;
    //   224: aload_3
    //   225: invokevirtual 159	com/viber/voip/camera/c/b:ac	()Lcom/viber/voip/camera/a/a;
    //   228: invokevirtual 173	com/viber/voip/camera/a/a:o	()Ljava/lang/String;
    //   231: ldc 175
    //   233: invokespecial 178	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: aload_3
    //   238: invokevirtual 181	com/viber/voip/camera/c/b:u	()Ljava/util/List;
    //   241: aload_0
    //   242: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   245: getstatic 184	com/viber/voip/camera/R$string:scene_mode	I
    //   248: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   251: invokestatic 186	com/viber/voip/camera/d/a:g	()Ljava/lang/String;
    //   254: aload_3
    //   255: invokevirtual 159	com/viber/voip/camera/c/b:ac	()Lcom/viber/voip/camera/a/a;
    //   258: invokevirtual 189	com/viber/voip/camera/a/a:m	()Ljava/lang/String;
    //   261: ldc 191
    //   263: invokespecial 178	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: aload_3
    //   268: invokevirtual 194	com/viber/voip/camera/c/b:t	()Ljava/util/List;
    //   271: aload_0
    //   272: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   275: getstatic 197	com/viber/voip/camera/R$string:color_effect	I
    //   278: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   281: invokestatic 199	com/viber/voip/camera/d/a:f	()Ljava/lang/String;
    //   284: aload_3
    //   285: invokevirtual 159	com/viber/voip/camera/c/b:ac	()Lcom/viber/voip/camera/a/a;
    //   288: invokevirtual 202	com/viber/voip/camera/a/a:n	()Ljava/lang/String;
    //   291: ldc 204
    //   293: invokespecial 178	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_2
    //   297: invokevirtual 207	com/viber/voip/camera/activity/ViberCcamActivity:p	()Z
    //   300: ifeq +70 -> 370
    //   303: new 209	android/widget/CheckBox
    //   306: dup
    //   307: aload_2
    //   308: invokespecial 210	android/widget/CheckBox:<init>	(Landroid/content/Context;)V
    //   311: astore 6
    //   313: aload 6
    //   315: aload_0
    //   316: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   319: getstatic 213	com/viber/voip/camera/R$string:preference_auto_stabilise	I
    //   322: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   325: invokevirtual 217	android/widget/CheckBox:setText	(Ljava/lang/CharSequence;)V
    //   328: aload 6
    //   330: iconst_m1
    //   331: invokevirtual 220	android/widget/CheckBox:setTextColor	(I)V
    //   334: aload 6
    //   336: aload 5
    //   338: invokestatic 221	com/viber/voip/camera/d/a:m	()Ljava/lang/String;
    //   341: iconst_0
    //   342: invokeinterface 225 3 0
    //   347: invokevirtual 229	android/widget/CheckBox:setChecked	(Z)V
    //   350: aload 6
    //   352: new 231	com/viber/voip/camera/f/b$9
    //   355: dup
    //   356: aload_0
    //   357: aload_2
    //   358: invokespecial 232	com/viber/voip/camera/f/b$9:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   361: invokevirtual 236	android/widget/CheckBox:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   364: aload_0
    //   365: aload 6
    //   367: invokevirtual 240	com/viber/voip/camera/f/b:addView	(Landroid/view/View;)V
    //   370: aload_3
    //   371: invokevirtual 243	com/viber/voip/camera/c/b:L	()Ljava/util/List;
    //   374: astore 7
    //   376: aload_0
    //   377: aload_3
    //   378: invokevirtual 247	com/viber/voip/camera/c/b:M	()I
    //   381: putfield 30	com/viber/voip/camera/f/b:b	I
    //   384: new 249	java/util/ArrayList
    //   387: dup
    //   388: invokespecial 250	java/util/ArrayList:<init>	()V
    //   391: astore 8
    //   393: aload 7
    //   395: invokeinterface 256 1 0
    //   400: astore 9
    //   402: aload 9
    //   404: invokeinterface 261 1 0
    //   409: ifeq +80 -> 489
    //   412: aload 9
    //   414: invokeinterface 265 1 0
    //   419: checkcast 267	com/viber/voip/camera/a/a$h
    //   422: astore 23
    //   424: aload 8
    //   426: new 269	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   433: aload 23
    //   435: getfield 272	com/viber/voip/camera/a/a$h:a	I
    //   438: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: ldc_w 278
    //   444: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 23
    //   449: getfield 282	com/viber/voip/camera/a/a$h:b	I
    //   452: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: ldc_w 284
    //   458: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 23
    //   463: getfield 272	com/viber/voip/camera/a/a$h:a	I
    //   466: aload 23
    //   468: getfield 282	com/viber/voip/camera/a/a$h:b	I
    //   471: invokestatic 287	com/viber/voip/camera/c/b:a	(II)Ljava/lang/String;
    //   474: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokeinterface 294 2 0
    //   485: pop
    //   486: goto -84 -> 402
    //   489: aload_0
    //   490: aload 8
    //   492: aload_0
    //   493: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   496: getstatic 297	com/viber/voip/camera/R$string:preference_resolution	I
    //   499: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   502: aload_0
    //   503: getfield 30	com/viber/voip/camera/f/b:b	I
    //   506: iconst_0
    //   507: new 299	com/viber/voip/camera/f/b$10
    //   510: dup
    //   511: aload_0
    //   512: aload_2
    //   513: aload 7
    //   515: aload_3
    //   516: invokespecial 302	com/viber/voip/camera/f/b$10:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;Ljava/util/List;Lcom/viber/voip/camera/c/b;)V
    //   519: invokespecial 305	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;IZLcom/viber/voip/camera/f/b$a;)V
    //   522: aload_3
    //   523: invokevirtual 308	com/viber/voip/camera/c/b:O	()Ljava/util/List;
    //   526: astore 10
    //   528: aload_0
    //   529: aload_3
    //   530: invokevirtual 311	com/viber/voip/camera/c/b:P	()I
    //   533: putfield 32	com/viber/voip/camera/f/b:c	I
    //   536: new 249	java/util/ArrayList
    //   539: dup
    //   540: invokespecial 250	java/util/ArrayList:<init>	()V
    //   543: astore 11
    //   545: aload 10
    //   547: invokeinterface 256 1 0
    //   552: astore 12
    //   554: aload 12
    //   556: invokeinterface 261 1 0
    //   561: ifeq +28 -> 589
    //   564: aload 11
    //   566: aload_3
    //   567: aload 12
    //   569: invokeinterface 265 1 0
    //   574: checkcast 313	java/lang/String
    //   577: invokevirtual 316	com/viber/voip/camera/c/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   580: invokeinterface 294 2 0
    //   585: pop
    //   586: goto -32 -> 554
    //   589: aload_0
    //   590: aload 11
    //   592: aload_0
    //   593: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   596: getstatic 319	com/viber/voip/camera/R$string:video_quality	I
    //   599: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   602: aload_0
    //   603: getfield 32	com/viber/voip/camera/f/b:c	I
    //   606: iconst_0
    //   607: new 321	com/viber/voip/camera/f/b$11
    //   610: dup
    //   611: aload_0
    //   612: aload_2
    //   613: aload 10
    //   615: aload_3
    //   616: invokespecial 322	com/viber/voip/camera/f/b$11:<init>	(Lcom/viber/voip/camera/f/b;Lcom/viber/voip/camera/activity/ViberCcamActivity;Ljava/util/List;Lcom/viber/voip/camera/c/b;)V
    //   619: invokespecial 305	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;IZLcom/viber/voip/camera/f/b$a;)V
    //   622: aload_0
    //   623: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   626: getstatic 325	com/viber/voip/camera/R$array:preference_timer_values	I
    //   629: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   632: astore 13
    //   634: aload_0
    //   635: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   638: getstatic 332	com/viber/voip/camera/R$array:preference_timer_entries	I
    //   641: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   644: astore 14
    //   646: aload 5
    //   648: invokestatic 334	com/viber/voip/camera/d/a:O	()Ljava/lang/String;
    //   651: ldc_w 336
    //   654: invokeinterface 148 3 0
    //   659: astore 15
    //   661: aload_0
    //   662: aload 13
    //   664: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   667: aload 15
    //   669: invokeinterface 346 2 0
    //   674: putfield 34	com/viber/voip/camera/f/b:d	I
    //   677: aload_0
    //   678: getfield 34	com/viber/voip/camera/f/b:d	I
    //   681: iconst_m1
    //   682: if_icmpne +8 -> 690
    //   685: aload_0
    //   686: iconst_0
    //   687: putfield 34	com/viber/voip/camera/f/b:d	I
    //   690: aload_0
    //   691: aload 14
    //   693: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   696: aload_0
    //   697: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   700: getstatic 349	com/viber/voip/camera/R$string:preference_timer	I
    //   703: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   706: aload_0
    //   707: getfield 34	com/viber/voip/camera/f/b:d	I
    //   710: iconst_0
    //   711: new 351	com/viber/voip/camera/f/b$12
    //   714: dup
    //   715: aload_0
    //   716: aload 13
    //   718: aload_2
    //   719: invokespecial 354	com/viber/voip/camera/f/b$12:<init>	(Lcom/viber/voip/camera/f/b;[Ljava/lang/String;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   722: invokespecial 305	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;IZLcom/viber/voip/camera/f/b$a;)V
    //   725: aload_0
    //   726: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   729: getstatic 357	com/viber/voip/camera/R$array:preference_burst_mode_values	I
    //   732: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   735: astore 16
    //   737: aload_0
    //   738: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   741: getstatic 360	com/viber/voip/camera/R$array:preference_burst_mode_entries	I
    //   744: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   747: astore 17
    //   749: aload 5
    //   751: invokestatic 363	com/viber/voip/camera/d/a:Q	()Ljava/lang/String;
    //   754: ldc_w 365
    //   757: invokeinterface 148 3 0
    //   762: astore 18
    //   764: aload_0
    //   765: aload 16
    //   767: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   770: aload 18
    //   772: invokeinterface 346 2 0
    //   777: putfield 36	com/viber/voip/camera/f/b:e	I
    //   780: aload_0
    //   781: getfield 36	com/viber/voip/camera/f/b:e	I
    //   784: iconst_m1
    //   785: if_icmpne +8 -> 793
    //   788: aload_0
    //   789: iconst_0
    //   790: putfield 36	com/viber/voip/camera/f/b:e	I
    //   793: aload_0
    //   794: aload 17
    //   796: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   799: aload_0
    //   800: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   803: getstatic 368	com/viber/voip/camera/R$string:preference_burst_mode	I
    //   806: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   809: aload_0
    //   810: getfield 36	com/viber/voip/camera/f/b:e	I
    //   813: iconst_0
    //   814: new 370	com/viber/voip/camera/f/b$13
    //   817: dup
    //   818: aload_0
    //   819: aload 16
    //   821: aload_2
    //   822: invokespecial 371	com/viber/voip/camera/f/b$13:<init>	(Lcom/viber/voip/camera/f/b;[Ljava/lang/String;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   825: invokespecial 305	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;IZLcom/viber/voip/camera/f/b$a;)V
    //   828: aload_0
    //   829: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   832: getstatic 374	com/viber/voip/camera/R$array:preference_grid_values	I
    //   835: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   838: astore 19
    //   840: aload_0
    //   841: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   844: getstatic 377	com/viber/voip/camera/R$array:preference_grid_entries	I
    //   847: invokevirtual 329	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   850: astore 20
    //   852: aload 5
    //   854: invokestatic 380	com/viber/voip/camera/d/a:y	()Ljava/lang/String;
    //   857: ldc_w 382
    //   860: invokeinterface 148 3 0
    //   865: astore 21
    //   867: aload_0
    //   868: aload 19
    //   870: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   873: aload 21
    //   875: invokeinterface 346 2 0
    //   880: putfield 38	com/viber/voip/camera/f/b:f	I
    //   883: aload_0
    //   884: getfield 38	com/viber/voip/camera/f/b:f	I
    //   887: iconst_m1
    //   888: if_icmpne +8 -> 896
    //   891: aload_0
    //   892: iconst_0
    //   893: putfield 38	com/viber/voip/camera/f/b:f	I
    //   896: aload_0
    //   897: aload 20
    //   899: invokestatic 342	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   902: aload_0
    //   903: invokevirtual 76	com/viber/voip/camera/f/b:getResources	()Landroid/content/res/Resources;
    //   906: getstatic 385	com/viber/voip/camera/R$string:preference_grid	I
    //   909: invokevirtual 87	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   912: aload_0
    //   913: getfield 38	com/viber/voip/camera/f/b:f	I
    //   916: iconst_1
    //   917: new 387	com/viber/voip/camera/f/b$14
    //   920: dup
    //   921: aload_0
    //   922: aload 19
    //   924: aload_2
    //   925: invokespecial 388	com/viber/voip/camera/f/b$14:<init>	(Lcom/viber/voip/camera/f/b;[Ljava/lang/String;Lcom/viber/voip/camera/activity/ViberCcamActivity;)V
    //   928: invokespecial 305	com/viber/voip/camera/f/b:a	(Ljava/util/List;Ljava/lang/String;IZLcom/viber/voip/camera/f/b$a;)V
    //   931: return
  }

  private void a(List<String> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, final b paramb)
  {
    LinearLayout localLinearLayout;
    String[] arrayOfString1;
    String[] arrayOfString2;
    label57: float f1;
    int i;
    int k;
    int m;
    if (paramList != null)
    {
      System.currentTimeMillis();
      localLinearLayout = new LinearLayout(getContext());
      localLinearLayout.setOrientation(0);
      if (paramInt1 != -1)
      {
        arrayOfString1 = getResources().getStringArray(paramInt1);
        if (paramInt2 == -1)
          break label250;
        arrayOfString2 = getResources().getStringArray(paramInt2);
        f1 = getResources().getDisplayMetrics().density;
        i = 280;
        Display localDisplay = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        int j = -50 + (int)(localDisplayMetrics.heightPixels / f1);
        if (i > j)
          i = j;
        k = i / paramList.size();
        if (k >= 40)
          break label850;
        m = 40;
      }
    }
    for (int n = 1; ; n = 0)
    {
      final Object localObject1 = null;
      Iterator localIterator = paramList.iterator();
      final String str;
      int i4;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((arrayOfString1 == null) || (arrayOfString2 == null))
          break label844;
        i4 = -1;
        int i5 = 0;
        while (true)
          if ((i5 < arrayOfString2.length) && (i4 == -1))
          {
            if (arrayOfString2[i5].equals(str))
              i4 = i5;
            i5++;
            continue;
            arrayOfString1 = null;
            break;
            label250: arrayOfString2 = null;
            break label57;
          }
        if (i4 == -1)
          break label844;
      }
      label844: for (int i1 = getResources().getIdentifier(arrayOfString1[i4], null, getContext().getApplicationContext().getPackageName()); ; i1 = -1)
      {
        Object localObject2;
        if (i1 != -1)
        {
          localObject2 = new ImageButton(getContext());
          localLinearLayout.addView((View)localObject2);
          Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), i1);
          if (localBitmap != null)
            ((ImageButton)localObject2).setImageBitmap(localBitmap);
          ((ImageButton)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
          int i2 = (int)(0.5F + 10.0F * f1);
          ((View)localObject2).setPadding(i2, i2, i2, i2);
          ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
          localLayoutParams.width = ((int)(0.5F + f1 * m));
          localLayoutParams.height = ((int)(0.5F + 50.0F * f1));
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((View)localObject2).setContentDescription(paramString1);
          if (!str.equals(paramString2))
            break label745;
          ((View)localObject2).setAlpha(1.0F);
          localObject1 = localObject2;
        }
        while (true)
        {
          ((View)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              paramb.a(str);
            }
          });
          this.g.put(paramString3 + "_" + str, localObject2);
          break;
          localObject2 = new Button(getContext());
          ((Button)localObject2).setBackgroundColor(0);
          localLinearLayout.addView((View)localObject2);
          if ((paramString1.equalsIgnoreCase("ISO")) && (str.length() >= 4) && (str.substring(0, 4).equalsIgnoreCase("ISO_")))
            ((Button)localObject2).setText(paramString1 + "\n" + str.substring(4));
          while (true)
          {
            ((Button)localObject2).setTextSize(1, 12.0F);
            ((Button)localObject2).setTextColor(-1);
            int i3 = (int)(0.5F + 0.0F * f1);
            ((View)localObject2).setPadding(i3, i3, i3, i3);
            break;
            if ((paramString1.equalsIgnoreCase("ISO")) && (str.length() >= 3) && (str.substring(0, 3).equalsIgnoreCase("ISO")))
              ((Button)localObject2).setText(paramString1 + "\n" + str.substring(3));
            else
              ((Button)localObject2).setText(paramString1 + "\n" + str);
          }
          label745: ((View)localObject2).setAlpha(0.6F);
        }
        if (n != 0)
        {
          final HorizontalScrollView localHorizontalScrollView = new HorizontalScrollView(getContext());
          localHorizontalScrollView.addView(localLinearLayout);
          localHorizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams((int)(0.5F + f1 * i), -2));
          addView(localHorizontalScrollView);
          if (localObject1 != null)
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public void onGlobalLayout()
              {
                localHorizontalScrollView.scrollTo(localObject1.getLeft(), 0);
              }
            });
          return;
        }
        addView(localLinearLayout);
        return;
      }
      label850: m = k;
    }
  }

  private void a(final List<String> paramList, String paramString, int paramInt, final boolean paramBoolean, final a parama)
  {
    LinearLayout localLinearLayout;
    final TextView localTextView2;
    final Button localButton1;
    int j;
    final Button localButton2;
    if ((paramList != null) && (paramInt != -1))
    {
      TextView localTextView1 = new TextView(getContext());
      localTextView1.setText(paramString);
      localTextView1.setTextColor(-1);
      localTextView1.setGravity(17);
      localTextView1.setTextSize(1, 8.0F);
      addView(localTextView1);
      localLinearLayout = new LinearLayout(getContext());
      localLinearLayout.setOrientation(0);
      localTextView2 = new TextView(getContext());
      localTextView2.setText((CharSequence)paramList.get(paramInt));
      localTextView2.setTextColor(-1);
      localTextView2.setGravity(17);
      localTextView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0F));
      float f1 = getResources().getDisplayMetrics().density;
      localButton1 = new Button(getContext());
      localButton1.setBackgroundColor(0);
      localLinearLayout.addView(localButton1);
      localButton1.setText("<");
      localButton1.setTextSize(1, 12.0F);
      int i = (int)(0.5F + 0.0F * f1);
      localButton1.setPadding(i, i, i, i);
      ViewGroup.LayoutParams localLayoutParams1 = localButton1.getLayoutParams();
      localLayoutParams1.width = ((int)(0.5F + 60.0F * f1));
      localLayoutParams1.height = ((int)(0.5F + 50.0F * f1));
      localButton1.setLayoutParams(localLayoutParams1);
      if ((!paramBoolean) && (paramInt <= 0))
        break label468;
      j = 0;
      localButton1.setVisibility(j);
      localLinearLayout.addView(localTextView2);
      localButton2 = new Button(getContext());
      localButton2.setBackgroundColor(0);
      localLinearLayout.addView(localButton2);
      localButton2.setText(">");
      localButton2.setTextSize(1, 12.0F);
      localButton2.setPadding(i, i, i, i);
      ViewGroup.LayoutParams localLayoutParams2 = localButton2.getLayoutParams();
      localLayoutParams2.width = ((int)(0.5F + 60.0F * f1));
      localLayoutParams2.height = ((int)(0.5F + f1 * 50.0F));
      localButton2.setLayoutParams(localLayoutParams2);
      if ((!paramBoolean) && (paramInt >= -1 + paramList.size()))
        break label474;
    }
    label468: label474: for (int k = 0; ; k = 4)
    {
      localButton2.setVisibility(k);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = 4;
          int j = parama.a();
          Button localButton1;
          if (j != -1)
          {
            localTextView2.setText((CharSequence)paramList.get(j));
            localButton1 = localButton1;
            if ((!paramBoolean) && (j <= 0))
              break label99;
          }
          label99: for (int k = 0; ; k = i)
          {
            localButton1.setVisibility(k);
            Button localButton2 = localButton2;
            if ((paramBoolean) || (j < -1 + paramList.size()))
              i = 0;
            localButton2.setVisibility(i);
            return;
          }
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = 4;
          int j = parama.b();
          Button localButton1;
          if (j != -1)
          {
            localTextView2.setText((CharSequence)paramList.get(j));
            localButton1 = localButton1;
            if ((!paramBoolean) && (j <= 0))
              break label99;
          }
          label99: for (int k = 0; ; k = i)
          {
            localButton1.setVisibility(k);
            Button localButton2 = localButton2;
            if ((paramBoolean) || (j < -1 + paramList.size()))
              i = 0;
            localButton2.setVisibility(i);
            return;
          }
        }
      });
      addView(localLinearLayout);
      return;
      j = 4;
      break;
    }
  }

  private void a(List<String> paramList, String paramString1, final String paramString2, String paramString3, String paramString4)
  {
    if (paramList != null)
    {
      final ViberCcamActivity localViberCcamActivity = (ViberCcamActivity)getContext();
      TextView localTextView = new TextView(getContext());
      localTextView.setText(paramString1);
      localTextView.setTextColor(-1);
      localTextView.setGravity(17);
      localTextView.setTextSize(1, 8.0F);
      addView(localTextView);
      RadioGroup localRadioGroup = new RadioGroup(getContext());
      localRadioGroup.setOrientation(1);
      this.g.put(paramString4, localRadioGroup);
      String str1 = com.viber.voip.camera.d.a.a(localViberCcamActivity).getString(paramString2, paramString3);
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        RadioButton localRadioButton = new RadioButton(getContext());
        localRadioButton.setText(str2);
        localRadioButton.setTextColor(-1);
        if (str2.equals(str1))
          localRadioButton.setChecked(true);
        while (true)
        {
          localRadioGroup.addView(localRadioButton);
          localRadioButton.setContentDescription(str2);
          localRadioButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(localViberCcamActivity).edit();
              localEditor.putString(paramString2, str2);
              localEditor.apply();
              localViberCcamActivity.n();
              localViberCcamActivity.l();
            }
          });
          this.g.put(paramString4 + "_" + str2, localRadioButton);
          break;
          localRadioButton.setChecked(false);
        }
      }
      addView(localRadioGroup);
    }
  }

  public void a()
  {
    this.g.clear();
  }

  private abstract class a
  {
    private a()
    {
    }

    public abstract int a();

    public abstract int b();
  }

  private abstract class b
  {
    private b()
    {
    }

    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.f.b
 * JD-Core Version:    0.6.2
 */