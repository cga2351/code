import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/page/common/prompt_dialog.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:flutter/material.dart';

class EditExpenseTypePage extends StatefulWidget {
  @override
  State createState() {
    return EditExpenseTypePageState();
  }
}

class EditExpenseTypePageState extends State<EditExpenseTypePage> {

  BuildContext? _buildContext;
  GlobalKey<FormState> _addExpenseTypeKey = GlobalKey();
  TextEditingController _expenseTypeController = TextEditingController();


  @override
  Widget build(BuildContext context) {
    _buildContext = context;
    return Scaffold(
      appBar: AppBar(
        title: Text("Edit Expense Types"),
      ),
      body: Center(
        child : Text("Edit Expense Types Page")
      ),
    );

    // return Center(
    //   child: Text("abc"),
    // );
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