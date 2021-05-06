import 'package:dailyexpense/bloc/expense_list_bloc.dart';
import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/model/expense_item.dart';
import 'package:dailyexpense/page/common/prompt_dialog.dart';
import 'package:dailyexpense/page/sheet/select_expense_type_sheet.dart';
import 'package:dailyexpense/utils/id_utils.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intl/intl.dart';

class EditExpenseItemDialog {
  BuildContext? _buildContext;
  bool _autoValidate = false;
  GlobalKey<FormState> _addExpenseItemKey = GlobalKey();

  // has an existing item, it means edit an existing item, or create an new item.
  ExpenseItem? _editItem;

  TextEditingController _expenseDateController = TextEditingController();
  TextEditingController _expenseTypeController = TextEditingController();
  TextEditingController _expenseAmountController = TextEditingController();
  TextEditingController _expenseCommentController = TextEditingController();
  int _expenseDateTimestamp = 0;

  void show(BuildContext buildContext, {ExpenseItem? editItem}) {
    _buildContext = buildContext;
    _autoValidate = false;

    // pass an item, it means edit an existing item, or create an new item.
    if (null != editItem) {
      _editItem = editItem;
    }

    showDialog(
      // builder: (buildContext) {
      //   return StatefulBuilder(
      //     builder: (buildContext, stateSetter) {
      //       stateSetter(() {
      //
      //       });
      //       return Text("aa");
      //     },
      //   );
      // },
      barrierDismissible: false,
      context: _buildContext!,
      // child: _buildDialog(),
      builder: (dialogBuildContext) {
        return _buildDialog();
      }
    );
  }

  Widget _buildDialog() {
    final double inputEditHeight = 55;
    String title;

    if (null == _editItem) {
      // add an new expense item, default date is current date and
      _expenseDateTimestamp = DateTime(
          DateTime.now().year,
          DateTime.now().month,
          DateTime.now().day).millisecondsSinceEpoch;
      _expenseDateController.text = DateFormat("yyyy.MM.dd")
          .format(DateTime.now());

      // default set no expense
      _expenseTypeController.text = Constants.SpecialExpenseType_NoExpense;
      _expenseAmountController.text = "0";

      // title add
      title = "add expense item";
    } else {
      // edit an existing item, set the existing item value
      _expenseDateTimestamp = _editItem!.dateTimestamp;
      _expenseDateController.text = _editItem!.date;
      _expenseTypeController.text = _editItem!.type;
      _expenseAmountController.text = _editItem!.amount.toString();
      _expenseCommentController.text = _editItem!.comment;

      // title edit
      title = "edit expense item";
    }

    return AlertDialog(
      title: Text(title),
      content: Container(
        width: 1000,
        // height: 500,
        height: 250,
        child: Form(
          key: _addExpenseItemKey,
          child: Column(
            children: <Widget>[
              // SizedBox(height: 30,),

              // select expense date
              SizedBox(
                height: inputEditHeight,
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Expanded(
                      child: TextFormField(
                        readOnly: true,
                        onTap: onSelectExpenseDate,
                        autovalidate: _autoValidate,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.white,
                          // labelText: "expense type",
                          hintText: "select expense date",
                        ),
                        controller: _expenseDateController,
                      ),
                    ),
                  ],
                ),
              ),

              // select expense type
              SizedBox(
                height: inputEditHeight,
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Expanded(
                      child: TextFormField(
                        readOnly: true,
                        onTap: onSelectExpenseType,
                        autovalidate: _autoValidate,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.white,
                          // labelText: "expense type",
                          hintText: "select expense type",
                        ),
                        validator: (value) {
                          if (null == value || value.isEmpty) {
                            return "expense type is empty";
                          } else {
                            return null;
                          }
                        },
                        controller: _expenseTypeController,
                      ),
                    ),
                  ],
                ),
              ),

              // input expense amount
              SizedBox(
                height: inputEditHeight,
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Expanded(
                      child: TextFormField(
                        keyboardType: TextInputType.number,
                        textAlignVertical: TextAlignVertical.top,
                        autovalidate: _autoValidate,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.white,
                          // labelText: "expense amount",
                          hintText: "input expense amount",
                        ),
                        validator: (value) {
                          if (_expenseTypeController.text == Constants.SpecialExpenseType_NoExpense ||
                              (null != value && value.isNotEmpty)) {
                            return null;
                          } else {
                            return "expense amount is empty";
                          }

                        },
                        controller: _expenseAmountController,
                      ),
                    ),
                  ],
                ),
              ),

              // input expense comment
              SizedBox(
                height: inputEditHeight,
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Expanded(
                      child: TextFormField(
                        keyboardType: TextInputType.text,
                        autovalidate: _autoValidate,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.white,
                          // labelText: "expense amount",
                          hintText: "input expense comment",
                        ),
                        controller: _expenseCommentController,
                      ),
                    ),
                  ],
                ),
              ),

            ],
          ),
        ),
      ),

      actions: <Widget>[
        TextButton(child: Text("cancel"), onPressed: onCancelAddExpenseItem),
        TextButton(child: Text("save"), onPressed: onSaveExpenseItem)
      ],
    );
  }

  void onSelectExpenseDate() {
    DateTime dateTimeNow;
    print("_expenseDateTimestamp=$_expenseDateTimestamp");
    if (_expenseDateTimestamp == 0) {
      dateTimeNow = DateTime.now();
    } else {
      dateTimeNow = DateTime.fromMillisecondsSinceEpoch(_expenseDateTimestamp);
    }

    showDatePicker(context: _buildContext!,
        initialDate: dateTimeNow,
        firstDate: DateTime(dateTimeNow.year - 1),
        lastDate: DateTime.now())
        .then((date) {
          if (null != date) {
            print("selected data:${DateFormat("y.M.d").format(date)}");
            _expenseDateTimestamp = date.millisecondsSinceEpoch;
            _expenseDateController.text = DateFormat("yyyy.MM.dd").format(date);
          } else {
            print("selected data: error, datePicker return null");
          }

        });
  }

  void onSelectExpenseType() {
    SelectExpenseTypeSheet()
        .show(_buildContext!, _expenseTypeController.text)
        .then((value) {
          print("onSelectExpenseType(), selected expense type=$value");
          if (null == value) {
            _expenseTypeController.text = Constants.SpecialExpenseType_NoExpense;
          } else {
            _expenseTypeController.text = value;
          }

          // if select no expense type, it means no expense this day, set the amount to 0
          if (_expenseTypeController.text == Constants.SpecialExpenseType_NoExpense) {
            _expenseAmountController.text = "0";
          }
    });
  }

  void onCancelAddExpenseItem() {
    Navigator.pop(_buildContext!);
  }

  void onSaveExpenseItem() {
    bool? validate = _addExpenseItemKey.currentState?.validate();

    if (null != validate && validate) {
      if (null == _editItem) {
        // no existing item, it means add an new item
        ExpenseItem expenseItem = ExpenseItem(
            IDUtils.genLocalIntID(),
            _expenseDateTimestamp,
            _expenseDateController.text,
            _expenseTypeController.text,
            _expenseAmountController.text.isNotEmpty
                ? int.parse(_expenseAmountController.text)
                : 0,
            _expenseCommentController.text.isNotEmpty
                ? _expenseCommentController.text
                : ""
        );
        LocalDataStorage.instance.addExpenseItem(expenseItem);
        print("onSaveExpenseItem(), add an new expenseItem=$expenseItem");
      } else {
        // has an existing item, it means edit an existing item
        _editItem!.dateTimestamp = _expenseDateTimestamp;
        _editItem!.date = _expenseDateController.text;
        _editItem!.type = _expenseTypeController.text;
        _editItem!.amount = int.parse(_expenseAmountController.text);
        _editItem!.comment = _expenseCommentController.text.isNotEmpty
            ? _expenseCommentController.text
            : "";

        LocalDataStorage.instance.updateExpenseItem(_editItem!);
        print("onSaveExpenseItem(), edit an existing expenseItem=$_editItem");
      }

      // send update list event
      List<ExpenseItem> allExpenseItem = LocalDataStorage.instance
          .getAllExpenseRecord();
      BlocProvider.of<ExpenseListBloc>(_buildContext!)
          .add(ExpenseListEventUpdateList(allExpenseItem));

      Navigator.pop(_buildContext!);
      showPromptDialog(_buildContext!, "save expense item success");
    } else {
      showPromptDialog(_buildContext!, "expense info invalid");
    }
  }

}
