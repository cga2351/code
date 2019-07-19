package com.viber.voip.gallery.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberEnv;
import com.viber.voip.an;
import com.viber.voip.an.c;
import com.viber.voip.an.d;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.extras.image.a.a;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.aq;
import com.viber.voip.util.ViberActionRunner.x;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f extends aq
  implements ViewPager.OnPageChangeListener, com.viber.voip.gallery.a.a, com.viber.voip.gallery.a.b
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private int c = -1;
  private boolean d;
  private Context e;
  private d f;
  private MenuItem g;
  private ViewPagerWithPagingEnable h;
  private ConversationData i;
  private Bundle j;
  private ArrayList<GalleryItem> k;
  private Map<Uri, SendMediaDataContainer> l = new HashMap();
  private c m;
  private com.viber.common.permission.b n;
  private e o;
  private an p;
  private an.d q;
  private View.OnClickListener r;
  private int s;
  private a.a t;

  public f()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(113);
    this.n = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        f.a(f.this);
      }
    };
    this.q = new an.d()
    {
      public void a(int paramAnonymousInt, Uri paramAnonymousUri)
      {
      }

      public void a(int paramAnonymousInt, an.c paramAnonymousc)
      {
        if (f.b(f.this) != null)
          f.b(f.this).a(paramAnonymousInt, paramAnonymousc);
      }

      public void b(int paramAnonymousInt, an.c paramAnonymousc)
      {
        if (f.b(f.this) != null)
          f.b(f.this).a(paramAnonymousInt, paramAnonymousc);
      }
    };
    this.r = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        f.c(f.this);
      }
    };
  }

  public static f a(ConversationData paramConversationData, Bundle paramBundle)
  {
    f localf = new f();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_conversation_data", paramConversationData);
    localBundle.putParcelable("options", paramBundle);
    localf.setArguments(localBundle);
    return localf;
  }

  private void a(int paramInt)
  {
    if (this.o != null)
      this.o.b(paramInt);
  }

  private void a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    this.b = paramBundle.getInt("current_position");
  }

  private void b(int paramInt)
  {
    if (this.o != null)
      this.o.c(paramInt);
  }

  private void b(ArrayList<GalleryItem> paramArrayList)
  {
    if (paramArrayList == null)
      paramArrayList = new ArrayList();
    this.k = paramArrayList;
    this.f = new d(this.e, this.k, this.h);
    this.f.a(this.p);
    com.viber.voip.gallery.a.d locald = new com.viber.voip.gallery.a.d(this.f, this.h, getLayoutInflater());
    locald.a(true);
    locald.a(10);
    locald.a(this);
    locald.a(this);
    locald.a(this);
    locald.a(this.r);
    this.h.setAdapter(locald);
    this.h.setCurrentItem(this.b, false);
    if (this.b < paramArrayList.size())
      this.f.a(this.b);
    f();
  }

  private void c()
  {
    dj.d(getActivity());
    com.viber.voip.messages.extras.image.a.a().b(this.s);
    this.s = 0;
    if (this.t != null)
      com.viber.voip.messages.extras.image.a.a().b(this.t);
    g();
  }

  private void d()
  {
    com.viber.voip.messages.extras.image.a.a().a(this.s);
    if (this.t != null)
      com.viber.voip.messages.extras.image.a.a().b(this.t);
    e();
  }

  private void e()
  {
    Iterator localIterator = this.l.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      at.d(this.e, ((SendMediaDataContainer)localEntry.getValue()).croppedImage);
      at.d(this.e, ((SendMediaDataContainer)localEntry.getValue()).thumbnailUri);
    }
    this.l.clear();
  }

  private void f()
  {
    d();
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < this.k.size(); i1++)
    {
      GalleryItem localGalleryItem = (GalleryItem)this.k.get(i1);
      if (!localGalleryItem.isGif())
        localArrayList.add(localGalleryItem.getItemUri());
    }
    if (localArrayList.isEmpty())
      return;
    Uri[] arrayOfUri = (Uri[])localArrayList.toArray(new Uri[localArrayList.size()]);
    this.s = ((int)(SystemClock.elapsedRealtime() / 1000L));
    this.t = new a.a()
    {
      public void a(int paramAnonymousInt1, SendMediaDataContainer paramAnonymousSendMediaDataContainer, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (f.d(f.this) != paramAnonymousInt1)
          return;
        f.e(f.this).put(paramAnonymousSendMediaDataContainer.fileUri, paramAnonymousSendMediaDataContainer);
      }

      public void a(int paramAnonymousInt, SendMediaDataContainer[] paramAnonymousArrayOfSendMediaDataContainer)
      {
        if (f.d(f.this) != paramAnonymousInt)
          return;
        com.viber.voip.messages.extras.image.a.a().b(this);
      }
    };
    com.viber.voip.messages.extras.image.a.a().a(this.t);
    com.viber.voip.messages.extras.image.a.a().a(this.s, this.e.getApplicationContext(), arrayOfUri, "image", dv.h, 256000);
  }

  private void g()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.k.iterator();
    if (localIterator.hasNext())
    {
      GalleryItem localGalleryItem = (GalleryItem)localIterator.next();
      Uri localUri1 = localGalleryItem.getItemUri();
      SendMediaDataContainer localSendMediaDataContainer;
      if (this.l.containsKey(localUri1))
      {
        localSendMediaDataContainer = (SendMediaDataContainer)this.l.remove(localUri1);
        localSendMediaDataContainer.description = localGalleryItem.getDescription();
      }
      while (true)
      {
        if (localGalleryItem.hasDoodle())
        {
          Uri localUri2 = localGalleryItem.getOriginalUri();
          Uri localUri3 = com.viber.voip.gallery.c.a.d(localUri2);
          if (localUri3 != null)
            localSendMediaDataContainer.fileUri = localUri3;
          localArrayList2.add(localUri2);
        }
        localArrayList1.add(localSendMediaDataContainer);
        break;
        localSendMediaDataContainer = new SendMediaDataContainer(this.e, localGalleryItem);
      }
    }
    av.a(av.e.g).post(new a(localArrayList2));
    e();
    Intent localIntent = com.viber.voip.messages.m.a(this.i, false);
    localIntent.addFlags(67108864);
    localIntent.putParcelableArrayListExtra("multiply_send", localArrayList1);
    localIntent.putExtra("options", this.j);
    startActivity(localIntent);
  }

  private void h()
  {
    if (this.m.a(n.m))
    {
      i();
      return;
    }
    this.m.a(this, 113, n.m);
  }

  private void i()
  {
    startActivityForResult(ViberActionRunner.x.a(getActivity(), this.k, this.i), 10);
  }

  private void j()
  {
    if (this.k != null);
    for (int i1 = this.k.size(); ; i1 = 0)
    {
      if (this.o != null)
        this.o.a(i1);
      if (this.g != null)
      {
        MenuItem localMenuItem = this.g;
        boolean bool = false;
        if (i1 > 0)
          bool = true;
        localMenuItem.setVisible(bool);
      }
      return;
    }
  }

  void a()
  {
    if (this.f != null)
      this.f.notifyDataSetChanged();
  }

  public void a(View paramView, int paramInt)
  {
    this.c = paramInt;
  }

  public void a(View paramView, Object paramObject, int paramInt)
  {
    j();
    b(paramInt);
  }

  void a(an paraman)
  {
    if ((isAdded()) && (this.p != null))
    {
      this.p.b(this.q);
      if (paraman != null)
        paraman.a(this.q);
    }
    this.p = paraman;
    if (paraman != null)
      this.p.a(this.q);
  }

  void a(ArrayList<GalleryItem> paramArrayList)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      b(paramArrayList);
      j();
      localFragmentActivity.supportInvalidateOptionsMenu();
    }
  }

  int b()
  {
    return this.b;
  }

  public void b(View paramView, Object paramObject, int paramInt)
  {
    a(paramInt);
  }

  public void c(View paramView, Object paramObject, int paramInt)
  {
    j();
    if (this.o != null)
      this.o.e();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    setHasOptionsMenu(true);
    View localView = getView();
    this.e = getActivity();
    this.m = c.a(getActivity());
    a(paramBundle);
    this.h = ((ViewPagerWithPagingEnable)localView.findViewById(R.id.gallery));
    b(this.k);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramInt1 == 10))
    {
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("extra_selected_images");
      if (this.o != null)
        this.o.a(localArrayList);
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!e.class.isInstance(paramActivity))
      throw new RuntimeException("parent activity must implement PhotoPreviewController");
    this.o = ((e)paramActivity);
    if (this.p != null)
      this.p.a(this.q);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle == null)
      throw new IllegalArgumentException("Arguments are not provided to fragment");
    this.i = ((ConversationData)localBundle.getParcelable("extra_conversation_data"));
    this.j = ((Bundle)localBundle.getParcelable("options"));
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_media_send, paramMenu);
    this.g = paramMenu.findItem(R.id.menu_send);
    MenuItem localMenuItem = this.g;
    if ((this.k != null) && (this.k.size() > 0));
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.photo_preview_fragment, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.h = null;
    this.f = null;
    super.onDestroyView();
  }

  public void onDetach()
  {
    this.o = null;
    if (this.p != null)
      this.p.b(this.q);
    super.onDetach();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_send == paramMenuItem.getItemId())
    {
      if (!this.d)
      {
        this.d = true;
        a(this.b);
        c();
      }
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.f == null)
      return;
    if (paramInt != 0)
    {
      this.f.a();
      return;
    }
    this.f.a(this.b);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    if ((this.c == -1) && (this.b != paramInt) && (this.b < this.k.size()))
      a(this.b);
    if ((this.c == -1) || (this.c > paramInt))
    {
      b(paramInt);
      this.b = paramInt;
      this.c = -1;
    }
    while (this.c >= paramInt)
      return;
    b(this.b);
    this.c = -1;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    a(this.b);
    paramBundle.putInt("current_position", this.b);
  }

  public void onStart()
  {
    super.onStart();
    this.m.a(this.n);
  }

  public void onStop()
  {
    super.onStop();
    this.m.b(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.preview.f
 * JD-Core Version:    0.6.2
 */