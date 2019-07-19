package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v7.a.a.a;
import android.support.v7.appcompat.R.string;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class j
  implements SupportMenuItem
{
  private View A;
  private android.support.v4.view.ActionProvider B;
  private MenuItem.OnActionExpandListener C;
  private boolean D = false;
  private ContextMenu.ContextMenuInfo E;
  h a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private CharSequence f;
  private CharSequence g;
  private Intent h;
  private char i;
  private int j = 4096;
  private char k;
  private int l = 4096;
  private Drawable m;
  private int n = 0;
  private u o;
  private Runnable p;
  private MenuItem.OnMenuItemClickListener q;
  private CharSequence r;
  private CharSequence s;
  private ColorStateList t = null;
  private PorterDuff.Mode u = null;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private int y = 16;
  private int z = 0;

  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.a = paramh;
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramCharSequence;
    this.z = paramInt5;
  }

  private Drawable a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (this.x) && ((this.v) || (this.w)))
    {
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      if (this.v)
        DrawableCompat.setTintList(paramDrawable, this.t);
      if (this.w)
        DrawableCompat.setTintMode(paramDrawable, this.u);
      this.x = false;
    }
    return paramDrawable;
  }

  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2)
      paramStringBuilder.append(paramString);
  }

  public SupportMenuItem a(int paramInt)
  {
    Context localContext = this.a.f();
    a(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }

  public SupportMenuItem a(View paramView)
  {
    this.A = paramView;
    this.B = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.b > 0))
      paramView.setId(this.b);
    this.a.b(this);
    return this;
  }

  CharSequence a(p.a parama)
  {
    if ((parama != null) && (parama.a()))
      return getTitleCondensed();
    return getTitle();
  }

  public void a(u paramu)
  {
    this.o = paramu;
    paramu.setHeaderTitle(getTitle());
  }

  void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.E = paramContextMenuInfo;
  }

  public void a(boolean paramBoolean)
  {
    int i1 = 0xFFFFFFFB & this.y;
    if (paramBoolean);
    for (int i2 = 4; ; i2 = 0)
    {
      this.y = (i2 | i1);
      return;
    }
  }

  public boolean a()
  {
    if ((this.q != null) && (this.q.onMenuItemClick(this)));
    do
    {
      do
        return true;
      while (this.a.a(this.a, this));
      if (this.p != null)
      {
        this.p.run();
        return true;
      }
      if (this.h != null)
        try
        {
          this.a.f().startActivity(this.h);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
    }
    while ((this.B != null) && (this.B.onPerformDefaultAction()));
    return false;
  }

  public int b()
  {
    return this.e;
  }

  public SupportMenuItem b(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }

  void b(boolean paramBoolean)
  {
    int i1 = this.y;
    int i2 = 0xFFFFFFFD & this.y;
    if (paramBoolean);
    for (int i3 = 2; ; i3 = 0)
    {
      this.y = (i3 | i2);
      if (i1 != this.y)
        this.a.a(false);
      return;
    }
  }

  char c()
  {
    if (this.a.c())
      return this.k;
    return this.i;
  }

  boolean c(boolean paramBoolean)
  {
    int i1 = this.y;
    int i2 = 0xFFFFFFF7 & this.y;
    if (paramBoolean);
    for (int i3 = 0; ; i3 = 8)
    {
      this.y = (i3 | i2);
      int i4 = this.y;
      boolean bool = false;
      if (i1 != i4)
        bool = true;
      return bool;
    }
  }

  public boolean collapseActionView()
  {
    if ((0x8 & this.z) == 0);
    do
    {
      return false;
      if (this.A == null)
        return true;
    }
    while ((this.C != null) && (!this.C.onMenuItemActionCollapse(this)));
    return this.a.d(this);
  }

  String d()
  {
    char c1 = c();
    if (c1 == 0)
      return "";
    Resources localResources = this.a.f().getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.a.f()).hasPermanentMenuKey())
      localStringBuilder.append(localResources.getString(R.string.abc_prepend_shortcut_label));
    int i1;
    if (this.a.c())
    {
      i1 = this.l;
      a(localStringBuilder, i1, 65536, localResources.getString(R.string.abc_menu_meta_shortcut_label));
      a(localStringBuilder, i1, 4096, localResources.getString(R.string.abc_menu_ctrl_shortcut_label));
      a(localStringBuilder, i1, 2, localResources.getString(R.string.abc_menu_alt_shortcut_label));
      a(localStringBuilder, i1, 1, localResources.getString(R.string.abc_menu_shift_shortcut_label));
      a(localStringBuilder, i1, 4, localResources.getString(R.string.abc_menu_sym_shortcut_label));
      a(localStringBuilder, i1, 8, localResources.getString(R.string.abc_menu_function_shortcut_label));
      switch (c1)
      {
      default:
        localStringBuilder.append(c1);
      case '\n':
      case '\b':
      case ' ':
      }
    }
    while (true)
    {
      return localStringBuilder.toString();
      i1 = this.j;
      break;
      localStringBuilder.append(localResources.getString(R.string.abc_menu_enter_shortcut_label));
      continue;
      localStringBuilder.append(localResources.getString(R.string.abc_menu_delete_shortcut_label));
      continue;
      localStringBuilder.append(localResources.getString(R.string.abc_menu_space_shortcut_label));
    }
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.y = (0x20 | this.y);
      return;
    }
    this.y = (0xFFFFFFDF & this.y);
  }

  public void e(boolean paramBoolean)
  {
    this.D = paramBoolean;
    this.a.a(false);
  }

  boolean e()
  {
    return (this.a.d()) && (c() != 0);
  }

  public boolean expandActionView()
  {
    if (!m());
    while ((this.C != null) && (!this.C.onMenuItemActionExpand(this)))
      return false;
    return this.a.c(this);
  }

  public boolean f()
  {
    return (0x4 & this.y) != 0;
  }

  public void g()
  {
    this.a.b(this);
  }

  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }

  public View getActionView()
  {
    if (this.A != null)
      return this.A;
    if (this.B != null)
    {
      this.A = this.B.onCreateActionView(this);
      return this.A;
    }
    return null;
  }

  public int getAlphabeticModifiers()
  {
    return this.l;
  }

  public char getAlphabeticShortcut()
  {
    return this.k;
  }

  public CharSequence getContentDescription()
  {
    return this.r;
  }

  public int getGroupId()
  {
    return this.c;
  }

  public Drawable getIcon()
  {
    if (this.m != null)
      return a(this.m);
    if (this.n != 0)
    {
      Drawable localDrawable = a.b(this.a.f(), this.n);
      this.n = 0;
      this.m = localDrawable;
      return a(localDrawable);
    }
    return null;
  }

  public ColorStateList getIconTintList()
  {
    return this.t;
  }

  public PorterDuff.Mode getIconTintMode()
  {
    return this.u;
  }

  public Intent getIntent()
  {
    return this.h;
  }

  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return this.b;
  }

  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.E;
  }

  public int getNumericModifiers()
  {
    return this.j;
  }

  public char getNumericShortcut()
  {
    return this.i;
  }

  public int getOrder()
  {
    return this.d;
  }

  public SubMenu getSubMenu()
  {
    return this.o;
  }

  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return this.B;
  }

  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return this.f;
  }

  public CharSequence getTitleCondensed()
  {
    if (this.g != null);
    for (Object localObject = this.g; ; localObject = this.f)
    {
      if ((Build.VERSION.SDK_INT < 18) && (localObject != null) && (!(localObject instanceof String)))
        localObject = ((CharSequence)localObject).toString();
      return localObject;
    }
  }

  public CharSequence getTooltipText()
  {
    return this.s;
  }

  public boolean h()
  {
    return this.a.r();
  }

  public boolean hasSubMenu()
  {
    return this.o != null;
  }

  public boolean i()
  {
    return (0x20 & this.y) == 32;
  }

  public boolean isActionViewExpanded()
  {
    return this.D;
  }

  public boolean isCheckable()
  {
    return (0x1 & this.y) == 1;
  }

  public boolean isChecked()
  {
    return (0x2 & this.y) == 2;
  }

  public boolean isEnabled()
  {
    return (0x10 & this.y) != 0;
  }

  public boolean isVisible()
  {
    if ((this.B != null) && (this.B.overridesItemVisibility()))
      if (((0x8 & this.y) != 0) || (!this.B.isVisible()));
    while ((0x8 & this.y) == 0)
    {
      return true;
      return false;
    }
    return false;
  }

  public boolean j()
  {
    return (0x1 & this.z) == 1;
  }

  public boolean k()
  {
    return (0x2 & this.z) == 2;
  }

  public boolean l()
  {
    return (0x4 & this.z) == 4;
  }

  public boolean m()
  {
    int i1 = 0x8 & this.z;
    boolean bool = false;
    if (i1 != 0)
    {
      if ((this.A == null) && (this.B != null))
        this.A = this.B.onCreateActionView(this);
      View localView = this.A;
      bool = false;
      if (localView != null)
        bool = true;
    }
    return bool;
  }

  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }

  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.k == paramChar)
      return this;
    this.k = Character.toLowerCase(paramChar);
    this.a.a(false);
    return this;
  }

  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.k == paramChar) && (this.l == paramInt))
      return this;
    this.k = Character.toLowerCase(paramChar);
    this.l = KeyEvent.normalizeMetaState(paramInt);
    this.a.a(false);
    return this;
  }

  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = this.y;
    int i2 = 0xFFFFFFFE & this.y;
    if (paramBoolean);
    for (int i3 = 1; ; i3 = 0)
    {
      this.y = (i3 | i2);
      if (i1 != this.y)
        this.a.a(false);
      return this;
    }
  }

  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((0x4 & this.y) != 0)
    {
      this.a.a(this);
      return this;
    }
    b(paramBoolean);
    return this;
  }

  public SupportMenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    this.a.a(false);
    return this;
  }

  public MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean);
    for (this.y = (0x10 | this.y); ; this.y = (0xFFFFFFEF & this.y))
    {
      this.a.a(false);
      return this;
    }
  }

  public MenuItem setIcon(int paramInt)
  {
    this.m = null;
    this.n = paramInt;
    this.x = true;
    this.a.a(false);
    return this;
  }

  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.n = 0;
    this.m = paramDrawable;
    this.x = true;
    this.a.a(false);
    return this;
  }

  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList;
    this.v = true;
    this.x = true;
    this.a.a(false);
    return this;
  }

  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.u = paramMode;
    this.w = true;
    this.x = true;
    this.a.a(false);
    return this;
  }

  public MenuItem setIntent(Intent paramIntent)
  {
    this.h = paramIntent;
    return this;
  }

  public MenuItem setNumericShortcut(char paramChar)
  {
    if (this.i == paramChar)
      return this;
    this.i = paramChar;
    this.a.a(false);
    return this;
  }

  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.i == paramChar) && (this.j == paramInt))
      return this;
    this.i = paramChar;
    this.j = KeyEvent.normalizeMetaState(paramInt);
    this.a.a(false);
    return this;
  }

  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.C = paramOnActionExpandListener;
    return this;
  }

  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.q = paramOnMenuItemClickListener;
    return this;
  }

  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.i = paramChar1;
    this.k = Character.toLowerCase(paramChar2);
    this.a.a(false);
    return this;
  }

  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.i = paramChar1;
    this.j = KeyEvent.normalizeMetaState(paramInt1);
    this.k = Character.toLowerCase(paramChar2);
    this.l = KeyEvent.normalizeMetaState(paramInt2);
    this.a.a(false);
    return this;
  }

  public void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default:
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    case 0:
    case 1:
    case 2:
    }
    this.z = paramInt;
    this.a.b(this);
  }

  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    if (this.B != null)
      this.B.reset();
    this.A = null;
    this.B = paramActionProvider;
    this.a.a(true);
    if (this.B != null)
      this.B.setVisibilityListener(new ActionProvider.VisibilityListener()
      {
        public void onActionProviderVisibilityChanged(boolean paramAnonymousBoolean)
        {
          j.this.a.a(j.this);
        }
      });
    return this;
  }

  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.a.f().getString(paramInt));
  }

  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    this.a.a(false);
    if (this.o != null)
      this.o.setHeaderTitle(paramCharSequence);
    return this;
  }

  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
    if (paramCharSequence == null);
    this.a.a(false);
    return this;
  }

  public SupportMenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    this.a.a(false);
    return this;
  }

  public MenuItem setVisible(boolean paramBoolean)
  {
    if (c(paramBoolean))
      this.a.a(this);
    return this;
  }

  public String toString()
  {
    if (this.f != null)
      return this.f.toString();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.6.2
 */