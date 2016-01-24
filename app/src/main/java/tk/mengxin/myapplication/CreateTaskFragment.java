package tk.mengxin.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Android Studio.
 * User: Xin Meng
 * Date: 24/01/2016
 * Time: 09:27
 * Version: V 1.0
 */

public class CreateTaskFragment  extends Fragment{
    private Button saveBtn;
    private EditText tfDescription,tfDate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_task,container,false);

        tfDescription = (EditText)view.findViewById(R.id.tf_task_description);
        tfDate = (EditText)view.findViewById(R.id.tf_task_date);
        tfDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment pickerFragment = new SelectDateFragment();
                pickerFragment.show(getFragmentManager(),"DatePicker");
            }
        });

        Button pickDateBtn = (Button)view.findViewById(R.id.btn_pick_date);
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = "Date"+String.valueOf(year) +"-"+String.valueOf(monthOfYear)
                                +"-"+String.valueOf(dayOfMonth);
                        tfDescription.setText(date);
                        tfDate.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
//                DialogFragment pickerFragment = new DialogFragment();
//
//                pickerFragment.show(getFragmentManager(),"DatePicker");
            }
        });
        saveBtn = (Button)view.findViewById(R.id.btn_save_task);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask();
            }
        });

        return view;
    }

    public void saveTask()
    {
        String description = tfDescription.getText().toString();
        String date = tfDate.getText().toString();
    }

//    @Override
//    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//        String date = "Date"+String.valueOf(year) +"-"+String.valueOf(monthOfYear)
//                +"-"+String.valueOf(dayOfMonth);
//        tfDescription.setText(date);
//        tfDate.setText(date);
//    }
}