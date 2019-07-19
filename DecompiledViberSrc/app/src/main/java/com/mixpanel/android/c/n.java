package com.mixpanel.android.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.mixpanel.android.b.f;
import com.mixpanel.android.mpmetrics.o;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(16)
class n
{
  private final com.mixpanel.android.mpmetrics.i a;
  private final c b;
  private final List<i> c;
  private final b d;
  private final Handler e;
  private final o f;

  public n(Context paramContext, List<i> paramList, o paramo)
  {
    this.a = com.mixpanel.android.mpmetrics.i.a(paramContext);
    this.c = paramList;
    this.f = paramo;
    this.e = new Handler(Looper.getMainLooper());
    this.b = new c();
    this.d = new b(255);
  }

  private void b(JsonWriter paramJsonWriter, View paramView)
    throws IOException
  {
    if ((paramView.getVisibility() == 4) && (this.a.t()))
      return;
    int i = paramView.getId();
    String str;
    CharSequence localCharSequence;
    label97: Object localObject1;
    label118: float f2;
    float f1;
    if (-1 == i)
    {
      str = null;
      paramJsonWriter.beginObject();
      paramJsonWriter.name("hashCode").value(paramView.hashCode());
      paramJsonWriter.name("id").value(i);
      paramJsonWriter.name("mp_id_name").value(str);
      localCharSequence = paramView.getContentDescription();
      if (localCharSequence != null)
        break label417;
      paramJsonWriter.name("contentDescription").nullValue();
      localObject1 = paramView.getTag();
      if (localObject1 != null)
        break label437;
      paramJsonWriter.name("tag").nullValue();
      paramJsonWriter.name("top").value(paramView.getTop());
      paramJsonWriter.name("left").value(paramView.getLeft());
      paramJsonWriter.name("width").value(paramView.getWidth());
      paramJsonWriter.name("height").value(paramView.getHeight());
      paramJsonWriter.name("scrollX").value(paramView.getScrollX());
      paramJsonWriter.name("scrollY").value(paramView.getScrollY());
      paramJsonWriter.name("visibility").value(paramView.getVisibility());
      if (Build.VERSION.SDK_INT < 11)
        break label615;
      f2 = paramView.getTranslationX();
      f1 = paramView.getTranslationY();
    }
    while (true)
    {
      paramJsonWriter.name("translationX").value(f2);
      paramJsonWriter.name("translationY").value(f1);
      paramJsonWriter.name("classes");
      paramJsonWriter.beginArray();
      Class localClass;
      for (Object localObject2 = paramView.getClass(); ; localObject2 = localClass)
      {
        paramJsonWriter.value((String)this.d.get(localObject2));
        localClass = ((Class)localObject2).getSuperclass();
        if ((localClass == Object.class) || (localClass == null))
        {
          paramJsonWriter.endArray();
          c(paramJsonWriter, paramView);
          ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
          if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
          {
            int[] arrayOfInt = ((RelativeLayout.LayoutParams)localLayoutParams).getRules();
            paramJsonWriter.name("layoutRules");
            paramJsonWriter.beginArray();
            int i1 = arrayOfInt.length;
            int i2 = 0;
            while (true)
              if (i2 < i1)
              {
                paramJsonWriter.value(arrayOfInt[i2]);
                i2++;
                continue;
                str = this.f.a(i);
                break;
                label417: paramJsonWriter.name("contentDescription").value(localCharSequence.toString());
                break label97;
                label437: if (!(localObject1 instanceof CharSequence))
                  break label118;
                paramJsonWriter.name("tag").value(localObject1.toString());
                break label118;
              }
            paramJsonWriter.endArray();
          }
          paramJsonWriter.name("subviews");
          paramJsonWriter.beginArray();
          if ((paramView instanceof ViewGroup))
          {
            ViewGroup localViewGroup2 = (ViewGroup)paramView;
            int m = localViewGroup2.getChildCount();
            for (int n = 0; n < m; n++)
            {
              View localView2 = localViewGroup2.getChildAt(n);
              if (localView2 != null)
                paramJsonWriter.value(localView2.hashCode());
            }
          }
          paramJsonWriter.endArray();
          paramJsonWriter.endObject();
          if (!(paramView instanceof ViewGroup))
            break;
          ViewGroup localViewGroup1 = (ViewGroup)paramView;
          int j = localViewGroup1.getChildCount();
          for (int k = 0; k < j; k++)
          {
            View localView1 = localViewGroup1.getChildAt(k);
            if (localView1 != null)
              b(paramJsonWriter, localView1);
          }
          break;
        }
      }
      label615: f1 = 0.0F;
      f2 = 0.0F;
    }
  }

  private void c(JsonWriter paramJsonWriter, View paramView)
    throws IOException
  {
    Class localClass1 = paramView.getClass();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.b.isAssignableFrom(localClass1)) && (locali.c != null))
      {
        Object localObject = locali.c.a(paramView);
        if (localObject != null)
          if ((localObject instanceof Number))
          {
            paramJsonWriter.name(locali.a).value((Number)localObject);
          }
          else if ((localObject instanceof Boolean))
          {
            paramJsonWriter.name(locali.a).value(((Boolean)localObject).booleanValue());
          }
          else if ((localObject instanceof ColorStateList))
          {
            paramJsonWriter.name(locali.a).value(Integer.valueOf(((ColorStateList)localObject).getDefaultColor()));
          }
          else if ((localObject instanceof Drawable))
          {
            Drawable localDrawable = (Drawable)localObject;
            Rect localRect = localDrawable.getBounds();
            paramJsonWriter.name(locali.a);
            paramJsonWriter.beginObject();
            paramJsonWriter.name("classes");
            paramJsonWriter.beginArray();
            for (Class localClass2 = localDrawable.getClass(); localClass2 != Object.class; localClass2 = localClass2.getSuperclass())
              paramJsonWriter.value(localClass2.getCanonicalName());
            paramJsonWriter.endArray();
            paramJsonWriter.name("dimensions");
            paramJsonWriter.beginObject();
            paramJsonWriter.name("left").value(localRect.left);
            paramJsonWriter.name("right").value(localRect.right);
            paramJsonWriter.name("top").value(localRect.top);
            paramJsonWriter.name("bottom").value(localRect.bottom);
            paramJsonWriter.endObject();
            if ((localDrawable instanceof ColorDrawable))
            {
              ColorDrawable localColorDrawable = (ColorDrawable)localDrawable;
              paramJsonWriter.name("color").value(localColorDrawable.getColor());
            }
            paramJsonWriter.endObject();
          }
          else
          {
            paramJsonWriter.name(locali.a).value(localObject.toString());
          }
      }
    }
  }

  void a(JsonWriter paramJsonWriter, View paramView)
    throws IOException
  {
    paramJsonWriter.beginArray();
    b(paramJsonWriter, paramView);
    paramJsonWriter.endArray();
  }

  public void a(k<Activity> paramk, OutputStream paramOutputStream)
    throws IOException
  {
    this.b.a(paramk);
    FutureTask localFutureTask = new FutureTask(this.b);
    this.e.post(localFutureTask);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream);
    Object localObject = Collections.emptyList();
    localOutputStreamWriter.write("[");
    try
    {
      List localList = (List)localFutureTask.get(1L, TimeUnit.SECONDS);
      localObject = localList;
      int i = ((List)localObject).size();
      for (int j = 0; j < i; j++)
      {
        if (j > 0)
          localOutputStreamWriter.write(",");
        d locald = (d)((List)localObject).get(j);
        localOutputStreamWriter.write("{");
        localOutputStreamWriter.write("\"activity\":");
        localOutputStreamWriter.write(JSONObject.quote(locald.a));
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"scale\":");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(locald.d);
        localOutputStreamWriter.write(String.format("%s", arrayOfObject));
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"serialized_objects\":");
        JsonWriter localJsonWriter = new JsonWriter(localOutputStreamWriter);
        localJsonWriter.beginObject();
        localJsonWriter.name("rootObject").value(locald.b.hashCode());
        localJsonWriter.name("objects");
        a(localJsonWriter, locald.b);
        localJsonWriter.endObject();
        localJsonWriter.flush();
        localOutputStreamWriter.write(",");
        localOutputStreamWriter.write("\"screenshot\":");
        localOutputStreamWriter.flush();
        locald.c.a(Bitmap.CompressFormat.PNG, 100, paramOutputStream);
        localOutputStreamWriter.write("}");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        f.b("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", localInterruptedException);
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        f.c("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", localTimeoutException);
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
        f.e("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", localExecutionException);
      localOutputStreamWriter.write("]");
      localOutputStreamWriter.flush();
    }
  }

  private static class a
  {
    private Bitmap a = null;
    private final Paint b = new Paint(2);

    public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
    {
      try
      {
        if ((this.a != null) && (this.a.getWidth() == paramInt1))
        {
          int i = this.a.getHeight();
          if (i == paramInt2)
            break label62;
        }
        try
        {
          this.a = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
          if (this.a != null)
            this.a.setDensity(paramInt3);
          label62: if (this.a != null)
            new Canvas(this.a).drawBitmap(paramBitmap, 0.0F, 0.0F, this.b);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          while (true)
            this.a = null;
        }
      }
      finally
      {
      }
    }

    public void a(Bitmap.CompressFormat paramCompressFormat, int paramInt, OutputStream paramOutputStream)
      throws IOException
    {
      try
      {
        if ((this.a == null) || (this.a.getWidth() == 0) || (this.a.getHeight() == 0))
          paramOutputStream.write("null".getBytes());
        while (true)
        {
          return;
          paramOutputStream.write(34);
          Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 2);
          this.a.compress(Bitmap.CompressFormat.PNG, 100, localBase64OutputStream);
          localBase64OutputStream.flush();
          paramOutputStream.write(34);
        }
      }
      finally
      {
      }
    }
  }

  private static class b extends LruCache<Class<?>, String>
  {
    public b(int paramInt)
    {
      super();
    }

    protected String a(Class<?> paramClass)
    {
      return paramClass.getCanonicalName();
    }
  }

  private static class c
    implements Callable<List<n.d>>
  {
    private k<Activity> a;
    private final List<n.d> b = new ArrayList();
    private final DisplayMetrics c = new DisplayMetrics();
    private final n.a d = new n.a();
    private final int e = 160;

    // ERROR //
    private void a(n.d paramd)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 58	com/mixpanel/android/c/n$d:b	Landroid/view/View;
      //   4: astore_2
      //   5: iconst_3
      //   6: anewarray 60	java/lang/Class
      //   9: astore 23
      //   11: aload 23
      //   13: iconst_0
      //   14: ldc 62
      //   16: aastore
      //   17: aload 23
      //   19: iconst_1
      //   20: getstatic 68	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   23: aastore
      //   24: aload 23
      //   26: iconst_2
      //   27: getstatic 71	java/lang/Boolean:TYPE	Ljava/lang/Class;
      //   30: aastore
      //   31: ldc 73
      //   33: ldc 75
      //   35: aload 23
      //   37: invokevirtual 79	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   40: astore 24
      //   42: aload 24
      //   44: iconst_1
      //   45: invokevirtual 85	java/lang/reflect/Method:setAccessible	(Z)V
      //   48: iconst_3
      //   49: anewarray 5	java/lang/Object
      //   52: astore 25
      //   54: aload 25
      //   56: iconst_0
      //   57: getstatic 89	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   60: aastore
      //   61: aload 25
      //   63: iconst_1
      //   64: iconst_m1
      //   65: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   68: aastore
      //   69: aload 25
      //   71: iconst_2
      //   72: iconst_0
      //   73: invokestatic 96	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   76: aastore
      //   77: aload 24
      //   79: aload_2
      //   80: aload 25
      //   82: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   85: checkcast 102	android/graphics/Bitmap
      //   88: astore 4
      //   90: aload 4
      //   92: ifnonnull +328 -> 420
      //   95: aload_2
      //   96: invokevirtual 106	android/view/View:isDrawingCacheEnabled	()Z
      //   99: invokestatic 96	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   102: astore 16
      //   104: aload_2
      //   105: iconst_1
      //   106: invokevirtual 109	android/view/View:setDrawingCacheEnabled	(Z)V
      //   109: aload_2
      //   110: iconst_1
      //   111: invokevirtual 112	android/view/View:buildDrawingCache	(Z)V
      //   114: aload_2
      //   115: invokevirtual 116	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
      //   118: astore 18
      //   120: aload 18
      //   122: astore 5
      //   124: aload 16
      //   126: astore 6
      //   128: aload 6
      //   130: astore 7
      //   132: fconst_1
      //   133: fstore 8
      //   135: aload 5
      //   137: ifnull +107 -> 244
      //   140: aload 5
      //   142: invokevirtual 120	android/graphics/Bitmap:getDensity	()I
      //   145: istore 9
      //   147: iload 9
      //   149: ifeq +11 -> 160
      //   152: ldc 121
      //   154: iload 9
      //   156: i2f
      //   157: fdiv
      //   158: fstore 8
      //   160: aload 5
      //   162: invokevirtual 124	android/graphics/Bitmap:getWidth	()I
      //   165: istore 10
      //   167: aload 5
      //   169: invokevirtual 127	android/graphics/Bitmap:getHeight	()I
      //   172: istore 11
      //   174: ldc2_w 128
      //   177: fload 8
      //   179: aload 5
      //   181: invokevirtual 124	android/graphics/Bitmap:getWidth	()I
      //   184: i2f
      //   185: fmul
      //   186: f2d
      //   187: dadd
      //   188: d2i
      //   189: istore 12
      //   191: ldc2_w 128
      //   194: fload 8
      //   196: aload 5
      //   198: invokevirtual 127	android/graphics/Bitmap:getHeight	()I
      //   201: i2f
      //   202: fmul
      //   203: f2d
      //   204: dadd
      //   205: d2i
      //   206: istore 13
      //   208: iload 10
      //   210: ifle +34 -> 244
      //   213: iload 11
      //   215: ifle +29 -> 244
      //   218: iload 12
      //   220: ifle +24 -> 244
      //   223: iload 13
      //   225: ifle +19 -> 244
      //   228: aload_0
      //   229: getfield 40	com/mixpanel/android/c/n$c:d	Lcom/mixpanel/android/c/n$a;
      //   232: iload 12
      //   234: iload 13
      //   236: sipush 160
      //   239: aload 5
      //   241: invokevirtual 132	com/mixpanel/android/c/n$a:a	(IIILandroid/graphics/Bitmap;)V
      //   244: aload 7
      //   246: ifnull +16 -> 262
      //   249: aload 7
      //   251: invokevirtual 135	java/lang/Boolean:booleanValue	()Z
      //   254: ifne +8 -> 262
      //   257: aload_2
      //   258: iconst_0
      //   259: invokevirtual 109	android/view/View:setDrawingCacheEnabled	(Z)V
      //   262: aload_1
      //   263: fload 8
      //   265: putfield 138	com/mixpanel/android/c/n$d:d	F
      //   268: aload_1
      //   269: aload_0
      //   270: getfield 40	com/mixpanel/android/c/n$c:d	Lcom/mixpanel/android/c/n$a;
      //   273: putfield 140	com/mixpanel/android/c/n$d:c	Lcom/mixpanel/android/c/n$a;
      //   276: return
      //   277: astore 22
      //   279: ldc 142
      //   281: ldc 144
      //   283: aload 22
      //   285: invokestatic 149	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   288: aconst_null
      //   289: astore 4
      //   291: goto -201 -> 90
      //   294: astore 21
      //   296: ldc 142
      //   298: ldc 151
      //   300: aload 21
      //   302: invokestatic 153	com/mixpanel/android/b/f:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   305: aconst_null
      //   306: astore 4
      //   308: goto -218 -> 90
      //   311: astore 20
      //   313: ldc 142
      //   315: ldc 155
      //   317: aload 20
      //   319: invokestatic 157	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   322: aconst_null
      //   323: astore 4
      //   325: goto -235 -> 90
      //   328: astore 19
      //   330: ldc 142
      //   332: ldc 159
      //   334: aload 19
      //   336: invokestatic 157	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   339: aconst_null
      //   340: astore 4
      //   342: goto -252 -> 90
      //   345: astore_3
      //   346: ldc 142
      //   348: ldc 161
      //   350: aload_3
      //   351: invokestatic 157	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   354: aconst_null
      //   355: astore 4
      //   357: goto -267 -> 90
      //   360: astore 14
      //   362: aconst_null
      //   363: astore 7
      //   365: aload 14
      //   367: astore 15
      //   369: ldc 142
      //   371: new 163	java/lang/StringBuilder
      //   374: dup
      //   375: invokespecial 164	java/lang/StringBuilder:<init>	()V
      //   378: ldc 166
      //   380: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: aload_2
      //   384: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   387: ldc 175
      //   389: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   392: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   395: aload 15
      //   397: invokestatic 149	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   400: aload 4
      //   402: astore 5
      //   404: goto -272 -> 132
      //   407: astore 17
      //   409: aload 16
      //   411: astore 7
      //   413: aload 17
      //   415: astore 15
      //   417: goto -48 -> 369
      //   420: aload 4
      //   422: astore 5
      //   424: aconst_null
      //   425: astore 6
      //   427: goto -299 -> 128
      //
      // Exception table:
      //   from	to	target	type
      //   5	90	277	java/lang/NoSuchMethodException
      //   5	90	294	java/lang/IllegalArgumentException
      //   5	90	311	java/lang/reflect/InvocationTargetException
      //   5	90	328	java/lang/IllegalAccessException
      //   5	90	345	java/lang/ClassCastException
      //   95	104	360	java/lang/RuntimeException
      //   104	120	407	java/lang/RuntimeException
    }

    public List<n.d> a()
      throws Exception
    {
      this.b.clear();
      Iterator localIterator = this.a.a().iterator();
      while (localIterator.hasNext())
      {
        Activity localActivity = (Activity)localIterator.next();
        String str = localActivity.getClass().getCanonicalName();
        View localView = localActivity.getWindow().getDecorView().getRootView();
        localActivity.getWindowManager().getDefaultDisplay().getMetrics(this.c);
        n.d locald = new n.d(str, localView);
        this.b.add(locald);
      }
      int i = this.b.size();
      for (int j = 0; j < i; j++)
        a((n.d)this.b.get(j));
      return this.b;
    }

    public void a(k<Activity> paramk)
    {
      this.a = paramk;
    }
  }

  private static class d
  {
    public final String a;
    public final View b;
    public n.a c;
    public float d;

    public d(String paramString, View paramView)
    {
      this.a = paramString;
      this.b = paramView;
      this.c = null;
      this.d = 1.0F;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.n
 * JD-Core Version:    0.6.2
 */