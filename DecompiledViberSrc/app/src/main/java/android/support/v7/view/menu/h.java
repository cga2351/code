package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements SupportMenu
{
  private static final int[] d = { 1, 4, 5, 3, 2, 0 };
  private boolean A;
  CharSequence a;
  Drawable b;
  View c;
  private final Context e;
  private final Resources f;
  private boolean g;
  private boolean h;
  private a i;
  private ArrayList<j> j;
  private ArrayList<j> k;
  private boolean l;
  private ArrayList<j> m;
  private ArrayList<j> n;
  private boolean o;
  private int p = 0;
  private ContextMenu.ContextMenuInfo q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private ArrayList<j> w = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList();
  private j y;
  private boolean z = false;

  public h(Context paramContext)
  {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = true;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = true;
    e(true);
  }

  private static int a(ArrayList<j> paramArrayList, int paramInt)
  {
    for (int i1 = -1 + paramArrayList.size(); i1 >= 0; i1--)
      if (((j)paramArrayList.get(i1)).b() <= paramInt)
        return i1 + 1;
    return 0;
  }

  private j a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new j(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }

  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = e();
    if (paramView != null)
    {
      this.c = paramView;
      this.a = null;
      this.b = null;
      a(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.a = localResources.getText(paramInt1);
      label47: if (paramInt2 <= 0)
        break label83;
      this.b = ContextCompat.getDrawable(f(), paramInt2);
    }
    while (true)
    {
      this.c = null;
      break;
      if (paramCharSequence == null)
        break label47;
      this.a = paramCharSequence;
      break label47;
      label83: if (paramDrawable != null)
        this.b = paramDrawable;
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.j.size()));
    do
    {
      return;
      this.j.remove(paramInt);
    }
    while (!paramBoolean);
    a(true);
  }

  private boolean a(u paramu, o paramo)
  {
    if (this.x.isEmpty())
      return false;
    boolean bool1 = false;
    if (paramo != null)
      bool1 = paramo.onSubMenuSelected(paramu);
    Iterator localIterator = this.x.iterator();
    boolean bool2 = bool1;
    o localo;
    boolean bool3;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.x.remove(localWeakReference);
        bool3 = bool2;
      }
    }
    while (true)
    {
      bool2 = bool3;
      break;
      if (!bool2)
      {
        bool3 = localo.onSubMenuSelected(paramu);
        continue;
        return bool2;
      }
      else
      {
        bool3 = bool2;
      }
    }
  }

  private void d(boolean paramBoolean)
  {
    if (this.x.isEmpty())
      return;
    h();
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
        this.x.remove(localWeakReference);
      else
        localo.updateMenuView(paramBoolean);
    }
    i();
  }

  private void e(Bundle paramBundle)
  {
    if (this.x.isEmpty())
      return;
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.x.remove(localWeakReference);
      }
      else
      {
        int i1 = localo.getId();
        if (i1 > 0)
        {
          Parcelable localParcelable = localo.onSaveInstanceState();
          if (localParcelable != null)
            localSparseArray.put(i1, localParcelable);
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }

  private void e(boolean paramBoolean)
  {
    int i1 = 1;
    if ((paramBoolean) && (this.f.getConfiguration().keyboard != i1) && (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.e), this.e)));
    while (true)
    {
      this.h = i1;
      return;
      i1 = 0;
    }
  }

  private static int f(int paramInt)
  {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if ((i1 < 0) || (i1 >= d.length))
      throw new IllegalArgumentException("order does not contain a valid category.");
    return d[i1] << 16 | 0xFFFF & paramInt;
  }

  private void f(Bundle paramBundle)
  {
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((localSparseArray == null) || (this.x.isEmpty()));
    while (true)
    {
      return;
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.x.remove(localWeakReference);
        }
        else
        {
          int i1 = localo.getId();
          if (i1 > 0)
          {
            Parcelable localParcelable = (Parcelable)localSparseArray.get(i1);
            if (localParcelable != null)
              localo.onRestoreInstanceState(localParcelable);
          }
        }
      }
    }
  }

  public int a(int paramInt1, int paramInt2)
  {
    int i1 = size();
    if (paramInt2 < 0)
      paramInt2 = 0;
    for (int i2 = paramInt2; i2 < i1; i2++)
      if (((j)this.j.get(i2)).getGroupId() == paramInt1)
        return i2;
    return -1;
  }

  public h a(int paramInt)
  {
    this.p = paramInt;
    return this;
  }

  protected h a(Drawable paramDrawable)
  {
    a(0, null, 0, paramDrawable, null);
    return this;
  }

  protected h a(View paramView)
  {
    a(0, null, 0, null, paramView);
    return this;
  }

  protected h a(CharSequence paramCharSequence)
  {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }

  j a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.w;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    j localj;
    if (localArrayList.isEmpty())
      localj = null;
    label181: 
    while (true)
    {
      return localj;
      int i1 = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int i2 = localArrayList.size();
      if (i2 == 1)
        return (j)localArrayList.get(0);
      boolean bool = c();
      int i3 = 0;
      if (i3 >= i2)
        break;
      localj = (j)localArrayList.get(i3);
      if (bool);
      for (int i4 = localj.getAlphabeticShortcut(); ; i4 = localj.getNumericShortcut())
      {
        if (((i4 == localKeyData.meta[0]) && ((i1 & 0x2) == 0)) || ((i4 == localKeyData.meta[2]) && ((i1 & 0x2) != 0)) || ((bool) && (i4 == 8) && (paramInt == 67)))
          break label181;
        i3++;
        break;
      }
    }
    return null;
  }

  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = f(paramInt3);
    j localj = a(paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.p);
    if (this.q != null)
      localj.a(this.q);
    this.j.add(a(this.j, i1), localj);
    a(true);
    return localj;
  }

  protected String a()
  {
    return "android:menu:actionviewstates";
  }

  public void a(Bundle paramBundle)
  {
    e(paramBundle);
  }

  public void a(a parama)
  {
    this.i = parama;
  }

  void a(j paramj)
  {
    this.l = true;
    a(true);
  }

  public void a(o paramo)
  {
    a(paramo, this.e);
  }

  public void a(o paramo, Context paramContext)
  {
    this.x.add(new WeakReference(paramo));
    paramo.initForMenu(paramContext, this);
    this.o = true;
  }

  void a(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getGroupId();
    int i2 = this.j.size();
    h();
    int i3 = 0;
    if (i3 < i2)
    {
      j localj = (j)this.j.get(i3);
      if ((localj.getGroupId() != i1) || (!localj.f()));
      while (!localj.isCheckable())
      {
        i3++;
        break;
      }
      if (localj == paramMenuItem);
      for (boolean bool = true; ; bool = false)
      {
        localj.b(bool);
        break;
      }
    }
    i();
  }

  void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = c();
    int i1 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67))
      return;
    int i2 = this.j.size();
    int i3 = 0;
    label49: j localj;
    int i4;
    label104: int i5;
    if (i3 < i2)
    {
      localj = (j)this.j.get(i3);
      if (localj.hasSubMenu())
        ((h)localj.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      if (!bool)
        break label209;
      i4 = localj.getAlphabeticShortcut();
      if (!bool)
        break label219;
      i5 = localj.getAlphabeticModifiers();
      label116: if ((i1 & 0x1100F) != (i5 & 0x1100F))
        break label229;
    }
    label209: label219: label229: for (int i6 = 1; ; i6 = 0)
    {
      if ((i6 != 0) && (i4 != 0) && ((i4 == localKeyData.meta[0]) || (i4 == localKeyData.meta[2]) || ((bool) && (i4 == 8) && (paramInt == 67))) && (localj.isEnabled()))
        paramList.add(localj);
      i3++;
      break label49;
      break;
      i4 = localj.getNumericShortcut();
      break label104;
      i5 = localj.getNumericModifiers();
      break label116;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (!this.r)
    {
      if (paramBoolean)
      {
        this.l = true;
        this.o = true;
      }
      d(paramBoolean);
    }
    do
    {
      return;
      this.s = true;
    }
    while (!paramBoolean);
    this.t = true;
  }

  boolean a(h paramh, MenuItem paramMenuItem)
  {
    return (this.i != null) && (this.i.onMenuItemSelected(paramh, paramMenuItem));
  }

  public boolean a(MenuItem paramMenuItem, int paramInt)
  {
    return a(paramMenuItem, null, paramInt);
  }

  public boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    j localj = (j)paramMenuItem;
    boolean bool1 = false;
    if (localj != null)
    {
      boolean bool2 = localj.isEnabled();
      bool1 = false;
      if (bool2)
        break label32;
    }
    label32: boolean bool3;
    label99: 
    do
    {
      return bool1;
      bool3 = localj.a();
      ActionProvider localActionProvider = localj.getSupportActionProvider();
      if ((localActionProvider != null) && (localActionProvider.hasSubMenu()));
      for (int i1 = 1; ; i1 = 0)
      {
        if (!localj.m())
          break label99;
        bool1 = bool3 | localj.expandActionView();
        if (!bool1)
          break;
        b(true);
        return bool1;
      }
      if ((!localj.hasSubMenu()) && (i1 == 0))
        break;
      if ((paramInt & 0x4) == 0)
        b(false);
      if (!localj.hasSubMenu())
        localj.a(new u(f(), this, localj));
      u localu = (u)localj.getSubMenu();
      if (i1 != 0)
        localActionProvider.onPrepareSubMenu(localu);
      bool1 = bool3 | a(localu, paramo);
    }
    while (bool1);
    b(true);
    return bool1;
    if ((paramInt & 0x1) == 0)
      b(true);
    return bool3;
  }

  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.f.getString(paramInt));
  }

  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }

  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }

  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }

  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.e.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    int i2;
    label52: ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i1 = localList.size();
      if ((paramInt4 & 0x1) == 0)
        removeGroup(paramInt1);
      i2 = 0;
      if (i2 >= i1)
        break label211;
      localResolveInfo = (ResolveInfo)localList.get(i2);
      if (localResolveInfo.specificIndex >= 0)
        break label198;
    }
    label198: for (Intent localIntent1 = paramIntent; ; localIntent1 = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      Intent localIntent2 = new Intent(localIntent1);
      localIntent2.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      MenuItem localMenuItem = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(localIntent2);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0))
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = localMenuItem;
      i2++;
      break label52;
      i1 = 0;
      break;
    }
    label211: return i1;
  }

  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.f.getString(paramInt));
  }

  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }

  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    j localj = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    u localu = new u(this.e, this, localj);
    localj.a(localu);
    return localu;
  }

  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }

  public int b(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
      if (((j)this.j.get(i2)).getItemId() == paramInt)
        return i2;
    return -1;
  }

  public void b(Bundle paramBundle)
  {
    f(paramBundle);
  }

  void b(j paramj)
  {
    this.o = true;
    a(true);
  }

  public void b(o paramo)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo))
        this.x.remove(localWeakReference);
    }
  }

  public final void b(boolean paramBoolean)
  {
    if (this.v)
      return;
    this.v = true;
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
        this.x.remove(localWeakReference);
      else
        localo.onCloseMenu(this, paramBoolean);
    }
    this.v = false;
  }

  public boolean b()
  {
    return this.z;
  }

  public int c(int paramInt)
  {
    return a(paramInt, 0);
  }

  public void c(Bundle paramBundle)
  {
    int i1 = size();
    int i2 = 0;
    Object localObject2;
    for (Object localObject1 = null; i2 < i1; localObject1 = localObject2)
    {
      MenuItem localMenuItem = getItem(i2);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1))
      {
        if (localObject1 == null)
          localObject1 = new SparseArray();
        localView.saveHierarchyState((SparseArray)localObject1);
        if (localMenuItem.isActionViewExpanded())
          paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
      }
      localObject2 = localObject1;
      if (localMenuItem.hasSubMenu())
        ((u)localMenuItem.getSubMenu()).c(paramBundle);
      i2++;
    }
    if (localObject1 != null)
      paramBundle.putSparseParcelableArray(a(), (SparseArray)localObject1);
  }

  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  boolean c()
  {
    return this.g;
  }

  public boolean c(j paramj)
  {
    boolean bool1 = this.x.isEmpty();
    boolean bool2 = false;
    if (bool1)
      return bool2;
    h();
    Iterator localIterator = this.x.iterator();
    boolean bool3 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.x.remove(localWeakReference);
        bool2 = bool3;
      }
      do
      {
        bool3 = bool2;
        break;
        bool2 = localo.expandItemActionView(this, paramj);
      }
      while (!bool2);
    }
    while (true)
    {
      i();
      if (!bool2)
        break;
      this.y = paramj;
      return bool2;
      bool2 = bool3;
    }
  }

  public void clear()
  {
    if (this.y != null)
      d(this.y);
    this.j.clear();
    a(true);
  }

  public void clearHeader()
  {
    this.b = null;
    this.a = null;
    this.c = null;
    a(false);
  }

  public void close()
  {
    b(true);
  }

  protected h d(int paramInt)
  {
    a(paramInt, null, 0, null, null);
    return this;
  }

  public void d(Bundle paramBundle)
  {
    if (paramBundle == null);
    MenuItem localMenuItem1;
    do
    {
      int i3;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
        int i1 = size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          MenuItem localMenuItem2 = getItem(i2);
          View localView = localMenuItem2.getActionView();
          if ((localView != null) && (localView.getId() != -1))
            localView.restoreHierarchyState(localSparseArray);
          if (localMenuItem2.hasSubMenu())
            ((u)localMenuItem2.getSubMenu()).d(paramBundle);
        }
        i3 = paramBundle.getInt("android:menu:expandedactionview");
      }
      while (i3 <= 0);
      localMenuItem1 = findItem(i3);
    }
    while (localMenuItem1 == null);
    localMenuItem1.expandActionView();
  }

  public boolean d()
  {
    return this.h;
  }

  public boolean d(j paramj)
  {
    boolean bool1 = this.x.isEmpty();
    boolean bool2 = false;
    if (!bool1)
    {
      j localj = this.y;
      bool2 = false;
      if (localj == paramj);
    }
    else
    {
      return bool2;
    }
    h();
    Iterator localIterator = this.x.iterator();
    boolean bool3 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.x.remove(localWeakReference);
        bool2 = bool3;
      }
      do
      {
        bool3 = bool2;
        break;
        bool2 = localo.collapseItemActionView(this, paramj);
      }
      while (!bool2);
    }
    while (true)
    {
      i();
      if (!bool2)
        break;
      this.y = null;
      return bool2;
      bool2 = bool3;
    }
  }

  Resources e()
  {
    return this.f;
  }

  protected h e(int paramInt)
  {
    a(0, null, paramInt, null, null);
    return this;
  }

  public Context f()
  {
    return this.e;
  }

  public MenuItem findItem(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      Object localObject = (j)this.j.get(i2);
      if (((j)localObject).getItemId() == paramInt);
      do
      {
        return localObject;
        if (!((j)localObject).hasSubMenu())
          break;
        localObject = ((j)localObject).getSubMenu().findItem(paramInt);
      }
      while (localObject != null);
    }
    return null;
  }

  public void g()
  {
    if (this.i != null)
      this.i.onMenuModeChange(this);
  }

  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.j.get(paramInt);
  }

  public void h()
  {
    if (!this.r)
    {
      this.r = true;
      this.s = false;
      this.t = false;
    }
  }

  public boolean hasVisibleItems()
  {
    if (this.A)
      return true;
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
      if (((j)this.j.get(i2)).isVisible())
        return true;
    return false;
  }

  public void i()
  {
    this.r = false;
    if (this.s)
    {
      this.s = false;
      a(this.t);
    }
  }

  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }

  public ArrayList<j> j()
  {
    if (!this.l)
      return this.k;
    this.k.clear();
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)this.j.get(i2);
      if (localj.isVisible())
        this.k.add(localj);
    }
    this.l = false;
    this.o = true;
    return this.k;
  }

  public void k()
  {
    ArrayList localArrayList = j();
    if (!this.o)
      return;
    Iterator localIterator = this.x.iterator();
    boolean bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
        this.x.remove(localWeakReference);
      for (boolean bool2 = bool1; ; bool2 = bool1 | localo.flagActionItems())
      {
        bool1 = bool2;
        break;
      }
    }
    if (bool1)
    {
      this.m.clear();
      this.n.clear();
      int i1 = localArrayList.size();
      int i2 = 0;
      if (i2 < i1)
      {
        j localj = (j)localArrayList.get(i2);
        if (localj.i())
          this.m.add(localj);
        while (true)
        {
          i2++;
          break;
          this.n.add(localj);
        }
      }
    }
    else
    {
      this.m.clear();
      this.n.clear();
      this.n.addAll(j());
    }
    this.o = false;
  }

  public ArrayList<j> l()
  {
    k();
    return this.m;
  }

  public ArrayList<j> m()
  {
    k();
    return this.n;
  }

  public CharSequence n()
  {
    return this.a;
  }

  public Drawable o()
  {
    return this.b;
  }

  public View p()
  {
    return this.c;
  }

  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), paramInt2);
  }

  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    j localj = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (localj != null)
      bool = a(localj, paramInt2);
    if ((paramInt2 & 0x2) != 0)
      b(true);
    return bool;
  }

  public h q()
  {
    return this;
  }

  boolean r()
  {
    return this.u;
  }

  public void removeGroup(int paramInt)
  {
    int i1 = c(paramInt);
    if (i1 >= 0)
    {
      int i2 = this.j.size() - i1;
      int i4;
      for (int i3 = 0; ; i3 = i4)
      {
        i4 = i3 + 1;
        if ((i3 >= i2) || (((j)this.j.get(i1)).getGroupId() != paramInt))
          break;
        a(i1, false);
      }
      a(true);
    }
  }

  public void removeItem(int paramInt)
  {
    a(b(paramInt), true);
  }

  public j s()
  {
    return this.y;
  }

  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)this.j.get(i2);
      if (localj.getGroupId() == paramInt)
      {
        localj.a(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
    }
  }

  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)this.j.get(i2);
      if (localj.getGroupId() == paramInt)
        localj.setEnabled(paramBoolean);
    }
  }

  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i1 = this.j.size();
    int i2 = 0;
    int i3 = 0;
    if (i2 < i1)
    {
      j localj = (j)this.j.get(i2);
      if ((localj.getGroupId() != paramInt) || (!localj.c(paramBoolean)))
        break label76;
    }
    label76: for (int i4 = 1; ; i4 = i3)
    {
      i2++;
      i3 = i4;
      break;
      if (i3 != 0)
        a(true);
      return;
    }
  }

  public void setQwertyMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
    a(false);
  }

  public int size()
  {
    return this.j.size();
  }

  public static abstract interface a
  {
    public abstract boolean onMenuItemSelected(h paramh, MenuItem paramMenuItem);

    public abstract void onMenuModeChange(h paramh);
  }

  public static abstract interface b
  {
    public abstract boolean invokeItem(j paramj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.h
 * JD-Core Version:    0.6.2
 */