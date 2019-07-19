package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater
{
  static final Class<?>[] a = { Context.class };
  static final Class<?>[] b = a;
  final Object[] c;
  final Object[] d;
  Context e;
  private Object f;

  public g(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }

  private Object a(Object paramObject)
  {
    if ((paramObject instanceof Activity));
    while (!(paramObject instanceof ContextWrapper))
      return paramObject;
    return a(((ContextWrapper)paramObject).getBaseContext());
  }

  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    String str3;
    label51: Object localObject;
    int j;
    int k;
    int m;
    if (i == 2)
    {
      str3 = paramXmlPullParser.getName();
      if (str3.equals("menu"))
      {
        i = paramXmlPullParser.next();
        localObject = null;
        j = 0;
        k = i;
        m = 0;
        label64: if (m != 0)
          return;
      }
    }
    label96: int n;
    switch (k)
    {
    default:
      n = j;
    case 2:
    case 3:
      while (true)
      {
        int i1 = paramXmlPullParser.next();
        int i2 = n;
        k = i1;
        j = i2;
        break label64;
        throw new RuntimeException("Expecting menu, got " + str3);
        i = paramXmlPullParser.next();
        if (i != 1)
          break;
        break label51;
        if (j != 0)
        {
          n = j;
        }
        else
        {
          String str2 = paramXmlPullParser.getName();
          if (str2.equals("group"))
          {
            localb.a(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("item"))
          {
            localb.b(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.c());
            n = j;
          }
          else
          {
            localObject = str2;
            n = 1;
            continue;
            String str1 = paramXmlPullParser.getName();
            if ((j != 0) && (str1.equals(localObject)))
            {
              localObject = null;
              n = 0;
            }
            else if (str1.equals("group"))
            {
              localb.a();
              n = j;
            }
            else
            {
              if (str1.equals("item"))
              {
                if (localb.d())
                  break label96;
                if ((localb.a != null) && (localb.a.hasSubMenu()))
                {
                  localb.c();
                  n = j;
                  continue;
                }
                localb.b();
                n = j;
                continue;
              }
              if (!str1.equals("menu"))
                break label96;
              m = 1;
              n = j;
            }
          }
        }
      }
    case 1:
    }
    throw new RuntimeException("Unexpected end of document");
  }

  Object a()
  {
    if (this.f == null)
      this.f = a(this.e);
    return this.f;
  }

  // ERROR //
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 135
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 137	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 31	android/support/v7/view/g:e	Landroid/content/Context;
    //   20: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload_1
    //   24: invokevirtual 147	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   27: astore_3
    //   28: aload_0
    //   29: aload_3
    //   30: aload_3
    //   31: invokestatic 153	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   34: aload_2
    //   35: invokespecial 111	android/support/v7/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   38: aload_3
    //   39: ifnull -26 -> 13
    //   42: aload_3
    //   43: invokeinterface 158 1 0
    //   48: return
    //   49: astore 6
    //   51: new 160	android/view/InflateException
    //   54: dup
    //   55: ldc 162
    //   57: aload 6
    //   59: invokespecial 165	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore 5
    //   65: aload_3
    //   66: ifnull +9 -> 75
    //   69: aload_3
    //   70: invokeinterface 158 1 0
    //   75: aload 5
    //   77: athrow
    //   78: astore 4
    //   80: new 160	android/view/InflateException
    //   83: dup
    //   84: ldc 162
    //   86: aload 4
    //   88: invokespecial 165	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	38	49	org/xmlpull/v1/XmlPullParserException
    //   16	38	63	finally
    //   51	63	63	finally
    //   80	92	63	finally
    //   16	38	78	java/io/IOException
  }

  private static class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] a = { MenuItem.class };
    private Object b;
    private Method c;

    public a(Object paramObject, String paramString)
    {
      this.b = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.c = localClass.getMethod(paramString, a);
        return;
      }
      catch (Exception localException)
      {
        InflateException localInflateException = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        localInflateException.initCause(localException);
        throw localInflateException;
      }
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.c.getReturnType() == Boolean.TYPE)
          return ((Boolean)this.c.invoke(this.b, new Object[] { paramMenuItem })).booleanValue();
        this.c.invoke(this.b, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
  }

  private class b
  {
    private String A;
    private String B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E = null;
    private PorterDuff.Mode F = null;
    ActionProvider a;
    private Menu c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private CharSequence m;
    private CharSequence n;
    private int o;
    private char p;
    private int q;
    private char r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private String z;

    public b(Menu arg2)
    {
      Object localObject;
      this.c = localObject;
      a();
    }

    private char a(String paramString)
    {
      if (paramString == null)
        return '\000';
      return paramString.charAt(0);
    }

    private <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        Constructor localConstructor = g.this.e.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        localConstructor.setAccessible(true);
        Object localObject = localConstructor.newInstance(paramArrayOfObject);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, localException);
      }
      return null;
    }

    private void a(MenuItem paramMenuItem)
    {
      int i1 = 1;
      MenuItem localMenuItem = paramMenuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
      if (this.t >= i1);
      int i4;
      for (int i3 = i1; ; i4 = 0)
      {
        localMenuItem.setCheckable(i3).setTitleCondensed(this.n).setIcon(this.o);
        if (this.x >= 0)
          paramMenuItem.setShowAsAction(this.x);
        if (this.B == null)
          break label147;
        if (!g.this.e.isRestricted())
          break;
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(g.this.a(), this.B));
      label147: if ((paramMenuItem instanceof j))
        ((j)paramMenuItem);
      if (this.t >= 2)
      {
        if ((paramMenuItem instanceof j))
          ((j)paramMenuItem).a(i1);
      }
      else
      {
        if (this.z == null)
          break label356;
        paramMenuItem.setActionView((View)a(this.z, g.a, g.this.c));
      }
      while (true)
      {
        if (this.y > 0)
        {
          if (i1 != 0)
            break label344;
          paramMenuItem.setActionView(this.y);
        }
        while (true)
        {
          if (this.a != null)
            MenuItemCompat.setActionProvider(paramMenuItem, this.a);
          MenuItemCompat.setContentDescription(paramMenuItem, this.C);
          MenuItemCompat.setTooltipText(paramMenuItem, this.D);
          MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.p, this.q);
          MenuItemCompat.setNumericShortcut(paramMenuItem, this.r, this.s);
          if (this.F != null)
            MenuItemCompat.setIconTintMode(paramMenuItem, this.F);
          if (this.E != null)
            MenuItemCompat.setIconTintList(paramMenuItem, this.E);
          return;
          if (!(paramMenuItem instanceof k))
            break;
          ((k)paramMenuItem).a(i1);
          break;
          label344: Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
        label356: int i2 = 0;
      }
    }

    public void a()
    {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = true;
      this.i = true;
    }

    public void a(AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = g.this.e.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
      this.d = localTypedArray.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.e = localTypedArray.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.f = localTypedArray.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.g = localTypedArray.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.h = localTypedArray.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.i = localTypedArray.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      localTypedArray.recycle();
    }

    public void b()
    {
      this.j = true;
      a(this.c.add(this.d, this.k, this.l, this.m));
    }

    public void b(AttributeSet paramAttributeSet)
    {
      int i1 = 1;
      TypedArray localTypedArray = g.this.e.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
      this.k = localTypedArray.getResourceId(R.styleable.MenuItem_android_id, 0);
      int i2 = localTypedArray.getInt(R.styleable.MenuItem_android_menuCategory, this.e);
      int i3 = localTypedArray.getInt(R.styleable.MenuItem_android_orderInCategory, this.f);
      this.l = (i2 & 0xFFFF0000 | i3 & 0xFFFF);
      this.m = localTypedArray.getText(R.styleable.MenuItem_android_title);
      this.n = localTypedArray.getText(R.styleable.MenuItem_android_titleCondensed);
      this.o = localTypedArray.getResourceId(R.styleable.MenuItem_android_icon, 0);
      this.p = a(localTypedArray.getString(R.styleable.MenuItem_android_alphabeticShortcut));
      this.q = localTypedArray.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
      this.r = a(localTypedArray.getString(R.styleable.MenuItem_android_numericShortcut));
      this.s = localTypedArray.getInt(R.styleable.MenuItem_numericModifiers, 4096);
      int i4;
      if (localTypedArray.hasValue(R.styleable.MenuItem_android_checkable))
        if (localTypedArray.getBoolean(R.styleable.MenuItem_android_checkable, false))
        {
          i4 = i1;
          this.t = i4;
          label194: this.u = localTypedArray.getBoolean(R.styleable.MenuItem_android_checked, false);
          this.v = localTypedArray.getBoolean(R.styleable.MenuItem_android_visible, this.h);
          this.w = localTypedArray.getBoolean(R.styleable.MenuItem_android_enabled, this.i);
          this.x = localTypedArray.getInt(R.styleable.MenuItem_showAsAction, -1);
          this.B = localTypedArray.getString(R.styleable.MenuItem_android_onClick);
          this.y = localTypedArray.getResourceId(R.styleable.MenuItem_actionLayout, 0);
          this.z = localTypedArray.getString(R.styleable.MenuItem_actionViewClass);
          this.A = localTypedArray.getString(R.styleable.MenuItem_actionProviderClass);
          if (this.A == null)
            break label442;
          label300: if ((i1 == 0) || (this.y != 0) || (this.z != null))
            break label447;
          this.a = ((ActionProvider)a(this.A, g.b, g.this.d));
          label343: this.C = localTypedArray.getText(R.styleable.MenuItem_contentDescription);
          this.D = localTypedArray.getText(R.styleable.MenuItem_tooltipText);
          if (!localTypedArray.hasValue(R.styleable.MenuItem_iconTintMode))
            break label468;
          this.F = DrawableUtils.parseTintMode(localTypedArray.getInt(R.styleable.MenuItem_iconTintMode, -1), this.F);
          label394: if (!localTypedArray.hasValue(R.styleable.MenuItem_iconTint))
            break label476;
        }
      label442: label447: label468: label476: for (this.E = localTypedArray.getColorStateList(R.styleable.MenuItem_iconTint); ; this.E = null)
      {
        localTypedArray.recycle();
        this.j = false;
        return;
        i4 = 0;
        break;
        this.t = this.g;
        break label194;
        i1 = 0;
        break label300;
        if (i1 != 0)
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        this.a = null;
        break label343;
        this.F = null;
        break label394;
      }
    }

    public SubMenu c()
    {
      this.j = true;
      SubMenu localSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
      a(localSubMenu.getItem());
      return localSubMenu;
    }

    public boolean d()
    {
      return this.j;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.g
 * JD-Core Version:    0.6.2
 */