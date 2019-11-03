package com.example.farmer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.textfield.TextInputEditText;

public class Create_Dialog extends AppCompatDialogFragment {

    private TextInputEditText textInputEditText;
    private Button btncancel;
    private Button btncreate;

    private CreateDialogListener Listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.create_dialog, null);

        builder.setView(view)
                .setTitle("Create Survey");

        textInputEditText = view.findViewById(R.id.surveyname);
        btncancel = view.findViewById(R.id.cancelbtn);
        btncreate = view.findViewById(R.id.createbtn);

        textInputEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                final String name = textInputEditText.getText().toString();
                btncreate.setEnabled(!name.isEmpty());
                btncreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Listener.applyTexts(name);
                        getDialog().dismiss();
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) { }});

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
                Listener.closeActivity();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            Listener = (CreateDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement CreateDialogListener");
        }
    }
    public interface CreateDialogListener{
        void applyTexts(String name);
        void closeActivity();
    }
}