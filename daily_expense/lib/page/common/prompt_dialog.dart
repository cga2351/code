import 'package:flutter/material.dart';

Future<T?> showPromptDialog<T>(BuildContext _buildContext, String info) async {
  return showDialog<T>(
    context: _buildContext,
    // child: AlertDialog(
    //   title: Text("info"),
    //   content: Text(info),
    //   actions: [
    //     TextButton(
    //         child: Text("OK"),
    //         onPressed: () {
    //           print("OK pressed");
    //           Navigator.pop(_buildContext);
    //         }
    //     ),
    //   ],
    // ),
    builder: (dialogBuildContext) {
      return AlertDialog(
        title: Text("info"),
        content: Text(info),
        actions: [
          TextButton(
              child: Text("OK"),
              onPressed: () {
                print("OK pressed");
                Navigator.pop(_buildContext);
              }
          ),
        ],
      );
    }
  );
}