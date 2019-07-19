package com.viber.voip.gallery.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.an.a;
import com.viber.voip.an.c;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gallery.c.a;
import com.viber.voip.ui.aq;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.PhotoDoodleView;
import com.viber.voip.widget.PhotoDoodleView.a;
import java.io.FileNotFoundException;
import java.io.IOException;

public class c extends aq
  implements PhotoDoodleView.a
{
  private static final Logger a;
  private static final int b = i1;
  private MenuItem c;
  private ImageView d;
  private PhotoDoodleView e;
  private b f;
  private Uri g;
  private an.c h;
  private Handler i;
  private Handler j;
  private a k;
  private b l;
  private boolean m;
  private Context n;
  private View.OnTouchListener o = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (c.a(c.this) != null)
        c.a(c.this).a();
      return false;
    }
  };

  static
  {
    int i1 = 1280;
    a = ViberEnv.getLogger();
    if (j.a(640.0F) <= i1)
      i1 = j.a(640.0F);
  }

  private void a(an.c paramc)
  {
    if (paramc == null);
    boolean bool;
    do
    {
      return;
      bool = a.a(this.g);
      if (bool)
        this.e.setCanvasDirty(true);
      if (!paramc.a)
        break;
      this.e.a(paramc.e.a, true);
      this.d.setImageDrawable(null);
      this.e.setVisibility(0);
      this.d.setVisibility(8);
    }
    while (!bool);
    this.k = new a(this.g, this.n);
    this.i.post(this.k);
    return;
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    localLayoutParams.height = paramc.c;
    localLayoutParams.width = paramc.b;
    this.d.setImageBitmap(paramc.e.a);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }

  private void f()
  {
    if (this.l != null)
    {
      this.i.removeCallbacks(this.l);
      this.l = null;
    }
    Bitmap localBitmap1 = this.e.getDoodle();
    Bitmap localBitmap2 = j.b(this.e.getDrawable());
    if ((localBitmap1 == null) || (localBitmap2 == null))
      return;
    if (this.f != null)
      this.f.b();
    this.l = new b(this.g, localBitmap1, localBitmap2);
    this.i.post(this.l);
  }

  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.supportInvalidateOptionsMenu();
  }

  void a(final Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    this.j.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this, null);
        if (c.b(c.this) != null)
        {
          if (!c.c(c.this))
            break label75;
          c.b(c.this).a(null, paramBitmap2);
          c.b(c.this).setCanvasDirty(false);
          c.a(c.this, false);
        }
        while (true)
        {
          c.b(c.this).invalidate();
          return;
          label75: c.b(c.this).a(paramBitmap1, paramBitmap2);
        }
      }
    });
  }

  void a(final Uri paramUri, final Bitmap paramBitmap)
  {
    this.j.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this, null);
        if (c.a(c.this) != null)
          c.a(c.this).a(paramUri, paramBitmap);
      }
    });
  }

  public void a(Uri paramUri, an.c paramc)
  {
    this.g = paramUri;
    if (this.e == null)
    {
      this.h = paramc;
      return;
    }
    a(paramc);
  }

  public void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.supportInvalidateOptionsMenu();
  }

  public void c()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.finish();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    setHasOptionsMenu(true);
    Bundle localBundle = getArguments();
    if (localBundle == null)
      throw new IllegalStateException("Fragment requires arguments.");
    int i1 = localBundle.getInt("eraser_size", 0);
    int i2 = localBundle.getInt("brush_color", 0);
    int i3 = localBundle.getInt("brush_size", 0);
    String str = localBundle.getString("custom_brush_path");
    if (paramBundle != null)
    {
      this.m = paramBundle.getBoolean("clear_doodle");
      this.n = getActivity().getApplicationContext();
      this.j = av.a(av.e.a);
      this.i = av.a(av.e.g);
      View localView = getView();
      this.d = ((ImageView)localView.findViewById(R.id.preview));
      this.e = ((PhotoDoodleView)localView.findViewById(R.id.doodle));
      this.e.setDoodleListener(this);
      this.e.setOnTouchListener(this.o);
      this.e.setPaintColor(i2);
      if (i1 <= 0)
        break label212;
      this.e.a(i1);
    }
    while (true)
    {
      a(this.h);
      this.h = null;
      return;
      this.m = localBundle.getBoolean("clear_doodle", false);
      break;
      label212: if (TextUtils.isEmpty(str))
        this.e.a(i3, i2);
      else
        this.e.a(i2, str, i3);
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!b.class.isInstance(paramActivity))
      throw new RuntimeException("parent activity must implement PhotoEditController");
    this.f = ((b)paramActivity);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_photo_preview, paramMenu);
    this.c = paramMenu.findItem(R.id.menu_done);
    MenuItem localMenuItem = this.c;
    if ((this.e != null) && (this.e.e()));
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.photo_edit_fragment, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.d.setImageDrawable(null);
    this.e.d();
    this.e = null;
    this.d = null;
    if (this.l != null)
      this.i.removeCallbacks(this.l);
    if (this.k != null)
      this.i.removeCallbacks(this.k);
    super.onDestroyView();
  }

  public void onDetach()
  {
    this.f = null;
    super.onDetach();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_done == paramMenuItem.getItemId())
    {
      f();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("clear_doodle", this.m);
    super.onSaveInstanceState(paramBundle);
  }

  class a
    implements Runnable
  {
    final Uri a;
    final Context b;

    a(Uri paramContext, Context arg3)
    {
      this.a = paramContext;
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      try
      {
        Bitmap localBitmap1 = j.a(this.b, a.b(this.a), c.e(), c.e(), false);
        Bitmap localBitmap2 = j.a(this.b, this.a, c.e(), c.e(), false);
        Bitmap localBitmap3 = localBitmap1.copy(localBitmap1.getConfig(), true);
        localBitmap1.recycle();
        c.this.a(localBitmap3, localBitmap2);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        c.d().a(localOutOfMemoryError, "Not enough memory to get original image and doodle.");
        ViberApplication.getInstance().onOutOfMemory();
        return;
      }
      catch (IOException localIOException)
      {
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
      }
    }
  }

  class b
    implements Runnable
  {
    final Uri a;
    Bitmap b;
    Bitmap c;

    b(Uri paramBitmap1, Bitmap paramBitmap2, Bitmap arg4)
    {
      this.a = paramBitmap1;
      this.b = paramBitmap2;
      Object localObject;
      this.c = localObject;
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   4: ifnull +278 -> 282
      //   7: aload_0
      //   8: getfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   11: ifnull +271 -> 282
      //   14: aload_0
      //   15: getfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   18: invokevirtual 35	android/graphics/Bitmap:getWidth	()I
      //   21: aload_0
      //   22: getfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   25: invokevirtual 38	android/graphics/Bitmap:getHeight	()I
      //   28: getstatic 44	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   31: invokestatic 48	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      //   34: astore 7
      //   36: aload 7
      //   38: astore_1
      //   39: new 50	android/graphics/Canvas
      //   42: dup
      //   43: aload_1
      //   44: invokespecial 53	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
      //   47: astore 8
      //   49: new 55	android/graphics/Paint
      //   52: dup
      //   53: bipush 6
      //   55: invokespecial 58	android/graphics/Paint:<init>	(I)V
      //   58: astore 9
      //   60: aload 8
      //   62: aload_0
      //   63: getfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   66: fconst_0
      //   67: fconst_0
      //   68: aload 9
      //   70: invokevirtual 62	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
      //   73: aload 8
      //   75: aload_0
      //   76: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   79: fconst_0
      //   80: fconst_0
      //   81: aload 9
      //   83: invokevirtual 62	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
      //   86: aload_1
      //   87: aload_0
      //   88: getfield 22	com/viber/voip/gallery/preview/c$b:a	Landroid/net/Uri;
      //   91: invokestatic 67	com/viber/voip/gallery/c/a:a	(Landroid/graphics/Bitmap;Landroid/net/Uri;)Landroid/net/Uri;
      //   94: astore 11
      //   96: aload 11
      //   98: astore 6
      //   100: aload 6
      //   102: ifnull +15 -> 117
      //   105: aload_0
      //   106: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   109: aload_0
      //   110: getfield 22	com/viber/voip/gallery/preview/c$b:a	Landroid/net/Uri;
      //   113: invokestatic 69	com/viber/voip/gallery/c/a:b	(Landroid/graphics/Bitmap;Landroid/net/Uri;)Landroid/net/Uri;
      //   116: pop
      //   117: aload_0
      //   118: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   121: ifnull +10 -> 131
      //   124: aload_0
      //   125: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   128: invokevirtual 72	android/graphics/Bitmap:recycle	()V
      //   131: aload_0
      //   132: aconst_null
      //   133: putfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   136: aload_0
      //   137: aconst_null
      //   138: putfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   141: aload 6
      //   143: astore_2
      //   144: aload_0
      //   145: getfield 17	com/viber/voip/gallery/preview/c$b:d	Lcom/viber/voip/gallery/preview/c;
      //   148: aload_2
      //   149: aload_1
      //   150: invokevirtual 77	com/viber/voip/gallery/preview/c:a	(Landroid/net/Uri;Landroid/graphics/Bitmap;)V
      //   153: return
      //   154: astore 4
      //   156: aconst_null
      //   157: astore 5
      //   159: aconst_null
      //   160: astore 6
      //   162: invokestatic 80	com/viber/voip/gallery/preview/c:d	()Lcom/viber/dexshared/Logger;
      //   165: aload 4
      //   167: ldc 82
      //   169: invokeinterface 87 3 0
      //   174: aload 5
      //   176: ifnull +100 -> 276
      //   179: aload 5
      //   181: invokevirtual 72	android/graphics/Bitmap:recycle	()V
      //   184: aconst_null
      //   185: astore_1
      //   186: invokestatic 93	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
      //   189: invokevirtual 96	com/viber/voip/ViberApplication:onOutOfMemory	()V
      //   192: aload_0
      //   193: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   196: ifnull +10 -> 206
      //   199: aload_0
      //   200: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   203: invokevirtual 72	android/graphics/Bitmap:recycle	()V
      //   206: aload_0
      //   207: aconst_null
      //   208: putfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   211: aload_0
      //   212: aconst_null
      //   213: putfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   216: aload 6
      //   218: astore_2
      //   219: goto -75 -> 144
      //   222: astore_3
      //   223: aload_0
      //   224: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   227: ifnull +10 -> 237
      //   230: aload_0
      //   231: getfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   234: invokevirtual 72	android/graphics/Bitmap:recycle	()V
      //   237: aload_0
      //   238: aconst_null
      //   239: putfield 24	com/viber/voip/gallery/preview/c$b:b	Landroid/graphics/Bitmap;
      //   242: aload_0
      //   243: aconst_null
      //   244: putfield 26	com/viber/voip/gallery/preview/c$b:c	Landroid/graphics/Bitmap;
      //   247: aload_3
      //   248: athrow
      //   249: astore 10
      //   251: aload_1
      //   252: astore 5
      //   254: aload 10
      //   256: astore 4
      //   258: aconst_null
      //   259: astore 6
      //   261: goto -99 -> 162
      //   264: astore 12
      //   266: aload_1
      //   267: astore 5
      //   269: aload 12
      //   271: astore 4
      //   273: goto -111 -> 162
      //   276: aload 5
      //   278: astore_1
      //   279: goto -93 -> 186
      //   282: aconst_null
      //   283: astore_1
      //   284: aconst_null
      //   285: astore_2
      //   286: goto -142 -> 144
      //
      // Exception table:
      //   from	to	target	type
      //   14	36	154	java/lang/OutOfMemoryError
      //   14	36	222	finally
      //   39	96	222	finally
      //   105	117	222	finally
      //   162	174	222	finally
      //   179	184	222	finally
      //   186	192	222	finally
      //   39	96	249	java/lang/OutOfMemoryError
      //   105	117	264	java/lang/OutOfMemoryError
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.preview.c
 * JD-Core Version:    0.6.2
 */