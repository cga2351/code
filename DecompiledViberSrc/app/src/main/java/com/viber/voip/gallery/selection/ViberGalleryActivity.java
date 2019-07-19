package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.g;
import com.viber.voip.widget.SmoothScrollingLinearLayoutManager;
import com.viber.voip.widget.ah;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public abstract class ViberGalleryActivity extends ViberFragmentActivity
  implements f, q.a, dagger.android.support.b
{

  @Inject
  dagger.android.c<Fragment> a;

  @Inject
  Handler b;

  @Inject
  g c;

  @Inject
  com.viber.common.permission.c d;
  private boolean e;
  private GalleryMediaSelector f = new GalleryMediaSelector();
  private s g;
  private RecyclerView h;
  private TabLayout i;
  private t j;
  private h k;
  private a l;
  private Animation m;
  private Animation n;
  private com.viber.common.permission.b o;

  public ViberGalleryActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(112);
    this.o = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if (ViberGalleryActivity.a(ViberGalleryActivity.this))
          ViberGalleryActivity.this.b(true);
      }
    };
  }

  private void a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if ((localBundle == null) || (!localBundle.containsKey("extra_selected_images")))
      return;
    localBundle.putParcelable("media_selector", new GalleryMediaSelector(localBundle.getParcelableArrayList("extra_selected_images")));
    a(localBundle);
  }

  private void a(GalleryItem[] paramArrayOfGalleryItem)
  {
    int i1 = paramArrayOfGalleryItem.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      GalleryItem localGalleryItem = paramArrayOfGalleryItem[i2];
      this.g.b(localGalleryItem);
    }
    if (this.h.getWidth() == 0)
    {
      this.h.scrollToPosition(-1 + this.g.getItemCount());
      return;
    }
    this.h.smoothScrollToPosition(-1 + this.g.getItemCount());
  }

  private void c(boolean paramBoolean)
  {
    this.e = true;
    this.l.a();
    this.j.a();
    this.k.b();
    this.h.setVisibility(0);
    if (paramBoolean)
      this.h.startAnimation(this.m);
  }

  private void d()
  {
    this.h = ((RecyclerView)findViewById(R.id.selected_images_container));
    this.h.setHasFixedSize(true);
    this.h.setLayoutManager(new SmoothScrollingLinearLayoutManager(this, 0, false, 200));
    new ItemTouchHelper(new a(null)).attachToRecyclerView(this.h);
    this.g = new s(this, this.c);
    this.h.setAdapter(this.g);
  }

  private void d(boolean paramBoolean)
  {
    this.e = false;
    this.l.b();
    this.j.b();
    this.k.c();
    if (paramBoolean)
    {
      this.n.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          ViberGalleryActivity.b(ViberGalleryActivity.this).setVisibility(8);
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      });
      this.h.startAnimation(this.n);
      return;
    }
    this.h.setVisibility(8);
  }

  private void e()
  {
    this.j = ((t)getSupportFragmentManager().findFragmentByTag("gallery_tag"));
    if (this.j == null)
      this.j = t.a(c());
    this.k = ((h)getSupportFragmentManager().findFragmentByTag("images_tag"));
    if (this.k == null)
      this.k = new h();
  }

  private void f()
  {
    this.l.b(this.f.selectionSize());
  }

  public ConversationData P()
  {
    return (ConversationData)getIntent().getParcelableExtra("extra_conversation_data");
  }

  void a(Bundle paramBundle)
  {
    this.e = paramBundle.getBoolean("extra_multiple_selection", false);
    this.f = ((GalleryMediaSelector)paramBundle.getParcelable("media_selector"));
    if (this.f == null)
      this.f = new GalleryMediaSelector();
    f();
    if ((this.e) && (this.d.a(n.m)))
      b(false);
    if (this.k.isAdded())
    {
      this.k.a();
      this.i.setVisibility(8);
    }
    this.j.a(GalleryFilter.VIDEO, this.f.isSelectionEmpty(), false);
  }

  public void a(GalleryItem paramGalleryItem, final o paramo)
  {
    this.f.toggleItemSelection(paramGalleryItem, this, new q(this, this)
    {
      public void a(GalleryItem paramAnonymousGalleryItem)
      {
        super.a(paramAnonymousGalleryItem);
        if (paramAnonymousGalleryItem.isVideo())
        {
          ViberGalleryActivity localViberGalleryActivity = ViberGalleryActivity.this;
          boolean bool1 = ViberGalleryActivity.c(ViberGalleryActivity.this).isSelectionEmpty();
          boolean bool2 = false;
          if (!bool1)
            bool2 = true;
          localViberGalleryActivity.a(paramAnonymousGalleryItem, bool2);
        }
        while (true)
        {
          paramo.a(true);
          return;
          ViberGalleryActivity.a(ViberGalleryActivity.this, new GalleryItem[] { paramAnonymousGalleryItem });
          ViberGalleryActivity.d(ViberGalleryActivity.this);
          if (!ViberGalleryActivity.a(ViberGalleryActivity.this))
            ViberGalleryActivity.a(ViberGalleryActivity.this, true);
          else if ((!ViberGalleryActivity.this.a()) && (ViberGalleryActivity.c(ViberGalleryActivity.this).selectionSize() == 1))
            ViberGalleryActivity.this.supportInvalidateOptionsMenu();
        }
      }

      public void a(GalleryItem paramAnonymousGalleryItem, int paramAnonymousInt)
      {
        super.a(paramAnonymousGalleryItem, paramAnonymousInt);
        paramo.a(false);
      }

      public void b(GalleryItem paramAnonymousGalleryItem)
      {
        super.b(paramAnonymousGalleryItem);
        if (!paramAnonymousGalleryItem.isVideo())
        {
          ViberGalleryActivity.e(ViberGalleryActivity.this).a(paramAnonymousGalleryItem);
          Handler localHandler = ViberGalleryActivity.this.b;
          Uri[] arrayOfUri = new Uri[1];
          arrayOfUri[0] = paramAnonymousGalleryItem.getOriginalUri();
          localHandler.post(new com.viber.voip.gallery.preview.a(arrayOfUri));
          ViberGalleryActivity.d(ViberGalleryActivity.this);
          if ((!ViberGalleryActivity.this.a()) && (ViberGalleryActivity.c(ViberGalleryActivity.this).isSelectionEmpty()))
            ViberGalleryActivity.this.supportInvalidateOptionsMenu();
        }
        paramo.a(true);
      }
    });
  }

  protected void a(GalleryItem paramGalleryItem, boolean paramBoolean)
  {
  }

  public void a(String paramString1, String paramString2)
  {
    if (getSupportFragmentManager().findFragmentByTag("images_tag") != null)
      return;
    Bundle localBundle = new Bundle();
    localBundle.putString("bucket_id", paramString1);
    localBundle.putString("bucket_name", paramString2);
    int i1 = this.i.getSelectedTabPosition();
    if (i1 != -1)
      localBundle.putParcelable("selection_filter", GalleryFilter.values()[i1]);
    this.k.setArguments(localBundle);
    if (this.e)
      this.k.b();
    this.i.setVisibility(8);
    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.gallery_fragment_fade_in, R.anim.gallery_fragment_fade_out, R.anim.gallery_fragment_fade_in, R.anim.gallery_fragment_fade_out).replace(R.id.root_container, this.k, "images_tag").addToBackStack(null).commit();
    getSupportFragmentManager().executePendingTransactions();
  }

  protected abstract void a(ArrayList<GalleryItem> paramArrayList);

  protected void a(List<GalleryItem> paramList)
  {
  }

  void a(boolean paramBoolean)
  {
    this.f.clearSelection();
    this.g.a();
    d(false);
    f();
    if ((paramBoolean) && (this.k.isAdded()))
      this.k.a();
  }

  protected boolean a()
  {
    return false;
  }

  public void b()
  {
    a locala = this.l;
    if (((!ViberApplication.isTablet(this)) && (!dj.c(this))) || (!c()));
    for (boolean bool = true; ; bool = false)
    {
      locala.a(bool);
      this.j.a(this.i);
      this.j.a(GalleryFilter.VIDEO, this.f.isSelectionAvailable(2), true);
      return;
    }
  }

  public void b(String paramString1, String paramString2)
  {
    this.l.a(paramString2);
  }

  void b(boolean paramBoolean)
  {
    c(paramBoolean);
    a((GalleryItem[])this.f.getSelection().toArray(new GalleryItem[this.f.selectionSize()]));
  }

  public boolean b(GalleryItem paramGalleryItem)
  {
    return this.f.isSelected(paramGalleryItem);
  }

  boolean c()
  {
    return false;
  }

  public void onBackPressed()
  {
    if (!getSupportFragmentManager().popBackStackImmediate())
    {
      a(this.f.getSelection());
      super.onBackPressed();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_gallery_selector);
    dj.c(this, false);
    this.m = AnimationUtils.loadAnimation(this, R.anim.menu_bottom_slide_in);
    this.n = AnimationUtils.loadAnimation(this, R.anim.menu_bottom_slide_out);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    this.i = ((TabLayout)findViewById(R.id.tab_layout));
    this.l = new a(this, new a.a()
    {
      public void a()
      {
        ViberGalleryActivity.this.supportInvalidateOptionsMenu();
      }
    });
    this.l.a(10);
    this.l.b(a());
    e();
    d();
    if (paramBundle == null)
    {
      a(getIntent());
      getSupportFragmentManager().beginTransaction().add(R.id.root_container, this.j, "gallery_tag").commit();
    }
    while (true)
    {
      if (!this.d.a(n.m))
        this.d.a(this, 112, n.m);
      android.support.v7.app.a locala = getSupportActionBar();
      locala.e(true);
      locala.a(false);
      locala.b(true);
      return;
      a(paramBundle);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return this.l.a(paramMenu);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_done)
    {
      if ((!a()) && (this.f.isSelectionEmpty()))
        Toast.makeText(getApplicationContext(), R.string.gallery_empty_selection_message, 0).show();
      while (true)
      {
        return true;
        a(new ArrayList(this.f.getSelection()));
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return this.l.b(paramMenu);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("extra_multiple_selection", this.e);
    paramBundle.putParcelable("media_selector", this.f);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    this.d.a(this.o);
  }

  protected void onStop()
  {
    super.onStop();
    this.d.b(this.o);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }

  private class a extends ah
  {
    private a()
    {
    }

    public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      GalleryItem localGalleryItem = ((s.a)paramViewHolder).a();
      ViberGalleryActivity.c(ViberGalleryActivity.this).deselect(localGalleryItem, null);
      ViberGalleryActivity.e(ViberGalleryActivity.this).a(localGalleryItem);
      ViberGalleryActivity.f(ViberGalleryActivity.this).a();
      Handler localHandler = ViberGalleryActivity.this.b;
      Uri[] arrayOfUri = new Uri[1];
      arrayOfUri[0] = localGalleryItem.getOriginalUri();
      localHandler.post(new com.viber.voip.gallery.preview.a(arrayOfUri));
      ViberGalleryActivity.d(ViberGalleryActivity.this);
      if (ViberGalleryActivity.c(ViberGalleryActivity.this).isSelectionAvailable(2))
      {
        ViberGalleryActivity.g(ViberGalleryActivity.this).a(GalleryFilter.VIDEO, true, true);
        if (!ViberGalleryActivity.this.a())
          ViberGalleryActivity.this.supportInvalidateOptionsMenu();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.ViberGalleryActivity
 * JD-Core Version:    0.6.2
 */