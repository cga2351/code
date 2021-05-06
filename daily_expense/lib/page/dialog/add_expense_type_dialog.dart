import 'dart:convert';
import 'dart:io';

import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/data_provider/cached_local_data.dart';
import 'package:dailyexpense/page/common/prompt_dialog.dart';
import 'package:dailyexpense/utils/hint_disp_utils.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AddExpenseTypeDialog {
  BuildContext? _buildContext;
  GlobalKey<FormState> _addExpenseTypeKey = GlobalKey();
  TextEditingController _expenseTypeController = TextEditingController();

  void show(BuildContext buildContext) {
    _buildContext = buildContext;
    showDialog<String> (
      context: _buildContext!,
      // child: AlertDialog(
      //   title: Text("add expense type"),
      //   content: Container(
      //       width: 1000,
      //       height: 90,
      //       child: Center(
      //         child: Scrollbar(
      //           child: SingleChildScrollView(
      //             child: Form(
      //               key: _addExpenseTypeKey,
      //               child: Column(
      //                 children: <Widget>[
      //                   // expense type
      //                   TextFormField(
      //                     controller: _expenseTypeController,
      //                     decoration: InputDecoration(
      //                       filled: true,
      //                       fillColor: Color(0x0A000000),
      //                       labelText: "expense type name",
      //                       hintText: "input a expense type name",
      //                     ),
      //                     validator: (value) {
      //                       if (value.isEmpty) {
      //                         return "expense type name is empty";
      //                       }
      //                       return null;
      //                     },
      //                   ),
      //                 ],
      //               ),
      //             ),
      //           ),
      //         ),
      //       ),
      //   ),
      //
      //   actions: <Widget>[
      //     TextButton(child: Text("cancel"), onPressed: onCancelAddExpenseType),
      //     TextButton(child: Text("add"), onPressed: onAddExpenseType)
      //   ],
      // ),

      builder: (dialogBuildContext) {
        return AlertDialog(
          title: Text("add expense type"),
          content: Container(
            width: 1000,
            height: 90,
            child: Center(
              child: Scrollbar(
                child: SingleChildScrollView(
                  child: Form(
                    key: _addExpenseTypeKey,
                    child: Column(
                      children: <Widget>[
                        // expense type
                        TextFormField(
                          controller: _expenseTypeController,
                          decoration: InputDecoration(
                            filled: true,
                            fillColor: Color(0x0A000000),
                            labelText: "expense type name",
                            hintText: "input a expense type name",
                          ),
                          validator: (value) {
                            if (null == value || value.isEmpty) {
                              return "expense type name is empty";
                            } else {
                              return null;
                            }
                          },
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            ),
          ),

          actions: <Widget>[
            TextButton(child: Text("cancel"), onPressed: onCancelAddExpenseType),
            TextButton(child: Text("add"), onPressed: onAddExpenseType)
          ],
        );
      }
    );
  }

  void onCancelAddExpenseType() {
    Navigator.pop(_buildContext!);
  }
  void onAddExpenseType() async {
    bool? validate = _addExpenseTypeKey.currentState?.validate();
    if (null != validate && validate) {
      print("write expense type");
      String result = LocalDataStorage.instance.addExpenseType(_expenseTypeController.text);
      if (result == Constants.RES_SUCCESS) {
        Navigator.pop(_buildContext!);
      }

      result = result == Constants.RES_SUCCESS ? "add type success" : result;
      showPromptDialog(_buildContext!, result);
    }
  }
}
