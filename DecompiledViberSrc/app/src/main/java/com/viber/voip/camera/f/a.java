package com.viber.voip.camera.f;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.viber.voip.camera.R.string;
import com.viber.voip.camera.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a extends DialogFragment
{
  private static final String a = com.viber.voip.camera.e.a.a(a.class);
  private File b = null;
  private AlertDialog c = null;
  private ListView d = null;

  private void a(File paramFile)
  {
    if (paramFile == null)
      return;
    try
    {
      File[] arrayOfFile2 = paramFile.listFiles();
      arrayOfFile1 = arrayOfFile2;
      if (arrayOfFile1 == null)
      {
        String str = getResources().getString(R.string.cant_access_folder) + ":\n" + paramFile.getAbsolutePath();
        Toast.makeText(getActivity(), str, 0).show();
        return;
      }
    }
    catch (Exception localException)
    {
      File[] arrayOfFile1;
      while (true)
        arrayOfFile1 = null;
      ArrayList localArrayList = new ArrayList();
      if (paramFile.getParentFile() != null)
        localArrayList.add(new a(paramFile.getParentFile(), true));
      for (int i = 0; i < arrayOfFile1.length; i++)
      {
        File localFile = arrayOfFile1[i];
        if (localFile.isDirectory())
          localArrayList.add(new a(localFile, false));
      }
      Collections.sort(localArrayList);
      ArrayAdapter localArrayAdapter = new ArrayAdapter(getActivity(), 17367043, localArrayList);
      this.d.setAdapter(localArrayAdapter);
      this.b = paramFile;
      this.c.setTitle(this.b.getAbsolutePath());
    }
  }

  private boolean a()
  {
    try
    {
      if (this.b != null)
      {
        boolean bool = this.b.canWrite();
        if (bool)
          return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private boolean b()
  {
    if (this.b == null)
      return false;
    if (a())
    {
      File localFile = b.d();
      String str = this.b.getAbsolutePath();
      if ((this.b.getParentFile() != null) && (this.b.getParentFile().equals(localFile)))
        str = this.b.getName();
      SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(getActivity()).edit();
      localEditor.putString(com.viber.voip.camera.d.a.u(), str);
      localEditor.apply();
      return true;
    }
    Toast.makeText(getActivity(), R.string.cant_write_folder, 0).show();
    return false;
  }

  private void c()
  {
    if (this.b == null)
      return;
    if (a())
    {
      final EditText localEditText = new EditText(getActivity());
      localEditText.setSingleLine();
      localEditText.setFilters(new InputFilter[] { new InputFilter()
      {
        String a = "|\\?*<\":>";

        public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          while (paramAnonymousInt1 < paramAnonymousInt2)
          {
            if (this.a.indexOf(paramAnonymousCharSequence.charAt(paramAnonymousInt1)) != -1)
              return "";
            paramAnonymousInt1++;
          }
          return null;
        }
      }
       });
      new AlertDialog.Builder(getActivity()).setTitle(R.string.enter_new_folder).setView(localEditText).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (localEditText.getText().length() == 0)
            return;
          File localFile;
          try
          {
            localFile = new File(a.d(a.this).getAbsolutePath() + File.separator + localEditText.getText().toString());
            if (localFile.exists())
            {
              Toast.makeText(a.this.getActivity(), R.string.folder_exists, 0).show();
              return;
            }
          }
          catch (Exception localException)
          {
            Toast.makeText(a.this.getActivity(), R.string.failed_create_folder, 0).show();
            return;
          }
          if (localFile.mkdirs())
          {
            a.a(a.this, a.d(a.this));
            return;
          }
          Toast.makeText(a.this.getActivity(), R.string.failed_create_folder, 0).show();
        }
      }).setNegativeButton(17039360, null).create().show();
      return;
    }
    Toast.makeText(getActivity(), R.string.cant_write_folder, 0).show();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    File localFile = b.a(com.viber.voip.camera.d.a.a(getActivity()).getString(com.viber.voip.camera.d.a.u(), "ViberCamera"));
    this.d = new ListView(getActivity());
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        File localFile = ((a.a)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt)).a();
        a.a(a.this, localFile);
      }
    });
    this.c = new AlertDialog.Builder(getActivity()).setView(this.d).setPositiveButton(R.string.use_folder, null).setNeutralButton(R.string.new_folder, null).setNegativeButton(17039360, null).create();
    this.c.setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        a.a(a.this).getButton(-1).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            if (a.b(a.this))
              a.a(a.this).dismiss();
          }
        });
        a.a(a.this).getButton(-3).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            a.c(a.this);
          }
        });
      }
    });
    if ((!localFile.exists()) && (!localFile.mkdirs()));
    a(localFile);
    if (this.b == null)
    {
      a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
      if (this.b == null)
        a(new File("/"));
    }
    return this.c;
  }

  public void onResume()
  {
    super.onResume();
    a(this.b);
  }

  private class a
    implements Comparable<a>
  {
    private File b = null;
    private boolean c = false;

    a(File paramBoolean, boolean arg3)
    {
      this.b = paramBoolean;
      boolean bool;
      this.c = bool;
    }

    private boolean b()
    {
      return this.c;
    }

    @SuppressLint({"DefaultLocale"})
    public int a(a parama)
    {
      if (this.c)
        return -1;
      if (parama.b())
        return 1;
      return this.b.getName().toLowerCase().compareTo(parama.a().getName().toLowerCase());
    }

    File a()
    {
      return this.b;
    }

    public String toString()
    {
      if (this.c)
        return a.this.getResources().getString(R.string.parent_folder);
      return this.b.getName();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.f.a
 * JD-Core Version:    0.6.2
 */