
import 'package:flutter/material.dart';

BuildContext _buildContext;
bool _autoValidate = false;
GlobalKey<FormState> _addExpenseItemKey = GlobalKey();

void addExpenseItem(BuildContext buildContext) {
  _buildContext = buildContext;
  _autoValidate = false;
  showDialog(
    context: _buildContext,
    child: AlertDialog(
      title: Text("add expense item"),
      content: Container(
          width: 1000,
          height: 300,
            child: Scrollbar(
              child: SingleChildScrollView(
                child: Form(
                  key: _addExpenseItemKey,
                  child: Column(
                    children: <Widget>[
                      // expense type
                      TextFormField(
                        autovalidate: _autoValidate,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Color(0x0A000000),
                          labelText: "expense type",
                          hintText: "select a expense type",
                        ),
                        validator: (value) {
                          if (value.isEmpty) {
                            return "expense type is empty";
                          }
                          return null;
                        },
                      ),
                    ],
                  ),
                ),
              ),
            )
      ),

      actions: <Widget>[
        FlatButton(child: Text("cancel"), onPressed: onCancelAddExpenseItem),
        FlatButton(child: Text("add"), onPressed: onAddExpenseItem)
      ],
    ),
  );
}

void onCancelAddExpenseItem() {
  Navigator.pop(_buildContext);
}
void onAddExpenseItem() {
  _addExpenseItemKey.currentState.validate();
}