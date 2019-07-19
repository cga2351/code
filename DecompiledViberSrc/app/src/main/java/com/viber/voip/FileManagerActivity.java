package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.b;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.h;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.at;
import com.viber.voip.util.at.a;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileManagerActivity extends ViberFragmentActivity
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, m.c
{
  private static final String[] a = { "mp3", "midi", "wav" };
  private String b = "history_key";
  private String c = "selected_files_key";
  private String d = "is_multiple_key";
  private ArrayList<c> e = new ArrayList();
  private Set<String> f = new HashSet();
  private ArrayDeque<File> g = new ArrayDeque();
  private b h;
  private boolean i = false;
  private boolean j = false;
  private MenuItem k;
  private String l;
  private boolean m;
  private com.viber.common.permission.c n;
  private b o;

  public FileManagerActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(104);
    this.o = new f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if (DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))
          if (paramAnonymousInt2 != -1)
            FileManagerActivity.this.finish();
        while (!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString))
          return;
        if (paramAnonymousInt2 == -1)
        {
          FileManagerActivity.a(FileManagerActivity.this, true);
          return;
        }
        FileManagerActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof Bundle))
          FileManagerActivity.a(FileManagerActivity.this, (Bundle)paramAnonymousObject);
      }
    };
  }

  private void a()
  {
    this.e.clear();
    File localFile1 = Environment.getExternalStorageDirectory();
    File localFile2;
    int i2;
    label64: File localFile3;
    if (this.g.isEmpty())
      if (this.i)
      {
        this.l = getResources().getString(R.string.options_send_file);
        localFile2 = localFile1;
        a(this.l);
        File[] arrayOfFile = localFile2.listFiles();
        int i1 = arrayOfFile.length;
        i2 = 0;
        if (i2 >= i1)
          break label269;
        localFile3 = arrayOfFile[i2];
        if (!localFile3.getName().startsWith("."))
          break label137;
      }
    label137: 
    while ((!localFile3.isDirectory()) && ((!this.i) || (!at.i(localFile3))))
    {
      i2++;
      break label64;
      this.l = getResources().getString(R.string.save_to);
      localFile2 = localFile1;
      break;
      localFile2 = (File)this.g.peek();
      this.l = localFile2.getName();
      break;
    }
    c localc2 = new c(null);
    localc2.a = localFile3;
    localc2.c = localFile3.getName();
    if (localFile3.isDirectory())
      localc2.d = "<DIR>";
    while (true)
    {
      localc2.b = b(localFile3);
      this.e.add(localc2);
      break;
      localc2.d = at.a(localFile3.length());
      if (this.f.contains(localc2.a.getPath()))
        localc2.e = true;
    }
    label269: Collections.sort(this.e);
    c localc1;
    String str;
    if (!this.g.isEmpty())
    {
      localc1 = new c(null);
      localc1.a = localFile2;
      localc1.c = "..";
      localc1.b = R.drawable.ic_file_manager_directory;
      str = localFile2.getParentFile().getPath();
      if (!localFile1.getPath().equals(str))
        break label364;
    }
    label364: for (localc1.d = "/"; ; localc1.d = str.replaceFirst(localFile1.getPath(), ""))
    {
      this.e.add(0, localc1);
      this.h.notifyDataSetChanged();
      return;
    }
  }

  private void a(Bundle paramBundle)
  {
    if (this.n.a(n.m))
    {
      b(paramBundle);
      return;
    }
    this.n.a(this, 104, n.m, paramBundle);
  }

  private void a(c paramc, int paramInt)
  {
    if (this.f.contains(paramc.a.getPath()))
    {
      paramc.e = false;
      this.f.remove(paramc.a.getPath());
      if (this.f.size() == 0)
        a(false);
    }
    while (true)
    {
      a(this.l);
      this.h.notifyDataSetChanged();
      return;
      if (this.f.size() < 10)
      {
        if (b(paramc, paramInt))
        {
          this.f.add(paramc.a.getPath());
          paramc.e = true;
        }
      }
      else
        Toast.makeText(this, getResources().getString(R.string.multiple_file_limit_toast), 1).show();
    }
  }

  private void a(File paramFile)
  {
    Intent localIntent = getIntent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile.toString());
    localIntent.putStringArrayListExtra("send_file_path", localArrayList);
    setResult(-1, localIntent);
    finish();
  }

  private void a(String paramString)
  {
    if ((this.i) && (this.j) && (this.f.size() > 0))
    {
      getSupportActionBar().a(paramString + " (" + this.f.size() + ")");
      return;
    }
    getSupportActionBar().a(paramString);
  }

  private void a(Set<String> paramSet)
  {
    Intent localIntent = getIntent();
    localIntent.putStringArrayListExtra("send_file_path", new ArrayList(paramSet));
    setResult(-1, localIntent);
    finish();
  }

  private void a(boolean paramBoolean)
  {
    if (this.j == paramBoolean);
    do
    {
      return;
      this.j = paramBoolean;
    }
    while (this.k == null);
    this.k.setVisible(paramBoolean);
  }

  private int b(File paramFile)
  {
    if (paramFile.isDirectory())
      return R.drawable.ic_file_manager_directory;
    for (String str : a)
      if (paramFile.getName().toLowerCase().endsWith("." + str))
        return R.drawable.ic_file_manager_audio;
    return R.drawable.ic_file_manager_generic;
  }

  private void b(Bundle paramBundle)
  {
    if ("mounted".equals(com.viber.voip.util.upload.o.e()))
    {
      ListView localListView = (ListView)findViewById(16908298);
      localListView.setOnItemClickListener(this);
      localListView.setOnItemLongClickListener(this);
      this.h = new b(getLayoutInflater());
      localListView.setAdapter(this.h);
      a();
    }
    while (paramBundle != null)
    {
      this.f = new HashSet(Arrays.asList(paramBundle.getStringArray(this.c)));
      String[] arrayOfString = paramBundle.getStringArray(this.b);
      int i1 = arrayOfString.length;
      int i2 = 0;
      while (true)
        if (i2 < i1)
        {
          File localFile = new File(arrayOfString[i2]);
          this.g.add(localFile);
          i2++;
          continue;
          finish();
          break;
        }
      if ((this.f.size() <= 0) && (!paramBundle.getBoolean(this.d)))
        break label185;
    }
    label185: for (boolean bool = true; ; bool = false)
    {
      a(bool);
      a();
      return;
    }
  }

  private boolean b(c paramc, int paramInt)
  {
    if (paramc.a.isDirectory())
      return false;
    at.a locala = at.b(paramc.a.length());
    if (locala == at.a.c)
    {
      h.a locala4 = com.viber.voip.ui.dialogs.o.h();
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = paramc.a.getName();
      arrayOfObject3[1] = Integer.valueOf(200);
      locala4.b(-1, arrayOfObject3).a(this).a(this);
      return false;
    }
    if (locala == at.a.b)
    {
      a locala1 = new a(null);
      locala1.a = paramInt;
      locala1.b = paramc.a.getPath();
      l.a locala2 = com.viber.voip.ui.dialogs.o.g();
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramc.a.getName();
      arrayOfObject1[1] = Integer.valueOf(50);
      locala2.b(-1, arrayOfObject1).a(this).a(locala1).a(this);
      return false;
    }
    if (locala == at.a.d)
    {
      h.a locala3 = com.viber.voip.ui.dialogs.o.k();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramc.a.getName();
      locala3.b(-1, arrayOfObject2).a(this).a(this);
      return false;
    }
    return true;
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new d(new h(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onBackPressed()
  {
    if (!this.g.isEmpty())
    {
      this.g.pop();
      a();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_file_manager);
    getSupportActionBar().b(true);
    getSupportActionBar().a(false);
    String str = getIntent().getAction();
    if ("com.viber.voip.action.SEND_FILE".equals(str))
      this.i = true;
    while ("com.viber.voip.action.SAVE_FILE_TO_DIR".equals(str))
    {
      this.n = com.viber.common.permission.c.a(this);
      this.n.a(this.o);
      a(paramBundle);
      return;
    }
    finish();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_file_manger, paramMenu);
    this.k = paramMenu.findItem(R.id.menu_done);
    if ((this.i) && (!this.j))
      this.k.setVisible(false);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.n.b(this.o);
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D377b))
      if ((-1 == paramInt) && (this.j) && (this.f.size() == 0))
        a(false);
    while (!paramm.a(DialogCode.D377a))
      return;
    Object localObject1;
    label111: Object localObject2;
    if (-1 == paramInt)
    {
      a locala = (a)paramm.d();
      localObject1 = this.h.a(locala.a);
      if ((localObject1 == null) || (!((c)localObject1).a.getPath().equals(locala.b)))
      {
        localObject1 = null;
        Iterator localIterator = this.e.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (c)localIterator.next();
          if (!((c)localObject2).a.getPath().equals(locala.b))
            break label245;
        }
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break label111;
      if (localObject1 != null)
      {
        if (!this.j)
          break label233;
        this.f.add(((c)localObject1).a.getPath());
        ((c)localObject1).e = true;
        a(this.l);
        this.h.notifyDataSetChanged();
      }
      while ((-2 == paramInt) && (this.f.size() == 0))
      {
        a(false);
        return;
        label233: a(((c)localObject1).a);
      }
      break;
      label245: localObject2 = localObject1;
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c localc = (c)this.e.get(paramInt);
    File localFile = localc.a;
    if (localFile.isDirectory())
      if ((!this.g.isEmpty()) && (paramInt == 0))
        onBackPressed();
    do
    {
      return;
      this.g.push(localFile);
      a();
      return;
      if ((this.i) && (!this.j) && (b(localc, paramInt)))
      {
        a(localFile);
        return;
      }
    }
    while (!this.j);
    a(localc, paramInt);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c localc = (c)this.e.get(paramInt);
    if ((!this.j) && (!localc.a.isDirectory()))
    {
      a(true);
      onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
    {
      finish();
      return true;
    }
    File localFile;
    if (i1 == R.id.menu_done)
    {
      if (this.i)
        break label98;
      Intent localIntent = getIntent();
      localFile = Environment.getExternalStorageDirectory();
      if (!this.g.isEmpty())
        break label83;
      localIntent.putExtra("save_file_to_dir_path", localFile.getPath());
      setResult(-1, localIntent);
      finish();
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      label83: localFile = (File)this.g.peek();
      break;
      label98: a(this.f);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    String[] arrayOfString1 = new String[this.f.size()];
    this.f.toArray(arrayOfString1);
    paramBundle.putStringArray(this.c, arrayOfString1);
    String[] arrayOfString2 = new String[this.g.size()];
    Iterator localIterator = this.g.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1++)
      arrayOfString2[i1] = ((File)localIterator.next()).getPath();
    paramBundle.putStringArray(this.b, arrayOfString2);
    paramBundle.putBoolean(this.d, this.j);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    if (this.m)
    {
      this.m = false;
      a(null);
    }
  }

  private static class a
    implements Serializable
  {
    public int a;
    public String b;
  }

  private class b extends BaseAdapter
  {
    private LayoutInflater b;

    public b(LayoutInflater arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public FileManagerActivity.c a(int paramInt)
    {
      return (FileManagerActivity.c)FileManagerActivity.a(FileManagerActivity.this).get(paramInt);
    }

    public int getCount()
    {
      return FileManagerActivity.a(FileManagerActivity.this).size();
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      FileManagerActivity.d locald;
      if (paramView == null)
      {
        paramView = this.b.inflate(R.layout.activity_file_manager_item, null, false);
        locald = new FileManagerActivity.d(FileManagerActivity.this, paramView);
        paramView.setTag(locald);
      }
      while (true)
      {
        locald.a(a(paramInt));
        return paramView;
        locald = (FileManagerActivity.d)paramView.getTag();
      }
    }
  }

  private class c
    implements Serializable, Comparable<c>
  {
    public File a;
    public int b;
    public String c;
    public String d;
    public boolean e;

    private c()
    {
    }

    public int a(c paramc)
    {
      if ((this.a.isDirectory()) && (!paramc.a.isDirectory()))
        return -1;
      if ((!this.a.isDirectory()) && (paramc.a.isDirectory()))
        return 1;
      return this.a.getName().toLowerCase().compareTo(paramc.a.getName().toLowerCase());
    }
  }

  private class d
  {
    private ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;

    public d(View arg2)
    {
      Object localObject;
      this.c = ((ImageView)localObject.findViewById(R.id.icon));
      this.d = ((TextView)localObject.findViewById(R.id.title));
      this.e = ((TextView)localObject.findViewById(R.id.subtitle));
      this.b = ((ImageView)localObject.findViewById(R.id.selection_indicator));
    }

    public void a(FileManagerActivity.c paramc)
    {
      this.c.setImageResource(paramc.b);
      this.d.setText(paramc.c);
      this.e.setText(paramc.d);
      ImageView localImageView = this.b;
      if (paramc.e);
      for (int i = 0; ; i = 8)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.FileManagerActivity
 * JD-Core Version:    0.6.2
 */