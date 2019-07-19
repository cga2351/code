package com.adsnative.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.adsnative.c.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class h
{
  public static int a;
  private static List<View> n = new ArrayList();
  private static WeakHashMap<Object, Boolean> o = new WeakHashMap();
  private static WeakHashMap<Object, Boolean> p = new WeakHashMap();
  private static WeakHashMap<View, Boolean> q = new WeakHashMap();
  private static ag r = null;
  private static String s = null;
  private final Context b;
  private LinearLayout c;
  private final ah d;
  private c e;
  private ah.d f;
  private a g;
  private WeakHashMap<View, b> h;
  private HashMap<String, Boolean> i;
  private HashMap<String, JSONArray> j;
  private ArrayList<String> k;
  private ArrayList<String> l;
  private HashMap<String, Object> m;

  public h(Context paramContext)
  {
    this(paramContext, null);
  }

  public h(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.b = paramContext;
    this.c = paramLinearLayout;
    this.d = new ah(this.b);
    this.f = new ah.d()
    {
      public void a(List<View> paramAnonymousList1, List<View> paramAnonymousList2, List<View> paramAnonymousList3)
      {
        Iterator localIterator1 = paramAnonymousList1.iterator();
        while (localIterator1.hasNext())
        {
          View localView2 = (View)localIterator1.next();
          if ((localView2 instanceof LinearLayout))
          {
            if (localView2.getTag() != null)
            {
              Boolean localBoolean3 = (Boolean)h.a().get(localView2.getTag());
              h.a().put(localView2.getTag(), new Boolean(true));
              Boolean localBoolean4 = (Boolean)h.b().get(localView2.getTag());
              if (((localBoolean3 == null) || (!localBoolean3.booleanValue())) && ((localBoolean4 == null) || (!localBoolean4.booleanValue())))
              {
                h.b().put(localView2.getTag(), new Boolean(true));
                if (h.a(h.this) != null);
                for (h.b localb2 = (h.b)h.a(h.this).get(localView2); ; localb2 = null)
                {
                  if (localb2 == null)
                    break label233;
                  h.b(h.this);
                  ((LinearLayout)localView2).removeAllViews();
                  if (!localb2.a)
                    break label235;
                  h.a(h.this, (LinearLayout)localView2, localb2.b, localb2.c);
                  break;
                  i.e("Attempted to get mediaViewMetaData when mMediaViewMetaData is null (126)");
                }
                label233: continue;
                label235: h.b(h.this, (LinearLayout)localView2, localb2.b, localb2.c);
              }
            }
          }
          else
          {
            Boolean localBoolean2 = (Boolean)h.c().get(localView2);
            if ((localBoolean2 == null) || (!localBoolean2.booleanValue()))
            {
              if (h.a(h.this) != null);
              for (h.b localb1 = (h.b)h.a(h.this).get(localView2); ; localb1 = null)
              {
                if ((localb1 == null) || (!localb1.c))
                  break label356;
                if (!(localView2 instanceof WebView))
                  break label358;
                ((WebView)localView2).loadUrl("javascript:autoPlay();");
                break;
                i.e("Attempted to get mediaViewMetaData when mMediaViewMetaData is null (155)");
              }
              label356: continue;
              label358: if ((localView2 instanceof ac))
              {
                ((ac)localView2).i();
                h.c().put(localView2, new Boolean(true));
              }
            }
          }
        }
        Iterator localIterator2 = paramAnonymousList3.iterator();
        while (localIterator2.hasNext())
        {
          View localView1 = (View)localIterator2.next();
          if ((localView1 instanceof LinearLayout))
          {
            h.a().put(localView1.getTag(), new Boolean(false));
          }
          else
          {
            Boolean localBoolean1 = (Boolean)h.c().get(localView1);
            if ((localBoolean1 != null) && (localBoolean1.booleanValue()))
              if ((localView1 instanceof WebView))
              {
                ((WebView)localView1).loadUrl("javascript:autoPause();");
                h.c().put(localView1, new Boolean(false));
              }
              else if ((localView1 instanceof ac))
              {
                ((ac)localView1).j();
                h.c().put(localView1, new Boolean(false));
              }
          }
        }
      }
    };
    this.d.a(this.f);
    this.h = new WeakHashMap();
  }

  private String a(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() <= 0))
      str = "";
    do
    {
      return str;
      Matcher localMatcher = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*").matcher(paramString);
      boolean bool = localMatcher.find();
      str = null;
      if (bool)
        str = localMatcher.group();
    }
    while ((str != null) && (str.length() == 11));
    return "";
  }

  public static void a(View paramView)
  {
    if ((paramView instanceof WebView))
      ((WebView)paramView).onPause();
    View localView;
    do
    {
      do
        return;
      while (!(paramView instanceof FrameLayout));
      localView = ((FrameLayout)paramView).getChildAt(0);
    }
    while (!(localView instanceof ac));
    ((ac)localView).a();
  }

  @TargetApi(17)
  private void a(LinearLayout paramLinearLayout, String paramString, boolean paramBoolean)
  {
    final WebView localWebView = new WebView(this.b);
    ag localag = new ag(this.b);
    r = localag;
    localWebView.setWebChromeClient(localag);
    localWebView.setWebViewClient(new WebViewClient()
    {
      private float c = 0.0F;

      private float a(String paramAnonymousString)
      {
        String str = paramAnonymousString.split("=")[1];
        if ((str != null) && (str.length() > 0))
          return Float.parseFloat(str);
        return 0.0F;
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("ytplayer")))
        {
          float f2;
          label138: String str;
          if (paramAnonymousString.startsWith("ytplayer://progress?data="))
          {
            float f1 = a(paramAnonymousString);
            if (f1 > 0.0F)
            {
              if (h.c(h.this) == null)
                break label271;
              h.c(h.this).b();
              Boolean localBoolean1 = (Boolean)h.c().get(localWebView);
              if ((localBoolean1 == null) || (!localBoolean1.booleanValue()))
                h.c().put(localWebView, new Boolean(true));
              if (this.c != 0.0F)
              {
                f2 = 100.0F * f1 / this.c;
                Iterator localIterator = h.d(h.this).iterator();
                if (localIterator.hasNext())
                  str = (String)localIterator.next();
              }
            }
          }
          while (true)
          {
            try
            {
              if (f2 < Integer.parseInt(str))
                break label138;
              if (h.e(h.this) != null)
              {
                localBoolean2 = (Boolean)h.e(h.this).get(str);
                if ((localBoolean2 != null) && (localBoolean2.booleanValue()))
                  break label138;
                h.c(h.this).a(str);
                h.e(h.this).put(str, new Boolean(true));
                if (f2 >= 100.0F)
                  h.c(h.this).a("100");
                return true;
                label271: i.e("Attempted videoOnStart when mMediaViewTrackersListener is null");
                break;
              }
              i.e("mQuartilesToTrack is null");
              Boolean localBoolean2 = null;
              continue;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              i.e("Video percentage tracker is not a valid Integer or Double + " + str);
              localNumberFormatException.printStackTrace();
            }
            break label138;
            if (paramAnonymousString.startsWith("ytplayer://duration?data="))
            {
              if (h.c(h.this) != null)
                h.c(h.this).a();
              while (true)
              {
                this.c = a(paramAnonymousString);
                if (h.d() == null)
                  h.a(new ArrayList());
                h.d().add(localWebView);
                break;
                i.e("Attempted videoImpressed when mMediaViewTrackersListener is null");
              }
            }
            if (paramAnonymousString.startsWith("ytplayer://error?data="))
              if (h.f(h.this) != null)
                h.f(h.this).a(localWebView);
              else
                i.e("Attempted mediaFailedToLoad when mMediaLoadListener is null");
          }
        }
        return false;
      }
    });
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    paramLinearLayout.addView(localWebView, new LinearLayout.LayoutParams(-1, -1));
    if (s == null)
      s = f();
    if ((s != null) && (s.contains("__ytid__")))
    {
      localWebView.loadData(s.replace("__ytid__", a(paramString)), "text/html", "UTF-8");
      localWebView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          localWebView.loadUrl("javascript:unMute();");
          if (h.c(h.this) != null)
            h.c(h.this).c();
          while (true)
          {
            return false;
            i.e("Attempted videoClickThrough when mMediaViewTrackersListener is null");
          }
        }
      });
      b localb = new b();
      localb.c = paramBoolean;
      if (this.h == null)
        break label231;
      this.h.put(localWebView, localb);
    }
    while (true)
    {
      Double localDouble = (Double)this.m.get("percentVisible");
      if ((localDouble == null) || (localDouble.intValue() <= 0))
        break;
      this.d.a(localWebView, localDouble.intValue(), 1);
      return;
      label231: i.e("Attempted to update webView mMediaViewMetaData is null");
    }
    this.d.a(localWebView, 50, 1);
  }

  public static void a(ac paramac, boolean paramBoolean)
  {
    q.put(paramac, Boolean.valueOf(paramBoolean));
  }

  public static void b(View paramView)
  {
    if ((paramView instanceof ac))
      ((ac)paramView).g();
    while (!(paramView instanceof WebView))
      return;
    ((WebView)paramView).destroy();
  }

  private void b(LinearLayout paramLinearLayout, String paramString, boolean paramBoolean)
  {
    final ac localac = new ac(this.b, this.m);
    FrameLayout localFrameLayout = new FrameLayout(this.b);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    localFrameLayout.addView(localac, new FrameLayout.LayoutParams(-1, -2));
    paramLinearLayout.addView(localFrameLayout);
    localac.setTrackersListener(this.e);
    localac.setQuartilesToTrack(this.j);
    localac.setVideoCompleteTrackers(this.l);
    localac.setMediaLoadListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        if (h.f(h.this) != null)
        {
          h.f(h.this).a(paramAnonymousView);
          return;
        }
        i.e("Attempted mediaFailedToLoad when mMediaLoadListener is null");
      }
    });
    localac.setVideoPath(paramString);
    x localx = new x(this.b);
    localx.setVideoConfigs(this.m);
    localx.setAnchorView(localFrameLayout);
    localac.setMediaController(localx);
    b localb = new b();
    localb.c = paramBoolean;
    if (this.h != null)
      this.h.put(localac, localb);
    while (true)
    {
      Double localDouble = (Double)this.m.get("percentVisible");
      if ((localDouble == null) || (localDouble.intValue() <= 0))
        break;
      this.d.a(localac, localDouble.intValue(), 1);
      return;
      i.e("Attempted to update mMediaViewMetaData is null");
    }
    this.d.a(localac, 50, 1);
  }

  private HashMap<String, Boolean> e()
  {
    HashMap localHashMap = new HashMap();
    if (this.j != null)
    {
      Iterator localIterator = this.j.keySet().iterator();
      while (localIterator.hasNext())
        localHashMap.put((String)localIterator.next(), new Boolean(false));
    }
    return localHashMap;
  }

  // ERROR //
  private String f()
  {
    // Byte code:
    //   0: new 369	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: new 372	java/io/BufferedReader
    //   11: dup
    //   12: new 374	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: getfield 73	com/adsnative/ads/h:b	Landroid/content/Context;
    //   20: invokevirtual 380	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 382
    //   26: invokevirtual 388	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: ldc 206
    //   31: invokespecial 391	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 394	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 397	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +57 -> 103
    //   49: aload_1
    //   50: aload 7
    //   52: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -18 -> 38
    //   59: astore 5
    //   61: new 369	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 403
    //   71: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 5
    //   76: invokevirtual 406	java/io/IOException:getMessage	()Ljava/lang/String;
    //   79: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 252	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   88: aload 5
    //   90: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 415	java/io/BufferedReader:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 415	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: areturn
    //   116: astore 9
    //   118: new 369	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 417
    //   128: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 9
    //   133: invokevirtual 406	java/io/IOException:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 252	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   145: aload 9
    //   147: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore 6
    //   154: new 369	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 417
    //   164: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 6
    //   169: invokevirtual 406	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 252	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   181: aload 6
    //   183: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 415	java/io/BufferedReader:close	()V
    //   199: aload_3
    //   200: athrow
    //   201: astore 4
    //   203: new 369	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 417
    //   213: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 4
    //   218: invokevirtual 406	java/io/IOException:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 252	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_3
    //   238: goto -47 -> 191
    //   241: astore 5
    //   243: aconst_null
    //   244: astore_2
    //   245: goto -184 -> 61
    //
    // Exception table:
    //   from	to	target	type
    //   38	44	59	java/io/IOException
    //   49	56	59	java/io/IOException
    //   107	111	116	java/io/IOException
    //   97	101	152	java/io/IOException
    //   8	38	188	finally
    //   195	199	201	java/io/IOException
    //   38	44	237	finally
    //   49	56	237	finally
    //   61	93	237	finally
    //   8	38	241	java/io/IOException
  }

  private void g()
  {
    if ((n != null) && (n.size() > 0))
    {
      Iterator localIterator = n.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof WebView))
        {
          ViewGroup localViewGroup2 = (ViewGroup)localView.getParent();
          if (localViewGroup2 != null)
          {
            localViewGroup2.removeAllViews();
            o.put(localViewGroup2.getTag(), new Boolean(false));
          }
          ((WebView)localView).destroy();
        }
        else if ((localView instanceof ac))
        {
          FrameLayout localFrameLayout = (FrameLayout)localView.getParent();
          if (localFrameLayout != null)
          {
            localFrameLayout.removeAllViews();
            ViewGroup localViewGroup1 = (ViewGroup)localFrameLayout.getParent();
            if (localViewGroup1 != null)
            {
              localViewGroup1.removeAllViews();
              o.put(localViewGroup1.getTag(), new Boolean(false));
            }
          }
          i.b("MediaView -> unloadAndDestroyAllViews -> videoView.hashCode() : " + localView.hashCode());
          ((ac)localView).g();
        }
      }
      n = null;
    }
  }

  public void a(c paramc)
  {
    this.e = paramc;
  }

  public void a(ArrayList<String> paramArrayList)
  {
    this.l = paramArrayList;
  }

  public void a(HashMap<String, JSONArray> paramHashMap)
  {
    this.j = paramHashMap;
    this.i = e();
    this.k = new ArrayList(this.i.keySet());
    Collections.sort(this.k);
  }

  public static abstract interface a
  {
    public abstract void a(View paramView);
  }

  static class b
  {
    boolean a;
    String b;
    boolean c;
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(String paramString);

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.h
 * JD-Core Version:    0.6.2
 */