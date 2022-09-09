package com.usu.customviews

import android.content.Context
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

/*
class LabelledInput extends View {
    public LabelledInput(Context context) {
        super(context);
    }
}

 */

class LabelledInput(context: Context, labelText: String): LinearLayout(context) {
    private val editText = EditText(context)
    init {
        orientation = VERTICAL
        val label = TextView(context)
        label.text = labelText
        addView(label)
        addView(editText)
    }

    val text: Editable = editText.text
//    fun getText(): Editable {
//        return editText.text
//    }
//    ====
//    fun getText() = editText.text

}