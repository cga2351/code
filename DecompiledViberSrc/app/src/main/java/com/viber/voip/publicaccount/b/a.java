package com.viber.voip.publicaccount.b;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.publicaccount.entity.CrmItem;
import java.util.List;

public class a
{
  public static BottomSheetDialog a(Context paramContext, List<CrmItem> paramList, b paramb, LayoutInflater paramLayoutInflater)
  {
    View localView = paramLayoutInflater.inflate(R.layout.layout_crm_dialog, null);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(R.id.recycler_view);
    localRecyclerView.setHasFixedSize(true);
    localRecyclerView.setLayoutManager(new GridLayoutManager(paramContext, 3));
    localRecyclerView.setAdapter(new d(paramContext, paramList, paramb, paramLayoutInflater));
    BottomSheetDialog localBottomSheetDialog = new BottomSheetDialog(paramContext);
    localBottomSheetDialog.setContentView(localView);
    localBottomSheetDialog.setCancelable(true);
    localBottomSheetDialog.setCanceledOnTouchOutside(false);
    return localBottomSheetDialog;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.b.a
 * JD-Core Version:    0.6.2
 */