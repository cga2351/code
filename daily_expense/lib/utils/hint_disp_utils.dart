
import 'package:flutter/material.dart';

class HintDispUtils {
  static void showHintSnackBar(BuildContext context, String info) {
    Scaffold.of(context).showSnackBar(SnackBar(
      content: Text(info),
      backgroundColor: Colors.black87,
      action: SnackBarAction(
        label: "OK",
        onPressed: () {} ,
      ),
    ));
  }

  static void showHintDialog(BuildContext buildContext, String info) {
    showDialog(
      context: buildContext,
      builder: (dialogBuildContext) {
        return AlertDialog(
          title: Text(info),
          actions: [
            TextButton(child: Text("OK"), onPressed: () {}),],
        );
      }
      // child: AlertDialog(
      //   title: Text(info),
      //   actions: [
      //     TextButton(child: Text("OK"), onPressed: () {}),],
      // ),
    );
  }
}