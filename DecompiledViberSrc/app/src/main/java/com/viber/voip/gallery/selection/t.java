package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class t extends Fragment
{
  private ViewPager a;
  private a b;
  private boolean c;

  public static t a(boolean paramBoolean)
  {
    t localt = new t();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("enable_filters", paramBoolean);
    localt.setArguments(localBundle);
    return localt;
  }

  public void a()
  {
    this.c = true;
    if (this.b != null)
      this.b.a(true);
  }

  public void a(TabLayout paramTabLayout)
  {
    if ((this.b != null) && (this.b.getCount() > 1))
    {
      paramTabLayout.setVisibility(0);
      paramTabLayout.setupWithViewPager(this.a);
      return;
    }
    paramTabLayout.setVisibility(8);
  }

  public void a(GalleryFilter paramGalleryFilter, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b == null)
      return;
    this.b.a(paramGalleryFilter, paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    this.c = false;
    if (this.b != null)
      this.b.a(false);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_gallery_tabbed_albums, paramViewGroup, false);
    Bundle localBundle = getArguments();
    int i;
    Context localContext2;
    FragmentManager localFragmentManager2;
    GalleryFilter[] arrayOfGalleryFilter2;
    if ((localBundle != null) && (localBundle.getBoolean("enable_filters")))
    {
      i = 1;
      this.a = ((ViewPager)localView.findViewById(R.id.albums_filter));
      if (i == 0)
        break label135;
      localContext2 = getContext();
      localFragmentManager2 = getChildFragmentManager();
      arrayOfGalleryFilter2 = new GalleryFilter[2];
      arrayOfGalleryFilter2[0] = GalleryFilter.IMAGE;
      arrayOfGalleryFilter2[1] = GalleryFilter.VIDEO;
    }
    label135: Context localContext1;
    FragmentManager localFragmentManager1;
    GalleryFilter[] arrayOfGalleryFilter1;
    for (this.b = new a(localContext2, localFragmentManager2, arrayOfGalleryFilter2); ; this.b = new a(localContext1, localFragmentManager1, arrayOfGalleryFilter1))
    {
      this.b.a(this.c);
      this.a.setAdapter(this.b);
      return localView;
      i = 0;
      break;
      localContext1 = getContext();
      localFragmentManager1 = getChildFragmentManager();
      arrayOfGalleryFilter1 = new GalleryFilter[1];
      arrayOfGalleryFilter1[0] = GalleryFilter.IMAGE;
    }
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new u(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new v(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  private static class a extends FragmentStatePagerAdapter
  {
    private final c[] a;
    private final boolean[] b;
    private final Context c;
    private GalleryFilter[] d;
    private boolean e;

    public a(Context paramContext, FragmentManager paramFragmentManager, GalleryFilter[] paramArrayOfGalleryFilter)
    {
      super();
      this.c = paramContext;
      this.d = paramArrayOfGalleryFilter;
      this.a = new c[paramArrayOfGalleryFilter.length];
      this.b = new boolean[paramArrayOfGalleryFilter.length];
    }

    void a(GalleryFilter paramGalleryFilter, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramGalleryFilter.ordinal() >= getCount())
        return;
      boolean[] arrayOfBoolean = this.b;
      int i = paramGalleryFilter.ordinal();
      if (!paramBoolean1);
      for (int j = 1; ; j = 0)
      {
        arrayOfBoolean[i] = j;
        c localc = this.a[paramGalleryFilter.ordinal()];
        if (localc == null)
          break;
        localc.a(paramBoolean1, paramBoolean2);
        return;
      }
    }

    void a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      c[] arrayOfc = this.a;
      int i = arrayOfc.length;
      int j = 0;
      if (j < i)
      {
        c localc = arrayOfc[j];
        if (localc == null);
        while (true)
        {
          j++;
          break;
          if (paramBoolean)
            localc.a();
          else
            localc.b();
        }
      }
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      this.a[paramInt] = null;
      super.destroyItem(paramViewGroup, paramInt, paramObject);
    }

    public int getCount()
    {
      return this.d.length;
    }

    public Fragment getItem(int paramInt)
    {
      return c.a(this.d[paramInt]);
    }

    public CharSequence getPageTitle(int paramInt)
    {
      return this.d[paramInt].getLabel(this.c);
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      c localc = (c)super.instantiateItem(paramViewGroup, paramInt);
      if (this.e)
      {
        localc.a();
        if (this.b[paramInt] != 0)
          break label56;
      }
      label56: for (boolean bool = true; ; bool = false)
      {
        localc.a(bool, false);
        this.a[paramInt] = localc;
        return localc;
        localc.b();
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.t
 * JD-Core Version:    0.6.2
 */