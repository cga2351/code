import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BottomSheetListItem extends StatelessWidget{

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Text("leading"),
      title: Text("title"),
      subtitle: Text("subtitle"),
      trailing: Text("trailing"),
    );
  }
}